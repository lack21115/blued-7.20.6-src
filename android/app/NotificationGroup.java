package android.app;

import android.content.Context;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/app/NotificationGroup.class */
public class NotificationGroup implements Parcelable {
    public static final Parcelable.Creator<NotificationGroup> CREATOR = new Parcelable.Creator<NotificationGroup>() { // from class: android.app.NotificationGroup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationGroup createFromParcel(Parcel parcel) {
            return new NotificationGroup(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationGroup[] newArray(int i) {
            return new NotificationGroup[i];
        }
    };
    private static final String TAG = "NotificationGroup";
    private boolean mDirty;
    private String mName;
    private int mNameResId;
    private Set<String> mPackages;
    private UUID mUuid;

    private NotificationGroup(Parcel parcel) {
        this.mPackages = new HashSet();
        readFromParcel(parcel);
    }

    public NotificationGroup(String str) {
        this(str, -1, null);
    }

    public NotificationGroup(String str, int i, UUID uuid) {
        this.mPackages = new HashSet();
        this.mName = str;
        this.mNameResId = i;
        this.mUuid = uuid != null ? uuid : UUID.randomUUID();
        this.mDirty = uuid == null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00bc -> B:13:0x006d). Please submit an issue!!! */
    public static NotificationGroup fromXml(XmlPullParser xmlPullParser, Context context) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "nameres");
        int i = -1;
        String str = null;
        if (attributeValue != null) {
            int identifier = context.getResources().getIdentifier(attributeValue, "string", "android");
            str = null;
            i = identifier;
            if (identifier > 0) {
                str = context.getResources().getString(identifier);
                i = identifier;
            }
        }
        String str2 = str;
        if (str == null) {
            str2 = xmlPullParser.getAttributeValue(null, "name");
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "uuid");
        UUID uuid = null;
        if (attributeValue2 != null) {
            try {
                uuid = UUID.fromString(attributeValue2);
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "UUID not recognized for " + str2 + ", using new one.");
                uuid = null;
            }
        }
        NotificationGroup notificationGroup = new NotificationGroup(str2, i, uuid);
        int next = xmlPullParser.next();
        while (true) {
            int i2 = next;
            if (i2 == 3 && xmlPullParser.getName().equals("notificationGroup")) {
                notificationGroup.mDirty = false;
                return notificationGroup;
            }
            if (i2 == 2 && xmlPullParser.getName().equals("package")) {
                notificationGroup.addPackage(xmlPullParser.nextText());
            }
            next = xmlPullParser.next();
        }
    }

    public void addPackage(String str) {
        this.mPackages.add(str);
        this.mDirty = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.mName;
    }

    public String[] getPackages() {
        return (String[]) this.mPackages.toArray(new String[this.mPackages.size()]);
    }

    public UUID getUuid() {
        return this.mUuid;
    }

    public void getXmlString(StringBuilder sb, Context context) {
        sb.append("<notificationGroup ");
        if (this.mNameResId > 0) {
            sb.append("nameres=\"");
            sb.append(context.getResources().getResourceEntryName(this.mNameResId));
        } else {
            sb.append("name=\"");
            sb.append(TextUtils.htmlEncode(getName()));
        }
        sb.append("\" uuid=\"");
        sb.append(TextUtils.htmlEncode(getUuid().toString()));
        sb.append("\">\n");
        Iterator<String> it = this.mPackages.iterator();
        while (it.hasNext()) {
            sb.append("<package>" + TextUtils.htmlEncode(it.next()) + "</package>\n");
        }
        sb.append("</notificationGroup>\n");
        this.mDirty = false;
    }

    public boolean hasPackage(String str) {
        return this.mPackages.contains(str);
    }

    public boolean isDirty() {
        return this.mDirty;
    }

    public void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
        this.mNameResId = parcel.readInt();
        this.mDirty = parcel.readInt() != 0;
        this.mUuid = ParcelUuid.CREATOR.createFromParcel(parcel).getUuid();
        this.mPackages.addAll(Arrays.asList(parcel.readStringArray()));
    }

    public void removePackage(String str) {
        this.mPackages.remove(str);
        this.mDirty = true;
    }

    public void setName(String str) {
        this.mName = str;
        this.mNameResId = -1;
        this.mDirty = true;
    }

    public String toString() {
        return getName();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
        parcel.writeInt(this.mNameResId);
        parcel.writeInt(this.mDirty ? 1 : 0);
        new ParcelUuid(this.mUuid).writeToParcel(parcel, 0);
        parcel.writeStringArray(getPackages());
    }
}
