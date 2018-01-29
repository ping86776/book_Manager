package client;
/**
 * 图书类别实体类
 * @author Ping
 *
 */

public class BookType {
	private int id;					//编号
	private String BookTypeName;	//图书类别名
	private String BookTypeDesc;    //备注
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		BookTypeName = bookTypeName;
		BookTypeDesc = bookTypeDesc;
	}
	
	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		BookTypeName = bookTypeName;
		BookTypeDesc = bookTypeDesc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return BookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		BookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return BookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		BookTypeDesc = bookTypeDesc;
	}
	@Override
	public String toString() {
		return "BookType [id=" + id + ", BookTypeName=" + BookTypeName + ", BookTypeDesc=" + BookTypeDesc + "]";
	}
	
}
