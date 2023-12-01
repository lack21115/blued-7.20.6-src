package okhttp3.internal.http2;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/ErrorCode.class */
public enum ErrorCode {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);
    
    public final int l;

    ErrorCode(int i) {
        this.l = i;
    }

    public static ErrorCode a(int i) {
        ErrorCode[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return null;
            }
            ErrorCode errorCode = values[i3];
            if (errorCode.l == i) {
                return errorCode;
            }
            i2 = i3 + 1;
        }
    }
}
