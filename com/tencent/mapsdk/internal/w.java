package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.mapsdk.engine.jni.models.IconImageInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/w.class */
public class w {
    private static final int i = -16711681;
    private static final int j = 16711680;
    private static final int k = -256;
    private static final int l = 255;

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<Context> f38082a;
    private e1 b;

    /* renamed from: c  reason: collision with root package name */
    private de f38083c;
    private float d;
    private zd e;
    private w6 f;
    private Lock g = new ReentrantLock();
    private Lock h = new ReentrantLock();

    public w(Context context, e1 e1Var, de deVar, zd zdVar) {
        this.d = 1.0f;
        this.f38082a = new WeakReference<>(context);
        this.b = e1Var;
        this.f38083c = deVar;
        this.e = zdVar;
        this.d = g7.d(context);
        if (e1Var == null || e1Var.j() == null) {
            return;
        }
        this.f = ((yi) e1Var.j()).A().w();
    }

    private int a(int i2) {
        return (i2 & (-16711681) & (-256)) | ((i2 & 255) << 16) | ((16711680 & i2) >> 16);
    }

    private Bitmap a(String str) {
        String[] split;
        String substring = str.substring(14);
        if (f7.b(substring) || (split = substring.split(", ")) == null || split.length < 5) {
            return null;
        }
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        long parseLong = Long.parseLong(split[2]);
        long parseLong2 = Long.parseLong(split[3]);
        float parseFloat = Float.parseFloat(split[4]);
        if (parseInt < 0 || parseInt2 < 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(parseFloat);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(a((int) parseLong2));
        Bitmap createBitmap = Bitmap.createBitmap(parseInt, parseInt2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(a((int) parseLong));
        RectF rectF = new RectF();
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = parseInt;
        rectF.bottom = parseInt2;
        canvas.drawRoundRect(rectF, parseInt >> 3, parseInt2 >> 3, paint);
        return createBitmap;
    }

    private Bitmap a(String str, Bitmap.Config config, boolean z) {
        WeakReference<Context> weakReference;
        if (!new File(str).exists() || (weakReference = this.f38082a) == null || weakReference.get() == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        if (z) {
            options.inDensity = 320;
            options.inTargetDensity = this.f38082a.get().getResources().getDisplayMetrics().densityDpi;
        }
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private boolean a(File file, String str, byte[] bArr, Lock lock) {
        if (file == null || f7.b(str) || bArr == null || bArr.length == 0) {
            return false;
        }
        String str2 = str + BridgeUtil.UNDERLINE_STR + Arrays.hashCode(bArr);
        try {
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str2);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            ga.b(file2, bArr);
            try {
                if (!wa.a(bArr).equals(wa.a(file2))) {
                    return false;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            File file3 = new File(file, str);
            File file4 = new File(file, str + ".bak");
            if (file4.exists() && !file4.delete()) {
                file4.deleteOnExit();
                return false;
            }
            lock.lock();
            if (file3.exists() && !file3.renameTo(file4)) {
                if (!file2.delete()) {
                    file2.deleteOnExit();
                }
                lock.unlock();
                return false;
            } else if (file2.renameTo(file3)) {
                if (!file4.delete()) {
                    file4.deleteOnExit();
                }
                lock.unlock();
                return true;
            } else {
                file4.renameTo(file3);
                if (!file2.delete()) {
                    file2.deleteOnExit();
                }
                lock.unlock();
                return false;
            }
        } catch (Exception e2) {
            return false;
        }
    }

    public e1 a() {
        return this.b;
    }

    public boolean a(String str, byte[] bArr) {
        de deVar = this.f38083c;
        if (deVar == null) {
            return false;
        }
        return a(new File(deVar.j()), str, bArr, this.g);
    }

    public IconImageInfo b(String str) {
        w6 w6Var;
        w6 w6Var2;
        w6 w6Var3;
        if (this.e == null) {
            return null;
        }
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        if (str != null && str.startsWith("drawRoundRect")) {
            iconImageInfo.scale = 1.0f;
            Bitmap a2 = a(str);
            iconImageInfo.bitmap = a2;
            if (a2 == null && (w6Var3 = this.f) != null) {
                w6Var3.l().a(System.currentTimeMillis(), str);
            }
            return iconImageInfo;
        }
        try {
            this.h.lock();
            this.e.a(str, iconImageInfo);
            this.h.unlock();
            if (iconImageInfo.bitmap == null && str != null) {
                str.equals(zd.f38161a);
            }
            if (iconImageInfo.bitmap != null || (w6Var2 = this.f) == null) {
                return iconImageInfo;
            }
            w6Var2.l().a(System.currentTimeMillis(), str);
            return iconImageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            if (iconImageInfo.bitmap != null || (w6Var = this.f) == null) {
                return null;
            }
            w6Var.l().a(System.currentTimeMillis(), str);
            return null;
        }
    }

    public void b() {
        this.g.lock();
    }

    public boolean b(String str, byte[] bArr) {
        de deVar = this.f38083c;
        if (deVar == null) {
            return false;
        }
        return a(new File(deVar.f()), str, bArr, this.h);
    }

    public IconImageInfo c(String str) {
        IconImageInfo iconImageInfo = new IconImageInfo();
        iconImageInfo.scale = this.d;
        iconImageInfo.anchorPointX1 = 0.5f;
        iconImageInfo.anchorPointY1 = 0.5f;
        iconImageInfo.bitmap = a(str, Bitmap.Config.RGB_565, false);
        return iconImageInfo;
    }

    public void c() {
        this.b.f().g("");
    }

    public void d() {
        this.g.unlock();
    }
}
