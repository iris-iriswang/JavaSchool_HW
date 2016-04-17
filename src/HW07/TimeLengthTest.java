package HW07;

import java.util.Scanner;

public class TimeLengthTest {

	public static void main(String[] args) {
		TimeLength timelength = new TimeLength();
		Scanner scanner = new Scanner(System.in);
		String strInput;
		int intInputType = 0;
		do {
			showMenu();
			strInput = scanner.nextLine();
			if (strInput.matches("[0-3]")) {
				switch (strInput) {
				case "1":/* case 1 輸入時間 */
					System.out.print("Please enter a time (seconds or hh:mm:ss): ");
					strInput = scanner.nextLine();
					/* 檢查輸入合法與否並輸入進行處理 */
					if (strInput.matches("[0-9]*")) {
						intInputType = 1;
						timelength.setSecond(Long.valueOf(strInput));
					} else if (strInput.matches("[0-9]*:[0-5][0-9]:[0-5][0-9]")) {
						intInputType = 2;
						timelength.setSecond(strInput);
					} else {
						System.out.println("Please enter a valid format.\n");
						break;
					}
					System.out.println("Time:" + strInput + "\n");
					break;
				case "2":/* case 2 調整時間 */
					if (intInputType == 0) {
						System.out.println("Please enter a time first.\n");
						break;
					}
					System.out.print("Please enter a time (seconds or hh:mm:ss): ");
					strInput = scanner.nextLine();
					/* 檢查輸入合法與否並輸入進行處理 */
					if (strInput.matches("-?[0-9]*")) {
						timelength.adjustSecond(Long.valueOf(strInput));
					} else if (strInput.matches("-?[0-9]*:[0-5][0-9]:[0-5][0-9]")) {
						timelength.adjustSecond(strInput);
					} else {
						System.out.println("Please enter a valid format.\n");
						break;
					}
					System.out.println("Time:" + strInput + "\n");
					break;
				case "3": /* case 3 已不同單位顯示時間 */
					if (intInputType == 0) {
						System.out.println("Please enter a time first.\n");
						break;
					}
					System.out.println("The current length of time (seconds): " + timelength.getSecond());
					System.out.println("The current length of time (hh:mm:ss): " + timelength.getHHMMSS() + "\n");
					break;
				}
			} else {
				System.out.println("Please enter a valid number.\n");
			}

		} while (!strInput.equals("0"));

	}

	/** 印出選單 */
	public static void showMenu() {
		System.out.println("***Convert Length of Time***");
		System.out.println("1) Set a length of time.");
		System.out.println("2) Adjust the Length of time.");
		System.out.println("3) Show length of time in different units.");
		System.out.println("0) Exit\n");
		System.out.print("Please enter a number in [1,2,3,0]:");

	}

}
