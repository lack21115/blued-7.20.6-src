package com.ishumei.l111l11111Il.l1111l111111Il;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l1111l111111Il/l111l1111lI1l.class */
public abstract class l111l1111lI1l {
    private String l1111l111111Il = "";

    abstract String l1111l111111Il();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l1111l111111Il(long j) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() { // from class: com.ishumei.l111l11111Il.l1111l111111Il.l111l1111lI1l.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    l111l1111lI1l.this.l1111l111111Il = l111l1111lI1l.this.l1111l111111Il();
                } catch (Throwable th) {
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await(150L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
        return this.l1111l111111Il;
    }
}
