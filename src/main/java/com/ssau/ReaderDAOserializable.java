package com.ssau;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOserializable implements DataDAO {
    @Override
    public List<Student> GetStudentsFromFile(String path) {
        List<Student> students = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path)))
        {
            students= (ArrayList<Student>) ois.readObject();
        }
        catch(Exception ex){
        }

        return students;
    }
}
