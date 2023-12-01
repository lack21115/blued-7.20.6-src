package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WpsResult.class */
public class WpsResult implements Parcelable {
    public static final Parcelable.Creator<WpsResult> CREATOR = new Parcelable.Creator<WpsResult>() { // from class: android.net.wifi.WpsResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WpsResult createFromParcel(Parcel parcel) {
            WpsResult wpsResult = new WpsResult();
            wpsResult.status = Status.valueOf(parcel.readString());
            wpsResult.pin = parcel.readString();
            return wpsResult;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WpsResult[] newArray(int i) {
            return new WpsResult[i];
        }
    };
    public String pin;
    public Status status;

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WpsResult$Status.class */
    public enum Status {
        SUCCESS,
        FAILURE,
        IN_PROGRESS
    }

    public WpsResult() {
        this.status = Status.FAILURE;
        this.pin = null;
    }

    public WpsResult(Status status) {
        this.status = status;
        this.pin = null;
    }

    public WpsResult(WpsResult wpsResult) {
        if (wpsResult != null) {
            this.status = wpsResult.status;
            this.pin = wpsResult.pin;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" status: ").append(this.status.toString());
        stringBuffer.append('\n');
        stringBuffer.append(" pin: ").append(this.pin);
        stringBuffer.append("\n");
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.status.name());
        parcel.writeString(this.pin);
    }
}
