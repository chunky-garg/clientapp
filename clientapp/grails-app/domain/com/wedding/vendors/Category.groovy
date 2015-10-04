package com.wedding.vendors

import com.wedding.CategoryType
import com.wedding.ProfileHeader

class Category {

    String name
    String code

    CategoryType type
    ProfileHeader header

    static belongsTo = [
            header: ProfileHeader
    ]

    static hasMany = [
            serviceCategories: ServiceCategory
    ]

    static constraints = {
        name blank: false
        code blank: false, unique: true
        type inList: [CategoryType.TEXT, CategoryType.CHECKBOX, CategoryType.RADIO, CategoryType.DROPDOWN]
        header inList: ProfileHeader.values().toList()

    }

    @Override
    public String toString() {
           name
    }
}
