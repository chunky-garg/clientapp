package com.wedding.common.location

class Country {

    String name
    String code

    static hasMany = [cities : City]

    static constraints = {
        name blank:false
        code blank: false, unique: true
    }

    public String toString() {
        name
    }
}
