package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.CosXmlService;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import com.tencent.cos.xml.model.object.CopyObjectResult;
import com.tencent.cos.xml.model.object.HeadObjectRequest;
import com.tencent.cos.xml.model.object.HeadObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyRequest;
import com.tencent.cos.xml.model.object.UploadPartCopyResult;
import com.tencent.cos.xml.transfer.UploadService;
import java.util.LinkedHashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/CopyObjectService.class */
public class CopyObjectService {
    private CosXmlService cosXmlService;
    private String sourceCustomerKey;
    private String sourceCustomerKeyId;
    private String sourceJsonContent;
    private long maxSliceSize = 5242880;
    private UploadService.EncryptionType encryptionType = UploadService.EncryptionType.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.cos.xml.transfer.CopyObjectService$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/CopyObjectService$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[UploadService.EncryptionType.values().length];
            $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType = iArr;
            try {
                iArr[UploadService.EncryptionType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType[UploadService.EncryptionType.SSEC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType[UploadService.EncryptionType.SSEKMS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/CopyObjectService$CopyServerResult.class */
    public static class CopyServerResult extends CosXmlResult {
        public String eTag;
    }

    public CopyObjectService(CosXmlService cosXmlService) {
        this.cosXmlService = cosXmlService;
    }

    private CompleteMultiUploadResult completeMultipart(String str, String str2, String str3, Map<Integer, String> map) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.completeMultiUpload(new CompleteMultiUploadRequest(str, str2, str3, map));
    }

    private CompleteMultiUploadResult copyObjectForLargeFile(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct, long j) throws CosXmlClientException, CosXmlServiceException {
        String initMultiUpload = initMultiUpload(str, str2);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long j2 = this.maxSliceSize;
        long j3 = -1;
        int i = 1;
        while (true) {
            long j4 = j - 1;
            if (j3 >= j4) {
                return completeMultipart(str, str2, initMultiUpload, linkedHashMap);
            }
            long j5 = j3 + j2;
            if (j5 < j4) {
                j4 = j5;
            }
            linkedHashMap.put(Integer.valueOf(i), copyObjectForLargeFile(str, str2, i, initMultiUpload, copySourceStruct, j3 + 1, j4).copyObject.eTag);
            i++;
            j3 = j4;
        }
    }

    private UploadPartCopyResult copyObjectForLargeFile(String str, String str2, int i, String str3, CopyObjectRequest.CopySourceStruct copySourceStruct, long j, long j2) throws CosXmlServiceException, CosXmlClientException {
        UploadPartCopyRequest uploadPartCopyRequest = new UploadPartCopyRequest(str, str2, i, str3, copySourceStruct, j, j2);
        setCopySourceEncryptionRequest(uploadPartCopyRequest);
        return this.cosXmlService.copyObject(uploadPartCopyRequest);
    }

    private CopyObjectResult copyObjectForSmallFile(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlServiceException, CosXmlClientException {
        CopyObjectRequest copyObjectRequest = new CopyObjectRequest(str, str2, copySourceStruct);
        setCopySourceEncryptionRequest(copyObjectRequest);
        return this.cosXmlService.copyObject(copyObjectRequest);
    }

    private long headObject(String str, String str2) throws CosXmlServiceException, CosXmlClientException {
        HeadObjectRequest headObjectRequest = new HeadObjectRequest(str, str2);
        setCopySourceEncryptionRequest(headObjectRequest);
        HeadObjectResult headObject = this.cosXmlService.headObject(headObjectRequest);
        if (headObject != null) {
            return Long.valueOf(headObject.headers.get("Content-Length").get(0)).longValue();
        }
        return -1L;
    }

    private String initMultiUpload(String str, String str2) throws CosXmlServiceException, CosXmlClientException {
        return this.cosXmlService.initMultipartUpload(new InitMultipartUploadRequest(str, str2)).initMultipartUpload.uploadId;
    }

    private void setCopySourceEncryptionRequest(CosXmlRequest cosXmlRequest) throws CosXmlClientException {
        if (cosXmlRequest == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$tencent$cos$xml$transfer$UploadService$EncryptionType[this.encryptionType.ordinal()];
        if (i == 2) {
            if (cosXmlRequest instanceof HeadObjectRequest) {
                ((HeadObjectRequest) cosXmlRequest).setCOSServerSideEncryptionWithCustomerKey(this.sourceCustomerKey);
            } else if (cosXmlRequest instanceof CopyObjectRequest) {
                ((CopyObjectRequest) cosXmlRequest).setCopySourceServerSideEncryptionCustomerKey(this.sourceCustomerKey);
            }
        } else if (i != 3) {
        } else {
            if (cosXmlRequest instanceof HeadObjectRequest) {
                ((HeadObjectRequest) cosXmlRequest).setCOSServerSideEncryptionWithKMS(this.sourceCustomerKeyId, this.sourceJsonContent);
            } else if (cosXmlRequest instanceof CopyObjectRequest) {
                ((CopyObjectRequest) cosXmlRequest).setCopySourceServerSideEncryptionKMS(this.sourceCustomerKeyId, this.sourceJsonContent);
            }
        }
    }

    public CosXmlResult copyObject(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlClientException, CosXmlServiceException {
        CopyServerResult copyServerResult = new CopyServerResult();
        long headObject = headObject(copySourceStruct.bucket, copySourceStruct.cosPath);
        if (headObject >= this.maxSliceSize) {
            CompleteMultiUploadResult copyObjectForLargeFile = copyObjectForLargeFile(str, str2, copySourceStruct, headObject);
            copyServerResult.headers = copyObjectForLargeFile.headers;
            copyServerResult.httpCode = copyObjectForLargeFile.httpCode;
            copyServerResult.httpMessage = copyObjectForLargeFile.httpMessage;
            copyServerResult.accessUrl = copyObjectForLargeFile.accessUrl;
            copyServerResult.eTag = copyObjectForLargeFile.completeMultipartUpload.eTag;
            return copyServerResult;
        }
        CopyObjectResult copyObjectForSmallFile = copyObjectForSmallFile(str, str2, copySourceStruct);
        copyServerResult.headers = copyObjectForSmallFile.headers;
        copyServerResult.httpCode = copyObjectForSmallFile.httpCode;
        copyServerResult.httpMessage = copyObjectForSmallFile.httpMessage;
        copyServerResult.accessUrl = copyObjectForSmallFile.accessUrl;
        copyServerResult.eTag = copyObjectForSmallFile.copyObject.eTag;
        return copyServerResult;
    }

    public CosXmlResult copyObject(String str, String str2, CopyObjectRequest.CopySourceStruct copySourceStruct, long j) throws CosXmlClientException, CosXmlServiceException {
        return j >= this.maxSliceSize ? copyObjectForLargeFile(str, str2, copySourceStruct, j) : copyObjectForSmallFile(str, str2, copySourceStruct);
    }

    public void setCopySourceCustomerKey(String str) {
        this.encryptionType = UploadService.EncryptionType.SSEC;
        this.sourceCustomerKey = str;
    }

    public void setCopySourceCustomerKeyIdAndJsonContent(String str, String str2) {
        this.sourceCustomerKeyId = str;
        this.sourceJsonContent = str2;
        this.encryptionType = UploadService.EncryptionType.SSEKMS;
    }
}
