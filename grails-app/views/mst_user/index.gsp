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
<div class="container">
    <div class="row">
        <h1>ログイン画面</h1>
    </div>
    <div class="row">
        <div class="col align-self-center">
            <!--<select id="user" class="btn dropdown-toggle">-->
                <!--<option v-for="user in activeUserList" v-bind:value="user.id">-->
                    <!--{{ userDetails.first_name }} {{ userDetails.last_name }}-->
                <!--</option>-->
            <!--</select>-->
            <select id="user" class="btn dropdown-toggle">
                <option v-for="user in userList" v-bind:value="user.id">
                    {{ user.first_name }} {{ user.last_name }}
                </option>
            </select>
            <button type="button" class="btn btn-outline-danger">選択
            </button>
            <button type="button" class="btn btn-outline-danger">ユーザー管理
            </button>
        </div>
    </div>
</div>
<script>
      <!--var userDetails = new Vue({-->
        <!--el: '#user',-->
          <!--data: {-->
            <!--activeUserList: []-->
          <!--},-->
          <!--methods: {-->
            <!--fetchData: function () {-->
              <!--axios.get('/mst_user_detail/listActiveUser')-->
              <!--.then(function (response) {-->
                <!--user.activeUserList = response.data.activeUserList;-->
              <!--})-->
              <!--.catch(function (error) {-->
                <!--console.log(error);-->
              <!--});-->
            <!--}-->
          <!--},-->
          <!--created: function () {-->
            <!--this.fetchData();-->
          <!--}-->
      <!--});-->

      var user = new Vue({
        el: '#user',
          data: {
            userList: []
          },
          created: function () {
              axios.get('/mst_user/listUser')
              .then(function (response) {
                user.userList = response.data.userList;
              })
              .catch(function (error) {
                console.log(error);
              });
          }
      });
    </script>
</body>
</html>