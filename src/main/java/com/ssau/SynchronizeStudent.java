package com.ssau;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchronizeStudent implements Pupil{

  private String name;
  private int[] marks;
  private String[] subjects;

  public  SynchronizeStudent (String n,int k)
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


  public synchronized  void setName(String n)
  {
    name=n;
  }


  public synchronized  String getName()
  {
    return name;
  }


  public synchronized  void setMark(int n, int mark)
  {
    if (mark>1&&mark<6)
    {
      marks[n]=mark;
    }
  }


  public synchronized  int getMark(int n)
  {
    return marks[n];
  }


  public synchronized  void setSubject(int n, String subj)
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


  public synchronized  String getSubject(int n)
  {
    if (n>=0&&n<subjects.length)
    {
      return subjects[n];
    }
    return "";
  }


  public synchronized  void addSubjectAndMark(String subj,int m)
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


  public synchronized  int getLength()
  {
    return marks.length;
  }


  @Override
  public synchronized  String toString()
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
  public synchronized  boolean equals(Object obj)
  {
    if (obj==null) return false;
    if (obj==this) return true;
    return false;
  }

  @Override
  public synchronized  int hashCode()
  {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (marks != null ? Arrays.hashCode(marks) : 0);
    result = 31 * result + (subjects != null ? Arrays.hashCode(subjects) : 0);
    return result;
  }

  @Override
  public synchronized SynchronizeStudent clone()
  {
    SynchronizeStudent clone;
    try
    {
      clone = (SynchronizeStudent)super.clone();
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

  @Override
  public String[] getSubjects()
  {
    return this.subjects;
  }


}
