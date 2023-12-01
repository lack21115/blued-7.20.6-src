package com.tencent.txcopyrightedmedia.impl.utils;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.txcopyrightedmedia.ErrorCode;
import com.tencent.txcopyrightedmedia.IAndroidAudioTrack;
import com.tencent.txcopyrightedmedia.ITXCMMusicTrack;
import com.tencent.txcopyrightedmedia.TXCMAudioFrameInfo;
import com.tencent.txcopyrightedmedia.TXCMMusicInfo;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import com.tencent.txcopyrightedmedia.agora.ITXCMAgoraRtcEngine;
import com.tencent.txcopyrightedmedia.impl.utils.av;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAux;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAuxCallbackEx;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioMixingHandler;
import com.tencent.txcopyrightedmedia.zego.ITXCMZegoExpressEngine;
import com.tencent.txcopyrightedmedia.zego.TXCMAuxDataEx;
import com.tencent.txcopyrightedmedia.zego.TXCMZegoAudioMixingData;
import com.zego.zegoavkit2.audioaux.IZegoAudioAuxCallbackEx;
import com.zego.zegoavkit2.audioaux.ZegoAudioAux;
import com.zego.zegoavkit2.entities.AuxDataEx;
import im.zego.zegoexpress.ZegoExpressEngine;
import im.zego.zegoexpress.callback.IZegoAudioMixingHandler;
import im.zego.zegoexpress.constants.ZegoAudioChannel;
import im.zego.zegoexpress.constants.ZegoAudioSampleRate;
import im.zego.zegoexpress.entity.ZegoAudioFrameParam;
import im.zego.zegoexpress.entity.ZegoAudioMixingData;
import io.agora.rtc.RtcEngine;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private av f26421a;
    private t b;

    /* renamed from: c  reason: collision with root package name */
    private ag f26422c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/n$a.class */
    public final class a implements ITXCMMusicTrack {
        private final TXCMMusicInfo b;

        /* renamed from: c  reason: collision with root package name */
        private ITXCMMusicTrack.OnErrorListener f26424c;
        private ITXCMMusicTrack.OnPreparedListener d;
        private HandlerThread e;
        private final Handler f;
        private Handler g;
        private String h;
        private be i;
        private boolean j;

        /* renamed from: com.tencent.txcopyrightedmedia.impl.utils.n$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/n$a$a.class */
        final class C0895a implements ITXCMAgoraRtcEngine {
            private RtcEngine b;

            private C0895a(Object obj) {
                try {
                    this.b = (RtcEngine) obj;
                } catch (Error e) {
                    e.printStackTrace();
                }
            }

            /* synthetic */ C0895a(a aVar, Object obj, byte b) {
                this(obj);
            }

            @Override // com.tencent.txcopyrightedmedia.agora.ITXCMAgoraRtcEngine
            public final int pushExternalAudioFrame(TXCMAudioFrameInfo tXCMAudioFrameInfo, long j) {
                av.a a2;
                if (tXCMAudioFrameInfo == null || n.this.f26421a == null || (a2 = n.this.f26421a.a(tXCMAudioFrameInfo.frameId)) == null) {
                    return -1;
                }
                int pushExternalAudioFrame = this.b.pushExternalAudioFrame(a2.b, j);
                if (a2.f26386c <= 0) {
                    n.this.f26421a.a(a2);
                }
                return pushExternalAudioFrame;
            }

            @Override // com.tencent.txcopyrightedmedia.agora.ITXCMAgoraRtcEngine
            public final int pushExternalAudioFrame(TXCMAudioFrameInfo tXCMAudioFrameInfo, long j, int i, int i2, int i3, int i4) {
                av.a a2;
                if (tXCMAudioFrameInfo == null || n.this.f26421a == null || (a2 = n.this.f26421a.a(tXCMAudioFrameInfo.frameId)) == null) {
                    return -1;
                }
                int pushExternalAudioFrame = this.b.pushExternalAudioFrame(a2.b, j, i, i2, i3, i4);
                if (a2.f26386c <= 0) {
                    n.this.f26421a.a(a2);
                }
                return pushExternalAudioFrame;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/n$a$b.class */
        final class b implements IAndroidAudioTrack {
            private AudioTrack b;

            private b(Object obj) {
                try {
                    this.b = (AudioTrack) obj;
                } catch (Error e) {
                    e.printStackTrace();
                }
            }

            /* synthetic */ b(a aVar, Object obj, byte b) {
                this(obj);
            }

            @Override // com.tencent.txcopyrightedmedia.IAndroidAudioTrack
            public final int write(TXCMAudioFrameInfo tXCMAudioFrameInfo, int i, int i2) {
                av.a a2;
                if (tXCMAudioFrameInfo == null || n.this.f26421a == null || (a2 = n.this.f26421a.a(tXCMAudioFrameInfo.frameId)) == null) {
                    return -1;
                }
                int write = this.b.write(a2.b, i, i2);
                if (a2.f26386c <= 0) {
                    n.this.f26421a.a(a2);
                }
                return write;
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/n$a$c.class */
        final class c implements ITXCMZegoAudioAux {
            private ZegoAudioAux b;

            /* renamed from: c  reason: collision with root package name */
            private TXCMAuxDataEx f26433c;

            private c(Object obj) {
                try {
                    this.b = (ZegoAudioAux) obj;
                } catch (Error e) {
                    e.printStackTrace();
                }
                n.this.f26422c = new ag(a.this.getMinBufferSize());
            }

            /* synthetic */ c(a aVar, Object obj, byte b) {
                this(obj);
            }

            @Override // com.tencent.txcopyrightedmedia.zego.ITXCMZegoAudioAux
            public final void setZegoAuxCallbackEx(final ITXCMZegoAudioAuxCallbackEx iTXCMZegoAudioAuxCallbackEx) {
                if (iTXCMZegoAudioAuxCallbackEx == null) {
                    this.b.setZegoAuxCallbackEx(null);
                } else {
                    this.b.setZegoAuxCallbackEx(new IZegoAudioAuxCallbackEx() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.c.1
                        @Override // com.zego.zegoavkit2.audioaux.IZegoAudioAuxCallbackEx
                        public final AuxDataEx onAuxCallback(int i) {
                            AuxDataEx auxDataEx;
                            TXCMAuxDataEx onAuxCallback;
                            av.a a2;
                            AuxDataEx auxDataEx2 = null;
                            while (true) {
                                auxDataEx = auxDataEx2;
                                if (n.this.f26422c.a() >= i || (onAuxCallback = iTXCMZegoAudioAuxCallbackEx.onAuxCallback()) == null || onAuxCallback.auxDataInfo == null || n.this.f26421a == null || (a2 = n.this.f26421a.a(onAuxCallback.auxDataInfo.frameId)) == null) {
                                    break;
                                }
                                int i2 = 0;
                                while (i2 < onAuxCallback.auxDataInfo.size) {
                                    if (n.this.f26422c.a(a2.b[i2])) {
                                        i2++;
                                    } else {
                                        n.this.f26422c.a((n.this.f26422c.f26355a.length + onAuxCallback.auxDataInfo.size) - i2);
                                        new StringBuilder("expand to ").append(n.this.f26422c.f26355a.length);
                                    }
                                }
                                if (a2.f26386c <= 0) {
                                    n.this.f26421a.a(a2);
                                }
                                AuxDataEx auxDataEx3 = auxDataEx;
                                if (auxDataEx == null) {
                                    auxDataEx3 = new AuxDataEx();
                                }
                                if (onAuxCallback.mediaSideInfoBuf != null) {
                                    auxDataEx3.mediaSideInfoBuf = onAuxCallback.mediaSideInfoBuf;
                                    auxDataEx3.mediaSideInfoBufLen = onAuxCallback.mediaSideInfoBufLen;
                                }
                                auxDataEx3.packet = onAuxCallback.packet;
                                c.this.f26433c = onAuxCallback;
                                auxDataEx2 = auxDataEx3;
                            }
                            AuxDataEx auxDataEx4 = auxDataEx;
                            if (auxDataEx == null) {
                                AuxDataEx auxDataEx5 = new AuxDataEx();
                                auxDataEx4 = auxDataEx5;
                                if (c.this.f26433c != null) {
                                    auxDataEx5.packet = c.this.f26433c.packet;
                                    auxDataEx4 = auxDataEx5;
                                }
                            }
                            auxDataEx4.sampleRate = a.this.getSampleRate();
                            auxDataEx4.channelCount = a.this.getChannelCount();
                            int min = Math.min(n.this.f26422c.a(), i);
                            if (min == 0) {
                                return null;
                            }
                            byte[] bArr = new byte[min];
                            n.this.f26422c.a(bArr, min);
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(min);
                            allocateDirect.put(bArr);
                            allocateDirect.flip();
                            auxDataEx4.auxDataBuf = allocateDirect;
                            auxDataEx4.auxDataBufLen = min;
                            return auxDataEx4;
                        }
                    });
                }
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/n$a$d.class */
        final class d implements ITXCMZegoExpressEngine {
            private ZegoExpressEngine b;

            /* renamed from: c  reason: collision with root package name */
            private TXCMZegoAudioMixingData f26436c;

            private d(Object obj) {
                try {
                    this.b = (ZegoExpressEngine) obj;
                } catch (Error e) {
                    e.printStackTrace();
                }
                n.this.f26422c = new ag(a.this.getMinBufferSize());
            }

            /* synthetic */ d(a aVar, Object obj, byte b) {
                this(obj);
            }

            @Override // com.tencent.txcopyrightedmedia.zego.ITXCMZegoExpressEngine
            public final void setAudioMixingHandler(final ITXCMZegoAudioMixingHandler iTXCMZegoAudioMixingHandler) {
                if (iTXCMZegoAudioMixingHandler == null) {
                    this.b.setAudioMixingHandler((IZegoAudioMixingHandler) null);
                } else {
                    this.b.setAudioMixingHandler(new IZegoAudioMixingHandler() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.d.1
                        public final ZegoAudioMixingData onAudioMixingCopyData(int i) {
                            ZegoAudioMixingData zegoAudioMixingData;
                            TXCMZegoAudioMixingData onAudioMixingCopyData;
                            av.a a2;
                            ZegoAudioMixingData zegoAudioMixingData2 = null;
                            while (true) {
                                zegoAudioMixingData = zegoAudioMixingData2;
                                if (n.this.f26422c.a() >= i || (onAudioMixingCopyData = iTXCMZegoAudioMixingHandler.onAudioMixingCopyData()) == null || onAudioMixingCopyData.audioInfo == null || n.this.f26421a == null || (a2 = n.this.f26421a.a(onAudioMixingCopyData.audioInfo.frameId)) == null) {
                                    break;
                                }
                                int i2 = 0;
                                while (i2 < onAudioMixingCopyData.audioInfo.size) {
                                    if (n.this.f26422c.a(a2.b[i2])) {
                                        i2++;
                                    } else {
                                        n.this.f26422c.a((n.this.f26422c.f26355a.length + onAudioMixingCopyData.audioInfo.size) - i2);
                                        new StringBuilder("expand to ").append(n.this.f26422c.f26355a.length);
                                    }
                                }
                                if (a2.f26386c <= 0) {
                                    n.this.f26421a.a(a2);
                                }
                                ZegoAudioMixingData zegoAudioMixingData3 = zegoAudioMixingData;
                                if (zegoAudioMixingData == null) {
                                    zegoAudioMixingData3 = new ZegoAudioMixingData();
                                }
                                if (onAudioMixingCopyData.SEIData != null) {
                                    zegoAudioMixingData3.SEIData = onAudioMixingCopyData.SEIData;
                                    zegoAudioMixingData3.SEIDataLength = onAudioMixingCopyData.SEIDataLength;
                                }
                                if (onAudioMixingCopyData.param != null) {
                                    zegoAudioMixingData3.param = onAudioMixingCopyData.param;
                                }
                                d.this.f26436c = onAudioMixingCopyData;
                                zegoAudioMixingData2 = zegoAudioMixingData3;
                            }
                            ZegoAudioMixingData zegoAudioMixingData4 = zegoAudioMixingData;
                            if (zegoAudioMixingData == null) {
                                ZegoAudioMixingData zegoAudioMixingData5 = new ZegoAudioMixingData();
                                zegoAudioMixingData4 = zegoAudioMixingData5;
                                if (d.this.f26436c != null) {
                                    zegoAudioMixingData5.param = d.this.f26436c.param;
                                    zegoAudioMixingData4 = zegoAudioMixingData5;
                                }
                            }
                            if (zegoAudioMixingData4.param == null) {
                                zegoAudioMixingData4.param = new ZegoAudioFrameParam();
                                zegoAudioMixingData4.param.channel = ZegoAudioChannel.getZegoAudioChannel(a.this.getChannelCount());
                                zegoAudioMixingData4.param.sampleRate = ZegoAudioSampleRate.getZegoAudioSampleRate(a.this.getSampleRate());
                            }
                            int min = Math.min(n.this.f26422c.a(), i);
                            if (min == 0) {
                                return null;
                            }
                            byte[] bArr = new byte[min];
                            n.this.f26422c.a(bArr, min);
                            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(min);
                            allocateDirect.put(bArr);
                            allocateDirect.flip();
                            zegoAudioMixingData4.audioData = allocateDirect;
                            zegoAudioMixingData4.audioDataLength = min;
                            return zegoAudioMixingData4;
                        }
                    });
                }
            }
        }

        private a(TXCMMusicInfo tXCMMusicInfo) {
            n.this.b = new t();
            this.f = new Handler(Looper.getMainLooper());
            this.b = tXCMMusicInfo;
            if (tXCMMusicInfo != null) {
                HandlerThread handlerThread = new HandlerThread("ame-audio-track");
                this.e = handlerThread;
                handlerThread.start();
                this.g = new Handler(this.e.getLooper());
            }
        }

        /* synthetic */ a(n nVar, TXCMMusicInfo tXCMMusicInfo, byte b2) {
            this(tXCMMusicInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(17:17|18|(2:20|(14:22|23|(5:26|27|(4:29|30|31|(2:33|34)(1:36))(1:37)|35|24)|38|39|(1:41)|43|(2:44|(2:46|47)(2:79|80))|49|50|51|(5:53|(1:55)|56|(1:58)(1:60)|59)|61|(2:63|64)(4:65|(1:67)|68|(2:70|71)(2:72|73))))|81|23|(1:24)|38|39|(0)|43|(2:44|(0)(0))|49|50|51|(0)|61|(0)(0)) */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0220, code lost:
            r14 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0222, code lost:
            r14.printStackTrace();
         */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x0215 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x01ae A[Catch: all -> 0x035d, IOException -> 0x0365, TRY_LEAVE, TryCatch #1 {IOException -> 0x0365, blocks: (B:21:0x0166, B:23:0x016e, B:25:0x0190, B:26:0x01a2, B:28:0x01ae, B:31:0x01bd, B:33:0x01cd, B:35:0x01d5, B:36:0x01e1, B:38:0x01ec), top: B:108:0x0166, outer: #7 }] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01ec A[Catch: all -> 0x035d, IOException -> 0x0365, TryCatch #1 {IOException -> 0x0365, blocks: (B:21:0x0166, B:23:0x016e, B:25:0x0190, B:26:0x01a2, B:28:0x01ae, B:31:0x01bd, B:33:0x01cd, B:35:0x01d5, B:36:0x01e1, B:38:0x01ec), top: B:108:0x0166, outer: #7 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x023a  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x02d0  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x02d3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.tencent.txcopyrightedmedia.ErrorCode a() {
            /*
                Method dump skipped, instructions count: 1082
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.n.a.a():com.tencent.txcopyrightedmedia.ErrorCode");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(final ErrorCode errorCode) {
            if (this.f26424c != null) {
                this.f.post(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.f26424c.onError(errorCode.code, errorCode.msg);
                    }
                });
            }
        }

        static /* synthetic */ void b(a aVar) {
            if (aVar.d != null) {
                aVar.f.post(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.d.onPrepared();
                    }
                });
            }
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void destroy() {
            this.j = true;
            be beVar = this.i;
            if (beVar != null && beVar.h) {
                beVar.d = System.currentTimeMillis() / 1000;
                beVar.e = "PCM_FinishPlay";
                beVar.g = beVar.f;
                ah.a().a(beVar);
            }
            n.this.b.b();
            if (n.this.f26421a != null) {
                av avVar = n.this.f26421a;
                synchronized (avVar.f26384c) {
                    avVar.b.clear();
                    avVar.f26383a.clear();
                }
            }
            Handler handler = this.g;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        h hVar = (h) m.a().b(m.f26419c);
                        if (hVar != null && a.this.h != null) {
                            hVar.a(a.this.h);
                        }
                        a.this.e.quit();
                    }
                });
            }
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final int getChannelCount() {
            return n.this.b.f26464c;
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final int getDuration() {
            return (int) n.this.b.d;
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final int getMinBufferSize() {
            String str = n.this.b.j;
            return (!TextUtils.isEmpty(str) ? str.contains("mpeg") ? 1152 : 1024 : 1200) * n.this.b.f26464c * 2;
        }

        /* JADX WARN: Type inference failed for: r0v17, types: [T, com.tencent.txcopyrightedmedia.impl.utils.n$a$c] */
        /* JADX WARN: Type inference failed for: r0v22, types: [T, com.tencent.txcopyrightedmedia.impl.utils.n$a$d] */
        /* JADX WARN: Type inference failed for: r0v27, types: [T, com.tencent.txcopyrightedmedia.impl.utils.n$a$b] */
        /* JADX WARN: Type inference failed for: r0v32, types: [T, com.tencent.txcopyrightedmedia.impl.utils.n$a$a] */
        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final <T> T getProxy(Object obj) {
            if (TextUtils.equals(obj.getClass().getName(), "io.agora.rtc.internal.RtcEngineImpl")) {
                ?? r0 = (T) new C0895a(this, obj, (byte) 0);
                if (((C0895a) r0).b != null) {
                    return r0;
                }
                return null;
            } else if (TextUtils.equals(obj.getClass().getName(), "android.media.AudioTrack")) {
                ?? r02 = (T) new b(this, obj, (byte) 0);
                if (((b) r02).b != null) {
                    return r02;
                }
                return null;
            } else if (TextUtils.equals(obj.getClass().getName(), "im.zego.zegoexpress.internal.ZegoExpressEngineInternalImpl")) {
                ?? r03 = (T) new d(this, obj, (byte) 0);
                if (((d) r03).b != null) {
                    return r03;
                }
                return null;
            } else if (TextUtils.equals(obj.getClass().getName(), "com.zego.zegoavkit2.audioaux.ZegoAudioAux")) {
                ?? r04 = (T) new c(this, obj, (byte) 0);
                if (((c) r04).b != null) {
                    return r04;
                }
                return null;
            } else {
                return null;
            }
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final int getSampleRate() {
            return n.this.b.b;
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void prepare() {
            if (this.b == null) {
                a(new i(-1, "MusicInfo not set."));
                return;
            }
            int a2 = ap.a().a(TXCopyrightedMedia.instance().getApplicationContext());
            if (a2 != 0) {
                a(new i(-8, "Licence fail. ".concat(String.valueOf(a2))));
            } else if (n.this.b.c()) {
            } else {
                if (this.j) {
                    a(new i(-1, "MusicTrack has destroy."));
                }
                this.g.post(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ErrorCode a3 = a.this.a();
                        if (a3 != null) {
                            if (a3.code == 0) {
                                a.b(a.this);
                            } else {
                                a.this.a(a3);
                            }
                        }
                    }
                });
            }
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final int prepareSync() {
            if (this.b == null) {
                return -1;
            }
            if (ap.a().a(TXCopyrightedMedia.instance().getApplicationContext()) != 0) {
                return -8;
            }
            if (n.this.b.c()) {
                return 0;
            }
            if (this.j) {
                return -1;
            }
            ErrorCode a2 = a();
            if (a2 != null) {
                return a2.code;
            }
            return 0;
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final int readAudioFrame(TXCMAudioFrameInfo tXCMAudioFrameInfo) {
            int i;
            if (tXCMAudioFrameInfo == null || n.this.f26421a == null) {
                return -1;
            }
            av.a a2 = n.this.f26421a.a();
            a2.f26386c = com.tencent.txcopyrightedmedia.b.a(tXCMAudioFrameInfo);
            synchronized (a.class) {
                try {
                    byte[] bArr = a2.b;
                    t tVar = n.this.b;
                    if (tVar.m == 0 || tVar.g == null) {
                        i = 0;
                    } else if (tVar.g.c() == -1) {
                        i = -1;
                    } else {
                        tVar.l = tVar.k;
                        new StringBuilder("read: update mLastFrameTimeUs: ").append(tVar.l);
                        i = tVar.g.a(bArr);
                    }
                    if (i != -1 && this.i != null) {
                        be beVar = this.i;
                        beVar.f += (((i * 1000.0f) / n.this.b.f26464c) / 2.0f) / n.this.b.b;
                        if (beVar.f - beVar.g > 5000.0d) {
                            beVar.d = System.currentTimeMillis() / 1000;
                            beVar.e = "PCM_TimedEvent";
                            beVar.g = beVar.f;
                            ah.a().a(beVar);
                        }
                    }
                    t tVar2 = n.this.b;
                    new StringBuilder("getPresentTimeMs: ").append(tVar2.l);
                    tXCMAudioFrameInfo.timestamp = tVar2.l / 1000;
                } catch (Throwable th) {
                    throw th;
                }
            }
            av avVar = n.this.f26421a;
            if (i > 0) {
                avVar.b(a2);
                tXCMAudioFrameInfo.frameId = a2.f26385a;
                tXCMAudioFrameInfo.size = i;
                return i;
            }
            avVar.a(a2);
            tXCMAudioFrameInfo.frameId = null;
            tXCMAudioFrameInfo.timestamp = 0L;
            tXCMAudioFrameInfo.size = 0;
            return i;
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void seek(int i) {
            t tVar = n.this.b;
            long j = i;
            synchronized (t.class) {
                try {
                    tVar.e = true;
                    tVar.f = j * 1000;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void setOnErrorListener(ITXCMMusicTrack.OnErrorListener onErrorListener) {
            this.f26424c = new q(onErrorListener);
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void setOnPreparedListener(ITXCMMusicTrack.OnPreparedListener onPreparedListener) {
            this.d = new r(onPreparedListener);
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void start() {
            if (this.g == null || n.this.b.c()) {
                return;
            }
            n.this.b.m = 0;
            this.g.post(new Runnable() { // from class: com.tencent.txcopyrightedmedia.impl.utils.n.a.2
                /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void run() {
                    /*
                        Method dump skipped, instructions count: 764
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.n.a.AnonymousClass2.run():void");
                }
            });
        }

        @Override // com.tencent.txcopyrightedmedia.ITXCMMusicTrack
        public final void stop() {
            n.this.b.a();
        }
    }

    private n() {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            if (stackTrace.length > 2 && !TextUtils.equals(stackTrace[1].getClassName(), n.class.getName())) {
                throw new RuntimeException("Permission denied");
            }
        }
    }

    public static ITXCMMusicTrack a(TXCMMusicInfo tXCMMusicInfo) {
        n nVar = new n();
        nVar.getClass();
        return new a(nVar, tXCMMusicInfo, (byte) 0);
    }
}
