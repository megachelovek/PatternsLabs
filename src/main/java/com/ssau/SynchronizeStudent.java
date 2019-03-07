package com.ssau;

public class SynchronizeStudent implements Pupil{
  // TODO
  //Объявить Pupil вызвать у него все методы через синхронайзд

  private Pupil pupil;

  public  SynchronizeStudent (Pupil n)
  {
    this.pupil = n;
  }


  public synchronized  void setName(String n)
  {
    pupil.setName(n);
  }


  public synchronized  String getName()
  {
    return pupil.getName();
  }


  public synchronized  void setMark(int n, int mark)
  {
    pupil.setMark(n,mark);
  }


  public synchronized  int getMark(int n)
  {
    return pupil.getMark(n);
  }


  public synchronized  void setSubject(int n, String subj)
  {
    pupil.setSubject(n,subj);
  }


  public synchronized  String getSubject(int n)
  {
   return pupil.getSubject(n);
  }


  public synchronized  void addSubjectAndMark(String subj,int m)
  {
   pupil.addSubjectAndMark(subj,m);
  }


  public synchronized  int getLength()
  {
    return pupil.getLength();
  }


  @Override
  public synchronized  String toString()
  {
    return pupil.toString();
  }

  @Override
  public synchronized  boolean equals(Object obj)
  {
    return pupil.equals(obj);
  }

  @Override
  public synchronized  int hashCode()
  {
   return pupil.hashCode();
  }

  @Override
  public synchronized Object clone()
  {
    return pupil.clone();
  }

  @Override
  public synchronized String[] getSubjects()
  {
    return pupil.getSubjects();
  }

  @Override
  public synchronized double getAverage() {
    return 0;
  }


}
