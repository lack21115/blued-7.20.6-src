package com.ss.android.downloadlib.addownload.mb;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.u;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/mb/mb.class */
public class mb {
    private static final String mb = mb.class.getSimpleName();
    private static mb ox;
    private CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.model.mb> b;
    private String h;
    private boolean hj = false;
    private ox u;

    /* renamed from: com.ss.android.downloadlib.addownload.mb.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/mb/mb$mb.class */
    public interface InterfaceC0701mb {
        void mb();
    }

    private mb() {
        ox oxVar = new ox();
        this.u = oxVar;
        this.b = oxVar.mb("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static mb mb() {
        if (ox == null) {
            ox = new mb();
        }
        return ox;
    }

    private void mb(final Context context, final com.ss.android.downloadlib.addownload.model.mb mbVar, final InterfaceC0701mb interfaceC0701mb, boolean z) {
        final com.ss.android.downloadad.api.mb.ox hj = u.mb().hj(mbVar.ox);
        if (hj == null) {
            com.ss.android.downloadlib.exception.b.mb().mb("showBackInstallDialog nativeModel null");
            return;
        }
        x.b().ox(new DownloadAlertDialogInfo.mb(context).mb(z ? "应用安装确认" : "退出确认").ox(String.format("%1$s下载完成，是否立即安装？", TextUtils.isEmpty(mbVar.h) ? "刚刚下载的应用" : mbVar.h)).b("立即安装").hj(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).mb(false).mb(jb.mb(context, mbVar.ko)).mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.addownload.mb.mb.1
            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void b(DialogInterface dialogInterface) {
                mb.this.ox("");
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void mb(DialogInterface dialogInterface) {
                AdEventHandler.mb().ox(EventConstants.Label.BACK_DIALOG_INSTALL, hj);
                com.ss.android.socialbase.appdownloader.hj.mb(context, (int) mbVar.mb);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void ox(DialogInterface dialogInterface) {
                AdEventHandler.mb().ox(EventConstants.Label.BACK_DIALOG_EXIT, hj);
                InterfaceC0701mb interfaceC0701mb2 = interfaceC0701mb;
                if (interfaceC0701mb2 != null) {
                    interfaceC0701mb2.mb();
                }
                mb.this.ox("");
                dialogInterface.dismiss();
            }
        }).mb(1).mb());
        AdEventHandler.mb().ox(EventConstants.Label.BACK_DIALOG_SHOW, hj);
        this.h = mbVar.hj;
    }

    private boolean mb(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0701mb interfaceC0701mb) {
        boolean z2;
        if (downloadInfo == null) {
            try {
                if (this.b.isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        if (downloadInfo != null && this.b.isEmpty()) {
            mb(activity, new com.ss.android.downloadlib.addownload.model.mb(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0701mb);
            return true;
        }
        long j = 0;
        if (downloadInfo != null) {
            j = new File(downloadInfo.getTargetFilePath()).lastModified();
        }
        ListIterator<com.ss.android.downloadlib.addownload.model.mb> listIterator = this.b.listIterator(this.b.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                z2 = false;
                break;
            }
            com.ss.android.downloadlib.addownload.model.mb previous = listIterator.previous();
            if (previous != null && !jb.hj(x.getContext(), previous.hj) && jb.mb(previous.ko)) {
                if (new File(previous.ko).lastModified() >= j) {
                    mb(activity, previous, z, interfaceC0701mb);
                    z2 = true;
                } else {
                    mb(activity, new com.ss.android.downloadlib.addownload.model.mb(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0701mb);
                    z2 = true;
                }
            }
        }
        com.ss.android.downloadlib.utils.x.mb(mb, "tryShowInstallDialog isShow:" + z2, null);
        return z2;
    }

    public DownloadInfo mb(Context context) {
        DownloadInfo downloadInfo;
        long ox2;
        List successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo2 = null;
        DownloadInfo downloadInfo3 = null;
        try {
            ox2 = ww.mb(context).ox();
        } catch (Exception e) {
            e.printStackTrace();
            downloadInfo = downloadInfo3;
        }
        if (x.lz().optInt("enable_miniapp_dialog", 0) == 0 || (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK)) == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return null;
        }
        Iterator it = successedDownloadInfosWithMimeType.iterator();
        long j = 0;
        while (true) {
            downloadInfo3 = downloadInfo2;
            downloadInfo = downloadInfo2;
            if (!it.hasNext()) {
                break;
            }
            DownloadInfo downloadInfo4 = downloadInfo2;
            DownloadInfo downloadInfo5 = (DownloadInfo) it.next();
            if (downloadInfo5 != null && !jb.hj(context, downloadInfo5.getPackageName())) {
                DownloadInfo downloadInfo6 = downloadInfo2;
                if (jb.mb(downloadInfo5.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo5.getTargetFilePath()).lastModified();
                    if (lastModified >= ox2) {
                        downloadInfo3 = downloadInfo2;
                        if (downloadInfo5.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo5.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                    downloadInfo2 = downloadInfo5;
                                    j = lastModified;
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return downloadInfo;
    }

    public void mb(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                this.b.add(new com.ss.android.downloadlib.addownload.model.mb(j, j2, j3, str, str2, str3, str4));
                this.u.mb("sp_ad_install_back_dialog", "key_uninstalled_list", this.b);
                return;
            }
            com.ss.android.downloadlib.addownload.model.mb mbVar = this.b.get(i2);
            if (mbVar != null && mbVar.ox == j2) {
                this.b.set(i2, new com.ss.android.downloadlib.addownload.model.mb(j, j2, j3, str, str2, str3, str4));
                this.u.mb("sp_ad_install_back_dialog", "key_uninstalled_list", this.b);
                return;
            }
            i = i2 + 1;
        }
    }

    public void mb(Context context, com.ss.android.downloadlib.addownload.model.mb mbVar, boolean z, InterfaceC0701mb interfaceC0701mb) {
        this.b.clear();
        mb(context, mbVar, interfaceC0701mb, z);
        this.hj = true;
        ww.mb(context).b();
        this.u.ox("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.utils.x.mb(mb, "tryShowInstallDialog isShow:true", null);
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (x.lz().optInt("enable_open_app_dialog", 0) == 1 && !oxVar.cd() && oxVar.e()) {
            oxVar.jb(true);
            TTDelegateActivity.mb(oxVar);
        }
    }

    public boolean mb(Activity activity, boolean z, InterfaceC0701mb interfaceC0701mb) {
        if (x.lz().optInt("disable_install_app_dialog") == 1 || this.hj) {
            return false;
        }
        return mb(activity, mb(activity), z, interfaceC0701mb);
    }

    public boolean mb(String str) {
        return TextUtils.equals(this.h, str);
    }

    public void ox(String str) {
        if (TextUtils.isEmpty(str)) {
            this.h = "";
        } else if (TextUtils.equals(this.h, str)) {
            this.h = "";
        }
    }
}
