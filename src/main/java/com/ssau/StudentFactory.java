package com.ssau;

public class StudentFactory implements PupilFactory{
    private String name;
    private int[] marks;
    private String[] subjects;

    public Pupil createInstance(String name, int size){
         return new Student(name, size);
    }

}
