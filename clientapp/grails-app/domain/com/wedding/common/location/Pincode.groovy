package com.wedding.common.location

class Pincode {

    String pincode

    static belongsTo = [city : City]

    static constraints = {
        pincode blank: false
    }

    public String toString() {
        pincode
    }
}
