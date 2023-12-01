package com.kwad.sdk.ip.direct;

import android.os.SystemClock;
import com.kwad.sdk.utils.bi;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ip/direct/b.class */
public final class b {
    static int atN = 80;
    static int port = 80;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ip/direct/b$a.class */
    static final class a extends Thread {
        LinkedList atP = new LinkedList();
        volatile boolean atQ = false;
        Selector atO = Selector.open();

        a() {
            setName("Connector");
        }

        private void AU() {
            synchronized (this.atP) {
                while (this.atP.size() > 0) {
                    C0406b c0406b = (C0406b) this.atP.removeFirst();
                    c0406b.atS.register(this.atO, 8, c0406b);
                }
            }
        }

        private void AV() {
            Iterator<SelectionKey> it = this.atO.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey next = it.next();
                it.remove();
                C0406b c0406b = (C0406b) next.attachment();
                SocketChannel socketChannel = (SocketChannel) next.channel();
                try {
                    if (socketChannel.finishConnect()) {
                        next.cancel();
                        c0406b.atW = SystemClock.elapsedRealtime();
                        socketChannel.close();
                    }
                } catch (Throwable th) {
                    bi.c(socketChannel);
                    c0406b.atT = th;
                }
            }
        }

        final void a(C0406b c0406b) {
            SocketChannel socketChannel;
            try {
                socketChannel = SocketChannel.open();
                try {
                    socketChannel.configureBlocking(false);
                    boolean connect = socketChannel.connect(c0406b.atR);
                    c0406b.atS = socketChannel;
                    c0406b.atV = SystemClock.elapsedRealtime();
                    if (connect) {
                        c0406b.atW = c0406b.atV;
                        bi.c(socketChannel);
                        return;
                    }
                    synchronized (this.atP) {
                        this.atP.add(c0406b);
                    }
                    if (this.atO != null) {
                        try {
                            this.atO.wakeup();
                        } catch (Throwable th) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bi.c(socketChannel);
                    c0406b.atT = th;
                }
            } catch (Throwable th3) {
                th = th3;
                socketChannel = null;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            while (true) {
                try {
                    if (this.atO.select() > 0) {
                        AV();
                    }
                    AU();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (this.atQ) {
                    if (this.atO != null) {
                        try {
                            this.atO.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                continue;
            }
        }

        final void shutdown() {
            this.atQ = true;
            Selector selector = this.atO;
            if (selector != null) {
                try {
                    selector.wakeup();
                } catch (Throwable th) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.ip.direct.b$b  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ip/direct/b$b.class */
    public static final class C0406b {
        InetSocketAddress atR;
        SocketChannel atS;
        Throwable atT;
        private float atU;
        long atV;
        long atW = 0;
        boolean atX = false;
        private boolean success;

        C0406b(String str) {
            try {
                this.atR = new InetSocketAddress(InetAddress.getByName(str), b.port);
            } catch (Throwable th) {
                this.atT = th;
            }
        }

        final void AW() {
            String str;
            if (this.atW != 0) {
                str = Long.toString(this.atW - this.atV) + "ms";
                this.atU = (float) (this.atW - this.atV);
                this.success = true;
            } else {
                Throwable th = this.atT;
                if (th != null) {
                    str = th.toString();
                    this.success = false;
                } else {
                    this.success = false;
                    str = "Timed out";
                }
            }
            com.kwad.sdk.core.d.b.d("IpDirect_Ping", this.atR + " : " + str);
            this.atX = true;
        }
    }

    public static c f(String str, long j) {
        a aVar;
        long j2 = j / 5;
        com.kwad.sdk.core.d.b.d("IpDirect_Ping", "ping:" + str);
        c cVar = new c(str);
        try {
            aVar = new a();
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar == null) {
            return cVar;
        }
        try {
            aVar.start();
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVar.AX()) {
                    try {
                        break;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return cVar;
                    }
                }
                C0406b c0406b = new C0406b(str);
                linkedList.add(c0406b);
                try {
                    aVar.a(c0406b);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                i = i2 + 1;
            }
            Thread.sleep(j + j2);
            try {
                aVar.shutdown();
                aVar.join();
                float f = 0.0f;
                Iterator it = linkedList.iterator();
                boolean z = true;
                while (it.hasNext()) {
                    C0406b c0406b2 = (C0406b) it.next();
                    c0406b2.AW();
                    z &= c0406b2.success;
                    cVar.bk(z);
                    f += c0406b2.atU;
                }
                com.kwad.sdk.core.d.b.d("IpDirect_Ping", "sum:" + f + "*size:" + linkedList.size());
                cVar.i(f / ((float) linkedList.size()));
                return cVar;
            } catch (Throwable th4) {
                th4.printStackTrace();
                return cVar;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            return cVar;
        }
    }
}
