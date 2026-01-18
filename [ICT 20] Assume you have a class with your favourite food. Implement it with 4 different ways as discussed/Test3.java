class FavouriteFood implements Cloneable {
    String name;

    FavouriteFood(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Favourite food: " + name);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Test3 {
    public static void main(String[] args) throws Exception {
        FavouriteFood food1 = new FavouriteFood("Burger");
        FavouriteFood food2 = (FavouriteFood) food1.clone();
        food2.show();
    }
}
