package com.meizu.cloud.pushsdk.c.g;

import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f24076a = new n() { // from class: com.meizu.cloud.pushsdk.c.g.n.1
        @Override // com.meizu.cloud.pushsdk.c.g.n
        public void a() {
        }
    };
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private long f24077c;

    public void a() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.b && this.f24077c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
