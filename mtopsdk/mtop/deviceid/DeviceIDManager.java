package mtopsdk.mtop.deviceid;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.cons.b;
import com.ut.device.UTDevice;
import java.net.SocketOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import mtopsdk.common.util.ConfigStoreManager;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.deviceid.domain.MtopSysNewDeviceIdRequest;
import mtopsdk.mtop.deviceid.domain.MtopSysNewDeviceIdResponse;
import mtopsdk.mtop.deviceid.domain.MtopSysNewDeviceIdResponseData;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKConfig;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.MtopConvert;
import mtopsdk.xstate.a;
import mtopsdk.xstate.util.PhoneInfo;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/deviceid/DeviceIDManager.class */
public class DeviceIDManager {
    private static Map a = new HashMap();

    /* renamed from: mtopsdk.mtop.deviceid.DeviceIDManager$1  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/deviceid/DeviceIDManager$1.class */
    class AnonymousClass1 implements Callable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ DeviceIDManager c;

        @Override // java.util.concurrent.Callable
        public String call() {
            String a = this.c.a(this.a, this.b);
            String a2 = this.c.a(this.a);
            if (StringUtils.b(a) || StringUtils.b(a2)) {
                a = this.c.b(this.a, this.b);
            }
            if (StringUtils.a(a)) {
                SDKUtils.a(a);
            }
            return a;
        }
    }

    /* renamed from: mtopsdk.mtop.deviceid.DeviceIDManager$2  reason: invalid class name */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/deviceid/DeviceIDManager$2.class */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ FutureTask a;

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/deviceid/DeviceIDManager$DeviceIdDomain.class */
    public class DeviceIdDomain {
        public boolean a;
        public Future b;
        public String c;

        public DeviceIdDomain(Future future) {
            this.b = future;
        }
    }

    private DeviceIDManager() {
    }

    private void a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        ConfigStoreManager a2 = ConfigStoreManager.a();
        a2.a(context, "MtopConfigStore", "MTOPSDK_DEVICEID_STORE." + str, "deviceId", str2);
        ConfigStoreManager a3 = ConfigStoreManager.a();
        a3.a(context, "MtopConfigStore", "MTOPSDK_DEVICEID_STORE." + str, "deviceId_created", str3);
        DeviceIdDomain deviceIdDomain = (DeviceIdDomain) a.get(str);
        DeviceIdDomain deviceIdDomain2 = deviceIdDomain;
        if (deviceIdDomain == null) {
            deviceIdDomain2 = new DeviceIdDomain(null);
        }
        deviceIdDomain2.c = str2;
        deviceIdDomain2.a = true;
        a.put(str, deviceIdDomain2);
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.DeviceIDManager", "[saveDeviceIdToStore]appkey=" + str + "; deviceId=" + str2 + "; mCreated=" + str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, String str) {
        String str2;
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.DeviceIDManager", "[getRemoteDeviceID] called!appkey=" + str);
        }
        String a2 = a(context);
        String b = PhoneInfo.b(context);
        String c = PhoneInfo.c(context);
        StringBuilder sb = new StringBuilder(64);
        if (StringUtils.a(a2)) {
            sb.append(a2);
        }
        if (StringUtils.a(b)) {
            sb.append(b);
        }
        if (StringUtils.a(c)) {
            sb.append(c);
        }
        if (StringUtils.b(sb.toString())) {
            TBSdkLog.d("mtopsdk.DeviceIDManager", "[getRemoteDeviceID]device_global_id is blank");
            return null;
        }
        MtopSysNewDeviceIdRequest mtopSysNewDeviceIdRequest = new MtopSysNewDeviceIdRequest();
        mtopSysNewDeviceIdRequest.p = sb.toString();
        mtopSysNewDeviceIdRequest.e = true;
        mtopSysNewDeviceIdRequest.q = Build.BRAND;
        mtopSysNewDeviceIdRequest.n = Build.MODEL;
        mtopSysNewDeviceIdRequest.o = b;
        mtopSysNewDeviceIdRequest.l = c;
        mtopSysNewDeviceIdRequest.k = PhoneInfo.e(context);
        mtopSysNewDeviceIdRequest.j = PhoneInfo.a();
        mtopSysNewDeviceIdRequest.g = PhoneInfo.d(context);
        MtopResponse syncRequest = Mtop.a(SDKConfig.a().b()).a(mtopSysNewDeviceIdRequest, SDKConfig.a().h()).setBizId(SocketOptions.SO_OOBINLINE).syncRequest();
        String str3 = null;
        if (syncRequest.i()) {
            try {
                BaseOutDo a3 = MtopConvert.a(syncRequest.d(), MtopSysNewDeviceIdResponse.class);
                str3 = null;
                if (a3 != null) {
                    String str4 = ((MtopSysNewDeviceIdResponseData) a3.b()).a;
                    try {
                        if (StringUtils.a(str4)) {
                            a(context, str, str4, "1");
                        }
                        return str4;
                    } catch (Throwable th) {
                        th = th;
                        str2 = str4;
                        TBSdkLog.d("mtopsdk.DeviceIDManager", "[getRemoteDeviceID] error ---" + th.toString());
                        str3 = str2;
                        return str3;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
            }
        }
        return str3;
    }

    private String c(Context context, String str) {
        if (context == null) {
            return null;
        }
        ConfigStoreManager a2 = ConfigStoreManager.a();
        String a3 = a2.a(context, "MtopConfigStore", "MTOPSDK_DEVICEID_STORE." + str, "deviceId");
        ConfigStoreManager a4 = ConfigStoreManager.a();
        if ("1".equalsIgnoreCase(a4.a(context, "MtopConfigStore", "MTOPSDK_DEVICEID_STORE." + str, "deviceId_created"))) {
            DeviceIdDomain deviceIdDomain = new DeviceIdDomain(null);
            deviceIdDomain.c = a3;
            deviceIdDomain.a = true;
            a.put(str, deviceIdDomain);
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.b("mtopsdk.DeviceIDManager", "[getDeviceIdFromStore] appkey=" + str + "; deviceId=" + a3);
        }
        return a3;
    }

    public String a(Context context) {
        String a2 = a.a(b.g);
        if (StringUtils.a(a2)) {
            SDKUtils.b(a2);
            return a2;
        } else if (context != null) {
            String utdid = UTDevice.getUtdid(context);
            SDKUtils.b(utdid);
            return utdid;
        } else if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
            TBSdkLog.c("mtopsdk.DeviceIDManager", "[getLocalUtdid] Context is null,get Utdid failed");
            return null;
        } else {
            return null;
        }
    }

    public String a(Context context, String str) {
        DeviceIdDomain deviceIdDomain = (DeviceIdDomain) a.get(str);
        return (deviceIdDomain == null || StringUtils.b(deviceIdDomain.c)) ? c(context, str) : deviceIdDomain.c;
    }
}
