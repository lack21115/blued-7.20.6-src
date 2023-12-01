package android.os;

import android.os.Parcelable;
import android.util.TimeUtils;

/* loaded from: source-9557208-dex2jar.jar:android/os/Message.class */
public final class Message implements Parcelable {
    static final int FLAGS_TO_CLEAR_ON_COPY_FROM = 1;
    static final int FLAG_ASYNCHRONOUS = 2;
    static final int FLAG_IN_USE = 1;
    private static final int MAX_POOL_SIZE = 50;
    private static Message sPool;
    public int arg1;
    public int arg2;
    Runnable callback;
    Bundle data;
    int flags;
    Message next;
    public Object obj;
    public Messenger replyTo;
    public int sendingUid = -1;
    Handler target;
    public int what;
    long when;
    private static final Object sPoolSync = new Object();
    private static int sPoolSize = 0;
    private static boolean gCheckRecycle = true;
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() { // from class: android.os.Message.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message createFromParcel(Parcel parcel) {
            Message obtain = Message.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Message[] newArray(int i) {
            return new Message[i];
        }
    };

    public static Message obtain() {
        synchronized (sPoolSync) {
            if (sPool != null) {
                Message message = sPool;
                sPool = message.next;
                message.next = null;
                message.flags = 0;
                sPoolSize--;
                return message;
            }
            return new Message();
        }
    }

    public static Message obtain(Handler handler) {
        Message obtain = obtain();
        obtain.target = handler;
        return obtain;
    }

    public static Message obtain(Handler handler, int i) {
        Message obtain = obtain();
        obtain.target = handler;
        obtain.what = i;
        return obtain;
    }

    public static Message obtain(Handler handler, int i, int i2, int i3) {
        Message obtain = obtain();
        obtain.target = handler;
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        return obtain;
    }

    public static Message obtain(Handler handler, int i, int i2, int i3, Object obj) {
        Message obtain = obtain();
        obtain.target = handler;
        obtain.what = i;
        obtain.arg1 = i2;
        obtain.arg2 = i3;
        obtain.obj = obj;
        return obtain;
    }

    public static Message obtain(Handler handler, int i, Object obj) {
        Message obtain = obtain();
        obtain.target = handler;
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    public static Message obtain(Handler handler, Runnable runnable) {
        Message obtain = obtain();
        obtain.target = handler;
        obtain.callback = runnable;
        return obtain;
    }

    public static Message obtain(Message message) {
        Message obtain = obtain();
        obtain.what = message.what;
        obtain.arg1 = message.arg1;
        obtain.arg2 = message.arg2;
        obtain.obj = message.obj;
        obtain.replyTo = message.replyTo;
        obtain.sendingUid = message.sendingUid;
        if (message.data != null) {
            obtain.data = new Bundle(message.data);
        }
        obtain.target = message.target;
        obtain.callback = message.callback;
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        this.what = parcel.readInt();
        this.arg1 = parcel.readInt();
        this.arg2 = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.obj = parcel.readParcelable(getClass().getClassLoader());
        }
        this.when = parcel.readLong();
        this.data = parcel.readBundle();
        this.replyTo = Messenger.readMessengerOrNullFromParcel(parcel);
        this.sendingUid = parcel.readInt();
    }

    public static void updateCheckRecycle(int i) {
        if (i < 21) {
            gCheckRecycle = false;
        }
    }

    public void copyFrom(Message message) {
        this.flags = message.flags & (-2);
        this.what = message.what;
        this.arg1 = message.arg1;
        this.arg2 = message.arg2;
        this.obj = message.obj;
        this.replyTo = message.replyTo;
        this.sendingUid = message.sendingUid;
        if (message.data != null) {
            this.data = (Bundle) message.data.clone();
        } else {
            this.data = null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Runnable getCallback() {
        return this.callback;
    }

    public Bundle getData() {
        if (this.data == null) {
            this.data = new Bundle();
        }
        return this.data;
    }

    public Handler getTarget() {
        return this.target;
    }

    public long getWhen() {
        return this.when;
    }

    public boolean isAsynchronous() {
        return (this.flags & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isInUse() {
        return (this.flags & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markInUse() {
        this.flags |= 1;
    }

    public Bundle peekData() {
        return this.data;
    }

    public void recycle() {
        if (!isInUse()) {
            recycleUnchecked();
        } else if (gCheckRecycle) {
            throw new IllegalStateException("This message cannot be recycled because it is still in use.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycleUnchecked() {
        this.flags = 1;
        this.what = 0;
        this.arg1 = 0;
        this.arg2 = 0;
        this.obj = null;
        this.replyTo = null;
        this.sendingUid = -1;
        this.when = 0L;
        this.target = null;
        this.callback = null;
        this.data = null;
        synchronized (sPoolSync) {
            if (sPoolSize < 50) {
                this.next = sPool;
                sPool = this;
                sPoolSize++;
            }
        }
    }

    public void sendToTarget() {
        this.target.sendMessage(this);
    }

    public void setAsynchronous(boolean z) {
        if (z) {
            this.flags |= 2;
        } else {
            this.flags &= -3;
        }
    }

    public void setData(Bundle bundle) {
        this.data = bundle;
    }

    public void setTarget(Handler handler) {
        this.target = handler;
    }

    public String toString() {
        return toString(SystemClock.uptimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append("{ when=");
        TimeUtils.formatDuration(this.when - j, sb);
        if (this.target != null) {
            if (this.callback != null) {
                sb.append(" callback=");
                sb.append(this.callback.getClass().getName());
            } else {
                sb.append(" what=");
                sb.append(this.what);
            }
            if (this.arg1 != 0) {
                sb.append(" arg1=");
                sb.append(this.arg1);
            }
            if (this.arg2 != 0) {
                sb.append(" arg2=");
                sb.append(this.arg2);
            }
            if (this.obj != null) {
                sb.append(" obj=");
                sb.append(this.obj);
            }
            sb.append(" target=");
            sb.append(this.target.getClass().getName());
        } else {
            sb.append(" barrier=");
            sb.append(this.arg1);
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.callback != null) {
            throw new RuntimeException("Can't marshal callbacks across processes.");
        }
        parcel.writeInt(this.what);
        parcel.writeInt(this.arg1);
        parcel.writeInt(this.arg2);
        if (this.obj != null) {
            try {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) this.obj, i);
            } catch (ClassCastException e) {
                throw new RuntimeException("Can't marshal non-Parcelable objects across processes.");
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeLong(this.when);
        parcel.writeBundle(this.data);
        Messenger.writeMessengerOrNullToParcel(this.replyTo, parcel);
        parcel.writeInt(this.sendingUid);
    }
}
