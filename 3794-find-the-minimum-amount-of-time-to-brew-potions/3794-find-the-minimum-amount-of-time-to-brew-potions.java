// 문제 해결 실패
class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] endTime = new long[skill.length];
        Arrays.fill(endTime, 0);
        //각 포션을 순서대로 처리해야하기에 for문 작동
        for(int i = 0; i < mana.length; ++i){
            long t = 0, maxDiff = 0;
            // 현재 포션에 대해 마법사가 작업 수행함
            for(int j = 0; j < skill.length; ++j){
                // 이전에 제조한 물약의 시간과 현재 물약 제조 시간 비교
                maxDiff = Math.max(maxDiff, endTime[j] - t);
                t += (long)skill[j] * (long)mana[i];
                endTime[j] = t;
            }
            // 계산된 최대 지연 시간을 모든 마법사의 완료 시간에 더해줌
            for(int j = 0; j < skill.length; ++j) endTime[j] += maxDiff;
        }
        //모든 포션 처리가 끝난 후, 마지막 마법사의 최종 작업 완료 시간을 반환
        return endTime[endTime.length-1];
    }
}