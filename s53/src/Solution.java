import java.util.Arrays;

/* https://leetcode-cn.com/problems/boats-to-save-people/  */
public class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            ans++;
        }


        return ans;
    }
}
