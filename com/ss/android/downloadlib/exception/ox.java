package com.ss.android.downloadlib.exception;

import android.text.TextUtils;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/exception/ox.class */
public class ox {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/exception/ox$mb.class */
    public interface mb<T> {
        T ox();
    }

    public static <T> T mb(mb<T> mbVar) {
        return (T) mb(true, null, mbVar);
    }

    public static <T> T mb(boolean z, String str, mb<T> mbVar) {
        try {
            return mbVar.ox();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.exception.mb) {
                throw th;
            }
            b.mb().mb(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static void mb(final Runnable runnable) {
        mb(new mb<Void>() { // from class: com.ss.android.downloadlib.exception.ox.1
            @Override // com.ss.android.downloadlib.exception.ox.mb
            /* renamed from: mb */
            public Void ox() {
                runnable.run();
                return null;
            }
        });
    }
}
