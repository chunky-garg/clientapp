package com.wedding.common.location

class City {

    String name

    static belongsTo = [country : Country]

    static hasMany = [pincodes : Pincode]

    static constraints = {
        name blank: false
    }

    public String toString() {
        return name
    }
}
