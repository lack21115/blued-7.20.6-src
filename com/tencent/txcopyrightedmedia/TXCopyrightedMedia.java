package com.tencent.txcopyrightedmedia;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.impl.utils.ab;
import com.tencent.txcopyrightedmedia.impl.utils.ah;
import com.tencent.txcopyrightedmedia.impl.utils.ai;
import com.tencent.txcopyrightedmedia.impl.utils.ak;
import com.tencent.txcopyrightedmedia.impl.utils.ap;
import com.tencent.txcopyrightedmedia.impl.utils.ar;
import com.tencent.txcopyrightedmedia.impl.utils.as;
import com.tencent.txcopyrightedmedia.impl.utils.at;
import com.tencent.txcopyrightedmedia.impl.utils.ax;
import com.tencent.txcopyrightedmedia.impl.utils.ay;
import com.tencent.txcopyrightedmedia.impl.utils.ba;
import com.tencent.txcopyrightedmedia.impl.utils.bd;
import com.tencent.txcopyrightedmedia.impl.utils.d;
import com.tencent.txcopyrightedmedia.impl.utils.g;
import com.tencent.txcopyrightedmedia.impl.utils.i;
import com.tencent.txcopyrightedmedia.impl.utils.j;
import com.tencent.txcopyrightedmedia.impl.utils.k;
import com.tencent.txcopyrightedmedia.impl.utils.m;
import com.tencent.txcopyrightedmedia.impl.utils.n;
import com.tencent.txcopyrightedmedia.impl.utils.o;
import com.tencent.txcopyrightedmedia.impl.utils.p;
import com.tencent.txcopyrightedmedia.impl.utils.y;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXCopyrightedMedia.class */
public class TXCopyrightedMedia {
    public static final int CLIP_CHORUS = 1;
    public static final int CLIP_FULL = 0;
    public static final String EXT_INFO_PLAY_SCENE = "PlayScene";
    public static final String EXT_INFO_ROOM_ID = "RoomId";
    public static final String PLAY_SCENE_CHAT = "Chat";
    public static final String PLAY_SCENE_LIVE = "Live";
    public static final int TYPE_ACCOMP = 1;
    public static final int TYPE_LYRIC = 2;
    public static final int TYPE_ORIGIN = 0;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<as> f26326a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26327c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXCopyrightedMedia$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static TXCopyrightedMedia f26330a = new TXCopyrightedMedia((byte) 0);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/TXCopyrightedMedia$b.class */
    static final class b implements ab.a {

        /* renamed from: a  reason: collision with root package name */
        final ay f26331a;
        final String b;

        /* renamed from: c  reason: collision with root package name */
        final String f26332c;
        final bd e;
        ArrayList<as> h;
        final ArrayList<ITXMusicPreloadCallback> d = new ArrayList<>();
        final Object f = new Object();
        ErrorCode g = null;

