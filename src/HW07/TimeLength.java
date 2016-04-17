package HW07;

public class TimeLength {

	private long longSecond;

	public TimeLength() {

	}

	/** 回傳以秒為單位的時間長度 */
	public long getSecond() {
		return longSecond;
	}

	/** 回傳以hh:mm:ss為單位的時間長度 */
	public String getHHMMSS() {
		return convertSecond2hhmmss(longSecond);
	}

	/**
	 * 以秒為單位設定時間
	 * 
	 * @param time
	 *            時間
	 */
	public void setSecond(long time) {
		this.longSecond = time;
	}

	/**
	 * 以hh:mm:ss為單位設定時間
	 * 
	 * @param time
	 *            時間
	 */
	public void setSecond(String time) {
		this.longSecond = converthhmmss2Second(time);
	}

	/**
	 * 以秒為單位調整時間
	 * 
	 * @param time
	 *            欲調整的時間
	 */
	public void adjustSecond(String time) {
		long second = converthhmmss2Second(time);
		longSecond += second;
	}

	/**
	 * 以hh:mm:ss為單位調整時間
	 * 
	 * @param time
	 *            欲調整的時間
	 */
	public void adjustSecond(long time) {
		longSecond += time;

	}

	/**
	 * 回傳時間以hh:mm:ss表示之格式
	 * 
	 * @param time
	 *            欲轉換的時間
	 */
	public String convertSecond2hhmmss(long time) {
		String result = "";
		if (time < 0) {
			time = time * -1;
			int h = (int) time / 3600;
			time = time % 3600;
			int m = (int) time / 60;
			time = time % 60;
			int s = (int) time;
			result = "-" + String.format("%02d:%02d:%02d", h, m, s);
		} else {
			int h = (int) time / 3600;
			time = time % 3600;
			int m = (int) time / 60;
			time = time % 60;
			int s = (int) time;
			result = String.format("%02d:%02d:%02d", h, m, s);
		}

		return result;
	}
	/**
	 * 回傳時間以秒表示之格式
	 * 
	 * @param time
	 *            欲轉換的時間
	 */
	public long converthhmmss2Second(String time) {
		String times[] = time.split(":");
		long second = 0;
		second += 60 * 60 * Long.valueOf(times[0]);
		second += 60 * Long.valueOf(times[1]);
		second += Long.valueOf(times[2]);
		return second;

	}

}
