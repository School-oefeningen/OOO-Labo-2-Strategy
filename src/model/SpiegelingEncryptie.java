package model;

public class SpiegelingEncryptie implements GeheimschriftBehavior {


    @Override
    public String decodeer(String s) {
        return codeer(s);

    }

    @Override
    public String codeer(String s) {
        StringBuilder mirror = new StringBuilder();
        mirror.append(s);
        mirror = mirror.reverse();
        return mirror.toString();
    }
}
