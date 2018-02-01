package client;
/**
 * 图书实体类
 * @author Ping
 *
 */

public class Book {
	private int id;  //编号
	private String bookName;  //图书名称
	private Integer bookTypeId;  //图书种类Id
	private String bookTypeName; //图书类别名称
	private String bookDesc;  //备注
		
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
			
	public Book(String bookName, Integer bookTypeId, String bookTypeName, String bookDesc) {
		super();
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
		this.bookDesc = bookDesc;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookTypeName=" + bookTypeName + "]";
	}
	
	
	

}
