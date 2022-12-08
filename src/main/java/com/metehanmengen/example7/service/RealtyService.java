package src.main.java.com.metehanmengen.example7.service;

import src.main.java.com.metehanmengen.example7.dao.RealtyDao;
import src.main.java.com.metehanmengen.example7.model.*;

import java.util.List;

public class RealtyService {
	
	private RealtyDao realtyDao = new RealtyDao();


	public void createRealty(Realty realty) {
		
		//userService.printAllUser();
		
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType()) ) {
			// en fazla 5 ilan girebilir.
			
			System.out.println("Bireysel kullanıclar en fazla 5 ilan girebilir.");
		}

		//Bireysel kullanıcılar sadece 3 adet ilan verebilir
		if (UserType.INDIVIDUAL.equals(realty.getUser().getType())) {
			if (!realty.getUser().getType().equals(RealtyType.HOUSE)) {
				System.out.println("Bireysel kullanıcılar sadece konut ilanı verebilir");
				return;
			}
			if (realty.getUser().getRealtyList().size() >= 3) {
				System.out.println("Bireysel kullanıcılar sadece 3 adet ilan verebilir");
				return;
			}
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
		.filter(realty -> RealtyAccountType.ACTIVE.equals(realty.getStatus()))
		.toList();

	}

	// Şehir ve ilçe bazlı ilan arama
	public List<Realty> getAllByDistrict(String province, String district)
	{
		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(province))
				.filter(realty -> realty.getProvince().equals(district))
				.toList();
	}

	public void getAllAtIstanbulProvince() {

		getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ISTANBUL))
				.limit(10)
				.forEach(realty -> System.out.println(realty));
	}

	public void getAllAtAnkaraProvince() {

		getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ANKARA))
				.limit(10)
				.forEach(realty -> System.out.println(realty));
	}

	public void getAllAtIzmirProvince() {

		getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.IZMIR))
				.limit(10)
				.forEach(realty -> System.out.println(realty));
	}

	//Şehirdeki ilan sayıları
	public long countOfIstanbulProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ISTANBUL))
				.count();
	}

	public long countOfAnkaraProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ANKARA))
				.count();
	}

	public long countOfIzmirProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.IZMIR))
				.count();
	}

	//Şehirdeki satılık ilan sayıları
	public long countOfSalesIstanbulProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ISTANBUL))
				.filter(realty -> realty.isSale())
				.count();
	}

	public long countOfSalesAnkaraProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.ANKARA))
				.filter(realty -> realty.isSale())
				.count();
	}

	public long countOfSalesIzmirProvince() {

		return getAll().stream()
				.filter(realty -> realty.getProvince().equals(ProvinceNames.IZMIR))
				.filter(realty -> realty.isSale())
				.count();
	}




}
