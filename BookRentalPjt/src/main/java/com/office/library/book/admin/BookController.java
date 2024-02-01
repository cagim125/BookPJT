package com.office.library.book.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.office.library.book.BookVo;
import com.office.library.book.admin.util.UploadFileService;

@Controller
@RequestMapping("/book/admin")
public class BookController {
	
		@Autowired
		BookService bookService;
		
		@Autowired
		UploadFileService uploadFileService;
	
		// 도서 Form
		@GetMapping("/registerBookForm")
		public String registerBookForm() {
			System.out.println("[BookController] registerBookFrom()");
			
			String nextPage = "admin/book/register_book_form";
			
			return nextPage;
		}
		
		// 도서 등록
		@PostMapping("/registerBookConfirm")
		public String registerBookConfirm(BookVo bookVo, 
				@RequestParam("file") MultipartFile file) {
			System.out.println("[BookController] registerBookConfirm()");
			
			// 파일 저장
			String savedFileName = uploadFileService.upload(file);
			
			String nextPage = "admin/book/register_book_ok";
			
			if (savedFileName != null) {
				bookVo.setB_thumbnail(savedFileName);
				int result = bookService.registerBookConfirm(bookVo);
				
				if (result <= 0)
					nextPage = "admin/book/register_book_ng";
			} else {
				nextPage = "admin/book/register_book_ok";
			}
			return nextPage;
		}
		
		@GetMapping("/searchBookConfirm")
		public String searchBookConfirm(BookVo bookVo, Model model) {
			System.out.println("[BookController] searchBookConfirm()");
			
			String nextPage = "admin/book/search_book";
			
			List<BookVo> bookVos = bookService.searchBookConfirm(bookVo);
			
			model.addAttribute("bookVos", bookVos);
			
			return nextPage;
			
			
			
		}
		
	
}
