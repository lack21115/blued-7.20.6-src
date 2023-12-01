package android.telecom;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/AudioState.class */
public final class AudioState implements Parcelable {
    public static final Parcelable.Creator<AudioState> CREATOR = new Parcelable.Creator<AudioState>() { // from class: android.telecom.AudioState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioState createFromParcel(Parcel parcel) {
            return new AudioState(parcel.readByte() != 0, parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AudioState[] newArray(int i) {
            return new AudioState[i];
        }
    };
    public static final int ROUTE_ALL = 15;
    public static final int ROUTE_BLUETOOTH = 2;
    public static final int ROUTE_EARPIECE = 1;
    public static final int ROUTE_SPEAKER = 8;
    public static final int ROUTE_WIRED_HEADSET = 4;
    public static final int ROUTE_WIRED_OR_EARPIECE = 5;
    public final boolean isMuted;
    public final int route;
    public final int supportedRouteMask;

    public AudioState(AudioState audioState) {
        this.isMuted = audioState.isMuted();
        this.route = audioState.getRoute();
        this.supportedRouteMask = audioState.getSupportedRouteMask();
    }

    public AudioState(boolean z, int i, int i2) {
        this.isMuted = z;
        this.route = i;
        this.supportedRouteMask = i2;
    }

    public static String audioRouteToString(int i) {
        if (i == 0 || (i & (-16)) != 0) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ((i & 1) == 1) {
            listAppend(stringBuffer, "EARPIECE");
        }
        if ((i & 2) == 2) {
            listAppend(stringBuffer, "BLUETOOTH");
        }
        if ((i & 4) == 4) {
            listAppend(stringBuffer, "WIRED_HEADSET");
        }
        if ((i & 8) == 8) {
            listAppend(stringBuffer, "SPEAKER");
        }
        return stringBuffer.toString();
    }

    private static void listAppend(StringBuffer stringBuffer, String str) {
        if (stringBuffer.length() > 0) {
            stringBuffer.append(", ");
        }
        stringBuffer.append(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof AudioState)) {
            AudioState audioState = (AudioState) obj;
            return isMuted() == audioState.isMuted() && getRoute() == audioState.getRoute() && getSupportedRouteMask() == audioState.getSupportedRouteMask();
        }
        return false;
    }

    public int getRoute() {
        return this.route;
    }

    public int getSupportedRouteMask() {
        return this.supportedRouteMask;
    }

    public boolean isMuted() {
        return this.isMuted;
    }

    public String toString() {
        return String.format(Locale.US, "[AudioState isMuted: %b, route; %s, supportedRouteMask: %s]", Boolean.valueOf(this.isMuted), audioRouteToString(this.route), audioRouteToString(this.supportedRouteMask));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.isMuted ? 1 : 0));
        parcel.writeInt(this.route);
        parcel.writeInt(this.supportedRouteMask);
    }
}
