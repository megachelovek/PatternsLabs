package test.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssau.*;
import org.apache.commons.codec.DecoderException;
import org.junit.jupiter.api.Test;

import java.io.*;

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
        Student[] studentsStandart = new Student[]{firstStudent,secondStudent};

        Student thirdStudent = new Student("1serializable1",0);
        thirdStudent.addSubjectAndMark("1subj1",3);
        thirdStudent.addSubjectAndMark("2subj2",3);
        Student fourthStudent = new Student("2serializable2",0);
        fourthStudent.addSubjectAndMark("1subj1",4);
        fourthStudent.addSubjectAndMark("2subj2",4);
        Student[] studentsSerializable = new Student[]{thirdStudent,fourthStudent};

        WriteStandartStudentsToFile("TextDAOstudentsStandart.txt",studentsStandart);
        WriteSerializableStudentsToFile("TextDAOstudentsSerializable.txt",studentsSerializable);

        DataDAO serializableDAO = new ReaderDAOserializable();
        DataDAO standartDAO = new ReaderDAOstandart();

        Student[] standart = standartDAO.GetStudentsFromFile("TextDAOstudentsStandart.txt");
        Student[] serializable = serializableDAO.GetStudentsFromFile("TextDAOstudentsSerializable.txt");

        System.out.println(standart);
        System.out.println("=========");
        System.out.println(serializable);
    }

    private void WriteSerializableStudentsToFile(String path, Student[] students){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(students);
            System.out.println("Students standart has been written");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void WriteStandartStudentsToFile (String path, Student[] studentsArray){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Student[].class, new InterfaceAdapter());
        Gson gson = builder.create();
        String students = gson.toJson(studentsArray,Student[].class);
        try(FileWriter writer = new FileWriter(path, false))
        {
            writer.write(students);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
