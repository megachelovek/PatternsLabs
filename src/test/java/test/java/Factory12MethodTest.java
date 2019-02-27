package test.java;

import com.ssau.Pupil;
import com.ssau.Pupils;
import com.ssau.SchoolboyFactory;
import org.junit.jupiter.api.Test;

class Factory12MethodTest {

    @Test
    void TestClone(){

        Pupil original = Pupils.createInstance("StudentFactory",0);
        System.out.println(original.getClass() + " = " +original.getName());
        Pupils.setPupilFactory(new SchoolboyFactory());
        original = Pupils.createInstance("SchoolboyFactory",0);
        System.out.println(original.getClass() + " = " +original.getName());
    }
}
