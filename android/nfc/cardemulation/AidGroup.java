package android.nfc.cardemulation;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/cardemulation/AidGroup.class */
public final class AidGroup implements Parcelable {
    public static final Parcelable.Creator<AidGroup> CREATOR = new Parcelable.Creator<AidGroup>() { // from class: android.nfc.cardemulation.AidGroup.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AidGroup createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList();
            if (readInt > 0) {
                parcel.readStringList(arrayList);
            }
            return new AidGroup(arrayList, readString);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AidGroup[] newArray(int i) {
            return new AidGroup[i];
        }
    };
    public static final int MAX_NUM_AIDS = 256;
    static final String TAG = "AidGroup";
    final List<String> aids;
    final String category;
    final String description;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AidGroup(String str, String str2) {
        this.aids = new ArrayList();
        this.category = str;
        this.description = str2;
    }

    public AidGroup(List<String> list, String str) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("No AIDS in AID group.");
        }
        if (list.size() > 256) {
            throw new IllegalArgumentException("Too many AIDs in AID group.");
        }
        for (String str2 : list) {
            if (!CardEmulation.isValidAid(str2)) {
                throw new IllegalArgumentException("AID " + str2 + " is not a valid AID.");
            }
        }
        if (isValidCategory(str)) {
            this.category = str;
        } else {
            this.category = "other";
        }
        this.aids = new ArrayList(list.size());
        for (String str3 : list) {
            this.aids.add(str3.toUpperCase());
        }
        this.description = null;
    }

    public static AidGroup createFromXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        AidGroup aidGroup;
        String str;
        boolean z;
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth();
        while (true) {
            aidGroup = null;
            if (eventType == 1) {
                break;
            }
            aidGroup = null;
            if (xmlPullParser.getDepth() < depth) {
                break;
            }
            String name = xmlPullParser.getName();
            if (eventType != 2) {
                str = str2;
                z = z2;
                if (eventType == 3) {
                    str = str2;
                    z = z2;
                    if (name.equals("aid-group")) {
                        str = str2;
                        z = z2;
                        if (z2) {
                            str = str2;
                            z = z2;
                            if (arrayList.size() > 0) {
                                aidGroup = new AidGroup(arrayList, str2);
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            } else if (name.equals("aid")) {
                if (z2) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "value");
                    str = str2;
                    z = z2;
                    if (attributeValue != null) {
                        arrayList.add(attributeValue.toUpperCase());
                        z = z2;
                        str = str2;
                    }
                } else {
                    Log.d(TAG, "Ignoring <aid> tag while not in group");
                    str = str2;
                    z = z2;
                }
            } else if (name.equals("aid-group")) {
                str = xmlPullParser.getAttributeValue(null, "category");
                if (str == null) {
                    Log.e(TAG, "<aid-group> tag without valid category");
                    return null;
                }
                z = true;
            } else {
                Log.d(TAG, "Ignoring unexpected tag: " + name);
                str = str2;
                z = z2;
            }
            eventType = xmlPullParser.next();
            str2 = str;
            z2 = z;
        }
        return aidGroup;
    }

    static boolean isValidCategory(String str) {
        return CardEmulation.CATEGORY_PAYMENT.equals(str) || "other".equals(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getAids() {
        return this.aids;
    }

    public String getCategory() {
        return this.category;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Category: " + this.category + ", AIDs:");
        for (String str : this.aids) {
            sb.append(str);
            sb.append(", ");
        }
        return sb.toString();
    }

    public void writeAsXml(XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, "aid-group");
        xmlSerializer.attribute(null, "category", this.category);
        for (String str : this.aids) {
            xmlSerializer.startTag(null, "aid");
            xmlSerializer.attribute(null, "value", str);
            xmlSerializer.endTag(null, "aid");
        }
        xmlSerializer.endTag(null, "aid-group");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.category);
        parcel.writeInt(this.aids.size());
        if (this.aids.size() > 0) {
            parcel.writeStringList(this.aids);
        }
    }
}
