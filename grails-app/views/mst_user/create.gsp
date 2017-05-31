<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'mst_user.label', default: 'Mst_user')}"/>
    <title>
        <g:message code="default.create.label" args="[entityName]"/>
    </title>
</head>
<body>
<g:form method="post">
    <div class="row">
        <h1>ユーザー編集画面</h1>
    </div>
    <div class="container" id="user-data">
        <g:hiddenField name="id" value="${mst_user?.id}"/>
        <g:hiddenField name="version" value="${mst_user?.version}"/>
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="button">
            <div class="row justify-content-md-center vertical-center-row">
                <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="update">登録
                </g:link>
                <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="delete">削除
                </g:link>
                <g:link class="btn btn-outline-danger ml-2" controller="mst_user" action="show">戻る
                </g:link>
            </div>
        </fieldset>
    </div>
</g:form>
</body>
</html>
