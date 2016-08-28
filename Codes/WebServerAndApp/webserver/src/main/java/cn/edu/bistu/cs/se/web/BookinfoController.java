package cn.edu.bistu.cs.se.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bistu.cs.se.model.bookinfo;
import cn.edu.bistu.cs.se.model.bookinfolist;
import cn.edu.bistu.cs.se.service.bookinfoService;

@Controller
@RequestMapping("/")
public class BookinfoController extends BaseController {
	org.slf4j.Logger logger = LoggerFactory.getLogger(BookinfoController.class);
	@Autowired
	bookinfoService bookService;

	@RequestMapping(value = "/list")
	public ModelAndView listbook(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		List<bookinfo> list = bookService.selectall();
		mav.addObject("booklist", list);
		mav.setViewName("/list");
		logger.info("list");
		return mav;
	}

	/**
	 * 通过json获得所有图书列表
	 */
	@RequestMapping(value = "androidlist", method = RequestMethod.POST)
	@ResponseBody
	public bookinfolist androidlist(HttpServletRequest request) {
		bookinfolist list = new bookinfolist();
		list.setList(bookService.selectall());
		return list;
	}

	@RequestMapping(value = "/addbook")
	public ModelAndView addbook(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/addbook");
		return mav;
	}

	@RequestMapping(value = "/add")
	public ModelAndView add(HttpServletRequest request, bookinfo bif) {

		// System.out.println(bif.getAuthor());

		ModelAndView mav = new ModelAndView();
		bookService.addbook(bif);
		mav.setViewName("redirect:/list.html");
		logger.info("记录" + bif.toString() + "添加成功");
		return mav;
	}

	/**
	 * 通过json增加书籍
	 */
	@RequestMapping(value = "androidaddbook", method = RequestMethod.POST)
	@ResponseBody
	public Integer androidaddbook(HttpServletRequest request, @RequestBody bookinfo bif) {
		if (bookService.addbook(bif) > 0) {
			logger.info("记录" + bif.toString() + "添加成功");
			return 1;
		}
		return 0;
	}

	@RequestMapping(value = "/delete/{bookid}")
	public ModelAndView delete(HttpServletRequest request, @PathVariable int bookid) {

		// System.out.println(bif.getAuthor());

		ModelAndView mav = new ModelAndView();
		bookService.deleteByPrimaryKey(bookid);
		mav.setViewName("redirect:/list.html");
		logger.info("记录" + bookid + "删除成功");
		return mav;
	}

	/**
	 * 通过Json删除书籍
	 */
	@RequestMapping(value = "androiddeletebook", method = RequestMethod.POST)
	@ResponseBody
	public Integer androidaddbook(HttpServletRequest request, @RequestBody int bookid) {
		if (bookService.deleteByPrimaryKey(bookid) > 0) {
			logger.info("记录" + bookid + "删除成功");
			return 1;
		}
		return 0;
	}

	@RequestMapping(value = "/updatebookinfo/{bookid}")
	public ModelAndView update(HttpServletRequest request, @PathVariable int bookid) {

		// System.out.println(bif.getAuthor());

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/update");
		bookinfo oldbook = bookService.selectbookbyid(bookid);
		mav.addObject("oldbook", oldbook);

		return mav;
	}

	@RequestMapping(value = "/update")
	public ModelAndView responseupdate(HttpServletRequest request, bookinfo bif) {

		// System.out.println(bif.getAuthor());

		ModelAndView mav = new ModelAndView();
		bookService.updateByPrimaryKey(bif);
		mav.setViewName("redirect:/list.html");
		logger.info("更新结果为：" + bif.toString());
		return mav;
	}

	@RequestMapping(value = "/selectbook")
	public ModelAndView selectbook(HttpServletRequest request) {

		// System.out.println(bif.getAuthor());

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/selectbook");

		return mav;
	}

	@RequestMapping(value = "/select")
	public ModelAndView responselect(HttpServletRequest request) {
		String s = request.getParameter("keys");

		// System.out.println(s);

		ModelAndView mav = new ModelAndView();
		List<bookinfo> selbooks = bookService.selectbook(s);
		mav.addObject("booklist", selbooks);
		mav.setViewName("/list");
		logger.info("查询书籍" + s + "结果为：" + selbooks.toString());
		return mav;
	}
}
