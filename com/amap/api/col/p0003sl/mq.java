package com.amap.api.col.p0003sl;

import android.content.pm.PackageManager;

/* renamed from: com.amap.api.col.3sl.mq  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/mq.class */
public final class mq {

    /* renamed from: a  reason: collision with root package name */
    public long f5387a;
    public String b;
    public int d;
    public long e;
    public short g;
    public boolean h;

    /* renamed from: c  reason: collision with root package name */
    public int f5388c = PackageManager.INSTALL_FAILED_NO_MATCHING_ABIS;
    public long f = 0;

    public mq(boolean z) {
        this.h = z;
    }

    public static long a(String str) {
        int i;
        long j;
        long j2;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i2 = 0;
        int length = str.length() - 1;
        long j3 = 0;
        while (true) {
            long j4 = j3;
            if (length < 0) {
                if (i2 != 48) {
                    return 0L;
                }
                return j4;
            }
            long charAt = str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j5 = 97;
                if (charAt < 97 || charAt > 102) {
                    j5 = 65;
                    if (charAt < 65 || charAt > 70) {
                        i = i2;
                        j = j4;
                        if (charAt != 58) {
                            i = i2;
                            j = j4;
                            if (charAt != 124) {
                                return 0L;
                            }
                        } else {
                            continue;
                        }
                        length--;
                        i2 = i;
                        j3 = j;
                    }
                }
                j2 = (charAt - j5) + 10;
            } else {
                j2 = charAt - 48;
            }
            j = j4 + (j2 << i2);
            i = i2 + 4;
            length--;
            i2 = i;
            j3 = j;
        }
    }

    public static String a(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return my.a(my.a(j), ":");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public mq clone() {
        mq mqVar = new mq(this.h);
        mqVar.f5387a = this.f5387a;
        mqVar.b = this.b;
        mqVar.f5388c = this.f5388c;
        mqVar.d = this.d;
        mqVar.e = this.e;
        mqVar.f = this.f;
        mqVar.g = this.g;
        mqVar.h = this.h;
        return mqVar;
    }

    public final String a() {
        return this.h + "#" + this.f5387a;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f5387a + ", ssid='" + this.b + "', rssi=" + this.f5388c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }
}
