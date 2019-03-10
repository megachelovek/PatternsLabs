package test.java;


import com.ssau.*;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class Visitor37Test {

  @Test
  public void TestVisitor() throws IOException, DecoderException, ClassNotFoundException {
    Visitor visitor = new PrintVisitor();
    Student student = new Student("VisitorStudent" , 0);
    student.addSubjectAndMark("1StudentSubject1",2);
    student.addSubjectAndMark("2StudentSubject2",3);
    System.out.println(student.accept(visitor));

    Schoolboy schoolboy = new Schoolboy("VisitorSchoolboy" , 0);
    schoolboy.addSubjectAndMark("1SchoolboySubject1",2);
    schoolboy.addSubjectAndMark("2SchoolboySubject2",3);
    System.out.println(schoolboy.accept(visitor));
  }
}
