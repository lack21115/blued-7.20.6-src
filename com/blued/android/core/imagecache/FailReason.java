package com.blued.android.core.imagecache;

import android.content.Context;
import android.text.TextUtils;
import com.blued.blued_core.R;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/FailReason.class */
public class FailReason {
    private final FailType a;
    private final Throwable b;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/FailReason$FailType.class */
    public enum FailType {
        SUCCESS,
        IO_ERROR,
        DISK_NO_SPACE,
        DECODING_ERROR,
        NETWORK_DENIED,
        DONOT_ALLOW_DOWNLOAD,
        OUT_OF_MEMORY,
        EMPTY_URL,
        INVALID_SCHEME,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.a = failType;
        this.b = th;
    }

    public static String a(Context context, FailReason failReason, boolean z) {
        if (failReason != null) {
            FailType type = failReason.getType();
            String string = type == FailType.NETWORK_DENIED ? context.getString(R.string.imageloader_network_exception) : type == FailType.DISK_NO_SPACE ? context.getString(R.string.disk_no_space_exception) : context.getString(R.string.imageloader_error_other);
            String str = string;
            if (z) {
                str = string + ", detail:" + failReason.a();
            }
            return str;
        }
        return context.getString(R.string.imageloader_error_other);
    }

    public static boolean a(Throwable th) {
        if (th instanceof IOException) {
            String message = ((IOException) th).getMessage();
            if (TextUtils.isEmpty(message)) {
                return false;
            }
            return message.contains("ENOSPC") || message.contains("No space left on device");
        }
        return false;
    }

    public Throwable a() {
        return this.b;
    }

    public FailType getType() {
        return this.a;
    }
}
