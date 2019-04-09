package Sandbox;

import java.util.ArrayList;

/**
 * Abstract factory: Produce families of related objects without specifying their concrete classes.
 * Interface: Abstracts the object to a framework object where you only care about the methods available to that
 *            framework and not the object or its specific type behind it.
 * */
public class Study_AbstractFactory {
    public static void main(String[] args){
        Vendor vendor = Vendor.MAC;
        Application application;
        GUIFactory factory;
        if(vendor == Vendor.MAC){
            factory = new MacFactory();
            application = new Application(factory);
        }else if(vendor == Vendor.WINDOWS){
            factory = new WindowsFactory();
            application = new Application(factory);
        }
    }
}

class Application{
    private Button button;
    private CheckBox checkBox;
    /**
     * Application doesn't care what kind of button from whatever OS, only that the button and checkbox run the
     * standardized methods.
     * */
    public Application(GUIFactory factory){
        button = factory.createButton();
        button.clickButton();
        checkBox = factory.createCheckBox();
        checkBox.displayOptions();
    }
}

//Abstract Fatory
interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
enum Vendor{
    MAC, WINDOWS
}

interface Button{
    void clickButton();
}
interface CheckBox{
    ArrayList<String> options = new ArrayList<>();
    void displayOptions();
}

//Mac
class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
class MacButton implements Button{
    @Override
    public void clickButton() {
        System.out.println("Mac Button");
    }
}
class MacCheckBox implements CheckBox{
    public MacCheckBox(){
        options.add("Safari");
        options.add("Apple Finder");
    }
    @Override
    public void displayOptions() {
        System.out.println("Mac Checkbox");
        for(String option: options){
            System.out.println(option);
        }
    }
}

//Windows
class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
class WindowsButton implements Button{
    @Override
    public void clickButton() {
        System.out.println("WindowsButton");
    }
}
class WindowsCheckBox implements CheckBox{
    public WindowsCheckBox(){
        options.add("Internet Explorer");
        options.add("Windows Explorer");
    }
    @Override
    public void displayOptions() {
        System.out.println("Windows Checkbox");
        for(String option: options){
            System.out.println(option);
        }
    }
}

