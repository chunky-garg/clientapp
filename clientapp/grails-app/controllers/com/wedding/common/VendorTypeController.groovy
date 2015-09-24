package com.wedding.common



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VendorTypeController {

    def scaffold = true
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VendorType.list(params), model:[vendorTypeInstanceCount: VendorType.count()]
    }

    def show(VendorType vendorTypeInstance) {
        respond vendorTypeInstance
    }

    def create() {
        respond new VendorType(params)
    }

    @Transactional
    def save(VendorType vendorTypeInstance) {
        if (vendorTypeInstance == null) {
            notFound()
            return
        }

        if (vendorTypeInstance.hasErrors()) {
            respond vendorTypeInstance.errors, view:'create'
            return
        }

        vendorTypeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorTypeInstance.label', default: 'VendorType'), vendorTypeInstance.id])
                redirect vendorTypeInstance
            }
            '*' { respond vendorTypeInstance, [status: CREATED] }
        }
    }

    def edit(VendorType vendorTypeInstance) {
        respond vendorTypeInstance
    }

    @Transactional
    def update(VendorType vendorTypeInstance) {
        if (vendorTypeInstance == null) {
            notFound()
            return
        }

        if (vendorTypeInstance.hasErrors()) {
            respond vendorTypeInstance.errors, view:'edit'
            return
        }

        vendorTypeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'VendorType.label', default: 'VendorType'), vendorTypeInstance.id])
                redirect vendorTypeInstance
            }
            '*'{ respond vendorTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(VendorType vendorTypeInstance) {

        if (vendorTypeInstance == null) {
            notFound()
            return
        }

        vendorTypeInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'VendorType.label', default: 'VendorType'), vendorTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorTypeInstance.label', default: 'VendorType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
