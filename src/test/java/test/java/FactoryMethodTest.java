package test.java;

import com.ssau.Pupil;
import com.ssau.Pupils;
import com.ssau.SchoolboyFactory;
import org.junit.jupiter.api.Test;

class FactoryMethodTest {

    @Test
    void TestClone(){

        Pupil original = Pupils.createInstance("StudentFactory",5);
        System.out.println(original.getClass() + " = " +original.getName());
        Pupils.setPupilFactory(new SchoolboyFactory());
        original = Pupils.createInstance("SchoolboyFactory",4);
        System.out.println(original.getClass() + " = " +original.getName());
    }
}
