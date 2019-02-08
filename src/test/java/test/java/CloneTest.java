package test.java;

import com.ssau.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CloneTest {

    @Test
    void TestClone(){
        Student original = new Student("TestCloneStudentName",2);
        original.addSubjectAndMark("1TestSubj1",3);
        original.addSubjectAndMark("2TestSubj2",5);
        Student cloned = original.clone();

        System.out.println(original.toString());
        System.out.println(cloned.toString());
        System.out.println(original.getMark(1) +" | "+ cloned.getMark(1));
        // deep check
        Assertions.assertEquals(original.getMark(2), cloned.getMark(2));
        Assertions.assertEquals(original.getSubject(1), cloned.getSubject(1));
        Assertions.assertNotSame(original.getMark(1), cloned.getMark(1));
        Assertions.assertNotSame(original.getSubject(2), cloned.getSubject(2));

        // shallow check
        Assertions.assertSame(original.getLength(), cloned.getLength());
    }
}
