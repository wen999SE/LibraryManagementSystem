package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import com.example.demo.pojo.Book_Borrow;
import com.example.demo.pojo.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.BorrowDao;
import com.example.demo.pojo.Book;

@Controller
public class BorrowController {

	@Autowired
    private BookDao bookDao;
	
	@Autowired
    private BorrowDao borrowDao;
	
	@RequestMapping("/BorrowList")
    public String BorrowIndex(Model model) {
        List<Book> BookList = bookDao.selectAllBook();
        BookList = BookList.subList(0,10);
        model.addAttribute("BookList",BookList);
        return "/borrow/list";//返回到list页面
    }
	
	 @RequestMapping("/BorrowList/{ID}")
	    public String BookListFenye(@PathVariable("ID") int ID, Model model) {
	        int last;
	        last = ID+10;
	        List<Book> BookList = bookDao.selectAllBook();
	        if(ID > BookList.size())
	            return "/borrow/list";
	        if(last > BookList.size()) {
	            last = BookList.size();
	            BookList = BookList.subList(ID,last);
	        }
	        else
	            BookList = BookList.subList(ID,last);
	        model.addAttribute("BookList",BookList);
	        return "/borrow/list";//返回到list页面
	    }
	 
	 @RequestMapping("/BorrowAddIndex")
	    public String BorrowAddIndex(Model model) {
		 	return "/borrow/add";
	    }
	 
	 @PostMapping("/BorrowAdd")
	 public String BorrowAdd(
			 @RequestParam(value = "book_borrow_name",required = false) String book_borrow_name,
			 @RequestParam(value = "borrow_user_name",required = false) String borrow_user_name,
			 @RequestParam(value = "borrow_time",required = false) String borrow_time,
             Model model) {
		 
		 System.out.println(borrow_time);
		 borrowDao.addBorrowInfo("x",book_borrow_name,borrow_user_name,borrow_time,"x");
		 borrowDao.addBorrowBook(book_borrow_name,borrow_user_name,borrow_time);
		 borrowDao.updateBook(book_borrow_name, "0");
		 return "redirect:/BorrowList";//返回到list页面
	 }

	@RequestMapping("/BorrowInfo/{name}")
	public String History(@PathVariable("name") String name, Model model) {

		System.out.println(name);
		List<Book_Borrow> BorrowsList = borrowDao.selectAllBorrowBookByBookName(name);
		Borrow BorrowsNowList = borrowDao.selectAllNowBorrowBookByBookName(name);
		if(BorrowsNowList == null) {
			model.addAttribute("BorrowsList",BorrowsList);
			return "/borrow/historyNull";
		}
		model.addAttribute("BorrowsList",BorrowsList);
		model.addAttribute("BorrowsNowList",BorrowsNowList);
		return "/borrow/history";//返回到list页面
	}

	@RequestMapping("/ReturnBook/{name}")
	public String ReturnBook(@PathVariable("name") String name, Model model) {

		System.out.println(name);
		Date date = new Date();
		Borrow Book = borrowDao.selectAllNowBorrowBookByBookName(name);
		System.out.println(date);
		System.out.println(Book);
		//borrowDao.addReturn(Book.getBook_borrow_name(),Book.getBorrow_user_name(),date.toString());
		borrowDao.deleteBorrowBook(name);
		borrowDao.updateBook(name,"1");
		return "redirect:/BorrowList";
	}

	@PostMapping("/BorrowFind")
	public String BookFind(@RequestParam(value = "name",required = false) String name,
						   Model model) {
		System.out.println(name);
		List<Book> bookList = bookDao.selectBookLike(name);
		model.addAttribute("BookList",bookList);
		return "/borrow/find";//返回到list页面
	}
}
