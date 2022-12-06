package src.main.java.com.metehanmengen.example2.creational_design_patterns.factory_method;


import java.util.Random;

public class Factory {
    public static void main(String[] args) {
        Coupon coupon1 = CouponFactory.getCoupon(30);
        System.out.println(String.format("Coupon code: %s, message: %s", coupon1.code(), coupon1.message()));

        Coupon coupon2 = CouponFactory.getCoupon(50);
        System.out.println(String.format("Coupon code: %s, message: %s", coupon2.code(), coupon2.message()));
    }
}

//Kupon interface'i ile code ve message tutuyoruz.
interface Coupon{
    String code();
    String message();
}

class FoodCoupon implements Coupon{
    Random random = new Random();
    @Override
    public String code() {
        return "" + random.nextInt(10000);
    }

    @Override
    public String message() {
        return "I am a food coupon";
    }
}

class ElectronicsCoupon implements Coupon{
    Random random = new Random();
    @Override
    public String code() {
        return "" + random.nextInt(10000);
    }

    @Override
    public String message() {
        return "I am an electronics coupon";
    }

}

class CouponFactory{
    public static Coupon getCoupon(int points){
        if(points < 50){
            return new FoodCoupon();
        }
        return new ElectronicsCoupon();
    }
}

