package com.wedding.vendors

class VendorProfileHeader {

    String header
    VendorType type

    static hasMany = [
            categories : Category
    ]

    static constraints = {
        header nullable: false
        type nullable: true
    }
}
