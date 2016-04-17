package HW02;
public class Student{
    //類別所含資訊個數：姓名，學號，班級
    public static final int info_count = 3;
    //透過陣列紀錄：姓名，學號，班級
    private String array_strInfos[] = new String[3];

    //建構子
    public Student(){
        //Nothing needs to initial.
    }

    //透過set方法設定物件屬性（陣列內容）
    public void setStudentInfo(String array_strInfos[]){
        for(int i=0; i<info_count; i++){
            this.array_strInfos[i] = array_strInfos[i];
        }
    }

    //透過get方法取得物件屬行
    /** int i 使用者可指定欲取得之內容*/
    public String getStudentInfo(int i){
        return array_strInfos[i];
    }
}
