package src.main.java.com.metehanmengen.example7.dao;

import src.main.java.com.metehanmengen.example7.model.Realty;

import java.util.ArrayList;
import java.util.List;


public class RealtyDao implements IRepository<Realty, Long> {
	
	private static List<Realty> realtyList = new ArrayList<>();

	@Override
	public List<Realty> findAll(){
		return realtyList;
	}

	@Override
	public void save(Realty realty)
	{
		realtyList.add(realty);
	}
}
