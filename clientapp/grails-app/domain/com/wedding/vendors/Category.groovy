package com.wedding.vendors

import com.wedding.CategoryType

class Category {

    String name
    String code

    String type

    static hasMany = [
           vendorTypes :VendorType
    ]

    static constraints = {
        type inList: [CategoryType.TEXT, CategoryType.CHECKBOX, CategoryType.RADIO, CategoryType.DROPDOWN]
    }
}
