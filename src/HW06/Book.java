package HW06;

public class Book {
	private int intBookID;
	private String strBookTitle;
	private double douBookPrice;

	/** 建構子 */
	public Book(int bookID, String bookTitle, double bookPrice) {
		intBookID = bookID;
		strBookTitle = bookTitle;
		douBookPrice = bookPrice;
	}

	/** 取得書籍編號 */
	public int getBookID() {
		return intBookID;
	}

	/** 取得書籍名稱 */
	public String getBookTitle() {
		return strBookTitle;
	}

	/** 取得書籍價格 */
	public double getBookPrice() {
		return douBookPrice;
	}
}
