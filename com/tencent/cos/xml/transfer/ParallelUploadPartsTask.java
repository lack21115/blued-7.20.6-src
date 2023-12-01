package com.tencent.cos.xml.transfer;

import android.text.TextUtils;
import android.util.SparseArray;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.COSDirect;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.transfer.COSUploadTask;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/ParallelUploadPartsTask.class */
class ParallelUploadPartsTask extends BaseUploadPartsTask {
    private AtomicLong mTotalProgress;
    private final Set<UploadPartRequest> runningRequestSet;
    private TaskCompletionSource<Set<COSUploadTask.UploadPart>> tcs;
    private SparseArray<Long> uploadPartProgress;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ParallelUploadPartsTask(COSDirect cOSDirect, PutObjectRequest putObjectRequest, long j, long j2, int i, String str) {
        super(cOSDirect, putObjectRequest, j, j2, i, str);
        this.runningRequestSet = Collections.synchronizedSet(new HashSet());
        this.tcs = new TaskCompletionSource<>();
        this.uploadPartProgress = new SparseArray<>();
        this.mTotalProgress = new AtomicLong(0L);
    }

    private int calculatePartNumber(long j, long j2) {
        int i = (int) (j / j2);
        int i2 = i;
        if (j % j2 != 0) {
            i2 = i + 1;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAllUploadingRequests() {
        synchronized (this.runningRequestSet) {
            for (UploadPartRequest uploadPartRequest : this.runningRequestSet) {
                this.mCosDirect.cancel(uploadPartRequest);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(UploadPartRequest uploadPartRequest, long j) {
        synchronized (this) {
            int partNumber = uploadPartRequest.getPartNumber();
            long longValue = this.uploadPartProgress.get(partNumber, 0L).longValue();
            this.uploadPartProgress.put(partNumber, Long.valueOf(j));
            notifyProgressChange(this.mOffset + this.mTotalProgress.addAndGet(j - longValue), this.mOffset + this.mSize);
        }
    }

    @Override // com.tencent.cos.xml.transfer.BaseUploadPartsTask
    public void cancel() {
        this.tcs.b();
        cancelAllUploadingRequests();
    }

    @Override // com.tencent.cos.xml.transfer.BaseUploadPartsTask
    public Set<COSUploadTask.UploadPart> upload() throws Exception {
        Task<Set<COSUploadTask.UploadPart>> a2 = this.tcs.a();
        final int calculatePartNumber = calculatePartNumber(this.mSize, this.mMaxPartSize);
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= calculatePartNumber) {
                break;
            }
            final int i3 = this.mStartNumber + i2;
            final long j = this.mOffset + (i2 * this.mMaxPartSize);
            final long min = Math.min(this.mMaxPartSize, (this.mOffset + this.mSize) - j);
            final UploadPartRequest uploadRequest = getUploadRequest(i3, j, min);
            uploadRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.ParallelUploadPartsTask.1
                @Override // com.tencent.qcloud.core.common.QCloudProgressListener
                public void onProgress(long j2, long j3) {
                    ParallelUploadPartsTask.this.updateProgress(uploadRequest, j2);
                }
            });
            synchronized (this.runningRequestSet) {
                this.runningRequestSet.add(uploadRequest);
            }
            this.mCosDirect.uploadPartAsync(uploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.ParallelUploadPartsTask.2
                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                    if (cosXmlClientException != null) {
                        ParallelUploadPartsTask.this.tcs.a((Exception) cosXmlClientException);
                    } else if (cosXmlServiceException != null) {
                        ParallelUploadPartsTask.this.tcs.a((Exception) cosXmlServiceException);
                    } else {
                        ParallelUploadPartsTask.this.tcs.a((Exception) new CosXmlClientException(ClientErrorCode.UNKNOWN));
                    }
                    ParallelUploadPartsTask.this.cancelAllUploadingRequests();
                }

                @Override // com.tencent.cos.xml.listener.CosXmlResultListener
                public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                    synchronized (ParallelUploadPartsTask.this.runningRequestSet) {
                        ParallelUploadPartsTask.this.runningRequestSet.remove(uploadRequest);
                    }
                    UploadPartResult uploadPartResult = (UploadPartResult) cosXmlResult;
                    String str = uploadPartResult.eTag;
                    COSTransferTask.loggerInfo(COSUploadTask.TAG, ParallelUploadPartsTask.this.taskId, "upload part %d, etag=%s", Integer.valueOf(i3), str);
                    if (TextUtils.isEmpty(str)) {
                        ParallelUploadPartsTask.this.tcs.a((Exception) new CosXmlClientException(ClientErrorCode.ETAG_NOT_FOUND));
                        ParallelUploadPartsTask.this.cancelAllUploadingRequests();
                        return;
                    }
                    ParallelUploadPartsTask.this.uploadParts.add(new COSUploadTask.UploadPart(uploadPartResult.eTag, i3, j, min));
                    if (atomicInteger.addAndGet(1) >= calculatePartNumber) {
                        ParallelUploadPartsTask.this.tcs.a((TaskCompletionSource) ParallelUploadPartsTask.this.uploadParts);
                    }
                }
            });
            i = i2 + 1;
        }
        a2.g();
        if (a2.d()) {
            throw a2.f();
        }
        if (a2.c()) {
            throw new CosXmlClientException(ClientErrorCode.USER_CANCELLED);
        }
        return a2.e();
    }
}
