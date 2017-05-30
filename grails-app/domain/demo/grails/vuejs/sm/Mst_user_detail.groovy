package demo.grails.vuejs.sm

/**
 * ユーザー詳細。
 */
class Mst_user_detail {

    /**
     * ユーザー名(姓)
     */
    String last_name

    /**
     * ユーザー名(名)
     */
    String first_name

    /**
     * 使用開始日時
     */
    Date from_date

    /**
     * 使用終了日時
     * 現行データは"9999/12/31 23:59:59"
     */

    Date to_date

    static belongsTo = [user: Mst_user]

    static constraints = {
        last_name nullable: false, maxSize: 128
        first_name nullable: false, maxSize: 128
        from_date nullable: false
        to_date nullable: false
    }

    static mapping = {
        from_date defaultValue: "now()"
        to_date defaultValue: "'9999-12-31 23:59:59'"
        sort 'id'
        order 'asc'
    }
}
