import java.util.BitSet;

public class LongWord {

    private BitSet longWord;

    public LongWord(){
        this.longWord = new BitSet(32);
        for (int i = 0; i < 32; i++) {
            this.longWord.set(i,false);
        }


    }

    public void setBit(int i){
        this.longWord.set(i,true);
    }

    public void setBit(int i,boolean status){
        this.longWord.set(i,status);
    }

    public boolean getBit(int i){
        return this.longWord.get(i);
    }

    public void clearBit(int i){
        this.longWord.set(i,false);
    }

    public void toggleBit(int i){

        if(this.longWord.get(i)){
            this.longWord.set(i,false);
        }else{
            this.longWord.set(i,true);
        }
    }

    public void set(int value){
        /*
        if(value == 1){
            for (int i = 0; i < 32; i++) {
                this.longWord.set(i,true);
            }
        }else if(value == 0){
            for (int i = 0; i < 32; i++) {
                this.longWord.set(i,false);
            }
        }
         */

        for (int i = 31; i >= 0; i--) {
            this.longWord.set(i,false);
            if(value >= Math.pow(2,i)){
                value = value - (int)Math.pow(2,i);
                this.longWord.set(i,true);
            }
        }

    }

    public void copy(LongWord other){
        for (int i = 0; i < 32; i++) {
            this.longWord.set(i,other.getBit(i));
        }
    }


    public LongWord shiftLeftLogical(int amount){
        LongWord leftLongWord = new LongWord();
        leftLongWord.copy(this);
        for(int i=0; i < amount; i++){
            for(int a = 31; a > 0; a--){
                leftLongWord.setBit(a,leftLongWord.getBit(a-1));
            }
            leftLongWord.clearBit(0);
        }
        return leftLongWord;
    }

    public LongWord shiftRightLogical(int amount){
        LongWord rightLongWord = new LongWord();
        rightLongWord.copy(this);
        for(int i=0; i < amount; i++){
            for(int a = 0; a < 31; a++){
                rightLongWord.setBit(a,rightLongWord.getBit(a+1));
            }
            rightLongWord.clearBit(31);
        }
        return rightLongWord;
    }

    public LongWord shiftRightArithmetic(int amount){
        LongWord newLongWord = new LongWord();
        newLongWord.copy(this);
        for(int i=0; i < amount; i++){
            for(int a = 0; a < 30; a++){
                newLongWord.setBit(a,newLongWord.getBit(a+1));
            }
            newLongWord.clearBit(30);
        }
        return newLongWord;
    }

    public LongWord not(){
        LongWord notLongWord = new LongWord();
        notLongWord.copy(this);
        for (int i = 0; i < 32; i++) {
            notLongWord.toggleBit(i);
        }

        return notLongWord;
    }

    public LongWord and(LongWord other){
        LongWord andLongWord = new LongWord();
        andLongWord.copy(this);
        for (int i = 0; i < 32; i++) {
            if(andLongWord.getBit(i) && other.getBit(i)){
                andLongWord.setBit(i);
            }else{
                andLongWord.clearBit(i);
            }
        }
        return andLongWord;
    }

    public LongWord or(LongWord other){
        LongWord orLongWord = new LongWord();
        orLongWord.copy(this);
        for (int i = 0; i < 32; i++) {
            if(orLongWord.getBit(i) || other.getBit(i)){
                orLongWord.setBit(i);
            }else{
                orLongWord.clearBit(i);
            }
        }
        return orLongWord;
    }

    public LongWord xor(LongWord other){
        LongWord xorLongWord = new LongWord();
        xorLongWord.copy(this);
        for (int i = 0; i < 32; i++) {
            if(xorLongWord.getBit(i) != other.getBit(i)){
                xorLongWord.setBit(i);
            }else{
                xorLongWord.clearBit(i);
            }
        }
        return xorLongWord;
    }

    public boolean isZeor(){
        if(this.getSigned() == 0){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String bit = "";
        for (int i = 31; i >= 0; i--) {
            if(this.longWord.get(i)){
                bit = bit + "1";
            }else{
                bit = bit + "0";
            }
            if( i%4 == 0){
                bit = bit + " ";
            }
        }
        return bit + "  " + bitToHex() + "  " + getSigned();
    }

    private String bitToHex(){
        String hac = "0x";
        for (int i = 32; i > 0; i=i-4) {
            int dec = 0;
            for(int a=i-4; a < i; a++){
                if(this.longWord.get(a)){
                    dec = (int) (dec + Math.pow(2,4-(i-a)));
                }
            }
            if(dec == 10){
                hac = hac + "A";
            }else if(dec == 11){
                hac = hac + "B";
            }else if(dec == 12){
                hac = hac + "C";
            }else if(dec == 13){
                hac = hac + "D";
            }else if(dec == 14){
                hac = hac + "E";
            }else if(dec == 15){
                hac = hac + "F";
            }else {
                hac = hac + dec;
            }
            //System.out.println(dec +" " + hac);
        }
        return hac;
    }

    public int getSigned(){
        int dec = 0;
        for (int i = 0; i < 31; i++) {
            if(this.longWord.get(i)){
                dec = (int) (dec + Math.pow(2,i));
            }
        }

        if(this.longWord.get(31)){
            dec = dec - 2147483647 - 1;
        }

        return dec;
    }

    public long getUnsigned(){
        long dec = 0;
        for (int i = 0; i < 32; i++) {
            if(this.longWord.get(i)){
                dec = dec + (long)Math.pow(2,i);
            }
        }
        return dec;
    }

}
