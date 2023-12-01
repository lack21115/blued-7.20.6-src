package com.amap.api.col.p0003sl;

/* JADX INFO: Access modifiers changed from: package-private */
@jb(a = "update_item_download_info")
/* renamed from: com.amap.api.col.3sl.bi  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bi.class */
public class bi {
    @jc(a = "mAdcode", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f4778a;
    @jc(a = "fileLength", b = 5)
    private long b;
    @jc(a = "splitter", b = 2)

    /* renamed from: c  reason: collision with root package name */
    private int f4779c;
    @jc(a = "startPos", b = 5)
    private long d;
    @jc(a = "endPos", b = 5)
    private long e;

    public bi() {
        this.f4778a = "";
        this.b = 0L;
        this.f4779c = 0;
        this.d = 0L;
        this.e = 0L;
    }

    public bi(String str, long j, int i, long j2, long j3) {
        this.f4778a = "";
        this.b = 0L;
        this.f4779c = 0;
        this.d = 0L;
        this.e = 0L;
        this.f4778a = str;
        this.b = j;
        this.f4779c = i;
        this.d = j2;
        this.e = j3;
    }

    public static String a(String str) {
        return "mAdcode='" + str + "'";
    }
}
