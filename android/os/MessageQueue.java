package android.os;

import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/os/MessageQueue.class */
public final class MessageQueue {
    private boolean mBlocked;
    Message mMessages;
    private int mNextBarrierToken;
    private IdleHandler[] mPendingIdleHandlers;
    private final boolean mQuitAllowed;
    private boolean mQuitting;
    private final ArrayList<IdleHandler> mIdleHandlers = new ArrayList<>();
    private long mPtr = nativeInit();

    /* loaded from: source-9557208-dex2jar.jar:android/os/MessageQueue$IdleHandler.class */
    public interface IdleHandler {
        boolean queueIdle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageQueue(boolean z) {
        this.mQuitAllowed = z;
    }

    private void dispose() {
        if (this.mPtr != 0) {
            nativeDestroy(this.mPtr);
            this.mPtr = 0L;
        }
    }

    private boolean isIdlingLocked() {
        return !this.mQuitting && nativeIsIdling(this.mPtr);
    }

    private static native void nativeDestroy(long j);

    private static native long nativeInit();

    private static native boolean nativeIsIdling(long j);

    private static native void nativePollOnce(long j, int i);

    private static native void nativeWake(long j);

    private void removeAllFutureMessagesLocked() {
        Message message;
        long uptimeMillis = SystemClock.uptimeMillis();
        Message message2 = this.mMessages;
        if (message2 == null) {
            return;
        }
        Message message3 = message2;
        if (message2.when > uptimeMillis) {
            removeAllMessagesLocked();
            return;
        }
        while (true) {
            Message message4 = message3.next;
            if (message4 == null) {
                return;
            }
            if (message4.when > uptimeMillis) {
                message3.next = null;
                Message message5 = message4;
                do {
                    message = message5.next;
                    message5.recycleUnchecked();
                    message5 = message;
                } while (message != null);
                return;
            }
            message3 = message4;
        }
    }

    private void removeAllMessagesLocked() {
        Message message = this.mMessages;
        while (true) {
            Message message2 = message;
            if (message2 == null) {
                this.mMessages = null;
                return;
            }
            Message message3 = message2.next;
            message2.recycleUnchecked();
            message = message3;
        }
    }

