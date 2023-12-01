package com.anythink.expressad.exoplayer.scheduler;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7731a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7732c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final int f = 8;
    private static final int g = 16;
    private static final int h = 7;
    private static final String i = "Requirements";
    private static final String[] j = null;
    private final int k;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.anythink.expressad.exoplayer.scheduler.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/scheduler/a$a.class */
    public @interface InterfaceC0140a {
    }

    public a(int i2) {
        this.k = i2;
    }

    private a(int i2, boolean z, boolean z2) {
        this(i2 | (z ? 16 : 0) | (z2 ? 8 : 0));
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        if (af.f7632a < 23) {
            return true;
        }
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        return !(networkCapabilities == null || !networkCapabilities.hasCapability(16));
    }

    private static boolean a(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        if (af.f7632a >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
        if ((r0 == null || !r0.hasCapability(16)) == false) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.scheduler.a.b(android.content.Context):boolean");
    }

    private boolean c(Context context) {
        if (b()) {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
            if (registerReceiver == null) {
                return false;
            }
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return true;
    }

    private boolean d(Context context) {
        if (c()) {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            return af.f7632a >= 23 ? !powerManager.isDeviceIdleMode() : af.f7632a >= 20 ? !powerManager.isInteractive() : !powerManager.isScreenOn();
        }
        return true;
    }

    private static void e() {
    }

    public final int a() {
        return this.k & 7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
        if ((r0 == null || !r0.hasCapability(16)) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (r0.isRoaming() == false) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d0, code lost:
        if (r10 == false) goto L3;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0178 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.scheduler.a.a(android.content.Context):boolean");
    }

    public final boolean b() {
        return (this.k & 16) != 0;
    }

    public final boolean c() {
        return (this.k & 8) != 0;
    }

    public final int d() {
        return this.k;
    }

    public final String toString() {
        return super.toString();
    }
}
