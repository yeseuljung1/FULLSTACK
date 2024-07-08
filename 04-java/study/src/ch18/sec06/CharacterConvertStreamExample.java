package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample
{
    public static void main(String[] args) throws Exception {
//        해당 경로에 가진 출력 스트림을 만들어줌
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }
    public static void write(String str) throws Exception {
        OutputStream os = new FileOutputStream("C:/Temp/test.txt");
//        바이트 스트림을 문자열 스트림으로 사용하기 위해 보조 스트림으로 연결해줌
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }
    public static String read() throws Exception {
//        해당 경로를 가진 입력 스크림을 만들어줌
        InputStream is = new FileInputStream("C:/Temp/test.txt");
//        바이트 스트림을 문자열로 스트림으로 사용하기 위해 보조 스트림으로 연결해줌
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[100];
        int num = reader.read(data);
        reader.close();
        String str = new String(data, 0, num);
        return str;
    }
}