        public b(ay ayVar, ITXMusicPreloadCallback iTXMusicPreloadCallback, ArrayList<as> arrayList) {
            this.f26331a = ayVar;
            this.b = ayVar.f26389a;
            String b = new j(ayVar.d).b();
            this.f26332c = b;
            this.e = new bd(this.b, b);
            this.d.add(iTXMusicPreloadCallback);
            this.h = arrayList;
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.ab.a
        public final String a() {
            return this.b + this.f26332c;
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.ab.a
        public final void b() {
            synchronized (this.f) {
                Iterator<ITXMusicPreloadCallback> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().onPreloadStart(this.b, this.f26332c);
                }
            }
        }

        @Override // com.tencent.txcopyrightedmedia.impl.utils.ab.a
        public final void c() {
            Thread currentThread = Thread.currentThread();
            currentThread.setName("ame-prepare-" + Thread.currentThread().getId());
            com.tencent.txcopyrightedmedia.impl.utils.b bVar = (com.tencent.txcopyrightedmedia.impl.utils.b) m.a().b(m.f26418a);
            if (bVar == null) {
                return;
            }
            ba baVar = new ba(bVar, this.f26331a);
            baVar.d = true;
            baVar.f = false;
            as asVar = new as(baVar);
            synchronized (TXCopyrightedMedia.class) {
                try {
                    this.h.add(asVar);
                } finally {
                }
            }
            bd bdVar = this.e;
            bdVar.c();
            bdVar.n = "GetVodInfo";
            this.e.a(100);
            i a2 = com.tencent.txcopyrightedmedia.impl.utils.a.a(asVar);
            i iVar = a2;
            if (a2.code == 0) {
                this.e.a(102);
                this.e.a(a2.f26410a);
                ah.a().a(this.e);
                g gVar = bVar.d;
                String str = this.f26331a.f26390c;
                SharedPreferences.Editor edit = gVar.f26408a.edit();
                edit.putString("USER_ID_TOKEN", str);
                edit.apply();
                this.e.d();
                this.e.a(100);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new at.a("Subtitles", 3, asVar.l()));
                arrayList.add(new at.a(asVar.k(), 2, asVar.l()));
                arrayList.add(new at.a(asVar.k(), 1, asVar.l()));
                iVar = com.tencent.txcopyrightedmedia.impl.utils.a.a(bVar, asVar, 2, arrayList, new com.tencent.txcopyrightedmedia.a() { // from class: com.tencent.txcopyrightedmedia.TXCopyrightedMedia.b.1
                    @Override // com.tencent.txcopyrightedmedia.a
                    public final void a(String str2, String str3, float f) {
                        synchronized (b.this.f) {
                            Iterator<ITXMusicPreloadCallback> it = b.this.d.iterator();
                            while (it.hasNext()) {
                                it.next().onPreloadProgress(str2, str3, f);
                            }
                        }
                    }
                });
                int i = iVar.code;
            }
            this.e.a(102);
            synchronized (this.f) {
                Iterator<ITXMusicPreloadCallback> it = this.d.iterator();
                while (it.hasNext()) {
                    it.next().onPreloadComplete(this.b, this.f26332c, iVar.code, iVar.msg);
                }
                this.g = iVar;
            }
            this.e.a(iVar.f26410a);
            ah.a().a(this.e);
            synchronized (TXCopyrightedMedia.class) {
                try {
                    this.h.remove(asVar);
                } finally {
                }
            }
        }
    }

    private TXCopyrightedMedia() {
        this.f26326a = new ArrayList<>();
    }

    /* synthetic */ TXCopyrightedMedia(byte b2) {
        this();
    }

