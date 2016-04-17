package HW06;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookOrder {
	private long longOrderID;
	private Book book;
	private String strName;
	private String strPhone;
	private Date dateTime;

	/**建構子*/
	public BookOrder(Book book, String name, String phone) {
		this.book = book;
		strName = name;
		strPhone = phone;
		dateTime = new Date();
		longOrderID = (long) dateTime.getTime() / 1000;
	}

	/** 印出訂單明細 */
	public void priintOrder() {
		System.out.println("********** 訂購明細 **********");
		System.out.printf("訂單編號： %d\n", longOrderID);
		System.out.printf("買家姓名： %s\n", strName);
		System.out.printf("聯絡電話： %s\n", strPhone);
		System.out.printf("書籍名稱： %s\n", book.getBookTitle());
		System.out.printf("應付金額： %.2f  元\n", book.getBookPrice());
		System.out.printf("訂單成立時間： %s\n", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime).toString());
	}

}
