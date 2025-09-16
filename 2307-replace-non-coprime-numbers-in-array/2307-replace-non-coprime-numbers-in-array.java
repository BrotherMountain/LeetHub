class Solution {
  public List<Integer> replaceNonCoprimes(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
      long current = num;
      while (!stack.isEmpty() && gcd(stack.peek(), current) > 1) {
        long top = stack.pop();
        current = lcm(top, current);
      }
      stack.push((int) current);
    }
    return stack.stream().toList();
  }

  private Long gcd(long x, long y) {
    if (y == 0) {
      return x;
    }
    return gcd(y, x % y);
  }

  private long lcm(long a, long b) {
    return (a / gcd(a, b)) * b;
  }
}