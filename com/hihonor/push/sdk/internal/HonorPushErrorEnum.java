package com.hihonor.push.sdk.internal;

import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.bw;
import com.hihonor.push.sdk.HonorPushErrorCode;
import com.hihonor.push.sdk.common.data.ApiException;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/internal/HonorPushErrorEnum.class */
public enum HonorPushErrorEnum {
    SUCCESS(0, bw.o),
    ERROR_NOT_SUPPORT_PUSH(HonorPushErrorCode.ERROR_NOT_SUPPORT_PUSH, "device is not support push."),
    ERROR_MAIN_THREAD(HonorPushErrorCode.ERROR_MAIN_THREAD, "operation in MAIN thread prohibited."),
    ERROR_NO_TOKEN(HonorPushErrorCode.ERROR_NO_TOKEN, "token missing."),
    ERROR_NO_APPID(HonorPushErrorCode.ERROR_NO_APPID, "app id missing."),
    ERROR_NOT_INITIALIZED(HonorPushErrorCode.ERROR_NOT_INITIALIZED, "SDK not initialized"),
    ERROR_CERT_FINGERPRINT_EMPTY(HonorPushErrorCode.CERT_FINGERPRINT_EMPTY, "certificate fingerprint empty."),
    ERROR_BIND_SERVICE(HonorPushErrorCode.ERROR_BIND_SERVICE, "bind service failed."),
    ERROR_SERVICE_DISCONNECTED(HonorPushErrorCode.ERROR_SERVICE_DISCONNECTED, "service disconnected."),
    ERROR_SERVICE_TIME_OUT(HonorPushErrorCode.ERROR_SERVICE_TIME_OUT, "service connect time out."),
    ERROR_SERVICE_ARGUMENTS_INVALID(HonorPushErrorCode.ERROR_SERVICE_ARGUMENTS_INVALID, "service arguments invalid."),
    ERROR_SERVICE_NULL_BINDING(HonorPushErrorCode.ERROR_SERVICE_NULL_BINDING, "service being bound has return null."),
    ERROR_SERVICE_INVALID(HonorPushErrorCode.ERROR_SERVICE_INVALID, "service invalid."),
    ERROR_SERVICE_DISABLED(HonorPushErrorCode.ERROR_SERVICE_DISABLED, "service disabled."),
    ERROR_SERVICE_MISSING(HonorPushErrorCode.ERROR_SERVICE_MISSING, "service missing."),
    ERROR_PUSH_SERVER(HonorPushErrorCode.ERROR_PUSH_SERVER, "push server error."),
    ERROR_UNKNOWN(HonorPushErrorCode.ERROR_UNKNOWN, "unknown error."),
    ERROR_INTERNAL_ERROR(HonorPushErrorCode.ERROR_INTERNAL, "internal error."),
    ERROR_ARGUMENTS_INVALID(HonorPushErrorCode.ERROR_ARGUMENTS_INVALID, "arguments invalid."),
    ERROR_OPERATION_FREQUENTLY(HonorPushErrorCode.ERROR_OPERATION_FREQUENTLY, "operation too frequently."),
    ERROR_NETWORK_NONE(HonorPushErrorCode.ERROR_NETWORK_NONE, "no network."),
    ERROR_STATEMENT_AGREEMENT(HonorPushErrorCode.ERROR_STATEMENT_AGREEMENT, "not statement agreement."),
    ERROR_SERVICE_REQUEST_TIME_OUT(HonorPushErrorCode.ERROR_SERVICE_REQUEST_TIME_OUT, "service request time out."),
    ERROR_HTTP_OPERATION_FREQUENTLY(HonorPushErrorCode.ERROR_HTTP_OPERATION_FREQUENTLY, "http operation too frequently.");
    
    public static final SparseArray<HonorPushErrorEnum> ENUM_MAPPER = new SparseArray<>();
    public String message;
    public int statusCode;

    static {
        HonorPushErrorEnum[] values = values();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 24) {
                return;
            }
            HonorPushErrorEnum honorPushErrorEnum = values[i2];
            ENUM_MAPPER.put(honorPushErrorEnum.statusCode, honorPushErrorEnum);
            i = i2 + 1;
        }
    }

    HonorPushErrorEnum(int i, String str) {
        this.statusCode = i;
        this.message = str;
    }

    public static HonorPushErrorEnum fromCode(int i) {
        return ENUM_MAPPER.get(i, ERROR_UNKNOWN);
    }

    public final int getErrorCode() {
        return this.statusCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final ApiException toApiException() {
        return new ApiException(getErrorCode(), getMessage());
    }
}
