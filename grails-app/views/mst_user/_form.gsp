<%@ page import="demo.grails.vuejs.sm.Mst_user" %>
<div class="row justify-content-center">
    <div class="col-4">
        <div class="fieldcontain ${hasErrors(bean: mst_user_details, field: 'id', 'error')} required">
            <g:textField name="user_id" value="${mst_user_details?.user_id}" readonly="readonly"
                         placeholder="ユーザーID"/>
        </div>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-4">
        <div class="fieldcontain ${hasErrors(bean: mst_user_details, field: 'last_name', 'error')} required">
            <g:textField name="last_name" value="${mst_user_details?.last_name}"
                         placeholder="姓を入力"/>
        </div>
    </div>
</div>
<div class="row justify-content-center">
    <div class="col-4">
        <div class="fieldcontain ${hasErrors(bean: mst_user_details, field: 'first_name', 'error')} required">
            <g:textField name="first_name" value="${mst_user_details?.first_name}"
                         placeholder="名を入力"/>
        </div>
    </div>
</div>