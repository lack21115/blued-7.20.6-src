package com.tencent.thumbplayer.c;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.MessageConstant;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.b.l;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.f;
import com.tencent.thumbplayer.utils.i;
import com.tencent.thumbplayer.utils.m;
import com.umeng.analytics.pro.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e.class */
public class e implements com.tencent.thumbplayer.c.a, f.a, i.b {
    private static int g = -1;

    /* renamed from: a  reason: collision with root package name */
    private Context f39249a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private ITPDownloadProxy f39250c;
    private b e;
    private ITPPlayListener f;
    private ArrayList<TPDownloadParamData> i;
    private String j;
    private int k;
    private TPVideoInfo l;
    private String m;
    private LinkedList<c> o;
    private HashMap<String, Integer> p;
    private long q;
    private long r;
    private m y;
    private int d = 0;
    private int h = g;
    private ITPPlayerProxyListener n = null;
    private boolean s = false;
    private boolean t = true;
    private boolean u = false;
    private boolean v = false;
    private long w = 100000000;
    private boolean x = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (e.this.f == null) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "handleMessage failed, mPlayListener is null and return");
                return;
            }
            int i = message.what;
            if (i == 4196) {
                e.this.g(message.arg1);
            } else if (i == 4197) {
                e.this.h(message.arg1);
            } else {
                switch (i) {
                    case 4097:
                        e.this.f.onDownloadFinish();
                        return;
                    case 4098:
                        e.this.f.onDownloadError(message.arg1, message.arg2, (String) message.obj);
                        return;
                    case 4099:
                        e.this.f.onDownloadCdnUrlUpdate((String) message.obj);
                        return;
                    case 4100:
                        TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = (TPPlayerMsg.TPCDNURLInfo) message.obj;
                        e.this.f.onDownloadCdnUrlInfoUpdate(tPCDNURLInfo.url, tPCDNURLInfo.cdnIp, tPCDNURLInfo.uIp, tPCDNURLInfo.errorStr);
                        return;
                    case 4101:
                        e.this.f.onDownloadStatusUpdate(message.arg1);
                        return;
                    case 4102:
                        TPPlayerMsg.TPProtocolInfo tPProtocolInfo = (TPPlayerMsg.TPProtocolInfo) message.obj;
                        e.this.f.onDownloadProtocolUpdate(tPProtocolInfo.protocolName, tPProtocolInfo.protocolVersion);
                        return;
                    case 4103:
                        e.this.f.onDownloadCdnUrlExpired((Map) message.obj);
                        return;
                    case o.a.h /* 4104 */:
                        C1016e c1016e = (C1016e) message.obj;
                        f fVar = (f) c1016e.f39255a;
                        c1016e.b.a(e.this.f.onPlayCallback(fVar.f39256a, fVar.b, fVar.f39257c, fVar.d, fVar.e));
                        return;
                    case 4105:
                        C1016e c1016e2 = (C1016e) message.obj;
                        c1016e2.b.a(e.this.f.getPlayInfo(((Long) c1016e2.f39255a).longValue()));
                        return;
                    case 4106:
                        TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = (TPPlayerMsg.TPDownLoadProgressInfo) message.obj;
                        e.this.f.onDownloadProgressUpdate((int) tPDownLoadProgressInfo.playableDurationMS, tPDownLoadProgressInfo.downloadSpeedKBps, tPDownLoadProgressInfo.currentDownloadSize, tPDownLoadProgressInfo.totalFileSize, tPDownLoadProgressInfo.extraInfo);
                        return;
                    case 4107:
                        C1016e c1016e3 = (C1016e) message.obj;
                        c1016e3.b.a(e.this.f.getPlayInfo((String) c1016e3.f39255a));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e$b.class */
    public class b implements ITPPlayListener {
        private b() {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getAdvRemainTime() {
            return e.this.f.getAdvRemainTime();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public String getContentType(int i, String str) {
            return e.this.f.getContentType(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int getCurrentPlayClipNo() {
            return e.this.f.getCurrentPlayClipNo();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getCurrentPlayOffset() {
            return e.this.f.getCurrentPlayOffset();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getCurrentPosition() {
            return e.this.f.getCurrentPosition();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public String getDataFilePath(int i, String str) {
            return e.this.f.getDataFilePath(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getDataTotalSize(int i, String str) {
            return e.this.f.getDataTotalSize(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object getPlayInfo(long j) {
            com.tencent.thumbplayer.utils.e eVar = new com.tencent.thumbplayer.utils.e();
            C1016e c1016e = new C1016e();
            c1016e.f39255a = Long.valueOf(j);
            c1016e.b = eVar;
            e.this.a(4105, c1016e);
            return e.this.a(eVar);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object getPlayInfo(String str) {
            com.tencent.thumbplayer.utils.e eVar = new com.tencent.thumbplayer.utils.e();
            C1016e c1016e = new C1016e();
            c1016e.f39255a = str;
            c1016e.b = eVar;
            e.this.a(4107, c1016e);
            return e.this.a(eVar);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getPlayerBufferLength() {
            return e.this.f.getPlayerBufferLength();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlExpired(Map<String, String> map) {
            e.this.a(4103, map);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
            tPCDNURLInfo.url = str;
            tPCDNURLInfo.cdnIp = str2;
            tPCDNURLInfo.uIp = str3;
            tPCDNURLInfo.errorStr = str4;
            e.this.a(4100, tPCDNURLInfo);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlUpdate(String str) {
            e.this.a(4099, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadError(int i, int i2, String str) {
            e.this.a(4098, i, i2, str, false, false, 0L);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadFinish() {
            e.this.a(4097, (Object) null);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str) {
            TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
            tPDownLoadProgressInfo.playableDurationMS = i;
            tPDownLoadProgressInfo.downloadSpeedKBps = i2;
            tPDownLoadProgressInfo.currentDownloadSize = j;
            tPDownLoadProgressInfo.totalFileSize = j2;
            tPDownLoadProgressInfo.extraInfo = str;
            e.this.a(4106, tPDownLoadProgressInfo);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadProtocolUpdate(String str, String str2) {
            TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
            tPProtocolInfo.protocolVersion = str2;
            tPProtocolInfo.protocolName = str;
            e.this.a(4102, tPProtocolInfo);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadStatusUpdate(int i) {
            e.this.a(4101, i, 0, null, false, false, 0L);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object onPlayCallback(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            f fVar = new f();
            fVar.f39256a = i;
            fVar.b = obj;
            fVar.f39257c = obj2;
            fVar.d = obj3;
            fVar.e = obj4;
            com.tencent.thumbplayer.utils.e eVar = new com.tencent.thumbplayer.utils.e();
            C1016e c1016e = new C1016e();
            c1016e.f39255a = fVar;
            c1016e.b = eVar;
            e.this.a((int) o.a.h, c1016e);
            return e.this.a(eVar);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onReadData(int i, String str, long j, long j2) {
            return e.this.f.onReadData(i, str, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onStartReadData(int i, String str, long j, long j2) {
            return e.this.f.onStartReadData(i, str, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onStopReadData(int i, String str, int i2) {
            return e.this.f.onStopReadData(i, str, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        long f39253a;
        int b;

        c(long j, int i) {
            this.f39253a = j;
            this.b = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f39254a;
        int b;

        d(int i, int i2) {
            this.f39254a = i;
            this.b = i2;
        }
    }

    /* renamed from: com.tencent.thumbplayer.c.e$e  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e$e.class */
    static class C1016e {

        /* renamed from: a  reason: collision with root package name */
        Object f39255a;
        com.tencent.thumbplayer.utils.e b;

        private C1016e() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/c/e$f.class */
    static class f {

        /* renamed from: a  reason: collision with root package name */
        int f39256a;
        Object b;

        /* renamed from: c  reason: collision with root package name */
        Object f39257c;
        Object d;
        Object e;

        private f() {
        }
    }

    public e(Context context, Looper looper) {
        this.f39249a = context;
        this.b = new a(looper);
        com.tencent.thumbplayer.utils.f.a(this);
        com.tencent.thumbplayer.utils.i.a().a(this);
        this.e = new b();
        this.f = new com.tencent.thumbplayer.c.f("TPThumbPlayer[TPPlayManagerImpl.java]");
        this.p = new HashMap<>();
        this.i = new ArrayList<>();
        this.y = new m();
    }

    private int a(List<ITPMediaTrackClip> list, String str, ArrayList<TPDownloadParamData> arrayList) {
        int i;
        int i2;
        if (com.tencent.thumbplayer.utils.b.a(list)) {
            TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "clipList is empty, return");
            return -1;
        }
        int size = list.size();
        HashMap hashMap = new HashMap();
        int i3 = 0;
        int i4 = 1;
        while (true) {
            int i5 = i4;
            if (i3 >= size) {
                break;
            }
            ITPMediaTrackClip iTPMediaTrackClip = list.get(i3);
            int i6 = i5;
            if (iTPMediaTrackClip instanceof com.tencent.thumbplayer.b.h) {
                i6 = i5;
                if (com.tencent.thumbplayer.utils.b.b(((com.tencent.thumbplayer.b.h) iTPMediaTrackClip).getFilePath())) {
                    hashMap.put(iTPMediaTrackClip, new d(i5, i3));
                    i6 = i5 + 1;
                }
            }
            i3++;
            i4 = i6;
        }
        if (com.tencent.thumbplayer.utils.b.a(hashMap)) {
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "all urls is local file url, return");
            return -1;
        }
        try {
            i = this.f39250c.startClipPlay(str, hashMap.size(), this.e);
        } catch (Throwable th) {
            th = th;
            i = -1;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            i2 = i;
            return i2;
        }
        if (i <= 0) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start clip play failed, cause : playId < 0");
            return i;
        }
        Iterator it = hashMap.entrySet().iterator();
        while (true) {
            i2 = i;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            ITPMediaTrackClip iTPMediaTrackClip2 = (ITPMediaTrackClip) entry.getKey();
            d dVar = (d) entry.getValue();
            if (iTPMediaTrackClip2 instanceof com.tencent.thumbplayer.b.h) {
                com.tencent.thumbplayer.b.h hVar = (com.tencent.thumbplayer.b.h) iTPMediaTrackClip2;
                TPDownloadParamData a2 = a(arrayList, dVar.b);
                if (a2 == null) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "fatal err, paramData is null.");
                    return -1;
                }
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "multi trackClipIndex:" + dVar.b + ", download seq:" + dVar.f39254a + ", clip.url:" + hVar.getUrl() + ", clip.getFilePath:" + hVar.getFilePath() + ", paramData.savePath:" + a2.getSavePath() + ", paramData.DownloadFileID:" + a2.getDownloadFileID());
                if (this.f39250c.setClipInfo(i, dVar.f39254a, a2.getDownloadFileID(), a(hVar.getFilePath(), a2, (Map<String, String>) null))) {
                    hVar.a(this.f39250c.getClipPlayUrl(i, dVar.f39254a, 1));
                }
            }
        }
        return i2;
    }

    private com.tencent.thumbplayer.adapter.a.e a(long j, String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map) {
        com.tencent.thumbplayer.adapter.a.e eVar = new com.tencent.thumbplayer.adapter.a.e(str);
        if (com.tencent.thumbplayer.utils.b.b(str) && !o()) {
            if (this.o == null) {
                this.o = new LinkedList<>();
            }
            String str2 = null;
            TPDownloadParam a2 = tPDownloadParamData != null ? a(str, tPDownloadParamData, map) : null;
            if (tPDownloadParamData != null) {
                try {
                    str2 = tPDownloadParamData.getDownloadFileID();
                } catch (Throwable th) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy switch def failed");
                    return eVar;
                }
            }
            int startPlay = this.f39250c.startPlay(str2, a2, this.e);
            if (startPlay <= 0) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def failed, cause : playId <= 0");
                return eVar;
            }
            String playUrl = this.f39250c.getPlayUrl(startPlay, 1);
            String str3 = playUrl;
            if (TextUtils.isEmpty(playUrl)) {
                str3 = str;
            }
            eVar.b(str3);
            String playUrl2 = this.f39250c.getPlayUrl(startPlay, 0);
            if (!TextUtils.isEmpty(playUrl2)) {
                str = playUrl2;
            }
            eVar.a(str);
            this.o.offer(new c(j, startPlay));
            TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + j + ",playId:" + startPlay);
            return eVar;
        }
        return eVar;
    }

    private ITPMediaAsset a(ITPMediaDRMAsset iTPMediaDRMAsset, long j, TPVideoInfo tPVideoInfo) {
        iTPMediaDRMAsset.setDrmPlayUrl(a(j, iTPMediaDRMAsset.getDrmPlayUrl(), (tPVideoInfo.getDownloadPraramList() == null || tPVideoInfo.getDownloadPraramList().size() <= 0) ? null : tPVideoInfo.getDownloadPraramList().get(0), (Map<String, String>) null).b());
        return iTPMediaDRMAsset;
    }

    private ITPMediaAsset a(com.tencent.thumbplayer.b.j jVar) {
        jVar.setDrmPlayUrl(a(jVar.getDrmPlayUrl(), (Map<String, String>) null).b());
        return jVar;
    }

    private ITPMediaAsset a(l lVar) {
        lVar.setStreamUrl(a(lVar.getStreamUrl(), (Map<String, String>) null).b());
        return lVar;
    }

    private ITPMediaAsset a(l lVar, long j, TPVideoInfo tPVideoInfo) {
        lVar.setStreamUrl(a(j, lVar.getStreamUrl(), tPVideoInfo, (Map<String, String>) null).b());
        return lVar;
    }

    private TPDownloadParamData a(ArrayList<TPDownloadParamData> arrayList, int i) {
        if (com.tencent.thumbplayer.utils.b.a(arrayList) || i >= arrayList.size()) {
            return null;
        }
        return arrayList.get(i);
    }

    private TPDownloadParam a(String str, TPDownloadParamData tPDownloadParamData, Map<String, String> map) {
        return k.a(str, tPDownloadParamData, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(com.tencent.thumbplayer.utils.e eVar) {
        try {
            return eVar.a(500L);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "onPlayCallback getResult has exception:" + th.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, Object obj, boolean z, boolean z2, long j) {
        StringBuilder sb;
        String str;
        this.y.readLock().lock();
        if (this.b == null) {
            sb = new StringBuilder();
            sb.append(f(i));
            str = " , send failed , handler null";
        } else if (!z || obj != null) {
            if (z2) {
                this.b.removeMessages(i);
            }
            Message obtainMessage = this.b.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            obtainMessage.obj = obj;
            this.b.sendMessageDelayed(obtainMessage, j);
            this.y.readLock().unlock();
        } else {
            sb = new StringBuilder();
            sb.append(f(i));
            str = ", send failed , params null";
        }
        sb.append(str);
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", sb.toString());
        this.y.readLock().unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Object obj) {
        a(i, 0, 0, obj, false, false, 0L);
    }

    private ITPMediaAsset b(ITPMediaAsset iTPMediaAsset) {
        List<ITPMediaTrackClip> c2 = c(iTPMediaAsset);
        if (!com.tencent.thumbplayer.utils.b.a(c2)) {
            this.k = a(c2, p(), this.i);
            l();
            m();
        }
        return iTPMediaAsset;
    }

    private ITPMediaAsset b(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo) {
        List<ITPMediaTrackClip> c2 = c(iTPMediaAsset);
        if (!com.tencent.thumbplayer.utils.b.a(c2) && tPVideoInfo != null) {
            int a2 = a(c2, tPVideoInfo.getProxyFileID(), tPVideoInfo.getDownloadPraramList());
            if (a2 > 0) {
                this.o.offer(new c(j, a2));
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch def sucess, defId:" + j + ",playId:" + a2);
                return iTPMediaAsset;
            }
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy switch clip def failed, cause : playId < 0");
        }
        return iTPMediaAsset;
    }

    private void b(TPVideoInfo tPVideoInfo) {
        String str;
        if (o()) {
            return;
        }
        this.l = tPVideoInfo;
        if (tPVideoInfo == null || tPVideoInfo.getDownloadPraramList() == null) {
            str = "video or downloadParamList is null, return";
        } else if (this.k <= 0) {
            str = "p2p proxy not start, return";
        } else {
            try {
                ArrayList<TPDownloadParamData> downloadPraramList = tPVideoInfo.getDownloadPraramList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= downloadPraramList.size()) {
                        return;
                    }
                    TPDownloadParamData tPDownloadParamData = downloadPraramList.get(i2);
                    if (!this.f39250c.setClipInfo(this.k, tPDownloadParamData.getClipNo(), tPDownloadParamData.getDownloadFileID(), a(tPDownloadParamData.getUrl(), tPDownloadParamData, (Map<String, String>) null))) {
                        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", "setClipInfo failed, playID:" + this.k + ", clipNo:" + tPDownloadParamData.getClipNo() + ", downloadFileID:" + tPDownloadParamData.getDownloadFileID());
                    }
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
                return;
            }
        }
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", str);
    }

    private boolean b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.DLPARAM_DATA_TRANSFER_MODE, 1);
        try {
            return this.f39250c.setClipInfo(this.k, 2, str2, new TPDownloadParam(arrayList, 3, hashMap));
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            return false;
        }
    }

    private List<ITPMediaTrackClip> c(ITPMediaAsset iTPMediaAsset) {
        ITPMediaTrack iTPMediaTrack;
        if (iTPMediaAsset instanceof com.tencent.thumbplayer.b.e) {
            List<ITPMediaTrack> allAVTracks = ((com.tencent.thumbplayer.b.e) iTPMediaAsset).getAllAVTracks();
            if (com.tencent.thumbplayer.utils.b.a(allAVTracks) || (iTPMediaTrack = allAVTracks.get(0)) == null || com.tencent.thumbplayer.utils.b.a(iTPMediaTrack.getAllTrackClips())) {
                return null;
            }
            return iTPMediaTrack.getAllTrackClips();
        } else if (iTPMediaAsset instanceof ITPMediaTrack) {
            ITPMediaTrack iTPMediaTrack2 = (ITPMediaTrack) iTPMediaAsset;
            if (com.tencent.thumbplayer.utils.b.a(iTPMediaTrack2.getAllTrackClips())) {
                return null;
            }
            return iTPMediaTrack2.getAllTrackClips();
        } else if (iTPMediaAsset instanceof ITPMediaTrackClip) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add((ITPMediaTrackClip) iTPMediaAsset);
            return arrayList;
        } else {
            return null;
        }
    }

    private void c(int i) {
        try {
            this.f39250c.pauseDownload(i);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy pause download failed, taskId:".concat(String.valueOf(i)));
        }
    }

    private void d(int i) {
        try {
            this.f39250c.resumeDownload(this.k);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy resume download failed, taskId:".concat(String.valueOf(i)));
        }
    }

    private void e(int i) {
        if (o()) {
            return;
        }
        try {
            this.f39250c.stopPlay(i);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy stop play failed, taskID:".concat(String.valueOf(i)));
        }
    }

    private String f(int i) {
        switch (i) {
            case 4097:
                return "onDownloadFinish";
            case 4098:
                return "onDownloadError";
            case 4099:
                return "onDownloadCdnUrlUpdate";
            case 4100:
                return "onDownloadCdnUrlInfoUpdate";
            case 4101:
                return "onDownloadStatusUpdate";
            case 4102:
                return "onDownloadProtocolUpdate";
            case 4103:
                return "onDownloadCdnUrlExpired";
            case o.a.h /* 4104 */:
                return "onPlayCallback";
            case 4105:
            case 4107:
                return "getPlayInfo";
            case 4106:
                return "onDownloadProgressUpdate";
            default:
                return "unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i) {
        switch (i) {
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /* 100001 */:
                b(13);
                return;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND /* 100002 */:
                b(14);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        if (i == 1) {
            b(1);
            b(10);
        } else if (i == 2) {
            b(2);
            b(9);
        } else if (i != 3) {
        } else {
            b(2);
            b(10);
        }
    }

    private boolean k() {
        if (this.h == g) {
            this.h = TPPlayerConfig.getProxyServiceType();
        }
        com.tencent.thumbplayer.c.b a2 = i.a().a(this.h);
        if (a2 == null || a2.a() == null) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "initProxy failed, serviceType:" + this.h + ", playProxyManager:" + a2);
            return false;
        }
        try {
            ITPDownloadProxy a3 = a2.a();
            this.f39250c = a3;
            a3.setUserData(TPDownloadProxyEnum.USER_IS_VIP, Boolean.valueOf(TPPlayerConfig.isUserIsVip()));
            if (!TextUtils.isEmpty(TPPlayerConfig.getUserUin())) {
                this.f39250c.setUserData(TPDownloadProxyEnum.USER_UIN, TPPlayerConfig.getUserUin());
            }
            if (!TextUtils.isEmpty(TPPlayerConfig.getAppVersionName(this.f39249a))) {
                this.f39250c.setUserData("app_version_name", TPPlayerConfig.getAppVersionName(this.f39249a));
            }
            if (TPPlayerConfig.getBuildNumber(this.f39249a) != -1) {
                this.f39250c.setUserData("app_version_code", String.valueOf(TPPlayerConfig.getBuildNumber(this.f39249a)));
            }
            this.f39250c.setUserData(TPDownloadProxyEnum.USER_UPC, TPPlayerConfig.getUserUpc());
            this.f39250c.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(TPPlayerConfig.getUserUpcState()));
            this.f39250c.setUserData(TPDownloadProxyEnum.USER_EXTERNAL_NETWORK_IP, TPPlayerConfig.getOutNetIp());
            this.f39250c.setUserData(TPDownloadProxyEnum.TAB_ABUSERID, TPPlayerConfig.getAbUserId());
            return true;
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            return false;
        }
    }

    private void l() {
        try {
            this.f39250c.setPlayState(this.k, this.t ? 101 : 100);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
        }
    }

    private void m() {
        int i = this.k;
        if (i > 0) {
            this.f39250c.updateTaskInfo(i, TPDownloadProxyEnum.TASKINFO_ADAPTIVE_DYNAMIC_SWITCH, Integer.valueOf((this.u || this.v) ? 1 : 0));
            this.f39250c.updateTaskInfo(this.k, TPDownloadProxyEnum.TASKINFO_MAX_BITRATE, Long.valueOf(this.w));
        }
    }

    private void n() {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "reset");
        this.j = "";
        this.m = "";
        this.l = null;
        this.q = 0L;
        this.r = 0L;
        this.s = false;
        this.t = true;
        this.u = false;
        this.v = false;
        if (!com.tencent.thumbplayer.utils.b.a(this.i)) {
            this.i.clear();
        }
        this.d = 0;
        this.h = g;
        this.f39250c = null;
        this.w = 100000000L;
    }

    private boolean o() {
        if (!TPPlayerConfig.isUseP2P()) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "config set don't use p2p proxy!");
            return true;
        }
        if (this.d == 0) {
            this.d = k() ? 2 : 1;
        }
        return this.d == 1;
    }

    private String p() {
        return this.j;
    }

    private void q() {
        try {
            this.f39250c.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_START_TIME, Long.valueOf(this.q));
            this.f39250c.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Long.valueOf(this.r));
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
        }
    }

    private void r() {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "inner event : release handler");
        this.y.writeLock().lock();
        a aVar = this.b;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
            this.b = null;
        }
        this.y.writeLock().unlock();
    }

    @Override // com.tencent.thumbplayer.c.a
    public com.tencent.thumbplayer.adapter.a.e a(long j, String str, TPVideoInfo tPVideoInfo, Map<String, String> map) {
        if (tPVideoInfo == null) {
            return new com.tencent.thumbplayer.adapter.a.e(str);
        }
        TPDownloadParamData tPDownloadParamData = null;
        if (tPVideoInfo.getDownloadPraramList() != null) {
            tPDownloadParamData = null;
            if (tPVideoInfo.getDownloadPraramList().size() > 0) {
                tPDownloadParamData = tPVideoInfo.getDownloadPraramList().get(0);
            }
        }
        return a(j, str, tPDownloadParamData, map);
    }

    @Override // com.tencent.thumbplayer.c.a
    public com.tencent.thumbplayer.adapter.a.e a(String str, Map<String, String> map) {
        com.tencent.thumbplayer.adapter.a.e eVar = new com.tencent.thumbplayer.adapter.a.e(str);
        if (com.tencent.thumbplayer.utils.b.b(str) && !o()) {
            q();
            this.m = str;
            TPDownloadParamData a2 = a(this.i, 0);
            TPDownloadParamData tPDownloadParamData = a2;
            if (this.x) {
                tPDownloadParamData = a2;
                if (a2 != null) {
                    tPDownloadParamData = a2;
                    if (a2.getDlType() == 1) {
                        tPDownloadParamData = new TPDownloadParamData(11);
                    }
                }
            }
            TPDownloadParam a3 = tPDownloadParamData != null ? a(str, tPDownloadParamData, map) : null;
            try {
                StringBuilder sb = new StringBuilder("single url:");
                sb.append(str);
                sb.append(", paramData.savePath:");
                sb.append(tPDownloadParamData != null ? tPDownloadParamData.getSavePath() : com.igexin.push.core.b.l);
                sb.append(", paramData.DownloadFileID:");
                String str2 = com.igexin.push.core.b.l;
                if (tPDownloadParamData != null) {
                    str2 = tPDownloadParamData.getDownloadFileID();
                }
                sb.append(str2);
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", sb.toString());
                int startPlay = this.f39250c.startPlay(p(), a3, this.e);
                if (startPlay <= 0) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId <= 0");
                    return eVar;
                }
                String playUrl = this.f39250c.getPlayUrl(startPlay, 0);
                String str3 = playUrl;
                if (TextUtils.isEmpty(playUrl)) {
                    str3 = str;
                }
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "startDownloadPlay, playId:".concat(String.valueOf(startPlay)));
                eVar.b(str3);
                String playUrl2 = this.f39250c.getPlayUrl(startPlay, 1);
                if (!TextUtils.isEmpty(playUrl2)) {
                    str = playUrl2;
                }
                eVar.a(str);
                this.k = startPlay;
                l();
                m();
                return eVar;
            } catch (Throwable th) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy start play failed");
                return eVar;
            }
        }
        return eVar;
    }

    @Override // com.tencent.thumbplayer.c.a
    public ITPMediaAsset a(ITPMediaAsset iTPMediaAsset) {
        if (o()) {
            return iTPMediaAsset;
        }
        q();
        return iTPMediaAsset instanceof com.tencent.thumbplayer.b.j ? a((com.tencent.thumbplayer.b.j) iTPMediaAsset) : iTPMediaAsset instanceof l ? a((l) iTPMediaAsset) : b(iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.c.a
    public ITPMediaAsset a(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo) {
        ITPMediaAsset iTPMediaAsset2 = iTPMediaAsset;
        if (!o()) {
            if (iTPMediaAsset == null) {
                return iTPMediaAsset;
            }
            if (this.o == null) {
                this.o = new LinkedList<>();
            }
            if (tPVideoInfo == null) {
                return iTPMediaAsset;
            }
            if (iTPMediaAsset instanceof ITPMediaDRMAsset) {
                return a((ITPMediaDRMAsset) iTPMediaAsset, j, tPVideoInfo);
            }
            if (iTPMediaAsset instanceof l) {
                return a((l) iTPMediaAsset, j, tPVideoInfo);
            }
            iTPMediaAsset2 = b(iTPMediaAsset, j, tPVideoInfo);
        }
        return iTPMediaAsset2;
    }

    /* JADX WARN: Not initialized variable reg: 12, insn: 0x011d: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:56:0x010e */
    @Override // com.tencent.thumbplayer.c.a
    public String a(int i, String str, TPDownloadParamData tPDownloadParamData) {
        String str2;
        TPDownloadParam tPDownloadParam;
        String a2;
        int i2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "return coz url is empty";
        } else if (!com.tencent.thumbplayer.utils.b.b(str)) {
            str3 = "return coz url is locol url, not need use proxy";
        } else if (!o()) {
            try {
                if (tPDownloadParamData != null) {
                    tPDownloadParam = k.a(str, tPDownloadParamData, null);
                    i2 = tPDownloadParamData.getTaskType() == 1 ? 2 : 1;
                    String downloadFileID = tPDownloadParamData.getDownloadFileID();
                    a2 = downloadFileID;
                    if (TextUtils.isEmpty(downloadFileID)) {
                        a2 = com.tencent.thumbplayer.utils.b.a(str);
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    int i3 = 0;
                    if (i == 2) {
                        i3 = 3;
                    }
                    tPDownloadParam = new TPDownloadParam(arrayList, i3, null);
                    a2 = com.tencent.thumbplayer.utils.b.a(str);
                    i2 = 1;
                }
                int startPlay = this.f39250c.startPlay(a2, tPDownloadParam, this.e);
                if (startPlay <= 0) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed, cause : playId <= 0");
                    return str;
                }
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play, url type".concat(String.valueOf(i2)));
                String playUrl = this.f39250c.getPlayUrl(startPlay, i2);
                this.p.put(playUrl, Integer.valueOf(startPlay));
                return playUrl;
            } catch (Throwable th) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "p2p proxy start play failed:".concat(String.valueOf(th)));
                return str2;
            }
        } else {
            str3 = "return coz download proxy init failed";
        }
        TPLogUtil.w("TPThumbPlayer[TPPlayManagerImpl.java]", str3);
        return str;
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(float f2) {
        if (o()) {
            return;
        }
        if (f2 <= 0.0f) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "set play speed ratio, value invalid:".concat(String.valueOf(f2)));
            return;
        }
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "set play speed value to proxy:".concat(String.valueOf(f2)));
        this.f39250c.updateTaskInfo(this.k, TPDownloadProxyEnum.TASKINFO_SPEED_RATIO, Float.valueOf(f2));
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(int i) {
        TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState: ".concat(String.valueOf(i)));
        if (o()) {
            return;
        }
        try {
            this.f39250c.setPlayState(this.k, i);
            if ((i == 5 || i == 0) && !com.tencent.thumbplayer.utils.b.a(this.o)) {
                Iterator<c> it = this.o.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next != null) {
                        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setProxyPlayState definitionID:" + next.f39253a + ", taskID:" + next.b + ", state:" + i);
                        this.f39250c.setPlayState(next.b, i);
                    }
                }
            }
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
        }
    }

    @Override // com.tencent.thumbplayer.utils.i.b
    public void a(int i, int i2, int i3, int i4) {
        TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "onNetworkStatusChanged oldNetStatus: " + i + ", netStatus: " + i2);
        a(4197, i2, 0, null, false, false, 0L);
    }

    @Override // com.tencent.thumbplayer.utils.f.a
    public void a(int i, int i2, int i3, Object obj) {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "onEvent eventId: " + i + ", arg1: " + i2 + ", arg2: " + i3 + ", object" + obj);
        a(MessageConstant.MessageType.MESSAGE_STAT, i, 0, null, false, false, 0L);
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(long j) {
        c cVar;
        if (o()) {
            return;
        }
        try {
            if (com.tencent.thumbplayer.utils.b.a(this.o)) {
                return;
            }
            c peek = this.o.peek();
            while (true) {
                cVar = peek;
                if (cVar == null || cVar.f39253a == j) {
                    break;
                }
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy definitionID:" + cVar.f39253a + ", taskID:" + cVar.b);
                e(cVar.b);
                this.o.removeFirst();
                peek = this.o.peek();
            }
            if (cVar != null) {
                TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stop proxy task id:" + cVar.b);
                e(this.k);
                this.k = cVar.b;
                l();
                m();
                this.o.remove(cVar);
            }
        } catch (Exception e) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", e, "playerSwitchDefComplete exception");
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(TPOptionalParam tPOptionalParam) {
        if (o() || tPOptionalParam == null) {
            return;
        }
        if (tPOptionalParam.getKey() == 100) {
            this.q = tPOptionalParam.getParamLong().value;
        } else if (tPOptionalParam.getKey() == 500) {
            try {
                long j = tPOptionalParam.getParamLong().value;
                this.r = j;
                if (this.k > 0) {
                    this.f39250c.setUserData(TPDownloadProxyEnum.DLPARAM_PLAY_END_TIME, Long.valueOf(j));
                }
            } catch (Throwable th) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            }
        } else if (tPOptionalParam.getKey() == 503) {
            this.w = tPOptionalParam.getParamLong().param1;
            m();
        } else if (tPOptionalParam.getKey() == 508) {
            this.u = tPOptionalParam.getParamBoolean().value;
            m();
        } else if (tPOptionalParam.getKey() == 504) {
            this.v = tPOptionalParam.getParamLong().value != 0;
            m();
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(TPVideoInfo tPVideoInfo) {
        if (tPVideoInfo == null) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, param is null ");
            return;
        }
        if (this.l != null) {
            b(tPVideoInfo);
        }
        this.l = tPVideoInfo;
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "setVideoInfo, enter");
        this.j = tPVideoInfo.getProxyFileID();
        if (!com.tencent.thumbplayer.utils.b.a(this.i)) {
            this.i.clear();
        }
        if (tPVideoInfo.getDownloadPraramList() == null || tPVideoInfo.getDownloadPraramList().size() <= 0) {
            return;
        }
        this.i.addAll(tPVideoInfo.getDownloadPraramList());
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(ITPPlayListener iTPPlayListener) {
        if (iTPPlayListener == null) {
            this.f = new com.tencent.thumbplayer.c.f("TPThumbPlayer[TPPlayManagerImpl.java]");
        } else {
            this.f = iTPPlayListener;
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(String str, Object obj) {
        ITPDownloadProxy iTPDownloadProxy = this.f39250c;
        if (iTPDownloadProxy != null) {
            iTPDownloadProxy.updateTaskInfo(this.k, str, obj);
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(String str, String str2) {
        if (!com.tencent.thumbplayer.utils.b.b(str) || TextUtils.isEmpty(str2)) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, audioTrackUrl:" + str + ", keyId:" + str2);
        } else if (o()) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, download proxy init failed.");
        } else {
            if (this.s) {
                int i = this.k;
                if (i > 0) {
                    e(i);
                }
                this.k = 0;
                a(this.m, (Map<String, String>) null);
                if (!b(str, str2)) {
                    TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, addAudioTrack err.");
                    return;
                }
            } else if (!b(str, str2)) {
                TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "startRemuxer, addAudioTrack err.");
                return;
            }
            this.s = true;
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void a(boolean z) {
        this.x = z;
    }

    @Override // com.tencent.thumbplayer.c.a
    public boolean a() {
        return this.x;
    }

    @Override // com.tencent.thumbplayer.c.a
    public void b() {
        if (o()) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", "stopRemuxer, download proxy init failed.");
            return;
        }
        if (this.s) {
            int i = this.k;
            if (i > 0) {
                e(i);
            }
            this.k = 0;
            a(this.m, (Map<String, String>) null);
        }
        this.s = false;
    }

    public void b(int i) {
        if (o()) {
            return;
        }
        try {
            this.f39250c.pushEvent(i);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th, "p2p proxy pushEvent failed, event:".concat(String.valueOf(i)));
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public boolean c() {
        LinkedList<c> linkedList;
        return (o() || (linkedList = this.o) == null || linkedList.size() <= 0) ? false : true;
    }

    @Override // com.tencent.thumbplayer.c.a
    public void d() {
        TPLogUtil.i("TPThumbPlayer[TPPlayManagerImpl.java]", "stopDownload, playId:" + this.k);
        int i = this.k;
        if (i > 0) {
            e(i);
        }
        this.k = 0;
        if (!com.tencent.thumbplayer.utils.b.a(this.o)) {
            Iterator<c> it = this.o.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    e(next.b);
                }
            }
            this.o.clear();
        }
        if (!com.tencent.thumbplayer.utils.b.a(this.p)) {
            for (Integer num : this.p.values()) {
                e(num.intValue());
            }
            this.p.clear();
        }
        n();
    }

    @Override // com.tencent.thumbplayer.c.a
    public void e() {
        d();
        com.tencent.thumbplayer.utils.i.a().b(this);
        com.tencent.thumbplayer.utils.f.b(this);
        r();
        this.n = null;
        this.f = new com.tencent.thumbplayer.c.f("TPThumbPlayer[TPPlayManagerImpl.java]");
        this.e = null;
        this.f39250c = null;
    }

    @Override // com.tencent.thumbplayer.c.a
    public boolean f() {
        return !o();
    }

    @Override // com.tencent.thumbplayer.c.a
    public String g() {
        if (o()) {
            return null;
        }
        try {
            return this.f39250c.getPlayErrorCodeStr(this.k);
        } catch (Throwable th) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", th);
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void h() {
        if (o()) {
            return;
        }
        c(this.k);
        if (!com.tencent.thumbplayer.utils.b.a(this.o)) {
            Iterator<c> it = this.o.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    c(next.b);
                }
            }
        }
        if (com.tencent.thumbplayer.utils.b.a(this.p)) {
            return;
        }
        for (Integer num : this.p.values()) {
            c(num.intValue());
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public void i() {
        if (o()) {
            return;
        }
        d(this.k);
        if (!com.tencent.thumbplayer.utils.b.a(this.o)) {
            Iterator<c> it = this.o.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null) {
                    d(next.b);
                }
            }
        }
        if (com.tencent.thumbplayer.utils.b.a(this.p)) {
            return;
        }
        for (Integer num : this.p.values()) {
            d(num.intValue());
        }
    }

    @Override // com.tencent.thumbplayer.c.a
    public ITPPlayerProxyListener j() {
        return this.n;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public void pushEvent(int i) {
        if (o()) {
            return;
        }
        try {
            b(h.b(i));
        } catch (IllegalArgumentException e) {
            TPLogUtil.e("TPThumbPlayer[TPPlayManagerImpl.java]", e);
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public void setIsActive(boolean z) {
        TPLogUtil.d("TPThumbPlayer[TPPlayManagerImpl.java]", "setIsActive: ".concat(String.valueOf(z)));
        this.t = z;
        if (o()) {
            return;
        }
        l();
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public void setProxyServiceType(int i) {
        this.h = i;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPlayerProxy
    public void setTPPlayerProxyListener(ITPPlayerProxyListener iTPPlayerProxyListener) {
        this.n = iTPPlayerProxyListener;
    }
}
