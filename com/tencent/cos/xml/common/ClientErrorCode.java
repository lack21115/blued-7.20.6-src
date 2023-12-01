package com.tencent.cos.xml.common;

import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.igexin.sdk.PushConsts;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/common/ClientErrorCode.class */
public enum ClientErrorCode {
    UNKNOWN(-10000, "Unknown Error"),
    INVALID_ARGUMENT(10000, "InvalidArgument"),
    INVALID_CREDENTIALS(10001, "InvalidCredentials"),
    BAD_REQUEST(10002, "BadRequest"),
    SINK_SOURCE_NOT_FOUND(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR, "SinkSourceNotFound"),
    ETAG_NOT_FOUND(10004, "ETagNotFound"),
    INTERNAL_ERROR(20000, "InternalError"),
    SERVERERROR(PushConsts.SETTAG_ERROR_COUNT, "ServerError"),
    IO_ERROR(20002, "IOError"),
    POOR_NETWORK(PushConsts.SETTAG_ERROR_REPEAT, "NetworkError"),
    NETWORK_NOT_CONNECTED(PushConsts.SETTAG_ERROR_UNBIND, "NetworkNotConnected"),
    USER_CANCELLED(30000, "UserCancelled"),
    ALREADY_FINISHED(PushConsts.ALIAS_ERROR_FREQUENCY, "AlreadyFinished"),
    DUPLICATE_TASK(PushConsts.ALIAS_OPERATE_PARAM_ERROR, "DuplicateTask"),
    KMS_ERROR(40000, "KMSError");
    
    private int code;
    private String errorMsg;

    ClientErrorCode(int i, String str) {
        this.code = i;
        this.errorMsg = str;
    }

    public static ClientErrorCode to(int i) {
        ClientErrorCode[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                throw new IllegalArgumentException("not error code defined");
            }
            ClientErrorCode clientErrorCode = values[i3];
            if (clientErrorCode.code == i) {
                return clientErrorCode;
            }
            i2 = i3 + 1;
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }
}
