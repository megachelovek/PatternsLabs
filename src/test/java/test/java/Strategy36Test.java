package test.java;


import com.ssau.*;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

public class Strategy36Test {

  @Test
  public void StrategyTest() throws IOException, DecoderException, ClassNotFoundException {
    Strategy strategyStudent = new StrategyArray();
    Pupil[] pupilArrayStudents = CreateRandomStudents(10);
    Pupil[] sortStudents = strategyStudent.SortPupilArray(pupilArrayStudents);

    Strategy strategySchoolboy = new StrategyRegisters();
    Pupil[] pupilArraySchoolboys = CreateRandomStudents(10);
    Pupil[] sortSchoolboy = strategySchoolboy.SortPupilRegisters(pupilArraySchoolboys);

    for (Pupil pup: pupilArrayStudents) {
      System.out.println(pup.getName());
      System.out.println(pup.getSubject(0) + " = "+pup.getMark(0));
      System.out.println(pup.getSubject(1) + " = "+pup.getMark(1));
      System.out.println(pup.getSubject(2) + " = "+pup.getMark(2));
    }
    System.out.println("----");
    for (Pupil pup: sortStudents) {
      System.out.println(pup.getName());
      System.out.println(pup.getSubject(0) + " = "+pup.getMark(0));
      System.out.println(pup.getSubject(1) + " = "+pup.getMark(1));
      System.out.println(pup.getSubject(2) + " = "+pup.getMark(2));
    }
    System.out.println("==============");

    for (Pupil pup: pupilArraySchoolboys) {
      System.out.println(pup.getName());
      System.out.println(pup.getSubject(0) + " = "+pup.getMark(0));
      System.out.println(pup.getSubject(1) + " = "+pup.getMark(1));
      System.out.println(pup.getSubject(2) + " = "+pup.getMark(2));
    }
    System.out.println("----");
    for (Pupil pup: sortSchoolboy) {
      System.out.println(pup.getName());
      System.out.println(pup.getSubject(0) + " = "+pup.getMark(0));
      System.out.println(pup.getSubject(1) + " = "+pup.getMark(1));
      System.out.println(pup.getSubject(2) + " = "+pup.getMark(2));
    }
    System.out.println("==============");

  }

  private Pupil[] CreateRandomStudents(int count){
    Pupil[] result = new Pupil[count];
    Random random = new Random();
    for(int i=0;i<count;i++){
      Student newStudent = new Student("RandomStudent", 0);
      newStudent.addSubjectAndMark("Math"+" r=", random.nextInt(5));
      newStudent.addSubjectAndMark("English"+" r=", random.nextInt(5));
      newStudent.addSubjectAndMark("Geo"+" r=", random.nextInt(5));
      result[i] = newStudent;
    }
    return result;
  }

  private Pupil[] CreateRandomSchoolboy(int count){
    Pupil[] result = new Pupil[count];
    Random random = new Random();
    for(int i=0;i<count;i++){
      Schoolboy newSchoolboy = new Schoolboy("RandomSchoolboy"+i, 0);
      newSchoolboy.addSubjectAndMark("Math"+" r=", random.nextInt(5));
      newSchoolboy.addSubjectAndMark("English"+" r=", random.nextInt(5));
      newSchoolboy.addSubjectAndMark("Geo"+" r=", random.nextInt(5));
      result[i] = newSchoolboy;
    }
    return result;
  }

}
