package mggdevit.jdbccrud.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mggdevit.jdbccrud.dao.PersonDAOInterface;
import mggdevit.jdbccrud.entity.Person;

@Service
public class PersonService implements PersonServiceInterface {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PersonDAOInterface personDAO;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Person> getAllItems() {
		return personDAO.getAllItems();
	}

	@Override
	public void addPerson(String name, Integer age) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("insert into person(name, age) values (?,?)", name, age);

	}

	@Override
	public void deletePerson(Integer id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("delete from person where id=" + id);
	}

	@Override
	public long getGeneratedKey(String name, Integer age) {
		// TODO Auto-generated method stub
		return 0;
	}

}
