package com.tencent.cos.xml;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.BasePutObjectRequest;
import com.tencent.cos.xml.model.object.BasePutObjectResult;
import com.tencent.cos.xml.model.object.GetObjectBytesRequest;
import com.tencent.cos.xml.model.object.GetObjectBytesResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.model.object.UploadRequest;
import com.tencent.cos.xml.transfer.ResponseBytesConverter;
import com.tencent.cos.xml.transfer.ResponseFileBodySerializer;
import com.tencent.cos.xml.transfer.ResponseXmlS3BodySerializer;
import com.tencent.cos.xml.utils.StringUtils;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudLifecycleCredentials;
import com.tencent.qcloud.core.auth.QCloudSelfSigner;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.auth.SignerFactory;
import com.tencent.qcloud.core.auth.StaticCredentialProvider;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudResultListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.http.NetworkClient;
import com.tencent.qcloud.core.http.OkHttpClientImpl;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.http.QCloudHttpRequest;
import com.tencent.qcloud.core.http.QCloudHttpRetryHandler;
import com.tencent.qcloud.core.http.ResponseBodyConverter;
import com.tencent.qcloud.core.logger.AndroidLogcatAdapter;
import com.tencent.qcloud.core.logger.FileLogAdapter;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.QCloudTask;
import com.tencent.qcloud.core.task.RetryStrategy;
import com.tencent.qcloud.core.task.TaskExecutors;
import com.tencent.qcloud.core.util.ContextHolder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CosXmlBaseService.class */
public class CosXmlBaseService implements BaseCosXml {
    private static final String TAG = "CosXmlBaseService";
    public static String appCachePath;
    protected volatile QCloudHttpClient client;
    protected CosXmlServiceConfig config;
    protected QCloudCredentialProvider credentialProvider;
    protected String requestDomain;
    protected QCloudSelfSigner selfSigner;
    protected String signerType;
    protected String tag;

    public CosXmlBaseService(Context context, CosXmlServiceConfig cosXmlServiceConfig) {
        this.tag = "CosXml";
        this.signerType = "CosXmlSigner";
        if (cosXmlServiceConfig.isDebuggable()) {
            FileLogAdapter fileLogAdapter = FileLogAdapter.getInstance(context, "QLog");
            LogServerProxy.init(context, fileLogAdapter);
            QCloudLogger.addAdapter(fileLogAdapter);
        }
        if (cosXmlServiceConfig.isDebuggable()) {
            QCloudLogger.addAdapter(new AndroidLogcatAdapter());
        }
        BeaconService.init(context.getApplicationContext(), cosXmlServiceConfig);
        appCachePath = context.getApplicationContext().getFilesDir().getPath();
        setNetworkClient(cosXmlServiceConfig);
        ContextHolder.setContext(context);
    }

