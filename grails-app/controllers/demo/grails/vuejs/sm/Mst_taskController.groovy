package demo.grails.vuejs.sm

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Mst_taskController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mst_task.list(params), model:[mst_taskCount: Mst_task.count()]
    }

    def show(Mst_task mst_task) {
        respond mst_task
    }

    def create() {
        respond new Mst_task(params)
    }

    @Transactional
    def save(Mst_task mst_task) {
        if (mst_task == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (mst_task.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mst_task.errors, view:'create'
            return
        }

        mst_task.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mst_task.label', default: 'Mst_task'), mst_task.id])
                redirect mst_task
            }
            '*' { respond mst_task, [status: CREATED] }
        }
    }

    def edit(Mst_task mst_task) {
        respond mst_task
    }

    @Transactional
    def update(Mst_task mst_task) {
        if (mst_task == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (mst_task.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mst_task.errors, view:'edit'
            return
        }

        mst_task.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mst_task.label', default: 'Mst_task'), mst_task.id])
                redirect mst_task
            }
            '*'{ respond mst_task, [status: OK] }
        }
    }

    @Transactional
    def delete(Mst_task mst_task) {

        if (mst_task == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        mst_task.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mst_task.label', default: 'Mst_task'), mst_task.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mst_task.label', default: 'Mst_task'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
