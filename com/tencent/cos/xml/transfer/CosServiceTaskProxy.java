package com.tencent.cos.xml.transfer;

import bolts.Task;
import bolts.TaskCompletionSource;
import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.AbortMultiUploadResult;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/CosServiceTaskProxy.class */
public class CosServiceTaskProxy {
    private CosXmlSimpleService cosXmlSimpleService;

    CosServiceTaskProxy(CosXmlSimpleService cosXmlSimpleService) {
        this.cosXmlSimpleService = cosXmlSimpleService;
    }

    public Task<AbortMultiUploadResult> abortMultiUpload(AbortMultiUploadRequest abortMultiUploadRequest) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.cosXmlSimpleService.abortMultiUploadAsync(abortMultiUploadRequest, new CosXmlResultListener() { // from class: com.tencent.cos.xml.transfer.CosServiceTaskProxy.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onFail(CosXmlRequest cosXmlRequest, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException) {
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (cosXmlClientException == null) {
                    cosXmlClientException = cosXmlServiceException != 0 ? cosXmlServiceException : new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), "UnknownError");
                }
                taskCompletionSource2.b(cosXmlClientException);
            }

            @Override // com.tencent.cos.xml.listener.CosXmlResultListener
            public void onSuccess(CosXmlRequest cosXmlRequest, CosXmlResult cosXmlResult) {
                taskCompletionSource.setResult((AbortMultiUploadResult) cosXmlResult);
            }
        });
        return taskCompletionSource.a();
    }
}
