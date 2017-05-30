package demo.grails.vuejs.sm

/**
 * タスク。
 */
class Mst_task {

    /**
     * タスク名
     */
    String task_name

    /**
     * 担当
     */
    String task_assigned_person

    /**
     * 開始予定日
     */
    Date task_plan_start_date

    /**
     * 終了予定日
     */
    Date task_plan_end_date

    /**
     * 開始実績日
     */
    Date task_actual_start_date

    /**
     * 終了実績日
     */
    Date task_actual_end_date

    /**
     * 表示順: タスク表示時に昇順で表示
     */
    Integer task_order

    /**
     * 進捗
     */
    Integer percent

    static belongsTo = [mst_project: Mst_project]

    static constraints = {
        task_name maxSize: 128
        task_assigned_person maxSize: 128
        task_name nullable: true
        task_assigned_person nullable: true
        task_plan_start_date nullable: true
        task_plan_end_date nullable: true
        task_plan_end_date nullable: true, validator: { value, task, errors ->
            if (value && value < task.task_plan_start_date) {
                task.errors.rejectValue('task_plan_end_date', 'error.common.correlationDate.message', ['終了日付', '開始日付'] as Object[], '')
                return false
            }
            return true
        }
        task_actual_start_date nullable: true
        task_actual_end_date nullable: true, validator: { value, task, errors ->
            if (value && value < task.task_actual_start_date) {
                task.errors.rejectValue('task_actual_end_date', 'error.common.correlationDate.message', ['終了日付', '開始日付'] as Object[], '')
                return false
            }
            return true
        }
        task_order blank: true, nullable: true
        percent blank: true, nullable: true, max: 100
    }

    static mapping = {
        sort 'id'
        order 'asc'
    }
}
