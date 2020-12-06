<template>
  <div id="magformdiv">
    <!-- <h2>{{ test }}</h2> -->
    <form class="w3-container">
      <fieldset id="fieldset-mode" class="border-blue" style="width: 100%">
        <legend v-if="title" class="w3-text-indigo">
          &nbsp;{{ title }}&nbsp;
        </legend>
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
                :refresh="refresh"
              ></MagInput>
            </td>
          </tr>

          <tr v-if="buttonDefinitions">
            <td>&nbsp;</td>
            <td :colspan="buttonDefinitions.length">
              <span v-for="btn in buttonDefinitions" v-bind:key="btn.name">
                <!-- <input v-for="btn in buttonDefinitions" v-bind:key="btn.name" type="button" :value="btn.displayText" v-on:click="onButtonPressed(btn.name)" :name="btn.name"> -->
                <input
                  type="button"
                  :value="btn.displayText"
                  v-on:click="onButtonPressed(btn.name)"
                  :name="btn.name"
                  class="w3-button w3-white w3-border w3-border-blue w3-round"
                  style="padding: 2px 5px"
                />&nbsp;
              </span>
            </td>
          </tr>
          <!-- <tr v-for="btn in buttonDefinitions" v-bind:key="btn.name">
            <td>&nbsp;</td>
            <td style="width: 100%">
              <input
                type="button"
                :value="btn.displayText"
                v-on:click="onButtonPressed(btn.name)"
                :name="btn.name"
              />
            </td>
          </tr> -->
        </table>
      </fieldset>
    </form>
  </div>
</template>

<script>
import MagInput from "./MagInput.vue";
var mapFields = new Map();
var mapButtons = new Map();
export default {
  props: {
    fieldDefinitions: Array,
    buttonDefinitions: Array,
    debug: Boolean,
    title: String,
    refresh: Boolean
  },
  components: {
    MagInput,
  },
  data: function () {
    return {};
  },
  created: function () {
    for (let i = 0; i < this.fieldDefinitions.length; i++) {
      mapFields.set(this.fieldDefinitions[i].name, this.fieldDefinitions[i]);
    }
    if (this.buttonDefinitions) {
      for (let i = 0; i < this.buttonDefinitions.length; i++) {
        if (this.buttonDefinitions[i]) {
          mapButtons.set(
            this.buttonDefinitions[i].name,
            this.buttonDefinitions[i]
          );
        }
      }
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
    onButtonPressed(name) {
      // if (this.debug) {
      //   console.log("onButtonPressed " + name);
      // }
      //var b = mapButtons.get(name);
      this.$emit("buttonpressed", name);
    },
  },
  // computed: {
  //   testChanged: function () {
  //     console.log("testChanged " + this.test);
  //     return this.test;
  //   },
  // },
  // watch: {
  //   refresh: function (newvalue, oldvalue) {
  //     console.log("testChanged " + oldvalue + " -> " + newvalue);
  //   },
  // },
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
input[type="xxxxxxbutton"],
input[type="xxxxxsubmit"],
input[type="xxxxxxreset"] {
  border: 1px solid blue;
  border-radius: 3px;
  background-color: white;
  color: blue;
  /* padding: 16px 32px; */
  /* text-decoration: none; */
  /* margin: 4px 2px; */
  /* cursor: pointer; */
}
</style>