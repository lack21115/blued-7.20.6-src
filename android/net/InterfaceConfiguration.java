package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/InterfaceConfiguration.class */
public class InterfaceConfiguration implements Parcelable {
    public static final Parcelable.Creator<InterfaceConfiguration> CREATOR = new Parcelable.Creator<InterfaceConfiguration>() { // from class: android.net.InterfaceConfiguration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InterfaceConfiguration createFromParcel(Parcel parcel) {
            InterfaceConfiguration interfaceConfiguration = new InterfaceConfiguration();
            interfaceConfiguration.mHwAddr = parcel.readString();
            if (parcel.readByte() == 1) {
                interfaceConfiguration.mAddr = (LinkAddress) parcel.readParcelable(null);
            }
            int readInt = parcel.readInt();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    return interfaceConfiguration;
                }
                interfaceConfiguration.mFlags.add(parcel.readString());
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InterfaceConfiguration[] newArray(int i) {
            return new InterfaceConfiguration[i];
        }
    };
    private static final String FLAG_DOWN = "down";
    private static final String FLAG_UP = "up";
    private LinkAddress mAddr;
    private HashSet<String> mFlags = Sets.newHashSet();
    private String mHwAddr;

    private static void validateFlag(String str) {
        if (str.indexOf(32) >= 0) {
            throw new IllegalArgumentException("flag contains space: " + str);
        }
    }

    public void clearFlag(String str) {
        validateFlag(str);
        this.mFlags.remove(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Iterable<String> getFlags() {
        return this.mFlags;
    }

    public String getHardwareAddress() {
        return this.mHwAddr;
    }

    public LinkAddress getLinkAddress() {
        return this.mAddr;
    }

    public boolean hasFlag(String str) {
        validateFlag(str);
        return this.mFlags.contains(str);
    }

    public boolean isActive() {
        boolean z = false;
        try {
            if (hasFlag(FLAG_UP)) {
                byte[] address = this.mAddr.getAddress().getAddress();
                int length = address.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 >= length) {
                        break;
                    } else if (address[i2] != 0) {
                        z = true;
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void setFlag(String str) {
        validateFlag(str);
        this.mFlags.add(str);
    }

    public void setHardwareAddress(String str) {
        this.mHwAddr = str;
    }

    public void setInterfaceDown() {
        this.mFlags.remove(FLAG_UP);
        this.mFlags.add(FLAG_DOWN);
    }

    public void setInterfaceUp() {
        this.mFlags.remove(FLAG_DOWN);
        this.mFlags.add(FLAG_UP);
    }

    public void setLinkAddress(LinkAddress linkAddress) {
        this.mAddr = linkAddress;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mHwAddr=").append(this.mHwAddr);
        sb.append(" mAddr=").append(String.valueOf(this.mAddr));
        sb.append(" mFlags=").append(getFlags());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mHwAddr);
        if (this.mAddr != null) {
            parcel.writeByte((byte) 1);
            parcel.writeParcelable(this.mAddr, i);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeInt(this.mFlags.size());
        Iterator<String> it = this.mFlags.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
    }
}
