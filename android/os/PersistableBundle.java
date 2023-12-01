package android.os;

import android.os.Parcelable;
import android.util.ArrayMap;
import com.android.internal.util.XmlUtils;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/os/PersistableBundle.class */
public final class PersistableBundle extends BaseBundle implements Cloneable, Parcelable, XmlUtils.WriteMapCallback {
    public static final Parcelable.Creator<PersistableBundle> CREATOR;
    public static final PersistableBundle EMPTY = new PersistableBundle();
    static final Parcel EMPTY_PARCEL;
    private static final String TAG_PERSISTABLEMAP = "pbundle_as_map";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/os/PersistableBundle$MyReadMapCallback.class */
    public static class MyReadMapCallback implements XmlUtils.ReadMapCallback {
        MyReadMapCallback() {
        }

        @Override // com.android.internal.util.XmlUtils.ReadMapCallback
        public Object readThisUnknownObjectXml(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
            if (PersistableBundle.TAG_PERSISTABLEMAP.equals(str)) {
                return PersistableBundle.restoreFromXml(xmlPullParser);
            }
            throw new XmlPullParserException("Unknown tag=" + str);
        }
    }

    static {
        EMPTY.mMap = ArrayMap.EMPTY;
        EMPTY_PARCEL = BaseBundle.EMPTY_PARCEL;
        CREATOR = new Parcelable.Creator<PersistableBundle>() { // from class: android.os.PersistableBundle.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PersistableBundle createFromParcel(Parcel parcel) {
                return parcel.readPersistableBundle();
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PersistableBundle[] newArray(int i) {
                return new PersistableBundle[i];
            }
        };
    }

    public PersistableBundle() {
    }

    public PersistableBundle(int i) {
        super(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PersistableBundle(Parcel parcel, int i) {
        super(parcel, i);
    }

    public PersistableBundle(PersistableBundle persistableBundle) {
        super(persistableBundle);
    }

    private PersistableBundle(Map<String, Object> map) {
        putAll(map);
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Map) {
                putPersistableBundle(str, new PersistableBundle((Map) obj));
            } else if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof int[]) && !(obj instanceof long[]) && !(obj instanceof double[]) && !(obj instanceof String[]) && !(obj instanceof PersistableBundle) && obj != null && !(obj instanceof Boolean) && !(obj instanceof boolean[])) {
                throw new IllegalArgumentException("Bad value in PersistableBundle key=" + str + " value=" + obj);
            }
        }
    }

    public static PersistableBundle forPair(String str, String str2) {
        PersistableBundle persistableBundle = new PersistableBundle(1);
        persistableBundle.putString(str, str2);
        return persistableBundle;
    }

    public static PersistableBundle restoreFromXml(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        int next;
        int depth = xmlPullParser.getDepth();
        String name = xmlPullParser.getName();
        String[] strArr = new String[1];
        do {
            next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() >= depth)) {
                return EMPTY;
            }
        } while (next != 2);
        return new PersistableBundle(XmlUtils.readThisMapXml(xmlPullParser, name, strArr, new MyReadMapCallback()));
    }

    public Object clone() {
        return new PersistableBundle(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PersistableBundle getPersistableBundle(String str) {
        unparcel();
        Object obj = this.mMap.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (PersistableBundle) obj;
        } catch (ClassCastException e) {
            typeWarning(str, obj, "Bundle", e);
            return null;
        }
    }

    public void putPersistableBundle(String str, PersistableBundle persistableBundle) {
        unparcel();
        this.mMap.put(str, persistableBundle);
    }

    public void saveToXml(XmlSerializer xmlSerializer) throws IOException, XmlPullParserException {
        unparcel();
        XmlUtils.writeMapXml(this.mMap, xmlSerializer, this);
    }

    public String toString() {
        String str;
        synchronized (this) {
            str = this.mParcelledData != null ? this.mParcelledData == EMPTY_PARCEL ? "PersistableBundle[EMPTY_PARCEL]" : "PersistableBundle[mParcelledData.dataSize=" + this.mParcelledData.dataSize() + "]" : "PersistableBundle[" + this.mMap.toString() + "]";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        boolean pushAllowFds = parcel.pushAllowFds(false);
        try {
            writeToParcelInner(parcel, i);
        } finally {
            parcel.restoreAllowFds(pushAllowFds);
        }
    }

    @Override // com.android.internal.util.XmlUtils.WriteMapCallback
    public void writeUnknownObject(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (!(obj instanceof PersistableBundle)) {
            throw new XmlPullParserException("Unknown Object o=" + obj);
        }
        xmlSerializer.startTag(null, TAG_PERSISTABLEMAP);
        xmlSerializer.attribute(null, "name", str);
        ((PersistableBundle) obj).saveToXml(xmlSerializer);
        xmlSerializer.endTag(null, TAG_PERSISTABLEMAP);
    }
}
