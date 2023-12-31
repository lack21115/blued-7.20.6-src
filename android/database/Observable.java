package android.database;

import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/database/Observable.class */
public abstract class Observable<T> {
    protected final ArrayList<T> mObservers = new ArrayList<>();

    public void registerObserver(T t) {
        if (t == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (this.mObservers) {
            if (this.mObservers.contains(t)) {
                throw new IllegalStateException("Observer " + t + " is already registered.");
            }
            this.mObservers.add(t);
        }
    }

    public void unregisterAll() {
        synchronized (this.mObservers) {
            this.mObservers.clear();
        }
    }

    public void unregisterObserver(T t) {
        if (t == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (this.mObservers) {
            int indexOf = this.mObservers.indexOf(t);
            if (indexOf == -1) {
                throw new IllegalStateException("Observer " + t + " was not registered.");
            }
            this.mObservers.remove(indexOf);
        }
    }
}
