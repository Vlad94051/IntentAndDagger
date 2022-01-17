package ru.tms.myapplication.data.model

import android.util.Log

interface StubUtil {
    fun print()
}

class StubUtilImpl(
    val a: A,
    val b: B,
    val c: C,
    val d: D
) : StubUtil {

    override fun print() {
        Log.e("!!!:", "a: $a, \nb: $b\n c: $c \n" +
                "d: $d")
    }
}

val stubUtil: StubUtil = StubUtilImpl(
    a = A(
        D()
    ),
    b = B(
        C(
            A(
                D()
            )
        )
    ),
    c = C(
        A(
            D()
        )
    ),
    d = D()
)