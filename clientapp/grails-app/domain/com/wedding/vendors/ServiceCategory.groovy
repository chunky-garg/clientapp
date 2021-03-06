package com.wedding.vendors

class ServiceCategory {

    String name;
    String code;

    static constraints = {
        code blank: false, unique: true
        name blank: false
    }

    static hasMany = [
            vendors: VendorService
    ]

    @Override
    public String toString() {
        name
    }
}
