package src.main.java;


import src.main.java.com.metehanmengen.example7.model.*;
import src.main.java.com.metehanmengen.example7.service.RealtyService;
import src.main.java.com.metehanmengen.example7.service.UserService;

import java.time.LocalDateTime;
import java.util.Collections;

public class Main {
    public static void main(String [] args) {

        User mete = new User("Mete", "mete@gmail.com", "123345", UserType.CORPARETE, Collections.emptyList());
        User ayşe = new User("Ayşe", "ayşe@gmail.com", "123345", UserType.CORPARETE, Collections.emptyList());
        User ali = new User("Ali", "ali@gmail.com", "123345", UserType.CORPARETE, Collections.emptyList());
        User zeynep = new User("Zeynep", "zeynep@gmail.com", "123345", UserType.CORPARETE, Collections.emptyList());

        UserService userService = new UserService();

        userService.createUser(mete);
        userService.createUser(ayşe);
        userService.createUser(ali);
        userService.createUser(zeynep);

        userService.printAllUser();

        RealtyService realtyService = new RealtyService();

        Realty realtyMeteIstanbul = new Realty(1L,"Güzel Ev, İstanbulda", LocalDateTime.now(),
                mete, RealtyAccountType.ACTIVE, RealtyType.HOUSE);
        realtyMeteIstanbul.setProvince(ProvinceNames.ISTANBUL);
        realtyService.createRealty(realtyMeteIstanbul);

        Realty realtyAliAnkara = new Realty(2L,"Güzel Ev, Ankarada", LocalDateTime.now(),
                ali, RealtyAccountType.ACTIVE, RealtyType.HOUSE);
        realtyAliAnkara.setProvince(ProvinceNames.ANKARA);
        realtyService.createRealty(realtyAliAnkara);

        Realty realtyZeynepIstanbul = new Realty(3L,"Güzel Ev, Istanbulda", LocalDateTime.now(),
                zeynep, RealtyAccountType.ACTIVE, RealtyType.HOUSE);
        realtyZeynepIstanbul.setProvince(ProvinceNames.ISTANBUL);
        realtyService.createRealty(realtyZeynepIstanbul);

        Realty realtyAyşeIzmir = new Realty(4L,"Güzel Ev, İzmirde", LocalDateTime.now(),
                ayşe, RealtyAccountType.ACTIVE, RealtyType.HOUSE);
        realtyZeynepIstanbul.setProvince(ProvinceNames.IZMIR);
        realtyService.createRealty(realtyAyşeIzmir);

        Realty realtyMeteIzmir = new Realty(5L,"Güzel Ev, İzmirde", LocalDateTime.now(),
                mete, RealtyAccountType.ACTIVE, RealtyType.HOUSE);
        realtyMeteIzmir.setProvince(ProvinceNames.IZMIR);
        realtyService.createRealty(realtyMeteIzmir);



        System.out.printf("Ankarada %d kadar ilan var " ,realtyService.countOfAnkaraProvince());
        System.out.printf("İstanbulda %d kadar ilan var " ,realtyService.countOfIstanbulProvince());
        System.out.printf("İzmirde %d kadar ilan var " ,realtyService.countOfIzmirProvince());


    }
}
