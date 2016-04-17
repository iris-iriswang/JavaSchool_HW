package HW05;

public class User {
	private static final String successfully_created = "Account successfully created!";
	private static final String unsuccessfully_created = "Unable to create account!";
	private static final String successfully_loging = "Logged in successfully!";
	private static final String unsuccessfully_loging = "Incorrect login!";
	private String strUsername;
	private String strPassword;
	private String strName;
	private String strEmail;
	private String strPhone;

	/**
	 * 初始使用者帳戶
	 * 
	 * @param username
	 *            帳號
	 */
	public User(String username) {
		strUsername = username;
	}

	/**
	 * 設定密碼
	 * 
	 * @param password
	 *            密碼
	 */
	public void setPassword(String password) {
		strPassword = password;
	}

	/**
	 * 設定名稱
	 * 
	 * @param name
	 *            名稱
	 */
	public void setName(String name) {
		strName = name;
	}

	/**
	 * 設定電子郵件
	 * 
	 * @param email
	 *            電子郵件
	 */
	public void setEmail(String email) {
		strEmail = email;
	}

	/**
	 * 設定電話號碼
	 * 
	 * @param phone
	 *            電話號碼
	 */
	public void setPhone(String phone) {
		strPhone = phone;
	}

	/** 回傳使用者帳號 */
	public String getUsernuame() {
		return strUsername;
	}

	/** 回傳使用者名稱 */
	public String getName() {
		return strName;
	}

	/** 回傳電子郵件 */
	public String getEmail() {
		return strEmail;
	}

	/** 回傳電話號碼 */
	public String getPhone() {
		return strPhone;
	}

	/**
	 * 使用者登入
	 * 
	 * @return false 登入失敗
	 * 
	 * @param username
	 *            帳號
	 * @param password
	 *            密碼
	 */
	public boolean login(String username, String password) {
		if (strUsername.equals(username) && strPassword.equals(password)) {
			System.out.println(successfully_loging + "\n");
			return true;
		}
		System.out.println(unsuccessfully_loging + "\n");
		return false;
	}

	/*
	 * name 格式 matches("[\\w&&[^0-9]&&[\\S]]*") phone 格式
	 * matches("[0-9]{4}-[0-9]{6}") email 格式
	 * matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")
	 */
	/**
	 * 設定使用者資訊並檢查其輸入是否符合格式
	 * 
	 * @param name
	 *            名稱
	 * @param email
	 *            電子郵件
	 * @param phone
	 *            電話號碼
	 * 
	 * @return false 有項目格式不符
	 */
	public boolean setUserData(String name, String email, String phone) {
		boolean flag = true;
		if (!name.matches("[\\w&&[^0-9]&&[\\S]]*")) {
			flag = false;
			System.out.println("Invalid Name Format.");
		}
		if (!email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
			flag = false;
			System.out.println("Invalid E-mail Format.");
		}
		if (!phone.matches("[0-9]{4}-[0-9]{6}")) {
			flag = false;
			System.out.println("Invalid Phone Format.");
		}
		if (flag == true) {
			strName = name;
			strEmail = email;
			strPhone = phone;
		}
		return flag;
	}

	/**
	 * 可透過此方法預先檢查帳號密碼是否符合設定標準
	 * 
	 * @param username
	 *            帳號
	 * @param password
	 *            密碼
	 * @param comfirmpw
	 *            確認密碼
	 * @return false 不符合設定標準
	 */
	public static boolean comfirmContent(String username, String password, String comfirmpw) {
		if (username.length() >= 6 && password.length() >= 6 && password.equals(comfirmpw)) {
			System.out.println(successfully_created + "\n");
			return true;
		}
		System.out.println(unsuccessfully_created + "\n");
		return false;
	}

}
