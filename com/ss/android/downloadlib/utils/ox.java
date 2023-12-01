package com.ss.android.downloadlib.utils;

import android.os.AsyncTask;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/ox.class */
public class ox {
    static final mb mb = new C0881ox();

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/ox$mb.class */
    static class mb {
        private mb() {
        }

        public <T> void mb(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.utils.ox$ox  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/ox$ox.class */
    static class C0881ox extends mb {
        private C0881ox() {
            super();
        }

        @Override // com.ss.android.downloadlib.utils.ox.mb
        public <T> void mb(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable th) {
            }
        }
    }

    public static <T> void mb(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        mb.mb(asyncTask, tArr);
    }
}
