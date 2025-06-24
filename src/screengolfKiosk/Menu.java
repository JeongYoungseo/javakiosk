package screengolfKiosk;

public class Menu {
    private String name;
    private String[] options;

    public Menu(String name, String[] options) {
        this.name = name;
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public String[] getOptions() {
        return options;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void displayOptions() {
        System.out.println("[메뉴: "+getName()+"]");
        for(int i = 0; i < getOptions().length; i++) {
            System.out.println("- "+getOptions()[i]);
        }
    }
}
