<template>
  <div id="magformdiv">
    <form class="w3-container">
      <p v-for-key="field in fields">
        <label class="w3-text-blue">{{field.name}}: {{field.type}}</label>
        <MagInput2 :fDef="field" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
      </p>
      <!--       <p>
        <label class="w3-text-blue">Test field 001: {{this.f1.type}}</label>
        <MagInput2 :fDef="f2" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
      </p>
      <p>
        <label class="w3-text-blue">Test field 001: {{this.f1.type}}</label>
        <MagInput2 :fDef="f3" @valuechanged="onValueChanged" :debug="debug"></MagInput2>
      </p>-->
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
        fields: []
    };
  }
};
</script>

<style scoped>
</style>