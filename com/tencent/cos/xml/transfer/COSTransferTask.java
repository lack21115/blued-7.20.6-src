package com.tencent.cos.xml.transfer;

import android.text.TextUtils;
import bolts.CancellationTokenSource;
import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.COSDirect;
import com.tencent.cos.xml.crypto.CryptoModuleBase;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.ObjectRequest;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSTransferTask.class */
public abstract class COSTransferTask {
    private final String TAG;
    protected String bucket;
    protected CosXmlClientException clientException;
    protected COSDirect cosDirect;
    protected CosXmlProgressListener cosXmlProgressListener;
    protected CosXmlRequest cosXmlRequest;
    protected CosXmlResult cosXmlResult;
    protected CosXmlResultListener cosXmlResultListener;
    protected CosXmlServiceConfig cosXmlServiceConfig;
    protected CryptoModuleBase cryptoModuleBase;
    protected String key;
    protected volatile CancellationTokenSource mTransferTaskCts;
    protected String region;
    protected CosXmlServiceException serviceException;
    protected TransferStateListener transferStateListener;
    protected volatile TransferTaskMetrics transferTaskMetrics;
    volatile TransferState taskState = TransferState.WAITING;
    protected volatile boolean manualPause = false;
    protected volatile boolean manualCancel = false;
    protected volatile String taskId = UUID.randomUUID().toString();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSTransferTask$TaskThreadFactory.class */
    public static final class TaskThreadFactory implements ThreadFactory {
        private final AtomicInteger increment = new AtomicInteger(1);
        private final int priority;
        private final String tag;

