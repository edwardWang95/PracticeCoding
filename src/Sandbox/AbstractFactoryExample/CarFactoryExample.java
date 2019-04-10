package Sandbox.AbstractFactoryExample;

import javax.security.auth.login.Configuration;
import java.util.Scanner;

/**
 * Scanner scanner = new Scanner(System.in);
 *         System.out.println("Type in brand: HONDA/TOYOTA/SUBARU");
 *         String brand = scanner.nextLine();
 * */
public class CarFactoryExample {
    public static void main(String[] args){
        //System Configuration
        Configuration configuration = Configuration.getConfiguration();
        //Configure car brand
        CarBrand carBrand = CarBrand.valueOf(configuration.getType());
        Car car = null;
        switch (carBrand){
            case HONDA:
                car = new Honda();
                ((Honda) car).setupSpotify();
                break;
            case TOYOTA:
                car = new Toyota();
                ((Toyota) car).setupPandora();
                break;
            case SUBARU:
                car = new Subaru();
                ((Subaru) car).setupAppleMusic();
                break;
        }
        Client app = new Client(car);
    }
}

class Client {
    private Car car;
    public Client(Car car){
        this.car = car;
        car.setupGPS();
        car.connectToGPS();
    }
}

interface Car{
    void setupGPS();
    void connectToGPS();
}
enum CarBrand{
    HONDA, TOYOTA, SUBARU
}

//Honda
class Honda implements Car{
    @Override
    public void setupGPS() {
        System.out.println("Setup Honda GPS");
    }
    @Override
    public void connectToGPS() {
        System.out.println("Connected to Honda GPS");
    }
    public void setupSpotify(){
        System.out.println("Logged into Spotify");
    }
}

//Toyota
class Toyota implements Car{
    @Override
    public void setupGPS() {
        System.out.println("Setup Toyota GPS");
    }
    @Override
    public void connectToGPS() {
        System.out.println("Connected to Toyota GPS");
    }
    public void setupPandora(){
        System.out.println("Logged into Pandora");
    }
}

//Subaru
class Subaru implements Car{
    @Override
    public void setupGPS() {
        System.out.println("Setup Subaru GPS");
    }
    @Override
    public void connectToGPS() {
        System.out.println("Connected to Subaru GPS");
    }
    public void setupAppleMusic(){
        System.out.println("Logged into AppleMusic");
    }
}