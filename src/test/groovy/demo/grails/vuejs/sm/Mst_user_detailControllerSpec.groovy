package demo.grails.vuejs.sm

import grails.test.mixin.*
import spock.lang.*

@TestFor(Mst_user_detailController)
@Mock(Mst_user_detail)
class Mst_user_detailControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mst_user_detailList
            model.mst_user_detailCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mst_user_detail!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def mst_user_detail = new Mst_user_detail()
            mst_user_detail.validate()
            controller.save(mst_user_detail)

        then:"The create view is rendered again with the correct model"
            model.mst_user_detail!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mst_user_detail = new Mst_user_detail(params)

            controller.save(mst_user_detail)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mst_user_detail/show/1'
            controller.flash.message != null
            Mst_user_detail.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def mst_user_detail = new Mst_user_detail(params)
            controller.show(mst_user_detail)

        then:"A model is populated containing the domain instance"
            model.mst_user_detail == mst_user_detail
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mst_user_detail = new Mst_user_detail(params)
            controller.edit(mst_user_detail)

        then:"A model is populated containing the domain instance"
            model.mst_user_detail == mst_user_detail
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mst_user_detail/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mst_user_detail = new Mst_user_detail()
            mst_user_detail.validate()
            controller.update(mst_user_detail)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mst_user_detail == mst_user_detail

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mst_user_detail = new Mst_user_detail(params).save(flush: true)
            controller.update(mst_user_detail)

        then:"A redirect is issued to the show action"
            mst_user_detail != null
            response.redirectedUrl == "/mst_user_detail/show/$mst_user_detail.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/mst_user_detail/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def mst_user_detail = new Mst_user_detail(params).save(flush: true)

        then:"It exists"
            Mst_user_detail.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(mst_user_detail)

        then:"The instance is deleted"
            Mst_user_detail.count() == 0
            response.redirectedUrl == '/mst_user_detail/index'
            flash.message != null
    }
}
