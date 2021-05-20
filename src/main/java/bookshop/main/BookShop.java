package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookShop {

	public static void main(String[] args) {
		displayBookInfo();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		Long no = scanner.nextLong();
		scanner.close();

		new BookDao().update(no, "대여중");
		displayBookInfo();
	}

	private static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기******");
		
		List<BookVo> list = new BookDao().findAll();
		for(BookVo vo : list) {
			String infos = String.format("[%02d] 책 제목: %s, 작가: %s, 대여유무:%s", vo.getNo(), vo.getTitle(), vo.getAuthorName(), vo.getStatus());
			System.out.println(infos);
		}
	}
}