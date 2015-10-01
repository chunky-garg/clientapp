package com.wedding.vendors


import grails.test.mixin.*
import spock.lang.*

@TestFor(VendorProfileController)
@Mock(VendorProfile)
class VendorProfileControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.vendorProfileInstanceList
        model.vendorProfileInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.vendorProfileInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        def vendorProfile = new VendorProfile()
        vendorProfile.validate()
        controller.save(vendorProfile)

        then: "The create view is rendered again with the correct model"
        model.vendorProfileInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        vendorProfile = new VendorProfile(params)

        controller.save(vendorProfile)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/vendorProfile/show/1'
        controller.flash.message != null
        VendorProfile.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def vendorProfile = new VendorProfile(params)
        controller.show(vendorProfile)

        then: "A model is populated containing the domain instance"
        model.vendorProfileInstance == vendorProfile
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def vendorProfile = new VendorProfile(params)
        controller.edit(vendorProfile)

        then: "A model is populated containing the domain instance"
        model.vendorProfileInstance == vendorProfile
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        controller.update(null)

        then: "A 404 error is returned"
        status == 404

        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def vendorProfile = new VendorProfile()
        vendorProfile.validate()
        controller.update(vendorProfile)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.vendorProfileInstance == vendorProfile

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        vendorProfile = new VendorProfile(params).save(flush: true)
        controller.update(vendorProfile)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/vendorProfile/show/$vendorProfile.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        controller.delete(null)

        then: "A 404 is returned"
        status == 404

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def vendorProfile = new VendorProfile(params).save(flush: true)

        then: "It exists"
        VendorProfile.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(vendorProfile)

        then: "The instance is deleted"
        VendorProfile.count() == 0
        response.redirectedUrl == '/vendorProfile/index'
        flash.message != null
    }
}
