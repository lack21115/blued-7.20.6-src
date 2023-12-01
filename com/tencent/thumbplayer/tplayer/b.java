package com.tencent.thumbplayer.tplayer;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.android.internal.telephony.PhoneConstants;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.reportv2.ITPExtendReportController;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.d.b;
import com.tencent.thumbplayer.tplayer.a.g;
import com.tencent.thumbplayer.tplayer.e;
import com.tencent.thumbplayer.utils.j;
import com.tencent.thumbplayer.utils.n;
import com.tencent.thumbplayer.utils.o;
import com.tencent.thumbplayer.utils.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/b.class */
public class b implements ITPPlayer {
    private static final SparseIntArray C;

    /* renamed from: a  reason: collision with root package name */
    private static String f39400a = "api call:";
    private static AtomicInteger u = new AtomicInteger(1000);
    private int A;
    private int B;
    private final com.tencent.thumbplayer.adapter.a b;

    /* renamed from: c  reason: collision with root package name */
    private c f39401c;
    private com.tencent.thumbplayer.c.a d;
    private com.tencent.thumbplayer.tplayer.plugins.report.b e;
    private com.tencent.thumbplayer.c.a.a f;
    private com.tencent.thumbplayer.tplayer.plugins.b g;
    private HandlerThread h;
    private Looper i;
    private a j;
    private com.tencent.thumbplayer.tplayer.a k;
    private String l;
    private boolean m;
    private boolean n;
    private int o;
    private ArrayList<String> p;
    private long q;
    private long r;
    private long s;
    private com.tencent.thumbplayer.e.a t;
    private AtomicInteger v;
    private boolean w;
    private g x;
    private Map<Long, Long> y;
    private long z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/b$a.class */
    public class a extends Handler {
        private b b;

        a(b bVar) {
            this.b = bVar;
        }

