package com.opos.videocache.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/d.class */
public abstract class d implements com.opos.videocache.a.a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f13743a = Executors.newSingleThreadExecutor();

    /* loaded from: source-8303388-dex2jar.jar:com/opos/videocache/a/d$a.class */
    class a implements Callable<Void> {
        private final File b;

        public a(File file) {
            this.b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() {
            d.this.b(this.b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b = b(list);
        int size = list.size();
        for (File file : list) {
            if (!a(file, b, size)) {
                long length = file.length();
                if (file.delete()) {
                    b -= length;
                    com.opos.cmn.an.f.a.a("LruDiskUsage", "Cache file " + file + " is deleted because it exceeds cache limit");
                    size--;
                } else {
                    com.opos.cmn.an.f.a.d("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
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
    public void b(File file) {
        h.c(file);
        a(h.b(file.getParentFile()));
    }

    @Override // com.opos.videocache.a.a
    public void a(File file) {
        this.f13743a.submit(new a(file));
    }

    protected abstract boolean a(File file, long j, int i);
}
