package com.office.library.book.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.library.book.BookVo;

@Service
public class BookService {
	
	@Autowired
	BookDao bookDao;
	
	public List<BookVo> searchBookConfirm(BookVo bookVo){
		System.out.println("[BookService] searchBookConfirm()");
		
		return bookDao.searchBookConfirm(bookVo);
	}
	
	public BookVo bookDetail(int b_no) {
		System.out.println("[BookService] bookDerail()");
		
		return bookDao.selectBook(b_no);
	}
	
	public int rentalBookConfirm(int b_no, int u_m_no) {
		System.out.println("[BookService] rentalBookConfirm()");
		
		int result = bookDao.insertRentalBook(b_no, u_m_no);
		
		if(result >= 0)
			bookDao.updateRentalBookAble(b_no);
		
		return result;
	}
	

}
