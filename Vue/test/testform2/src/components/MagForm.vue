<template>
  <div id="magformdiv">
    <!-- <form class="w3-container">
      <p v-for="field in fieldDefinitions" v-bind:key="field.name">
        <label class="w3-text-blue">{{field.displayName}}</label>
        <MagInput :fDef="field" @valuechanged="onValueChanged" @lostfocus="onLostFocus" :debug="debug"></MagInput>
      </p>
    </form> -->
    <form class="w3-container">
      <fieldset id="fieldset-mode" class="border-blue" style="width: 100%">
        <legend v-if="title" class="w3-text-indigo">&nbsp;{{ title }}&nbsp;</legend>
        <table style="width: 100%">
          <tr v-for="field in fieldDefinitions" v-bind:key="field.name">
            <td>
              <label class="w3-text-blue">{{ field.displayName }}:</label>
            </td>
            <td style="width: 100%">
              <MagInput
                :fDef="field"
                @valuechanged="onValueChanged"
                @lostfocus="onLostFocus"
                :debug="debug"
              ></MagInput>
            </td>
          </tr>
        </table>
      </fieldset>
    </form>
  </div>
</template>

<script>
import MagInput from "./MagInput.vue";
var mapFields = new Map();
export default {
  props: {
    fieldDefinitions: Array, //[this.FieldDef], //Object, //array of FieldDef,
    debug: Boolean,
    title: String,
  },
  components: {
    MagInput,
  },
  data: function () {
    return { aaa: "bbb" };
  },
  created: function () {
    for (var i = 0; i < this.fieldDefinitions.length; i++) {
      mapFields.set(this.fieldDefinitions[i].name, this.fieldDefinitions[i]);
    }
  },
  mounted: function () {
    //console.log(this.title);
    //this.t = this.tableTest.getFields();
    // console.log(this.tableTest.getFields()[0].value);
    // console.log(this.tableTest.getFields()[1].value);
    // console.log(this.tableTest.getFields()[2].value);
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
    },
  },
};
</script>

<style scoped>
.border-blue {
  border: 1px solid #000088;
}
#magformdiv {
/* border: 2px solid rgb(21, 21, 194); */
/* font-family: "Avenir", Helvetica, Arial, sans-serif; */
/* background-color: lightskyblue; */
/* padding: 0px; */
padding-top: 8px;
/* margin: 0px; */
}
</style>