package com.qiniu.pili.droid.streaming.core;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import a.a.a.a.a.f.d;
import a.a.a.a.a.n.b;
import android.content.Intent;
import com.cdo.oaps.ad.OapsWrapper;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.tencent.ugc.UGCTransitionRules;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/core/PLDroidStreamingCore.class */
public class PLDroidStreamingCore {
    public static final String TAG = "PLDroidStreamingCore";
    public static String mDomain;
    public static String mPath;
    public static String mRemoteIP;
    public static String mReqID;
    public static String mScheme;
    public String currentUrl;
    public b mErrorListener;
    public static final boolean isLoadOk = SharedLibraryNameHelper.getInstance().e();
    public static int ERROR_CODE_TIME_OUT = -110;
    public static int ERROR_CODE_UNINITIALIZED = -1;
    public static int ERROR_CODE_DISCONNECTED = -2;
    public static int ERROR_CODE_UNAUTHORIZED_URL = -3;
    public boolean isUnauthorized = false;
    public boolean mInitialized = false;
    public final b.g listener = new a();

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/core/PLDroidStreamingCore$AVOptions.class */
    public static class AVOptions implements Cloneable {
        public String outputFormatName = "flv";
        public String outputUrl = "test.flv";
        public int type = c.VIDEO_AUDIO.ordinal();
        public boolean isLoggingEnabled = e.a();
        public int videoHeight = 1280;
        public int videoWidth = UGCTransitionRules.DEFAULT_IMAGE_WIDTH;
        public int videoFps = 30;
        public int videoBitRate = 1500000;
        public int audioSampleRate = 44100;
        public int audioNumChannels = 1;
        public int audioBitRate = 128000;
        public boolean avcc = true;
        public boolean quicEnable = false;
        public int quicPort = 6935;
        public int sendTimeout = 3;
        public String deviceModel = h.i();
        public String osPlatform = "Android";
        public String osVersion = h.j();
        public String appName = "";
        public String appVersion = "";
        public String componentsVersion = "librtmp-1.1.0;PLDroidCameraStreaming-3.0.0";
        public String networkType = "";
        public boolean isWifiNetwork = true;
        public boolean enableWifiPermission = false;
        public boolean enablePhonePermission = false;
        public String ispName = "";
        public int signalDB = 0;
        public String videoEncodeType = "x264";
        public String audioEncodeType = "voaac";
        public long gopTimeMS = 0;
        public long cuBasetime = 0;
        public Map<String, String> rtmpOptions = null;

        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/core/PLDroidStreamingCore$a.class */
    public class a implements b.g {
        public a() {
        }

