package android.hardware.display;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/WifiDisplaySessionInfo.class */
public final class WifiDisplaySessionInfo implements Parcelable {
    public static final Parcelable.Creator<WifiDisplaySessionInfo> CREATOR = new Parcelable.Creator<WifiDisplaySessionInfo>() { // from class: android.hardware.display.WifiDisplaySessionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDisplaySessionInfo createFromParcel(Parcel parcel) {
            return new WifiDisplaySessionInfo(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDisplaySessionInfo[] newArray(int i) {
            return new WifiDisplaySessionInfo[i];
        }
    };
    private final boolean mClient;
    private final String mGroupId;
    private final String mIP;
    private final String mPassphrase;
    private final int mSessionId;

    public WifiDisplaySessionInfo() {
        this(true, 0, "", "", "");
    }

    public WifiDisplaySessionInfo(boolean z, int i, String str, String str2, String str3) {
        this.mClient = z;
        this.mSessionId = i;
        this.mGroupId = str;
        this.mPassphrase = str2;
        this.mIP = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getIP() {
        return this.mIP;
    }

    public String getPassphrase() {
        return this.mPassphrase;
    }

    public int getSessionId() {
        return this.mSessionId;
    }

    public boolean isClient() {
        return this.mClient;
    }

    public String toString() {
        return "WifiDisplaySessionInfo:\n    Client/Owner: " + (this.mClient ? "Client" : "Owner") + "\n    GroupId: " + this.mGroupId + "\n    Passphrase: " + this.mPassphrase + "\n    SessionId: " + this.mSessionId + "\n    IP Address: " + this.mIP;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mClient ? 1 : 0);
        parcel.writeInt(this.mSessionId);
        parcel.writeString(this.mGroupId);
        parcel.writeString(this.mPassphrase);
        parcel.writeString(this.mIP);
    }
}
