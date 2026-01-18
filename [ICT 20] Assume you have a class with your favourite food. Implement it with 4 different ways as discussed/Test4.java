import java.io.*;

class FavouriteFood implements Serializable {
    String name;

    FavouriteFood(String name) {
        this.name = name;
    }

    void show() {
        System.out.println("Favourite food: " + name);
    }
}

public class Test4 {
    public static void main(String[] args) throws Exception {

        FavouriteFood food1 = new FavouriteFood("Pasta");

        ObjectOutputStream out =
            new ObjectOutputStream(new FileOutputStream("food.txt"));
        out.writeObject(food1);
        out.close();

        ObjectInputStream in =
            new ObjectInputStream(new FileInputStream("food.txt"));
        FavouriteFood food2 = (FavouriteFood) in.readObject();
        in.close();

        food2.show();
    }
}
