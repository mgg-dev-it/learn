package mggdevit.jdbccrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mggdevit.jdbccrud.entity.Person;
import mggdevit.jdbccrud.entity.PersonRowMapper;

@Repository
public class PersonDAO implements PersonDAOInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Person> getAllItems() {
		String sql = "select id, name, age from person p order by id";

		// RowMapper<Item> rowMapper = new BeanPropertyRowMapper<Item>(Item.class);
		RowMapper<Person> rowMapper = new PersonRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
