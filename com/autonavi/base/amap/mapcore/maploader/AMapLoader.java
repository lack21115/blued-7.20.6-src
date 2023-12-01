package com.autonavi.base.amap.mapcore.maploader;

import android.content.Context;
import com.amap.api.col.3sl.da;
import com.amap.api.col.3sl.dt;
import com.amap.api.col.3sl.dw;
import com.amap.api.col.3sl.ho;
import com.amap.api.col.3sl.hr;
import com.amap.api.col.3sl.hx;
import com.amap.api.col.3sl.ia;
import com.amap.api.col.3sl.iw;
import com.amap.api.col.3sl.jw;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.openalliance.ad.constant.t;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/maploader/AMapLoader.class */
public class AMapLoader implements jw.a {
    private static final int GET_METHOD = 0;
    private static final String NETWORK_RESPONSE_CODE_STRING = "网络异常状态码：";
    private jw downloadManager;
    ADataRequestParam mDataRequestParam;
    private int mEngineID;
    GLMapEngine mGLMapEngine;
    private boolean mRequestCancel;
    private volatile boolean isCanceled = false;
    private long requestMapDataTimestamp = 0;
    private long requestMapDataPackageSize = 0;

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/maploader/AMapLoader$ADataRequestParam.class */
    public static class ADataRequestParam {
        public byte[] enCodeString;
        public long handler;
        public int nCompress;
        public int nRequestType;
        public String requestBaseUrl;
        public String requestUrl;
    }

    /* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/amap/mapcore/maploader/AMapLoader$AMapGridDownloadRequest.class */
    public static class AMapGridDownloadRequest extends da {
        private final Context mContext;
        private byte[] postEntityBytes;
        private String sUrl;
        private String userAgent;

        public AMapGridDownloadRequest(Context context, String str, String str2) {
            this.mContext = context;
            this.sUrl = str;
            this.userAgent = str2;
        }

        public byte[] getEntityBytes() {
            return this.postEntityBytes;
        }

        public String getIPV6URL() {
            return dw.a(getURL());
        }

        public Map<String, String> getParams() {
            return null;
        }

        public Map<String, String> getRequestHead() {
            ia a2 = dw.a();
            String b = a2 != null ? a2.b() : null;
            String f = ho.f(this.mContext);
            try {
                f = URLEncoder.encode(f, "UTF-8");
            } catch (Throwable th) {
            }
            Hashtable hashtable = new Hashtable(16);
            hashtable.put("User-Agent", this.userAgent);
            hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", b, "3dmap"));
            hashtable.put("x-INFO", hr.a(this.mContext));
            hashtable.put("key", f);
            hashtable.put("logversion", "2.1");
            return hashtable;
        }

        public String getURL() {
            return this.sUrl;
        }

        public boolean isSupportIPV6() {
            return true;
        }

        public void setPostEntityBytes(byte[] bArr) {
            this.postEntityBytes = bArr;
        }
    }

    public AMapLoader(int i, GLMapEngine gLMapEngine, ADataRequestParam aDataRequestParam) {
        this.mEngineID = 0;
        this.mRequestCancel = false;
        this.mDataRequestParam = aDataRequestParam;
        this.mEngineID = i;
        this.mGLMapEngine = gLMapEngine;
        this.mRequestCancel = false;
    }

