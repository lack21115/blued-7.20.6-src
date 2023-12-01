package android.view;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputEvent.class */
public abstract class InputEvent implements Parcelable {
    protected static final int PARCEL_TOKEN_KEY_EVENT = 2;
    protected static final int PARCEL_TOKEN_MOTION_EVENT = 1;
    private static final boolean TRACK_RECYCLED_LOCATION = false;
    protected boolean mRecycled;
    private RuntimeException mRecycledLocation;
    protected int mSeq = mNextSeq.getAndIncrement();
    private static final AtomicInteger mNextSeq = new AtomicInteger();
    public static final Parcelable.Creator<InputEvent> CREATOR = new Parcelable.Creator<InputEvent>() { // from class: android.view.InputEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputEvent createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt == 2) {
                return KeyEvent.createFromParcelBody(parcel);
            }
            if (readInt == 1) {
                return MotionEvent.createFromParcelBody(parcel);
            }
            throw new IllegalStateException("Unexpected input event type token in parcel.");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputEvent[] newArray(int i) {
            return new InputEvent[i];
        }
    };

    public abstract void cancel();

    public abstract InputEvent copy();

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final InputDevice getDevice() {
        return InputDevice.getDevice(getDeviceId());
    }

    public abstract int getDeviceId();

    public abstract long getEventTime();

    public abstract long getEventTimeNano();

    public int getSequenceNumber() {
        return this.mSeq;
    }

    public abstract int getSource();

    public boolean isFromSource(int i) {
        return (getSource() & i) == i;
    }

    public abstract boolean isTainted();

    /* JADX INFO: Access modifiers changed from: protected */
    public void prepareForReuse() {
        this.mRecycled = false;
        this.mRecycledLocation = null;
        this.mSeq = mNextSeq.getAndIncrement();
    }

    public void recycle() {
        if (this.mRecycled) {
            throw new RuntimeException(toString() + " recycled twice!");
        }
        this.mRecycled = true;
    }

    public void recycleIfNeededAfterDispatch() {
        recycle();
    }

    public abstract void setSource(int i);

    public abstract void setTainted(boolean z);
}
