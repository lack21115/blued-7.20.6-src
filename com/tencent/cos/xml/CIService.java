package com.tencent.cos.xml;

import android.content.Context;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.ci.DeleteBucketDPStateRequest;
import com.tencent.cos.xml.model.ci.DeleteBucketDPStateResult;
import com.tencent.cos.xml.model.ci.GetBucketDPStateRequest;
import com.tencent.cos.xml.model.ci.GetBucketDPStateResult;
import com.tencent.cos.xml.model.ci.PutBucketDPStateRequest;
import com.tencent.cos.xml.model.ci.PutBucketDPStateResult;
import com.tencent.cos.xml.model.ci.QRCodeUploadRequest;
import com.tencent.cos.xml.model.ci.QRCodeUploadResult;
import com.tencent.cos.xml.model.ci.SensitiveContentRecognitionRequest;
import com.tencent.cos.xml.model.ci.SensitiveContentRecognitionResult;
import com.tencent.cos.xml.model.ci.audit.GetAudioAuditRequest;
import com.tencent.cos.xml.model.ci.audit.GetAudioAuditResult;
import com.tencent.cos.xml.model.ci.audit.GetDocumentAuditRequest;
import com.tencent.cos.xml.model.ci.audit.GetDocumentAuditResult;
import com.tencent.cos.xml.model.ci.audit.GetImageAuditRequest;
import com.tencent.cos.xml.model.ci.audit.GetImageAuditResult;
import com.tencent.cos.xml.model.ci.audit.GetTextAuditRequest;
import com.tencent.cos.xml.model.ci.audit.GetVideoAuditRequest;
import com.tencent.cos.xml.model.ci.audit.GetVideoAuditResult;
import com.tencent.cos.xml.model.ci.audit.GetWebPageAuditRequest;
import com.tencent.cos.xml.model.ci.audit.GetWebPageAuditResult;
import com.tencent.cos.xml.model.ci.audit.PostAudioAuditRequest;
import com.tencent.cos.xml.model.ci.audit.PostAuditResult;
import com.tencent.cos.xml.model.ci.audit.PostDocumentAuditRequest;
import com.tencent.cos.xml.model.ci.audit.PostImagesAuditRequest;
import com.tencent.cos.xml.model.ci.audit.PostImagesAuditResult;
import com.tencent.cos.xml.model.ci.audit.PostTextAuditRequest;
import com.tencent.cos.xml.model.ci.audit.PostVideoAuditRequest;
import com.tencent.cos.xml.model.ci.audit.PostWebPageAuditRequest;
import com.tencent.cos.xml.model.ci.audit.TextAuditResult;
import com.tencent.qcloud.core.auth.COSXmlSigner;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.SignerFactory;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CIService.class */
public class CIService extends CosXmlService {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/CIService$CISigner.class */
    static class CISigner extends COSXmlSigner {
        private CISigner() {
        }

        @Override // com.tencent.qcloud.core.auth.COSXmlSigner
        public String getSessionTokenKey() {
            return "x-ci-security-token";
        }
    }

    public CIService(Context context, CosXmlServiceConfig cosXmlServiceConfig, QCloudCredentialProvider qCloudCredentialProvider) {
        super(context, cosXmlServiceConfig, qCloudCredentialProvider);
        this.signerType = "CISigner";
        SignerFactory.registerSigner(this.signerType, new CISigner());
    }

