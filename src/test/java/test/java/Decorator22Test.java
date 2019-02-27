package test.java;

import com.ssau.Pupil;
import com.ssau.Pupils;
import com.ssau.Student;
import org.junit.jupiter.api.Test;

public class Decorator22Test {

  @Test
  public void TestDecorate(){
    Pupil pupilTest = Pupils.synchronizedPupil(new Student("TestDecorate",0));
    System.out.print(pupilTest.getName() );
  }
}
