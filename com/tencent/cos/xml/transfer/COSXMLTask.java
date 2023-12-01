package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.BeaconService;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLTask.class */
public abstract class COSXMLTask {
    private static final String TAG = "COSXMLTask";
    protected static TaskStateMonitor monitor = TaskStateMonitor.getInstance();
    protected String bucket;
    protected String cosPath;
    protected CosXmlProgressListener cosXmlProgressListener;
    protected CosXmlResultListener cosXmlResultListener;
    protected CosXmlSimpleService cosXmlService;
    protected Map<String, List<String>> headers;
    protected CosXmlProgressListener internalProgressListener;
    protected TransferStateListener internalStateListener;
    protected Exception mException;
    protected CosXmlResult mResult;
    protected OnGetHttpTaskMetrics onGetHttpTaskMetrics;
    protected OnSignatureListener onSignatureListener;
    protected Map<String, String> queries;
    protected String region;
    protected TransferStateListener transferStateListener;
    protected Timer waitTimeoutTimer;
    protected boolean isNeedMd5 = true;
    volatile TransferState taskState = TransferState.WAITING;
    protected AtomicBoolean IS_EXIT = new AtomicBoolean(false);

    /* renamed from: com.tencent.cos.xml.transfer.COSXMLTask$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLTask$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$cos$xml$transfer$TransferState;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0065 -> B:41:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0069 -> B:37:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:49:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0071 -> B:43:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0075 -> B:39:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0079 -> B:35:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x007d -> B:47:0x0058). Please submit an issue!!! */
        static {
            int[] iArr = new int[TransferState.values().length];
            $SwitchMap$com$tencent$cos$xml$transfer$TransferState = iArr;
            try {
                iArr[TransferState.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.CANCELED.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.RESUMED_WAITING.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$TransferState[TransferState.CONSTRAINED.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLTask$COSXMLMetrics.class */
    class COSXMLMetrics extends HttpTaskMetrics {
        String requestName;

        COSXMLMetrics(String str) {
            this.requestName = str;
        }

        @Override // com.tencent.qcloud.core.http.HttpTaskMetrics
        public void onDataReady() {
            super.onDataReady();
            if (COSXMLTask.this.onGetHttpTaskMetrics != null) {
                COSXMLTask.this.onGetHttpTaskMetrics.onGetHttpMetrics(this.requestName, this);
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLTask$OnGetHttpTaskMetrics.class */
    public interface OnGetHttpTaskMetrics {
        void onGetHttpMetrics(String str, HttpTaskMetrics httpTaskMetrics);
    }

    @Deprecated
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/COSXMLTask$OnSignatureListener.class */
    public interface OnSignatureListener {
        String onGetSign(CosXmlRequest cosXmlRequest);
    }

    private void dispatchStateChange(TransferState transferState) {
        TransferStateListener transferStateListener = this.transferStateListener;
        if (transferStateListener != null) {
            transferStateListener.onStateChanged(transferState);
        }
        TransferStateListener transferStateListener2 = this.internalStateListener;
        if (transferStateListener2 != null) {
            transferStateListener2.onStateChanged(transferState);
        }
    }

    protected abstract CosXmlRequest buildCOSXMLTaskRequest();

    protected abstract CosXmlResult buildCOSXMLTaskResult(CosXmlResult cosXmlResult);

    public void cancel() {
        if (this.IS_EXIT.get()) {
            return;
        }
        this.IS_EXIT.set(true);
        monitor.sendStateMessage(this, TransferState.CANCELED, new CosXmlClientException(ClientErrorCode.USER_CANCELLED.getCode(), "canceled by user"), null, 2);
    }

    public void clearResultAndException() {
        this.mException = null;
        this.mResult = null;
    }

    void constraintSatisfied() {
        monitor.sendStateMessage(this, TransferState.RESUMED_WAITING, null, null, 5);
    }

    void constraintUnSatisfied() {
        monitor.sendStateMessage(this, TransferState.CONSTRAINED, null, null, 5);
    }

    protected abstract void encounterError(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

    public Exception getException() {
        return this.mException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getHttpMetrics(CosXmlRequest cosXmlRequest, String str) {
        cosXmlRequest.attachMetrics(new COSXMLMetrics(str));
    }

    public CosXmlResult getResult() {
        return this.mResult;
    }

    public TransferState getTaskState() {
        return this.taskState;
    }

    protected void internalCancel() {
    }

    protected void internalCompleted() {
    }

    protected void internalFailed() {
    }

    protected void internalPause() {
    }

    protected void internalResume() {
    }

    public void pause() {
        if (this.IS_EXIT.get()) {
            return;
        }
        this.IS_EXIT.set(true);
        monitor.sendStateMessage(this, TransferState.PAUSED, null, null, 2);
    }

    public void resume() {
        monitor.sendStateMessage(this, TransferState.RESUMED_WAITING, null, null, 2);
    }

    public void setCosXmlProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.cosXmlProgressListener = cosXmlProgressListener;
    }

    public void setCosXmlResultListener(CosXmlResultListener cosXmlResultListener) {
        this.cosXmlResultListener = cosXmlResultListener;
        monitor.sendStateMessage(this, null, this.mException, this.mResult, 4);
    }

    protected void setCosXmlService(CosXmlSimpleService cosXmlSimpleService) {
        this.cosXmlService = cosXmlSimpleService;
    }

    void setInternalProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.internalProgressListener = cosXmlProgressListener;
    }

    void setInternalStateListener(TransferStateListener transferStateListener) {
        this.internalStateListener = transferStateListener;
    }

    public void setOnGetHttpTaskMetrics(OnGetHttpTaskMetrics onGetHttpTaskMetrics) {
        this.onGetHttpTaskMetrics = onGetHttpTaskMetrics;
    }

    public void setOnSignatureListener(OnSignatureListener onSignatureListener) {
        this.onSignatureListener = onSignatureListener;
    }

    public void setTransferStateListener(TransferStateListener transferStateListener) {
        this.transferStateListener = transferStateListener;
        monitor.sendStateMessage(this, this.taskState, null, null, 4);
    }

    public void startTimeoutTimer(long j) {
        Timer timer = new Timer();
        this.waitTimeoutTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.tencent.cos.xml.transfer.COSXMLTask.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (COSXMLTask.this.taskState == TransferState.WAITING || COSXMLTask.this.taskState == TransferState.RESUMED_WAITING) {
                    COSXMLTask.this.encounterError(null, new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), "Task waiting timeout."), null);
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateState(TransferState transferState, Exception exc, CosXmlResult cosXmlResult, boolean z) {
        synchronized (this) {
            if (z) {
                if (exc != null) {
                    if (this.cosXmlResultListener != null) {
                        if (exc instanceof CosXmlClientException) {
                            this.cosXmlResultListener.onFail(buildCOSXMLTaskRequest(), (CosXmlClientException) exc, null);
                        } else {
                            this.cosXmlResultListener.onFail(buildCOSXMLTaskRequest(), null, (CosXmlServiceException) exc);
                        }
                    }
                } else if (cosXmlResult != null) {
                    if (this.cosXmlResultListener != null) {
                        this.cosXmlResultListener.onSuccess(buildCOSXMLTaskRequest(), cosXmlResult);
                    }
                } else if (transferState != null) {
                    dispatchStateChange(this.taskState);
                }
                return;
            }
            switch (AnonymousClass2.$SwitchMap$com$tencent$cos$xml$transfer$TransferState[transferState.ordinal()]) {
                case 1:
                    if (this.taskState == TransferState.RESUMED_WAITING) {
                        this.taskState = TransferState.WAITING;
                        dispatchStateChange(this.taskState);
                    }
                    return;
                case 2:
                    if (this.taskState == TransferState.WAITING) {
                        this.taskState = TransferState.IN_PROGRESS;
                        dispatchStateChange(this.taskState);
                    }
                    return;
                case 3:
                    if (this.taskState == TransferState.IN_PROGRESS) {
                        this.taskState = TransferState.COMPLETED;
                        this.mResult = buildCOSXMLTaskResult(cosXmlResult);
                        if (this.cosXmlResultListener != null) {
                            this.cosXmlResultListener.onSuccess(buildCOSXMLTaskRequest(), this.mResult);
                        }
                        dispatchStateChange(this.taskState);
                        internalCompleted();
                    }
                    return;
                case 4:
                    if (this.taskState == TransferState.WAITING || this.taskState == TransferState.IN_PROGRESS) {
                        this.taskState = TransferState.FAILED;
                        this.mException = exc;
                        if (this.cosXmlResultListener != null) {
                            if (exc instanceof CosXmlClientException) {
                                this.cosXmlResultListener.onFail(buildCOSXMLTaskRequest(), (CosXmlClientException) exc, null);
                            } else {
                                this.cosXmlResultListener.onFail(buildCOSXMLTaskRequest(), null, (CosXmlServiceException) exc);
                            }
                        }
                        dispatchStateChange(this.taskState);
                        internalFailed();
                    }
                    return;
                case 5:
                    if (this.taskState == TransferState.WAITING || this.taskState == TransferState.IN_PROGRESS) {
                        this.taskState = TransferState.PAUSED;
                        dispatchStateChange(this.taskState);
                        internalPause();
                    }
                    return;
                case 6:
                    if (this.taskState != TransferState.CANCELED && this.taskState != TransferState.COMPLETED) {
                        this.taskState = TransferState.CANCELED;
                        dispatchStateChange(this.taskState);
                        this.mException = exc;
                        if (this.cosXmlResultListener != null) {
                            this.cosXmlResultListener.onFail(buildCOSXMLTaskRequest(), (CosXmlClientException) exc, null);
                        }
                        internalCancel();
                    }
                    return;
                case 7:
                    if (this.taskState == TransferState.PAUSED || this.taskState == TransferState.FAILED || this.taskState == TransferState.CONSTRAINED) {
                        this.taskState = TransferState.RESUMED_WAITING;
                        dispatchStateChange(this.taskState);
                        internalResume();
                    }
                    return;
                case 8:
                    if (this.taskState == TransferState.WAITING || this.taskState == TransferState.RESUMED_WAITING || this.taskState == TransferState.IN_PROGRESS) {
                        this.taskState = TransferState.CONSTRAINED;
                        dispatchStateChange(this.taskState);
                        internalPause();
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("invalid state: " + transferState);
                    BeaconService.getInstance().reportError(TAG, illegalStateException);
                    throw illegalStateException;
                default:
                    IllegalStateException illegalStateException2 = new IllegalStateException("invalid state: " + transferState);
                    BeaconService.getInstance().reportError(TAG, illegalStateException2);
                    throw illegalStateException2;
            }
        }
    }
}
