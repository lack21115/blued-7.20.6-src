package com.tencent.cos.xml;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.cos.xml.common.MetaDataDirective;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlBooleanListener;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketCORSResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketInventoryRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketInventoryResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketTaggingRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketTaggingResult;
import com.tencent.cos.xml.model.bucket.DeleteBucketWebsiteRequest;
import com.tencent.cos.xml.model.bucket.DeleteBucketWebsiteResult;
import com.tencent.cos.xml.model.bucket.GetBucketACLRequest;
import com.tencent.cos.xml.model.bucket.GetBucketACLResult;
import com.tencent.cos.xml.model.bucket.GetBucketAccelerateRequest;
import com.tencent.cos.xml.model.bucket.GetBucketAccelerateResult;
import com.tencent.cos.xml.model.bucket.GetBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.GetBucketCORSResult;
import com.tencent.cos.xml.model.bucket.GetBucketDomainRequest;
import com.tencent.cos.xml.model.bucket.GetBucketDomainResult;
import com.tencent.cos.xml.model.bucket.GetBucketIntelligentTieringRequest;
import com.tencent.cos.xml.model.bucket.GetBucketIntelligentTieringResult;
import com.tencent.cos.xml.model.bucket.GetBucketInventoryRequest;
import com.tencent.cos.xml.model.bucket.GetBucketInventoryResult;
import com.tencent.cos.xml.model.bucket.GetBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.GetBucketLocationRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLocationResult;
import com.tencent.cos.xml.model.bucket.GetBucketLoggingRequest;
import com.tencent.cos.xml.model.bucket.GetBucketLoggingResult;
import com.tencent.cos.xml.model.bucket.GetBucketObjectVersionsRequest;
import com.tencent.cos.xml.model.bucket.GetBucketObjectVersionsResult;
import com.tencent.cos.xml.model.bucket.GetBucketRefererRequest;
import com.tencent.cos.xml.model.bucket.GetBucketRefererResult;
import com.tencent.cos.xml.model.bucket.GetBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.GetBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.GetBucketRequest;
import com.tencent.cos.xml.model.bucket.GetBucketResult;
import com.tencent.cos.xml.model.bucket.GetBucketTaggingRequest;
import com.tencent.cos.xml.model.bucket.GetBucketTaggingResult;
import com.tencent.cos.xml.model.bucket.GetBucketVersioningRequest;
import com.tencent.cos.xml.model.bucket.GetBucketVersioningResult;
import com.tencent.cos.xml.model.bucket.GetBucketWebsiteRequest;
import com.tencent.cos.xml.model.bucket.GetBucketWebsiteResult;
import com.tencent.cos.xml.model.bucket.HeadBucketRequest;
import com.tencent.cos.xml.model.bucket.HeadBucketResult;
import com.tencent.cos.xml.model.bucket.ListBucketInventoryRequest;
import com.tencent.cos.xml.model.bucket.ListBucketInventoryResult;
import com.tencent.cos.xml.model.bucket.ListBucketVersionsRequest;
import com.tencent.cos.xml.model.bucket.ListBucketVersionsResult;
import com.tencent.cos.xml.model.bucket.PutBucketACLRequest;
import com.tencent.cos.xml.model.bucket.PutBucketACLResult;
import com.tencent.cos.xml.model.bucket.PutBucketAccelerateRequest;
import com.tencent.cos.xml.model.bucket.PutBucketAccelerateResult;
import com.tencent.cos.xml.model.bucket.PutBucketCORSRequest;
import com.tencent.cos.xml.model.bucket.PutBucketCORSResult;
import com.tencent.cos.xml.model.bucket.PutBucketDomainRequest;
import com.tencent.cos.xml.model.bucket.PutBucketDomainResult;
import com.tencent.cos.xml.model.bucket.PutBucketIntelligentTieringRequest;
import com.tencent.cos.xml.model.bucket.PutBucketIntelligentTieringResult;
import com.tencent.cos.xml.model.bucket.PutBucketInventoryRequest;
import com.tencent.cos.xml.model.bucket.PutBucketInventoryResult;
import com.tencent.cos.xml.model.bucket.PutBucketLifecycleRequest;
import com.tencent.cos.xml.model.bucket.PutBucketLifecycleResult;
import com.tencent.cos.xml.model.bucket.PutBucketLoggingRequest;
import com.tencent.cos.xml.model.bucket.PutBucketLoggingResult;
import com.tencent.cos.xml.model.bucket.PutBucketRefererRequest;
import com.tencent.cos.xml.model.bucket.PutBucketRefererResult;
import com.tencent.cos.xml.model.bucket.PutBucketReplicationRequest;
import com.tencent.cos.xml.model.bucket.PutBucketReplicationResult;
import com.tencent.cos.xml.model.bucket.PutBucketRequest;
import com.tencent.cos.xml.model.bucket.PutBucketResult;
import com.tencent.cos.xml.model.bucket.PutBucketTaggingRequest;
import com.tencent.cos.xml.model.bucket.PutBucketTaggingResult;
import com.tencent.cos.xml.model.bucket.PutBucketVersioningRequest;
import com.tencent.cos.xml.model.bucket.PutBucketVersioningResult;
import com.tencent.cos.xml.model.bucket.PutBucketWebsiteRequest;
import com.tencent.cos.xml.model.bucket.PutBucketWebsiteResult;
import com.tencent.cos.xml.model.ci.FormatConversionRequest;
import com.tencent.cos.xml.model.ci.FormatConversionResult;
import com.tencent.cos.xml.model.ci.GetDescribeMediaBucketsRequest;
import com.tencent.cos.xml.model.ci.GetDescribeMediaBucketsResult;
import com.tencent.cos.xml.model.ci.GetMediaInfoRequest;
import com.tencent.cos.xml.model.ci.GetMediaInfoResult;
import com.tencent.cos.xml.model.ci.GetSnapshotRequest;
import com.tencent.cos.xml.model.ci.GetSnapshotResult;
import com.tencent.cos.xml.model.ci.PreviewDocumentInHtmlBytesRequest;
import com.tencent.cos.xml.model.ci.PreviewDocumentInHtmlBytesResult;
import com.tencent.cos.xml.model.ci.PreviewDocumentInHtmlLinkRequest;
import com.tencent.cos.xml.model.ci.PreviewDocumentInHtmlLinkResult;
import com.tencent.cos.xml.model.ci.PreviewDocumentInHtmlRequest;
import com.tencent.cos.xml.model.ci.PreviewDocumentInHtmlResult;
import com.tencent.cos.xml.model.ci.PreviewDocumentRequest;
import com.tencent.cos.xml.model.ci.PreviewDocumentResult;
import com.tencent.cos.xml.model.object.AppendObjectRequest;
import com.tencent.cos.xml.model.object.AppendObjectResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.DeleteMultiObjectRequest;
import com.tencent.cos.xml.model.object.DeleteMultiObjectResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.DeleteObjectTaggingRequest;
import com.tencent.cos.xml.model.object.DeleteObjectTaggingResult;
import com.tencent.cos.xml.model.object.GetObjectACLRequest;
import com.tencent.cos.xml.model.object.GetObjectACLResult;
import com.tencent.cos.xml.model.object.GetObjectTaggingRequest;
import com.tencent.cos.xml.model.object.GetObjectTaggingResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.OptionObjectRequest;
import com.tencent.cos.xml.model.object.OptionObjectResult;
import com.tencent.cos.xml.model.object.PutObjectACLRequest;
import com.tencent.cos.xml.model.object.PutObjectACLResult;
import com.tencent.cos.xml.model.object.PutObjectTaggingRequest;
import com.tencent.cos.xml.model.object.PutObjectTaggingResult;
import com.tencent.cos.xml.model.object.RestoreRequest;
import com.tencent.cos.xml.model.object.RestoreResult;
import com.tencent.cos.xml.model.object.SelectObjectContentRequest;
import com.tencent.cos.xml.model.object.SelectObjectContentResult;
import com.tencent.cos.xml.model.service.GetServiceRequest;
import com.tencent.cos.xml.model.service.GetServiceResult;
import com.tencent.cos.xml.model.tag.COSMetaData;
import com.tencent.cos.xml.transfer.SelectObjectContentConverter;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudSelfSigner;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.http.QCloudHttpRequest;
import com.tencent.qcloud.core.http.ResponseBodyConverter;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CosXmlService.class */
public class CosXmlService extends CosXmlSimpleService implements CosXml {
    private String getServiceRequestDomain;

