package test.java;


import com.ssau.Student;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Memento34Test {

  @Test
  public void TestMemento() throws IOException, DecoderException, ClassNotFoundException {
    Student student = new Student("MementoTest",0);
    student.addSubjectAndMark("1Memento1",2);
    student.addSubjectAndMark("2Memento2",4);
    student.addSubjectAndMark("3Memento3",5);
    System.out.println(student);
    System.out.println("---");
    Student.MementoStudent  mementoStudent = student.createMemento();
    student.setSubject(0,"NONONO");
    student.setSubject(1,"NONONO");
    student.setSubject(2,"NONONO");
    System.out.println(student);
    System.out.println("=====");
    student = student.GetStudentMemento(mementoStudent);
    System.out.println(student);
  }
}
