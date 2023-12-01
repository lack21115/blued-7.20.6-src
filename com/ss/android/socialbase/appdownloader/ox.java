package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ox.class */
public class ox {
    private static mb b;
    private static final String mb = ox.class.getSimpleName();
    private static b ox;

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ox$b.class */
    public interface b {
        void mb(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.mb mbVar);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ox$h.class */
    static class h implements WeakDownloadHandler.IHandler {
        public static int mb;
        private static int ox;
        private final Context b;
        private final InterfaceC0715ox h;
        private final Intent hj;
        private final long ko;
        private boolean lz = false;
        private final Handler u;
        private Future<Boolean> ww;

        public h(Context context, Intent intent, int i, InterfaceC0715ox interfaceC0715ox, long j) {
            this.b = context;
            this.hj = intent;
            ox = i;
            this.h = interfaceC0715ox;
            this.u = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.ko = j;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message != null) {
                boolean z = true;
                if (message.what == 1) {
                    long j = this.ko;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    mb = 1;
                    this.ww = DownloadComponentManager.getCPUThreadExecutor().submit(new hj(this.u, this.b, this.h, this.ko));
                } else if (message.what == 2) {
                    mb = 2;
                    this.u.removeMessages(2);
                    this.u.removeMessages(1);
                    Future<Boolean> future = this.ww;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.lz && (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground())) {
                        Intent intent = this.hj;
                        if (intent != null) {
                            ox.ox(this.b, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.b).getDownloadInfo(ox);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.b.ox(this.b, ox, false);
                            }
                        }
                        this.lz = true;
                    }
                    if (this.hj != null) {
                        z = false;
                    }
                    ox.ox(ox, z, ox.mb(this.b));
                }
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ox$hj.class */
    static class hj implements Callable<Boolean> {
        private final Handler b;
        private final long hj;
        private final Context mb;
        private final InterfaceC0715ox ox;