    public CosXmlService(Context context, CosXmlServiceConfig cosXmlServiceConfig) {
        super(context, cosXmlServiceConfig);
    }

    public CosXmlService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudCredentialProvider qCloudCredentialProvider) {
        super(context, cosXmlServiceConfig, qCloudCredentialProvider);
    }

    public CosXmlService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudSelfSigner qCloudSelfSigner) {
        super(context, cosXmlServiceConfig, qCloudSelfSigner);
    }

    public CosXmlService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudSigner qCloudSigner) {
        super(context, cosXmlServiceConfig, qCloudSigner);
    }

    @Override // com.tencent.cos.xml.CosXml
    public AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        AppendObjectResult appendObjectResult = new AppendObjectResult();
        appendObjectResult.accessUrl = getAccessUrl(appendObjectRequest);
        return (AppendObjectResult) execute(appendObjectRequest, appendObjectResult);
    }

    @Override // com.tencent.cos.xml.CosXml
    public void appendObjectAsync(AppendObjectRequest appendObjectRequest, CosXmlResultListener cosXmlResultListener) {
        AppendObjectResult appendObjectResult = new AppendObjectResult();
        appendObjectResult.accessUrl = getAccessUrl(appendObjectRequest);
        schedule(appendObjectRequest, appendObjectResult, cosXmlResultListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.CosXmlBaseService
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> boolean buildHttpRequestBodyConverter(T1 t1, T2 t2, QCloudHttpRequest.Builder<T2> builder) {
        if (t1 instanceof SelectObjectContentRequest) {
            SelectObjectContentRequest selectObjectContentRequest = (SelectObjectContentRequest) t1;
            SelectObjectContentConverter selectObjectContentConverter = new SelectObjectContentConverter((SelectObjectContentResult) t2, selectObjectContentRequest.getSelectResponseFilePath());
            selectObjectContentConverter.setContentListener(selectObjectContentRequest.getSelectObjectContentProgressListener());
            builder.converter((ResponseBodyConverter<T2>) selectObjectContentConverter);
            return true;
        }
        return super.buildHttpRequestBodyConverter(t1, t2, builder);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketResult) execute(deleteBucketRequest, new DeleteBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketAsync(DeleteBucketRequest deleteBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketRequest, new DeleteBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketCORSResult deleteBucketCORS(DeleteBucketCORSRequest deleteBucketCORSRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketCORSResult) execute(deleteBucketCORSRequest, new DeleteBucketCORSResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketCORSAsync(DeleteBucketCORSRequest deleteBucketCORSRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketCORSRequest, new DeleteBucketCORSResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketInventoryResult deleteBucketInventory(DeleteBucketInventoryRequest deleteBucketInventoryRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketInventoryResult) execute(deleteBucketInventoryRequest, new DeleteBucketInventoryResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketInventoryAsync(DeleteBucketInventoryRequest deleteBucketInventoryRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketInventoryRequest, new DeleteBucketInventoryResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketLifecycleResult deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketLifecycleResult) execute(deleteBucketLifecycleRequest, new DeleteBucketLifecycleResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketLifecycleAsync(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketLifecycleRequest, new DeleteBucketLifecycleResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketReplicationResult deleteBucketReplication(DeleteBucketReplicationRequest deleteBucketReplicationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketReplicationResult) execute(deleteBucketReplicationRequest, new DeleteBucketReplicationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketReplicationAsync(DeleteBucketReplicationRequest deleteBucketReplicationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketReplicationRequest, new DeleteBucketReplicationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketTaggingResult deleteBucketTagging(DeleteBucketTaggingRequest deleteBucketTaggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketTaggingResult) execute(deleteBucketTaggingRequest, new DeleteBucketTaggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketTaggingAsync(DeleteBucketTaggingRequest deleteBucketTaggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketTaggingRequest, new DeleteBucketTaggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteBucketWebsiteResult deleteBucketWebsite(DeleteBucketWebsiteRequest deleteBucketWebsiteRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketWebsiteResult) execute(deleteBucketWebsiteRequest, new DeleteBucketWebsiteResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteBucketWebsiteAsync(DeleteBucketWebsiteRequest deleteBucketWebsiteRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteBucketWebsiteRequest, new DeleteBucketWebsiteResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteMultiObjectResult deleteMultiObject(DeleteMultiObjectRequest deleteMultiObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteMultiObjectResult) execute(deleteMultiObjectRequest, new DeleteMultiObjectResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteMultiObjectAsync(DeleteMultiObjectRequest deleteMultiObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteMultiObjectRequest, new DeleteMultiObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public boolean deleteObject(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        deleteObject(new DeleteObjectRequest(str, str2));
        return true;
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteObjectAsync(String str, String str2, final CosXmlBooleanListener cosXmlBooleanListener) {
        deleteObjectAsync(new DeleteObjectRequest(str, str2), new CosXmlResultListener() { // from class: com.tencent.cos.xml.CosXmlService.3
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }
        });
    }

    @Override // com.tencent.cos.xml.CosXml
    public DeleteObjectTaggingResult deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteObjectTaggingResult) execute(deleteObjectTaggingRequest, new DeleteObjectTaggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void deleteObjectTaggingAsync(DeleteObjectTaggingRequest deleteObjectTaggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(deleteObjectTaggingRequest, new DeleteObjectTaggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public boolean doesBucketExist(String str) throws CosXmlClientException, CosXmlServiceException {
        try {
            getBucketACL(new GetBucketACLRequest(str));
            return true;
        } catch (CosXmlServiceException e) {
            if (e.getStatusCode() == 301 || "AccessDenied".equals(e.getErrorCode())) {
                return true;
            }
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    @Override // com.tencent.cos.xml.CosXml
    public void doesBucketExistAsync(String str, final CosXmlBooleanListener cosXmlBooleanListener) {
        headBucketAsync(new HeadBucketRequest(str), new CosXmlResultListener() { // from class: com.tencent.cos.xml.CosXmlService.1
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                boolean z = false;
                if (cosXmlClientException == null) {
                    z = false;
                    if (cosXmlServiceException != null) {
                        if (cosXmlServiceException.getStatusCode() == 301 || "AccessDenied".equals(cosXmlServiceException.getErrorCode())) {
                            cosXmlBooleanListener.onSuccess(true);
                            z = true;
                        } else {
                            z = false;
                        }
                        if (cosXmlServiceException.getStatusCode() == 404) {
                            cosXmlBooleanListener.onSuccess(false);
                            z = true;
                        }
                    }
                }
                if (z) {
                    return;
                }
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }
        });
    }

    @Override // com.tencent.cos.xml.CosXml
    public boolean doesObjectExist(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        try {
            headObject(new HeadObjectRequest(str, str2));
            return true;
        } catch (CosXmlServiceException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    @Override // com.tencent.cos.xml.CosXml
    public void doesObjectExistAsync(String str, String str2, final CosXmlBooleanListener cosXmlBooleanListener) {
        headObjectAsync(new HeadObjectRequest(str, str2), new CosXmlResultListener() { // from class: com.tencent.cos.xml.CosXmlService.2
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                if (cosXmlServiceException == null || cosXmlServiceException.getStatusCode() != 404) {
                    cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
                } else {
                    cosXmlBooleanListener.onSuccess(false);
                }
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }
        });
    }

    public void formatConversionAsync(FormatConversionRequest formatConversionRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(formatConversionRequest, new FormatConversionResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketResult getBucket(GetBucketRequest getBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketResult) execute(getBucketRequest, new GetBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketACLResult) execute(getBucketACLRequest, new GetBucketACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketACLAsync(GetBucketACLRequest getBucketACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketACLRequest, new GetBucketACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketAccelerateResult getBucketAccelerate(GetBucketAccelerateRequest getBucketAccelerateRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketAccelerateResult) execute(getBucketAccelerateRequest, new GetBucketAccelerateResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketAccelerateAsync(GetBucketAccelerateRequest getBucketAccelerateRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketAccelerateRequest, new GetBucketAccelerateResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketAsync(GetBucketRequest getBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketRequest, new GetBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketCORSResult getBucketCORS(GetBucketCORSRequest getBucketCORSRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketCORSResult) execute(getBucketCORSRequest, new GetBucketCORSResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketCORSAsync(GetBucketCORSRequest getBucketCORSRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketCORSRequest, new GetBucketCORSResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketDomainResult getBucketDomain(GetBucketDomainRequest getBucketDomainRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketDomainResult) execute(getBucketDomainRequest, new GetBucketDomainResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketDomainAsync(GetBucketDomainRequest getBucketDomainRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketDomainRequest, new GetBucketDomainResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketIntelligentTieringResult getBucketIntelligentTiering(GetBucketIntelligentTieringRequest getBucketIntelligentTieringRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketIntelligentTieringResult) execute(getBucketIntelligentTieringRequest, new GetBucketIntelligentTieringResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketIntelligentTieringAsync(GetBucketIntelligentTieringRequest getBucketIntelligentTieringRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketIntelligentTieringRequest, new GetBucketIntelligentTieringResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketInventoryResult getBucketInventory(GetBucketInventoryRequest getBucketInventoryRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketInventoryResult) execute(getBucketInventoryRequest, new GetBucketInventoryResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketInventoryAsync(GetBucketInventoryRequest getBucketInventoryRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketInventoryRequest, new GetBucketInventoryResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketLifecycleResult getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLifecycleResult) execute(getBucketLifecycleRequest, new GetBucketLifecycleResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketLifecycleAsync(GetBucketLifecycleRequest getBucketLifecycleRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketLifecycleRequest, new GetBucketLifecycleResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketLocationResult getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLocationResult) execute(getBucketLocationRequest, new GetBucketLocationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketLocationAsync(GetBucketLocationRequest getBucketLocationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketLocationRequest, new GetBucketLocationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketLoggingResult getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketLoggingResult) execute(getBucketLoggingRequest, new GetBucketLoggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketLoggingAsync(GetBucketLoggingRequest getBucketLoggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketLoggingRequest, new GetBucketLoggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketObjectVersionsResult getBucketObjectVersions(GetBucketObjectVersionsRequest getBucketObjectVersionsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketObjectVersionsResult) execute(getBucketObjectVersionsRequest, new GetBucketObjectVersionsResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketObjectVersionsAsync(GetBucketObjectVersionsRequest getBucketObjectVersionsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketObjectVersionsRequest, new GetBucketObjectVersionsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketRefererResult getBucketReferer(GetBucketRefererRequest getBucketRefererRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketRefererResult) execute(getBucketRefererRequest, new GetBucketRefererResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketRefererAsync(GetBucketRefererRequest getBucketRefererRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketRefererRequest, new GetBucketRefererResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketReplicationResult getBucketReplication(GetBucketReplicationRequest getBucketReplicationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketReplicationResult) execute(getBucketReplicationRequest, new GetBucketReplicationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketReplicationAsync(GetBucketReplicationRequest getBucketReplicationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketReplicationRequest, new GetBucketReplicationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketTaggingResult getBucketTagging(GetBucketTaggingRequest getBucketTaggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketTaggingResult) execute(getBucketTaggingRequest, new GetBucketTaggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketTaggingAsync(GetBucketTaggingRequest getBucketTaggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketTaggingRequest, new GetBucketTaggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketVersioningResult getBucketVersioning(GetBucketVersioningRequest getBucketVersioningRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketVersioningResult) execute(getBucketVersioningRequest, new GetBucketVersioningResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketVersioningAsync(GetBucketVersioningRequest getBucketVersioningRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketVersioningRequest, new GetBucketVersioningResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetBucketWebsiteResult getBucketWebsite(GetBucketWebsiteRequest getBucketWebsiteRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketWebsiteResult) execute(getBucketWebsiteRequest, new GetBucketWebsiteResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getBucketWebsiteAsync(GetBucketWebsiteRequest getBucketWebsiteRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketWebsiteRequest, new GetBucketWebsiteResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetDescribeMediaBucketsResult getDescribeMediaBuckets(GetDescribeMediaBucketsRequest getDescribeMediaBucketsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetDescribeMediaBucketsResult) execute(getDescribeMediaBucketsRequest, new GetDescribeMediaBucketsResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getDescribeMediaBucketsAsync(GetDescribeMediaBucketsRequest getDescribeMediaBucketsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getDescribeMediaBucketsRequest, new GetDescribeMediaBucketsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetMediaInfoResult getMediaInfo(GetMediaInfoRequest getMediaInfoRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetMediaInfoResult) execute(getMediaInfoRequest, new GetMediaInfoResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getMediaInfoAsync(GetMediaInfoRequest getMediaInfoRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getMediaInfoRequest, new GetMediaInfoResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectACLResult) execute(getObjectACLRequest, new GetObjectACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getObjectACLAsync(GetObjectACLRequest getObjectACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getObjectACLRequest, new GetObjectACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetObjectTaggingResult getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectTaggingResult) execute(getObjectTaggingRequest, new GetObjectTaggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getObjectTaggingAsync(GetObjectTaggingRequest getObjectTaggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getObjectTaggingRequest, new GetObjectTaggingResult(), cosXmlResultListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.CosXmlBaseService
    public String getRequestHost(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        return (!(cosXmlRequest instanceof GetServiceRequest) || TextUtils.isEmpty(this.getServiceRequestDomain)) ? super.getRequestHost(cosXmlRequest) : this.getServiceRequestDomain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.cos.xml.CosXmlBaseService
    public String getRequestHostHeader(CosXmlRequest cosXmlRequest) {
        return cosXmlRequest instanceof GetServiceRequest ? "service.cos.myqcloud.com" : super.getRequestHostHeader(cosXmlRequest);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetServiceResult getService(GetServiceRequest getServiceRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetServiceResult) execute(getServiceRequest, new GetServiceResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getServiceAsync(GetServiceRequest getServiceRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getServiceRequest, new GetServiceResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public GetSnapshotResult getSnapshot(GetSnapshotRequest getSnapshotRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetSnapshotResult) execute(getSnapshotRequest, new GetSnapshotResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void getSnapshotAsync(GetSnapshotRequest getSnapshotRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getSnapshotRequest, new GetSnapshotResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public HeadBucketResult headBucket(HeadBucketRequest headBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (HeadBucketResult) execute(headBucketRequest, new HeadBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void headBucketAsync(HeadBucketRequest headBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(headBucketRequest, new HeadBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public ListBucketInventoryResult listBucketInventory(ListBucketInventoryRequest listBucketInventoryRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListBucketInventoryResult) execute(listBucketInventoryRequest, new ListBucketInventoryResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void listBucketInventoryAsync(ListBucketInventoryRequest listBucketInventoryRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listBucketInventoryRequest, new ListBucketInventoryResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public ListBucketVersionsResult listBucketVersions(ListBucketVersionsRequest listBucketVersionsRequest) throws CosXmlClientException, CosXmlServiceException {
        return (ListBucketVersionsResult) execute(listBucketVersionsRequest, new ListBucketVersionsResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void listBucketVersionsAsync(ListBucketVersionsRequest listBucketVersionsRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(listBucketVersionsRequest, new ListBucketVersionsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public OptionObjectResult optionObject(OptionObjectRequest optionObjectRequest) throws CosXmlClientException, CosXmlServiceException {
        return (OptionObjectResult) execute(optionObjectRequest, new OptionObjectResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void optionObjectAsync(OptionObjectRequest optionObjectRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(optionObjectRequest, new OptionObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PreviewDocumentResult previewDocument(PreviewDocumentRequest previewDocumentRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PreviewDocumentResult) execute(previewDocumentRequest, new PreviewDocumentResult(previewDocumentRequest.getDownloadPath()));
    }

    @Override // com.tencent.cos.xml.CosXml
    public void previewDocumentAsync(PreviewDocumentRequest previewDocumentRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(previewDocumentRequest, new PreviewDocumentResult(previewDocumentRequest.getDownloadPath()), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PreviewDocumentInHtmlResult previewDocumentInHtml(PreviewDocumentInHtmlRequest previewDocumentInHtmlRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PreviewDocumentInHtmlResult) execute(previewDocumentInHtmlRequest, new PreviewDocumentInHtmlResult(previewDocumentInHtmlRequest.getDownloadPath()));
    }

    @Override // com.tencent.cos.xml.CosXml
    public void previewDocumentInHtmlAsync(PreviewDocumentInHtmlRequest previewDocumentInHtmlRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(previewDocumentInHtmlRequest, new PreviewDocumentInHtmlResult(previewDocumentInHtmlRequest.getDownloadPath()), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public byte[] previewDocumentInHtmlBytes(String str, String str2) throws CosXmlClientException, CosXmlServiceException {
        PreviewDocumentInHtmlBytesResult previewDocumentInHtmlBytesResult = (PreviewDocumentInHtmlBytesResult) execute(new PreviewDocumentInHtmlBytesRequest(str, str2), new PreviewDocumentInHtmlBytesResult());
        return previewDocumentInHtmlBytesResult != null ? previewDocumentInHtmlBytesResult.data : new byte[0];
    }

    @Override // com.tencent.cos.xml.CosXml
    public PreviewDocumentInHtmlLinkResult previewDocumentInHtmlLink(PreviewDocumentInHtmlLinkRequest previewDocumentInHtmlLinkRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PreviewDocumentInHtmlLinkResult) execute(previewDocumentInHtmlLinkRequest, new PreviewDocumentInHtmlLinkResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void previewDocumentInHtmlLinkAsync(PreviewDocumentInHtmlLinkRequest previewDocumentInHtmlLinkRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(previewDocumentInHtmlLinkRequest, new PreviewDocumentInHtmlLinkResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketResult putBucket(PutBucketRequest putBucketRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketResult) execute(putBucketRequest, new PutBucketResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketACLResult putBucketACL(PutBucketACLRequest putBucketACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketACLResult) execute(putBucketACLRequest, new PutBucketACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketACLAsync(PutBucketACLRequest putBucketACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketACLRequest, new PutBucketACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketAccelerateResult putBucketAccelerate(PutBucketAccelerateRequest putBucketAccelerateRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketAccelerateResult) execute(putBucketAccelerateRequest, new PutBucketAccelerateResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketAccelerateAsync(PutBucketAccelerateRequest putBucketAccelerateRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketAccelerateRequest, new PutBucketAccelerateResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketAsync(PutBucketRequest putBucketRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketRequest, new PutBucketResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketCORSResult putBucketCORS(PutBucketCORSRequest putBucketCORSRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketCORSResult) execute(putBucketCORSRequest, new PutBucketCORSResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketCORSAsync(PutBucketCORSRequest putBucketCORSRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketCORSRequest, new PutBucketCORSResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketDomainResult putBucketDomain(PutBucketDomainRequest putBucketDomainRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketDomainResult) execute(putBucketDomainRequest, new PutBucketDomainResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketDomainAsync(PutBucketDomainRequest putBucketDomainRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketDomainRequest, new PutBucketDomainResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketIntelligentTieringResult putBucketIntelligentTiering(PutBucketIntelligentTieringRequest putBucketIntelligentTieringRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketIntelligentTieringResult) execute(putBucketIntelligentTieringRequest, new PutBucketIntelligentTieringResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketIntelligentTieringAsync(PutBucketIntelligentTieringRequest putBucketIntelligentTieringRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketIntelligentTieringRequest, new PutBucketIntelligentTieringResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketInventoryResult putBucketInventory(PutBucketInventoryRequest putBucketInventoryRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketInventoryResult) execute(putBucketInventoryRequest, new PutBucketInventoryResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketInventoryAsync(PutBucketInventoryRequest putBucketInventoryRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketInventoryRequest, new PutBucketInventoryResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketLifecycleResult putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketLifecycleResult) execute(putBucketLifecycleRequest, new PutBucketLifecycleResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketLifecycleAsync(PutBucketLifecycleRequest putBucketLifecycleRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketLifecycleRequest, new PutBucketLifecycleResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketLoggingResult putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketLoggingResult) execute(putBucketLoggingRequest, new PutBucketLoggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketLoggingAsync(PutBucketLoggingRequest putBucketLoggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketLoggingRequest, new PutBucketLoggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketRefererResult putBucketReferer(PutBucketRefererRequest putBucketRefererRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketRefererResult) execute(putBucketRefererRequest, new PutBucketRefererResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketRefererAsync(PutBucketRefererRequest putBucketRefererRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketRefererRequest, new PutBucketRefererResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketReplicationResult putBucketReplication(PutBucketReplicationRequest putBucketReplicationRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketReplicationResult) execute(putBucketReplicationRequest, new PutBucketReplicationResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketReplicationAsync(PutBucketReplicationRequest putBucketReplicationRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketReplicationRequest, new PutBucketReplicationResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketTaggingResult putBucketTagging(PutBucketTaggingRequest putBucketTaggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketTaggingResult) execute(putBucketTaggingRequest, new PutBucketTaggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketTaggingAsync(PutBucketTaggingRequest putBucketTaggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketTaggingRequest, new PutBucketTaggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketVersionAsync(PutBucketVersioningRequest putBucketVersioningRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketVersioningRequest, new PutBucketVersioningResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketVersioningResult putBucketVersioning(PutBucketVersioningRequest putBucketVersioningRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketVersioningResult) execute(putBucketVersioningRequest, new PutBucketVersioningResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutBucketWebsiteResult putBucketWebsite(PutBucketWebsiteRequest putBucketWebsiteRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketWebsiteResult) execute(putBucketWebsiteRequest, new PutBucketWebsiteResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putBucketWebsiteAsync(PutBucketWebsiteRequest putBucketWebsiteRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketWebsiteRequest, new PutBucketWebsiteResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutObjectACLResult putObjectACL(PutObjectACLRequest putObjectACLRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutObjectACLResult) execute(putObjectACLRequest, new PutObjectACLResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putObjectACLAsync(PutObjectACLRequest putObjectACLRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putObjectACLRequest, new PutObjectACLResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public PutObjectTaggingResult putObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutObjectTaggingResult) execute(putObjectTaggingRequest, new PutObjectTaggingResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void putObjectTaggingAsync(PutObjectTaggingRequest putObjectTaggingRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putObjectTaggingRequest, new PutObjectTaggingResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public RestoreResult restoreObject(RestoreRequest restoreRequest) throws CosXmlClientException, CosXmlServiceException {
        return (RestoreResult) execute(restoreRequest, new RestoreResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void restoreObjectAsync(RestoreRequest restoreRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(restoreRequest, new RestoreResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.CosXml
    public SelectObjectContentResult selectObjectContent(SelectObjectContentRequest selectObjectContentRequest) throws CosXmlClientException, CosXmlServiceException {
        return (SelectObjectContentResult) execute(selectObjectContentRequest, new SelectObjectContentResult());
    }

    @Override // com.tencent.cos.xml.CosXml
    public void selectObjectContentAsync(SelectObjectContentRequest selectObjectContentRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(selectObjectContentRequest, new SelectObjectContentResult(), cosXmlResultListener);
    }

    public void setServiceDomain(String str) {
        this.getServiceRequestDomain = str;
    }

    @Override // com.tencent.cos.xml.CosXml
    @Deprecated
    public boolean updateObjectMeta(String str, String str2, COSMetaData cOSMetaData) throws CosXmlClientException, CosXmlServiceException {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, new CopyObjectRequest.CopySourceStruct(this.config.getAppid(), str, this.config.getRegion(), str2));
        copyObjectRequest.setCopyMetaDataDirective(MetaDataDirective.REPLACED);
        for (String str3 : cOSMetaData.keySet()) {
            copyObjectRequest.setXCOSMeta(str3, cOSMetaData.get(str3));
        }
        copyObject(copyObjectRequest);
        return true;
    }

    @Override // com.tencent.cos.xml.CosXml
    @Deprecated
    public void updateObjectMetaAsync(String str, String str2, COSMetaData cOSMetaData, final CosXmlBooleanListener cosXmlBooleanListener) {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, new CopyObjectRequest.CopySourceStruct(this.config.getAppid(), str, this.config.getRegion(), str2));
        copyObjectRequest.setCopyMetaDataDirective(MetaDataDirective.REPLACED);
        for (String str3 : cOSMetaData.keySet()) {
            copyObjectRequest.setXCOSMeta(str3, cOSMetaData.get(str3));
        }
        copyObjectAsync(copyObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.CosXmlService.4
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }
        });
    }

    @Override // com.tencent.cos.xml.CosXml
    public boolean updateObjectMetaData(String str, String str2, COSMetaData cOSMetaData) throws CosXmlClientException, CosXmlServiceException {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, new CopyObjectRequest.CopySourceStruct(str, this.config.getRegion(), str2));
        copyObjectRequest.setCopyMetaDataDirective(MetaDataDirective.REPLACED);
        for (String str3 : cOSMetaData.keySet()) {
            copyObjectRequest.setXCOSMeta(str3, cOSMetaData.get(str3));
        }
        copyObject(copyObjectRequest);
        return true;
    }

    @Override // com.tencent.cos.xml.CosXml
    public void updateObjectMetaDataAsync(String str, String str2, COSMetaData cOSMetaData, final CosXmlBooleanListener cosXmlBooleanListener) {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, new CopyObjectRequest.CopySourceStruct(str, this.config.getRegion(), str2));
        copyObjectRequest.setCopyMetaDataDirective(MetaDataDirective.REPLACED);
        for (String str3 : cOSMetaData.keySet()) {
            copyObjectRequest.setXCOSMeta(str3, cOSMetaData.get(str3));
        }
        copyObjectAsync(copyObjectRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.CosXmlService.5
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                cosXmlBooleanListener.onFail(cosXmlClientException, cosXmlServiceException);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                cosXmlBooleanListener.onSuccess(true);
            }
        });
    }
}
