package com.blued.android.core.net.deque;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/deque/LIFOLinkedBlockingDeque.class */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.blued.android.core.net.deque.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(T t) {
        return super.b((LIFOLinkedBlockingDeque<T>) t);
    }

    @Override // com.blued.android.core.net.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue
    public T remove() {
        return (T) super.a();
    }
}
