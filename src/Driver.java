/**
 * driver class for begin
 */
public class Driver {
    //
    public static void main(String[] args){

        LongWord longWord = new LongWord();
        longWord.setBit(1);
        longWord.setBit(2);
        longWord.setBit(3);
        longWord.setBit(4);
        longWord.setBit(5);
        longWord.clearBit(3);
        longWord.toggleBit(0);
        System.out.println(longWord.toString());

        LongWord longWord2 = new LongWord();
        longWord2.set(1);
        System.out.println(longWord2.toString() + " " + longWord2.getUnsigned());

        System.out.println("1: shift left  " + longWord2.shiftLeftLogical(2).toString());
        System.out.println("2: shift right " + longWord2.shiftRightLogical(2).toString());
        System.out.println("3: shift Arith " + longWord2.shiftRightArithmetic(2).toString());
        System.out.println("4: not         " + longWord2.not().toString());
        System.out.println("5: and         " + longWord2.and(longWord).toString());
        System.out.println("6: or          " + longWord2.or(longWord).toString());
        System.out.println("7: xor         " + longWord2.xor(longWord).toString());


        longWord.setBit(31);
        System.out.println(longWord.toString());
    }
}
