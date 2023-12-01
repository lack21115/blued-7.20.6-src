package android.media.tv;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.net.Uri;
import android.os.FileObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import com.android.internal.R;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputInfo.class */
public final class TvInputInfo implements Parcelable {
    public static final Parcelable.Creator<TvInputInfo> CREATOR;
    private static final boolean DEBUG = false;
    private static final String DELIMITER_INFO_IN_ID = "/";
    public static final String EXTRA_INPUT_ID = "android.media.tv.extra.INPUT_ID";
    private static final int LENGTH_HDMI_DEVICE_ID = 2;
    private static final int LENGTH_HDMI_PHYSICAL_ADDRESS = 4;
    private static final String PREFIX_HARDWARE_DEVICE = "HW";
    private static final String PREFIX_HDMI_DEVICE = "HDMI";
    private static final String TAG = "TvInputInfo";
    public static final int TYPE_COMPONENT = 1004;
    public static final int TYPE_COMPOSITE = 1001;
    public static final int TYPE_DISPLAY_PORT = 1008;
    public static final int TYPE_DVI = 1006;
    public static final int TYPE_HDMI = 1007;
    public static final int TYPE_OTHER = 1000;
    public static final int TYPE_SCART = 1003;
    public static final int TYPE_SVIDEO = 1002;
    public static final int TYPE_TUNER = 0;
    public static final int TYPE_VGA = 1005;
    private static final String XML_START_TAG_NAME = "tv-input";
    private static SparseIntArray sHardwareTypeToTvInputType = new SparseIntArray();
    private HdmiDeviceInfo mHdmiDeviceInfo;
    private Uri mIconUri;
    private final String mId;
    private boolean mIsConnectedToHdmiSwitch;
    private String mLabel;
    private final String mParentId;
    private final ResolveInfo mService;
    private String mSettingsActivity;
    private String mSetupActivity;
    private int mType;

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/TvInputInfo$TvInputSettings.class */
    public static final class TvInputSettings {
        private static final String CUSTOM_NAME_SEPARATOR = ",";
        private static final String TV_INPUT_SEPARATOR = ":";

        private TvInputSettings() {
        }

        private static void ensureValidField(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(str + " should not empty ");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String getCustomLabel(Context context, String str, int i) {
            return getCustomLabels(context, i).get(str);
        }

        public static Map<String, String> getCustomLabels(Context context, int i) {
            String stringForUser = Settings.Secure.getStringForUser(context.getContentResolver(), Settings.Secure.TV_INPUT_CUSTOM_LABELS, i);
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(stringForUser)) {
                String[] split = stringForUser.split(":");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    String[] split2 = split[i3].split(",");
                    hashMap.put(Uri.decode(split2[0]), Uri.decode(split2[1]));
                    i2 = i3 + 1;
                }
            }
            return hashMap;
        }

        public static Set<String> getHiddenTvInputIds(Context context, int i) {
            String stringForUser = Settings.Secure.getStringForUser(context.getContentResolver(), Settings.Secure.TV_INPUT_HIDDEN_INPUTS, i);
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(stringForUser)) {
                String[] split = stringForUser.split(":");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    hashSet.add(Uri.decode(split[i3]));
                    i2 = i3 + 1;
                }
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isHidden(Context context, String str, int i) {
            return getHiddenTvInputIds(context, i).contains(str);
        }

