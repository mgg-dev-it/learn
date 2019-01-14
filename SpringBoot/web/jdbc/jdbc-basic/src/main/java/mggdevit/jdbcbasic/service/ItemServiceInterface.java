package mggdevit.jdbcbasic.service;

import java.util.List;

import mggdevit.jdbcbasic.entity.Item;


public interface ItemServiceInterface {
	List<Item> getAllItems();
	// Item getItemById(int itemId);
	// boolean addItem(Item item);
	// void updateItem(Item item);
	// void deleteItem(int itemId);
}
