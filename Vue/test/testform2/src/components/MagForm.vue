<template>
  <div id="magformdiv">
    <form class="w3-container">
      <p v-for="field in fieldDefinitions" v-bind:key="field.name">
        <label class="w3-text-blue">{{field.displayName}}</label>
        <MagInput :fDef="field" @valuechanged="onValueChanged" @lostfocus="onLostFocus" :debug="debug"></MagInput>
      </p>
    </form>
  </div>
</template>

<script>
import MagInput from "./MagInput.vue";
var mapFields = new Map();
export default {
  props: {
    fieldDefinitions: Array, //[this.FieldDef], //Object, //array of FieldDef,
    debug: Boolean
  },
  components: {
    MagInput
  },
  data() {
    return {};
  },
  created: function() {
    for (var i = 0; i < this.fieldDefinitions.length; i++) {
      mapFields.set(this.fieldDefinitions[i].name, this.fieldDefinitions[i]);
    }
  },
  methods: {
    onValueChanged(val, name) {
      var f = mapFields.get(name);
      f.value = val;
      this.$emit("valuechanged", val, name);
    },
    onLostFocus(val, name) {
      var f = mapFields.get(name);
      f.value = val;
      this.$emit("lostfocus", val, name);
    }
  }
};
</script>

<style scoped>
</style>