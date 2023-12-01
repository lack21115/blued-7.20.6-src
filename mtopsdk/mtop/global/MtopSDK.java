package mtopsdk.mtop.global;

import android.content.Context;
import com.taobao.tao.remotebusiness.listener.c;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.b.a;
import mtopsdk.common.util.SdkSetting;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxyBase;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/global/MtopSDK.class */
public class MtopSDK {
    private static SDKConfig a = SDKConfig.a();
    private static volatile boolean b = false;
    private static AtomicBoolean c = new AtomicBoolean(true);
    private static Object d = new Object();

    /* renamed from: mtopsdk.mtop.global.MtopSDK$3  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/global/MtopSDK$3.class */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ EnvModeEnum a;

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            MtopSDK.a();
            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.b("mtopsdk.MtopSDK", "[switchEnvMode]MtopSDK switchEnvMode start");
            }
            int i = AnonymousClass4.a[this.a.ordinal()];
            if (i == 1) {
                MtopSDK.a.a(EnvModeEnum.ONLINE);
                MtopProxyBase.a = EnvModeEnum.ONLINE;
                SdkSetting.a(SdkSetting.ENV.release);
                MtopSDK.b(this.a);
                if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.b("mtopsdk.MtopSDK", "[switchEnvMode]switch envMode to ONLINE!");
                }
                MtopSDK.a(false);
            } else if (i == 2) {
                MtopSDK.a.a(EnvModeEnum.PREPARE);
                MtopProxyBase.a = EnvModeEnum.PREPARE;
                SdkSetting.a(SdkSetting.ENV.develop);
                MtopSDK.a(true);
                MtopSDK.b(this.a);
                if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                    str = "[switchEnvMode]switch envMode to PRE!";
                    TBSdkLog.b("mtopsdk.MtopSDK", str);
                }
            } else if (i == 3) {
                MtopSDK.a.a(EnvModeEnum.TEST);
                MtopProxyBase.a = EnvModeEnum.TEST;
                SdkSetting.a(SdkSetting.ENV.debug);
                MtopSDK.a(true);
                MtopSDK.b(this.a);
                if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                    str = "[switchEnvMode]switch envMode to DAILY!";
                    TBSdkLog.b("mtopsdk.MtopSDK", str);
                }
            } else if (i == 4) {
                MtopSDK.a.a(EnvModeEnum.TEST_SANDBOX);
                MtopProxyBase.a = EnvModeEnum.TEST_SANDBOX;
                SdkSetting.a(SdkSetting.ENV.debug);
                MtopSDK.a(true);
                MtopSDK.b(this.a);
                if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                    str = "[switchEnvMode]switch envMode to DAILY SandBox!";
                    TBSdkLog.b("mtopsdk.MtopSDK", str);
                }
            }
            MtopSDK.b(MtopSDK.a.b());
            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.b("mtopsdk.MtopSDK", "[switchEnvMode]MtopSDK switchEnvMode end");
            }
        }
    }

    /* renamed from: mtopsdk.mtop.global.MtopSDK$4  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/global/MtopSDK$4.class */
    /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            a = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private MtopSDK() {
    }

    public static void a() {
        if (b) {
            return;
        }
        synchronized (d) {
            try {
                if (!b) {
                    d.wait(60000L);
                    if (!b) {
                        TBSdkLog.d("mtopsdk.MtopSDK", "[checkMtopSDKInit]Didn't call MtopSDK.init(...),please execute global init.");
                    }
                }
            } catch (Exception e) {
                TBSdkLog.d("mtopsdk.MtopSDK", "[checkMtopSDKInit] wait MtopSDK initLock failed---" + e.toString());
            }
        }
    }

    public static void a(final Context context, final c cVar, final String str) {
        synchronized (MtopSDK.class) {
            try {
                if (StringUtils.a(str)) {
                    a.d(str);
                }
                if (!b) {
                    a.a(context);
                    MtopSDKThreadPoolExecutorFactory.a(new Runnable() { // from class: mtopsdk.mtop.global.MtopSDK.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.b("mtopsdk.MtopSDK", "[init]MtopSDK init Called");
                            }
                            MtopSDK.c(context, cVar, str);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Context context, String str) {
        synchronized (MtopSDK.class) {
            try {
                if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.b("mtopsdk.MtopSDK", "[init]ttid=" + str);
                }
                a(context, null, str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(boolean z) {
        TBSdkLog.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context) {
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.MtopSDK", "[executeInitExtraTask]MtopSDK initextra start");
        }
        try {
            SwitchConfig.a().a(context);
        } catch (Throwable th) {
            TBSdkLog.b("mtopsdk.MtopSDK", "[executeInitExtraTask] execute MtopSDK initExtraTask error.---", th);
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.MtopSDK", "[executeInitExtraTask]MtopSDK initextra end");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(EnvModeEnum envModeEnum) {
        if (a.c() == null || envModeEnum == null) {
            return;
        }
        int e = a.e();
        if (EnvModeEnum.TEST.a() == envModeEnum.a() || EnvModeEnum.TEST_SANDBOX.a() == envModeEnum.a()) {
            e = a.d();
        }
        a.c().a(a.b(), e);
        SDKConfig sDKConfig = a;
        sDKConfig.a(sDKConfig.c().a(new a(e, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final Context context, c cVar, String str) {
        synchronized (d) {
            if (b) {
                return;
            }
            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.b("mtopsdk.MtopSDK", "[executeInitCoreTask]MtopSDK initcore start. ttid=" + str);
            }
            a.a(context);
            mtopsdk.xstate.a.a(context);
            if (StringUtils.a(str)) {
                a.d(str);
            }
            c cVar2 = cVar;
            if (cVar == null) {
                cVar2 = new c();
            }
            cVar2.a(context, a.e());
            a.a(cVar2);
            a.a(cVar2.a(new a(a.e(), null)));
            b = true;
            d.notifyAll();
            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.b("mtopsdk.MtopSDK", "[executeInitCoreTask]MtopSDK initcore end");
            }
            MtopSDKThreadPoolExecutorFactory.a(new Runnable() { // from class: mtopsdk.mtop.global.MtopSDK.2
                @Override // java.lang.Runnable
                public final void run() {
                    MtopSDK.b(context);
                }
            });
        }
    }
}
