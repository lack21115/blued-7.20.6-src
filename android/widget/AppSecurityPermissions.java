package android.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.internal.R;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AppSecurityPermissions.class */
public class AppSecurityPermissions {
    private static final String TAG = "AppSecurityPermissions";
    public static final int WHICH_ALL = 65535;
    public static final int WHICH_DEVICE = 2;
    public static final int WHICH_NEW = 4;
    public static final int WHICH_PERSONAL = 1;
    private static final boolean localLOGV = false;
    private final Context mContext;
    private final LayoutInflater mInflater;
    private final CharSequence mNewPermPrefix;
    private String mPackageName;
    private final PermissionInfoComparator mPermComparator;
    private final PermissionGroupInfoComparator mPermGroupComparator;
    private final Map<String, MyPermissionGroupInfo> mPermGroups;
    private final List<MyPermissionGroupInfo> mPermGroupsList;
    private final List<MyPermissionInfo> mPermsList;
    private final PackageManager mPm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AppSecurityPermissions$MyPermissionGroupInfo.class */
    public static class MyPermissionGroupInfo extends PermissionGroupInfo {
        final ArrayList<MyPermissionInfo> mAllPermissions;
        final ArrayList<MyPermissionInfo> mDevicePermissions;
        CharSequence mLabel;
        final ArrayList<MyPermissionInfo> mNewPermissions;
        final ArrayList<MyPermissionInfo> mPersonalPermissions;

        MyPermissionGroupInfo(PermissionGroupInfo permissionGroupInfo) {
            super(permissionGroupInfo);
            this.mNewPermissions = new ArrayList<>();
            this.mPersonalPermissions = new ArrayList<>();
            this.mDevicePermissions = new ArrayList<>();
            this.mAllPermissions = new ArrayList<>();
        }

        MyPermissionGroupInfo(PermissionInfo permissionInfo) {
            this.mNewPermissions = new ArrayList<>();
            this.mPersonalPermissions = new ArrayList<>();
            this.mDevicePermissions = new ArrayList<>();
            this.mAllPermissions = new ArrayList<>();
            this.name = permissionInfo.packageName;
            this.packageName = permissionInfo.packageName;
        }

