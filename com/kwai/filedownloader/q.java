package com.kwai.filedownloader;

import com.kwai.filedownloader.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/q.class */
final class q {
    private final b aGb = new b();

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/q$a.class */
    static final class a {
        private static final q aGc = new q();

        static {
            com.kwai.filedownloader.message.e.Iv().a(new aa());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/q$b.class */
    static final class b {
        private ThreadPoolExecutor aGd;
        private LinkedBlockingQueue<Runnable> aGe;

        b() {
            init();
        }

        private void init() {
            LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
            this.aGe = linkedBlockingQueue;
            this.aGd = com.kwai.filedownloader.e.b.a(3, linkedBlockingQueue, "LauncherTask");
        }

        public final void b(x.b bVar) {
            this.aGe.remove(bVar);
        }

        public final void c(x.b bVar) {
            this.aGd.execute(new c(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/q$c.class */
    public static final class c implements Runnable {
        private final x.b aGf;
        private boolean aGg = false;

        c(x.b bVar) {
            this.aGf = bVar;
        }

        public final boolean equals(Object obj) {
            return super.equals(obj) || obj == this.aGf;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.aGg) {
                return;
            }
            this.aGf.start();
        }
    }

    q() {
    }

    public static q Hn() {
        return a.aGc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(x.b bVar) {
        synchronized (this) {
            this.aGb.c(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(x.b bVar) {
        synchronized (this) {
            this.aGb.b(bVar);
        }
    }
}
