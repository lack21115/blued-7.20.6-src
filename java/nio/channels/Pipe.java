package java.nio.channels;

import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Pipe.class */
public abstract class Pipe {

    /* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Pipe$SinkChannel.class */
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        /* JADX INFO: Access modifiers changed from: protected */
        public SinkChannel(SelectorProvider selectorProvider) {
            super(selectorProvider);
        }

        @Override // java.nio.channels.SelectableChannel
        public final int validOps() {
            return 4;
        }
    }

    /* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Pipe$SourceChannel.class */
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        /* JADX INFO: Access modifiers changed from: protected */
        public SourceChannel(SelectorProvider selectorProvider) {
            super(selectorProvider);
        }

        @Override // java.nio.channels.SelectableChannel
        public final int validOps() {
            return 1;
        }
    }

    public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }

    public abstract SinkChannel sink();

    public abstract SourceChannel source();
}
