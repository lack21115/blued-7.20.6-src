package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.o;
import com.tencent.liteav.base.util.q;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.d.b;
import com.tencent.liteav.txcplayer.e;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.b.d;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import com.tencent.liteav.txcvodplayer.renderer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.renderer.c;
import com.tencent.liteav.txcvodplayer.renderer.f;
import com.tencent.liteav.txcvodplayer.renderer.g;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.rtmp.TXPlayerDrmBuilder;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.egl.EGLContext;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/a.class */
public final class a implements c.a {
    private String A;
    private String B;
    private int C;
    private int D;
    private boolean H;
    private C0750a I;
    private boolean J;
    private boolean K;

    /* renamed from: a  reason: collision with root package name */
    public ITXLivePlayListener f22521a;
    public ITXVodPlayListener b;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference<TXVodPlayer> f22522c;
    public TXCVodVideoView d;
    public boolean f;
    public Surface i;
    public String k;
    public Map<String, Object> l;
    public TXPlayInfoParams m;
    public TXPlayerDrmBuilder n;
    public d o;
    public boolean p;
    protected float q;
    public c r;
    public Object s;
    private Context t;
    private TXVodPlayConfig v;
    private TXCloudVideoView u = null;
    public com.tencent.liteav.txcvodplayer.a.a e = null;
    public boolean g = true;
    public boolean h = true;
    private boolean w = true;
    private float x = 1.0f;
    public boolean j = false;
    private int y = -1000;
    private boolean z = false;
    private String E = "";
    private boolean F = false;
    private int G = -1;
    private com.tencent.liteav.txcplayer.d L = new com.tencent.liteav.txcplayer.d() { // from class: com.tencent.liteav.a.3
        @Override // com.tencent.liteav.txcplayer.d
        public final void a(int i, Bundle bundle) {
            int i2;
            boolean z;
            Bundle bundle2 = new Bundle(bundle);
            if (i == -2301) {
                a.this.e.a(-2301, "network disconnect, has retry reconnect, but still failed!");
            } else if (i == 2011) {
                bundle2.putInt("EVT_PARAM1", a.this.d.getMetaRotationDegree());
            } else if (i != 2026 && i != 2103) {
                if (i != 2106) {
                    if (i == 2013) {
                        LiteavLog.i(TXVodPlayer.TAG, "util onPlayEvent VOD_PLAY_EVT_VOD_PLAY_PREPARED");
                    } else if (i != 2014) {
                        switch (i) {
                            case -2305:
                                a.this.e.a(-2305, "HLS decrypt key error");
                                break;
                            case -2304:
                                a.this.e.a(-2304, "h265 decode failed");
                                if (!a.this.f) {
                                    a.j(a.this);
                                    a aVar = a.this;
                                    aVar.a(aVar.v);
                                    break;
                                }
                                break;
                            case -2303:
                                a.this.e.a(-2303, "file not found");
                                break;
                            default:
                                switch (i) {
                                    case 2003:
                                        LiteavLog.i(TXVodPlayer.TAG, "util onPlayEvent VOD_PLAY_EVT_RCV_FIRST_I_FRAME");
                                        a.this.e.d();
                                        if (a.this.f) {
                                            z = false;
                                        } else {
                                            a.l(a.this);
                                            com.tencent.liteav.txcvodplayer.a.a aVar2 = a.this.e;
                                            LiteavLog.i("TXCVodPlayCollection", "renderStart");
                                            if (aVar2.l == 0) {
                                                aVar2.l = (int) (System.currentTimeMillis() - aVar2.d);
                                            }
                                            Bundle bundle3 = new Bundle();
                                            bundle3.putInt(TXVodConstants.EVT_ID, 2008);
                                            bundle3.putLong("EVT_TIME", TimeUtil.a());
                                            bundle3.putLong("EVT_UTC_TIME", TimeUtil.b());
                                            b mediaInfo = a.this.d.getMediaInfo();
                                            if (mediaInfo == null || mediaInfo.f22790c == null || !mediaInfo.f22790c.toLowerCase().contains("hevc")) {
                                                bundle3.putCharSequence("description", a.this.w ? "Enables hardware decoding" : "Enables software decoding");
                                                i2 = 0;
                                            } else {
                                                bundle3.putCharSequence("description", a.this.w ? "Enables hardware decoding H265" : "Enables software decoding h265");
                                                i2 = 1;
                                            }
                                            bundle3.putInt("EVT_PARAM1", a.this.w ? 1 : 2);
                                            bundle3.putInt(TXVodConstants.EVT_CODEC_TYPE, i2);
                                            a.this.e.u = a.this.w ? i2 == 0 ? 1 : 3 : i2 == 0 ? 0 : 2;
                                            a(2008, bundle3);
                                            z = true;
                                        }
                                        if (!z) {
                                            return;
                                        }
                                        break;
                                    case 2004:
                                        LiteavLog.i(TXVodPlayer.TAG, "util onPlayEvent VOD_PLAY_EVT_PLAY_BEGIN");
                                        break;
                                    case 2005:
                                        com.tencent.liteav.txcvodplayer.a.a aVar3 = a.this.e;
                                        int i3 = bundle.getInt("EVT_PLAY_DURATION", 0);
                                        int i4 = bundle.getInt("EVT_PLAY_PROGRESS", 0);
                                        aVar3.i = i3;
                                        int a2 = i4 / com.tencent.liteav.txcvodplayer.a.b.a(aVar3.f22816a).a(aVar3.B);
                                        if (a2 != aVar3.j) {
                                            aVar3.j = a2;
                                            if (!aVar3.f) {
                                                aVar3.b();
                                                break;
                                            }
                                        }
                                        break;
                                    case 2006:
                                        a.this.e.c();
                                        if (a.this.p) {
                                            a.this.d.a();
                                            a.this.e.a(true);
                                            LiteavLog.d(TXVodPlayer.TAG, "loop play");
                                            return;
                                        }
                                        break;
                                    case 2007:
                                        com.tencent.liteav.txcvodplayer.a.a aVar4 = a.this.e;
                                        if (!aVar4.p && aVar4.l != 0 && !aVar4.h) {
                                            aVar4.e = System.currentTimeMillis();
                                            aVar4.q = true;
                                            LiteavLog.i("TXCVodPlayCollection", "setLoadBegin mBeginLoadTS= " + aVar4.e);
                                            break;
                                        }
                                        break;
                                    case 2008:
                                        break;
                                    case 2009:
                                        if (a.this.r != null) {
                                            c cVar = a.this.r;
                                            cVar.a(g.a(cVar, a.this.d.getVideoWidth(), a.this.d.getVideoHeight()), "setVideoSize");
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 2016:
                                                LiteavLog.i(TXVodPlayer.TAG, "util play tcp connect success");
                                                com.tencent.liteav.txcvodplayer.a.a aVar5 = a.this.e;
                                                if (aVar5.v == 0) {
                                                    aVar5.v = (int) (System.currentTimeMillis() - aVar5.f22817c);
                                                    LiteavLog.i("TXCVodPlayCollection", "mTcpConnectTS = " + aVar5.v + ", mOriginBeginPlayTS = " + aVar5.f22817c + ", " + System.currentTimeMillis());
                                                    return;
                                                }
                                                return;
                                            case 2017:
                                                LiteavLog.i(TXVodPlayer.TAG, "util play first video packet");
                                                com.tencent.liteav.txcvodplayer.a.a aVar6 = a.this.e;
                                                if (aVar6.x == 0) {
                                                    aVar6.x = (int) (System.currentTimeMillis() - aVar6.d);
                                                    return;
                                                }
                                                return;
                                            case 2018:
                                                LiteavLog.i(TXVodPlayer.TAG, "util play dns resolved");
                                                com.tencent.liteav.txcvodplayer.a.a aVar7 = a.this.e;
                                                if (aVar7.w == 0) {
                                                    aVar7.w = (int) (System.currentTimeMillis() - aVar7.f22817c);
                                                    return;
                                                }
                                                return;
                                            case 2019:
                                                break;
                                            default:
                                                LiteavLog.d(TXVodPlayer.TAG, "miss match event ".concat(String.valueOf(i)));
                                                return;
                                        }
                                }
                        }
                    } else {
                        com.tencent.liteav.txcvodplayer.a.a aVar8 = a.this.e;
                        if (!aVar8.p && aVar8.l != 0 && !aVar8.h) {
                            LiteavLog.i("TXCVodPlayCollection", "setLoadEnd mFirstFrame=" + aVar8.l + " , mIsLoading = " + aVar8.q + ",mBeginLoadTS = " + aVar8.e);
                            if (aVar8.q) {
                                int currentTimeMillis = (int) (System.currentTimeMillis() - aVar8.e);
                                aVar8.n += currentTimeMillis;
                                aVar8.m++;
                                if (aVar8.o < currentTimeMillis) {
                                    aVar8.o = currentTimeMillis;
                                }
                                aVar8.q = false;
                            }
                        }
                        if (aVar8.p) {
                            aVar8.p = false;
                        }
                        a.this.e.d();
                    }
                } else if (!a.this.f) {
                    a.j(a.this);
                    a aVar9 = a.this;
                    aVar9.a(aVar9.v);
                }
            }
            bundle2.putString("EVT_MSG", bundle.getString("description", ""));
            a.a(a.this, i, bundle2);
        }

        @Override // com.tencent.liteav.txcplayer.d
        public final void a(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            int[] a2 = q.a();
            bundle2.putCharSequence("CPU_USAGE", a2[0] + "%");
            bundle2.putInt("VIDEO_FPS", (int) bundle.getFloat("fps"));
            bundle2.putInt("VIDEO_DPS", (int) bundle.getFloat("dps"));
            bundle2.putInt("NET_SPEED", ((int) bundle.getLong("tcpSpeed")) / 1000);
            bundle2.putInt("VIDEO_CACHE", ((int) bundle.getLong("cachedBytes")) / 1000);
            bundle2.putInt("VIDEO_WIDTH", a.this.d.getVideoWidth());
            bundle2.putInt("VIDEO_HEIGHT", a.this.d.getVideoHeight());
            bundle2.putString("SERVER_IP", a.this.d.getServerIp());
            com.tencent.liteav.txcvodplayer.a.a aVar = a.this.e;
            aVar.y = a.this.d.getServerIp();
            if (aVar.y == null) {
                aVar.y = "";
            }
            a.a(a.this, 15001, bundle2);
        }
    };