        public static void putCustomLabels(Context context, Map<String, String> map, int i) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                ensureValidField(entry.getKey());
                ensureValidField(entry.getValue());
                if (z) {
                    z = false;
                } else {
                    sb.append(":");
                }
                sb.append(Uri.encode(entry.getKey()));
                sb.append(",");
                sb.append(Uri.encode(entry.getValue()));
            }
            Settings.Secure.putStringForUser(context.getContentResolver(), Settings.Secure.TV_INPUT_CUSTOM_LABELS, sb.toString(), i);
        }

        public static void putHiddenTvInputs(Context context, Set<String> set, int i) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : set) {
                ensureValidField(str);
                if (z) {
                    z = false;
                } else {
                    sb.append(":");
                }
                sb.append(Uri.encode(str));
            }
            Settings.Secure.putStringForUser(context.getContentResolver(), Settings.Secure.TV_INPUT_HIDDEN_INPUTS, sb.toString(), i);
        }
    }

    static {
        sHardwareTypeToTvInputType.put(1, 1000);
        sHardwareTypeToTvInputType.put(2, 0);
        sHardwareTypeToTvInputType.put(3, 1001);
        sHardwareTypeToTvInputType.put(4, 1002);
        sHardwareTypeToTvInputType.put(5, 1003);
        sHardwareTypeToTvInputType.put(6, 1004);
        sHardwareTypeToTvInputType.put(7, 1005);
        sHardwareTypeToTvInputType.put(8, 1006);
        sHardwareTypeToTvInputType.put(9, 1007);
        sHardwareTypeToTvInputType.put(10, 1008);
        CREATOR = new Parcelable.Creator<TvInputInfo>() { // from class: android.media.tv.TvInputInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TvInputInfo createFromParcel(Parcel parcel) {
                return new TvInputInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TvInputInfo[] newArray(int i) {
                return new TvInputInfo[i];
            }
        };
    }

    private TvInputInfo(ResolveInfo resolveInfo, String str, String str2, int i) {
        this.mType = 0;
        this.mService = resolveInfo;
        this.mId = str;
        this.mParentId = str2;
        this.mType = i;
    }

    private TvInputInfo(Parcel parcel) {
        this.mType = 0;
        this.mId = parcel.readString();
        this.mParentId = parcel.readString();
        this.mService = ResolveInfo.CREATOR.createFromParcel(parcel);
        this.mSetupActivity = parcel.readString();
        this.mSettingsActivity = parcel.readString();
        this.mType = parcel.readInt();
        this.mHdmiDeviceInfo = (HdmiDeviceInfo) parcel.readParcelable(null);
        this.mIconUri = (Uri) parcel.readParcelable(null);
        this.mLabel = parcel.readString();
        this.mIsConnectedToHdmiSwitch = parcel.readByte() == 1;
    }

    public static TvInputInfo createTvInputInfo(Context context, ResolveInfo resolveInfo) throws XmlPullParserException, IOException {
        return createTvInputInfo(context, resolveInfo, generateInputIdForComponentName(new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name)), null, 0, null, null, false);
    }

    public static TvInputInfo createTvInputInfo(Context context, ResolveInfo resolveInfo, HdmiDeviceInfo hdmiDeviceInfo, String str, String str2, Uri uri) throws XmlPullParserException, IOException {
        TvInputInfo createTvInputInfo = createTvInputInfo(context, resolveInfo, generateInputIdForHdmiDevice(new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name), hdmiDeviceInfo), str, 1007, str2, uri, (hdmiDeviceInfo.getPhysicalAddress() & FileObserver.ALL_EVENTS) != 0);
        createTvInputInfo.mHdmiDeviceInfo = hdmiDeviceInfo;
        return createTvInputInfo;
    }

    public static TvInputInfo createTvInputInfo(Context context, ResolveInfo resolveInfo, TvInputHardwareInfo tvInputHardwareInfo, String str, Uri uri) throws XmlPullParserException, IOException {
        return createTvInputInfo(context, resolveInfo, generateInputIdForHardware(new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name), tvInputHardwareInfo), null, sHardwareTypeToTvInputType.get(tvInputHardwareInfo.getType(), 0), str, uri, false);
    }

    private static TvInputInfo createTvInputInfo(Context context, ResolveInfo resolveInfo, String str, String str2, int i, String str3, Uri uri, boolean z) throws XmlPullParserException, IOException {
        int next;
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        PackageManager packageManager = context.getPackageManager();
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                XmlResourceParser loadXmlMetaData = serviceInfo.loadXmlMetaData(packageManager, TvInputService.SERVICE_META_DATA);
                if (loadXmlMetaData == null) {
                    throw new XmlPullParserException("No android.media.tv.input meta-data for " + serviceInfo.name);
                }
                Resources resourcesForApplication = packageManager.getResourcesForApplication(serviceInfo.applicationInfo);
                AttributeSet asAttributeSet = Xml.asAttributeSet(loadXmlMetaData);
                do {
                    next = loadXmlMetaData.next();
                    if (next == 1) {
                        break;
                    }
                } while (next != 2);
                if (XML_START_TAG_NAME.equals(loadXmlMetaData.getName())) {
                    TvInputInfo tvInputInfo = new TvInputInfo(resolveInfo, str, str2, i);
                    TypedArray obtainAttributes = resourcesForApplication.obtainAttributes(asAttributeSet, R.styleable.TvInputService);
                    tvInputInfo.mSetupActivity = obtainAttributes.getString(1);
                    if (i == 0 && TextUtils.isEmpty(tvInputInfo.mSetupActivity)) {
                        throw new XmlPullParserException("Setup activity not found in " + serviceInfo.name);
                    }
                    tvInputInfo.mSettingsActivity = obtainAttributes.getString(0);
                    obtainAttributes.recycle();
                    tvInputInfo.mLabel = str3;
                    tvInputInfo.mIconUri = uri;
                    tvInputInfo.mIsConnectedToHdmiSwitch = z;
                    if (loadXmlMetaData != null) {
                        loadXmlMetaData.close();
                    }
                    return tvInputInfo;
                }
                throw new XmlPullParserException("Meta-data does not start with tv-input-service tag in " + serviceInfo.name);
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

    private static final String generateInputIdForComponentName(ComponentName componentName) {
        return componentName.flattenToShortString();
    }

    private static final String generateInputIdForHardware(ComponentName componentName, TvInputHardwareInfo tvInputHardwareInfo) {
        return componentName.flattenToShortString() + String.format("%s%s%d", DELIMITER_INFO_IN_ID, PREFIX_HARDWARE_DEVICE, Integer.valueOf(tvInputHardwareInfo.getDeviceId()));
    }

    private static final String generateInputIdForHdmiDevice(ComponentName componentName, HdmiDeviceInfo hdmiDeviceInfo) {
        return componentName.flattenToShortString() + String.format(String.format("%s%s%%0%sX%%0%sX", DELIMITER_INFO_IN_ID, PREFIX_HDMI_DEVICE, 4, 2), Integer.valueOf(hdmiDeviceInfo.getPhysicalAddress()), Integer.valueOf(hdmiDeviceInfo.getId()));
    }

    private Drawable loadServiceIcon(Context context) {
        if (this.mService.serviceInfo.icon == 0 && this.mService.serviceInfo.applicationInfo.icon == 0) {
            return null;
        }
        return this.mService.serviceInfo.loadIcon(context.getPackageManager());
    }

    public Intent createSettingsIntent() {
        if (TextUtils.isEmpty(this.mSettingsActivity)) {
            return null;
        }
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(this.mService.serviceInfo.packageName, this.mSettingsActivity);
        intent.putExtra(EXTRA_INPUT_ID, getId());
        return intent;
    }

    public Intent createSetupIntent() {
        if (TextUtils.isEmpty(this.mSetupActivity)) {
            return null;
        }
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(this.mService.serviceInfo.packageName, this.mSetupActivity);
        intent.putExtra(EXTRA_INPUT_ID, getId());
        return intent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TvInputInfo) {
            return this.mId.equals(((TvInputInfo) obj).mId);
        }
        return false;
    }

    public ComponentName getComponent() {
        return new ComponentName(this.mService.serviceInfo.packageName, this.mService.serviceInfo.name);
    }

    public HdmiDeviceInfo getHdmiDeviceInfo() {
        if (this.mType == 1007) {
            return this.mHdmiDeviceInfo;
        }
        return null;
    }

    public String getId() {
        return this.mId;
    }

    public String getParentId() {
        return this.mParentId;
    }

    public ServiceInfo getServiceInfo() {
        return this.mService.serviceInfo;
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        return this.mId.hashCode();
    }

    public boolean isConnectedToHdmiSwitch() {
        return this.mIsConnectedToHdmiSwitch;
    }

    public boolean isHidden(Context context) {
        return TvInputSettings.isHidden(context, this.mId, UserHandle.myUserId());
    }

    public boolean isPassthroughInput() {
        return this.mType != 0;
    }

    public CharSequence loadCustomLabel(Context context) {
        return TvInputSettings.getCustomLabel(context, this.mId, UserHandle.myUserId());
    }

    public Drawable loadIcon(Context context) {
        Drawable drawable;
        if (this.mIconUri == null) {
            drawable = loadServiceIcon(context);
        } else {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(this.mIconUri);
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                if (createFromStream == null) {
                    Drawable loadServiceIcon = loadServiceIcon(context);
                    drawable = loadServiceIcon;
                    if (openInputStream != null) {
                        if (0 != 0) {
                            openInputStream.close();
                            return loadServiceIcon;
                        }
                        openInputStream.close();
                        return loadServiceIcon;
                    }
                } else {
                    drawable = createFromStream;
                    if (openInputStream != null) {
                        if (0 != 0) {
                            openInputStream.close();
                            return createFromStream;
                        }
                        openInputStream.close();
                        return createFromStream;
                    }
                }
            } catch (IOException e) {
                Log.w(TAG, "Loading the default icon due to a failure on loading " + this.mIconUri, e);
                return loadServiceIcon(context);
            }
        }
        return drawable;
    }

    public CharSequence loadLabel(Context context) {
        return TextUtils.isEmpty(this.mLabel) ? this.mService.loadLabel(context.getPackageManager()) : this.mLabel;
    }

    public String toString() {
        return "TvInputInfo{id=" + this.mId + ", pkg=" + this.mService.serviceInfo.packageName + ", service=" + this.mService.serviceInfo.name + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mParentId);
        this.mService.writeToParcel(parcel, i);
        parcel.writeString(this.mSetupActivity);
        parcel.writeString(this.mSettingsActivity);
        parcel.writeInt(this.mType);
        parcel.writeParcelable(this.mHdmiDeviceInfo, i);
        parcel.writeParcelable(this.mIconUri, i);
        parcel.writeString(this.mLabel);
        parcel.writeByte(this.mIsConnectedToHdmiSwitch ? (byte) 1 : (byte) 0);
    }
}
