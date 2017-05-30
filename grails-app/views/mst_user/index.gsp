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
<div id="user-data">
    <div class="row justify-content-md-center vertical-center-row">
        <select class="btn btn-secondary dropdown-toggle">
            <option value="0">ユーザー名を選択</option>
            <option v-for="user in userList" v-bind:value="user.id">
                {{ user.first_name }} {{ user.last_name }}
            </option>
        </select>
        <g:link class="btn btn-outline-danger ml-2" controller="mst_project" action="index">選択
        </g:link>
        <g:link class="btn btn-outline-danger ml-2" controller="mst_user_detail" action="index">ユーザー管理
        </g:link>
    </div>
</div>
</body>
</html>