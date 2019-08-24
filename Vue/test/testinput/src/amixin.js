export const amixin = {
    data() {
        return {
            a: "",
            b: ""
        }
    },
    methods: {
        doSomething() {
            console.log("doSomething");
        },
        Person(first, last, age, eyecolor) {
            this.firstName = first;
            this.lastName = last;
            this.age = age;
            this.eyeColor = eyecolor;
            this.nationality = "English";
            this.name = function () { return this.firstName + " " + this.lastName; };
            this.changeName = function (name) {
                this.lastName = name;
            };
        }
    }
}