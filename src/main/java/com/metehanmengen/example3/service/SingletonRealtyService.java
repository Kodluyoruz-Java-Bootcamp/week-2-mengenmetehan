package src.main.java.com.metehanmengen.example3.service;

import java.util.List;

import src.main.java.com.metehanmengen.example3.dao.RealtyDao;
import src.main.java.com.metehanmengen.example3.model.Realty;
import src.main.java.com.metehanmengen.example3.model.RealtyType;
import src.main.java.com.metehanmengen.example3.model.User;
import src.main.java.com.metehanmengen.example3.model.UserType;

public class SingletonRealtyService {
	
	private RealtyDao realtyDao = new RealtyDao();

	private static SingletonRealtyService instance = null;

	private SingletonRealtyService()
	{

	}

	public SingletonRealtyService getInstance()
	{
		if (instance == null)
			instance = new SingletonRealtyService();

		return instance;
	}

	public void createRealty(Realty realty) {
		
		//userService.printAllUser();
		
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) ) {
			// en fazla 5 ilan girebilir.
			
			System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir.");
		}
			
		realtyDao.save(realty);
		System.out.println("createRealty :: " + realty.getTitle());
	}
	
	public List<Realty> getAll(){
		return realtyDao.findAll();
	}
	
	public void printAll(List<Realty> realtList) {
		realtList.forEach(realty -> System.out.println(realty));
	}

	public void getAllByProvince(String province) {
		
		getAll().stream()
		.filter(realty -> realty.getProvince().equals(province))
		//.count();
		.forEach(realty -> System.out.println(realty));
		
	}
	
	public List<Realty> getAllByUserName(User user){
		return getAll().stream()
		.filter(realty -> realty.getUser().getMail().equals(user.getMail()))
		.toList();		
	}

	public List<Realty> getActiveRealtyByUserName(User user) {
		
		return getAll().stream()
		.filter(realty -> realty.getUser().getName().equals(user.getName()))
		.filter(realty -> RealtyType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}

}
