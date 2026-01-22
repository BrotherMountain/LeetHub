/**
 * @param {string} date
 * @return {string}
 */
var convertDateToBinary = function (date) {
    let strings = date.split("-");
    let ans = "";
    for (let i = 0; i < strings.length; i++) {
        let binary = "";
        let num = parseInt(strings[i]);
        while (num > 0) {
            binary = (num % 2) + binary;
            num = Math.floor(num / 2);
        }
        if (i < strings.length - 1) {
            ans += binary + "-";
        } else {
            ans += binary;
        }
    }
    return ans;
};