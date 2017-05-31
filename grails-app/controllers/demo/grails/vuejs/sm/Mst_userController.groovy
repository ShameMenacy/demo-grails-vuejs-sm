package demo.grails.vuejs.sm

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class Mst_userController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Mst_user.list(params), model: [mst_userCount: Mst_user.count()]
    }

    def list() {
        def userList = getActivedUserList()
        def result = [userList: userList]
        render result as JSON
    }

    def create() {
        def mst_user = new Mst_user(params)
        respond mst_user
    }

    def show(Mst_user mst_user) {
        render(view: "show", model: [mst_user: mst_user])
    }

    def view(Mst_user mst_user) {
        render(view: "view", model: [mst_user: mst_user])
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mst_user.label', default: 'Mst_user'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def test() {

//        def userList = Mst_user.findAll("from Mst_user as mu where mu.author=:author",
//                [author: 'Dan Brown'], [max: 10, offset: 5])
        def user_ids = Mst_user.getAll()*.id
        println user_ids
        def userList = Mst_user_detail.findAllWhere(user: user_ids, from_date < new Date(), to_date > new Date())
        userList.each() {
            println "user ${it.id}"
        }

        def results = Mst_user.withCriteria {
            like('title', '%Groovy%')
        }
        render userList.dump()
    }

    def getActivedUserList() {
        def userList = Mst_user_detail.createCriteria().list {
            and {
                lt('from_date', new Date())
                ge('to_date', new Date())
            }
            order("from_date", "asc")
        }
        return userList
    }
}