        public Drawable loadGroupIcon(PackageManager packageManager) {
            if (this.icon != 0) {
                return loadUnbadgedIcon(packageManager);
            }
            try {
                return packageManager.getApplicationInfo(this.packageName, 0).loadUnbadgedIcon(packageManager);
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AppSecurityPermissions$MyPermissionInfo.class */
    public static class MyPermissionInfo extends PermissionInfo {
        int mExistingReqFlags;
        CharSequence mLabel;
        boolean mNew;
        int mNewReqFlags;

        MyPermissionInfo(PermissionInfo permissionInfo) {
            super(permissionInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AppSecurityPermissions$PermissionGroupInfoComparator.class */
    public static class PermissionGroupInfoComparator implements Comparator<MyPermissionGroupInfo> {
        private final Collator sCollator = Collator.getInstance();

        PermissionGroupInfoComparator() {
        }

        @Override // java.util.Comparator
        public final int compare(MyPermissionGroupInfo myPermissionGroupInfo, MyPermissionGroupInfo myPermissionGroupInfo2) {
            return ((myPermissionGroupInfo.flags ^ myPermissionGroupInfo2.flags) & 1) != 0 ? (myPermissionGroupInfo.flags & 1) != 0 ? -1 : 1 : myPermissionGroupInfo.priority != myPermissionGroupInfo2.priority ? myPermissionGroupInfo.priority <= myPermissionGroupInfo2.priority ? 1 : -1 : this.sCollator.compare(myPermissionGroupInfo.mLabel, myPermissionGroupInfo2.mLabel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AppSecurityPermissions$PermissionInfoComparator.class */
    public static class PermissionInfoComparator implements Comparator<MyPermissionInfo> {
        private final Collator sCollator = Collator.getInstance();

        PermissionInfoComparator() {
        }

        @Override // java.util.Comparator
        public final int compare(MyPermissionInfo myPermissionInfo, MyPermissionInfo myPermissionInfo2) {
            return this.sCollator.compare(myPermissionInfo.mLabel, myPermissionInfo2.mLabel);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AppSecurityPermissions$PermissionItemView.class */
    public static class PermissionItemView extends LinearLayout implements View.OnClickListener {
        AlertDialog mDialog;
        MyPermissionGroupInfo mGroup;
        private String mPackageName;
        MyPermissionInfo mPerm;
        private boolean mShowRevokeUI;

        public PermissionItemView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mShowRevokeUI = false;
            setClickable(true);
        }

        private void addRevokeUIIfNecessary(AlertDialog.Builder builder) {
            if (this.mShowRevokeUI) {
                if ((this.mPerm.mExistingReqFlags & 1) != 0) {
                    return;
                }
                builder.setNegativeButton(R.string.revoke, new DialogInterface.OnClickListener() { // from class: android.widget.AppSecurityPermissions.PermissionItemView.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PermissionItemView.this.getContext().getPackageManager().revokePermission(PermissionItemView.this.mPackageName, PermissionItemView.this.mPerm.name);
                        PermissionItemView.this.setVisibility(8);
                    }
                });
                builder.setPositiveButton(17039370, (DialogInterface.OnClickListener) null);
            }
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00d3 -> B:15:0x008d). Please submit an issue!!! */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            if (this.mGroup == null || this.mPerm == null) {
                return;
            }
            if (this.mDialog != null) {
                this.mDialog.dismiss();
            }
            PackageManager packageManager = getContext().getPackageManager();
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(this.mGroup.mLabel);
            if (this.mPerm.descriptionRes != 0) {
                builder.setMessage(this.mPerm.loadDescription(packageManager));
            } else {
                try {
                    str = packageManager.getApplicationInfo(this.mPerm.packageName, 0).loadLabel(packageManager);
                } catch (PackageManager.NameNotFoundException e) {
                    str = this.mPerm.packageName;
                }
                StringBuilder sb = new StringBuilder(128);
                sb.append(getContext().getString(R.string.perms_description_app, str));
                sb.append("\n\n");
                sb.append(this.mPerm.name);
                builder.setMessage(sb.toString());
            }
            builder.setCancelable(true);
            builder.setIcon(this.mGroup.loadGroupIcon(packageManager));
            addRevokeUIIfNecessary(builder);
            this.mDialog = builder.show();
            this.mDialog.setCanceledOnTouchOutside(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.ViewGroup, android.view.View
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.mDialog != null) {
                this.mDialog.dismiss();
            }
        }

        public void setPermission(MyPermissionGroupInfo myPermissionGroupInfo, MyPermissionInfo myPermissionInfo, boolean z, CharSequence charSequence, String str, boolean z2) {
            this.mGroup = myPermissionGroupInfo;
            this.mPerm = myPermissionInfo;
            this.mShowRevokeUI = z2;
            this.mPackageName = str;
            ImageView imageView = (ImageView) findViewById(R.id.perm_icon);
            TextView textView = (TextView) findViewById(R.id.perm_name);
            PackageManager packageManager = getContext().getPackageManager();
            Drawable drawable = null;
            if (z) {
                drawable = myPermissionGroupInfo.loadGroupIcon(packageManager);
            }
            CharSequence charSequence2 = myPermissionInfo.mLabel;
            SpannableStringBuilder spannableStringBuilder = charSequence2;
            if (myPermissionInfo.mNew) {
                spannableStringBuilder = charSequence2;
                if (charSequence != null) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    Parcel obtain = Parcel.obtain();
                    TextUtils.writeToParcel(charSequence, obtain, 0);
                    obtain.setDataPosition(0);
                    obtain.recycle();
                    spannableStringBuilder2.append(TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(obtain));
                    spannableStringBuilder2.append(charSequence2);
                    spannableStringBuilder = spannableStringBuilder2;
                }
            }
            imageView.setImageDrawable(drawable);
            textView.setText(spannableStringBuilder);
            setOnClickListener(this);
        }
    }

    private AppSecurityPermissions(Context context) {
        this.mPermGroups = new HashMap();
        this.mPermGroupsList = new ArrayList();
        this.mPermGroupComparator = new PermissionGroupInfoComparator();
        this.mPermComparator = new PermissionInfoComparator();
        this.mPermsList = new ArrayList();
        this.mContext = context;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mPm = this.mContext.getPackageManager();
        this.mNewPermPrefix = this.mContext.getText(R.string.perms_new_perm_prefix);
    }

    public AppSecurityPermissions(Context context, PackageInfo packageInfo) {
        this(context);
        HashSet hashSet = new HashSet();
        if (packageInfo == null) {
            return;
        }
        this.mPackageName = packageInfo.packageName;
        PackageInfo packageInfo2 = null;
        if (packageInfo.requestedPermissions != null) {
            try {
                packageInfo2 = this.mPm.getPackageInfo(packageInfo.packageName, 4096);
            } catch (PackageManager.NameNotFoundException e) {
            }
            extractPerms(packageInfo, hashSet, packageInfo2);
        }
        if (packageInfo.sharedUserId != null) {
            try {
                getAllUsedPermissions(this.mPm.getUidForSharedUser(packageInfo.sharedUserId), hashSet);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w(TAG, "Couldn't retrieve shared user id for: " + packageInfo.packageName);
            }
        }
        this.mPermsList.addAll(hashSet);
        setPermissions(this.mPermsList);
    }

    public AppSecurityPermissions(Context context, String str) {
        this(context);
        this.mPackageName = str;
        HashSet hashSet = new HashSet();
        try {
            PackageInfo packageInfo = this.mPm.getPackageInfo(str, 4096);
            if (packageInfo.applicationInfo != null && packageInfo.applicationInfo.uid != -1) {
                getAllUsedPermissions(packageInfo.applicationInfo.uid, hashSet);
            }
            this.mPermsList.addAll(hashSet);
            setPermissions(this.mPermsList);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Couldn't retrieve permissions for package:" + str);
        }
    }

    private void addPermToList(List<MyPermissionInfo> list, MyPermissionInfo myPermissionInfo) {
        if (myPermissionInfo.mLabel == null) {
            myPermissionInfo.mLabel = myPermissionInfo.loadLabel(this.mPm);
        }
        int binarySearch = Collections.binarySearch(list, myPermissionInfo, this.mPermComparator);
        if (binarySearch < 0) {
            list.add((-binarySearch) - 1, myPermissionInfo);
        }
    }

    private void displayPermissions(List<MyPermissionGroupInfo> list, LinearLayout linearLayout, int i, boolean z) {
        linearLayout.removeAllViews();
        int i2 = (int) (8.0f * this.mContext.getResources().getDisplayMetrics().density);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= list.size()) {
                return;
            }
            MyPermissionGroupInfo myPermissionGroupInfo = list.get(i4);
            List<MyPermissionInfo> permissionList = getPermissionList(myPermissionGroupInfo, i);
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < permissionList.size()) {
                    View permissionItemView = getPermissionItemView(myPermissionGroupInfo, permissionList.get(i6), i6 == 0, i != 4 ? this.mNewPermPrefix : null, z);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    if (i6 == 0) {
                        layoutParams.topMargin = i2;
                    }
                    if (i6 == myPermissionGroupInfo.mAllPermissions.size() - 1) {
                        layoutParams.bottomMargin = i2;
                    }
                    if (linearLayout.getChildCount() == 0) {
                        layoutParams.topMargin *= 2;
                    }
                    linearLayout.addView(permissionItemView, layoutParams);
                    i5 = i6 + 1;
                }
            }
            i3 = i4 + 1;
        }
    }

    private void extractPerms(PackageInfo packageInfo, Set<MyPermissionInfo> set, PackageInfo packageInfo2) {
        MyPermissionGroupInfo myPermissionGroupInfo;
        String[] strArr = packageInfo.requestedPermissions;
        int[] iArr = packageInfo.requestedPermissionsFlags;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return;
            }
            String str = strArr[i2];
            if (packageInfo2 == null || packageInfo != packageInfo2 || (iArr[i2] & 2) != 0) {
                try {
                    PermissionInfo permissionInfo = this.mPm.getPermissionInfo(str, 0);
                    if (permissionInfo != null) {
                        int i3 = -1;
                        if (packageInfo2 != null) {
                            i3 = -1;
                            if (packageInfo2.requestedPermissions != null) {
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4;
                                    i3 = -1;
                                    if (i5 >= packageInfo2.requestedPermissions.length) {
                                        break;
                                    } else if (str.equals(packageInfo2.requestedPermissions[i5])) {
                                        i3 = i5;
                                        break;
                                    } else {
                                        i4 = i5 + 1;
                                    }
                                }
                            }
                        }
                        int i6 = i3 >= 0 ? packageInfo2.requestedPermissionsFlags[i3] : 0;
                        if (isDisplayablePermission(permissionInfo, iArr[i2], i6)) {
                            String str2 = permissionInfo.group;
                            String str3 = str2;
                            if (str2 == null) {
                                str3 = permissionInfo.packageName;
                                permissionInfo.group = str3;
                            }
                            if (this.mPermGroups.get(str3) == null) {
                                PermissionGroupInfo permissionGroupInfo = null;
                                if (str2 != null) {
                                    permissionGroupInfo = this.mPm.getPermissionGroupInfo(str2, 0);
                                }
                                if (permissionGroupInfo != null) {
                                    myPermissionGroupInfo = new MyPermissionGroupInfo(permissionGroupInfo);
                                } else {
                                    permissionInfo.group = permissionInfo.packageName;
                                    if (this.mPermGroups.get(permissionInfo.group) == null) {
                                        new MyPermissionGroupInfo(permissionInfo);
                                    }
                                    myPermissionGroupInfo = new MyPermissionGroupInfo(permissionInfo);
                                }
                                this.mPermGroups.put(permissionInfo.group, myPermissionGroupInfo);
                            }
                            boolean z = packageInfo2 != null && (i6 & 2) == 0;
                            MyPermissionInfo myPermissionInfo = new MyPermissionInfo(permissionInfo);
                            myPermissionInfo.mNewReqFlags = iArr[i2];
                            myPermissionInfo.mExistingReqFlags = i6;
                            myPermissionInfo.mNew = z;
                            set.add(myPermissionInfo);
                        }
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.i(TAG, "Ignoring unknown permission:" + str);
                }
            }
            i = i2 + 1;
        }
    }

