package test.java;

import com.ssau.Pupil;
import com.ssau.Pupils;
import org.junit.jupiter.api.Test;

public class PupilsTest {

    @Test
    public void TestFactoryMethod(){
        Pupil test = Pupils.createInstance("Iosifff Kobzon",0);
        System.out.println("Class = " +test.getClass() + " | Name = " + test.getName());
    }

}