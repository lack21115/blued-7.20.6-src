package com.tencent.ugc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCFrameQueue.class */
public class UGCFrameQueue<T> {
    private final Deque<T> mDeque = new LinkedList();
    private UGCFrameQueueListener mListener;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCFrameQueue$UGCFrameQueueListener.class */
    public interface UGCFrameQueueListener {
        void onFrameDequeued();
    }

    private void notifyFrameBeenDequeued() {
        UGCFrameQueueListener uGCFrameQueueListener = this.mListener;
        if (uGCFrameQueueListener != null) {
            uGCFrameQueueListener.onFrameDequeued();
        }
    }

    public void clear() {
        synchronized (this.mDeque) {
            this.mDeque.clear();
        }
    }

    public T dequeue() {
        return dequeue(0L);
    }

    public T dequeue(long j) {
        T pollFirst;
        synchronized (this.mDeque) {
            try {
                if (this.mDeque.isEmpty()) {
                    this.mDeque.wait(j);
                }
                pollFirst = this.mDeque.pollFirst();
            } catch (InterruptedException e) {
                return null;
            }
        }
        if (pollFirst != null) {
            notifyFrameBeenDequeued();
        }
        return pollFirst;
    }

    public List<T> dequeueAll() {
        LinkedList linkedList = new LinkedList();
        synchronized (this.mDeque) {
            while (!this.mDeque.isEmpty()) {
                linkedList.add(this.mDeque.pollFirst());
            }
        }
        return linkedList;
    }

    public T peekLast() {
        T peekLast;
        synchronized (this.mDeque) {
            peekLast = this.mDeque.peekLast();
        }
        return peekLast;
    }

    public void queue(T t) {
        synchronized (this.mDeque) {
            this.mDeque.addLast(t);
            this.mDeque.notify();
        }
    }

    public void setUGCFrameQueueListener(UGCFrameQueueListener uGCFrameQueueListener) {
        synchronized (this) {
            this.mListener = uGCFrameQueueListener;
        }
    }

    public int size() {
        int size;
        synchronized (this.mDeque) {
            size = this.mDeque.size();
        }
        return size;
    }
}
