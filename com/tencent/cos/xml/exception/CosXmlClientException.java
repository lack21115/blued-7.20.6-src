package com.tencent.cos.xml.exception;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.qcloud.core.common.QCloudClientException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/exception/CosXmlClientException.class */
public class CosXmlClientException extends QCloudClientException {
    private static final long serialVersionUID = 1;
    public final int errorCode;

    public CosXmlClientException(int i, String str) {
        super(str);
        this.errorCode = i;
    }

    public CosXmlClientException(int i, String str, Throwable th) {
        super(str, th);
        this.errorCode = i;
    }

    public CosXmlClientException(int i, Throwable th) {
        super(th);
        this.errorCode = i;
    }

    public CosXmlClientException(ClientErrorCode clientErrorCode) {
        this(clientErrorCode.getCode(), clientErrorCode.getErrorMsg());
    }

    public static CosXmlClientException internalException(String str) {
        return new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), str);
    }

    public static CosXmlClientException manualCancelException() {
        return new CosXmlClientException(ClientErrorCode.USER_CANCELLED);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CosXmlClientException{errorCode=" + this.errorCode + "message=" + getMessage() + '}';
    }
}
