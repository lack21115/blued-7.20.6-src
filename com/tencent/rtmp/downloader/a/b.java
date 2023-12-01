package com.tencent.rtmp.downloader.a;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Base64;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.storage.PersistStorage;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.txcplayer.b.a;
import com.tencent.liteav.txcvodplayer.b.a;
import com.tencent.liteav.txcvodplayer.b.d;
import com.tencent.liteav.txcvodplayer.b.e;
import com.tencent.liteav.txcvodplayer.b.f;
import com.tencent.liteav.txcvodplayer.b.g;
import com.tencent.rtmp.TXPlayerAuthBuilder;
import com.tencent.rtmp.downloader.ITXVodDownloadListener;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.rtmp.downloader.TXVodDownloadManager;
import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/downloader/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public com.tencent.liteav.txcplayer.b.a f38672a;
    ArrayList<c> b;

    /* renamed from: c  reason: collision with root package name */
    public ITXVodDownloadListener f38673c;
    public PersistStorage d;
    a.InterfaceC0929a e = new a.InterfaceC0929a() { // from class: com.tencent.rtmp.downloader.a.b.4
        @Override // com.tencent.liteav.txcplayer.b.a.InterfaceC0929a
        public final void a(com.tencent.liteav.txcplayer.b.b bVar) {
            c a2 = b.this.a(bVar);
            if (a2 != null) {
                a2.h(1);
                b.a(b.this, a2);
                if (b.this.f38673c != null) {
                    b.this.f38673c.onDownloadStart(a2);
                }
            }
        }

        @Override // com.tencent.liteav.txcplayer.b.a.InterfaceC0929a
        public final void a(com.tencent.liteav.txcplayer.b.b bVar, int i, String str) {
            c a2 = b.this.a(bVar);
            if (a2 != null) {
                LiteavLog.w("TXVodDownloadManagerImpl", "downloadError " + a2.getPlayPath() + " " + i + " ： " + str);
                a2.h(3);
                b.a(b.this, a2);
                synchronized (b.this.b) {
                    b.this.b.remove(a2);
                }
                if (b.this.f38673c != null) {
                    if (a2.getDownloadState() == 2) {
                        b.this.f38673c.onDownloadStop(a2);
                    } else if (i == 1008) {
                        b.this.f38673c.onDownloadError(a2, TXVodDownloadManager.DOWNLOAD_HLS_KEY_ERROR, str);
                    } else if (i == 14020003) {
                        b.this.f38673c.onDownloadError(a2, TXVodDownloadManager.DOWNLOAD_403FORBIDDEN, str);
                    } else {
                        b.this.f38673c.onDownloadError(a2, TXVodDownloadManager.DOWNLOAD_DISCONNECT, str);
                    }
                }
            }
        }

        @Override // com.tencent.liteav.txcplayer.b.a.InterfaceC0929a
        public final void b(com.tencent.liteav.txcplayer.b.b bVar) {
            c a2 = b.this.a(bVar);
            if (a2 != null) {
                LiteavLog.i("TXVodDownloadManagerImpl", "downloadEnd " + a2.getPlayPath());
                a2.h(2);
                b.a(b.this, a2);
                synchronized (b.this.b) {
                    b.this.b.remove(a2);
                }
                if (b.this.f38673c != null) {
                    b.this.f38673c.onDownloadStop(a2);
                }
            }
        }

        @Override // com.tencent.liteav.txcplayer.b.a.InterfaceC0929a
        public final void c(com.tencent.liteav.txcplayer.b.b bVar) {
            c a2 = b.this.a(bVar);
            if (a2 != null) {
                LiteavLog.i("TXVodDownloadManagerImpl", "downloadFinish " + a2.getPlayPath());
                a2.h(4);
                b.a(b.this, a2);
                synchronized (b.this.b) {
                    b.this.b.remove(a2);
                }
                if (b.this.f38673c != null) {
                    if (b.c(a2.getPlayPath())) {
                        b.this.f38673c.onDownloadFinish(a2);
                    } else {
                        b.this.f38673c.onDownloadError(a2, TXVodDownloadManager.DOWNLOAD_NO_FILE, "The file not exist");
                    }
                }
            }
        }

        @Override // com.tencent.liteav.txcplayer.b.a.InterfaceC0929a
        public final void d(com.tencent.liteav.txcplayer.b.b bVar) {
            c a2 = b.this.a(bVar);
            if (a2 == null || b.this.f38673c == null) {
                return;
            }
            b.this.f38673c.onDownloadProgress(a2);
        }
    };

    public b() {
        Context b = b();
        com.tencent.liteav.txcplayer.b.a a2 = com.tencent.liteav.txcplayer.b.c.a(b);
        this.f38672a = a2;
        if (a2 != null) {
            a2.setListener(this.e);
        }
        this.b = new ArrayList<>();
        if (b != null) {
            ContextUtils.initApplicationContext(b);
            ContextUtils.setDataDirectorySuffix("liteav");
            this.d = new PersistStorage("vod_download");
        }
    }

    private static String a(String str, c cVar) {
        TXVodDownloadDataSource dataSource = cVar.getDataSource();
        String str2 = str;
        if (dataSource != null) {
            str2 = str;
            if (!TextUtils.isEmpty(dataSource.getOverlayKey())) {
                str2 = str.concat("&oversign=" + dataSource.getAppId() + "&o1=" + dataSource.getUserName() + "&o2=" + dataSource.getFileId() + "&o3=" + dataSource.getQuality() + "&o4=" + dataSource.getOverlayKey() + "&o5=" + dataSource.getOverlayIv() + "&oversign=");
            }
        }
        return str2;
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        String encodeToString;
        if (bVar.d != null) {
            if (cVar == null) {
                encodeToString = "";
            } else {
                Parcel obtain = Parcel.obtain();
                cVar.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                encodeToString = Base64.encodeToString(obtain.marshall(), 2);
                obtain.recycle();
            }
            if (TextUtils.isEmpty(encodeToString)) {
                return;
            }
            String b = b(cVar);
            if (TextUtils.isEmpty(b)) {
                return;
            }
            bVar.d.put(b, encodeToString);
            bVar.d.commit();
            LiteavLog.i("TXVodDownloadManagerImpl", "saveDownloadMediaInfo key: " + b + "| mediaInfo: " + encodeToString);
        }
    }

    static /* synthetic */ void a(b bVar, final c cVar, final com.tencent.liteav.txcvodplayer.b.c cVar2) {
        int i;
        if (cVar2 == null || cVar.getDataSource() == null) {
            return;
        }
        final String a2 = cVar2.a();
        if (a2 == null || !a2.contains(".m3u8")) {
            LiteavLog.w("TXVodDownloadManagerImpl", "not support format! masterPlaylistUrl : ".concat(String.valueOf(a2)));
            return;
        }
        cVar.a(cVar2.c() * 1000);
        if (cVar2.b != null) {
            i = cVar2.b.e;
        } else {
            i = -1;
            if (cVar2.f36521c != null) {
                f fVar = cVar2.f36521c;
                if (fVar.b == null) {
                    fVar.b = fVar.c();
                }
                i = -1;
                if (fVar.b != null) {
                    i = fVar.b.d;
                }
            }
        }
        cVar.c(i);
        a.C0931a.f36516a.a(a2, new a.b() { // from class: com.tencent.rtmp.downloader.a.b.3
            @Override // com.tencent.liteav.txcvodplayer.b.a.b
            public final void a() {
                LiteavLog.i("TXVodDownloadManagerImpl", "prepareDownloadMedia onError");
                synchronized (b.this.b) {
                    b.this.b.remove(cVar);
                }
                if (b.this.f38673c != null) {
                    b.this.f38673c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_AUTH_FAILED, "get substream infos failure");
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:63:0x0209  */
            /* JADX WARN: Removed duplicated region for block: B:77:0x033a  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x0383  */
            @Override // com.tencent.liteav.txcvodplayer.b.a.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(java.lang.String r7) {
                /*
                    Method dump skipped, instructions count: 919
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.downloader.a.b.AnonymousClass3.a(java.lang.String):void");
            }
        });
    }

    private static Context b() {
        Method method;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            if (cls == null || (method = cls.getMethod("currentActivityThread", new Class[0])) == null) {
                return null;
            }
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = invoke.getClass().getMethod("getApplication", new Class[0]);
            if (method2 == null) {
                return null;
            }
            return ((Application) method2.invoke(invoke, new Object[0])).getApplicationContext();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        TXVodDownloadDataSource dataSource = tXVodDownloadMediaInfo.getDataSource();
        if (dataSource == null) {
            if (TextUtils.isEmpty(tXVodDownloadMediaInfo.getUrl())) {
                return null;
            }
            return tXVodDownloadMediaInfo.getUserName() + BridgeUtil.UNDERLINE_STR + com.tencent.liteav.txcplayer.e.a.b(tXVodDownloadMediaInfo.getUrl());
        } else if (TextUtils.isEmpty(dataSource.getFileId())) {
            return null;
        } else {
            return dataSource.getUserName() + BridgeUtil.UNDERLINE_STR + dataSource.getAppId() + BridgeUtil.UNDERLINE_STR + dataSource.getFileId() + BridgeUtil.UNDERLINE_STR + dataSource.getQuality();
        }
    }

    static /* synthetic */ String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new StringBuffer();
        String[] split = str.split("\n");
        if (split == null || split.length <= 0) {
            return null;
        }
        int length = split.length;
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = z;
            if (i >= length) {
                return null;
            }
            String str3 = split[i];
            boolean z3 = z2;
            if (!TextUtils.isEmpty(str3)) {
                if (str3.startsWith("#EXT-X-STREAM-INF:")) {
                    z3 = z2;
                    if (str3.contains(str2)) {
                        z3 = true;
                    }
                } else {
                    z3 = z2;
                    if (z2) {
                        z3 = z2;
                        if (str3.contains(".m3u8")) {
                            return str3;
                        }
                    } else {
                        continue;
                    }
                }
            }
            i++;
            z = z3;
        }
    }

    static boolean c(String str) {
        String str2 = str;
        if (str.contains(".hls")) {
            str2 = str.substring(0, str.indexOf(".hls") + 4);
        }
        return new File(str2).exists();
    }

    private static c d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 2);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
        c createFromParcel = c.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        if (createFromParcel == null) {
            return null;
        }
        if (createFromParcel.getPlayPath().contains("&oversign=")) {
            return createFromParcel;
        }
        a aVar = (a) createFromParcel.getDataSource();
        if (aVar != null && !TextUtils.isEmpty(aVar.getOverlayKey())) {
            createFromParcel.a(a(createFromParcel.getPlayPath(), createFromParcel));
        }
        return createFromParcel;
    }

    public final TXVodDownloadMediaInfo a(int i, String str, int i2) {
        c cVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.b) {
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                TXVodDownloadDataSource dataSource = next.getDataSource();
                if (dataSource != null && dataSource.getAppId() == i && dataSource.getFileId().equals(str) && dataSource.getQuality() == i2) {
                    return next;
                }
            }
            if (this.d != null) {
                c cVar2 = new c();
                cVar2.a(new a(i, str, i2, null, null));
                String b = b(cVar2);
                cVar = d(this.d.getString(b));
                if (cVar != null && !c(cVar.getPlayPath())) {
                    this.d.clear(b);
                    this.d.commit();
                    LiteavLog.w("TXVodDownloadManagerImpl", "fileId : " + str + " | qualityId: " + i2 + " download file not exist! remove download info!");
                    return null;
                }
            }
            return cVar;
        }
    }

    final c a(com.tencent.liteav.txcplayer.b.b bVar) {
        c next;
        synchronized (this.b) {
            Iterator<c> it = this.b.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
                if (next.getTaskId() == bVar.f36475a) {
                    break;
                }
            } while (!next.getUrl().equals(bVar.b));
            if (bVar.h > 0) {
                next.b(bVar.h);
            }
            if (next.getDuration() <= 0 && bVar.i > 0) {
                next.a(bVar.i);
            }
            if (bVar.f36476c > 0) {
                next.d(bVar.f36476c);
            }
            if (next.getSize() <= 0 && bVar.d > 0) {
                next.c(bVar.d);
            }
            if (bVar.f > 0) {
                next.e(bVar.f);
            }
            if (bVar.g > 0) {
                next.f(bVar.g);
            }
            return next;
        }
    }

    public final c a(final TXVodDownloadDataSource tXVodDownloadDataSource) {
        final c cVar = new c();
        a aVar = TextUtils.isEmpty(tXVodDownloadDataSource.getTemplateName()) ? new a(tXVodDownloadDataSource.getAuthBuilder(), tXVodDownloadDataSource.getQuality()) : new a(tXVodDownloadDataSource.getAuthBuilder(), tXVodDownloadDataSource.getTemplateName());
        cVar.a(aVar);
        c a2 = a((TXVodDownloadMediaInfo) cVar);
        if (a2 != null) {
            return a2;
        }
        if (tXVodDownloadDataSource.getAuthBuilder() != null) {
            TXPlayerAuthBuilder authBuilder = aVar.getAuthBuilder();
            d dVar = new d();
            dVar.f36534c = authBuilder.isHttps();
            final a aVar2 = aVar;
            dVar.a(new e() { // from class: com.tencent.rtmp.downloader.a.b.1
                @Override // com.tencent.liteav.txcvodplayer.b.e
                public final void a(d dVar2) {
                    g gVar;
                    List<Integer> list;
                    if (cVar.getDownloadState() == 2) {
                        synchronized (b.this.b) {
                            b.this.b.remove(cVar);
                        }
                        if (b.this.f38673c != null) {
                            b.this.f38673c.onDownloadStop(cVar);
                        }
                        LiteavLog.w("TXVodDownloadManagerImpl", "Download task canceled");
                        return;
                    }
                    f a3 = dVar2.a();
                    if (tXVodDownloadDataSource.getQuality() != 1000) {
                        int quality = aVar2.getQuality();
                        if (quality == 0) {
                            gVar = a3.f();
                        } else {
                            String a4 = a.a(quality);
                            List<f.a> k = a3.k();
                            if (k != null) {
                                for (f.a aVar3 : k) {
                                    if (aVar3.f36539a.equals(a4)) {
                                        list = aVar3.f36540c;
                                        break;
                                    }
                                }
                            }
                            list = null;
                            gVar = null;
                            if (list != null) {
                                Iterator<g> it = a3.e().iterator();
                                while (true) {
                                    gVar = null;
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    g next = it.next();
                                    if (list.contains(Integer.valueOf(next.i))) {
                                        gVar = next;
                                        if (next.g == null) {
                                            break;
                                        } else if (next.g.contains("hls")) {
                                            gVar = next;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        gVar = null;
                        if (tXVodDownloadDataSource.getTemplateName() != null) {
                            String templateName = aVar2.getTemplateName();
                            gVar = null;
                            if (templateName != null) {
                                Iterator<g> it2 = a3.e().iterator();
                                while (true) {
                                    gVar = null;
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    g next2 = it2.next();
                                    if (templateName.equals(next2.h)) {
                                        gVar = next2;
                                        if (next2.g == null) {
                                            break;
                                        } else if (next2.g.contains("hls")) {
                                            gVar = next2;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (gVar == null) {
                        synchronized (b.this.b) {
                            b.this.b.remove(cVar);
                        }
                        if (b.this.f38673c != null) {
                            b.this.f38673c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_NO_FILE, "No such resolution");
                            return;
                        }
                        return;
                    }
                    String str = gVar.f36541a;
                    TXVodDownloadDataSource tXVodDownloadDataSource2 = tXVodDownloadDataSource;
                    String str2 = str;
                    if (tXVodDownloadDataSource2 != null) {
                        str2 = str;
                        if (tXVodDownloadDataSource2.getToken() != null) {
                            String[] split = str.split(BridgeUtil.SPLIT_MARK);
                            str2 = str;
                            if (split.length > 0) {
                                int lastIndexOf = str.lastIndexOf(split[split.length - 1]);
                                str2 = str.substring(0, lastIndexOf) + "voddrm.token." + tXVodDownloadDataSource.getToken() + "." + str.substring(lastIndexOf);
                            }
                        }
                    }
                    cVar.b(str2);
                    cVar.c(gVar.d);
                    cVar.a(gVar.e);
                    b.this.a(cVar);
                }

                @Override // com.tencent.liteav.txcvodplayer.b.e
                public final void a(d dVar2, String str, int i) {
                    synchronized (b.this.b) {
                        b.this.b.remove(cVar);
                    }
                    if (b.this.f38673c != null) {
                        b.this.f38673c.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_AUTH_FAILED, str);
                    }
                }
            });
            if (dVar.a(authBuilder.getAppId(), authBuilder.getFileId(), authBuilder.getTimeout(), authBuilder.getUs(), authBuilder.getExper(), authBuilder.getSign()) != 0) {
                LiteavLog.e("TXVodDownloadManagerImpl", "unable to getPlayInfo");
                return null;
            }
            cVar.a(dVar);
            synchronized (this.b) {
                this.b.add(cVar);
            }
            return cVar;
        }
        return null;
    }

    public final c a(TXVodDownloadMediaInfo tXVodDownloadMediaInfo) {
        c d;
        String b = b(tXVodDownloadMediaInfo);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        String string = this.d.getString(b);
        if (TextUtils.isEmpty(string) || (d = d(string)) == null) {
            return null;
        }
        if (c(d.getPlayPath())) {
            LiteavLog.i("TXVodDownloadManagerImpl", "partly download, resume download");
            a(d);
            return d;
        }
        LiteavLog.w("TXVodDownloadManagerImpl", "file is deleted, remove cache and restart download");
        this.d.clear(b);
        PersistStorage persistStorage = this.d;
        persistStorage.clear(b + "_kv");
        this.d.commit();
        return null;
    }

    public final c a(String str, String str2) {
        c cVar = new c();
        cVar.b(str);
        cVar.c(str2);
        c a2 = a((TXVodDownloadMediaInfo) cVar);
        if (a2 != null) {
            return a2;
        }
        a(cVar);
        return cVar;
    }

    public final List<TXVodDownloadMediaInfo> a() {
        boolean z;
        PersistStorage persistStorage = this.d;
        if (persistStorage == null) {
            return null;
        }
        try {
            String[] allKeys = persistStorage.getAllKeys();
            if (allKeys == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(allKeys.length);
            int length = allKeys.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return arrayList;
                }
                String str = allKeys[i2];
                c d = d(this.d.getString(str));
                if (d != null) {
                    if (c(d.getPlayPath())) {
                        synchronized (this.b) {
                            Iterator<c> it = this.b.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = false;
                                    break;
                                }
                                c next = it.next();
                                if (next.getTaskId() == d.getTaskId()) {
                                    arrayList.add(next);
                                    z = true;
                                    break;
                                }
                            }
                        }
                        if (!z) {
                            arrayList.add(d);
                        }
                    } else {
                        this.d.clear(str);
                        this.d.commit();
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    final void a(c cVar) {
        String url = cVar.getUrl();
        if (url == null) {
            return;
        }
        if (!Uri.parse(url).getPath().endsWith(".m3u8")) {
            LiteavLog.e("TXVodDownloadManagerImpl", "only support m3u8 file, format error: ".concat(String.valueOf(url)));
            ITXVodDownloadListener iTXVodDownloadListener = this.f38673c;
            if (iTXVodDownloadListener != null) {
                iTXVodDownloadListener.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_FORMAT_ERROR, "No support format");
                return;
            }
            return;
        }
        cVar.a(a(this.f38672a.makePlayPath(url), cVar));
        if (cVar.getPlayPath() == null) {
            ITXVodDownloadListener iTXVodDownloadListener2 = this.f38673c;
            if (iTXVodDownloadListener2 != null) {
                iTXVodDownloadListener2.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_PATH_ERROR, "Failed to create local path");
                return;
            }
            return;
        }
        LiteavLog.d("TXVodDownloadManagerImpl", "download hls " + url + " to " + cVar.getPlayPath());
        synchronized (this.b) {
            this.b.add(cVar);
        }
        cVar.g(this.f38672a.downloadHls(url, cVar.getPlayPath()));
        if (cVar.getTaskId() < 0) {
            LiteavLog.e("TXVodDownloadManagerImpl", "start download failed");
            ITXVodDownloadListener iTXVodDownloadListener3 = this.f38673c;
            if (iTXVodDownloadListener3 != null) {
                iTXVodDownloadListener3.onDownloadError(cVar, TXVodDownloadManager.DOWNLOAD_FORMAT_ERROR, "Internal error");
            }
        }
    }

    public final boolean a(String str) {
        LiteavLog.d("TXVodDownloadManagerImpl", "delete file ".concat(String.valueOf(str)));
        synchronized (this.b) {
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.getPlayPath() != null && next.getPlayPath().equals(str)) {
                    LiteavLog.e("TXVodDownloadManagerImpl", "file is downloading, can not be delete");
                    return false;
                }
            }
            return this.f38672a.deleteDownloadFile(str);
        }
    }

    public final TXVodDownloadMediaInfo b(String str) {
        c cVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.b) {
            Iterator<c> it = this.b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.getUrl() != null && next.getUrl().equals(str)) {
                    return next;
                }
            }
            if (this.d != null) {
                c cVar2 = new c();
                cVar2.b(str);
                String b = b(cVar2);
                cVar = d(this.d.getString(b));
                if (cVar != null && !c(cVar.getPlayPath())) {
                    this.d.clear(b);
                    this.d.commit();
                    return null;
                }
            }
            return cVar;
        }
    }
}
