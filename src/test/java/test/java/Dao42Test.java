package test.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssau.DataDAO;
import com.ssau.ReaderDAOserializable;
import com.ssau.ReaderDAOstandart;
import com.ssau.Student;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dao42Test {
    @Test
    public void TestDAO() throws IOException, DecoderException, ClassNotFoundException {
        PrintWriter clean = new PrintWriter("TextDAOstudentsStandart.txt");
        clean.print("");
        clean.close();
        PrintWriter clean2 = new PrintWriter("TextDAOstudentsSerializable.txt");
        clean.print("");
        clean.close();

        Student firstStudent = new Student("1standart1",0);
        firstStudent.addSubjectAndMark("1subj1",1);
        firstStudent.addSubjectAndMark("2subj2",1);
        Student secondStudent = new Student("2standart2",0);
        secondStudent.addSubjectAndMark("1subj1",2);
        secondStudent.addSubjectAndMark("2subj2",2);
        List<Student> studentsStandart = new ArrayList<Student>();
        studentsStandart.add(firstStudent);
        studentsStandart.add(secondStudent);

        Student thirdStudent = new Student("1serializable1",0);
        thirdStudent.addSubjectAndMark("1subj1",3);
        thirdStudent.addSubjectAndMark("2subj2",3);
        Student fourthStudent = new Student("2serializable2",0);
        fourthStudent.addSubjectAndMark("1subj1",4);
        fourthStudent.addSubjectAndMark("2subj2",4);
        List<Student> studentsSerializable = new ArrayList<Student>();
        studentsSerializable.add(thirdStudent);
        studentsSerializable.add(fourthStudent);

        WriteStandartStudentsToFile("TextDAOstudentsStandart.txt",studentsStandart);
        WriteSerializableStudentsToFile("TextDAOstudentsSerializable.txt",studentsSerializable);

        DataDAO serializableDAO = new ReaderDAOserializable();
        DataDAO standartDAO = new ReaderDAOstandart();

        List<Student> standart = standartDAO.GetStudentsFromFile("TextDAOstudentsStandart.txt");
        List<Student> serializable = serializableDAO.GetStudentsFromFile("TextDAOstudentsSerializable.txt");

        for (int i=0;i<standart.size();i++){
            System.out.println(standart.get(i).toString());
        }

        System.out.println("=========");

        for (int i=0;i<serializable.size();i++){
            int[] marks = serializable.get(i).getMarks();
            System.out.println(specText(serializable.get(i),marks));
        }
    }

    private void WriteSerializableStudentsToFile(String path, List<Student> students){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(students);
            System.out.println("Students standart has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void WriteStandartStudentsToFile (String path, List<Student> studentsArray){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String students = gson.toJson(studentsArray,ArrayList.class);
        try(FileWriter writer = new FileWriter(path, false))
        {
            writer.write(students);
            writer.flush();
            System.out.println("Students serializable has been written");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private String specText(Student st,int[] marks){
        StringBuffer s = new StringBuffer();
        s.append(st.getName());
        s.append(" ");
        s.append(st.getLength());
        for (int i=0;i<st.getLength();i++)
        {
            s.append("\n");
            s.append(st.getSubject(i));
            s.append(" ");
            s.append(marks[i]);
        }
        return s.toString();
    }
}
