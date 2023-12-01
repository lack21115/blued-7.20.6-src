package com.tencent.cos.xml.transfer;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/transfer/TransferListener.class */
public interface TransferListener {
    void onError(String str, CosXmlClientException cosXmlClientException, CosXmlServiceException cosXmlServiceException);

    void onProgressChanged(String str, long j, long j2);

    void onStateChanged(String str, TransferState transferState);
}
