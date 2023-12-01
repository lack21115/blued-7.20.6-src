package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/e4.class */
public class e4 extends JsonComposer {
    @Json(name = "layerid")

    /* renamed from: a  reason: collision with root package name */
    private String f37405a;
    @Json(name = "type")
    private int b;
    @Json(name = "data_ver")

    /* renamed from: c  reason: collision with root package name */
    private String f37406c;
    @Json(name = "local_data_ver")
    private int d;
    @Json(name = "cfg_ver")
    private String e;
    @Json(name = "local_cfg_ver")
    private int f;
    @Json(name = "params")
    private String[] g;
    @Json(name = "url")
    private String h;
    @Json(ignore = true)
    private String i;

    private boolean f() {
        String str = this.f37406c;
        if (str.equals(this.d + "")) {
            String str2 = this.e;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f);
            sb.append("");
            return !str2.equals(sb.toString());
        }
        return true;
    }

    public String a() {
        if (f()) {
            this.e = this.f + "";
            this.f37406c = this.d + "";
            this.i = null;
        }
        if (this.g != null && this.i == null && !TextUtils.isEmpty(this.h)) {
            this.i = this.h;
            String[] strArr = this.g;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str = strArr[i2];
                try {
                    Object fieldValueByJsonName = getFieldValueByJsonName(str);
                    if (fieldValueByJsonName instanceof String) {
                        String str2 = this.i;
                        this.i = str2.replaceAll("\\{" + str + "\\}", (String) fieldValueByJsonName);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
        }
        return this.i;
    }

    public void a(int i) {
        if (i != this.d) {
            this.i = null;
        }
        this.d = i;
    }

    public String b() {
        return this.d + "";
    }

    public void b(int i) {
        if (i != this.f) {
            this.i = null;
        }
        this.f = i;
    }

    public String c() {
        return this.f37405a;
    }

    public a4 d() {
        return a4.b(this.b);
    }

    public String e() {
        return this.f + "";
    }

    public String toString() {
        return "DataLayer{layerId='" + this.f37405a + "', layerType='" + this.b + "', remoteDataVersion='" + this.f37406c + "', dataVersion=" + this.d + ", remoteStyleVersion='" + this.e + "', styleVersion=" + this.f + ", params=" + Arrays.toString(this.g) + ", dataUrl='" + this.h + "', decodeDataUrl='" + this.i + "'}";
    }
}
