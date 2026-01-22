/**
 * @param {string} s
 * @return {number}
 */
var reverseDegree = function(s) {
    let ans = 0;
    for (let i = 0; i < s.length; i++) {
        let number = 123 - s.charCodeAt(i);
        ans += (number * (i + 1));
    }
    return ans;
};