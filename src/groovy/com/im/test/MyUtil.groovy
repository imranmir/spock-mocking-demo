package com.im.test


class MyUtil {

    String metaProgrammingUseCaseMethod() {
        //Some calculations
        Integer val = someComplexCalculation()

        return (val * 2)
    }

    Integer someComplexCalculation() {
        //someComplexCalculation
        return 100
    }
}
