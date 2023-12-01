package android.view;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputChannel.class */
public final class InputChannel implements Parcelable {
    public static final Parcelable.Creator<InputChannel> CREATOR = new Parcelable.Creator<InputChannel>() { // from class: android.view.InputChannel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputChannel createFromParcel(Parcel parcel) {
            InputChannel inputChannel = new InputChannel();
            inputChannel.readFromParcel(parcel);
            return inputChannel;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputChannel[] newArray(int i) {
            return new InputChannel[i];
        }
    };
    private static final boolean DEBUG = false;
    private static final String TAG = "InputChannel";
    private long mPtr;

    private native void nativeDispose(boolean z);

    private native void nativeDup(InputChannel inputChannel);

    private native String nativeGetName();

    private static native InputChannel[] nativeOpenInputChannelPair(String str);

    private native void nativeReadFromParcel(Parcel parcel);

    private native void nativeTransferTo(InputChannel inputChannel);

    private native void nativeWriteToParcel(Parcel parcel);

    public static InputChannel[] openInputChannelPair(String str) {
        if (str == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        return nativeOpenInputChannelPair(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public void dispose() {
        nativeDispose(false);
    }

    public InputChannel dup() {
        InputChannel inputChannel = new InputChannel();
        nativeDup(inputChannel);
        return inputChannel;
    }

    protected void finalize() throws Throwable {
        try {
            nativeDispose(true);
        } finally {
            super.finalize();
        }
    }

    public String getName() {
        String nativeGetName = nativeGetName();
        return nativeGetName != null ? nativeGetName : "uninitialized";
    }

    public void readFromParcel(Parcel parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("in must not be null");
        }
        nativeReadFromParcel(parcel);
    }

    public String toString() {
        return getName();
    }

    public void transferTo(InputChannel inputChannel) {
        if (inputChannel == null) {
            throw new IllegalArgumentException("outParameter must not be null");
        }
        nativeTransferTo(inputChannel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (parcel == null) {
            throw new IllegalArgumentException("out must not be null");
        }
        nativeWriteToParcel(parcel);
        if ((i & 1) != 0) {
            dispose();
        }
    }
}
