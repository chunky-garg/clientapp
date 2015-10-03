package com.wedding.app

class Storyline {

    String title
    String content
    Date storyDate

    static belongsTo = [
            story: WeddingStory
    ]

    static constraints = {
        title blank: false
        content blank: false
        storyDate nullable: false
    }

    public String toString(){
        title
    }
}
