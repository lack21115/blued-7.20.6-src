package com.ss.android.downloadlib.addownload;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.b;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.ko;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.je;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/h.class */
public class h implements u, je.mb {
    private static final String mb = h.class.getSimpleName();
    private SoftReference<OnItemClickListener> e;
    private SoftReference<IDownloadButtonClickListener> gm;
    private WeakReference<Context> h;
    private boolean jb;
    private long je;
    private DownloadShortInfo ko;
    private boolean l;
    private b lz;
    private DownloadInfo ww;
    private final com.ss.android.downloadlib.utils.je ox = new com.ss.android.downloadlib.utils.je(Looper.getMainLooper(), this);
    private final Map<Integer, Object> u = new ConcurrentHashMap();
    private final IDownloadListener x = new ko.mb(this.ox);
    private long nk = -1;
    private DownloadModel o = null;
    private DownloadEventConfig lc = null;

    /* renamed from: io  reason: collision with root package name */
    private DownloadController f34887io = null;
    private ko b = new ko(this);
    private hj hj = new hj(this.ox);
    private final boolean m = DownloadSetting.obtainGlobal().optBugFix("ttdownloader_callback_twice");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/h$b.class */
    public class b extends AsyncTask<String, Void, DownloadInfo> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: mb */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr != null) {
                if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                    return null;
                }
                String str = strArr[0];
                DownloadInfo downloadInfo2 = null;
                if (h.this.o != null) {
                    downloadInfo2 = null;
                    if (!TextUtils.isEmpty(h.this.o.getFilePath())) {
                        downloadInfo2 = Downloader.getInstance(x.getContext()).getDownloadInfo(str, h.this.o.getFilePath());
                    }
                }
                downloadInfo = downloadInfo2;
                if (downloadInfo2 == null) {
                    downloadInfo = com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), str);
                }
            }
            return downloadInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: mb */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || h.this.o == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.model.b mb = com.ss.android.downloadlib.utils.jb.mb(h.this.o.getPackageName(), h.this.o.getVersionCode(), h.this.o.getVersionName());
                com.ss.android.downloadlib.addownload.model.ko.mb().mb(h.this.o.getVersionCode(), mb.ox(), com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo));
                boolean mb2 = mb.mb();
                if (downloadInfo == null || downloadInfo.getId() == 0 || (!mb2 && Downloader.getInstance(x.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    if (downloadInfo != null && Downloader.getInstance(x.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                        h.this.ww = null;
                    }
                    if (h.this.ww != null) {
                        Downloader.getInstance(x.getContext()).removeTaskMainListener(h.this.ww.getId());
                        if (h.this.m) {
                            Downloader.getInstance(h.this.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.x, false);
                        } else {
                            Downloader.getInstance(h.this.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.x);
                        }
                    }
                    if (mb2) {
                        h.this.ww = new DownloadInfo.Builder(h.this.o.getDownloadUrl()).build();
                        h.this.ww.setStatus(-3);
                        h.this.b.mb(h.this.ww, h.this.e(), ko.mb(h.this.u));
                    } else {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : ko.mb(h.this.u)) {
                            downloadStatusChangeListener.onIdle();
                        }
                        h.this.ww = null;
                    }
                } else {
                    Downloader.getInstance(x.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (h.this.ww == null || h.this.ww.getStatus() != -4) {
                        h.this.ww = downloadInfo;
                        if (h.this.m) {
                            Downloader.getInstance(x.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.x, false);
                        } else {
                            Downloader.getInstance(x.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.x);
                        }
                    } else {
                        h.this.ww = null;
                    }
                    h.this.b.mb(h.this.ww, h.this.e(), ko.mb(h.this.u));
                }
                h.this.b.b(h.this.ww);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/h$mb.class */
    public interface mb {
        void mb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/h$ox.class */
    public interface ox {
        void mb(long j);
    }

    private boolean b(int i) {
        if (h()) {
            int i2 = -1;
            String mb2 = this.o.getQuickAppModel().mb();
            if (i == 1) {
                i2 = 5;
            } else if (i == 2) {
                i2 = 4;
            }
            DownloadModel downloadModel = this.o;
            if (downloadModel instanceof AdDownloadModel) {
                ((AdDownloadModel) downloadModel).setFunnelType(3);
            }
            boolean b2 = com.ss.android.downloadlib.utils.ww.b(x.getContext(), mb2);
            if (!b2) {
                AdEventHandler.mb().mb(this.nk, false, 0);
                return b2;
            }
            AdEventHandler.mb().mb(this.nk, i);
            Message obtain = Message.obtain();
            obtain.what = i2;
            obtain.obj = Long.valueOf(this.o.getId());
            com.ss.android.downloadlib.addownload.b.mb().mb(this, i2, this.o);
            return b2;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo e() {
        if (this.ko == null) {
            this.ko = new DownloadShortInfo();
        }
        return this.ko;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.h;
        return (weakReference == null || weakReference.get() == null) ? x.getContext() : this.h.get();
    }

    private void h(boolean z) {
        if (com.ss.android.downloadlib.utils.hj.ox(this.o).optInt("notification_opt_2") == 1 && this.ww != null) {
            DownloadNotificationManager.getInstance().cancelNotification(this.ww.getId());
        }
        u(z);
    }

    private void io() {
        b bVar = this.lz;
        if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.lz.cancel(true);
        }
        b bVar2 = new b();
        this.lz = bVar2;
        com.ss.android.downloadlib.utils.ox.mb(bVar2, this.o.getDownloadUrl(), this.o.getPackageName());
    }

    private void jb() {
        SoftReference<OnItemClickListener> softReference = this.e;
        if (softReference == null || softReference.get() == null) {
            x.ox().mb(getContext(), this.o, nk(), je());
            return;
        }
        this.e.get().onItemClick(this.o, je(), nk());
        this.e = null;
    }

    private DownloadEventConfig je() {
        DownloadEventConfig downloadEventConfig = this.lc;
        com.ss.android.download.api.download.b bVar = downloadEventConfig;
        if (downloadEventConfig == null) {
            bVar = new b.mb().mb();
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(final boolean z) {
        this.hj.mb(new com.ss.android.downloadlib.addownload.model.h(this.nk, this.o, je(), nk()));
        this.hj.mb(0, 0L, 0L, new mb() { // from class: com.ss.android.downloadlib.addownload.h.5
            @Override // com.ss.android.downloadlib.addownload.h.mb
            public void mb() {
                if (h.this.hj.mb()) {
                    return;
                }
                h.this.ww(z);
            }
        });
    }

    private boolean lc() {
        if (!DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            DownloadInfo downloadInfo = this.ww;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(x.getContext()).canResume(this.ww.getId())) || this.ww.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.ww;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.ww.getCurBytes() <= 0) || this.ww.getStatus() == 0 || this.ww.getStatus() == -4) {
            return true;
        }
        try {
            return DownloadUtils.isDownloadSuccessAndFileNotExist(this.ww.getStatus(), this.ww.getSavePath(), this.ww.getName());
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i, int i2, DownloadInfo downloadInfo) {
        if (!DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), i, i2);
        } else if (i2 == -3 || DownloadProcessDispatcher.getInstance().canResume(i)) {
            com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), i, i2);
        } else {
            mb(false, false);
        }
    }

    private void mb(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.ox.sendMessage(obtain);
    }

    private DownloadController nk() {
        if (this.f34887io == null) {
            this.f34887io = new com.ss.android.download.api.download.ox();
        }
        return this.f34887io;
    }

    private void o() {
        com.ss.android.downloadlib.utils.x.mb(mb, "pICD", null);
        if (this.b.hj(this.ww)) {
            com.ss.android.downloadlib.utils.x.mb(mb, "pICD BC", null);
            u(false);
            return;
        }
        com.ss.android.downloadlib.utils.x.mb(mb, "pICD IC", null);
        jb();
    }

    private void u(final boolean z) {
        DownloadModel downloadModel;
        com.ss.android.downloadlib.utils.x.mb(mb, "pBCD", null);
        if (lc()) {
            com.ss.android.downloadlib.addownload.model.h h = com.ss.android.downloadlib.addownload.model.u.mb().h(this.nk);
            if (this.l) {
                if (!lz()) {
                    mb(z, true);
                    return;
                } else if (hj(false) && h.hj != null && h.hj.isAutoDownloadOnCardShow()) {
                    mb(z, true);
                    return;
                } else {
                    return;
                }
            } else if (this.o.isAd() && h.hj != null && h.hj.enableShowComplianceDialog() && h.ox != null && com.ss.android.downloadlib.addownload.compliance.ox.mb().mb(h.ox) && com.ss.android.downloadlib.addownload.compliance.ox.mb().mb(h)) {
                return;
            } else {
                mb(z, true);
                return;
            }
        }
        String str = mb;
        com.ss.android.downloadlib.utils.x.mb(str, "pBCD continue download, status:" + this.ww.getStatus(), null);
        DownloadInfo downloadInfo = this.ww;
        if (downloadInfo != null && (downloadModel = this.o) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.ww.getStatus();
        final int id = this.ww.getId();
        final com.ss.android.downloadad.api.mb.ox mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(this.ww);
        if (status == -2 || status == -1) {
            this.b.mb(this.ww, z);
            if (mb2 != null) {
                mb2.ww(System.currentTimeMillis());
                mb2.lz(this.ww.getCurBytes());
            }
            this.ww.setDownloadFromReserveWifi(false);
            this.hj.mb(new com.ss.android.downloadlib.addownload.model.h(this.nk, this.o, je(), nk()));
            this.hj.mb(id, this.ww.getCurBytes(), this.ww.getTotalBytes(), new mb() { // from class: com.ss.android.downloadlib.addownload.h.2
                @Override // com.ss.android.downloadlib.addownload.h.mb
                public void mb() {
                    if (h.this.hj.mb()) {
                        return;
                    }
                    h hVar = h.this;
                    hVar.mb(id, status, hVar.ww);
                }
            });
        } else if (!je.mb(status)) {
            this.b.mb(this.ww, z);
            mb(id, status, this.ww);
        } else if (this.o.enablePause()) {
            this.hj.mb(true);
            com.ss.android.downloadlib.b.ww.mb().ox(com.ss.android.downloadlib.addownload.model.u.mb().hj(this.nk));
            com.ss.android.downloadlib.addownload.b.u.mb().mb(mb2, status, new com.ss.android.downloadlib.addownload.b.b() { // from class: com.ss.android.downloadlib.addownload.h.3
                @Override // com.ss.android.downloadlib.addownload.b.b
                public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
                    if (h.this.ww == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                        h.this.ww = Downloader.getInstance(x.getContext()).getDownloadInfo(id);
                    }
                    h.this.b.mb(h.this.ww, z);
                    if (h.this.ww != null && DownloadUtils.isWifi(x.getContext()) && h.this.ww.isPauseReserveOnWifi()) {
                        h.this.ww.stopPauseReserveOnWifi();
                        AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_CANCEL_ON_WIFI, mb2);
                        return;
                    }
                    h hVar = h.this;
                    hVar.mb(id, status, hVar.ww);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww(boolean z) {
        for (DownloadStatusChangeListener downloadStatusChangeListener : ko.mb(this.u)) {
            downloadStatusChangeListener.onDownloadStart(this.o, nk());
        }
        int mb2 = this.b.mb(x.getContext(), this.x);
        String str = mb;
        com.ss.android.downloadlib.utils.x.mb(str, "beginDown id:" + mb2, null);
        if (mb2 == 0) {
            DownloadInfo build = new DownloadInfo.Builder(this.o.getDownloadUrl()).build();
            build.setStatus(-1);
            mb(build);
            AdEventHandler.mb().mb(this.nk, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.exception.b.mb().ox("beginDown");
        } else if (this.ww != null && !DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            this.b.mb(this.ww, false);
        } else if (z) {
            this.b.mb();
        }
        if (this.b.mb(b())) {
            String str2 = mb;
            com.ss.android.downloadlib.utils.x.mb(str2, "beginDown IC id:" + mb2, null);
            jb();
        }
    }

    public void b(boolean z) {
        if (z) {
            AdEventHandler.mb().mb(this.nk, 1);
        }
        o();
    }

    public boolean b() {
        DownloadInfo downloadInfo = this.ww;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public boolean h() {
        return x.lz().optInt("quick_app_enable_switch", 0) == 0 && this.o.getQuickAppModel() != null && !TextUtils.isEmpty(this.o.getQuickAppModel().mb()) && com.ss.android.downloadlib.addownload.b.mb(this.ww) && com.ss.android.downloadlib.utils.jb.mb(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.o.getQuickAppModel().mb())));
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public long hj() {
        return this.je;
    }

    public boolean hj(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.gm;
        if (softReference == null || softReference.get() == null) {
            com.ss.android.downloadlib.exception.b.mb().ox("mDownloadButtonClickListener has recycled");
            return false;
        }
        try {
            if (z) {
                this.gm.get().handleMarketFailedComplianceDialog();
            } else {
                this.gm.get().handleComplianceDialog(true);
            }
            this.gm = null;
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.exception.b.mb().ox("mDownloadButtonClickListener has recycled");
            return false;
        }
    }

    public void ko() {
        if (this.u.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : ko.mb(this.u)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.ww;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public boolean lz() {
        SoftReference<IDownloadButtonClickListener> softReference = this.gm;
        if (softReference == null) {
            return false;
        }
        return ww.mb(this.o, softReference.get());
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* renamed from: mb */
    public h ox(int i, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (x.lz().optInt("back_use_softref_listener") == 1) {
                this.u.put(Integer.valueOf(i), downloadStatusChangeListener);
                return this;
            }
            this.u.put(Integer.valueOf(i), new SoftReference(downloadStatusChangeListener));
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* renamed from: mb */
    public h ox(Context context) {
        if (context != null) {
            this.h = new WeakReference<>(context);
        }
        x.ox(context);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* renamed from: mb */
    public h ox(DownloadController downloadController) {
        JSONObject extra;
        this.f34887io = downloadController;
        if (com.ss.android.downloadlib.utils.hj.ox(this.o).optInt("force_auto_open") == 1) {
            nk().setLinkMode(1);
        }
        if (DownloadSetting.obtainGlobal().optBugFix("fix_show_dialog") && (extra = this.o.getExtra()) != null && extra.optInt("subprocess") > 0) {
            nk().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, nk());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* renamed from: mb */
    public h ox(DownloadEventConfig downloadEventConfig) {
        this.lc = downloadEventConfig;
        this.l = je().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, je());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* renamed from: mb */
    public h ox(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.exception.b.mb().mb("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.exception.b.mb().mb(false, "setDownloadModel id=0");
                if (DownloadSetting.obtainGlobal().optBugFix("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadModel);
            this.nk = downloadModel.getId();
            this.o = downloadModel;
            if (ww.mb(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.mb.ox hj = com.ss.android.downloadlib.addownload.model.u.mb().hj(this.nk);
                if (hj != null && hj.je() != 3) {
                    hj.h(3L);
                    com.ss.android.downloadlib.addownload.model.ww.mb().mb(hj);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public u mb(long j) {
        if (j != 0) {
            DownloadModel mb2 = com.ss.android.downloadlib.addownload.model.u.mb().mb(j);
            if (mb2 != null) {
                this.o = mb2;
                this.nk = j;
                this.b.mb(j);
                return this;
            }
        } else {
            com.ss.android.downloadlib.exception.b.mb().mb(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public u mb(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.gm = null;
            return this;
        }
        this.gm = new SoftReference<>(iDownloadButtonClickListener);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public u mb(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.e = null;
            return this;
        }
        this.e = new SoftReference<>(onItemClickListener);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void mb() {
        this.jb = true;
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, je());
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, nk());
        this.b.mb(this.nk);
        io();
        if (x.lz().optInt("enable_empty_listener", 1) == 1 && this.u.get(Integer.MIN_VALUE) == null) {
            ox(Integer.MIN_VALUE, new com.ss.android.download.api.config.mb());
        }
    }

    @Override // com.ss.android.downloadlib.utils.je.mb
    public void mb(Message message) {
        if (message != null && this.jb && message.what == 3) {
            this.ww = (DownloadInfo) message.obj;
            this.b.mb(message, e(), this.u);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void mb(boolean z) {
        if (this.ww != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.b.hj ox2 = com.ss.android.socialbase.appdownloader.hj.x().ox();
                if (ox2 != null) {
                    ox2.mb(this.ww);
                }
                Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(this.ww.getId(), true);
                return;
            }
            Intent intent = new Intent(x.getContext(), DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS, this.ww.getId());
            x.getContext().startService(intent);
        }
    }

    public void mb(boolean z, final boolean z2) {
        if (z) {
            AdEventHandler.mb().mb(this.nk, 2);
        }
        if (!com.ss.android.downloadlib.utils.lz.ox("android.permission.WRITE_EXTERNAL_STORAGE") && !nk().enableNewActivity()) {
            this.o.setFilePath(this.b.ox());
        }
        if (com.ss.android.downloadlib.utils.hj.b(this.o) != 0) {
            ko(z2);
            return;
        }
        com.ss.android.downloadlib.utils.x.mb(mb, "pBCD not start", null);
        this.b.mb(new gm() { // from class: com.ss.android.downloadlib.addownload.h.4
            @Override // com.ss.android.download.api.config.gm
            public void mb() {
                com.ss.android.downloadlib.utils.x.mb(h.mb, "pBCD start download", null);
                h.this.ko(z2);
            }

            @Override // com.ss.android.download.api.config.gm
            public void mb(String str) {
                com.ss.android.downloadlib.utils.x.mb(h.mb, "pBCD onDenied", null);
            }
        });
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public boolean mb(int i) {
        if (i == 0) {
            this.u.clear();
        } else {
            this.u.remove(Integer.valueOf(i));
        }
        if (!this.u.isEmpty()) {
            if (this.u.size() == 1 && this.u.containsKey(Integer.MIN_VALUE)) {
                this.b.ox(this.ww);
                return false;
            }
            return false;
        }
        this.jb = false;
        this.je = System.currentTimeMillis();
        if (this.ww != null) {
            Downloader.getInstance(x.getContext()).removeTaskMainListener(this.ww.getId());
        }
        b bVar = this.lz;
        if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.lz.cancel(true);
        }
        this.b.mb(this.ww);
        String str = mb;
        StringBuilder sb = new StringBuilder();
        sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
        DownloadInfo downloadInfo = this.ww;
        sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
        com.ss.android.downloadlib.utils.x.mb(str, sb.toString(), null);
        this.ox.removeCallbacksAndMessages(null);
        this.ko = null;
        this.ww = null;
        return true;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void ox(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.b.mb(this.nk);
        if (!com.ss.android.downloadlib.addownload.model.u.mb().h(this.nk).jq()) {
            com.ss.android.downloadlib.exception.b.mb().mb("handleDownload ModelBox !isStrictValid");
        }
        if (this.b.mb(getContext(), i, this.l)) {
            return;
        }
        boolean b2 = b(i);
        if (i == 1) {
            if (b2) {
                return;
            }
            String str = mb;
            com.ss.android.downloadlib.utils.x.mb(str, "handleDownload id:" + this.nk + ",pIC:", null);
            b(true);
        } else if (i == 2 && !b2) {
            String str2 = mb;
            com.ss.android.downloadlib.utils.x.mb(str2, "handleDownload id:" + this.nk + ",pBC:", null);
            ox(true);
        }
    }

    public void ox(boolean z) {
        h(z);
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public boolean ox() {
        return this.jb;
    }

    public void u() {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.h.1
            @Override // java.lang.Runnable
            public void run() {
                for (DownloadStatusChangeListener downloadStatusChangeListener : ko.mb(h.this.u)) {
                    downloadStatusChangeListener.onInstalled(h.this.e());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void ww() {
        com.ss.android.downloadlib.addownload.model.u.mb().u(this.nk);
    }
}