    public DeleteBucketDPStateResult deleteBucketDocumentPreviewState(DeleteBucketDPStateRequest deleteBucketDPStateRequest) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteBucketDPStateResult) execute(deleteBucketDPStateRequest, new DeleteBucketDPStateResult());
    }

    public void deleteBucketDocumentPreviewStateAsync(DeleteBucketDPStateRequest deleteBucketDPStateRequest, CosXmlResultListener cosXmlResultListener) throws CosXmlClientException, CosXmlServiceException {
        schedule(deleteBucketDPStateRequest, new DeleteBucketDPStateResult(), cosXmlResultListener);
    }

    public GetAudioAuditResult getAudioAudit(GetAudioAuditRequest getAudioAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetAudioAuditResult) execute(getAudioAuditRequest, new GetAudioAuditResult());
    }

    public void getAudioAuditAsync(GetAudioAuditRequest getAudioAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getAudioAuditRequest, new GetAudioAuditResult(), cosXmlResultListener);
    }

    public GetBucketDPStateResult getBucketDocumentPreviewState(GetBucketDPStateRequest getBucketDPStateRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetBucketDPStateResult) execute(getBucketDPStateRequest, new GetBucketDPStateResult());
    }

    public void getBucketDocumentPreviewStateAsync(GetBucketDPStateRequest getBucketDPStateRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getBucketDPStateRequest, new GetBucketDPStateResult(), cosXmlResultListener);
    }

    public GetDocumentAuditResult getDocumentAudit(GetDocumentAuditRequest getDocumentAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetDocumentAuditResult) execute(getDocumentAuditRequest, new GetDocumentAuditResult());
    }

    public void getDocumentAuditAsync(GetDocumentAuditRequest getDocumentAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getDocumentAuditRequest, new GetDocumentAuditResult(), cosXmlResultListener);
    }

    public GetImageAuditResult getImageAudit(GetImageAuditRequest getImageAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetImageAuditResult) execute(getImageAuditRequest, new GetImageAuditResult());
    }

    public void getImageAuditAsync(GetImageAuditRequest getImageAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getImageAuditRequest, new GetImageAuditResult(), cosXmlResultListener);
    }

    public TextAuditResult getTextAudit(GetTextAuditRequest getTextAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (TextAuditResult) execute(getTextAuditRequest, new TextAuditResult());
    }

    public void getTextAuditAsync(GetTextAuditRequest getTextAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getTextAuditRequest, new TextAuditResult(), cosXmlResultListener);
    }

    public GetVideoAuditResult getVideoAudit(GetVideoAuditRequest getVideoAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetVideoAuditResult) execute(getVideoAuditRequest, new GetVideoAuditResult());
    }

    public void getVideoAuditAsync(GetVideoAuditRequest getVideoAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getVideoAuditRequest, new GetVideoAuditResult(), cosXmlResultListener);
    }

    public GetWebPageAuditResult getWebPageAudit(GetWebPageAuditRequest getWebPageAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (GetWebPageAuditResult) execute(getWebPageAuditRequest, new GetWebPageAuditResult());
    }

    public void getWebPageAuditAsync(GetWebPageAuditRequest getWebPageAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(getWebPageAuditRequest, new GetWebPageAuditResult(), cosXmlResultListener);
    }

    public PostAuditResult postAudioAudit(PostAudioAuditRequest postAudioAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostAuditResult) execute(postAudioAuditRequest, new PostAuditResult());
    }

    public void postAudioAuditAsync(PostAudioAuditRequest postAudioAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postAudioAuditRequest, new PostAuditResult(), cosXmlResultListener);
    }

    public PostAuditResult postDocumentAudit(PostDocumentAuditRequest postDocumentAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostAuditResult) execute(postDocumentAuditRequest, new PostAuditResult());
    }

    public void postDocumentAuditAsync(PostDocumentAuditRequest postDocumentAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postDocumentAuditRequest, new PostAuditResult(), cosXmlResultListener);
    }

    public PostImagesAuditResult postImagesAudit(PostImagesAuditRequest postImagesAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostImagesAuditResult) execute(postImagesAuditRequest, new PostImagesAuditResult());
    }

    public void postImagesAuditAsync(PostImagesAuditRequest postImagesAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postImagesAuditRequest, new PostImagesAuditResult(), cosXmlResultListener);
    }

    public TextAuditResult postTextAudit(PostTextAuditRequest postTextAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (TextAuditResult) execute(postTextAuditRequest, new TextAuditResult());
    }

    public void postTextAuditAsync(PostTextAuditRequest postTextAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postTextAuditRequest, new TextAuditResult(), cosXmlResultListener);
    }

    public PostAuditResult postVideoAudit(PostVideoAuditRequest postVideoAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostAuditResult) execute(postVideoAuditRequest, new PostAuditResult());
    }

    public void postVideoAuditAsync(PostVideoAuditRequest postVideoAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postVideoAuditRequest, new PostAuditResult(), cosXmlResultListener);
    }

    public PostAuditResult postWebPageAudit(PostWebPageAuditRequest postWebPageAuditRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PostAuditResult) execute(postWebPageAuditRequest, new PostAuditResult());
    }

    public void postWebPageAuditAsync(PostWebPageAuditRequest postWebPageAuditRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(postWebPageAuditRequest, new PostAuditResult(), cosXmlResultListener);
    }

    public PutBucketDPStateResult putBucketDocumentPreviewState(PutBucketDPStateRequest putBucketDPStateRequest) throws CosXmlClientException, CosXmlServiceException {
        return (PutBucketDPStateResult) execute(putBucketDPStateRequest, new PutBucketDPStateResult());
    }

    public void putBucketDocumentPreviewStateAsync(PutBucketDPStateRequest putBucketDPStateRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(putBucketDPStateRequest, new PutBucketDPStateResult(), cosXmlResultListener);
    }

    public QRCodeUploadResult qrCodeUpload(QRCodeUploadRequest qRCodeUploadRequest) throws CosXmlClientException, CosXmlServiceException {
        return (QRCodeUploadResult) execute(qRCodeUploadRequest, new QRCodeUploadResult());
    }

    public void qrCodeUploadAsync(QRCodeUploadRequest qRCodeUploadRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(qRCodeUploadRequest, new QRCodeUploadResult(), cosXmlResultListener);
    }

    public SensitiveContentRecognitionResult sensitiveContentRecognition(SensitiveContentRecognitionRequest sensitiveContentRecognitionRequest) throws CosXmlClientException, CosXmlServiceException {
        return (SensitiveContentRecognitionResult) execute(sensitiveContentRecognitionRequest, new SensitiveContentRecognitionResult());
    }

    public void sensitiveContentRecognitionAsync(SensitiveContentRecognitionRequest sensitiveContentRecognitionRequest, CosXmlResultListener cosXmlResultListener) {
        schedule(sensitiveContentRecognitionRequest, new SensitiveContentRecognitionResult(), cosXmlResultListener);
    }
}
