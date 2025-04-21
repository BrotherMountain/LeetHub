class Solution {
    public  int maximumSum(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        int ans = -1;
        for (int num: nums) {
            int digitSum = getDigitSum(num);
            if (dic.containsKey(digitSum)) {
                ans = Math.max(ans, num + dic.get(digitSum));
            }

            dic.put(digitSum, Math.max(dic.getOrDefault(digitSum, 0), num));
        }

        return ans;
    }

    public  int getDigitSum(int num) {
        //자릿수 더하는 함수
        int digitSum = 0;
        //num이 0보다 클 때 까지
        while (num > 0) {
            //10의 자릿수 구하고 추가함
            digitSum += num % 10;
            //10을 나눠서 1000 => 100, 100 => 10이 됨
            num /= 10;
        }
        return digitSum;
    }
}