package demo.grails.vuejs.sm

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Mst_projectController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mst_project.list(params), model:[mst_projectCount: Mst_project.count()]
    }

    def show(Mst_project mst_project) {
        respond mst_project
    }

    def create() {
        respond new Mst_project(params)
    }

    @Transactional
    def save(Mst_project mst_project) {
        if (mst_project == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (mst_project.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mst_project.errors, view:'create'
            return
        }

        mst_project.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mst_project.label', default: 'Mst_project'), mst_project.id])
                redirect mst_project
            }
            '*' { respond mst_project, [status: CREATED] }
        }
    }

    def edit(Mst_project mst_project) {
        respond mst_project
    }

    @Transactional
    def update(Mst_project mst_project) {
        if (mst_project == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (mst_project.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mst_project.errors, view:'edit'
            return
        }

        mst_project.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mst_project.label', default: 'Mst_project'), mst_project.id])
                redirect mst_project
            }
            '*'{ respond mst_project, [status: OK] }
        }
    }

    @Transactional
    def delete(Mst_project mst_project) {

        if (mst_project == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        mst_project.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mst_project.label', default: 'Mst_project'), mst_project.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mst_project.label', default: 'Mst_project'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
