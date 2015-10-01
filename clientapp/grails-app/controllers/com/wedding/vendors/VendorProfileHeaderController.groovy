package com.wedding.vendors



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VendorProfileHeaderController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VendorProfileHeader.list(params), model:[vendorProfileHeaderInstanceCount: VendorProfileHeader.count()]
    }

    def show(VendorProfileHeader vendorProfileHeaderInstance) {
        respond vendorProfileHeaderInstance
    }

    def create() {
        respond new VendorProfileHeader(params)
    }

    @Transactional
    def save(VendorProfileHeader vendorProfileHeaderInstance) {
        if (vendorProfileHeaderInstance == null) {
            notFound()
            return
        }

        if (vendorProfileHeaderInstance.hasErrors()) {
            respond vendorProfileHeaderInstance.errors, view:'create'
            return
        }

        vendorProfileHeaderInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorProfileHeaderInstance.label', default: 'VendorProfileHeader'), vendorProfileHeaderInstance.id])
                redirect vendorProfileHeaderInstance
            }
            '*' { respond vendorProfileHeaderInstance, [status: CREATED] }
        }
    }

    def edit(VendorProfileHeader vendorProfileHeaderInstance) {
        respond vendorProfileHeaderInstance
    }

    @Transactional
    def update(VendorProfileHeader vendorProfileHeaderInstance) {
        if (vendorProfileHeaderInstance == null) {
            notFound()
            return
        }

        if (vendorProfileHeaderInstance.hasErrors()) {
            respond vendorProfileHeaderInstance.errors, view:'edit'
            return
        }

        vendorProfileHeaderInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'VendorProfileHeader.label', default: 'VendorProfileHeader'), vendorProfileHeaderInstance.id])
                redirect vendorProfileHeaderInstance
            }
            '*'{ respond vendorProfileHeaderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(VendorProfileHeader vendorProfileHeaderInstance) {

        if (vendorProfileHeaderInstance == null) {
            notFound()
            return
        }

        vendorProfileHeaderInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'VendorProfileHeader.label', default: 'VendorProfileHeader'), vendorProfileHeaderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorProfileHeaderInstance.label', default: 'VendorProfileHeader'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
