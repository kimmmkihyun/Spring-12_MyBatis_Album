package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {
	
	final String command = "insert.ab";
	final String getPage = "AlbumInsertForm";
	final String gotoPage = "redirect:/list.ab";
	
	// /WEB-INF/album/AlbumInsertForm.jsp
	
	@Autowired
	//@Qualifier("myAlbumDao")
	private AlbumDao albumDao;
	
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doAction() {
		return getPage; // form
	}
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction( @Valid AlbumBean album, BindingResult result  ) {
		// command 객체 
		
		ModelAndView mav = new ModelAndView();
		 
		if(result.hasErrors()) {
			System.out.println("유효성 검사 오류 발생");
			//return getPage;
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = albumDao.insertAlbum(album);
		System.out.println("AIC cnt : " + cnt);
		
		mav.setViewName(gotoPage);// "redirect:/list.ab"
		return mav;		
		//return gotoPage; 
	}
}





