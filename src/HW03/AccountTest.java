package HW03;

import java.util.Scanner;
/**AccountTest is used to test Account class.*/
public class AccountTest {

	public static void main(String[] args) {
		Account account = null;
		boolean hasAccount = false;
		boolean need2continue = true;
		long credit = 0;

		Scanner input = new Scanner(System.in);
		do {
			/* 印出選單內容 */
			System.out.printf("\n***Main Menu***\n");
			System.out.printf("1）開戶\n2）存款\n3）提款\n4）目前餘額\n0）Exit\n\n");
			System.out.printf("Please enter a number in [1, 2, 3, 4, 0]:");
			
			/*檢查使用者需求指令是否在[1, 2, 3, 4, 0]中*/
			if (input.hasNextInt()) {
				/* 判斷使用者需求 */
				switch (input.nextInt()) {
				/* 1)開戶 */
				case 1:
					/* 檢查使用者開戶與否 */
					if (hasAccount) {
						System.out.printf("已開戶！\n");
					} else {
						System.out.printf("請輸入開戶金額：");
						/*若使用者未開戶即可開戶，要求使用者輸入金額，並檢查使用輸入型態使否為long*/
						if (!(input.hasNextLong())) {
							// input中的has僅做請求輸入及判斷，不做取出
							// 須取出input中next的值，才不影響下次輸入
							input.next();
							System.out.printf("開戶失敗！請輸入金額\n");
							break;
						}
						//開戶金額
						credit = input.nextLong();

						/* 檢查開戶金額是否大於1000 */
						if (credit < 1000) {
							System.out.printf("開戶金額不足！\n");
						} else {
							/* 開戶金額大於1000，開戶並初始戶頭金額，開戶旗標 = true */
							account = new Account(credit);
							hasAccount = true;
							System.out.printf("開戶成功！成功存入$ %d 元\n", credit);
						}
					}
					//case 1 break
					break; 

				/* 2)存款 */
				case 2:
					/* 檢查使用者開戶與否 */
					if (hasAccount) {
						System.out.printf("請輸入存款金額：");
						/*若使用者已開戶，要求使用者輸入金額，並檢查使用輸入型態使否為long*/
						if (!(input.hasNextLong())) {
							// input中的has僅做請求輸入及判斷，不做取出
							// 須取出input中next的值，才不影響下次輸入
							input.next();
							System.out.printf("存款失敗！請輸入金額\n");
							break;
						}
						//存款金額
						credit = input.nextLong();

						/* 檢查是否成功存入 */
						if (account.deposit(credit)) {
							System.out.printf("成功存入$ %d元\n", credit);
						} else {
							System.out.printf("存款失敗！請輸入非負整數！\n");
						}
					} else {
						System.out.printf("未開戶！\n");
					}
					//case 2 break
					break;

				/* 3)提款 */
				case 3:
					/* 檢查使用者開戶與否 */
					if (hasAccount) {
						System.out.printf("請輸入提款金額：");
						/*若使用者已開戶，要求使用者輸入金額，並檢查使用輸入型態使否為long*/
						if (!(input.hasNextLong())) {
							// input中的has僅做請求輸入及判斷，不做取出
							// 須取出input中next的值，才不影響下次輸入
							input.next();
							System.out.printf("提款失敗！請輸入金額\n");
							break;
						}
						//提款金額
						credit = input.nextLong();

						/* 檢查是否成功提款 */
						if (account.draw(credit)) {
							System.out.printf("成功領出$ %d 元\n", credit);
						} else if (credit < 0) {
							System.out.printf("提款失敗！提款金額不得為負\n");
						} else {
							System.out.printf("提款失敗！提款金額大於目前餘額\n");
						}
					} else {
						System.out.printf("未開戶！\n");
					}
					//case 3 break
					break;

				/* 4)目前餘額 */
				case 4:
					/* 檢查使用者開戶與否 */
					if (hasAccount) {
						System.out.printf("目前餘額：$ %d 元\n", account.getBalance());
					} else {
						System.out.printf("未開戶！\n");
					}
					//case 4 break
					break;

				/* 0)離開程式 */
				case 0:
					need2continue = false;
					break;

				default:
					System.out.printf("僅能輸入[1, 2, 3, 4, 0]\n");
					break;
				}

			} else {
				input.next();
				System.out.printf("僅能輸入[1, 2, 3, 4, 0]\n");
			}
		} while (need2continue);

	}

}
