package HW04;

import java.util.Scanner;

/** The Game class is a guessing number class. */
public class Game {

	private final static int ARRAY_LENGTH_MAX = 100;
	private final static String NUM_TOO_BIG = "猜錯了！您猜得數字比答案大";
	private final static String NUM_TOO_SMALL = "猜錯了！您猜得數字比答案小";
	private final static String NUM_RIGHT = "恭喜您猜對了！";
	private final static String RIGHT_TYPE_RANGE = "輸入正確範圍與格式";
	private final static String WRONG_RANGE = "請輸入範圍內之值";
	private final static String WRONG_TYPE = "請輸入數值";

	private int intMin, intMax, intTimes;
	private int intHasGuessedTimes;
	private int intGuessedNumbers[];
	private int intRandomNum;

	private int intNum;
	private String strResult = "";

	/** 預設猜數字次數最多僅能是ARRAY_LENGTH_MAX */
	public Game() {
		intGuessedNumbers = new int[ARRAY_LENGTH_MAX];
	}

	/** set the range, the times, and the random number. */
	public void setSettings() {
		Scanner scanner = new Scanner(System.in);
		int min = 0, max = 0, times = 0;
		boolean flag = false;
		System.out.println("*********猜數字遊戲**********");
		
		/*直到使用者輸入數值*/
		while(!flag){
			System.out.printf("猜數字範圍最小值:");
			if(scanner.hasNextInt()){
				flag = true;
				min = scanner.nextInt();
			}else{
				scanner.next();
			}
		}
		flag = false;
		
		/*直到使用者輸入數值*/
		while(!flag){
			System.out.printf("猜數字範圍最大值:");
			if(scanner.hasNextInt()){
				flag = true;
				max = scanner.nextInt();
			}else{
				scanner.next();
			}
		}
		flag = false;
		
		/*直到使用者輸入數值*/
		while(!flag){
			System.out.printf("猜數字次數限制:");
			if(scanner.hasNextInt()){
				flag = true;
				times = scanner.nextInt();
			}else{
				scanner.next();
			}
		}
		/*設定最小範圍
		 * 設定最大範圍
		 * 設定猜測次數
		 * 設定隨機答案*/
		intMin = min;
		intMax = max;
		intTimes = times;
		intRandomNum = (int) (Math.random() * (intMax - intMin + 1) + intMin);
	}

	/**
	 * record the guessed number.
	 * 
	 * @param num
	 *            the guessed number
	 */
	public void setGuessedNum(int num) {
		intHasGuessedTimes++;
		intGuessedNumbers[getGuessedTimes() - 1] = num;
	}

	/** 回傳範圍最小值 */
	public int getMin() {
		return intMin;
	}

	/** 回傳範圍最大值 */
	public int getMax() {
		return intMax;
	}

	/** 回傳猜測次數限制 */
	public int getTimes() {
		return intTimes;
	}

	/** 回傳亂數設定的答案 */
	public int getRandomNum() {
		return intRandomNum;
	}

	/** 回傳已猜測的次數 */
	public int getGuessedTimes() {
		return intHasGuessedTimes;
	}

	/** 比較猜測數字與答案的大小 */
	public String compare() {

		if (intNum > getRandomNum()) {
			intMax = intNum - 1;
			return NUM_TOO_BIG;
		} else if (intNum < getRandomNum()) {
			intMin = intNum + 1;
			return NUM_TOO_SMALL;
		}

		return NUM_RIGHT;

	}

	/**
	 * 檢查輸入是否符合要求
	 * 
	 * @param num
	 */
	public String checkInput() {
		Scanner scanner = new Scanner(System.in);
		/* 檢查輸入是否為整數值 */
		if (scanner.hasNextInt()) {
			intNum = scanner.nextInt();
			/* 檢查輸入是否超出範圍 */
			if (intNum < getMin() || intNum > getMax()) {
				return WRONG_RANGE;
			}
			return RIGHT_TYPE_RANGE;
		}
		scanner.next();
		return WRONG_TYPE;
	}

	/** 顯示猜過的數字及訊息 */
	public void showHistory() {
		for (int i = 1; i <= getGuessedTimes(); i++) {
			System.out.printf("第%d猜：%d\n", i, intGuessedNumbers[i - 1]);
		}
		System.out.println("-----");
		System.out.printf("猜數字限制%d次\n", getTimes());
		System.out.printf("您總共猜了%d次\n", getGuessedTimes());
		System.out.printf("正確數字：%d\n", getRandomNum());
	}

	/** 開始遊戲 */
	public void StartGame() {
		intNum = 0;
		intHasGuessedTimes = 0;

		System.out.println("*********遊戲開始**********");
		do {
			System.out.printf("數字範圍：%d ~ %d\n", getMin(), getMax());
			System.out.printf("您猜的數字：");
			strResult = checkInput();
			if (strResult.equals(RIGHT_TYPE_RANGE)) {
				strResult = compare();
				setGuessedNum(intNum);
				System.out.println(strResult);
			}else{
				System.out.println(strResult);
			}
			

		} while (!(strResult.equals(NUM_RIGHT) || intHasGuessedTimes >= intTimes
				|| intHasGuessedTimes >= ARRAY_LENGTH_MAX));
		System.out.println("*********遊戲結束**********");

	}

}
