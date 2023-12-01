package com.igexin.push.core.b;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/b/j.class */
public final class j implements Comparable<j> {

    /* renamed from: a  reason: collision with root package name */
    public long f23444a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f23445c;
    public String d;
    public byte[] e;
    public byte[] f;
    public String g;
    public int h;
    public long i;
    private String j;
    private long k;
    private int l;
    private long m;
    private int n;
    private int o;

    public j(long j, String str, String str2, String str3, byte[] bArr, byte[] bArr2, String str4, int i, long j2) {
        this.f23444a = j;
        this.b = str;
        this.f23445c = str2;
        this.d = str3;
        this.e = bArr;
        this.f = bArr2;
        this.g = str4;
        this.h = i;
        this.i = j2;
    }

    public j(byte[] bArr, String str, long j) {
        this.f = bArr;
        this.j = str;
        this.k = j;
    }

    private int a(j jVar) {
        return (int) (this.k - jVar.k);
    }

    private void a(int i) {
        this.h = i;
    }

    private void a(long j) {
        this.f23444a = j;
    }

    private void a(String str) {
        this.b = str;
    }

    private void a(byte[] bArr) {
        this.f = bArr;
    }

    private long b() {
        return this.f23444a;
    }

    private void b(int i) {
        this.l = i;
    }

    private void b(long j) {
        this.i = j;
    }

    private void b(String str) {
        this.f23445c = str;
    }

    private void b(byte[] bArr) {
        this.e = bArr;
    }

    private String c() {
        return this.b;
    }

    private void c(int i) {
        this.n = i;
    }

    private void c(long j) {
        this.k = j;
    }

    private void c(String str) {
        this.d = str;
    }

    private String d() {
        return this.f23445c;
    }

    private void d(int i) {
        this.o = i;
    }

    private void d(long j) {
        this.m = j;
    }

    private void d(String str) {
        this.g = str;
    }

    private String e() {
        return this.d;
    }

    private void e(String str) {
        this.j = str;
    }

    private String f() {
        return this.g;
    }

    private int g() {
        return this.h;
    }

    private long h() {
        return this.i;
    }

    private int i() {
        return this.l;
    }

    private long j() {
        return this.m;
    }

    private int k() {
        return this.n;
    }

    private int l() {
        return this.o;
    }

    private byte[] m() {
        return this.f;
    }

    private long n() {
        return this.k;
    }

    private String o() {
        return this.j;
    }

    private byte[] p() {
        return this.e;
    }

    public final JSONObject a() {
        try {
            return new JSONObject(this.j);
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(j jVar) {
        return (int) (this.k - jVar.k);
    }
}
