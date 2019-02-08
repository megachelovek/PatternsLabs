package com.ssau;

import java.io.Serializable;

public interface Pupil extends Serializable,Cloneable
{
    void setName(String name);
    String getName();
    void setMark(int n, int mark);
    void setSubject(int n, String name);
    int getLength();
    int getMark(int n);
    String getSubject(int n);
    void addSubjectAndMark(String subj, int m);
    Object clone();
}