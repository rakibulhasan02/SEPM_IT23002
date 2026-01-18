class FavouriteFood {
    String name = "Pizza";

    void show() {
        System.out.println("Favourite food: " + name);
    }
}

public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("FavouriteFood");
        FavouriteFood food2 =
            (FavouriteFood) cls.getDeclaredConstructor().newInstance();
        food2.show();
    }
}
