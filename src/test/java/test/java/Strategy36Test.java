package test.java;


import com.ssau.*;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

public class Strategy36Test {

  @Test
  public void StrategyTest() throws IOException, DecoderException, ClassNotFoundException {
    Strategy strategyStudent = new StrategySort();
    Pupil[] pupilArrayStudents = CreateRandomStudents(10);

    for (Pupil pup: pupilArrayStudents) {
      System.out.print(pup.getName());
      System.out.println("=  "+pup.getAverage());
    }

    Pupil[] sortStudents = strategyStudent.SortPupil(pupilArrayStudents);

    System.out.println("-----------------");
    for (Pupil pup: sortStudents) {
      System.out.print(pup.getName());
      System.out.println("=  "+pup.getAverage());
    }

    Strategy strategySchoolboy = new StrategySort();
    Pupil[] pupilArraySchoolboys = CreateRandomSchoolboy(10);

    System.out.println("===============================================");

    for (Pupil pup: pupilArraySchoolboys) {
      System.out.print(pup.getName());
      System.out.println("=  "+pup.getAverage());
    }

    Pupil[] sortSchoolboy = strategySchoolboy.SortPupil(pupilArraySchoolboys);

    System.out.println("----");
    for (Pupil pup: sortSchoolboy) {
      System.out.print(pup.getName());
      System.out.println("=  "+pup.getAverage());
    }

  }

  private Pupil[] CreateRandomStudents(int count){
    Pupil[] result = new Pupil[count];
    Random random = new Random();
    for(int i=0;i<count;i++){
      Student newStudent = new Student("RandomStudent"+i, 0);
      newStudent.addSubjectAndMark("Math"+" r=", 1+random.nextInt(4));
      newStudent.addSubjectAndMark("English"+" r=", 1+random.nextInt(4));
      newStudent.addSubjectAndMark("Geo"+" r=", 1+random.nextInt(4));
      if (newStudent.getSubject(1)==null){
        newStudent.addSubjectAndMark("Java"+" r=", 1+random.nextInt(4));
      }
      if (newStudent.getSubject(2)==null){
        newStudent.addSubjectAndMark(".net"+" r=", 1+random.nextInt(4));
      }
      result[i] = newStudent;
    }
    return result;
  }

  private Pupil[] CreateRandomSchoolboy(int count){
    Pupil[] result = new Pupil[count];
    Random random = new Random();
    for(int i=0;i<count;i++){
      Schoolboy newSchoolboy = new Schoolboy("RandomSchoolboy"+i, 0);
      newSchoolboy.addSubjectAndMark("Math"+" r=", 1+random.nextInt(4));
      newSchoolboy.addSubjectAndMark("English"+" r=", 1+random.nextInt(4));
      newSchoolboy.addSubjectAndMark("Geo"+" r=", 1+random.nextInt(4));
      if (newSchoolboy.getSubject(1)==null){
        newSchoolboy.addSubjectAndMark("Java"+" r=", 1+random.nextInt(4));
      }
      if (newSchoolboy.getSubject(2)==null){
        newSchoolboy.addSubjectAndMark(".net"+" r=", 1+random.nextInt(4));
      }
      result[i] = newSchoolboy;
    }
    return result;
  }

}
