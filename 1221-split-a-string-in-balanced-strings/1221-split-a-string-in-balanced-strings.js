/**
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
    let ans = 0;
    let count = 0;
    for (let i = 0; i < s.length; i++) {
        let char = s.charAt(i);
        if (char === 'R') {
            count++;
        } else {
            count--;
        }

        if (count === 0) {
            ans++;
        }
    }
    return ans;
};
