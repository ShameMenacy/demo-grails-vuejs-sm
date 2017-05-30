package demo.grails.vuejs.sm

/**
 * プロジェクト。
 */
class Mst_project {

    /**
     * プロジェクト名
     */
    String project_name

    static belongsTo = [owner: Mst_user]

    static hasMany = [tasks: Mst_task]

    static constraints = {
        project_name blank: false, maxSize: 128
        owner blank: true, nullable: true
    }

    static mapping = {
        sort 'id'
        order 'asc'
    }
}

