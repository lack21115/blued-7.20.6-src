package java.nio.channels;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/SelectionKey.class */
public abstract class SelectionKey {
    public static final int OP_ACCEPT = 16;
    public static final int OP_CONNECT = 8;
    public static final int OP_READ = 1;
    public static final int OP_WRITE = 4;
    private volatile Object attachment = null;

    public final Object attach(Object obj) {
        Object obj2 = this.attachment;
        this.attachment = obj;
        return obj2;
    }

    public final Object attachment() {
        return this.attachment;
    }

    public abstract void cancel();

    public abstract SelectableChannel channel();

    public abstract int interestOps();

    public abstract SelectionKey interestOps(int i);

    public final boolean isAcceptable() {
        return (readyOps() & 16) == 16;
    }

    public final boolean isConnectable() {
        return (readyOps() & 8) == 8;
    }

    public final boolean isReadable() {
        return (readyOps() & 1) == 1;
    }

    public abstract boolean isValid();

    public final boolean isWritable() {
        return (readyOps() & 4) == 4;
    }

    public abstract int readyOps();

    public abstract Selector selector();
}
