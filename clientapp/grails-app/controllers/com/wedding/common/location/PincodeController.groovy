package com.wedding.common.location



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PincodeController {

    def scaffold = true

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pincode.list(params), model:[pincodeInstanceCount: Pincode.count()]
    }

    def show(Pincode pincodeInstance) {
        respond pincodeInstance
    }

    def create() {
        respond new Pincode(params)
    }

    @Transactional
    def save(Pincode pincodeInstance) {
        if (pincodeInstance == null) {
            notFound()
            return
        }

        if (pincodeInstance.hasErrors()) {
            respond pincodeInstance.errors, view:'create'
            return
        }

        pincodeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'pincodeInstance.label', default: 'Pincode'), pincodeInstance.id])
                redirect pincodeInstance
            }
            '*' { respond pincodeInstance, [status: CREATED] }
        }
    }

    def edit(Pincode pincodeInstance) {
        respond pincodeInstance
    }

    @Transactional
    def update(Pincode pincodeInstance) {
        if (pincodeInstance == null) {
            notFound()
            return
        }

        if (pincodeInstance.hasErrors()) {
            respond pincodeInstance.errors, view:'edit'
            return
        }

        pincodeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Pincode.label', default: 'Pincode'), pincodeInstance.id])
                redirect pincodeInstance
            }
            '*'{ respond pincodeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Pincode pincodeInstance) {

        if (pincodeInstance == null) {
            notFound()
            return
        }

        pincodeInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Pincode.label', default: 'Pincode'), pincodeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pincodeInstance.label', default: 'Pincode'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
