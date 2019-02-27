package com.ssau;

public class SchoolboyFactory implements PupilFactory{

    public Pupil createInstance(String name, int size){
         return new Schoolboy(name, size);
    }

}
