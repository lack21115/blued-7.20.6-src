package com.tencent.rtmp;

import android.content.Context;
import com.tencent.liteav.LiveSettingJni;
import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.videoconsumer.decoder.ExternalDecodeFactoryManager;
import com.tencent.liteav.videoconsumer.decoder.o;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLiveBase.class */
public class TXLiveBase {
    private static final String TAG = "TXLiveBase";
    private static TXLiveBase instance = new TXLiveBase();
    private static c networkTimeCallback = new c((byte) 0);
    private static TXLiveBaseListener sListener;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLiveBase$a.class */
    static final class a implements o {

        /* renamed from: a  reason: collision with root package name */
        private TXLiteAVExternalDecoderFactoryInterface f24969a;

        public a(TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface) {
            this.f24969a = tXLiteAVExternalDecoderFactoryInterface;
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.o
        public final long a() {
            long CreateHevcDecoder = this.f24969a.CreateHevcDecoder();
            LiteavLog.i("ExternalDecoderWrapper", "Create external hevc decoder. decoder:".concat(String.valueOf(CreateHevcDecoder)));
            return CreateHevcDecoder;
        }

        @Override // com.tencent.liteav.videoconsumer.decoder.o
        public final void a(long j) {
            LiteavLog.i("ExternalDecoderWrapper", "Destroy external hevc decoder. handler:".concat(String.valueOf(j)));
            this.f24969a.DestroyHevcDecoder(j);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLiveBase$b.class */
    static final class b implements LiteavLog.a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.tencent.liteav.base.util.LiteavLog.a
        public final void a(LiteavLog.b bVar, String str, String str2) {
            TXLiveBaseListener tXLiveBaseListener = TXLiveBase.sListener;
            if (tXLiveBaseListener != null) {
                tXLiveBaseListener.onLog(bVar.mNativeValue, str, str2);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXLiveBase$c.class */
    static final class c implements CommonUtil.a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.tencent.liteav.base.util.CommonUtil.a
        public final void a(int i, String str) {
            TXLiveBase.onUpdateNetworkTime(i, str);
        }
    }

    static {
        if (com.tencent.liteav.base.util.o.a()) {
            CommonUtil.setUpdateNetworkTimeCallback(networkTimeCallback);
        }
    }

    private TXLiveBase() {
    }

    public static TXLiveBase getInstance() {
        return instance;
    }

    public static long getNetworkTimestamp() {
        return CommonUtil.getNetworkTimestamp();
    }

    public static String getPituSDKVersion() {
        return "";
    }

    public static String getSDKVersionStr() {
        return CommonUtil.getSDKVersionStr();
    }

    public static boolean isLibraryPathValid(String str) {
        return false;
    }

    public static void onUpdateNetworkTime(int i, String str) {
        TXLiveBaseListener tXLiveBaseListener = sListener;
        if (tXLiveBaseListener != null) {
            tXLiveBaseListener.onUpdateNetworkTime(i, str);
        }
    }

    public static void setAppID(String str) {
        LiveSettingJni.nativeSetAppId(str);
    }

    public static void setAppVersion(String str) {
    }

    public static void setConsoleEnabled(boolean z) {
        LiteavLog.nativeSetConsoleLogEnabled(z);
    }

    public static boolean setExtID(String str, String str2) {
        return LiteavSystemInfo.setExtID(str, str2);
    }

    public static void setExternalDecoderFactory(TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface) {
        LiteavLog.i(TAG, "Set external decoder factory. factory:".concat(String.valueOf(tXLiteAVExternalDecoderFactoryInterface)));
        if (tXLiteAVExternalDecoderFactoryInterface == null) {
            ExternalDecodeFactoryManager.a(null);
        } else {
            ExternalDecodeFactoryManager.a(new a(tXLiteAVExternalDecoderFactoryInterface));
        }
    }

    public static int setGlobalEnv(String str) {
        return CommonUtil.setGlobalEnv(str);
    }

    public static void setLibraryPath(String str) {
        com.tencent.liteav.base.util.o.b(str);
        if (com.tencent.liteav.base.util.o.a()) {
            CommonUtil.setUpdateNetworkTimeCallback(networkTimeCallback);
        }
    }

    public static void setListener(TXLiveBaseListener tXLiveBaseListener) {
        boolean z = false;
        LiteavLog.setCallback(new b((byte) 0));
        if (tXLiveBaseListener != null) {
            z = true;
        }
        LiteavLog.nativeSetLogCallbackEnabled(z);
        sListener = tXLiveBaseListener;
    }

    public static void setLogLevel(int i) {
        LiteavLog.b bVar = LiteavLog.b.kAll;
        LiteavLog.nativeSetLogLevel((i != 2 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? LiteavLog.b.kAll : LiteavLog.b.kNone : LiteavLog.b.kFatal : LiteavLog.b.kError : LiteavLog.b.kWarning : LiteavLog.b.kInfo).mNativeValue);
    }

    public static void setPituLicencePath(String str) {
    }

    public static void setUserId(String str) {
        LiveSettingJni.nativeSetUserId(str);
    }

    public static int updateNetworkTime() {
        return CommonUtil.updateNetworkTime();
    }

    public String getLicenceInfo(Context context) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        return LicenseChecker.getInstance().getLicense(LicenseChecker.c.LIVE);
    }

    public void setLicence(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(new LicenseChecker.b() { // from class: com.tencent.rtmp.TXLiveBase.1
            @Override // com.tencent.liteav.sdk.common.LicenseChecker.b
            public final void a(int i, String str3) {
                TXLiveBaseListener tXLiveBaseListener = TXLiveBase.sListener;
                if (tXLiveBaseListener != null) {
                    tXLiveBaseListener.onLicenceLoaded(i, str3);
                }
            }
        });
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.LIVE, str, str2);
    }
}
