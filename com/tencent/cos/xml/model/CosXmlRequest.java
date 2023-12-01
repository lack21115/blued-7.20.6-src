package com.tencent.cos.xml.model;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.auth.COSXmlSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.STSCredentialScope;
import com.tencent.qcloud.core.common.QCloudTaskStateListener;
import com.tencent.qcloud.core.http.HttpConfiguration;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/CosXmlRequest.class */
public abstract class CosXmlRequest {
    protected String bucket;
    private HttpTask httpTask;
    private String keyTime;
    private HttpTaskMetrics metrics;
    private OnRequestWeightListener onRequestWeightListener;
    protected QCloudTaskStateListener qCloudTaskStateListener;
    private String queryParameterEncodedString;
    protected String region;
    protected String requestURL;
    private boolean signInUrl;
    protected QCloudSignSourceProvider signSourceProvider;
    protected Map<String, String> queryParameters = new LinkedHashMap();
    protected Map<String, List<String>> requestHeaders = new LinkedHashMap();
    protected Set<String> noSignHeaders = new HashSet();
    protected Set<String> noSignParams = new HashSet();
    private boolean isNeedMD5 = false;
    private boolean isSupportAccelerate = false;
    protected int priority = -1;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/CosXmlRequest$OnRequestWeightListener.class */
    public interface OnRequestWeightListener {
        int onWeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addHeader(String str, String str2) {
        ArrayList arrayList = this.requestHeaders.containsKey(str) ? this.requestHeaders.get(str) : new ArrayList();
        arrayList.add(str2);
        this.requestHeaders.put(str, arrayList);
    }

    public void addNoSignHeader(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.noSignHeaders.add(str);
    }

    public void addNoSignParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.noSignParams.add(str);
    }

    public void addQuery(String str, String str2) {
        this.queryParameters.put(str, str2);
    }

    public void attachMetrics(HttpTaskMetrics httpTaskMetrics) {
        this.metrics = httpTaskMetrics;
    }

    public void checkParameters() throws CosXmlClientException {
    }

    public String getBucket() {
        return this.bucket;
    }

    public HttpTask getHttpTask() {
        return this.httpTask;
    }

    public String getKeyTime() {
        return this.keyTime;
    }

    public abstract String getMethod();

    public HttpTaskMetrics getMetrics() {
        return this.metrics;
    }

    public Set<String> getNoSignHeaders() {
        return this.noSignHeaders;
    }

    public Set<String> getNoSignParams() {
        return this.noSignParams;
    }

    public abstract String getPath(CosXmlServiceConfig cosXmlServiceConfig);

    public int getPriority() {
        return this.priority;
    }

    public String getQueryEncodedString() {
        return this.queryParameterEncodedString;
    }

    public Map<String, String> getQueryString() {
        return this.queryParameters;
    }

    public String getRegion() {
        return this.region;
    }

    public abstract RequestBodySerializer getRequestBody() throws CosXmlClientException;

    public Map<String, List<String>> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getRequestHost(CosXmlServiceConfig cosXmlServiceConfig) {
        return cosXmlServiceConfig.getRequestHost(this.region, this.bucket, this.isSupportAccelerate);
    }

    public String getRequestURL() {
        return this.requestURL;
    }

    public STSCredentialScope[] getSTSCredentialScope(CosXmlServiceConfig cosXmlServiceConfig) {
        return new STSCredentialScope("name/cos:" + getClass().getSimpleName().replace("Request", ""), cosXmlServiceConfig.getBucket(this.bucket), cosXmlServiceConfig.getRegion(), getPath(cosXmlServiceConfig)).toArray();
    }

    public QCloudSignSourceProvider getSignSourceProvider() {
        if (this.signSourceProvider == null) {
            this.signSourceProvider = new COSXmlSignSourceProvider();
        }
        return this.signSourceProvider;
    }

    public int getWeight() {
        OnRequestWeightListener onRequestWeightListener = this.onRequestWeightListener;
        if (onRequestWeightListener != null) {
            return onRequestWeightListener.onWeight();
        }
        return 0;
    }

    public boolean headersHasUnsafeNonAscii() {
        return false;
    }

    public boolean isNeedMD5() {
        return this.isNeedMD5;
    }

    public boolean isSignInUrl() {
        return this.signInUrl;
    }

    public void isSupportAccelerate(boolean z) {
        this.isSupportAccelerate = z;
    }

    public boolean isSupportAccelerate() {
        return this.isSupportAccelerate;
    }

    public void setNeedMD5(boolean z) {
        this.isNeedMD5 = z;
    }

    public void setOnRequestWeightListener(OnRequestWeightListener onRequestWeightListener) {
        this.onRequestWeightListener = onRequestWeightListener;
    }

    public void setQueryEncodedString(String str) {
        this.queryParameterEncodedString = str;
    }

    public void setQueryParameters(Map<String, String> map) {
        this.queryParameters = map;
    }

    public void setRegion(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.region = str;
    }

    @Deprecated
    public void setRequestHeaders(String str, String str2) throws CosXmlClientException {
        if (str == null || str2 == null) {
            return;
        }
        addHeader(str, URLEncodeUtils.cosPathEncode(str2));
    }

    public void setRequestHeaders(String str, String str2, boolean z) throws CosXmlClientException {
        if (str == null || str2 == null) {
            return;
        }
        String str3 = str2;
        if (z) {
            str3 = URLEncodeUtils.cosPathEncode(str2);
        }
        addHeader(str, str3);
    }

    public void setRequestHeaders(Map<String, List<String>> map) {
        if (map != null) {
            this.requestHeaders.putAll(map);
        }
    }

    public void setRequestURL(String str) {
        this.requestURL = str;
    }

    @Deprecated
    public void setSign(long j) {
    }

    @Deprecated
    public void setSign(long j, long j2) {
    }

    @Deprecated
    public void setSign(long j, long j2, Set<String> set, Set<String> set2) {
        setSignParamsAndHeaders(set, set2);
    }

    @Deprecated
    public void setSign(long j, Set<String> set, Set<String> set2) {
        setSignParamsAndHeaders(set, set2);
    }

    public void setSign(String str) {
        addHeader("Authorization", str);
    }

    public void setSignInUrl(boolean z) {
        this.signInUrl = z;
    }

    public void setSignKeyTime(int i) {
        long deviceTimeWithOffset = HttpConfiguration.getDeviceTimeWithOffset();
        this.keyTime = deviceTimeWithOffset + ";" + (i + deviceTimeWithOffset);
    }

    public void setSignParamsAndHeaders(Set<String> set, Set<String> set2) {
        COSXmlSignSourceProvider cOSXmlSignSourceProvider = new COSXmlSignSourceProvider();
        cOSXmlSignSourceProvider.parameters(set);
        cOSXmlSignSourceProvider.headers(set2);
        this.signSourceProvider = cOSXmlSignSourceProvider;
    }

    public void setSignSourceProvider(QCloudSignSourceProvider qCloudSignSourceProvider) {
        this.signSourceProvider = qCloudSignSourceProvider;
    }

    public void setTask(HttpTask httpTask) {
        this.httpTask = httpTask;
        httpTask.addStateListener(this.qCloudTaskStateListener);
        httpTask.attachMetric(this.metrics);
    }

    public void setTaskStateListener(QCloudTaskStateListener qCloudTaskStateListener) {
        this.qCloudTaskStateListener = qCloudTaskStateListener;
    }
}
