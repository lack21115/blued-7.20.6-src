package com.ss.android.socialbase.appdownloader;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.b.nk;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/hj.class */
public class hj {
    private String b;
    private IOpenInstallerListener e;
    private DownloadReceiver h;
    private String hj;

    /* renamed from: io  reason: collision with root package name */
    private IInstallAppHandler f21198io;
    private com.ss.android.socialbase.appdownloader.b.ww jb;
    private com.ss.android.socialbase.appdownloader.b.ko je;
    private x lc;
    private com.ss.android.socialbase.appdownloader.b.b lz;
    private nk nk;
    private com.ss.android.socialbase.appdownloader.b.u o;
    private boolean ww = false;
    private com.ss.android.socialbase.appdownloader.b.hj x;
    private static final String mb = hj.class.getSimpleName();
    private static volatile hj ox = null;
    private static boolean u = false;
    private static boolean ko = false;

    private hj() {
    }

    private void b(Context context) {
        if (context == null || u) {
            return;
        }
        DownloadConstants.setMimeApk(AdBaseConstants.MIME_APK);
        DownloadComponentManager.setAppContext(context);
        DownloadComponentManager.setDownloadLaunchHandler(new com.ss.android.socialbase.appdownloader.hj.ox());
        e();
        l();
        u = true;
    }

