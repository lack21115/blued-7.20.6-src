package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.ox;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/ox.class */
public class ox implements com.ss.android.downloadad.api.ox {
    private static String mb = ox.class.getSimpleName();
    private static volatile ox ox;
    private ww b = ww.mb(x.getContext());

    private ox() {
    }

    public static DownloadEventConfig b() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(EventConstants.Tag.LANDING_H5_DOWNLOAD_AD_BUTTON).setClickItemTag(EventConstants.Tag.LANDING_H5_DOWNLOAD_AD_BUTTON).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public static DownloadController mb(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static ox mb() {
        if (ox == null) {
            synchronized (ox.class) {
                try {
                    if (ox == null) {
                        ox = new ox();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    public static DownloadController ox() {
        return mb(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ox(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController mb2;
        boolean z = false;
        if (com.ss.android.download.api.b.mb.mb(uri) && x.lz().optInt("disable_market") != 1) {
            Context context2 = context == null ? x.getContext() : context;
            String ox2 = com.ss.android.download.api.b.mb.ox(uri);
            if (downloadModel == null) {
                if (com.ss.android.downloadlib.utils.ww.mb(context2, ox2).getType() == 5) {
                    z = true;
                }
                return z;
            }
            if (!TextUtils.isEmpty(ox2) && (downloadModel instanceof AdDownloadModel)) {
                ((AdDownloadModel) downloadModel).setPackageName(ox2);
            }
            if (downloadController != null) {
                downloadController.setDownloadMode(2);
                mb2 = downloadController;
            } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
                mb2 = mb(true);
            } else {
                mb2 = downloadModel.getDownloadUrl().startsWith("market") ? mb(true) : ox();
            }
            com.ss.android.downloadlib.addownload.model.h hVar = new com.ss.android.downloadlib.addownload.model.h(downloadModel.getId(), downloadModel, (DownloadEventConfig) jb.mb(downloadEventConfig, b()), mb2);
            com.ss.android.downloadlib.addownload.model.u.mb().mb(hVar.ox);
            com.ss.android.downloadlib.addownload.model.u.mb().mb(hVar.mb, hVar.b);
            com.ss.android.downloadlib.addownload.model.u.mb().mb(hVar.mb, hVar.hj);
            if (jb.mb(downloadModel) && DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 && com.ss.android.downloadlib.ox.mb.mb(hVar)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            jb.mb(jSONObject, EventConstants.ExtraJson.MARKET_URL, uri.toString());
            jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, (Object) 1);
            AdEventHandler.mb().ox(EventConstants.Label.MARKET_CLICK_OPEN, jSONObject, hVar);
            OpenAppResult mb3 = com.ss.android.downloadlib.utils.ww.mb(context2, hVar, ox2);
            String mb4 = jb.mb(mb3.ox(), EventConstants.AppLinkSource.OPEN_MARKET);
            if (mb3.getType() == 5) {
                com.ss.android.downloadlib.ox.mb.mb(mb4, jSONObject, hVar, true);
                return true;
            } else if (mb3.getType() == 6) {
                jb.mb(jSONObject, "error_code", Integer.valueOf(mb3.mb()));
                AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_FAILED, jSONObject, hVar);
                if (com.ss.android.downloadlib.addownload.ww.mb(downloadModel, iDownloadButtonClickListener)) {
                    iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
                    return false;
                }
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.ox
    public Dialog mb(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return mb(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    @Override // com.ss.android.downloadad.api.ox
    public Dialog mb(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return mb(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false, iDownloadButtonClickListener);
    }

    public Dialog mb(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        return mb(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, null);
    }

    public Dialog mb(final Context context, final String str, final boolean z, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.exception.ox.mb(new ox.mb<Dialog>() { // from class: com.ss.android.downloadlib.ox.1
            @Override // com.ss.android.downloadlib.exception.ox.mb
            /* renamed from: mb */
            public Dialog ox() {
                return ox.this.ox(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2, iDownloadButtonClickListener);
            }
        });
    }

    public void mb(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(j);
        com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j);
        AdDownloadModel adDownloadModel = mb2;
        if (mb2 == null) {
            adDownloadModel = mb2;
            if (hj != null) {
                adDownloadModel = hj.he();
            }
        }
        if (adDownloadModel == null) {
            return;
        }
        if (downloadEventConfig == null || downloadController == null || (downloadEventConfig instanceof com.ss.android.download.api.download.b) || (downloadController instanceof com.ss.android.download.api.download.ox)) {
            ox(j);
            return;
        }
        downloadEventConfig.setDownloadScene(1);
        this.b.mb(adDownloadModel.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(long j) {
        return (com.ss.android.downloadlib.addownload.model.u.mb().mb(j) == null && com.ss.android.downloadlib.addownload.model.u.mb().hj(j) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(long j, int i) {
        DownloadModel mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(j);
        if (mb2 != null) {
            this.b.mb(mb2.getDownloadUrl(), i);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j);
        if (hj != null) {
            this.b.mb(context, i, downloadStatusChangeListener, hj.he());
            return true;
        }
        DownloadModel mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(j);
        if (mb2 != null) {
            this.b.mb(context, i, downloadStatusChangeListener, mb2);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return mb(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.exception.ox.mb(new ox.mb<Boolean>() { // from class: com.ss.android.downloadlib.ox.3
            @Override // com.ss.android.downloadlib.exception.ox.mb
            /* renamed from: mb */
            public Boolean ox() {
                return Boolean.valueOf(ox.this.ox(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public Dialog ox(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (mb(downloadModel.getId())) {
            if (z2) {
                mb(downloadModel.getId(), downloadEventConfig, downloadController);
                return null;
            }
            ox(downloadModel.getId());
            return null;
        } else if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        } else {
            this.b.mb(context, i, downloadStatusChangeListener, downloadModel);
            final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) jb.mb(downloadEventConfig, b());
            final DownloadController downloadController2 = (DownloadController) jb.mb(downloadController, ox());
            downloadEventConfig2.setDownloadScene(1);
            if ((downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.ox.mb().mb(downloadModel)) ? true : (x.lz().optInt("disable_lp_dialog", 0) == 1) | z) {
                this.b.mb(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
                return null;
            }
            String str2 = mb;
            com.ss.android.downloadlib.utils.x.mb(str2, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
            Dialog ox2 = x.b().ox(new DownloadAlertDialogInfo.mb(context).mb(downloadModel.getName()).ox("确认要下载此应用吗？").b("确认").hj("取消").mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.ox.2
                @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                public void b(DialogInterface dialogInterface) {
                    AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_CANCEL, downloadModel, downloadEventConfig2, downloadController2);
                }

                @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                public void mb(DialogInterface dialogInterface) {
                    ox.this.b.mb(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                    AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_CONFIRM, downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
                public void ox(DialogInterface dialogInterface) {
                    AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_CANCEL, downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }
            }).mb(0).mb());
            AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_SHOW, downloadModel, downloadEventConfig2, downloadController2);
            return ox2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45, types: [com.ss.android.download.api.download.DownloadController] */
    public void ox(long j) {
        DownloadEventConfig downloadEventConfig;
        AdDownloadController adDownloadController;
        DownloadModel mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(j);
        com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j);
        AdDownloadModel adDownloadModel = mb2;
        if (mb2 == null) {
            adDownloadModel = mb2;
            if (hj != null) {
                adDownloadModel = hj.he();
            }
        }
        if (adDownloadModel == null) {
            return;
        }
        DownloadEventConfig ox2 = com.ss.android.downloadlib.addownload.model.u.mb().ox(j);
        DownloadController b = com.ss.android.downloadlib.addownload.model.u.mb().b(j);
        DownloadEventConfig downloadEventConfig2 = ox2;
        if (ox2 instanceof com.ss.android.download.api.download.b) {
            downloadEventConfig2 = null;
        }
        AdDownloadController adDownloadController2 = b;
        if (b instanceof com.ss.android.download.api.download.ox) {
            adDownloadController2 = null;
        }
        if (hj == null) {
            DownloadEventConfig downloadEventConfig3 = downloadEventConfig2;
            if (downloadEventConfig2 == null) {
                downloadEventConfig3 = b();
            }
            downloadEventConfig = downloadEventConfig3;
            adDownloadController = adDownloadController2;
            if (adDownloadController2 == null) {
                adDownloadController = ox();
                downloadEventConfig = downloadEventConfig3;
            }
        } else {
            AdDownloadEventConfig adDownloadEventConfig = downloadEventConfig2;
            if (downloadEventConfig2 == null) {
                adDownloadEventConfig = new AdDownloadEventConfig.Builder().setClickButtonTag(hj.x()).setRefer(hj.lz()).setIsEnableV3Event(hj.nk()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            downloadEventConfig = adDownloadEventConfig;
            adDownloadController = adDownloadController2;
            if (adDownloadController2 == null) {
                adDownloadController = hj.jm();
                downloadEventConfig = adDownloadEventConfig;
            }
        }
        downloadEventConfig.setDownloadScene(1);
        this.b.mb(adDownloadModel.getDownloadUrl(), j, 2, downloadEventConfig, adDownloadController);
    }
}
