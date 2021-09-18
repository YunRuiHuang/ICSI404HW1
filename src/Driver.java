/**
 * driver class for begin
 */
public class Driver {
    //
    public static void main(String[] args){

        LongWord longWord = new LongWord();
        longWord.setBit(1,true);
        longWord.setBit(3,true);
        longWord.setBit(5,true);
        System.out.println(longWord.toString());

    }
}
