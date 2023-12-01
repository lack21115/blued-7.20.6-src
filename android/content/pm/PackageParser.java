package android.content.pm;

import android.Manifest;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.ThemeConfig;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import android.util.TypedValue;
import com.android.internal.R;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.XmlUtils;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.StrictJarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser.class */
public class PackageParser {
    private static final String ANDROID_MANIFEST_FILENAME = "AndroidManifest.xml";
    private static final String ANDROID_RESOURCES = "http://schemas.android.com/apk/res/android";
    private static final String ATTRIBUTE_ITEM_NAME = "name";
    private static final boolean DEBUG_BACKUP = false;
    private static final boolean DEBUG_JAR = false;
    private static final boolean DEBUG_PARSER = false;
    private static final String ICON_PATH = "assets/icons/";
    private static final String OVERLAY_PATH = "assets/overlays/";
    private static final String PACKAGE_REDIRECTIONS_XML = "res/xml/redirections.xml";
    public static final int PARSE_CHATTY = 2;
    public static final int PARSE_COLLECT_CERTIFICATES = 256;
    private static final int PARSE_DEFAULT_INSTALL_LOCATION = -1;
    public static final int PARSE_FORWARD_LOCK = 16;
    public static final int PARSE_IGNORE_PROCESSES = 8;
    public static final int PARSE_IS_PREBUNDLED_DIR = 1024;
    public static final int PARSE_IS_PRIVILEGED = 128;
    public static final int PARSE_IS_SYSTEM = 1;
    public static final int PARSE_IS_SYSTEM_DIR = 64;
    public static final int PARSE_MUST_BE_APK = 4;
    public static final int PARSE_ON_SDCARD = 32;
    public static final int PARSE_TRUSTED_OVERLAY = 512;
    private static final boolean RIGID_PARSER = false;
    private static final String TAG = "PackageParser";
    private static final String TAG_ITEM = "item";
    private static final String TAG_PACKAGE_REDIRECTIONS = "package-redirections";
    private static final String TAG_RESOURCE_REDIRECTIONS = "resource-redirections";
    @Deprecated
    private String mArchiveSourcePath;
    private boolean mOnlyCoreApps;
    private ParseComponentArgs mParseActivityAliasArgs;
    private ParseComponentArgs mParseActivityArgs;
    private ParsePackageItemArgs mParseInstrumentationArgs;
    private ParseComponentArgs mParseProviderArgs;
    private ParseComponentArgs mParseServiceArgs;
    private String[] mSeparateProcesses;
    public static final NewPermissionInfo[] NEW_PERMISSIONS = {new NewPermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", 4, 0), new NewPermissionInfo("android.permission.READ_PHONE_STATE", 4, 0)};
    public static final SplitPermissionInfo[] SPLIT_PERMISSIONS = {new SplitPermissionInfo("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 10001), new SplitPermissionInfo(Manifest.permission.READ_CONTACTS, new String[]{Manifest.permission.READ_CALL_LOG}, 16), new SplitPermissionInfo(Manifest.permission.WRITE_CONTACTS, new String[]{Manifest.permission.WRITE_CALL_LOG}, 16)};
    private static final int SDK_VERSION = Build.VERSION.SDK_INT;
    private static final String[] SDK_CODENAMES = Build.VERSION.ACTIVE_CODENAMES;
    private static boolean sCompatibilityModeEnabled = true;
    private static final Comparator<String> sSplitNameComparator = new SplitNameComparator();
    private static AtomicReference<byte[]> sBuffer = new AtomicReference<>();
    private int mParseError = 1;
    private DisplayMetrics mMetrics = new DisplayMetrics();

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Activity.class */
    public static final class Activity extends Component<ActivityIntentInfo> {
        public final ActivityInfo info;

        public Activity(ParseComponentArgs parseComponentArgs, ActivityInfo activityInfo) {
            super(parseComponentArgs, (ComponentInfo) activityInfo);
            this.info = activityInfo;
            this.info.applicationInfo = parseComponentArgs.owner.applicationInfo;
        }

        @Override // android.content.pm.PackageParser.Component
        public void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Activity{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$ActivityIntentInfo.class */
    public static final class ActivityIntentInfo extends IntentInfo {
        public final Activity activity;

        public ActivityIntentInfo(Activity activity) {
            this.activity = activity;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ActivityIntentInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            this.activity.appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$ApkLite.class */
    public static class ApkLite {
        public final String codePath;
        public final boolean coreApp;
        public final int installLocation;
        public final boolean isTheme;
        public final boolean multiArch;
        public final String packageName;
        public final int revisionCode;
        public final Signature[] signatures;
        public final String splitName;
        public final VerifierInfo[] verifiers;
        public final int versionCode;

        public ApkLite(String str, String str2, String str3, int i, int i2, int i3, List<VerifierInfo> list, Signature[] signatureArr, boolean z, boolean z2, boolean z3) {
            this.codePath = str;
            this.packageName = str2;
            this.splitName = str3;
            this.versionCode = i;
            this.revisionCode = i2;
            this.installLocation = i3;
            this.verifiers = (VerifierInfo[]) list.toArray(new VerifierInfo[list.size()]);
            this.signatures = signatureArr;
            this.coreApp = z;
            this.multiArch = z2;
            this.isTheme = z3;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Component.class */
    public static class Component<II extends IntentInfo> {
        public final String className;
        ComponentName componentName;
        String componentShortName;
        public final ArrayList<II> intents;
        public Bundle metaData;
        public final Package owner;

        public Component(Component<II> component) {
            this.owner = component.owner;
            this.intents = component.intents;
            this.className = component.className;
            this.componentName = component.componentName;
            this.componentShortName = component.componentShortName;
        }

        public Component(Package r4) {
            this.owner = r4;
            this.intents = null;
            this.className = null;
        }

        public Component(ParseComponentArgs parseComponentArgs, ComponentInfo componentInfo) {
            this((ParsePackageItemArgs) parseComponentArgs, (PackageItemInfo) componentInfo);
            if (parseComponentArgs.outError[0] != null) {
                return;
            }
            if (parseComponentArgs.processRes != 0) {
                componentInfo.processName = PackageParser.buildProcessName(this.owner.applicationInfo.packageName, this.owner.applicationInfo.processName, this.owner.applicationInfo.targetSdkVersion >= 8 ? parseComponentArgs.sa.getNonConfigurationString(parseComponentArgs.processRes, 1024) : parseComponentArgs.sa.getNonResourceString(parseComponentArgs.processRes), parseComponentArgs.flags, parseComponentArgs.sepProcesses, parseComponentArgs.outError);
            }
            if (parseComponentArgs.descriptionRes != 0) {
                componentInfo.descriptionRes = parseComponentArgs.sa.getResourceId(parseComponentArgs.descriptionRes, 0);
            }
            componentInfo.enabled = parseComponentArgs.sa.getBoolean(parseComponentArgs.enabledRes, true);
        }

        public Component(ParsePackageItemArgs parsePackageItemArgs, PackageItemInfo packageItemInfo) {
            this.owner = parsePackageItemArgs.owner;
            this.intents = new ArrayList<>(0);
            String nonConfigurationString = parsePackageItemArgs.sa.getNonConfigurationString(parsePackageItemArgs.nameRes, 0);
            if (nonConfigurationString == null) {
                this.className = null;
                parsePackageItemArgs.outError[0] = parsePackageItemArgs.tag + " does not specify android:name";
                return;
            }
            packageItemInfo.name = PackageParser.buildClassName(this.owner.applicationInfo.packageName, nonConfigurationString, parsePackageItemArgs.outError);
            if (packageItemInfo.name == null) {
                this.className = null;
                parsePackageItemArgs.outError[0] = parsePackageItemArgs.tag + " does not have valid android:name";
                return;
            }
            this.className = packageItemInfo.name;
            int resourceId = parsePackageItemArgs.sa.getResourceId(parsePackageItemArgs.iconRes, 0);
            if (resourceId != 0) {
                packageItemInfo.icon = resourceId;
                packageItemInfo.nonLocalizedLabel = null;
            }
            int resourceId2 = parsePackageItemArgs.sa.getResourceId(parsePackageItemArgs.logoRes, 0);
            if (resourceId2 != 0) {
                packageItemInfo.logo = resourceId2;
            }
            int resourceId3 = parsePackageItemArgs.sa.getResourceId(parsePackageItemArgs.bannerRes, 0);
            if (resourceId3 != 0) {
                packageItemInfo.banner = resourceId3;
            }
            TypedValue peekValue = parsePackageItemArgs.sa.peekValue(parsePackageItemArgs.labelRes);
            if (peekValue != null) {
                int i = peekValue.resourceId;
                packageItemInfo.labelRes = i;
                if (i == 0) {
                    packageItemInfo.nonLocalizedLabel = peekValue.coerceToString();
                }
            }
            packageItemInfo.packageName = this.owner.packageName;
        }

        public void appendComponentShortName(StringBuilder sb) {
            ComponentName.appendShortString(sb, this.owner.applicationInfo.packageName, this.className);
        }

        public ComponentName getComponentName() {
            if (this.componentName != null) {
                return this.componentName;
            }
            if (this.className != null) {
                this.componentName = new ComponentName(this.owner.applicationInfo.packageName, this.className);
            }
            return this.componentName;
        }

        public void printComponentShortName(PrintWriter printWriter) {
            ComponentName.printShortString(printWriter, this.owner.applicationInfo.packageName, this.className);
        }

        public void setPackageName(String str) {
            this.componentName = null;
            this.componentShortName = null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Instrumentation.class */
    public static final class Instrumentation extends Component {
        public final InstrumentationInfo info;

        public Instrumentation(ParsePackageItemArgs parsePackageItemArgs, InstrumentationInfo instrumentationInfo) {
            super(parsePackageItemArgs, instrumentationInfo);
            this.info = instrumentationInfo;
        }

        @Override // android.content.pm.PackageParser.Component
        public void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Instrumentation{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$IntentInfo.class */
    public static class IntentInfo extends IntentFilter {
        public int banner;
        public boolean hasDefault;
        public int icon;
        public int labelRes;
        public int logo;
        public CharSequence nonLocalizedLabel;
        public int preferred;
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$NewPermissionInfo.class */
    public static class NewPermissionInfo {
        public final int fileVersion;
        public final String name;
        public final int sdkVersion;

        public NewPermissionInfo(String str, int i, int i2) {
            this.name = str;
            this.sdkVersion = i;
            this.fileVersion = i2;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Package.class */
    public static final class Package {
        public String baseCodePath;
        public boolean baseHardwareAccelerated;
        public int baseRevisionCode;
        public String codePath;
        public boolean coreApp;
        public String cpuAbiOverride;
        public boolean hasIconPack;
        public int installLocation;
        public Certificate[][] mCertificates;
        public Object mExtras;
        public ArrayMap<String, ArraySet<PublicKey>> mKeySetMapping;
        public long mLastPackageUsageTimeInMills;
        public boolean mOperationPending;
        public int mOverlayPriority;
        public String mOverlayTarget;
        public String mRequiredAccountType;
        public boolean mRequiredForAllUsers;
        public String mRestrictedAccountType;
        public String mSharedUserId;
        public int mSharedUserLabel;
        public Signature[] mSignatures;
        public ArraySet<PublicKey> mSigningKeys;
        public boolean mTrustedOverlay;
        public ArraySet<String> mUpgradeKeySets;
        public int mVersionCode;
        public String mVersionName;
        public ManifestDigest manifestDigest;
        public int manifestHashCode;
        public String packageName;
        public ArrayList<String> protectedBroadcasts;
        public String[] splitCodePaths;
        public int[] splitFlags;
        public String[] splitNames;
        public int[] splitRevisionCodes;
        public final ApplicationInfo applicationInfo = new ApplicationInfo();
        public final ArrayList<Permission> permissions = new ArrayList<>(0);
        public final ArrayList<PermissionGroup> permissionGroups = new ArrayList<>(0);
        public final ArrayList<Activity> activities = new ArrayList<>(0);
        public final ArrayList<Activity> receivers = new ArrayList<>(0);
        public final ArrayList<Provider> providers = new ArrayList<>(0);
        public final ArrayList<Service> services = new ArrayList<>(0);
        public final ArrayList<Instrumentation> instrumentation = new ArrayList<>(0);
        public final ArrayList<String> requestedPermissions = new ArrayList<>();
        public final ArrayList<Boolean> requestedPermissionsRequired = new ArrayList<>();
        public ArrayList<String> libraryNames = null;
        public ArrayList<String> usesLibraries = null;
        public ArrayList<String> usesOptionalLibraries = null;
        public String[] usesLibraryFiles = null;
        public ArrayList<ActivityIntentInfo> preferredActivityFilters = null;
        public ArrayList<String> mOriginalPackages = null;
        public String mRealPackage = null;
        public ArrayList<String> mAdoptPermissions = null;
        public Bundle mAppMetaData = null;
        public int mPreferredOrder = 0;
        public final ArraySet<String> mDexOptPerformed = new ArraySet<>(4);
        public boolean mIsThemeApk = false;
        public final ArrayList<String> mOverlayTargets = new ArrayList<>(0);
        public Map<String, Map<String, String>> mPackageRedirections = new HashMap();
        public ThemeInfo mThemeInfo = null;
        public boolean mIsLegacyIconPackApk = false;
        public ArrayList<ConfigurationInfo> configPreferences = null;
        public ArrayList<FeatureInfo> reqFeatures = null;
        public ArrayList<FeatureGroupInfo> featureGroups = null;

        public Package(String str) {
            this.packageName = str;
            this.applicationInfo.packageName = str;
            this.applicationInfo.uid = -1;
        }

        public List<String> getAllCodePaths() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.baseCodePath);
            if (!ArrayUtils.isEmpty(this.splitCodePaths)) {
                Collections.addAll(arrayList, this.splitCodePaths);
            }
            return arrayList;
        }

        public List<String> getAllCodePathsExcludingResourceOnly() {
            ArrayList arrayList = new ArrayList();
            if ((this.applicationInfo.flags & 4) != 0) {
                arrayList.add(this.baseCodePath);
            }
            if (!ArrayUtils.isEmpty(this.splitCodePaths)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.splitCodePaths.length) {
                        break;
                    }
                    if ((this.splitFlags[i2] & 4) != 0) {
                        arrayList.add(this.splitCodePaths[i2]);
                    }
                    i = i2 + 1;
                }
            }
            return arrayList;
        }

        public boolean hasComponentClassName(String str) {
            int size = this.activities.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    int size2 = this.receivers.size();
                    while (true) {
                        int i2 = size2 - 1;
                        if (i2 < 0) {
                            int size3 = this.providers.size();
                            while (true) {
                                int i3 = size3 - 1;
                                if (i3 < 0) {
                                    int size4 = this.services.size();
                                    while (true) {
                                        int i4 = size4 - 1;
                                        if (i4 < 0) {
                                            int size5 = this.instrumentation.size();
                                            while (true) {
                                                int i5 = size5 - 1;
                                                if (i5 < 0) {
                                                    return false;
                                                }
                                                if (str.equals(this.instrumentation.get(i5).className)) {
                                                    return true;
                                                }
                                                size5 = i5;
                                            }
                                        } else if (str.equals(this.services.get(i4).className)) {
                                            return true;
                                        } else {
                                            size4 = i4;
                                        }
                                    }
                                } else if (str.equals(this.providers.get(i3).className)) {
                                    return true;
                                } else {
                                    size3 = i3;
                                }
                            }
                        } else if (str.equals(this.receivers.get(i2).className)) {
                            return true;
                        } else {
                            size2 = i2;
                        }
                    }
                } else if (str.equals(this.activities.get(i).className)) {
                    return true;
                } else {
                    size = i;
                }
            }
        }

        public void setPackageName(String str) {
            this.packageName = str;
            this.applicationInfo.packageName = str;
            int size = this.permissions.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                this.permissions.get(i).setPackageName(str);
                size = i;
            }
            int size2 = this.permissionGroups.size();
            while (true) {
                int i2 = size2 - 1;
                if (i2 < 0) {
                    break;
                }
                this.permissionGroups.get(i2).setPackageName(str);
                size2 = i2;
            }
            int size3 = this.activities.size();
            while (true) {
                int i3 = size3 - 1;
                if (i3 < 0) {
                    break;
                }
                this.activities.get(i3).setPackageName(str);
                size3 = i3;
            }
            int size4 = this.receivers.size();
            while (true) {
                int i4 = size4 - 1;
                if (i4 < 0) {
                    break;
                }
                this.receivers.get(i4).setPackageName(str);
                size4 = i4;
            }
            int size5 = this.providers.size();
            while (true) {
                int i5 = size5 - 1;
                if (i5 < 0) {
                    break;
                }
                this.providers.get(i5).setPackageName(str);
                size5 = i5;
            }
            int size6 = this.services.size();
            while (true) {
                int i6 = size6 - 1;
                if (i6 < 0) {
                    break;
                }
                this.services.get(i6).setPackageName(str);
                size6 = i6;
            }
            int size7 = this.instrumentation.size();
            while (true) {
                int i7 = size7 - 1;
                if (i7 < 0) {
                    return;
                }
                this.instrumentation.get(i7).setPackageName(str);
                size7 = i7;
            }
        }

        public String toString() {
            return "Package{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.packageName + "}";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$PackageLite.class */
    public static class PackageLite {
        public final String baseCodePath;
        public final int baseRevisionCode;
        public final String codePath;
        public final boolean coreApp;
        public final int installLocation;
        public boolean isTheme;
        public final boolean multiArch;
        public final String packageName;
        public final String[] splitCodePaths;
        public final String[] splitNames;
        public final int[] splitRevisionCodes;
        public final VerifierInfo[] verifiers;
        public final int versionCode;

        public PackageLite(String str, ApkLite apkLite, String[] strArr, String[] strArr2, int[] iArr) {
            this.packageName = apkLite.packageName;
            this.versionCode = apkLite.versionCode;
            this.installLocation = apkLite.installLocation;
            this.verifiers = apkLite.verifiers;
            this.splitNames = strArr;
            this.codePath = str;
            this.baseCodePath = apkLite.codePath;
            this.splitCodePaths = strArr2;
            this.baseRevisionCode = apkLite.revisionCode;
            this.splitRevisionCodes = iArr;
            this.coreApp = apkLite.coreApp;
            this.multiArch = apkLite.multiArch;
            this.isTheme = apkLite.isTheme;
        }

        public List<String> getAllCodePaths() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.baseCodePath);
            if (!ArrayUtils.isEmpty(this.splitCodePaths)) {
                Collections.addAll(arrayList, this.splitCodePaths);
            }
            return arrayList;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$PackageParserException.class */
    public static class PackageParserException extends Exception {
        public final int error;

        public PackageParserException(int i, String str) {
            super(str);
            this.error = i;
        }

        public PackageParserException(int i, String str, Throwable th) {
            super(str, th);
            this.error = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$ParseComponentArgs.class */
    public static class ParseComponentArgs extends ParsePackageItemArgs {
        final int descriptionRes;
        final int enabledRes;
        int flags;
        final int processRes;
        final String[] sepProcesses;

        ParseComponentArgs(Package r10, String[] strArr, int i, int i2, int i3, int i4, int i5, String[] strArr2, int i6, int i7, int i8) {
            super(r10, strArr, i, i2, i3, i4, i5);
            this.sepProcesses = strArr2;
            this.processRes = i6;
            this.descriptionRes = i7;
            this.enabledRes = i8;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$ParsePackageItemArgs.class */
    public static class ParsePackageItemArgs {
        final int bannerRes;
        final int iconRes;
        final int labelRes;
        final int logoRes;
        final int nameRes;
        final String[] outError;
        final Package owner;
        TypedArray sa;
        String tag;

        ParsePackageItemArgs(Package r4, String[] strArr, int i, int i2, int i3, int i4, int i5) {
            this.owner = r4;
            this.outError = strArr;
            this.nameRes = i;
            this.labelRes = i2;
            this.iconRes = i3;
            this.logoRes = i4;
            this.bannerRes = i5;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Permission.class */
    public static final class Permission extends Component<IntentInfo> {
        public PermissionGroup group;
        public final PermissionInfo info;
        public boolean tree;

        public Permission(Package r5) {
            super(r5);
            this.info = new PermissionInfo();
        }

        public Permission(Package r4, PermissionInfo permissionInfo) {
            super(r4);
            this.info = permissionInfo;
        }

        @Override // android.content.pm.PackageParser.Component
        public void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public String toString() {
            return "Permission{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.info.name + "}";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$PermissionGroup.class */
    public static final class PermissionGroup extends Component<IntentInfo> {
        public final PermissionGroupInfo info;

        public PermissionGroup(Package r5) {
            super(r5);
            this.info = new PermissionGroupInfo();
        }

        public PermissionGroup(Package r4, PermissionGroupInfo permissionGroupInfo) {
            super(r4);
            this.info = permissionGroupInfo;
        }

        @Override // android.content.pm.PackageParser.Component
        public void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public String toString() {
            return "PermissionGroup{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.info.name + "}";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Provider.class */
    public static final class Provider extends Component<ProviderIntentInfo> {
        public final ProviderInfo info;
        public boolean syncable;

        public Provider(ParseComponentArgs parseComponentArgs, ProviderInfo providerInfo) {
            super(parseComponentArgs, (ComponentInfo) providerInfo);
            this.info = providerInfo;
            this.info.applicationInfo = parseComponentArgs.owner.applicationInfo;
            this.syncable = false;
        }

        public Provider(Provider provider) {
            super(provider);
            this.info = provider.info;
            this.syncable = provider.syncable;
        }

        @Override // android.content.pm.PackageParser.Component
        public void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Provider{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$ProviderIntentInfo.class */
    public static final class ProviderIntentInfo extends IntentInfo {
        public final Provider provider;

        public ProviderIntentInfo(Provider provider) {
            this.provider = provider;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ProviderIntentInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            this.provider.appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$Service.class */
    public static final class Service extends Component<ServiceIntentInfo> {
        public final ServiceInfo info;

        public Service(ParseComponentArgs parseComponentArgs, ServiceInfo serviceInfo) {
            super(parseComponentArgs, (ComponentInfo) serviceInfo);
            this.info = serviceInfo;
            this.info.applicationInfo = parseComponentArgs.owner.applicationInfo;
        }

        @Override // android.content.pm.PackageParser.Component
        public void setPackageName(String str) {
            super.setPackageName(str);
            this.info.packageName = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Service{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$ServiceIntentInfo.class */
    public static final class ServiceIntentInfo extends IntentInfo {
        public final Service service;

        public ServiceIntentInfo(Service service) {
            this.service = service;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("ServiceIntentInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            this.service.appendComponentShortName(sb);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$SplitNameComparator.class */
    private static class SplitNameComparator implements Comparator<String> {
        private SplitNameComparator() {
        }

        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageParser$SplitPermissionInfo.class */
    public static class SplitPermissionInfo {
        public final String[] newPerms;
        public final String rootPerm;
        public final int targetSdk;

        public SplitPermissionInfo(String str, String[] strArr, int i) {
            this.rootPerm = str;
            this.newPerms = strArr;
            this.targetSdk = i;
        }
    }

    public PackageParser() {
        this.mMetrics.setToDefaults();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String buildClassName(String str, CharSequence charSequence, String[] strArr) {
        if (charSequence == null || charSequence.length() <= 0) {
            strArr[0] = "Empty class name in package " + str;
            return null;
        }
        String charSequence2 = charSequence.toString();
        char charAt = charSequence2.charAt(0);
        if (charAt == '.') {
            return (str + charSequence2).intern();
        }
        if (charSequence2.indexOf(46) < 0) {
            return (str + '.' + charSequence2).intern();
        } else if (charAt < 'a' || charAt > 'z') {
            strArr[0] = "Bad class name " + charSequence2 + " in package " + str;
            return null;
        } else {
            return charSequence2.intern();
        }
    }

    private static String buildCompoundName(String str, CharSequence charSequence, String str2, String[] strArr) {
        String charSequence2 = charSequence.toString();
        char charAt = charSequence2.charAt(0);
        if (str == null || charAt != ':') {
            String validateName = validateName(charSequence2, true);
            if (validateName == null || ThemeConfig.SYSTEM_DEFAULT.equals(charSequence2)) {
                return charSequence2.intern();
            }
            strArr[0] = "Invalid " + str2 + " name " + charSequence2 + " in package " + str + ": " + validateName;
            return null;
        } else if (charSequence2.length() < 2) {
            strArr[0] = "Bad " + str2 + " name " + charSequence2 + " in package " + str + ": must be at least two characters";
            return null;
        } else {
            String validateName2 = validateName(charSequence2.substring(1), false);
            if (validateName2 != null) {
                strArr[0] = "Invalid " + str2 + " name " + charSequence2 + " in package " + str + ": " + validateName2;
                return null;
            }
            return (str + charSequence2).intern();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String buildProcessName(String str, String str2, CharSequence charSequence, int i, String[] strArr, String[] strArr2) {
        if ((i & 8) == 0 || ThemeConfig.SYSTEM_DEFAULT.equals(charSequence)) {
            if (strArr != null) {
                int length = strArr.length;
                while (true) {
                    int i2 = length - 1;
                    if (i2 < 0) {
                        break;
                    }
                    String str3 = strArr[i2];
                    if (str3.equals(str) || str3.equals(str2) || str3.equals(charSequence)) {
                        break;
                    }
                    length = i2;
                }
                return str;
            }
            if (charSequence != null && charSequence.length() > 0) {
                return buildCompoundName(str, charSequence, UMModuleRegister.PROCESS, strArr2);
            }
        } else if (str2 == null) {
            return str;
        }
        return str2;
    }

    private static String buildTaskAffinityName(String str, String str2, CharSequence charSequence, String[] strArr) {
        if (charSequence == null) {
            return str2;
        }
        if (charSequence.length() <= 0) {
            return null;
        }
        return buildCompoundName(str, charSequence, "taskAffinity", strArr);
    }

    private static boolean checkUseInstalledOrHidden(int i, PackageUserState packageUserState) {
        return (packageUserState.installed && !packageUserState.hidden) || (i & 8192) != 0;
    }

    public static void closeQuietly(StrictJarFile strictJarFile) {
        if (strictJarFile != null) {
            try {
                strictJarFile.close();
            } catch (Exception e) {
            }
        }
    }

    private static void collectCertificates(Package r6, File file, int i) throws PackageParserException {
        StrictJarFile strictJarFile;
        String absolutePath = file.getAbsolutePath();
        StrictJarFile strictJarFile2 = null;
        try {
            try {
                StrictJarFile strictJarFile3 = new StrictJarFile(absolutePath);
                try {
                    ZipEntry findEntry = strictJarFile3.findEntry("AndroidManifest.xml");
                    if (findEntry == null) {
                        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "Package " + absolutePath + " has no manifest");
                    }
                    ArrayList<ZipEntry> arrayList = new ArrayList();
                    arrayList.add(findEntry);
                    if ((i & 1) == 0) {
                        Iterator it = strictJarFile3.iterator();
                        while (it.hasNext()) {
                            ZipEntry zipEntry = (ZipEntry) it.next();
                            if (!zipEntry.isDirectory() && !zipEntry.getName().startsWith("META-INF/") && !zipEntry.getName().equals("AndroidManifest.xml")) {
                                arrayList.add(zipEntry);
                            }
                        }
                    }
                    for (ZipEntry zipEntry2 : arrayList) {
                        Certificate[][] loadCertificates = loadCertificates(strictJarFile3, zipEntry2);
                        if (ArrayUtils.isEmpty(loadCertificates)) {
                            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES, "Package " + absolutePath + " has no certificates at entry " + zipEntry2.getName());
                        }
                        Signature[] convertToSignatures = convertToSignatures(loadCertificates);
                        if (r6.mCertificates == null) {
                            r6.mCertificates = loadCertificates;
                            r6.mSignatures = convertToSignatures;
                            r6.mSigningKeys = new ArraySet<>();
                            int i2 = 0;
                            while (true) {
                                int i3 = i2;
                                if (i3 < loadCertificates.length) {
                                    r6.mSigningKeys.add(loadCertificates[i3][0].getPublicKey());
                                    i2 = i3 + 1;
                                }
                            }
                        } else if (!Signature.areExactMatch(r6.mSignatures, convertToSignatures)) {
                            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_INCONSISTENT_CERTIFICATES, "Package " + absolutePath + " has mismatched certificates at entry " + zipEntry2.getName());
                        }
                    }
                    closeQuietly(strictJarFile3);
                } catch (IOException e) {
                    strictJarFile = strictJarFile3;
                    e = e;
                    throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES, "Failed to collect certificates from " + absolutePath, e);
                } catch (RuntimeException e2) {
                    strictJarFile = strictJarFile3;
                    e = e2;
                    throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_NO_CERTIFICATES, "Failed to collect certificates from " + absolutePath, e);
                } catch (GeneralSecurityException e3) {
                    e = e3;
                    throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING, "Failed to collect certificates from " + absolutePath, e);
                } catch (Throwable th) {
                    th = th;
                    strictJarFile2 = strictJarFile3;
                    closeQuietly(strictJarFile2);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                strictJarFile = null;
            } catch (RuntimeException e5) {
                e = e5;
                strictJarFile = null;
            } catch (GeneralSecurityException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Signature[] convertToSignatures(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= certificateArr.length) {
                return signatureArr;
            }
            signatureArr[i2] = new Signature(certificateArr[i2]);
            i = i2 + 1;
        }
    }

    private static boolean copyNeeded(int i, Package r4, PackageUserState packageUserState, Bundle bundle, int i2) {
        if (i2 != 0) {
            return true;
        }
        if (packageUserState.enabled != 0) {
            if (r4.applicationInfo.enabled != (packageUserState.enabled == 1)) {
                return true;
            }
        }
        if (!packageUserState.installed || packageUserState.hidden || packageUserState.stopped) {
            return true;
        }
        if ((i & 128) == 0 || (bundle == null && r4.mAppMetaData == null)) {
            if ((i & 1024) == 0 || r4.usesLibraryFiles == null) {
                if (packageUserState.protectedComponents != null) {
                    return r4.applicationInfo.protect != (packageUserState.protectedComponents.size() > 0);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public static final ActivityInfo generateActivityInfo(ActivityInfo activityInfo, int i, PackageUserState packageUserState, int i2) {
        if (activityInfo != null && checkUseInstalledOrHidden(i, packageUserState)) {
            ActivityInfo activityInfo2 = new ActivityInfo(activityInfo);
            activityInfo2.applicationInfo = generateApplicationInfo(activityInfo2.applicationInfo, i, packageUserState, i2);
            return activityInfo2;
        }
        return null;
    }

    public static final ActivityInfo generateActivityInfo(Activity activity, int i, PackageUserState packageUserState, int i2) {
        if (activity != null && checkUseInstalledOrHidden(i, packageUserState)) {
            if (copyNeeded(i, activity.owner, packageUserState, activity.metaData, i2)) {
                ActivityInfo activityInfo = new ActivityInfo(activity.info);
                activityInfo.metaData = activity.metaData;
                activityInfo.applicationInfo = generateApplicationInfo(activity.owner, i, packageUserState, i2);
                return activityInfo;
            }
            return activity.info;
        }
        return null;
    }

    public static ApplicationInfo generateApplicationInfo(ApplicationInfo applicationInfo, int i, PackageUserState packageUserState, int i2) {
        if (applicationInfo != null && checkUseInstalledOrHidden(i, packageUserState)) {
            ApplicationInfo applicationInfo2 = new ApplicationInfo(applicationInfo);
            if (i2 != 0) {
                applicationInfo2.uid = UserHandle.getUid(i2, applicationInfo2.uid);
                applicationInfo2.dataDir = PackageManager.getDataDirForUser(i2, applicationInfo2.packageName);
            }
            if (packageUserState.stopped) {
                applicationInfo2.flags |= 2097152;
            } else {
                applicationInfo2.flags &= -2097153;
            }
            updateApplicationInfo(applicationInfo2, i, packageUserState);
            return applicationInfo2;
        }
        return null;
    }

    public static ApplicationInfo generateApplicationInfo(Package r5, int i, PackageUserState packageUserState) {
        return generateApplicationInfo(r5, i, packageUserState, UserHandle.getCallingUserId());
    }

    public static ApplicationInfo generateApplicationInfo(Package r6, int i, PackageUserState packageUserState, int i2) {
        if (r6 != null && checkUseInstalledOrHidden(i, packageUserState)) {
            if (!copyNeeded(i, r6, packageUserState, null, i2) && ((32768 & i) == 0 || packageUserState.enabled != 4)) {
                updateApplicationInfo(r6.applicationInfo, i, packageUserState);
                return r6.applicationInfo;
            }
            ApplicationInfo applicationInfo = new ApplicationInfo(r6.applicationInfo);
            if (i2 != 0) {
                applicationInfo.uid = UserHandle.getUid(i2, applicationInfo.uid);
                applicationInfo.dataDir = PackageManager.getDataDirForUser(i2, applicationInfo.packageName);
            }
            if ((i & 128) != 0) {
                applicationInfo.metaData = r6.mAppMetaData;
            }
            if ((i & 1024) != 0) {
                applicationInfo.sharedLibraryFiles = r6.usesLibraryFiles;
            }
            if (packageUserState.stopped) {
                applicationInfo.flags |= 2097152;
            } else {
                applicationInfo.flags &= -2097153;
            }
            updateApplicationInfo(applicationInfo, i, packageUserState);
            return applicationInfo;
        }
        return null;
    }

    public static final InstrumentationInfo generateInstrumentationInfo(Instrumentation instrumentation, int i) {
        if (instrumentation == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return instrumentation.info;
        }
        InstrumentationInfo instrumentationInfo = new InstrumentationInfo(instrumentation.info);
        instrumentationInfo.metaData = instrumentation.metaData;
        return instrumentationInfo;
    }

    public static PackageInfo generatePackageInfo(Package r11, int[] iArr, int i, long j, long j2, ArraySet<String> arraySet, PackageUserState packageUserState) {
        return generatePackageInfo(r11, iArr, i, j, j2, arraySet, packageUserState, UserHandle.getCallingUserId());
    }

    public static PackageInfo generatePackageInfo(Package r7, int[] iArr, int i, long j, long j2, ArraySet<String> arraySet, PackageUserState packageUserState, int i2) {
        PackageInfo packageInfo;
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        if (checkUseInstalledOrHidden(i, packageUserState)) {
            PackageInfo packageInfo2 = new PackageInfo();
            packageInfo2.packageName = r7.packageName;
            packageInfo2.splitNames = r7.splitNames;
            packageInfo2.versionCode = r7.mVersionCode;
            packageInfo2.baseRevisionCode = r7.baseRevisionCode;
            packageInfo2.splitRevisionCodes = r7.splitRevisionCodes;
            packageInfo2.versionName = r7.mVersionName;
            packageInfo2.sharedUserId = r7.mSharedUserId;
            packageInfo2.sharedUserLabel = r7.mSharedUserLabel;
            packageInfo2.isThemeApk = r7.mIsThemeApk;
            packageInfo2.hasIconPack = r7.hasIconPack;
            packageInfo2.isLegacyIconPackApk = r7.mIsLegacyIconPackApk;
            if (packageInfo2.isThemeApk) {
                packageInfo2.mOverlayTargets = r7.mOverlayTargets;
                packageInfo2.themeInfo = r7.mThemeInfo;
            }
            packageInfo2.applicationInfo = generateApplicationInfo(r7, i, packageUserState, i2);
            packageInfo2.installLocation = r7.installLocation;
            packageInfo2.coreApp = r7.coreApp;
            if ((packageInfo2.applicationInfo.flags & 1) != 0 || (packageInfo2.applicationInfo.flags & 128) != 0) {
                packageInfo2.requiredForAllUsers = r7.mRequiredForAllUsers;
            }
            packageInfo2.restrictedAccountType = r7.mRestrictedAccountType;
            packageInfo2.requiredAccountType = r7.mRequiredAccountType;
            packageInfo2.overlayTarget = r7.mOverlayTarget;
            packageInfo2.firstInstallTime = j;
            packageInfo2.lastUpdateTime = j2;
            if ((i & 256) != 0) {
                packageInfo2.gids = iArr;
            }
            if ((i & 16384) != 0) {
                int size6 = r7.configPreferences != null ? r7.configPreferences.size() : 0;
                if (size6 > 0) {
                    packageInfo2.configPreferences = new ConfigurationInfo[size6];
                    r7.configPreferences.toArray(packageInfo2.configPreferences);
                }
                int size7 = r7.reqFeatures != null ? r7.reqFeatures.size() : 0;
                if (size7 > 0) {
                    packageInfo2.reqFeatures = new FeatureInfo[size7];
                    r7.reqFeatures.toArray(packageInfo2.reqFeatures);
                }
                int size8 = r7.featureGroups != null ? r7.featureGroups.size() : 0;
                if (size8 > 0) {
                    packageInfo2.featureGroups = new FeatureGroupInfo[size8];
                    r7.featureGroups.toArray(packageInfo2.featureGroups);
                }
            }
            if ((i & 1) != 0 && (size5 = r7.activities.size()) > 0) {
                if ((i & 512) != 0) {
                    packageInfo2.activities = new ActivityInfo[size5];
                } else {
                    int i3 = 0;
                    int i4 = 0;
                    while (i4 < size5) {
                        int i5 = i3;
                        if (r7.activities.get(i4).info.enabled) {
                            i5 = i3 + 1;
                        }
                        i4++;
                        i3 = i5;
                    }
                    packageInfo2.activities = new ActivityInfo[i3];
                }
                int i6 = 0;
                for (int i7 = 0; i7 < size5; i7++) {
                    if (r7.activities.get(i7).info.enabled || (i & 512) != 0) {
                        packageInfo2.activities[i6] = generateActivityInfo(r7.activities.get(i7), i, packageUserState, i2);
                        i6++;
                    }
                }
            }
            if ((i & 2) != 0 && (size4 = r7.receivers.size()) > 0) {
                if ((i & 512) != 0) {
                    packageInfo2.receivers = new ActivityInfo[size4];
                } else {
                    int i8 = 0;
                    int i9 = 0;
                    while (i9 < size4) {
                        int i10 = i8;
                        if (r7.receivers.get(i9).info.enabled) {
                            i10 = i8 + 1;
                        }
                        i9++;
                        i8 = i10;
                    }
                    packageInfo2.receivers = new ActivityInfo[i8];
                }
                int i11 = 0;
                for (int i12 = 0; i12 < size4; i12++) {
                    if (r7.receivers.get(i12).info.enabled || (i & 512) != 0) {
                        packageInfo2.receivers[i11] = generateActivityInfo(r7.receivers.get(i12), i, packageUserState, i2);
                        i11++;
                    }
                }
            }
            if ((i & 4) != 0 && (size3 = r7.services.size()) > 0) {
                if ((i & 512) != 0) {
                    packageInfo2.services = new ServiceInfo[size3];
                } else {
                    int i13 = 0;
                    int i14 = 0;
                    while (i14 < size3) {
                        int i15 = i13;
                        if (r7.services.get(i14).info.enabled) {
                            i15 = i13 + 1;
                        }
                        i14++;
                        i13 = i15;
                    }
                    packageInfo2.services = new ServiceInfo[i13];
                }
                int i16 = 0;
                for (int i17 = 0; i17 < size3; i17++) {
                    if (r7.services.get(i17).info.enabled || (i & 512) != 0) {
                        packageInfo2.services[i16] = generateServiceInfo(r7.services.get(i17), i, packageUserState, i2);
                        i16++;
                    }
                }
            }
            if ((i & 8) != 0 && (size2 = r7.providers.size()) > 0) {
                if ((i & 512) != 0) {
                    packageInfo2.providers = new ProviderInfo[size2];
                } else {
                    int i18 = 0;
                    int i19 = 0;
                    while (i19 < size2) {
                        int i20 = i18;
                        if (r7.providers.get(i19).info.enabled) {
                            i20 = i18 + 1;
                        }
                        i19++;
                        i18 = i20;
                    }
                    packageInfo2.providers = new ProviderInfo[i18];
                }
                int i21 = 0;
                for (int i22 = 0; i22 < size2; i22++) {
                    if (r7.providers.get(i22).info.enabled || (i & 512) != 0) {
                        packageInfo2.providers[i21] = generateProviderInfo(r7.providers.get(i22), i, packageUserState, i2);
                        i21++;
                    }
                }
            }
            if ((i & 16) != 0 && (size = r7.instrumentation.size()) > 0) {
                packageInfo2.instrumentation = new InstrumentationInfo[size];
                int i23 = 0;
                while (true) {
                    int i24 = i23;
                    if (i24 >= size) {
                        break;
                    }
                    packageInfo2.instrumentation[i24] = generateInstrumentationInfo(r7.instrumentation.get(i24), i);
                    i23 = i24 + 1;
                }
            }
            if ((i & 4096) != 0) {
                int size9 = r7.permissions.size();
                if (size9 > 0) {
                    packageInfo2.permissions = new PermissionInfo[size9];
                    int i25 = 0;
                    while (true) {
                        int i26 = i25;
                        if (i26 >= size9) {
                            break;
                        }
                        packageInfo2.permissions[i26] = generatePermissionInfo(r7.permissions.get(i26), i);
                        i25 = i26 + 1;
                    }
                }
                int size10 = r7.requestedPermissions.size();
                if (size10 > 0) {
                    packageInfo2.requestedPermissions = new String[size10];
                    packageInfo2.requestedPermissionsFlags = new int[size10];
                    int i27 = 0;
                    while (true) {
                        int i28 = i27;
                        if (i28 >= size10) {
                            break;
                        }
                        String str = r7.requestedPermissions.get(i28);
                        packageInfo2.requestedPermissions[i28] = str;
                        if (r7.requestedPermissionsRequired.get(i28).booleanValue()) {
                            int[] iArr2 = packageInfo2.requestedPermissionsFlags;
                            iArr2[i28] = iArr2[i28] | 1;
                        }
                        if (arraySet != null && arraySet.contains(str)) {
                            int[] iArr3 = packageInfo2.requestedPermissionsFlags;
                            iArr3[i28] = iArr3[i28] | 2;
                        }
                        i27 = i28 + 1;
                    }
                }
            }
            packageInfo = packageInfo2;
            if ((i & 64) != 0) {
                int length = r7.mSignatures != null ? r7.mSignatures.length : 0;
                packageInfo = packageInfo2;
                if (length > 0) {
                    packageInfo2.signatures = new Signature[length];
                    System.arraycopy(r7.mSignatures, 0, packageInfo2.signatures, 0, length);
                    return packageInfo2;
                }
            }
        } else {
            packageInfo = null;
        }
        return packageInfo;
    }

    public static final PermissionGroupInfo generatePermissionGroupInfo(PermissionGroup permissionGroup, int i) {
        if (permissionGroup == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return permissionGroup.info;
        }
        PermissionGroupInfo permissionGroupInfo = new PermissionGroupInfo(permissionGroup.info);
        permissionGroupInfo.metaData = permissionGroup.metaData;
        return permissionGroupInfo;
    }

    public static final PermissionInfo generatePermissionInfo(Permission permission, int i) {
        if (permission == null) {
            return null;
        }
        if ((i & 128) == 0) {
            return permission.info;
        }
        PermissionInfo permissionInfo = new PermissionInfo(permission.info);
        permissionInfo.metaData = permission.metaData;
        return permissionInfo;
    }

    public static final ProviderInfo generateProviderInfo(Provider provider, int i, PackageUserState packageUserState, int i2) {
        if (provider != null && checkUseInstalledOrHidden(i, packageUserState)) {
            if (copyNeeded(i, provider.owner, packageUserState, provider.metaData, i2) || ((i & 2048) == 0 && provider.info.uriPermissionPatterns != null)) {
                ProviderInfo providerInfo = new ProviderInfo(provider.info);
                providerInfo.metaData = provider.metaData;
                if ((i & 2048) == 0) {
                    providerInfo.uriPermissionPatterns = null;
                }
                providerInfo.applicationInfo = generateApplicationInfo(provider.owner, i, packageUserState, i2);
                return providerInfo;
            }
            return provider.info;
        }
        return null;
    }

    public static final ServiceInfo generateServiceInfo(Service service, int i, PackageUserState packageUserState, int i2) {
        if (service != null && checkUseInstalledOrHidden(i, packageUserState)) {
            if (copyNeeded(i, service.owner, packageUserState, service.metaData, i2)) {
                ServiceInfo serviceInfo = new ServiceInfo(service.info);
                serviceInfo.metaData = service.metaData;
                serviceInfo.applicationInfo = generateApplicationInfo(service.owner, i, packageUserState, i2);
                return serviceInfo;
            }
            return service.info;
        }
        return null;
    }

    public static final boolean isApkFile(File file) {
        return isApkPath(file.getName());
    }

    private static boolean isApkPath(String str) {
        return str.endsWith(".apk");
    }

    public static boolean isAvailable(PackageUserState packageUserState) {
        return checkUseInstalledOrHidden(0, packageUserState);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isLegacyIconPack(org.xmlpull.v1.XmlPullParser r4) {
        /*
            java.lang.String r0 = "action"
            r1 = r4
            java.lang.String r1 = r1.getName()
            boolean r0 = r0.equals(r1)
            r8 = r0
            java.lang.String r0 = "category"
            r1 = r4
            java.lang.String r1 = r1.getName()
            boolean r0 = r0.equals(r1)
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L68
            java.lang.String[] r0 = android.content.pm.ThemeUtils.sSupportedActions
            r10 = r0
        L26:
            r0 = r10
            if (r0 == 0) goto L89
            r0 = 0
            r5 = r0
        L2d:
            r0 = r5
            r1 = r4
            int r1 = r1.getAttributeCount()
            if (r0 >= r1) goto L89
            java.lang.String r0 = "name"
            r1 = r4
            r2 = r5
            java.lang.String r1 = r1.getAttributeName(r2)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L82
            r0 = r4
            r1 = r5
            java.lang.String r0 = r0.getAttributeValue(r1)
            r11 = r0
            r0 = r10
            int r0 = r0.length
            r7 = r0
            r0 = 0
            r6 = r0
        L55:
            r0 = r6
            r1 = r7
            if (r0 >= r1) goto L82
            r0 = r10
            r1 = r6
            r0 = r0[r1]
            r1 = r11
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7b
            r0 = 1
            return r0
        L68:
            r0 = r9
            if (r0 == 0) goto L75
            java.lang.String[] r0 = android.content.pm.ThemeUtils.sSupportedCategories
            r10 = r0
            goto L26
        L75:
            r0 = 0
            r10 = r0
            goto L26
        L7b:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L55
        L82:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L2d
        L89:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.PackageParser.isLegacyIconPack(org.xmlpull.v1.XmlPullParser):boolean");
    }

    private static boolean isPackageThemeable(String str, String[] strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (str.startsWith(strArr[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static int loadApkIntoAssetManager(AssetManager assetManager, String str, int i) throws PackageParserException {
        if ((i & 4) == 0 || isApkPath(str)) {
            int addAssetPath = assetManager.addAssetPath(str);
            if (addAssetPath == 0) {
                throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "Failed adding asset path: " + str);
            }
            return addAssetPath;
        }
        throw new PackageParserException(-100, "Invalid package file: " + str);
    }

    private static Certificate[][] loadCertificates(StrictJarFile strictJarFile, ZipEntry zipEntry) throws PackageParserException {
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            try {
                InputStream inputStream3 = strictJarFile.getInputStream(zipEntry);
                readFullyIgnoringContents(inputStream3);
                inputStream2 = inputStream3;
                inputStream = inputStream3;
                Certificate[][] certificateChains = strictJarFile.getCertificateChains(zipEntry);
                IoUtils.closeQuietly(inputStream3);
                return certificateChains;
            } catch (IOException e) {
                e = e;
                throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed reading " + zipEntry.getName() + " in " + strictJarFile, e);
            } catch (RuntimeException e2) {
                e = e2;
                inputStream2 = inputStream;
                throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed reading " + zipEntry.getName() + " in " + strictJarFile, e);
            }
        } catch (Throwable th) {
            IoUtils.closeQuietly((AutoCloseable) null);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.zip.ZipFile] */
    private boolean packageHasIconPack(File file) {
        ZipFile zipFile;
        Exception e;
        Enumeration<? extends ZipEntry> enumeration = null;
        try {
            try {
                zipFile = new ZipFile(file.getPath());
                try {
                    enumeration = zipFile.entries();
                    while (enumeration.hasMoreElements()) {
                        String name = enumeration.nextElement().getName();
                        if (name.startsWith("assets/icons/") && name.length() > "assets/icons/".length()) {
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                    return true;
                                } catch (Exception e2) {
                                    return true;
                                }
                            }
                            return true;
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (Exception e3) {
                            return false;
                        }
                    }
                    return false;
                } catch (Exception e4) {
                    e = e4;
                    Log.e(TAG, "Could not read zip entries while checking if apk has icon pack", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                            return false;
                        } catch (Exception e5) {
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    enumeration = zipFile;
                    th = th;
                    if (enumeration != null) {
                        try {
                            enumeration.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e7) {
                zipFile = null;
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x07a0, code lost:
        r16 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x07a5, code lost:
        if (r27 != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x07a8, code lost:
        r0 = r0.info;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x07b6, code lost:
        if (r0.intents.size() <= 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x07b9, code lost:
        r22 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x07bc, code lost:
        r0.exported = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x07c4, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x07c5, code lost:
        r22 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.pm.PackageParser.Activity parseActivity(android.content.pm.PackageParser.Package r16, android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, int r20, java.lang.String[] r21, boolean r22, boolean r23) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.PackageParser.parseActivity(android.content.pm.PackageParser$Package, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, int, java.lang.String[], boolean, boolean):android.content.pm.PackageParser$Activity");
    }

    private Activity parseActivityAlias(Package r16, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) throws XmlPullParserException, IOException {
        Activity activity;
        Activity activity2;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestActivityAlias);
        String nonConfigurationString = obtainAttributes.getNonConfigurationString(7, 1024);
        if (nonConfigurationString == null) {
            strArr[0] = "<activity-alias> does not specify android:targetActivity";
            obtainAttributes.recycle();
            activity2 = null;
        } else {
            String buildClassName = buildClassName(r16.applicationInfo.packageName, nonConfigurationString, strArr);
            if (buildClassName == null) {
                obtainAttributes.recycle();
                return null;
            }
            if (this.mParseActivityAliasArgs == null) {
                this.mParseActivityAliasArgs = new ParseComponentArgs(r16, strArr, 2, 0, 1, 8, 10, this.mSeparateProcesses, 0, 6, 4);
                this.mParseActivityAliasArgs.tag = "<activity-alias>";
            }
            this.mParseActivityAliasArgs.sa = obtainAttributes;
            this.mParseActivityAliasArgs.flags = i;
            int size = r16.activities.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                activity = null;
                if (i3 >= size) {
                    break;
                }
                activity = r16.activities.get(i3);
                if (buildClassName.equals(activity.info.name)) {
                    break;
                }
                i2 = i3 + 1;
            }
            if (activity == null) {
                strArr[0] = "<activity-alias> target activity " + buildClassName + " not found in manifest";
                obtainAttributes.recycle();
                return null;
            }
            ActivityInfo activityInfo = new ActivityInfo();
            activityInfo.targetActivity = buildClassName;
            activityInfo.configChanges = activity.info.configChanges;
            activityInfo.flags = activity.info.flags;
            activityInfo.icon = activity.info.icon;
            activityInfo.logo = activity.info.logo;
            activityInfo.banner = activity.info.banner;
            activityInfo.labelRes = activity.info.labelRes;
            activityInfo.nonLocalizedLabel = activity.info.nonLocalizedLabel;
            activityInfo.launchMode = activity.info.launchMode;
            activityInfo.processName = activity.info.processName;
            if (activityInfo.descriptionRes == 0) {
                activityInfo.descriptionRes = activity.info.descriptionRes;
            }
            activityInfo.screenOrientation = activity.info.screenOrientation;
            activityInfo.taskAffinity = activity.info.taskAffinity;
            activityInfo.theme = activity.info.theme;
            activityInfo.softInputMode = activity.info.softInputMode;
            activityInfo.uiOptions = activity.info.uiOptions;
            activityInfo.parentActivityName = activity.info.parentActivityName;
            activityInfo.maxRecents = activity.info.maxRecents;
            Activity activity3 = new Activity(this.mParseActivityAliasArgs, activityInfo);
            if (strArr[0] != null) {
                obtainAttributes.recycle();
                return null;
            }
            boolean hasValue = obtainAttributes.hasValue(5);
            if (hasValue) {
                activity3.info.exported = obtainAttributes.getBoolean(5, false);
            }
            String nonConfigurationString2 = obtainAttributes.getNonConfigurationString(3, 0);
            if (nonConfigurationString2 != null) {
                activity3.info.permission = nonConfigurationString2.length() > 0 ? nonConfigurationString2.toString().intern() : null;
            }
            String nonConfigurationString3 = obtainAttributes.getNonConfigurationString(9, 1024);
            if (nonConfigurationString3 != null) {
                String buildClassName2 = buildClassName(activity3.info.packageName, nonConfigurationString3, strArr);
                if (strArr[0] == null) {
                    activity3.info.parentActivityName = buildClassName2;
                } else {
                    Log.e(TAG, "Activity alias " + activity3.info.name + " specified invalid parentActivityName " + nonConfigurationString3);
                    strArr[0] = null;
                }
            }
            obtainAttributes.recycle();
            if (strArr[0] != null) {
                return null;
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                    break;
                } else if (next != 3 && next != 4) {
                    if (xmlPullParser.getName().equals("intent-filter")) {
                        ActivityIntentInfo activityIntentInfo = new ActivityIntentInfo(activity3);
                        if (!parseIntent(resources, xmlPullParser, attributeSet, true, activityIntentInfo, strArr)) {
                            return null;
                        }
                        if (activityIntentInfo.countActions() == 0) {
                            Slog.w(TAG, "No actions in intent filter at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                        } else {
                            activity3.intents.add(activityIntentInfo);
                        }
                    } else if (xmlPullParser.getName().equals("meta-data")) {
                        Bundle parseMetaData = parseMetaData(resources, xmlPullParser, attributeSet, activity3.metaData, strArr);
                        activity3.metaData = parseMetaData;
                        if (parseMetaData == null) {
                            return null;
                        }
                    } else {
                        Slog.w(TAG, "Unknown element under <activity-alias>: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                        XmlUtils.skipCurrentTag(xmlPullParser);
                    }
                }
            }
            activity2 = activity3;
            if (!hasValue) {
                activity3.info.exported = activity3.intents.size() > 0;
                return activity3;
            }
        }
        return activity2;
    }

    private boolean parseAllMetaData(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String str, Component component, String[] strArr) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return true;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return true;
            }
            if (next != 3 && next != 4) {
                if (xmlPullParser.getName().equals("meta-data")) {
                    Bundle parseMetaData = parseMetaData(resources, xmlPullParser, attributeSet, component.metaData, strArr);
                    component.metaData = parseMetaData;
                    if (parseMetaData == null) {
                        return false;
                    }
                } else {
                    Slog.w(TAG, "Unknown element under " + str + ": " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                    XmlUtils.skipCurrentTag(xmlPullParser);
                }
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 24, insn: 0x0081: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r24 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:16:0x0081 */
    public static ApkLite parseApkLite(File file, int i) throws PackageParserException {
        AutoCloseable autoCloseable;
        AssetManager assetManager;
        XmlResourceParser xmlResourceParser;
        AssetManager assetManager2;
        Throwable th;
        AssetManager assetManager3;
        Signature[] signatureArr;
        String absolutePath = file.getAbsolutePath();
        try {
            try {
                assetManager = new AssetManager();
            } catch (IOException e) {
                e = e;
                xmlResourceParser = null;
                assetManager = null;
            } catch (RuntimeException e2) {
                e = e2;
                xmlResourceParser = null;
                assetManager = null;
            } catch (XmlPullParserException e3) {
                e = e3;
                xmlResourceParser = null;
                assetManager = null;
            } catch (Throwable th2) {
                th = th2;
                autoCloseable = null;
                assetManager = null;
            }
            try {
                assetManager.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Build.VERSION.RESOURCES_SDK_INT);
                int addAssetPath = assetManager.addAssetPath(absolutePath);
                if (addAssetPath == 0) {
                    throw new PackageParserException(-100, "Failed to parse " + absolutePath);
                }
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayMetrics.setToDefaults();
                Resources resources = new Resources(assetManager, displayMetrics, null);
                xmlResourceParser = assetManager.openXmlResourceParser(addAssetPath, "AndroidManifest.xml");
                if ((i & 256) != 0) {
                    try {
                        Package r0 = new Package(null);
                        collectCertificates(r0, file, 0);
                        signatureArr = r0.mSignatures;
                    } catch (IOException e4) {
                        e = e4;
                        th = e;
                        assetManager3 = assetManager;
                        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed to parse " + absolutePath, th);
                    } catch (RuntimeException e5) {
                        e = e5;
                        th = e;
                        assetManager3 = assetManager;
                        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed to parse " + absolutePath, th);
                    } catch (XmlPullParserException e6) {
                        e = e6;
                        th = e;
                        assetManager3 = assetManager;
                        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed to parse " + absolutePath, th);
                    }
                } else {
                    signatureArr = null;
                }
                ApkLite parseApkLite = parseApkLite(absolutePath, resources, xmlResourceParser, xmlResourceParser, i, signatureArr);
                IoUtils.closeQuietly(xmlResourceParser);
                IoUtils.closeQuietly(assetManager);
                return parseApkLite;
            } catch (IOException e7) {
                e = e7;
                xmlResourceParser = null;
            } catch (RuntimeException e8) {
                e = e8;
                xmlResourceParser = null;
            } catch (XmlPullParserException e9) {
                e = e9;
                xmlResourceParser = null;
            } catch (Throwable th3) {
                th = th3;
                autoCloseable = null;
                IoUtils.closeQuietly(autoCloseable);
                IoUtils.closeQuietly(assetManager);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            assetManager = assetManager2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0224, code lost:
        r29 = true;
        r21 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.pm.PackageParser.ApkLite parseApkLite(java.lang.String r14, android.content.res.Resources r15, org.xmlpull.v1.XmlPullParser r16, android.util.AttributeSet r17, int r18, android.content.pm.Signature[] r19) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException, android.content.pm.PackageParser.PackageParserException {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.PackageParser.parseApkLite(java.lang.String, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, int, android.content.pm.Signature[]):android.content.pm.PackageParser$ApkLite");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x029a, code lost:
        r12[0] = "<overlay> priority must be between 0 and 9999";
        r8.mParseError = android.content.pm.PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02a8, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.pm.PackageParser.Package parseBaseApk(android.content.res.Resources r9, android.content.res.XmlResourceParser r10, int r11, java.lang.String[] r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 3222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.PackageParser.parseBaseApk(android.content.res.Resources, android.content.res.XmlResourceParser, int, java.lang.String[]):android.content.pm.PackageParser$Package");
    }

    private Package parseBaseApk(File file, AssetManager assetManager, int i) throws PackageParserException {
        String[] strArr;
        String absolutePath = file.getAbsolutePath();
        this.mParseError = 1;
        this.mArchiveSourcePath = file.getAbsolutePath();
        int loadApkIntoAssetManager = loadApkIntoAssetManager(assetManager, absolutePath, i);
        AutoCloseable autoCloseable = null;
        try {
            try {
                Resources resources = new Resources(assetManager, this.mMetrics, null);
                autoCloseable = null;
                try {
                    assetManager.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Build.VERSION.RESOURCES_SDK_INT);
                    XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser(loadApkIntoAssetManager, "AndroidManifest.xml");
                    Package parseBaseApk = parseBaseApk(resources, openXmlResourceParser, i, new String[1]);
                    if (parseBaseApk == null) {
                        throw new PackageParserException(this.mParseError, absolutePath + " (at " + openXmlResourceParser.getPositionDescription() + "): " + strArr[0]);
                    }
                    parseBaseApk.baseCodePath = absolutePath;
                    parseBaseApk.mSignatures = null;
                    if (parseBaseApk.mIsThemeApk) {
                        Iterator<String> it = scanPackageOverlays(file).iterator();
                        while (it.hasNext()) {
                            parseBaseApk.mOverlayTargets.add(it.next());
                        }
                        parseBaseApk.hasIconPack = packageHasIconPack(file);
                    }
                    IoUtils.closeQuietly(openXmlResourceParser);
                    return parseBaseApk;
                } catch (PackageParserException e) {
                    e = e;
                    throw e;
                } catch (Exception e2) {
                    e = e2;
                    throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed to read manifest from " + absolutePath, e);
                } catch (Throwable th) {
                    th = th;
                    IoUtils.closeQuietly(autoCloseable);
                    throw th;
                }
            } catch (PackageParserException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean parseBaseApplication(Package r11, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) throws XmlPullParserException, IOException {
        ApplicationInfo applicationInfo = r11.applicationInfo;
        String str = r11.applicationInfo.packageName;
        applicationInfo.isThemeable = isPackageThemeable(str, resources.getStringArray(17235988));
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestApplication);
        String nonConfigurationString = obtainAttributes.getNonConfigurationString(3, 0);
        if (nonConfigurationString != null) {
            applicationInfo.className = buildClassName(str, nonConfigurationString, strArr);
            if (applicationInfo.className == null) {
                obtainAttributes.recycle();
                this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                return false;
            }
        }
        String nonConfigurationString2 = obtainAttributes.getNonConfigurationString(4, 1024);
        if (nonConfigurationString2 != null) {
            applicationInfo.manageSpaceActivityName = buildClassName(str, nonConfigurationString2, strArr);
        }
        if (obtainAttributes.getBoolean(17, true)) {
            applicationInfo.flags |= 32768;
            String nonConfigurationString3 = obtainAttributes.getNonConfigurationString(16, 1024);
            if (nonConfigurationString3 != null) {
                applicationInfo.backupAgentName = buildClassName(str, nonConfigurationString3, strArr);
                if (obtainAttributes.getBoolean(18, true)) {
                    applicationInfo.flags |= 65536;
                }
                if (obtainAttributes.getBoolean(21, false)) {
                    applicationInfo.flags |= 131072;
                }
                if (obtainAttributes.getBoolean(32, false)) {
                    applicationInfo.flags |= 67108864;
                }
            }
        }
        TypedValue peekValue = obtainAttributes.peekValue(1);
        if (peekValue != null) {
            int i2 = peekValue.resourceId;
            applicationInfo.labelRes = i2;
            if (i2 == 0) {
                applicationInfo.nonLocalizedLabel = peekValue.coerceToString();
            }
        }
        applicationInfo.icon = obtainAttributes.getResourceId(2, 0);
        applicationInfo.logo = obtainAttributes.getResourceId(22, 0);
        applicationInfo.banner = obtainAttributes.getResourceId(30, 0);
        applicationInfo.theme = obtainAttributes.getResourceId(0, 0);
        applicationInfo.descriptionRes = obtainAttributes.getResourceId(13, 0);
        if ((i & 1) != 0 && obtainAttributes.getBoolean(8, false)) {
            applicationInfo.flags |= 8;
        }
        if (obtainAttributes.getBoolean(27, false)) {
            r11.mRequiredForAllUsers = true;
        }
        String string = obtainAttributes.getString(28);
        if (string != null && string.length() > 0) {
            r11.mRestrictedAccountType = string;
        }
        String string2 = obtainAttributes.getString(29);
        if (string2 != null && string2.length() > 0) {
            r11.mRequiredAccountType = string2;
        }
        if (obtainAttributes.getBoolean(10, false)) {
            applicationInfo.flags |= 2;
        }
        if (obtainAttributes.getBoolean(20, false)) {
            applicationInfo.flags |= 16384;
        }
        r11.baseHardwareAccelerated = obtainAttributes.getBoolean(23, r11.applicationInfo.targetSdkVersion >= 14);
        if (obtainAttributes.getBoolean(7, true)) {
            applicationInfo.flags |= 4;
        }
        if (obtainAttributes.getBoolean(14, false)) {
            applicationInfo.flags |= 32;
        }
        if (obtainAttributes.getBoolean(5, true)) {
            applicationInfo.flags |= 64;
        }
        if (obtainAttributes.getBoolean(15, false)) {
            applicationInfo.flags |= 256;
        }
        if (obtainAttributes.getBoolean(24, false)) {
            applicationInfo.flags |= 1048576;
        }
        if (obtainAttributes.getBoolean(26, false)) {
            applicationInfo.flags |= 4194304;
        }
        if (obtainAttributes.getBoolean(33, false)) {
            applicationInfo.flags |= Integer.MIN_VALUE;
        }
        String nonConfigurationString4 = obtainAttributes.getNonConfigurationString(6, 0);
        applicationInfo.permission = (nonConfigurationString4 == null || nonConfigurationString4.length() <= 0) ? null : nonConfigurationString4.intern();
        applicationInfo.taskAffinity = buildTaskAffinityName(applicationInfo.packageName, applicationInfo.packageName, r11.applicationInfo.targetSdkVersion >= 8 ? obtainAttributes.getNonConfigurationString(12, 1024) : obtainAttributes.getNonResourceString(12), strArr);
        if (strArr[0] == null) {
            applicationInfo.processName = buildProcessName(applicationInfo.packageName, null, r11.applicationInfo.targetSdkVersion >= 8 ? obtainAttributes.getNonConfigurationString(11, 1024) : obtainAttributes.getNonResourceString(11), i, this.mSeparateProcesses, strArr);
            applicationInfo.enabled = obtainAttributes.getBoolean(9, true);
            if (obtainAttributes.getBoolean(31, false)) {
                applicationInfo.flags |= 33554432;
            }
        }
        applicationInfo.uiOptions = obtainAttributes.getInt(25, 0);
        obtainAttributes.recycle();
        if (strArr[0] != null) {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return false;
        }
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return true;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return true;
            }
            if (next != 3 && next != 4) {
                String name = xmlPullParser.getName();
                if (name.equals("activity")) {
                    Activity parseActivity = parseActivity(r11, resources, xmlPullParser, attributeSet, i, strArr, false, r11.baseHardwareAccelerated);
                    if (parseActivity == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.activities.add(parseActivity);
                } else if (name.equals(SocialConstants.PARAM_RECEIVER)) {
                    Activity parseActivity2 = parseActivity(r11, resources, xmlPullParser, attributeSet, i, strArr, true, false);
                    if (parseActivity2 == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.receivers.add(parseActivity2);
                } else if (name.equals("service")) {
                    Service parseService = parseService(r11, resources, xmlPullParser, attributeSet, i, strArr);
                    if (parseService == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.services.add(parseService);
                } else if (name.equals(d.M)) {
                    Provider parseProvider = parseProvider(r11, resources, xmlPullParser, attributeSet, i, strArr);
                    if (parseProvider == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.providers.add(parseProvider);
                } else if (name.equals("activity-alias")) {
                    Activity parseActivityAlias = parseActivityAlias(r11, resources, xmlPullParser, attributeSet, i, strArr);
                    if (parseActivityAlias == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.activities.add(parseActivityAlias);
                } else if (xmlPullParser.getName().equals("meta-data")) {
                    Bundle parseMetaData = parseMetaData(resources, xmlPullParser, attributeSet, r11.mAppMetaData, strArr);
                    r11.mAppMetaData = parseMetaData;
                    if (parseMetaData == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                } else if (name.equals("library")) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestLibrary);
                    String nonResourceString = obtainAttributes2.getNonResourceString(0);
                    obtainAttributes2.recycle();
                    if (nonResourceString != null) {
                        String intern = nonResourceString.intern();
                        if (!ArrayUtils.contains(r11.libraryNames, intern)) {
                            r11.libraryNames = ArrayUtils.add(r11.libraryNames, intern);
                        }
                    }
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else if (name.equals("uses-library")) {
                    TypedArray obtainAttributes3 = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestUsesLibrary);
                    String nonResourceString2 = obtainAttributes3.getNonResourceString(0);
                    boolean z = obtainAttributes3.getBoolean(1, true);
                    obtainAttributes3.recycle();
                    if (nonResourceString2 != null) {
                        String intern2 = nonResourceString2.intern();
                        if (z) {
                            r11.usesLibraries = ArrayUtils.add(r11.usesLibraries, intern2);
                        } else {
                            r11.usesOptionalLibraries = ArrayUtils.add(r11.usesOptionalLibraries, intern2);
                        }
                    }
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else if (name.equals("uses-package")) {
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else {
                    Slog.w(TAG, "Unknown element under <application>: " + name + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                    XmlUtils.skipCurrentTag(xmlPullParser);
                }
            }
        }
    }

    private Package parseClusterPackage(File file, int i) throws PackageParserException {
        PackageLite parseClusterPackageLite = parseClusterPackageLite(file, 0);
        if (!this.mOnlyCoreApps || parseClusterPackageLite.coreApp) {
            AssetManager assetManager = new AssetManager();
            try {
                loadApkIntoAssetManager(assetManager, parseClusterPackageLite.baseCodePath, i);
                if (!ArrayUtils.isEmpty(parseClusterPackageLite.splitCodePaths)) {
                    String[] strArr = parseClusterPackageLite.splitCodePaths;
                    int length = strArr.length;
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        loadApkIntoAssetManager(assetManager, strArr[i3], i);
                        i2 = i3 + 1;
                    }
                }
                File file2 = new File(parseClusterPackageLite.baseCodePath);
                Package parseBaseApk = parseBaseApk(file2, assetManager, i);
                if (parseBaseApk == null) {
                    throw new PackageParserException(-100, "Failed to parse base APK: " + file2);
                }
                if (!ArrayUtils.isEmpty(parseClusterPackageLite.splitNames)) {
                    int length2 = parseClusterPackageLite.splitNames.length;
                    parseBaseApk.splitNames = parseClusterPackageLite.splitNames;
                    parseBaseApk.splitCodePaths = parseClusterPackageLite.splitCodePaths;
                    parseBaseApk.splitRevisionCodes = parseClusterPackageLite.splitRevisionCodes;
                    parseBaseApk.splitFlags = new int[length2];
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= length2) {
                            break;
                        }
                        parseSplitApk(parseBaseApk, i5, assetManager, i);
                        i4 = i5 + 1;
                    }
                }
                parseBaseApk.codePath = file.getAbsolutePath();
                return parseBaseApk;
            } finally {
                IoUtils.closeQuietly(assetManager);
            }
        }
        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED, "Not a coreApp: " + file);
    }

    private static PackageLite parseClusterPackageLite(File file, int i) throws PackageParserException {
        File[] listFiles = file.listFiles();
        if (ArrayUtils.isEmpty(listFiles)) {
            throw new PackageParserException(-100, "No packages found in split");
        }
        String str = null;
        int i2 = 0;
        ArrayMap arrayMap = new ArrayMap();
        int length = listFiles.length;
        int i3 = 0;
        while (i3 < length) {
            File file2 = listFiles[i3];
            String str2 = str;
            int i4 = i2;
            if (isApkFile(file2)) {
                ApkLite parseApkLite = parseApkLite(file2, i);
                if (str == null) {
                    str = parseApkLite.packageName;
                    i4 = parseApkLite.versionCode;
                } else if (!str.equals(parseApkLite.packageName)) {
                    throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "Inconsistent package " + parseApkLite.packageName + " in " + file2 + "; expected " + str);
                } else {
                    i4 = i2;
                    if (i2 != parseApkLite.versionCode) {
                        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "Inconsistent version " + parseApkLite.versionCode + " in " + file2 + "; expected " + i2);
                    }
                }
                str2 = str;
                if (arrayMap.put(parseApkLite.splitName, parseApkLite) != null) {
                    throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "Split name " + parseApkLite.splitName + " defined more than once; most recent was " + file2);
                }
            }
            i3++;
            str = str2;
            i2 = i4;
        }
        ApkLite apkLite = (ApkLite) arrayMap.remove(null);
        if (apkLite == null) {
            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_MANIFEST, "Missing base APK in " + file);
        }
        int size = arrayMap.size();
        String[] strArr = null;
        String[] strArr2 = null;
        int[] iArr = null;
        if (size > 0) {
            String[] strArr3 = new String[size];
            String[] strArr4 = new String[size];
            int[] iArr2 = new int[size];
            String[] strArr5 = (String[]) arrayMap.keySet().toArray(strArr3);
            Arrays.sort(strArr5, sSplitNameComparator);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                strArr = strArr5;
                strArr2 = strArr4;
                iArr = iArr2;
                if (i6 >= size) {
                    break;
                }
                strArr4[i6] = ((ApkLite) arrayMap.get(strArr5[i6])).codePath;
                iArr2[i6] = ((ApkLite) arrayMap.get(strArr5[i6])).revisionCode;
                i5 = i6 + 1;
            }
        }
        return new PackageLite(file.getAbsolutePath(), apkLite, strArr, strArr2, iArr);
    }

    private Instrumentation parseInstrumentation(Package r12, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestInstrumentation);
        if (this.mParseInstrumentationArgs == null) {
            this.mParseInstrumentationArgs = new ParsePackageItemArgs(r12, strArr, 2, 0, 1, 6, 7);
            this.mParseInstrumentationArgs.tag = "<instrumentation>";
        }
        this.mParseInstrumentationArgs.sa = obtainAttributes;
        Instrumentation instrumentation = new Instrumentation(this.mParseInstrumentationArgs, new InstrumentationInfo());
        if (strArr[0] != null) {
            obtainAttributes.recycle();
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        String nonResourceString = obtainAttributes.getNonResourceString(3);
        instrumentation.info.targetPackage = nonResourceString != null ? nonResourceString.intern() : null;
        instrumentation.info.handleProfiling = obtainAttributes.getBoolean(4, false);
        instrumentation.info.functionalTest = obtainAttributes.getBoolean(5, false);
        obtainAttributes.recycle();
        if (instrumentation.info.targetPackage == null) {
            strArr[0] = "<instrumentation> does not specify targetPackage";
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        } else if (parseAllMetaData(resources, xmlPullParser, attributeSet, "<instrumentation>", instrumentation, strArr)) {
            r12.instrumentation.add(instrumentation);
            return instrumentation;
        } else {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00c8, code lost:
        r11[0] = "No value supplied for <android:name>";
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d0, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0103, code lost:
        r11[0] = "No value supplied for <android:name>";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010b, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseIntent(android.content.res.Resources r6, org.xmlpull.v1.XmlPullParser r7, android.util.AttributeSet r8, boolean r9, android.content.pm.PackageParser.IntentInfo r10, java.lang.String[] r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.PackageParser.parseIntent(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, boolean, android.content.pm.PackageParser$IntentInfo, java.lang.String[]):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x02af, code lost:
        if (r0.keySet().removeAll(r0.keySet()) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x02b2, code lost:
        android.util.Slog.w(android.content.pm.PackageParser.TAG, "Package" + r6.packageName + " AndroidManifext.xml 'key-set' and 'public-key' names must be distinct.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x02dc, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x02dd, code lost:
        r6.mKeySetMapping = new android.util.ArrayMap<>();
        r0 = r0.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02f9, code lost:
        if (r0.hasNext() == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x02fc, code lost:
        r0 = (java.util.Map.Entry) r0.next();
        r0 = (java.lang.String) r0.getKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x031f, code lost:
        if (((android.util.ArraySet) r0.getValue()).size() != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0322, code lost:
        android.util.Slog.w(android.content.pm.PackageParser.TAG, "Package" + r6.packageName + " AndroidManifext.xml 'key-set' " + r0 + " has no valid associated 'public-key'. Not including in package's defined key-sets.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0364, code lost:
        if (r0.contains(r0) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0367, code lost:
        android.util.Slog.w(android.content.pm.PackageParser.TAG, "Package" + r6.packageName + " AndroidManifext.xml 'key-set' " + r0 + " contained improper 'public-key' tags. Not including in package's defined key-sets.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x03a3, code lost:
        r6.mKeySetMapping.put(r0, new android.util.ArraySet<>());
        r0 = ((android.util.ArraySet) r0.getValue()).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x03c9, code lost:
        if (r0.hasNext() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x03cc, code lost:
        r6.mKeySetMapping.get(r0).add(r0.get((java.lang.String) r0.next()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x03ff, code lost:
        if (r6.mKeySetMapping.keySet().containsAll(r0) == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0402, code lost:
        r6.mUpgradeKeySets = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0409, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x040a, code lost:
        android.util.Slog.w(android.content.pm.PackageParser.TAG, "Package" + r6.packageName + " AndroidManifext.xml does not define all 'upgrade-key-set's .");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0434, code lost:
        return false;
     */
    /* JADX WARN: Type inference failed for: r1v38, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean parseKeySets(android.content.pm.PackageParser.Package r6, android.content.res.Resources r7, org.xmlpull.v1.XmlPullParser r8, android.util.AttributeSet r9, java.lang.String[] r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1077
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.content.pm.PackageParser.parseKeySets(android.content.pm.PackageParser$Package, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, java.lang.String[]):boolean");
    }

    private Bundle parseMetaData(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Bundle bundle, String[] strArr) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestMetaData);
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        String nonConfigurationString = obtainAttributes.getNonConfigurationString(0, 0);
        if (nonConfigurationString == null) {
            strArr[0] = "<meta-data> requires an android:name attribute";
            obtainAttributes.recycle();
            return null;
        }
        String intern = nonConfigurationString.intern();
        TypedValue peekValue = obtainAttributes.peekValue(2);
        if (peekValue == null || peekValue.resourceId == 0) {
            TypedValue peekValue2 = obtainAttributes.peekValue(1);
            if (peekValue2 == null) {
                strArr[0] = "<meta-data> requires an android:value or android:resource attribute";
                bundle2 = null;
            } else if (peekValue2.type == 3) {
                CharSequence coerceToString = peekValue2.coerceToString();
                String str = null;
                if (coerceToString != null) {
                    str = coerceToString.toString().intern();
                }
                bundle2.putString(intern, str);
            } else if (peekValue2.type == 18) {
                bundle2.putBoolean(intern, peekValue2.data != 0);
            } else if (peekValue2.type >= 16 && peekValue2.type <= 31) {
                bundle2.putInt(intern, peekValue2.data);
            } else if (peekValue2.type == 4) {
                bundle2.putFloat(intern, peekValue2.getFloat());
            } else {
                Slog.w(TAG, "<meta-data> only supports string, integer, float, color, boolean, and resource reference types: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
            }
        } else {
            bundle2.putInt(intern, peekValue.resourceId);
        }
        obtainAttributes.recycle();
        XmlUtils.skipCurrentTag(xmlPullParser);
        return bundle2;
    }

    private static PackageLite parseMonolithicPackageLite(File file, int i) throws PackageParserException {
        return new PackageLite(file.getAbsolutePath(), parseApkLite(file, i), null, null, null);
    }

    private boolean parsePackageItemInfo(Package r6, PackageItemInfo packageItemInfo, String[] strArr, String str, TypedArray typedArray, int i, int i2, int i3, int i4, int i5) {
        String nonConfigurationString = typedArray.getNonConfigurationString(i, 0);
        if (nonConfigurationString == null) {
            strArr[0] = str + " does not specify android:name";
            return false;
        }
        packageItemInfo.name = buildClassName(r6.applicationInfo.packageName, nonConfigurationString, strArr);
        if (packageItemInfo.name == null) {
            return false;
        }
        int resourceId = typedArray.getResourceId(i3, 0);
        if (resourceId != 0) {
            packageItemInfo.icon = resourceId;
            packageItemInfo.nonLocalizedLabel = null;
        }
        int resourceId2 = typedArray.getResourceId(i4, 0);
        if (resourceId2 != 0) {
            packageItemInfo.logo = resourceId2;
        }
        int resourceId3 = typedArray.getResourceId(i5, 0);
        if (resourceId3 != 0) {
            packageItemInfo.banner = resourceId3;
        }
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue != null) {
            int i6 = peekValue.resourceId;
            packageItemInfo.labelRes = i6;
            if (i6 == 0) {
                packageItemInfo.nonLocalizedLabel = peekValue.coerceToString();
            }
        }
        packageItemInfo.packageName = r6.packageName;
        return true;
    }

    public static PackageLite parsePackageLite(File file, int i) throws PackageParserException {
        return file.isDirectory() ? parseClusterPackageLite(file, i) : parseMonolithicPackageLite(file, i);
    }

    private static Pair<String, String> parsePackageSplitNames(XmlPullParser xmlPullParser, AttributeSet attributeSet, int i) throws IOException, XmlPullParserException, PackageParserException {
        int next;
        String validateName;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED, "No start tag found");
        }
        if (xmlPullParser.getName().equals("manifest")) {
            String attributeValue = attributeSet.getAttributeValue(null, "package");
            if ("android".equals(attributeValue) || (validateName = validateName(attributeValue, true)) == null) {
                String attributeValue2 = attributeSet.getAttributeValue(null, "split");
                String str = attributeValue2;
                if (attributeValue2 != null) {
                    if (attributeValue2.length() == 0) {
                        str = null;
                    } else {
                        String validateName2 = validateName(attributeValue2, false);
                        str = attributeValue2;
                        if (validateName2 != null) {
                            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME, "Invalid manifest split: " + validateName2);
                        }
                    }
                }
                String intern = attributeValue.intern();
                String str2 = str;
                if (str != null) {
                    str2 = str.intern();
                }
                return Pair.create(intern, str2);
            }
            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_BAD_PACKAGE_NAME, "Invalid manifest package: " + validateName);
        }
        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED, "No <manifest> tag");
    }

    private Permission parsePermission(Package r13, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) throws XmlPullParserException, IOException {
        Permission permission = new Permission(r13);
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestPermission);
        if (!parsePackageItemInfo(r13, permission.info, strArr, "<permission>", obtainAttributes, 2, 0, 1, 6, 8)) {
            obtainAttributes.recycle();
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        permission.info.group = obtainAttributes.getNonResourceString(4);
        if (permission.info.group != null) {
            permission.info.group = permission.info.group.intern();
        }
        permission.info.descriptionRes = obtainAttributes.getResourceId(5, 0);
        permission.info.protectionLevel = obtainAttributes.getInt(3, 0);
        permission.info.flags = obtainAttributes.getInt(7, 0);
        permission.info.allowViaWhitelist = obtainAttributes.getBoolean(9, false);
        obtainAttributes.recycle();
        if (permission.info.protectionLevel == -1) {
            strArr[0] = "<permission> does not specify protectionLevel";
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        permission.info.protectionLevel = PermissionInfo.fixProtectionLevel(permission.info.protectionLevel);
        if ((permission.info.protectionLevel & 240) != 0 && (permission.info.protectionLevel & 15) != 2) {
            strArr[0] = "<permission>  protectionLevel specifies a flag but is not based on signature type";
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        } else if (parseAllMetaData(resources, xmlPullParser, attributeSet, "<permission>", permission, strArr)) {
            r13.permissions.add(permission);
            return permission;
        } else {
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
    }

    private PermissionGroup parsePermissionGroup(Package r13, int i, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) throws XmlPullParserException, IOException {
        PermissionGroup permissionGroup = new PermissionGroup(r13);
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestPermissionGroup);
        if (!parsePackageItemInfo(r13, permissionGroup.info, strArr, "<permission-group>", obtainAttributes, 2, 0, 1, 5, 7)) {
            obtainAttributes.recycle();
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        permissionGroup.info.descriptionRes = obtainAttributes.getResourceId(4, 0);
        permissionGroup.info.flags = obtainAttributes.getInt(6, 0);
        permissionGroup.info.priority = obtainAttributes.getInt(3, 0);
        if (permissionGroup.info.priority > 0 && (i & 1) == 0) {
            permissionGroup.info.priority = 0;
        }
        obtainAttributes.recycle();
        if (parseAllMetaData(resources, xmlPullParser, attributeSet, "<permission-group>", permissionGroup, strArr)) {
            r13.permissionGroups.add(permissionGroup);
            return permissionGroup;
        }
        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
        return null;
    }

    private Permission parsePermissionTree(Package r13, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, String[] strArr) throws XmlPullParserException, IOException {
        Permission permission = new Permission(r13);
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestPermissionTree);
        if (!parsePackageItemInfo(r13, permission.info, strArr, "<permission-tree>", obtainAttributes, 2, 0, 1, 3, 4)) {
            obtainAttributes.recycle();
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        obtainAttributes.recycle();
        int indexOf = permission.info.name.indexOf(46);
        int i = indexOf;
        if (indexOf > 0) {
            i = permission.info.name.indexOf(46, indexOf + 1);
        }
        if (i < 0) {
            strArr[0] = "<permission-tree> name has less than three segments: " + permission.info.name;
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
            return null;
        }
        permission.info.descriptionRes = 0;
        permission.info.protectionLevel = 0;
        permission.tree = true;
        if (parseAllMetaData(resources, xmlPullParser, attributeSet, "<permission-tree>", permission, strArr)) {
            r13.permissions.add(permission);
            return permission;
        }
        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
        return null;
    }

    private Provider parseProvider(Package r16, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) throws XmlPullParserException, IOException {
        Provider provider;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestProvider);
        if (this.mParseProviderArgs == null) {
            this.mParseProviderArgs = new ParseComponentArgs(r16, strArr, 2, 0, 1, 15, 17, this.mSeparateProcesses, 8, 14, 6);
            this.mParseProviderArgs.tag = "<provider>";
        }
        this.mParseProviderArgs.sa = obtainAttributes;
        this.mParseProviderArgs.flags = i;
        Provider provider2 = new Provider(this.mParseProviderArgs, new ProviderInfo());
        if (strArr[0] != null) {
            obtainAttributes.recycle();
            provider = null;
        } else {
            boolean z = false;
            if (r16.applicationInfo.targetSdkVersion < 17) {
                z = true;
            }
            provider2.info.exported = obtainAttributes.getBoolean(7, z);
            String nonConfigurationString = obtainAttributes.getNonConfigurationString(10, 0);
            provider2.info.isSyncable = obtainAttributes.getBoolean(11, false);
            String nonConfigurationString2 = obtainAttributes.getNonConfigurationString(3, 0);
            String nonConfigurationString3 = obtainAttributes.getNonConfigurationString(4, 0);
            String str = nonConfigurationString3;
            if (nonConfigurationString3 == null) {
                str = nonConfigurationString2;
            }
            if (str == null) {
                provider2.info.readPermission = r16.applicationInfo.permission;
            } else {
                provider2.info.readPermission = str.length() > 0 ? str.toString().intern() : null;
            }
            String nonConfigurationString4 = obtainAttributes.getNonConfigurationString(5, 0);
            String str2 = nonConfigurationString4;
            if (nonConfigurationString4 == null) {
                str2 = nonConfigurationString2;
            }
            if (str2 == null) {
                provider2.info.writePermission = r16.applicationInfo.permission;
            } else {
                provider2.info.writePermission = str2.length() > 0 ? str2.toString().intern() : null;
            }
            provider2.info.grantUriPermissions = obtainAttributes.getBoolean(13, false);
            provider2.info.multiprocess = obtainAttributes.getBoolean(9, false);
            provider2.info.initOrder = obtainAttributes.getInt(12, 0);
            provider2.info.flags = 0;
            if (obtainAttributes.getBoolean(16, false)) {
                provider2.info.flags |= 1073741824;
                if (provider2.info.exported && (i & 128) == 0) {
                    Slog.w(TAG, "Provider exported request ignored due to singleUser: " + provider2.className + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                    provider2.info.exported = false;
                }
            }
            obtainAttributes.recycle();
            if ((r16.applicationInfo.flags & 268435456) != 0 && provider2.info.processName == r16.packageName) {
                strArr[0] = "Heavy-weight applications can not have providers in main process";
                return null;
            } else if (nonConfigurationString == null) {
                strArr[0] = "<provider> does not include authorities attribute";
                return null;
            } else if (nonConfigurationString.length() <= 0) {
                strArr[0] = "<provider> has empty authorities attribute";
                return null;
            } else {
                provider2.info.authority = nonConfigurationString.intern();
                provider = provider2;
                if (!parseProviderTags(resources, xmlPullParser, attributeSet, provider2, strArr)) {
                    return null;
                }
            }
        }
        return provider;
    }

    private boolean parseProviderTags(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Provider provider, String[] strArr) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return true;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return true;
            }
            if (next != 3 && next != 4) {
                if (xmlPullParser.getName().equals("intent-filter")) {
                    ProviderIntentInfo providerIntentInfo = new ProviderIntentInfo(provider);
                    if (!parseIntent(resources, xmlPullParser, attributeSet, true, providerIntentInfo, strArr)) {
                        return false;
                    }
                    provider.intents.add(providerIntentInfo);
                } else if (xmlPullParser.getName().equals("meta-data")) {
                    Bundle parseMetaData = parseMetaData(resources, xmlPullParser, attributeSet, provider.metaData, strArr);
                    provider.metaData = parseMetaData;
                    if (parseMetaData == null) {
                        return false;
                    }
                } else if (xmlPullParser.getName().equals("grant-uri-permission")) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestGrantUriPermission);
                    PatternMatcher patternMatcher = null;
                    String nonConfigurationString = obtainAttributes.getNonConfigurationString(0, 0);
                    if (nonConfigurationString != null) {
                        patternMatcher = new PatternMatcher(nonConfigurationString, 0);
                    }
                    String nonConfigurationString2 = obtainAttributes.getNonConfigurationString(1, 0);
                    if (nonConfigurationString2 != null) {
                        patternMatcher = new PatternMatcher(nonConfigurationString2, 1);
                    }
                    String nonConfigurationString3 = obtainAttributes.getNonConfigurationString(2, 0);
                    if (nonConfigurationString3 != null) {
                        patternMatcher = new PatternMatcher(nonConfigurationString3, 2);
                    }
                    obtainAttributes.recycle();
                    if (patternMatcher != null) {
                        if (provider.info.uriPermissionPatterns == null) {
                            provider.info.uriPermissionPatterns = new PatternMatcher[1];
                            provider.info.uriPermissionPatterns[0] = patternMatcher;
                        } else {
                            int length = provider.info.uriPermissionPatterns.length;
                            PatternMatcher[] patternMatcherArr = new PatternMatcher[length + 1];
                            System.arraycopy(provider.info.uriPermissionPatterns, 0, patternMatcherArr, 0, length);
                            patternMatcherArr[length] = patternMatcher;
                            provider.info.uriPermissionPatterns = patternMatcherArr;
                        }
                        provider.info.grantUriPermissions = true;
                        XmlUtils.skipCurrentTag(xmlPullParser);
                    } else {
                        Slog.w(TAG, "Unknown element under <path-permission>: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                        XmlUtils.skipCurrentTag(xmlPullParser);
                    }
                } else if (xmlPullParser.getName().equals("path-permission")) {
                    TypedArray obtainAttributes2 = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestPathPermission);
                    String nonConfigurationString4 = obtainAttributes2.getNonConfigurationString(0, 0);
                    String nonConfigurationString5 = obtainAttributes2.getNonConfigurationString(1, 0);
                    String str = nonConfigurationString5;
                    if (nonConfigurationString5 == null) {
                        str = nonConfigurationString4;
                    }
                    String nonConfigurationString6 = obtainAttributes2.getNonConfigurationString(2, 0);
                    String str2 = nonConfigurationString6;
                    if (nonConfigurationString6 == null) {
                        str2 = nonConfigurationString4;
                    }
                    boolean z = false;
                    String str3 = str;
                    if (str != null) {
                        str3 = str.intern();
                        z = true;
                    }
                    String str4 = str2;
                    if (str2 != null) {
                        str4 = str2.intern();
                        z = true;
                    }
                    if (z) {
                        String nonConfigurationString7 = obtainAttributes2.getNonConfigurationString(3, 0);
                        PathPermission pathPermission = null;
                        if (nonConfigurationString7 != null) {
                            pathPermission = new PathPermission(nonConfigurationString7, 0, str3, str4);
                        }
                        String nonConfigurationString8 = obtainAttributes2.getNonConfigurationString(4, 0);
                        if (nonConfigurationString8 != null) {
                            pathPermission = new PathPermission(nonConfigurationString8, 1, str3, str4);
                        }
                        String nonConfigurationString9 = obtainAttributes2.getNonConfigurationString(5, 0);
                        if (nonConfigurationString9 != null) {
                            pathPermission = new PathPermission(nonConfigurationString9, 2, str3, str4);
                        }
                        obtainAttributes2.recycle();
                        if (pathPermission != null) {
                            if (provider.info.pathPermissions == null) {
                                provider.info.pathPermissions = new PathPermission[1];
                                provider.info.pathPermissions[0] = pathPermission;
                            } else {
                                int length2 = provider.info.pathPermissions.length;
                                PathPermission[] pathPermissionArr = new PathPermission[length2 + 1];
                                System.arraycopy(provider.info.pathPermissions, 0, pathPermissionArr, 0, length2);
                                pathPermissionArr[length2] = pathPermission;
                                provider.info.pathPermissions = pathPermissionArr;
                            }
                            XmlUtils.skipCurrentTag(xmlPullParser);
                        } else {
                            Slog.w(TAG, "No path, pathPrefix, or pathPattern for <path-permission>: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                            XmlUtils.skipCurrentTag(xmlPullParser);
                        }
                    } else {
                        Slog.w(TAG, "No readPermission or writePermssion for <path-permission>: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                        XmlUtils.skipCurrentTag(xmlPullParser);
                    }
                } else {
                    Slog.w(TAG, "Unknown element under <provider>: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                    XmlUtils.skipCurrentTag(xmlPullParser);
                }
            }
        }
    }

    public static final PublicKey parsePublicKey(String str) {
        if (str == null) {
            Slog.i(TAG, "Could not parse null public key");
            return null;
        }
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(str, 0));
            try {
                return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
            } catch (NoSuchAlgorithmException e) {
                Log.wtf(TAG, "Could not parse public key because RSA isn't included in build");
                return null;
            } catch (InvalidKeySpecException e2) {
                try {
                    return KeyFactory.getInstance("DSA").generatePublic(x509EncodedKeySpec);
                } catch (NoSuchAlgorithmException e3) {
                    Log.wtf(TAG, "Could not parse public key because DSA isn't included in build");
                    return null;
                } catch (InvalidKeySpecException e4) {
                    return null;
                }
            }
        } catch (IllegalArgumentException e5) {
            Slog.i(TAG, "Could not parse verifier public key; invalid Base64");
            return null;
        }
    }

    private Service parseService(Package r16, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, String[] strArr) throws XmlPullParserException, IOException {
        Service service;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestService);
        if (this.mParseServiceArgs == null) {
            this.mParseServiceArgs = new ParseComponentArgs(r16, strArr, 2, 0, 1, 8, 12, this.mSeparateProcesses, 6, 7, 4);
            this.mParseServiceArgs.tag = "<service>";
        }
        this.mParseServiceArgs.sa = obtainAttributes;
        this.mParseServiceArgs.flags = i;
        Service service2 = new Service(this.mParseServiceArgs, new ServiceInfo());
        if (strArr[0] != null) {
            obtainAttributes.recycle();
            service = null;
        } else {
            boolean hasValue = obtainAttributes.hasValue(5);
            if (hasValue) {
                service2.info.exported = obtainAttributes.getBoolean(5, false);
            }
            String nonConfigurationString = obtainAttributes.getNonConfigurationString(3, 0);
            if (nonConfigurationString == null) {
                service2.info.permission = r16.applicationInfo.permission;
            } else {
                service2.info.permission = nonConfigurationString.length() > 0 ? nonConfigurationString.toString().intern() : null;
            }
            service2.info.flags = 0;
            if (obtainAttributes.getBoolean(9, false)) {
                service2.info.flags |= 1;
            }
            if (obtainAttributes.getBoolean(10, false)) {
                service2.info.flags |= 2;
            }
            boolean z = hasValue;
            if (obtainAttributes.getBoolean(11, false)) {
                service2.info.flags |= 1073741824;
                z = hasValue;
                if (service2.info.exported) {
                    z = hasValue;
                    if ((i & 128) == 0) {
                        Slog.w(TAG, "Service exported request ignored due to singleUser: " + service2.className + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                        service2.info.exported = false;
                        z = true;
                    }
                }
            }
            obtainAttributes.recycle();
            if ((r16.applicationInfo.flags & 268435456) != 0 && service2.info.processName == r16.packageName) {
                strArr[0] = "Heavy-weight applications can not have services in main process";
                return null;
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                    break;
                } else if (next != 3 && next != 4) {
                    if (xmlPullParser.getName().equals("intent-filter")) {
                        ServiceIntentInfo serviceIntentInfo = new ServiceIntentInfo(service2);
                        if (!parseIntent(resources, xmlPullParser, attributeSet, true, serviceIntentInfo, strArr)) {
                            return null;
                        }
                        service2.intents.add(serviceIntentInfo);
                    } else if (xmlPullParser.getName().equals("meta-data")) {
                        Bundle parseMetaData = parseMetaData(resources, xmlPullParser, attributeSet, service2.metaData, strArr);
                        service2.metaData = parseMetaData;
                        if (parseMetaData == null) {
                            return null;
                        }
                    } else {
                        Slog.w(TAG, "Unknown element under <service>: " + xmlPullParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                        XmlUtils.skipCurrentTag(xmlPullParser);
                    }
                }
            }
            service = service2;
            if (!z) {
                service2.info.exported = service2.intents.size() > 0;
                return service2;
            }
        }
        return service;
    }

    private Package parseSplitApk(Package r10, Resources resources, XmlResourceParser xmlResourceParser, int i, int i2, String[] strArr) throws XmlPullParserException, IOException, PackageParserException {
        Package r11;
        parsePackageSplitNames(xmlResourceParser, xmlResourceParser, i);
        this.mParseInstrumentationArgs = null;
        this.mParseActivityArgs = null;
        this.mParseServiceArgs = null;
        this.mParseProviderArgs = null;
        boolean z = false;
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || (next == 3 && xmlResourceParser.getDepth() <= depth)) {
                break;
            } else if (next != 3 && next != 4) {
                if (!xmlResourceParser.getName().equals("application")) {
                    Slog.w(TAG, "Unknown element under <manifest>: " + xmlResourceParser.getName() + " at " + this.mArchiveSourcePath + " " + xmlResourceParser.getPositionDescription());
                    XmlUtils.skipCurrentTag(xmlResourceParser);
                } else if (z) {
                    Slog.w(TAG, "<manifest> has more than one <application>");
                    XmlUtils.skipCurrentTag(xmlResourceParser);
                } else {
                    z = true;
                    if (!parseSplitApplication(r10, resources, xmlResourceParser, xmlResourceParser, i, i2, strArr)) {
                        r11 = null;
                        break;
                    }
                }
            }
        }
        r11 = r10;
        if (!z) {
            strArr[0] = "<manifest> does not contain an <application>";
            this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_EMPTY;
            return r10;
        }
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.content.pm.PackageParser] */
    /* JADX WARN: Type inference failed for: r22v0, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARN: Type inference failed for: r22v5 */
    /* JADX WARN: Type inference failed for: r22v8, types: [android.content.res.XmlResourceParser, java.lang.AutoCloseable] */
    private void parseSplitApk(Package r20, int i, AssetManager assetManager, int i2) throws PackageParserException {
        Resources resources;
        String[] strArr;
        String str = r20.splitCodePaths[i];
        new File(str);
        this.mParseError = 1;
        this.mArchiveSourcePath = str;
        int loadApkIntoAssetManager = loadApkIntoAssetManager(assetManager, str, i2);
        try {
            try {
                resources = new Resources(assetManager, this.mMetrics, null);
                try {
                    assetManager.setConfiguration(0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Build.VERSION.RESOURCES_SDK_INT);
                    assetManager = assetManager.openXmlResourceParser(loadApkIntoAssetManager, "AndroidManifest.xml");
                } catch (PackageParserException e) {
                    e = e;
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    assetManager = 0;
                }
            } catch (PackageParserException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
                assetManager = 0;
            }
            try {
                if (parseSplitApk(r20, resources, assetManager, i2, i, new String[1]) == null) {
                    throw new PackageParserException(this.mParseError, str + " (at " + assetManager.getPositionDescription() + "): " + strArr[0]);
                }
                IoUtils.closeQuietly((AutoCloseable) assetManager);
            } catch (PackageParserException e5) {
                e = e5;
                throw e;
            } catch (Exception e6) {
                e = e6;
                throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_UNEXPECTED_EXCEPTION, "Failed to read manifest from " + str, e);
            } catch (Throwable th3) {
                th = th3;
                IoUtils.closeQuietly((AutoCloseable) assetManager);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private boolean parseSplitApplication(Package r11, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i, int i2, String[] strArr) throws XmlPullParserException, IOException {
        if (resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestApplication).getBoolean(7, true)) {
            int[] iArr = r11.splitFlags;
            iArr[i2] = iArr[i2] | 4;
        }
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return true;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return true;
            }
            if (next != 3 && next != 4) {
                String name = xmlPullParser.getName();
                if (name.equals("activity")) {
                    Activity parseActivity = parseActivity(r11, resources, xmlPullParser, attributeSet, i, strArr, false, r11.baseHardwareAccelerated);
                    if (parseActivity == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.activities.add(parseActivity);
                } else if (name.equals(SocialConstants.PARAM_RECEIVER)) {
                    Activity parseActivity2 = parseActivity(r11, resources, xmlPullParser, attributeSet, i, strArr, true, false);
                    if (parseActivity2 == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.receivers.add(parseActivity2);
                } else if (name.equals("service")) {
                    Service parseService = parseService(r11, resources, xmlPullParser, attributeSet, i, strArr);
                    if (parseService == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.services.add(parseService);
                } else if (name.equals(d.M)) {
                    Provider parseProvider = parseProvider(r11, resources, xmlPullParser, attributeSet, i, strArr);
                    if (parseProvider == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.providers.add(parseProvider);
                } else if (name.equals("activity-alias")) {
                    Activity parseActivityAlias = parseActivityAlias(r11, resources, xmlPullParser, attributeSet, i, strArr);
                    if (parseActivityAlias == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                    r11.activities.add(parseActivityAlias);
                } else if (xmlPullParser.getName().equals("meta-data")) {
                    Bundle parseMetaData = parseMetaData(resources, xmlPullParser, attributeSet, r11.mAppMetaData, strArr);
                    r11.mAppMetaData = parseMetaData;
                    if (parseMetaData == null) {
                        this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                        return false;
                    }
                } else if (name.equals("uses-library")) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestUsesLibrary);
                    String nonResourceString = obtainAttributes.getNonResourceString(0);
                    boolean z = obtainAttributes.getBoolean(1, true);
                    obtainAttributes.recycle();
                    if (nonResourceString != null) {
                        String intern = nonResourceString.intern();
                        if (z) {
                            r11.usesLibraries = ArrayUtils.add(r11.usesLibraries, intern);
                            r11.usesOptionalLibraries = ArrayUtils.remove(r11.usesOptionalLibraries, intern);
                        } else if (!ArrayUtils.contains(r11.usesLibraries, intern)) {
                            r11.usesOptionalLibraries = ArrayUtils.add(r11.usesOptionalLibraries, intern);
                        }
                    }
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else if (name.equals("uses-package")) {
                    XmlUtils.skipCurrentTag(xmlPullParser);
                } else {
                    Slog.w(TAG, "Unknown element under <application>: " + name + " at " + this.mArchiveSourcePath + " " + xmlPullParser.getPositionDescription());
                    XmlUtils.skipCurrentTag(xmlPullParser);
                }
            }
        }
    }

    private FeatureInfo parseUsesFeature(Resources resources, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        FeatureInfo featureInfo = new FeatureInfo();
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestUsesFeature);
        featureInfo.name = obtainAttributes.getNonResourceString(0);
        if (featureInfo.name == null) {
            featureInfo.reqGlEsVersion = obtainAttributes.getInt(1, 0);
        }
        if (obtainAttributes.getBoolean(2, true)) {
            featureInfo.flags |= 1;
        }
        obtainAttributes.recycle();
        return featureInfo;
    }

    private boolean parseUsesPermission(Package r5, Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, String[] strArr) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestUsesPermission);
        String nonResourceString = obtainAttributes.getNonResourceString(0);
        TypedValue peekValue = obtainAttributes.peekValue(1);
        int i = 0;
        if (peekValue != null) {
            i = 0;
            if (peekValue.type >= 16) {
                i = 0;
                if (peekValue.type <= 31) {
                    i = peekValue.data;
                }
            }
        }
        obtainAttributes.recycle();
        if ((i == 0 || i >= Build.VERSION.RESOURCES_SDK_INT) && nonResourceString != null) {
            int indexOf = r5.requestedPermissions.indexOf(nonResourceString);
            if (indexOf == -1) {
                r5.requestedPermissions.add(nonResourceString.intern());
                r5.requestedPermissionsRequired.add(1 != 0 ? Boolean.TRUE : Boolean.FALSE);
            } else if (!r5.requestedPermissionsRequired.get(indexOf).booleanValue()) {
                strArr[0] = "conflicting <uses-permission> entries";
                this.mParseError = PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED;
                return false;
            }
        }
        XmlUtils.skipCurrentTag(xmlResourceParser);
        return true;
    }

    private static VerifierInfo parseVerifier(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, int i) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.AndroidManifestPackageVerifier);
        String nonResourceString = obtainAttributes.getNonResourceString(0);
        String nonResourceString2 = obtainAttributes.getNonResourceString(1);
        obtainAttributes.recycle();
        if (nonResourceString == null || nonResourceString.length() == 0) {
            Slog.i(TAG, "verifier package name was null; skipping");
            return null;
        }
        PublicKey parsePublicKey = parsePublicKey(nonResourceString2);
        if (parsePublicKey == null) {
            Slog.i(TAG, "Unable to parse verifier public key for " + nonResourceString);
            return null;
        }
        return new VerifierInfo(nonResourceString, parsePublicKey);
    }

    public static long readFullyIgnoringContents(InputStream inputStream) throws IOException {
        byte[] andSet = sBuffer.getAndSet(null);
        byte[] bArr = andSet;
        if (andSet == null) {
            bArr = new byte[4096];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int read = inputStream.read(bArr, 0, bArr.length);
            if (read == -1) {
                sBuffer.set(bArr);
                return i2;
            }
            i = i2 + read;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x009e -> B:21:0x0073). Please submit an issue!!! */
    private ArrayList<String> scanPackageOverlays(File file) {
        ZipFile zipFile;
        HashSet hashSet = new HashSet();
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(file.getPath());
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        String name = entries.nextElement().getName();
                        if (name.startsWith("assets/overlays/") && name.length() > 16) {
                            hashSet.add(name.split("/")[2]);
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    zipFile2 = zipFile;
                    hashSet.clear();
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (Exception e3) {
                        }
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(hashSet);
                    return arrayList;
                } catch (Throwable th) {
                    zipFile2 = zipFile;
                    th = th;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e5) {
            e = e5;
            zipFile = null;
        }
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.addAll(hashSet);
        return arrayList2;
    }

    public static void setCompatibilityModeEnabled(boolean z) {
        sCompatibilityModeEnabled = z;
    }

    public static Signature stringToSignature(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new Signature(bArr);
            }
            bArr[i2] = (byte) str.charAt(i2);
            i = i2 + 1;
        }
    }

    private static void updateApplicationInfo(ApplicationInfo applicationInfo, int i, PackageUserState packageUserState) {
        if (!sCompatibilityModeEnabled) {
            applicationInfo.disableCompatibilityMode();
        }
        if (packageUserState.installed) {
            applicationInfo.flags |= 8388608;
        } else {
            applicationInfo.flags &= -8388609;
        }
        if (packageUserState.hidden) {
            applicationInfo.flags |= 134217728;
        } else {
            applicationInfo.flags &= -134217729;
        }
        if (packageUserState.enabled == 1) {
            applicationInfo.enabled = true;
        } else if (packageUserState.enabled == 4) {
            applicationInfo.enabled = (32768 & i) != 0;
        } else if (packageUserState.enabled == 2 || packageUserState.enabled == 3) {
            applicationInfo.enabled = false;
        }
        applicationInfo.enabledSetting = packageUserState.enabled;
        if (packageUserState.protectedComponents != null) {
            applicationInfo.protect = packageUserState.protectedComponents.size() > 0;
        }
    }

    private static String validateName(String str, boolean z) {
        boolean z2;
        boolean z3;
        int length = str.length();
        boolean z4 = false;
        boolean z5 = true;
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                if (!z5) {
                    if (charAt >= '0') {
                        z3 = z5;
                        z2 = z4;
                        if (charAt <= '9') {
                            continue;
                        }
                    }
                    z3 = z5;
                    z2 = z4;
                    if (charAt == '_') {
                        continue;
                    }
                }
                if (charAt != '.') {
                    return "bad character '" + charAt + "'";
                }
                z2 = true;
                z3 = true;
            } else {
                z3 = false;
                z2 = z4;
            }
            i++;
            z5 = z3;
            z4 = z2;
        }
        if (z4 || !z) {
            return null;
        }
        return "must have at least one '.' separator";
    }

    public void collectCertificates(Package r7, int i) throws PackageParserException {
        r7.mCertificates = null;
        r7.mSignatures = null;
        r7.mSigningKeys = null;
        collectCertificates(r7, new File(r7.baseCodePath), i);
        if (ArrayUtils.isEmpty(r7.splitCodePaths)) {
            return;
        }
        String[] strArr = r7.splitCodePaths;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            collectCertificates(r7, new File(strArr[i3]), i);
            i2 = i3 + 1;
        }
    }

    public void collectManifestDigest(Package r6) throws PackageParserException {
        r6.manifestDigest = null;
        r6.manifestHashCode = 0;
        try {
            StrictJarFile strictJarFile = new StrictJarFile(r6.baseCodePath);
            ZipEntry findEntry = strictJarFile.findEntry("AndroidManifest.xml");
            if (findEntry != null) {
                r6.manifestDigest = ManifestDigest.fromInputStream(strictJarFile.getInputStream(findEntry));
                r6.manifestHashCode = ThemeUtils.getPackageHashCode(r6, strictJarFile);
            }
            strictJarFile.close();
        } catch (IOException | RuntimeException e) {
            throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED, "Failed to collect manifest digest");
        }
    }

    @Deprecated
    public Package parseMonolithicPackage(File file, int i) throws PackageParserException {
        if (!this.mOnlyCoreApps || parseMonolithicPackageLite(file, i).coreApp) {
            AssetManager assetManager = new AssetManager();
            try {
                Package parseBaseApk = parseBaseApk(file, assetManager, i);
                parseBaseApk.codePath = file.getAbsolutePath();
                return parseBaseApk;
            } finally {
                IoUtils.closeQuietly(assetManager);
            }
        }
        throw new PackageParserException(PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED, "Not a coreApp: " + file);
    }

    public Package parsePackage(File file, int i) throws PackageParserException {
        return file.isDirectory() ? parseClusterPackage(file, i) : parseMonolithicPackage(file, i);
    }

    public void setDisplayMetrics(DisplayMetrics displayMetrics) {
        this.mMetrics = displayMetrics;
    }

    public void setOnlyCoreApps(boolean z) {
        this.mOnlyCoreApps = z;
    }

    public void setSeparateProcesses(String[] strArr) {
        this.mSeparateProcesses = strArr;
    }
}
