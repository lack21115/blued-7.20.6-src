package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/c2.class */
public class c2 extends JsonComposer {
    @Json(ignore = true)

    /* renamed from: a  reason: collision with root package name */
    public String f37337a;
    @Json(name = "md5")
    public String b;
    @Json(name = "pinyin")

    /* renamed from: c  reason: collision with root package name */
    public String f37338c;
    @Json(name = "size")
    public int d;
    @Json(name = "ver")
    public int e;

    public String a() {
        return this.f37338c + ".dat";
    }

    public boolean a(OfflineItem offlineItem) {
        return offlineItem.getPinyin().equals(this.f37338c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0072, code lost:
        if (r0.equals(r4.b) == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.tencent.mapsdk.internal.ic r5) {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r5
            if (r0 == 0) goto L77
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            r1 = r4
            java.lang.String r1 = r1.f37338c
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r9
            java.lang.String r1 = "-md5"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r9
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.d(r1)
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r10
            r1 = r4
            java.lang.String r1 = r1.f37338c
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r10
            java.lang.String r1 = "-version"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r10
            java.lang.String r1 = r1.toString()
            r2 = -1
            int r0 = r0.a(r1, r2)
            r6 = r0
            r0 = r4
            int r0 = r0.e
            r1 = r6
            if (r0 != r1) goto L75
            r0 = r8
            r7 = r0
            r0 = r9
            if (r0 == 0) goto L77
            r0 = r8
            r7 = r0
            r0 = r9
            r1 = r4
            java.lang.String r1 = r1.b
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L77
        L75:
            r0 = 1
            r7 = r0
        L77:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.c2.a(com.tencent.mapsdk.internal.ic):boolean");
    }

    public String b() {
        return this.f37337a + File.separator + this.f37338c + this.e + ".zip";
    }

    public void b(ic icVar) {
        if (icVar != null) {
            icVar.b(this.f37338c + "-md5", this.b);
            icVar.b(this.f37338c + "-version", this.e);
        }
    }

    public String c() {
        return this.f37338c + ".zip";
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("OfflineMapConfigCity{");
        stringBuffer.append("url='");
        stringBuffer.append(this.f37337a);
        stringBuffer.append('\'');
        stringBuffer.append(", md5='");
        stringBuffer.append(this.b);
        stringBuffer.append('\'');
        stringBuffer.append(", pinyin='");
        stringBuffer.append(this.f37338c);
        stringBuffer.append('\'');
        stringBuffer.append(", size=");
        stringBuffer.append(this.d);
        stringBuffer.append(", version=");
        stringBuffer.append(this.e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
