package android.view;

import android.app.ActivityManager;
import android.content.Context;
import android.provider.Settings;
import android.util.ArraySet;
import android.util.Slog;
import android.view.WindowManager;
import android.view.WindowManagerPolicy;
import com.android.internal.content.NativeLibraryHelper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicyControl.class */
public class WindowManagerPolicyControl {
    private static final String NAME_IMMERSIVE_FULL = "immersive.full";
    private static final String NAME_IMMERSIVE_NAVIGATION = "immersive.navigation";
    private static final String NAME_IMMERSIVE_PRECONFIRMATIONS = "immersive.preconfirms";
    private static final String NAME_IMMERSIVE_STATUS = "immersive.status";
    private static int sDefaultImmersiveStyle;
    private static Filter sImmersiveNavigationFilter;
    private static Filter sImmersivePreconfirmationsFilter;
    private static Filter sImmersiveStatusFilter;
    private static String sSettingValue;
    private static String TAG = "PolicyControl";
    private static boolean DEBUG = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicyControl$Filter.class */
    public static class Filter {
        private static final String ALL = "*";
        private static final String APPS = "apps";
        private final ArraySet<String> mBlacklist;
        private final ArraySet<String> mWhitelist;

        private Filter(ArraySet<String> arraySet, ArraySet<String> arraySet2) {
            this.mWhitelist = arraySet;
            this.mBlacklist = arraySet2;
        }

