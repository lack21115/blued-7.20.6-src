package com.soft.blued.tinker.service;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.download.DownloadManager;
import com.blued.android.framework.download.OnFileDownloadListener;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.CommonTools;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.tinker.model.TinkerExtra;
import com.soft.blued.tinker.model.TinkerModel;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.utils.Logger;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/service/PatchCheckUpdateUtils.class */
public class PatchCheckUpdateUtils {
    public static void a() {
        AppHttpUtils.a(TinkerTools.a(), AppInfo.f9487c, new BluedUIHttpResponse<BluedEntity<TinkerModel, TinkerExtra>>() { // from class: com.soft.blued.tinker.service.PatchCheckUpdateUtils.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(final BluedEntity<TinkerModel, TinkerExtra> bluedEntity) {
                Logger.b("PTH", "patch check update request success");
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    Logger.b("PTH", "patch has no data");
                } else {
                    ThreadManager.a().a(new ThreadExecutor("checkPatchResult") { // from class: com.soft.blued.tinker.service.PatchCheckUpdateUtils.1.1
                        @Override // com.blued.android.framework.pool.ThreadExecutor
                        public void execute() {
                            PatchCheckUpdateUtils.b(bluedEntity);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(BluedEntity<TinkerModel, TinkerExtra> bluedEntity) {
        if (bluedEntity.extra != null && bluedEntity.extra.f29778a == 1) {
            Logger.b("PTH", "patch check update need roll back");
            Tinker.with(AppInfo.d()).cleanPatch();
            return;
        }
        for (TinkerModel tinkerModel : bluedEntity.data) {
            DownloadBaseInfo downloadBaseInfo = new DownloadBaseInfo();
            downloadBaseInfo.download_url = tinkerModel.tinker_url;
            downloadBaseInfo.description = "patch";
            if (TextUtils.isEmpty(downloadBaseInfo.download_url)) {
                Logger.b("PTH", "download_url is empty");
                return;
            }
            String d = CommonTools.d(downloadBaseInfo.download_url);
            String a2 = CommonTools.a();
            Logger.b("PTH", "downloadDirs sub:" + a2);
            if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(d)) {
                DownloadManager.a().a(downloadBaseInfo, new File(a2, d).getAbsolutePath(), new OnFileDownloadListener() { // from class: com.soft.blued.tinker.service.PatchCheckUpdateUtils.2
                    @Override // com.blued.android.framework.download.OnFileDownloadListener
                    public void a(DownloadBaseInfo downloadBaseInfo2) {
                        Logger.b("PTH", "patch download start");
                    }

                    @Override // com.blued.android.framework.download.OnFileDownloadListener
                    public void a(DownloadBaseInfo downloadBaseInfo2, int i, int i2) {
                    }

                    @Override // com.blued.android.framework.download.OnFileDownloadListener
                    public void a(DownloadBaseInfo downloadBaseInfo2, String str) {
                        Logger.b("PTH", "patch file download success");
                        if (downloadBaseInfo2 == null || TextUtils.isEmpty(str) || !new File(str).exists()) {
                            return;
                        }
                        Logger.b("PTH", "patch file path: " + str);
                        TinkerInstaller.onReceiveUpgradePatch(AppInfo.d(), str);
                    }

                    @Override // com.blued.android.framework.download.OnFileDownloadListener
                    public void b(DownloadBaseInfo downloadBaseInfo2) {
                        Logger.b("PTH", "patch download failure");
                    }
                }, false);
            }
        }
    }
}
