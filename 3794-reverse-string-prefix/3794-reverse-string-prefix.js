/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
var reversePrefix = function(s, k) {
    let strings = s.split("");
    for (let i = 0; i < k; i++) {
        if (i < k / 2) {
            let temp = strings[i];
            strings[i] = strings[k - 1 - i];
            strings[k - 1 - i] = temp;
        }
    }
    return strings.join("");
};