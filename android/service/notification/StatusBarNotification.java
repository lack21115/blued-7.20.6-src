package android.service.notification;

import android.app.Notification;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/StatusBarNotification.class */
public class StatusBarNotification implements Parcelable {
    public static final Parcelable.Creator<StatusBarNotification> CREATOR = new Parcelable.Creator<StatusBarNotification>() { // from class: android.service.notification.StatusBarNotification.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusBarNotification createFromParcel(Parcel parcel) {
            return new StatusBarNotification(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public StatusBarNotification[] newArray(int i) {
            return new StatusBarNotification[i];
        }
    };
    private final String groupKey;
    private final int id;
    private final int initialPid;
    private final String key;
    private final Notification notification;
    private final String opPkg;
    private final String pkg;
    private final long postTime;
    private final int score;
    private final String tag;
    private final int uid;
    private final UserHandle user;

    public StatusBarNotification(Parcel parcel) {
        this.pkg = parcel.readString();
        this.opPkg = parcel.readString();
        this.id = parcel.readInt();
        if (parcel.readInt() != 0) {
            this.tag = parcel.readString();
        } else {
            this.tag = null;
        }
        this.uid = parcel.readInt();
        this.initialPid = parcel.readInt();
        this.score = parcel.readInt();
        this.notification = new Notification(parcel);
        this.user = UserHandle.readFromParcel(parcel);
        this.postTime = parcel.readLong();
        this.key = key();
        this.groupKey = groupKey();
    }

    public StatusBarNotification(String str, String str2, int i, String str3, int i2, int i3, int i4, Notification notification, UserHandle userHandle) {
        this(str, str2, i, str3, i2, i3, i4, notification, userHandle, System.currentTimeMillis());
    }

    public StatusBarNotification(String str, String str2, int i, String str3, int i2, int i3, int i4, Notification notification, UserHandle userHandle, long j) {
        if (str == null) {
            throw new NullPointerException();
        }
        if (notification == null) {
            throw new NullPointerException();
        }
        this.pkg = str;
        this.opPkg = str2;
        this.id = i;
        this.tag = str3;
        this.uid = i2;
        this.initialPid = i3;
        this.score = i4;
        this.notification = notification;
        this.user = userHandle;
        this.postTime = j;
        this.key = key();
        this.groupKey = groupKey();
    }

    private String groupKey() {
        String group = getNotification().getGroup();
        String sortKey = getNotification().getSortKey();
        if (group == null && sortKey == null) {
            return this.key;
        }
        return this.user.getIdentifier() + "|" + this.pkg + "|" + (group == null ? "p:" + this.notification.priority : "g:" + group);
    }

    private String key() {
        return this.user.getIdentifier() + "|" + this.pkg + "|" + this.id + "|" + this.tag + "|" + this.uid;
    }

    /* renamed from: clone */
    public StatusBarNotification m865clone() {
        return new StatusBarNotification(this.pkg, this.opPkg, this.id, this.tag, this.uid, this.initialPid, this.score, this.notification.m115clone(), this.user, this.postTime);
    }

    public StatusBarNotification cloneLight() {
        Notification notification = new Notification();
        this.notification.cloneInto(notification, false);
        return new StatusBarNotification(this.pkg, this.opPkg, this.id, this.tag, this.uid, this.initialPid, this.score, notification, this.user, this.postTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getGroupKey() {
        return this.groupKey;
    }

    public int getId() {
        return this.id;
    }

    public int getInitialPid() {
        return this.initialPid;
    }

    public String getKey() {
        return this.key;
    }

    public Notification getNotification() {
        return this.notification;
    }

    public String getOpPkg() {
        return this.opPkg;
    }

    public String getPackageName() {
        return this.pkg;
    }

    public long getPostTime() {
        return this.postTime;
    }

    public int getScore() {
        return this.score;
    }

    public String getTag() {
        return this.tag;
    }

    public int getUid() {
        return this.uid;
    }

    public UserHandle getUser() {
        return this.user;
    }

    public int getUserId() {
        return this.user.getIdentifier();
    }

    public boolean isClearable() {
        return (this.notification.flags & 2) == 0 && (this.notification.flags & 32) == 0;
    }

    public boolean isOngoing() {
        return (this.notification.flags & 2) != 0;
    }

    public String toString() {
        return String.format("StatusBarNotification(pkg=%s user=%s id=%d tag=%s score=%d key=%s: %s)", this.pkg, this.user, Integer.valueOf(this.id), this.tag, Integer.valueOf(this.score), this.key, this.notification);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pkg);
        parcel.writeString(this.opPkg);
        parcel.writeInt(this.id);
        if (this.tag != null) {
            parcel.writeInt(1);
            parcel.writeString(this.tag);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.uid);
        parcel.writeInt(this.initialPid);
        parcel.writeInt(this.score);
        this.notification.writeToParcel(parcel, i);
        this.user.writeToParcel(parcel, i);
        parcel.writeLong(this.postTime);
    }
}
