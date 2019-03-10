package com.ssau;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class CommandWriterColumn implements Command, Serializable {
    @Override
    public void PrintInFile(FileWriter fileWriter, Pupil pupil){ // оценки фамилия пердмет
        try(FileWriter writer = fileWriter)
        {
            String text = pupil.getName()+"\n";
            for (int i=0; i<pupil.getLength();i++) {
                text += pupil.getSubject(i) +" "+ pupil.getMark(i) +"\n";
            }
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
