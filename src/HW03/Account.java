package HW03;

/**帳戶類別*/
public class Account {

	private long longBalance;

	/**
	 * 開戶 init the account
	 * 
	 * @param credit
	 *            開戶金額
	 */
	public Account(long credit) {
		longBalance = credit;
	}

	/**
	 * 目前餘額
	 */
	public long getBalance() {
		return longBalance;

	}

	/**
	 * 存款
	 * 
	 * @param credit
	 *            存款金額
	 * @return false 存款金額為負
	 */
	public boolean deposit(long credit) {
		if (credit < 0) {
			return false;
		}
		longBalance += credit;
		return true;

	}

	/**
	 * 提款
	 * 
	 * @param credit
	 *            提款金額
	 * @return false 提款金額為負或目前餘額不足
	 */
	public boolean draw(long credit) {
		if (credit < 0 || credit > longBalance) {
			return false;
		}
		longBalance -= credit;
		return true;
	}

}
