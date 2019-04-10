package Sandbox;

/**
 * Abstract Factory: produce family of related objects without specifying their concrete objects.
 * */
public class AbstractFactory {
    static OS os = OS.MAC;
    public static void main(String[] args){
        GUIFactory factory = null;
        if(os == OS.MAC){
            factory = new MacFactory();
            testMacGUIElements(factory);
        }else if(os == OS.WINDOWS){
            factory = new WindowsFactory();
            testWindowsGUIElements(factory);
        }
    }
    /**
     * The client doesn't care about the underlying OS, only that the methods across are
     * all the same "createGUIElements()" and "clickButton()."
     * */
    private static void testMacGUIElements(GUIFactory factory){
        factory.createGUIElements();
        factory.getButton().clickButton();
        /**
         * Can convert factory interface button into specified object to call its
         * unique methods.
         * */
        MacButton button = (MacButton) factory.getButton();
        button.openTerminal();
    }

    private static void testWindowsGUIElements(GUIFactory factory){
        factory.createGUIElements();
        factory.getButton().clickButton();
        WindowsButton button = (WindowsButton) factory.getButton();
        button.openCommandPrompt();
    }
}

/**
 * Abstract Factory - focused on GUI
 * */
interface GUIFactory{
    void createGUIElements();
    Button getButton();
}
enum OS{
    MAC, WINDOWS
}
interface Button{
    void clickButton();
}

//Mac
class MacFactory implements GUIFactory{
    MacButton button = null;
    @Override
    public void createGUIElements() {
        button =  new MacButton();
    }

    @Override
    public Button getButton() {
        return button;
    }
}
class MacButton implements Button{
    @Override
    public void clickButton() {
        System.out.println("Mac Button");
    }
    public void openTerminal(){
        System.out.println("Open Mac terminal.");
    }
}

//Windows
class WindowsFactory implements GUIFactory{
    WindowsButton button = null;
    @Override
    public void createGUIElements() {
        button = new WindowsButton();
    }

    @Override
    public Button getButton() {
        return button;
    }

}
class WindowsButton implements Button{
    @Override
    public void clickButton() {
        System.out.println("Windows Button");
    }
    public void openCommandPrompt(){
        System.out.println("Open Windows command prompt");
    }
}