package com.tencent.thumbplayer.tplayer;

import android.text.TextUtils;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/c.class */
public class c implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDemuxerListener, ITPPlayerListener.IOnDetailInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private ITPPlayerListener.IOnPreparedListener f39404a;
    private ITPPlayerListener.IOnCompletionListener b;

    /* renamed from: c  reason: collision with root package name */
    private ITPPlayerListener.IOnInfoListener f39405c;
    private ITPPlayerListener.IOnErrorListener d;
    private ITPPlayerListener.IOnSeekCompleteListener e;
    private ITPPlayerListener.IOnVideoSizeChangedListener f;
    private ITPPlayerListener.IOnSubtitleDataListener g;
    private ITPPlayerListener.IOnSubtitleFrameOutListener h;
    private ITPPlayerListener.IOnVideoFrameOutListener i;
    private ITPPlayerListener.IOnAudioFrameOutputListener j;
    private ITPPlayerListener.IOnVideoProcessFrameOutputListener k;
    private ITPPlayerListener.IOnAudioProcessFrameOutputListener l;
    private ITPPlayerListener.IOnStateChangeListener m;
    private ITPPlayerListener.IOnStopAsyncCompleteListener n;
    private ITPPlayerListener.IOnDetailInfoListener o;
    private ITPPlayerListener.IOnDemuxerListener p;
    private a q;
    private String r = "TPPlayerListenerS";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/tplayer/c$a.class */
    public static class a implements ITPPlayerListener.IOnAudioFrameOutputListener, ITPPlayerListener.IOnAudioProcessFrameOutputListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDemuxerListener, ITPPlayerListener.IOnDetailInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnStateChangeListener, ITPPlayerListener.IOnStopAsyncCompleteListener, ITPPlayerListener.IOnSubtitleDataListener, ITPPlayerListener.IOnSubtitleFrameOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnVideoProcessFrameOutputListener, ITPPlayerListener.IOnVideoSizeChangedListener {

        /* renamed from: a  reason: collision with root package name */
        private String f39406a;

        public a(String str) {
            this.f39406a = str;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener
        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onAudioFrameOut");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener
        public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onPostProcessFrameOut");
            return null;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onCompletion");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnDetailInfoListener
        public void onDetailInfo(ITPPlayer iTPPlayer, TPPlayerDetailInfo tPPlayerDetailInfo) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onDetailInfo");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, int i, int i2, long j, long j2) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onError");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i, long j, long j2, Object obj) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onInfo");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onPrepared");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnDemuxerListener
        public TPRemoteSdpInfo onSdpExchange(ITPPlayer iTPPlayer, String str, int i) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onSdpExchange");
            return null;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onSeekComplete");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
        public void onStateChange(int i, int i2) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onStateChange");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener
        public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onStopAsyncComplete");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener
        public void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onSubtitleData");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener
        public void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onSubtitleFrameOut");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener
        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onVideoFrameOut");
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener
        public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onPostProcessFrameOut");
            return null;
        }

        @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, long j, long j2) {
            TPLogUtil.i(this.f39406a, " empty player listener , notify , onVideoSizeChanged");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str) {
        a(str);
        a aVar = new a(this.r);
        this.q = aVar;
        this.f39404a = aVar;
        this.b = aVar;
        this.f39405c = aVar;
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.h = aVar;
        this.i = aVar;
        this.j = aVar;
        this.k = aVar;
        this.l = aVar;
        this.m = aVar;
        this.n = aVar;
        this.o = aVar;
        this.p = aVar;
    }

    public void a() {
        a aVar = this.q;
        this.f39404a = aVar;
        this.b = aVar;
        this.f39405c = aVar;
        this.d = aVar;
        this.e = aVar;
        this.f = aVar;
        this.g = aVar;
        this.i = aVar;
        this.j = aVar;
        this.m = aVar;
        this.n = aVar;
        this.o = aVar;
        this.p = aVar;
    }

    public void a(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener) {
        a aVar = iOnAudioFrameOutputListener;
        if (iOnAudioFrameOutputListener == null) {
            aVar = this.q;
        }
        this.j = aVar;
    }

    public void a(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener) {
        a aVar = iOnAudioProcessFrameOutputListener;
        if (iOnAudioProcessFrameOutputListener == null) {
            aVar = this.q;
        }
        this.l = aVar;
    }

    public void a(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        a aVar = iOnCompletionListener;
        if (iOnCompletionListener == null) {
            aVar = this.q;
        }
        this.b = aVar;
    }

    public void a(ITPPlayerListener.IOnDemuxerListener iOnDemuxerListener) {
        a aVar = iOnDemuxerListener;
        if (iOnDemuxerListener == null) {
            aVar = this.q;
        }
        this.p = aVar;
    }

    public void a(ITPPlayerListener.IOnDetailInfoListener iOnDetailInfoListener) {
        a aVar = iOnDetailInfoListener;
        if (iOnDetailInfoListener == null) {
            aVar = this.q;
        }
        this.o = aVar;
    }

    public void a(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        a aVar = iOnErrorListener;
        if (iOnErrorListener == null) {
            aVar = this.q;
        }
        this.d = aVar;
    }

    public void a(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        a aVar = iOnInfoListener;
        if (iOnInfoListener == null) {
            aVar = this.q;
        }
        this.f39405c = aVar;
    }

    public void a(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        a aVar = iOnPreparedListener;
        if (iOnPreparedListener == null) {
            aVar = this.q;
        }
        this.f39404a = aVar;
    }

    public void a(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        a aVar = iOnSeekCompleteListener;
        if (iOnSeekCompleteListener == null) {
            aVar = this.q;
        }
        this.e = aVar;
    }

    public void a(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener) {
        a aVar = iOnStateChangeListener;
        if (iOnStateChangeListener == null) {
            aVar = this.q;
        }
        this.m = aVar;
    }

    public void a(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        a aVar = iOnStopAsyncCompleteListener;
        if (iOnStopAsyncCompleteListener == null) {
            aVar = this.q;
        }
        this.n = aVar;
    }

    public void a(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener) {
        a aVar = iOnSubtitleDataListener;
        if (iOnSubtitleDataListener == null) {
            aVar = this.q;
        }
        this.g = aVar;
    }

    public void a(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener) {
        a aVar = iOnSubtitleFrameOutListener;
        if (iOnSubtitleFrameOutListener == null) {
            aVar = this.q;
        }
        this.h = aVar;
    }

    public void a(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        a aVar = iOnVideoFrameOutListener;
        if (iOnVideoFrameOutListener == null) {
            aVar = this.q;
        }
        this.i = aVar;
    }

    public void a(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener) {
        a aVar = iOnVideoProcessFrameOutputListener;
        if (iOnVideoProcessFrameOutputListener == null) {
            aVar = this.q;
        }
        this.k = aVar;
    }

    public void a(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        a aVar = iOnVideoSizeChangedListener;
        if (iOnVideoSizeChangedListener == null) {
            aVar = this.q;
        }
        this.f = aVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.r = "TPPlayerListenerS";
        } else {
            this.r = str;
        }
        a aVar = this.q;
        if (aVar != null) {
            aVar.f39406a = str;
        }
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener
    public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
        this.j.onAudioFrameOut(iTPPlayer, tPAudioFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioProcessFrameOutputListener
    public TPPostProcessFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.l.onAudioProcessFrameOut(iTPPlayer, tPPostProcessFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener
    public void onCompletion(ITPPlayer iTPPlayer) {
        this.b.onCompletion(iTPPlayer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnDetailInfoListener
    public void onDetailInfo(ITPPlayer iTPPlayer, TPPlayerDetailInfo tPPlayerDetailInfo) {
        this.o.onDetailInfo(iTPPlayer, tPPlayerDetailInfo);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener
    public void onError(ITPPlayer iTPPlayer, int i, int i2, long j, long j2) {
        this.d.onError(iTPPlayer, i, i2, j, j2);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener
    public void onInfo(ITPPlayer iTPPlayer, int i, long j, long j2, Object obj) {
        this.f39405c.onInfo(iTPPlayer, i, j, j2, obj);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener
    public void onPrepared(ITPPlayer iTPPlayer) {
        this.f39404a.onPrepared(iTPPlayer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnDemuxerListener
    public TPRemoteSdpInfo onSdpExchange(ITPPlayer iTPPlayer, String str, int i) {
        return this.p.onSdpExchange(iTPPlayer, str, i);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener
    public void onSeekComplete(ITPPlayer iTPPlayer) {
        this.e.onSeekComplete(iTPPlayer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStateChangeListener
    public void onStateChange(int i, int i2) {
        this.m.onStateChange(i, i2);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener
    public void onStopAsyncComplete(ITPPlayer iTPPlayer) {
        this.n.onStopAsyncComplete(iTPPlayer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleDataListener
    public void onSubtitleData(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
        this.g.onSubtitleData(iTPPlayer, tPSubtitleData);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnSubtitleFrameOutListener
    public void onSubtitleFrameOut(ITPPlayer iTPPlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        this.h.onSubtitleFrameOut(iTPPlayer, tPSubtitleFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoFrameOutListener
    public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.i.onVideoFrameOut(iTPPlayer, tPVideoFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoProcessFrameOutputListener
    public TPPostProcessFrameBuffer onVideoProcessFrameOut(ITPPlayer iTPPlayer, TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.k.onVideoProcessFrameOut(iTPPlayer, tPPostProcessFrameBuffer);
    }

    @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnVideoSizeChangedListener
    public void onVideoSizeChanged(ITPPlayer iTPPlayer, long j, long j2) {
        this.f.onVideoSizeChanged(iTPPlayer, j, j2);
    }
}
