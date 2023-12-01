package android.app.admin;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Printer;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/app/admin/DeviceAdminInfo.class */
public final class DeviceAdminInfo implements Parcelable {
    public static final Parcelable.Creator<DeviceAdminInfo> CREATOR = null;
    static final String TAG = "DeviceAdminInfo";
    public static final int USES_ENCRYPTED_STORAGE = 7;
    public static final int USES_POLICY_DEVICE_OWNER = -2;
    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    public static final int USES_POLICY_DISABLE_KEYGUARD_FEATURES = 9;
    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    public static final int USES_POLICY_FORCE_LOCK = 3;
    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    public static final int USES_POLICY_PROFILE_OWNER = -1;
    public static final int USES_POLICY_RESET_PASSWORD = 2;
    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    public static final int USES_POLICY_WATCH_LOGIN = 1;
    public static final int USES_POLICY_WIPE_DATA = 4;
    final ResolveInfo mReceiver;
    int mUsesPolicies;
    boolean mVisible;
    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<>();
    static HashMap<String, Integer> sKnownPolicies = new HashMap<>();
    static SparseArray<PolicyInfo> sRevKnownPolicies = new SparseArray<>();

    /* renamed from: android.app.admin.DeviceAdminInfo$1  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/app/admin/DeviceAdminInfo$1.class */
    static final class AnonymousClass1 implements Parcelable.Creator<DeviceAdminInfo> {
        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceAdminInfo createFromParcel(Parcel parcel) {
            return new DeviceAdminInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceAdminInfo[] newArray(int i) {
            return new DeviceAdminInfo[i];
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/admin/DeviceAdminInfo$PolicyInfo.class */
    public static class PolicyInfo {
        public final int description;
        public final int ident;
        public final int label;
        public final String tag;

        public PolicyInfo(int i, String str, int i2, int i3) {
            this.ident = i;
            this.tag = str;
            this.label = i2;
            this.description = i3;
        }
    }

    static {
        ArrayList<PolicyInfo> arrayList = sPoliciesDisplayOrder;
        new PolicyInfo(4, "wipe-data", 17040380, 17040381);
        throw new VerifyError("bad dex opcode");
    }

    public DeviceAdminInfo(Context context, ResolveInfo resolveInfo) throws XmlPullParserException, IOException {
        int next;
        this.mReceiver = resolveInfo;
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        PackageManager packageManager = context.getPackageManager();
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser loadXmlMetaData = activityInfo.loadXmlMetaData(packageManager, DeviceAdminReceiver.DEVICE_ADMIN_META_DATA);
                if (loadXmlMetaData == null) {
                    throw new XmlPullParserException("No android.app.device_admin meta-data");
                }
                Resources resourcesForApplication = packageManager.getResourcesForApplication(activityInfo.applicationInfo);
                AttributeSet asAttributeSet = Xml.asAttributeSet(loadXmlMetaData);
                do {
                    next = loadXmlMetaData.next();
                    if (next == 1) {
                        break;
                    }
                } while (next != 2);
                if (!"device-admin".equals(loadXmlMetaData.getName())) {
                    throw new XmlPullParserException("Meta-data does not start with device-admin tag");
                }
                TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.DeviceAdmin);
                this.mVisible = obtainAttributes.getBoolean(0, true);
                obtainAttributes.recycle();
                int depth = loadXmlMetaData.getDepth();
                while (true) {
                    int next2 = loadXmlMetaData.next();
                    if (next2 == 1 || (next2 == 3 && loadXmlMetaData.getDepth() <= depth)) {
                        break;
                    } else if (next2 != 3 && next2 != 4 && loadXmlMetaData.getName().equals("uses-policies")) {
                        int depth2 = loadXmlMetaData.getDepth();
                        while (true) {
                            int next3 = loadXmlMetaData.next();
                            if (next3 != 1 && (next3 != 3 || loadXmlMetaData.getDepth() > depth2)) {
                                if (next3 != 3 && next3 != 4) {
                                    String name = loadXmlMetaData.getName();
                                    Integer num = sKnownPolicies.get(name);
                                    if (num != null) {
                                        this.mUsesPolicies |= 1 << num.intValue();
                                    } else {
                                        Log.w(TAG, "Unknown tag under uses-policies of " + getComponent() + ": " + name);
                                    }
                                }
                            }
                        }
                    }
                }
                if (loadXmlMetaData != null) {
                    loadXmlMetaData.close();
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new XmlPullParserException("Unable to create context for: " + activityInfo.packageName);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    DeviceAdminInfo(Parcel parcel) {
        this.mReceiver = ResolveInfo.CREATOR.createFromParcel(parcel);
        this.mUsesPolicies = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        printer.println(str + "Receiver:");
        this.mReceiver.dump(printer, str + "  ");
    }

    public ActivityInfo getActivityInfo() {
        return this.mReceiver.activityInfo;
    }

    public ComponentName getComponent() {
        return new ComponentName(this.mReceiver.activityInfo.packageName, this.mReceiver.activityInfo.name);
    }

    public String getPackageName() {
        return this.mReceiver.activityInfo.packageName;
    }

    public String getReceiverName() {
        return this.mReceiver.activityInfo.name;
    }

    public String getTagForPolicy(int i) {
        return sRevKnownPolicies.get(i).tag;
    }

    public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sPoliciesDisplayOrder.size()) {
                return arrayList;
            }
            PolicyInfo policyInfo = sPoliciesDisplayOrder.get(i2);
            if (usesPolicy(policyInfo.ident)) {
                arrayList.add(policyInfo);
            }
            i = i2 + 1;
        }
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public CharSequence loadDescription(PackageManager packageManager) throws Resources.NotFoundException {
        if (this.mReceiver.activityInfo.descriptionRes != 0) {
            String str = this.mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo = null;
            String str2 = str;
            if (str == null) {
                str2 = this.mReceiver.activityInfo.packageName;
                applicationInfo = this.mReceiver.activityInfo.applicationInfo;
            }
            return packageManager.getText(str2, this.mReceiver.activityInfo.descriptionRes, applicationInfo);
        }
        throw new Resources.NotFoundException();
    }

    public Drawable loadIcon(PackageManager packageManager) {
        return this.mReceiver.loadIcon(packageManager);
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        return this.mReceiver.loadLabel(packageManager);
    }

    public void readPoliciesFromXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        this.mUsesPolicies = Integer.parseInt(xmlPullParser.getAttributeValue(null, "flags"));
    }

    public String toString() {
        return "DeviceAdminInfo{" + this.mReceiver.activityInfo.name + "}";
    }

    public boolean usesPolicy(int i) {
        return (this.mUsesPolicies & (1 << i)) != 0;
    }

    public void writePoliciesToXml(XmlSerializer xmlSerializer) throws IllegalArgumentException, IllegalStateException, IOException {
        xmlSerializer.attribute(null, "flags", Integer.toString(this.mUsesPolicies));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mReceiver.writeToParcel(parcel, i);
        parcel.writeInt(this.mUsesPolicies);
    }
}
