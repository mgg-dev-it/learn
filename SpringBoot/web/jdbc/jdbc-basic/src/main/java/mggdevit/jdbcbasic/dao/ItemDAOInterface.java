package mggdevit.jdbcbasic.dao;

import java.util.List;

import mggdevit.jdbcbasic.entity.Item;

public interface ItemDAOInterface {
	List<Item> getAllItems();
}
