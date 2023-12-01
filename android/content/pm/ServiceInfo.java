package android.content.pm;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/ServiceInfo.class */
public class ServiceInfo extends ComponentInfo implements Parcelable {
    public static final Parcelable.Creator<ServiceInfo> CREATOR = new Parcelable.Creator<ServiceInfo>() { // from class: android.content.pm.ServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceInfo createFromParcel(Parcel parcel) {
            return new ServiceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ServiceInfo[] newArray(int i) {
            return new ServiceInfo[i];
        }
    };
    public static final int FLAG_ISOLATED_PROCESS = 2;
    public static final int FLAG_SINGLE_USER = 1073741824;
    public static final int FLAG_STOP_WITH_TASK = 1;
    public int flags;
    public String permission;

    public ServiceInfo() {
    }

    public ServiceInfo(ServiceInfo serviceInfo) {
        super(serviceInfo);
        this.permission = serviceInfo.permission;
        this.flags = serviceInfo.flags;
    }

    private ServiceInfo(Parcel parcel) {
        super(parcel);
        this.permission = parcel.readString();
        this.flags = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        super.dumpFront(printer, str);
        printer.println(str + "permission=" + this.permission);
        printer.println(str + "flags=0x" + Integer.toHexString(this.flags));
    }

    public String toString() {
        return "ServiceInfo{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.name + i.d;
    }

    @Override // android.content.pm.ComponentInfo, android.content.pm.PackageItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.permission);
        parcel.writeInt(this.flags);
    }
}
