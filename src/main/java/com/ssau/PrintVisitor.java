package com.ssau;

public class PrintVisitor implements Visitor {
  @Override
  public String Visit(Student student) {
    String text = student.getName();
    for (int i=0; i<student.getLength();i++) {
      text += " "+student.getSubject(i) +" "+ student.getMark(i);
    }
    return text;
  }

  @Override
  public String Visit(Schoolboy schoolboy) {
    String text = schoolboy.getName()+"\n";
    for (int i=0; i<schoolboy.getLength();i++) {
      text += schoolboy.getSubject(i) +" "+ schoolboy.getMark(i) +"\n";
    }
    return text;
  }
}
