package com.ssau;

public class StrategyRegisters implements Strategy {

    @Override
    public Pupil[] SortPupilArray(Pupil[] pupils) {
        return null;
    }

    @Override
    public Pupil[] SortPupilRegisters(Pupil[] pupils) {
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
