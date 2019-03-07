package test.java;

import com.ssau.CommandWriterString;
import com.ssau.Student;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

public class Command32Test {

  @Test
  public void CommandWriterTest() throws IOException {
    FileWriter writer = new FileWriter("TextStudentCommand.txt", true); // TODO предмет оценка фамилия
    PrintWriter clean = new PrintWriter("TextStudentCommand.txt");
    clean.print("");
    clean.close();
    Student student = new Student("CommandTest",0);
    student.addSubjectAndMark("Math",3);
    student.addSubjectAndMark("C#",2);
    student.addSubjectAndMark("Java",2);
    student.addSubjectAndMark("English",2);
    student.print(writer);
    writer.close();
    FileReaderTest("TextStudentCommand.txt");
    System.out.print("======");
    student.SetPrintCommand(new CommandWriterString());
    FileWriter writer2 = new FileWriter("TextStudentCommand.txt", true);
    student.print(writer2);
    FileReaderTest("TextStudentCommand.txt");
    writer2.close();
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
