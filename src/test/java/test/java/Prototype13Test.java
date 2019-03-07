package test.java;

import com.ssau.Schoolboy;
import com.ssau.Student;
import org.junit.jupiter.api.Test;

class Prototype13Test {

    @Test
    void TestClone(){
        Student original = new Student("TestCloneStudentName",0);
        original.addSubjectAndMark("1TestSubj1",3);
        original.addSubjectAndMark("2TestSubj2",5);
        Student cloned = original.clone();
        System.out.println(original.toString());
        System.out.println("======");
        System.out.println(cloned.toString());
        System.out.println(original.getMark(1) +" | "+ cloned.getMark(1));

        System.out.println("=======================================");
        original.setSubject(0,"NONONO");
        original.setSubject(1,"NONONO");

        System.out.println(original.toString() );
        System.out.println("======");
        System.out.println(cloned.toString());
        System.out.println(original.getMark(1) +" | "+ cloned.getMark(1));
        System.out.println("########################################");

        Schoolboy originalSchoolboy = new Schoolboy("TestCloneSchoolboyName",0);
        originalSchoolboy.addSubjectAndMark("1TestSubj1",3);
        originalSchoolboy.addSubjectAndMark("2TestSubj2",5);
        Schoolboy clonedSchoolboy = originalSchoolboy.clone();
        System.out.println(originalSchoolboy.toString());
        System.out.println("======");
        System.out.println(clonedSchoolboy.toString());
        System.out.println(originalSchoolboy.getMark(1) +" | "+ cloned.getMark(1));

        System.out.println("=======================================");
        originalSchoolboy.setSubject(0,"nonono");
        originalSchoolboy.setSubject(1,"nonono");

        System.out.println(originalSchoolboy.toString() );
        System.out.println("======");
        System.out.println(clonedSchoolboy.toString());
        System.out.println(originalSchoolboy.getMark(1) +" | "+ clonedSchoolboy.getMark(1));
    }


}
