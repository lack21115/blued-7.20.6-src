package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/HardwareConfigState.class */
public final class HardwareConfigState {

    /* renamed from: a  reason: collision with root package name */
    private static final File f7350a = new File("/proc/self/fd");
    private static volatile HardwareConfigState b;
    private final int d;
    private final int e;
    private int f;
    private boolean g = true;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7351c = b();

    HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.d = 20000;
            this.e = 0;
            return;
        }
        this.d = 700;
        this.e = 128;
    }

    public static HardwareConfigState a() {
        if (b == null) {
            synchronized (HardwareConfigState.class) {
                try {
                    if (b == null) {
                        b = new HardwareConfigState();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private static boolean b() {
        boolean z = true;
        if (Build.MODEL != null) {
            if (Build.MODEL.length() < 7) {
                return true;
            }
            String substring = Build.MODEL.substring(0, 7);
            boolean z2 = true;
            switch (substring.hashCode()) {
                case -1398613787:
                    if (substring.equals("SM-A520")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1398431166:
                    if (substring.equals("SM-G930")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1398431161:
                    if (substring.equals("SM-G935")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1398431073:
                    if (substring.equals("SM-G960")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1398431068:
                    if (substring.equals("SM-G965")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1398343746:
                    if (substring.equals("SM-J720")) {
                        z2 = true;
                        break;
                    }
                    break;
                case -1398222624:
                    if (substring.equals("SM-N935")) {
                        z2 = false;
                        break;
                    }
                    break;
            }
            switch (z2) {
                case false:
                case true:
                case true:
                case true:
                case true:
                case true:
                case true:
                    if (Build.VERSION.SDK_INT == 26) {
                        z = false;
                        break;
                    } else {
                        return true;
                    }
                default:
                    return true;
            }
        }
        return z;
    }

    private boolean c() {
        boolean z;
        synchronized (this) {
            boolean z2 = true;
            int i = this.f + 1;
            this.f = i;
            if (i >= 50) {
                this.f = 0;
                int length = f7350a.list().length;
                if (length >= this.d) {
                    z2 = false;
                }
                this.g = z2;
                if (!z2 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.d);
                }
            }
            z = this.g;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean a2 = a(i, i2, z, z2);
        if (a2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return a2;
    }

    public boolean a(int i, int i2, boolean z, boolean z2) {
        boolean z3 = false;
        if (z) {
            z3 = false;
            if (this.f7351c) {
                z3 = false;
                if (Build.VERSION.SDK_INT >= 26) {
                    if (z2) {
                        return false;
                    }
                    int i3 = this.e;
                    z3 = false;
                    if (i >= i3) {
                        z3 = false;
                        if (i2 >= i3) {
                            z3 = false;
                            if (c()) {
                                z3 = true;
                            }
                        }
                    }
                }
            }
        }
        return z3;
    }
}
