// 문제 조건: 최대 애너지 반환
// 시작점 하나 선택 후 배열 끝에 도달할 때까지 정수 k 만큼 순간이동
// 접근 방식: 동적 프로그래밍 방식
// 생각 : energy 하나 선택해서 이동했을 때의 얻을 에너지 양 중에서 가장 큰 양을 선택
// 문제 : 하나하나 전부 탐색을 해야하기에 시간복잡도가 큼
// 이미 간 경로 탐색을 다시 안 하면 되긴 함
class Solution {
  public int maximumEnergy(int[] energy, int k) {
    int n = energy.length;
    int ans = Integer.MIN_VALUE;
    for (int i = n - k; i < n; i++) {
        int sum = 0;
        for (int j = i; j >= 0; j -= k) {
            sum += energy[j];
            ans = Math.max(ans, sum);
        }
    }
    return ans;
  }
}