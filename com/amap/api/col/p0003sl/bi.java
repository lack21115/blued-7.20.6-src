package com.amap.api.col.p0003sl;

/* JADX INFO: Access modifiers changed from: package-private */
@jb(a = "update_item_download_info")
/* renamed from: com.amap.api.col.3sl.bi  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bi.class */
public class bi {
    @jc(a = "mAdcode", b = 6)
    private String a;
    @jc(a = "fileLength", b = 5)
    private long b;
    @jc(a = "splitter", b = 2)
    private int c;
    @jc(a = "startPos", b = 5)
    private long d;
    @jc(a = "endPos", b = 5)
    private long e;

    public bi() {
        this.a = "";
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    public bi(String str, long j, int i, long j2, long j3) {
        this.a = "";
        this.b = 0L;
        this.c = 0;
        this.d = 0L;
        this.e = 0L;
        this.a = str;
        this.b = j;
        this.c = i;
        this.d = j2;
        this.e = j3;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }
}
