package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.download.DownloadParams;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/cm.class */
public final class cm implements com.kwad.sdk.core.d<DownloadParams> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(DownloadParams downloadParams, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        downloadParams.mDownloadid = jSONObject.optString("mDownloadid");
        if (downloadParams.mDownloadid == JSONObject.NULL) {
            downloadParams.mDownloadid = "";
        }
        downloadParams.mAppName = jSONObject.optString("mAppName");
        if (downloadParams.mAppName == JSONObject.NULL) {
            downloadParams.mAppName = "";
        }
        downloadParams.mPkgname = jSONObject.optString("mPkgname");
        if (downloadParams.mPkgname == JSONObject.NULL) {
            downloadParams.mPkgname = "";
        }
        downloadParams.mVersion = jSONObject.optString("mVersion");
        if (downloadParams.mVersion == JSONObject.NULL) {
            downloadParams.mVersion = "";
        }
        downloadParams.mVersionCode = jSONObject.optString("mVersionCode");
        if (downloadParams.mVersionCode == JSONObject.NULL) {
            downloadParams.mVersionCode = "";
        }
        downloadParams.mAppSize = jSONObject.optLong("mAppSize");
        downloadParams.mFileMd5 = jSONObject.optString("mFileMd5");
        if (downloadParams.mFileMd5 == JSONObject.NULL) {
            downloadParams.mFileMd5 = "";
        }
        downloadParams.mFileUrl = jSONObject.optString("mFileUrl");
        if (downloadParams.mFileUrl == JSONObject.NULL) {
            downloadParams.mFileUrl = "";
        }
        downloadParams.mAppIcon = jSONObject.optString("mAppIcon");
        if (downloadParams.mAppIcon == JSONObject.NULL) {
            downloadParams.mAppIcon = "";
        }
        downloadParams.mShortDesc = jSONObject.optString("mShortDesc");
        if (downloadParams.mShortDesc == JSONObject.NULL) {
            downloadParams.mShortDesc = "";
        }
        downloadParams.mTaskId = jSONObject.optInt("mTaskId");
        downloadParams.filePath = jSONObject.optString("filePath");
        if (downloadParams.filePath == JSONObject.NULL) {
            downloadParams.filePath = "";
        }
        downloadParams.requestInstallPermission = jSONObject.optBoolean("requestInstallPermission");
        downloadParams.downloadEnablePause = jSONObject.optBoolean("downloadEnablePause");
        downloadParams.downloadPlace = jSONObject.optInt("downloadPlace");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(DownloadParams downloadParams, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (downloadParams.mDownloadid != null && !downloadParams.mDownloadid.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mDownloadid", downloadParams.mDownloadid);
        }
        if (downloadParams.mAppName != null && !downloadParams.mAppName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mAppName", downloadParams.mAppName);
        }
        if (downloadParams.mPkgname != null && !downloadParams.mPkgname.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mPkgname", downloadParams.mPkgname);
        }
        if (downloadParams.mVersion != null && !downloadParams.mVersion.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mVersion", downloadParams.mVersion);
        }
        if (downloadParams.mVersionCode != null && !downloadParams.mVersionCode.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mVersionCode", downloadParams.mVersionCode);
        }
        if (downloadParams.mAppSize != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mAppSize", downloadParams.mAppSize);
        }
        if (downloadParams.mFileMd5 != null && !downloadParams.mFileMd5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mFileMd5", downloadParams.mFileMd5);
        }
        if (downloadParams.mFileUrl != null && !downloadParams.mFileUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mFileUrl", downloadParams.mFileUrl);
        }
        if (downloadParams.mAppIcon != null && !downloadParams.mAppIcon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mAppIcon", downloadParams.mAppIcon);
        }
        if (downloadParams.mShortDesc != null && !downloadParams.mShortDesc.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mShortDesc", downloadParams.mShortDesc);
        }
        if (downloadParams.mTaskId != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "mTaskId", downloadParams.mTaskId);
        }
        if (downloadParams.filePath != null && !downloadParams.filePath.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "filePath", downloadParams.filePath);
        }
        if (downloadParams.requestInstallPermission) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "requestInstallPermission", downloadParams.requestInstallPermission);
        }
        if (downloadParams.downloadEnablePause) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadEnablePause", downloadParams.downloadEnablePause);
        }
        if (downloadParams.downloadPlace != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "downloadPlace", downloadParams.downloadPlace);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(DownloadParams downloadParams, JSONObject jSONObject) {
        a2(downloadParams, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(DownloadParams downloadParams, JSONObject jSONObject) {
        return b2(downloadParams, jSONObject);
    }
}
