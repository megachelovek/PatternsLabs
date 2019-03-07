package com.ssau;

public class StrategyArray implements Strategy{
    @Override
    public Pupil[] SortPupilRegisters(Pupil[] pupils) {
        return null;
    } //TODO сортировку через один метод не привязываться к регистрам \ полям студента

    @Override
    public Pupil[] SortPupilArray(Pupil[] pupils) {
        for (int i = 0; i < pupils.length; i++) {
            for (int j = 0; j < pupils.length - i - 1; j++) {
                if (pupils[j].getAverage() > pupils[j + 1].getAverage()) {
                    Pupil swapPupil = pupils[ j];
                    pupils[ j] = pupils[j + 1];
                    pupils[j + 1] = swapPupil;
                }
            }
        }
        return pupils;
    }

}