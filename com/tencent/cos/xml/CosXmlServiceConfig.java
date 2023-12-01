package com.tencent.cos.xml;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.cos.xml.common.VersionInfo;
import com.tencent.qcloud.core.http.QCloudHttpRetryHandler;
import com.tencent.qcloud.core.task.RetryStrategy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CosXmlServiceConfig.class */
public class CosXmlServiceConfig implements Parcelable {
    public static final String ACCELERATE_ENDPOINT_SUFFIX = "cos.accelerate";
    public static final String ACCELERATE_HOST_FORMAT = "${bucket}.cos.accelerate.myqcloud.com";
    public static final String CI_HOST_FORMAT = "${bucket}.ci.${region}.myqcloud.com";
    public static final String DEFAULT_HOST_FORMAT = "${bucket}.cos.${region}.myqcloud.com";
    public static final String HTTPS_PROTOCOL = "https";
    public static final String HTTP_PROTOCOL = "http";
    public static final String PATH_STYLE_HOST_FORMAT = "cos.${region}.myqcloud.com";
    public static final String PIC_HOST_FORMAT = "${bucket}.pic.${region}.myqcloud.com";
    private boolean accelerate;
    private String appid;
    private boolean bucketInPath;
    private Map<String, List<String>> commonHeaders;
    private int connectionTimeout;
    private boolean dnsCache;
    private String endpointSuffix;
    private Executor executor;
    private String host;
    private String hostFormat;
    private String hostHeaderFormat;
    private boolean isDebuggable;
    private boolean isQuic;
    private Set<String> noSignHeaders;
    private Executor observeExecutor;
    private int port;
    private List<String> prefetchHosts;
    private String protocol;
    private QCloudHttpRetryHandler qCloudHttpRetryHandler;
    private String region;
    private RetryStrategy retryStrategy;
    private boolean signInUrl;
    private int socketTimeout;
    private boolean transferThreadControl;
    private String userAgent;
    public static final String DEFAULT_USER_AGENT = VersionInfo.getUserAgent();
    public static final Parcelable.Creator<CosXmlServiceConfig> CREATOR = new Parcelable.Creator<CosXmlServiceConfig>() { // from class: com.tencent.cos.xml.CosXmlServiceConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CosXmlServiceConfig createFromParcel(Parcel parcel) {
            return new CosXmlServiceConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CosXmlServiceConfig[] newArray(int i) {
            return new CosXmlServiceConfig[i];
        }
    };

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CosXmlServiceConfig$Builder.class */
    public static final class Builder {
        private boolean accelerate;
        private String appid;
        private boolean bucketInPath;
        private Map<String, List<String>> commonHeaders;
        private int connectionTimeout;
        private boolean dnsCache;
        private String endpointSuffix;
        private Executor executor;
        private String host;
        private String hostFormat;
        private String hostHeaderFormat;
        private boolean isDebuggable;
        private boolean isQuic;
        private Set<String> noSignHeaders;
        private Executor observeExecutor;
        private int port;
        private String protocol;
        private QCloudHttpRetryHandler qCloudHttpRetryHandler;
        private String region;
        private RetryStrategy retryStrategy;
        private boolean signInUrl;
        private int socketTimeout;
        private boolean transferThreadControl;
        private String userAgent;

        public Builder() {
            this.port = -1;
            this.connectionTimeout = 15000;
            this.socketTimeout = 30000;
            this.isQuic = false;
            this.dnsCache = true;
            this.commonHeaders = new HashMap();
            this.noSignHeaders = new HashSet();
            this.transferThreadControl = true;
            this.protocol = "https";
            this.userAgent = CosXmlServiceConfig.DEFAULT_USER_AGENT;
            this.isDebuggable = false;
            this.retryStrategy = RetryStrategy.DEFAULT;
            this.bucketInPath = false;
        }

