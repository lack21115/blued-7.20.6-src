package android.os;

import android.os.Parcelable;
import android.util.SparseArray;
import java.io.PrintWriter;

/* loaded from: source-9557208-dex2jar.jar:android/os/UserHandle.class */
public final class UserHandle implements Parcelable {
    public static final boolean MU_ENABLED = true;
    public static final int PER_USER_RANGE = 100000;
    public static final int USER_ALL = -1;
    public static final int USER_CURRENT = -2;
    public static final int USER_CURRENT_OR_SELF = -3;
    public static final int USER_NULL = -10000;
    public static final int USER_OWNER = 0;
    final int mHandle;
    public static final UserHandle ALL = new UserHandle(-1);
    public static final UserHandle CURRENT = new UserHandle(-2);
    public static final UserHandle CURRENT_OR_SELF = new UserHandle(-3);
    public static final UserHandle OWNER = new UserHandle(0);
    private static final SparseArray<UserHandle> userHandles = new SparseArray<>();
    public static final Parcelable.Creator<UserHandle> CREATOR = new Parcelable.Creator<UserHandle>() { // from class: android.os.UserHandle.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserHandle createFromParcel(Parcel parcel) {
            return new UserHandle(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserHandle[] newArray(int i) {
            return new UserHandle[i];
        }
    };

    public UserHandle(int i) {
        this.mHandle = i;
    }

    public UserHandle(Parcel parcel) {
        this.mHandle = parcel.readInt();
    }

    public static void formatUid(PrintWriter printWriter, int i) {
        if (i < 10000) {
            printWriter.print(i);
            return;
        }
        printWriter.print('u');
        printWriter.print(getUserId(i));
        int appId = getAppId(i);
        if (appId >= 99000 && appId <= 99999) {
            printWriter.print('i');
            printWriter.print(appId - Process.FIRST_ISOLATED_UID);
        } else if (appId >= 10000) {
            printWriter.print('a');
            printWriter.print(appId - 10000);
        } else {
            printWriter.print('s');
            printWriter.print(appId);
        }
    }

    public static void formatUid(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append(i);
            return;
        }
        sb.append('u');
        sb.append(getUserId(i));
        int appId = getAppId(i);
        if (appId >= 99000 && appId <= 99999) {
            sb.append('i');
            sb.append(appId - Process.FIRST_ISOLATED_UID);
        } else if (appId >= 10000) {
            sb.append('a');
            sb.append(appId - 10000);
        } else {
            sb.append('s');
            sb.append(appId);
        }
    }

    public static final int getAppId(int i) {
        return i % 100000;
    }

    public static final UserHandle getCallingUserHandle() {
        int userId = getUserId(Binder.getCallingUid());
        UserHandle userHandle = userHandles.get(userId);
        UserHandle userHandle2 = userHandle;
        if (userHandle == null) {
            userHandle2 = new UserHandle(userId);
            userHandles.put(userId, userHandle2);
        }
        return userHandle2;
    }

    public static final int getCallingUserId() {
        return getUserId(Binder.getCallingUid());
    }

    public static final int getSharedAppGid(int i) {
        return (50000 + (i % 100000)) - 10000;
    }

    public static final int getUid(int i, int i2) {
        return (i * 100000) + (i2 % 100000);
    }

    public static final int getUserGid(int i) {
        return getUid(i, Process.SHARED_USER_GID);
    }

    public static final int getUserId(int i) {
        return i / 100000;
    }

    public static boolean isApp(int i) {
        boolean z = false;
        if (i > 0) {
            int appId = getAppId(i);
            z = false;
            if (appId >= 10000) {
                z = false;
                if (appId <= 19999) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static final boolean isIsolated(int i) {
        boolean z = false;
        if (i > 0) {
            int appId = getAppId(i);
            z = false;
            if (appId >= 99000) {
                z = false;
                if (appId <= 99999) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static final boolean isSameApp(int i, int i2) {
        return getAppId(i) == getAppId(i2);
    }

    public static final boolean isSameUser(int i, int i2) {
        return getUserId(i) == getUserId(i2);
    }

    public static final int myUserId() {
        return getUserId(Process.myUid());
    }

    public static UserHandle readFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt != -10000) {
            return new UserHandle(readInt);
        }
        return null;
    }

    public static void writeToParcel(UserHandle userHandle, Parcel parcel) {
        if (userHandle != null) {
            userHandle.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(-10000);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = false;
                if (this.mHandle == ((UserHandle) obj).mHandle) {
                    z = true;
                }
            } catch (ClassCastException e) {
                return false;
            }
        }
        return z;
    }

    public int getIdentifier() {
        return this.mHandle;
    }

    public int hashCode() {
        return this.mHandle;
    }

    public final boolean isOwner() {
        return equals(OWNER);
    }

    public String toString() {
        return "UserHandle{" + this.mHandle + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mHandle);
    }
}
