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
            //f5 : new this.FieldDef("field05", "text", "").setMaxLength(10),
            f101 : new this.FieldDef("field101", "text", "").setMaxLength(6).setUpperCase(true),
            f102 : new this.FieldDef("field102", "int", "").setMaxLength(10),
            f103 : new this.FieldDef("field103", "date", ""),
            fieldDefinitions99: [this.fieldDef1, this.fieldDef2, this.fieldDef3]
        }
    },
    computed: {
        tableDef: function () {
            //return ([this.fieldDef1, this.fieldDef2, this.fieldDef3])
            return ([this.f101, this.f102, this.f103])
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
        FieldDef: function (name, type, value) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.displayName = name;
            this.upperCase = false;
            this.maxLength = -1;
            this.focused = false;
            this.setMaxLength = function (m) {
                this.maxLength = m;
                return (this);
            }
            this.setUpperCase = function (u){
                this.upperCase = u;
                return (this);
            }
        }
    }
}