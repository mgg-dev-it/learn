package mggdevit.jdbcbasic.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper<Item> {

	@Override
	public Item mapRow(ResultSet row, int rowNum) throws SQLException {
		Item item = new Item();
		item.setId(row.getInt("id"));
		item.setName(row.getString("name"));
		item.setAge(row.getInt("age"));
		return item;
	}
}