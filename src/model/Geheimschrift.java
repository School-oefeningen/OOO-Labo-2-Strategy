package model;

import model.GeheimschriftBehavior;

public class Geheimschrift {
    GeheimschriftBehavior geheimschriftBehavior;

    public Geheimschrift(GeheimschriftBehavior geheimschriftBehavior){
        if(geheimschriftBehavior == null) {
            throw new IllegalArgumentException("GeheimschriftBehaviour mag niet null zijn");
        }
        this.geheimschriftBehavior = geheimschriftBehavior;
    }

    public String decryptString(String s) {
        if(s.trim().isEmpty() || s == null){
            throw new IllegalArgumentException("String mag niet leeg of null zijn");

        }
        return geheimschriftBehavior.decodeer(s);
    }

    public String encryptString(String s) {
        if(s.trim().isEmpty() || s == null) {
            throw new IllegalArgumentException("String mag niet leeg of null zijn");
        }
        return geheimschriftBehavior.codeer(s);
    }
}
