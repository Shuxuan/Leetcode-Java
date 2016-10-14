package bitoperation;

import java.util.BitSet;

/**
 * Created by shuxuannie on 8/4/16.
 */
public class BitSetTest {

    int smallestFreeIndex;
    int max;
    BitSet bitset;

    public BitSetTest(int maxNumber) {
        this.max = maxNumber;
        this.bitset = new BitSet(max);
    }

    public int get() {
        // handle bitset fully allocated
        if(smallestFreeIndex == max) {
            return -1;
        }
        int num = smallestFreeIndex;
        bitset.set(smallestFreeIndex);
        //Only scan for the next free bit, from the previously known smallest free index
        smallestFreeIndex = bitset.nextClearBit(smallestFreeIndex);
        return num;
    }

    public static void main(String[] args) {
        BitSetTest bitsetTest = new BitSetTest(3);
        System.out.println(bitsetTest.get());
        System.out.println(bitsetTest.get());
        System.out.println(bitsetTest.get());
        System.out.println(bitsetTest.get());
    }
}
