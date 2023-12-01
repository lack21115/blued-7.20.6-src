package com.tencent.cos.xml.transfer;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import bolts.CancellationTokenSource;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.COSDirect;
import com.tencent.cos.xml.crypto.CipherLiteInputStream;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.crypto.MultipartUploadCryptoContext;
import com.tencent.cos.xml.crypto.ObjectMetadata;
import com.tencent.cos.xml.crypto.ResettableInputStream;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsRequest;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.tag.ListMultipartUploads;
import com.tencent.cos.xml.transfer.COSTransferTask;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.util.ContextHolder;
import com.tencent.qcloud.core.util.QCloudUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSUploadTask.class */
public class COSUploadTask extends COSTransferTask {
    public static final String TAG = "QCloudUpload";
    private static final int UPLOAD_CONCURRENT = 2;
    private static ThreadPoolExecutor uploadTaskExecutor = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(Integer.MAX_VALUE), new COSTransferTask.TaskThreadFactory("QCloudUpload-", 8));
    private boolean mForceSimpleUpload;
    private long mMaxPartSize;
    private PutObjectRequest mPutObjectRequest;
    private long multipartUploadThreshold;
    private long uploadLength;
    private BaseUploadTask uploadTask;
    private boolean verifyCRC64;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSUploadTask$BaseUploadTask.class */
    public static abstract class BaseUploadTask implements Runnable {
        protected COSDirect cosDirect;
        protected TransferTaskMetrics mTransferMetrics;
        protected CancellationTokenSource mTransferTaskCts;
        protected PutObjectRequest putObjectRequest;
        protected String taskId;
        protected TaskCompletionSource<CosXmlResult> tcs = new TaskCompletionSource<>();
        protected long totalUploadSize;

        BaseUploadTask(COSDirect cOSDirect, PutObjectRequest putObjectRequest, CancellationTokenSource cancellationTokenSource, long j) {
            this.cosDirect = cOSDirect;
            this.putObjectRequest = putObjectRequest;
            this.mTransferTaskCts = cancellationTokenSource;
            this.totalUploadSize = j;
        }

        public abstract void cancel();

        public Task<CosXmlResult> getTask() {
            return this.tcs.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mTransferTaskCts.a()) {
                this.tcs.c();
                return;
            }
            try {
                this.tcs.setResult(upload(this.putObjectRequest));
            } catch (Exception e) {
                this.tcs.b(e);
            }
        }

        public void setTaskId(String str) {
            this.taskId = str;
        }

        protected abstract CosXmlResult upload(PutObjectRequest putObjectRequest) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSUploadTask$MultipartUploadTask.class */
    public static class MultipartUploadTask extends BaseUploadTask {
        private String bucket;
        private volatile CompleteMultiUploadRequest completeMultiUploadRequest;
        private CosXmlSimpleService cosService;
        private volatile InitMultipartUploadRequest initMultipartUploadRequest;
        private String key;
        private volatile ListMultiUploadsRequest listMultiUploadsRequest;
        private volatile ListPartsRequest listPartsRequest;
        private MultipartUploadCryptoContext mCryptoContext;
        private long mMaxPartSize;
        private String mUploadId;
        private String region;
        private TreeSet<UploadPart> uploadParts;
        private BaseUploadPartsTask uploadPartsTask;
        private boolean verifyCRC64;

        public MultipartUploadTask(COSDirect cOSDirect, PutObjectRequest putObjectRequest, CancellationTokenSource cancellationTokenSource, long j) {
            super(cOSDirect, putObjectRequest, cancellationTokenSource, j);
            this.mMaxPartSize = 1048576L;
            this.verifyCRC64 = true;
            this.putObjectRequest = putObjectRequest;
            this.tcs = new TaskCompletionSource<>();
            this.bucket = putObjectRequest.getBucket();
            this.region = putObjectRequest.getRegion();
            this.key = putObjectRequest.getCosPath();
            this.uploadParts = new TreeSet<>(new Comparator<UploadPart>() { // from class: com.tencent.cos.xml.transfer.COSUploadTask.MultipartUploadTask.1
                @Override // java.util.Comparator
                public int compare(UploadPart uploadPart, UploadPart uploadPart2) {
                    int i = uploadPart.number;
                    int i2 = uploadPart2.number;
                    if (i < i2) {
                        return -1;
                    }
                    return i == i2 ? 0 : 1;
                }
            });
            this.cosService = this.cosDirect.getCosService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void abort() {
            if (TextUtils.isEmpty(this.mUploadId)) {
                return;
            }
            AbortMultiUploadRequest abortMultiUploadRequest = new AbortMultiUploadRequest(this.bucket, this.key, this.mUploadId);
            abortMultiUploadRequest.setRegion(this.region);
            this.cosService.abortMultiUploadAsync(abortMultiUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSUploadTask.MultipartUploadTask.2
                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                }

                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                }
            });
        }

        private void assetNotNull(Object obj) throws CosXmlClientException {
            if (obj != null) {
                return;
            }
            int code = ClientErrorCode.INTERNAL_ERROR.getCode();
            throw new CosXmlClientException(code, Object.class.getSimpleName() + "is null");
        }

        private void checkoutManualCanceled() throws CosXmlClientException {
            if (this.mTransferTaskCts.a()) {
                throw CosXmlClientException.manualCancelException();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0144, code lost:
            com.tencent.cos.xml.transfer.COSTransferTask.loggerInfo(com.tencent.cos.xml.transfer.COSUploadTask.TAG, r10.taskId, "part number %d md5 not the same, local md5=%s, part md5=%s", java.lang.Integer.valueOf(r0), r0, r0.eTag);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x016b, code lost:
            r14 = r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean checkoutUploadId(java.lang.String r11) throws com.tencent.cos.xml.exception.CosXmlClientException, com.tencent.cos.xml.exception.CosXmlServiceException {
            /*
                Method dump skipped, instructions count: 449
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.transfer.COSUploadTask.MultipartUploadTask.checkoutUploadId(java.lang.String):boolean");
        }

        private CosXmlResult completeMultipartUpload(String str) throws CosXmlClientException, CosXmlServiceException {
            HashMap hashMap = new HashMap();
            Iterator<UploadPart> it = this.uploadParts.iterator();
            while (it.hasNext()) {
                UploadPart next = it.next();
                hashMap.put(Integer.valueOf(next.number), next.etag);
            }
            try {
                this.completeMultiUploadRequest = new CompleteMultiUploadRequest(this.bucket, this.key, str, hashMap);
                this.completeMultiUploadRequest.setRequestHeaders(getCompleteHeaders(this.putObjectRequest));
                CompleteMultiUploadResult completeMultipartUpload = this.cosDirect.completeMultipartUpload(this.completeMultiUploadRequest);
                COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "complete upload task", this.key, str);
                return completeMultipartUpload;
            } catch (CosXmlServiceException e) {
                if ("NoSuchUpload".equals(e.getErrorCode())) {
                    try {
                        HeadObjectRequest headObjectRequest = new HeadObjectRequest(this.bucket, this.key);
                        headObjectRequest.setRegion(this.region);
                        COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "complete uploadId [%s] failed with NoSuchUpload. check if it has been uploaded by HeadObjectRequest.", str);
                        return this.cosService.headObject(headObjectRequest);
                    } catch (Exception e2) {
                        throw e;
                    }
                }
                throw e;
            }
        }

        private void crc64Verify(String str) throws CosXmlClientException {
            if (TextUtils.isEmpty(str)) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "unable to verify with crc64 is null");
            }
            try {
                long bigIntFromString = DigestUtils.getBigIntFromString(str);
                InputStream openInputStream = openInputStream();
                long crc64 = DigestUtils.getCRC64(openInputStream);
                openInputStream.close();
                if (bigIntFromString != crc64) {
                    throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), String.format(Locale.ENGLISH, "crc64 verify failed, remote crc 64bit value is %d, but local crc 64bit value is %d", Long.valueOf(bigIntFromString), Long.valueOf(crc64)));
                }
                COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "verify crc64 %s success", str);
            } catch (IOException e) {
                throw new CosXmlClientException(ClientErrorCode.IO_ERROR.getCode(), String.format(Locale.ENGLISH, "failed open inputStream to verify crc64: %s", e.getMessage()));
            }
        }

        private void delete() {
            DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(this.bucket, this.key);
            deleteObjectRequest.setRegion(this.region);
            try {
                this.cosService.deleteObject(deleteObjectRequest);
            } catch (CosXmlClientException e) {
                e.printStackTrace();
            } catch (CosXmlServiceException e2) {
                e2.printStackTrace();
            }
        }

        private Map<String, List<String>> getCompleteHeaders(PutObjectRequest putObjectRequest) {
            Map<String, List<String>> requestHeaders = putObjectRequest.getRequestHeaders();
            if (requestHeaders == null) {
                return new HashMap();
            }
            HashMap hashMap = new HashMap(requestHeaders);
            hashMap.remove("Content-Type");
            return hashMap;
        }

        private Map<String, List<String>> getInitHeaders(PutObjectRequest putObjectRequest) {
            Map<String, List<String>> requestHeaders = putObjectRequest.getRequestHeaders();
            return requestHeaders == null ? new HashMap() : new HashMap(requestHeaders);
        }

        private String getStorageClass() {
            List<String> list = this.putObjectRequest.getRequestHeaders().get("x-cos-storage-class");
            return (list == null || list.isEmpty()) ? "STANDARD" : list.get(0);
        }

        private String initUploadId() throws Exception {
            this.initMultipartUploadRequest = new InitMultipartUploadRequest(this.bucket, this.key);
            this.initMultipartUploadRequest.setRegion(this.region);
            this.initMultipartUploadRequest.setRequestHeaders(getInitHeaders(this.putObjectRequest));
            HttpTaskMetrics httpTaskMetrics = new HttpTaskMetrics();
            this.initMultipartUploadRequest.attachMetrics(httpTaskMetrics);
            if (this.cosDirect.isTransferSecurely()) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(this.totalUploadSize);
                objectMetadata.setContentMD5(DigestUtils.getCOSMd5(openUnencryptedInputStream(), 0L, this.totalUploadSize));
                this.initMultipartUploadRequest.setMetadata(objectMetadata);
            }
            InitMultipartUploadResult initMultipartUpload = this.cosDirect.initMultipartUpload(this.initMultipartUploadRequest);
            this.mTransferMetrics.connectAddress = httpTaskMetrics.getConnectAddress();
            String str = initMultipartUpload.initMultipartUpload.uploadId;
            if (this.cosDirect.isTransferSecurely()) {
                this.mCryptoContext = this.cosDirect.getCryptoModule().getCryptoContext(str);
            }
            COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "create a new uploadId %s", str);
            return str;
        }

        private boolean isParallelUpload() {
            return !this.cosDirect.isTransferSecurely();
        }

        private List<String> listObjectUploadIds() throws CosXmlClientException, CosXmlServiceException {
            String substring = this.key.startsWith("/") ? this.key.substring(1) : this.key;
            HttpTaskMetrics httpTaskMetrics = new HttpTaskMetrics();
            this.listMultiUploadsRequest = new ListMultiUploadsRequest(this.bucket);
            this.listMultiUploadsRequest.setPrefix(substring);
            this.listMultiUploadsRequest.setRegion(this.region);
            this.listMultiUploadsRequest.attachMetrics(httpTaskMetrics);
            LinkedList linkedList = new LinkedList();
            ListMultiUploadsResult listMultiUploads = this.cosService.listMultiUploads(this.listMultiUploadsRequest);
            this.mTransferMetrics.connectAddress = httpTaskMetrics.getConnectAddress();
            ListMultipartUploads listMultipartUploads = listMultiUploads.listMultipartUploads;
            if (listMultipartUploads != null) {
                List<ListMultipartUploads.Upload> list = listMultipartUploads.uploads;
                COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "find %d uploadIds with prefix %s", Integer.valueOf(list.size()), substring);
                if (!list.isEmpty()) {
                    Collections.sort(list, new Comparator<ListMultipartUploads.Upload>() { // from class: com.tencent.cos.xml.transfer.COSUploadTask.MultipartUploadTask.3
                        @Override // java.util.Comparator
                        public int compare(ListMultipartUploads.Upload upload, ListMultipartUploads.Upload upload2) {
                            Long valueOf = Long.valueOf(MultipartUploadTask.this.parseInitiatedDate(upload.initiated));
                            Long valueOf2 = Long.valueOf(MultipartUploadTask.this.parseInitiatedDate(upload2.initiated));
                            if (valueOf2.longValue() < valueOf.longValue()) {
                                return -1;
                            }
                            return valueOf2 == valueOf ? 0 : 1;
                        }
                    });
                    for (ListMultipartUploads.Upload upload : list) {
                        if (upload.key.equals(substring) && upload.storageClass.equals(getStorageClass())) {
                            linkedList.add(upload.uploadID);
                        }
                    }
                }
            }
            COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "find %d plan uploadId", Integer.valueOf(linkedList.size()));
            return linkedList;
        }

        private InputStream openInputStream() throws CosXmlClientException {
            CipherLiteInputStream openUnencryptedInputStream = openUnencryptedInputStream();
            if (this.cosDirect.isTransferSecurely()) {
                if (this.mCryptoContext == null) {
                    throw CosXmlClientException.internalException(this.mUploadId + " crypto context not found");
                }
                openUnencryptedInputStream = this.cosDirect.getCryptoModule().newCOSCipherLiteInputStream(this.putObjectRequest, this.mCryptoContext.getCipherLite());
            }
            assetNotNull(openUnencryptedInputStream);
            return openUnencryptedInputStream;
        }

        private InputStream openUnencryptedInputStream() throws CosXmlClientException {
            try {
                String srcPath = this.putObjectRequest.getSrcPath();
                Uri uri = this.putObjectRequest.getUri();
                ResettableInputStream resettableInputStream = srcPath != null ? new ResettableInputStream(srcPath) : (uri == null || ContextHolder.getAppContext() == null) ? null : ContextHolder.getAppContext().getContentResolver().openInputStream(uri);
                assetNotNull(resettableInputStream);
                return resettableInputStream;
            } catch (Exception e) {
                throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), "open InputStream failed");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long parseInitiatedDate(String str) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
                return 0L;
            }
        }

        private UploadPartRequest transform(PutObjectRequest putObjectRequest) throws CosXmlClientException {
            UploadPartRequest uploadPartRequest = putObjectRequest.getUri() != null ? new UploadPartRequest(this.bucket, this.key, 1, putObjectRequest.getUri(), this.mUploadId) : putObjectRequest.getSrcPath() != null ? new UploadPartRequest(this.bucket, this.key, 1, putObjectRequest.getSrcPath(), this.mUploadId) : null;
            assetNotNull(uploadPartRequest);
            uploadPartRequest.setFileOffset(0L);
            uploadPartRequest.setFileContentLength(new File(putObjectRequest.getSrcPath()).length());
            return uploadPartRequest;
        }

        private void uploadParts(String str) throws Exception {
            long j;
            int i;
            long j2 = this.totalUploadSize;
            UploadPart last = this.uploadParts.isEmpty() ? null : this.uploadParts.last();
            if (last != null) {
                j = last.offset + last.size;
                j2 -= j;
                i = last.number + 1;
            } else {
                j = 0;
                i = 1;
            }
            this.mTransferMetrics.size = j2;
            if (j2 > 0) {
                COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "start upload parts, offset=%s, size=%d, startNumber=%d", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
                if (isParallelUpload()) {
                    this.uploadPartsTask = new ParallelUploadPartsTask(this.cosDirect, this.putObjectRequest, j, j2, i, str);
                } else {
                    this.uploadPartsTask = new SerialUploadPartsTask(this.cosDirect, this.putObjectRequest, j, j2, i, str);
                }
                this.uploadPartsTask.mMaxPartSize = this.mMaxPartSize;
                this.uploadPartsTask.setTaskId(this.taskId);
                this.uploadPartsTask.setProgressListener(this.putObjectRequest.getProgressListener());
                this.uploadParts.addAll(this.uploadPartsTask.upload());
            }
        }

        @Override // com.tencent.cos.xml.transfer.COSUploadTask.BaseUploadTask
        public void cancel() {
            if (this.listMultiUploadsRequest != null) {
                this.cosDirect.cancel(this.listMultiUploadsRequest);
            }
            if (this.initMultipartUploadRequest != null) {
                this.cosDirect.cancel(this.initMultipartUploadRequest);
            }
            if (this.listPartsRequest != null) {
                this.cosDirect.cancel(this.listPartsRequest);
            }
            if (this.completeMultiUploadRequest != null) {
                this.cosDirect.cancel(this.completeMultiUploadRequest);
            }
            BaseUploadPartsTask baseUploadPartsTask = this.uploadPartsTask;
            if (baseUploadPartsTask != null) {
                baseUploadPartsTask.cancel();
            }
        }

        @Override // com.tencent.cos.xml.transfer.COSUploadTask.BaseUploadTask
        public void setTaskId(String str) {
            this.taskId = str;
        }

        @Override // com.tencent.cos.xml.transfer.COSUploadTask.BaseUploadTask
        protected CosXmlResult upload(PutObjectRequest putObjectRequest) throws Exception {
            if (!this.cosDirect.isTransferSecurely()) {
                checkoutManualCanceled();
                List<String> listObjectUploadIds = listObjectUploadIds();
                checkoutManualCanceled();
                Iterator<String> it = listObjectUploadIds.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (checkoutUploadId(next)) {
                        this.mUploadId = next;
                        break;
                    }
                }
            }
            checkoutManualCanceled();
            if (TextUtils.isEmpty(this.mUploadId)) {
                this.mUploadId = initUploadId();
            }
            checkoutManualCanceled();
            uploadParts(this.mUploadId);
            checkoutManualCanceled();
            CosXmlResult completeMultipartUpload = completeMultipartUpload(this.mUploadId);
            if (this.verifyCRC64) {
                checkoutManualCanceled();
                crc64Verify(completeMultipartUpload.getHeader(Headers.COS_HASH_CRC64_ECMA));
            }
            return completeMultipartUpload;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSUploadTask$SimpleUploadTask.class */
    static class SimpleUploadTask extends BaseUploadTask {
        SimpleUploadTask(COSDirect cOSDirect, PutObjectRequest putObjectRequest, CancellationTokenSource cancellationTokenSource, long j) {
            super(cOSDirect, putObjectRequest, cancellationTokenSource, j);
        }

        @Override // com.tencent.cos.xml.transfer.COSUploadTask.BaseUploadTask
        public void cancel() {
            this.cosDirect.cancel(this.putObjectRequest);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.cos.xml.transfer.COSUploadTask.BaseUploadTask
        public PutObjectResult upload(PutObjectRequest putObjectRequest) throws Exception {
            HttpTaskMetrics httpTaskMetrics = new HttpTaskMetrics();
            this.mTransferMetrics.size = this.totalUploadSize;
            putObjectRequest.attachMetrics(httpTaskMetrics);
            PutObjectResult putObject = this.cosDirect.putObject(putObjectRequest);
            this.mTransferMetrics.connectAddress = httpTaskMetrics.getConnectAddress();
            COSTransferTask.loggerInfo(COSUploadTask.TAG, this.taskId, "complete upload task", new Object[0]);
            return putObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSUploadTask$UploadPart.class */
    public static final class UploadPart {
        String etag;
        int number;
        long offset;
        long size;

        public UploadPart(String str, int i, long j, long j2) {
            this.etag = str;
            this.number = i;
            this.offset = j;
            this.size = j2;
        }
    }

    public COSUploadTask(COSDirect cOSDirect, PutObjectRequest putObjectRequest) {
        super(cOSDirect, putObjectRequest);
        this.multipartUploadThreshold = 2097152L;
        this.mMaxPartSize = 1048576L;
        this.verifyCRC64 = true;
        this.mForceSimpleUpload = false;
        this.uploadLength = -1L;
        this.mPutObjectRequest = putObjectRequest;
    }

    private PutObjectResult buildPutObjectResult(CompleteMultiUploadResult completeMultiUploadResult) {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.httpCode = completeMultiUploadResult.httpCode;
        putObjectResult.httpMessage = completeMultiUploadResult.httpMessage;
        putObjectResult.headers = completeMultiUploadResult.headers;
        putObjectResult.accessUrl = completeMultiUploadResult.accessUrl;
        putObjectResult.eTag = completeMultiUploadResult.completeMultipartUpload.eTag;
        putObjectResult.picUploadResult = completeMultiUploadResult.completeMultipartUpload.getPicUploadResult();
        return putObjectResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getUploadLength() {
        return this.uploadLength;
    }

    private boolean isMultipartUploadLength() {
        return this.uploadLength >= this.multipartUploadThreshold;
    }

    private boolean isMultipartUploadRequest() {
        return (this.mPutObjectRequest.getSrcPath() == null && this.mPutObjectRequest.getUri() == null) ? false : true;
    }

    private boolean shouldMultipartUpload() {
        return !this.mForceSimpleUpload && isMultipartUploadRequest() && isMultipartUploadLength();
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    public void cancel() {
        super.cancel();
        BaseUploadTask baseUploadTask = this.uploadTask;
        if (baseUploadTask != null) {
            baseUploadTask.cancel();
        }
        BaseUploadTask baseUploadTask2 = this.uploadTask;
        if (baseUploadTask2 instanceof MultipartUploadTask) {
            ((MultipartUploadTask) baseUploadTask2).abort();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    public void checking() throws CosXmlClientException {
        super.checking();
        this.mPutObjectRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.COSUploadTask.1
            @Override // com.tencent.qcloud.core.common.QCloudProgressListener
            public void onProgress(long j, long j2) {
                COSUploadTask cOSUploadTask = COSUploadTask.this;
                cOSUploadTask.onTransferProgressChange(j, cOSUploadTask.getUploadLength());
            }
        });
        byte[] data = this.mPutObjectRequest.getData();
        this.mPutObjectRequest.getInputStream();
        String srcPath = this.mPutObjectRequest.getSrcPath();
        Uri uri = this.mPutObjectRequest.getUri();
        this.mPutObjectRequest.getUrl();
        String strData = this.mPutObjectRequest.getStrData();
        this.mPutObjectRequest.getUrlUploadPolicy();
        if (TextUtils.isEmpty(srcPath) && uri == null && data == null && strData == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "Only support upload file path, uri, bytes array and string");
        }
        if (!TextUtils.isEmpty(srcPath)) {
            File file = new File(srcPath);
            if (!file.exists()) {
                int code = ClientErrorCode.INVALID_ARGUMENT.getCode();
                throw new CosXmlClientException(code, srcPath + " is not exist.");
            } else if (file.isDirectory()) {
                int code2 = ClientErrorCode.INVALID_ARGUMENT.getCode();
                throw new CosXmlClientException(code2, srcPath + " is directory.");
            } else if (!file.canRead()) {
                int code3 = ClientErrorCode.INVALID_ARGUMENT.getCode();
                throw new CosXmlClientException(code3, " read " + srcPath + " failed, please check permission to read this file.");
            } else {
                this.uploadLength = file.length();
            }
        } else if (uri != null) {
            Context appContext = ContextHolder.getAppContext();
            if (appContext != null) {
                if (!QCloudUtils.doesUriFileExist(uri, appContext.getContentResolver())) {
                    int code4 = ClientErrorCode.INVALID_ARGUMENT.getCode();
                    throw new CosXmlClientException(code4, "uri " + uri + " is not exist");
                }
                this.uploadLength = QCloudUtils.getUriContentLength2(uri, appContext.getContentResolver());
            }
        } else if (data != null) {
            this.uploadLength = data.length;
        } else if (strData != null) {
            this.uploadLength = strData.getBytes().length;
        }
        loggerInfo(TAG, this.taskId, "checkout upload length=%d", Long.valueOf(this.uploadLength));
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    protected CosXmlResult execute() throws Exception {
        if (shouldMultipartUpload()) {
            loggerInfo(TAG, this.taskId, "start upload with multipart upload", new Object[0]);
            MultipartUploadTask multipartUploadTask = new MultipartUploadTask(this.cosDirect, this.mPutObjectRequest, this.mTransferTaskCts, getUploadLength());
            multipartUploadTask.mMaxPartSize = this.mMaxPartSize;
            multipartUploadTask.verifyCRC64 = this.verifyCRC64;
            this.uploadTask = multipartUploadTask;
        } else {
            loggerInfo(TAG, this.taskId, "start upload with simple upload.", this.key);
            this.uploadTask = new SimpleUploadTask(this.cosDirect, this.mPutObjectRequest, this.mTransferTaskCts, getUploadLength());
        }
        this.uploadTask.mTransferMetrics = this.transferTaskMetrics;
        this.uploadTask.taskId = this.taskId;
        CosXmlResult upload = this.uploadTask.upload(this.mPutObjectRequest);
        PutObjectResult putObjectResult = upload;
        if (upload instanceof CompleteMultiUploadResult) {
            putObjectResult = buildPutObjectResult((CompleteMultiUploadResult) upload);
        }
        return putObjectResult;
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    protected Executor executor() {
        return uploadTaskExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceSimpleUpload(boolean z) {
        this.mForceSimpleUpload = z;
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    public void pause() {
        super.pause();
        BaseUploadTask baseUploadTask = this.uploadTask;
        if (baseUploadTask != null) {
            baseUploadTask.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPartSize(long j) {
        this.mMaxPartSize = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSliceSizeThreshold(long j) {
        this.multipartUploadThreshold = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerifyCRC64(boolean z) {
        this.verifyCRC64 = z;
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    protected String tag() {
        return TAG;
    }
}
