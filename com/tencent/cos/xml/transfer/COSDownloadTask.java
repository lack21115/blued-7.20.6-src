package com.tencent.cos.xml.transfer;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bolts.CancellationTokenSource;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.anythink.expressad.foundation.g.b.b;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.crypto.COSDirect;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.transfer.COSTransferTask;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.cos.xml.utils.FileUtils;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.util.ContextHolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSDownloadTask.class */
public class COSDownloadTask extends COSTransferTask {
    private static final int DOWNLOAD_CONCURRENT = 3;
    private static final String TAG = "QCloudDownload";
    private static ThreadPoolExecutor downloadTaskExecutor = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(Integer.MAX_VALUE), new COSTransferTask.TaskThreadFactory("QCloudDownload-", 8));
    private volatile GetObjectRequest mGetObjectRequest;
    private SimpleDownloadTask simpleDownloadTask;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSDownloadTask$DownloadRecord.class */
    public static class DownloadRecord {
        String crc64ecma;
        List<DownloadedBlock> downloadedBlocks;
        String eTag;
        String lastModified;
        long remoteEnd;
        long remoteStart;

        public DownloadRecord(String str, String str2, String str3, long j, long j2, List<DownloadedBlock> list) {
            this.lastModified = str;
            this.eTag = str2;
            this.crc64ecma = str3;
            this.downloadedBlocks = list;
            this.remoteStart = j;
            this.remoteEnd = j2;
        }

        public static String flatJson(DownloadRecord downloadRecord) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lastModified", downloadRecord.lastModified);
            jSONObject.put(DBDefinition.ETAG, downloadRecord.eTag);
            jSONObject.put("crc64ecma", downloadRecord.crc64ecma);
            jSONObject.put("remoteStart", downloadRecord.remoteStart);
            jSONObject.put("remoteEnd", downloadRecord.remoteEnd);
            JSONArray jSONArray = new JSONArray();
            for (DownloadedBlock downloadedBlock : downloadRecord.downloadedBlocks) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("from", downloadedBlock.from);
                jSONObject2.put("to", downloadedBlock.to);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("downloadedBlocks", jSONArray);
            return jSONObject.toString();
        }

        public static DownloadRecord toJson(String str) throws JSONException {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("lastModified");
            String string2 = jSONObject.getString(DBDefinition.ETAG);
            String optString = jSONObject.optString("crc64ecma");
            String string3 = jSONObject.getString("remoteStart");
            String string4 = jSONObject.getString("remoteEnd");
            JSONArray jSONArray = jSONObject.getJSONArray("downloadedBlocks");
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return new DownloadRecord(string, string2, optString, Long.parseLong(string3), Long.parseLong(string4), linkedList);
                }
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                linkedList.add(new DownloadedBlock(Long.parseLong(jSONObject2.getString("from")), Long.parseLong(jSONObject2.getString("to"))));
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSDownloadTask$DownloadedBlock.class */
    public static class DownloadedBlock {
        long from;
        long to;

        public DownloadedBlock(long j, long j2) {
            this.from = j;
            this.to = j2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSDownloadTask$SimpleDownloadTask.class */
    public static class SimpleDownloadTask implements Runnable {
        private String bucket;
        private COSDirect cosDirect;
        private String crc64ecma;
        private String eTag;
        private volatile GetObjectRequest getObjectRequest;
        private volatile HeadObjectRequest headObjectRequest;
        private String key;
        private String lastModified;
        private TransferTaskMetrics mTransferMetrics;
        private CancellationTokenSource mTransferTaskCts;
        private String region;
        private SharedPreferences sharedPreferences;
        private String taskId;
        private long remoteStart = 0;
        private long remoteEnd = -1;
        private TaskCompletionSource<GetObjectResult> tcs = new TaskCompletionSource<>();

        public SimpleDownloadTask(COSDirect cOSDirect, GetObjectRequest getObjectRequest, CancellationTokenSource cancellationTokenSource) {
            this.cosDirect = cOSDirect;
            this.getObjectRequest = getObjectRequest;
            this.mTransferTaskCts = cancellationTokenSource;
        }

        private void checkCRC64(String str, File file, long j, long j2) throws CosXmlClientException {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                long crc64 = DigestUtils.getCRC64(new FileInputStream(file), j, j2);
                long bigIntFromString = DigestUtils.getBigIntFromString(str);
                if (crc64 == bigIntFromString) {
                    COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "check offset=%d, size=%d, crc64=%s success", Long.valueOf(j), Long.valueOf(j2), str);
                    return;
                }
                throw CosXmlClientException.internalException("verify CRC64 failed, local crc64: " + crc64 + ", remote crc64: " + bigIntFromString);
            } catch (FileNotFoundException e) {
                throw CosXmlClientException.internalException("verify CRC64 failed: " + e.getMessage());
            }
        }

        private void checkMd5(String str, File file) throws CosXmlClientException {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String md5 = DigestUtils.getMD5(file.getAbsolutePath());
            String replaceAll = str.replaceAll("\"", "");
            if (md5.equals(replaceAll)) {
                COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "check md5=%s success", replaceAll);
                return;
            }
            throw CosXmlClientException.internalException("verify MD5 failed, local MD5: " + md5 + ", remote MD5: " + replaceAll);
        }

        private void checking() throws CosXmlClientException, CosXmlServiceException {
            Range range = this.getObjectRequest.getRange();
            if (range != null) {
                this.remoteStart = range.getStart();
                this.remoteEnd = range.getEnd();
            } else {
                this.remoteStart = 0L;
                this.remoteEnd = -1L;
            }
            Context appContext = ContextHolder.getAppContext();
            if (appContext == null) {
                throw CosXmlClientException.internalException(b.f7836a);
            }
            this.sharedPreferences = appContext.getSharedPreferences(COSDownloadTask.TAG, 0);
            this.headObjectRequest = new HeadObjectRequest(this.bucket, this.key);
            HttpTaskMetrics httpTaskMetrics = new HttpTaskMetrics();
            this.headObjectRequest.attachMetrics(httpTaskMetrics);
            this.headObjectRequest.setRegion(this.region);
            this.headObjectRequest.setRequestHeaders(getHeadHeaders(this.getObjectRequest));
            HeadObjectResult headObject = this.cosDirect.headObject(this.headObjectRequest);
            this.mTransferMetrics.connectAddress = httpTaskMetrics.getConnectAddress();
            this.lastModified = headObject.getHeader("Last-Modified");
            this.eTag = headObject.getHeader("ETag");
            this.crc64ecma = headObject.getHeader(Headers.COS_HASH_CRC64_ECMA);
            COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "start download to %s", this.getObjectRequest.getDownloadPath());
            COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "checkout remoteStart=%d, remoteEnd=%d, crc64ecma=%s", Long.valueOf(this.remoteStart), Long.valueOf(this.remoteEnd), this.crc64ecma);
        }

        private void checkoutManualCanceled() throws CosXmlClientException {
            if (this.mTransferTaskCts.a()) {
                throw CosXmlClientException.manualCancelException();
            }
        }

        private GetObjectResult download() throws CosXmlClientException, CosXmlServiceException {
            try {
                this.sharedPreferences.edit().putString(this.key, DownloadRecord.flatJson(new DownloadRecord(this.lastModified, this.eTag, this.crc64ecma, this.remoteStart, this.remoteEnd, new LinkedList()))).apply();
            } catch (JSONException e) {
                COSTransferTask.loggerWarn(COSDownloadTask.TAG, this.taskId, "save DownloadRecord failed: %s", e.getMessage());
            }
            Range range = this.getObjectRequest.getRange();
            COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "start download [%d,%d] with fileOffset=%d", Long.valueOf(range != null ? range.getStart() : 0L), Long.valueOf(range != null ? range.getEnd() : -1L), Long.valueOf(this.getObjectRequest.getFileOffset()));
            GetObjectResult object = this.cosDirect.getObject(this.getObjectRequest);
            this.sharedPreferences.edit().remove(this.key).apply();
            COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "download complete", new Object[0]);
            return object;
        }

        private Map<String, List<String>> getHeadHeaders(GetObjectRequest getObjectRequest) {
            Map<String, List<String>> requestHeaders = getObjectRequest.getRequestHeaders();
            return requestHeaders == null ? new HashMap() : new HashMap(requestHeaders);
        }

        private boolean hasDownloadPart() throws CosXmlClientException {
            String string = this.sharedPreferences.getString(this.key, "");
            if (TextUtils.isEmpty(string)) {
                COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "not find DownloadRecord", new Object[0]);
                return false;
            }
            COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "find DownloadRecord: %s", string);
            try {
                DownloadRecord json = DownloadRecord.toJson(string);
                if (json.lastModified != null && json.lastModified.equals(this.lastModified) && json.eTag != null && json.eTag.equals(this.eTag) && ((json.crc64ecma == null || this.crc64ecma == null || json.crc64ecma.equals(this.crc64ecma)) && json.remoteStart == this.remoteStart && json.remoteEnd == this.remoteEnd)) {
                    return true;
                }
                COSTransferTask.loggerWarn(COSDownloadTask.TAG, this.taskId, "verify DownloadRecord failed: lastModified:%s, eTag:%s, crc64ecma:%s, remoteStart:%d, remoteEnd:%d", this.lastModified, this.eTag, this.crc64ecma, Long.valueOf(this.remoteStart), Long.valueOf(this.remoteEnd));
                return false;
            } catch (JSONException e) {
                COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "parse DownloadRecord failed: %s", e.getMessage());
                return false;
            }
        }

        private boolean isRangeDownload() {
            return (this.remoteStart == 0 && this.remoteEnd == -1) ? false : true;
        }

        private void prepareDownloadContext(boolean z) {
            File file = new File(this.getObjectRequest.getDownloadPath());
            if (!z) {
                FileUtils.deleteFileIfExist(file.getAbsolutePath());
                return;
            }
            long length = file.length();
            this.getObjectRequest.setFileOffset(length);
            this.getObjectRequest.setRange(this.remoteStart + length, this.remoteEnd);
            COSTransferTask.loggerInfo(COSDownloadTask.TAG, this.taskId, "has download part %d", Long.valueOf(length));
        }

        private void verifyContent(GetObjectResult getObjectResult) throws CosXmlClientException {
            String header = getObjectResult.getHeader(Headers.COS_HASH_CRC64_ECMA);
            String header2 = getObjectResult.getHeader(Headers.UNENCRYPTED_CONTENT_MD5);
            File file = new File(this.getObjectRequest.getDownloadPath());
            this.mTransferMetrics.size = file.length() - this.getObjectRequest.getFileOffset();
            if (isRangeDownload()) {
                checkCRC64(header, file, this.getObjectRequest.getFileOffset(), file.length() - this.getObjectRequest.getFileOffset());
            } else if (this.cosDirect.isTransferSecurely()) {
                checkMd5(header2, file);
            } else {
                checkCRC64(header, file, 0L, -1L);
            }
        }

        public void cancel() {
            if (this.headObjectRequest != null) {
                this.cosDirect.cancel(this.headObjectRequest);
            }
            if (this.getObjectRequest != null) {
                this.cosDirect.cancel(this.getObjectRequest);
            }
        }

        public Task<GetObjectResult> getTask() {
            return this.tcs.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                checkoutManualCanceled();
                checking();
                checkoutManualCanceled();
                boolean hasDownloadPart = hasDownloadPart();
                checkoutManualCanceled();
                prepareDownloadContext(hasDownloadPart && !this.cosDirect.isTransferSecurely());
                checkoutManualCanceled();
                GetObjectResult download = download();
                checkoutManualCanceled();
                try {
                    verifyContent(download);
                    this.tcs.setResult(download);
                } catch (CosXmlClientException e) {
                    FileUtils.deleteFileIfExist(this.getObjectRequest.getDownloadPath());
                    throw e;
                }
            } catch (Exception e2) {
                this.tcs.b(e2);
            }
        }

        public void setTaskId(String str) {
            this.taskId = str;
        }
    }

    public COSDownloadTask(COSDirect cOSDirect, GetObjectRequest getObjectRequest) {
        super(cOSDirect, getObjectRequest);
        this.mGetObjectRequest = getObjectRequest;
    }

    private GetObjectResult multipartDownload() throws CosXmlClientException, CosXmlServiceException {
        return null;
    }

    private GetObjectResult simpleDownload() throws Exception {
        SimpleDownloadTask simpleDownloadTask = new SimpleDownloadTask(this.cosDirect, this.mGetObjectRequest, this.mTransferTaskCts);
        this.simpleDownloadTask = simpleDownloadTask;
        simpleDownloadTask.bucket = this.bucket;
        this.simpleDownloadTask.key = this.key;
        this.simpleDownloadTask.region = this.region;
        this.simpleDownloadTask.taskId = this.taskId;
        this.simpleDownloadTask.mTransferMetrics = this.transferTaskMetrics;
        this.mGetObjectRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.COSDownloadTask.1
            @Override // com.tencent.qcloud.core.common.QCloudProgressListener
            public void onProgress(long j, long j2) {
                long fileOffset = COSDownloadTask.this.mGetObjectRequest.getFileOffset();
                COSDownloadTask.this.onTransferProgressChange(j + fileOffset, j2 + fileOffset);
            }
        });
        this.simpleDownloadTask.run();
        Task<GetObjectResult> task = this.simpleDownloadTask.getTask();
        if (task.d()) {
            throw task.f();
        }
        if (task.b()) {
            return task.e();
        }
        throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), "simple download complete without result");
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    public void cancel() {
        super.cancel();
        SimpleDownloadTask simpleDownloadTask = this.simpleDownloadTask;
        if (simpleDownloadTask != null) {
            simpleDownloadTask.cancel();
        }
        FileUtils.deleteFileIfExist(this.mGetObjectRequest.getDownloadPath());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    public void checking() throws CosXmlClientException {
        super.checking();
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    protected CosXmlResult execute() throws Exception {
        return simpleDownload();
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    protected Executor executor() {
        return downloadTaskExecutor;
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    public void pause() {
        super.pause();
        SimpleDownloadTask simpleDownloadTask = this.simpleDownloadTask;
        if (simpleDownloadTask != null) {
            simpleDownloadTask.cancel();
        }
    }

    @Override // com.tencent.cos.xml.transfer.COSTransferTask
    protected String tag() {
        return TAG;
    }
}