        @Override // a.a.a.a.a.n.b.g
        public void a() {
            if (PLDroidStreamingCore.this.currentUrl != null) {
                try {
                    a.a.a.a.a.n.b.a().b(PLDroidStreamingCore.this.currentUrl);
                } catch (d e) {
                    PLDroidStreamingCore.this.isUnauthorized = true;
                } catch (URISyntaxException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/core/PLDroidStreamingCore$b.class */
    public interface b {
        void a(int i, String str);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/core/PLDroidStreamingCore$c.class */
    public enum c {
        VIDEO_AUDIO,
        VIDEO,
        AUDIO
    }

    private void checkAVOptions(AVOptions aVOptions) {
        e.f.b(TAG, "checkAVOptions");
        if (aVOptions.ispName == null) {
            aVOptions.ispName = "";
            e.f.e(TAG, "AVOptions: ispName is null");
        }
        if (aVOptions.appName == null) {
            aVOptions.appName = "";
            e.f.e(TAG, "AVOptions: appName is null");
        }
        if (aVOptions.appVersion == null) {
            aVOptions.appVersion = "";
            e.f.e(TAG, "AVOptions: appVersion is null");
        }
        if (aVOptions.networkType == null) {
            aVOptions.networkType = "Unknown";
            e.f.e(TAG, "AVOptions: networkType is unknown");
        }
    }

    private native void doFinalize(boolean z);

    public static void getDomain(String str) throws IOException {
        try {
            mDomain = a.a.a.a.a.n.b.a(str);
        } catch (URISyntaxException e) {
            throw new IOException("invalid url=>" + str);
        }
    }

    public static String getOutputUrlByDns(String str) throws IOException {
        String str2;
        DnsManager dnsManager = StreamingProfile.getDnsManager();
        if (dnsManager != null) {
            try {
                URI uri = new URI(str);
                mScheme = uri.getScheme();
                mPath = uri.getPath();
                if (DnsManager.validIP(uri.getHost())) {
                    return str;
                }
                String[] query = dnsManager.query(uri.getHost());
                if (query != null && query.length > 0) {
                    String query2 = uri.getQuery();
                    if (uri.getPort() > 0) {
                        str2 = ":" + Integer.toString(uri.getPort());
                    } else {
                        str2 = "";
                    }
                    return (query2 == null || query2.equals("")) ? String.format("rtmp://%s%s%s?domain=%s", query[0], str2, uri.getPath(), uri.getHost()) : String.format("rtmp://%s%s%s?%s&domain=%s", query[0], str2, uri.getPath(), uri.getQuery(), uri.getHost());
                }
            } catch (URISyntaxException e) {
                e.printStackTrace();
                throw new IOException(e.getMessage());
            }
        }
        return str;
    }

    public static String getOutputUrlByZeus(String str) throws IOException, URISyntaxException {
        return a.a.a.a.a.n.b.a().b(str);
    }

    private native String getPushIP();

    public static Integer[] getQuicConfig() {
        return a.a.a.a.a.n.b.a().c(mDomain);
    }

    private native String getReqID();

    private String getRtmpOptions(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(" ");
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private native void initialize(AVOptions aVOptions) throws IOException;

    private void initializeInternal(AVOptions aVOptions) throws IOException {
        String str;
        e.f.c(TAG, "isLoggingEnabled:" + aVOptions.isLoggingEnabled);
        this.currentUrl = aVOptions.outputUrl;
        this.isUnauthorized = false;
        a.a.a.a.a.n.b.a().a(this.listener);
        updateOutputUrl(aVOptions);
        checkAVOptions(aVOptions);
        String rtmpOptions = getRtmpOptions(aVOptions.rtmpOptions);
        if (rtmpOptions != null) {
            aVOptions.outputUrl += rtmpOptions;
        }
        getDomain(this.currentUrl);
        if (a.a.a.a.a.n.b.f1416a) {
            Integer[] quicConfig = getQuicConfig();
            if (quicConfig.length == 2) {
                int intValue = quicConfig[0].intValue();
                aVOptions.quicPort = quicConfig[1].intValue();
                if (intValue == 1) {
                    aVOptions.quicEnable = true;
                } else if (intValue == 2) {
                    aVOptions.quicEnable = false;
                }
                e.f.a("quic mode = " + intValue + ", port = " + aVOptions.quicPort + ", enable = " + aVOptions.quicEnable);
            }
        } else {
            aVOptions.quicEnable = false;
        }
        initialize(aVOptions);
        mRemoteIP = getPushIP();
        mReqID = getReqID();
        this.mInitialized = true;
        Intent intent = new Intent("pldroid-qos-filter");
        intent.putExtra("pldroid-qos-msg-type", 4);
        if (aVOptions.quicEnable) {
            str = mScheme + ".quic";
        } else {
            str = mScheme;
        }
        intent.putExtra("scheme", str);
        intent.putExtra("domain", mDomain);
        intent.putExtra("remoteIp", mRemoteIP);
        intent.putExtra(OapsWrapper.KEY_PATH, mPath);
        intent.putExtra("reqid", mReqID);
        a.a.a.a.a.j.a.a().a(intent);
    }

    private native void prepareAudioExtraData(byte[] bArr, int i, long j);

    private native void prepareVideoExtraData(byte[] bArr, int i, long j);

    public static void updateOutputUrl(AVOptions aVOptions) throws IOException {
        aVOptions.sendTimeout = StreamingProfile.getSendTimeout();
        if (a.a.a.a.a.n.b.f1416a && !a.a.a.a.a.c.a.a().b()) {
            try {
                aVOptions.outputUrl = getOutputUrlByZeus(aVOptions.outputUrl);
            } catch (URISyntaxException e) {
                throw new IOException("invalid url=>" + aVOptions.outputUrl);
            }
        }
        aVOptions.outputUrl = getOutputUrlByDns(aVOptions.outputUrl);
    }

    private native int writePacket(ByteBuffer byteBuffer, int i, long j, long j2, boolean z, boolean z2, byte[] bArr, int i2);

    public void errorCallback(int i) {
        e eVar = e.f;
        eVar.c(TAG, "errorCode:" + i);
    }

    public void errorCallback(int i, String str) {
        b bVar = this.mErrorListener;
        if (bVar != null) {
            bVar.a(i, str);
        }
        e eVar = e.f;
        eVar.c(TAG, "errorCode:" + i + ", msg:" + str);
    }

    public String getPath() {
        return mPath;
    }

    public String getRemoteIP() {
        String str = mRemoteIP;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public void initCore(AVOptions aVOptions) throws IOException {
        initializeInternal(aVOptions);
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public int sendFrame(ByteBuffer byteBuffer, int i, long j, long j2, boolean z, boolean z2) {
        return sendFrame(byteBuffer, i, j, j2, z, z2, null);
    }

    public int sendFrame(ByteBuffer byteBuffer, int i, long j, long j2, boolean z, boolean z2, String str) {
        byte[] bArr;
        int i2;
        if (this.isUnauthorized) {
            errorCallback(ERROR_CODE_UNAUTHORIZED_URL, "ERROR_CODE_UNAUTHORIZED_URL");
            return ERROR_CODE_UNAUTHORIZED_URL;
        } else if (this.mInitialized) {
            if (str == null || str.isEmpty()) {
                bArr = null;
                i2 = 0;
            } else {
                byte[] bytes = str.getBytes();
                i2 = bytes.length;
                e.i.e(TAG, "send sei  : " + str + " size ： " + i2);
                bArr = bytes;
            }
            return writePacket(byteBuffer, i, j, j2, z, z2, bArr, i2);
        } else {
            return ERROR_CODE_UNINITIALIZED;
        }
    }

    public final void setOnErrorListener(b bVar) {
        if (bVar == null) {
            e.f.e(TAG, "Error!!! listener cannot be null");
        } else {
            this.mErrorListener = bVar;
        }
    }

    public void shutDown(boolean z) {
        a.a.a.a.a.n.b.a().b(this.listener);
        this.mErrorListener = null;
        doFinalize(z);
        this.mInitialized = false;
    }

    public native void updateAVOptions(AVOptions aVOptions, boolean z);

    public void writeAudioSeqHeader(byte[] bArr, int i, long j) {
        prepareAudioExtraData(bArr, i, j);
    }

    public void writeVideoSeqHeader(byte[] bArr, int i, long j) {
        prepareVideoExtraData(bArr, i, j);
    }
}
