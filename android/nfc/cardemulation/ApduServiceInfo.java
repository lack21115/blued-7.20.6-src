package android.nfc.cardemulation;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.android.internal.R;
import com.android.internal.telephony.PhoneConstants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/cardemulation/ApduServiceInfo.class */
public final class ApduServiceInfo implements Parcelable {
    public static final Parcelable.Creator<ApduServiceInfo> CREATOR = new Parcelable.Creator<ApduServiceInfo>() { // from class: android.nfc.cardemulation.ApduServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApduServiceInfo createFromParcel(Parcel parcel) {
            ResolveInfo createFromParcel = ResolveInfo.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            boolean z = parcel.readInt() != 0;
            ArrayList arrayList = new ArrayList();
            if (parcel.readInt() > 0) {
                parcel.readTypedList(arrayList, AidGroup.CREATOR);
            }
            ArrayList arrayList2 = new ArrayList();
            if (parcel.readInt() > 0) {
                parcel.readTypedList(arrayList2, AidGroup.CREATOR);
            }
            return new ApduServiceInfo(createFromParcel, z, readString, arrayList, arrayList2, parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ApduServiceInfo[] newArray(int i) {
            return new ApduServiceInfo[i];
        }
    };
    static final String TAG = "ApduServiceInfo";
    final int mBannerResourceId;
    final String mDescription;
    final HashMap<String, AidGroup> mDynamicAidGroups;
    final boolean mOnHost;
    final boolean mRequiresDeviceUnlock;
    final String mSeName;
    final ResolveInfo mService;
    final HashMap<String, AidGroup> mStaticAidGroups;
    final int mUid;

    public ApduServiceInfo(PackageManager packageManager, ResolveInfo resolveInfo, boolean z) throws XmlPullParserException, IOException {
        XmlResourceParser xmlResourceParser;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        XmlResourceParser xmlResourceParser2 = null;
        try {
            try {
                if (z) {
                    XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, HostApduService.SERVICE_META_DATA);
                    xmlResourceParser = loadXmlMetaData;
                    if (loadXmlMetaData == null) {
                        throw new XmlPullParserException("No android.nfc.cardemulation.host_apdu_service meta-data");
                    }
                } else {
                    XmlResourceParser loadXmlMetaData2 = serviceInfo.loadXmlMetaData(packageManager, OffHostApduService.SERVICE_META_DATA);
                    xmlResourceParser = loadXmlMetaData2;
                    if (loadXmlMetaData2 == null) {
                        throw new XmlPullParserException("No android.nfc.cardemulation.off_host_apdu_service meta-data");
                    }
                }
                XmlResourceParser xmlResourceParser3 = xmlResourceParser;
                for (int eventType = xmlResourceParser.getEventType(); eventType != 2 && eventType != 1; eventType = xmlResourceParser.next()) {
                }
                String name = xmlResourceParser.getName();
                if (z && !"host-apdu-service".equals(name)) {
                    XmlResourceParser xmlResourceParser4 = xmlResourceParser;
                    throw new XmlPullParserException("Meta-data does not start with <host-apdu-service> tag");
                } else if (!z && !"offhost-apdu-service".equals(name)) {
                    XmlResourceParser xmlResourceParser5 = xmlResourceParser;
                    throw new XmlPullParserException("Meta-data does not start with <offhost-apdu-service> tag");
                } else {
                    XmlResourceParser xmlResourceParser6 = xmlResourceParser;
                    Resources resourcesForApplication = packageManager.getResourcesForApplication(serviceInfo.applicationInfo);
                    XmlResourceParser xmlResourceParser7 = xmlResourceParser;
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                    if (z) {
                        TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.HostApduService);
                        XmlResourceParser xmlResourceParser8 = xmlResourceParser;
                        this.mService = resolveInfo;
                        XmlResourceParser xmlResourceParser9 = xmlResourceParser;
                        this.mDescription = obtainAttributes.getString(0);
                        XmlResourceParser xmlResourceParser10 = xmlResourceParser;
                        this.mRequiresDeviceUnlock = obtainAttributes.getBoolean(1, false);
                        XmlResourceParser xmlResourceParser11 = xmlResourceParser;
                        this.mBannerResourceId = obtainAttributes.getResourceId(2, -1);
                        XmlResourceParser xmlResourceParser12 = xmlResourceParser;
                        obtainAttributes.recycle();
                    } else {
                        TypedArray obtainAttributes2 = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.OffHostApduService);
                        XmlResourceParser xmlResourceParser13 = xmlResourceParser;
                        this.mService = resolveInfo;
                        XmlResourceParser xmlResourceParser14 = xmlResourceParser;
                        this.mDescription = obtainAttributes2.getString(0);
                        XmlResourceParser xmlResourceParser15 = xmlResourceParser;
                        this.mRequiresDeviceUnlock = false;
                        XmlResourceParser xmlResourceParser16 = xmlResourceParser;
                        this.mBannerResourceId = obtainAttributes2.getResourceId(1, -1);
                        XmlResourceParser xmlResourceParser17 = xmlResourceParser;
                        obtainAttributes2.recycle();
                    }
                    XmlResourceParser xmlResourceParser18 = xmlResourceParser;
                    this.mStaticAidGroups = new HashMap<>();
                    XmlResourceParser xmlResourceParser19 = xmlResourceParser;
                    this.mDynamicAidGroups = new HashMap<>();
                    XmlResourceParser xmlResourceParser20 = xmlResourceParser;
                    this.mOnHost = z;
                    XmlResourceParser xmlResourceParser21 = xmlResourceParser;
                    int depth = xmlResourceParser.getDepth();
                    AidGroup aidGroup = null;
                    String str = null;
                    while (true) {
                        int next = xmlResourceParser.next();
                        if ((next != 3 || xmlResourceParser.getDepth() > depth) && next != 1) {
                            String name2 = xmlResourceParser.getName();
                            if (next == 2 && "aid-group".equals(name2) && aidGroup == null) {
                                TypedArray obtainAttributes3 = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.AidGroup);
                                XmlResourceParser xmlResourceParser22 = xmlResourceParser;
                                String string = obtainAttributes3.getString(1);
                                XmlResourceParser xmlResourceParser23 = xmlResourceParser;
                                String string2 = obtainAttributes3.getString(0);
                                XmlResourceParser xmlResourceParser24 = xmlResourceParser;
                                String str2 = CardEmulation.CATEGORY_PAYMENT.equals(string) ? string : "other";
                                aidGroup = this.mStaticAidGroups.get(str2);
                                if (aidGroup == null) {
                                    aidGroup = new AidGroup(str2, string2);
                                } else if (!"other".equals(str2)) {
                                    XmlResourceParser xmlResourceParser25 = xmlResourceParser;
                                    Log.e(TAG, "Not allowing multiple aid-groups in the " + str2 + " category");
                                    aidGroup = null;
                                }
                                obtainAttributes3.recycle();
                            } else if (next == 3 && "aid-group".equals(name2) && aidGroup != null) {
                                if (aidGroup.aids.size() > 0) {
                                    XmlResourceParser xmlResourceParser26 = xmlResourceParser;
                                    if (!this.mStaticAidGroups.containsKey(aidGroup.category)) {
                                        XmlResourceParser xmlResourceParser27 = xmlResourceParser;
                                        this.mStaticAidGroups.put(aidGroup.category, aidGroup);
                                    }
                                } else {
                                    Log.e(TAG, "Not adding <aid-group> with empty or invalid AIDs");
                                }
                                aidGroup = null;
                            } else if (next == 2 && "aid-filter".equals(name2) && aidGroup != null) {
                                TypedArray obtainAttributes4 = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.AidFilter);
                                XmlResourceParser xmlResourceParser28 = xmlResourceParser;
                                String upperCase = obtainAttributes4.getString(0).toUpperCase();
                                XmlResourceParser xmlResourceParser29 = xmlResourceParser;
                                if (CardEmulation.isValidAid(upperCase)) {
                                    XmlResourceParser xmlResourceParser30 = xmlResourceParser;
                                    if (!aidGroup.aids.contains(upperCase)) {
                                        XmlResourceParser xmlResourceParser31 = xmlResourceParser;
                                        aidGroup.aids.add(upperCase);
                                        XmlResourceParser xmlResourceParser32 = xmlResourceParser;
                                        obtainAttributes4.recycle();
                                    }
                                }
                                Log.e(TAG, "Ignoring invalid or duplicate aid: " + upperCase);
                                XmlResourceParser xmlResourceParser322 = xmlResourceParser;
                                obtainAttributes4.recycle();
                            } else if (next == 2 && "aid-prefix-filter".equals(name2) && aidGroup != null) {
                                TypedArray obtainAttributes5 = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.AidFilter);
                                XmlResourceParser xmlResourceParser33 = xmlResourceParser;
                                String concat = obtainAttributes5.getString(0).toUpperCase().concat(PhoneConstants.APN_TYPE_ALL);
                                XmlResourceParser xmlResourceParser34 = xmlResourceParser;
                                if (CardEmulation.isValidAid(concat)) {
                                    XmlResourceParser xmlResourceParser35 = xmlResourceParser;
                                    if (!aidGroup.aids.contains(concat)) {
                                        XmlResourceParser xmlResourceParser36 = xmlResourceParser;
                                        aidGroup.aids.add(concat);
                                        XmlResourceParser xmlResourceParser37 = xmlResourceParser;
                                        obtainAttributes5.recycle();
                                    }
                                }
                                Log.e(TAG, "Ignoring invalid or duplicate aid: " + concat);
                                XmlResourceParser xmlResourceParser372 = xmlResourceParser;
                                obtainAttributes5.recycle();
                            } else if (next == 2 && "secure-element".equals(name2) && aidGroup != null) {
                                TypedArray obtainAttributes6 = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.AidFilter);
                                XmlResourceParser xmlResourceParser38 = xmlResourceParser;
                                str = obtainAttributes6.getString(0);
                                XmlResourceParser xmlResourceParser39 = xmlResourceParser;
                                obtainAttributes6.recycle();
                            }
                        }
                    }
                    if (this.mOnHost) {
                        XmlResourceParser xmlResourceParser40 = xmlResourceParser;
                        this.mSeName = new String("DH");
                    } else if (str == null) {
                        this.mSeName = new String("SIM1");
                    } else {
                        this.mSeName = str;
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    this.mUid = serviceInfo.applicationInfo.uid;
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new XmlPullParserException("Unable to create context for: " + serviceInfo.packageName);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser2.close();
            }
            throw th;
        }
    }

    public ApduServiceInfo(ResolveInfo resolveInfo, boolean z, String str, ArrayList<AidGroup> arrayList, ArrayList<AidGroup> arrayList2, boolean z2, int i, int i2) {
        this.mService = resolveInfo;
        this.mDescription = str;
        this.mStaticAidGroups = new HashMap<>();
        this.mDynamicAidGroups = new HashMap<>();
        this.mOnHost = z;
        this.mRequiresDeviceUnlock = z2;
        Iterator<AidGroup> it = arrayList.iterator();
        while (it.hasNext()) {
            AidGroup next = it.next();
            this.mStaticAidGroups.put(next.category, next);
        }
        Iterator<AidGroup> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            AidGroup next2 = it2.next();
            this.mDynamicAidGroups.put(next2.category, next2);
        }
        this.mBannerResourceId = i;
        this.mUid = i2;
        if (z) {
            this.mSeName = new String("DH");
        } else {
            this.mSeName = new String("SIM1");
        }
    }

    public ApduServiceInfo(ResolveInfo resolveInfo, boolean z, String str, ArrayList<AidGroup> arrayList, ArrayList<AidGroup> arrayList2, boolean z2, int i, int i2, String str2) {
        this.mService = resolveInfo;
        this.mDescription = str;
        this.mStaticAidGroups = new HashMap<>();
        this.mDynamicAidGroups = new HashMap<>();
        this.mOnHost = z;
        this.mRequiresDeviceUnlock = z2;
        Iterator<AidGroup> it = arrayList.iterator();
        while (it.hasNext()) {
            AidGroup next = it.next();
            this.mStaticAidGroups.put(next.category, next);
        }
        Iterator<AidGroup> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            AidGroup next2 = it2.next();
            this.mDynamicAidGroups.put(next2.category, next2);
        }
        this.mBannerResourceId = i;
        this.mUid = i2;
        this.mSeName = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println("    " + getComponent() + " (Description: " + getDescription() + ")");
        printWriter.println("    Static AID groups:");
        for (AidGroup aidGroup : this.mStaticAidGroups.values()) {
            printWriter.println("        Category: " + aidGroup.category);
            Iterator<String> it = aidGroup.aids.iterator();
            while (it.hasNext()) {
                printWriter.println("            AID: " + it.next());
            }
        }
        printWriter.println("    Dynamic AID groups:");
        for (AidGroup aidGroup2 : this.mDynamicAidGroups.values()) {
            printWriter.println("        Category: " + aidGroup2.category);
            Iterator<String> it2 = aidGroup2.aids.iterator();
            while (it2.hasNext()) {
                printWriter.println("            AID: " + it2.next());
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApduServiceInfo) {
            return ((ApduServiceInfo) obj).getComponent().equals(getComponent());
        }
        return false;
    }

    public ArrayList<AidGroup> getAidGroups() {
        ArrayList<AidGroup> arrayList = new ArrayList<>();
        for (Map.Entry<String, AidGroup> entry : this.mDynamicAidGroups.entrySet()) {
            arrayList.add(entry.getValue());
        }
        for (Map.Entry<String, AidGroup> entry2 : this.mStaticAidGroups.entrySet()) {
            if (!this.mDynamicAidGroups.containsKey(entry2.getKey())) {
                arrayList.add(entry2.getValue());
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAids() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<AidGroup> it = getAidGroups().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().aids);
        }
        return arrayList;
    }

    public String getCategoryForAid(String str) {
        Iterator<AidGroup> it = getAidGroups().iterator();
        while (it.hasNext()) {
            AidGroup next = it.next();
            if (next.aids.contains(str.toUpperCase())) {
                return next.category;
            }
        }
        return null;
    }

    public ComponentName getComponent() {
        return new ComponentName(this.mService.serviceInfo.packageName, this.mService.serviceInfo.name);
    }

    public String getDescription() {
        return this.mDescription;
    }

    public AidGroup getDynamicAidGroupForCategory(String str) {
        return this.mDynamicAidGroups.get(str);
    }

    public String getSeName() {
        return this.mSeName;
    }

    public int getUid() {
        return this.mUid;
    }

    public boolean hasCategory(String str) {
        return this.mStaticAidGroups.containsKey(str) || this.mDynamicAidGroups.containsKey(str);
    }

    public int hashCode() {
        return getComponent().hashCode();
    }

    public boolean isOnHost() {
        return this.mOnHost;
    }

    public Drawable loadBanner(PackageManager packageManager) {
        try {
            return packageManager.getResourcesForApplication(this.mService.serviceInfo.packageName).getDrawable(this.mBannerResourceId);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Could not load banner.");
            return null;
        } catch (Resources.NotFoundException e2) {
            Log.e(TAG, "Could not load banner.");
            return null;
        }
    }

    public Drawable loadIcon(PackageManager packageManager) {
        return this.mService.loadIcon(packageManager);
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        return this.mService.loadLabel(packageManager);
    }

    public boolean removeDynamicAidGroupForCategory(String str) {
        return this.mDynamicAidGroups.remove(str) != null;
    }

    public boolean requiresUnlock() {
        return this.mRequiresDeviceUnlock;
    }

    public void setOrReplaceDynamicAidGroup(AidGroup aidGroup) {
        this.mDynamicAidGroups.put(aidGroup.getCategory(), aidGroup);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ApduService: ");
        sb.append(getComponent());
        sb.append(", description: " + this.mDescription);
        sb.append(", Static AID Groups: ");
        for (AidGroup aidGroup : this.mStaticAidGroups.values()) {
            sb.append(aidGroup.toString());
        }
        sb.append(", Dynamic AID Groups: ");
        for (AidGroup aidGroup2 : this.mDynamicAidGroups.values()) {
            sb.append(aidGroup2.toString());
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mService.writeToParcel(parcel, i);
        parcel.writeString(this.mDescription);
        parcel.writeInt(this.mOnHost ? 1 : 0);
        parcel.writeInt(this.mStaticAidGroups.size());
        if (this.mStaticAidGroups.size() > 0) {
            parcel.writeTypedList(new ArrayList(this.mStaticAidGroups.values()));
        }
        parcel.writeInt(this.mDynamicAidGroups.size());
        if (this.mDynamicAidGroups.size() > 0) {
            parcel.writeTypedList(new ArrayList(this.mDynamicAidGroups.values()));
        }
        parcel.writeInt(this.mRequiresDeviceUnlock ? 1 : 0);
        parcel.writeInt(this.mBannerResourceId);
        parcel.writeInt(this.mUid);
        parcel.writeString(this.mSeName);
    }
}
