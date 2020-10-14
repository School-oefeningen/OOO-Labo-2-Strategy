package model;

public class CaesarEncryptie implements GeheimschriftBehavior{
    private int start;
    private char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public CaesarEncryptie(int start){
        setStart(start);
    }

    private void setStart(int start) {
        this.start = start;
    }

    @Override
    public String decodeer(String s) {
        StringBuilder caesar = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()){
            if(c != ' '){
                int oldPosition = c - 'a';
                int newPosition = (oldPosition + this.start) % 26;
                char newChar = (char) ('a' + newPosition);
                caesar.append(newChar);
            }
            else{
                caesar.append(c);
            }
        }
        return caesar.toString();
    }

    @Override
    public String codeer(String s) {
        StringBuilder caesar = new StringBuilder();
        for(char c: s.toLowerCase().toCharArray()){
            if(c != ' '){
                int oldPosition = c - 'a';
                int newPosition = (oldPosition + (26 -this.start)) % 26;
                char newChar = (char) ('a' + newPosition);
                caesar.append(newChar);
            }
            else{
                caesar.append(c);
            }
        }
        return caesar.toString();
    }
}