    public static String genMusicURI(String str, int i, String str2) {
        synchronized (TXCopyrightedMedia.class) {
            try {
                j jVar = new j(str2);
                String a2 = jVar.a();
                com.tencent.txcopyrightedmedia.impl.utils.b bVar = (com.tencent.txcopyrightedmedia.impl.utils.b) m.a().b(m.f26418a);
                if (bVar == null) {
                    return null;
                }
                ay ayVar = new ay();
                ayVar.f26389a = str;
                ayVar.d = a2;
                ba baVar = new ba(bVar, ayVar);
                if (!TextUtils.isEmpty(baVar.f26396c.f26388c) && baVar.f26396c.e == 100) {
                    as asVar = new as(baVar);
                    asVar.f26377a = baVar.f26396c.f26388c;
                    if (asVar.e().code != 0) {
                        return null;
                    }
                    at a3 = i == 0 ? asVar.a(jVar.f26413a, 1, jVar.b) : i == 1 ? asVar.a(jVar.f26413a, 2, jVar.b) : asVar.a("Subtitles", 3, jVar.b);
                    if (a3 == null) {
                        return null;
                    }
                    if (i == 2) {
                        return d.a(a3.i(), a3.l()).getAbsolutePath();
                    }
                    String encode = URLEncoder.encode(a2);
                    return "CopyRightMusic://audiotype=" + i + "&musicid=" + URLEncoder.encode(str) + "&musicparams=" + encode;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String getSDKVersion() {
        synchronized (TXCopyrightedMedia.class) {
        }
        return "TXCopyrightedMedia_trtc_proxy_ksong_ysd-3.5.0.230247";
    }

    public static TXCopyrightedMedia instance() {
        return a.f26330a;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.txcopyrightedmedia.TXCopyrightedMedia$1] */
    public void cancelPreloadMusic(final String str, String str2) {
        synchronized (this) {
            final String b2 = new j(str2).b();
            new Thread() { // from class: com.tencent.txcopyrightedmedia.TXCopyrightedMedia.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    Thread currentThread = Thread.currentThread();
                    currentThread.setName("ame-cancel-" + Thread.currentThread().getId());
                    synchronized (TXCopyrightedMedia.class) {
                        try {
                            Iterator it = TXCopyrightedMedia.this.f26326a.iterator();
                            while (it.hasNext()) {
                                as asVar = (as) it.next();
                                if ((TextUtils.equals(asVar.i(), str) && TextUtils.equals(asVar.j(), b2)) || str == null) {
                                    asVar.f().b = true;
                                    asVar.n();
                                    Iterator<at> it2 = asVar.d().iterator();
                                    while (it2.hasNext()) {
                                        at next = it2.next();
                                        next.n();
                                        if (next.e != null) {
                                            next.e.n();
                                        }
                                        if (next.g != null) {
                                            next.g.n();
                                        }
                                        int i = 0;
                                        while (true) {
                                            int i2 = i;
                                            if (i2 < next.f.size()) {
                                                ar a2 = next.a(i2);
                                                if (a2 != null) {
                                                    a2.n();
                                                }
                                                i = i2 + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        } finally {
                        }
                    }
                }
            }.start();
        }
    }

    public void clearMusicCache() {
        synchronized (this) {
            com.tencent.txcopyrightedmedia.impl.utils.b bVar = (com.tencent.txcopyrightedmedia.impl.utils.b) m.a().b(m.f26418a);
            if (bVar == null) {
                return;
            }
            bVar.b.b();
            bVar.f26393a.a();
            d.a();
        }
    }

    public void clearMusicCache(String str, String str2) {
        synchronized (this) {
            com.tencent.txcopyrightedmedia.impl.utils.b bVar = (com.tencent.txcopyrightedmedia.impl.utils.b) m.a().b(m.f26418a);
            if (bVar == null) {
                return;
            }
            String b2 = new j(str2).b();
            bVar.b.b(str, b2);
            bVar.f26393a.b(str, b2);
            d.a(str);
        }
    }

    public ITXCMMusicTrack createMusicTrack(TXCMMusicInfo tXCMMusicInfo) {
        synchronized (this) {
            if (this.b == null || !this.f26327c || tXCMMusicInfo == null) {
                return null;
            }
            com.tencent.txcopyrightedmedia.b.a(tXCMMusicInfo, new TXCMMusicExtParams(com.tencent.txcopyrightedmedia.b.b(tXCMMusicInfo)).toString());
            return n.a(tXCMMusicInfo);
        }
    }

    public ITXSongScore createSongScore(TXSongScoreConfig tXSongScoreConfig) {
        synchronized (this) {
            if (this.b != null && this.f26327c) {
                return new y(tXSongScoreConfig);
            }
            return null;
        }
    }

    public void destroy() {
        synchronized (this) {
            this.f26327c = false;
            m a2 = m.a();
            synchronized (m.class) {
                if (a2.e != null) {
                    a2.e.c();
                }
                if (a2.i != null) {
                    o oVar = a2.i;
                    synchronized (o.class) {
                        if (oVar.f26438a != null) {
                            oVar.f26438a.shutdown();
                            oVar.f26438a = null;
                        }
                        if (oVar.b != null) {
                            oVar.b.shutdown();
                            oVar.b = null;
                        }
                        oVar.f26439c = false;
                    }
                    a2.i = null;
                }
                if (a2.h != null) {
                    a2.h.a().b.sendEmptyMessage(101);
                    a2.h = null;
                }
                a2.g.f26409a.clear();
                if (a2.j != null) {
                    ai aiVar = a2.j;
                    aiVar.b.removeCallbacksAndMessages(null);
                    aiVar.f26363a.quit();
                }
            }
            cancelPreloadMusic(null, null);
            k.b();
            ah.a().f26357a = true;
            ab.a();
        }
    }

    public int getAppID() {
        synchronized (this) {
            if (this.b == null) {
                return -1;
            }
            if (ap.a().b == -1) {
                ap.a().a(this.b);
            }
            return ap.a().b;
        }
    }

    public Context getApplicationContext() {
        Context context;
        synchronized (this) {
            context = this.b;
        }
        return context;
    }

    public void init() {
        synchronized (this) {
            if (!this.f26327c && this.b != null) {
                k.a();
                m a2 = m.a();
                synchronized (m.class) {
                    a2.h = new com.tencent.txcopyrightedmedia.impl.utils.b(instance().getApplicationContext());
                    if (a2.f != null) {
                        a2.f.f26417a = a2.h;
                    }
                    a2.e.h();
                    a2.i = new o();
                    a2.j = new ai();
                }
                this.f26327c = true;
            }
        }
    }

    public boolean isMusicPreloaded(String str, String str2) {
        synchronized (this) {
            com.tencent.txcopyrightedmedia.impl.utils.b bVar = (com.tencent.txcopyrightedmedia.impl.utils.b) m.a().b(m.f26418a);
            if (bVar == null) {
                return false;
            }
            ax a2 = bVar.b.a(str, new j(str2).b());
            if (a2 != null) {
                return a2.e == 100;
            }
            return false;
        }
    }

    public void preloadMusic(String str, String str2, String str3, ITXMusicPreloadCallback iTXMusicPreloadCallback) {
        synchronized (this) {
            j jVar = new j(str2);
            String b2 = jVar.b();
            p pVar = new p(iTXMusicPreloadCallback);
            if (this.b == null) {
                pVar.onPreloadComplete(str, b2, -1, "License not set.");
            } else if (!this.f26327c) {
                pVar.onPreloadComplete(str, b2, -1, "SDK not init.");
            } else {
                bd bdVar = new bd(str, b2);
                bdVar.d();
                ay ayVar = new ay();
                int a2 = ap.a().a(this.b);
                if (a2 != 0) {
                    pVar.onPreloadComplete(str, b2, -8, "License fail. ".concat(String.valueOf(a2)));
                    ah a3 = ah.a();
                    bdVar.p = -8;
                    a3.a(bdVar.a("License fail. ".concat(String.valueOf(a2))));
                    return;
                }
                i iVar = new i(0, null);
                ayVar.f26390c = str3;
                if (iVar.code != 0) {
                    pVar.onPreloadComplete(str, b2, iVar.code, iVar.msg);
                    ah a4 = ah.a();
                    bdVar.p = -3;
                    a4.a(bdVar.a(iVar.msg));
                    return;
                }
                ayVar.f26389a = str;
                ayVar.d = jVar.a();
                if (isMusicPreloaded(str, b2)) {
                    i iVar2 = new i(0, null);
                    pVar.onPreloadStart(str, b2);
                    pVar.onPreloadComplete(str, b2, iVar2.code, iVar2.msg);
                    return;
                }
                ab.a a5 = ab.a(new b(ayVar, pVar, this.f26326a));
                if (a5 instanceof b) {
                    b bVar = (b) a5;
                    synchronized (bVar.f) {
                        if (bVar.d.contains(pVar)) {
                            return;
                        }
                        pVar.onPreloadStart(bVar.b, bVar.f26332c);
                        if (bVar.g != null) {
                            pVar.onPreloadComplete(bVar.b, bVar.f26332c, bVar.g.code, bVar.g.msg);
                        } else {
                            bVar.d.add(pVar);
                        }
                    }
                }
            }
        }
    }

    public void setExtInfo(String str, String str2) {
        synchronized (this) {
            m.a().a(str, str2);
        }
    }

    public void setLicense(Context context, String str, String str2) {
        synchronized (this) {
            Context context2 = context;
            if (context == null) {
                try {
                    Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
                    context2 = (Context) cls.getDeclaredField("currentActivity").get(cls);
                } catch (Exception e) {
                    new StringBuilder("callUnity: e=").append(e);
                    context2 = context;
                }
            }
            if (context2 == null) {
                return;
            }
            this.b = context2.getApplicationContext();
            k.a();
            ap a2 = ap.a();
            Context context3 = this.b;
            if (context3 != null) {
                a2.f26368a = context3.getApplicationContext();
            }
            a2.e.d = str2;
            a2.e.e = str;
            if (a2.f26368a != null) {
                a2.e.f26374c = a2.b();
                if (!ak.a(a2.e.f26374c + File.separator + a2.e.f26373a)) {
                    a2.a(a2.e, "");
                }
                a2.a(a2.e);
            }
        }
    }

    public void setMusicCacheMaxCount(int i) {
        synchronized (this) {
            com.tencent.txcopyrightedmedia.impl.utils.b bVar = (com.tencent.txcopyrightedmedia.impl.utils.b) m.a().b(m.f26418a);
            if (bVar == null) {
                return;
            }
            SharedPreferences.Editor edit = bVar.d.f26408a.edit();
            edit.putInt("MAX_CACHE_ITEM_COUNT", i);
            edit.apply();
        }
    }
}
