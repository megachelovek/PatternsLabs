package com.ssau;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Schoolboy implements Pupil
{
    protected static class Register implements Serializable,Cloneable
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

        @Override
        public String toString()
        {
            StringBuffer s = new StringBuffer();
            s.append(this.name);
            s.append(" | ");
            s.append(this.mark);
            return s.toString();
        }
    }

    protected class SchoolboyIterator implements Iterator {
        private int current;
        private Register[] registers;

        SchoolboyIterator(Register[] reg){
            this.registers = reg;
            current = 0;
        }

        @Override
        public boolean hasNext() {
            if (current+1<registers.length){return true;}
            return false;
        }

        @Override
        public Register next() {
            if (hasNext()) {
                current++;
                return registers[current];
            }
            return registers[current];
        }

        public void onStart() {
            current = 0;
        }

        public int getCurrentNumber() {
           return current;
        }

        public Register getCurrent() {
            return registers[current];
        }
    }

    ///  \/ Schoolboy class \/
    private String name;
    private Register[] registers;
    private SchoolboyIterator iterator;

    public Schoolboy(String n, int reg)
    {
        name=n;
        this.registers = new Register[reg];
        this.iterator = new SchoolboyIterator(registers);

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
        newRegisters[newRegisters.length-1] = new Register(subj,m);
        this.registers = newRegisters;
        iterator.registers = newRegisters;
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
        result = 31 * result + (registers != null ? Arrays.hashCode(registers) : 0);
        return result;
    }

    @Override
    public Schoolboy clone()
    {
        Schoolboy clone;
        try
        {
            clone = (Schoolboy)super.clone();
            clone.registers=this.registers.clone();
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

    public SchoolboyIterator iterator(){
        return this.iterator;
    }

    public Register getCurrent(){
        return this.iterator.getCurrent();
    }
    public void nextRegister(){
        this.iterator.next();
    }
}
