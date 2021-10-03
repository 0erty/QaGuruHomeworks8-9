package domain;

public enum MenuItems {
    Search("All"),
    Images("Images"),
    Video("Videos");

    private String name;

    MenuItems(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
