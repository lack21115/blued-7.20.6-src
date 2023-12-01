package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.cq;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.cr  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cr.class */
public final class cr extends lc {

    /* renamed from: a  reason: collision with root package name */
    private Context f4819a;
    private IAMapDelegate b;

    /* renamed from: c  reason: collision with root package name */
    private cq f4820c;
    private String d;
    private String e;
    private String g;
    private a h;
    private int i;

    /* renamed from: com.amap.api.col.3sl.cr$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cr$a.class */
    public interface a {
        void a(byte[] bArr, int i);

        void b(byte[] bArr, int i);
    }

    public cr(Context context, a aVar, int i, String str) {
        this.d = null;
        this.e = null;
        this.g = null;
        boolean z = false;
        this.i = 0;
        this.f4819a = context;
        this.h = aVar;
        this.i = i;
        if (this.f4820c == null) {
            this.f4820c = new cq(context, "", i != 0 ? true : z);
        }
        this.f4820c.a(str);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.d = sb.toString();
        this.e = context.getCacheDir().getPath();
    }

    public cr(Context context, IAMapDelegate iAMapDelegate) {
        this.d = null;
        this.e = null;
        this.g = null;
        this.i = 0;
        this.f4819a = context;
        this.b = iAMapDelegate;
        if (this.f4820c == null) {
            this.f4820c = new cq(context, "");
        }
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        ds.a(this.f4819a, "amap_style_config", "lastModified".concat(String.valueOf(str)), str2);
    }

    private void a(String str, byte[] bArr) {
        if (str == null || bArr == null || this.e == null) {
            return;
        }
        FileUtil.saveFileContents(this.e + File.separator + str, bArr);
    }

    private byte[] b(String str) {
        if (str == null || this.e == null) {
            return null;
        }
        return FileUtil.readFileContents(this.e + File.separator + str);
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        Object b = ds.b(this.f4819a, "amap_style_config", "lastModified".concat(String.valueOf(str)), "");
        if (!(b instanceof String) || b == "") {
            return null;
        }
        return (String) b;
    }

    public final void a() {
        this.f4819a = null;
        if (this.f4820c != null) {
            this.f4820c = null;
        }
    }

    public final void a(String str) {
        cq cqVar = this.f4820c;
        if (cqVar != null) {
            cqVar.b(str);
        }
        this.g = str;
    }

    public final void b() {
        du.a().a(this);
    }

    @Override // com.amap.api.col.p0003sl.lc
    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f4820c != null) {
                    String str = this.g + this.d;
                    String c2 = c(str);
                    if (c2 != null) {
                        this.f4820c.c(c2);
                    }
                    byte[] b = b(str);
                    if (this.h != null && b != null) {
                        this.h.b(b, this.i);
                    }
                    cq.a d = this.f4820c.d();
                    if (d != null && d.f4817a != null) {
                        JSONObject jSONObject = null;
                        try {
                            jSONObject = new JSONObject(new String(d.f4817a));
                        } catch (JSONException e) {
                        }
                        if (jSONObject == null) {
                            if (this.h != null) {
                                if (!Arrays.equals(d.f4817a, b)) {
                                    this.h.a(d.f4817a, this.i);
                                }
                            } else if (this.b != null) {
                                this.b.setCustomMapStyle(this.b.getMapConfig().isCustomStyleEnable(), d.f4817a);
                            }
                            a(str, d.f4817a);
                            a(str, d.f4818c);
                        }
                    }
                }
                iw.a(this.f4819a, dw.a());
                if (this.b != null) {
                    this.b.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            iw.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
