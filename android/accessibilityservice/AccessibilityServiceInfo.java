package android.accessibilityservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.R;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/accessibilityservice/AccessibilityServiceInfo.class */
public class AccessibilityServiceInfo implements Parcelable {
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final Parcelable.Creator<AccessibilityServiceInfo> CREATOR;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_AUDIBLE = 4;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FEEDBACK_GENERIC = 16;
    public static final int FEEDBACK_HAPTIC = 2;
    public static final int FEEDBACK_SPOKEN = 1;
    public static final int FEEDBACK_VISUAL = 8;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    public static final int FLAG_RETRIEVE_INTERACTIVE_WINDOWS = 64;
    private static final String TAG_ACCESSIBILITY_SERVICE = "accessibility-service";
    private static final SparseArray<CapabilityInfo> sAvailableCapabilityInfos = new SparseArray<>();
    public int eventTypes;
    public int feedbackType;
    public int flags;
    private int mCapabilities;
    private int mDescriptionResId;
    private String mId;
    private String mNonLocalizedDescription;
    private ResolveInfo mResolveInfo;
    private String mSettingsActivityName;
    public long notificationTimeout;
    public String[] packageNames;

    /* loaded from: source-9557208-dex2jar.jar:android/accessibilityservice/AccessibilityServiceInfo$CapabilityInfo.class */
    public static final class CapabilityInfo {
        public final int capability;
        public final int descResId;
        public final int titleResId;

        public CapabilityInfo(int i, int i2, int i3) {
            this.capability = i;
            this.titleResId = i2;
            this.descResId = i3;
        }
    }

    static {
        sAvailableCapabilityInfos.put(1, new CapabilityInfo(1, 17039910, 17039911));
        sAvailableCapabilityInfos.put(2, new CapabilityInfo(2, 17039912, 17039913));
        sAvailableCapabilityInfos.put(4, new CapabilityInfo(4, 17039914, 17039915));
        sAvailableCapabilityInfos.put(8, new CapabilityInfo(8, 17039916, 17039917));
        CREATOR = new Parcelable.Creator<AccessibilityServiceInfo>() { // from class: android.accessibilityservice.AccessibilityServiceInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AccessibilityServiceInfo createFromParcel(Parcel parcel) {
                AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
                accessibilityServiceInfo.initFromParcel(parcel);
                return accessibilityServiceInfo;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AccessibilityServiceInfo[] newArray(int i) {
                return new AccessibilityServiceInfo[i];
            }
        };
    }

    public AccessibilityServiceInfo() {
    }

    public AccessibilityServiceInfo(ResolveInfo resolveInfo, Context context) throws XmlPullParserException, IOException {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        this.mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        this.mResolveInfo = resolveInfo;
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, AccessibilityService.SERVICE_META_DATA);
                if (loadXmlMetaData == null) {
                    if (loadXmlMetaData != null) {
                        loadXmlMetaData.close();
                        return;
                    }
                    return;
                }
                for (int i = 0; i != 1 && i != 2; i = loadXmlMetaData.next()) {
                }
                if (!TAG_ACCESSIBILITY_SERVICE.equals(loadXmlMetaData.getName())) {
                    throw new XmlPullParserException("Meta-data does not start withaccessibility-service tag");
                }
                TypedArray obtainAttributes = packageManager.getResourcesForApplication(serviceInfo.applicationInfo).obtainAttributes(Xml.asAttributeSet(loadXmlMetaData), R.styleable.AccessibilityService);
                this.eventTypes = obtainAttributes.getInt(2, 0);
                String string = obtainAttributes.getString(3);
                if (string != null) {
                    this.packageNames = string.split("(\\s)*,(\\s)*");
                }
                this.feedbackType = obtainAttributes.getInt(4, 0);
                this.notificationTimeout = obtainAttributes.getInt(5, 0);
                this.flags = obtainAttributes.getInt(6, 0);
                this.mSettingsActivityName = obtainAttributes.getString(1);
                if (obtainAttributes.getBoolean(7, false)) {
                    this.mCapabilities |= 1;
                }
                if (obtainAttributes.getBoolean(8, false)) {
                    this.mCapabilities |= 2;
                }
                if (obtainAttributes.getBoolean(9, false)) {
                    this.mCapabilities |= 4;
                }
                if (obtainAttributes.getBoolean(10, false)) {
                    this.mCapabilities |= 8;
                }
                TypedValue peekValue = obtainAttributes.peekValue(0);
                if (peekValue != null) {
                    this.mDescriptionResId = peekValue.resourceId;
                    CharSequence coerceToString = peekValue.coerceToString();
                    if (coerceToString != null) {
                        this.mNonLocalizedDescription = coerceToString.toString().trim();
                    }
                }
                obtainAttributes.recycle();
                if (loadXmlMetaData != null) {
                    loadXmlMetaData.close();
                }
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