    /* renamed from: com.tencent.liteav.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/a$a.class */
    static final class C0750a {

        /* renamed from: a  reason: collision with root package name */
        Class f22528a;
        Class b;

        /* renamed from: c  reason: collision with root package name */
        Class f22529c;
        Field d;
        Field e;
        Field f;
        Field g;
        Field h;
        Field i;
        Field j;
        Field k;
        Field l;

        public C0750a(Object obj) {
            try {
                this.f22528a = obj.getClass();
                this.b = Class.forName("com.tencent.trtc.TRTCCloudDef$TRTCTexture");
                this.f22529c = Class.forName("com.tencent.trtc.TRTCCloudDef$TRTCVideoFrame");
                this.d = this.b.getDeclaredField("textureId");
                this.e = this.b.getDeclaredField("eglContext10");
                this.g = this.f22529c.getDeclaredField("texture");
                this.h = this.f22529c.getDeclaredField("width");
                this.i = this.f22529c.getDeclaredField("height");
                this.j = this.f22529c.getDeclaredField("pixelFormat");
                this.k = this.f22529c.getDeclaredField("bufferType");
                this.l = this.f22529c.getDeclaredField("timestamp");
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                    this.f = this.b.getDeclaredField("eglContext14");
                }
            } catch (Exception e) {
                LiteavLog.e(TXVodPlayer.TAG, "init TRTCCloudClassInvokeWrapper error ", e);
            }
        }
    }

    static {
        o.a();
    }

    public a(Context context) {
        this.t = null;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.t = applicationContext;
            ContextUtils.initApplicationContext(applicationContext);
            ContextUtils.setDataDirectorySuffix("liteav");
        }
        this.f22521a = null;
        this.b = null;
        RenderProcessService.getInstance().checkInit(context.getApplicationContext());
        TXCVodVideoView tXCVodVideoView = new TXCVodVideoView(context);
        this.d = tXCVodVideoView;
        tXCVodVideoView.setListener(this.L);
        this.l = new HashMap();
    }

    static /* synthetic */ void a(a aVar, int i, Bundle bundle) {
        TXVodPlayer tXVodPlayer;
        TXVodPlayer tXVodPlayer2;
        if (i == 15001) {
            ITXLivePlayListener iTXLivePlayListener = aVar.f22521a;
            if (iTXLivePlayListener != null) {
                iTXLivePlayListener.onNetStatus(bundle);
            }
            if (aVar.b == null || (tXVodPlayer2 = aVar.f22522c.get()) == null) {
                return;
            }
            aVar.b.onNetStatus(tXVodPlayer2, bundle);
            return;
        }
        ITXLivePlayListener iTXLivePlayListener2 = aVar.f22521a;
        if (iTXLivePlayListener2 != null) {
            iTXLivePlayListener2.onPlayEvent(i, bundle);
        }
        if (aVar.b == null || (tXVodPlayer = aVar.f22522c.get()) == null) {
            return;
        }
        aVar.b.onPlayEvent(tXVodPlayer, i, bundle);
    }

    public static String b(String str) {
        return TXCHLSEncoder.a(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x028d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 849
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.a.c(java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(String str, String str2) {
        String str3 = str;
        if (!TextUtils.isEmpty(str2)) {
            String path = Uri.parse(str).getPath();
            str3 = str;
            if (path != null) {
                String[] split = path.split("/");
                str3 = str;
                if (split.length > 0) {
                    int lastIndexOf = str.lastIndexOf(split[split.length - 1]);
                    str3 = str.substring(0, lastIndexOf) + "voddrm.token." + str2 + "." + str.substring(lastIndexOf);
                }
            }
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(String str) {
        TXVodPlayConfig tXVodPlayConfig;
        if (str == null || TextUtils.isEmpty(str)) {
            LiteavLog.i(TXVodPlayer.TAG, "startPlay playUrl is empty, player=" + hashCode());
            return -1;
        }
        this.E = str;
        int i = this.y;
        b(false);
        this.y = i;
        TXCloudVideoView tXCloudVideoView = this.u;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.clearLog();
            this.u.setVisibility(0);
            if (this.u.getVideoView() == null) {
                TextureRenderView textureRenderView = new TextureRenderView(this.u.getContext());
                this.u.addVideoView(textureRenderView);
                this.d.setTextureRenderView(textureRenderView);
            }
            this.u.getVideoView().setVisibility(0);
        } else {
            Surface surface = this.i;
            if (surface != null) {
                this.d.setRenderSurface(surface);
            }
        }
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(com.tencent.liteav.txcvodplayer.renderer.d.a(cVar), "Start");
        }
        this.e = new com.tencent.liteav.txcvodplayer.a.a(this.t);
        String c2 = c(str);
        com.tencent.liteav.txcvodplayer.a.a aVar = this.e;
        LiteavLog.i("TXCVodPlayCollection", "setUrl: ".concat(String.valueOf(c2)));
        aVar.b = c2;
        this.e.a(this.h);
        if (TextUtils.isEmpty(com.tencent.liteav.txcplayer.a.b.a()) && (tXVodPlayConfig = this.v) != null) {
            com.tencent.liteav.txcplayer.a.b.a(tXVodPlayConfig.getCacheFolderPath());
        }
        a(this.v);
        this.d.setPrivateConfig(this.l);
        this.f = false;
        this.d.setStartTime(this.q);
        this.d.setPlayerType(this.v.getPlayerType());
        this.d.a(this.g);
        this.d.setVideoPath(c2);
        this.d.setAutoPlay(this.h);
        this.d.setMute(this.F);
        int i2 = this.G;
        if (i2 >= 0) {
            this.d.setAudioPlayoutVolume(i2);
        }
        d(this.y);
        a(this.x);
        c(this.D);
        b(this.C);
        d(this.H);
        this.d.a();
        this.e.r = this.d.getPlayerType();
        if (this.J) {
            a();
        }
        if (this.K) {
            c();
        }
        LiteavLog.d(TXVodPlayer.TAG, "startPlay url=" + c2 + " player=" + hashCode());
        if (this.m != null && !TextUtils.isEmpty(this.A)) {
            com.tencent.liteav.txcvodplayer.c.a a2 = com.tencent.liteav.txcvodplayer.c.a.a();
            int appId = this.m.getAppId();
            String fileId = this.m.getFileId();
            String str2 = this.A;
            String str3 = this.B;
            if (TextUtils.isEmpty(fileId) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(c2)) {
                LiteavLog.w("PlayInfoProtocolV4Storage", "put params empty fileId: " + fileId + " overlayKey:" + str2 + " overlayIv:" + str3 + " url:" + c2);
            } else {
                com.tencent.liteav.txcplayer.a.a.a().execute(com.tencent.liteav.txcvodplayer.c.b.a(a2, appId, fileId, c2, str2, str3));
            }
        }
        Event4XReporter event4XReporter = new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1);
        event4XReporter.ReportDau(1997, 0, "");
        com.tencent.liteav.txcvodplayer.a.a aVar2 = this.e;
        aVar2.C = new Event4XReporter(40303, 1011, "", true, 1);
        aVar2.a();
        aVar2.C.SetEventStringValue("str_fileid", aVar2.t);
        LicenseChecker.d valid = LicenseChecker.getInstance().valid(LicenseChecker.a.PLAYER_STANDARD);
        LiteavLog.i("VodLicenseCheck", "checkValidForPlayerStandard = ".concat(String.valueOf(valid)));
        aVar2.C.SetEventStringValue("u64_err_code", String.valueOf(valid.value));
        if (valid != LicenseChecker.d.OK) {
            aVar2.C.SetEventStringValue("str_err_info", "player_license_error");
        }
        aVar2.C.SendReport();
        LiteavLog.i("TXCVodPlayCollection", "report evt 40303: token=" + aVar2.A);
        try {
            if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
                event4XReporter.ReportDau(1556, 0, "");
                return 0;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    private void e(boolean z) {
        try {
            Object obj = this.s;
            if (obj != null) {
                obj.getClass().getDeclaredMethod("enableCustomVideoCapture", Integer.TYPE, Boolean.TYPE).invoke(obj, 2, Boolean.valueOf(z));
            }
        } catch (Exception e) {
            LiteavLog.e(TXVodPlayer.TAG, "setTRTCCustomVideoCapture error ", e);
        }
    }

    private TextureView f() {
        TXCloudVideoView tXCloudVideoView = this.u;
        if (tXCloudVideoView != null) {
            return tXCloudVideoView.getVideoView();
        }
        return null;
    }

    static /* synthetic */ boolean j(a aVar) {
        aVar.w = false;
        return false;
    }

    static /* synthetic */ boolean l(a aVar) {
        aVar.f = true;
        return true;
    }

    static /* synthetic */ boolean n(a aVar) {
        aVar.z = false;
        return false;
    }

    public final int a(TXPlayerDrmBuilder tXPlayerDrmBuilder) {
        this.m = null;
        this.n = tXPlayerDrmBuilder;
        a((String) null, (String) null);
        if (tXPlayerDrmBuilder != null) {
            this.l.put("TXC_DRM_KEY_URL", tXPlayerDrmBuilder.getKeyLicenseUrl());
            this.l.put("TXC_DRM_PROVISION_URL", tXPlayerDrmBuilder.getProvisionUrl());
            this.l.put("TXC_DRM_ENABLE", Boolean.TRUE);
            return d(tXPlayerDrmBuilder.getPlayUrl());
        }
        return -1;
    }

    public final int a(String str) {
        this.m = null;
        this.l.put("TXC_DRM_ENABLE", Boolean.FALSE);
        if (TextUtils.equals(str, this.E)) {
            TXPlayerDrmBuilder tXPlayerDrmBuilder = this.n;
            if (tXPlayerDrmBuilder != null) {
                return a(tXPlayerDrmBuilder);
            }
        } else {
            a((String) null, (String) null);
            this.n = null;
        }
        return d(str);
    }

    public final void a() {
        this.J = true;
        e(true);
    }

    public final void a(float f) {
        this.x = f;
        this.d.setRate(f);
        com.tencent.liteav.txcvodplayer.a.a aVar = this.e;
        if (aVar != null) {
            aVar.a(f);
        }
    }

    public final void a(int i) {
        this.G = i;
        this.d.setAudioPlayoutVolume(i);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.c.a
    public final void a(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        this.i = surface;
        this.d.setRenderSurface(surface);
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.c.a
    public final void a(PixelFrame pixelFrame) {
        if (this.J) {
            try {
                if (this.I == null && this.s != null) {
                    this.I = new C0750a(this.s);
                }
                if (this.I != null) {
                    C0750a c0750a = this.I;
                    Object obj = this.s;
                    try {
                        Object newInstance = c0750a.b.newInstance();
                        c0750a.d.set(newInstance, Integer.valueOf(pixelFrame.getTextureId()));
                        if (pixelFrame.getGLContext() instanceof EGLContext) {
                            c0750a.e.set(newInstance, pixelFrame.getGLContext());
                        } else {
                            c0750a.f.set(newInstance, pixelFrame.getGLContext());
                        }
                        Object newInstance2 = c0750a.f22529c.newInstance();
                        c0750a.g.set(newInstance2, newInstance);
                        c0750a.h.set(newInstance2, Integer.valueOf(pixelFrame.getWidth()));
                        c0750a.i.set(newInstance2, Integer.valueOf(pixelFrame.getHeight()));
                        c0750a.j.set(newInstance2, 2);
                        c0750a.k.set(newInstance2, 3);
                        c0750a.l.set(newInstance2, 0);
                        c0750a.f22528a.getDeclaredMethod("sendCustomVideoData", Integer.TYPE, newInstance2.getClass()).invoke(obj, 2, newInstance2);
                    } catch (Exception e) {
                        LiteavLog.e(TXVodPlayer.TAG, "sendCustomVideoData method error ", e);
                    }
                }
            } catch (Exception e2) {
                LiteavLog.e(TXVodPlayer.TAG, "get enableCustomVideoCapture method error ", e2);
            }
        }
    }

    public final void a(final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        if (this.z || iTXSnapshotListener == null) {
            return;
        }
        this.z = true;
        TextureView f = f();
        if (f == null) {
            this.z = false;
            return;
        }
        Bitmap bitmap = f.getBitmap();
        Bitmap bitmap2 = bitmap;
        if (bitmap != null) {
            Matrix transform = f.getTransform(null);
            if (this.H) {
                transform.postScale(-1.0f, 1.0f);
            }
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), transform, true);
            bitmap.recycle();
        }
        if (iTXSnapshotListener != null) {
            final Bitmap bitmap3 = bitmap2;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.liteav.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    TXLivePlayer.ITXSnapshotListener iTXSnapshotListener2 = iTXSnapshotListener;
                    if (iTXSnapshotListener2 != null) {
                        iTXSnapshotListener2.onSnapshot(bitmap3);
                    }
                    a.n(a.this);
                }
            });
        }
    }

    public final void a(TXVodPlayConfig tXVodPlayConfig) {
        this.v = tXVodPlayConfig;
        if (tXVodPlayConfig == null) {
            this.v = new TXVodPlayConfig();
        }
        e eVar = new e();
        float connectRetryCount = this.v.getConnectRetryCount();
        if (connectRetryCount >= 1.0f && connectRetryCount <= 10.0f) {
            eVar.f22796a = (int) connectRetryCount;
        }
        float connectRetryInterval = this.v.getConnectRetryInterval();
        if (connectRetryInterval >= 3.0f && connectRetryInterval <= 30.0f) {
            eVar.b = (int) connectRetryInterval;
        }
        eVar.f22797c = this.v.getTimeout();
        eVar.d = this.w;
        eVar.e = this.v.getCacheFolderPath();
        eVar.f = this.v.getMaxCacheItems();
        eVar.g = this.v.getPlayerType();
        eVar.h = this.v.getHeaders();
        eVar.i = this.v.isEnableAccurateSeek();
        eVar.j = this.v.isSmoothSwitchBitrate();
        eVar.k = this.v.getCacheMp4ExtName();
        eVar.l = this.v.getProgressInterval();
        eVar.m = this.v.getMaxBufferSize();
        if (this.m == null && TextUtils.isEmpty(this.A)) {
            eVar.u = this.v.getOverlayKey();
            eVar.v = this.v.getOverlayIv();
        } else {
            eVar.u = this.A;
            eVar.v = this.B;
        }
        eVar.x = this.v.getExtInfoMap();
        eVar.z = this.v.isEnableRenderProcess();
        eVar.y = this.v.isAutoRotate();
        eVar.s = this.v.getPreferredResolution();
        eVar.A = this.v.getMediaType();
        LiteavLog.i(TXVodPlayer.TAG, "setConfig [connectRetryCount:" + this.v.getConnectRetryCount() + "(default 3 times)][connectRetryInterval:" + this.v.getConnectRetryInterval() + "(default 3s,min:3s max:30s)][vodTimeout:" + this.v.getTimeout() + "(default 10s)][enableHardwareDecoder:" + this.w + "(default false)][cacheFolderPath for mp4/HLS:" + this.v.getCacheFolderPath() + "][maxCacheItems:" + this.v.getMaxCacheItems() + "][enableAccurateSeek:" + this.v.isEnableAccurateSeek() + "(default true)][autoRotate:" + this.v.isAutoRotate() + "(default true)][HLS smoothSwitchBitrate:" + this.v.isSmoothSwitchBitrate() + "(default false)][progressInterval:" + this.v.getProgressInterval() + "(default 0.5s)][preload maxBufferSize:" + this.v.getMaxBufferSize() + "][mOverlayKey for HLS Encrypt:" + this.v.getOverlayKey() + "][mOverlayIv for HLS Encrypt:" + this.v.getOverlayIv() + "][mEnableRenderProcess:" + this.v.isEnableRenderProcess() + "][mPreferredResolution:" + this.v.getPreferredResolution() + "][mMediaType:" + this.v.getMediaType() + "]");
        this.d.setConfig(eVar);
        RenderProcessService.getInstance().setEnableRenderProcess(this.v.isEnableRenderProcess());
    }

    public final void a(TXCloudVideoView tXCloudVideoView) {
        TXCloudVideoView tXCloudVideoView2 = this.u;
        if (tXCloudVideoView != tXCloudVideoView2) {
            if (tXCloudVideoView2 != null) {
                tXCloudVideoView2.removeVideoView();
            }
            if (tXCloudVideoView != null) {
                tXCloudVideoView.removeVideoView();
            }
        }
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setVisibility(0);
            if (this.r == null || this.s == null) {
                if (tXCloudVideoView.getVideoView() == null) {
                    TextureRenderView textureRenderView = new TextureRenderView(tXCloudVideoView.getContext());
                    tXCloudVideoView.addVideoView(textureRenderView);
                    this.d.setTextureRenderView(textureRenderView);
                }
            } else if (tXCloudVideoView.getVideoView() == null) {
                tXCloudVideoView.addVideoView(new TextureView(tXCloudVideoView.getContext()));
                c cVar = this.r;
                cVar.a(f.a(cVar, new DisplayTarget(tXCloudVideoView)), "setDisplayTarget");
            }
            tXCloudVideoView.getVideoView().setVisibility(0);
        }
        this.u = tXCloudVideoView;
    }

    public final void a(String str, String str2) {
        this.A = str;
        this.B = str2;
    }

    public final boolean a(boolean z) {
        if (z) {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 18) {
                LiteavLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + LiteavSystemInfo.getSystemOSVersionInt() + ", the minimum build.version should be 18(android 4.3 or later)");
                return false;
            }
            if (LiteavSystemInfo.getManufacturer().equalsIgnoreCase("HUAWEI") && LiteavSystemInfo.getModel().equalsIgnoreCase("Che2-TL00")) {
                LiteavLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + LiteavSystemInfo.getManufacturer() + ", MODEL" + LiteavSystemInfo.getModel());
                return false;
            }
        }
        this.w = z;
        a(this.v);
        return true;
    }

    public final int b(boolean z) {
        this.j = true;
        this.d.b();
        d dVar = this.o;
        if (dVar != null) {
            dVar.a(null);
            this.o = null;
        }
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(true);
        }
        TXCloudVideoView tXCloudVideoView = this.u;
        if (tXCloudVideoView != null && tXCloudVideoView.getVideoView() != null && z) {
            this.u.setVisibility(8);
            this.u.getVideoView().setVisibility(8);
            this.u.removeVideoView();
        }
        com.tencent.liteav.txcvodplayer.a.a aVar = this.e;
        if (aVar != null) {
            aVar.c();
        }
        this.y = -1000;
        return 0;
    }

    public final void b() {
        this.J = false;
        e(false);
    }

    public final void b(float f) {
        this.q = f;
        this.d.setStartTime(f);
    }

    public final void b(int i) {
        this.C = i;
        if (i == 1) {
            this.d.setRenderMode(0);
        } else {
            this.d.setRenderMode(1);
        }
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(GLConstants.GLScaleType.a(i));
        }
    }

    public final void c() {
        this.K = true;
        this.d.d();
    }

    public final void c(int i) {
        this.D = i;
        this.d.setVideoRotationDegree(i);
        c cVar = this.r;
        if (cVar != null) {
            cVar.a(Rotation.a(i));
        }
    }

    public final void c(boolean z) {
        this.F = z;
        this.d.setMute(z);
    }

    public final void d() {
        this.K = false;
        TXCVodVideoView tXCVodVideoView = this.d;
        if (tXCVodVideoView.f22800c != null) {
            tXCVodVideoView.f22800c.unpublishAudioToNetwork();
        }
    }

    public final void d(int i) {
        com.tencent.liteav.txcvodplayer.a.a aVar;
        this.d.setBitrateIndex(i);
        this.y = i;
        if (i == -1 || !this.f || (aVar = this.e) == null) {
            return;
        }
        aVar.c(this.v.isSmoothSwitchBitrate());
    }

    public final void d(boolean z) {
        this.H = z;
        TextureView f = f();
        if (f != null) {
            float f2 = -1.0f;
            if (this.v.isAutoRotate() && (this.d.getMetaRotationDegree() == 90 || this.d.getMetaRotationDegree() == 270)) {
                if (!z) {
                    f2 = 1.0f;
                }
                f.setScaleY(f2);
            } else {
                if (!z) {
                    f2 = 1.0f;
                }
                f.setScaleX(f2);
            }
        }
        com.tencent.liteav.txcvodplayer.a.a aVar = this.e;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    @Override // com.tencent.liteav.txcvodplayer.renderer.c.a
    public final void e() {
        this.i = null;
        this.d.setRenderSurface(null);
    }
}
