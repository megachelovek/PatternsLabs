package com.ssau;

public class StudentFactory implements PupilFactory{

    public Pupil createInstance(String name, int size){
         return new Student(name, size);
    }

}
