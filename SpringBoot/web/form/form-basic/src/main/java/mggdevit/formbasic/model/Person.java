package mggdevit.formbasic.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import mggdevit.formbasic.validation.ValidEmail;

public class Person {
	
	@NotNull
	@NotEmpty
    private String firstName;

	@NotNull
	@NotEmpty
	@ValidEmail
    private String lastName;
 
    public Person() {
 
    }
 
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
}
