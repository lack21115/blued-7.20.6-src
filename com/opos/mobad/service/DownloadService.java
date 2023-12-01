package com.opos.mobad.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.widget.Toast;
import com.anythink.expressad.foundation.h.i;
import com.heytap.msp.mobad.api.R;
import com.heytap.nearx.tapplugin.pluginapi.PluginApi;
import com.huawei.openalliance.ad.constant.t;
import com.opos.mobad.d.a;
import com.opos.mobad.d.a.c;
import com.opos.mobad.d.a.d;
import com.opos.mobad.d.a.e;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/DownloadService.class */
public class DownloadService extends Service {

    /* renamed from: c  reason: collision with root package name */
    private static AtomicInteger f13572c = new AtomicInteger(10000);
    private static boolean f = true;

    /* renamed from: a  reason: collision with root package name */
    private Context f13573a;
    private com.opos.mobad.d.a.c b;
    private ConcurrentHashMap<String, com.opos.mobad.d.a.b> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<Messenger>> e = new ConcurrentHashMap<>();
    private AtomicBoolean g = new AtomicBoolean(false);
    private Messenger h = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.service.DownloadService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            String string = data.getString("key_url");
            String string2 = data.getString("key_pkg_name");
            com.opos.cmn.an.f.a.b("DownloadService", "get message actionType:" + message.what + ",url:" + string + ",pkgName:" + string2);
            int i = message.what;
            if (i == 1) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Messenger messenger = message.replyTo;
                String string3 = data.getString("key_apk_md5");
                String string4 = data.getString("key_app_name");
                DownloadService.this.a(messenger, string);
                DownloadService.this.a(string, string2, string3, string4);
            } else if (i == 2) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.g(string);
            } else if (i == 3) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.h(string);
            } else if (i == 4) {
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                DownloadService.this.i(string);
            } else if (i == 5) {
                DownloadService.this.f(string2);
            } else if (i != 7) {
            } else {
                DownloadService.this.a(message.replyTo);
            }
        }
    });
    private a.InterfaceC0519a i = new a.InterfaceC0519a() { // from class: com.opos.mobad.service.DownloadService.2
        private int a(long j, long j2) {
            if (j2 <= 0 || j <= 0) {
                return 0;
            }
            long j3 = (j * 100) / j2;
            if (j3 > 100) {
                return 100;
            }
            if (j3 >= 0) {
                return (int) j3;
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.opos.mobad.d.a.b bVar, String str) {
            DownloadService.this.b.a(bVar.f12263c, new c.a(bVar.f12262a, "", 106, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(com.opos.mobad.d.a.b bVar, String str, long j, long j2, int i) {
            a(str, i);
            DownloadService.this.b.a(bVar.f12263c, new c.a(bVar.f12262a, (((float) (((j * 100) / 1024) / 1024)) / 100.0f) + "MB/" + (((float) (((100 * j2) / 1024) / 1024)) / 100.0f) + "MB", 103, i, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void a(String str, int i) {
            com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str);
            if (bVar != null) {
                bVar.d = i;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(com.opos.mobad.d.a.b bVar, String str) {
            DownloadService.this.b.a(bVar.f12263c, new c.a(bVar.f12262a, "", 105, 0, DownloadService.this.d(str), DownloadService.this.b(str), DownloadService.this.c(str)));
        }

        private void b(String str, int i) {
            com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str);
            if (bVar != null) {
                bVar.e = i;
            }
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void a(final String str) {
            final com.opos.mobad.d.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a(str, 0);
            Toast.makeText(DownloadService.this.f13573a, DownloadService.this.f13573a.getResources().getString(R.string.download_toast_start_txt), 1).show();
            b(str, 101);
            if (DownloadService.this.a() && (bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str)) != null) {
                bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadService.this.b.a(bVar.f12263c, new c.a(bVar.f12262a, "", 107, 0, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                    }
                }, d.a.INIT_STATUS);
            }
            DownloadService.this.a(101, 0, str);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void a(final String str, int i, long j, long j2) {
            com.opos.cmn.an.f.a.b("DownloadService", "fail exception:" + i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j, j2);
            Toast.makeText(DownloadService.this.f13573a, DownloadService.this.f13573a.getResources().getString(R.string.download_toast_fail_txt), 1).show();
            b(str, 106);
            if (DownloadService.this.a()) {
                a(str, a2);
                final com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str);
                if (bVar != null) {
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.5
                        @Override // java.lang.Runnable
                        public void run() {
                            a(bVar, str);
                        }
                    }, d.a.FAILED_STATUS);
                }
            }
            DownloadService downloadService = DownloadService.this;
            downloadService.a(106, a2, str, i + "");
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void a(String str, long j, long j2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b(str, 107);
            DownloadService.this.a(107, a(j, j2), str);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void b(final String str) {
            com.opos.cmn.an.f.a.b("DownloadService", "complete ");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Toast.makeText(DownloadService.this.f13573a, DownloadService.this.f13573a.getResources().getString(R.string.download_toast_downloaded_txt), 1).show();
            b(str, 105);
            if (DownloadService.this.a()) {
                a(str, 100);
                final com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str);
                if (bVar != null) {
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.6
                        @Override // java.lang.Runnable
                        public void run() {
                            b(bVar, str);
                        }
                    }, d.a.END_STATUS);
                }
            }
            DownloadService.this.a(105, 100, str);
            com.opos.mobad.d.b.b.a(DownloadService.this.f13573a, com.opos.cmn.d.a.a(DownloadService.this.f13573a, str));
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void b(final String str, final long j, final long j2) {
            final com.opos.mobad.d.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final int a2 = a(j, j2);
            b(str, 102);
            if (DownloadService.this.a() && (bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str)) != null) {
                int i = a2 - bVar.d;
                if (i < 0) {
                    bVar.d = 0;
                }
                if (i > 1) {
                    a(str, a2);
                    com.opos.cmn.an.f.a.b("DownloadService", "changePercent:" + i + ",notificationHelper.lastPercent:" + bVar.d);
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bVar != null) {
                                DownloadService.this.b.a(bVar.f12263c, new c.a(bVar.f12262a, (((float) (((j * 100) / 1024) / 1024)) / 100.0f) + "MB/" + (((float) (((j2 * 100) / 1024) / 1024)) / 100.0f) + "MB", 102, a2, DownloadService.this.a(str), DownloadService.this.b(str), DownloadService.this.c(str)));
                            }
                        }
                    }, d.a.PROGRESS_STATUS);
                }
            }
            DownloadService.this.a(102, a2, str);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void c(String str) {
            com.opos.cmn.an.f.a.b("DownloadService", "onMobileNetworkAvailableAndChooseRetry url =" + str);
            com.opos.mobad.d.a.a(DownloadService.this.f13573a).a(str);
            Toast.makeText(DownloadService.this.f13573a, DownloadService.this.f13573a.getResources().getString(R.string.download_toast_in_mobile_txt), 1).show();
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void c(final String str, final long j, final long j2) {
            final com.opos.mobad.d.a.b bVar;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            final int a2 = a(j, j2);
            b(str, 103);
            if (DownloadService.this.a() && (bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str)) != null) {
                bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a(bVar, str, j, j2, a2);
                    }
                }, d.a.PAUSED_STATUS);
            }
            DownloadService.this.a(103, a2, str);
        }

        @Override // com.opos.mobad.d.a.InterfaceC0519a
        public void d(String str, long j, long j2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int a2 = a(j, j2);
            b(str, 104);
            if (DownloadService.this.a()) {
                a(str, a2);
                final com.opos.mobad.d.a.b bVar = (com.opos.mobad.d.a.b) DownloadService.this.d.get(str);
                if (bVar != null) {
                    bVar.f.a(new Runnable() { // from class: com.opos.mobad.service.DownloadService.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadService.this.b.a(bVar.f12263c);
                        }
                    }, d.a.END_STATUS);
                }
            }
            DownloadService.this.a(104, a2, str);
            DownloadService.this.e(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f13573a, DownloadService.class);
        intent.setAction("key_download_action");
        intent.putExtra("key_action_type", 1);
        intent.putExtra(DBDefinition.SAVE_PATH, str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        a(i, i2, str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2) {
        List<Messenger> list;
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.e;
        if (concurrentHashMap == null || concurrentHashMap.size() <= 0 || TextUtils.isEmpty(str) || (list = this.e.get(str)) == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.f.a.b("DownloadService", "service status :" + i + ",percent:" + i2 + ",url:" + str);
        Message obtain = Message.obtain();
        obtain.what = i;
        Bundle bundle = new Bundle();
        bundle.putInt("key_percent", i2);
        bundle.putString("key_server_url", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(Constants.KEY_ERROR_CODE, str2);
        }
        obtain.setData(bundle);
        for (Messenger messenger : list) {
            if (messenger != null) {
                if (messenger.getBinder() == null || !messenger.getBinder().isBinderAlive()) {
                    list.remove(messenger);
                } else {
                    try {
                        messenger.send(obtain);
                    } catch (RemoteException e) {
                        com.opos.cmn.an.f.a.b("DownloadService", "", e);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0194, code lost:
        if (106 == r8) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Intent r7) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.DownloadService.a(android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger) {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap;
        if (messenger != null && (concurrentHashMap = this.e) != null && concurrentHashMap.size() > 0) {
            for (String str : this.e.keySet()) {
                List<Messenger> list = this.e.get(str);
                if (list != null && list.contains(messenger)) {
                    list.remove(messenger);
                    if (list != null && list.size() <= 0) {
                        this.e.remove(str);
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b("DownloadService", "remove mClientMessengerMap size :" + this.e.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Messenger messenger, String str) {
        List<Messenger> j;
        if (TextUtils.isEmpty(str) || messenger == null || (j = j(str)) == null || j.contains(messenger)) {
            return;
        }
        j.add(messenger);
        try {
            messenger.getBinder().linkToDeath(new IBinder.DeathRecipient() { // from class: com.opos.mobad.service.DownloadService.3
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    com.opos.cmn.an.f.a.a("DownloadService", "download binderDied:" + messenger);
                    DownloadService.this.a(messenger);
                    messenger.getBinder().unlinkToDeath(this, 0);
                }
            }, 0);
        } catch (RemoteException e) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e);
        }
        this.e.put(str, j);
        com.opos.cmn.an.f.a.b("DownloadService", "add mClientMessengerToUrlsMap size:" + this.e.size() + ",messengersByUrlList size :" + j.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (f) {
            return Build.VERSION.SDK_INT < 33 || this.f13573a.checkSelfPermission(t.cv) == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f13573a, DownloadService.class);
        intent.setAction("key_delete_action");
        intent.putExtra("key_action_type", 2);
        intent.putExtra(DBDefinition.SAVE_PATH, str);
        return intent;
    }

    private void b() {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.e;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(this.f13573a, DownloadService.class);
        intent.setAction("key_sys_delete_action");
        intent.putExtra("key_action_type", 3);
        intent.putExtra(DBDefinition.SAVE_PATH, str);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String a2 = com.opos.cmn.d.a.a(this.f13573a, str);
        com.opos.cmn.an.f.a.b("DownloadService", "install intent downloadPath =" + a2);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return com.opos.mobad.d.b.b.b(this.f13573a, a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.d.remove(str);
            k(str);
        }
        com.opos.cmn.an.f.a.b("DownloadService", "remove data mUrlToDownloadDataMap size:" + this.d.size() + ",mUrlToClientMessengerMap:" + this.e.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<String, com.opos.mobad.d.a.b> entry : this.d.entrySet()) {
            com.opos.mobad.d.a.b value = entry.getValue();
            if (value != null && value.a(str)) {
                String key = entry.getKey();
                if (a()) {
                    com.opos.cmn.an.f.a.b("DownloadService", "cancel notificationId:" + value.f12263c);
                    this.b.a(value.f12263c);
                }
                e(key);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.d.a.a(this.f13573a).b(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.d.a.a(this.f13573a).d(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.opos.mobad.d.a.a(this.f13573a).c(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadService", "", (Throwable) e);
        }
    }

    private List<Messenger> j(String str) {
        ArrayList arrayList = (TextUtils.isEmpty(str) || !this.e.containsKey(str)) ? new ArrayList() : this.e.get(str);
        com.opos.cmn.an.f.a.b("DownloadService", "getUrlToClientMessengerMap size=" + arrayList.size());
        return arrayList;
    }

    private void k(String str) {
        ConcurrentHashMap<String, List<Messenger>> concurrentHashMap = this.e;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0 && !TextUtils.isEmpty(str)) {
            this.e.remove(str);
        }
        com.opos.cmn.an.f.a.b("DownloadService", "removeClientMessengerUrlList mUrlToClientMessengerMap.size:" + this.e.size());
    }

    private void l(String str) {
        com.opos.mobad.d.a.b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (a() && (bVar = this.d.get(str)) != null) {
            int i = bVar.f12263c;
            this.b.a(i);
            com.opos.cmn.an.f.a.b("DownloadService", "cancelNotificationAndRemoveData:" + i);
        }
        e(str);
    }

    public void a(int i, boolean z) {
        if (this.g.compareAndSet(false, true)) {
            f = z;
            com.opos.cmn.an.f.a.b("DownloadService", "int service downloadTaskNums:" + i + ",sIsShowNotification :" + f);
            com.opos.mobad.d.a.a(this.f13573a).a(i, this.i);
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.mobad.d.a.b bVar = null;
        if (this.d.containsKey(str)) {
            bVar = this.d.get(str);
        }
        com.opos.cmn.an.f.a.b("DownloadService", "add downloadreq pkgName:" + str2 + ",appName :" + str4 + ",url:" + str + ",downloadReq:" + bVar);
        if (bVar != null) {
            if (102 != bVar.e && 107 != bVar.e) {
                com.opos.mobad.d.a.a(this.f13573a).a(str, str3);
                return;
            }
            Context context = this.f13573a;
            Toast.makeText(context, context.getResources().getString(R.string.download_toast_downloading_txt), 1).show();
            return;
        }
        com.opos.mobad.d.a.a(this.f13573a).a(str, str3);
        String str5 = str4;
        if (TextUtils.isEmpty(str4)) {
            str5 = com.opos.cmn.d.b.a(str);
        }
        this.d.put(str, new com.opos.mobad.d.a.b(str5, str2, f13572c.getAndIncrement(), new com.opos.mobad.d.a.d()));
        com.opos.cmn.an.f.a.b("DownloadService", "add downloadreq mUrlToDownloadDataMap size:" + this.d.size());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.opos.cmn.an.f.a.b("DownloadService", "on bind");
        a(intent);
        return this.h.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f13573a = getApplicationContext();
        b.a(PluginApi.sPluginContext, PluginApi.sHostContext);
        com.opos.cmn.an.f.a.b("DownloadService", "onCreate startForeground");
        com.opos.mobad.d.a.e a2 = new e.a().a("mob_downloader").b(3).b("download_manager").a(false).a(e.a(this.f13573a, "opos_mob_drawable_download_icon", i.f5112c)).a();
        this.b = Build.VERSION.SDK_INT > 30 ? new com.opos.mobad.d.a.g(this.f13573a, a2) : new com.opos.mobad.d.a.a(this.f13573a, a2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.opos.cmn.an.f.a.b("DownloadService", "onDestroy");
        this.d.clear();
        this.b.a();
        com.opos.mobad.d.a.a(this.f13573a).a();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        com.opos.cmn.an.f.a.b("DownloadService", "on Rebind");
        a(intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        com.opos.cmn.an.f.a.b("DownloadService", "onStartCommand");
        a(intent);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        com.opos.cmn.an.f.a.b("DownloadService", "onUnbind");
        b();
        return super.onUnbind(intent);
    }
}
