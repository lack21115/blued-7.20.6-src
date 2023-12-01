package com.kwad.sdk.core.diskcache;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.av;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/ApkCacheManager.class */
public class ApkCacheManager {
    private Future aei;
    private File aej;
    private final ExecutorService aek;
    private final Callable<Void> ael;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/diskcache/ApkCacheManager$Holder.class */
    public enum Holder {
        INSTANCE;
        
        private ApkCacheManager mInstance = new ApkCacheManager((byte) 0);

        Holder() {
        }

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    private ApkCacheManager() {
        this.aek = GlobalThreadPools.xU();
        this.ael = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: vi */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    try {
                        if (ApkCacheManager.this.aej != null && ApkCacheManager.this.aej.exists() && !ApkCacheManager.this.vg()) {
                            for (File file : ApkCacheManager.this.i(ApkCacheManager.this.aej)) {
                                if (file.getName().endsWith(".apk")) {
                                    ApkCacheManager.this.c(file);
                                    if (ApkCacheManager.this.vg()) {
                                        return null;
                                    }
                                }
                            }
                            return null;
                        }
                        return null;
                    } finally {
                    }
                }
            }
        };
        if (((e) ServiceProvider.get(e.class)).getContext() == null) {
            return;
        }
        try {
            this.aej = av.cB(((e) ServiceProvider.get(e.class)).getContext());
        } catch (Throwable th) {
        }
    }

    /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                    return;
                }
                return;
            }
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    file.delete();
                    return;
                } else {
                    c(listFiles[i2]);
                    i = i2 + 1;
                }
            }
        } catch (Exception e) {
        }
    }

    private int g(File file) {
        return (int) ((((float) h(file)) / 1000.0f) / 1000.0f);
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private long h(File file) {
        File[] listFiles = file.listFiles();
        long j = 0;
        long j2 = 0;
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                j2 = j;
                if (i2 >= length) {
                    break;
                }
                j += listFiles[i2].isDirectory() ? h(listFiles[i2]) : listFiles[i2].length();
                i = i2 + 1;
            }
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> i(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(listFiles));
        m(arrayList);
        return arrayList;
    }

    private void m(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            private static int a(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return a(file, file2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vg() {
        File file = this.aej;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = this.aej.listFiles();
        if (listFiles.length > 5) {
            return listFiles.length <= 10 && g(this.aej) <= 400;
        }
        return true;
    }

    public final void vh() {
        File file = this.aej;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.aei;
        if (future == null || future.isDone()) {
            this.aei = this.aek.submit(this.ael);
        }
    }
}
