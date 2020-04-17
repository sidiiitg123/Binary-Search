package com.company;

import java.util.ArrayList;
import java.util.List;

public class SearchRange {

    public int bSearch(List<Integer> A, int B, boolean bool) {
        int low = 0;
        int high = A.size();
        int res = -1;

        while (low < high) {

            int mid = low+(high-low)/2;

            if (A.get(mid) == B) {
                res = mid;
                if (bool) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else if (A.get(mid) > B) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> finalArray = new ArrayList<>();
        int left = bSearch(A, B, true);
        int right = bSearch(A, B, false);
        finalArray.add(left);
        finalArray.add(right);
        return finalArray;
    }
}
