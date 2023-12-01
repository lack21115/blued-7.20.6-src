package com.tencent.cos.xml.transfer;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.cos.xml.crypto.COSDirect;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.transfer.COSUploadTask;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/BaseUploadPartsTask.class */
abstract class BaseUploadPartsTask {
    protected COSDirect mCosDirect;
    protected long mOffset;
    protected PutObjectRequest mPutObjectRequest;
    protected long mSize;
    protected int mStartNumber;
    protected String mUploadId;
    private CosXmlProgressListener progressListener;
    protected String taskId;
    protected Set<COSUploadTask.UploadPart> uploadParts = Collections.synchronizedSet(new HashSet());
    protected long mMaxPartSize = 1048576;
    protected final String TAG = COSUploadTask.TAG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseUploadPartsTask(COSDirect cOSDirect, PutObjectRequest putObjectRequest, long j, long j2, int i, String str) {
        this.mCosDirect = cOSDirect;
        this.mPutObjectRequest = putObjectRequest;
        this.mOffset = j;
        this.mSize = j2;
        this.mStartNumber = i;
        this.mUploadId = str;
    }

    private Map<String, List<String>> getUploadPartHeaders(PutObjectRequest putObjectRequest) {
        Map<String, List<String>> requestHeaders = putObjectRequest.getRequestHeaders();
        if (requestHeaders == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (String str : requestHeaders.keySet()) {
            if (str.startsWith(Headers.SERVER_SIDE_ENCRYPTION) || str.equals(Headers.COS_TRAFFIC_LIMIT)) {
                hashMap.put(str, requestHeaders.get(str));
            }
        }
        return hashMap;
    }

    public abstract void cancel();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UploadPartRequest getUploadRequest(int i, long j, long j2) {
        UploadPartRequest uploadPartRequest = null;
        if (j >= this.mOffset + this.mSize) {
            return null;
        }
        String srcPath = this.mPutObjectRequest.getSrcPath();
        Uri uri = this.mPutObjectRequest.getUri();
        String bucket = this.mPutObjectRequest.getBucket();
        String cosPath = this.mPutObjectRequest.getCosPath();
        String region = this.mPutObjectRequest.getRegion();
        if (srcPath != null) {
            uploadPartRequest = new UploadPartRequest(bucket, cosPath, i, srcPath, j, j2, this.mUploadId);
        } else if (uri != null) {
            uploadPartRequest = new UploadPartRequest(bucket, cosPath, i, uri, j, j2, this.mUploadId);
        }
        if (uploadPartRequest != null) {
            if (!TextUtils.isEmpty(region)) {
                uploadPartRequest.setRegion(region);
            }
            uploadPartRequest.setRequestHeaders(getUploadPartHeaders(this.mPutObjectRequest));
            uploadPartRequest.setLastPart(j + j2 >= this.mOffset + this.mSize);
        }
        return uploadPartRequest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyProgressChange(long j, long j2) {
        CosXmlProgressListener cosXmlProgressListener = this.progressListener;
        if (cosXmlProgressListener != null) {
            cosXmlProgressListener.onProgress(j, j2);
        }
    }

    public void setProgressListener(CosXmlProgressListener cosXmlProgressListener) {
        this.progressListener = cosXmlProgressListener;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public abstract Set<COSUploadTask.UploadPart> upload() throws Exception;
}
