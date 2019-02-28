package com.ssau;

import static java.util.Arrays.swap;

public class StrategyArray implements Strategy{
    @Override
    public Pupil[] SortPupilRegisters(Pupil[] pupils) {
        return null;
    }

    @Override
    public Pupil[] SortPupilArray(Pupil[] pupils) {
        for (int i = 0; i < pupils.length; i++)
            for (int j = 0; j < pupils.length-i-1; j++)
                if (pupils[j].getAverage() > pupils[j +1].getAverage())
                    swap(pupils, j, j +1);
    }

}