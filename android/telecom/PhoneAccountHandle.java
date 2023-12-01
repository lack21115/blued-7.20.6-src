package android.telecom;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.UserHandle;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/PhoneAccountHandle.class */
public class PhoneAccountHandle implements Parcelable {
    public static final Parcelable.Creator<PhoneAccountHandle> CREATOR = new Parcelable.Creator<PhoneAccountHandle>() { // from class: android.telecom.PhoneAccountHandle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAccountHandle createFromParcel(Parcel parcel) {
            return new PhoneAccountHandle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAccountHandle[] newArray(int i) {
            return new PhoneAccountHandle[i];
        }
    };
    private final ComponentName mComponentName;
    private final String mId;
    private final UserHandle mUserHandle;

    public PhoneAccountHandle(ComponentName componentName, String str) {
        this(componentName, str, Process.myUserHandle());
    }

    public PhoneAccountHandle(ComponentName componentName, String str, UserHandle userHandle) {
        this.mComponentName = componentName;
        this.mId = str;
        this.mUserHandle = userHandle;
    }

    private PhoneAccountHandle(Parcel parcel) {
        this(ComponentName.CREATOR.createFromParcel(parcel), parcel.readString(), UserHandle.CREATOR.createFromParcel(parcel));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof PhoneAccountHandle) && Objects.equals(((PhoneAccountHandle) obj).getComponentName(), getComponentName()) && Objects.equals(((PhoneAccountHandle) obj).getId(), getId()) && Objects.equals(((PhoneAccountHandle) obj).getUserHandle(), getUserHandle());
    }

    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    public String getId() {
        return this.mId;
    }

    public UserHandle getUserHandle() {
        return this.mUserHandle;
    }

    public int hashCode() {
        return Objects.hash(this.mComponentName, this.mId, this.mUserHandle);
    }

    public String toString() {
        return this.mComponentName + ", " + Log.pii(this.mId) + ", " + this.mUserHandle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mComponentName.writeToParcel(parcel, i);
        parcel.writeString(this.mId);
        this.mUserHandle.writeToParcel(parcel, i);
    }
}
