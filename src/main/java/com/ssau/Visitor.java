package com.ssau;

public interface Visitor {
  String Visit(Student student);

  String Visit(Schoolboy schoolboy);
}
