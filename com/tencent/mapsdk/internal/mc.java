package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mc.class */
public class mc {
    public static final String n = "data/";
    private static final String o = "/tencentmapsdk/";
    private static mc p;

    /* renamed from: a  reason: collision with root package name */
    private Context f37645a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f37646c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;

    private mc(Context context, TencentMapOptions tencentMapOptions) {
        if (context == null) {
            throw new Error("context can not be null");
        }
        this.f37645a = context.getApplicationContext();
        a(tencentMapOptions);
        j();
        k();
    }

    public static mc a(Context context, TencentMapOptions tencentMapOptions) {
        if (p == null) {
            p = new mc(context, tencentMapOptions);
        }
        return p;
    }

    private static String a(Context context) {
        File externalFilesDir = context.getExternalFilesDir(null);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : context.getFilesDir().getPath();
    }

    private void a(TencentMapOptions tencentMapOptions) {
        if (tencentMapOptions != null) {
            String customCacheRootPath = tencentMapOptions.getCustomCacheRootPath();
            if (e(customCacheRootPath)) {
                this.m = customCacheRootPath;
            }
        }
    }

    public static long b(String str) {
        long blockSizeLong;
        long availableBlocksLong;
        try {
            StatFs statFs = new StatFs(str);
            if (Build.VERSION.SDK_INT < 18) {
                blockSizeLong = statFs.getBlockSize();
                availableBlocksLong = statFs.getAvailableBlocks();
            } else {
                blockSizeLong = statFs.getBlockSizeLong();
                availableBlocksLong = statFs.getAvailableBlocksLong();
            }
            return ((blockSizeLong * availableBlocksLong) / 1024) / 1024;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static mc b(Context context) {
        return a(context, (TencentMapOptions) null);
    }

    private boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        boolean z = false;
        if (file.isDirectory()) {
            z = false;
            if (file.canRead()) {
                z = false;
                if (file.canWrite()) {
                    z = false;
                    if (b(str) > 5) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void j() {
        this.i = this.f37645a.getFilesDir().getAbsolutePath();
        this.f = this.i + "/tencentMapSdk/config/";
        this.j = this.f + "temp/";
        this.g = this.i + "/tencentMapSdk/assets/";
        this.h = this.i + "/tencentMapSdk/dynamicAssets/";
        Context context = this.f37645a;
        a(context, lc.a(context).d("sdkVersion"));
    }

    private void k() {
        String h = h();
        String a2 = ga.a(this.f37645a);
        if (f7.b(a2)) {
            this.b = h + o;
        } else {
            this.b = h + o + a2;
        }
        this.f37646c = this.b + BridgeUtil.SPLIT_MARK + "data/v4/render/";
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append("/sat/");
        this.d = sb.toString();
        this.e = this.f37646c + "closeRoadDatas/";
        this.k = this.f37646c + "events/icons";
        this.l = this.f37646c + "offlineMaps/";
    }

    public String a() {
        ha.b(this.h);
        return this.h;
    }

    public String a(String str) {
        String str2;
        if (f7.b(str)) {
            str2 = this.g;
        } else {
            str2 = this.i + "/tencentMapSdk/subKey/" + str + "/assets/";
        }
        ha.b(str2);
        return str2;
    }

    public void a(Context context, String str) {
        if (!f7.b(lc.a(context).d("sdkVersion")) && c7.b("4.1.0", str) > 0) {
            kc.a(context);
            ga.e(new File(this.f));
            ga.e(new File(this.g));
            ga.e(new File(this.i + "/tencentMapSdk/subKey/"));
        }
    }

    public File b() {
        return new File(this.b);
    }

    public File c() {
        return new File(this.b + BridgeUtil.SPLIT_MARK + "data/");
    }

    public String c(String str) {
        String str2;
        if (f7.b(str)) {
            str2 = this.f;
        } else {
            str2 = this.i + "/tencentMapSdk/subKey/" + str + "/config/";
        }
        ha.b(str2);
        return str2;
    }

    public String d() {
        ha.b(this.f37646c);
        return this.f37646c;
    }

    public String d(String str) {
        String str2;
        if (f7.b(str)) {
            str2 = this.j;
        } else {
            str2 = c(str) + "temp/";
        }
        ha.b(str2);
        return str2;
    }

    public String e() {
        ha.b(this.l);
        return this.l;
    }

    public String f() {
        ha.b(this.e);
        return this.e;
    }

    public String g() {
        ha.b(this.d);
        return this.d;
    }

    public String h() {
        if (TextUtils.isEmpty(this.m)) {
            Context context = this.f37645a;
            String a2 = a(context);
            String str = a2;
            if (b(a2) < 5) {
                String path = context.getFilesDir().getPath();
                str = path;
                if (b(path) < 5) {
                    str = a(context);
                }
            }
            return str;
        }
        return this.m;
    }

    public String i() {
        ha.b(this.k);
        return this.k;
    }
}