    private static void appendCapabilities(StringBuilder sb, int i) {
        sb.append("capabilities:");
        sb.append("[");
        while (i != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            sb.append(capabilityToString(numberOfTrailingZeros));
            int i2 = i & (numberOfTrailingZeros ^ (-1));
            i = i2;
            if (i2 != 0) {
                sb.append(", ");
                i = i2;
            }
        }
        sb.append("]");
    }

    private static void appendEventTypes(StringBuilder sb, int i) {
        sb.append("eventTypes:");
        sb.append("[");
        while (i != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            sb.append(AccessibilityEvent.eventTypeToString(numberOfTrailingZeros));
            int i2 = i & (numberOfTrailingZeros ^ (-1));
            i = i2;
            if (i2 != 0) {
                sb.append(", ");
                i = i2;
            }
        }
        sb.append("]");
    }

    private static void appendFeedbackTypes(StringBuilder sb, int i) {
        sb.append("feedbackTypes:");
        sb.append("[");
        while (i != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            sb.append(feedbackTypeToString(numberOfTrailingZeros));
            int i2 = i & (numberOfTrailingZeros ^ (-1));
            i = i2;
            if (i2 != 0) {
                sb.append(", ");
                i = i2;
            }
        }
        sb.append("]");
    }

    private static void appendFlags(StringBuilder sb, int i) {
        sb.append("flags:");
        sb.append("[");
        while (i != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            sb.append(flagToString(numberOfTrailingZeros));
            int i2 = i & (numberOfTrailingZeros ^ (-1));
            i = i2;
            if (i2 != 0) {
                sb.append(", ");
                i = i2;
            }
        }
        sb.append("]");
    }

