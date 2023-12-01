package com.tencent.live2.impl;

import android.content.Context;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePremier;
import com.tencent.rtmp.TXLiveBase;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0943a f37190a = new C0943a();
    private static V2TXLivePremier.V2TXLivePremierObserver b;

    /* renamed from: com.tencent.live2.impl.a$2  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/a$2.class */
    static final /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37191a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[LiteavLog.b.values().length];
            f37191a = iArr;
            try {
                iArr[LiteavLog.b.kInfo.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f37191a[LiteavLog.b.kWarning.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f37191a[LiteavLog.b.kError.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f37191a[LiteavLog.b.kFatal.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.tencent.live2.impl.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/a$a.class */
    public static final class C0943a implements LiteavLog.a {

        /* renamed from: a  reason: collision with root package name */
        V2TXLivePremier.V2TXLivePremierObserver f37192a;

        @Override // com.tencent.liteav.base.util.LiteavLog.a
        public final void a(LiteavLog.b bVar, String str, String str2) {
            int i = AnonymousClass2.f37191a[bVar.ordinal()];
            int i2 = 4;
            if (i == 1) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 3;
            } else if (i != 3) {
                i2 = i != 4 ? 0 : 5;
            }
            V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = this.f37192a;
            if (v2TXLivePremierObserver != null) {
                v2TXLivePremierObserver.onLog(i2, str2);
            }
        }
    }

    public static String a() {
        return CommonUtil.getSDKVersionStr();
    }

    public static void a(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(new LicenseChecker.b() { // from class: com.tencent.live2.impl.a.1
            @Override // com.tencent.liteav.sdk.common.LicenseChecker.b
            public final void a(int i, String str3) {
                V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver = a.b;
                if (v2TXLivePremierObserver != null) {
                    v2TXLivePremierObserver.onLicenceLoaded(i, str3);
                }
            }
        });
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.LIVE, str, str2);
    }

    public static void a(V2TXLiveDef.V2TXLiveLogConfig v2TXLiveLogConfig) {
        if (v2TXLiveLogConfig != null) {
            LiteavLog.nativeSetConsoleLogEnabled(v2TXLiveLogConfig.enableConsole);
            LiteavLog.nativeSetLogToFileEnabled(v2TXLiveLogConfig.enableLogFile);
            if (v2TXLiveLogConfig.logPath != null) {
                LiteavLog.nativeSetLogFilePath(v2TXLiveLogConfig.logPath);
            }
            int i = v2TXLiveLogConfig.logLevel;
            LiteavLog.nativeSetLogLevel((i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? LiteavLog.b.kAll : LiteavLog.b.kNone : LiteavLog.b.kFatal : LiteavLog.b.kError : LiteavLog.b.kWarning : LiteavLog.b.kInfo).mNativeValue);
            C0943a c0943a = f37190a;
            boolean z = v2TXLiveLogConfig.enableObserver;
            LiteavLog.setCallback(z ? c0943a : null);
            LiteavLog.nativeSetLogCallbackEnabled(z);
        }
    }

    public static void a(V2TXLivePremier.V2TXLivePremierObserver v2TXLivePremierObserver) {
        b = v2TXLivePremierObserver;
        f37190a.f37192a = v2TXLivePremierObserver;
    }

    public static void a(String str) {
        TXLiveBase.setGlobalEnv(str);
    }

    public static void a(String str, int i, String str2, String str3) {
        CommonUtil.setSocks5Proxy(str, i, str2, str3);
    }
}
