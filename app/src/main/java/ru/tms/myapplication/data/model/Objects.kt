package ru.tms.myapplication.data.model

import javax.inject.Inject

class A @Inject constructor(d : D)
class B @Inject constructor(c: C)
class C @Inject constructor(a: A)
class D @Inject constructor()