        public Builder(CosXmlServiceConfig cosXmlServiceConfig) {
            this.port = -1;
            this.connectionTimeout = 15000;
            this.socketTimeout = 30000;
            this.isQuic = false;
            this.dnsCache = true;
            this.commonHeaders = new HashMap();
            this.noSignHeaders = new HashSet();
            this.transferThreadControl = true;
            this.protocol = cosXmlServiceConfig.protocol;
            this.userAgent = CosXmlServiceConfig.DEFAULT_USER_AGENT;
            this.region = cosXmlServiceConfig.region;
            this.appid = cosXmlServiceConfig.appid;
            this.host = cosXmlServiceConfig.host;
            this.port = cosXmlServiceConfig.port;
            this.endpointSuffix = cosXmlServiceConfig.endpointSuffix;
            this.bucketInPath = cosXmlServiceConfig.bucketInPath;
            this.isDebuggable = cosXmlServiceConfig.isDebuggable;
            this.retryStrategy = cosXmlServiceConfig.retryStrategy;
            this.qCloudHttpRetryHandler = cosXmlServiceConfig.qCloudHttpRetryHandler;
            this.connectionTimeout = cosXmlServiceConfig.connectionTimeout;
            this.socketTimeout = cosXmlServiceConfig.socketTimeout;
            this.executor = cosXmlServiceConfig.executor;
            this.observeExecutor = cosXmlServiceConfig.observeExecutor;
            this.isQuic = cosXmlServiceConfig.isQuic;
            this.dnsCache = cosXmlServiceConfig.dnsCache;
            this.commonHeaders = cosXmlServiceConfig.commonHeaders;
            this.noSignHeaders = cosXmlServiceConfig.noSignHeaders;
            this.hostFormat = cosXmlServiceConfig.hostFormat;
            this.hostHeaderFormat = cosXmlServiceConfig.hostHeaderFormat;
            this.accelerate = cosXmlServiceConfig.accelerate;
            this.signInUrl = cosXmlServiceConfig.signInUrl;
            this.transferThreadControl = cosXmlServiceConfig.transferThreadControl;
        }

        public Builder addHeader(String str, String str2) {
            List<String> list = this.commonHeaders.get(str);
            LinkedList linkedList = list;
            if (list == null) {
                linkedList = new LinkedList();
            }
            linkedList.add(str2);
            this.commonHeaders.put(str, linkedList);
            return this;
        }

        public Builder addNoSignHeaders(String str) {
            this.noSignHeaders.add(str);
            return this;
        }

        public CosXmlServiceConfig builder() {
            return new CosXmlServiceConfig(this);
        }

        public Builder dnsCache(boolean z) {
            this.dnsCache = z;
            return this;
        }

        public Builder enableQuic(boolean z) {
            this.isQuic = z;
            this.userAgent = VersionInfo.getQuicUserAgent();
            return this;
        }

        public Builder isHttps(boolean z) {
            if (z) {
                this.protocol = "https";
                return this;
            }
            this.protocol = "http";
            return this;
        }

        public Builder setAccelerate(boolean z) {
            this.accelerate = z;
            return this;
        }

        @Deprecated
        public Builder setAppidAndRegion(String str, String str2) {
            this.appid = str;
            this.region = str2;
            return this;
        }

        @Deprecated
        public Builder setBucketInPath(boolean z) {
            this.bucketInPath = z;
            return this;
        }

        public Builder setConnectionTimeout(int i) {
            this.connectionTimeout = i;
            return this;
        }

        public Builder setDebuggable(boolean z) {
            this.isDebuggable = z;
            return this;
        }

        @Deprecated
        public Builder setEndpointSuffix(String str) {
            this.endpointSuffix = str;
            return this;
        }

        public Builder setExecutor(Executor executor) {
            this.executor = executor;
            return this;
        }

        public Builder setHost(Uri uri) {
            this.host = uri.getHost();
            if (uri.getPort() != -1) {
                this.port = uri.getPort();
            }
            this.protocol = uri.getScheme();
            return this;
        }

        public Builder setHost(String str) {
            this.host = str;
            return this;
        }

        public Builder setHostFormat(String str) {
            this.hostFormat = str;
            return this;
        }

        public Builder setObserveExecutor(Executor executor) {
            this.observeExecutor = executor;
            return this;
        }

        public Builder setPathStyle(boolean z) {
            this.bucketInPath = z;
            return this;
        }

