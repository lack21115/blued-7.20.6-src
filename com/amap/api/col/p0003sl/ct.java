package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.cs;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;

/* renamed from: com.amap.api.col.3sl.ct  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ct.class */
public final class ct extends lc {
    private Context a;
    private cs b;
    private cz c;
    private a d;

    /* renamed from: com.amap.api.col.3sl.ct$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ct$a.class */
    public interface a {
        void a(String str, cz czVar);
    }

    public ct(Context context) {
        this.a = context;
        if (this.b == null) {
            this.b = new cs(context, "");
        }
    }

    private static String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    private static void a(String str, byte[] bArr) {
        FileUtil.writeDatasToFile(str, bArr);
    }

    public final void a() {
        this.a = null;
        if (this.b != null) {
            this.b = null;
        }
    }

    public final void a(a aVar) {
        this.d = aVar;
    }

    public final void a(cz czVar) {
        this.c = czVar;
    }

    public final void a(String str) {
        cs csVar = this.b;
        if (csVar != null) {
            csVar.a(str);
        }
    }

    public final void b() {
        du.a().a(this);
    }

    @Override // com.amap.api.col.p0003sl.lc
    public final void runTask() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.b != null) {
                    cs.a d = this.b.d();
                    String str = null;
                    if (d != null) {
                        str = null;
                        if (d.a != null) {
                            str = a(this.a) + "/custom_texture_data";
                            a(str, d.a);
                        }
                    }
                    if (this.d != null) {
                        this.d.a(str, this.c);
                    }
                }
                iw.a(this.a, dw.a());
            }
        } catch (Throwable th) {
            iw.c(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }
}
