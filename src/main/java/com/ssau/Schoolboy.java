package com.ssau;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Schoolboy implements Pupil
{
    private class Register implements Serializable,Cloneable
    {
        private String name;
        private int mark;

        public Register()
        {
            name="";
            mark=0;
        }

        public Register(String name, int k) {
            this.name=name;
            mark=k;
        }
        public void SetMarkRegister(int mark) {
            this.mark=mark;
        }
        public void SetSubjectRegister(String name) {
        this.name=name;
    }
        @Override
        public int hashCode()
        {
            int result=mark;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Register other = (Register) obj;
            if (!Objects.equals(this.name, other.name)) {
                return false;
            }
            return this.mark == other.mark;
        }

        @Override
        public Object clone() throws CloneNotSupportedException
        {
            return (Register)super.clone();
        }
    }

    private String name;
    private Register registers[];

    public Schoolboy(String n, Register[] reg)
    {
        name=n;
        registers = reg;
    }


    public void setName(String n)
    {
        name=n;
    }


    public String getName()
    {
        return name;
    }


    public void setMark(int n, int mark)
    {
       registers[n].SetMarkRegister(mark);
    }


    public int getMark(int n)
    {
        return  registers[n].mark;
    }


    public void setSubject(int n, String subj)
    {
        registers[n].SetSubjectRegister(subj);
    }


    public String getSubject(int n)
    {
            return registers[n].name;
    }

    public Register[] getRegisters()
    {
        return this.registers;
    }


    public void addSubjectAndMark(String subj,int m)
    {
        Register[] newRegisters = new Register[registers.length +1];
        for (int i=0; i< registers.length; i++ )
        {
            newRegisters[i] = registers[i];
        }
        newRegisters[registers.length +1] = new Register(subj,m);
    }


    public int getLength()
    {
        return registers.length;
    }


    @Override
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append(this.getName());
        s.append(" ");
        s.append(this.getLength());
        for (int i=0;i<this.getLength();i++)
        {
            s.append("\n");
            s.append(this.getSubject(i));
            s.append(" ");
            s.append(this.getMark(i));
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj==null) return false;
        if (obj==this) return true;
       return false;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (marks != null ? Arrays.hashCode(marks) : 0);
        result = 31 * result + (subjects != null ? Arrays.hashCode(subjects) : 0);
        return result;
    }

    @Override
    public Schoolboy clone()
    {
        Schoolboy clone;
        try
        {
            clone = (Schoolboy)super.clone();
            clone.marks=this.marks.clone();
            clone.subjects=this.subjects.clone();
            return clone;
        }
        catch (CloneNotSupportedException ex)
        {
            Logger.getLogger(Schoolboy.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String[] getSubjects() {
        String[] subjects = new String[registers.length];
        for (int i =0; i< registers.length; i++){
            subjects[i] = registers[i].name;
        }
        return subjects;
    }
}
