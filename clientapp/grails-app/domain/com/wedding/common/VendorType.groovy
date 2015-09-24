package com.wedding.common

class VendorType {

    String name;
    String code;

    static constraints = {
        code blank: false, unique: true
        name blank: false
    }

    static hasMany = [
            vendors: Vendor
    ]

    public String toString() {
        "Name :" + name +", Code : " + code
    }
}
