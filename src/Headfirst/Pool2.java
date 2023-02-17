package Headfirst;

public class Pool2 {
    private Integer i;
    private Integer j;
    public static void main (String [] args) {
Pool2 t = new Pool2();
t.go();
    }
    public void go() {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
