package com.tencent.liteav.thumbplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.o;
import com.tencent.liteav.txcplayer.a;
import com.tencent.liteav.txcplayer.b;
import com.tencent.liteav.txcplayer.c;
import com.tencent.liteav.txcplayer.d.c;
import com.tencent.liteav.txcplayer.e;
import com.tencent.thumbplayer.api.ITPModuleLoader;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.api.TPProgramInfo;
import com.tencent.thumbplayer.api.TPTrackInfo;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/thumbplayer/ThumbMediaPlayer.class */
public class ThumbMediaPlayer extends a implements b {
    private static final String THUMB_PLAYER_GUID = "liteav_tbplayer_android_";
    private static final int THUMB_PLAYER_PLATFORM_ID = 2330303;
    private static volatile boolean mSDKInited = false;
    private e mConfig;
    private String mDataSource;
    private boolean mIsLooping;
    private Map<String, Object> mPrivateConfig;
    private float mRate;
    private boolean mReuseSurfaceTexture;
    private boolean mScreenOnWhilePlaying;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceTexture mSurfaceTexture;
    private c mSurfaceTextureHost;
    private volatile ITPPlayer mTPPPlayer;
    private final String TAG = ThumbMediaPlayer.class.getName();
    private boolean mEnableAccurateSeek = false;
    private PowerManager.WakeLock mWakeLock = null;
    private int mBitrateIndex = -1000;
    private long mCachedBytes = 0;
    private long mBitrate = 0;
    private long mTcpSpeed = 0;
    private long mTotalFileSize = 0;
    private boolean mHasReceiveFirstVideoRenderEvent = false;
    private Object mTrtcCloud = null;
    private volatile Object mTrtcAudioTrack = null;
    private volatile ITPPlayerListener.IOnAudioFrameOutputListener mAudioFrameListener = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/thumbplayer/ThumbMediaPlayer$TRTCCloudClassInvokeHelper.class */
    public static class TRTCCloudClassInvokeHelper {
        private static final String TAG = TRTCCloudClassInvokeHelper.class.getName();
        private static TRTCCloudClassInvokeHelper mInstance;
        private Class mClazzTRTCAudioFrame;
        private Field mFieldChannel;
        private Field mFieldData;
        private Field mFieldSampleRate;
        private Method mMethodMixExternalAudioFrame;
        private Method mMethodWriteData;

        private TRTCCloudClassInvokeHelper() {
            try {
                Class<?> cls = Class.forName("com.tencent.trtc.TRTCCloudDef$TRTCAudioFrame");
                this.mClazzTRTCAudioFrame = cls;
                this.mFieldData = cls.getDeclaredField("data");
                this.mFieldSampleRate = this.mClazzTRTCAudioFrame.getDeclaredField("sampleRate");
                this.mFieldChannel = this.mClazzTRTCAudioFrame.getDeclaredField("channel");
                this.mMethodMixExternalAudioFrame = Class.forName("com.tencent.trtc.TRTCCloud").getDeclaredMethod("mixExternalAudioFrame", this.mClazzTRTCAudioFrame);
                this.mMethodWriteData = Class.forName("com.tencent.trtc.TRTCAudioCustomTrack").getDeclaredMethod("writeData", this.mClazzTRTCAudioFrame);
            } catch (Exception e) {
                String str = TAG;
                LiteavLog.e(str, "init TRTCCloudClassInvokeHelper error: " + e.getMessage());
            }
        }

        static /* synthetic */ TRTCCloudClassInvokeHelper access$600() {
            return getInstance();
        }

