public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        final int INFINITE = -1;
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            int l = mid == 0 ? INFINITE : arr[mid - 1];
            int r = mid == n - 1 ? INFINITE : arr[mid + 1];
            int c = arr[mid];

            if (c > l && c > r) return mid;

            if (c <= r) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