    public void addIdleHandler(IdleHandler idleHandler) {
        if (idleHandler == null) {
            throw new NullPointerException("Can't add a null IdleHandler");
        }
        synchronized (this) {
            this.mIdleHandlers.add(idleHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(Printer printer, String str) {
        synchronized (this) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = 0;
            for (Message message = this.mMessages; message != null; message = message.next) {
                printer.println(str + "Message " + i + ": " + message.toString(uptimeMillis));
                i++;
            }
            printer.println(str + "(Total messages: " + i + ", idling=" + isIdlingLocked() + ", quitting=" + this.mQuitting + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean enqueueMessage(Message message, long j) {
        boolean z;
        Message message2;
        if (message.target == null) {
            throw new IllegalArgumentException("Message must have a target.");
        }
        if (message.isInUse()) {
            throw new IllegalStateException(message + " This message is already in use.");
        }
        synchronized (this) {
            if (this.mQuitting) {
                IllegalStateException illegalStateException = new IllegalStateException(message.target + " sending message to a Handler on a dead thread");
                Log.w("MessageQueue", illegalStateException.getMessage(), illegalStateException);
                message.recycle();
                return false;
            }
            message.markInUse();
            message.when = j;
            Message message3 = this.mMessages;
            if (message3 == null || j == 0 || j < message3.when) {
                message.next = message3;
                this.mMessages = message;
                z = this.mBlocked;
            } else {
                z = false;
                Message message4 = message3;
                if (this.mBlocked) {
                    z = false;
                    message4 = message3;
                    if (message3.target == null) {
                        z = false;
                        message4 = message3;
                        if (message.isAsynchronous()) {
                            z = true;
                            message4 = message3;
                        }
                    }
                }
                while (true) {
                    message2 = message4.next;
                    if (message2 == null || j < message2.when) {
                        break;
                    }
                    message4 = message2;
                    if (z) {
                        message4 = message2;
                        if (message2.isAsynchronous()) {
                            z = false;
                            message4 = message2;
                        }
                    }
                }
                message.next = message2;
                message4.next = message;
            }
            if (z) {
                nativeWake(this.mPtr);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int enqueueSyncBarrier(long j) {
        int i;
        synchronized (this) {
            i = this.mNextBarrierToken;
            this.mNextBarrierToken = i + 1;
            Message obtain = Message.obtain();
            obtain.markInUse();
            obtain.when = j;
            obtain.arg1 = i;
            Message message = null;
            Message message2 = null;
            Message message3 = this.mMessages;
            Message message4 = message3;
            if (j != 0) {
                while (true) {
                    message4 = message3;
                    message = message2;
                    if (message3 == null) {
                        break;
                    }
                    message4 = message3;
                    message = message2;
                    if (message3.when > j) {
                        break;
                    }
                    message2 = message3;
                    message3 = message3.next;
                }
            }
            if (message != null) {
                obtain.next = message4;
                message.next = obtain;
            } else {
                obtain.next = message4;
                this.mMessages = obtain;
            }
        }
        return i;
    }

    protected void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMessages(Handler handler, int i, Object obj) {
        if (handler == null) {
            return false;
        }
        synchronized (this) {
            for (Message message = this.mMessages; message != null; message = message.next) {
                if (message.target == handler && message.what == i && (obj == null || message.obj == obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMessages(Handler handler, Runnable runnable, Object obj) {
        if (handler == null) {
            return false;
        }
        synchronized (this) {
            for (Message message = this.mMessages; message != null; message = message.next) {
                if (message.target == handler && message.callback == runnable && (obj == null || message.obj == obj)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isIdling() {
        boolean isIdlingLocked;
        synchronized (this) {
            isIdlingLocked = isIdlingLocked();
        }
        return isIdlingLocked;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x018f, code lost:
        r6 = 0;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f7, code lost:
        if (r0 < r5.mMessages.when) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0139, code lost:
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013b, code lost:
        r6 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x013d, code lost:
        if (r6 >= r8) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0140, code lost:
        r0 = r5.mPendingIdleHandlers[r6];
        r5.mPendingIdleHandlers[r6] = null;
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x015d, code lost:
        r13 = r0.queueIdle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0179, code lost:
        r16 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x017b, code lost:
        android.util.Log.wtf("MessageQueue", "IdleHandler threw exception", r16);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.os.Message next() {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.MessageQueue.next():android.os.Message");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void quit(boolean z) {
        if (!this.mQuitAllowed) {
            throw new IllegalStateException("Main thread not allowed to quit.");
        }
        synchronized (this) {
            if (this.mQuitting) {
                return;
            }
            this.mQuitting = true;
            if (z) {
                removeAllFutureMessagesLocked();
            } else {
                removeAllMessagesLocked();
            }
            nativeWake(this.mPtr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCallbacksAndMessages(Handler handler, Object obj) {
        Message message;
        if (handler == null) {
            return;
        }
        synchronized (this) {
            Message message2 = this.mMessages;
            while (true) {
                Message message3 = message2;
                message = message3;
                if (message3 == null) {
                    break;
                }
                message = message3;
                if (message3.target != handler) {
                    break;
                }
                if (obj != null) {
                    message = message3;
                    if (message3.obj != obj) {
                        break;
                    }
                }
                Message message4 = message3.next;
                this.mMessages = message4;
                message3.recycleUnchecked();
                message2 = message4;
            }
            while (message != null) {
                Message message5 = message.next;
                if (message5 != null && message5.target == handler && (obj == null || message5.obj == obj)) {
                    Message message6 = message5.next;
                    message5.recycleUnchecked();
                    message.next = message6;
                } else {
                    message = message5;
                }
            }
        }
    }

    public void removeIdleHandler(IdleHandler idleHandler) {
        synchronized (this) {
            this.mIdleHandlers.remove(idleHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMessages(Handler handler, int i, Object obj) {
        Message message;
        if (handler == null) {
            return;
        }
        synchronized (this) {
            Message message2 = this.mMessages;
            while (true) {
                Message message3 = message2;
                message = message3;
                if (message3 == null) {
                    break;
                }
                message = message3;
                if (message3.target != handler) {
                    break;
                }
                message = message3;
                if (message3.what != i) {
                    break;
                }
                if (obj != null) {
                    message = message3;
                    if (message3.obj != obj) {
                        break;
                    }
                }
                Message message4 = message3.next;
                this.mMessages = message4;
                message3.recycleUnchecked();
                message2 = message4;
            }
            while (message != null) {
                Message message5 = message.next;
                if (message5 != null && message5.target == handler && message5.what == i && (obj == null || message5.obj == obj)) {
                    Message message6 = message5.next;
                    message5.recycleUnchecked();
                    message.next = message6;
                } else {
                    message = message5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMessages(Handler handler, Runnable runnable, Object obj) {
        Message message;
        if (handler == null || runnable == null) {
            return;
        }
        synchronized (this) {
            Message message2 = this.mMessages;
            while (true) {
                Message message3 = message2;
                message = message3;
                if (message3 == null) {
                    break;
                }
                message = message3;
                if (message3.target != handler) {
                    break;
                }
                message = message3;
                if (message3.callback != runnable) {
                    break;
                }
                if (obj != null) {
                    message = message3;
                    if (message3.obj != obj) {
                        break;
                    }
                }
                Message message4 = message3.next;
                this.mMessages = message4;
                message3.recycleUnchecked();
                message2 = message4;
            }
            while (message != null) {
                Message message5 = message.next;
                if (message5 != null && message5.target == handler && message5.callback == runnable && (obj == null || message5.obj == obj)) {
                    Message message6 = message5.next;
                    message5.recycleUnchecked();
                    message.next = message6;
                } else {
                    message = message5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeSyncBarrier(int i) {
        boolean z;
        synchronized (this) {
            Message message = null;
            Message message2 = this.mMessages;
            while (message2 != null && (message2.target != null || message2.arg1 != i)) {
                message = message2;
                message2 = message2.next;
            }
            if (message2 == null) {
                throw new IllegalStateException("The specified message queue synchronization  barrier token has not been posted or has already been removed.");
            }
            if (message != null) {
                message.next = message2.next;
                z = false;
            } else {
                this.mMessages = message2.next;
                z = this.mMessages == null || this.mMessages.target != null;
            }
            message2.recycleUnchecked();
            if (z && !this.mQuitting) {
                nativeWake(this.mPtr);
            }
        }
    }
}
