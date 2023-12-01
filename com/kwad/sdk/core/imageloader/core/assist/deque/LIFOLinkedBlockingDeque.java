package com.kwad.sdk.core.imageloader.core.assist.deque;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/core/assist/deque/LIFOLinkedBlockingDeque.class */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque, java.util.concurrent.BlockingQueue
    public boolean offer(T t) {
        return super.offerFirst(t);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, com.kwad.sdk.core.imageloader.core.assist.deque.BlockingDeque, com.kwad.sdk.core.imageloader.core.assist.deque.Deque
    public T remove() {
        return (T) super.removeFirst();
    }
}
