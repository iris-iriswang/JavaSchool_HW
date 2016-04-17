package HW02;
import java.util.Scanner;

public class CaesarTest{
    /**程式進入點*/
    public static void main(String[] args) {
        //實作Caesar物件
        Caesar caesar = new Caesar();
        //實作Scanner物件用以取得使用者輸入內容
        Scanner input = new Scanner(System.in);


        /**讀入明文*/
        System.out.printf("Plaintext:");
        caesar.setPlaintext(input.next());
        /**讀入偏移量*/
        System.out.printf("Key:");
        caesar.setKey(input.nextInt());
        //印出密文
        System.out.printf("Ciphertext:%s\n", caesar.getCiphertext());
    }
}
