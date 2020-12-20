import java.io.FileWriter;
import java.io.IOException;

//교수님이 주신 수업시간 자료를 사용했습니다.

public class hintWriter {
    String text="";
    FileWriter out;
    public void add(String sentence) throws IOException {
        if(sentence.equals("end")){
//            text+="end";
            write();
        }
        else {
            text += sentence;
            text += "-";
        }
    }
    public void write() throws IOException {

        out.write(text);
        out.close();
        System.out.print("done");
    }
    hintWriter(String name) throws IOException {
        out = new FileWriter(name);
    }
//    public static void main(String [] args) throws IOException {
//        hintWriter f = new hintWriter("hint.txt");
//        f.add("hello");
//        f.add("hello");
//        f.add("end");
//
//    }
}
