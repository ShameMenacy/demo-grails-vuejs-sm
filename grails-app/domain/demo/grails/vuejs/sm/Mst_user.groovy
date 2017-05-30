package demo.grails.vuejs.sm

/**
 * ユーザー。
 */
class Mst_user {

    static hasMany = [mst_user_details: Mst_user_detail, mst_projects: Mst_project]

    static constraints = {
    }
}