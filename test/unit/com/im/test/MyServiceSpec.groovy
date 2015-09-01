package com.im.test

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification
import spock.util.mop.ConfineMetaClassChanges


@TestFor(MyService)
@Mock(User)
class MyServiceSpec extends Specification {

    def setup(){
        service.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
    }

    void "Use case for mocking"() {

        given: "OtherService as a mock"
        def otherService = Mock(OtherService)

        and: "Initialize my service with other service mock"
        service.otherService = otherService

        when: "Call the method to be tested"
        service.mockUseCaseMethod()

        then: "Make sure otherService method is called with the specific arguments"
        1 * otherService.method("arg")
    }


    void "Use case for stubbing"() {

        given: "OtherService as a mock"
        def otherService = Mock(OtherService)

        and: "Initialize my service with other service mock"
        service.otherService = otherService
        1 * otherService.methodReturningValue(1) >> oddOrEven

        when: "Call the method to be tested"
        String result = service.stubUseCaseMethod(1)

        then:
        result == expectedResult

        where:
        oddOrEven | expectedResult
        "odd"     | "Yes"
        "even"    | "No"
    }


    @ConfineMetaClassChanges(User)
    void "Meta programming use case"() {
        User.metaClass.getSomeVal = {-> return 1000}
        given: "Stubbed complex method"
        service.metaClass.someComplexCalculation = {-> return 300}

        when:
        String result = service.metaProgrammingUseCaseMethod()

        then:
        result == "600"
    }


//    void "Meta programming use case"() {
//        given:
//        MyService myService = Spy(MyService)
////        MyService myService = new MyService()
//        and:
//        1 * myService.someComplexCalculation() >> 200
//        expect:
//        myService.metaProgrammingUseCaseMethod() == "400"
//
//    }




}
