public class ExBeJVM1 {
    public static void main (String [] args) {
        ExBeJVM1 output = new ExBeJVM1();
        output.go();
    }

    void go () {
        int value = 7;
        for (int i = 1; i <8; i++) {
            value++;
            if (i>4) {
                System.out.print(++value + " ");
            } //end if1
            if (value >14) {
                System.out.println(" i = " + i);
                break;
            } // end if2
            } // end for
        } //end methodGo
    } // end class

