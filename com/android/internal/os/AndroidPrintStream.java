package com.android.internal.os;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/AndroidPrintStream.class */
public class AndroidPrintStream extends LoggingPrintStream {
    private final int priority;
    private final String tag;

    public AndroidPrintStream(int i, String str) {
        if (str == null) {
            throw new NullPointerException("tag");
        }
        this.priority = i;
        this.tag = str;
    }

    @Override // com.android.internal.os.LoggingPrintStream
    protected void log(String str) {
        Log.println(this.priority, this.tag, str);
    }
}
