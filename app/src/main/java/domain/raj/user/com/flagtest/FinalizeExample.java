package domain.raj.user.com.flagtest;

class FinalizeExample {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize called");
    }

   /* public void finalize() {
        System.out.println("finalize called");
    }*/

    public static void main(String[] args) {
        FinalizeExample f1=new FinalizeExample();
        FinalizeExample f2=new FinalizeExample();
        f1=null;
        f2=null;
        System.gc();
    }
}
