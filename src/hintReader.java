import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/*
    ���ϸ����� ���� ����� ����Ͽ� ��������ϴ�.
    ArrayList�� ����߽��ϴ�.
    �������� �ֽ� �����ð� �ڷḦ ����߽��ϴ�.
 */
public class hintReader {
    File f;
    ArrayList<Integer> arr = new ArrayList<>(10);
    hintReader(String name){
        f=new File(name);
    }

    public ArrayList read() throws IOException {
//        System.out.println("start reading ");
        String text ="";
        FileReader in = new FileReader(f);
        int ch,i=0;
        while((ch = in.read())!=-1){
            if((char)ch=='-'|(char)ch=='/'){
                arr.add(Integer.valueOf(text));
                text="";
                continue;
            }
            //System.out.println((char)ch);
            text+=(char)ch;
        }
//        System.out.print("Array: "+ arr);
        return arr;
    }
//    public static void main(String [] args) throws IOException {
//
//        new hintReader("hint.txt").read();
//
//    }
}