    private String generateQueryString(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        String f = ho.f(this.mGLMapEngine.getContext());
        try {
            f = URLEncoder.encode(f, "UTF-8");
        } catch (Throwable th) {
        }
        stringBuffer.append("&key=");
        stringBuffer.append(f);
        String sortReEncoderParams = sortReEncoderParams(stringBuffer.toString());
        String a2 = hr.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a2)));
        stringBuffer.append("&scode=" + hr.a(context, a2, sortReEncoderParams));
        stringBuffer.append("&dip=16300");
        return stringBuffer.toString();
    }

    private String getEncodeRequestParams(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getNetworkFailedReason(String str) {
        if (!this.mGLMapEngine.isNetworkConnected()) {
            str = "无网络";
        }
        return str;
    }

    private void onCancel() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.netCancel(this.mEngineID, aDataRequestParam.handler, -1);
    }

    private String sortReEncoderParams(String str) {
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            stringBuffer.append(strReEncoder(split[i2]));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            i = i2 + 1;
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            str = (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    private void staticNetworkPerformance() {
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null) {
            dt.a(gLMapEngine.getContext(), this.mGLMapEngine.hashCode(), System.currentTimeMillis() - this.requestMapDataTimestamp, this.requestMapDataPackageSize);
        }
    }

    private String strReEncoder(String str) {
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            iw.c(e, "AbstractProtocalHandler", "strReEncoder");
            return "";
        } catch (Exception e2) {
            iw.c(e2, "AbstractProtocalHandler", "strReEncoderException");
            return "";
        }
    }

    public void doCancel() {
        this.mRequestCancel = true;
        if (this.downloadManager == null || this.isCanceled) {
            return;
        }
        synchronized (this.downloadManager) {
            try {
                this.isCanceled = true;
                this.downloadManager.a();
                this.mGLMapEngine.setMapLoaderToTask(this.mEngineID, this.mDataRequestParam.handler, null);
            }
        }
    }

    public void doCancelAndNotify() {
        doCancel();
        onCancel();
    }

    public void doRequest() {
        if (hx.a(this.mGLMapEngine.getContext(), dw.a()).a == hx.c.a && !this.mRequestCancel) {
            String str = this.mDataRequestParam.requestBaseUrl;
            String str2 = this.mDataRequestParam.requestUrl;
            String str3 = str;
            if (!str.endsWith("?")) {
                str3 = str + "?";
            }
            String requestParams = getRequestParams(str2.replaceAll(t.aE, getEncodeRequestParams(t.aE).toString()), str3 != null && str3.contains("http://m5.amap.com/"), this.mDataRequestParam.nRequestType);
            StringBuffer stringBuffer = new StringBuffer();
            if (this.mDataRequestParam.nRequestType == 0) {
                stringBuffer.append(requestParams);
                stringBuffer.append("&csid=" + UUID.randomUUID().toString());
            } else {
                stringBuffer.append("csid=" + UUID.randomUUID().toString());
            }
            try {
                AMapGridDownloadRequest aMapGridDownloadRequest = new AMapGridDownloadRequest(this.mGLMapEngine.getContext(), str3 + generateQueryString(this.mGLMapEngine.getContext(), stringBuffer.toString()), this.mGLMapEngine.getUserAgent());
                aMapGridDownloadRequest.setConnectionTimeout(30000);
                aMapGridDownloadRequest.setSoTimeout(30000);
                if (this.mDataRequestParam.nRequestType != 0) {
                    aMapGridDownloadRequest.setPostEntityBytes(requestParams.getBytes("UTF-8"));
                }
                this.requestMapDataTimestamp = System.currentTimeMillis();
                this.requestMapDataPackageSize = aMapGridDownloadRequest.getEntityBytes() == null ? 0L : aMapGridDownloadRequest.getEntityBytes().length;
                jw jwVar = new jw(aMapGridDownloadRequest, 0L, -1L, MapsInitializer.getProtocol() == 2);
                this.downloadManager = jwVar;
                jwVar.a(this);
            } catch (Throwable th) {
                try {
                    onException(th);
                } finally {
                    doCancel();
                }
            }
        }
    }

    protected String getRequestParams(String str, boolean z, int i) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (z) {
            stringBuffer.append("&channel=amap7&div=GNaviMap");
        } else {
            stringBuffer.append("&channel=amapapi");
            stringBuffer.append("&div=GNaviMap");
        }
        return stringBuffer.toString();
    }

    public void onDownload(byte[] bArr, long j) {
        GLMapEngine gLMapEngine;
        ADataRequestParam aDataRequestParam;
        if (bArr == null || (gLMapEngine = this.mGLMapEngine) == null || (aDataRequestParam = this.mDataRequestParam) == null) {
            return;
        }
        gLMapEngine.receiveNetData(this.mEngineID, aDataRequestParam.handler, bArr, bArr.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r10 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
        com.amap.api.col.3sl.dt.a(r10.getContext(), r7.mGLMapEngine.hashCode(), !r7.mGLMapEngine.isNetworkConnected(), getNetworkFailedReason(r8.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ae, code lost:
        if (r10 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b4, code lost:
        com.amap.api.col.3sl.iw.c(r8, "AMapLoader", "download onException");
        com.amap.api.col.3sl.dy.b(com.amap.api.col.3sl.dx.e, "map loader exception " + r8.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00e0, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onException(java.lang.Throwable r8) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.maploader.AMapLoader.onException(java.lang.Throwable):void");
    }

    public void onFinish() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.finishDownLoad(this.mEngineID, aDataRequestParam.handler);
        }
        staticNetworkPerformance();
    }

    public void onStop() {
        ADataRequestParam aDataRequestParam;
        GLMapEngine gLMapEngine = this.mGLMapEngine;
        if (gLMapEngine != null && (aDataRequestParam = this.mDataRequestParam) != null) {
            gLMapEngine.netStop(this.mEngineID, aDataRequestParam.handler, -1);
        }
        staticNetworkPerformance();
    }
}
