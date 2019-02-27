package com.ssau;

import java.io.FileWriter;
import java.io.IOException;

public class CommandWriterColumn implements Command {
    @Override
    public void PrintInFile(FileWriter fileWriter, Pupil pupil){
        try(FileWriter writer = fileWriter)
        {
            String text = "";
            for (String subj: pupil.getSubjects()) {
                text += subj +"\n";
            }
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
