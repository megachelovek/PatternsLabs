package com.ssau;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class ReaderDAOstandart implements DataDAO {
    @Override
    public Student[] GetStudentsFromFile(String path) {
        String result="";
        try(FileReader reader = new FileReader(path))
        {
            int c;
            while((c=reader.read())!=-1){
                result+=(char)c;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        Gson gson = new Gson();
        Student[] students = gson.fromJson(result,Student[].class);
        return students;
    }
}
