<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'mst_user_detail.label', default: 'Mst_user_detail')}"/>
    <title>
        <g:message code="default.list.label" args="[entityName]"/>
    </title>
</head>
<body>

<div class="row">
    <h1>ユーザー管理画面</h1>
</div>
<br/>
<div id="user-detail-data">
    <div class="row justify-content-start">
        <div class="col-1">
            姓
        </div>
        <div class="col-1">
            名
        </div>
    </div>
    <div class="row justify-content-start">
        <div class="col-2">
            ------------------
        </div>
    </div>
    <div class="row justify-content-start" v-for="userData in userDetailDatas">
        <div class="col-1">
            <g:link controller="mst_project" action="index">
            {{ userData.first_name }}</g:link>
        </div>
        <div class="col-1">
            <g:link controller="mst_project" action="index">{{ userData.last_name }}</g:link>
        </div>
    </div>
</div>

<div class="row justify-content-md-center vertical-center-row">
    <div class="col-xs-6 col-centered col-fixed">
        <g:link class="btn btn-outline-danger" controller="mst_project" action="index">新規登録
        </g:link>
        <g:link class="btn btn-outline-danger" controller="mst_user" action="index">戻る
        </g:link>
    </div>
</div>
</body>
</html>