    public CosXmlBaseService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudCredentialProvider qCloudCredentialProvider) {
        this(context, cosXmlServiceConfig);
        this.credentialProvider = qCloudCredentialProvider;
    }

    public CosXmlBaseService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudSelfSigner qCloudSelfSigner) {
        this(context, cosXmlServiceConfig);
        this.selfSigner = qCloudSelfSigner;
    }

    public CosXmlBaseService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudSigner qCloudSigner) {
        this(context, cosXmlServiceConfig);
        this.credentialProvider = new StaticCredentialProvider(null);
        this.signerType = "UserCosXmlSigner";
        SignerFactory.registerSigner("UserCosXmlSigner", qCloudSigner);
    }

    private void init(QCloudHttpClient.Builder builder, CosXmlServiceConfig cosXmlServiceConfig) {
        builder.setConnectionTimeout(cosXmlServiceConfig.getConnectionTimeout()).setSocketTimeout(cosXmlServiceConfig.getSocketTimeout());
        RetryStrategy retryStrategy = cosXmlServiceConfig.getRetryStrategy();
        if (retryStrategy != null) {
            builder.setRetryStrategy(retryStrategy);
        }
        QCloudHttpRetryHandler qCloudHttpRetryHandler = cosXmlServiceConfig.getQCloudHttpRetryHandler();
        if (qCloudHttpRetryHandler != null) {
            builder.setQCloudHttpRetryHandler(qCloudHttpRetryHandler);
        }
        builder.enableDebugLog(cosXmlServiceConfig.isDebuggable());
        if (cosXmlServiceConfig.isEnableQuic()) {
            try {
                builder.setNetworkClient((NetworkClient) Class.forName("com.tencent.qcloud.quic.QuicClientImpl").newInstance());
            } catch (Exception e) {
                IllegalStateException illegalStateException = new IllegalStateException(e.getMessage(), e);
                BeaconService.getInstance().reportError(TAG, illegalStateException);
                throw illegalStateException;
            }
        } else {
            builder.setNetworkClient(new OkHttpClientImpl());
        }
        builder.dnsCache(cosXmlServiceConfig.isDnsCache());
        builder.addPrefetchHost(cosXmlServiceConfig.getEndpointSuffix());
    }

    public void addCustomerDNS(String str, String[] strArr) throws CosXmlClientException {
        try {
            this.client.addDnsRecord(str, strArr);
        } catch (UnknownHostException e) {
            throw new CosXmlClientException(ClientErrorCode.POOR_NETWORK.getCode(), e);
        }
    }

    @Deprecated
    public void addVerifiedHost(String str) {
        this.client.addVerifiedHost(str);
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public BasePutObjectResult basePutObject(BasePutObjectRequest basePutObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        BasePutObjectResult basePutObjectResult = new BasePutObjectResult();
        basePutObjectResult.accessUrl = getAccessUrl(basePutObjectRequest);
        return (BasePutObjectResult) execute(basePutObjectRequest, basePutObjectResult);
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public void basePutObjectAsync(BasePutObjectRequest basePutObjectRequest, CosXmlResultListener cosXmlResultListener) {
        BasePutObjectResult basePutObjectResult = new BasePutObjectResult();
        basePutObjectResult.accessUrl = getAccessUrl(basePutObjectRequest);
        schedule(basePutObjectRequest, basePutObjectResult, cosXmlResultListener);
    }

    protected <T1 extends CosXmlRequest, T2 extends CosXmlResult> QCloudHttpRequest buildHttpRequest(T1 t1, T2 t2) throws CosXmlClientException {
        QCloudHttpRequest.Builder<T2> tag = new QCloudHttpRequest.Builder().method(t1.getMethod()).userAgent(this.config.getUserAgent()).tag((Object) this.tag);
        tag.addNoSignHeaderKeys(this.config.getNoSignHeaders());
        tag.addNoSignHeaderKeys(t1.getNoSignHeaders());
        tag.addNoSignParamKeys(t1.getNoSignParams());
        String requestURL = t1.getRequestURL();
        String requestHost = getRequestHost(t1);
        if (requestURL != null) {
            try {
                tag.url(new URL(requestURL));
            } catch (MalformedURLException e) {
                throw new CosXmlClientException(ClientErrorCode.BAD_REQUEST.getCode(), e);
            }
        } else {
            t1.checkParameters();
            tag.scheme(this.config.getProtocol()).host(requestHost).path(t1.getPath(this.config));
            if (this.config.getPort() != -1) {
                tag.port(this.config.getPort());
            }
            tag.query(t1.getQueryString());
            if (t1.getQueryEncodedString() != null) {
                tag.encodedQuery(t1.getQueryEncodedString());
            }
        }
        setCopySource(t1);
        HashSet<String> hashSet = new HashSet();
        hashSet.addAll(this.config.getCommonHeaders().keySet());
        hashSet.addAll(t1.getRequestHeaders().keySet());
        HashMap hashMap = new HashMap();
        for (String str : hashSet) {
            List<String> list = t1.getRequestHeaders().get(str);
            List<String> list2 = list;
            if (list == null) {
                list2 = this.config.getCommonHeaders().get(str);
            }
            if (list2 != null) {
                hashMap.put(str, list2);
            }
        }
        if (!hashMap.containsKey("Host")) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(requestHost);
            hashMap.put("Host", linkedList);
        }
        if (t1.headersHasUnsafeNonAscii()) {
            tag.addHeadersUnsafeNonAscii(hashMap);
        } else {
            tag.addHeaders(hashMap);
        }
        if (t1.isNeedMD5()) {
            tag.contentMD5();
        }
        tag.setKeyTime(t1.getKeyTime());
        if (this.credentialProvider == null) {
            tag.signer(null, null);
        } else {
            tag.signer(this.signerType, t1.getSignSourceProvider());
        }
        QCloudSelfSigner qCloudSelfSigner = this.selfSigner;
        if (qCloudSelfSigner != null) {
            tag.selfSigner(qCloudSelfSigner);
        }
        tag.credentialScope(t1.getSTSCredentialScope(this.config));
        if (t1.getRequestBody() != null) {
            tag.body(t1.getRequestBody());
        }
        if (t1 instanceof GetObjectRequest) {
            GetObjectRequest getObjectRequest = (GetObjectRequest) t1;
            if (!TextUtils.isEmpty(getObjectRequest.getDownloadPath())) {
                tag.converter((ResponseBodyConverter<T2>) new ResponseFileBodySerializer((GetObjectResult) t2, getObjectRequest.getDownloadPath(), getObjectRequest.getFileOffset()));
            } else if (getObjectRequest.getFileContentUri() != null) {
                tag.converter((ResponseBodyConverter<T2>) new ResponseFileBodySerializer((GetObjectResult) t2, getObjectRequest.getFileContentUri(), ContextHolder.getAppContext().getContentResolver(), getObjectRequest.getFileOffset()));
            }
        } else if (t1 instanceof GetObjectBytesRequest) {
            tag.converter((ResponseBodyConverter<T2>) new ResponseBytesConverter((GetObjectBytesResult) t2));
        } else if (!buildHttpRequestBodyConverter(t1, t2, tag)) {
            tag.converter((ResponseBodyConverter<T2>) new ResponseXmlS3BodySerializer(t2));
        }
        tag.signInUrl(t1.isSignInUrl() || this.config.isSignInUrl());
        return tag.build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> boolean buildHttpRequestBodyConverter(T1 t1, T2 t2, QCloudHttpRequest.Builder<T2> builder) {
        return false;
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public void cancel(CosXmlRequest cosXmlRequest) {
        if (cosXmlRequest == null || cosXmlRequest.getHttpTask() == null) {
            return;
        }
        cosXmlRequest.getHttpTask().cancel();
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public void cancelAll() {
        for (HttpTask httpTask : this.client.getTasksByTag(this.tag)) {
            httpTask.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> T2 execute(T1 t1, T2 t2) throws CosXmlClientException, CosXmlServiceException {
        try {
            if (t1.getMetrics() == null) {
                t1.attachMetrics(new HttpTaskMetrics());
            }
            HttpTask resolveRequest = this.client.resolveRequest(buildHttpRequest(t1, t2), this.credentialProvider);
            resolveRequest.setTransferThreadControl(this.config.isTransferThreadControl());
            t1.setTask(resolveRequest);
            setProgressListener(t1, resolveRequest, false);
            HttpResult httpResult = (HttpResult) resolveRequest.executeNow();
            BeaconService.getInstance().reportRequestSuccess(t1);
            if (httpResult != null) {
                return (T2) httpResult.content();
            }
            return null;
        } catch (QCloudClientException e) {
            throw BeaconService.getInstance().reportRequestClientException(t1, e);
        } catch (QCloudServiceException e2) {
            throw BeaconService.getInstance().reportRequestServiceException(t1, e2);
        }
    }

    public String getAccessUrl(CosXmlRequest cosXmlRequest) {
        String str;
        String requestURL = cosXmlRequest.getRequestURL();
        if (requestURL != null) {
            int indexOf = requestURL.indexOf("?");
            String str2 = requestURL;
            if (indexOf > 0) {
                str2 = requestURL.substring(0, indexOf);
            }
            return str2;
        }
        String str3 = null;
        try {
            str3 = getRequestHost(cosXmlRequest);
        } catch (CosXmlClientException e) {
            BeaconService.getInstance().reportError(TAG, e);
            e.printStackTrace();
        }
        try {
            str = URLEncodeUtils.cosPathEncode(cosXmlRequest.getPath(this.config));
        } catch (CosXmlClientException e2) {
            BeaconService.getInstance().reportError(TAG, e2);
            e2.printStackTrace();
            str = "/";
        }
        return this.config.getProtocol() + "://" + str3 + str;
    }

    @Deprecated
    public String getAppid() {
        return this.config.getAppid();
    }

    public CosXmlServiceConfig getConfig() {
        return this.config;
    }

    public QCloudCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public File[] getLogFiles(int i) {
        FileLogAdapter fileLogAdapter;
        LogServerProxy logServerProxy = LogServerProxy.getInstance();
        if (logServerProxy == null || (fileLogAdapter = logServerProxy.getFileLogAdapter()) == null) {
            return null;
        }
        return fileLogAdapter.getLogFilesDesc(i);
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public GetObjectResult getObject(GetObjectRequest getObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectResult) execute(getObjectRequest, new GetObjectResult());
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public byte[] getObject(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        GetObjectBytesResult getObjectBytesResult = (GetObjectBytesResult) execute(new GetObjectBytesRequest(str, str2), new GetObjectBytesResult());
        return getObjectBytesResult != null ? getObjectBytesResult.data : new byte[0];
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public void getObjectAsync(GetObjectRequest getObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getObjectRequest, new GetObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public String getObjectUrl(String str, String str2, String str3) {
        BasePutObjectRequest basePutObjectRequest = new BasePutObjectRequest(str, str3, "");
        basePutObjectRequest.setRegion(str2);
        return getAccessUrl(basePutObjectRequest);
    }

    public String getPresignedURL(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        try {
            QCloudLifecycleCredentials qCloudLifecycleCredentials = (QCloudLifecycleCredentials) this.credentialProvider.getCredentials();
            QCloudSigner signer = SignerFactory.getSigner(this.signerType);
            QCloudHttpRequest buildHttpRequest = buildHttpRequest(cosXmlRequest, null);
            signer.sign(buildHttpRequest, qCloudLifecycleCredentials);
            String header = buildHttpRequest.header("Authorization");
            String header2 = buildHttpRequest.header(Headers.SECURITY_TOKEN);
            String str = header;
            if (!TextUtils.isEmpty(header2)) {
                str = header + "&x-cos-security-token=" + header2;
            }
            String accessUrl = getAccessUrl(cosXmlRequest);
            String flat = StringUtils.flat(cosXmlRequest.getQueryString());
            if (TextUtils.isEmpty(flat)) {
                return accessUrl + "?" + str;
            }
            return accessUrl + "?" + flat + ContainerUtils.FIELD_DELIMITER + str;
        } catch (QCloudClientException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_CREDENTIALS.getCode(), e);
        }
    }

    @Deprecated
    public String getRegion() {
        return this.config.getRegion();
    }

    @Deprecated
    public String getRegion(CosXmlRequest cosXmlRequest) {
        return cosXmlRequest.getRegion() == null ? this.config.getRegion() : cosXmlRequest.getRegion();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRequestHost(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        return !TextUtils.isEmpty(this.requestDomain) ? this.requestDomain : cosXmlRequest.getRequestHost(this.config);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getRequestHostHeader(CosXmlRequest cosXmlRequest) {
        return String.format(Locale.ENGLISH, "%s.cos.%s.myqcloud.com", this.config.getBucket(cosXmlRequest.getBucket()), !TextUtils.isEmpty(cosXmlRequest.getRegion()) ? cosXmlRequest.getRegion() : this.config.getRegion());
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public void release() {
        cancelAll();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> void schedule(final T1 t1, T2 t2, final CosXmlResultListener cosXmlResultListener) {
        Object obj = new QCloudResultListener<HttpResult<T2>>() { // from class: com.tencent.cos.xml.CosXmlBaseService.1
            @Override // com.tencent.qcloud.core.common.QCloudResultListener
            public void onFailure(QCloudClientException qCloudClientException, QCloudServiceException qCloudServiceException) {
                if (qCloudClientException != null) {
                    cosXmlResultListener.onFail(t1, BeaconService.getInstance().reportRequestClientException(t1, qCloudClientException), null);
                } else if (qCloudServiceException != null) {
                    cosXmlResultListener.onFail(t1, null, BeaconService.getInstance().reportRequestServiceException(t1, qCloudServiceException));
                }
            }

            public void onSuccess(HttpResult<T2> httpResult) {
                BeaconService.getInstance().reportRequestSuccess(t1);
                cosXmlResultListener.onSuccess(t1, (CosXmlResult) httpResult.content());
            }

            @Override // com.tencent.qcloud.core.common.QCloudResultListener
            public /* bridge */ /* synthetic */ void onSuccess(Object obj2) {
                onSuccess((HttpResult) ((HttpResult) obj2));
            }
        };
        try {
            if (t1.getMetrics() == null) {
                t1.attachMetrics(new HttpTaskMetrics());
            }
            HttpTask resolveRequest = this.client.resolveRequest(buildHttpRequest(t1, t2), this.credentialProvider);
            resolveRequest.setTransferThreadControl(this.config.isTransferThreadControl());
            t1.setTask(resolveRequest);
            setProgressListener(t1, resolveRequest, true);
            Executor executor = this.config.getExecutor();
            Executor observeExecutor = this.config.getObserveExecutor();
            if (observeExecutor != null) {
                resolveRequest.observeOn(observeExecutor);
            }
            resolveRequest.addResultListener(obj);
            if (executor != null) {
                resolveRequest.scheduleOn(executor);
            } else if (t1 instanceof UploadRequest) {
                resolveRequest.scheduleOn(TaskExecutors.UPLOAD_EXECUTOR, t1.getPriority());
            } else {
                resolveRequest.schedule();
            }
        } catch (QCloudClientException e) {
            cosXmlResultListener.onFail(t1, BeaconService.getInstance().reportRequestClientException(t1, e), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T1 extends CosXmlRequest> void setCopySource(T1 t1) throws CosXmlClientException {
    }

    public void setDomain(String str) {
        this.requestDomain = str;
    }

    public void setNetworkClient(CosXmlServiceConfig cosXmlServiceConfig) {
        QCloudHttpClient.Builder builder = new QCloudHttpClient.Builder();
        init(builder, cosXmlServiceConfig);
        this.client = builder.build();
        this.client.setNetworkClientType(builder);
        this.config = cosXmlServiceConfig;
        QCloudHttpClient qCloudHttpClient = this.client;
        qCloudHttpClient.addVerifiedHost("*." + cosXmlServiceConfig.getEndpointSuffix());
        QCloudHttpClient qCloudHttpClient2 = this.client;
        qCloudHttpClient2.addVerifiedHost("*." + cosXmlServiceConfig.getEndpointSuffix(cosXmlServiceConfig.getRegion(), true));
        this.client.setDebuggable(cosXmlServiceConfig.isDebuggable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> void setProgressListener(final T1 t1, HttpTask<T2> httpTask, boolean z) {
        if (t1 instanceof BasePutObjectRequest) {
            httpTask.addProgressListener(((BasePutObjectRequest) t1).getProgressListener());
        } else if (!(t1 instanceof UploadPartRequest)) {
            if (t1 instanceof GetObjectRequest) {
                httpTask.addProgressListener(((GetObjectRequest) t1).getProgressListener());
            }
        } else {
            httpTask.addProgressListener(((UploadPartRequest) t1).getProgressListener());
            if (z) {
                httpTask.setOnRequestWeightListener(new QCloudTask.OnRequestWeightListener() { // from class: com.tencent.cos.xml.CosXmlBaseService.2
                    @Override // com.tencent.qcloud.core.task.QCloudTask.OnRequestWeightListener
                    public int onWeight() {
                        return t1.getWeight();
                    }
                });
            }
        }
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) throws CosXmlClientException, CosXmlServiceException {
        return (UploadPartResult) execute(uploadPartRequest, new UploadPartResult());
    }

    @Override // com.tencent.cos.xml.BaseCosXml
    public void uploadPartAsync(UploadPartRequest uploadPartRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(uploadPartRequest, new UploadPartResult(), cosXmlResultListener);
    }
}
