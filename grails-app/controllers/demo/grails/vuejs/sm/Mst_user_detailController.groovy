package demo.grails.vuejs.sm

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Mst_user_detailController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mst_user_detail.list(params), model: [mst_user_detailCount: Mst_user_detail.count()]
    }

    def listActiveUser() {
        def activeUserList = Mst_user_detail.createCriteria().list {
            and {
                lt('from_date', new Date())
                ge('to_date', new Date())
            }
        }
        def result = [activeUserList: activeUserList]
        render result as JSON
    }



    def show(Mst_user_detail mst_user_detail) {
        respond mst_user_detail
    }

    def create() {
        respond new Mst_user_detail(params)
    }

    @Transactional
    def save(Mst_user_detail mst_user_detail) {
        if (mst_user_detail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (mst_user_detail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mst_user_detail.errors, view: 'create'
            return
        }

        mst_user_detail.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mst_user_detail.label', default: 'Mst_user_detail'), mst_user_detail.id])
                redirect mst_user_detail
            }
            '*' { respond mst_user_detail, [status: CREATED] }
        }
    }

    def edit(Mst_user_detail mst_user_detail) {
        respond mst_user_detail
    }

    @Transactional
    def update(Mst_user_detail mst_user_detail) {
        if (mst_user_detail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (mst_user_detail.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond mst_user_detail.errors, view: 'edit'
            return
        }

        mst_user_detail.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'mst_user_detail.label', default: 'Mst_user_detail'), mst_user_detail.id])
                redirect mst_user_detail
            }
            '*' { respond mst_user_detail, [status: OK] }
        }
    }

    @Transactional
    def delete(Mst_user_detail mst_user_detail) {

        if (mst_user_detail == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        mst_user_detail.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'mst_user_detail.label', default: 'Mst_user_detail'), mst_user_detail.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mst_user_detail.label', default: 'Mst_user_detail'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
