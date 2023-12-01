package com.tencent.thumbplayer.adapter.a;

import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c.class */
public class c {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$a.class */
    public interface a {
        void a(TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$b.class */
    public interface b {
        TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    /* renamed from: com.tencent.thumbplayer.adapter.a.c$c  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$c.class */
    public interface InterfaceC1013c {
        void b();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$d.class */
    public interface d {
        TPRemoteSdpInfo a(String str, int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$e.class */
    public interface e {
        void a(TPPlayerDetailInfo tPPlayerDetailInfo);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$f.class */
    public interface f {
        void a(@TPCommonEnum.TPErrorType int i, int i2, long j, long j2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$g.class */
    public interface g {
        void a(TPDrmInfo tPDrmInfo);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$h.class */
    public interface h {
        void a(int i, long j, long j2, Object obj);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$i.class */
    public interface i {
        void a();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$j.class */
    public interface j {
        void c();
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$k.class */
    public interface k {
        void b(int i, int i2);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$l.class */
    public interface l {
        void a(TPSubtitleData tPSubtitleData);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$m.class */
    public interface m {
        void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$n.class */
    public interface n {
        void a(TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$o.class */
    public interface o {
        TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/a/c$p.class */
    public interface p {
        void a(long j, long j2);
    }
}
