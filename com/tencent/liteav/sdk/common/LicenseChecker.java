package com.tencent.liteav.sdk.common;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.o;

@JNINamespace("liteav::license")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseChecker.class */
public class LicenseChecker {
    private b mLicenceCheckListener;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseChecker$a.class */
    public enum a {
        PUSHER(1),
        UGC_SIMPLE(2),
        UGC_STANDARD(4),
        PITU_SIMPLE(8),
        PITU(16),
        PLAYER_STANDARD(32),
        PLAYER_MONET(64);
        
        public int value;

        a(int i) {
            this.value = i;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseChecker$b.class */
    public interface b {
        void a(int i, String str);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseChecker$c.class */
    public enum c {
        LIVE,
        UGC
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseChecker$d.class */
    public enum d {
        OK(0),
        ERROR_JSON_FORMAT(-1),
        ERROR_SIGNATURE(-2),
        ERROR_DECODE(-3),
        ERROR_PACKAGE(-4),
        ERROR_FEATURE(-5),
        ERROR_INNER_NOT_EXIST(-6),
        ERROR_LOCAL_NOT_EXIST(-7),
        ERROR_CONTENT_EMPTY(-8),
        ERROR_WRITE_LICENSE(-9),
        ERROR_WRITE_PITU_LICENSE(-10),
        ERROR_EXPIRED(-11),
        ERROR_DOWNLOAD(-12),
        ERROR_NO_AUTHORIZATION(-13),
        ERROR_UNKNOWN(-14);
        
        public int value;

        d(int i) {
            this.value = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/sdk/common/LicenseChecker$e.class */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static LicenseChecker f36425a = new LicenseChecker();
    }

    static {
        o.a();
    }

    public static LicenseChecker getInstance() {
        return e.f36425a;
    }

    private static native String nativeGetAppId();

    private static native String nativeGetKey(int i);

    private static native String nativeGetLicense(int i);

    private static native void nativeSetClient(LicenseChecker licenseChecker);

    private static native boolean nativeSetLicense(int i, String str, String str2);

    private static native int nativeValid(int i);

    public void OnResult(int i, String str) {
        b bVar = this.mLicenceCheckListener;
        if (bVar != null) {
            bVar.a(i, str);
        }
    }

    public String getAppId() {
        return nativeGetAppId();
    }

    public String getKey(c cVar) {
        return nativeGetKey(cVar.ordinal());
    }

    public String getLicense(c cVar) {
        return nativeGetLicense(cVar.ordinal());
    }

    public boolean setLicense(c cVar, String str, String str2) {
        return nativeSetLicense(cVar.ordinal(), str, str2);
    }

    public void setListener(b bVar) {
        this.mLicenceCheckListener = bVar;
        if (bVar != null) {
            nativeSetClient(this);
        }
    }

    public d valid(a aVar) {
        int nativeValid = nativeValid(aVar.value);
        d[] values = d.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return d.ERROR_UNKNOWN;
            }
            d dVar = values[i2];
            if (dVar.value == nativeValid) {
                return dVar;
            }
            i = i2 + 1;
        }
    }
}
