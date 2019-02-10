package com.ssau;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements Pupil
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
    private int[] marks;
    private String[] subjects;

    public Student(String n,int k)
    {
        name=n;
        marks=new int[k];
        subjects=new String[k];
        for (int i=0;i<k;i++)
        {
            marks[i]=0;
            subjects[i]="";
        }
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
        if (mark>1&&mark<6)
        {
            marks[n]=mark;
        }
    }


    public int getMark(int n)
    {
        return marks[n];
    }


    public void setSubject(int n, String subj)
    {
        for (String subject : subjects)
        {
            if (subject.equals(subj))
            {

            }
        }
        if (n>=0&&n<subjects.length)
        {
            subjects[n]=subj;
        }
    }


    public String getSubject(int n)
    {
        if (n>=0&&n<subjects.length)
        {
            return subjects[n];
        }
        return "";
    }


    public void addSubjectAndMark(String subj,int m)
    {
        if (m>1&&m<6)
        {
            for (String subject : subjects)
            {
                if (subject.equals(subj))
                {

                }
            }
            marks = Arrays.copyOf(marks, marks.length+1);
            subjects = Arrays.copyOf(subjects, subjects.length+1);
            marks[marks.length-1]=m;
            subjects[subjects.length-1]=subj;
        }
    }


    public int getLength()
    {
        return marks.length;
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
    public Student clone()
    {
        Student clone;
        try
        {
            clone = (Student)super.clone();
            System.arraycopy(this.marks ,0 ,clone.marks ,0 ,this.marks.length);
            System.arraycopy(this.subjects ,0 ,clone.subjects ,0 ,this.subjects.length);
            return clone;
        }
        catch (CloneNotSupportedException ex)
        {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /*
    public static int[] deepCopyIntArray(int[] original) {
        if (original == null) {
            return null;
        }

        final int[] result = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone;
        }
        return result;
    }
    public static String[] deepCopyStringArray(boolean[][] original) {
        if (original == null) {
            return null;
        }

        final boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
    */
}
