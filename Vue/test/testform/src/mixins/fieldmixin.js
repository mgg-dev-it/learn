export const fieldmixin = {
    data() {
        return {
            c: "",
            d: "",
            fieldDef1: {
                name: "field1",
                type: "text",
                value: "",
                upperCase: true,
                maxLength: 6,
                focused: true
            },
            fieldDef2: {
                name: "field2",
                type: "int",
                value: "",
                //upperCase: true,
                maxLength: 10
                //focused: true
            },
            fieldDef3: {
                name: "field3",
                type: "date",
                value: "",
                upperCase: false,
                maxLength: -1
            },
            fieldDefinitions99: [this.fieldDef1, this.fieldDef2, this.fieldDef3]
        }
    },
    computed: {
        tableDef: function () {
            return ([this.fieldDef1, this.fieldDef2, this.fieldDef3])
        }
    },
    beforeCreate() {
        //console.log("dbmixin beforeCreate");
    },
    created() {
        //console.log("dbmixin created");
        this.fieldDefinitions99 = [this.fieldDef1, this.fieldDef2, this.fieldDef3];
    },
    mounted() {
        //console.log("dbmixin mounted");
    },
    methods: {
        // Person: function (first, last, age, eyecolor) {
        //     this.firstName = first;
        //     this.lastName = last;
        //     this.age = age;
        //     this.eyeColor = eyecolor;
        //     this.nationality = "English";
        //     this.name = function () { return this.firstName + " " + this.lastName; };
        //     this.changeName = function (name) {
        //         this.lastName = name;
        //     };
        // },
        // FieldDef: function (name, type, value) {
        //     this.name = name;
        //     this.type = type;
        //     this.value = value;
        //     this.upperCase = false;
        //     this.maxLength = -1;
        //     this.focused = false;
        // }
    }
}