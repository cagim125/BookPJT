package com.office.library.book.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.library.book.admin.util.UploadFileServive;

@Controller
@RequestMapping("/book/admin")
public class BookController {
	
		@Autowired
		BookService bookService;
		
		@Autowired
		UploadFileServive uploadFileServive;
	
		// 도서 Form
		@GetMapping("/registerBookForm")
		public String registerBookForm() {
			System.out.println("[BookController] registerBookFrom()");
			
			String nextPage = "admin/book/register_book_form";
			
			return nextPage;
		}
		
	
}
