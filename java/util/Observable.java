package java.util;

/* loaded from: source-2895416-dex2jar.jar:java/util/Observable.class */
public class Observable {
    List<Observer> observers = new ArrayList();
    boolean changed = false;

    public void addObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!this.observers.contains(observer)) {
                this.observers.add(observer);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearChanged() {
        this.changed = false;
    }

    public int countObservers() {
        return this.observers.size();
    }

    public void deleteObserver(Observer observer) {
        synchronized (this) {
            this.observers.remove(observer);
        }
    }

    public void deleteObservers() {
        synchronized (this) {
            this.observers.clear();
        }
    }

    public boolean hasChanged() {
        return this.changed;
    }

    public void notifyObservers() {
        notifyObservers(null);
    }

    public void notifyObservers(Object obj) {
        Observer[] observerArr = null;
        synchronized (this) {
            if (hasChanged()) {
                clearChanged();
                observerArr = new Observer[this.observers.size()];
                this.observers.toArray(observerArr);
            }
        }
        if (observerArr == null) {
            return;
        }
        int length = observerArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            observerArr[i2].update(this, obj);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setChanged() {
        this.changed = true;
    }
}
