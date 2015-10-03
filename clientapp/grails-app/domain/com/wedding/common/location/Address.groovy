package com.wedding.common.location

class Address {

    String street

    Pincode pincode
    City city
    Country country

    String image


    static constraints = {
        street nullable: true
        pincode nullable: true
        city nullable: true
        country nullable: true
        image nullable : true
    }
}