    private void getAllUsedPermissions(int i, Set<MyPermissionInfo> set) {
        String[] packagesForUid = this.mPm.getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return;
        }
        int length = packagesForUid.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            getPermissionsForPackage(packagesForUid[i3], set);
            i2 = i3 + 1;
        }
    }

    public static View getPermissionItemView(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return getPermissionItemViewOld(context, (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), charSequence, charSequence2, z, context.getDrawable(z ? 17302317 : 17302593));
    }

    private static PermissionItemView getPermissionItemView(Context context, LayoutInflater layoutInflater, MyPermissionGroupInfo myPermissionGroupInfo, MyPermissionInfo myPermissionInfo, boolean z, CharSequence charSequence, String str, boolean z2) {
        PermissionItemView permissionItemView = (PermissionItemView) layoutInflater.inflate((myPermissionInfo.flags & 1) != 0 ? 17367091 : 17367090, (ViewGroup) null);
        permissionItemView.setPermission(myPermissionGroupInfo, myPermissionInfo, z, charSequence, str, z2);
        return permissionItemView;
    }

    private PermissionItemView getPermissionItemView(MyPermissionGroupInfo myPermissionGroupInfo, MyPermissionInfo myPermissionInfo, boolean z, CharSequence charSequence, boolean z2) {
        return getPermissionItemView(this.mContext, this.mInflater, myPermissionGroupInfo, myPermissionInfo, z, charSequence, this.mPackageName, z2);
    }

    private static View getPermissionItemViewOld(Context context, LayoutInflater layoutInflater, CharSequence charSequence, CharSequence charSequence2, boolean z, Drawable drawable) {
        View inflate = layoutInflater.inflate(R.layout.app_permission_item_old, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.permission_group);
        TextView textView2 = (TextView) inflate.findViewById(R.id.permission_list);
        ((ImageView) inflate.findViewById(R.id.perm_icon)).setImageDrawable(drawable);
        if (charSequence != null) {
            textView.setText(charSequence);
            textView2.setText(charSequence2);
            return inflate;
        }
        textView.setText(charSequence2);
        textView2.setVisibility(8);
        return inflate;
    }

    private List<MyPermissionInfo> getPermissionList(MyPermissionGroupInfo myPermissionGroupInfo, int i) {
        return i == 4 ? myPermissionGroupInfo.mNewPermissions : i == 1 ? myPermissionGroupInfo.mPersonalPermissions : i == 2 ? myPermissionGroupInfo.mDevicePermissions : myPermissionGroupInfo.mAllPermissions;
    }

    private void getPermissionsForPackage(String str, Set<MyPermissionInfo> set) {
        try {
            PackageInfo packageInfo = this.mPm.getPackageInfo(str, 4096);
            extractPerms(packageInfo, set, packageInfo);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "Couldn't retrieve permissions for package: " + str);
        }
    }

    private View getPermissionsView(int i, boolean z) {
        LinearLayout linearLayout = (LinearLayout) this.mInflater.inflate(R.layout.app_perms_summary, (ViewGroup) null);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.perms_list);
        View findViewById = linearLayout.findViewById(R.id.no_permissions);
        displayPermissions(this.mPermGroupsList, linearLayout2, i, z);
        if (linearLayout2.getChildCount() <= 0) {
            findViewById.setVisibility(0);
        }
        return linearLayout;
    }

    private boolean isDisplayablePermission(PermissionInfo permissionInfo, int i, int i2) {
        int i3 = permissionInfo.protectionLevel & 15;
        boolean z = i3 == 0;
        boolean z2 = i3 == 1;
        boolean z3 = (i & 1) != 0;
        boolean z4 = (permissionInfo.protectionLevel & 32) != 0;
        boolean z5 = (i2 & 2) != 0;
        boolean z6 = (i & 2) != 0;
        if ((z || z2) && (z3 || z5 || z6)) {
            return true;
        }
        return z4 && z5;
    }

    private void setPermissions(List<MyPermissionInfo> list) {
        MyPermissionGroupInfo myPermissionGroupInfo;
        if (list != null) {
            for (MyPermissionInfo myPermissionInfo : list) {
                if (isDisplayablePermission(myPermissionInfo, myPermissionInfo.mNewReqFlags, myPermissionInfo.mExistingReqFlags) && (myPermissionGroupInfo = this.mPermGroups.get(myPermissionInfo.group)) != null) {
                    myPermissionInfo.mLabel = myPermissionInfo.loadLabel(this.mPm);
                    addPermToList(myPermissionGroupInfo.mAllPermissions, myPermissionInfo);
                    if (myPermissionInfo.mNew) {
                        addPermToList(myPermissionGroupInfo.mNewPermissions, myPermissionInfo);
                    }
                    if ((myPermissionGroupInfo.flags & 1) != 0) {
                        addPermToList(myPermissionGroupInfo.mPersonalPermissions, myPermissionInfo);
                    } else {
                        addPermToList(myPermissionGroupInfo.mDevicePermissions, myPermissionInfo);
                    }
                }
            }
        }
        for (MyPermissionGroupInfo myPermissionGroupInfo2 : this.mPermGroups.values()) {
            if (myPermissionGroupInfo2.labelRes == 0 && myPermissionGroupInfo2.nonLocalizedLabel == null) {
                try {
                    myPermissionGroupInfo2.mLabel = this.mPm.getApplicationInfo(myPermissionGroupInfo2.packageName, 0).loadLabel(this.mPm);
                } catch (PackageManager.NameNotFoundException e) {
                    myPermissionGroupInfo2.mLabel = myPermissionGroupInfo2.loadLabel(this.mPm);
                }
            } else {
                myPermissionGroupInfo2.mLabel = myPermissionGroupInfo2.loadLabel(this.mPm);
            }
            this.mPermGroupsList.add(myPermissionGroupInfo2);
        }
        Collections.sort(this.mPermGroupsList, this.mPermGroupComparator);
    }

    public int getPermissionCount() {
        return getPermissionCount(65535);
    }

    public int getPermissionCount(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mPermGroupsList.size()) {
                return i2;
            }
            i2 += getPermissionList(this.mPermGroupsList.get(i4), i).size();
            i3 = i4 + 1;
        }
    }

    public View getPermissionsView() {
        return getPermissionsView(65535, false);
    }

    public View getPermissionsView(int i) {
        return getPermissionsView(i, false);
    }

    public View getPermissionsViewWithRevokeButtons() {
        return getPermissionsView(65535, true);
    }
}