    private void e() {
        if (ko) {
            return;
        }
        if (this.h == null) {
            this.h = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction(Intent.ACTION_BOOT_COMPLETED);
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(Intent.ACTION_PACKAGE_ADDED);
            intentFilter2.addAction(Intent.ACTION_PACKAGE_REPLACED);
            intentFilter2.addDataScheme("package");
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction(Intent.ACTION_MEDIA_MOUNTED);
            intentFilter3.addDataScheme(ContentResolver.SCHEME_FILE);
            DownloadComponentManager.getAppContext().registerReceiver(this.h, intentFilter);
            DownloadComponentManager.getAppContext().registerReceiver(this.h, intentFilter2);
            DownloadComponentManager.getAppContext().registerReceiver(this.h, intentFilter3);
            ko = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 21) {
            RetryScheduler.setRetryScheduleHandler(new RetryScheduler.RetryScheduleHandler() { // from class: com.ss.android.socialbase.appdownloader.hj.1
                @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
                public void cancelRetry(int i) {
                    RetryJobSchedulerService.mb(i);
                }

                @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
                public void scheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i) {
                    RetryJobSchedulerService.mb(downloadInfo, j, z, i);
                }
            });
        }
    }

    private IDownloadNotificationEventListener mb(final com.ss.android.socialbase.appdownloader.b.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.appdownloader.hj.4
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                return hVar.mb();
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z) {
                return hVar.mb(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            hVar.mb(i, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            hVar.mb(DownloadComponentManager.getAppContext(), str);
                            return;
                        case 10:
                            hVar.mb(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                hVar.mb(i, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
        };
    }

    private DownloadInfo mb(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
    }

    private List<HttpHeader> mb(List<HttpHeader> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        boolean z2 = false;
        if (list != null) {
            z2 = false;
            if (list.size() > 0) {
                Iterator<HttpHeader> it = list.iterator();
                while (true) {
                    z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    HttpHeader next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.getName()) && !TextUtils.isEmpty(next.getValue())) {
                        if (next.getName().equals("User-Agent")) {
                            z = true;
                        }
                        arrayList.add(new HttpHeader(next.getName(), next.getValue()));
                    }
                }
            }
        }
        if (!z2) {
            arrayList.add(new HttpHeader("User-Agent", com.ss.android.socialbase.appdownloader.ox.mb.mb));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(DownloadTask downloadTask, int i, boolean z) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    public static boolean mb(Context context, int i) {
        return b.mb(context, i, true) == 1;
    }

    private DownloadInfo ox(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList != null) {
            for (DownloadInfo downloadInfo : downloadInfoList) {
                if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                    return downloadInfo;
                }
            }
            return null;
        }
        return null;
    }

    public static hj x() {
        if (ox == null) {
            synchronized (hj.class) {
                try {
                    if (ox == null) {
                        ox = new hj();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ox;
    }

    public com.ss.android.socialbase.appdownloader.b.ww b() {
        return this.jb;
    }

    public com.ss.android.socialbase.appdownloader.b.u h() {
        return this.o;
    }

    public String hj() {
        return this.hj;
    }

    public nk jb() {
        return this.nk;
    }

    public com.ss.android.socialbase.appdownloader.b.ko je() {
        return this.je;
    }

    public x ko() {
        return this.lc;
    }

    public IOpenInstallerListener lc() {
        return this.e;
    }

    public String lz() {
        return this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0174, code lost:
        if (r10.u() != false) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int mb(com.ss.android.socialbase.appdownloader.u r10) {
        /*
            Method dump skipped, instructions count: 1206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.hj.mb(com.ss.android.socialbase.appdownloader.u):int");
    }

    public com.ss.android.socialbase.appdownloader.b.b mb() {
        return this.lz;
    }

    public DownloadInfo mb(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            DownloadInfo mb2 = mb(context, str, ww());
            DownloadInfo downloadInfo = mb2;
            if (mb2 == null) {
                downloadInfo = mb(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
            }
            DownloadInfo downloadInfo2 = downloadInfo;
            if (downloadInfo == null) {
                downloadInfo2 = mb(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
            }
            DownloadInfo downloadInfo3 = downloadInfo2;
            if (downloadInfo2 == null) {
                downloadInfo3 = mb(context, str, context.getFilesDir());
            }
            boolean optBugFix = DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST);
            DownloadInfo downloadInfo4 = downloadInfo3;
            if (downloadInfo3 == null) {
                downloadInfo4 = downloadInfo3;
                if (optBugFix) {
                    downloadInfo4 = ox(context, str);
                }
            }
            return downloadInfo4;
        } catch (Throwable th) {
            Logger.d(mb, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            return null;
        }
    }

    public String mb(String str, String str2) {
        String str3 = str2;
        if (!TextUtils.isEmpty(str)) {
            str3 = str2;
            if (str.endsWith(".apk")) {
                str3 = str2;
                if (!b.b(str2)) {
                    str3 = AdBaseConstants.MIME_APK;
                }
            }
        }
        return str3;
    }

    public List<DownloadInfo> mb(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void mb(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    Downloader.getInstance(context).restart(i);
                    return;
                case -3:
                    b.mb(context, i, true);
                    return;
                case -2:
                    Downloader.getInstance(context).resume(i);
                    return;
                case 0:
                case 6:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    Downloader.getInstance(context).pause(i);
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public void mb(Context context, String str, com.ss.android.socialbase.appdownloader.b.b bVar, com.ss.android.socialbase.appdownloader.b.hj hjVar, com.ss.android.socialbase.appdownloader.b.ww wwVar) {
        if (bVar != null) {
            this.lz = bVar;
        }
        if (hjVar != null) {
            this.x = hjVar;
        }
        if (wwVar != null) {
            this.jb = wwVar;
        }
        b(context);
    }

    public void mb(com.ss.android.socialbase.appdownloader.b.ko koVar) {
        this.je = koVar;
    }

    public void mb(x xVar) {
        this.lc = xVar;
    }

    public void mb(IInstallAppHandler iInstallAppHandler) {
        this.f21198io = iInstallAppHandler;
    }

    public void mb(IOpenInstallerListener iOpenInstallerListener) {
        this.e = iOpenInstallerListener;
    }

    public void mb(IReserveWifiStatusListener iReserveWifiStatusListener) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.hj = str;
    }

    public IReserveWifiStatusListener nk() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public IInstallAppHandler o() {
        return this.f21198io;
    }

    public com.ss.android.socialbase.appdownloader.b.hj ox() {
        return this.x;
    }

    public List<DownloadInfo> ox(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
    }

    public void ox(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    public boolean u() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.PACKAGE_FLAG_CONFIG, 1) == 1;
    }

    public File ww() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }
}
