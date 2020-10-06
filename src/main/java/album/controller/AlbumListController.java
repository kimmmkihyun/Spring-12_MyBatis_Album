package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	
	private final String command = "list.ab";
	private final String getPage = "AlbumList";
	
	@Autowired
	private AlbumDao albumDao;
	  
	@RequestMapping(command)
	public ModelAndView doAction(
					@RequestParam(value="whatColumn", required = false) String whatColumn,
					@RequestParam(value="keyword", required = false) String keyword,
					@RequestParam(value="pageNumber", required = false) String pageNumber,
					@RequestParam(value="pageSize", required = false) String pageSize,
					HttpServletRequest request	) { 
		
		System.out.println("whatColumn:" +whatColumn); // null, title,singer
		System.out.println("keyword:" +keyword); // null,³¯,¾Æ
		System.out.println("pageNumber:" +pageNumber); // null
		System.out.println("pageSize:" +pageSize);// null
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("whatColumn",whatColumn); //whatColumn=title
		map.put("keyword", "%"+keyword+"%"); //keyword=%³¯%
		
		int totalCount = albumDao.getTotalCount(map);
		System.out.println("totalCount : " + totalCount); 
		
		String url = request.getContextPath() +"/" +command ;
		System.out.println("url : " + url);// /ex/list.ab
		  
		Paging pageInfo = new Paging(pageNumber,pageSize,totalCount,url,whatColumn,keyword);
		
		System.out.println("offset : " + pageInfo.getOffset()); // 0
		System.out.println("limit : " + pageInfo.getLimit()); // 2
		
		List<AlbumBean> lists = albumDao.getAlbumList(pageInfo,map); 
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("totalCount", totalCount);
		mav.setViewName(getPage);
		return mav;
		
	}
	
}





