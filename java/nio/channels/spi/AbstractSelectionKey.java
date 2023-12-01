package java.nio.channels.spi;

import java.nio.channels.SelectionKey;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/spi/AbstractSelectionKey.class */
public abstract class AbstractSelectionKey extends SelectionKey {
    boolean isValid = true;

    @Override // java.nio.channels.SelectionKey
    public final void cancel() {
        if (this.isValid) {
            this.isValid = false;
            ((AbstractSelector) selector()).cancel(this);
        }
    }

    @Override // java.nio.channels.SelectionKey
    public final boolean isValid() {
        return this.isValid;
    }
}
