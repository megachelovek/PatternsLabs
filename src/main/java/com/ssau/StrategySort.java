package com.ssau;

public class StrategySort implements Strategy {

    @Override
    public Pupil[] SortPupil(Pupil[] pupils) {
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
