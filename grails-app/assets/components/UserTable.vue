<template>
    <vuetable ref="userTable"
        api-url="https://vuetable.ratiw.net/api/users"
        :fields="['last_name', 'first_name']">
    </vuetable>
</template>

<script>
import UserTable from '/assets/components/UserTable'

export default {
  components: {
    UserTable
  }
}
</script>