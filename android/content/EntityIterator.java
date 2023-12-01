package android.content;

import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/content/EntityIterator.class */
public interface EntityIterator extends Iterator<Entity> {
    void close();

    void reset();
}
