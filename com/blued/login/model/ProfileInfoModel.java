package com.blued.login.model;

import com.blued.das.login.LoginAndRegisterProtos;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/model/ProfileInfoModel.class */
public final class ProfileInfoModel implements Serializable {
    private String i;
    private String j;
    private String k;
    private LoginAndRegisterProtos.Source m;

    /* renamed from: a  reason: collision with root package name */
    private String f6955a = "";
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f6956c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private int l = 1;
    private String n = "onclick";
    private String o = "";
    private String p = "";
    private String q = "";

    public final String a() {
        return this.f6955a;
    }

    public final void a(int i) {
        this.l = i;
    }

    public final void a(LoginAndRegisterProtos.Source source) {
        this.m = source;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f6955a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }

    public final String c() {
        return this.f6956c;
    }

    public final void c(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f6956c = str;
    }

    public final String d() {
        return this.d;
    }

    public final void d(String str) {
        Intrinsics.e(str, "<set-?>");
        this.d = str;
    }

    public final String e() {
        return this.e;
    }

    public final void e(String str) {
        Intrinsics.e(str, "<set-?>");
        this.e = str;
    }

    public final String f() {
        return this.f;
    }

    public final void f(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f = str;
    }

    public final String g() {
        return this.h;
    }

    public final void g(String str) {
        Intrinsics.e(str, "<set-?>");
        this.h = str;
    }

    public final String h() {
        return this.i;
    }

    public final void h(String str) {
        this.i = str;
    }

    public final String i() {
        return this.j;
    }

    public final void i(String str) {
        this.j = str;
    }

    public final String j() {
        return this.k;
    }

    public final void j(String str) {
        this.k = str;
    }

    public final int k() {
        return this.l;
    }

    public final void k(String str) {
        Intrinsics.e(str, "<set-?>");
        this.n = str;
    }

    public final LoginAndRegisterProtos.Source l() {
        return this.m;
    }

    public final void l(String str) {
        Intrinsics.e(str, "<set-?>");
        this.o = str;
    }

    public final String m() {
        return this.o;
    }

    public final void m(String str) {
        Intrinsics.e(str, "<set-?>");
        this.p = str;
    }

    public final String n() {
        return this.p;
    }

    public final void n(String str) {
        Intrinsics.e(str, "<set-?>");
        this.q = str;
    }

    public final String o() {
        return this.q;
    }
}
