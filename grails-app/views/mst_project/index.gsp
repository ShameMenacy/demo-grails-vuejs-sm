<!DOCTYPE html>
<html xmlns:v-bind="http://www.w3.org/1999/xhtml" xmlns:v-on="http://www.w3.org/1999/xhtml">
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'mst_project.label', default: 'Mst_project')}"/>
    <title>
        <g:message code="default.list.label" args="[entityName]"/>
    </title>
</head>
<body>
<div class="row">
    <h1>プロジェクト選択画面</h1>
</div>
<div class="container" id="project-data">
    <div class="row justify-content-center fieldcontain">
        <div class="col-4">
            <input v-model="project_name" placeholder="プロジェクト名を入力">
        </div>
        <div class="col-4">
            <button class="btn btn-outline-danger ml-2" v-on:click="create" v-on:keyup.enter="create">新規作成</button>
        </div>
    </div>
    <div class="row justify-content-center fieldcontain">
        <div class="col-4">
            <select class="btn btn-secondary dropdown-toggle" v-model="projectId">
                <option value="0" disabled>プロジェクト選択</option>
                <option v-for="project in projectList" v-bind:value="project.id">
                    {{ project.project_name }}
                </option>
            </select>
        </div>
        <div class="col-4">
            <a class="btn btn-outline-danger ml-2" v-bind:href="'/mst_project/show/' + projectId">選択</a>
            <button class="btn btn-outline-danger ml-2" @click="deleteProject">削除</button>
        </div>
    </div>
</div>
<script>
    var vProject = new Vue({
        el: '#project-data',
        data: {
            projectId: 0,
            project_name: '',
            projectList: []
        },
        methods: {
            loadData: function () {
                axios('/mst_project/list')
                .then(function (response) {vProject.projectList = response.data.projectList;})
                .catch(function (error) {console.log(error);});
            },
            resetData: function () {
                vProject.loadData();
                vProject.project_name='';
                vProject.projectId=0
            },
            create: function () {
                axios.get('/mst_project/create', {
                    params: {
                        project_name: vProject.project_name
                    }
                })
                .then(function (response) {vProject.resetData()})
                .catch(function (error) {console.log(error);});
            },
            deleteProject: function () {
                axios.get('/mst_project/delete', {
                    params: {
                        id: vProject.projectId
                    }
                })
                .then(function (response) {vProject.resetData()})
                .catch(function (error) {console.log(error);});
            }
        },
        created: function () {
            this.loadData();
        }
    })
</script>
</body>
</html>