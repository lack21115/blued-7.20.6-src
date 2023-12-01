package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.internal.m9;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b7.class */
public class b7 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23625a = 2048;
    private static final String b = "BitmapUtil";

    /* renamed from: c  reason: collision with root package name */
    public static Paint f23626c;
    private static byte[] d;
    public static a e;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b7$a.class */
    public static class a {
        private static final AtomicInteger b = new AtomicInteger();

        /* renamed from: a  reason: collision with root package name */
        private final MemoryCache<v9> f23627a;

        /* renamed from: com.tencent.mapsdk.internal.b7$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/b7$a$a.class */
        public class C0780a implements m9.b<v9> {
            public C0780a() {
            }

            @Override // com.tencent.mapsdk.internal.m9.b
            public boolean a(v9 v9Var) {
                if (v9Var != null) {
                    String e = v9Var.e();
                    if (!v9Var.h() || e == null) {
                        return true;
                    }
                    a.this.f23627a.remove(e);
                    return true;
                }
                return true;
            }
        }

        public a(Context context, int i) {
            File b2 = mc.b(context).b();
            if (y9.c("4.5.9", "4.4.6", 3)) {
                ga.b(new File(b2, "BitmapDescriptorCache"), new File(b2, "bitmaps"));
            }
            this.f23627a = (MemoryCache) q9.b(v9.class, new MemoryCache.a().a(i).a(new C0780a()));
            c();
        }

        public Bitmap a(String str) {
            synchronized (this) {
                v9 b2 = this.f23627a.g().b(str, v9.class);
                if (b2 != null) {
                    return b2.d();
                }
                return null;
            }
        }

        public void a() {
            synchronized (this) {
                AtomicInteger atomicInteger = b;
                if (atomicInteger.get() <= 0 || atomicInteger.decrementAndGet() == 0) {
                    this.f23627a.g().b();
                }
            }
        }

        public void a(String str, Bitmap bitmap) {
            synchronized (this) {
                a(str, new v9(bitmap));
            }
        }

        public void a(String str, v9 v9Var) {
            synchronized (this) {
                na.a("BD", "putCache:" + str + " id:" + v9Var.e() + " bitmapData:" + v9Var);
                v9 a2 = this.f23627a.a(str, v9.class);
                if (a2 != null) {
                    na.a("BD", "getCache:" + str + " id:" + a2.e() + " recycle:" + a2.g() + " bitmapData:" + a2);
                }
                if (a2 == null || a2.g() || TextUtils.isEmpty(a2.e()) || !a2.e().equals(v9Var.e())) {
                    this.f23627a.g().b(str, (String) v9Var);
                    return;
                }
                na.a("BD", "same bitmap!!" + str);
                a2.f();
            }
        }

        public int b() {
            return b.get();
        }

        public boolean b(String str) {
            boolean z;
            synchronized (this) {
                v9 a2 = this.f23627a.a(str, v9.class);
                if (a2 == null || !a2.h()) {
                    z = false;
                } else {
                    na.a("BD", "remove:" + str + " bitmapData:" + a2);
                    this.f23627a.remove(str);
                    z = true;
                }
            }
            return z;
        }

        public void c() {
            AtomicInteger atomicInteger = b;
            if (atomicInteger.get() < 0) {
                atomicInteger.set(0);
            }
            atomicInteger.incrementAndGet();
        }
    }

    static {
        Paint paint = new Paint();
        f23626c = paint;
        paint.setAntiAlias(true);
    }

    private static Bitmap a(int i, int i2, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e2) {
            try {
                return Bitmap.createBitmap(i, i2, config);
            } catch (OutOfMemoryError e3) {
                return null;
            }
        }
    }

    public static Bitmap a(Context context, int i) {
        try {
            return BitmapFactory.decodeResource(context.getResources(), i);
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        FileInputStream fileInputStream;
        String str2;
        try {
            try {
                if (str == null) {
                    return null;
                }
                try {
                    if (str.trim().length() == 0) {
                        return null;
                    }
                    if (str.trim().charAt(0) != '/') {
                        str2 = context.getFilesDir() + "/" + str;
                    } else {
                        str2 = context.getFilesDir() + str;
                    }
                    fileInputStream = new FileInputStream(str2);
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
                        fileInputStream.close();
                        return decodeStream;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return null;
                        }
                        return null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                return context;
            }
        } catch (Throwable th3) {
            inputStream = context;
            th = th3;
        }
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap != null) {
            try {
                return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() / c7.x()), (int) (bitmap.getHeight() / c7.x()), true);
            } catch (OutOfMemoryError e2) {
                bitmap2 = null;
            }
        }
        return bitmap2;
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap != null && f != 1.0f) {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return bitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        } catch (OutOfMemoryError e2) {
            try {
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            } catch (OutOfMemoryError e3) {
                return null;
            }
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap a2;
        if (bitmap == null || bitmap.isRecycled() || i < 1 || i2 < 1 || (a2 = a(i, i2, Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        a2.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(a2);
        a2.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, f23626c);
        return a2;
    }

    public static Bitmap a(Bitmap bitmap, Context context, int i, int i2) {
        int min;
        int min2;
        Bitmap a2;
        if (bitmap == null || bitmap.isRecycled() || i < 1 || i2 < 1 || (a2 = a((min = Math.min(i, 2048)), (min2 = Math.min(i2, 2048)), Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        a2.eraseColor(0);
        Canvas canvas = new Canvas(a2);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, min, min2);
        bitmapDrawable.draw(canvas);
        return a2;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof NinePatchDrawable) {
            Bitmap a2 = a(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            if (a2 == null) {
                return null;
            }
            Canvas canvas = new Canvas(a2);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return a2;
        }
        return null;
    }

    public static Bitmap a(View view) {
        Bitmap c2;
        if (view != null) {
            try {
                synchronized (view) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
                    view.setDrawingCacheEnabled(true);
                    view.buildDrawingCache();
                    c2 = c(view.getDrawingCache());
                    view.destroyDrawingCache();
                }
                return c2;
            } catch (Throwable th) {
                Log.e(b, "BitmapUtil.convertToBitmap errorDetail:" + Log.getStackTraceString(th));
                return null;
            }
        }
        return null;
    }

    public static final Bitmap a(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    public static Bitmap a(String str, int i) {
        return a(str, i, Integer.MIN_VALUE, (Typeface) null);
    }

    public static Bitmap a(String str, int i, int i2, int i3, int i4, Typeface typeface) {
        TextPaint textPaint;
        StaticLayout staticLayout;
        Rect rect = new Rect();
        TextPaint textPaint2 = new TextPaint(65);
        textPaint2.setStyle(Paint.Style.FILL);
        textPaint2.setColor(i2);
        textPaint2.setTextSize(i);
        textPaint2.clearShadowLayer();
        if (i3 != 0) {
            textPaint = new TextPaint(65);
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(i3);
            textPaint.setColor(i4);
            textPaint.clearShadowLayer();
        } else {
            textPaint = null;
        }
        if (typeface != null) {
            textPaint2.setTypeface(typeface);
            if (textPaint != null) {
                textPaint.setTypeface(typeface);
            }
        }
        textPaint2.getTextBounds(str, 0, str.length(), rect);
        if (textPaint != null) {
            textPaint.getTextBounds(str, 0, str.length(), rect);
            staticLayout = new StaticLayout(str, textPaint, Math.round(rect.width()), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        } else {
            staticLayout = null;
        }
        StaticLayout staticLayout2 = new StaticLayout(str, textPaint2, Math.round(rect.width()), Layout.Alignment.ALIGN_CENTER, 0.0f, 0.0f, false);
        Bitmap a2 = staticLayout != null ? a(staticLayout.getWidth(), staticLayout.getHeight(), Bitmap.Config.ARGB_8888) : a(staticLayout2.getWidth(), staticLayout2.getHeight(), Bitmap.Config.ARGB_8888);
        if (a2 == null) {
            return null;
        }
        Canvas canvas = new Canvas(a2);
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        staticLayout2.draw(canvas);
        canvas.restore();
        return a2;
    }

    public static Bitmap a(String str, int i, int i2, Typeface typeface) {
        return a(str, i, i2, 0, 0, typeface);
    }

    public static Bitmap a(int[] iArr, int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(iArr, i, i2, config);
    }

    public static boolean a(Bitmap bitmap, String str) {
        return a(bitmap, str, Bitmap.CompressFormat.PNG);
    }

    public static boolean a(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        FileOutputStream fileOutputStream;
        if (bitmap == null || bitmap.isRecycled() || TextUtils.isEmpty(str)) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                FileOutputStream fileOutputStream3 = new FileOutputStream(str);
                try {
                    bitmap.compress(compressFormat, 100, fileOutputStream3);
                    ha.a(fileOutputStream3);
                    return true;
                } catch (Exception e2) {
                    fileOutputStream = fileOutputStream3;
                    e = e2;
                    fileOutputStream2 = fileOutputStream;
                    e.printStackTrace();
                    ha.a(fileOutputStream);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    ha.a(fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        }
    }

    public static byte[] a() {
        Bitmap a2;
        if (d == null && (a2 = a(256, 256, Bitmap.Config.ARGB_8888)) != null) {
            new Canvas(a2).drawARGB(0, 255, 255, 255);
            d = f(a2);
        }
        return d;
    }

    public static byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap b(Context context, String str) {
        InputStream inputStream;
        try {
            inputStream = context.getAssets().open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                ha.a((Closeable) inputStream);
                return decodeStream;
            } catch (Exception e2) {
                ha.a((Closeable) inputStream);
                return null;
            } catch (OutOfMemoryError e3) {
                ha.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                ha.a((Closeable) inputStream);
                throw th;
            }
        } catch (Exception e4) {
            inputStream = null;
        } catch (OutOfMemoryError e5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static Drawable b(Bitmap bitmap) {
        return new BitmapDrawable(bitmap);
    }

    public static Bitmap c(Context context, String str) {
        InputStream inputStream;
        Bitmap bitmap;
        InputStream inputStream2;
        InputStream inputStream3;
        try {
            try {
                InputStream c2 = ha.c(mc.b(context).a() + str);
                InputStream inputStream4 = c2;
                if (c2 == null) {
                    inputStream3 = c2;
                    inputStream2 = c2;
                    try {
                        if (jc.a() != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(jc.a());
                            sb.append(str);
                            inputStream4 = jc.a(context, sb.toString());
                        } else {
                            inputStream4 = c2;
                            if (jc.b() != null) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(jc.b());
                                sb2.append(str);
                                inputStream4 = ha.c(sb2.toString());
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        inputStream = inputStream2;
                        bitmap = null;
                        ha.a((Closeable) inputStream);
                        return bitmap;
                    } catch (OutOfMemoryError e3) {
                        bitmap = null;
                        inputStream = inputStream3;
                    }
                }
                inputStream = inputStream4;
                if (inputStream4 == null) {
                    StringBuilder sb3 = new StringBuilder();
                    InputStream inputStream5 = inputStream4;
                    sb3.append(c7.m);
                    InputStream inputStream6 = inputStream4;
                    sb3.append(str);
                    InputStream inputStream7 = inputStream4;
                    inputStream = jc.a(context, sb3.toString());
                }
                InputStream inputStream8 = inputStream;
                inputStream3 = inputStream;
                inputStream2 = inputStream;
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e4) {
                e = e4;
                inputStream2 = null;
            } catch (OutOfMemoryError e5) {
                inputStream = null;
                bitmap = null;
            } catch (Throwable th) {
                th = th;
                ha.a((Closeable) null);
                throw th;
            }
            ha.a((Closeable) inputStream);
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
            ha.a((Closeable) null);
            throw th;
        }
    }

    public static Bitmap c(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return a(bitmap, bitmap.getWidth(), bitmap.getHeight());
    }

    public static final Bitmap d(Bitmap bitmap) {
        try {
            return Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    public static String e(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer allocate = Build.VERSION.SDK_INT >= 19 ? ByteBuffer.allocate(bitmap.getAllocationByteCount()) : ByteBuffer.allocate(bitmap.getByteCount());
        bitmap.copyPixelsToBuffer(allocate);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        sb.append("@");
        sb.append(width);
        sb.append("x");
        sb.append(height);
        sb.append("@");
        sb.append(wa.a(allocate.array()));
        allocate.clear();
        return sb.toString();
    }

    public static byte[] f(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (bitmap == null || bitmap.isRecycled()) {
            return new byte[0];
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                ha.a(byteArrayOutputStream2);
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream = byteArrayOutputStream2;
                th = th;
                ha.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }
}
