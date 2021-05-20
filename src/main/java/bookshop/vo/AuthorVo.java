package bookshop.vo;

public class AuthorVo {

	private long no;
	private String name;
	public long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AuthorVo [no=" + no + ", name=" + name + "]";
	}
	
	
}
