// !LANGUAGE: +NewInference
// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_VARIABLE -UNUSED_VALUE
// SKIP_TXT

/*
 * TESTCASE NUMBER: 1
 * ISSUES: KT-28965
 */
inline fun <reified T, reified K> case_1(x: T) {
    if (x is K) {
        <!DEBUG_INFO_EXPRESSION_TYPE("T & T & K")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("T & T & K")!>x<!><!UNSAFE_CALL!>.<!>equals(x)
    }
}

/*
 * TESTCASE NUMBER: 2
 * ISSUES: KT-28965
 */
inline fun <reified T, reified K> case_2(x: T) {
    x as K
    <!DEBUG_INFO_EXPRESSION_TYPE("T & T & K")!>x<!>
    <!DEBUG_INFO_EXPRESSION_TYPE("T & T & K")!>x<!><!UNSAFE_CALL!>.<!>equals(x)
}

/*
 * TESTCASE NUMBER: 3
 * ISSUES: KT-28965
 */
inline fun <reified T, reified K> case_3() {
    var x: T? = 10 as T
    x = null
    if (x is K) {
        <!DEBUG_INFO_EXPRESSION_TYPE("T? & kotlin.Nothing? & K")!>x<!><!UNSAFE_CALL!>.<!>equals(10)
        <!DEBUG_INFO_EXPRESSION_TYPE("T? & kotlin.Nothing? & K")!>x<!>
        println(1)
    }
}

// TESTCASE NUMBER: 4
inline fun <reified T, reified K> case_4(x: T?) {
    if (x is K) {
        <!DEBUG_INFO_EXPRESSION_TYPE("T? & T? & K")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("T? & T? & K")!>x<!><!UNSAFE_CALL!>.<!>equals(x)
    }
}

// TESTCASE NUMBER: 5
inline fun <reified T, reified K> case_5(x: T) {
    if (x is K?) {
        <!DEBUG_INFO_EXPRESSION_TYPE("T & T & K?")!>x<!>
        <!DEBUG_INFO_EXPRESSION_TYPE("T & T & K?")!>x<!><!UNSAFE_CALL!>.<!>equals(x)
    }
}

/*
 * TESTCASE NUMBER: 6
 * ISSUES: KT-28965
 */
inline fun <reified T, reified K> case_6() {
    var x: T? = 10 as T
    if (x is K) {
        x = null
        <!DEBUG_INFO_EXPRESSION_TYPE("T? & kotlin.Nothing?")!>x<!><!UNSAFE_CALL!>.<!>equals(10)
        <!DEBUG_INFO_EXPRESSION_TYPE("T? & kotlin.Nothing?")!>x<!>
        println(1)
    }
}
