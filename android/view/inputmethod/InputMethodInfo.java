package android.view.inputmethod;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
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
import android.util.Printer;
import android.util.Slog;
import android.util.Xml;
import android.view.inputmethod.InputMethodSubtype;
import com.alipay.sdk.util.i;
import com.android.internal.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodInfo.class */
public final class InputMethodInfo implements Parcelable {
    public static final Parcelable.Creator<InputMethodInfo> CREATOR = new Parcelable.Creator<InputMethodInfo>() { // from class: android.view.inputmethod.InputMethodInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodInfo createFromParcel(Parcel parcel) {
            return new InputMethodInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InputMethodInfo[] newArray(int i) {
            return new InputMethodInfo[i];
        }
    };
    static final String TAG = "InputMethodInfo";
    private final boolean mForceDefault;
    final String mId;
    private final boolean mIsAuxIme;
    final int mIsDefaultResId;
    final ResolveInfo mService;
    final String mSettingsActivityName;
    private final InputMethodSubtypeArray mSubtypes;
    private final boolean mSupportsSwitchingToNextInputMethod;

    public InputMethodInfo(Context context, ResolveInfo resolveInfo) throws XmlPullParserException, IOException {
        this(context, resolveInfo, null);
    }

    public InputMethodInfo(Context context, ResolveInfo resolveInfo, Map<String, List<InputMethodSubtype>> map) throws XmlPullParserException, IOException {
        int next;
        this.mService = resolveInfo;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        this.mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        boolean z = true;
        this.mForceDefault = false;
        PackageManager packageManager = context.getPackageManager();
        XmlResourceParser xmlResourceParser = null;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, InputMethod.SERVICE_META_DATA);
                if (loadXmlMetaData == null) {
                    throw new XmlPullParserException("No android.view.im meta-data");
                }
                Resources resourcesForApplication = packageManager.getResourcesForApplication(serviceInfo.applicationInfo);
                AttributeSet asAttributeSet = Xml.asAttributeSet(loadXmlMetaData);
                do {
                    next = loadXmlMetaData.next();
                    if (next == 1) {
                        break;
                    }
                } while (next != 2);
                if (!"input-method".equals(loadXmlMetaData.getName())) {
                    throw new XmlPullParserException("Meta-data does not start with input-method tag");
                }
                TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.InputMethod);
                String string = obtainAttributes.getString(1);
                int resourceId = obtainAttributes.getResourceId(0, 0);
                boolean z2 = obtainAttributes.getBoolean(2, false);
                obtainAttributes.recycle();
                int depth = loadXmlMetaData.getDepth();
                while (true) {
                    int next2 = loadXmlMetaData.next();
                    if ((next2 != 3 || loadXmlMetaData.getDepth() > depth) && next2 != 1) {
                        if (next2 == 2) {
                            if (!"subtype".equals(loadXmlMetaData.getName())) {
                                throw new XmlPullParserException("Meta-data in input-method does not start with subtype tag");
                            }
                            TypedArray obtainAttributes2 = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.InputMethod_Subtype);
                            InputMethodSubtype build = new InputMethodSubtype.InputMethodSubtypeBuilder().setSubtypeNameResId(obtainAttributes2.getResourceId(0, 0)).setSubtypeIconResId(obtainAttributes2.getResourceId(1, 0)).setSubtypeLocale(obtainAttributes2.getString(2)).setSubtypeMode(obtainAttributes2.getString(3)).setSubtypeExtraValue(obtainAttributes2.getString(4)).setIsAuxiliary(obtainAttributes2.getBoolean(5, false)).setOverridesImplicitlyEnabledSubtype(obtainAttributes2.getBoolean(6, false)).setSubtypeId(obtainAttributes2.getInt(7, 0)).setIsAsciiCapable(obtainAttributes2.getBoolean(8, false)).build();
                            z = build.isAuxiliary() ? z : false;
                            arrayList.add(build);
                        }
                    }
                }
                if (loadXmlMetaData != null) {
                    loadXmlMetaData.close();
                }
                z = arrayList.size() == 0 ? false : z;
                if (map != null && map.containsKey(this.mId)) {
                    List<InputMethodSubtype> list = map.get(this.mId);
                    int size = list.size();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= size) {
                            break;
                        }
                        InputMethodSubtype inputMethodSubtype = list.get(i2);
                        if (arrayList.contains(inputMethodSubtype)) {
                            Slog.w(TAG, "Duplicated subtype definition found: " + inputMethodSubtype.getLocale() + ", " + inputMethodSubtype.getMode());
                        } else {
                            arrayList.add(inputMethodSubtype);
                        }
                        i = i2 + 1;
                    }
                }
                this.mSubtypes = new InputMethodSubtypeArray(arrayList);
                this.mSettingsActivityName = string;
                this.mIsDefaultResId = resourceId;
                this.mIsAuxIme = z;
                this.mSupportsSwitchingToNextInputMethod = z2;
            } catch (PackageManager.NameNotFoundException e) {
                throw new XmlPullParserException("Unable to create context for: " + serviceInfo.packageName);
            }
        } catch (Throwable th) {
            if (0 != 0) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    public InputMethodInfo(ResolveInfo resolveInfo, boolean z, String str, List<InputMethodSubtype> list, int i, boolean z2) {
        this(resolveInfo, z, str, list, i, z2, true);
    }

    public InputMethodInfo(ResolveInfo resolveInfo, boolean z, String str, List<InputMethodSubtype> list, int i, boolean z2, boolean z3) {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        this.mService = resolveInfo;
        this.mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        this.mSettingsActivityName = str;
        this.mIsDefaultResId = i;
        this.mIsAuxIme = z;
        this.mSubtypes = new InputMethodSubtypeArray(list);
        this.mForceDefault = z2;
        this.mSupportsSwitchingToNextInputMethod = z3;
    }

    InputMethodInfo(Parcel parcel) {
        this.mId = parcel.readString();
        this.mSettingsActivityName = parcel.readString();
        this.mIsDefaultResId = parcel.readInt();
        this.mIsAuxIme = parcel.readInt() == 1;
        this.mSupportsSwitchingToNextInputMethod = parcel.readInt() == 1;
        this.mService = ResolveInfo.CREATOR.createFromParcel(parcel);
        this.mSubtypes = new InputMethodSubtypeArray(parcel);
        this.mForceDefault = false;
    }

    public InputMethodInfo(String str, String str2, CharSequence charSequence, String str3) {
        this(buildDummyResolveInfo(str, str2, charSequence), false, str3, null, 0, false, true);
    }

    private static ResolveInfo buildDummyResolveInfo(String str, String str2, CharSequence charSequence) {
        ResolveInfo resolveInfo = new ResolveInfo();
        ServiceInfo serviceInfo = new ServiceInfo();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.packageName = str;
        applicationInfo.enabled = true;
        serviceInfo.applicationInfo = applicationInfo;
        serviceInfo.enabled = true;
        serviceInfo.packageName = str;
        serviceInfo.name = str2;
        serviceInfo.exported = true;
        serviceInfo.nonLocalizedLabel = charSequence;
        resolveInfo.serviceInfo = serviceInfo;
        return resolveInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dump(Printer printer, String str) {
        printer.println(str + "mId=" + this.mId + " mSettingsActivityName=" + this.mSettingsActivityName);
        printer.println(str + "mIsDefaultResId=0x" + Integer.toHexString(this.mIsDefaultResId));
        printer.println(str + "Service:");
        this.mService.dump(printer, str + "  ");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            z = true;
        } else {
            z = false;
            if (obj != null) {
                z = false;
                if (obj instanceof InputMethodInfo) {
                    return this.mId.equals(((InputMethodInfo) obj).mId);
                }
            }
        }
        return z;
    }

    public ComponentName getComponent() {
        return new ComponentName(this.mService.serviceInfo.packageName, this.mService.serviceInfo.name);
    }

    public String getId() {
        return this.mId;
    }

    public int getIsDefaultResourceId() {
        return this.mIsDefaultResId;
    }

    public String getPackageName() {
        return this.mService.serviceInfo.packageName;
    }

    public ServiceInfo getServiceInfo() {
        return this.mService.serviceInfo;
    }

    public String getServiceName() {
        return this.mService.serviceInfo.name;
    }

    public String getSettingsActivity() {
        return this.mSettingsActivityName;
    }

    public InputMethodSubtype getSubtypeAt(int i) {
        return this.mSubtypes.get(i);
    }

    public int getSubtypeCount() {
        return this.mSubtypes.getCount();
    }

    public int hashCode() {
        return this.mId.hashCode();
    }

    public boolean isAuxiliaryIme() {
        return this.mIsAuxIme;
    }

    public boolean isDefault(Context context) {
        boolean z = false;
        if (this.mForceDefault) {
            z = true;
        } else {
            try {
                if (getIsDefaultResourceId() != 0) {
                    return context.createPackageContext(getPackageName(), 0).getResources().getBoolean(getIsDefaultResourceId());
                }
            } catch (PackageManager.NameNotFoundException e) {
                return false;
            } catch (Resources.NotFoundException e2) {
                return false;
            }
        }
        return z;
    }

    public Drawable loadIcon(PackageManager packageManager) {
        return this.mService.loadIcon(packageManager);
    }

    public CharSequence loadLabel(PackageManager packageManager) {
        return this.mService.loadLabel(packageManager);
    }

    public boolean supportsSwitchingToNextInputMethod() {
        return this.mSupportsSwitchingToNextInputMethod;
    }

    public String toString() {
        return "InputMethodInfo{" + this.mId + ", settings: " + this.mSettingsActivityName + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mSettingsActivityName);
        parcel.writeInt(this.mIsDefaultResId);
        parcel.writeInt(this.mIsAuxIme ? 1 : 0);
        parcel.writeInt(this.mSupportsSwitchingToNextInputMethod ? 1 : 0);
        this.mService.writeToParcel(parcel, i);
        this.mSubtypes.writeToParcel(parcel);
    }
}
