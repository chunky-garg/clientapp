package com.wedding.app.client


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WeddingController {

    def scaffold=true

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def view = {
        render view: 'view.gsp', model:[wedding:Wedding.list()[0]]
    }
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Wedding.list(params), model: [weddingInstanceCount: Wedding.count()]
    }

    def show(Wedding weddingInstance) {
        respond weddingInstance
    }

    def create() {
        respond new Wedding(params)
    }

    @Transactional
    def save(Wedding weddingInstance) {
        if (weddingInstance == null) {
            notFound()
            return
        }

        if (weddingInstance.hasErrors()) {
            respond weddingInstance.errors, view: 'create'
            return
        }

        weddingInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'weddingInstance.label', default: 'Wedding'), weddingInstance.id])
                redirect weddingInstance
            }
            '*' { respond weddingInstance, [status: CREATED] }
        }
    }

    def edit(Wedding weddingInstance) {
        respond weddingInstance
    }

    @Transactional
    def update(Wedding weddingInstance) {
        if (weddingInstance == null) {
            notFound()
            return
        }

        if (weddingInstance.hasErrors()) {
            respond weddingInstance.errors, view: 'edit'
            return
        }

        weddingInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Wedding.label', default: 'Wedding'), weddingInstance.id])
                redirect weddingInstance
            }
            '*' { respond weddingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Wedding weddingInstance) {

        if (weddingInstance == null) {
            notFound()
            return
        }

        weddingInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Wedding.label', default: 'Wedding'), weddingInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'weddingInstance.label', default: 'Wedding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
