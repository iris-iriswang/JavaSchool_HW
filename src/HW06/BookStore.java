package HW06;

import java.util.Scanner;

public class BookStore {
	public static Book[] books = new Book[6];
	public static BookOrder bookorder;

	public static void main(String[] args) {
		System.out.println("********** Welcome to Book Store **********");
		setBooks();
		printBooks();
		orderBook();
		bookorder.priintOrder();
	}

	/** 訂購書籍 */
	public static void orderBook() {
		Scanner scanner = new Scanner(System.in);
		String bookID, name, phone;
		do {
			System.out.printf("請輸入訂購書籍[1-6]：");
			bookID = scanner.nextLine();
			System.out.printf("請輸入您的姓名：");
			name = scanner.nextLine();
			System.out.printf("請輸入聯絡電話：");
			phone = scanner.nextLine();
		} while (!isOrderFormat(bookID, name, phone));
		scanner.close();
		bookorder = new BookOrder(books[Integer.valueOf(bookID) - 1], name, phone);

	}

	/** 印出書籍清單 */
	public static void printBooks() {
		for (int i = 0; i < books.length; i++) {
			System.out.printf("%d)%s\t\t%9.2f 元\n", i + 1, books[i].getBookTitle(), books[i].getBookPrice());
		}
		System.out.println();
	}

	/** 設置書籍清單 */
	public static void setBooks() {
		books[0] = new Book(1, "會計學　", 360);
		books[1] = new Book(2, "統計學　", 245);
		books[2] = new Book(3, "程式語言", 600);
		books[3] = new Book(4, "經濟學　", 445);
		books[4] = new Book(5, "本國史　", 180);
		books[5] = new Book(6, "英文　　", 350);
	}

	/** 驗證訂購格式 */
	public static boolean isOrderFormat(String bookID, String name, String phone) {
		boolean flag = true;
		if (!bookID.matches("[1-6]")) {
			System.out.println("請輸入正確書籍代碼！");
			flag = false;
		}
		if (!name.matches("[[a-zA-Z-_]&&[^0-9]]*")) {
			System.out.println("請輸入正確姓名！");
			flag = false;
		}
		if (!phone.matches("[0-9]{4}-[0-9]{6}")) {
			System.out.println("電話格式有誤! (格式: 0000-000000)");
			flag = false;
		}

		return flag;
	}
}
