package com.ssau;

import java.util.List;

public interface DataDAO{
    List<Student> GetStudentsFromFile(String path);
}
