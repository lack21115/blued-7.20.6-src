package com.bytedance.android.openliveplugin.material;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.openliveplugin.net.NetApi;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/openliveplugin/material/LiveInitMaterialManager.class */
public class LiveInitMaterialManager {
    private static final String FETCH_PLUGIN_SETTINGS_URL = "/webcast/openapi/pangle/setting/";
    private static final String HOST = "https://webcast-open.douyin.com";
    private static final String MATERIAL_NAME = "material";
    private static final String TAG = "LiveInitMaterialManager";
    private volatile boolean isDownloading;
    private final AtomicInteger mRetryCount = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: private */
    public void download(final Context context, final String str, final String str2, final String str3, final ILiveMaterialGet iLiveMaterialGet) {
        if (this.isDownloading) {
            TTLogger.d(TAG, "live init : Downloading...");
            return;
        }
        try {
            Downloader.with(context).url(str).savePath(str2).name(str3).retryCount(3).needRetryDelay(false).subThreadListener(new AbsDownloadListener() { // from class: com.bytedance.android.openliveplugin.material.LiveInitMaterialManager.1
                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onCanceled(DownloadInfo downloadInfo) {
                    TTLogger.d(LiveInitMaterialManager.TAG, "live init : Download task canceled.");
                    LiveInitMaterialManager.this.isDownloading = false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                    TTLogger.e(LiveInitMaterialManager.TAG, "live init : Download failed. " + baseException);
                    LiveInitMaterialManager.this.isDownloading = false;
                    if (LiveInitMaterialManager.this.mRetryCount.getAndIncrement() < 3) {
                        LiveInitMaterialManager.this.download(context, str, str2, str3, iLiveMaterialGet);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
                public void onSuccessed(DownloadInfo downloadInfo) {
                    try {
                        ZipFileUtil.unZipFolder(new File(downloadInfo.getSavePath(), downloadInfo.getName()).getAbsolutePath(), downloadInfo.getSavePath());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ConfigParams localConfigParams = LiveInitMaterialManager.this.getLocalConfigParams(context);
                    ILiveMaterialGet iLiveMaterialGet2 = iLiveMaterialGet;
                    if (iLiveMaterialGet2 != null) {
                        iLiveMaterialGet2.onMaterialGet(localConfigParams);
                    }
                    TTLogger.d(LiveInitMaterialManager.TAG, "live init : Download end.");
                    LiveInitMaterialManager.this.isDownloading = false;
                }
            }).download();
            TTLogger.d(TAG, "live init : Download start.");
            this.isDownloading = true;
        } catch (Throwable th) {
            TTLogger.e(TAG, "live init : Download file error: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConfigParams getLocalConfigParams(Context context) {
        File file;
        File file2;
        JSONObject jSONObject;
        File file3 = new File(getMaterialDownloadPath(context));
        if (file3.exists()) {
            File[] listFiles = file3.listFiles();
            ConfigParams configParams = null;
            if (listFiles != null) {
                if (listFiles.length <= 0) {
                    return null;
                }
                int length = listFiles.length;
                int i = 0;
                File file4 = null;
                File file5 = null;
                while (true) {
                    File file6 = file5;
                    file = file4;
                    file2 = file6;
                    if (i >= length) {
                        break;
                    }
                    File file7 = listFiles[i];
                    file = file4;
                    if (file7.isFile()) {
                        file = file4;
                        if (file7.getName().contains("_config")) {
                            file = file7;
                        }
                    }
                    file2 = file6;
                    if (file7.isFile()) {
                        file2 = file6;
                        if (file7.getAbsolutePath().endsWith(".lic")) {
                            file2 = file7;
                        }
                    }
                    if (file != null && file2 != null) {
                        break;
                    }
                    i++;
                    file4 = file;
                    file5 = file2;
                }
                configParams = null;
                if (file != null) {
                    try {
                        jSONObject = new JSONObject(ZipFileUtil.readTextFile(file));
                        configParams = new ConfigParams();
                    } catch (JSONException e) {
                        e = e;
                        configParams = null;
                    }
                    try {
                        configParams.appID = jSONObject.optLong("appid");
                        configParams.webcastAppID = jSONObject.optLong("webcast_appid");
                        configParams.ttsdkAppID = jSONObject.optLong("ttsdk_appid");
                        configParams.clientKey = jSONObject.optString("client_key");
                        configParams.version = jSONObject.optLong("version");
                        if (file2 != null) {
                            configParams.ttSDKLicensePath = file2.getAbsolutePath();
                        }
                        return configParams;
                    } catch (JSONException e2) {
                        e = e2;
                        TTLogger.e(TAG, "live init : parse local file error : " + e);
                        e.printStackTrace();
                        return configParams;
                    }
                }
            }
            return configParams;
        }
        return null;
    }

    private String getMaterialDownloadPath(Context context) {
        return context.getFilesDir() + File.separator + "pangle_com.byted.live.lite" + File.separator + ".msdata_lc" + File.separator;
    }

    private ResPackage startCheckLiveInitMaterial(String str, Application application) {
        if (TextUtils.isEmpty(str) || application == null) {
            return null;
        }
        String request = NetApi.getInstance().request(false, "https://webcast-open.douyin.com/webcast/openapi/pangle/setting/?app_id=" + str + "&package_name=" + application.getPackageName(), null);
        if (TextUtils.isEmpty(request)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(request);
            ResPackage resPackage = new ResPackage();
            resPackage.statusCode = jSONObject.optLong("status_code");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            resPackage.resUrl = optJSONObject.optString("setting_url");
            resPackage.version = optJSONObject.optLong("version");
            return resPackage;
        } catch (JSONException e) {
            return null;
        }
    }

    public void run(String str, Application application, ILiveMaterialGet iLiveMaterialGet) {
        ResPackage startCheckLiveInitMaterial = startCheckLiveInitMaterial(str, application);
        if (startCheckLiveInitMaterial == null || !startCheckLiveInitMaterial.isLegal()) {
            TTLogger.e("live init : material task res package null error");
            ConfigParams localConfigParams = getLocalConfigParams(application);
            if (localConfigParams == null || iLiveMaterialGet == null) {
                return;
            }
            iLiveMaterialGet.onMaterialGet(localConfigParams);
            return;
        }
        long j = 0;
        ConfigParams localConfigParams2 = getLocalConfigParams(application);
        if (localConfigParams2 != null) {
            j = localConfigParams2.version;
        }
        if (startCheckLiveInitMaterial.version <= j) {
            if (iLiveMaterialGet != null) {
                iLiveMaterialGet.onMaterialGet(localConfigParams2);
            }
        } else if (TextUtils.isEmpty(startCheckLiveInitMaterial.resUrl)) {
            TTLogger.e("live init : material task res download url empty error");
        } else {
            ZipFileUtil.removeDir(new File(getMaterialDownloadPath(application)));
            File file = new File(getMaterialDownloadPath(application));
            if (!file.exists()) {
                file.mkdir();
            }
            TTLogger.d("live init : start download material res");
            download(application, startCheckLiveInitMaterial.resUrl, getMaterialDownloadPath(application), MATERIAL_NAME, iLiveMaterialGet);
        }
    }
}
