package android.database;

/* loaded from: source-9557208-dex2jar.jar:android/database/DataSetObservable.class */
public class DataSetObservable extends Observable<DataSetObserver> {
    public void notifyChanged() {
        synchronized (this.mObservers) {
            int size = this.mObservers.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    ((DataSetObserver) this.mObservers.get(i)).onChanged();
                    size = i;
                }
            }
        }
    }

    public void notifyInvalidated() {
        synchronized (this.mObservers) {
            int size = this.mObservers.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    ((DataSetObserver) this.mObservers.get(i)).onInvalidated();
                    size = i;
                }
            }
        }
    }
}
