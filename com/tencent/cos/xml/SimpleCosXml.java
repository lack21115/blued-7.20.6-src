package com.tencent.cos.xml;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.listener.CosXmlResultSimpleListener;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsRequest;
import com.tencent.cos.xml.model.bucket.ListMultiUploadsResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.AbortMultiUploadResult;
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
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/SimpleCosXml.class */
public interface SimpleCosXml extends BaseCosXml {
    AbortMultiUploadResult abortMultiUpload(AbortMultiUploadRequest abortMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    void abortMultiUploadAsync(AbortMultiUploadRequest abortMultiUploadRequest, CosXmlResultListener cosXmlResultListener);

    CompleteMultiUploadResult completeMultiUpload(CompleteMultiUploadRequest completeMultiUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    void completeMultiUploadAsync(CompleteMultiUploadRequest completeMultiUploadRequest, CosXmlResultListener cosXmlResultListener);

    CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    UploadPartCopyResult copyObject(UploadPartCopyRequest uploadPartCopyRequest) throws CosXmlClientException, CosXmlServiceException;

    void copyObjectAsync(CopyObjectRequest copyObjectRequest, CosXmlResultListener cosXmlResultListener);

    void copyObjectAsync(UploadPartCopyRequest uploadPartCopyRequest, CosXmlResultListener cosXmlResultListener);

    DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    void deleteObjectAsync(DeleteObjectRequest deleteObjectRequest, CosXmlResultListener cosXmlResultListener);

    HeadObjectResult headObject(HeadObjectRequest headObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    void headObjectAsync(HeadObjectRequest headObjectRequest, CosXmlResultListener cosXmlResultListener);

    InitMultipartUploadResult initMultipartUpload(InitMultipartUploadRequest initMultipartUploadRequest) throws CosXmlClientException, CosXmlServiceException;

    void initMultipartUploadAsync(InitMultipartUploadRequest initMultipartUploadRequest, CosXmlResultListener cosXmlResultListener);

    ListMultiUploadsResult listMultiUploads(ListMultiUploadsRequest listMultiUploadsRequest) throws CosXmlClientException, CosXmlServiceException;

    void listMultiUploadsAsync(ListMultiUploadsRequest listMultiUploadsRequest, CosXmlResultListener cosXmlResultListener);

    ListPartsResult listParts(ListPartsRequest listPartsRequest) throws CosXmlClientException, CosXmlServiceException;

    void listPartsAsync(ListPartsRequest listPartsRequest, CosXmlResultListener cosXmlResultListener);

    PostObjectResult postObject(PostObjectRequest postObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    void postObjectAsync(PostObjectRequest postObjectRequest, CosXmlResultListener cosXmlResultListener);

    boolean preBuildConnection(String str) throws CosXmlClientException, CosXmlServiceException;

    void preBuildConnectionAsync(String str, CosXmlResultSimpleListener cosXmlResultSimpleListener);

    PutObjectResult putObject(PutObjectRequest putObjectRequest) throws CosXmlClientException, CosXmlServiceException;

    void putObjectAsync(PutObjectRequest putObjectRequest, CosXmlResultListener cosXmlResultListener);
}
