package com.ssau;

import java.io.FileWriter;
import java.io.IOException;

public class ChainResponsibilityString implements ChainResponsibility {
    ChainResponsibility next = null;
    @Override
    public void OutputStudent(Pupil pupil) {
        if (pupil.getLength() <=3){
            try(FileWriter writer = new FileWriter("TextChainResponsibility.txt", false))
            {
                String text = pupil.getName();
                for (int i=0; i<pupil.getLength();i++) {
                    text += " "+pupil.getSubject(i) +" "+ pupil.getMark(i);
                }
                writer.write(text);
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        else{
            this.GetNextMember(pupil);
        }
    }

    @Override
    public void GetNextMember(Pupil pupil) {
        this.next  = new ChainResponsibilityColumn();
        next.OutputStudent(pupil);
    }
}
