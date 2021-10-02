public class Solution {
    static final long MAX = 0x1_0000_0000L;


    public String toHex(int num) {
        if (num == 0) return "0";

        long target = num >= 0 ? num : MAX + num;
        StringBuilder sb = new StringBuilder();
        while (target != 0) {
            int mod = (int) (target % 16);
            switch (mod) {
                case 15:
                    sb.append('f');
                    break;
                case 14:
                    sb.append('e');
                    break;
                case 13:
                    sb.append('d');
                    break;
                case 12:
                    sb.append('c');
                    break;
                case 11:
                    sb.append('b');
                    break;
                case 10:
                    sb.append('a');
                    break;
                default:
                    sb.append(mod);
                    break;
            }
            target = target / 16;
        }

        return sb.reverse().toString();
    }
}
