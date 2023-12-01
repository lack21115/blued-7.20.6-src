package com.tencent.mapsdk.internal;

import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ei.class */
public class ei extends JsonComposer {
    @Json(name = "name")

    /* renamed from: a  reason: collision with root package name */
    private String f23729a;
    @Json(name = "style")
    private int b;
    @Json(name = "scene")

    /* renamed from: c  reason: collision with root package name */
    private int f23730c;
    @Json(name = "version")
    private int d;
    @Json(name = "url")
    private String e;
    @Json(name = "range")
    private int[] f;

    private int a(int i, int i2) {
        int i3 = i % i2;
        int i4 = i3;
        if (i3 * i2 < 0) {
            i4 = i3 + i2;
        }
        return i4;
    }

    public String a() {
        return this.f23729a;
    }

    public String a(int i, int i2, int i3, String str) {
        String str2 = this.e;
        int[] b = b();
        return (b.length == 0 ? str2.replaceFirst("\\{range\\}", "") : str2.replaceFirst("\\{range\\}", Integer.toString(a(i + i2, b.length)))).replaceFirst("\\{z\\}", Integer.toString(i3)).replaceFirst("\\{x\\}", Integer.toString(i)).replaceFirst("\\{y\\}", Integer.toString(i2)).replaceFirst("\\{style\\}", Integer.toString(d())).replaceFirst("\\{scene\\}", Integer.toString(c())).replaceFirst("\\{version\\}", Integer.toString(f())).replaceFirst("\\{ch\\}", str);
    }

    public void a(int i) {
        this.f23730c = i;
    }

    public void a(String str) {
        this.f23729a = str;
    }

    public void a(int[] iArr) {
        this.f = iArr;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.e = str;
    }

    public int[] b() {
        return this.f;
    }

    public int c() {
        return this.f23730c;
    }

    public void c(int i) {
        this.d = i;
    }

    public int d() {
        return this.b;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("WorldMapTileSrc{");
        stringBuffer.append("mName='");
        stringBuffer.append(this.f23729a);
        stringBuffer.append('\'');
        stringBuffer.append(", mStyle=");
        stringBuffer.append(this.b);
        stringBuffer.append(", mScene=");
        stringBuffer.append(this.f23730c);
        stringBuffer.append(", mVersion=");
        stringBuffer.append(this.d);
        stringBuffer.append(", mUrl='");
        stringBuffer.append(this.e);
        stringBuffer.append('\'');
        stringBuffer.append(", mRanges=");
        if (this.f == null) {
            stringBuffer.append(com.igexin.push.core.b.l);
        } else {
            stringBuffer.append('[');
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.length) {
                    break;
                }
                stringBuffer.append(i2 == 0 ? "" : ", ");
                stringBuffer.append(this.f[i2]);
                i = i2 + 1;
            }
            stringBuffer.append(']');
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
