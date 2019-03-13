package com.ssau;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOserializable implements DataDAO {
    @Override
    public List<Student> GetStudentsFromFile(String path) {
        List<Student> students = null;
        List<Student> newStudents = new ArrayList<Student>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            students= (ArrayList<Student>) ois.readObject();
        }
        catch(Exception ex){
        }

        for (int i = 0; i <students.size(); i++)
        {
            int[] tt = students.get(i).getMarks();
            Student tempStudent = new Student(students.get(i).getName(), 0);
            for (int j = 0; j < students.get(i).getLength(); j++) {
                tempStudent.addSubjectAndMark(students.get(i).getSubject(j),tt[i]);
            }
            newStudents.add(tempStudent);
        }

        return newStudents;
    }
}
