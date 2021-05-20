package bookshop.test;

import java.util.List;

import bookshop.dao.AuthorDao;
import bookshop.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
		//insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		List<AuthorVo> list = new AuthorDao().findAll();
		for(AuthorVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void insertTest() {
		AuthorVo vo = null;
		
		vo = new AuthorVo();
		vo.setName("스테파니메이어");
		new AuthorDao().insert(vo);
		
		vo = new AuthorVo();
		vo.setName("조정래");
		new AuthorDao().insert(vo);
				
		vo = new AuthorVo();
		vo.setName("김동인");
		new AuthorDao().insert(vo);

		vo = new AuthorVo();
		vo.setName("김난도");
		new AuthorDao().insert(vo);

		vo = new AuthorVo();
		vo.setName("천상병");
		new AuthorDao().insert(vo);

		vo = new AuthorVo();
		vo.setName("조정래");
		new AuthorDao().insert(vo);
	}
}
