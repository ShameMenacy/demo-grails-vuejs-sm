var userData = new Vue({
    el: '#user-data',
    data: {
        userList: []
    },
    methods: {
        fetchData: function () {
            axios.get('/mst_user/getUserList')
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

var userDetailsData = new Vue({
    el: '#user-detail-data',
    data: {
        userDetailDatas: []
    },
    methods: {
        fetchData: function () {
            axios.get('/mst_user_detail/listActiveUser')
            .then(function (response) {
                userDetailsData.userDetailDatas = response.data.activeUserList;
            })
            .catch(function (error) {
                console.log(error);
            });
        },
    },
    created: function () {
        this.fetchData();
    }
});