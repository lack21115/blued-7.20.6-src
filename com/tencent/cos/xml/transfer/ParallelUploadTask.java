package com.tencent.cos.xml.transfer;

import android.net.Uri;
import android.text.TextUtils;
import bolts.CancellationToken;
import bolts.CancellationTokenSource;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.transfer.COSUploadTask;
import com.tencent.qcloud.core.http.HttpTaskMetrics;
import com.tencent.qcloud.core.task.TaskExecutors;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/ParallelUploadTask.class */
public class ParallelUploadTask {
    private volatile HttpTaskMetrics httpTaskMetrics;
    private CancellationTokenSource mCancellationTokenSource;
    private CosXmlSimpleService mCosXmlSimpleService;
    private long mOffset;
    private long mOffsetPointer;
    private final int mPartNumber;
    private CosXmlProgressListener mProgressListener;
    private PutObjectRequest mPutObjectRequest;
    private List<UploadPartRequest> mRequests;
    private long mSize;
    private Task<?> mTask;
    private TaskCompletionSource<?> mTaskCompletionSource;
    private Map<UploadPartRequest, Long> mUploadCompleteMap;
    private final String mUploadId;
    private List<UploadPartTask> mUploadPartTasks;
    private SlidingWindow slidingWindow;
    private String taskId;
    private final Object mCheckingLock = new Object();
    private long mTotalComplete = 0;
    private long mNormalNetworkSliceSize = 1048576;
    private long mPoolNetworkSliceSize = 1048576;
    private volatile boolean isPoolNetwork = true;
    private final long normalNetworkSpeed = 102400;
    private Set<COSUploadTask.UploadPart> uploadParts = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/ParallelUploadTask$SlidingWindow.class */
    public static class SlidingWindow {
        private boolean[] completes;
        private int mNext;
        private int mStart;
        private int mWidth;

        SlidingWindow(int i, int i2) {
            this.mStart = 0;
            this.mNext = 0;
            this.mStart = i;
            this.mNext = i;
            this.mWidth = i2;
            this.completes = new boolean[i2];
        }

        void complete(int i) {
            int i2;
            int i3;
            synchronized (this) {
                this.completes[i - this.mStart] = true;
                int i4 = 0;
                for (int i5 = 0; i5 < this.completes.length && this.completes[i5]; i5++) {
                    i4++;
                }
                if (i4 > 0) {
                    this.mStart += i4;
                    int length = this.completes.length;
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        i2 = length - i4;
                        if (i7 >= i2) {
                            break;
                        }
                        this.completes[i7] = this.completes[i7 + i4];
                        i6 = i7 + 1;
                    }
                    for (i3 = i2; i3 < length; i3++) {
                        this.completes[i3] = false;
                    }
                    notifyAll();
                }
            }
        }

