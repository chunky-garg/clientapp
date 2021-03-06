package com.wedding.app.client

import com.wedding.app.Wedding
import com.wedding.app.WeddingController
import grails.test.mixin.*
import spock.lang.*

@TestFor(WeddingController)
@Mock(Wedding)
class WeddingControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.weddingInstanceList
            model.weddingInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.weddingInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def wedding = new Wedding()
            wedding.validate()
            controller.save(wedding)

        then:"The create view is rendered again with the correct model"
            model.weddingInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            wedding = new Wedding(params)

            controller.save(wedding)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/wedding/show/1'
            controller.flash.message != null
            Wedding.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def wedding = new Wedding(params)
            controller.show(wedding)

        then:"A model is populated containing the domain instance"
            model.weddingInstance == wedding
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def wedding = new Wedding(params)
            controller.edit(wedding)

        then:"A model is populated containing the domain instance"
            model.weddingInstance == wedding
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def wedding = new Wedding()
            wedding.validate()
            controller.update(wedding)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.weddingInstance == wedding

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            wedding = new Wedding(params).save(flush: true)
            controller.update(wedding)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/wedding/show/$wedding.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            status == 404

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def wedding = new Wedding(params).save(flush: true)

        then:"It exists"
            Wedding.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(wedding)

        then:"The instance is deleted"
            Wedding.count() == 0
            response.redirectedUrl == '/wedding/index'
            flash.message != null
    }
}
