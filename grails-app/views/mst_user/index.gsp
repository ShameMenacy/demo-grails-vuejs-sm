<!DOCTYPE html>
<html xmlns:v-bind="http://www.w3.org/1999/xhtml">
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'mst_user.label', default: 'Mst_user')}"/>
    <title>
        <g:message code="default.list.label" args="[entityName]"/>
    </title>
</head>
<body>
<div class="row">
    <h1>ログイン画面</h1>
</div>
<div class="container" id="user-data">
    <div class="row justify-content-center">
        <select class="btn btn-secondary dropdown-toggle">
            <option disabled value="">ユーザー名を選択</option>
            <option v-for="user in userList" v-bind:value="user.id">
                {{ user.first_name }} {{ user.last_name }}
            </option>
        </select>
        <button href="${createLink(controller:'mst_project')}" class="btn btn-outline-danger ml-2">選択</button>
        <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="show">ユーザー管理
        </g:link>
    </div>
</div>

<script>
    var userData = new Vue({
        el: '#user-data',
        data: {
            userList: []
        },
        methods: {
            fetchData: function () {
                axios.get('/mst_user/list')
                .then(function (response) {
                    userData.userList = response.data.userList;
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
        },
        created: function () {
            this.fetchData();
        }
    });
</script>
</body>
</html>