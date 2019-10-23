<template>
  <div id="magformdiv">
    <div class="w3-container w3-green">
      <h2>MagForm</h2>
    </div>
    <form class="w3-container">
      <p v-for="field in fieldDefinitions" v-bind:key="field.name">
        <label class="w3-text-blue">{{field.name}}: {{field.type}}</label>
        <MagInput2 :fDef="field" :debug="debug"></MagInput2>
      </p>
    </form>
  </div>
</template>

<script>
import MagInput2 from "./MagInput2.vue";
import { dbmixin } from "@/mixins/dbmixin.js";
export default {
  mixins: [dbmixin],
  props: {
    fieldDefinitions: Array, //[this.FieldDef], //Object, //array of FieldDef,
    debug: Boolean
  },
  components: {
    MagInput2
  },  data() {
    return {
      fields: []
    };
  },
created: function() {
    //console.log("MagForm created");
     //onsole.log(this.fieldDefinitions);
    // if (this.fDef.type == "date" || this.fDef.type == "int") {
    //   this.inputMode = "decimal";
    // }
    // this.cvd = this.fDef.value;
    // if (this.fDef.upperCase) {
    //   this.cvd = this.cvd.toUpperCase();
    // }
  }
};
</script>

<style scoped>
</style>