        int getNextNumber() {
            int i;
            synchronized (this) {
                while (this.mNext >= this.mStart + this.mWidth) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i = this.mNext;
                this.mNext = i + 1;
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/ParallelUploadTask$UploadPartTask.class */
    public static class UploadPartTask implements Comparable<UploadPartTask>, Runnable {
        private CosXmlSimpleService cosXmlSimpleService;
        private CancellationToken mCancellationToken;
        private TaskCompletionSource<UploadPartResult> tcs = new TaskCompletionSource<>();
        private UploadPartRequest uploadPartRequest;

        public UploadPartTask(CosXmlSimpleService cosXmlSimpleService, UploadPartRequest uploadPartRequest, CancellationToken cancellationToken) {
            this.cosXmlSimpleService = cosXmlSimpleService;
            this.uploadPartRequest = uploadPartRequest;
            this.mCancellationToken = cancellationToken;
        }

        public void cancel() {
            this.cosXmlSimpleService.cancel(this.uploadPartRequest);
        }

        @Override // java.lang.Comparable
        public int compareTo(UploadPartTask uploadPartTask) {
            return 0;
        }

        public Task<UploadPartResult> getTask() {
            return this.tcs.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCancellationToken.a()) {
                return;
            }
            try {
                this.tcs.setResult(this.cosXmlSimpleService.uploadPart(this.uploadPartRequest));
            } catch (CancellationException e) {
                this.tcs.c();
            } catch (Exception e2) {
                this.tcs.b(e2);
            }
        }
    }

    public ParallelUploadTask(CosXmlSimpleService cosXmlSimpleService, PutObjectRequest putObjectRequest, long j, long j2, int i, String str) {
        this.mPartNumber = i;
        this.mUploadId = str;
        this.mOffset = j;
        this.mSize = j2;
        this.slidingWindow = new SlidingWindow(i, 3);
        this.mOffsetPointer = this.mOffset;
        this.mPutObjectRequest = putObjectRequest;
        TaskCompletionSource<?> taskCompletionSource = new TaskCompletionSource<>();
        this.mTaskCompletionSource = taskCompletionSource;
        this.mTask = taskCompletionSource.a();
        this.mCosXmlSimpleService = cosXmlSimpleService;
        this.mCancellationTokenSource = new CancellationTokenSource();
        this.mUploadPartTasks = new LinkedList();
        this.mUploadCompleteMap = new HashMap();
    }

    private void cancelAllUploadTask() {
        LinkedList<UploadPartTask> linkedList = new LinkedList(this.mUploadPartTasks);
        synchronized (this.mCheckingLock) {
            for (UploadPartTask uploadPartTask : linkedList) {
                uploadPartTask.cancel();
            }
        }
    }

    private void checkoutException(Exception exc) throws CosXmlClientException, CosXmlServiceException {
        if (exc instanceof CosXmlClientException) {
            throw ((CosXmlClientException) exc);
        }
        if (!(exc instanceof CosXmlServiceException)) {
            throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), exc.getMessage());
        }
        throw ((CosXmlServiceException) exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeTaskMetrics(HttpTaskMetrics httpTaskMetrics) {
        synchronized (this) {
            if (httpTaskMetrics != null) {
                if (this.httpTaskMetrics != null) {
                    this.httpTaskMetrics.merge(httpTaskMetrics);
                }
            }
        }
    }

    private UploadPartRequest nextUploadPartRequest(int i) throws CosXmlClientException {
        long j = this.mOffsetPointer;
        UploadPartRequest uploadPartRequest = null;
        if (j >= this.mOffset + this.mSize) {
            return null;
        }
        long min = Math.min(this.isPoolNetwork ? this.mPoolNetworkSliceSize : this.mNormalNetworkSliceSize, (this.mOffset + this.mSize) - this.mOffsetPointer);
        this.mOffsetPointer += min;
        String srcPath = this.mPutObjectRequest.getSrcPath();
        Uri uri = this.mPutObjectRequest.getUri();
        String bucket = this.mPutObjectRequest.getBucket();
        String cosPath = this.mPutObjectRequest.getCosPath();
        String region = this.mPutObjectRequest.getRegion();
        if (srcPath != null) {
            uploadPartRequest = new UploadPartRequest(bucket, cosPath, i, srcPath, j, min, this.mUploadId);
        } else if (uri != null) {
            uploadPartRequest = new UploadPartRequest(bucket, cosPath, i, uri, j, min, this.mUploadId);
        }
        if (uploadPartRequest != null && !TextUtils.isEmpty(region)) {
            uploadPartRequest.setRegion(region);
        }
        return uploadPartRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePartProgress(UploadPartRequest uploadPartRequest, long j) {
        synchronized (this) {
            long j2 = 0;
            if (this.mUploadCompleteMap.containsKey(uploadPartRequest)) {
                j2 = this.mUploadCompleteMap.get(uploadPartRequest).longValue();
            }
            this.mUploadCompleteMap.put(uploadPartRequest, Long.valueOf(j));
            long j3 = this.mTotalComplete + (j - j2);
            this.mTotalComplete = j3;
            if (this.mProgressListener != null) {
                this.mProgressListener.onProgress(j3 + this.mOffset, -1L);
            }
        }
    }

    public void cancel() {
        this.mCancellationTokenSource.c();
        this.mTaskCompletionSource.c();
        cancelAllUploadTask();
    }

    public void setHttpTaskMetrics(HttpTaskMetrics httpTaskMetrics) {
        this.httpTaskMetrics = httpTaskMetrics;
    }

    public void setNormalNetworkSliceSize(long j) {
        this.mNormalNetworkSliceSize = j;
    }

    public void setPoolNetworkSliceSize(long j) {
        this.mPoolNetworkSliceSize = j;
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.mProgressListener = cosXmlProgressListener;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public Set<COSUploadTask.UploadPart> waitForComplete() throws CosXmlClientException, CosXmlServiceException {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        while (!this.mTask.b()) {
            final int nextNumber = this.slidingWindow.getNextNumber();
            final UploadPartRequest nextUploadPartRequest = nextUploadPartRequest(nextNumber);
            if (nextUploadPartRequest == null) {
                atomicBoolean.set(true);
                break;
            }
            nextUploadPartRequest.attachMetrics(new HttpTaskMetrics());
            atomicInteger.addAndGet(1);
            UploadPartTask uploadPartTask = new UploadPartTask(this.mCosXmlSimpleService, nextUploadPartRequest, this.mCancellationTokenSource.b());
            this.mUploadPartTasks.add(uploadPartTask);
            uploadPartTask.getTask().a(new Continuation<UploadPartResult, Void>() { // from class: com.tencent.cos.xml.transfer.ParallelUploadTask.1
                @Override // bolts.Continuation
                public Void then(Task<UploadPartResult> task) throws Exception {
                    ParallelUploadTask.this.slidingWindow.complete(nextNumber);
                    if (task.d()) {
                        ParallelUploadTask.this.mTaskCompletionSource.a(task.f());
                    }
                    if (task.b()) {
                        ParallelUploadTask.this.uploadParts.add(new COSUploadTask.UploadPart(task.e().eTag, nextUploadPartRequest.getPartNumber(), nextUploadPartRequest.getFileOffset(), nextUploadPartRequest.getFileContentLength()));
                        ParallelUploadTask.this.mergeTaskMetrics(nextUploadPartRequest.getMetrics());
                    }
                    if (atomicInteger.get() == atomicInteger2.addAndGet(1) && atomicBoolean.get()) {
                        ParallelUploadTask.this.mTaskCompletionSource.a((TaskCompletionSource) null);
                        return null;
                    }
                    return null;
                }
            });
            nextUploadPartRequest.setProgressListener(new CosXmlProgressListener() { // from class: com.tencent.cos.xml.transfer.ParallelUploadTask.2
                @Override // com.tencent.qcloud.core.common.QCloudProgressListener
                public void onProgress(long j, long j2) {
                    ParallelUploadTask.this.updatePartProgress(nextUploadPartRequest, j);
                }
            });
            TaskExecutors.UPLOAD_EXECUTOR.execute(uploadPartTask);
        }
        try {
            this.mTask.g();
            if (this.mTask.d()) {
                checkoutException(this.mTask.f());
                cancelAllUploadTask();
            } else if (this.mTask.c()) {
                throw CosXmlClientException.manualCancelException();
            }
            return this.uploadParts;
        } catch (InterruptedException e) {
            int code = ClientErrorCode.INTERNAL_ERROR.getCode();
            throw new CosXmlClientException(code, ClientErrorCode.INTERNAL_ERROR.getErrorMsg() + ": " + e.getMessage());
        }
    }
}
