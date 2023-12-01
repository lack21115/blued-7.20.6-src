package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/cj.class */
public class cj implements zd {

    /* renamed from: c  reason: collision with root package name */
    private Context f23688c;
    private final float d;
    private String e;
    private String f;

    public cj(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f23688c = applicationContext;
        this.d = g7.d(applicationContext);
        this.e = str;
    }

    private Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        InputStream c2 = ha.c(mc.b(this.f23688c).c(this.e) + str);
        InputStream inputStream = c2;
        if (c2 == null) {
            inputStream = ha.c(mc.b(this.f23688c).a(this.e) + str);
        }
        InputStream inputStream2 = inputStream;
        if (inputStream == null) {
            inputStream2 = ha.c(mc.b(this.f23688c).a() + str);
        }
        InputStream inputStream3 = inputStream2;
        if (inputStream2 == null) {
            inputStream3 = inputStream2;
            if (this.f != null) {
                inputStream3 = ha.a(new File(this.f, str));
            }
        }
        InputStream inputStream4 = inputStream3;
        if (inputStream3 == null) {
            if (jc.a() != null) {
                Context context = this.f23688c;
                inputStream4 = jc.a(context, jc.a() + str);
            } else {
                inputStream4 = inputStream3;
                if (jc.b() != null) {
                    inputStream4 = ha.c(jc.b() + str);
                }
            }
        }
        InputStream inputStream5 = inputStream4;
        if (inputStream4 == null) {
            inputStream5 = jc.b(this.f23688c, str);
        }
        InputStream inputStream6 = inputStream5;
        if (inputStream5 == null) {
            inputStream6 = jc.a(this.f23688c, str);
        }
        if (inputStream6 == null) {
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream6);
        ha.a((Closeable) inputStream6);
        return decodeStream;
    }

    @Override // com.tencent.mapsdk.internal.zd
    public String a(GeoPoint geoPoint) {
        return null;
    }

    @Override // com.tencent.mapsdk.internal.zd
    public void a(String str, IconImageInfo iconImageInfo) {
        Bitmap a2 = qc.a(str);
        if (a2 == null) {
            a2 = b7.e.a(str);
            iconImageInfo.bitmap = a2;
        } else {
            iconImageInfo.bitmap = a2;
        }
        if (str.endsWith(k4.s) || str.contains("@2x")) {
            iconImageInfo.scale = 2.0f;
        } else if (str.endsWith("@3x.png") || str.contains("@3x")) {
            iconImageInfo.scale = 3.0f;
        } else {
            iconImageInfo.scale = this.d;
        }
        if (this.f23688c != null && a2 == null) {
            try {
                if (str.startsWith("poi_icon") || str.startsWith(k4.r)) {
                    a2 = a(f7.g(str) + k4.s);
                }
                if (a2 != null) {
                    iconImageInfo.bitmap = a2;
                    iconImageInfo.scale = 2.0f;
                    return;
                }
                iconImageInfo.bitmap = a(str);
                if (!str.equals(zd.f24470a) && !str.equals(zd.b)) {
                    iconImageInfo.scale = 1.0f;
                    return;
                }
                iconImageInfo.scale = this.d;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.zd
    public void setOptionalResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = str;
        if (str.contains("../")) {
            str2 = str.replaceAll("\\.\\./", "");
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f = str2;
    }
}
