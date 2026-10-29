public class Test {
    public static void main(String[] args) {
        /* Excercise 1
        * abc : valid
        * _under_bar_ : valid
        * 9qdf : invalid
        * m928134 : valid
        * t5 : valid
        * me@var : invalid
        * j7 : valid
        * transient : invalid
        * her_sales$ :invalid
        * var : valid
        * some# : invalid
        * if : invalid
        * */

        // Excercise 2 : Will the following compile? Predict and try out.
        //a) boolean b = 1;  ==> Don't compile : must be true or false
        //b) boolean b = FALSE;  ==> Don't compile : must be true or false (not FALSE in upper case)
        //c) byte b = -128;  ==> Compile (the lime is -127 -> 127)
        //d) char c = 5;  ==> Compile : should be a caharcter but that will compile
        //e) char c = “c”;  ==> Don't compile : the character is between '
        //f) char c = -2;  ==> Don't compile : but not sure...
        /*g) int x;   ==> Compile
        char c='c';
        x=c;*/
        //h) float f= 5;    ==> Compile: the conversion is done automatically
        //i) float f= 5.0;  ==> Compile ==> That not compile because 5.0 is considerate like double and not float...
        //                                   And double has more precision...
        /*j) double d = 5;  ==> Compile: Converion double to float didn't work automatically...
        float f = d;*/
        /*k) double d = 5;  ==> Compile: the conversion is forced with (float)
        float f = (float)d;*/
        //l) long l = 6;    ==> Compile: the conversion is done automatically
        //m) long l = 123_456_789;  ==> Compile O_O
        /*n) long l = 12345; ==> Don't compile: we risk to lost precision
        int i=l;*/
        /*o) long l = 12345;  ==> Compile : Conversion forced by the programmer
        int i=(int)l;*/
        //p) int i = 012; // What is the value of i?
        // After sout -> i  = 10, why because 012 ies 12 in Octal and then 10 in decimal.
        //q) int i= 0x12_E; // What is the value of i?
        //r) Try out other things you think of...*/


        /* Excercise 3. What is the value of x after each statement is performed?
        a) int x = 7 + 3 * 6 / 4 - 1;
           int x = 7 + 18 / 4 -1;
           int x = 7 + 4 - 1;
           int x = 11 - 1;
           int x = 10;
           */
        System.out.println("a) x=" + (7 + 3 * 6 / 4 - 1));
        /*
        b) int x = 5 % 3 + 2 * 4 - 3 / 2;
           int x = 2 + 8 - 1;
           int x = 10 -1 ;
           int x = 9;
           */
        System.out.println("b)x=" + (5 % 3 + 2 * 4 - 3 / 2));
        /*
        c) int x = (3 * 9 * (3 - (9 * 3 / (3))));
           int x = (3 * 9 * (3 - (9 * 3 / 3)));
           int x = (3 * 9 * (3 - (27 / 3)));
           int x = (3 * 9 * (3 - 9));
           int x = (27 * (-6));
           int x = -162
        */
        System.out.println("x)x=" + (3 * 9 * (3 - (9 * 3 / (3)))));




        // Ecercise 4 . What is the result of following code fragments. Predict and try out.
        System.out.println("Excercise 4");
        //a) System.out.println(5+3 == 5*4);  ==> false
        System.out.print("a)");
        System.out.println(5+3 == 5*4);
        //b) System.out.println(5+(3 == 5)*4);  ==> une erreur ???
        //System.out.println(5+(3 == 5)*4);
        //c) System.out.println(“5”+(3 == 5)+”4”);  ==> une erreur (c'est faux)
        System.out.print("c)");
        System.out.println("5"+(3 == 5)+"4");
        //d) System.out.println(5*3 + “6”); ==> 156
        System.out.print("d)");
        System.out.println(5*3 + "6");
        //e) System.out.println("6" + 5 + 3*6); ==>  6518
        System.out.print("e)");
        System.out.println("6" + 5 + 3*6);
        //f) System.out.println( “6” + 5 + 3); ==> 615
        System.out.print("f)");
        System.out.println( "6" + 5 + 3);
        //g) System.out.println(“6” + (5 + 3*6)); ==> 623
        System.out.print("g)");
        System.out.println("6" + (5 + 3*6));
        //h) byte i = 5; byte j = 6; byte k = i+j;  ==> k = 11;   ==> Error because the calculation is converted to int...
        //i) int i = 5; int j = 6; j+=i;  ==> j = 11;
        int i = 5; int j = 6; j+=i;
        System.out.print("i)" + j);
        //int k = i++ + ++j;
        //System.out.println(k);
        //j) boolean b= false;
        //System.out.println(b=false);  ==> true;
        System.out.print("j)");
        boolean b= false;
        System.out.println(b=false);
        //k) System.out.println( 5!=4?6:3);  ==> 6
        System.out.print("k)");
        System.out.println( 5!=4?6:3);
        //l) Try out other things you think of...
    }
}
