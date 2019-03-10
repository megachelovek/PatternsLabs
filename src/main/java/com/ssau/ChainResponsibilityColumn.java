package com.ssau;

import java.io.FileWriter;
import java.io.IOException;

public class ChainResponsibilityColumn implements ChainResponsibility{
    ChainResponsibility next = null;
    @Override
    public void OutputStudent(Pupil pupil) {
        if (pupil.getLength() >3){
            try(FileWriter writer = new FileWriter("TextChainResponsibility.txt", false))
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
        else{
            this.GetNextMember(pupil); // сделать поле типа ChainResponsibility, присваиваю null,
        }
    }

    @Override
    public void GetNextMember(Pupil pupil) {
        this.next  = null;
    }
}
