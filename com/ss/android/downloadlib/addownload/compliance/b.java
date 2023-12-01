package com.ss.android.downloadlib.addownload.compliance;

import com.ss.android.socialbase.downloader.utils.LruCache;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/b.class */
public class b extends LruCache<Long, com.ss.android.downloadlib.addownload.model.ox> {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/addownload/compliance/b$mb.class */
    static class mb {
        private static b mb = new b();
    }

    private b() {
        super(16, 16);
    }

    public static b mb() {
        return mb.mb;
    }

    public com.ss.android.downloadlib.addownload.model.ox mb(long j) {
        return (com.ss.android.downloadlib.addownload.model.ox) get(Long.valueOf(j));
    }

    public com.ss.android.downloadlib.addownload.model.ox mb(long j, long j2) {
        return (com.ss.android.downloadlib.addownload.model.ox) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public void mb(com.ss.android.downloadlib.addownload.model.ox oxVar) {
        if (oxVar == null) {
            return;
        }
        put(Long.valueOf(oxVar.mb()), oxVar);
    }
}
