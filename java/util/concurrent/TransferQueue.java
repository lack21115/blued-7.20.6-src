package java.util.concurrent;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/TransferQueue.class */
public interface TransferQueue<E> extends BlockingQueue<E> {
    int getWaitingConsumerCount();

    boolean hasWaitingConsumer();

    void transfer(E e) throws InterruptedException;

    boolean tryTransfer(E e);

    boolean tryTransfer(E e, long j, TimeUnit timeUnit) throws InterruptedException;
}
