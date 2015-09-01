package com.im.test

import grails.transaction.Transactional

@Transactional
class MyService {

    def otherService

    String mockUseCaseMethod() {
        //Some calculations go here
        otherService.method("arg")
    }

    String stubUseCaseMethod(Integer someNumber) {
        String result
        String val = otherService.methodReturningValue(someNumber)

        if (val == "odd") {
            result = "Yes"
        } else {
            result = "No"
        }
        return result
    }


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
