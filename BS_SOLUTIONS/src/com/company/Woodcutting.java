package com.company;

import java.util.ArrayList;

public class Woodcutting {

    boolean cutTest(ArrayList<Integer> A,long mid,long B){
        long total=0;
        for(long x:A){
            if(x>=mid){
                total+=x-mid;
            }
        }
        if(total>=B)
            return true;
        else
            return false;
    }

    public long solve(ArrayList<Integer> A, int B) {

        long low = 0, max = Integer.MIN_VALUE;
        long output=0;
        long B1=B;

        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
        }
        long high=max;

        long mid = 0;


        while (low <= high) {
            mid = low + (high - low) / 2;

            if(cutTest(A,mid,B1)){
                   output=mid;
                   low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return output;
    }
}