        a(b bVar, Looper looper) {
            super(looper);
            this.b = bVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = b.this.f39401c;
            if (cVar == null) {
                return;
            }
            int i = message.what;
            if (i == 257) {
                b.this.t.c("onPrepared");
                b.this.c(1004);
                cVar.onPrepared(this.b);
            } else if (i == 1256) {
                b.this.a(message);
            } else {
                switch (i) {
                    case 260:
                        cVar.onCompletion(this.b);
                        return;
                    case 261:
                        b.this.b(message.arg1);
                        e.a aVar = (e.a) message.obj;
                        if (aVar != null && !b.this.d.c()) {
                            cVar.onInfo(this.b, message.arg1, aVar.f39408a, aVar.b, aVar.f39409c);
                            return;
                        } else if (aVar != null) {
                            cVar.onInfo(this.b, message.arg1, aVar.f39408a, aVar.b, aVar.f39409c);
                            return;
                        } else {
                            return;
                        }
                    case 262:
                        e.a aVar2 = (e.a) message.obj;
                        if (aVar2 != null) {
                            cVar.onError(this.b, message.arg1, message.arg2, aVar2.f39408a, aVar2.b);
                            return;
                        }
                        return;
                    case 263:
                        cVar.onSeekComplete(this.b);
                        return;
                    case 264:
                        e.a aVar3 = (e.a) message.obj;
                        if (aVar3 != null) {
                            cVar.onVideoSizeChanged(this.b, aVar3.f39408a, aVar3.b);
                            return;
                        }
                        return;
                    case 265:
                        cVar.onSubtitleData(this.b, (TPSubtitleData) message.obj);
                        return;
                    case 266:
                        cVar.onVideoFrameOut(this.b, (TPVideoFrameBuffer) message.obj);
                        return;
                    case 267:
                        cVar.onAudioFrameOut(this.b, (TPAudioFrameBuffer) message.obj);
                        return;
                    case 268:
                        cVar.onError(this.b, message.arg1, message.arg2, 0L, 0L);
                        return;
                    case 269:
                        cVar.onInfo(this.b, 1002, message.arg1, message.arg2, message.obj);
                        return;
                    case 270:
                        cVar.onInfo(this.b, 1003, message.arg1, message.arg2, message.obj);
                        return;
                    case 271:
                        cVar.onInfo(this.b, 1001, message.arg1, message.arg2, message.obj);
                        return;
                    case 272:
                        cVar.onInfo(this.b, 1004, message.arg1, message.arg2, message.obj);
                        return;
                    case 273:
                        cVar.onInfo(this.b, 1005, message.arg1, message.arg2, message.obj);
                        return;
                    case 274:
                        cVar.onInfo(this.b, 1006, message.arg1, message.arg2, message.obj);
                        return;
                    case 275:
                        cVar.onInfo(this.b, 1007, message.arg1, message.arg2, message.obj);
                        return;
                    case 276:
                        cVar.onInfo(this.b, 1008, message.arg1, message.arg2, message.obj);
                        return;
                    case 277:
                        cVar.onStateChange(message.arg1, message.arg2);
                        return;
                    case 278:
                        if (b.this.b != null) {
                            try {
                                b.this.b.a(new TPOptionalParam().buildLong(8000, message.arg1));
                            } catch (IllegalStateException e) {
                                b.this.t.a(e);
                            }
                        }
                        if (b.this.n) {
                            cVar.onInfo(this.b, 1010, message.arg1, message.arg2, message.obj);
                            return;
                        }
                        return;
                    case 279:
                        cVar.onSubtitleFrameOut(this.b, (TPSubtitleFrameBuffer) message.obj);
                        return;
                    case 280:
                        cVar.onStopAsyncComplete(this.b);
                        return;
                    case 281:
                        cVar.onInfo(this.b, 1015, message.arg1, message.arg2, message.obj);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.tencent.thumbplayer.tplayer.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/b$b.class */
    class C1026b implements c.a, c.b, c.InterfaceC1013c, c.d, c.e, c.f, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p, ITPPlayListener {
        C1026b() {
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.o
        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            c cVar = b.this.f39401c;
            if (cVar != null) {
                return cVar.onVideoProcessFrameOut(b.this, tPPostProcessFrameBuffer);
            }
            return null;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.d
        public TPRemoteSdpInfo a(String str, int i) {
            c cVar = b.this.f39401c;
            if (cVar != null) {
                return cVar.onSdpExchange(b.this, str, i);
            }
            return null;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.i
        public void a() {
            int i;
            boolean z = true;
            b.this.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 1);
            b.this.d.a(0);
            com.tencent.thumbplayer.adapter.b e = b.this.b.e();
            String str = e.a() + PhoneConstants.APN_TYPE_ALL + e.b();
            TPTrackInfo[] r = b.this.b.r();
            if (r != null) {
                int length = r.length;
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    i = i4;
                    if (i2 >= length) {
                        break;
                    }
                    int i5 = i4;
                    if (r[i2].trackType == 2) {
                        i5 = i4 + 1;
                    }
                    i2++;
                    i3 = i5;
                }
            } else {
                i = 0;
            }
            b bVar = b.this;
            com.tencent.thumbplayer.utils.g a2 = new com.tencent.thumbplayer.utils.g().a("playertype", Integer.valueOf(b.this.b.d())).a("definition", str).a(TextToSpeech.Engine.KEY_PARAM_RATE, Long.valueOf(e.f() / 8000)).a("duration", Long.valueOf(e.j())).a("fmt", e.c()).a("etime", Long.valueOf(System.currentTimeMillis()));
            if (i <= 1) {
                z = false;
            }
            bVar.a(103, 0, 0, (String) null, a2.a("multitrack", Boolean.valueOf(z)).a());
            b.this.a(257, 0, 0, (Object) null);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.f
        public void a(int i, int i2, long j, long j2) {
            String g = b.this.d.g();
            b.this.t.c("onError playerErrorCodeStr=".concat(String.valueOf(g)));
            int i3 = i;
            int i4 = i2;
            if (!TextUtils.isEmpty(g)) {
                try {
                    i4 = Integer.parseInt(g);
                    i3 = 4000;
                } catch (Exception e) {
                    b.this.t.a(e);
                    i4 = i2;
                    i3 = i;
                }
            }
            b.this.a(i3, i4);
            b.this.t.c("onError errorTypeReal=" + i3 + ", errorCodeReal=" + i4);
            e.a aVar = new e.a();
            aVar.f39408a = j;
            aVar.b = j2;
            b.this.a(262, i3, i4, (Object) aVar);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.h
        public void a(int i, long j, long j2, Object obj) {
            b.this.a(i, j, j2, obj);
            if (i == 1011) {
                b.this.a(obj);
            } else if (i == 1012) {
                b.this.b(obj);
            } else {
                Long l = obj;
                if (i == 4) {
                    l = Long.valueOf(b.this.b(((Long) obj).longValue(), "async call select track"));
                }
                e.a aVar = new e.a();
                aVar.f39408a = j;
                aVar.b = j2;
                aVar.f39409c = l;
                b.this.a(261, i, 0, (Object) aVar);
            }
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.p
        public void a(long j, long j2) {
            e.a aVar = new e.a();
            aVar.f39408a = j;
            aVar.b = j2;
            b.this.a(264, 0, 0, (Object) aVar);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.a
        public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            c cVar = b.this.f39401c;
            if (cVar != null) {
                cVar.onAudioFrameOut(b.this, tPAudioFrameBuffer);
            }
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.e
        public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
            c cVar = b.this.f39401c;
            if (cVar != null) {
                cVar.onDetailInfo(b.this, tPPlayerDetailInfo);
            }
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.l
        public void a(TPSubtitleData tPSubtitleData) {
            b.this.a(265, 0, 0, (Object) tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.m
        public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            b.this.a(279, 0, 0, (Object) tPSubtitleFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.n
        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            c cVar = b.this.f39401c;
            if (cVar != null) {
                cVar.onVideoFrameOut(b.this, tPVideoFrameBuffer);
            }
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.b
        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            c cVar = b.this.f39401c;
            if (cVar != null) {
                return cVar.onAudioProcessFrameOut(b.this, tPPostProcessFrameBuffer);
            }
            return null;
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.InterfaceC1013c
        public void b() {
            b.this.a(111, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("reason", 0).a());
            b.this.a(260, 0, 0, (Object) null);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.k
        public void b(int i, int i2) {
            b.this.a(277, i, i2, (Object) null);
        }

        @Override // com.tencent.thumbplayer.adapter.a.c.j
        public void c() {
            b.this.e();
            b.this.a(110, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("petime", Long.valueOf(b.this.getCurrentPositionMs())).a());
            b.this.a(263, 0, 0, (Object) null);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getAdvRemainTime() {
            ITPPlayerProxyListener j = b.this.d.j();
            if (j != null) {
                return j.getAdvRemainTimeMs();
            }
            return -1L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public String getContentType(int i, String str) {
            if (b.this.f == null) {
                b.this.t.e("mAssetResourceLoader not set");
                return "";
            }
            return b.this.f.c(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int getCurrentPlayClipNo() {
            com.tencent.thumbplayer.adapter.a aVar = b.this.b;
            if (aVar != null) {
                return aVar.a();
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getCurrentPlayOffset() {
            return b.this.b.t();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getCurrentPosition() {
            return b.this.getCurrentPositionMs();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public String getDataFilePath(int i, String str) {
            if (b.this.f == null) {
                b.this.t.e("mAssetResourceLoader not set");
                return "";
            }
            return b.this.f.b(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getDataTotalSize(int i, String str) {
            if (b.this.f == null) {
                b.this.t.e("mAssetResourceLoader not set");
                return -1L;
            }
            return b.this.f.a(i, str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object getPlayInfo(long j) {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object getPlayInfo(String str) {
            return null;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public long getPlayerBufferLength() {
            com.tencent.thumbplayer.adapter.a aVar = b.this.b;
            if (aVar != null) {
                return aVar.o() - b.this.b.n();
            }
            return 0L;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlExpired(Map<String, String> map) {
            b.this.t.c("onDownloadCdnUrlExpired");
            b.this.a(275, 0, 0, (Object) map);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            com.tencent.thumbplayer.e.a aVar = b.this.t;
            aVar.c("onDownloadCdnUrlInfoUpdate, url:" + str + ", cdnIp:" + str2 + ", uip:" + str3 + ", errorCodeStr:" + str4);
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
            tPCDNURLInfo.url = str;
            tPCDNURLInfo.cdnIp = str2;
            tPCDNURLInfo.uIp = str3;
            b.this.a(201, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("url", str).a("cdnip", str2).a("cdnuip", str3).a());
            b.this.a(270, 0, 0, (Object) tPCDNURLInfo);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadCdnUrlUpdate(String str) {
            b.this.t.c("onDownloadCdnUrlUpdate, url:".concat(String.valueOf(str)));
            b.this.a(269, 0, 0, (Object) str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadError(int i, int i2, String str) {
            com.tencent.thumbplayer.e.a aVar = b.this.t;
            aVar.c("onDownloadError, moduleID:" + i + ", errorCode:" + i2 + ", extInfo:" + str);
            b.this.a(i, i2);
            b.this.a(268, i, i2, (Object) str);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadFinish() {
            b.this.t.c("onDownloadFinish");
            b.this.a(271, 0, 0, (Object) 0);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str) {
            long j3 = i;
            b.this.q = j3;
            b.this.r = j;
            b.this.s = j2;
            TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
            tPDownLoadProgressInfo.playableDurationMS = j3;
            tPDownLoadProgressInfo.downloadSpeedKBps = i2;
            tPDownLoadProgressInfo.currentDownloadSize = j;
            tPDownLoadProgressInfo.totalFileSize = j2;
            tPDownLoadProgressInfo.extraInfo = str;
            b.this.a(200, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("speed", Integer.valueOf(i2)).a("spanId", str).a());
            b.this.a(274, 0, 0, (Object) tPDownLoadProgressInfo);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadProtocolUpdate(String str, String str2) {
            com.tencent.thumbplayer.e.a aVar = b.this.t;
            aVar.c("onDownloadProtocolUpdate, protocol:" + str + ", protocolVer:" + str2);
            TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
            tPProtocolInfo.protocolVersion = str2;
            tPProtocolInfo.protocolName = str;
            b.this.a(202, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a(WifiConfiguration.Protocol.varName, str).a("protover", str2).a());
            b.this.a(273, 0, 0, (Object) tPProtocolInfo);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public void onDownloadStatusUpdate(int i) {
            if (i != b.this.o) {
                b.this.t.c("onDownloadStatusUpdate, status:".concat(String.valueOf(i)));
                b.this.o = i;
            }
            b.this.a(272, i, 0, (Object) null);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public Object onPlayCallback(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            if (i == 1) {
                b.this.t.c("onDownloadNoMoreData");
                b.this.a(276, 0, 0, obj);
                return null;
            } else if (i == 2) {
                if (obj3 instanceof Integer) {
                    b.this.a(278, ((Integer) obj3).intValue(), 0, (Object) null);
                    return null;
                }
                b.this.t.c("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3.");
                return null;
            } else if (i != 8) {
                return null;
            } else {
                com.tencent.thumbplayer.e.a aVar = b.this.t;
                aVar.c("AB test info from download proxy received, key: " + obj + ", value: " + obj2);
                HashMap hashMap = new HashMap();
                hashMap.put((String) obj, Integer.valueOf((String) obj2));
                b.this.a(281, 0, 0, (Object) hashMap);
                return null;
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onReadData(int i, String str, long j, long j2) {
            if (b.this.f == null) {
                b.this.t.e("mAssetResourceLoader not set");
                return -1;
            }
            return b.this.f.b(i, str, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onStartReadData(int i, String str, long j, long j2) {
            if (b.this.f == null) {
                b.this.t.e("mAssetResourceLoader not set");
                return -1;
            }
            return b.this.f.a(i, str, j, j2);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener
        public int onStopReadData(int i, String str, int i2) {
            if (b.this.f == null) {
                b.this.t.e("mAssetResourceLoader not set");
                return -1;
            }
            return b.this.f.a(i, str, i2);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        C = sparseIntArray;
        sparseIntArray.put(106, 1005);
        C.put(105, 1006);
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, Looper looper) {
        this(context, looper, null);
    }

    public b(Context context, Looper looper, Looper looper2) {
        this(context, looper, looper2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x01ca, code lost:
        if (r12 == android.os.Looper.getMainLooper()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r11, android.os.Looper r12, android.os.Looper r13, com.tencent.thumbplayer.e.b r14) {
        /*
            Method dump skipped, instructions count: 704
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tplayer.b.<init>(android.content.Context, android.os.Looper, android.os.Looper, com.tencent.thumbplayer.e.b):void");
    }

    private int a(String str) {
        if (this.d.a()) {
            return 5;
        }
        return r.a(str);
    }

    private long a(long j, String str) {
        this.y.put(Long.valueOf(this.z), Long.valueOf(j));
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(str + ", convert opaque(" + j + ") => uniqueId(" + this.z + ")");
        long j2 = this.z;
        this.z = 1 + j2;
        return j2;
    }

    private TPVideoInfo a(TPVideoInfo tPVideoInfo, int i, int i2) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c("updateStartAndSkipEndTimeMsForDownloadParam, startTimeMs:" + i + ", skipEndTimeMs:" + i2);
        if (tPVideoInfo == null) {
            return new TPVideoInfo.Builder().downloadParam(b(i, i2)).build();
        }
        ArrayList<TPDownloadParamData> downloadPraramList = tPVideoInfo.getDownloadPraramList();
        if (downloadPraramList == null || downloadPraramList.isEmpty()) {
            tPVideoInfo.getBuilder().downloadParam(b(i, i2)).build();
            return tPVideoInfo;
        }
        Iterator<TPDownloadParamData> it = downloadPraramList.iterator();
        while (it.hasNext()) {
            TPDownloadParamData next = it.next();
            next.setStarTimeMS(i);
            next.setEndTimeMS(i2);
        }
        return tPVideoInfo;
    }

    private void a(@TPPlayerDetailInfo.TPPlayerDetailInfoType int i) {
        a aVar = this.j;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = 1256;
            obtainMessage.obj = new TPPlayerDetailInfo(i);
            this.j.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        com.tencent.thumbplayer.utils.g a2 = new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("reason", 3);
        a(108, i, i2, "", a2.a("code", i + "." + i2).a());
        this.d.a(3);
        this.d.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, Object obj) {
        a aVar = this.j;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.arg2 = i3;
            obtainMessage.obj = obj;
            this.j.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, String str, Object obj) {
        try {
            if (this.g != null) {
                this.g.a(i, i2, i3, str, obj);
            }
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j, long j2, Object obj) {
        if (i == 200) {
            this.d.a(4);
            a(114, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a("format", 0).a("ptime", Long.valueOf(getCurrentPositionMs())).a("url", this.l).a());
        } else if (i == 201) {
            e();
            a(115, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i == 3) {
            long j3 = -1;
            if (obj instanceof Long) {
                j3 = ((Long) obj).longValue();
            }
            this.t.c("switch definition finish defId:".concat(String.valueOf(j3)));
            if (j3 > 0) {
                this.d.a(j3);
            }
            a(121, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("switch", String.valueOf(j3)).a());
        } else if (i == 106) {
            a(105, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i == 501) {
            a(117, 0, 0, (String) null, obj);
        } else if (i == 107) {
            a(119, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i == 4) {
            a(123, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("opaque", obj).a("etime", Long.valueOf(System.currentTimeMillis())).a("code", String.valueOf(j2)).a());
        } else if (i == 101) {
            a(124, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i == 505 && (obj instanceof TPPlayerMsg.TPMediaDrmInfo)) {
            TPPlayerMsg.TPMediaDrmInfo tPMediaDrmInfo = (TPPlayerMsg.TPMediaDrmInfo) obj;
            this.t.c("TPMediaDrmInfo secureDecoder:" + tPMediaDrmInfo.supportSecureDecoder + " secureDecrypt:" + tPMediaDrmInfo.supportSecureDecrypt + " componentName:" + tPMediaDrmInfo.componentName + " drmType:" + tPMediaDrmInfo.drmType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (message.obj instanceof TPPlayerDetailInfo) {
            a((TPPlayerDetailInfo) message.obj);
        }
    }

    private void a(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam == null) {
            return;
        }
        if (tPOptionalParam.getKey() == 205) {
            this.m = tPOptionalParam.getParamBoolean().value;
            com.tencent.thumbplayer.e.a aVar = this.t;
            aVar.c("setPlayerOptionalParam, use p2p proxy, OPTION_ID_BEFORE_BOOLEAN_USE_PROXY=" + this.m);
        } else if (tPOptionalParam.getKey() == 508) {
            this.n = tPOptionalParam.getParamBoolean().value;
        } else if (tPOptionalParam.getKey() == 100) {
            this.A = (int) tPOptionalParam.getParamLong().value;
        } else if (tPOptionalParam.getKey() == 500) {
            this.B = (int) tPOptionalParam.getParamLong().value;
        }
    }

    private void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.onDetailInfo(this, tPPlayerDetailInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj) {
        TPDownloadParamData tPDownloadParamData;
        if (obj instanceof TPPlayerMsg.TPAudioTrackInfo) {
            if (!d()) {
                this.t.e("handleSelectAudioTrack, proxy is not enable");
                return;
            }
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = (TPPlayerMsg.TPAudioTrackInfo) obj;
            this.t.c("handleSelectAudioTrack, audioTrack url:" + tPAudioTrackInfo.audioTrackUrl);
            if (TextUtils.isEmpty(tPAudioTrackInfo.audioTrackUrl)) {
                try {
                    this.d.b();
                    return;
                } catch (Exception e) {
                    this.t.a(e);
                    return;
                }
            }
            Iterator<TPOptionalParam> it = tPAudioTrackInfo.paramData.iterator();
            while (true) {
                tPDownloadParamData = null;
                if (!it.hasNext()) {
                    break;
                }
                TPOptionalParam next = it.next();
                if (next.getKey() == 0) {
                    tPDownloadParamData = (TPDownloadParamData) next.getParamObject().objectValue;
                    break;
                }
            }
            this.d.a(tPAudioTrackInfo.audioTrackUrl, tPDownloadParamData != null ? tPDownloadParamData.getAudioTrackKeyId() : "");
        }
    }

    private void a(String str, int i, boolean z) {
        b.u uVar = new b.u();
        uVar.a(str);
        uVar.b(i);
        uVar.a(z);
        this.k.b().a(uVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long b(long j, String str) {
        if (!this.y.containsKey(Long.valueOf(j))) {
            com.tencent.thumbplayer.e.a aVar = this.t;
            aVar.e(str + ", invalid uniqueId");
            return -1L;
        }
        long longValue = this.y.get(Long.valueOf(j)).longValue();
        com.tencent.thumbplayer.e.a aVar2 = this.t;
        aVar2.c(str + ", convert uniqueId(" + j + ") => opaque(" + longValue + ")");
        return longValue;
    }

    private TPDownloadParamData b(int i, int i2) {
        TPDownloadParamData tPDownloadParamData = new TPDownloadParamData(0);
        tPDownloadParamData.setStarTimeMS(i);
        tPDownloadParamData.setEndTimeMS(i2);
        return tPDownloadParamData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        int i2 = C.get(i, -1);
        if (i2 == -1) {
            return;
        }
        c(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        TPDownloadParamData tPDownloadParamData;
        if (obj instanceof TPPlayerMsg.TPAudioTrackInfo) {
            if (!d()) {
                this.t.c("handleAudioTrackProxy, proxy not enable and use orinal url");
                return;
            }
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = (TPPlayerMsg.TPAudioTrackInfo) obj;
            Iterator<TPOptionalParam> it = tPAudioTrackInfo.paramData.iterator();
            while (true) {
                tPDownloadParamData = null;
                if (!it.hasNext()) {
                    break;
                }
                TPOptionalParam next = it.next();
                if (next.getKey() == 0) {
                    tPDownloadParamData = (TPDownloadParamData) next.getParamObject().objectValue;
                    break;
                }
            }
            String a2 = this.d.a(2, tPAudioTrackInfo.audioTrackUrl, tPDownloadParamData);
            this.p.add(a2);
            tPAudioTrackInfo.proxyUrl = a2;
        }
    }

    private void b(String str) {
        b.p pVar = new b.p();
        pVar.a(str);
        this.k.b().a(pVar);
    }

    private void c() {
        this.b.j();
        a(107, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("reason", 1).a());
        this.d.a(5);
        this.d.h();
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@TPPlayerDetailInfo.TPPlayerDetailInfoType int i) {
        a(new TPPlayerDetailInfo(i));
    }

    private boolean d() {
        return this.d.f() && TPPlayerConfig.isUseP2P() && this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.d.a(this.b.c() ? 0 : 5);
    }

    private void f() {
        e.a aVar = new e.a();
        aVar.f39408a = d() ? 1L : 0L;
        a(261, 1009, 0, (Object) aVar);
    }

    private boolean g() {
        int b = this.b.b();
        return b == 4 || b == 5 || b == 6 || b == 7;
    }

    public Looper a() {
        return this.i;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void addAudioTrackSource(String str, String str2) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "addAudioTrackSource, url:" + str + ", name:" + str2);
        addAudioTrackSource(str, str2, null);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void addAudioTrackSource(String str, String str2, TPDownloadParamData tPDownloadParamData) {
        this.t.c(f39400a + "addAudioTrackSource, url:" + str + ", name:" + str2 + ", downloadParamData:" + tPDownloadParamData);
        if (TextUtils.isEmpty(str2) || !com.tencent.thumbplayer.utils.b.b(str)) {
            this.t.e("handleAddAudioSource, illegal argument.");
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            TPOptionalParam tPOptionalParam = new TPOptionalParam();
            if (tPDownloadParamData != null) {
                tPOptionalParam.buildObject(0, tPDownloadParamData);
            }
            arrayList.add(tPOptionalParam);
            Map<String, String> map = null;
            if (tPDownloadParamData != null) {
                map = null;
                if (tPDownloadParamData.getUrlCdnidHttpHeaderList() != null) {
                    map = null;
                    if (!tPDownloadParamData.getUrlCdnidHttpHeaderList().isEmpty()) {
                        map = tPDownloadParamData.getUrlCdnidHttpHeaderList().get(0);
                    }
                }
            }
            this.b.a(str, map, str2, arrayList);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(c = true)
    public void addSubtitleSource(String str, String str2, String str3) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "addSubtitleSource, url:" + str + ", mimeType:" + str2 + ", name:" + str3);
        addSubtitleSource(str, str2, str3, null);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(c = true)
    public void addSubtitleSource(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData) {
        String str4;
        this.t.c(f39400a + "addSubtitleSource, url:" + str + ", name:" + str3 + ", downloadParamData:" + tPDownloadParamData);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (d() && com.tencent.thumbplayer.utils.b.b(str)) {
                str4 = this.d.a(3, str, tPDownloadParamData);
                this.p.add(str4);
            } else {
                str4 = str;
            }
            Map<String, String> map = null;
            if (tPDownloadParamData != null) {
                map = null;
                if (tPDownloadParamData.getUrlCdnidHttpHeaderList() != null) {
                    map = null;
                    if (!tPDownloadParamData.getUrlCdnidHttpHeaderList().isEmpty()) {
                        map = tPDownloadParamData.getUrlCdnidHttpHeaderList().get(0);
                    }
                }
            }
            this.b.a(str4, map, str2, str3);
            a(118, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(currentTimeMillis)).a("etime", Long.valueOf(System.currentTimeMillis())).a("url", str).a("name", str3).a());
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    public String b() {
        return this.t.b();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(a = true)
    public void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "captureVideo, params:" + tPCaptureParams + ", captureCallBack:" + tPCaptureCallBack);
        try {
            this.b.a(tPCaptureParams, tPCaptureCallBack);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void deselectTrack(int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "deselectTrack, trackIndex:" + i + ", opaque:" + j);
        try {
            this.b.b(i, j);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener, Looper looper) {
        if (iTPAssetResourceLoaderListener == null) {
            this.d.a(false);
            return;
        }
        this.d.a(true);
        com.tencent.thumbplayer.c.a.a aVar = this.f;
        if (aVar != null) {
            aVar.c();
            this.f = null;
        }
        com.tencent.thumbplayer.c.a.b bVar = new com.tencent.thumbplayer.c.a.b(this.k.a(), looper);
        this.f = bVar;
        bVar.a(iTPAssetResourceLoaderListener);
        this.f.a();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getBufferPercent() {
        if (this.b.m() == 0) {
            return 0;
        }
        return (int) ((((float) (this.b.o() - this.b.n())) * 100.0f) / ((float) this.b.m()));
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getCurrentPositionMs() {
        return this.b.n();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getCurrentState() {
        return this.b.b();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getDurationMs() {
        return this.b.m();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public ITPExtendReportController getExtendReportController() {
        return this.x;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getPlayableDurationMs() {
        if (d()) {
            long j = this.r;
            if (j > 0) {
                long j2 = this.s;
                if (j2 > 0) {
                    return (long) (((j * 1.0d) / j2) * this.b.m());
                }
            }
            return this.q;
        }
        return this.b.o();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public ITPPlayerProxy getPlayerProxy() {
        return this.d;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getPlayerType() {
        return this.b.d();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.b.s();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public long getPropertyLong(int i) {
        return this.b.b(i);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public String getPropertyString(int i) {
        return this.b.c(i);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public ITPBusinessReportManager getReportManager() {
        return this.e;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public TPTrackInfo[] getTrackInfo() {
        return this.b.r();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getVideoHeight() {
        return this.b.q();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public int getVideoWidth() {
        return this.b.p();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void pause() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + com.anythink.expressad.foundation.d.c.cb);
        this.b.i();
        try {
            a(106, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
            this.d.a(5);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void pauseDownload() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "pauseDownload");
        try {
            this.b.a(new TPOptionalParam().buildLong(502, 0L));
        } catch (Exception e) {
            this.t.a(e);
        }
        this.d.h();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void prepareAsync() {
        String str = UUID.randomUUID().toString() + System.nanoTime() + BridgeUtil.UNDERLINE_STR + TPPlayerConfig.getPlatform();
        a(1003);
        this.t.c(f39400a + "prepareAsync");
        try {
            this.d.i();
            this.b.g();
        } catch (RuntimeException e) {
            this.t.a(e);
        }
        b(str);
        try {
            a(102, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a("url", this.l).a("p2p", Boolean.valueOf(d())).a("flowid", str).a());
            f();
        } catch (Exception e2) {
            this.t.a(e2);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(a = true)
    public void release() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "release");
        this.b.l();
        a(112, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("reason", 1).a());
        this.f39401c.a();
        this.d.e();
        this.p.clear();
        com.tencent.thumbplayer.c.a.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.c();
            this.f = null;
        }
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        o.a().a(this.h, this.j);
        this.h = null;
        this.j = null;
        this.g.c();
        g gVar = this.x;
        if (gVar != null) {
            gVar.b();
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(a = true)
    public void reset() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "reset");
        if (this.w) {
            this.t.a(String.valueOf(this.v.incrementAndGet()));
            this.b.a(this.t.a());
            this.f39401c.a(this.t.a().a());
        }
        this.b.k();
        a(113, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("reason", 1).a());
        this.d.d();
        this.o = -1;
        this.p.clear();
        com.tencent.thumbplayer.c.a.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.b();
        }
        a aVar3 = this.j;
        if (aVar3 != null) {
            aVar3.removeCallbacksAndMessages(null);
        }
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        this.m = true;
        this.n = false;
        this.A = 0;
        this.B = 0;
        this.y.clear();
        this.z = 0L;
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void resumeDownload() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "resumeDownload");
        this.d.i();
        try {
            this.b.a(new TPOptionalParam().buildLong(502, 1L));
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void seekTo(int i) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "seekTo, positionMs:" + i);
        this.b.a(i);
        this.d.a(1);
        a(109, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a("format", 0).a("pstime", Long.valueOf(getCurrentPositionMs())).a());
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void seekTo(int i, int i2) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "seekTo, positionMs:" + i + ", mode:" + i2);
        if (i2 > 0) {
            this.b.a(i, i2);
        } else {
            this.b.a(i);
        }
        this.d.a(1);
        a(109, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a("format", 0).a("pstime", Long.valueOf(getCurrentPositionMs())).a());
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void selectProgram(int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "selectProgram, programIndex:" + i + ", opaque:" + j);
        try {
            this.b.c(i, j);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void selectTrack(int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "selectTrack, trackIndex:" + i + ", opaque:" + j);
        try {
            long a2 = a(j, "selectTrack");
            TPTrackInfo[] r = this.b.r();
            if (r != null && r.length > i) {
                a(122, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("opaque", Long.valueOf(a2)).a("tracktype", Integer.valueOf(r[i].getTrackType())).a("name", r[i].getName()).a("stime", Long.valueOf(System.currentTimeMillis())).a());
            }
            this.b.a(i, a2);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true)
    public void setAudioGainRatio(float f) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setAudioGainRatio, gainRatio:" + f);
        try {
            this.b.a(f);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true)
    public void setAudioNormalizeVolumeParams(String str) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + str);
        try {
            this.b.a(str);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            throw new IllegalArgumentException("error : setDataSource , param is null");
        }
        if (this.b.b() != 1) {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.b.b());
        }
        a("", 4, false);
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setDataSource, AssetFileDescriptor");
        try {
            this.b.a(assetFileDescriptor);
        } catch (IOException | SecurityException e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            throw new IllegalArgumentException("error : setDataSource , param is null");
        }
        if (this.b.b() != 1) {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.b.b());
        }
        a("", 4, false);
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setDataSource, ParcelFileDescriptor");
        try {
            this.b.a(parcelFileDescriptor);
        } catch (IOException | SecurityException e) {
            this.t.a(e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r0.getDrmAllProperties().isEmpty() == false) goto L14;
     */
    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @com.tencent.thumbplayer.utils.n.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDataSource(com.tencent.thumbplayer.api.composition.ITPMediaAsset r6) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tplayer.b.setDataSource(com.tencent.thumbplayer.api.composition.ITPMediaAsset):void");
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setDataSource(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("error : setDataSource , param is invalid");
        }
        if (this.b.b() != 1) {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.b.b());
        }
        a(str, a(str), d());
        a(1000);
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setDataSource, url:" + str);
        this.l = str;
        com.tencent.thumbplayer.adapter.a.e eVar = new com.tencent.thumbplayer.adapter.a.e(str);
        this.t.c("handleSetDataSource originalUrl=".concat(String.valueOf(str)));
        if (d()) {
            eVar = this.d.a(str, (Map<String, String>) null);
            updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 0);
            com.tencent.thumbplayer.e.a aVar2 = this.t;
            aVar2.c("handleSetDataSource selfPlayerUrl=" + eVar.b());
            com.tencent.thumbplayer.e.a aVar3 = this.t;
            aVar3.c("handleSetDataSource systemPlayerUrl=" + eVar.a());
        }
        this.b.a(eVar);
        a(1001);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setDataSource(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("error : setDataSource , param is invalid");
        }
        if (this.b.b() != 1) {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.b.b());
        }
        a(str, a(str), d());
        a(1000);
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setDataSource, url:" + str + ", httpHeader:" + map);
        this.l = str;
        com.tencent.thumbplayer.adapter.a.e eVar = new com.tencent.thumbplayer.adapter.a.e(str);
        this.t.c("handleSetDataSource originalUrl=".concat(String.valueOf(str)));
        if (d()) {
            eVar = this.d.a(str, map);
            updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 0);
            com.tencent.thumbplayer.e.a aVar2 = this.t;
            aVar2.c("handleSetDataSource selfPlayerUrl=" + eVar.b());
            com.tencent.thumbplayer.e.a aVar3 = this.t;
            aVar3.c("handleSetDataSource systemPlayerUrl=" + eVar.a());
        }
        this.b.a(eVar, map);
        a(1001);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void setLoopback(boolean z) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setLoopback, isLoopback:" + z);
        try {
            this.b.b(z);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void setLoopback(boolean z, long j, long j2) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setLoopback, isLoopback:" + z + ", loopStartPositionMs:" + j + ", loopEndPositionMs:" + j2);
        try {
            this.b.a(z, j, j2);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnAudioFrameOutputListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnAudioProcessFrameOutputListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnCompletionListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnDemuxerListener(ITPPlayerListener.IOnDemuxerListener iOnDemuxerListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnDemuxerListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnDetailInfoListener(ITPPlayerListener.IOnDetailInfoListener iOnDetailInfoListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnDetailInfoListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnErrorListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnInfoListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnStateChangeListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnPreparedListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnSeekCompleteListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnStopAsyncCompleteListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnSubtitleDataListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnSubtitleFrameOutListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnVideoFrameOutListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnVideoProcessFrameOutputListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        c cVar = this.f39401c;
        if (cVar != null) {
            cVar.a(iOnVideoSizeChangedListener);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true)
    public void setOutputMute(boolean z) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setOutputMute, isOutputMute:" + z);
        try {
            this.b.a(z);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true)
    public void setPlaySpeedRatio(float f) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setPlaySpeedRatio, speedRatio:" + f);
        try {
            this.d.a(f);
            this.b.b(f);
        } catch (Exception e) {
            this.t.a(e);
        }
        a(116, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("scene", Float.valueOf(f)).a());
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(c = true)
    public void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam.getParamType() == 7 && !j.a(tPOptionalParam.getKey(), tPOptionalParam.getParamObject().objectValue)) {
            com.tencent.thumbplayer.e.a aVar = this.t;
            aVar.d("set object param failed, optional id:" + tPOptionalParam.getKey());
            return;
        }
        a(tPOptionalParam);
        this.d.a(tPOptionalParam);
        try {
            this.b.a(tPOptionalParam);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        this.b.a(iTPRichMediaSynchronizer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setSurface(Surface surface) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setSurface, surface:" + surface);
        try {
            this.b.a(surface);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "setSurfaceHolder, SurfaceHolder:" + surfaceHolder);
        try {
            this.b.a(surfaceHolder);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(c = true)
    public void setVideoInfo(TPVideoInfo tPVideoInfo) {
        if (tPVideoInfo != null) {
            try {
                a(tPVideoInfo, this.A, this.B);
                this.d.a(tPVideoInfo);
                this.b.a(tPVideoInfo);
            } catch (Exception e) {
                this.t.a(e);
            }
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void start() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "start");
        this.b.h();
        try {
            a(104, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
            this.d.a(0);
        } catch (Exception e) {
            this.t.a(e);
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(a = true)
    public void stop() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "stop");
        c();
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void stopAsync() {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "stopAsync");
        c();
        a(280, 0, 0, (Object) null);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void switchDefinition(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "switchDefinition, mediaAsset:" + iTPMediaAsset + ", defID:" + j + ", videoInfo:" + tPVideoInfo);
        switchDefinition(iTPMediaAsset, j, tPVideoInfo, 0);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void switchDefinition(ITPMediaAsset iTPMediaAsset, long j, TPVideoInfo tPVideoInfo, int i) {
        if (!g()) {
            throw new IllegalStateException("error : switchDefinition , state invalid");
        }
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "switchDefinition, mediaAsset:" + iTPMediaAsset + ", defID:" + j + ", videoInfo:" + tPVideoInfo + ", mode:" + i);
        TPVideoInfo a2 = a(tPVideoInfo, (int) getCurrentPositionMs(), this.B);
        ITPMediaAsset iTPMediaAsset2 = iTPMediaAsset;
        if (d()) {
            iTPMediaAsset2 = this.d.a(iTPMediaAsset, j, a2);
        }
        if (iTPMediaAsset2 != null) {
            com.tencent.thumbplayer.e.a aVar2 = this.t;
            aVar2.c("handleSwitchDef, proxyMediaAsset:" + iTPMediaAsset2 + ", defID:" + j);
            this.b.b(a2);
            this.b.a(iTPMediaAsset2, 0, j);
            a(120, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("switch", String.valueOf(j)).a());
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "switchDefinition, defUrl:" + str + ", defID:" + j);
        switchDefinition(str, j, tPVideoInfo, 0);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo, int i) {
        if (!g()) {
            throw new IllegalStateException("error : switchDefinition , state invalid");
        }
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "switchDefinition, defUrl:" + str + ", defID:" + j + ", mode:" + i);
        TPVideoInfo a2 = a(tPVideoInfo, (int) getCurrentPositionMs(), this.B);
        com.tencent.thumbplayer.adapter.a.e eVar = new com.tencent.thumbplayer.adapter.a.e(str);
        if (d()) {
            eVar = this.d.a(j, str, a2, null);
            com.tencent.thumbplayer.e.a aVar2 = this.t;
            aVar2.c("switchDefinition selfPlayerUrl=" + eVar.b());
            com.tencent.thumbplayer.e.a aVar3 = this.t;
            aVar3.c("switchDefinition systemPlayerUrl=" + eVar.a());
        }
        com.tencent.thumbplayer.e.a aVar4 = this.t;
        aVar4.c("switchDefinition, proxyUrl:" + str + ", defID:" + j);
        this.b.b(a2);
        this.b.a(eVar, i, j);
        a(120, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("switch", String.valueOf(j)).a());
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo, Map<String, String> map) {
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "switchDefinition, defUrl:" + str + ", defID:" + j + ", videoInfo:" + tPVideoInfo + ", httpHeader:" + map);
        switchDefinition(str, j, tPVideoInfo, map, 0);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j, TPVideoInfo tPVideoInfo, Map<String, String> map, int i) {
        if (!g()) {
            throw new IllegalStateException("error : switchDefinition , state invalid");
        }
        com.tencent.thumbplayer.e.a aVar = this.t;
        aVar.c(f39400a + "switchDefinition, defUrl:" + str + ", defID:" + j + ", httpHeader:" + map + ", mode:" + i);
        TPVideoInfo a2 = a(tPVideoInfo, (int) getCurrentPositionMs(), this.B);
        com.tencent.thumbplayer.adapter.a.e eVar = new com.tencent.thumbplayer.adapter.a.e(str);
        if (d()) {
            eVar = this.d.a(j, str, a2, map);
            com.tencent.thumbplayer.e.a aVar2 = this.t;
            aVar2.c("switchDefinition selfPlayerUrl=" + eVar.b());
            com.tencent.thumbplayer.e.a aVar3 = this.t;
            aVar3.c("switchDefinition systemPlayerUrl=" + eVar.a());
        }
        com.tencent.thumbplayer.e.a aVar4 = this.t;
        aVar4.c("switchDefinition, proxyUrl:" + str + ", defID:" + j + ", httpHeader:" + map);
        this.b.b(a2);
        this.b.a(eVar, map, i, j);
        a(120, 0, 0, (String) null, new com.tencent.thumbplayer.utils.g().a("switch", String.valueOf(j)).a());
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    public void updateLoggerContext(com.tencent.thumbplayer.e.b bVar) {
        if (bVar != null) {
            this.w = false;
            this.t.a(new com.tencent.thumbplayer.e.b(bVar, "TPPlayer"));
            this.b.a(this.t.a());
            this.f39401c.a(this.t.a().a());
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayer
    @n.b
    public void updateTaskInfo(String str, Object obj) {
        com.tencent.thumbplayer.c.a aVar = this.d;
        if (aVar != null) {
            aVar.a(str, obj);
        }
    }
}
