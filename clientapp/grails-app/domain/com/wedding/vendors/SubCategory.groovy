package com.wedding.vendors

class SubCategory {

    String name
    String code

    static belongsTo = [
            category : Category
    ]

    static constraints = {
        name blank: false
        code blank: false, unique: true
    }

    @Override
    public String toString() {
        name
    }
}