        private static TRTCCloudClassInvokeHelper getInstance() {
            if (mInstance == null) {
                mInstance = new TRTCCloudClassInvokeHelper();
            }
            return mInstance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mixExternalAudioFrame(Object obj, Object obj2, TPAudioFrameBuffer tPAudioFrameBuffer) {
            try {
                Object newInstance = this.mClazzTRTCAudioFrame.newInstance();
                this.mFieldData.set(newInstance, tPAudioFrameBuffer.data[0]);
                this.mFieldSampleRate.set(newInstance, Integer.valueOf(tPAudioFrameBuffer.sampleRate));
                this.mFieldChannel.set(newInstance, Integer.valueOf(tPAudioFrameBuffer.channels));
                if (obj2 != null) {
                    this.mMethodWriteData.invoke(obj2, newInstance);
                }
                if (obj != null) {
                    this.mMethodMixExternalAudioFrame.invoke(obj, newInstance);
                }
            } catch (Exception e) {
                LiteavLog.e(TAG, "mixExternalAudioFrame method error ", e);
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/thumbplayer/ThumbMediaPlayer$TXCDLProxyLogListener.class */
    static class TXCDLProxyLogListener implements ITPDLProxyLogListener {
        int logLevel;

        private TXCDLProxyLogListener() {
            this.logLevel = LiteavLog.getLogLevel();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int d(String str, int i, String str2, String str3) {
            if (this.logLevel <= LiteavLog.b.kAll.mNativeValue) {
                Log.d(str2, "[" + str + "," + i + "] " + str3);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int e(String str, int i, String str2, String str3) {
            if (this.logLevel <= LiteavLog.b.kError.mNativeValue) {
                Log.e(str2, "[" + str + "," + i + "] " + str3);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int i(String str, int i, String str2, String str3) {
            if (this.logLevel <= LiteavLog.b.kInfo.mNativeValue) {
                Log.i(str2, "[" + str + "," + i + "] " + str3);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public int w(String str, int i, String str2, String str3) {
            if (this.logLevel <= LiteavLog.b.kWarning.mNativeValue) {
                Log.w(str2, "[" + str + "," + i + "] " + str3);
                return 0;
            }
            return 0;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/thumbplayer/ThumbMediaPlayer$TXCTPPlayerOnLogListener.class */
    static class TXCTPPlayerOnLogListener implements TPPlayerMgr.OnLogListener {
        int logLevel;

        private TXCTPPlayerOnLogListener() {
            this.logLevel = LiteavLog.getLogLevel();
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public int d(String str, String str2) {
            if (this.logLevel <= LiteavLog.b.kAll.mNativeValue) {
                Log.d(str, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public int e(String str, String str2) {
            if (this.logLevel <= LiteavLog.b.kError.mNativeValue) {
                Log.e(str, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public int i(String str, String str2) {
            if (this.logLevel <= LiteavLog.b.kInfo.mNativeValue) {
                Log.i(str, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public int v(String str, String str2) {
            if (this.logLevel <= LiteavLog.b.kAll.mNativeValue) {
                Log.v(str, str2);
                return 0;
            }
            return 0;
        }

        @Override // com.tencent.thumbplayer.api.TPPlayerMgr.OnLogListener
        public int w(String str, String str2) {
            if (this.logLevel <= LiteavLog.b.kWarning.mNativeValue) {
                Log.w(str, str2);
                return 0;
            }
            return 0;
        }
    }

    public ThumbMediaPlayer(Context context) {
        synchronized (ThumbMediaPlayer.class) {
            try {
                if (!mSDKInited) {
                    setTPSystemInfo();
                    setTPPLibCustomLoader();
                    TPPlayerMgr.initSdk(context, THUMB_PLAYER_GUID + context.getPackageName(), THUMB_PLAYER_PLATFORM_ID);
                    TPPlayerMgr.setDebugEnable(false);
                    TPPlayerMgr.setOnLogListener(new TXCTPPlayerOnLogListener());
                    mSDKInited = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.mTPPPlayer == null) {
            TPPlayerMgr.setDebugEnable(false);
            this.mTPPPlayer = TPPlayerFactory.createTPPlayer(context);
            new ThumbMediaPlayerListener(this).attachToPlayer();
        }
        setCustomReportData();
    }

    private ITPMediaDRMAsset handleDRMAsset(String str) {
        Map<String, Object> map = this.mPrivateConfig;
        if (map != null) {
            Object obj = map.get("TXC_DRM_ENABLE");
            if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                Object obj2 = this.mPrivateConfig.get("TXC_DRM_KEY_URL");
                Object obj3 = this.mPrivateConfig.get("TXC_DRM_PROVISION_URL");
                if ((obj2 instanceof String) && (obj3 instanceof String)) {
                    String str2 = (String) obj2;
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                    String str3 = (String) obj3;
                    if (TextUtils.isEmpty(str3)) {
                        return null;
                    }
                    ITPMediaDRMAsset createMediaDRMAsset = TPMediaCompositionFactory.createMediaDRMAsset(0, str);
                    createMediaDRMAsset.setDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PROVISION_URL, str3);
                    createMediaDRMAsset.setDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_URL, str2);
                    createMediaDRMAsset.setDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_STANDARDIZATION, "1");
                    return createMediaDRMAsset;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    private void setCustomReportData() {
        ITPBusinessReportManager reportManager = this.mTPPPlayer.getReportManager();
        TPDefaultReportInfo tPDefaultReportInfo = new TPDefaultReportInfo() { // from class: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.2
            @Override // com.tencent.thumbplayer.api.report.TPDefaultReportInfo
            public int getPlayType() {
                return 0;
            }
        };
        if (TextUtils.isEmpty(null)) {
            return;
        }
        try {
            tPDefaultReportInfo.scenesId = Integer.parseInt(null);
        } catch (Exception e) {
            String str = this.TAG;
            LiteavLog.w(str, "set scenesId fail for parse appid:" + ((String) null) + " ,error=" + e.getMessage());
        }
        reportManager.setReportInfoGetter(tPDefaultReportInfo);
    }

    private void setEnableMixExternalAudioFrame() {
        LiteavLog.i(this.TAG, "setEnableMixExternalAudioFrame");
        if (this.mTrtcAudioTrack == null) {
            try {
                Class<?> cls = Class.forName("com.tencent.trtc.TRTCAudioCustomTrack");
                this.mTrtcAudioTrack = cls.newInstance();
                cls.getDeclaredMethod("enablePlayout", Boolean.TYPE).invoke(this.mTrtcAudioTrack, Boolean.TRUE);
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(404, -1L));
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(120, true));
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "enable trtcAudioTrack error: " + e.getMessage());
                return;
            }
        }
        if (this.mTrtcAudioTrack == null || this.mAudioFrameListener != null) {
            return;
        }
        this.mAudioFrameListener = new ITPPlayerListener.IOnAudioFrameOutputListener() { // from class: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.6
            @Override // com.tencent.thumbplayer.api.ITPPlayerListener.IOnAudioFrameOutputListener
            public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
                if (ThumbMediaPlayer.this.mTrtcCloud == null && ThumbMediaPlayer.this.mTrtcAudioTrack == null) {
                    return;
                }
                TRTCCloudClassInvokeHelper.access$600().mixExternalAudioFrame(ThumbMediaPlayer.this.mTrtcCloud, ThumbMediaPlayer.this.mTrtcAudioTrack, tPAudioFrameBuffer);
            }
        };
        this.mTPPPlayer.setOnAudioFrameOutputListener(this.mAudioFrameListener);
        LiteavLog.i(this.TAG, "setOnAudioFrameOutputListener");
    }

    private void setSurfaceToPlayer(Surface surface) {
        this.mSurfaceHolder = null;
        this.mSurface = surface;
        this.mTPPPlayer.setSurface(surface);
        String str = this.TAG;
        LiteavLog.i(str, "setSurface mSurface:" + this.mSurface);
    }

    private void setTPPLibCustomLoader() {
        try {
            if (TextUtils.isEmpty(o.b())) {
                return;
            }
            TPPlayerMgr.setLibLoader(new ITPModuleLoader() { // from class: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.1
                @Override // com.tencent.thumbplayer.api.ITPModuleLoader
                public void loadLibrary(String str, String str2) {
                    o.a(str);
                }
            });
        } catch (Throwable th) {
            String str = this.TAG;
            LiteavLog.e(str, "setTPPLibCustomLoader, ex = " + th.getMessage());
        }
    }

    private void setTPSystemInfo() {
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_MODEL, LiteavSystemInfo.getModel());
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_MANUFACTURER, LiteavSystemInfo.getManufacturer());
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE, LiteavSystemInfo.getSystemOSVersion());
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_BOARD, LiteavSystemInfo.getBoard());
    }

    private void setVideoInfo(String str) {
        String d;
        if (str == null || this.mTPPPlayer == null) {
            return;
        }
        TPVideoInfo.Builder builder = new TPVideoInfo.Builder();
        TPDownloadParamData tPDownloadParamData = new TPDownloadParamData(0);
        int indexOf = str.indexOf(63);
        String a2 = com.tencent.liteav.txcplayer.e.a.a(Uri.parse(indexOf > 0 ? str.substring(0, indexOf) : str).getPath());
        if (TextUtils.isEmpty(a2) || !a2.endsWith("hls")) {
            d = com.tencent.liteav.txcplayer.e.a.d(str);
        } else {
            String substring = str.substring(0, str.indexOf(".hls") + 4);
            d = substring.substring(substring.lastIndexOf(47) + 1);
            TPDownloadProxyFactory.getTPDownloadProxy(THUMB_PLAYER_PLATFORM_ID).updateStoragePath(substring.substring(0, substring.lastIndexOf(47)));
            tPDownloadParamData.setDlType(3);
            tPDownloadParamData.setOffline(true);
        }
        builder.fileId(d);
        e eVar = this.mConfig;
        if (eVar != null && eVar.w && d.endsWith(".hls")) {
            if (this.mConfig.A == 2) {
                tPDownloadParamData.setDlType(5);
            } else {
                tPDownloadParamData.setDlType(3);
            }
            tPDownloadParamData.setSelfAdaption(true);
        }
        HashMap hashMap = new HashMap();
        if (this.mConfig.n > 0 && !this.mConfig.p) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_BUFFER_SIZE, Integer.valueOf(this.mConfig.n * 1024 * 1024));
        } else if (this.mConfig.m > 0) {
            hashMap.put(TPDownloadProxyEnum.DLPARAM_BUFFER_SIZE, Integer.valueOf(this.mConfig.m * 1024 * 1024));
        }
        if (hashMap.size() > 0) {
            tPDownloadParamData.setExtInfoMap(hashMap);
        }
        builder.downloadParam(tPDownloadParamData);
        this.mTPPPlayer.setVideoInfo(builder.build());
    }

    private com.tencent.liteav.txcplayer.c.b transferToITrackInfo(final TPTrackInfo tPTrackInfo) {
        if (tPTrackInfo == null) {
            return null;
        }
        return new com.tencent.liteav.txcplayer.c.b() { // from class: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.5
            public com.tencent.liteav.txcplayer.c.a getFormat() {
                return null;
            }

            public String getInfoInline() {
                StringBuilder sb = new StringBuilder(128);
                sb.append(tPTrackInfo.getName());
                sb.append('{');
                TPTrackInfo tPTrackInfo2 = tPTrackInfo;
                if (tPTrackInfo2 != null) {
                    sb.append(tPTrackInfo2.toString());
                } else {
                    sb.append(com.igexin.push.core.b.l);
                }
                sb.append('}');
                return sb.toString();
            }

            public String getLanguage() {
                return com.anythink.expressad.exoplayer.b.f4327ar;
            }

            public int getTrackType() {
                return tPTrackInfo.getTrackType();
            }
        };
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void attachTRTC(Object obj) {
        this.mTrtcCloud = obj;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("enableMixExternalAudioFrame", Boolean.TYPE, Boolean.TYPE).invoke(this.mTrtcCloud, Boolean.FALSE, Boolean.FALSE);
                LiteavLog.i(this.TAG, "attachTRTC enableMixExternalAudioFrame");
                setEnableMixExternalAudioFrame();
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "attachTRTC exception : " + e.toString());
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void detachTRTC() {
        LiteavLog.i(this.TAG, "detachTRTC");
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("enableMixExternalAudioFrame", Boolean.TYPE, Boolean.TYPE).invoke(this.mTrtcCloud, Boolean.FALSE, Boolean.FALSE);
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "mTrtcCloud detachTRTC exception : " + e.toString());
            }
        }
        if (this.mTrtcAudioTrack != null) {
            try {
                this.mTrtcAudioTrack.getClass().getDeclaredMethod("enablePlayout", Boolean.TYPE).invoke(this.mTrtcAudioTrack, Boolean.FALSE);
            } catch (Exception e2) {
                String str2 = this.TAG;
                LiteavLog.e(str2, "mTrtcAudioTrack detachTRTC exception : " + e2.toString());
            }
        }
        this.mTrtcCloud = null;
        this.mTrtcAudioTrack = null;
        TRTCCloudClassInvokeHelper unused = TRTCCloudClassInvokeHelper.mInstance = null;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void enableAdaptiveBitrate() {
        this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, 1L));
        this.mBitrateIndex = -1;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public int getBitrateIndex() {
        if (this.mBitrateIndex == -1000) {
            TPProgramInfo[] programInfo = this.mTPPPlayer.getProgramInfo();
            if (programInfo != null) {
                int length = programInfo.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    TPProgramInfo tPProgramInfo = programInfo[i2];
                    if (tPProgramInfo.actived) {
                        String str = this.TAG;
                        LiteavLog.i(str, "getBitrateIndex, find active index=" + tPProgramInfo.programId + " ,resolution=" + tPProgramInfo.resolution);
                        this.mBitrateIndex = tPProgramInfo.programId;
                        break;
                    }
                    i = i2 + 1;
                }
            } else {
                return this.mBitrateIndex;
            }
        }
        String str2 = this.TAG;
        LiteavLog.i(str2, "getBitrateIndex ：" + this.mBitrateIndex);
        return this.mBitrateIndex;
    }

    public e getConfig() {
        return this.mConfig;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public long getCurrentPosition() {
        return this.mTPPPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public long getDuration() {
        return this.mTPPPlayer.getDurationMs();
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public com.tencent.liteav.txcplayer.d.b getMediaInfo() {
        String[] split;
        LiteavLog.i(this.TAG, "getMediaInfo");
        com.tencent.liteav.txcplayer.d.b bVar = new com.tencent.liteav.txcplayer.d.b();
        bVar.f22789a = "thumbplayer";
        bVar.f = new com.tencent.liteav.txcplayer.d.c();
        String propertyString = this.mTPPPlayer.getPropertyString(0);
        if (propertyString != null && propertyString.length() > 0 && (split = propertyString.split("\\n")) != null && split.length > 0) {
            bVar.f.b = getSupportedBitrates();
            int i = this.mBitrateIndex;
            int i2 = i;
            if (i == -1000) {
                i2 = 0;
            }
            bVar.f.e = new c.a(i2);
            bVar.f.d = new c.a(i2);
            bVar.f.f22792c.add(bVar.f.e);
            bVar.f.f22792c.add(bVar.f.d);
            int length = split.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= length) {
                    break;
                }
                String str = split[i4];
                if (str != null) {
                    String trim = str.substring(str.indexOf("=") + 1, str.length()).trim();
                    if (str.contains("ContainerFormat=")) {
                        bVar.f.f22791a = trim;
                    } else if (str.contains("VideoCodec=")) {
                        bVar.b = "avcodec";
                        bVar.f22790c = trim;
                        bVar.f.d.b = trim;
                    } else if (str.contains("VideoProfile=")) {
                        bVar.f.d.f22794c = trim;
                    } else if (str.contains("Width=")) {
                        bVar.f.d.e = Integer.valueOf(trim).intValue();
                    } else if (str.contains("Height=")) {
                        bVar.f.d.f = Integer.valueOf(trim).intValue();
                    } else if (str.contains("VideoBitRate=")) {
                        bVar.f.d.d = Integer.valueOf(trim).intValue();
                    } else if (str.contains("AudioCodec=")) {
                        bVar.d = "avcodec";
                        bVar.e = trim;
                        bVar.f.e.b = trim;
                    } else if (str.contains("AudioProfile=")) {
                        bVar.f.e.f22794c = trim;
                    } else if (str.contains("AudioBitRate=")) {
                        bVar.f.e.d = Integer.valueOf(trim).intValue();
                    } else if (str.contains("SampleRate=")) {
                        bVar.f.e.g = Integer.valueOf(trim).intValue();
                    }
                }
                i3 = i4 + 1;
            }
        }
        return bVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public long getPlayableDurationMs() {
        return this.mTPPPlayer.getPlayableDurationMs();
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public long getPropertyLong(int i) throws IllegalStateException {
        if (i == 208) {
            i = 208;
        } else if (i != 209) {
            switch (i) {
                case 100:
                    i = 100;
                    break;
                case 101:
                    i = 101;
                    break;
                case 102:
                    i = 102;
                    break;
                case 103:
                    i = 103;
                    break;
                default:
                    switch (i) {
                        case 201:
                            i = 201;
                            break;
                        case 202:
                            i = 202;
                            break;
                        case 203:
                            i = 203;
                            break;
                        case 204:
                            i = 204;
                            break;
                        case 205:
                            i = 205;
                            break;
                        case 206:
                            i = 206;
                            break;
                        default:
                            switch (i) {
                                case 301:
                                    return this.mBitrate;
                                case 302:
                                    long playableDurationMs = ((this.mBitrate * (this.mTPPPlayer.getPlayableDurationMs() - this.mTPPPlayer.getCurrentPositionMs())) / 1000) / 8;
                                    long j = playableDurationMs;
                                    if (playableDurationMs < 0) {
                                        j = 0;
                                    }
                                    return j;
                                case 303:
                                    return this.mTcpSpeed;
                            }
                    }
            }
        } else {
            i = 209;
        }
        return this.mTPPPlayer.getPropertyLong(i);
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public float getRate() {
        return this.mRate;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public ArrayList<com.tencent.liteav.txcplayer.d.a> getSupportedBitrates() {
        ArrayList<com.tencent.liteav.txcplayer.d.a> arrayList;
        TPProgramInfo[] programInfo = this.mTPPPlayer.getProgramInfo();
        if (programInfo != null) {
            ArrayList<com.tencent.liteav.txcplayer.d.a> arrayList2 = new ArrayList<>(programInfo.length);
            int length = programInfo.length;
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= length) {
                    break;
                }
                TPProgramInfo tPProgramInfo = programInfo[i2];
                if (tPProgramInfo != null) {
                    com.tencent.liteav.txcplayer.d.a aVar = new com.tencent.liteav.txcplayer.d.a();
                    String[] split = tPProgramInfo.resolution.split("x");
                    if (split != null && split.length == 2) {
                        aVar.b = Integer.valueOf(split[0]).intValue();
                        aVar.f22788c = Integer.valueOf(split[1]).intValue();
                    }
                    aVar.d = (int) tPProgramInfo.bandwidth;
                    aVar.f22787a = tPProgramInfo.programId;
                    if (aVar.f22787a == this.mBitrateIndex || tPProgramInfo.actived) {
                        this.mBitrate = aVar.d;
                    }
                    arrayList2.add(aVar);
                    LiteavLog.i(this.TAG, "getSupportedBitrates item index：" + aVar.f22787a + ":width:" + aVar.b + ":height:" + aVar.f22788c + ":bitrate:" + aVar.d);
                }
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        LiteavLog.i(this.TAG, "mBitrateIndex:" + this.mBitrateIndex + ":mBitrate:" + this.mBitrate);
        return arrayList;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public Surface getSurface() {
        String str = this.TAG;
        LiteavLog.i(str, "getSurface ：" + this.mSurface);
        return this.mSurface;
    }

    @Override // com.tencent.liteav.txcplayer.b
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ITPPlayer getTPPPlayer() {
        return this.mTPPPlayer;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public com.tencent.liteav.txcplayer.c.b[] getTrackInfo() {
        com.tencent.liteav.txcplayer.c.b[] bVarArr;
        TPTrackInfo[] trackInfo = this.mTPPPlayer.getTrackInfo();
        if (trackInfo != null && trackInfo.length > 0) {
            com.tencent.liteav.txcplayer.c.b[] bVarArr2 = new com.tencent.liteav.txcplayer.c.b[trackInfo.length];
            int i = 0;
            while (true) {
                int i2 = i;
                bVarArr = bVarArr2;
                if (i2 >= trackInfo.length) {
                    break;
                }
                bVarArr2[i2] = transferToITrackInfo(trackInfo[i2]);
                LiteavLog.i(this.TAG, "getTrackInfo ：" + bVarArr2[i2].toString());
                i = i2 + 1;
            }
        } else {
            bVarArr = null;
        }
        return bVarArr;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public int getVideoHeight() {
        try {
            return this.mTPPPlayer.getVideoHeight();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public int getVideoSarDen() {
        return 0;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public int getVideoSarNum() {
        return 0;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public int getVideoWidth() {
        try {
            return this.mTPPPlayer.getVideoWidth();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public boolean isLooping() {
        String str = this.TAG;
        LiteavLog.i(str, "isLooping ：" + this.mIsLooping);
        return this.mIsLooping;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public boolean isPlaying() {
        boolean z = false;
        try {
            if (this.mTPPPlayer.getCurrentState() == 5) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void onReceiveFirstVideoRenderEvent() {
        if (getTXCVodVideoViewTargetState() == 4 || !(getConfig().p || this.mTPPPlayer.getCurrentState() == 5)) {
            this.mHasReceiveFirstVideoRenderEvent = true;
            return;
        }
        notifyOnInfo(2017, 0, 0, null);
        notifyOnInfo(2026, 0, 0, null);
        notifyOnInfo(2003, 0, 0, null);
        this.mHasReceiveFirstVideoRenderEvent = false;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void pause() throws IllegalStateException {
        this.mTPPPlayer.pause();
        if (this.mTrtcAudioTrack != null) {
            try {
                this.mTrtcAudioTrack.getClass().getDeclaredMethod(com.anythink.expressad.foundation.d.c.cb, new Class[0]).invoke(this.mTrtcAudioTrack, new Object[0]);
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "mTrtcAudioTrack detachTRTC exception : " + e.toString());
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void prepareAsync() throws IllegalStateException {
        try {
            LiteavLog.i(this.TAG, "prepareAsync");
            this.mTPPPlayer.prepareAsync();
        } catch (Throwable th) {
            th.printStackTrace();
            throw new IllegalStateException(th);
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void publishAudioToNetwork() {
        LiteavLog.i(this.TAG, "publishAudioToNetwork");
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("enableMixExternalAudioFrame", Boolean.TYPE, Boolean.TYPE).invoke(this.mTrtcCloud, Boolean.TRUE, Boolean.FALSE);
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "publishAudioToNetwork exception : " + e.toString());
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void release() {
        releaseSurfaceTexture();
        detachTRTC();
        com.tencent.liteav.txcplayer.a.a.a().execute(new Runnable() { // from class: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.4
            @Override // java.lang.Runnable
            public void run() {
                ThumbMediaPlayer.this.mTPPPlayer.release();
            }
        });
    }

    public void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null || this.mReuseSurfaceTexture) {
            return;
        }
        com.tencent.liteav.txcplayer.c cVar = this.mSurfaceTextureHost;
        if (cVar != null) {
            cVar.a(surfaceTexture);
        } else {
            surfaceTexture.release();
        }
        this.mSurfaceTexture = null;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void reset() {
        releaseSurfaceTexture();
        this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_PLAYER_START, Boolean.FALSE);
        if (this.mTPPPlayer != null) {
            this.mTPPPlayer.reset();
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void seekTo(long j) throws IllegalStateException {
        String str = this.TAG;
        LiteavLog.i(str, "seekTo msec: " + j + "：mEnableAccurateSeek：" + this.mEnableAccurateSeek);
        if (this.mEnableAccurateSeek) {
            this.mTPPPlayer.seekTo((int) j, 3);
        } else {
            this.mTPPPlayer.seekTo((int) j);
        }
        if (this.mTrtcAudioTrack != null) {
            try {
                this.mTrtcAudioTrack.getClass().getDeclaredMethod("seek", new Class[0]).invoke(this.mTrtcAudioTrack, new Object[0]);
            } catch (Exception e) {
                String str2 = this.TAG;
                LiteavLog.e(str2, "mTrtcAudioTrack detachTRTC exception : " + e.toString());
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setAudioStreamType(int i) {
        LiteavLog.i(this.TAG, "setAudioStreamType：".concat(String.valueOf(i)));
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setAudioVolume(int i) {
        LiteavLog.i(this.TAG, "setAudioVolume： ".concat(String.valueOf(i)));
        if (i == 0) {
            this.mTPPPlayer.setOutputMute(true);
        } else {
            this.mTPPPlayer.setOutputMute(false);
            this.mTPPPlayer.setAudioGainRatio(i / 100.0f);
        }
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("setMixExternalAudioVolume", Integer.TYPE, Integer.TYPE).invoke(this.mTrtcCloud, Integer.valueOf(i), Integer.valueOf(i));
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "mTrtcCloud setAudioVolume exception : " + e.toString());
            }
        }
        if (this.mTrtcAudioTrack != null) {
            try {
                this.mTrtcAudioTrack.getClass().getDeclaredMethod("setPlayoutVolume", Integer.TYPE).invoke(this.mTrtcAudioTrack, Integer.valueOf(i));
            } catch (Exception e2) {
                String str2 = this.TAG;
                LiteavLog.e(str2, "mTrtcAudioTrack setAudioVolume exception : " + e2.toString());
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setBitrateIndex(int i) {
        TPProgramInfo[] programInfo;
        LiteavLog.i(this.TAG, "setBitrateIndex ：".concat(String.valueOf(i)));
        if (this.mBitrateIndex == -1) {
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, 0L));
        }
        if (i != -1 && (programInfo = this.mTPPPlayer.getProgramInfo()) != null && i >= 0 && i < programInfo.length) {
            this.mTPPPlayer.selectProgram(i, 0L);
        }
        this.mBitrateIndex = i;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setConfig(e eVar) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:539)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String uri2 = uri.toString();
        this.mDataSource = uri2;
        ITPMediaDRMAsset handleDRMAsset = handleDRMAsset(uri2);
        if (handleDRMAsset != null) {
            TPPlayerConfig.setP2PEnable(false);
            this.mTPPPlayer.setDataSource(handleDRMAsset);
        } else if (uri2.contains(".hls?")) {
            TPPlayerConfig.setP2PEnable(true);
            this.mTPPPlayer.setDataSource(uri2.substring(uri2.indexOf(".hls?") + 5), map);
        } else {
            TPPlayerConfig.setP2PEnable(true);
            this.mTPPPlayer.setDataSource(uri2, map);
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mTPPPlayer.setDataSource(ParcelFileDescriptor.dup(fileDescriptor));
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(null, Uri.parse(str));
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.mSurfaceTexture != null) {
            return;
        }
        if (surfaceHolder != null) {
            this.mSurface = surfaceHolder.getSurface();
        }
        this.mSurfaceHolder = surfaceHolder;
        this.mTPPPlayer.setSurfaceHolder(surfaceHolder);
    }

    void setEnableAccurateSeek(boolean z) {
        this.mEnableAccurateSeek = z;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setKeepInBackground(boolean z) {
        LiteavLog.i(this.TAG, "setKeepInBackground none：".concat(String.valueOf(z)));
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setLogEnabled(boolean z) {
        TPLogUtil.setDebugEnable(z);
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setLooping(boolean z) {
        LiteavLog.i(this.TAG, "setLooping ：".concat(String.valueOf(z)));
        this.mIsLooping = z;
        this.mTPPPlayer.setLoopback(z);
    }

    public void setMaxCacheSize(int i) {
        TPPlayerMgr.setProxyMaxStorageSizeMB(i);
    }

    @Override // com.tencent.liteav.txcplayer.a, com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setPrivateConfig(Map<String, Object> map) {
        this.mPrivateConfig = map;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setRate(float f) {
        String str = this.TAG;
        LiteavLog.i(str, "setRate " + this.mRate);
        this.mRate = f;
        this.mTPPPlayer.setPlaySpeedRatio(f);
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setScreenOnWhilePlaying(boolean z) {
        LiteavLog.i(this.TAG, "setScreenOnWhilePlaying(true) screenOn:".concat(String.valueOf(z)));
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                LiteavLog.w(this.TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(z);
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setSurface(Surface surface) {
        if (this.mSurfaceTexture == null) {
            setSurfaceToPlayer(surface);
        }
        String str = this.TAG;
        LiteavLog.i(str, "setSurface mSurface:" + this.mSurface);
    }

    @Override // com.tencent.liteav.txcplayer.b
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.mSurfaceTexture == surfaceTexture) {
            return;
        }
        releaseSurfaceTexture();
        this.mSurfaceTexture = surfaceTexture;
        if (surfaceTexture == null) {
            this.mSurface = null;
            setSurfaceToPlayer(null);
            return;
        }
        if (this.mSurface == null) {
            this.mSurface = new Surface(surfaceTexture);
        }
        setSurfaceToPlayer(this.mSurface);
    }

    @Override // com.tencent.liteav.txcplayer.b
    public void setSurfaceTextureHost(com.tencent.liteav.txcplayer.c cVar) {
        this.mSurfaceTextureHost = cVar;
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void setWakeMode(Context context, int i) {
        boolean z;
        LiteavLog.i(this.TAG, "setWakeMode ：".concat(String.valueOf(i)));
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService(Context.POWER_SERVICE)).newWakeLock(i | 536870912, ThumbMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void start() throws IllegalStateException {
        LiteavLog.i(this.TAG, "TPPlayer start");
        if (this.mHasReceiveFirstVideoRenderEvent) {
            notifyOnInfo(2017, 0, 0, null);
            notifyOnInfo(2026, 0, 0, null);
            notifyOnInfo(2003, 0, 0, null);
            this.mHasReceiveFirstVideoRenderEvent = false;
        }
        if (this.mConfig.m > 0) {
            this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_BUFFER_SIZE_BYTE, Integer.valueOf(this.mConfig.m * 1024 * 1024));
        }
        this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_PLAYER_START, Boolean.TRUE);
        this.mTPPPlayer.start();
        if (this.mTrtcAudioTrack != null) {
            try {
                this.mTrtcAudioTrack.getClass().getDeclaredMethod("resume", new Class[0]).invoke(this.mTrtcAudioTrack, new Object[0]);
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "mTrtcAudioTrack detachTRTC exception : " + e.toString());
            }
        }
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void stop() throws IllegalStateException {
        com.tencent.liteav.txcplayer.a.a.a().execute(new Runnable() { // from class: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ThumbMediaPlayer.this.mTPPPlayer.getCurrentState() == 10 || ThumbMediaPlayer.this.mTPPPlayer.getCurrentState() == 1) {
                        return;
                    }
                    ThumbMediaPlayer.this.mTPPPlayer.stop();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.liteav.txcplayer.ITXVCubePlayer
    public void unpublishAudioToNetwork() {
        LiteavLog.i(this.TAG, "unpublishAudioToNetwork ：none");
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                obj.getClass().getDeclaredMethod("enableMixExternalAudioFrame", Boolean.TYPE, Boolean.TYPE).invoke(this.mTrtcCloud, Boolean.FALSE, Boolean.FALSE);
            } catch (Exception e) {
                String str = this.TAG;
                LiteavLog.e(str, "unpublishAudioToNetwork exception : " + e.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateBitrate(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i <= 0 || this.mTotalFileSize == j) {
            return;
        }
        this.mTotalFileSize = j;
        long duration = getDuration();
        if (duration <= 0 || i <= 0) {
            return;
        }
        this.mBitrate = ((j * 1000) * 8) / duration;
        String str = this.TAG;
        LiteavLog.i(str, "updateBitrate:mTotalFileSize:" + this.mTotalFileSize + ":bitRate:" + this.mBitrate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateTcpSpeed(long j) {
        this.mTcpSpeed = j;
    }
}