        private void dump(String str, ArraySet<String> arraySet, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("=(");
            int size = arraySet.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    printWriter.print(')');
                    return;
                }
                if (i2 > 0) {
                    printWriter.print(',');
                }
                printWriter.print(arraySet.valueAt(i2));
                i = i2 + 1;
            }
        }

        private boolean onBlacklist(String str) {
            return this.mBlacklist.contains(str) || this.mBlacklist.contains("*");
        }

        private boolean onWhitelist(String str) {
            return this.mWhitelist.contains("*") || this.mWhitelist.contains(str);
        }

        static Filter parse(String str) {
            if (str == null) {
                return null;
            }
            ArraySet arraySet = new ArraySet();
            ArraySet arraySet2 = new ArraySet();
            String[] split = str.split(",");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return new Filter(arraySet, arraySet2);
                }
                String trim = split[i2].trim();
                if (!trim.startsWith(NativeLibraryHelper.CLEAR_ABI_OVERRIDE) || trim.length() <= 1) {
                    arraySet.add(trim);
                } else {
                    arraySet2.add(trim.substring(1));
                }
                i = i2 + 1;
            }
        }

        void dump(PrintWriter printWriter) {
            printWriter.print("Filter[");
            dump("whitelist", this.mWhitelist, printWriter);
            printWriter.print(',');
            dump("blacklist", this.mBlacklist, printWriter);
            printWriter.print(']');
        }

        public boolean isEnabledForAll() {
            return this.mWhitelist.contains("*");
        }

        boolean matches(WindowManager.LayoutParams layoutParams) {
            if (layoutParams == null) {
                return false;
            }
            boolean z = layoutParams.type >= 1 && layoutParams.type <= 99;
            if ((z && this.mBlacklist.contains(APPS)) || onBlacklist(layoutParams.packageName)) {
                return false;
            }
            if (z && this.mWhitelist.contains(APPS)) {
                return true;
            }
            return onWhitelist(layoutParams.packageName);
        }

        boolean matches(String str) {
            return !onBlacklist(str) && onWhitelist(str);
        }

        public String toString() {
            StringWriter stringWriter = new StringWriter();
            dump(new PrintWriter((Writer) stringWriter, true));
            return stringWriter.toString();
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/WindowManagerPolicyControl$ImmersiveDefaultStyles.class */
    public static final class ImmersiveDefaultStyles {
        public static final int IMMERSIVE_FULL = 0;
        public static final int IMMERSIVE_NAVIGATION = 2;
        public static final int IMMERSIVE_STATUS = 1;
    }

    public static void addToNavigationWhiteList(String str) {
        if (sImmersiveNavigationFilter == null) {
            sImmersiveNavigationFilter = new Filter(new ArraySet(), new ArraySet());
        }
        if (sImmersiveNavigationFilter.mWhitelist.contains(str)) {
            return;
        }
        sImmersiveNavigationFilter.mWhitelist.add(str);
    }

    public static void addToPreconfirmWhiteList(String str) {
        if (sImmersivePreconfirmationsFilter == null) {
            sImmersivePreconfirmationsFilter = new Filter(new ArraySet(), new ArraySet());
        }
        if (sImmersivePreconfirmationsFilter.mWhitelist.contains(str)) {
            return;
        }
        sImmersivePreconfirmationsFilter.mWhitelist.add(str);
    }

    public static void addToStatusWhiteList(String str) {
        if (sImmersiveStatusFilter == null) {
            sImmersiveStatusFilter = new Filter(new ArraySet(), new ArraySet());
        }
        if (sImmersiveStatusFilter.mWhitelist.contains(str)) {
            return;
        }
        sImmersiveStatusFilter.mWhitelist.add(str);
    }

    public static int adjustClearableFlags(WindowManagerPolicy.WindowState windowState, int i) {
        WindowManager.LayoutParams attrs = windowState != null ? windowState.getAttrs() : null;
        int i2 = i;
        if (sImmersiveStatusFilter != null) {
            i2 = i;
            if (sImmersiveStatusFilter.matches(attrs)) {
                i2 = i & (-5);
            }
        }
        return i2;
    }

    public static boolean disableImmersiveConfirmation(String str) {
        return (sImmersivePreconfirmationsFilter != null && sImmersivePreconfirmationsFilter.matches(str)) || ActivityManager.isRunningInTestHarness();
    }

    private static void dump(String str, Filter filter, String str2, PrintWriter printWriter) {
        printWriter.print(str2);
        printWriter.print("PolicyControl.");
        printWriter.print(str);
        printWriter.print('=');
        if (filter == null) {
            printWriter.println("null");
            return;
        }
        filter.dump(printWriter);
        printWriter.println();
    }

    public static void dump(String str, PrintWriter printWriter) {
        dump("sImmersiveStatusFilter", sImmersiveStatusFilter, str, printWriter);
        dump("sImmersiveNavigationFilter", sImmersiveNavigationFilter, str, printWriter);
        dump("sImmersivePreconfirmationsFilter", sImmersivePreconfirmationsFilter, str, printWriter);
    }

    public static int getPrivateWindowFlags(WindowManagerPolicy.WindowState windowState, WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            layoutParams = windowState.getAttrs();
        }
        int i = layoutParams.privateFlags;
        int i2 = i;
        if (sImmersiveStatusFilter != null) {
            i2 = i;
            if (sImmersiveNavigationFilter != null) {
                i2 = i;
                if (sImmersiveStatusFilter.isEnabledForAll()) {
                    i2 = i;
                    if (sImmersiveNavigationFilter.isEnabledForAll()) {
                        i2 = i;
                        if ((layoutParams.flags & 1024) == 0) {
                            i2 = i | 8192;
                        }
                        switch (sDefaultImmersiveStyle) {
                            case 0:
                                return i2 | 4096 | 2048;
                            case 1:
                                return i2 | 2048;
                            case 2:
                                return i2 | 4096;
                        }
                    }
                }
            }
        }
        int i3 = i2;
        if (sImmersiveStatusFilter != null) {
            i3 = i2;
            if (sImmersiveStatusFilter.matches(layoutParams)) {
                int i4 = i2;
                if ((layoutParams.flags & 1024) == 0) {
                    i4 = i2 | 8192;
                }
                i3 = i4 | 2048;
            }
        }
        int i5 = i3;
        if (sImmersiveNavigationFilter != null) {
            i5 = i3;
            if (sImmersiveNavigationFilter.matches(layoutParams)) {
                i5 = i3 | 4096;
            }
        }
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle == 1) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        if (android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle == 2) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getSystemUiVisibility(android.view.WindowManagerPolicy.WindowState r3, android.view.WindowManager.LayoutParams r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L69
        L4:
            r0 = r3
            if (r0 == 0) goto L73
            r0 = r3
            int r0 = r0.getSystemUiVisibility()
            r6 = r0
        Lf:
            r0 = r6
            r5 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveStatusFilter
            if (r0 == 0) goto L3b
            r0 = r6
            r5 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveStatusFilter
            r1 = r4
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L3b
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            if (r0 == 0) goto L32
            r0 = r6
            r5 = r0
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            r1 = 1
            if (r0 != r1) goto L3b
        L32:
            r0 = r6
            r1 = 5124(0x1404, float:7.18E-42)
            r0 = r0 | r1
            r1 = -1073742081(0xffffffffbffffeff, float:-1.9999694)
            r0 = r0 & r1
            r5 = r0
        L3b:
            r0 = r5
            r6 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveNavigationFilter
            if (r0 == 0) goto L67
            r0 = r5
            r6 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveNavigationFilter
            r1 = r4
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L67
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            if (r0 == 0) goto L5e
            r0 = r5
            r6 = r0
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            r1 = 2
            if (r0 != r1) goto L67
        L5e:
            r0 = r5
            r1 = 4610(0x1202, float:6.46E-42)
            r0 = r0 | r1
            r1 = 2147483391(0x7ffffeff, float:NaN)
            r0 = r0 & r1
            r6 = r0
        L67:
            r0 = r6
            return r0
        L69:
            r0 = r3
            android.view.WindowManager$LayoutParams r0 = r0.getAttrs()
            r4 = r0
            goto L4
        L73:
            r0 = r4
            int r0 = r0.systemUiVisibility
            r6 = r0
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowManagerPolicyControl.getSystemUiVisibility(android.view.WindowManagerPolicy$WindowState, android.view.WindowManager$LayoutParams):int");
    }

    public static ArraySet<String> getWhiteLists() {
        ArraySet<String> arraySet = new ArraySet<>();
        if (sImmersiveStatusFilter != null) {
            arraySet.addAll(sImmersiveStatusFilter.mWhitelist);
        }
        if (sImmersiveNavigationFilter != null && sImmersiveNavigationFilter != sImmersiveStatusFilter) {
            arraySet.addAll(sImmersiveNavigationFilter.mWhitelist);
        }
        return arraySet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle == 1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle == 2) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getWindowFlags(android.view.WindowManagerPolicy.WindowState r3, android.view.WindowManager.LayoutParams r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L5f
        L4:
            r0 = r4
            int r0 = r0.flags
            r6 = r0
            r0 = r6
            r5 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveStatusFilter
            if (r0 == 0) goto L35
            r0 = r6
            r5 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveStatusFilter
            r1 = r4
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L35
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            if (r0 == 0) goto L2c
            r0 = r6
            r5 = r0
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            r1 = 1
            if (r0 != r1) goto L35
        L2c:
            r0 = r6
            r1 = 1024(0x400, float:1.435E-42)
            r0 = r0 | r1
            r1 = -67110913(0xfffffffffbfff7ff, float:-2.6581313E36)
            r0 = r0 & r1
            r5 = r0
        L35:
            r0 = r5
            r6 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveNavigationFilter
            if (r0 == 0) goto L5d
            r0 = r5
            r6 = r0
            android.view.WindowManagerPolicyControl$Filter r0 = android.view.WindowManagerPolicyControl.sImmersiveNavigationFilter
            r1 = r4
            boolean r0 = r0.matches(r1)
            if (r0 == 0) goto L5d
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            if (r0 == 0) goto L58
            r0 = r5
            r6 = r0
            int r0 = android.view.WindowManagerPolicyControl.sDefaultImmersiveStyle
            r1 = 2
            if (r0 != r1) goto L5d
        L58:
            r0 = r5
            r1 = -134217729(0xfffffffff7ffffff, float:-1.0384593E34)
            r0 = r0 & r1
            r6 = r0
        L5d:
            r0 = r6
            return r0
        L5f:
            r0 = r3
            android.view.WindowManager$LayoutParams r0 = r0.getAttrs()
            r4 = r0
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.WindowManagerPolicyControl.getWindowFlags(android.view.WindowManagerPolicy$WindowState, android.view.WindowManager$LayoutParams):int");
    }

    public static boolean immersiveNavigationFilterMatches(String str) {
        return sImmersiveNavigationFilter != null && sImmersiveNavigationFilter.matches(str);
    }

    public static boolean immersiveStatusFilterMatches(String str) {
        return sImmersiveStatusFilter != null && sImmersiveStatusFilter.matches(str);
    }

    public static boolean isImmersiveFiltersActive() {
        return (sImmersiveStatusFilter == null && sImmersiveNavigationFilter == null) ? false : true;
    }

    public static void reloadFromSetting(Context context) {
        reloadStyleFromSetting(context, "policy_control_style");
        reloadFromSetting(context, "policy_control");
    }

    public static void reloadFromSetting(Context context, String str) {
        if (DEBUG) {
            Slog.d(TAG, "reloadFromSetting()");
        }
        String str2 = null;
        try {
            String stringForUser = Settings.Global.getStringForUser(context.getContentResolver(), str, -2);
            if (sSettingValue == null || !sSettingValue.equals(stringForUser)) {
                setFilters(stringForUser);
                str2 = stringForUser;
                sSettingValue = stringForUser;
            }
        } catch (Throwable th) {
            Slog.w(TAG, "Error loading policy control, value=" + str2, th);
        }
    }

    public static void reloadStyleFromSetting(Context context, String str) {
        sDefaultImmersiveStyle = Settings.Global.getInt(context.getContentResolver(), str, 0);
        if (DEBUG) {
            Slog.d(TAG, "reloadStyleFromSetting " + sDefaultImmersiveStyle);
        }
    }

    public static void removeFromWhiteLists(String str) {
        if (sImmersiveStatusFilter != null) {
            sImmersiveStatusFilter.mWhitelist.remove(str);
        }
        if (sImmersiveNavigationFilter != null) {
            sImmersiveNavigationFilter.mWhitelist.remove(str);
        }
    }

    public static void saveStyleToSettings(Context context, int i) {
        Settings.Global.putInt(context.getContentResolver(), "policy_control_style", i);
        sDefaultImmersiveStyle = i;
    }

    public static void saveToSettings(Context context) {
        saveToSettings(context, "policy_control");
    }

    public static void saveToSettings(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        if (sImmersiveStatusFilter != null) {
            writeFilter(NAME_IMMERSIVE_STATUS, sImmersiveStatusFilter, sb);
            z = true;
        }
        boolean z2 = z;
        if (sImmersiveNavigationFilter != null) {
            if (z) {
                sb.append(":");
            }
            writeFilter(NAME_IMMERSIVE_NAVIGATION, sImmersiveNavigationFilter, sb);
            z2 = true;
        }
        if (sImmersivePreconfirmationsFilter != null) {
            if (z2) {
                sb.append(":");
            }
            writeFilter(NAME_IMMERSIVE_PRECONFIRMATIONS, sImmersivePreconfirmationsFilter, sb);
        }
        Settings.Global.putString(context.getContentResolver(), str, sb.toString());
    }

    private static void setFilters(String str) {
        if (DEBUG) {
            Slog.d(TAG, "setFilters: " + str);
        }
        sImmersiveStatusFilter = null;
        sImmersiveNavigationFilter = null;
        sImmersivePreconfirmationsFilter = null;
        if (str != null) {
            String[] split = str.split(":");
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String str2 = split[i2];
                int indexOf = str2.indexOf(61);
                if (indexOf != -1) {
                    String substring = str2.substring(0, indexOf);
                    String substring2 = str2.substring(indexOf + 1);
                    if (substring.equals(NAME_IMMERSIVE_FULL)) {
                        Filter parse = Filter.parse(substring2);
                        sImmersiveNavigationFilter = parse;
                        sImmersiveStatusFilter = parse;
                        if (sImmersivePreconfirmationsFilter == null) {
                            sImmersivePreconfirmationsFilter = parse;
                        }
                    } else if (substring.equals(NAME_IMMERSIVE_STATUS)) {
                        sImmersiveStatusFilter = Filter.parse(substring2);
                    } else if (substring.equals(NAME_IMMERSIVE_NAVIGATION)) {
                        Filter parse2 = Filter.parse(substring2);
                        sImmersiveNavigationFilter = parse2;
                        if (sImmersivePreconfirmationsFilter == null) {
                            sImmersivePreconfirmationsFilter = parse2;
                        }
                    } else if (substring.equals(NAME_IMMERSIVE_PRECONFIRMATIONS)) {
                        sImmersivePreconfirmationsFilter = Filter.parse(substring2);
                    }
                }
                i = i2 + 1;
            }
        }
        if (DEBUG) {
            Slog.d(TAG, "immersiveStatusFilter: " + sImmersiveStatusFilter);
            Slog.d(TAG, "immersiveNavigationFilter: " + sImmersiveNavigationFilter);
            Slog.d(TAG, "immersivePreconfirmationsFilter: " + sImmersivePreconfirmationsFilter);
        }
    }

    private static void writeFilter(String str, Filter filter, StringBuilder sb) {
        if (filter.mWhitelist.isEmpty() && filter.mBlacklist.isEmpty()) {
            return;
        }
        sb.append(str);
        sb.append("=");
        boolean z = false;
        if (!filter.mWhitelist.isEmpty()) {
            writePackages(filter.mWhitelist, sb, false);
            z = true;
        }
        if (filter.mBlacklist.isEmpty()) {
            return;
        }
        if (z) {
            sb.append(",");
        }
        writePackages(filter.mBlacklist, sb, true);
    }

    private static void writePackages(ArraySet<String> arraySet, StringBuilder sb, boolean z) {
        Iterator<String> it = arraySet.iterator();
        while (it.hasNext()) {
            if (z) {
                sb.append(NativeLibraryHelper.CLEAR_ABI_OVERRIDE);
            }
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
    }
}
