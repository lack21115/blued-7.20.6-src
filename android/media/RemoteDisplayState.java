package android.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/media/RemoteDisplayState.class */
public final class RemoteDisplayState implements Parcelable {
    public static final Parcelable.Creator<RemoteDisplayState> CREATOR = new Parcelable.Creator<RemoteDisplayState>() { // from class: android.media.RemoteDisplayState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteDisplayState createFromParcel(Parcel parcel) {
            return new RemoteDisplayState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoteDisplayState[] newArray(int i) {
            return new RemoteDisplayState[i];
        }
    };
    public static final int DISCOVERY_MODE_ACTIVE = 2;
    public static final int DISCOVERY_MODE_NONE = 0;
    public static final int DISCOVERY_MODE_PASSIVE = 1;
    public static final String SERVICE_INTERFACE = "com.android.media.remotedisplay.RemoteDisplayProvider";
    public final ArrayList<RemoteDisplayInfo> displays;

    /* loaded from: source-9557208-dex2jar.jar:android/media/RemoteDisplayState$RemoteDisplayInfo.class */
    public static final class RemoteDisplayInfo implements Parcelable {
        public static final Parcelable.Creator<RemoteDisplayInfo> CREATOR = new Parcelable.Creator<RemoteDisplayInfo>() { // from class: android.media.RemoteDisplayState.RemoteDisplayInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RemoteDisplayInfo createFromParcel(Parcel parcel) {
                return new RemoteDisplayInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RemoteDisplayInfo[] newArray(int i) {
                return new RemoteDisplayInfo[i];
            }
        };
        public static final int PLAYBACK_VOLUME_FIXED = 0;
        public static final int PLAYBACK_VOLUME_VARIABLE = 1;
        public static final int STATUS_AVAILABLE = 2;
        public static final int STATUS_CONNECTED = 4;
        public static final int STATUS_CONNECTING = 3;
        public static final int STATUS_IN_USE = 1;
        public static final int STATUS_NOT_AVAILABLE = 0;
        public String description;
        public String id;
        public String name;
        public int presentationDisplayId;
        public int status;
        public int volume;
        public int volumeHandling;
        public int volumeMax;

        public RemoteDisplayInfo(RemoteDisplayInfo remoteDisplayInfo) {
            this.id = remoteDisplayInfo.id;
            this.name = remoteDisplayInfo.name;
            this.description = remoteDisplayInfo.description;
            this.status = remoteDisplayInfo.status;
            this.volume = remoteDisplayInfo.volume;
            this.volumeMax = remoteDisplayInfo.volumeMax;
            this.volumeHandling = remoteDisplayInfo.volumeHandling;
            this.presentationDisplayId = remoteDisplayInfo.presentationDisplayId;
        }

        RemoteDisplayInfo(Parcel parcel) {
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.description = parcel.readString();
            this.status = parcel.readInt();
            this.volume = parcel.readInt();
            this.volumeMax = parcel.readInt();
            this.volumeHandling = parcel.readInt();
            this.presentationDisplayId = parcel.readInt();
        }

        public RemoteDisplayInfo(String str) {
            this.id = str;
            this.status = 0;
            this.volumeHandling = 0;
            this.presentationDisplayId = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.id) || TextUtils.isEmpty(this.name)) ? false : true;
        }

        public String toString() {
            return "RemoteDisplayInfo{ id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", status=" + this.status + ", volume=" + this.volume + ", volumeMax=" + this.volumeMax + ", volumeHandling=" + this.volumeHandling + ", presentationDisplayId=" + this.presentationDisplayId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.description);
            parcel.writeInt(this.status);
            parcel.writeInt(this.volume);
            parcel.writeInt(this.volumeMax);
            parcel.writeInt(this.volumeHandling);
            parcel.writeInt(this.presentationDisplayId);
        }
    }

    public RemoteDisplayState() {
        this.displays = new ArrayList<>();
    }

    RemoteDisplayState(Parcel parcel) {
        this.displays = parcel.createTypedArrayList(RemoteDisplayInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isValid() {
        if (this.displays == null) {
            return false;
        }
        int size = this.displays.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (!this.displays.get(i2).isValid()) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.displays);
    }
}