        public Builder setPort(int i) {
            this.port = i;
            return this;
        }

        public Builder setRegion(String str) {
            this.region = str;
            return this;
        }

        public Builder setRetryHandler(QCloudHttpRetryHandler qCloudHttpRetryHandler) {
            this.qCloudHttpRetryHandler = qCloudHttpRetryHandler;
            return this;
        }

        public Builder setRetryStrategy(RetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            return this;
        }

        public Builder setSignInUrl(boolean z) {
            this.signInUrl = z;
            return this;
        }

        public Builder setSocketTimeout(int i) {
            this.socketTimeout = i;
            return this;
        }

        public Builder setTransferThreadControl(boolean z) {
            this.transferThreadControl = z;
            return this;
        }
    }

    private CosXmlServiceConfig(Parcel parcel) {
        this(new Builder().isHttps("https".equals(parcel.readString())).setRegion(parcel.readString()).setDebuggable(parcel.readInt() != 1 ? false : true));
    }

    public CosXmlServiceConfig(Builder builder) {
        this.hostFormat = DEFAULT_HOST_FORMAT;
        this.hostHeaderFormat = null;
        this.transferThreadControl = true;
        this.protocol = builder.protocol;
        this.userAgent = builder.userAgent;
        this.isDebuggable = builder.isDebuggable;
        this.appid = builder.appid;
        this.region = builder.region;
        this.host = builder.host;
        this.port = builder.port;
        this.endpointSuffix = builder.endpointSuffix;
        this.bucketInPath = builder.bucketInPath;
        this.commonHeaders = builder.commonHeaders;
        this.noSignHeaders = builder.noSignHeaders;
        if (TextUtils.isEmpty(this.hostFormat) && TextUtils.isEmpty(this.region) && TextUtils.isEmpty(this.host)) {
            throw new IllegalArgumentException("please set host or endpointSuffix or region !");
        }
        this.retryStrategy = builder.retryStrategy;
        this.qCloudHttpRetryHandler = builder.qCloudHttpRetryHandler;
        this.socketTimeout = builder.socketTimeout;
        this.connectionTimeout = builder.connectionTimeout;
        this.hostFormat = builder.hostFormat;
        this.hostHeaderFormat = builder.hostHeaderFormat;
        this.executor = builder.executor;
        this.observeExecutor = builder.observeExecutor;
        this.isQuic = builder.isQuic;
        this.accelerate = builder.accelerate;
        this.dnsCache = builder.dnsCache;
        this.signInUrl = builder.signInUrl;
        this.transferThreadControl = builder.transferThreadControl;
    }

    private String getFormatHost(String str, String str2, String str3) {
        return str.replace("${bucket}", str3).replace("${region}", str2);
    }

    private String getHostFormat(boolean z, boolean z2) {
        if (TextUtils.isEmpty(this.hostFormat)) {
            String str = z ? ACCELERATE_HOST_FORMAT : z2 ? PATH_STYLE_HOST_FORMAT : DEFAULT_HOST_FORMAT;
            String str2 = this.endpointSuffix;
            if (str2 != null) {
                if (!this.bucketInPath) {
                    str2 = "${bucket}.".concat(str2);
                }
                str = str2;
                if (z) {
                    str = str2.replace("cos.${region}", ACCELERATE_ENDPOINT_SUFFIX);
                }
            }
            return str;
        }
        return this.hostFormat;
    }

