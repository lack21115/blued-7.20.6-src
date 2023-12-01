package com.tencent.thumbplayer.adapter.a.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.huawei.openalliance.ad.constant.bc;
import com.tencent.thumbplayer.adapter.a.b.c;
import com.tencent.thumbplayer.adapter.a.c;
import com.tencent.thumbplayer.adapter.g;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPAudioAttributes;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.api.TPCaptureParams;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPJitterBufferConfig;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.thumbplayer.core.common.TPDetailInfo;
import com.tencent.thumbplayer.core.common.TPGeneralError;
import com.tencent.thumbplayer.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.demuxer.ITPNativeDemuxerCallback;
import com.tencent.thumbplayer.core.demuxer.TPNativeRemoteSdpInfo;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerEventRecordCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.core.player.TPNativePlayer;
import com.tencent.thumbplayer.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.core.player.TPNativePlayerProgramInfo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/b.class */
public class b implements com.tencent.thumbplayer.adapter.a.b {

    /* renamed from: a  reason: collision with root package name */
    static final Set<Integer> f39167a = new HashSet<Integer>() { // from class: com.tencent.thumbplayer.adapter.a.b.b.8
        {
            add(503);
        }
    };
    private TPNativePlayer b;

    /* renamed from: c  reason: collision with root package name */
    private TPNativePlayerInitConfig f39168c;
    private a d;
    private g e;
    private com.tencent.thumbplayer.adapter.a.a f;
    private com.tencent.thumbplayer.e.a h;
    private TPSubtitleData g = new TPSubtitleData();
    private ITPNativePlayerMessageCallback i = new ITPNativePlayerMessageCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.1
        private void a(int i, Object obj) {
            if (b.this.d != null) {
                Message.obtain(b.this.d, i, obj).sendToTarget();
            }
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public void onASyncCallResult(int i, long j, int i2, int i3) {
            com.tencent.thumbplayer.e.a aVar = b.this.h;
            aVar.c("onASyncCallResult, callType:" + i + ", opaque:" + j + ", errorType:" + i2 + ", errorCode:" + i3);
            C1012b c1012b = new C1012b();
            c1012b.f39177a = i;
            c1012b.b = j;
            c1012b.f39178c = i2;
            c1012b.d = i3;
            a(1, c1012b);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public void onDetailInfo(TPDetailInfo tPDetailInfo) {
            com.tencent.thumbplayer.e.a aVar = b.this.h;
            aVar.c("onDetailInfo, type:" + tPDetailInfo.type + ", time:" + tPDetailInfo.timeSince1970Us);
            a(5, tPDetailInfo);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public void onError(int i, int i2) {
            com.tencent.thumbplayer.e.a aVar = b.this.h;
            aVar.c("onError, msgType:" + i + ", errorCode:" + i2);
            c cVar = new c();
            cVar.f39179a = i;
            cVar.b = i2;
            a(4, cVar);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public void onInfoLong(int i, long j, long j2) {
            com.tencent.thumbplayer.e.a aVar = b.this.h;
            aVar.c("onInfoLong, infoType:" + i + ", lParam1:" + j + ", lParam2:" + j2);
            if (i == 253) {
                com.tencent.thumbplayer.adapter.a.b.a.b(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, (int) j));
                return;
            }
            d dVar = new d();
            dVar.f39180a = i;
            dVar.b = j;
            dVar.f39181c = j2;
            a(2, dVar);
        }

        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerMessageCallback
        public void onInfoObject(int i, Object obj) {
            if (!b.this.d(i)) {
                com.tencent.thumbplayer.e.a aVar = b.this.h;
                aVar.c("onInfoObject, infoType:" + i + ", objParam:" + obj);
            }
            e eVar = new e();
            eVar.f39182a = i;
            eVar.b = obj;
            a(3, eVar);
        }
    };
    private ITPNativePlayerAudioFrameCallback j = new ITPNativePlayerAudioFrameCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.2
        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerAudioFrameCallback
        public void onAudioFrame(TPAudioFrame tPAudioFrame, int i) {
            b.this.e.a(com.tencent.thumbplayer.adapter.a.b.c.a(tPAudioFrame));
        }
    };
    private ITPNativePlayerVideoFrameCallback k = new ITPNativePlayerVideoFrameCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.3
        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerVideoFrameCallback
        public void onVideoFrame(TPVideoFrame tPVideoFrame, int i) {
            b.this.e.a(com.tencent.thumbplayer.adapter.a.b.c.a(tPVideoFrame));
        }
    };
    private ITPNativePlayerSubtitleFrameCallback l = new ITPNativePlayerSubtitleFrameCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.4
        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerSubtitleFrameCallback
        public void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame, int i) {
            b.this.e.a(com.tencent.thumbplayer.adapter.a.b.c.a(tPSubtitleFrame));
        }
    };
    private ITPNativePlayerPostProcessFrameCallback m = new ITPNativePlayerPostProcessFrameCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.5
        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerPostProcessFrameCallback
        public TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame tPPostProcessFrame, int i) {
            TPPostProcessFrameBuffer b;
            TPPostProcessFrameBuffer a2 = com.tencent.thumbplayer.adapter.a.b.c.a(tPPostProcessFrame);
            a2.eventFlag = i;
            if (tPPostProcessFrame.mediaType == 0) {
                b = b.this.e.a(a2);
            } else if (tPPostProcessFrame.mediaType != 1) {
                return null;
            } else {
                b = b.this.e.b(a2);
            }
            return com.tencent.thumbplayer.adapter.a.b.c.a(b);
        }
    };
    private ITPNativeDemuxerCallback n = new ITPNativeDemuxerCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.6
        @Override // com.tencent.thumbplayer.core.demuxer.ITPNativeDemuxerCallback
        public TPNativeRemoteSdpInfo onSdpExchange(String str, int i) {
            return com.tencent.thumbplayer.adapter.a.b.c.a(b.this.e.a(str, i));
        }
    };
    private ITPNativePlayerEventRecordCallback o = new ITPNativePlayerEventRecordCallback() { // from class: com.tencent.thumbplayer.adapter.a.b.b.7
        @Override // com.tencent.thumbplayer.core.player.ITPNativePlayerEventRecordCallback
        public void onDrmInfo(TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            if (tPPlayerDrmParams == null) {
                b.this.h.e("Native DrmInfo is null!");
                return;
            }
            b.this.h.c("onDrmInfo");
            b.this.e.a(com.tencent.thumbplayer.adapter.a.b.c.a(tPPlayerDrmParams));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/b$a.class */
    public class a extends Handler {
        private WeakReference<b> b;

        public a(Looper looper, b bVar) {
            super(looper);
            this.b = new WeakReference<>(bVar);
        }

        private void a(@TPCommonEnum.NativeErrorType int i, int i2) {
            b.this.e.a(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapErrorType.class, i), i2, 0L, 0L);
        }

        private void a(C1012b c1012b) {
            int i = c1012b.f39177a;
            if (i == 1) {
                b.this.b();
            } else if (i != 2) {
                b.this.a(c1012b);
            } else {
                b.this.c();
            }
        }

        private void a(d dVar) {
            int i = dVar.f39180a;
            if (i == 154) {
                b.this.d();
            } else if (i != 250) {
                b.this.a(dVar.f39180a, dVar);
            } else {
                b.this.a(dVar.b, dVar.f39181c);
            }
        }

        private void a(e eVar) {
            if (eVar.f39182a != 502) {
                b.this.a(eVar.f39182a, eVar);
            } else if (eVar.b instanceof String) {
                b.this.g.subtitleData = (String) eVar.b;
                b.this.e.a(b.this.g);
            }
        }

        private void a(TPDetailInfo tPDetailInfo) {
            b.this.e.a(com.tencent.thumbplayer.adapter.a.b.c.a(tPDetailInfo));
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.b.get() == null) {
                b.this.h.e("mWeakRef is null");
                return;
            }
            int i = message.what;
            if (i == 1) {
                a((C1012b) message.obj);
            } else if (i == 2) {
                a((d) message.obj);
            } else if (i == 3) {
                a((e) message.obj);
            } else if (i == 4) {
                c cVar = (c) message.obj;
                a(cVar.f39179a, cVar.b);
            } else if (i == 5) {
                a((TPDetailInfo) message.obj);
            } else {
                com.tencent.thumbplayer.e.a aVar = b.this.h;
                aVar.d("message :" + message.what + "  not recognition");
            }
        }
    }

    /* renamed from: com.tencent.thumbplayer.adapter.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/b$b.class */
    public static class C1012b {
        @TPCommonEnum.NativeMsgInfo

        /* renamed from: a  reason: collision with root package name */
        int f39177a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        int f39178c;
        int d;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/b$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        int f39179a;
        int b;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/b$d.class */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f39180a;
        long b;

        /* renamed from: c  reason: collision with root package name */
        long f39181c;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/b/b$e.class */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        int f39182a;
        Object b;
    }

    public b(Context context, com.tencent.thumbplayer.e.b bVar) {
        this.h = new com.tencent.thumbplayer.e.a(bVar, "TPThumbPlayer");
        TPNativePlayer tPNativePlayer = new TPNativePlayer(context);
        this.b = tPNativePlayer;
        tPNativePlayer.setMessageCallback(this.i);
        this.b.setAudioFrameCallback(this.j);
        this.b.setVideoFrameCallback(this.k);
        this.b.setSubtitleFrameCallback(this.l);
        this.b.setPostProcessFrameCallback(this.m);
        this.b.setDemuxerCallback(this.n);
        this.b.setEventRecordCallback(this.o);
        this.f39168c = new TPNativePlayerInitConfig();
        this.e = new g(this.h.b());
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.d = new a(myLooper, this);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.d = new a(mainLooper, this);
        } else {
            this.d = null;
        }
    }

    private TPProgramInfo a(TPNativePlayerProgramInfo tPNativePlayerProgramInfo) {
        if (tPNativePlayerProgramInfo != null) {
            TPProgramInfo tPProgramInfo = new TPProgramInfo();
            tPProgramInfo.url = tPNativePlayerProgramInfo.url;
            tPProgramInfo.bandwidth = tPNativePlayerProgramInfo.bandwidth;
            tPProgramInfo.resolution = tPNativePlayerProgramInfo.resolution;
            tPProgramInfo.programId = tPNativePlayerProgramInfo.programId;
            tPProgramInfo.actived = tPNativePlayerProgramInfo.actived;
            return tPProgramInfo;
        }
        return null;
    }

    private TPTrackInfo a(TPMediaTrackInfo tPMediaTrackInfo) {
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = tPMediaTrackInfo.trackName;
        tPTrackInfo.trackType = tPMediaTrackInfo.trackType;
        tPTrackInfo.containerType = tPMediaTrackInfo.contianerType;
        if (tPTrackInfo.containerType == 1) {
            tPTrackInfo.hlsTag.name = tPMediaTrackInfo.hlsTag.name;
            tPTrackInfo.hlsTag.bandwidth = tPMediaTrackInfo.hlsTag.bandwidth;
            tPTrackInfo.hlsTag.resolution = tPMediaTrackInfo.hlsTag.resolution;
            tPTrackInfo.hlsTag.framerate = tPMediaTrackInfo.hlsTag.framerate;
            tPTrackInfo.hlsTag.codecs = tPMediaTrackInfo.hlsTag.codecs;
            tPTrackInfo.hlsTag.groupId = tPMediaTrackInfo.hlsTag.groupId;
            tPTrackInfo.hlsTag.language = tPMediaTrackInfo.hlsTag.language;
        } else if (tPTrackInfo.containerType == 2) {
            tPTrackInfo.dashFormat = com.tencent.thumbplayer.adapter.a.b.c.a(tPMediaTrackInfo.dashFormat);
        }
        tPTrackInfo.isExclusive = tPMediaTrackInfo.isExclusive;
        tPTrackInfo.isSelected = tPMediaTrackInfo.isSelected;
        tPTrackInfo.isInternal = tPMediaTrackInfo.isInternal;
        return tPTrackInfo;
    }

    private void a() {
        if (this.b == null) {
            throw new IllegalStateException("player has release");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@TPCommonEnum.NativeErrorType int i, d dVar) {
        Class cls;
        int tPIntValue = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, i);
        if (tPIntValue < 0) {
            this.h.d("msgType:" + i + ", cannot convert to thumbPlayer Info");
            return;
        }
        long j = dVar.b;
        long j2 = dVar.f39181c;
        if (tPIntValue == 203) {
            cls = TPNativeKeyMap.MapAudioDecoderType.class;
        } else if (tPIntValue != 204) {
            this.h.d("unhandled thumbPlayerInfo=".concat(String.valueOf(tPIntValue)));
            this.e.a(tPIntValue, j, j2, (Object) null);
        } else {
            cls = TPNativeKeyMap.MapVideoDecoderType.class;
        }
        j = TPNativeKeyMapUtil.toTPIntValue(cls, (int) dVar.b);
        this.e.a(tPIntValue, j, j2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@TPCommonEnum.NativeMsgInfo int i, e eVar) {
        int tPIntValue = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, i);
        if (tPIntValue < 0 || eVar.b == null) {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.d("msgType:" + i + ", cannot convert to thumbPlayer Info");
            return;
        }
        Object obj = eVar.b;
        String str = obj;
        switch (tPIntValue) {
            case 500:
                str = com.tencent.thumbplayer.adapter.a.b.c.a((ITPNativePlayerMessageCallback.VideoCropInfo) eVar.b);
                break;
            case 501:
            case 504:
                break;
            case 502:
                str = com.tencent.thumbplayer.adapter.a.b.c.a((ITPNativePlayerMessageCallback.MediaCodecInfo) eVar.b);
                break;
            case 503:
                str = com.tencent.thumbplayer.adapter.a.b.c.a((ITPNativePlayerMessageCallback.VideoSeiInfo) eVar.b);
                break;
            case 505:
                str = com.tencent.thumbplayer.adapter.a.b.c.a((ITPNativePlayerMessageCallback.MediaDrmInfo) eVar.b);
                break;
            case 506:
                str = (String) eVar.b;
                this.h.c("TP_PLAYER_INFO_OBJECT_SUBTITLE_NOTE:".concat(String.valueOf(str)));
                break;
            default:
                str = obj;
                break;
        }
        this.e.a(tPIntValue, 0L, 0L, str);
    }

    private void a(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamBoolean optionalParamBoolean) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping boolean is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.b() == 3) {
            this.f39168c.setBool(convertToNativeOptionalId.c(), optionalParamBoolean.value);
        } else {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamFloat optionalParamFloat) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping float is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (7 == convertToNativeOptionalId.b()) {
            this.f39168c.setFloat(convertToNativeOptionalId.c(), optionalParamFloat.value);
        } else {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID:" + convertToNativeOptionalId.c() + " is not float");
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamLong optionalParamLong) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
            return;
        }
        int b = convertToNativeOptionalId.b();
        boolean z = true;
        if (b == 1) {
            this.f39168c.setLong(convertToNativeOptionalId.c(), optionalParamLong.value);
        } else if (b == 3) {
            TPNativePlayerInitConfig tPNativePlayerInitConfig = this.f39168c;
            int c2 = convertToNativeOptionalId.c();
            if (optionalParamLong.value <= 0) {
                z = false;
            }
            tPNativePlayerInitConfig.setBool(c2, z);
        } else if (b == 4) {
            this.f39168c.setInt(convertToNativeOptionalId.c(), (int) optionalParamLong.value);
        } else {
            this.h.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamObject optionalParamObject) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId == null) {
            this.h.e("convertToNativeOptionalId failed, key: ".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping object is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else {
            int c2 = convertToNativeOptionalId.c();
            if (c2 == 126) {
                this.f39168c.setObject(convertToNativeOptionalId.c(), com.tencent.thumbplayer.adapter.a.b.c.a((TPJitterBufferConfig) optionalParamObject.objectValue));
            } else if (c2 == 414) {
                this.f39168c.setObject(convertToNativeOptionalId.c(), com.tencent.thumbplayer.adapter.a.b.c.a((TPAudioAttributes) optionalParamObject.objectValue));
            } else {
                com.tencent.thumbplayer.e.a aVar = this.h;
                aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
            }
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamQueueInt optionalParamQueueInt) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping queue_int is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (optionalParamQueueInt.queueValue == null || optionalParamQueueInt.queueValue.length == 0) {
            this.h.e("queueint params is empty in".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.b() != 5) {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= optionalParamQueueInt.queueValue.length) {
                    return;
                }
                this.f39168c.addQueueInt(convertToNativeOptionalId.c(), optionalParamQueueInt.queueValue[i3]);
                i2 = i3 + 1;
            }
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamQueueString optionalParamQueueString) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping queue_string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (optionalParamQueueString.queueValue == null || optionalParamQueueString.queueValue.length == 0) {
            this.h.e("queue String params is empty in".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.b() != 6) {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= optionalParamQueueString.queueValue.length) {
                    return;
                }
                this.f39168c.addQueueString(convertToNativeOptionalId.c(), optionalParamQueueString.queueValue[i3]);
                i2 = i3 + 1;
            }
        }
    }

    private void a(int i, TPOptionalParam.OptionalParamString optionalParamString) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (2 == convertToNativeOptionalId.b()) {
            this.f39168c.setString(convertToNativeOptionalId.c(), optionalParamString.value);
        } else {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID:" + convertToNativeOptionalId.c() + " is not string");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        this.e.a(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C1012b c1012b) {
        this.e.a(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, c1012b.f39177a), c1012b.f39178c, c1012b.d, Long.valueOf(c1012b.b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.e.a();
    }

    private void b(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamBoolean optionalParamBoolean) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.b() == 3) {
            this.b.setOptionLong(convertToNativeOptionalId.c(), optionalParamBoolean.value ? 1L : 0L, 0L);
        } else {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        }
    }

    private void b(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamLong optionalParamLong) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i)));
            return;
        }
        int b = convertToNativeOptionalId.b();
        if (b == 1 || b == 3 || b == 4) {
            this.b.setOptionLong(convertToNativeOptionalId.c(), optionalParamLong.value, optionalParamLong.param1);
            return;
        }
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
    }

    private void b(int i, TPOptionalParam.OptionalParamObject optionalParamObject) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId == null) {
            this.h.e("player optionaIdMapping object is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.c() == 1001) {
            this.b.setOptionObject(convertToNativeOptionalId.c(), com.tencent.thumbplayer.adapter.a.b.c.a((TPSubtitleRenderModel) optionalParamObject.objectValue));
        } else {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        }
    }

    private void b(@TPCommonEnum.TPOptionalId int i, TPOptionalParam.OptionalParamString optionalParamString) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i);
        if (convertToNativeOptionalId.a()) {
            this.h.e("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i)));
        } else if (convertToNativeOptionalId.b() == 2) {
            this.b.setOptionObject(convertToNativeOptionalId.c(), optionalParamString.value);
        } else {
            com.tencent.thumbplayer.e.a aVar = this.h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.e.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        return f39167a.contains(Integer.valueOf(i));
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(float f) {
        this.h.c("setAudioGainRatio:".concat(String.valueOf(f)));
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.setAudioVolume(f);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i) {
        this.h.c("seekTo:".concat(String.valueOf(i)));
        a();
        if (this.b.seekToAsync(i, 1, 0L) == 0) {
            return;
        }
        throw new IllegalStateException("seek to position:" + i + " failed!!");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, @TPCommonEnum.TPSeekMode int i2) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("seekTo:" + i + " mode:" + i2);
        a();
        if (this.b.seekToAsync(i, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSeekMode.class, i2), 0L) == 0) {
            return;
        }
        throw new IllegalStateException("seek to position:" + i + " failed!!");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(int i, long j) {
        this.h.c("selectTrack");
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.selectTrackAsync(i, j);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            throw new IllegalStateException("setDataSource url afd is null!!");
        }
        int detachFd = assetFileDescriptor.getParcelFileDescriptor().detachFd();
        long startOffset = assetFileDescriptor.getStartOffset();
        long length = assetFileDescriptor.getLength();
        ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(detachFd);
        int detachFd2 = fromFd.detachFd();
        fromFd.close();
        assetFileDescriptor.close();
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("setDataSource: " + assetFileDescriptor + ", playFd: " + detachFd + ", offset: " + startOffset + ", length: " + length + ", captureFd: " + detachFd2);
        a();
        if (this.b.setDataSource(detachFd, startOffset, length) != 0) {
            throw new IllegalStateException("setDataSource url afd failed!!");
        }
        this.f = new com.tencent.thumbplayer.a.d(detachFd2, startOffset, length);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            throw new IllegalStateException("setDataSource url pfd is null!!");
        }
        int detachFd = parcelFileDescriptor.detachFd();
        ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(detachFd);
        int detachFd2 = fromFd.detachFd();
        fromFd.close();
        parcelFileDescriptor.close();
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("setDataSource: " + parcelFileDescriptor + ", playFd:" + detachFd + ", captureFd: " + detachFd2);
        a();
        if (this.b.setDataSource(detachFd, 0L, 0L) != 0) {
            throw new IllegalStateException("setDataSource url pfd failed!!");
        }
        this.f = new com.tencent.thumbplayer.a.d(detachFd2);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(Surface surface) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        StringBuilder sb = new StringBuilder("setSurface, surface is null ? : ");
        sb.append(surface == null);
        aVar.c(sb.toString());
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else if (tPNativePlayer.setVideoSurface(surface) != 0) {
            throw new IllegalStateException("setSurface failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(SurfaceHolder surfaceHolder) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        StringBuilder sb = new StringBuilder("SurfaceHolder, surfaceHolder is null ? : ");
        sb.append(surfaceHolder == null);
        aVar.c(sb.toString());
        if (this.b == null) {
            this.h.d("player has released, return");
        } else if (surfaceHolder != null && surfaceHolder.getSurface() == null) {
            this.h.e("SurfaceHolder，err.");
        } else {
            if (this.b.setVideoSurface(surfaceHolder == null ? null : surfaceHolder.getSurface()) != 0) {
                throw new IllegalStateException("setSurface failed!!");
            }
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.a aVar) {
        this.e.a(aVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.b bVar) {
        this.e.a(bVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.InterfaceC1013c interfaceC1013c) {
        this.e.a(interfaceC1013c);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.d dVar) {
        this.e.a(dVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.e eVar) {
        this.e.a(eVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.f fVar) {
        this.e.a(fVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.g gVar) {
        this.e.a(gVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.h hVar) {
        this.e.a(hVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.i iVar) {
        this.e.a(iVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.j jVar) {
        this.e.a(jVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.l lVar) {
        this.e.a(lVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.m mVar) {
        this.e.a(mVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.n nVar) {
        this.e.a(nVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.o oVar) {
        this.e.a(oVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(c.p pVar) {
        this.e.a(pVar);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        this.h.c("captureVideo, params".concat(String.valueOf(tPCaptureParams)));
        if (this.f == null) {
            tPCaptureCallBack.onCaptureVideoFailed(TPGeneralError.UNMATCHED_STATE);
            return;
        }
        TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
        tPImageGeneratorParams.width = tPCaptureParams.width;
        tPImageGeneratorParams.height = tPCaptureParams.height;
        tPImageGeneratorParams.format = tPCaptureParams.format;
        tPImageGeneratorParams.requestedTimeMsToleranceAfter = tPCaptureParams.requestedTimeMsToleranceAfter;
        tPImageGeneratorParams.requestedTimeMsToleranceBefore = tPCaptureParams.requestedTimeMsToleranceBefore;
        this.f.a(n(), tPImageGeneratorParams, tPCaptureCallBack);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(TPOptionalParam tPOptionalParam) {
        this.h.c("setPlayerOptionalParam:".concat(String.valueOf(tPOptionalParam)));
        if (this.b == null) {
            this.h.d("player has released, return");
        } else if (tPOptionalParam.getParamType() == 1) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamBoolean());
            } else {
                b(tPOptionalParam.getKey(), tPOptionalParam.getParamBoolean());
            }
        } else if (tPOptionalParam.getParamType() == 2) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamLong());
            } else {
                b(tPOptionalParam.getKey(), tPOptionalParam.getParamLong());
            }
        } else if (tPOptionalParam.getParamType() == 6) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamFloat());
            }
        } else if (tPOptionalParam.getParamType() == 3) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamString());
            } else {
                b(tPOptionalParam.getKey(), tPOptionalParam.getParamString());
            }
        } else if (tPOptionalParam.getParamType() == 4) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamQueueInt());
            }
        } else if (tPOptionalParam.getParamType() == 5) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamQueueString());
            }
        } else if (tPOptionalParam.getParamType() != 7) {
            this.h.d("optionalParam param type is unknown, return");
        } else if (tPOptionalParam.getKey() < 500) {
            a(tPOptionalParam.getKey(), tPOptionalParam.getParamObject());
        } else {
            b(tPOptionalParam.getKey(), tPOptionalParam.getParamObject());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset) {
        this.h.c("setDataSource: ".concat(String.valueOf(iTPMediaAsset)));
        a();
        if (iTPMediaAsset == null) {
            throw new IllegalStateException("media asset is null!");
        }
        String url = iTPMediaAsset.getUrl();
        if (this.b.setDataSource(url) != 0) {
            throw new IllegalStateException("setDataSource mediaAsset failed!!");
        }
        this.f = new com.tencent.thumbplayer.a.d(url);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("switchDefinition mediaAsset:" + iTPMediaAsset + " opaque:" + j);
        a();
        if (iTPMediaAsset != null) {
            if (this.b.switchDefinitionAsync(iTPMediaAsset.getUrl(), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, i), j) != 0) {
                throw new IllegalStateException("switchDefinition in invalid state");
            }
            this.f = new com.tencent.thumbplayer.a.d(iTPMediaAsset.getUrl());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(com.tencent.thumbplayer.e.b bVar) {
        this.h.a(new com.tencent.thumbplayer.e.b(bVar, "TPThumbPlayer"));
        if (bVar != null) {
            this.e.a(this.h.a().a());
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str) {
        this.h.c("setAudioNormalizeVolumeParams:".concat(String.valueOf(str)));
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.setAudioNormalizeVolumeParams(str);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("switchDefinition url:" + str + " opaque:" + j);
        a();
        if (this.b.switchDefinitionAsync(str, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, i), j) != 0) {
            throw new IllegalStateException("switchDefinition in invalid state");
        }
        com.tencent.thumbplayer.adapter.a.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a();
            this.f = null;
        }
        this.f = new com.tencent.thumbplayer.a.d(str);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map) {
        this.h.c("setDataSource: ".concat(String.valueOf(str)));
        a();
        if (this.b.setDataSource(str, map) != 0) {
            throw new IllegalStateException("setDataSource url and header failed!!");
        }
        this.f = new com.tencent.thumbplayer.a.d(str);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i, long j) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("switchDefinition url:" + str + "httpHeader:" + map + " opaque:" + j);
        a();
        if (this.b.switchDefinitionAsync(str, map, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, i), j) != 0) {
            throw new IllegalStateException("switchDefinition in invalid state");
        }
        com.tencent.thumbplayer.adapter.a.a aVar2 = this.f;
        if (aVar2 != null) {
            aVar2.a();
            this.f = null;
        }
        this.f = new com.tencent.thumbplayer.a.d(str);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, String str3) {
        this.h.c("addSubtitleSource");
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.addSubtitleTrackSource(str, str3, map);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        this.h.c("addAudioTrackSource");
        if (this.b == null) {
            this.h.d("player has released, return");
            return;
        }
        TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
        tPAudioTrackInfo.audioTrackUrl = str;
        tPAudioTrackInfo.paramData = list;
        g gVar = this.e;
        if (gVar != null) {
            gVar.a(1012, 0L, 0L, tPAudioTrackInfo);
        }
        if (TextUtils.isEmpty(tPAudioTrackInfo.proxyUrl)) {
            this.b.addAudioTrackSource(tPAudioTrackInfo.audioTrackUrl, str2, tPAudioTrackInfo.httpHeader);
        } else {
            this.b.addAudioTrackSource(tPAudioTrackInfo.proxyUrl, str2, tPAudioTrackInfo.httpHeader);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z) {
        this.h.c("setOutputMute:".concat(String.valueOf(z)));
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.setAudioMute(z);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void a(boolean z, long j, long j2) {
        com.tencent.thumbplayer.e.a aVar = this.h;
        aVar.c("setLoopback:" + z + " loopStartPositionMs:" + j + " loopEndPositionMs:" + j2);
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else if (tPNativePlayer.setLoopback(z, j, j2) != 0) {
            throw new IllegalStateException("set loopback failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long b(int i) {
        this.h.c("getPropertyLong:".concat(String.valueOf(i)));
        a();
        int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, i);
        if (nativeIntValue < 0) {
            this.h.d("paramId not found, return -1");
            return -1L;
        }
        return this.b.getPropertyLong(nativeIntValue);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(float f) {
        this.h.c("setPlaySpeedRatio:".concat(String.valueOf(f)));
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.setPlaybackRate(f);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(int i, long j) {
        this.h.c("selectTrack");
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.deselectTrackAsync(i, j);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void b(boolean z) {
        this.h.c("setLoopback:".concat(String.valueOf(z)));
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.setLoopback(z, 0L, -1L);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPDynamicStatisticParams c(boolean z) {
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            return null;
        }
        return tPNativePlayer.getDynamicStatisticParams(z);
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public String c(int i) {
        this.h.c("getPropertyString:".concat(String.valueOf(i)));
        a();
        try {
            int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, i);
            if (nativeIntValue < 0) {
                com.tencent.thumbplayer.e.a aVar = this.h;
                aVar.d("getPropertyString, tpToNativeValue(TPNativeKeyMap.MapPropertyId.class," + i + "), return" + nativeIntValue);
                return "";
            }
            return this.b.getPropertyString(nativeIntValue);
        } catch (IllegalArgumentException e2) {
            this.h.d("paramId not found, return");
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void c(int i, long j) {
        this.h.c("selectProgram, programIndex:".concat(String.valueOf(i)));
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.d("player has released, return");
        } else {
            tPNativePlayer.selectProgramAsync(i, j);
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void f() {
        this.h.c(bc.b.Code);
        a();
        this.b.setInitConfig(this.f39168c);
        if (this.b.prepare() != 0) {
            throw new IllegalStateException("prepare failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void g() {
        this.h.c("prepareAsync");
        a();
        this.b.setInitConfig(this.f39168c);
        if (this.b.prepareAsync() != 0) {
            throw new IllegalStateException("prepareAsync failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void h() {
        this.h.c("start");
        a();
        if (this.b.start() != 0) {
            throw new IllegalStateException("start failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void i() {
        this.h.c(com.anythink.expressad.foundation.d.c.cb);
        a();
        if (this.b.pause() != 0) {
            throw new IllegalStateException("pause failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void j() {
        this.h.c("stop");
        a();
        this.h.c("stop before");
        int stop = this.b.stop();
        this.h.c("stop after");
        if (stop != 0) {
            throw new IllegalStateException("stop failed!!");
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void k() {
        this.h.c("reset");
        if (this.b == null) {
            this.h.d("reset, player has released.");
            return;
        }
        this.h.c("reset before");
        this.b.reset();
        a aVar = this.d;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages(null);
        }
        this.h.c("reset after");
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public void l() {
        this.h.c("release");
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer != null) {
            tPNativePlayer.release();
            this.b = null;
        }
        com.tencent.thumbplayer.adapter.a.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
            this.f = null;
        }
        a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.removeCallbacksAndMessages(null);
            this.d = null;
        }
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long m() {
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return 0L;
        }
        return tPNativePlayer.getDurationMs();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long n() {
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return 0L;
        }
        return tPNativePlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long o() {
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return 0L;
        }
        return tPNativePlayer.getBufferedDurationMs() + this.b.getCurrentPositionMs();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int p() {
        this.h.c("getVideoWidth");
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return 0;
        }
        return tPNativePlayer.getVideoWidth();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public int q() {
        this.h.c("getVideoHeight");
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return 0;
        }
        return tPNativePlayer.getVideoHeight();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPTrackInfo[] r() {
        this.h.c("getTrackInfo");
        TPNativePlayer tPNativePlayer = this.b;
        TPTrackInfo[] tPTrackInfoArr = null;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return null;
        }
        TPMediaTrackInfo[] trackInfo = tPNativePlayer.getTrackInfo();
        if (trackInfo != null) {
            if (trackInfo.length > 0) {
                TPTrackInfo[] tPTrackInfoArr2 = new TPTrackInfo[trackInfo.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    tPTrackInfoArr = tPTrackInfoArr2;
                    if (i2 >= trackInfo.length) {
                        break;
                    }
                    tPTrackInfoArr2[i2] = a(trackInfo[i2]);
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        }
        return tPTrackInfoArr;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPProgramInfo[] s() {
        this.h.c("getProgramInfo");
        TPNativePlayer tPNativePlayer = this.b;
        TPProgramInfo[] tPProgramInfoArr = null;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return 0");
            return null;
        }
        TPNativePlayerProgramInfo[] programInfo = tPNativePlayer.getProgramInfo();
        if (programInfo != null) {
            if (programInfo.length > 0) {
                TPProgramInfo[] tPProgramInfoArr2 = new TPProgramInfo[programInfo.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    tPProgramInfoArr = tPProgramInfoArr2;
                    if (i2 >= programInfo.length) {
                        break;
                    }
                    tPProgramInfoArr2[i2] = a(programInfo[i2]);
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        }
        return tPProgramInfoArr;
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public long t() {
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            this.h.c("player has released, return -1");
            return -1L;
        }
        return tPNativePlayer.getDemuxerOffsetInFile();
    }

    @Override // com.tencent.thumbplayer.adapter.a.b
    public TPGeneralPlayFlowParams u() {
        TPNativePlayer tPNativePlayer = this.b;
        if (tPNativePlayer == null) {
            return null;
        }
        return tPNativePlayer.getGeneralPlayFlowParams();
    }
}
