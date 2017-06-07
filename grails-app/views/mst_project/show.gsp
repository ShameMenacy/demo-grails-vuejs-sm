<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'mst_project.label', default: 'Mst_project')}"/>
    <title>
        <g:message code="default.list.label" args="[entityName]"/>
    </title>
</head>
<body>
<div class="row">
    <h1>予定更新画面</h1>
</div>
<div class="container" id="task-data">
    <div class="row justify-content-left fieldcontain">
        <div class="col-8">
            <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="show">予定
            </g:link>
            <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="show">実績
            </g:link>
            <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="show">EXCEL出力
            </g:link>
        </div>
    </div>
    <div class="row justify-content-center fieldcontain">
        <task-item v-for="item in mstTask" v-bind:task="item" :key="item.id"></task-item>
    </div>
    <div class="row justify-content-left fieldcontain">
        <div class="col-4">
            <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="show">+
            </g:link>
        </div>
    </div>
</div>
<script type="text/javascript">

    Vue.component('task-item', {
        props: ['task'],
        template:   `
            <div class="col-md-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">{{ task.task_name }}</h3>
                    </div>
                    <div class="panel-body">{{ task.task_assigned_person }}</div>
                </div>
            </div>
        `,
    });

    new Vue({
        el: '#task-data',
        data: {
            mstTask: ${raw(mstTask)}
        },
        methods: {
        },
        created: function () {
        }
    });
</script>
</body>
</html>