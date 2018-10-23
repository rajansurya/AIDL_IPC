package domain.raj.user.com.flagtest;

public class Stringmanupulation {
    /*Move character to 2 postion ahead*/
    void moveCharacter(String arr[], String temp[], int n, int moveto) {
        for (int i = 0; i < arr.length; i++) {
            int nextelement = (i + moveto) % n;
            temp[nextelement]=arr[i];
        }
    }
}
