package domain.raj.user.com.flagtest;

public class StaticMethodOver {
    protected int protectedL = 0;
    int protectedDefault = 0;

    /*static method can overload as final and private */
    static int showMeS() {
        return 0;
    }

    int showMeS(int r) {
        return 0;
    }

    protected Number showMe() {
        return 0;
    }

    protected void defaulttest() {

    }
    /*public int showMe() {

return 0;
    }*/
}

class B extends StaticMethodOver {
    @Override
    public Integer showMe() {
        super.showMe();
        int dd = protectedDefault;
        return 0;
    }

    /*@Override
    int showMeS() {
        return super.showMeS();
    }*/
}
