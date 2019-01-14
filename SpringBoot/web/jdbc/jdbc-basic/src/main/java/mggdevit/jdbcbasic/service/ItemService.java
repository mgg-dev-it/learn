package mggdevit.jdbcbasic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mggdevit.jdbcbasic.dao.ItemDAOInterface;
import mggdevit.jdbcbasic.entity.Item;


@Service
public class ItemService implements ItemServiceInterface{

	@Autowired
	private ItemDAOInterface itemDAO;
	
	@Override
	public List<Item> getAllItems() {
		return itemDAO.getAllItems();
	}
	
}
