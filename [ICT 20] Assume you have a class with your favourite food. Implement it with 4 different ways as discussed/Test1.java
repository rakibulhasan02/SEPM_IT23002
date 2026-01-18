class FavouriteFood {
    String name;

    FavouriteFood(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Favourite food: " + name);
    }
}

public class Test1 {
    public static void main(String[] args) {
        FavouriteFood food1 = new FavouriteFood("Biryani");
        food1.show();
    }
}