    private String substituteEndpointSuffix(String str, String str2) {
        String str3 = str;
        if (!TextUtils.isEmpty(str)) {
            str3 = str;
            if (str2 != null) {
                str3 = str.replace("${region}", str2);
            }
        }
        return str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getBucket(String str) {
        return getBucket(str, this.appid);
    }

    public String getBucket(String str, String str2) {
        String str3 = str;
        if (str != null) {
            str3 = str;
            if (!str.endsWith("-" + str2)) {
                str3 = str;
                if (!TextUtils.isEmpty(str2)) {
                    str3 = str + "-" + str2;
                }
            }
        }
        return str3;
    }

    public Map<String, List<String>> getCommonHeaders() {
        return this.commonHeaders;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public String getDefaultRequestHost(String str, String str2) {
        return getFormatHost(DEFAULT_HOST_FORMAT, str, str2);
    }

    @Deprecated
    public String getDefaultRequestHost(String str, String str2, String str3) {
        return getDefaultRequestHost(str, getBucket(str2, str3));
    }

    @Deprecated
    public String getEndpointSuffix() {
        return getEndpointSuffix(this.region, false);
    }

    @Deprecated
    public String getEndpointSuffix(String str, boolean z) {
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            str2 = getRegion();
        }
        String str3 = this.endpointSuffix;
        String str4 = str3;
        if (str3 == null) {
            str4 = str3;
            if (str2 != null) {
                str4 = "cos." + str2 + ".myqcloud.com";
            }
        }
        String substituteEndpointSuffix = substituteEndpointSuffix(str4, str2);
        String str5 = substituteEndpointSuffix;
        if (substituteEndpointSuffix != null) {
            str5 = substituteEndpointSuffix;
            if (z) {
                str5 = substituteEndpointSuffix.replace("cos." + str2, ACCELERATE_ENDPOINT_SUFFIX);
            }
        }
        return str5;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public String getHeaderHost(String str, String str2) {
        String str3 = this.hostHeaderFormat;
        return str3 != null ? getFormatHost(str3, str, str2) : "";
    }

    @Deprecated
    public String getHost(String str, String str2, String str3, boolean z) {
        return getHost(str, str2, str3, z, false);
    }

    @Deprecated
    public String getHost(String str, String str2, String str3, boolean z, boolean z2) {
        if (z2 || TextUtils.isEmpty(this.host)) {
            String bucket = getBucket(str, str3);
            String str4 = "";
            if (!this.bucketInPath) {
                str4 = "" + bucket + ".";
            }
            return str4 + getEndpointSuffix(str2, z);
        }
        return this.host;
    }

    @Deprecated
    public String getHost(String str, String str2, boolean z) {
        return getHost(str, str2, this.appid, z);
    }

    @Deprecated
    public String getHost(String str, String str2, boolean z, boolean z2) {
        return getHost(str, str2, this.appid, z, z2);
    }

    @Deprecated
    public String getHost(String str, boolean z) {
        return getHost(str, null, z);
    }

    public Set<String> getNoSignHeaders() {
        return this.noSignHeaders;
    }

    public Executor getObserveExecutor() {
        return this.observeExecutor;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public QCloudHttpRetryHandler getQCloudHttpRetryHandler() {
        return this.qCloudHttpRetryHandler;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRequestHost(String str, String str2, String str3) {
        if (TextUtils.isEmpty(this.host)) {
            String str4 = str;
            if (TextUtils.isEmpty(str)) {
                str4 = this.region;
            }
            return getFormatHost(str3, str4, getBucket(str2, this.appid));
        }
        return this.host;
    }

    public String getRequestHost(String str, String str2, boolean z) {
        return getRequestHost(str, str2, getHostFormat(z || this.accelerate, this.bucketInPath));
    }

    public String getRequestHost(String str, boolean z) {
        return getRequestHost((String) null, str, z);
    }

    public RetryStrategy getRetryStrategy() {
        return this.retryStrategy;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public String getUrlPath(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (this.bucketInPath) {
            String str3 = str;
            if (!str.endsWith("-" + this.appid)) {
                str3 = str;
                if (!TextUtils.isEmpty(this.appid)) {
                    str3 = str + "-" + this.appid;
                }
            }
            sb.append(BridgeUtil.SPLIT_MARK);
            sb.append(str3);
        }
        if (str2 == null || str2.startsWith(BridgeUtil.SPLIT_MARK)) {
            sb.append(str2);
        } else {
            sb.append(BridgeUtil.SPLIT_MARK);
            sb.append(str2);
        }
        return sb.toString();
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isDebuggable() {
        return this.isDebuggable;
    }

    public boolean isDnsCache() {
        return this.dnsCache;
    }

    public boolean isEnableQuic() {
        return this.isQuic;
    }

    public boolean isSignInUrl() {
        return this.signInUrl;
    }

    public boolean isTransferThreadControl() {
        return this.transferThreadControl;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
