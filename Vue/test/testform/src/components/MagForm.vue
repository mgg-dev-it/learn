<template>
  <div id="magformdiv">
    <!-- <div class="w3-container w3-green">
      <h2>MagForm</h2>
    </div> -->
    <form class="w3-container">
      <p v-for="field in fieldDefinitions" v-bind:key="field.name">
        <label class="w3-text-blue">{{field.name}}: {{field.type}}</label>
        <MagInput2 :fDef="field" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
      </p>
    </form>
  </div>
</template>

<script>
import MagInput2 from "./MagInput2.vue";
import { dbmixin } from "@/mixins/dbmixin.js";
var mapFields = new Map();
export default {
  mixins: [dbmixin],
  props: {
    fieldDefinitions: Array, //[this.FieldDef], //Object, //array of FieldDef,
    debug: Boolean
  },
  components: {
    MagInput2
  },
  data() {
    return {
      fields: []
    };
  },
  beforeCreate: function() {
    console.log("MagForm beforeCreate");
  },
  created: function() {
    console.log("MagForm created");
    //onsole.log(this.fieldDefinitions);
    // if (this.fDef.type == "date" || this.fDef.type == "int") {
    //   this.inputMode = "decimal";
    // }
    // this.cvd = this.fDef.value;
    // if (this.fDef.upperCase) {
    //   this.cvd = this.cvd.toUpperCase();
    // }
    for (var i = 0; i < this.fieldDefinitions.length; i++) {
      mapFields.set(this.fieldDefinitions[i].name, this.fieldDefinitions[i]);
    }
  },
  methods: {
    onValueChanged(val, name) {
      // var f = mapFields.get(name);
      // console.log(name);
      // console.log(val);
      // console.log(f);
      //this.raiseEventValueChanged();
       this.$emit("valuechanged", val, name);
    }
    // raiseEventValueChanged() {
    //   this.$emit("valuechanged", this.cvd, this.fDef.name);
    // }
  }
};
</script>

<style scoped>
</style>