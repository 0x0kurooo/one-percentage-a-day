class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
        Naive solution
        - Merge 2 arrays
        - Then pick median
        - If n + m is odd, then return middle
        - Else return avarage if 2 middle numbers
        */

        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int middle = (m + n) / 2 + 1;
        float cur = 0;
        float prev = 0;

        while (i < m && j < n && (i + j) < middle) {
            prev = cur;
            if (nums1[i] < nums2[j]) {
                cur = nums1[i];
                i++;
            } else {
                cur = nums2[j];
                j++;
            }
        }
        while (i < m && (i + j) < middle) {
            prev = cur;
            cur = nums1[i];
            i++;
        }
        while (j < n && (i + j) < middle) {
            prev = cur;
            cur = nums2[j];
            j++;
        }

        if ((n + m) % 2 == 1) {
            return cur;
        } else {
            return (cur + prev) / 2;
        }
    }
}
