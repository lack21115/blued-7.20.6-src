package com.tencent.cos.xml.transfer;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.model.tag.ListParts;
import com.tencent.cos.xml.model.tag.UrlUploadPolicy;
import com.tencent.cos.xml.model.tag.pic.PicUploadResult;
import com.tencent.cos.xml.utils.CloseUtil;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.qcloud.core.common.QCloudTaskStateListener;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.util.ContextHolder;
import com.tencent.qcloud.core.util.QCloudUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLUploadTask.class */
public final class COSXMLUploadTask extends COSXMLTask {
    private static Executor executor = Executors.newSingleThreadExecutor();
    private AtomicLong ALREADY_SEND_DATA_LEN;
    private Object SYNC_UPLOAD_PART;
    private final String TAG;
    private AtomicInteger UPLOAD_PART_COUNT;
    private byte[] bytes;
    private CompleteMultiUploadRequest completeMultiUploadRequest;
    private long fileLength;
    boolean forceSimpleUpload;
    private HeadObjectRequest headObjectRequest;
    HttpTaskMetrics httpTaskMetrics;
    private InitMultipartUploadRequest initMultipartUploadRequest;
    private InputStream inputStream;
    private boolean isSliceUpload;
    private ListPartsRequest listPartsRequest;
    protected long multiUploadSizeDivision;
    private MultiUploadsStateListener multiUploadsStateListenerHandler;
    private Map<Integer, SlicePartStruct> partStructMap;
    boolean priorityLow;
    private PutObjectRequest putObjectRequest;
    private AtomicBoolean sendingCompleteRequest;
    private long simpleAlreadySendDataLen;
    protected long sliceSize;
    String srcPath;
    private long startTime;
    private String uploadId;
    private Map<UploadPartRequest, Long> uploadPartRequestLongMap;
    private Uri uri;
    private URL url;
    private UrlUploadPolicy urlUploadPolicy;
    private WeightStrategy weightStrategy;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLUploadTask$COSXMLUploadTaskRequest.class */
    public static class COSXMLUploadTaskRequest extends PutObjectRequest {
        protected COSXMLUploadTaskRequest(String str, String str2, String str3, String str4, Map<String, List<String>> map, Map<String, String> map2) {
            super(str2, str3, str4);
            setRegion(str);
            setRequestHeaders(map);
            setQueryParameters(map2);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLUploadTask$COSXMLUploadTaskResult.class */
    public static class COSXMLUploadTaskResult extends CosXmlResult {
        public String eTag;
        public PicUploadResult picUploadResult;

        protected COSXMLUploadTaskResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLUploadTask$MultiUploadsStateListener.class */
    public interface MultiUploadsStateListener {
        void onCompleted(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult);

        void onFailed(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

        void onInit();

        void onListParts();

        void onUploadParts();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLUploadTask$SlicePartStruct.class */
    public static class SlicePartStruct {
        public String eTag;
        public boolean isAlreadyUpload;
        public long offset;
        public int partNumber;
        public long sliceSize;

        private SlicePartStruct() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLUploadTask$WeightStrategy.class */
    static class WeightStrategy {
        private final long DEFAULT_WEIGHT_HIGH_SIZE;
        private final long DEFAULT_WEIGHT_NORMAL_SIZE;
        private long highSize;
        private long normalSize;

        private WeightStrategy() {
            this.DEFAULT_WEIGHT_NORMAL_SIZE = 83886080L;
            this.DEFAULT_WEIGHT_HIGH_SIZE = 157286400L;
            this.normalSize = 83886080L;
            this.highSize = 157286400L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getWeight(long j) {
            if (j > this.highSize) {
                return 2;
            }
            return j > this.normalSize ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, PutObjectRequest putObjectRequest, String str) {
        this(cosXmlSimpleService, putObjectRequest.getRegion(), putObjectRequest.getBucket(), putObjectRequest.getPath(cosXmlSimpleService.getConfig()));
        this.uri = putObjectRequest.getUri();
        this.url = putObjectRequest.getUrl();
        this.urlUploadPolicy = putObjectRequest.getUrlUploadPolicy();
        this.srcPath = putObjectRequest.getSrcPath();
        this.bytes = putObjectRequest.getData();
        this.inputStream = putObjectRequest.getInputStream();
        this.queries = putObjectRequest.getQueryString();
        this.headers = putObjectRequest.getRequestHeaders();
        this.isNeedMd5 = putObjectRequest.isNeedMD5();
        this.uploadId = str;
        this.priorityLow = putObjectRequest.isPriorityLow();
    }

    private COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3) {
        this.TAG = "UploadTask";
        this.isSliceUpload = false;
        this.SYNC_UPLOAD_PART = new Object();
        this.startTime = 0L;
        this.simpleAlreadySendDataLen = 0L;
        this.priorityLow = false;
        this.sendingCompleteRequest = new AtomicBoolean(false);
        this.weightStrategy = new WeightStrategy();
        this.multiUploadsStateListenerHandler = new MultiUploadsStateListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.1
            @Override // com.tencent.cos.xml.transfer.COSXMLUploadTask.MultiUploadsStateListener
            public void onCompleted(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                COSXMLUploadTask.this.updateState(TransferState.COMPLETED, null, cosXmlResult, false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cos.xml.transfer.COSXMLUploadTask.MultiUploadsStateListener
            public void onFailed(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                CosXmlClientException cosXmlClientException2 = cosXmlClientException == null ? cosXmlServiceException : cosXmlClientException;
                COSXMLUploadTask.this.reportException(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                COSXMLUploadTask.this.updateState(TransferState.FAILED, cosXmlClientException2, null, false);
            }

            @Override // com.tencent.cos.xml.transfer.COSXMLUploadTask.MultiUploadsStateListener
            public void onInit() {
                COSXMLUploadTask cOSXMLUploadTask = COSXMLUploadTask.this;
                cOSXMLUploadTask.multiUploadPart(cOSXMLUploadTask.cosXmlService);
            }

            @Override // com.tencent.cos.xml.transfer.COSXMLUploadTask.MultiUploadsStateListener
            public void onListParts() {
                COSXMLUploadTask cOSXMLUploadTask = COSXMLUploadTask.this;
                cOSXMLUploadTask.multiUploadPart(cOSXMLUploadTask.cosXmlService);
            }

            @Override // com.tencent.cos.xml.transfer.COSXMLUploadTask.MultiUploadsStateListener
            public void onUploadParts() {
                COSXMLUploadTask cOSXMLUploadTask = COSXMLUploadTask.this;
                cOSXMLUploadTask.completeMultiUpload(cOSXMLUploadTask.cosXmlService);
            }
        };
        this.cosXmlService = cosXmlSimpleService;
        this.region = str;
        this.bucket = str2;
        this.cosPath = str3;
        this.httpTaskMetrics = new HttpTaskMetrics();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, Uri uri, String str4) {
        this(cosXmlSimpleService, str, str2, str3);
        this.uri = uri;
        this.uploadId = str4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, InputStream inputStream) {
        this(cosXmlSimpleService, str, str2, str3);
        this.inputStream = inputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, String str4, String str5) {
        this(cosXmlSimpleService, str, str2, str3);
        this.srcPath = str4;
        this.uploadId = str5;
    }

    COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, URL url, UrlUploadPolicy urlUploadPolicy, String str4) {
        this(cosXmlSimpleService, str, str2, str3);
        this.url = url;
        this.urlUploadPolicy = urlUploadPolicy;
        this.uploadId = str4;
    }

    COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, URL url, String str4) {
        this(cosXmlSimpleService, str, str2, str3);
        this.url = url;
        this.uploadId = str4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLUploadTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, byte[] bArr) {
        this(cosXmlSimpleService, str, str2, str3);
        this.bytes = bArr;
    }

    private void abortMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        if (this.uploadId == null) {
            return;
        }
        AbortMultiUploadRequest abortMultiUploadRequest = new AbortMultiUploadRequest(this.bucket, this.cosPath, this.uploadId);
        abortMultiUploadRequest.setRegion(this.region);
        if (this.onSignatureListener != null) {
            abortMultiUploadRequest.setSign(this.onSignatureListener.onGetSign(abortMultiUploadRequest));
        }
        getHttpMetrics(abortMultiUploadRequest, "AbortMultiUploadRequest");
        cosXmlSimpleService.abortMultiUploadAsync(abortMultiUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.13
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
            }
        });
    }

    private void clear() {
        Map<UploadPartRequest, Long> map = this.uploadPartRequestLongMap;
        if (map != null) {
            map.clear();
        }
        Map<Integer, SlicePartStruct> map2 = this.partStructMap;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        this.sendingCompleteRequest.set(true);
        CompleteMultiUploadRequest completeMultiUploadRequest = new CompleteMultiUploadRequest(this.bucket, this.cosPath, this.uploadId, null);
        this.completeMultiUploadRequest = completeMultiUploadRequest;
        completeMultiUploadRequest.setRegion(this.region);
        for (Map.Entry<Integer, SlicePartStruct> entry : this.partStructMap.entrySet()) {
            SlicePartStruct value = entry.getValue();
            this.completeMultiUploadRequest.setPartNumberAndETag(value.partNumber, value.eTag);
        }
        this.completeMultiUploadRequest.setNeedMD5(this.isNeedMd5);
        this.completeMultiUploadRequest.setRequestHeaders(getCustomCompleteHeaders(this.headers));
        if (this.onSignatureListener != null) {
            this.completeMultiUploadRequest.setSign(this.onSignatureListener.onGetSign(this.completeMultiUploadRequest));
        }
        getHttpMetrics(this.completeMultiUploadRequest, "CompleteMultiUploadRequest");
        cosXmlSimpleService.completeMultiUploadAsync(this.completeMultiUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.12
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(final CosXmlRequest cosXmlRequest, final CosXmlClientException cosXmlClientException, final CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest != COSXMLUploadTask.this.completeMultiUploadRequest) {
                    return;
                }
                if (cosXmlServiceException != null && "NoSuchUpload".equals(cosXmlServiceException.getErrorCode())) {
                    COSXMLUploadTask.executor.execute(new Runnable() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HeadObjectResult headObjectToCheckCRC64 = COSXMLUploadTask.this.headObjectToCheckCRC64();
                            if (headObjectToCheckCRC64 != null) {
                                COSXMLUploadTask.this.onTransferComplete(cosXmlRequest, headObjectToCheckCRC64);
                            } else {
                                COSXMLUploadTask.this.encounterError(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                            }
                            COSXMLUploadTask.this.sendingCompleteRequest.set(false);
                        }
                    });
                    return;
                }
                COSXMLUploadTask.this.encounterError(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                COSXMLUploadTask.this.sendingCompleteRequest.set(false);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest != COSXMLUploadTask.this.completeMultiUploadRequest) {
                    return;
                }
                COSXMLUploadTask.this.sendingCompleteRequest.set(false);
                COSXMLUploadTask.this.onTransferComplete(cosXmlRequest, cosXmlResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchProgressChange(long j, long j2) {
        if (this.cosXmlProgressListener != null) {
            this.cosXmlProgressListener.onProgress(j, j2);
        }
        if (this.internalProgressListener != null) {
            this.internalProgressListener.onProgress(j, j2);
        }
    }

    private String getCRCValue(HeadObjectResult headObjectResult) {
        List<String> list = headObjectResult.headers.get(Headers.COS_HASH_CRC64_ECMA);
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }

    private Map<String, List<String>> getCustomCompleteHeaders(Map<String, List<String>> map) {
        if (map == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(map);
        hashMap.remove("Content-Type");
        return hashMap;
    }

    private int getIndexOfParts(List<ListParts.Part> list) {
        if (Integer.valueOf(list.get(0).partNumber).intValue() != 1) {
            return -1;
        }
        int size = list.size();
        int i = 0;
        int i2 = 1;
        for (int i3 = 1; i3 < size; i3++) {
            ListParts.Part part = list.get(i3);
            if (Integer.valueOf(part.partNumber).intValue() != i2 + 1) {
                return i;
            }
            i2 = Integer.valueOf(part.partNumber).intValue();
            i = i3;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HeadObjectResult headObjectToCheckCRC64() {
        try {
            this.headObjectRequest = new HeadObjectRequest(this.bucket, this.cosPath);
            HeadObjectResult headObject = this.cosXmlService.headObject(this.headObjectRequest);
            long bigIntFromString = DigestUtils.getBigIntFromString(getCRCValue(headObject));
            InputStream openUploadFileStream = openUploadFileStream();
            long crc64 = DigestUtils.getCRC64(openUploadFileStream);
            openUploadFileStream.close();
            if (bigIntFromString == crc64) {
                return headObject;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        InitMultipartUploadRequest initMultipartUploadRequest = new InitMultipartUploadRequest(this.bucket, this.cosPath);
        this.initMultipartUploadRequest = initMultipartUploadRequest;
        initMultipartUploadRequest.setRegion(this.region);
        this.initMultipartUploadRequest.setRequestHeaders(this.headers);
        if (this.onSignatureListener != null) {
            this.initMultipartUploadRequest.setSign(this.onSignatureListener.onGetSign(this.initMultipartUploadRequest));
        }
        this.httpTaskMetrics.setDomainName(this.initMultipartUploadRequest.getRequestHost(cosXmlSimpleService.getConfig()));
        getHttpMetrics(this.initMultipartUploadRequest, "InitMultipartUploadRequest");
        cosXmlSimpleService.initMultipartUploadAsync(this.initMultipartUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.5
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLUploadTask.this.initMultipartUploadRequest && !COSXMLUploadTask.this.IS_EXIT.get()) {
                    COSXMLUploadTask.this.IS_EXIT.set(true);
                    COSXMLUploadTask.this.multiUploadsStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLUploadTask.this.initMultipartUploadRequest && !COSXMLUploadTask.this.IS_EXIT.get()) {
                    COSXMLUploadTask.this.onUpdateInProgress();
                    COSXMLUploadTask.this.uploadId = ((InitMultipartUploadResult) cosXmlResult).initMultipartUpload.uploadId;
                    COSXMLUploadTask.this.multiUploadsStateListenerHandler.onInit();
                }
            }
        });
    }

    private void initSlicePart(long j, long j2, int i) {
        int i2 = (int) (j2 / this.sliceSize);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                break;
            }
            SlicePartStruct slicePartStruct = new SlicePartStruct();
            slicePartStruct.isAlreadyUpload = false;
            slicePartStruct.partNumber = i + i4;
            slicePartStruct.offset = (i4 * this.sliceSize) + j;
            slicePartStruct.sliceSize = this.sliceSize;
            this.partStructMap.put(Integer.valueOf(slicePartStruct.partNumber), slicePartStruct);
            i3 = i4 + 1;
        }
        int i5 = i2;
        if (j2 % this.sliceSize != 0) {
            SlicePartStruct slicePartStruct2 = new SlicePartStruct();
            slicePartStruct2.isAlreadyUpload = false;
            slicePartStruct2.partNumber = i + i2;
            slicePartStruct2.offset = (i2 * this.sliceSize) + j;
            slicePartStruct2.sliceSize = (j + j2) - slicePartStruct2.offset;
            this.partStructMap.put(Integer.valueOf(slicePartStruct2.partNumber), slicePartStruct2);
            i5 = i2 + 1;
        }
        this.UPLOAD_PART_COUNT.set((i + i5) - 1);
        if (this.IS_EXIT.get()) {
        }
    }

    private boolean isFixSliceSize(List<ListParts.Part> list) {
        for (ListParts.Part part : list) {
            if (this.partStructMap.containsKey(Integer.valueOf(part.partNumber)) && this.partStructMap.get(Integer.valueOf(part.partNumber)).sliceSize != Long.valueOf(part.size).longValue()) {
                return false;
            }
        }
        return true;
    }

    private void listMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        ListPartsRequest listPartsRequest = new ListPartsRequest(this.bucket, this.cosPath, this.uploadId);
        this.listPartsRequest = listPartsRequest;
        listPartsRequest.setRegion(this.region);
        this.listPartsRequest.setRequestHeaders(this.headers);
        if (this.onSignatureListener != null) {
            this.listPartsRequest.setSign(this.onSignatureListener.onGetSign(this.listPartsRequest));
        }
        this.httpTaskMetrics.setDomainName(this.listPartsRequest.getRequestHost(cosXmlSimpleService.getConfig()));
        getHttpMetrics(this.listPartsRequest, "ListPartsRequest");
        this.listPartsRequest.setTaskStateListener(new QCloudTaskStateListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.6
            @Override // com.tencent.qcloud.core.common.QCloudTaskStateListener
            public void onStateChanged(String str, int i) {
                if (COSXMLUploadTask.this.IS_EXIT.get()) {
                    return;
                }
                COSXMLUploadTask.this.onUpdateInProgress();
            }
        });
        cosXmlSimpleService.listPartsAsync(this.listPartsRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.7
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(final CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLUploadTask.this.listPartsRequest && !COSXMLUploadTask.this.IS_EXIT.get()) {
                    if (cosXmlServiceException != null && "NoSuchUpload".equals(cosXmlServiceException.getErrorCode())) {
                        COSXMLUploadTask.executor.execute(new Runnable() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.7.2
                            @Override // java.lang.Runnable
                            public void run() {
                                HeadObjectResult headObjectToCheckCRC64 = COSXMLUploadTask.this.headObjectToCheckCRC64();
                                if (headObjectToCheckCRC64 != null) {
                                    COSXMLUploadTask.this.onTransferComplete(cosXmlRequest, headObjectToCheckCRC64);
                                } else if (COSXMLUploadTask.this.IS_EXIT.get()) {
                                } else {
                                    COSXMLUploadTask.this.reTrans();
                                }
                            }
                        });
                        return;
                    }
                    COSXMLUploadTask.this.IS_EXIT.set(true);
                    COSXMLUploadTask.this.multiUploadsStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, final CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLUploadTask.this.listPartsRequest && !COSXMLUploadTask.this.IS_EXIT.get()) {
                    if (COSXMLUploadTask.this.url == null) {
                        COSXMLUploadTask.executor.execute(new Runnable() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.7.1
                            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0046 -> B:40:0x0072). Please submit an issue!!! */
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z;
                                InputStream inputStream = null;
                                InputStream inputStream2 = null;
                                try {
                                    try {
                                        try {
                                            InputStream openUploadFileStream = COSXMLUploadTask.this.openUploadFileStream();
                                            inputStream = openUploadFileStream;
                                            boolean verifyUploadParts = COSXMLUploadTask.this.verifyUploadParts(((ListPartsResult) cosXmlResult).listParts, openUploadFileStream);
                                            z = verifyUploadParts;
                                            if (openUploadFileStream != null) {
                                                CloseUtil.closeQuietly(openUploadFileStream);
                                                z = verifyUploadParts;
                                            }
                                        } catch (Throwable th) {
                                            if (inputStream2 != null) {
                                                try {
                                                    CloseUtil.closeQuietly(inputStream2);
                                                } catch (CosXmlClientException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (CosXmlClientException e2) {
                                        e2.printStackTrace();
                                    }
                                } catch (IOException e3) {
                                    inputStream2 = inputStream;
                                    e3.printStackTrace();
                                    z = false;
                                    if (inputStream != null) {
                                        CloseUtil.closeQuietly(inputStream);
                                        z = false;
                                    }
                                }
                                if (!z) {
                                    COSXMLUploadTask.this.reTrans();
                                    return;
                                }
                                COSXMLUploadTask.this.updateSlicePart((ListPartsResult) cosXmlResult);
                                COSXMLUploadTask.this.multiUploadsStateListenerHandler.onListParts();
                            }
                        });
                        return;
                    }
                    COSXMLUploadTask.this.updateSlicePart((ListPartsResult) cosXmlResult);
                    COSXMLUploadTask.this.multiUploadsStateListenerHandler.onListParts();
                }
            }
        });
    }

    private void multiUpload(CosXmlSimpleService cosXmlSimpleService) {
        initSlicePart(0L, this.fileLength, 1);
        if (TextUtils.isEmpty(this.uploadId)) {
            initMultiUpload(cosXmlSimpleService);
        } else {
            listMultiUpload(cosXmlSimpleService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void multiUploadPart(CosXmlSimpleService cosXmlSimpleService) {
        boolean z = true;
        for (Map.Entry<Integer, SlicePartStruct> entry : this.partStructMap.entrySet()) {
            final SlicePartStruct value = entry.getValue();
            if (!value.isAlreadyUpload && !this.IS_EXIT.get()) {
                UploadPartRequest uploadPartRequest = this.srcPath != null ? new UploadPartRequest(this.bucket, this.cosPath, value.partNumber, this.srcPath, value.offset, value.sliceSize, this.uploadId) : null;
                if (this.uri != null) {
                    uploadPartRequest = new UploadPartRequest(this.bucket, this.cosPath, value.partNumber, this.uri, value.offset, value.sliceSize, this.uploadId);
                }
                if (this.url != null) {
                    uploadPartRequest = new UploadPartRequest(this.bucket, this.cosPath, value.partNumber, this.url, value.offset, value.sliceSize, this.uploadId);
                }
                if (this.priorityLow) {
                    uploadPartRequest.setPriorityLow();
                }
                uploadPartRequest.setRegion(this.region);
                if (this.url == null) {
                    uploadPartRequest.setNeedMD5(this.isNeedMd5);
                } else {
                    uploadPartRequest.setNeedMD5(false);
                }
                uploadPartRequest.setRequestHeaders(this.headers);
                uploadPartRequest.setOnRequestWeightListener(new CosXmlRequest.OnRequestWeightListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.9
                    @Override // com.tencent.cos.xml.model.CosXmlRequest.OnRequestWeightListener
                    public int onWeight() {
                        return COSXMLUploadTask.this.weightStrategy.getWeight(COSXMLUploadTask.this.ALREADY_SEND_DATA_LEN.get());
                    }
                });
                if (this.onSignatureListener != null) {
                    uploadPartRequest.setSign(this.onSignatureListener.onGetSign(uploadPartRequest));
                }
                getHttpMetrics(uploadPartRequest, "UploadPartRequest");
                this.uploadPartRequestLongMap.put(uploadPartRequest, 0L);
                final UploadPartRequest uploadPartRequest2 = uploadPartRequest;
                uploadPartRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.10
                    @Override // com.tencent.qcloud.core.common.QCloudProgressListener
                    public void onProgress(long j, long j2) {
                        if (COSXMLUploadTask.this.IS_EXIT.get()) {
                            return;
                        }
                        try {
                            long addAndGet = COSXMLUploadTask.this.ALREADY_SEND_DATA_LEN.addAndGet(j - ((Long) COSXMLUploadTask.this.uploadPartRequestLongMap.get(uploadPartRequest2)).longValue());
                            COSXMLUploadTask.this.uploadPartRequestLongMap.put(uploadPartRequest2, Long.valueOf(j));
                            COSXMLUploadTask.this.dispatchProgressChange(addAndGet, COSXMLUploadTask.this.fileLength);
                        } catch (Exception e) {
                        }
                    }
                });
                final UploadPartRequest uploadPartRequest3 = uploadPartRequest;
                cosXmlSimpleService.uploadPartAsync(uploadPartRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.11
                    @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                    public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                        if (cosXmlRequest == uploadPartRequest3 && !COSXMLUploadTask.this.IS_EXIT.get()) {
                            COSXMLUploadTask.this.IS_EXIT.set(true);
                            COSXMLUploadTask.this.multiUploadsStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                        }
                    }

                    @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                    public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                        if (cosXmlRequest != uploadPartRequest3) {
                            return;
                        }
                        COSXMLUploadTask.this.httpTaskMetrics.merge(cosXmlRequest.getMetrics());
                        if (COSXMLUploadTask.this.IS_EXIT.get()) {
                            return;
                        }
                        value.eTag = ((UploadPartResult) cosXmlResult).eTag;
                        value.isAlreadyUpload = true;
                        synchronized (COSXMLUploadTask.this.SYNC_UPLOAD_PART) {
                            COSXMLUploadTask.this.UPLOAD_PART_COUNT.decrementAndGet();
                            if (COSXMLUploadTask.this.UPLOAD_PART_COUNT.get() == 0) {
                                COSXMLUploadTask.this.multiUploadsStateListenerHandler.onUploadParts();
                            }
                        }
                    }
                });
                z = false;
            }
        }
        if (!z || this.IS_EXIT.get()) {
            return;
        }
        long j = this.fileLength;
        dispatchProgressChange(j, j);
        this.multiUploadsStateListenerHandler.onUploadParts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTransferComplete(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
        cosXmlRequest.attachMetrics(this.httpTaskMetrics);
        if (this.IS_EXIT.get()) {
            return;
        }
        this.IS_EXIT.set(true);
        BeaconService.getInstance().reportUploadTaskSuccess(cosXmlRequest);
        this.multiUploadsStateListenerHandler.onCompleted(cosXmlRequest, cosXmlResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateInProgress() {
        updateState(TransferState.IN_PROGRESS, null, null, false);
        if (this.waitTimeoutTimer != null) {
            this.waitTimeoutTimer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream openUploadFileStream() throws IOException {
        if (this.srcPath != null) {
            return new FileInputStream(this.srcPath);
        }
        if (this.uri != null) {
            if (ContextHolder.getAppContext() != null) {
                return ContextHolder.getAppContext().getContentResolver().openInputStream(this.uri);
            }
            throw new IOException("Open src file failed, Application context is null!");
        }
        throw new IOException("There is no src file path or uri!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reTrans() {
        this.uploadId = null;
        startUpload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportException(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        CosXmlRequest cosXmlRequest2 = cosXmlRequest;
        if (cosXmlRequest == null) {
            cosXmlRequest2 = buildCOSXMLTaskRequest();
        }
        if (cosXmlClientException != null) {
            BeaconService.getInstance().reportUploadTaskClientException(cosXmlRequest2, cosXmlClientException);
        }
        if (cosXmlServiceException != null) {
            BeaconService.getInstance().reportUploadTaskServiceException(cosXmlRequest2, cosXmlServiceException);
        }
    }

    private void simpleUpload(CosXmlSimpleService cosXmlSimpleService) {
        if (this.bytes != null) {
            this.putObjectRequest = new PutObjectRequest(this.bucket, this.cosPath, this.bytes);
        } else if (this.inputStream != null) {
            this.putObjectRequest = new PutObjectRequest(this.bucket, this.cosPath, this.inputStream);
        } else if (this.uri != null) {
            this.putObjectRequest = new PutObjectRequest(this.bucket, this.cosPath, this.uri);
        } else if (this.url != null) {
            this.putObjectRequest = new PutObjectRequest(this.bucket, this.cosPath, this.url);
        } else {
            this.putObjectRequest = new PutObjectRequest(this.bucket, this.cosPath, this.srcPath);
        }
        this.putObjectRequest.setRegion(this.region);
        if (this.url != null) {
            this.putObjectRequest.setNeedMD5(false);
        } else {
            this.putObjectRequest.setNeedMD5(this.isNeedMd5);
        }
        this.putObjectRequest.setRequestHeaders(this.headers);
        if (this.onSignatureListener != null) {
            this.putObjectRequest.setSign(this.onSignatureListener.onGetSign(this.putObjectRequest));
        }
        getHttpMetrics(this.putObjectRequest, "PutObjectRequest");
        this.putObjectRequest.setTaskStateListener(new QCloudTaskStateListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.2
            @Override // com.tencent.qcloud.core.common.QCloudTaskStateListener
            public void onStateChanged(String str, int i) {
                if (COSXMLUploadTask.this.IS_EXIT.get()) {
                    return;
                }
                if (i == 2 || i == 3) {
                    COSXMLUploadTask.this.onUpdateInProgress();
                }
            }
        });
        this.putObjectRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.3
            @Override // com.tencent.qcloud.core.common.QCloudProgressListener
            public void onProgress(long j, long j2) {
                COSXMLUploadTask.this.simpleAlreadySendDataLen = j;
                COSXMLUploadTask.this.dispatchProgressChange(j, j2);
            }
        });
        if (this.priorityLow) {
            this.putObjectRequest.setPriorityLow();
        }
        cosXmlSimpleService.putObjectAsync(this.putObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.4
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLUploadTask.this.putObjectRequest && !COSXMLUploadTask.this.IS_EXIT.get()) {
                    COSXMLUploadTask.this.IS_EXIT.set(true);
                    COSXMLUploadTask.this.multiUploadsStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLUploadTask.this.putObjectRequest && !COSXMLUploadTask.this.IS_EXIT.get()) {
                    COSXMLUploadTask.this.IS_EXIT.set(true);
                    BeaconService.getInstance().reportUploadTaskSuccess(cosXmlRequest);
                    COSXMLUploadTask.this.updateState(TransferState.COMPLETED, null, cosXmlResult, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSlicePart(ListPartsResult listPartsResult) {
        List<ListParts.Part> list;
        if (listPartsResult == null || listPartsResult.listParts == null || (list = listPartsResult.listParts.parts) == null || list.size() <= 0) {
            return;
        }
        if (isFixSliceSize(list)) {
            for (ListParts.Part part : list) {
                if (this.partStructMap.containsKey(Integer.valueOf(part.partNumber))) {
                    SlicePartStruct slicePartStruct = this.partStructMap.get(Integer.valueOf(part.partNumber));
                    slicePartStruct.isAlreadyUpload = true;
                    slicePartStruct.eTag = part.eTag;
                    this.UPLOAD_PART_COUNT.decrementAndGet();
                    this.ALREADY_SEND_DATA_LEN.addAndGet(Long.parseLong(part.size));
                }
            }
            return;
        }
        Collections.sort(list, new Comparator<ListParts.Part>() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.14
            @Override // java.util.Comparator
            public int compare(ListParts.Part part2, ListParts.Part part3) {
                int intValue = Integer.valueOf(part2.partNumber).intValue();
                int intValue2 = Integer.valueOf(part3.partNumber).intValue();
                if (intValue > intValue2) {
                    return 1;
                }
                return intValue < intValue2 ? -1 : 0;
            }
        });
        int indexOfParts = getIndexOfParts(list);
        if (indexOfParts < 0) {
            return;
        }
        this.partStructMap.clear();
        long j = 0;
        int i = 0;
        while (i <= indexOfParts) {
            ListParts.Part part2 = list.get(i);
            SlicePartStruct slicePartStruct2 = new SlicePartStruct();
            i++;
            slicePartStruct2.partNumber = i;
            slicePartStruct2.offset = j;
            slicePartStruct2.sliceSize = Long.parseLong(part2.size);
            slicePartStruct2.eTag = part2.eTag;
            slicePartStruct2.isAlreadyUpload = true;
            j += slicePartStruct2.sliceSize;
            this.partStructMap.put(Integer.valueOf(i), slicePartStruct2);
        }
        this.ALREADY_SEND_DATA_LEN.addAndGet(j);
        initSlicePart(j, this.fileLength - j, indexOfParts + 2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 > indexOfParts) {
                return;
            }
            this.UPLOAD_PART_COUNT.decrementAndGet();
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean verifyUploadParts(ListParts listParts, InputStream inputStream) throws IOException {
        List<ListParts.Part> list = listParts.parts;
        Collections.sort(list, new Comparator<ListParts.Part>() { // from class: com.tencent.cos.xml.transfer.COSXMLUploadTask.8
            @Override // java.util.Comparator
            public int compare(ListParts.Part part, ListParts.Part part2) {
                int intValue = Integer.valueOf(part.partNumber).intValue();
                int intValue2 = Integer.valueOf(part2.partNumber).intValue();
                if (intValue > intValue2) {
                    return 1;
                }
                return intValue < intValue2 ? -1 : 0;
            }
        });
        boolean isFixSliceSize = isFixSliceSize(list);
        Iterator<ListParts.Part> it = list.iterator();
        boolean z = true;
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return true;
            }
            ListParts.Part next = it.next();
            int parseInt = Integer.parseInt(next.partNumber);
            z = z && i2 + 1 == parseInt;
            if (!isFixSliceSize && !z) {
                return true;
            }
            String cOSMd5 = DigestUtils.getCOSMd5(inputStream, ((parseInt - i2) - 1) * this.sliceSize, Long.parseLong(next.size));
            if (!next.eTag.equals(cOSMd5)) {
                QCloudLogger.i("UploadTask", "verify upload parts failed, part number " + next.partNumber + ", etag " + next.eTag + ", but local md5 is " + cOSMd5, new Object[0]);
                return false;
            }
            i = parseInt;
        }
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected CosXmlRequest buildCOSXMLTaskRequest() {
        return new COSXMLUploadTaskRequest(this.region, this.bucket, this.cosPath, this.srcPath, this.headers, this.queries);
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected CosXmlResult buildCOSXMLTaskResult(CosXmlResult cosXmlResult) {
        COSXMLUploadTaskResult cOSXMLUploadTaskResult = new COSXMLUploadTaskResult();
        if (cosXmlResult != null && (cosXmlResult instanceof PutObjectResult)) {
            PutObjectResult putObjectResult = (PutObjectResult) cosXmlResult;
            cOSXMLUploadTaskResult.httpCode = putObjectResult.httpCode;
            cOSXMLUploadTaskResult.httpMessage = putObjectResult.httpMessage;
            cOSXMLUploadTaskResult.headers = putObjectResult.headers;
            cOSXMLUploadTaskResult.eTag = putObjectResult.eTag;
            cOSXMLUploadTaskResult.accessUrl = putObjectResult.accessUrl;
            cOSXMLUploadTaskResult.picUploadResult = putObjectResult.picUploadResult();
            return cOSXMLUploadTaskResult;
        }
        if (cosXmlResult != null && (cosXmlResult instanceof CompleteMultiUploadResult)) {
            CompleteMultiUploadResult completeMultiUploadResult = (CompleteMultiUploadResult) cosXmlResult;
            cOSXMLUploadTaskResult.httpCode = completeMultiUploadResult.httpCode;
            cOSXMLUploadTaskResult.httpMessage = completeMultiUploadResult.httpMessage;
            cOSXMLUploadTaskResult.headers = completeMultiUploadResult.headers;
            cOSXMLUploadTaskResult.eTag = completeMultiUploadResult.completeMultipartUpload.eTag;
            cOSXMLUploadTaskResult.accessUrl = completeMultiUploadResult.accessUrl;
            PicUploadResult picUploadResult = new PicUploadResult();
            picUploadResult.originalInfo = completeMultiUploadResult.completeMultipartUpload.getOriginInfo();
            picUploadResult.processResults = completeMultiUploadResult.completeMultipartUpload.processResults;
            cOSXMLUploadTaskResult.picUploadResult = picUploadResult;
        }
        return cOSXMLUploadTaskResult;
    }

    void cancelAllRequest(CosXmlSimpleService cosXmlSimpleService) {
        HeadObjectRequest headObjectRequest = this.headObjectRequest;
        if (headObjectRequest != null) {
            cosXmlSimpleService.cancel(headObjectRequest);
        }
        PutObjectRequest putObjectRequest = this.putObjectRequest;
        if (putObjectRequest != null) {
            cosXmlSimpleService.cancel(putObjectRequest);
        }
        InitMultipartUploadRequest initMultipartUploadRequest = this.initMultipartUploadRequest;
        if (initMultipartUploadRequest != null) {
            cosXmlSimpleService.cancel(initMultipartUploadRequest);
        }
        ListPartsRequest listPartsRequest = this.listPartsRequest;
        if (listPartsRequest != null) {
            cosXmlSimpleService.cancel(listPartsRequest);
        }
        Map<UploadPartRequest, Long> map = this.uploadPartRequestLongMap;
        if (map != null) {
            for (UploadPartRequest uploadPartRequest : map.keySet()) {
                cosXmlSimpleService.cancel(uploadPartRequest);
            }
        }
        CompleteMultiUploadRequest completeMultiUploadRequest = this.completeMultiUploadRequest;
        if (completeMultiUploadRequest != null) {
            cosXmlSimpleService.cancel(completeMultiUploadRequest);
        }
    }

    protected boolean checkParameter() {
        UrlUploadPolicy urlUploadPolicy;
        Context appContext;
        if (this.bytes == null && this.inputStream == null && this.srcPath == null && this.uri == null && this.url == null) {
            if (this.IS_EXIT.get()) {
                return false;
            }
            this.IS_EXIT.set(true);
            this.multiUploadsStateListenerHandler.onFailed(new PutObjectRequest(this.bucket, this.cosPath, ""), new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "source is is invalid: null"), null);
            return false;
        }
        if (this.srcPath != null) {
            File file = new File(this.srcPath);
            if (!file.exists() || file.isDirectory() || !file.canRead()) {
                if (this.IS_EXIT.get()) {
                    return false;
                }
                this.IS_EXIT.set(true);
                MultiUploadsStateListener multiUploadsStateListener = this.multiUploadsStateListenerHandler;
                PutObjectRequest putObjectRequest = new PutObjectRequest(this.bucket, this.cosPath, this.srcPath);
                int code = ClientErrorCode.INVALID_ARGUMENT.getCode();
                multiUploadsStateListener.onFailed(putObjectRequest, new CosXmlClientException(code, "srcPath is is invalid: " + this.srcPath), null);
                return false;
            }
            this.fileLength = file.length();
        }
        if (this.uri != null && (appContext = ContextHolder.getAppContext()) != null) {
            this.fileLength = QCloudUtils.getUriContentLength2(this.uri, appContext.getContentResolver());
        }
        if (this.url == null || (urlUploadPolicy = this.urlUploadPolicy) == null) {
            return true;
        }
        if (urlUploadPolicy.getDownloadType() != UrlUploadPolicy.Type.NOTSUPPORT) {
            this.fileLength = this.urlUploadPolicy.getFileLength();
            return true;
        } else if (this.IS_EXIT.get()) {
            return false;
        } else {
            monitor.sendStateMessage(this, TransferState.FAILED, new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "url not support download"), null, 1);
            this.IS_EXIT.set(true);
            return false;
        }
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void encounterError(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        if (this.IS_EXIT.get()) {
            return;
        }
        this.IS_EXIT.set(true);
        MultiUploadsStateListener multiUploadsStateListener = this.multiUploadsStateListenerHandler;
        if (cosXmlRequest == null) {
            cosXmlRequest = buildCOSXMLTaskRequest();
        }
        multiUploadsStateListener.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
    }

    public boolean getSendingCompleteRequest() {
        return this.sendingCompleteRequest.get();
    }

    public String getUploadId() {
        return this.uploadId;
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalCancel() {
        cancelAllRequest(this.cosXmlService);
        if (this.isSliceUpload) {
            abortMultiUpload(this.cosXmlService);
        }
        clear();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalCompleted() {
        clear();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalFailed() {
        cancelAllRequest(this.cosXmlService);
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalPause() {
        CosXmlRequest buildCOSXMLTaskRequest = buildCOSXMLTaskRequest();
        buildCOSXMLTaskRequest.attachMetrics(this.httpTaskMetrics);
        BeaconService.getInstance().reportUploadTaskSuccess(buildCOSXMLTaskRequest);
        cancelAllRequest(this.cosXmlService);
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalResume() {
        this.taskState = TransferState.WAITING;
        this.IS_EXIT.set(false);
        upload();
    }

    public boolean pauseSafely() {
        if (this.sendingCompleteRequest.get()) {
            return false;
        }
        pause();
        return true;
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    public void resume() {
        if (this.inputStream == null) {
            super.resume();
        } else if (this.IS_EXIT.get()) {
        } else {
            this.IS_EXIT.set(true);
            this.multiUploadsStateListenerHandler.onFailed(buildCOSXMLTaskRequest(), new CosXmlClientException(ClientErrorCode.SINK_SOURCE_NOT_FOUND.getCode(), "inputStream closed"), null);
        }
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    protected void startUpload() {
        if (this.bytes != null || this.inputStream != null) {
            simpleUpload(this.cosXmlService);
        } else if (this.fileLength < this.multiUploadSizeDivision || this.forceSimpleUpload) {
            simpleUpload(this.cosXmlService);
        } else {
            this.isSliceUpload = true;
            this.UPLOAD_PART_COUNT = new AtomicInteger(0);
            this.ALREADY_SEND_DATA_LEN = new AtomicLong(0L);
            this.partStructMap = new LinkedHashMap();
            this.uploadPartRequestLongMap = new LinkedHashMap();
            multiUpload(this.cosXmlService);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void upload() {
        if (checkParameter()) {
            this.startTime = System.nanoTime();
            startUpload();
        }
    }
}
