package HW02;
import java.util.Scanner;

public class StudentTest{
    //類別所含資訊個數：姓名，學號，班級
    public static final int info_count = 3;
    //資訊個別名稱：姓名（Name),學號（StudentID）,班級（Class）
    public static final String array_strInfosName[] = {"Name", "StudentID", "Class"};

    //程式進入點main
    public static void main(String args[]){
        //宣告並取得兩個Student物件
        Student student1 = new Student();
        Student student2 = new Student();
        //取得Scanner物件
        Scanner input = new Scanner(System.in);
        //宣告並取得字串陣列
        String array_strStudentInfo[] = new String[3];

        //透過Student類別的set方法，設定Student1資訊(命令列引數)
        student1.setStudentInfo(args);

        //取得使用者依提示輸入之內容：Student2
        for(int i=0; i<info_count; i++){
            System.out.printf("%s:", array_strInfosName[i]);
            //暫存資訊進字串陣列
            array_strStudentInfo[i] = input.next();
        }
        //透過Student類別的set方法，設定Student2資訊
        student2.setStudentInfo(array_strStudentInfo);

        //在cmd上顯示使用者輸入資訊
        System.out.printf("----------Student 1----------\n");
        for(int i=0; i<info_count; i++){
            System.out.printf("%s:%s\n", array_strInfosName[i], student1.getStudentInfo(i));
        }
        
        System.out.printf("----------Student 2----------\n");
        for(int i=0; i<info_count; i++){
            System.out.printf("%s:%s\n", array_strInfosName[i], student2.getStudentInfo(i));
        }
    }
}
