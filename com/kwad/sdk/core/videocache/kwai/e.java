package com.kwad.sdk.core.videocache.kwai;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/e.class */
public abstract class e implements com.kwad.sdk.core.videocache.kwai.a {
    private final ExecutorService aok = GlobalThreadPools.xL();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/videocache/kwai/e$a.class */
    final class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: vi */
        public Void call() {
            e.this.u(this.file);
            return null;
        }
    }

    private void r(List<File> list) {
        long s = s(list);
        list.size();
        for (File file : list) {
            if (!W(s)) {
                long length = file.length();
                if (file.delete()) {
                    s -= length;
                } else {
                    com.kwad.sdk.core.d.b.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long s(List<File> list) {
        Iterator<File> it = list.iterator();
        long j = 0;
        while (true) {
            long j2 = j;
            if (!it.hasNext()) {
                return j2;
            }
            j = j2 + it.next().length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(File file) {
        d.r(file);
        r(d.q(file.getParentFile()));
    }

    protected abstract boolean W(long j);

    @Override // com.kwad.sdk.core.videocache.kwai.a
    public final void n(File file) {
        this.aok.submit(new a(file));
    }
}
