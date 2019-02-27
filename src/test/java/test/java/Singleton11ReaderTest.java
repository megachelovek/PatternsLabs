package test.java;

import com.ssau.SingletonReader;
import org.junit.jupiter.api.Test;

public class Singleton11ReaderTest {

  @Test
  public void ReaderTest(){
    SingletonReader testReader = SingletonReader.getInstance("src/config.properties");
    System.out.print(testReader.GetProperties()[0]+"  ");
    System.out.print(testReader.GetProperties()[1]+ "  ");
    System.out.print(testReader.GetProperties()[2]);
  }

}
