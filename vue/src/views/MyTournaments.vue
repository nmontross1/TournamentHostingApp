<template>
    <header>
    <div class="myTournaments">
        <my-tournaments />
    </div>

    </header>
</template>

<script>
import myTournaments from "@/components/MyTournamentsComp.vue";


export default {
    name: "myTournaments-view",
    components: { myTournaments },
}
</script>
<style scoped>
div.myTournaments {
  text-align: center;
}
</style>