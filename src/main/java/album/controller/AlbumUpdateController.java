package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {
	final String command = "update.ab";
	final String getPage = "AlbumUpdateForm"; 
	final String gotoPage = "redirect:/list.ab"; 
	
	
	@Autowired
	private AlbumDao albumDao;
	
	// AlbumList.jsp에서 수정 클릭
	@RequestMapping(value = command, method=RequestMethod.GET)
	public String doAction(@RequestParam("num") int num,
						   @RequestParam("pageNumber") int pageNumber,
						   @RequestParam("pageSize") int  pageSize,
							Model model) {
		
		AlbumBean album = albumDao.getOneAlbum(num);
		model.addAttribute("album", album);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize", pageSize);
		return getPage; 
	}
	
	// AlbumForm.jsp에서 submit 클릭
	@RequestMapping(value = command, method=RequestMethod.POST)
	public ModelAndView doAction(
							@RequestParam("pageNumber") int pageNumber,
							@RequestParam("pageSize") int  pageSize,
							@ModelAttribute("album") @Valid AlbumBean album,
							BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println(result.hasErrors());
		if(result.hasErrors()) {
			mav.addObject("pageNumber", pageNumber);
			mav.addObject("pageSize", pageSize);
			mav.setViewName(getPage); //updateForm갈때
			return mav;
		}
		
		int cnt = albumDao.updateAlbum(album);
		if(cnt>0) {
			mav.setViewName(gotoPage+"?pageNumber="+pageNumber+"&pageSize="+pageSize);
			//redirect:/list.ab?pageNumber=pageNumber&pageSize=pageSize 이런식으로 넘겨야한다
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}
}
