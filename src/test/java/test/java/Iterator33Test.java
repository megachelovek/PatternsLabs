package test.java;

import com.ssau.Schoolboy;
import org.junit.jupiter.api.Test;

class Iterator33Test {

    @Test
    void TestClone(){
        Schoolboy original = new Schoolboy("TestCloneStudentName",0);
        original.addSubjectAndMark("1TestSubj1",3);
        original.addSubjectAndMark("2TestSubj2",5);
        original.addSubjectAndMark("3TestSubj3",4);
        original.addSubjectAndMark("4TestSubj4",4);
        for (int i=0; i<original.getLength();i++){
            System.out.println("Iterator current = "+i+" subject = "+ original.getCurrent());
            original.nextRegister();
        }
    }
}
