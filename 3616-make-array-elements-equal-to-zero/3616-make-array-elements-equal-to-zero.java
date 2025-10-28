class Solution {
  public int countValidSelections(int[] nums) {
    int n = nums.length;
    int ans = 0;

    for (int i = 0; i < n; i++) {
      int num = nums[i];
      if (num == 0) {
        boolean left = visit(nums, n, i, true);
        boolean right = visit(nums, n, i, false);
        if (left && right) {
          ans += 2;
        } else if (left) {
          ans++;
        } else if (right) {
          ans++;
        }
      }
    }
    return ans;
  }

  private boolean visit(int[] nums, int n, int index, boolean isLeft ) {
    int[] copy = nums.clone();
    while (index >= 0 && index < n) {
      while (copy[index] != 0) {
        copy[index]--;
        isLeft = !isLeft;
        if (isLeft) {
          index--;
        } else {
          index++;
        }
      }
      if (copy[index] == 0) {
        if (isLeft) {
          index--;
        } else {
          index++;
        }
      }
    }

    for (int i : copy) {
      if (i != 0) {
        return false;
      }
    }
    return true;
  }
}