package com.android.internal.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.InputChannel;
import com.alipay.sdk.util.i;
import com.android.internal.view.IInputMethodSession;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/InputBindResult.class */
public final class InputBindResult implements Parcelable {
    public static final Parcelable.Creator<InputBindResult> CREATOR = new Parcelable.Creator<InputBindResult>() { // from class: com.android.internal.view.InputBindResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBindResult createFromParcel(Parcel parcel) {
            return new InputBindResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputBindResult[] newArray(int i) {
            return new InputBindResult[i];
        }
    };
    static final String TAG = "InputBindResult";
    public final InputChannel channel;
    public final String id;
    public final IInputMethodSession method;
    public final int sequence;
    public final int userActionNotificationSequenceNumber;

    InputBindResult(Parcel parcel) {
        this.method = IInputMethodSession.Stub.asInterface(parcel.readStrongBinder());
        if (parcel.readInt() != 0) {
            this.channel = (InputChannel) InputChannel.CREATOR.createFromParcel(parcel);
        } else {
            this.channel = null;
        }
        this.id = parcel.readString();
        this.sequence = parcel.readInt();
        this.userActionNotificationSequenceNumber = parcel.readInt();
    }

    public InputBindResult(IInputMethodSession iInputMethodSession, InputChannel inputChannel, String str, int i, int i2) {
        this.method = iInputMethodSession;
        this.channel = inputChannel;
        this.id = str;
        this.sequence = i;
        this.userActionNotificationSequenceNumber = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        if (this.channel != null) {
            return this.channel.describeContents();
        }
        return 0;
    }

    public String toString() {
        return "InputBindResult{" + this.method + " " + this.id + " sequence:" + this.sequence + " userActionNotificationSequenceNumber:" + this.userActionNotificationSequenceNumber + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongInterface(this.method);
        if (this.channel != null) {
            parcel.writeInt(1);
            this.channel.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.id);
        parcel.writeInt(this.sequence);
        parcel.writeInt(this.userActionNotificationSequenceNumber);
    }
}
