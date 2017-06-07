package demo.grails.vuejs.sm

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*

class Mst_projectController {
    def index() {
    }

    def list() {
        def projectList = Mst_project.list(params)
        def result = [projectList: projectList]
        render result as JSON
    }

    def create() {
        new Mst_project(project_name: params?.project_name).save flush: true
        list()
    }

    def show() {
        def mst_project = Mst_project.get(params?.id)
        if (mst_project == null) {
            notFound()
            return
        }
        def mst_task = Mst_task.getAll(mst_project.tasks.id)
        if (mst_task == null) {
            notFound()
            return
        }
//        def result = [mst_project: mst_project]
//        render result as JSON
        render(view: "/mst_project/show", model: [mstTask: mst_task as JSON])
    }

    def delete(int id) {
        def mst_project = Mst_project.get(id)
        if (mst_project == null) {
            notFound()
            return
        }
        mst_project.delete flush:true
        list()
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'mst_project.label', default: 'Mst_project'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
