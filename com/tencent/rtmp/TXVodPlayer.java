package com.tencent.rtmp;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.txcplayer.a.b;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.liteav.txcvodplayer.b.d;
import com.tencent.liteav.txcvodplayer.b.e;
import com.tencent.liteav.txcvodplayer.b.f;
import com.tencent.liteav.txcvodplayer.renderer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.renderer.c;
import com.tencent.liteav.txcvodplayer.renderer.j;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.rtmp.TXPlayerDrmBuilder;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/rtmp/TXVodPlayer.class */
public class TXVodPlayer {
    public static final String TAG = "TXVodPlayer";
    private final com.tencent.liteav.a mPlayer;

    public TXVodPlayer(Context context) {
        this.mPlayer = new com.tencent.liteav.a(context);
    }

    public static String getEncryptedPlayKey(String str) {
        return com.tencent.liteav.a.b(str);
    }

    public void attachTRTC(Object obj) {
        LiteavLog.i(TAG, "attachTRTC=" + obj + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        if (obj != null) {
            aVar.s = obj;
            if (aVar.r == null) {
                aVar.r = new c(aVar);
                c cVar = aVar.r;
                synchronized (cVar) {
                    if (cVar.f22873a != null) {
                        LiteavLog.w("VodRenderer", "VodRenderer is initialized!");
                    } else {
                        LiteavLog.i("VodRenderer", "initialize VodRenderer");
                        HandlerThread handlerThread = new HandlerThread("VodRenderer_" + cVar.hashCode());
                        handlerThread.start();
                        cVar.f22873a = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
                        cVar.a(j.a(cVar), ContentResolver.SYNC_EXTRAS_INITIALIZE);
                    }
                }
            }
            TXCVodVideoView tXCVodVideoView = aVar.d;
            tXCVodVideoView.f = obj;
            if (tXCVodVideoView.f22800c != null) {
                tXCVodVideoView.f22800c.attachTRTC(obj);
            }
        }
    }

    public void detachTRTC() {
        LiteavLog.i(TAG, "detachTRTC player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.s = null;
        if (aVar.r != null) {
            final c cVar = aVar.r;
            cVar.a(false);
            cVar.a(new Runnable() { // from class: com.tencent.liteav.txcvodplayer.renderer.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    LiteavLog.i("VodRenderer", "uninitialize VodRenderer");
                    if (cVar.f22874c != null) {
                        cVar.f22874c.setDisplayView(null, false);
                        c.d(cVar);
                    }
                    c.e(cVar);
                    cVar.a();
                    synchronized (cVar) {
                        if (cVar.f22873a != null) {
                            cVar.f22873a.a();
                            c.g(cVar);
                        }
                    }
                }
            }, "uninitialize");
            aVar.r = null;
        }
        aVar.d();
        aVar.b();
        TXCVodVideoView tXCVodVideoView = aVar.d;
        tXCVodVideoView.f = null;
        if (tXCVodVideoView.f22800c != null) {
            tXCVodVideoView.f22800c.detachTRTC();
        }
    }

    public boolean enableHardwareDecode(boolean z) {
        LiteavLog.i(TAG, "enableHardwareDecode=" + z + " player=" + hashCode());
        return this.mPlayer.a(z);
    }

    public int getBitrateIndex() {
        return this.mPlayer.d.getBitrateIndex();
    }

    public float getBufferDuration() {
        return ((float) this.mPlayer.d.getBufferDuration()) / 1000.0f;
    }

    public float getCurrentPlaybackTime() {
        return ((float) this.mPlayer.d.getCurrentPosition()) / 1000.0f;
    }

    public float getDuration() {
        return this.mPlayer.d.getDuration() / 1000.0f;
    }

    public int getHeight() {
        return this.mPlayer.d.getVideoHeight();
    }

    public float getPlayableDuration() {
        return ((float) this.mPlayer.d.getBufferDuration()) / 1000.0f;
    }

    public ArrayList<TXBitrateItem> getSupportedBitrates() {
        com.tencent.liteav.a aVar = this.mPlayer;
        ArrayList<TXBitrateItem> arrayList = new ArrayList<>();
        ArrayList<com.tencent.liteav.txcplayer.d.a> supportedBitrates = aVar.d.getSupportedBitrates();
        if (supportedBitrates != null) {
            Iterator<com.tencent.liteav.txcplayer.d.a> it = supportedBitrates.iterator();
            while (it.hasNext()) {
                com.tencent.liteav.txcplayer.d.a next = it.next();
                TXBitrateItem tXBitrateItem = new TXBitrateItem();
                tXBitrateItem.index = next.f22787a;
                tXBitrateItem.width = next.b;
                tXBitrateItem.height = next.f22788c;
                tXBitrateItem.bitrate = next.d;
                arrayList.add(tXBitrateItem);
            }
        }
        return arrayList;
    }

    public int getWidth() {
        return this.mPlayer.d.getVideoWidth();
    }

    public boolean isLoop() {
        return this.mPlayer.p;
    }

    public boolean isPlaying() {
        TXCVodVideoView tXCVodVideoView = this.mPlayer.d;
        return tXCVodVideoView.c() && tXCVodVideoView.f22800c.isPlaying() && tXCVodVideoView.f22799a != 4;
    }

    public void pause() {
        LiteavLog.i(TAG, "pause player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        TXCVodVideoView tXCVodVideoView = aVar.d;
        tXCVodVideoView.b = 4;
        LiteavLog.i("TXCVodVideoView", "pause vod=" + tXCVodVideoView.hashCode());
        if (tXCVodVideoView.c()) {
            try {
                tXCVodVideoView.f22800c.pause();
            } catch (Exception e) {
                LiteavLog.e("TXCVodVideoView", "pause exception: " + e.getMessage());
            }
            tXCVodVideoView.f22799a = 4;
        }
        if (aVar.e != null) {
            com.tencent.liteav.txcvodplayer.a.a aVar2 = aVar.e;
            LiteavLog.i("TXCVodPlayCollection", "pause " + aVar2.k);
            if (!aVar2.f) {
                aVar2.k += System.currentTimeMillis() - aVar2.d;
            }
            aVar2.f = true;
            aVar2.d = System.currentTimeMillis();
        }
    }

    public void publishAudio() {
        LiteavLog.i(TAG, "publishAudio player=" + hashCode());
        this.mPlayer.c();
    }

    public void publishVideo() {
        LiteavLog.i(TAG, "publishVideo player=" + hashCode());
        this.mPlayer.a();
    }

    public void resume() {
        LiteavLog.i(TAG, "resume player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.d.a();
        if (aVar.e != null) {
            com.tencent.liteav.txcvodplayer.a.a aVar2 = aVar.e;
            aVar2.d = System.currentTimeMillis();
            if (aVar2.g) {
                aVar2.f22817c = aVar2.d;
                aVar2.g = false;
            }
            LiteavLog.i("TXCVodPlayCollection", "resume " + aVar2.d);
            aVar2.f = false;
        }
    }

    public void seek(float f) {
        LiteavLog.i(TAG, "seek time=" + f + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.d.a((int) (f * 1000.0f));
        if (!aVar.f || aVar.e == null) {
            return;
        }
        aVar.e.e();
    }

    public void seek(int i) {
        LiteavLog.i(TAG, "seek time=" + i + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.d.a(i * 1000);
        if (!aVar.f || aVar.e == null) {
            return;
        }
        aVar.e.e();
    }

    public void setAudioPlayoutVolume(int i) {
        LiteavLog.i(TAG, "setAudioPlayoutVolume=" + i + " player=" + hashCode());
        this.mPlayer.a(i);
    }

    public void setAutoPlay(boolean z) {
        LiteavLog.i(TAG, "setAutoPlay=" + z + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.h = z;
        aVar.d.setAutoPlay(z);
    }

    public void setBitrateIndex(int i) {
        LiteavLog.i(TAG, "setBitrateIndex=" + i + " player=" + hashCode());
        this.mPlayer.d(i);
    }

    public void setConfig(TXVodPlayConfig tXVodPlayConfig) {
        this.mPlayer.a(tXVodPlayConfig);
    }

    public void setLoop(boolean z) {
        LiteavLog.i(TAG, "setLoop=" + z + " player=" + hashCode());
        this.mPlayer.p = z;
    }

    public void setMirror(boolean z) {
        LiteavLog.i(TAG, "setMirror=" + z + " player=" + hashCode());
        this.mPlayer.d(z);
    }

    public void setMute(boolean z) {
        LiteavLog.i(TAG, "setMute=" + z + " player=" + hashCode());
        this.mPlayer.c(z);
    }

    @Deprecated
    public void setPlayListener(ITXLivePlayListener iTXLivePlayListener) {
        LiteavLog.i(TAG, "setPlayListener=" + iTXLivePlayListener + " player=" + hashCode());
        this.mPlayer.f22521a = iTXLivePlayListener;
    }

    public void setPlayerView(TextureRenderView textureRenderView) {
        LiteavLog.i(TAG, "setPlayerView TextureRenderView=" + textureRenderView + " player=" + hashCode());
        this.mPlayer.d.setRenderView(textureRenderView);
    }

    public void setPlayerView(TXCloudVideoView tXCloudVideoView) {
        LiteavLog.i(TAG, "setPlayerView TXCloudVideoView=" + tXCloudVideoView + " player=" + hashCode());
        this.mPlayer.a(tXCloudVideoView);
    }

    public void setRate(float f) {
        LiteavLog.i(TAG, "setRate=" + f + " player=" + hashCode());
        this.mPlayer.a(f);
    }

    public void setRenderMode(int i) {
        LiteavLog.i(TAG, "setRenderMode=" + i + " player=" + hashCode());
        this.mPlayer.b(i);
    }

    public void setRenderRotation(int i) {
        LiteavLog.i(TAG, "setRenderRotation=" + i + " player=" + hashCode());
        this.mPlayer.c(i);
    }

    public boolean setRequestAudioFocus(boolean z) {
        LiteavLog.i(TAG, "setRequestAudioFocus=" + z + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.g = z;
        return aVar.d.a(z);
    }

    public void setStartTime(float f) {
        LiteavLog.i(TAG, "setStartTime=" + f + " player=" + hashCode());
        this.mPlayer.b(f);
    }

    public void setStringOption(String str, Object obj) {
        LiteavLog.i(TAG, "setStringOption key=" + str + " value=" + obj + "player=" + hashCode());
        TXCVodVideoView tXCVodVideoView = this.mPlayer.d;
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, "PARAM_SUPER_RESOLUTION_TYPE") && (obj instanceof Integer)) {
            RenderProcessService.getInstance().updateRenderProcessMode(tXCVodVideoView.f22800c, ((Integer) obj).intValue());
        }
    }

    public void setSurface(Surface surface) {
        LiteavLog.i(TAG, "setSurface Surface=" + surface + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.i = surface;
        aVar.d.setRenderSurface(aVar.i);
    }

    public void setToken(String str) {
        LiteavLog.i(TAG, "setToken=" + str + " player=" + hashCode());
        this.mPlayer.k = str;
    }

    public void setVodListener(ITXVodPlayListener iTXVodPlayListener) {
        LiteavLog.i(TAG, "setVodListener=" + iTXVodPlayListener + " player=" + hashCode());
        com.tencent.liteav.a aVar = this.mPlayer;
        aVar.f22522c = new WeakReference<>(this);
        aVar.b = iTXVodPlayListener;
    }

    public void snapshot(TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        LiteavLog.i(TAG, "snapshot=" + iTXSnapshotListener + " player=" + hashCode());
        this.mPlayer.a(iTXSnapshotListener);
    }

    @Deprecated
    public int startPlay(TXPlayerAuthBuilder tXPlayerAuthBuilder) {
        LiteavLog.i(TAG, "startPlay [FileId=" + tXPlayerAuthBuilder.fileId + "][Timeout=" + tXPlayerAuthBuilder.timeout + "][Unique identification request=" + tXPlayerAuthBuilder.us + "][Trial duration=" + tXPlayerAuthBuilder.exper + "][Sign=" + tXPlayerAuthBuilder.sign + "][player=" + hashCode() + "]");
        final com.tencent.liteav.a aVar = this.mPlayer;
        aVar.m = null;
        aVar.n = null;
        aVar.l.put("TXC_DRM_ENABLE", Boolean.FALSE);
        aVar.a((String) null, (String) null);
        aVar.o = new d();
        aVar.o.f22843c = tXPlayerAuthBuilder.isHttps();
        aVar.o.a(new e() { // from class: com.tencent.liteav.a.1
            @Override // com.tencent.liteav.txcvodplayer.b.e
            public final void a(d dVar) {
                if (dVar != a.this.o) {
                    return;
                }
                f a2 = dVar.a();
                a.this.d(a2.a());
                Bundle bundle = new Bundle();
                bundle.putInt(TXVodConstants.EVT_ID, 2010);
                bundle.putLong("EVT_TIME", TimeUtil.a());
                bundle.putLong("EVT_UTC_TIME", TimeUtil.b());
                bundle.putString("EVT_MSG", "Requested file information successfully");
                bundle.putString("EVT_PLAY_URL", a2.a());
                bundle.putString("EVT_PLAY_COVER_URL", a2.d());
                bundle.putString("EVT_PLAY_NAME", a2.g());
                bundle.putString("EVT_PLAY_DESCRIPTION", a2.h());
                if (a2.f() != null) {
                    bundle.putInt("EVT_PLAY_DURATION", a2.f().e);
                }
                a.a(a.this, 2010, bundle);
                LiteavLog.i(TXVodPlayer.TAG, "onNetSuccess: Requested file information successfully");
            }

            @Override // com.tencent.liteav.txcvodplayer.b.e
            public final void a(d dVar, String str, int i) {
                if (dVar != a.this.o) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt(TXVodConstants.EVT_ID, -2306);
                bundle.putLong("EVT_TIME", TimeUtil.a());
                bundle.putLong("EVT_UTC_TIME", TimeUtil.b());
                bundle.putString("EVT_MSG", str);
                bundle.putInt("EVT_PARAM1", i);
                a.a(a.this, -2306, bundle);
                LiteavLog.i(TXVodPlayer.TAG, "onNetFailed: eventId: -2306 description:".concat(String.valueOf(str)));
            }
        });
        LiteavLog.i(TAG, "startPlay [FileId:" + tXPlayerAuthBuilder.getFileId() + "][Timeout:" + tXPlayerAuthBuilder.getTimeout() + "][Unique identification request:" + tXPlayerAuthBuilder.getUs() + "][Trial duration:" + tXPlayerAuthBuilder.getExper() + "][Sign:" + tXPlayerAuthBuilder.getSign() + "]");
        return aVar.o.a(tXPlayerAuthBuilder.getAppId(), tXPlayerAuthBuilder.getFileId(), tXPlayerAuthBuilder.getTimeout(), tXPlayerAuthBuilder.getUs(), tXPlayerAuthBuilder.getExper(), tXPlayerAuthBuilder.getSign());
    }

    public int startPlay(String str) {
        LiteavLog.i(TAG, "StartPlay url=" + str + " player=" + hashCode());
        return this.mPlayer.a(str);
    }

    public void startPlay(TXPlayInfoParams tXPlayInfoParams) {
        LiteavLog.i(TAG, "startPlay [FileId=" + tXPlayInfoParams.mFileId + "][AppId=" + tXPlayInfoParams.mAppId + "][PSign=" + tXPlayInfoParams.mPSign + "][player=" + hashCode() + "]");
        final com.tencent.liteav.a aVar = this.mPlayer;
        aVar.m = tXPlayInfoParams;
        aVar.n = null;
        if (tXPlayInfoParams != null) {
            aVar.j = false;
            new com.tencent.liteav.txcvodplayer.b.c(tXPlayInfoParams).a(new c.a() { // from class: com.tencent.liteav.a.2
                @Override // com.tencent.liteav.txcvodplayer.b.c.a
                public final void a(int i, String str) {
                    LiteavLog.w(TXVodPlayer.TAG, "onFail: errorCode = " + i + " message = " + str);
                    Bundle bundle = new Bundle();
                    bundle.putInt(TXVodConstants.EVT_ID, -2306);
                    bundle.putLong("EVT_TIME", TimeUtil.a());
                    bundle.putLong("EVT_UTC_TIME", TimeUtil.b());
                    bundle.putString("EVT_MSG", str);
                    bundle.putInt("EVT_PARAM1", i);
                    a.a(a.this, -2306, bundle);
                    LiteavLog.i(TXVodPlayer.TAG, "onError: eventId: -2306 description:".concat(String.valueOf(str)));
                }

                @Override // com.tencent.liteav.txcvodplayer.b.c.a
                public final void a(com.tencent.liteav.txcvodplayer.b.c cVar, TXPlayInfoParams tXPlayInfoParams2) {
                    String str;
                    List<c.C0764c> list;
                    String str2;
                    LiteavLog.i(TXVodPlayer.TAG, "onSuccess: protocol params = " + tXPlayInfoParams2.toString());
                    if (a.this.j) {
                        return;
                    }
                    if ("SimpleAES".equalsIgnoreCase(cVar.d())) {
                        a.this.a(cVar.d, cVar.e);
                        com.tencent.liteav.txcvodplayer.c.a a2 = com.tencent.liteav.txcvodplayer.c.a.a();
                        String a3 = b.a();
                        if (TextUtils.isEmpty(a3)) {
                            LiteavLog.i("PlayInfoProtocolV4Storage", "clean cacheDir is empty");
                        } else {
                            long currentTimeMillis = System.currentTimeMillis() / 3600000;
                            if (a2.f22853c <= 0 || currentTimeMillis - a2.f22853c >= 24) {
                                a2.f22853c = currentTimeMillis;
                                com.tencent.liteav.txcplayer.a.a.a().execute(com.tencent.liteav.txcvodplayer.c.d.a(a2, a3, currentTimeMillis));
                            } else {
                                LiteavLog.i("PlayInfoProtocolV4Storage", "clean mLastCacheCleanTime: " + a2.f22853c + " not more than 24h");
                            }
                        }
                    } else {
                        a.this.a((String) null, (String) null);
                    }
                    String a4 = cVar.b != null ? cVar.b.a("Widevine") : null;
                    if (TextUtils.isEmpty(a4)) {
                        a.this.l.put("TXC_DRM_ENABLE", Boolean.FALSE);
                        String a5 = cVar.a();
                        if (!TextUtils.isEmpty(a5)) {
                            String c2 = a.c(a5, cVar.b());
                            a.this.k = null;
                            Uri parse = Uri.parse(c2);
                            String query = parse.getQuery();
                            if (TextUtils.isEmpty(query)) {
                                str = "";
                            } else {
                                str = query + ContainerUtils.FIELD_DELIMITER;
                            }
                            String d = cVar.d();
                            String str3 = d;
                            if (TextUtils.isEmpty(d)) {
                                str3 = "plain";
                            }
                            Uri build = parse.buildUpon().query(str + "spfileid=" + tXPlayInfoParams2.getFileId() + "&spdrmtype=" + str3 + "&spappid=" + tXPlayInfoParams2.getAppId()).build();
                            StringBuilder sb = new StringBuilder("playVodURL: newurl = ");
                            sb.append(build.toString());
                            sb.append(" ;url= ");
                            sb.append(c2);
                            LiteavLog.i(TXVodPlayer.TAG, sb.toString());
                            a.this.d(build.toString());
                        }
                    } else {
                        a.this.k = null;
                        TXPlayerDrmBuilder tXPlayerDrmBuilder = new TXPlayerDrmBuilder();
                        tXPlayerDrmBuilder.setPlayUrl(a4);
                        if (cVar.b != null) {
                            com.tencent.liteav.txcvodplayer.b.b bVar = cVar.b;
                            if (!TextUtils.isEmpty(bVar.i) && !TextUtils.isEmpty(bVar.g)) {
                                str2 = bVar.i + "?drmToken=" + bVar.g;
                                tXPlayerDrmBuilder.setKeyLicenseUrl(str2);
                                a.this.a(tXPlayerDrmBuilder);
                            }
                        }
                        str2 = null;
                        tXPlayerDrmBuilder.setKeyLicenseUrl(str2);
                        a.this.a(tXPlayerDrmBuilder);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(TXVodConstants.EVT_ID, 2010);
                    bundle.putLong("EVT_TIME", TimeUtil.a());
                    bundle.putLong("EVT_UTC_TIME", TimeUtil.b());
                    bundle.putString("EVT_MSG", "Requested file information successfully");
                    bundle.putString("EVT_PLAY_URL", a.this.E);
                    bundle.putString("EVT_PLAY_COVER_URL", cVar.b != null ? cVar.b.f22827c : cVar.f22830c != null ? cVar.f22830c.d() : null);
                    bundle.putString("EVT_PLAY_NAME", cVar.b != null ? cVar.b.f22826a : cVar.f22830c != null ? cVar.f22830c.g() : null);
                    bundle.putString("EVT_PLAY_DESCRIPTION", cVar.b != null ? cVar.b.b : cVar.f22830c != null ? cVar.f22830c.h() : null);
                    bundle.putInt("EVT_PLAY_DURATION", cVar.c());
                    c.b i = cVar.b != null ? cVar.b.j : cVar.f22830c != null ? cVar.f22830c.i() : null;
                    if (i != null) {
                        bundle.putString(TXVodConstants.EVT_IMAGESPRIT_WEBVTTURL, i.b);
                        bundle.putStringArrayList(TXVodConstants.EVT_IMAGESPRIT_IMAGEURL_LIST, i.f22838a);
                    }
                    if (cVar.b != null) {
                        list = cVar.b.k;
                    } else {
                        list = null;
                        if (cVar.f22830c != null) {
                            list = cVar.f22830c.j();
                        }
                    }
                    if (list != null && !list.isEmpty()) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        float[] fArr = new float[list.size()];
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 >= list.size()) {
                                break;
                            }
                            arrayList.add(list.get(i3).f22839a);
                            fArr[i3] = list.get(i3).b;
                            i2 = i3 + 1;
                        }
                        bundle.putStringArrayList(TXVodConstants.EVT_KEY_FRAME_CONTENT_LIST, arrayList);
                        bundle.putFloatArray(TXVodConstants.EVT_KEY_FRAME_TIME_LIST, fArr);
                    }
                    bundle.putString(TXVodConstants.EVT_DRM_TYPE, cVar.d());
                    a.a(a.this, 2010, bundle);
                    LiteavLog.i(TXVodPlayer.TAG, "onSuccess: Requested file information successfully");
                }
            });
        }
    }

    public int startPlayDrm(TXPlayerDrmBuilder tXPlayerDrmBuilder) {
        LiteavLog.i(TAG, "startPlayDrm [PlayUrl=" + tXPlayerDrmBuilder.mPlayUrl + "][KeyLicenseUrl=" + tXPlayerDrmBuilder.mKeyLicenseUrl + "][ProvisionUrl=" + tXPlayerDrmBuilder.mProvisionUrl + "][player=" + hashCode() + "]");
        return this.mPlayer.a(tXPlayerDrmBuilder);
    }

    public int stopPlay(boolean z) {
        LiteavLog.i(TAG, "stopPlay needClearLastImg=" + z + " player=" + hashCode());
        return this.mPlayer.b(z);
    }

    public void unpublishAudio() {
        LiteavLog.i(TAG, "unpublishAudio player=" + hashCode());
        this.mPlayer.d();
    }

    public void unpublishVideo() {
        LiteavLog.i(TAG, "unpublishVideo player=" + hashCode());
        this.mPlayer.b();
    }
}
