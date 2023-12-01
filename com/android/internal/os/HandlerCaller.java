package com.android.internal.os;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/HandlerCaller.class */
public class HandlerCaller {
    final Callback mCallback;
    final Handler mH;
    final Looper mMainLooper;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/HandlerCaller$Callback.class */
    public interface Callback {
        void executeMessage(Message message);
    }

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/HandlerCaller$MyHandler.class */
    class MyHandler extends Handler {
        MyHandler(Looper looper, boolean z) {
            super(looper, null, z);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HandlerCaller.this.mCallback.executeMessage(message);
        }
    }

    public HandlerCaller(Context context, Looper looper, Callback callback, boolean z) {
        this.mMainLooper = looper == null ? context.getMainLooper() : looper;
        this.mH = new MyHandler(this.mMainLooper, z);
        this.mCallback = callback;
    }

    public void executeOrSendMessage(Message message) {
        if (Looper.myLooper() != this.mMainLooper) {
            this.mH.sendMessage(message);
            return;
        }
        this.mCallback.executeMessage(message);
        message.recycle();
    }

    public Handler getHandler() {
        return this.mH;
    }

    public boolean hasMessages(int i) {
        return this.mH.hasMessages(i);
    }

    public Message obtainMessage(int i) {
        return this.mH.obtainMessage(i);
    }

    public Message obtainMessageBO(int i, boolean z, Object obj) {
        return this.mH.obtainMessage(i, z ? 1 : 0, 0, obj);
    }

    public Message obtainMessageBOO(int i, boolean z, Object obj, Object obj2) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        return this.mH.obtainMessage(i, z ? 1 : 0, 0, obtain);
    }

    public Message obtainMessageI(int i, int i2) {
        return this.mH.obtainMessage(i, i2, 0);
    }

    public Message obtainMessageII(int i, int i2, int i3) {
        return this.mH.obtainMessage(i, i2, i3);
    }

    public Message obtainMessageIIII(int i, int i2, int i3, int i4, int i5) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi1 = i2;
        obtain.argi2 = i3;
        obtain.argi3 = i4;
        obtain.argi4 = i5;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public Message obtainMessageIIIIII(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.argi1 = i2;
        obtain.argi2 = i3;
        obtain.argi3 = i4;
        obtain.argi4 = i5;
        obtain.argi5 = i6;
        obtain.argi6 = i7;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public Message obtainMessageIIIIO(int i, int i2, int i3, int i4, int i5, Object obj) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.argi1 = i2;
        obtain.argi2 = i3;
        obtain.argi3 = i4;
        obtain.argi4 = i5;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public Message obtainMessageIIO(int i, int i2, int i3, Object obj) {
        return this.mH.obtainMessage(i, i2, i3, obj);
    }

    public Message obtainMessageIIOO(int i, int i2, int i3, Object obj, Object obj2) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        return this.mH.obtainMessage(i, i2, i3, obtain);
    }

    public Message obtainMessageIO(int i, int i2, Object obj) {
        return this.mH.obtainMessage(i, i2, 0, obj);
    }

    public Message obtainMessageIOO(int i, int i2, Object obj, Object obj2) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        return this.mH.obtainMessage(i, i2, 0, obtain);
    }

    public Message obtainMessageIOOO(int i, int i2, Object obj, Object obj2, Object obj3) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        obtain.arg3 = obj3;
        return this.mH.obtainMessage(i, i2, 0, obtain);
    }

    public Message obtainMessageO(int i, Object obj) {
        return this.mH.obtainMessage(i, 0, 0, obj);
    }

    public Message obtainMessageOO(int i, Object obj, Object obj2) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public Message obtainMessageOOO(int i, Object obj, Object obj2, Object obj3) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        obtain.arg3 = obj3;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public Message obtainMessageOOOO(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        obtain.arg3 = obj3;
        obtain.arg4 = obj4;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public Message obtainMessageOOOOO(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        SomeArgs obtain = SomeArgs.obtain();
        obtain.arg1 = obj;
        obtain.arg2 = obj2;
        obtain.arg3 = obj3;
        obtain.arg4 = obj4;
        obtain.arg5 = obj5;
        return this.mH.obtainMessage(i, 0, 0, obtain);
    }

    public void removeMessages(int i) {
        this.mH.removeMessages(i);
    }

    public void removeMessages(int i, Object obj) {
        this.mH.removeMessages(i, obj);
    }

    public void sendMessage(Message message) {
        this.mH.sendMessage(message);
    }

    public SomeArgs sendMessageAndWait(Message message) {
        if (Looper.myLooper() == this.mH.getLooper()) {
            throw new IllegalStateException("Can't wait on same thread as looper");
        }
        SomeArgs someArgs = (SomeArgs) message.obj;
        someArgs.mWaitState = 1;
        this.mH.sendMessage(message);
        synchronized (someArgs) {
            while (someArgs.mWaitState == 1) {
                try {
                    someArgs.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
        }
        someArgs.mWaitState = 0;
        return someArgs;
    }

    public void sendMessageDelayed(Message message, long j) {
        this.mH.sendMessageDelayed(message, j);
    }
}
