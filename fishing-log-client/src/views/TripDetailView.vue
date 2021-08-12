<template>
  <trip-detail v-bind:tripId="$route.params.tripId" ></trip-detail>
</template>

<script>
import TripDetail from "@/components/TripDetail.vue";

export default {
    name: "trip",
  components: {
    TripDetail,
  },
};
</script>

<style>
</style>