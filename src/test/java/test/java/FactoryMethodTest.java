package test.java;

import com.ssau.Pupil;
import com.ssau.Pupils;
import com.ssau.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactoryMethodTest {

    @Test
    void TestClone(){

        Pupil original = Pupils.createInstance("StudentFactory",5);
        System.out.println(original.getClass());


    }
}
