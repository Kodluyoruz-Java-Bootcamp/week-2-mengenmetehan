package src.main.java.com.metehanmengen.example2.creational_design_patterns.abstract_factory_pattern;

abstract class BasicCar {
    BasicCar(CarType model, Location location) {
        this.model = model;
        this.location = location;
    }


    abstract void construct();

    CarType model = null;
    Location location = null;

    CarType getModel() {
        return model;
    }

    void setModel(CarType model) {
        this.model = model;
    }

    Location getLocation() {
        return location;
    }

    void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "CarModel - " + model + " located in " + location;
    }

}

class Sedan extends BasicCar {
    Sedan(Location location) {
        super(CarType.SEDAN, Location.BURSA);
        construct();
    }

    @Override
    void construct() {
        System.out.println("Constructing to Sedan car");
    }
}

class Suv extends BasicCar {
    Suv(Location location) {
        super(CarType.SUV, Location.ANKARA);
        construct();
    }

    @Override
    void construct() {
        System.out.println("Constructing to Suv car");
    }
}

class Pickup extends BasicCar {
    Pickup(Location location) {
        super(CarType.PICKUP, Location.ISTANBUL);
        construct();
    }

    @Override
    void construct() {
        System.out.println("Constructing to Pickup car");
    }
}

enum CarType
{
    SEDAN, PICKUP, SUV
}

enum Location
{
    DEFAULT, ANKARA, BURSA, ISTANBUL
}

class CarFactory
{
    private CarFactory()
    {

    }
    public static BasicCar buildCar(CarType type, Location location)
    {
        BasicCar car = null;


        switch(type)
        {
            case SEDAN:
                car = new Sedan(location);
                break;

            case SUV:
                car = new Suv(location);
                break;

            default:
                car = new Pickup(location);

        }

        return car;

    }
}

class AbstractDesign
{
    public static void main(String[] args)
    {
        System.out.println(CarFactory.buildCar(CarType.SEDAN, Location.ANKARA));
        System.out.println(CarFactory.buildCar(CarType.SUV, Location.BURSA));
        System.out.println(CarFactory.buildCar(CarType.PICKUP, Location.ISTANBUL));
    }
}