package com.wedding.common.location

class Address {

    String street

    Pincode pincode
    City city
    Country country


    static constraints = {
        street nullable: true
        pincode nullable: true
        city nullable: true
        country nullable: true
    }
}
