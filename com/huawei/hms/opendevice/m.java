package com.huawei.hms.opendevice;

import android.content.Context;
import android.media.TtmlUtils;
import android.text.TextUtils;
import com.blued.android.chat.grpc.backup.MsgBackupManager;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/m.class */
public class m {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/m$a.class */
    class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f22820a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f22820a = context;
            this.b = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (!d.b()) {
                HMSLog.d("ReportAaidToken", "Not HW Phone.");
            } else if (m.b(this.f22820a)) {
            } else {
                String a2 = com.huawei.hms.opendevice.b.a(this.f22820a);
                if (TextUtils.isEmpty(a2)) {
                    HMSLog.w("ReportAaidToken", "AAID is empty.");
                } else if (!m.d(this.f22820a, a2, this.b)) {
                    HMSLog.d("ReportAaidToken", "This time need not report.");
                } else {
                    String string = AGConnectServicesConfig.fromContext(this.f22820a).getString(TtmlUtils.TAG_REGION);
                    if (TextUtils.isEmpty(string)) {
                        HMSLog.i("ReportAaidToken", "The data storage region is empty.");
                        return;
                    }
                    String a3 = k.a(this.f22820a, "com.huawei.hms.opendevicesdk", "ROOT", null, string);
                    if (TextUtils.isEmpty(a3)) {
                        return;
                    }
                    String c2 = m.c(this.f22820a, a2, this.b);
                    Context context = this.f22820a;
                    m.b(this.f22820a, g.a(context, a3 + "/rest/appdata/v1/aaid/report", c2, (Map<String, String>) null), a2, this.b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/m$b.class */
    public enum b {
        MOBILE("1"),
        PC("2"),
        TABLET("3"),
        TV("4"),
        SOUNDBOX("5"),
        GLASS("6"),
        WATCH("7"),
        VEHICLE("8"),
        OFFICE_DEVICE("9"),
        IOT_DEVICES("10"),
        HEALTHY("11"),
        ENTERTAINMENT("12"),
        TRANSPORT_DEVICES("13");
        

        /* renamed from: a  reason: collision with root package name */
        private String f22822a;

        b(String str) {
            this.f22822a = str;
        }

        public String a() {
            return this.f22822a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/opendevice/m$c.class */
    public enum c {
        IOS(MsgBackupManager.PLATFORM_IOS),
        ANDROID("android"),
        HARMONY("harmony"),
        WINDOWS("windows"),
        EMBED("embed"),
        OTHERS("others");
        

        /* renamed from: a  reason: collision with root package name */
        private String f22824a;

        c(String str) {
            this.f22824a = str;
        }

        public String a() {
            return this.f22824a;
        }
    }

    public static void a(Context context, String str) {
        new a(context, str).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            HMSLog.e("ReportAaidToken", "Https response is empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("ret", 256);
            if (optInt != 0) {
                HMSLog.e("ReportAaidToken", "Https response body's ret code: " + optInt + ", error message: " + jSONObject.optString("msg"));
                return;
            }
            boolean saveString = i.a(context).saveString("reportAaidAndToken", n.a(str3 + str2, "SHA-256"));
            StringBuilder sb = new StringBuilder();
            sb.append("Report success ");
            sb.append(saveString ? "and save success." : "but save failure.");
            HMSLog.d("ReportAaidToken", sb.toString());
        } catch (JSONException e) {
            HMSLog.e("ReportAaidToken", "Has JSONException.");
        } catch (Exception e2) {
            HMSLog.e("ReportAaidToken", "Exception occur.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context) {
        int packageVersionCode = new PackageManagerHelper(context).getPackageVersionCode("com.huawei.android.pushagent");
        HMSLog.d("ReportAaidToken", "NC version code: " + packageVersionCode);
        return (90101400 <= packageVersionCode && packageVersionCode < 100000000) || packageVersionCode >= 100001301;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Context context, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("timezone", TimeZone.getDefault().getID());
            jSONObject2.put("country", SystemUtils.getLocalCountry());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("agent_version", new PackageManagerHelper(context).getPackageVersionName("com.huawei.android.pushagent"));
            jSONObject3.put("hms_version", String.valueOf(Util.getHmsVersion(context)));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("dev_type", b.MOBILE.a());
            jSONObject4.put("dev_sub_type", "phone");
            jSONObject4.put("os_type", c.ANDROID.a());
            jSONObject4.put("os_version", String.valueOf(HwBuildEx.VERSION.EMUI_SDK_INT));
            jSONObject.put("id", UUID.randomUUID().toString());
            jSONObject.put(Logger.GLOBAL_LOGGER_NAME, jSONObject2);
            jSONObject.put("push_agent", jSONObject3);
            jSONObject.put("hardware", jSONObject4);
            jSONObject.put("aaid", str);
            jSONObject.put("token", str2);
            jSONObject.put("app_id", AGConnectServicesConfig.fromContext(context).getString("client/app_id"));
            jSONObject.put(TtmlUtils.TAG_REGION, AGConnectServicesConfig.fromContext(context).getString(TtmlUtils.TAG_REGION));
            return jSONObject.toString();
        } catch (JSONException e) {
            HMSLog.e("ReportAaidToken", "Catch JSONException.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context, String str, String str2) {
        i a2 = i.a(context);
        if (!a2.containsKey("reportAaidAndToken")) {
            HMSLog.d("ReportAaidToken", "It hasn't been reported, this time needs report.");
            return true;
        }
        String string = a2.getString("reportAaidAndToken");
        if (TextUtils.isEmpty(string)) {
            HMSLog.e("ReportAaidToken", "It has been reported, but sp file is empty, this time needs report.");
            return true;
        }
        return !string.equals(n.a(str2 + str, "SHA-256"));
    }
}
