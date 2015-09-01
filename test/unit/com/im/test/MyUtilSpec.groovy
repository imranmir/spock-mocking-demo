package com.im.test

import spock.lang.Specification


class MyUtilSpec extends Specification {

    void "Spy use case"() {

        given: "My Util Spy"
        MyUtil myUtil = Spy(MyUtil)

        and: "Stub complex calculation method to return a dummy value"
        1 * myUtil.someComplexCalculation() >> 200

        expect:
        myUtil.metaProgrammingUseCaseMethod() == "400"
    }
}
