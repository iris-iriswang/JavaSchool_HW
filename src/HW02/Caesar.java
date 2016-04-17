package HW02;
import java.lang.String;

public class Caesar{
    //自訂字母表
    public static final String words = "qwertyuiopasdfghjklzxcvbnm";
    /**
    strPlaintext：明文 (使用者輸入)
    intKey：金鑰 (使用者輸入)
    strCiphertext：密文 (輸出結果)*/
    private String strPlaintext;
    private int intKey;
    private String strCiphertext = "";

    /**set方法設定Caesar物件的明文屬性*/
    public void setPlaintext(String str){
        strPlaintext = str;
    }

    /**set方法設定Caesar物件的偏移量屬性*/
    public void setKey(int i){
        intKey = i;
    }

    /**get方法取得加密後之密文*/
    public String getCiphertext(){
        strCiphertext = "";
        //將明文轉成小寫以便之後轉換
        String strPlaintextLower = strPlaintext.toLowerCase();
        /**一個字一個字取得並將其轉換為密文*/
        for(int i=0; i<strPlaintext.length(); i++){
            strCiphertext += convertPlain2Cipher(strPlaintextLower.charAt(i));
        }
        return strCiphertext;
    }

    /**將明文字元轉換乘密文字元*/
    private String convertPlain2Cipher(char c){
        int intPosition = words.indexOf(c);
        char chaCipher = words.charAt(((intPosition + intKey) % 26));
        return new Character(chaCipher).toString();
    }
}
