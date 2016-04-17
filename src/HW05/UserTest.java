package HW05;

import java.io.Console;
import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) {
		Console console = System.console();
		Scanner scanner = new Scanner(System.in);

		String username = "";
		String password = "";
		String comfirmpw = "";
		/*
		 * 直到輸入正確格式的帳號密碼
		 */
		do {
			System.out.println("********** Create an Account **********");
			// System.out.printf("Username：") //Eclipse 無法透過console直接存取資料
			// username = scanner.nextLine();
			// System.out.printf("Password：");
			// password = scanner.nextLine();
			// System.out.printf("Comfirm Password：");
			// comfirmpw = scanner.nextLine();
			username = console.readLine("Username：");
			password = new String(console.readPassword("Password："));
			comfirmpw = new String(console.readPassword("Comfirm Password："));
		} while (!User.comfirmContent(username, password, comfirmpw));

		/* 建立帳號並設定密碼 */
		User user = new User(username);
		user.setPassword(password);

		/* 直到正確登入 */
		do {
			System.out.println("********** Login Account **********");
			// System.out.printf("Username：");
			// username = scanner.nextLine();
			// System.out.printf("Password：");
			// password = scanner.nextLine();
			username = console.readLine("Username：");
			password = new String(console.readPassword("Password："));
		} while (!user.login(username, password));

		String name = "";
		String email = "";
		String phone = "";
		/* 直到使用者輸入符合格式為止 */
		do {
			System.out.println("********** Set User Data **********");
			System.out.printf("Name：");
			name = scanner.nextLine();
			System.out.printf("E-mail：");
			email = scanner.nextLine();
			System.out.printf("Phone：");
			phone = scanner.nextLine();
		} while (!user.setUserData(name, email, phone));
		/* 顯示使用者資訊 */
		System.out.println("********** " + user.getUsernuame() + "'s User Data **********");
		System.out.printf("Name：%s\n", user.getName());
		System.out.printf("E-mail：%s\n", user.getEmail());
		System.out.printf("Phone：%s\n", user.getPhone());
	}

}
