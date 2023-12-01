package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.cos.xml.model.tag.ListParts;
import com.tencent.qcloud.core.common.QCloudTaskStateListener;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLCopyTask.class */
public final class COSXMLCopyTask extends COSXMLTask {
    private AtomicBoolean IS_EXIT;
    private Object SYNC_UPLOAD_PART;
    private AtomicInteger UPLOAD_PART_COUNT;
    private CompleteMultiUploadRequest completeMultiUploadRequest;
    private CopyObjectRequest copyObjectRequest;
    private Map<Integer, CopyPartStruct> copyPartStructMap;
    private CopyObjectRequest.CopySourceStruct copySourceStruct;
    private long fileLength;
    private HeadObjectRequest headObjectRequest;
    private HttpTaskMetrics httpTaskMetrics;
    private InitMultipartUploadRequest initMultipartUploadRequest;
    private boolean isLargeCopy;
    private LargeCopyStateListener largeCopyStateListenerHandler;
    private ListPartsRequest listPartsRequest;
    protected long multiCopySizeDivision;
    protected long sliceSize;
    private String uploadId;
    private List<UploadPartCopyRequest> uploadPartCopyRequestList;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLCopyTask$COSXMLCopyTaskRequest.class */
    public static class COSXMLCopyTaskRequest extends CopyObjectRequest {
        protected COSXMLCopyTaskRequest(String str, String str2, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct, Map<String, List<String>> map, Map<String, String> map2) {
            super(str2, str3, copySourceStruct);
            setRegion(str);
            setRequestHeaders(map);
            setQueryParameters(map2);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLCopyTask$COSXMLCopyTaskResult.class */
    public static class COSXMLCopyTaskResult extends CosXmlResult {
        public String eTag;

        protected COSXMLCopyTaskResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLCopyTask$CopyPartStruct.class */
    public static class CopyPartStruct {
        public String eTag;
        public long end;
        public boolean isAlreadyUpload;
        public int partNumber;
        public long start;

        private CopyPartStruct() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLCopyTask$LargeCopyStateListener.class */
    public interface LargeCopyStateListener {
        void onCompleted(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult);

        void onFailed(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

        void onInit();

        void onListParts();

        void onUploadPartCopy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLCopyTask(CosXmlSimpleService cosXmlSimpleService, CopyObjectRequest copyObjectRequest) {
        this(cosXmlSimpleService, copyObjectRequest.getRegion(), copyObjectRequest.getBucket(), copyObjectRequest.getPath(cosXmlSimpleService.getConfig()), copyObjectRequest.getCopySource());
        this.queries = copyObjectRequest.getQueryString();
        this.headers = copyObjectRequest.getRequestHeaders();
        this.isNeedMd5 = copyObjectRequest.isNeedMD5();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLCopyTask(CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct) {
        this.isLargeCopy = false;
        this.IS_EXIT = new AtomicBoolean(false);
        this.SYNC_UPLOAD_PART = new Object();
        this.httpTaskMetrics = new HttpTaskMetrics();
        this.largeCopyStateListenerHandler = new LargeCopyStateListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.1
            @Override // com.tencent.cos.xml.transfer.COSXMLCopyTask.LargeCopyStateListener
            public void onCompleted(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                COSXMLCopyTask.this.updateState(TransferState.COMPLETED, null, cosXmlResult, false);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cos.xml.transfer.COSXMLCopyTask.LargeCopyStateListener
            public void onFailed(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                CosXmlClientException cosXmlClientException2 = cosXmlClientException != null ? cosXmlClientException : cosXmlServiceException;
                COSXMLCopyTask.this.reportException(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                COSXMLCopyTask.this.updateState(TransferState.FAILED, cosXmlClientException2, null, false);
            }

            @Override // com.tencent.cos.xml.transfer.COSXMLCopyTask.LargeCopyStateListener
            public void onInit() {
                COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                cOSXMLCopyTask.uploadPartCopy(cOSXMLCopyTask.cosXmlService);
            }

            @Override // com.tencent.cos.xml.transfer.COSXMLCopyTask.LargeCopyStateListener
            public void onListParts() {
                COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                cOSXMLCopyTask.uploadPartCopy(cOSXMLCopyTask.cosXmlService);
            }

            @Override // com.tencent.cos.xml.transfer.COSXMLCopyTask.LargeCopyStateListener
            public void onUploadPartCopy() {
                COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                cOSXMLCopyTask.completeMultiUpload(cOSXMLCopyTask.cosXmlService);
            }
        };
        this.cosXmlService = cosXmlSimpleService;
        this.region = str;
        this.bucket = str2;
        this.cosPath = str3;
        this.copySourceStruct = copySourceStruct;
    }

    private void abortMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        if (this.uploadId == null) {
            return;
        }
        AbortMultiUploadRequest abortMultiUploadRequest = new AbortMultiUploadRequest(this.bucket, this.cosPath, this.uploadId);
        if (this.onSignatureListener != null) {
            abortMultiUploadRequest.setSign(this.onSignatureListener.onGetSign(abortMultiUploadRequest));
        }
        getHttpMetrics(abortMultiUploadRequest, "AbortMultiUploadRequest");
        cosXmlSimpleService.abortMultiUploadAsync(abortMultiUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.7
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
            }
        });
    }

    private void cancelAllRequest(CosXmlSimpleService cosXmlSimpleService) {
        HeadObjectRequest headObjectRequest = this.headObjectRequest;
        if (headObjectRequest != null) {
            cosXmlSimpleService.cancel(headObjectRequest);
        }
        CopyObjectRequest copyObjectRequest = this.copyObjectRequest;
        if (copyObjectRequest != null) {
            cosXmlSimpleService.cancel(copyObjectRequest);
        }
        InitMultipartUploadRequest initMultipartUploadRequest = this.initMultipartUploadRequest;
        if (initMultipartUploadRequest != null) {
            cosXmlSimpleService.cancel(initMultipartUploadRequest);
        }
        ListPartsRequest listPartsRequest = this.listPartsRequest;
        if (listPartsRequest != null) {
            cosXmlSimpleService.cancel(listPartsRequest);
        }
        List<UploadPartCopyRequest> list = this.uploadPartCopyRequestList;
        if (list != null) {
            for (UploadPartCopyRequest uploadPartCopyRequest : list) {
                cosXmlSimpleService.cancel(uploadPartCopyRequest);
            }
        }
        CompleteMultiUploadRequest completeMultiUploadRequest = this.completeMultiUploadRequest;
        if (completeMultiUploadRequest != null) {
            cosXmlSimpleService.cancel(completeMultiUploadRequest);
        }
    }

    private void clear() {
        List<UploadPartCopyRequest> list = this.uploadPartCopyRequestList;
        if (list != null) {
            list.clear();
        }
        Map<Integer, CopyPartStruct> map = this.copyPartStructMap;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        this.completeMultiUploadRequest = new CompleteMultiUploadRequest(this.bucket, this.cosPath, this.uploadId, null);
        for (Map.Entry<Integer, CopyPartStruct> entry : this.copyPartStructMap.entrySet()) {
            CopyPartStruct value = entry.getValue();
            this.completeMultiUploadRequest.setPartNumberAndETag(value.partNumber, value.eTag);
        }
        this.completeMultiUploadRequest.setNeedMD5(this.isNeedMd5);
        this.completeMultiUploadRequest.setRequestHeaders(this.headers);
        if (this.onSignatureListener != null) {
            this.completeMultiUploadRequest.setSign(this.onSignatureListener.onGetSign(this.completeMultiUploadRequest));
        }
        getHttpMetrics(this.completeMultiUploadRequest, "CompleteMultiUploadRequest");
        cosXmlSimpleService.completeMultiUploadAsync(this.completeMultiUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.6
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLCopyTask.this.completeMultiUploadRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask.this.IS_EXIT.set(true);
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLCopyTask.this.completeMultiUploadRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask.this.IS_EXIT.set(true);
                    cosXmlRequest.attachMetrics(COSXMLCopyTask.this.httpTaskMetrics.merge(cosXmlRequest.getMetrics()));
                    BeaconService.getInstance().reportCopyTaskSuccess(cosXmlRequest);
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onCompleted(cosXmlRequest, cosXmlResult);
                }
            }
        });
    }

    private void initCopyPart() {
        synchronized (this) {
            int i = (int) (this.fileLength / this.sliceSize);
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 < i) {
                    CopyPartStruct copyPartStruct = new CopyPartStruct();
                    copyPartStruct.isAlreadyUpload = false;
                    copyPartStruct.partNumber = i3;
                    copyPartStruct.start = (i3 - 1) * this.sliceSize;
                    long j = i3;
                    long j2 = this.sliceSize;
                    Long.signum(j);
                    copyPartStruct.end = (j * j2) - 1;
                    this.copyPartStructMap.put(Integer.valueOf(i3), copyPartStruct);
                    i2 = i3 + 1;
                } else {
                    CopyPartStruct copyPartStruct2 = new CopyPartStruct();
                    copyPartStruct2.isAlreadyUpload = false;
                    copyPartStruct2.partNumber = i3;
                    copyPartStruct2.start = (i3 - 1) * this.sliceSize;
                    copyPartStruct2.end = this.fileLength - 1;
                    this.copyPartStructMap.put(Integer.valueOf(i3), copyPartStruct2);
                    this.UPLOAD_PART_COUNT.set(i3);
                }
            }
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
        getHttpMetrics(this.initMultipartUploadRequest, "InitMultipartUploadRequest");
        cosXmlSimpleService.initMultipartUploadAsync(this.initMultipartUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.3
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLCopyTask.this.initMultipartUploadRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask.this.IS_EXIT.set(true);
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLCopyTask.this.initMultipartUploadRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                    cOSXMLCopyTask.httpTaskMetrics = cOSXMLCopyTask.httpTaskMetrics.merge(cosXmlRequest.getMetrics());
                    COSXMLCopyTask.this.uploadId = ((InitMultipartUploadResult) cosXmlResult).initMultipartUpload.uploadId;
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onInit();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void largeFileCopy(CosXmlSimpleService cosXmlSimpleService) {
        initCopyPart();
        if (this.uploadId == null) {
            initMultiUpload(cosXmlSimpleService);
        } else {
            listMultiUpload(cosXmlSimpleService);
        }
    }

    private void listMultiUpload(CosXmlSimpleService cosXmlSimpleService) {
        ListPartsRequest listPartsRequest = new ListPartsRequest(this.bucket, this.cosPath, this.uploadId);
        this.listPartsRequest = listPartsRequest;
        listPartsRequest.setRequestHeaders(this.headers);
        if (this.onSignatureListener != null) {
            this.listPartsRequest.setSign(this.onSignatureListener.onGetSign(this.listPartsRequest));
        }
        getHttpMetrics(this.listPartsRequest, "ListPartsRequest");
        cosXmlSimpleService.listPartsAsync(this.listPartsRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.4
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLCopyTask.this.listPartsRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask.this.IS_EXIT.set(true);
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLCopyTask.this.listPartsRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                    cOSXMLCopyTask.httpTaskMetrics = cOSXMLCopyTask.httpTaskMetrics.merge(cosXmlRequest.getMetrics());
                    COSXMLCopyTask.this.updateSlicePart((ListPartsResult) cosXmlResult);
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onListParts();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportException(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        if (cosXmlClientException != null) {
            BeaconService.getInstance().reportCopyTaskClientException(cosXmlRequest, cosXmlClientException);
        }
        if (cosXmlServiceException != null) {
            BeaconService.getInstance().reportCopyTaskServiceException(cosXmlRequest, cosXmlServiceException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smallFileCopy() {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(this.bucket, this.cosPath, this.copySourceStruct);
        this.copyObjectRequest = copyObjectRequest;
        copyObjectRequest.setRegion(this.region);
        this.copyObjectRequest.setRequestHeaders(this.headers);
        if (this.onSignatureListener != null) {
            this.copyObjectRequest.setSign(this.onSignatureListener.onGetSign(this.copyObjectRequest));
        }
        getHttpMetrics(this.copyObjectRequest, "CopyObjectRequest");
        this.cosXmlService.copyObjectAsync(this.copyObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.2
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLCopyTask.this.copyObjectRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask.this.IS_EXIT.set(true);
                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLCopyTask.this.copyObjectRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                    COSXMLCopyTask.this.IS_EXIT.set(true);
                    BeaconService.getInstance().reportCopyTaskSuccess(cosXmlRequest);
                    COSXMLCopyTask.this.updateState(TransferState.COMPLETED, null, cosXmlResult, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSlicePart(ListPartsResult listPartsResult) {
        List<ListParts.Part> list;
        if (listPartsResult == null || listPartsResult.listParts == null || (list = listPartsResult.listParts.parts) == null) {
            return;
        }
        for (ListParts.Part part : list) {
            if (this.copyPartStructMap.containsKey(Integer.valueOf(part.partNumber))) {
                CopyPartStruct copyPartStruct = this.copyPartStructMap.get(Integer.valueOf(part.partNumber));
                copyPartStruct.isAlreadyUpload = true;
                copyPartStruct.eTag = part.eTag;
                this.UPLOAD_PART_COUNT.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartCopy(CosXmlSimpleService cosXmlSimpleService) {
        boolean z = true;
        for (Map.Entry<Integer, CopyPartStruct> entry : this.copyPartStructMap.entrySet()) {
            final CopyPartStruct value = entry.getValue();
            if (!value.isAlreadyUpload && !this.IS_EXIT.get()) {
                z = false;
                final UploadPartCopyRequest uploadPartCopyRequest = new UploadPartCopyRequest(this.bucket, this.cosPath, value.partNumber, this.uploadId, this.copySourceStruct, value.start, value.end);
                uploadPartCopyRequest.setRegion(this.region);
                uploadPartCopyRequest.setRequestHeaders(this.headers);
                if (this.onSignatureListener != null) {
                    uploadPartCopyRequest.setSign(this.onSignatureListener.onGetSign(uploadPartCopyRequest));
                }
                getHttpMetrics(uploadPartCopyRequest, "UploadPartCopyRequest");
                this.uploadPartCopyRequestList.add(uploadPartCopyRequest);
                cosXmlSimpleService.copyObjectAsync(uploadPartCopyRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.5
                    @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                    public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                        if (cosXmlRequest == uploadPartCopyRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                            COSXMLCopyTask.this.IS_EXIT.set(true);
                            COSXMLCopyTask.this.largeCopyStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
                        }
                    }

                    @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                    public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                        if (cosXmlRequest == uploadPartCopyRequest && !COSXMLCopyTask.this.IS_EXIT.get()) {
                            COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                            cOSXMLCopyTask.httpTaskMetrics = cOSXMLCopyTask.httpTaskMetrics.merge(cosXmlRequest.getMetrics());
                            value.eTag = ((UploadPartCopyResult) cosXmlResult).copyObject.eTag;
                            value.isAlreadyUpload = true;
                            synchronized (COSXMLCopyTask.this.SYNC_UPLOAD_PART) {
                                COSXMLCopyTask.this.UPLOAD_PART_COUNT.decrementAndGet();
                                if (COSXMLCopyTask.this.UPLOAD_PART_COUNT.get() == 0) {
                                    COSXMLCopyTask.this.largeCopyStateListenerHandler.onUploadPartCopy();
                                }
                            }
                        }
                    }
                });
            }
        }
        if (!z || this.IS_EXIT.get()) {
            return;
        }
        this.largeCopyStateListenerHandler.onUploadPartCopy();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected CosXmlRequest buildCOSXMLTaskRequest() {
        return new COSXMLCopyTaskRequest(this.region, this.bucket, this.cosPath, this.copySourceStruct, this.headers, this.queries);
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected CosXmlResult buildCOSXMLTaskResult(CosXmlResult cosXmlResult) {
        COSXMLCopyTaskResult cOSXMLCopyTaskResult = new COSXMLCopyTaskResult();
        if (cosXmlResult != null && (cosXmlResult instanceof CopyObjectResult)) {
            CopyObjectResult copyObjectResult = (CopyObjectResult) cosXmlResult;
            cOSXMLCopyTaskResult.httpCode = copyObjectResult.httpCode;
            cOSXMLCopyTaskResult.httpMessage = copyObjectResult.httpMessage;
            cOSXMLCopyTaskResult.headers = copyObjectResult.headers;
            cOSXMLCopyTaskResult.eTag = copyObjectResult.copyObject.eTag;
            cOSXMLCopyTaskResult.accessUrl = copyObjectResult.accessUrl;
            return cOSXMLCopyTaskResult;
        }
        if (cosXmlResult != null && (cosXmlResult instanceof CompleteMultiUploadResult)) {
            CompleteMultiUploadResult completeMultiUploadResult = (CompleteMultiUploadResult) cosXmlResult;
            cOSXMLCopyTaskResult.httpCode = completeMultiUploadResult.httpCode;
            cOSXMLCopyTaskResult.httpMessage = completeMultiUploadResult.httpMessage;
            cOSXMLCopyTaskResult.headers = completeMultiUploadResult.headers;
            cOSXMLCopyTaskResult.eTag = completeMultiUploadResult.completeMultipartUpload.eTag;
            cOSXMLCopyTaskResult.accessUrl = completeMultiUploadResult.accessUrl;
        }
        return cOSXMLCopyTaskResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void copy() {
        run();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void encounterError(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        if (this.IS_EXIT.get()) {
            return;
        }
        this.IS_EXIT.set(true);
        this.largeCopyStateListenerHandler.onFailed(this.copyObjectRequest, cosXmlClientException, cosXmlServiceException);
    }

    public String getUploadId() {
        return this.uploadId;
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalCancel() {
        cancelAllRequest(this.cosXmlService);
        if (this.isLargeCopy) {
            abortMultiUpload(this.cosXmlService);
        }
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
        copy();
    }

    protected void run() {
        HeadObjectRequest headObjectRequest = new HeadObjectRequest(this.copySourceStruct.bucket, this.copySourceStruct.cosPath);
        this.headObjectRequest = headObjectRequest;
        headObjectRequest.setRegion(this.copySourceStruct.region);
        if (this.onSignatureListener != null) {
            this.headObjectRequest.setSign(this.onSignatureListener.onGetSign(this.headObjectRequest));
        }
        getHttpMetrics(this.headObjectRequest, BeaconService.EVENT_PARAMS_NODE_HEAD);
        this.headObjectRequest.setTaskStateListener(new QCloudTaskStateListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.8
            @Override // com.tencent.qcloud.core.common.QCloudTaskStateListener
            public void onStateChanged(String str, int i) {
                if (COSXMLCopyTask.this.IS_EXIT.get()) {
                    return;
                }
                COSXMLCopyTask.this.updateState(TransferState.IN_PROGRESS, null, null, false);
            }
        });
        this.cosXmlService.headObjectAsync(this.headObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLCopyTask.9
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (COSXMLCopyTask.this.IS_EXIT.get()) {
                    return;
                }
                COSXMLCopyTask.this.IS_EXIT.set(true);
                COSXMLCopyTask.this.largeCopyStateListenerHandler.onFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (COSXMLCopyTask.this.IS_EXIT.get()) {
                    return;
                }
                List<String> list = cosXmlResult.headers.get("Content-Length");
                if (list != null && list.size() > 0) {
                    COSXMLCopyTask.this.fileLength = Long.parseLong(list.get(0));
                }
                if (COSXMLCopyTask.this.fileLength <= COSXMLCopyTask.this.multiCopySizeDivision) {
                    COSXMLCopyTask.this.smallFileCopy();
                    return;
                }
                COSXMLCopyTask.this.isLargeCopy = true;
                if (COSXMLCopyTask.this.copyPartStructMap != null) {
                    COSXMLCopyTask.this.copyPartStructMap.clear();
                } else {
                    COSXMLCopyTask.this.copyPartStructMap = new LinkedHashMap();
                }
                if (COSXMLCopyTask.this.uploadPartCopyRequestList != null) {
                    COSXMLCopyTask.this.uploadPartCopyRequestList.clear();
                } else {
                    COSXMLCopyTask.this.uploadPartCopyRequestList = new ArrayList();
                }
                if (COSXMLCopyTask.this.UPLOAD_PART_COUNT != null) {
                    COSXMLCopyTask.this.UPLOAD_PART_COUNT.set(0);
                } else {
                    COSXMLCopyTask.this.UPLOAD_PART_COUNT = new AtomicInteger(0);
                }
                COSXMLCopyTask cOSXMLCopyTask = COSXMLCopyTask.this;
                cOSXMLCopyTask.largeFileCopy(cOSXMLCopyTask.cosXmlService);
            }
        });
    }
}
