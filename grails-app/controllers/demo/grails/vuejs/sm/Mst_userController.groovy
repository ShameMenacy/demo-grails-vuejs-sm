package demo.grails.vuejs.sm

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Mst_userController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mst_user.list(params), model:[mst_userCount: Mst_user.count()]
    }

    def listUser() {
        def userList = Mst_user.mst_user_details.createCriteria().list {
            and {
                lt('from_date', new Date())
                ge('to_date', new Date())
            }
        }> 0 ?: null
        def result = [userList: userList]
        render result as JSON
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mst_user.label', default: 'Mst_user'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
