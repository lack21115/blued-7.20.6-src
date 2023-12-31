package com.bumptech.glide.load.engine.cache;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemorySizeCalculator.class */
public final class MemorySizeCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final int f7228a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f7229c;
    private final int d;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemorySizeCalculator$Builder.class */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        static final int f7230a;
        final Context b;

        /* renamed from: c  reason: collision with root package name */
        ActivityManager f7231c;
        ScreenDimensions d;
        float f;
        float e = 2.0f;
        float g = 0.4f;
        float h = 0.33f;
        int i = 4194304;

        static {
            f7230a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public Builder(Context context) {
            this.f = f7230a;
            this.b = context;
            this.f7231c = (ActivityManager) context.getSystemService("activity");
            this.d = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !MemorySizeCalculator.a(this.f7231c)) {
                return;
            }
            this.f = 0.0f;
        }

        public MemorySizeCalculator a() {
            return new MemorySizeCalculator(this);
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemorySizeCalculator$DisplayMetricsScreenDimensions.class */
    static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f7232a;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f7232a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int a() {
            return this.f7232a.widthPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.ScreenDimensions
        public int b() {
            return this.f7232a.heightPixels;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/MemorySizeCalculator$ScreenDimensions.class */
    interface ScreenDimensions {
        int a();

        int b();
    }

    MemorySizeCalculator(Builder builder) {
        this.f7229c = builder.b;
        this.d = a(builder.f7231c) ? builder.i / 2 : builder.i;
        int a2 = a(builder.f7231c, builder.g, builder.h);
        float a3 = builder.d.a() * builder.d.b() * 4;
        int round = Math.round(builder.f * a3);
        int round2 = Math.round(a3 * builder.e);
        int i = a2 - this.d;
        int i2 = round2 + round;
        if (i2 <= i) {
            this.b = round2;
            this.f7228a = round;
        } else {
            float f = i / (builder.f + builder.e);
            this.b = Math.round(builder.e * f);
            this.f7228a = Math.round(f * builder.f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.b));
            sb.append(", pool size: ");
            sb.append(a(this.f7228a));
            sb.append(", byte array size: ");
            sb.append(a(this.d));
            sb.append(", memory class limited? ");
            sb.append(i2 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(builder.f7231c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(builder.f7231c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int a(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f7229c, i);
    }

    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.f7228a;
    }

    public int c() {
        return this.d;
    }
}
