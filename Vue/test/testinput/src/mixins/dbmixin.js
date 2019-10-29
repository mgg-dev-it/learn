export const dbmixin = {
    data() {
        return {
            aaa: "aaa",
            bbb: "bbb"
        }
    },
    beforeCreate() {
       // console.log("dbmixin beforeCreate");
       this.aaa = "xxx";
    },
    created() {
        //console.log("dbmixin created");
        this.aaa = "yyy";
    },
    mounted() {
        //console.log("dbmixin mounted");
    },
    methods: {
        Person: function(first, last, age, eyecolor) {
            this.firstName = first;
            this.lastName = last;
            this.age = age;
            this.eyeColor = eyecolor;
            this.nationality = "English";
            this.name = function () { return this.firstName + " " + this.lastName; };
            this.changeName = function (name) {
                this.lastName = name;
            };
        },
        FieldDef: function(name, type, value) {
            this.name = name;
            this.type = type;
            this.value = value;
            this.upperCase = false;
            this.maxLength = -1;
            this.focused = false;
        }
    }
}