package com.amap.api.col.p0003sl;

import android.content.ContentResolver;

/* JADX INFO: Access modifiers changed from: package-private */
@jb(a = "update_item_file")
/* renamed from: com.amap.api.col.3sl.bj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bj.class */
public class bj {
    @jc(a = "mAdcode", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f4780a;
    @jc(a = ContentResolver.SCHEME_FILE, b = 6)
    private String b;

    public bj() {
        this.f4780a = "";
        this.b = "";
    }

    public bj(String str, String str2) {
        this.f4780a = "";
        this.b = "";
        this.f4780a = str;
        this.b = str2;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }

    public final String a() {
        return this.b;
    }
}
