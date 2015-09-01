package com.im.test

import grails.transaction.Transactional

@Transactional
class OtherService {

    void method(String s){
        // Some logic here
    }

    String methodReturningValue(Integer someNumber){
       return "odd"
    }

}
