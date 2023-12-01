package android.os;

import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/os/Registrant.class */
public class Registrant {
    WeakReference refH;
    Object userObj;
    int what;

    public Registrant(Handler handler, int i, Object obj) {
        this.refH = new WeakReference(handler);
        this.what = i;
        this.userObj = obj;
    }

    public void clear() {
        this.refH = null;
        this.userObj = null;
    }

    public Handler getHandler() {
        if (this.refH == null) {
            return null;
        }
        return (Handler) this.refH.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void internalNotifyRegistrant(Object obj, Throwable th) {
        Handler handler = getHandler();
        if (handler == null) {
            clear();
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = this.what;
        obtain.obj = new AsyncResult(this.userObj, obj, th);
        handler.sendMessage(obtain);
    }

    public Message messageForRegistrant() {
        Handler handler = getHandler();
        if (handler == null) {
            clear();
            return null;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = this.what;
        obtainMessage.obj = this.userObj;
        return obtainMessage;
    }

    public void notifyException(Throwable th) {
        internalNotifyRegistrant(null, th);
    }

    public void notifyRegistrant() {
        internalNotifyRegistrant(null, null);
    }

    public void notifyRegistrant(AsyncResult asyncResult) {
        internalNotifyRegistrant(asyncResult.result, asyncResult.exception);
    }

    public void notifyResult(Object obj) {
        internalNotifyRegistrant(obj, null);
    }
}
