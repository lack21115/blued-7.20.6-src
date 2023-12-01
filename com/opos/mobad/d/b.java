package com.opos.mobad.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.mobad.service.DownloadService;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f25968a;
    private static final byte[] b = new byte[0];
    private static int g = 3;
    private static boolean h = true;

    /* renamed from: c  reason: collision with root package name */
    private Messenger f25969c;
    private Context d;
    private ConcurrentHashMap<String, com.opos.mobad.d.b.a> e = new ConcurrentHashMap<>();
    private List<com.opos.mobad.d.b.a> f = new CopyOnWriteArrayList();
    private boolean i = false;
    private int j = 0;
    private Messenger k = new Messenger(new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.d.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null || message.getData() == null) {
                return;
            }
            Bundle data = message.getData();
            int i = message.what;
            int i2 = data.getInt("key_percent");
            String string = data.getString("key_server_url");
            switch (i) {
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 107:
                    b.this.a(i, i2, string);
                    return;
                case 106:
                    b.this.a(i, i2, string, data.getString(Constants.KEY_ERROR_CODE));
                    return;
                default:
                    return;
            }
        }
    });
    private ServiceConnection l = new ServiceConnection() { // from class: com.opos.mobad.d.b.2
        private void a() {
            for (com.opos.mobad.d.b.a aVar : new ArrayList(b.this.e.values())) {
                if (aVar.f == 102 || aVar.f == 107) {
                    b.this.a(aVar);
                }
            }
        }

        private void b() {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay mDelayDownloadTaskList size:" + b.this.f.size());
            try {
                if (b.this.f == null || b.this.f.size() <= 0) {
                    return;
                }
                com.opos.mobad.d.b.a[] aVarArr = (com.opos.mobad.d.b.a[]) b.this.f.toArray(new com.opos.mobad.d.b.a[b.this.f.size()]);
                b.this.f.removeAll(Arrays.asList(aVarArr));
                int length = aVarArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        return;
                    }
                    b.this.a(aVarArr[i2]);
                    i = i2 + 1;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloaderDelay error", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceConnected");
            b.this.f25969c = new Messenger(iBinder);
            b();
            a();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.opos.cmn.an.f.a.b("DownloaderMgr", "onServiceDisconnected");
            b.this.f25969c = null;
            if (b.a(b.this) < 3) {
                b.this.d();
            }
        }
    };

    private b(Context context) {
        this.d = context.getApplicationContext();
    }

    static /* synthetic */ int a(b bVar) {
        int i = bVar.j;
        bVar.j = i + 1;
        return i;
    }

    public static b a(Context context) {
        b bVar;
        b bVar2 = f25968a;
        if (bVar2 == null) {
            synchronized (b) {
                b bVar3 = f25968a;
                bVar = bVar3;
                if (bVar3 == null) {
                    bVar = new b(context);
                    f25968a = bVar;
                }
            }
            return bVar;
        }
        return bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        a(i, i2, str, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, String str2) {
        ConcurrentHashMap<String, com.opos.mobad.d.b.a> concurrentHashMap;
        com.opos.mobad.d.b.a aVar;
        com.opos.cmn.an.f.a.b("DownloaderMgr", "client status:" + i + ",percent:" + i2 + ",url:" + str);
        if (TextUtils.isEmpty(str) || (concurrentHashMap = this.e) == null || (aVar = concurrentHashMap.get(str)) == null) {
            return;
        }
        switch (i) {
            case 101:
                aVar.f = 101;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (e eVar : aVar.e) {
                    if (eVar != null) {
                        eVar.a(i, i2, str, aVar.b);
                    }
                }
                return;
            case 102:
                aVar.f = 102;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (e eVar2 : aVar.e) {
                    if (eVar2 != null) {
                        eVar2.b(i, i2, str, aVar.b);
                    }
                }
                return;
            case 103:
                aVar.f = 103;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (e eVar3 : aVar.e) {
                    if (eVar3 != null) {
                        eVar3.d(i, i2, str, aVar.b);
                    }
                }
                return;
            case 104:
                aVar.f = 104;
                aVar.g = i2;
                if (aVar.e != null && aVar.e.size() > 0) {
                    for (e eVar4 : aVar.e) {
                        if (eVar4 != null) {
                            eVar4.e(i, i2, str, aVar.b);
                        }
                    }
                    aVar.e.clear();
                    break;
                }
                break;
            case 105:
                aVar.f = 105;
                aVar.g = i2;
                if (aVar.e != null && aVar.e.size() > 0) {
                    for (e eVar5 : aVar.e) {
                        if (eVar5 != null) {
                            eVar5.f(i, i2, str, aVar.b);
                        }
                    }
                    break;
                }
                break;
            case 106:
                aVar.f = 106;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (e eVar6 : aVar.e) {
                    if (eVar6 != null) {
                        eVar6.a(i, i2, str, aVar.b, str2);
                    }
                }
                return;
            case 107:
                aVar.f = 107;
                aVar.g = i2;
                if (aVar.e == null || aVar.e.size() <= 0) {
                    return;
                }
                for (e eVar7 : aVar.e) {
                    if (eVar7 != null) {
                        eVar7.c(i, i2, str, aVar.b);
                    }
                }
                return;
            default:
                return;
        }
        this.e.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.opos.mobad.d.b.a aVar) {
        boolean a2 = (aVar == null || com.opos.cmn.an.c.a.a(aVar.d) || com.opos.cmn.an.c.a.a(aVar.b)) ? false : a(aVar.d, aVar.b, aVar.f25973c, aVar.f25972a);
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader result:" + a2 + ", downloadData:" + aVar);
        return a2;
    }

    private boolean a(String str, String str2, String str3, String str4) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader pkgName:" + str2 + ",url:" + str + ",md5:" + str3 + ",appName:" + str4);
        boolean z = true;
        if (!com.opos.cmn.an.c.a.a(str) && !com.opos.cmn.an.c.a.a(str2) && this.f25969c != null) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("key_url", str);
                bundle.putString("key_pkg_name", str2);
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("key_apk_md5", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("key_app_name", str4);
                }
                obtain.setData(bundle);
                obtain.replyTo = this.k;
                this.f25969c.send(obtain);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
            }
            com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader mUrlToDownloadDataMap:" + this.e.size());
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("DownloaderMgr", "addDownloader mUrlToDownloadDataMap:" + this.e.size());
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r2 = r4
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.opos.mobad.d.b.a> r2 = r2.e
            java.util.Collection r2 = r2.values()
            r1.<init>(r2)
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L14:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L59
            r0 = r6
            java.lang.Object r0 = r0.next()
            com.opos.mobad.d.b.a r0 = (com.opos.mobad.d.b.a) r0
            r7 = r0
            r0 = r7
            int r0 = r0.f
            r1 = 102(0x66, float:1.43E-43)
            if (r0 == r1) goto L54
            r0 = r7
            int r0 = r0.f
            r1 = 107(0x6b, float:1.5E-43)
            if (r0 == r1) goto L54
            r0 = r7
            int r0 = r0.f
            r1 = 101(0x65, float:1.42E-43)
            if (r0 == r1) goto L54
            r0 = r7
            int r0 = r0.f
            r1 = 106(0x6a, float:1.49E-43)
            if (r0 == r1) goto L54
            r0 = r7
            int r0 = r0.f
            r1 = 103(0x67, float:1.44E-43)
            if (r0 != r1) goto L14
        L54:
            r0 = 0
            r5 = r0
            goto L5b
        L59:
            r0 = 1
            r5 = r0
        L5b:
            r0 = r5
            if (r0 == 0) goto L63
            r0 = r4
            r0.c()
        L63:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "unBindServiceIfNeed canUnbind:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "DownloaderMgr"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.b.b():void");
    }

    private void c() {
        if (this.f25969c != null) {
            try {
                Message obtain = Message.obtain();
                obtain.what = 7;
                obtain.replyTo = this.k;
                try {
                    this.f25969c.send(obtain);
                } catch (RemoteException e) {
                    com.opos.cmn.an.f.a.b("DownloaderMgr", "", e);
                }
                if (this.d != null && this.l != null) {
                    this.d.unbindService(this.l);
                }
                this.f25969c = null;
                com.opos.cmn.an.f.a.b("DownloaderMgr", "task download mgr ,unBindService");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Intent intent = new Intent(this.d, DownloadService.class);
        intent.putExtra("key_action_type", 0);
        intent.putExtra("key_download_tasks", g);
        intent.putExtra("key_show_notification", h);
        this.d.startService(intent);
        this.d.bindService(intent, this.l, 1);
    }

    public void a() {
        try {
            if (this.d == null || this.l == null) {
                return;
            }
            c();
            if (this.e != null) {
                this.e.clear();
            }
            if (this.f != null) {
                this.f.clear();
            }
        } catch (Exception e) {
        }
    }

    public void a(int i, boolean z) {
        if (this.i) {
            return;
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "set nums =" + i + ", show notification =" + z);
        g = i;
        h = z;
        this.i = true;
    }

    public void a(e eVar) {
        if (eVar != null) {
            for (com.opos.mobad.d.b.a aVar : this.e.values()) {
                if (aVar != null) {
                    aVar.b(eVar);
                    com.opos.cmn.an.f.a.b("DownloaderMgr", "removeDownloadListener");
                    return;
                }
            }
        }
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "pauseDownloader url:" + str);
        if (com.opos.cmn.an.c.a.a(str) || this.f25969c == null) {
            return;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putString("key_url", str);
            obtain.setData(bundle);
            this.f25969c.send(obtain);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
        }
    }

    public void a(String str, String str2, String str3, String str4, e eVar) {
        com.opos.mobad.d.b.a aVar;
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return;
        }
        if (this.e.containsKey(str)) {
            com.opos.mobad.d.b.a aVar2 = this.e.get(str);
            aVar = aVar2;
            if (aVar2 != null) {
                aVar2.a(eVar);
                aVar = aVar2;
            }
        } else {
            com.opos.mobad.d.b.a aVar3 = new com.opos.mobad.d.b.a(str, str4, str2, str3);
            aVar3.a(eVar);
            this.e.put(str, aVar3);
            aVar = aVar3;
        }
        if (this.f25969c == null) {
            d();
            this.f.add(aVar);
        } else {
            a(aVar);
        }
        this.j = 0;
    }

    public int[] a(String str, String str2) {
        com.opos.mobad.d.b.a aVar;
        int[] iArr = new int[2];
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (aVar = this.e.get(str)) != null) {
            iArr[0] = aVar.f;
            iArr[1] = aVar.g;
        }
        com.opos.cmn.an.f.a.b("DownloaderMgr", "queryDownload status:" + iArr[0] + ",percent:" + iArr[1]);
        return iArr;
    }

    public void b(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "cancelDownloader url:" + str);
        if (com.opos.cmn.an.c.a.a(str) || this.f25969c == null) {
            return;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = 4;
            Bundle bundle = new Bundle();
            bundle.putString("key_url", str);
            obtain.setData(bundle);
            this.f25969c.send(obtain);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("DownloaderMgr", "notifyInstallEvent pkgName:" + str);
        if (com.opos.cmn.an.c.a.a(str) || this.f25969c == null) {
            return;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = 5;
            Bundle bundle = new Bundle();
            bundle.putString("key_pkg_name", str);
            obtain.setData(bundle);
            this.f25969c.send(obtain);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloaderMgr", "", (Throwable) e);
        }
        b();
    }
}
