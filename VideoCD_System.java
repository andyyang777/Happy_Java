package MyPackage;

public class MyVideoCD {
    private String title;
    private boolean avaliability;

    public MyVideoCD(String t) {
        title = t;
        avaliability = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvaliability() {
        if (avaliability) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lend() {
        if (avaliability) {
            avaliability = false;
            return true;
        } else {
            return false;
        }
    }

    public void returnCD() {
        avaliability = true;
    }

    public static void main(String[] args) {
        String[] names = {"dogs", "cats", "mouse", "birds", "fish"};
        MyVideoCD[] CDs = new MyVideoCD[5];
        for (int i = 0; i < names.length; i++) {
            CDs[i] = new MyVideoCD(names[i]);
            System.out.print(CDs[i].getTitle() + " " + CDs[i].isAvaliability() + "    ");
        }
        System.out.println("\nTest if someone borrows the CD \"dogs\", and then returned it.");
        MyVideoCD dogs = CDs[0];
        System.out.println(dogs.isAvaliability());
        dogs.lend();
        System.out.println(dogs.isAvaliability());
        dogs.returnCD();
        System.out.println(dogs.isAvaliability());

    }
}