        public hj(Handler handler, Context context, InterfaceC0715ox interfaceC0715ox, long j) {
            this.mb = context;
            this.ox = interfaceC0715ox;
            this.b = handler;
            this.hj = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            if (this.ox != null && this.hj > 0 && this.hj <= 10000) {
                Context context = this.mb;
                boolean mb = context != null ? this.ox.mb(context) : false;
                Message obtain = Message.obtain();
                if (mb) {
                    obtain.what = 2;
                    this.b.sendMessage(obtain);
                } else {
                    obtain.what = 1;
                    this.b.sendMessageDelayed(obtain, this.hj);
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ox$mb.class */
    public static class mb implements AppStatusManager.AppStatusChangeListener {
        private JSONObject b;
        private final h mb;
        private final int ox;

        public mb(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0715ox interfaceC0715ox) {
            this.b = jSONObject;
            int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.ox = optInt;
            this.mb = new h(context, intent, i, interfaceC0715ox, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int optInt = this.b.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.mb.u.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.mb.u.sendMessageDelayed(obtain2, optInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.mb.lz) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.mb.u.sendMessage(obtain);
            }
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            mb unused = ox.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.ox$ox  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/ox$ox.class */
    public interface InterfaceC0715ox {
        boolean mb(Context context);
    }

    public static void b(int i, JSONObject jSONObject) {
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("scene", z ? 1 : 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            return true;
        }
    }

    private static void hj(int i, JSONObject jSONObject) {
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("scene", z ? 1 : 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hj(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable th) {
            return true;
        }
    }

    public static int mb(DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        int i;
        if (downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !TextUtils.isEmpty(optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false) {
            if (DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) {
                JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
                int i2 = -1;
                int i3 = -1;
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    int i4 = 0;
                    while (true) {
                        i3 = i2;
                        if (i4 >= length) {
                            break;
                        }
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                        int i5 = i2;
                        if (com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONObject2)) {
                            String optString = optJSONObject2.optString("type");
                            if ("plan_a".equals(optString) || "plan_b".equals(optString) || "plan_e".equals(optString) || "plan_f".equals(optString)) {
                                com.ss.android.socialbase.appdownloader.mb mb2 = mb(optJSONObject2, downloadSetting);
                                i = mb2.ox;
                                if (mb2.ox == 0) {
                                    return 0;
                                }
                            } else if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString)) {
                                return 0;
                            } else {
                                i5 = i2;
                                if ("plan_g".equalsIgnoreCase(optString)) {
                                    com.ss.android.socialbase.appdownloader.mb ox2 = ox(optJSONObject2, downloadSetting);
                                    i = ox2.ox;
                                    if (ox2.ox == 0) {
                                        return 0;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            i5 = i;
                        }
                        i4++;
                        i2 = i5;
                    }
                }
                return i3;
            }
            return 4;
        }
        return 5;
    }

    public static com.ss.android.socialbase.appdownloader.mb mb(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.mb mbVar = new com.ss.android.socialbase.appdownloader.mb();
        if (jSONObject == null) {
            return mbVar;
        }
        String optString = jSONObject.optString("type");
        mbVar.mb = optString;
        if ("plan_b".equals(optString)) {
            mbVar.h = WbCloudFaceContant.CUSTOM;
            if (com.ss.android.socialbase.appdownloader.mb.hj.mb(DownloadComponentManager.getAppContext(), WbCloudFaceContant.CUSTOM, jSONObject, downloadSetting)) {
                mbVar.ox = 0;
                return mbVar;
            }
            mb(mbVar, 3);
            return mbVar;
        }
        String optString2 = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
        mbVar.h = optString2;
        if (!TextUtils.isEmpty(optString2)) {
            String[] split = optString2.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                if (com.ss.android.socialbase.appdownloader.mb.hj.mb(DownloadComponentManager.getAppContext(), split[i2], jSONObject, downloadSetting)) {
                    mbVar.ox = 0;
                    return mbVar;
                }
                mb(mbVar, 3);
                i = i2 + 1;
            }
        }
        return mbVar;
    }

    public static com.ss.android.socialbase.appdownloader.mb mb(JSONObject jSONObject, String str, Context context, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.mb mbVar = new com.ss.android.socialbase.appdownloader.mb();
        if (jSONObject != null) {
            if (!com.ss.android.socialbase.appdownloader.u.hj.ox()) {
                return mbVar;
            }
            mbVar.mb = jSONObject.optString("type");
            if (downloadSetting.optInt("bi", 0) == 1) {
                mbVar.ox = 0;
                return mbVar;
            } else if (mb(context)) {
                mbVar.ox = 2;
                return mbVar;
            } else if (com.ss.android.socialbase.appdownloader.u.mb.mb(str) != null) {
                mbVar.ox = 0;
                return mbVar;
            } else {
                mbVar.ox = 9;
            }
        }
        return mbVar;
    }

    public static String mb(Throwable th) {
        String th2 = th.toString();
        String str = th2;
        if (th2.length() > 800) {
            str = th2.substring(0, 500);
        }
        return str;
    }

    public static void mb(int i, JSONObject jSONObject) {
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("scene", z ? 1 : 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    private static void mb(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0715ox interfaceC0715ox) {
        if (b != null) {
            AppStatusManager.getInstance().unregisterAppSwitchListener(b);
            b = null;
        }
        b = new mb(context, intent, i, jSONObject, interfaceC0715ox);
        AppStatusManager.getInstance().registerAppSwitchListener(b);
    }

    private static void mb(com.ss.android.socialbase.appdownloader.mb mbVar, int i) {
        if (mbVar.ox != -1) {
            mbVar.ox = (mbVar.ox * 10) + i;
        } else {
            mbVar.ox = i;
        }
    }

    public static void mb(b bVar) {
        ox = bVar;
    }

    public static boolean mb() {
        return h.mb == 1;
    }

    public static boolean mb(Context context) {
        if (context == null) {
            return true;
        }
        try {
            if (!com.ss.android.socialbase.appdownloader.u.hj.ox() || Build.VERSION.SDK_INT >= 26) {
                if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26) {
                    return true;
                }
                return h(context);
            }
            return hj(context);
        } catch (Throwable th) {
            return true;
        }
    }

    public static boolean mb(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.u.hj.ox() && Build.VERSION.SDK_INT < 26 && !hj(context)) {
                com.ss.android.socialbase.appdownloader.mb.u uVar = new com.ss.android.socialbase.appdownloader.mb.u(context);
                if (uVar.mb()) {
                    mb(context, intent, i, jSONObject, new InterfaceC0715ox() { // from class: com.ss.android.socialbase.appdownloader.ox.1
                        @Override // com.ss.android.socialbase.appdownloader.ox.InterfaceC0715ox
                        public boolean mb(Context context2) {
                            return ox.hj(context2);
                        }
                    });
                    return ox(context, uVar.ox());
                }
                return false;
            } else if (Build.VERSION.SDK_INT < 26 || context.getApplicationInfo().targetSdkVersion < 26 || h(context)) {
                return false;
            } else {
                com.ss.android.socialbase.appdownloader.mb.ox oxVar = new com.ss.android.socialbase.appdownloader.mb.ox(context);
                if (oxVar.mb()) {
                    mb(context, intent, i, jSONObject, new InterfaceC0715ox() { // from class: com.ss.android.socialbase.appdownloader.ox.2
                        @Override // com.ss.android.socialbase.appdownloader.ox.InterfaceC0715ox
                        public boolean mb(Context context2) {
                            return ox.h(context2);
                        }
                    });
                    return ox(context, oxVar.ox());
                }
                return false;
            }
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean mb(Context context, Intent intent, JSONObject jSONObject, int i, com.ss.android.socialbase.appdownloader.mb mbVar) {
        if (context == null || jSONObject == null) {
            return false;
        }
        long optLong = jSONObject.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
        if (optLong <= 0) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
        if ((System.currentTimeMillis() - sharedPreferences.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L)) / 60000 >= optLong && !mb(context)) {
            sharedPreferences.edit().putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis()).apply();
            if (!(jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1)) {
                if (mb(context, intent, i, jSONObject)) {
                    b(i, jSONObject);
                    return true;
                }
                return true;
            }
            Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
            intent2.addFlags(268435456);
            intent2.putExtra("intent", intent);
            intent2.putExtra(com.igexin.push.core.b.U, jSONObject.toString());
            intent2.putExtra("id", i);
            try {
                if (mb(context, intent2, false)) {
                    hj(i, jSONObject);
                    return true;
                }
                return true;
            } catch (Throwable th) {
                if (mbVar != null) {
                    mbVar.ox = 1;
                    mbVar.b = "tryShowUnknownSourceDialog" + mb(th);
                    return false;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean mb(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (!z) {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        }
        try {
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x014e, code lost:
        if (com.ss.android.socialbase.appdownloader.u.hj.ox() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0175, code lost:
        if (r10 != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean mb(android.content.Context r6, com.ss.android.socialbase.downloader.model.DownloadInfo r7, android.content.Intent r8, org.json.JSONObject r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 945
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.ox.mb(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray == null) {
            return false;
        }
        int length = optJSONArray.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (com.ss.android.socialbase.appdownloader.u.mb.mb(optJSONObject) && mb(context, downloadInfo, intent, optJSONObject, z)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static boolean mb(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.mb mbVar) {
        boolean z;
        String str;
        if (context == null || jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
        mbVar.h = optString;
        if (TextUtils.isEmpty(optString)) {
            return false;
        }
        String[] split = optString.split(",");
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath)) {
            return false;
        }
        File file = new File(savePath);
        StringBuilder sb = new StringBuilder();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            z = true;
            if (i2 >= length) {
                z = false;
                str = null;
                break;
            }
            String str2 = split[i2];
            com.ss.android.socialbase.appdownloader.mb.mb mb2 = com.ss.android.socialbase.appdownloader.mb.hj.mb(context, str2, jSONObject, downloadInfo);
            if (mb2 != null) {
                Intent ox2 = mb2.ox();
                if (ox2 == null) {
                    mb(mbVar, 3);
                    sb.append(str2);
                    sb.append(" resolveActivity failed! ");
                } else if (mb(file, downloadInfo, jSONObject)) {
                    try {
                        mb(context, ox2, false);
                        str = str2;
                        break;
                    } catch (Throwable th) {
                        sb.append(str2);
                        sb.append(" startActivity failed : ");
                        sb.append(mb(th));
                        mb(mbVar, 1);
                    }
                } else {
                    mb(mbVar, 6);
                    sb.append(str2);
                    sb.append(" createDescFile failed! ");
                }
            }
            sb.append("  ");
            i = i2 + 1;
        }
        if (!z) {
            mbVar.b = sb.toString();
            return z;
        }
        mbVar.hj = str;
        mbVar.ox = 0;
        return z;
    }

    private static boolean mb(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.mb mbVar, DownloadSetting downloadSetting) {
        boolean z;
        String optString = jSONObject.optString("type");
        mbVar.mb = optString;
        Intent ox2 = com.ss.android.socialbase.appdownloader.mb.hj.mb(context, "vbi", jSONObject, downloadInfo).ox();
        StringBuilder sb = new StringBuilder();
        try {
            z = ox(context, ox2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(mb(th));
            mb(mbVar, 1);
            z = false;
        }
        if (z) {
            mbVar.ox = 0;
            return true;
        }
        mbVar.b = sb.toString();
        return true;
    }

    private static boolean mb(File file, DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject optJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        String optString = optJSONObject != null ? optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC) : null;
        File file2 = null;
        if (!TextUtils.isEmpty(optString)) {
            file2 = null;
            if (!TextUtils.isEmpty(optString)) {
                file2 = new File(path + File.separator + optString);
            }
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                    return true;
                }
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    public static com.ss.android.socialbase.appdownloader.mb ox(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.mb mbVar = new com.ss.android.socialbase.appdownloader.mb();
        if (jSONObject == null) {
            return mbVar;
        }
        mbVar.mb = jSONObject.optString("type");
        mbVar.h = "vbi";
        if (com.ss.android.socialbase.appdownloader.mb.hj.mb(DownloadComponentManager.getAppContext(), "vbi", jSONObject, downloadSetting)) {
            mbVar.ox = 0;
            return mbVar;
        }
        mb(mbVar, 3);
        return mbVar;
    }

    public static void ox(int i, JSONObject jSONObject) {
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("scene", z ? 1 : 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", z ? 1 : 2);
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, z2 ? 1 : 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ox(Context context, Intent intent) {
        return mb(context, intent, true);
    }

    private static boolean ox(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.mb mbVar) {
        if (context == null || jSONObject == null) {
            return false;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath)) {
            return false;
        }
        mbVar.hj = WbCloudFaceContant.CUSTOM;
        com.ss.android.socialbase.appdownloader.mb.mb mb2 = com.ss.android.socialbase.appdownloader.mb.hj.mb(context, WbCloudFaceContant.CUSTOM, jSONObject, downloadInfo);
        if (mb2 == null || !mb2.mb()) {
            mbVar.ox = 3;
            return false;
        }
        Intent ox2 = mb2.ox();
        if (ox2 == null) {
            return false;
        }
        if (!mb(new File(savePath), downloadInfo, jSONObject)) {
            mbVar.ox = 6;
            return false;
        } else if (ox(context, ox2)) {
            mbVar.ox = 0;
            return true;
        } else {
            mbVar.ox = 1;
            return false;
        }
    }
}
