package com.ssau;

import java.io.FileWriter;

public interface Command {
    void PrintInFile(FileWriter fileWriter, Pupil pupil);
}
