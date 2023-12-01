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
    private Context a;
    private IAMapDelegate b;
    private cq c;
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
        this.a = context;
        this.h = aVar;
        this.i = i;
        if (this.c == null) {
            this.c = new cq(context, "", i != 0 ? true : z);
        }
        this.c.a(str);
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
        this.a = context;
        this.b = iAMapDelegate;
        if (this.c == null) {
            this.c = new cq(context, "");
        }
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        ds.a(this.a, "amap_style_config", "lastModified".concat(String.valueOf(str)), str2);
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
        Object b = ds.b(this.a, "amap_style_config", "lastModified".concat(String.valueOf(str)), "");
        if (!(b instanceof String) || b == "") {
            return null;
        }
        return (String) b;
    }

    public final void a() {
        this.a = null;
        if (this.c != null) {
            this.c = null;
        }
    }

    public final void a(String str) {
        cq cqVar = this.c;
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
                if (this.c != null) {
                    String str = this.g + this.d;
                    String c = c(str);
                    if (c != null) {
                        this.c.c(c);
                    }
                    byte[] b = b(str);
                    if (this.h != null && b != null) {
                        this.h.b(b, this.i);
                    }
                    cq.a d = this.c.d();
                    if (d != null && d.a != null) {
                        JSONObject jSONObject = null;
                        try {
                            jSONObject = new JSONObject(new String(d.a));
                        } catch (JSONException e) {
                        }
                        if (jSONObject == null) {
                            if (this.h != null) {
                                if (!Arrays.equals(d.a, b)) {
                                    this.h.a(d.a, this.i);
                                }
                            } else if (this.b != null) {
                                this.b.setCustomMapStyle(this.b.getMapConfig().isCustomStyleEnable(), d.a);
                            }
                            a(str, d.a);
                            a(str, d.c);
                        }
                    }
                }
                iw.a(this.a, dw.a());
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