        /* JADX INFO: Access modifiers changed from: package-private */
        public TaskThreadFactory(String str, int i) {
            this.tag = str;
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.tag + this.increment.getAndIncrement());
            thread.setDaemon(false);
            thread.setPriority(this.priority);
            return thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSTransferTask$TransferRunnable.class */
    public class TransferRunnable implements Runnable {
        private TransferRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                COSTransferTask.this.onTransferInProgress();
                COSTransferTask.this.checking();
                COSTransferTask.this.cosXmlResult = COSTransferTask.this.execute();
                COSTransferTask.this.onTransferSuccess(COSTransferTask.this.cosXmlRequest, COSTransferTask.this.cosXmlResult);
            } catch (CosXmlClientException e) {
                if (COSTransferTask.this.isManualPaused() || COSTransferTask.this.isManualCanceled()) {
                    return;
                }
                COSTransferTask cOSTransferTask = COSTransferTask.this;
                cOSTransferTask.onTransferFailed(cOSTransferTask.cosXmlRequest, e, null);
            } catch (CosXmlServiceException e2) {
                if (COSTransferTask.this.isManualPaused() || COSTransferTask.this.isManualCanceled()) {
                    return;
                }
                COSTransferTask cOSTransferTask2 = COSTransferTask.this;
                cOSTransferTask2.onTransferFailed(cOSTransferTask2.cosXmlRequest, null, e2);
            } catch (Exception e3) {
                if (COSTransferTask.this.isManualPaused() || COSTransferTask.this.isManualCanceled()) {
                    return;
                }
                COSTransferTask cOSTransferTask3 = COSTransferTask.this;
                cOSTransferTask3.onTransferFailed(cOSTransferTask3.cosXmlRequest, new CosXmlClientException(ClientErrorCode.UNKNOWN.getCode(), e3.getMessage()), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSTransferTask(COSDirect cOSDirect, ObjectRequest objectRequest) {
        this.cosXmlServiceConfig = cOSDirect.getCosService().getConfig();
        this.cosXmlRequest = objectRequest;
        this.cosDirect = cOSDirect;
        this.bucket = objectRequest.getBucket();
        String region = objectRequest.getRegion();
        this.region = region;
        if (TextUtils.isEmpty(region)) {
            String region2 = this.cosXmlServiceConfig.getRegion();
            this.region = region2;
            objectRequest.setRegion(region2);
        }
        this.key = objectRequest.getCosPath();
        this.TAG = tag();
        if (cOSDirect.isTransferSecurely()) {
            loggerInfo(this.TAG, this.taskId, "encrypted transmission enabled", new Object[0]);
        }
        loggerInfo(this.TAG, this.taskId, "create a %s task, region: %s, bucket: %s, key: %s", objectRequest.getClass().getSimpleName(), this.region, this.bucket, this.key);
    }

    private static Object[] compose(String str, Object... objArr) {
        Object[] objArr2 = new Object[objArr.length + 1];
        objArr2[0] = str;
        System.arraycopy(objArr, 0, objArr2, 1, objArr.length);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void loggerInfo(String str, String str2, String str3, Object... objArr) {
        QCloudLogger.i(str, "[%s]: " + str3, compose(str2, objArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void loggerWarn(String str, String str2, String str3, Object... objArr) {
        QCloudLogger.w(str, "[%s]: " + str3, compose(str2, objArr));
    }

    private void notifyTransferProgressChange(long j, long j2) {
        if (this.cosXmlProgressListener == null || this.taskState != TransferState.IN_PROGRESS) {
            return;
        }
        this.cosXmlProgressListener.onProgress(j, j2);
    }

    private void notifyTransferResultFailed(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        if (cosXmlServiceException != null && TextUtils.isEmpty(cosXmlServiceException.getErrorCode())) {
            cosXmlServiceException.setErrorCode(cosXmlServiceException.getHttpMessage());
        }
        CosXmlResultListener cosXmlResultListener = this.cosXmlResultListener;
        if (cosXmlResultListener != null) {
            cosXmlResultListener.onFail(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
        }
    }

    private void notifyTransferResultSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
        CosXmlResultListener cosXmlResultListener = this.cosXmlResultListener;
        if (cosXmlResultListener != null) {
            cosXmlResultListener.onSuccess(cosXmlRequest, cosXmlResult);
        }
    }

    private void notifyTransferStateChange() {
        TransferStateListener transferStateListener = this.transferStateListener;
        if (transferStateListener != null) {
            transferStateListener.onStateChanged(this.taskState);
        }
    }

    private void throwException() throws CosXmlClientException, CosXmlServiceException {
        throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR);
    }

    public void cancel() {
        loggerInfo(this.TAG, this.taskId, "cancel upload task", new Object[0]);
        this.manualCancel = true;
        onTransferFailed(this.cosXmlRequest, CosXmlClientException.manualCancelException(), null);
        if (this.mTransferTaskCts != null) {
            this.mTransferTaskCts.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checking() throws CosXmlClientException {
        if (TextUtils.isEmpty(this.bucket)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "bucket is null");
        }
        if (TextUtils.isEmpty(this.region)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "region is null");
        }
    }

    protected abstract CosXmlResult execute() throws Exception;

    protected abstract Executor executor();

    public CosXmlClientException getClientException() {
        return this.clientException;
    }

    public CosXmlServiceException getServiceException() {
        return this.serviceException;
    }

    public TransferState getTaskState() {
        return this.taskState;
    }

    public TransferTaskMetrics getTransferTaskMetrics() {
        return this.transferTaskMetrics;
    }

    protected boolean isManualCanceled() {
        return this.manualCancel;
    }

    protected boolean isManualPaused() {
        return this.manualPause;
    }

    protected void onTransferFailed(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
        if (cosXmlClientException != null) {
            loggerInfo(this.TAG, this.taskId, "transfer failed, clientException=%d, %s", Integer.valueOf(cosXmlClientException.errorCode), cosXmlClientException.getMessage());
        } else if (cosXmlServiceException != null) {
            loggerInfo(this.TAG, this.taskId, "transfer failed, serviceException=%s, %s", cosXmlServiceException.getErrorCode(), cosXmlServiceException.getErrorMessage());
        }
        this.clientException = cosXmlClientException;
        this.serviceException = cosXmlServiceException;
        this.transferTaskMetrics.onComplete();
        this.taskState = TransferState.FAILED;
        notifyTransferStateChange();
        notifyTransferResultFailed(cosXmlRequest, cosXmlClientException, cosXmlServiceException);
        if (cosXmlClientException != null) {
            BeaconService.getInstance().reportTransferClientException(cosXmlRequest, this.transferTaskMetrics, cosXmlClientException, this.cosDirect.isTransferSecurely());
        } else if (cosXmlServiceException != null) {
            BeaconService.getInstance().reportTransferServiceException(cosXmlRequest, this.transferTaskMetrics, cosXmlServiceException, this.cosDirect.isTransferSecurely());
        }
    }

    protected void onTransferInProgress() {
        this.taskState = TransferState.IN_PROGRESS;
        this.transferTaskMetrics.onInProgress();
        notifyTransferStateChange();
    }

    protected void onTransferPaused() {
        this.taskState = TransferState.PAUSED;
        this.transferTaskMetrics.onComplete();
        notifyTransferStateChange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onTransferProgressChange(long j, long j2) {
        synchronized (this) {
            this.transferTaskMetrics.onFirstProgressCallback();
            notifyTransferProgressChange(j, j2);
        }
    }

    protected void onTransferSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
        this.cosXmlResult = cosXmlResult;
        this.taskState = TransferState.COMPLETED;
        this.transferTaskMetrics.onComplete();
        notifyTransferStateChange();
        notifyTransferResultSuccess(cosXmlRequest, cosXmlResult);
        BeaconService.getInstance().reportTransferSuccess(cosXmlRequest, this.transferTaskMetrics, this.cosDirect.isTransferSecurely());
    }

    protected void onTransferWaiting() {
        this.taskState = TransferState.WAITING;
        this.transferTaskMetrics.onStart();
        notifyTransferStateChange();
    }

    public void pause() {
        if (this.taskState != TransferState.IN_PROGRESS && this.taskState != TransferState.WAITING) {
            loggerInfo(this.TAG, this.taskId, "cannot pause upload task in state %s", this.taskState);
            return;
        }
        loggerInfo(this.TAG, this.taskId, "pause upload task", new Object[0]);
        this.manualPause = true;
        onTransferPaused();
        if (this.mTransferTaskCts != null) {
            this.mTransferTaskCts.c();
        }
    }

    public void resume() {
        if (this.taskState != TransferState.PAUSED) {
            loggerInfo(this.TAG, this.taskId, "cannot resume upload task in state %s", this.taskState);
            return;
        }
        loggerInfo(this.TAG, this.taskId, "resume upload task", this.taskState);
        start();
    }

    public void setCosXmlProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.cosXmlProgressListener = cosXmlProgressListener;
    }

    public void setCosXmlResultListener(CosXmlResultListener cosXmlResultListener) {
        this.cosXmlResultListener = cosXmlResultListener;
        if (this.taskState == TransferState.COMPLETED) {
            notifyTransferResultSuccess(this.cosXmlRequest, this.cosXmlResult);
        } else if (this.taskState == TransferState.FAILED) {
            notifyTransferResultFailed(this.cosXmlRequest, this.clientException, this.serviceException);
        }
    }

    public void setTransferStateListener(TransferStateListener transferStateListener) {
        this.transferStateListener = transferStateListener;
        notifyTransferStateChange();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start() {
        this.manualPause = false;
        this.manualCancel = false;
        this.transferTaskMetrics = new TransferTaskMetrics();
        this.transferTaskMetrics.domain = this.cosXmlRequest.getRequestHost(this.cosXmlServiceConfig);
        onTransferWaiting();
        this.mTransferTaskCts = new CancellationTokenSource();
        executor().execute(new TransferRunnable());
    }

    protected abstract String tag();

    protected void throwException(Exception exc) throws CosXmlClientException, CosXmlServiceException {
        if (exc instanceof CosXmlClientException) {
            throw ((CosXmlClientException) exc);
        }
        if (exc instanceof CosXmlServiceException) {
            throw ((CosXmlServiceException) exc);
        }
        if (exc == null) {
            throw CosXmlClientException.internalException("unknown exception");
        }
        throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), exc.getMessage());
    }
}
