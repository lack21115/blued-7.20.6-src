package com.tencent.mapsdk.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/pg.class */
public class pg {
    public static final String g = "tileOverlay";
    public static final String h = "getTile";
    private static final String i = "x";
    private static final String j = "y";
    private static final String k = "z";
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 100;

    /* renamed from: a  reason: collision with root package name */
    private ri f24004a;
    private Map<Integer, kg> b = new Hashtable(4);

    /* renamed from: c  reason: collision with root package name */
    private rg f24005c;
    private Context d;
    private rc e;
    public String f;

    public pg(Context context, rc rcVar) {
        this.d = context;
        this.e = rcVar;
        this.f24004a = rcVar.S();
        this.f = mc.b(context).c().getPath();
    }

    private int a(Uri uri) {
        String lastPathSegment;
        if (uri == null || (lastPathSegment = uri.getLastPathSegment()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(lastPathSegment);
        } catch (NumberFormatException e) {
            na.b(Log.getStackTraceString(e));
            return -1;
        }
    }

    private int a(Uri uri, String str) {
        if (uri == null) {
            return -1;
        }
        try {
            return Integer.parseInt(uri.getQueryParameter(str));
        } catch (NumberFormatException e) {
            na.b(Log.getStackTraceString(e));
            return -1;
        }
    }

    public static void a(Context context) {
        File[] listFiles;
        if (context == null) {
            return;
        }
        File file = new File(mc.b(context).c().getPath() + kg.K);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            File file2 = listFiles[i3];
            if (currentTimeMillis - file2.lastModified() > TimeUnit.DAYS.toMillis(7L)) {
                ga.d(file2);
            }
            i2 = i3 + 1;
        }
    }

    public int a(TileOverlayCallback tileOverlayCallback, boolean z) {
        if (this.f24004a == null) {
            return -1;
        }
        ra.d(ma.b, "内部addTileOverlay");
        return this.f24004a.a(tileOverlayCallback, z);
    }

    public Context a() {
        return this.d;
    }

    public kg a(int i2) {
        if (i2 >= 0) {
            return this.b.get(Integer.valueOf(i2));
        }
        return null;
    }

    public TileOverlay a(TileOverlayOptions tileOverlayOptions) {
        kg b = b(tileOverlayOptions);
        ra.h(ma.b);
        return new z0(b);
    }

    public void a(int i2, int i3) {
        ri riVar = this.f24004a;
        if (riVar == null) {
            return;
        }
        riVar.f(i2, i3);
    }

    public void a(int i2, int i3, int i4) {
        ri riVar = this.f24004a;
        if (riVar == null) {
            return;
        }
        riVar.b(i2, i3, i4);
    }

    public void a(kg kgVar) {
        int i2;
        if (kgVar == null || (i2 = kgVar.B) <= 0) {
            return;
        }
        this.b.put(Integer.valueOf(i2), kgVar);
    }

    public void a(boolean z) {
        this.f24004a.p(z);
    }

    public byte[] a(String str) {
        kg kgVar;
        try {
            Uri parse = Uri.parse(str);
            if (f7.c(parse.getAuthority(), h)) {
                int a2 = a(parse);
                if (a2 == -1 || (kgVar = this.b.get(Integer.valueOf(a2))) == null) {
                    return null;
                }
                return kgVar.a(a(parse, i), a(parse, "y"), a(parse, "z"));
            }
            return null;
        } catch (Exception e) {
            na.b(Log.getStackTraceString(e));
            return null;
        }
    }

    public kg b(TileOverlayOptions tileOverlayOptions) {
        if (this.f24005c == null) {
            this.f24005c = new rg(this);
        }
        return this.f24005c.a(tileOverlayOptions);
    }

    public rc b() {
        return this.e;
    }

    public void b(int i2) {
        ri riVar = this.f24004a;
        if (riVar == null) {
            return;
        }
        riVar.d(i2);
    }

    public void c(int i2) {
        if (this.f24004a == null) {
            return;
        }
        this.b.remove(Integer.valueOf(i2));
        this.f24004a.g(i2);
        ra.i(ma.b);
    }

    public boolean c() {
        return this.f24004a.Q();
    }

    public void d() {
        Map<Integer, kg> map = this.b;
        if (map == null || map.isEmpty()) {
            return;
        }
        kg[] kgVarArr = (kg[]) this.b.values().toArray(new kg[this.b.keySet().size()]);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= kgVarArr.length) {
                return;
            }
            kgVarArr[i3].remove();
            i2 = i3 + 1;
        }
    }
}
