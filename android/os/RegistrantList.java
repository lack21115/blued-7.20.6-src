package android.os;

import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/os/RegistrantList.class */
public class RegistrantList {
    ArrayList registrants = new ArrayList();

    private void internalNotifyRegistrants(Object obj, Throwable th) {
        synchronized (this) {
            int size = this.registrants.size();
            for (int i = 0; i < size; i++) {
                ((Registrant) this.registrants.get(i)).internalNotifyRegistrant(obj, th);
            }
        }
    }

    public void add(Handler handler, int i, Object obj) {
        synchronized (this) {
            add(new Registrant(handler, i, obj));
        }
    }

    public void add(Registrant registrant) {
        synchronized (this) {
            removeCleared();
            this.registrants.add(registrant);
        }
    }

    public void addUnique(Handler handler, int i, Object obj) {
        synchronized (this) {
            remove(handler);
            add(new Registrant(handler, i, obj));
        }
    }

    public Object get(int i) {
        Object obj;
        synchronized (this) {
            obj = this.registrants.get(i);
        }
        return obj;
    }

    public void notifyException(Throwable th) {
        internalNotifyRegistrants(null, th);
    }

    public void notifyRegistrants() {
        internalNotifyRegistrants(null, null);
    }

    public void notifyRegistrants(AsyncResult asyncResult) {
        internalNotifyRegistrants(asyncResult.result, asyncResult.exception);
    }

    public void notifyResult(Object obj) {
        internalNotifyRegistrants(obj, null);
    }

    public void remove(Handler handler) {
        synchronized (this) {
            int size = this.registrants.size();
            for (int i = 0; i < size; i++) {
                Registrant registrant = (Registrant) this.registrants.get(i);
                Handler handler2 = registrant.getHandler();
                if (handler2 == null || handler2 == handler) {
                    registrant.clear();
                }
            }
            removeCleared();
        }
    }

    public void removeCleared() {
        synchronized (this) {
            int size = this.registrants.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    if (((Registrant) this.registrants.get(i)).refH == null) {
                        this.registrants.remove(i);
                    }
                    size = i;
                }
            }
        }
    }

    public int size() {
        int size;
        synchronized (this) {
            size = this.registrants.size();
        }
        return size;
    }
}
