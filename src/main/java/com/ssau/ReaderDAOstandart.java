package com.ssau;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOstandart implements DataDAO {
    @Override
    public List<Student> GetStudentsFromFile(String path) {
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
        List<Student> newStudents = new ArrayList<Student>();
        result = "{students:"+result+'}';
        JSONObject obj = new JSONObject(result);
        JSONArray arr = obj.getJSONArray("students");
        for (int i = 0; i < arr.length(); i++)
        {
            JSONArray marks = arr.getJSONObject(i).getJSONArray("marks");
            JSONArray subjects =  arr.getJSONObject(i).getJSONArray("subjects");
            Student tempStudent = new Student(arr.getJSONObject(i).getString("name"), 0);
            for (int j = 0; j < marks.length(); j++) {
                tempStudent.addSubjectAndMark(subjects.getString(j),marks.getInt(j));
            }
            newStudents.add(tempStudent);
        }
        return newStudents;
    }
}
