package com.tencent.cos.xml.transfer;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.utils.COSUtils;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.cos.xml.utils.FileUtils;
import com.tencent.qcloud.core.common.QCloudTaskStateListener;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.io.File;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLDownloadTask.class */
public final class COSXMLDownloadTask extends COSXMLTask {
    private static final String TAG = COSXMLUploadTask.class.getSimpleName();
    private long downloadComplete;
    private String eTag;
    private long fileOffset;
    private GetObjectRequest getObjectRequest;
    private long hasWriteDataLen;
    private HeadObjectRequest headObjectRequest;
    private String localSaveDirPath;
    private String localSaveFileName;
    private long rangeEnd;
    private long rangeStart;
    private SharedPreferences sharedPreferences;
    private long startTime;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLDownloadTask$COSXMLDownloadTaskRequest.class */
    public static class COSXMLDownloadTaskRequest extends GetObjectRequest {
        protected COSXMLDownloadTaskRequest(String str, String str2, String str3, String str4, String str5, Map<String, List<String>> map, Map<String, String> map2) {
            super(str2, str3, str4, str5);
            setRegion(str);
            setRequestHeaders(map);
            setQueryParameters(map2);
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLDownloadTask$COSXMLDownloadTaskResult.class */
    public static class COSXMLDownloadTaskResult extends CosXmlResult {
        public String eTag;

        protected COSXMLDownloadTaskResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLDownloadTask(Context context, CosXmlSimpleService cosXmlSimpleService, GetObjectRequest getObjectRequest) {
        this(context, cosXmlSimpleService, getObjectRequest.getRegion(), getObjectRequest.getBucket(), getObjectRequest.getPath(cosXmlSimpleService.getConfig()), getObjectRequest.getSavePath(), getObjectRequest.getSaveFileName());
        this.queries = getObjectRequest.getQueryString();
        this.headers = getObjectRequest.getRequestHeaders();
        this.isNeedMd5 = getObjectRequest.isNeedMD5();
        if (this.headers != null && this.headers.containsKey("Range")) {
            String str = this.headers.get("Range").get(0);
            int indexOf = str.indexOf("=");
            int indexOf2 = str.indexOf("-");
            this.rangeStart = Long.valueOf(str.substring(indexOf + 1, indexOf2)).longValue();
            String substring = str.substring(indexOf2 + 1);
            if (!TextUtils.isEmpty(substring)) {
                this.rangeEnd = Long.valueOf(substring).longValue();
            }
        }
        this.fileOffset = getObjectRequest.getFileOffset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSXMLDownloadTask(Context context, CosXmlSimpleService cosXmlSimpleService, String str, String str2, String str3, String str4, String str5) {
        this.rangeStart = 0L;
        this.rangeEnd = -1L;
        this.fileOffset = 0L;
        this.hasWriteDataLen = 0L;
        this.startTime = 0L;
        this.region = str;
        this.bucket = str2;
        this.cosPath = str3;
        this.localSaveDirPath = str4;
        this.localSaveFileName = str5;
        this.cosXmlService = cosXmlSimpleService;
        if (context != null) {
            this.sharedPreferences = context.getSharedPreferences("COSXMLDOWNLOADTASK", 0);
        }
    }

    private void cancelAllRequest() {
        this.cosXmlService.cancel(this.headObjectRequest);
        this.cosXmlService.cancel(this.getObjectRequest);
    }

    private void clear() {
        synchronized (this) {
            if (this.sharedPreferences != null) {
                this.sharedPreferences.edit().remove(getKey()).commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDownloadPath() {
        String str;
        String str2;
        int lastIndexOf;
        String str3 = this.localSaveDirPath;
        if (str3 != null) {
            if (str3.endsWith(BridgeUtil.SPLIT_MARK)) {
                str2 = this.localSaveDirPath;
            } else {
                str2 = this.localSaveDirPath + BridgeUtil.SPLIT_MARK;
            }
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (this.localSaveFileName != null) {
                return str2 + this.localSaveFileName;
            }
            str = str2;
            if (this.cosPath != null) {
                if (this.cosPath.lastIndexOf(BridgeUtil.SPLIT_MARK) >= 0) {
                    return str2 + this.cosPath.substring(lastIndexOf + 1);
                }
                return str2 + this.cosPath;
            }
        } else {
            str = null;
        }
        return str;
    }

    private String getKey() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("download");
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.region);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.bucket);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.cosPath);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.rangeStart);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.rangeEnd);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.fileOffset);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.localSaveDirPath);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.localSaveFileName);
        stringBuffer.append(BridgeUtil.UNDERLINE_STR);
        stringBuffer.append(this.eTag);
        try {
            return DigestUtils.getSha1(stringBuffer.toString());
        } catch (CosXmlClientException e) {
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String hasExisted() {
        synchronized (this) {
            if (this.sharedPreferences != null) {
                return this.sharedPreferences.getString(getKey(), null);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDownload(long j, long j2, long j3) {
        GetObjectRequest getObjectRequest = new GetObjectRequest(this.bucket, this.cosPath, this.localSaveDirPath, this.localSaveFileName);
        this.getObjectRequest = getObjectRequest;
        getObjectRequest.setRegion(this.region);
        this.getObjectRequest.setFileOffset(j3);
        this.getObjectRequest.setQueryParameters(this.queries);
        this.getObjectRequest.setRequestHeaders(this.headers);
        if (j2 > 0 || j > 0) {
            this.getObjectRequest.setRange(j, j2);
        }
        if (this.onSignatureListener != null) {
            this.getObjectRequest.setSign(this.onSignatureListener.onGetSign(this.getObjectRequest));
        }
        getHttpMetrics(this.getObjectRequest, BeaconService.EVENT_PARAMS_NODE_GET);
        this.getObjectRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.COSXMLDownloadTask.1
            @Override // com.tencent.qcloud.core.common.QCloudProgressListener
            public void onProgress(long j4, long j5) {
                COSXMLDownloadTask.this.downloadComplete = j4;
                if (COSXMLDownloadTask.this.cosXmlProgressListener != null) {
                    COSXMLDownloadTask.this.cosXmlProgressListener.onProgress(COSXMLDownloadTask.this.hasWriteDataLen + j4, COSXMLDownloadTask.this.hasWriteDataLen + j5);
                }
            }
        });
        this.cosXmlService.getObjectAsync(this.getObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLDownloadTask.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest != COSXMLDownloadTask.this.getObjectRequest) {
                    return;
                }
                if (cosXmlClientException == null || COSXMLDownloadTask.this.taskState == TransferState.PAUSED || COSXMLDownloadTask.this.taskState == TransferState.CANCELED) {
                    cosXmlClientException = null;
                } else {
                    BeaconService.getInstance().reportDownloadTaskClientException(cosXmlRequest, cosXmlClientException);
                }
                if (cosXmlServiceException != 0 && COSXMLDownloadTask.this.taskState != TransferState.PAUSED && COSXMLDownloadTask.this.taskState != TransferState.CANCELED) {
                    BeaconService.getInstance().reportDownloadTaskServiceException(cosXmlRequest, cosXmlServiceException);
                    cosXmlClientException = cosXmlServiceException;
                }
                if (COSXMLDownloadTask.this.IS_EXIT.get()) {
                    return;
                }
                COSXMLDownloadTask.this.IS_EXIT.set(true);
                COSXMLDownloadTask.this.updateState(TransferState.FAILED, cosXmlClientException, null, false);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest != COSXMLDownloadTask.this.getObjectRequest) {
                    return;
                }
                BeaconService.getInstance().reportDownloadTaskSuccess(COSXMLDownloadTask.this.getObjectRequest);
                if (COSXMLDownloadTask.this.IS_EXIT.get()) {
                    return;
                }
                COSXMLDownloadTask.this.IS_EXIT.set(true);
                COSXMLDownloadTask.this.updateState(TransferState.COMPLETED, null, cosXmlResult, false);
            }
        });
    }

    private String removeIfExist() {
        synchronized (this) {
            if (this.sharedPreferences != null) {
                String string = this.sharedPreferences.getString(getKey(), null);
                if (string == null) {
                    FileUtils.deleteFileIfExist(getDownloadPath());
                }
                return string;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(String str) {
        synchronized (this) {
            if (this.sharedPreferences != null) {
                this.sharedPreferences.edit().putString(getKey(), str).commit();
            }
        }
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected CosXmlRequest buildCOSXMLTaskRequest() {
        return new COSXMLDownloadTaskRequest(this.region, this.bucket, this.cosPath, this.localSaveDirPath, this.localSaveFileName, this.headers, this.queries);
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected CosXmlResult buildCOSXMLTaskResult(CosXmlResult cosXmlResult) {
        COSXMLDownloadTaskResult cOSXMLDownloadTaskResult = new COSXMLDownloadTaskResult();
        if (cosXmlResult != null) {
            cOSXMLDownloadTaskResult.httpCode = cosXmlResult.httpCode;
            cOSXMLDownloadTaskResult.httpMessage = cosXmlResult.httpMessage;
            cOSXMLDownloadTaskResult.headers = cosXmlResult.headers;
            cOSXMLDownloadTaskResult.eTag = this.eTag;
            cOSXMLDownloadTaskResult.accessUrl = cosXmlResult.accessUrl;
        }
        return cOSXMLDownloadTaskResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void download() {
        this.startTime = System.nanoTime();
        run();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void encounterError(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        if (this.IS_EXIT.get()) {
            return;
        }
        this.IS_EXIT.set(true);
        updateState(TransferState.FAILED, COSUtils.mergeException(cosXmlClientException, cosXmlServiceException), null, false);
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalCancel() {
        cancelAllRequest();
        clear();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalCompleted() {
        clear();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalFailed() {
        cancelAllRequest();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalPause() {
        if (this.getObjectRequest != null) {
            BeaconService.getInstance().reportDownloadTaskSuccess(this.getObjectRequest);
        }
        cancelAllRequest();
    }

    @Override // com.tencent.cos.xml.transfer.COSXMLTask
    protected void internalResume() {
        this.taskState = TransferState.WAITING;
        this.IS_EXIT.set(false);
        download();
    }

    protected void run() {
        HeadObjectRequest headObjectRequest = new HeadObjectRequest(this.bucket, this.cosPath);
        this.headObjectRequest = headObjectRequest;
        headObjectRequest.setRequestHeaders(this.headers);
        this.headObjectRequest.setQueryParameters(this.queries);
        this.headObjectRequest.setRegion(this.region);
        final String downloadPath = getDownloadPath();
        if (this.onSignatureListener != null) {
            this.headObjectRequest.setSign(this.onSignatureListener.onGetSign(this.headObjectRequest));
        }
        getHttpMetrics(this.headObjectRequest, BeaconService.EVENT_PARAMS_NODE_HEAD);
        this.headObjectRequest.setTaskStateListener(new QCloudTaskStateListener() { // from class: com.tencent.cos.xml.transfer.COSXMLDownloadTask.3
            @Override // com.tencent.qcloud.core.common.QCloudTaskStateListener
            public void onStateChanged(String str, int i) {
                if (COSXMLDownloadTask.this.IS_EXIT.get() || i == 1) {
                    return;
                }
                COSXMLDownloadTask.this.updateState(TransferState.IN_PROGRESS, null, null, false);
            }
        });
        this.cosXmlService.headObjectAsync(this.headObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.COSXMLDownloadTask.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlRequest == COSXMLDownloadTask.this.headObjectRequest && !COSXMLDownloadTask.this.IS_EXIT.get()) {
                    CosXmlClientException cosXmlClientException2 = cosXmlClientException;
                    if (cosXmlClientException == null) {
                        cosXmlClientException2 = cosXmlServiceException;
                    }
                    cosXmlClientException2.printStackTrace();
                    COSXMLDownloadTask.this.updateState(TransferState.FAILED, cosXmlClientException2, null, false);
                    String str = COSXMLDownloadTask.TAG;
                    QCloudLogger.i(str, "head " + COSXMLDownloadTask.this.cosPath + "failed !, exception is " + cosXmlClientException2.getMessage(), new Object[0]);
                    FileUtils.deleteFileIfExist(downloadPath);
                    COSXMLDownloadTask.this.hasWriteDataLen = 0L;
                    COSXMLDownloadTask cOSXMLDownloadTask = COSXMLDownloadTask.this;
                    cOSXMLDownloadTask.realDownload(cOSXMLDownloadTask.rangeStart, COSXMLDownloadTask.this.rangeEnd, COSXMLDownloadTask.this.fileOffset);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                if (cosXmlRequest == COSXMLDownloadTask.this.headObjectRequest && !COSXMLDownloadTask.this.IS_EXIT.get()) {
                    List<String> list = cosXmlResult.headers.get("ETag");
                    if (list != null && list.size() > 0) {
                        COSXMLDownloadTask.this.eTag = list.get(0);
                    }
                    String hasExisted = COSXMLDownloadTask.this.hasExisted();
                    if (hasExisted != null) {
                        File file = new File(hasExisted);
                        if (file.exists()) {
                            long length = file.length();
                            List<String> list2 = cosXmlResult.headers.get("Content-Length");
                            if (list2 == null || list2.size() <= 0 || Long.valueOf(list2.get(0)).longValue() != length) {
                                COSXMLDownloadTask cOSXMLDownloadTask = COSXMLDownloadTask.this;
                                cOSXMLDownloadTask.hasWriteDataLen = length - cOSXMLDownloadTask.fileOffset;
                                COSXMLDownloadTask cOSXMLDownloadTask2 = COSXMLDownloadTask.this;
                                cOSXMLDownloadTask2.realDownload(cOSXMLDownloadTask2.rangeStart + COSXMLDownloadTask.this.hasWriteDataLen, COSXMLDownloadTask.this.rangeEnd, COSXMLDownloadTask.this.fileOffset + COSXMLDownloadTask.this.hasWriteDataLen);
                                return;
                            }
                            if (COSXMLDownloadTask.this.cosXmlProgressListener != null) {
                                COSXMLDownloadTask.this.cosXmlProgressListener.onProgress(length, length);
                            }
                            COSXMLDownloadTask.this.IS_EXIT.set(true);
                            COSXMLDownloadTask.this.updateState(TransferState.COMPLETED, null, cosXmlResult, false);
                            return;
                        }
                    }
                    FileUtils.deleteFileIfExist(downloadPath);
                    COSXMLDownloadTask cOSXMLDownloadTask3 = COSXMLDownloadTask.this;
                    cOSXMLDownloadTask3.save(cOSXMLDownloadTask3.getDownloadPath());
                    COSXMLDownloadTask.this.hasWriteDataLen = 0L;
                    COSXMLDownloadTask cOSXMLDownloadTask4 = COSXMLDownloadTask.this;
                    cOSXMLDownloadTask4.realDownload(cOSXMLDownloadTask4.rangeStart, COSXMLDownloadTask.this.rangeEnd, COSXMLDownloadTask.this.fileOffset);
                }
            }
        });
    }
}
