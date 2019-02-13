package test.java;


import com.ssau.*;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ChainResponsibilityTest {

  @Test
  public void TestChain() throws IOException, DecoderException, ClassNotFoundException {
    Pupil studentColumn = new Student("ChainStudentColumn", 0);
    studentColumn.addSubjectAndMark("ColumnMath",2);
    studentColumn.addSubjectAndMark("ColumnEnglish",5);
    studentColumn.addSubjectAndMark("ColumnC#",5);
    studentColumn.addSubjectAndMark("ColumnJava",4);
    ChainResponsibility chainResponsibility = new ChainResponsibilityString();
    chainResponsibility.OutputStudent(studentColumn);
    FileReaderTest("TextChainResponsibility.txt");

    FileWriter fstream1 = new FileWriter("TextChainResponsibility.txt");// конструктор с одним параметром - для перезаписи
    BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
    out1.write(""); // очищаем, перезаписав поверх пустую строку
    out1.close(); // закрываем
    System.out.println("=========");
    Pupil studentString = new Student("ChainStudentString", 0);
    studentString.addSubjectAndMark("StringMath",2);
    studentString.addSubjectAndMark("StringEnglish",5);
    studentString.addSubjectAndMark("StringC#",5);
    ChainResponsibility chainResponsibility2 = new ChainResponsibilityColumn();
    chainResponsibility2.OutputStudent(studentString);
    FileReaderTest("TextChainResponsibility.txt");

  }


  private void FileReaderTest(String path){
    try(FileReader reader = new FileReader(path))
    {
      char[] buf = new char[256];
      int c;
      while((c = reader.read(buf))>0){

        if(c < 256){
          buf = Arrays.copyOf(buf, c);
        }
        System.out.print(buf);
      }
    }
    catch(IOException ex){

      System.out.println(ex.getMessage());
    }
  }
}
