function runtest(teamKey) {
    /*
    * Write your code below; return type and arguments should be according to the problem's requirements
    */

    let request = new XMLHttpRequest();
    request.open('GET', 'https://raw.githubusercontent.com/openfootball/football.json/198f60ce50ac427dadc16a35ef4ad65edcea3125/2014-15/en.1.json', false);
    request.send(null);

    let resp;
    if (request.status === 200) {
        resp = JSON.parse(request.responseText);
    }


    goals = null;
    return goals;
}

// runtest("arsenal");


/////////////////////////////////////////////////////////////////////


function single_student_number(student_list) {
    /*
    * Write your code below; return type and arguments should be according to the problem's requirements
    */
    // sort the array

    var single_student_number = null;
    var size = student_list.length - 1;

    if (3 > size > 10000) {
        return single_student_number;
    }


    student_list.sort();

    var j = 1;
    for (var i = 0; i < student_list.length; i++) {

        if (2 > student_list[i] > 100000) {
            return single_student_number;
        }

        if (student_list[i] !== student_list[j]
            && student_list[j] === student_list[j + 1]) {
            single_student_number = student_list[i];
            return single_student_number;

        }

        i++;
        j = j + 2;


    }

    return single_student_number;
}


//////////////////////////////////////////////////////////////////////////////////

/**
 *Maximum possible sum of a contiguous subarray
 *
 * For an array with n elements, a = (a1, a2, a3, … , an),
 * find the maximum possible sum of a contiguous subarray.
 * If the maximum element is bigger than the sum, return that element.
 *
 * @param a
 * @returns {*}
 */
function run(a) {
    /*
    * Write your code below; return type and arguments should be according to the problem's requirements
    */

// Kadane's Algorithm

    var size = a.length;
    var max_so_far = 0;
    var max_ending_here = 0;
    var max_neg = a[0];
    var has_pos = false;


    for (var i = 0; i < size; i++) {
        max_ending_here = max_ending_here + a[i];

        if (max_so_far < max_ending_here) {
            max_so_far = max_ending_here;
        }
        if (max_ending_here < 0) {
            max_ending_here = 0;
        }
        if (max_neg < 0 && max_neg < a[i]) {
            max_neg = a[i];
        }

        if (a[i] >= 0) {
            has_pos = true;
        }

    }

    if (!has_pos) {
        return max_neg;
    }

    maximum_sum = max_so_far;


    return maximum_sum;
}