package mggdevit.jdbccrud.service;

import java.util.List;

import mggdevit.jdbccrud.entity.Person;

public interface PersonServiceInterface {

	List<Person> getAllItems();

	void addPerson(String name, Integer age);

	void deletePerson(Integer id);

	// List atriskdogs(Date rescued);

	long getGeneratedKey(String name, Integer age);
}