    private static void appendPackageNames(StringBuilder sb, String[] strArr) {
        sb.append("packageNames:");
        sb.append("[");
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(strArr[i2]);
                if (i2 < length - 1) {
                    sb.append(", ");
                }
                i = i2 + 1;
            }
        }
        sb.append("]");
    }

    public static String capabilityToString(int i) {
        switch (i) {
            case 1:
                return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
            case 2:
                return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            case 4:
                return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 8:
                return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
        }
    }

    public static String feedbackTypeToString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (i != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ (-1);
            switch (numberOfTrailingZeros) {
                case 1:
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append("FEEDBACK_SPOKEN");
                    break;
                case 2:
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append("FEEDBACK_HAPTIC");
                    break;
                case 4:
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append("FEEDBACK_AUDIBLE");
                    break;
                case 8:
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append("FEEDBACK_VISUAL");
                    break;
                case 16:
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append("FEEDBACK_GENERIC");
                    break;
                case 32:
                    if (sb.length() > 1) {
                        sb.append(", ");
                    }
                    sb.append("FEEDBACK_BRAILLE");
                    break;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String flagToString(int i) {
        switch (i) {
            case 1:
                return "DEFAULT";
            case 2:
                return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            case 4:
                return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
            case 8:
                return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
            case 16:
                return "FLAG_REPORT_VIEW_IDS";
            case 32:
                return "FLAG_REQUEST_FILTER_KEY_EVENTS";
            case 64:
                return "FLAG_RETRIEVE_INTERACTIVE_WINDOWS";
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFromParcel(Parcel parcel) {
        this.eventTypes = parcel.readInt();
        this.packageNames = parcel.readStringArray();
        this.feedbackType = parcel.readInt();
        this.notificationTimeout = parcel.readLong();
        this.flags = parcel.readInt();
        this.mId = parcel.readString();
        this.mResolveInfo = (ResolveInfo) parcel.readParcelable(null);
        this.mSettingsActivityName = parcel.readString();
        this.mCapabilities = parcel.readInt();
        this.mDescriptionResId = parcel.readInt();
        this.mNonLocalizedDescription = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccessibilityServiceInfo accessibilityServiceInfo = (AccessibilityServiceInfo) obj;
            return this.mId == null ? accessibilityServiceInfo.mId == null : this.mId.equals(accessibilityServiceInfo.mId);
        }
        return false;
    }

    public boolean getCanRetrieveWindowContent() {
        return (this.mCapabilities & 1) != 0;
    }

    public int getCapabilities() {
        return this.mCapabilities;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.List] */
    public List<CapabilityInfo> getCapabilityInfos() {
        ArrayList arrayList;
        if (this.mCapabilities != 0) {
            int i = this.mCapabilities;
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                arrayList = arrayList2;
                if (i == 0) {
                    break;
                }
                int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
                int i2 = i & (numberOfTrailingZeros ^ (-1));
                CapabilityInfo capabilityInfo = sAvailableCapabilityInfos.get(numberOfTrailingZeros);
                i = i2;
                if (capabilityInfo != null) {
                    arrayList2.add(capabilityInfo);
                    i = i2;
                }
            }
        } else {
            arrayList = Collections.emptyList();
        }
        return arrayList;
    }

    public String getDescription() {
        return this.mNonLocalizedDescription;
    }

    public String getId() {
        return this.mId;
    }

    public ResolveInfo getResolveInfo() {
        return this.mResolveInfo;
    }

    public String getSettingsActivityName() {
        return this.mSettingsActivityName;
    }

    public int hashCode() {
        return (this.mId == null ? 0 : this.mId.hashCode()) + 31;
    }

    public String loadDescription(PackageManager packageManager) {
        if (this.mDescriptionResId == 0) {
            return this.mNonLocalizedDescription;
        }
        ServiceInfo serviceInfo = this.mResolveInfo.serviceInfo;
        CharSequence text = packageManager.getText(serviceInfo.packageName, this.mDescriptionResId, serviceInfo.applicationInfo);
        if (text != null) {
            return text.toString().trim();
        }
        return null;
    }

    public void setCapabilities(int i) {
        this.mCapabilities = i;
    }

    public void setComponentName(ComponentName componentName) {
        this.mId = componentName.flattenToShortString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendEventTypes(sb, this.eventTypes);
        sb.append(", ");
        appendPackageNames(sb, this.packageNames);
        sb.append(", ");
        appendFeedbackTypes(sb, this.feedbackType);
        sb.append(", ");
        sb.append("notificationTimeout: ").append(this.notificationTimeout);
        sb.append(", ");
        appendFlags(sb, this.flags);
        sb.append(", ");
        sb.append("id: ").append(this.mId);
        sb.append(", ");
        sb.append("resolveInfo: ").append(this.mResolveInfo);
        sb.append(", ");
        sb.append("settingsActivityName: ").append(this.mSettingsActivityName);
        sb.append(", ");
        appendCapabilities(sb, this.mCapabilities);
        return sb.toString();
    }

    public void updateDynamicallyConfigurableProperties(AccessibilityServiceInfo accessibilityServiceInfo) {
        this.eventTypes = accessibilityServiceInfo.eventTypes;
        this.packageNames = accessibilityServiceInfo.packageNames;
        this.feedbackType = accessibilityServiceInfo.feedbackType;
        this.notificationTimeout = accessibilityServiceInfo.notificationTimeout;
        this.flags = accessibilityServiceInfo.flags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.eventTypes);
        parcel.writeStringArray(this.packageNames);
        parcel.writeInt(this.feedbackType);
        parcel.writeLong(this.notificationTimeout);
        parcel.writeInt(this.flags);
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.mResolveInfo, 0);
        parcel.writeString(this.mSettingsActivityName);
        parcel.writeInt(this.mCapabilities);
        parcel.writeInt(this.mDescriptionResId);
        parcel.writeString(this.mNonLocalizedDescription);
    }
}
