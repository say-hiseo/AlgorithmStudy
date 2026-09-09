import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);

            if (str.matches("[A-Z]{2}")) {
                list.add(str);
            }
        }

        int same = 0;
        int sizeB = 0;

        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);

            if (str.matches("[A-Z]{2}")) {
                sizeB++;
                if (list.contains(str)) {
                    same++;
                    list.remove(str);
                }
            }
        }

        int total = list.size() + sizeB;

        if (total == 0) {
            return 65536;
        }

        return same * 65536 / total;
    }
}