package com.company;

import java.util.ArrayList;

public class BitonicSeq {

    int ascendingBS(ArrayList<Integer> A, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == key) {
                return mid;
            }
            if (A.get(mid) > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    int descendingBS(ArrayList<Integer> A, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == key) {
                return mid;
            }
            if (A.get(mid) < key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    int findBitonicPoint(ArrayList<Integer> A, int low, int high) {

        int mid=0;
        while(low<=high){
              mid=low+(high-low)/2;
            if (A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                return mid;
            } else {
                if (A.get(mid) > A.get(mid - 1) && A.get(mid) < A.get(mid + 1)) {
                    low=mid+1;
                } else {
                    if (A.get(mid) < A.get(mid - 1) && A.get(mid) > A.get(mid + 1)){
                        high=mid-1;
                    }
                }
            }
        }
        return mid;
    }

    public int solve(ArrayList<Integer> A, int B) {

        int low = 0;
        int high = A.size() - 1;
        int index = findBitonicPoint(A, low, high);

        int x=ascendingBS(A,low,index,B);
        int y=descendingBS(A,index+1,high,B);

      if(x!=-1)
          return x;
      if(y!=-1)
          return y;

      return -1;
    }
}
