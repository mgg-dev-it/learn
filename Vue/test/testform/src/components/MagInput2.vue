<template>
  <div id="maginputdiv">
    <input
      type="text"
      v-model="cv"
      @blur="onBlur"
      @keydown="onKeyDown"
      @keypress="onKeyPress"
      @keyup="onKeyUp"
      @input="onInput"
      placeholder="type here"
      class="w3-input"
      ref="refinput"
      :inputmode="inputMode"
    />
  </div>
</template>

<script>
import { dbmixin } from "@/mixins/dbmixin.js";

export default {
  mixins: [dbmixin],
  name: "MagInput2",
  props: {
    fDef: Object, //this.FieldDef,
    debug: Boolean
  },
  data() {
    return {
      inputvalue: "",
      cvd: "",
      prevcvd: "",
      inputMode: ""
    };
  },
  computed: {
    cv: {
      get() {
        return this.cvd;
      },
      set(val) {
        this.cvd = val;
        if (this.fDef.upperCase) {
          this.cvd = val.toUpperCase();
        }
        if (this.cvd != this.prevcvd) {
          this.raiseEventValueChanged();
        }
        this.prevcvd = this.cvd;
      }
    }
  },
  beforeCreate() {
    //console.log("MagInput2 beforeCreate");
    // console.log(this.cvd);
  },
  created: function() {
    //console.log("MagInput2 created");
    // console.log(this.cvd);
    if (this.fDef.type == "date" || this.fDef.type == "int") {
      this.inputMode = "decimal";
    }
    this.cvd = this.fDef.value;
    if (this.fDef.upperCase) {
      this.cvd = this.cvd.toUpperCase();
    }
  },
  mounted: function() {
    //console.log("MagInput2 mounted");
    // console.log(this.cvd);
    //this.$emit("valuechanged", this.cvd, this.fDef.name);
    this.raiseEventValueChanged();
    if (this.fDef.focused) {
      //this.$refs[“ref-input”].setFocus();
      //console.log(this.$refs);
      //console.log(this.$refs.refinput);
      this.$refs.refinput.focus();
    }
  },
  methods: {
    raiseEventValueChanged() {
      this.$emit("valuechanged", this.cvd, this.fDef.name);
    },
    formatInt(val) {
      //var s = this.cv.replace(/\D/g, "");
      var s = val.replace(/\D/g, "");
      var l = s.length;
      var t = 0;
      var r = "";
      //for (var i = l; i--; i > 0) {
      for (var i = l; i > 0; i--) {
        r = s.substring(i - 1, i) + r;
        ++t;
        if (t == 3) {
          r = " " + r;
          t = 0;
        }
      }
      return r;
    },
    onInput(event) {
      if (this.debug) {
        console.log("onInput data " + event.data);
        console.log("onInput inputType " + event.inputType);
        console.log("onInput isComposing " + event.isComposing);
      }
    },
    onBlur(event) {
      //because of IME composition mode ...
      if (this.fDef.maxLength > 0 && this.cvd.length >= this.fDef.maxLength) {
        this.cv = this.cv.substring(0, this.fDef.maxLength);
      }
      if (this.fDef.type == "date") {
        //this.cv = "123";
        var s = this.cv.replace(/\D/g, "");
        var d = new Date();
        var sYear = String(d.getFullYear());
        var sMonth = String(d.getMonth() + 1);
        if (sMonth.length == 1) {
          sMonth = "0" + sMonth;
        }
        var sDay = String(d.getDate());
        if (sDay.length == 1) {
          sDay = "0" + sDay;
        }
        var dd = sYear + sMonth + sDay;
        if (s.length == 1) {
          s = "0" + s;
        }
        if (s.length == 3) {
          s = "0" + s;
        }
        if (s.length > 0) {
          dd = dd.substring(0, 8 - s.length) + s;
        }
        //s = dd;
        //this.cv = s;
        var sDateSeparator = "/";
        this.cv =
          dd.substring(0, 4) +
          sDateSeparator +
          dd.substring(4, 6) +
          sDateSeparator +
          dd.substring(6, 8);
      }
      if (this.fDef.type == "int") {
        this.cv = this.formatInt(this.cv);
      }
    },
    onKeyDown(event) {
      if (this.debug) {
        // console.log("onKeyDown "+event.target.value);
        console.log("onKeyDown key " + event.key);
        console.log("onKeyDown keyCode " + event.keyCode);
        //console.log("onKeyDown altKey " + event.altKey);
        //console.log("onKeyDown ctrlKey " + event.ctrlKey);
        //console.log("onKeyDown metaKey " + event.metaKey);
        //console.log("onKeyDown shiftKey " + event.shiftKey);
      }
    },
    onKeyPress(event) {
      if (this.debug) {
        console.log("onKeyPress " + event.key);
        console.log("selectionStart = " + this.$refs.refinput.selectionStart);
        console.log("selectionEnd = " + this.$refs.refinput.selectionEnd);
      }
      if (
        this.fDef.maxLength > 0 &&
        this.cvd.length >= this.fDef.maxLength &&
        this.$refs.refinput.selectionEnd - this.$refs.refinput.selectionStart <
          1
      ) {
        event.preventDefault();
      }
      if (this.fDef.type == "date") {
        if ("1234567890/.-".indexOf(event.key) < 0) {
          event.preventDefault();
        }
      }
      if (this.fDef.type == "int") {
        if ("1234567890".indexOf(event.key) < 0) {
          event.preventDefault();
        }
        //this.cv = this.formatInt(this.cv);
      }
    },
    onKeyUp(event) {
      if (this.debug) {
        console.log("onKeyUp " + event.key);
      }
    }
  }
};
</script>

<style scoped>
#maginputdiv {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  /* background-color: lightskyblue; */
  padding: 0px;
  margin: 0px;
}
input:focus {
  background-color: yellow;
  outline: none;
  }
.w3-input{
  padding-top: 1px;
  padding-left: 5px;
  padding-bottom: 1px;
  background-color: lemonchiffon;
}
</style>