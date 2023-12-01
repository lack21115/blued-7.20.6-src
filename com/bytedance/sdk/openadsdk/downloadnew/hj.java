package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.config.ko;
import com.ss.android.download.api.config.l;
import com.ss.android.download.api.config.lz;
import com.ss.android.download.api.config.ww;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.download.api.model.mb;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.mb.mb;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.ox.x;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/hj.class */
public class hj {
    public static ITTDownloadVisitor b;
    private static Context h;
    private static final com.ss.android.download.api.download.mb.mb ko;
    public static volatile String mb;
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> u;
    private static final AtomicBoolean hj = new AtomicBoolean(false);
    public static boolean ox = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/hj$b.class */
    public static class b implements lz {
        @Override // com.ss.android.download.api.config.lz
        public void mb(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.lz
        public void mb(Activity activity, String[] strArr, final gm gmVar) {
            if (hj.hj() != null) {
                hj.hj().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.b.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        gm gmVar2 = gmVar;
                        if (gmVar2 != null) {
                            gmVar2.mb(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        gm gmVar2 = gmVar;
                        if (gmVar2 != null) {
                            gmVar2.mb();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.lz
        public boolean mb(Context context, String str) {
            if (hj.hj() != null) {
                return hj.hj().hasPermission(context, str);
            }
            return false;
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/hj$h.class */
    public static class h implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public IDownloadHttpConnection downloadWithConnection(int i, String str, List<HttpHeader> list) throws IOException {
            final b.mb mb = com.bytedance.sdk.openadsdk.downloadnew.b.mb(str, list);
            if (mb != null) {
                return new IDownloadHttpConnection() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.h.1
                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public void cancel() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public void end() {
                        try {
                            mb.hj.disconnect();
                        } catch (Exception e) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
                    public InputStream getInputStream() {
                        return mb.mb;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public int getResponseCode() {
                        return mb.b;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
                    public String getResponseHeaderField(String str2) {
                        if (mb.ox != null) {
                            return mb.ox.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.hj$hj  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/hj$hj.class */
    public static class C0155hj implements je {
        private final WeakReference<Context> mb;

        public C0155hj(Context context) {
            this.mb = new WeakReference<>(context);
        }

        private DialogBuilder b(final DownloadAlertDialogInfo downloadAlertDialogInfo) {
            return DialogBuilder.builder().setTitle(downloadAlertDialogInfo.ox).setMessage(downloadAlertDialogInfo.b).setNegativeBtnText(downloadAlertDialogInfo.h).setPositiveBtnText(downloadAlertDialogInfo.hj).setIcon(downloadAlertDialogInfo.ko).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.hj.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (downloadAlertDialogInfo.ww != null) {
                        downloadAlertDialogInfo.ww.b(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    if (downloadAlertDialogInfo.ww != null) {
                        try {
                            downloadAlertDialogInfo.ww.ox(dialogInterface);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    if (downloadAlertDialogInfo.ww != null) {
                        downloadAlertDialogInfo.ww.mb(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.je
        /* renamed from: mb */
        public AlertDialog ox(DownloadAlertDialogInfo downloadAlertDialogInfo) {
            if (downloadAlertDialogInfo == null || hj.hj() == null) {
                return null;
            }
            boolean z = false;
            if (downloadAlertDialogInfo.mb != null && (downloadAlertDialogInfo.mb instanceof Activity)) {
                ITTDownloadVisitor hj = hj.hj();
                Activity activity = (Activity) downloadAlertDialogInfo.mb;
                if (downloadAlertDialogInfo.x == 1) {
                    z = true;
                }
                return hj.showDialogBySelf(activity, z, b(downloadAlertDialogInfo));
            }
            ITTDownloadVisitor hj2 = hj.hj();
            WeakReference<Context> weakReference = this.mb;
            boolean z2 = false;
            if (downloadAlertDialogInfo.x == 1) {
                z2 = true;
            }
            hj2.showDialogByDelegate(weakReference, z2, b(downloadAlertDialogInfo));
            return null;
        }

        @Override // com.ss.android.download.api.config.je
        public void mb(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                Logger.e("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/hj$mb.class */
    public static class mb implements ko {
        private void b(com.ss.android.download.api.model.ox oxVar) {
            if (oxVar == null) {
                return;
            }
            Object je = oxVar.je();
            JSONObject jSONObject = null;
            if (je instanceof JSONObject) {
                jSONObject = (JSONObject) je;
            }
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(oxVar.ox()).setExtJson(oxVar.ww()).setMaterialMeta(jSONObject).setLabel(oxVar.b());
            boolean z = EventConstants.Tag.NOTIFICATION.equals(oxVar.ox()) || EventConstants.Tag.LANDING_H5_DOWNLOAD_AD_BUTTON.equals(oxVar.ox());
            if (hj.hj() != null) {
                hj.hj().executeLogUpload(label, z);
            }
        }

        private void mb(com.ss.android.download.api.model.ox oxVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (hj.hj() == null || (tTDownloadEventLogger = hj.hj().getTTDownloadEventLogger()) == null || oxVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && hj.hj().isOpenSdkEvent(oxVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(hj.ox(oxVar));
            } else {
                tTDownloadEventLogger.onEvent(hj.ox(oxVar));
            }
        }

        @Override // com.ss.android.download.api.config.ko
        public void mb(com.ss.android.download.api.model.ox oxVar) {
            com.bytedance.sdk.openadsdk.api.mb.ox("LibEventLogger", "onV3Event");
            mb(oxVar, true);
        }

        @Override // com.ss.android.download.api.config.ko
        public void ox(com.ss.android.download.api.model.ox oxVar) {
            com.bytedance.sdk.openadsdk.api.mb.ox("LibEventLogger", "onEvent called");
            mb(oxVar, false);
            b(oxVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/hj$ox.class */
    public static class ox implements ww {
        private ox() {
        }

        @Override // com.ss.android.download.api.config.ww
        public void mb(String str, String str2, Map<String, Object> map, final l lVar) {
            boolean z;
            int hashCode = str.hashCode();
            int i = 1;
            if (hashCode != 70454) {
                if (hashCode == 2461856 && str.equals("POST")) {
                    z = true;
                }
                z = true;
            } else {
                if (str.equals("GET")) {
                    z = false;
                }
                z = true;
            }
            if (!z || !z) {
                i = 0;
            }
            if (hj.hj() != null) {
                hj.hj().execute(i, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.ox.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.mb(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.mb(str3);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.ww
        public void mb(String str, byte[] bArr, String str2, int i, final l lVar) {
            if (hj.hj() != null) {
                hj.hj().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.ox.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.mb(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        l lVar2 = lVar;
                        if (lVar2 != null) {
                            lVar2.mb(str3);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0026 -> B:4:0x001b). Please submit an issue!!! */
    static {
        try {
            mb = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable th) {
        }
        ko = new com.ss.android.download.api.download.mb.mb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.6
            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onCanceled");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void mb(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.mb.mb
            public void ox(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.mb.ox("TTDownloadVisitor", "completeListener: onInstalled");
                hj.b(str);
            }
        };
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> b() {
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        com.ss.android.downloadad.api.mb.ox mb2;
        JSONObject ko2;
        if (TextUtils.isEmpty(str) || (mb2 = u.mb().mb(str)) == null || (ko2 = mb2.ko()) == null || h() == null) {
            return;
        }
        h().checkAutoControl(ko2, str);
    }

    private static Context getContext() {
        Context context = h;
        Context context2 = context;
        if (context == null) {
            context2 = TTAppContextHolder.getContext();
        }
        return context2;
    }

    private static ITTDownloadVisitor h() {
        ITTDownloadVisitor iTTDownloadVisitor = b;
        ITTDownloadVisitor iTTDownloadVisitor2 = iTTDownloadVisitor;
        if (iTTDownloadVisitor == null) {
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager == null) {
                return null;
            }
            iTTDownloadVisitor2 = (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.ox.mb(1));
        }
        return iTTDownloadVisitor2;
    }

    static /* synthetic */ ITTDownloadVisitor hj() {
        return h();
    }

    public static com.ss.android.downloadlib.ww mb() {
        mb(getContext());
        return com.ss.android.downloadlib.ww.mb(getContext());
    }

    private static DownloaderBuilder mb(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new IDownloadSettings() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.5
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadSettings
            public JSONObject get() {
                return hj.hj() != null ? hj.hj().getDownloadSettings() : new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new h());
    }

    public static void mb(int i) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = u;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    public static void mb(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (u == null) {
                u = Collections.synchronizedMap(new WeakHashMap());
            }
            u.put(Integer.valueOf(i), onEventLogHandler);
        }
    }

    public static void mb(Context context) {
        Context context2 = context;
        if (context == null) {
            context2 = TTAppContextHolder.getContext();
        }
        if (context2 == null || hj.get()) {
            return;
        }
        synchronized (hj.class) {
            try {
                if (!hj.get()) {
                    h = context2.getApplicationContext();
                    if (h() != null) {
                        String initPath = h().initPath(ox);
                        if (!TextUtils.isEmpty(initPath)) {
                            mb = initPath;
                        }
                    }
                    hj.set(ox(h));
                }
            } finally {
            }
        }
    }

    public static void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mb = str;
    }

    public static boolean mb(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.mb.mb.mb().mb(activity, false, new mb.InterfaceC0701mb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.7
            @Override // com.ss.android.downloadlib.addownload.mb.mb.InterfaceC0701mb
            public void mb() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }

    public static boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return mb().h().mb(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return mb().h().mb(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean mb(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List<DownloadInfo> ox2 = com.ss.android.socialbase.appdownloader.hj.x().ox(context);
        if (ox2.isEmpty()) {
            return false;
        }
        for (DownloadInfo downloadInfo : ox2) {
            if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                return true;
            }
        }
        return false;
    }

    public static boolean mb(Uri uri) {
        return x.mb(uri);
    }

    public static boolean mb(String str, String str2, JSONObject jSONObject, Object obj) {
        boolean z = false;
        boolean z2 = false;
        if (!TextUtils.isEmpty(str)) {
            z2 = false;
            if (!TextUtils.isEmpty(str2)) {
                if (jSONObject == null) {
                    return false;
                }
                Map<Integer, ITTDownloadAdapter.OnEventLogHandler> b2 = b();
                z2 = false;
                if (b2 != null) {
                    Iterator<Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler>> it = b2.entrySet().iterator();
                    while (true) {
                        z2 = z;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> next = it.next();
                        int intValue = next.getKey().intValue();
                        ITTDownloadAdapter.OnEventLogHandler value = next.getValue();
                        if (value != null) {
                            boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                            if (!z && !onEventLog) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ox(com.ss.android.download.api.model.ox oxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", oxVar.mb());
            jSONObject.put("tag", oxVar.ox());
            jSONObject.put("label", oxVar.b());
            jSONObject.put("isAd", oxVar.hj());
            jSONObject.put("adId", oxVar.h());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, oxVar.u());
            jSONObject.put("extValue", oxVar.ko());
            jSONObject.put("extJson", oxVar.ww());
            jSONObject.put("paramsJson", oxVar.lz());
            jSONObject.put("eventSource", oxVar.jb());
            jSONObject.put("extraObject", oxVar.je());
            jSONObject.put("clickTrackUrl", oxVar.x());
            jSONObject.put("isV3", oxVar.nk());
            jSONObject.put("V3EventName", oxVar.o());
            jSONObject.put("V3EventParams", oxVar.lc());
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    public static void ox() {
        mb().ko();
        if (h() != null) {
            h().clearAllData(mb);
        }
    }

    private static boolean ox(Context context) {
        com.ss.android.download.api.mb mb2;
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        String str = packageName;
        if (TextUtils.isEmpty(packageName)) {
            str = "";
        }
        if (u()) {
            try {
                mb2 = com.ss.android.downloadlib.ww.mb(applicationContext).mb(AdBaseConstants.DownloadConfigureName.PANGOLIN);
            } catch (Throwable th) {
                mb2 = com.ss.android.downloadlib.ww.mb(applicationContext).mb();
            }
        } else {
            mb2 = com.ss.android.downloadlib.ww.mb(applicationContext).mb();
        }
        if (mb2 == null) {
            return false;
        }
        com.ss.android.download.api.mb mb3 = mb2.mb(new b()).mb(new mb()).mb(new C0155hj(applicationContext)).mb(new ox()).mb(new com.ss.android.download.api.config.x() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.3
            @Override // com.ss.android.download.api.config.x
            public JSONObject mb() {
                return hj.hj() != null ? hj.hj().getDownloadSettings() : new JSONObject();
            }
        }).mb(new com.ss.android.download.api.config.ox() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.2
            @Override // com.ss.android.download.api.config.ox
            public boolean mb() {
                if (hj.hj() != null) {
                    return hj.hj().getAppIsBackground();
                }
                return false;
            }
        }).mb(new mb.C0700mb().ox("143").mb(TTAdConstant.APP_NAME).b("5.1.0.2").hj(String.valueOf(5102)).mb()).mb(new e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.1
            @Override // com.ss.android.download.api.config.e
            public byte[] mb(byte[] bArr, int i) {
                return new byte[0];
            }
        });
        mb3.mb(str + ".TTFileProvider").mb(mb(applicationContext, h() != null ? h().getDownloadSettings() : new JSONObject())).mb();
        com.ss.android.downloadlib.utils.mb.mb();
        com.ss.android.downloadlib.ww.mb(applicationContext).hj().mb(1);
        com.ss.android.downloadlib.ww.mb(applicationContext).mb(ko);
        com.ss.android.socialbase.appdownloader.hj.x().mb(new IInstallAppHandler() { // from class: com.bytedance.sdk.openadsdk.downloadnew.hj.4
            @Override // com.ss.android.socialbase.downloader.depend.IInstallAppHandler
            public boolean installApp(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = h().getTTDownloadEventLogger();
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
            return true;
        }
        return true;
    }

    private static boolean u() {
        return false;
    }
}
