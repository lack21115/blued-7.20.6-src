package com.kwai.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/j.class */
public final class j {
    static int aFM = 10;
    static int aFN = 5;
    private final Executor aFI;
    private final LinkedBlockingQueue<t> aFJ;
    private final Object aFK;
    private final ArrayList<t> aFL;
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/j$a.class */
    public static final class a {
        private static final j aFQ = new j((byte) 0);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwai/filedownloader/j$b.class */
    static final class b implements Handler.Callback {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        private static void b(ArrayList<t> arrayList) {
            Iterator<t> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().Hc();
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((t) message.obj).Hc();
                return true;
            } else if (message.what == 2) {
                b((ArrayList) message.obj);
                j.GY().push();
                return true;
            } else {
                return true;
            }
        }
    }

    private j() {
        this.aFI = com.kwai.filedownloader.e.b.n(5, "BlockCompleted");
        this.aFK = new Object();
        this.aFL = new ArrayList<>();
        this.handler = new Handler(Looper.getMainLooper(), new b((byte) 0));
        this.aFJ = new LinkedBlockingQueue<>();
    }

    /* synthetic */ j(byte b2) {
        this();
    }

    public static j GY() {
        return a.aFQ;
    }

    private static boolean GZ() {
        return aFM > 0;
    }

    private void a(final t tVar, boolean z) {
        if (tVar.Hd()) {
            tVar.Hc();
        } else if (tVar.He()) {
            this.aFI.execute(new Runnable() { // from class: com.kwai.filedownloader.j.1
                @Override // java.lang.Runnable
                public final void run() {
                    tVar.Hc();
                }
            });
        } else {
            if (!GZ() && !this.aFJ.isEmpty()) {
                synchronized (this.aFK) {
                    if (!this.aFJ.isEmpty()) {
                        Iterator<t> it = this.aFJ.iterator();
                        while (it.hasNext()) {
                            b(it.next());
                        }
                    }
                    this.aFJ.clear();
                }
            }
            if (GZ()) {
                c(tVar);
            } else {
                b(tVar);
            }
        }
    }

    private void b(t tVar) {
        Handler handler = this.handler;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    private void c(t tVar) {
        synchronized (this.aFK) {
            this.aFJ.offer(tVar);
        }
        push();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void push() {
        int i;
        synchronized (this.aFK) {
            if (this.aFL.isEmpty()) {
                if (this.aFJ.isEmpty()) {
                    return;
                }
                if (GZ()) {
                    int i2 = aFM;
                    int min = Math.min(this.aFJ.size(), aFN);
                    for (int i3 = 0; i3 < min; i3++) {
                        this.aFL.add(this.aFJ.remove());
                    }
                    i = i2;
                } else {
                    this.aFJ.drainTo(this.aFL);
                    i = 0;
                }
                Handler handler = this.handler;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.aFL), i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(t tVar) {
        a(tVar, false);
    }
}
