import java.util.BitSet;

public class LongWord {

    private BitSet longWord;

    public LongWord(){
        this.longWord = new BitSet(32);
        for (int i = 0; i < 32; i++) {
            this.longWord.set(i,false);
        }


    }

    public void setBit(int i, boolean status){
        this.longWord.set(i,status);
    }

    public boolean getBit(int i){
        return this.longWord.get(i);
    }


    public String toString(){
        String bit = "";
        for (int i = 32; i > 0; --i) {
            if(this.longWord.get(i)){
                bit = bit + "1";
            }else{
                bit = bit + "0";
            }
            if( i%4 == 1){
                bit = bit + " ";
            }
        }
        return bit + "  " + bitToHax() + "  " + bitToDec();
    }

    private String bitToHax(){
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

    private int bitToDec(){
        int dec = 0;
        for (int i = 0; i < 32; i++) {
            if(this.longWord.get(i)){
                dec = (int) (dec + Math.pow(2,i));
            }
        }
        return dec;
    }
}
