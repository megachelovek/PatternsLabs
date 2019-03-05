package com.ssau;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReaderDAOserializable implements DataDAO {
    @Override
    public Student[] GetStudentsFromFile(String path) {
        Student[] students = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            students=((Student[])ois.readObject());
        }
        catch(Exception ex){
        }
        return students;
    }
}
