package com.tencent.cos.xml;

import android.content.Context;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.listener.CosXmlResultSimpleListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsRequest;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.AbortMultiUploadResult;
import com.tencent.cos.xml.model.object.AppendObjectRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.DeleteObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.PostObjectRequest;
import com.tencent.cos.xml.model.object.PostObjectResult;
import com.tencent.cos.xml.model.object.PreBuildConnectionRequest;
import com.tencent.cos.xml.model.object.PreBuildConnectionResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudSelfSigner;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.http.HttpTask;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CosXmlSimpleService.class */
public class CosXmlSimpleService extends CosXmlBaseService implements SimpleCosXml {
    private static final String TAG = "CosXmlSimpleService";

    public CosXmlSimpleService(Context context, CosXmlServiceConfig cosXmlServiceConfig) {
        super(context, cosXmlServiceConfig);
    }

    public CosXmlSimpleService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudCredentialProvider qCloudCredentialProvider) {
        super(context, cosXmlServiceConfig, qCloudCredentialProvider);
    }

    public CosXmlSimpleService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudSelfSigner qCloudSelfSigner) {
        super(context, cosXmlServiceConfig, qCloudSelfSigner);
    }

    public CosXmlSimpleService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudSigner qCloudSigner) {
        super(context, cosXmlServiceConfig, qCloudSigner);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public AbortMultiUploadResult abortMultiUpload(AbortMultiUploadRequest abortMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        return (AbortMultiUploadResult) execute(abortMultiUploadRequest, new AbortMultiUploadResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void abortMultiUploadAsync(AbortMultiUploadRequest abortMultiUploadRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(abortMultiUploadRequest, new AbortMultiUploadResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public CompleteMultiUploadResult completeMultiUpload(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        CompleteMultiUploadResult completeMultiUploadResult = new CompleteMultiUploadResult();
        completeMultiUploadResult.accessUrl = getAccessUrl(completeMultiUploadRequest);
        return (CompleteMultiUploadResult) execute(completeMultiUploadRequest, completeMultiUploadResult);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void completeMultiUploadAsync(CompleteMultiUploadRequest completeMultiUploadRequest, CosXmlResultListener cosXmlResultListener) {
        CompleteMultiUploadResult completeMultiUploadResult = new CompleteMultiUploadResult();
        completeMultiUploadResult.accessUrl = getAccessUrl(completeMultiUploadRequest);
        schedule(completeMultiUploadRequest, completeMultiUploadResult, cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (CopyObjectResult) execute(copyObjectRequest, new CopyObjectResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public UploadPartCopyResult copyObject(UploadPartCopyRequest uploadPartCopyRequest) throws CosXmlClientException, CosXmlServiceException {
        return (UploadPartCopyResult) execute(uploadPartCopyRequest, new UploadPartCopyResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void copyObjectAsync(CopyObjectRequest copyObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(copyObjectRequest, new CopyObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void copyObjectAsync(UploadPartCopyRequest uploadPartCopyRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(uploadPartCopyRequest, new UploadPartCopyResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteObjectResult) execute(deleteObjectRequest, new DeleteObjectResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void deleteObjectAsync(DeleteObjectRequest deleteObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteObjectRequest, new DeleteObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (HeadObjectResult) execute(headObjectRequest, new HeadObjectResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void headObjectAsync(HeadObjectRequest headObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(headObjectRequest, new HeadObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public InitMultipartUploadResult initMultipartUpload(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        return (InitMultipartUploadResult) execute(initMultipartUploadRequest, new InitMultipartUploadResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void initMultipartUploadAsync(InitMultipartUploadRequest initMultipartUploadRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(initMultipartUploadRequest, new InitMultipartUploadResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public ListMultiUploadsResult listMultiUploads(ListMultiUploadsRequest listMultiUploadsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListMultiUploadsResult) execute(listMultiUploadsRequest, new ListMultiUploadsResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void listMultiUploadsAsync(ListMultiUploadsRequest listMultiUploadsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listMultiUploadsRequest, new ListMultiUploadsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public ListPartsResult listParts(ListPartsRequest listPartsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListPartsResult) execute(listPartsRequest, new ListPartsResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void listPartsAsync(ListPartsRequest listPartsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listPartsRequest, new ListPartsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public PostObjectResult postObject(PostObjectRequest postObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostObjectResult) execute(postObjectRequest, new PostObjectResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void postObjectAsync(PostObjectRequest postObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postObjectRequest, new PostObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public boolean preBuildConnection(String str) {
        try {
            execute(new PreBuildConnectionRequest(str), new PreBuildConnectionResult());
            return true;
        } catch (CosXmlClientException e) {
            return false;
        } catch (CosXmlServiceException e2) {
            return e2.getStatusCode() != 404;
        }
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void preBuildConnectionAsync(String str, final CosXmlResultSimpleListener cosXmlResultSimpleListener) {
        schedule(new PreBuildConnectionRequest(str), new PreBuildConnectionResult(), new CosXmlResultListener() { // from class: com.tencent.cos.xml.CosXmlSimpleService.1
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlServiceException == null || cosXmlServiceException.getStatusCode() == 404) {
                    cosXmlResultSimpleListener.onFail(cosXmlClientException, cosXmlServiceException);
                } else {
                    cosXmlResultSimpleListener.onSuccess();
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlResultSimpleListener.onSuccess();
            }
        });
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public PutObjectResult putObject(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.accessUrl = getAccessUrl(putObjectRequest);
        return (PutObjectResult) execute(putObjectRequest, putObjectResult);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void putObjectAsync(PutObjectRequest putObjectRequest, CosXmlResultListener cosXmlResultListener) {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.accessUrl = getAccessUrl(putObjectRequest);
        schedule(putObjectRequest, putObjectResult, cosXmlResultListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.CosXmlBaseService
    public <T1 extends CosXmlRequest> void setCopySource(T1 t1) throws CosXmlClientException {
        super.setCopySource(t1);
        if (t1 instanceof CopyObjectRequest) {
            CopyObjectRequest copyObjectRequest = (CopyObjectRequest) t1;
            copyObjectRequest.setCopySource(copyObjectRequest.getCopySource(), this.config);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.CosXmlBaseService
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> void setProgressListener(T1 t1, HttpTask<T2> httpTask, boolean z) {
        super.setProgressListener(t1, httpTask, z);
        if (t1 instanceof AppendObjectRequest) {
            httpTask.addProgressListener(((AppendObjectRequest) t1).getProgressListener());
        } else if (t1 instanceof PostObjectRequest) {
            httpTask.addProgressListener(((PostObjectRequest) t1).getProgressListener());
        }
    }
}
