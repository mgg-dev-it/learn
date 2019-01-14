package mggdevit.jdbcbasic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import mggdevit.jdbcbasic.entity.Item;
import mggdevit.jdbcbasic.entity.ItemRowMapper;

@Repository
public class ItemDAO implements ItemDAOInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Item> getAllItems() {
		String sql = "select id, name, age from person p order by id";

		// RowMapper<Item> rowMapper = new BeanPropertyRowMapper<Item>(Item.class);
		RowMapper<Item> rowMapper = new ItemRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

}
