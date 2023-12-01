package com.android.internal.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.AppGlobals;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.alipay.sdk.cons.b;
import com.android.ims.ImsConferenceState;
import com.android.internal.R;
import com.android.internal.content.PackageMonitor;
import com.android.internal.widget.ResolverDrawerLayout;
import com.anythink.core.common.l;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity.class */
public class ResolverActivity extends Activity implements AdapterView.OnItemClickListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "ResolverActivity";
    private static final long USAGE_STATS_PERIOD = 1209600000;
    private ResolveListAdapter mAdapter;
    private Button mAlwaysButton;
    private boolean mAlwaysUseOption;
    private ViewGroup mFilteredItemContainer;
    private int mIconDpi;
    private int mIconSize;
    private Intent mIntent;
    private int mLaunchedFromUid;
    private ListView mListView;
    private int mMaxColumns;
    private Button mOnceButton;
    private PackageManager mPm;
    private View mProfileView;
    private boolean mRegistered;
    private boolean mSafeForwardingMode;
    private boolean mShowExtended;
    private Map<String, UsageStats> mStats;
    private UsageStatsManager mUsm;
    private int mLastSelected = -1;
    private boolean mResolvingHome = false;
    private int mProfileSwitchMessageId = -1;
    private final PackageMonitor mPackageMonitor = new PackageMonitor() { // from class: com.android.internal.app.ResolverActivity.1
        @Override // com.android.internal.content.PackageMonitor
        public void onSomePackagesChanged() {
            ResolverActivity.this.mAdapter.handlePackagesChanged();
            if (ResolverActivity.this.mProfileView != null) {
                ResolverActivity.this.bindProfileView();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$ActionTitle.class */
    public enum ActionTitle {
        VIEW("android.intent.action.VIEW", R.string.whichViewApplication, R.string.whichViewApplicationNamed),
        EDIT("android.intent.action.EDIT", R.string.whichEditApplication, R.string.whichEditApplicationNamed),
        SEND("android.intent.action.SEND", R.string.whichSendApplication, R.string.whichSendApplicationNamed),
        SENDTO("android.intent.action.SENDTO", R.string.whichSendApplication, R.string.whichSendApplicationNamed),
        SEND_MULTIPLE("android.intent.action.SEND_MULTIPLE", R.string.whichSendApplication, R.string.whichSendApplicationNamed),
        DEFAULT(null, R.string.whichApplication, R.string.whichApplicationNamed),
        HOME("android.intent.action.MAIN", R.string.whichHomeApplication, R.string.whichHomeApplicationNamed);
        
        public final String action;
        public final int namedTitleRes;
        public final int titleRes;

        ActionTitle(String str, int i, int i2) {
            this.action = str;
            this.titleRes = i;
            this.namedTitleRes = i2;
        }

        public static ActionTitle forAction(String str) {
            ActionTitle[] values = values();
            int length = values.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return DEFAULT;
                }
                ActionTitle actionTitle = values[i2];
                if (actionTitle != HOME && str != null && str.equals(actionTitle.action)) {
                    return actionTitle;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$DisplayResolveInfo.class */
    public final class DisplayResolveInfo {
        Drawable displayIcon;
        CharSequence displayLabel;
        CharSequence extendedInfo;
        Intent origIntent;
        ResolveInfo ri;

        DisplayResolveInfo(ResolveInfo resolveInfo, CharSequence charSequence, CharSequence charSequence2, Intent intent) {
            this.ri = resolveInfo;
            this.displayLabel = charSequence;
            this.extendedInfo = charSequence2;
            this.origIntent = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$ItemLongClickListener.class */
    public class ItemLongClickListener implements AdapterView.OnItemLongClickListener {
        ItemLongClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            int headerViewsCount = i - ResolverActivity.this.mListView.getHeaderViewsCount();
            if (headerViewsCount < 0) {
                return false;
            }
            ResolverActivity.this.showAppDetails(ResolverActivity.this.mAdapter.resolveInfoForPosition(headerViewsCount, true));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$LoadIconIntoViewTask.class */
    public class LoadIconIntoViewTask extends AsyncTask<DisplayResolveInfo, Void, DisplayResolveInfo> {
        final ImageView mTargetView;

        public LoadIconIntoViewTask(ImageView imageView) {
            this.mTargetView = imageView;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public DisplayResolveInfo doInBackground(DisplayResolveInfo... displayResolveInfoArr) {
            DisplayResolveInfo displayResolveInfo = displayResolveInfoArr[0];
            if (displayResolveInfo.displayIcon == null) {
                displayResolveInfo.displayIcon = ResolverActivity.this.loadIconForResolveInfo(displayResolveInfo.ri);
            }
            return displayResolveInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(DisplayResolveInfo displayResolveInfo) {
            this.mTargetView.setImageDrawable(displayResolveInfo.displayIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$LoadIconTask.class */
    public class LoadIconTask extends AsyncTask<DisplayResolveInfo, Void, DisplayResolveInfo> {
        LoadIconTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public DisplayResolveInfo doInBackground(DisplayResolveInfo... displayResolveInfoArr) {
            DisplayResolveInfo displayResolveInfo = displayResolveInfoArr[0];
            if (displayResolveInfo.displayIcon == null) {
                displayResolveInfo.displayIcon = ResolverActivity.this.loadIconForResolveInfo(displayResolveInfo.ri);
            }
            return displayResolveInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(DisplayResolveInfo displayResolveInfo) {
            if (ResolverActivity.this.mProfileView != null && ResolverActivity.this.mAdapter.getOtherProfile() == displayResolveInfo) {
                ResolverActivity.this.bindProfileView();
            }
            ResolverActivity.this.mAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$ResolveListAdapter.class */
    public final class ResolveListAdapter extends BaseAdapter {
        private final List<ResolveInfo> mBaseResolveList;
        private boolean mFilterLastUsed;
        private final LayoutInflater mInflater;
        private final Intent[] mInitialIntents;
        private ResolveInfo mLastChosen;
        private final int mLaunchedFromUid;
        List<ResolveInfo> mOrigResolveList;
        private DisplayResolveInfo mOtherProfile;
        private int mLastChosenPosition = -1;
        List<DisplayResolveInfo> mList = new ArrayList();

        public ResolveListAdapter(Context context, Intent[] intentArr, List<ResolveInfo> list, int i, boolean z) {
            this.mInitialIntents = intentArr;
            this.mBaseResolveList = list;
            this.mLaunchedFromUid = i;
            this.mInflater = LayoutInflater.from(context);
            this.mFilterLastUsed = z;
            rebuildList();
        }

        private void addResolveInfo(DisplayResolveInfo displayResolveInfo) {
            if (displayResolveInfo.ri.targetUserId == -2 || this.mOtherProfile != null) {
                this.mList.add(displayResolveInfo);
            } else {
                this.mOtherProfile = displayResolveInfo;
            }
        }

        private final void bindView(View view, DisplayResolveInfo displayResolveInfo) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            viewHolder.text.setText(displayResolveInfo.displayLabel);
            if (ResolverActivity.this.mShowExtended) {
                viewHolder.text2.setVisibility(0);
                viewHolder.text2.setText(displayResolveInfo.extendedInfo);
            } else {
                viewHolder.text2.setVisibility(8);
            }
            if (displayResolveInfo.displayIcon == null) {
                new LoadIconTask().execute(displayResolveInfo);
            }
            viewHolder.icon.setImageDrawable(displayResolveInfo.displayIcon);
        }

        private void processGroup(List<ResolveInfo> list, int i, int i2, ResolveInfo resolveInfo, CharSequence charSequence) {
            if ((i2 - i) + 1 == 1) {
                addResolveInfo(new DisplayResolveInfo(resolveInfo, charSequence, null, null));
                updateLastChosenPosition(resolveInfo);
                return;
            }
            ResolverActivity.this.mShowExtended = true;
            boolean z = false;
            CharSequence loadLabel = resolveInfo.activityInfo.applicationInfo.loadLabel(ResolverActivity.this.mPm);
            if (loadLabel == null) {
                z = true;
            }
            boolean z2 = z;
            if (!z) {
                HashSet hashSet = new HashSet();
                hashSet.add(loadLabel);
                int i3 = i;
                while (true) {
                    int i4 = i3 + 1;
                    z2 = z;
                    if (i4 > i2) {
                        break;
                    }
                    CharSequence loadLabel2 = list.get(i4).activityInfo.applicationInfo.loadLabel(ResolverActivity.this.mPm);
                    if (loadLabel2 == null || hashSet.contains(loadLabel2)) {
                        break;
                    }
                    hashSet.add(loadLabel2);
                    i3 = i4;
                }
                z2 = true;
                hashSet.clear();
            }
            while (i <= i2) {
                ResolveInfo resolveInfo2 = list.get(i);
                if (z2) {
                    addResolveInfo(new DisplayResolveInfo(resolveInfo2, charSequence, resolveInfo2.activityInfo.packageName, null));
                } else {
                    addResolveInfo(new DisplayResolveInfo(resolveInfo2, charSequence, resolveInfo2.activityInfo.applicationInfo.loadLabel(ResolverActivity.this.mPm), null));
                }
                updateLastChosenPosition(resolveInfo2);
                i++;
            }
        }

        private void rebuildList() {
            List<ResolveInfo> list;
            int i;
            try {
                this.mLastChosen = AppGlobals.getPackageManager().getLastChosenActivity(ResolverActivity.this.mIntent, ResolverActivity.this.mIntent.resolveTypeIfNeeded(ResolverActivity.this.getContentResolver()), 65536);
            } catch (RemoteException e) {
                Log.d(ResolverActivity.TAG, "Error calling setLastChosenActivity\n" + e);
            }
            this.mList.clear();
            if (this.mBaseResolveList != null) {
                list = this.mBaseResolveList;
                this.mOrigResolveList = list;
            } else {
                List<ResolveInfo> queryIntentActivities = ResolverActivity.this.mPm.queryIntentActivities(ResolverActivity.this.mIntent, (this.mFilterLastUsed ? 64 : 0) | 65536);
                this.mOrigResolveList = queryIntentActivities;
                list = queryIntentActivities;
                if (queryIntentActivities != null) {
                    int size = queryIntentActivities.size();
                    while (true) {
                        int i2 = size - 1;
                        list = queryIntentActivities;
                        if (i2 < 0) {
                            break;
                        }
                        ActivityInfo activityInfo = queryIntentActivities.get(i2).activityInfo;
                        if (ActivityManager.checkComponentPermission(activityInfo.permission, this.mLaunchedFromUid, activityInfo.applicationInfo.uid, activityInfo.exported) != 0) {
                            if (this.mOrigResolveList == queryIntentActivities) {
                                this.mOrigResolveList = new ArrayList(this.mOrigResolveList);
                            }
                            queryIntentActivities.remove(i2);
                        }
                        size = i2;
                    }
                }
            }
            if (list != null) {
                int size2 = list.size();
                if (size2 > 0) {
                    ResolveInfo resolveInfo = list.get(0);
                    int i3 = 1;
                    while (i3 < size2) {
                        ResolveInfo resolveInfo2 = list.get(i3);
                        int i4 = size2;
                        if (resolveInfo.priority == resolveInfo2.priority) {
                            i = size2;
                            if (resolveInfo.isDefault != resolveInfo2.isDefault) {
                                i4 = size2;
                            } else {
                                i3++;
                                size2 = i;
                            }
                        }
                        while (true) {
                            i = i4;
                            if (i3 < i4) {
                                if (this.mOrigResolveList == list) {
                                    this.mOrigResolveList = new ArrayList(this.mOrigResolveList);
                                }
                                list.remove(i3);
                                i4--;
                            }
                        }
                        i3++;
                        size2 = i;
                    }
                    if (size2 > 1) {
                        Collections.sort(list, new ResolverComparator(ResolverActivity.this, ResolverActivity.this.mIntent));
                    }
                    if (this.mInitialIntents != null) {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= this.mInitialIntents.length) {
                                break;
                            }
                            Intent intent = this.mInitialIntents[i6];
                            if (intent != null) {
                                ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(ResolverActivity.this.getPackageManager(), 0);
                                if (resolveActivityInfo == null) {
                                    Log.w(ResolverActivity.TAG, "No activity found for " + intent);
                                } else {
                                    ResolveInfo resolveInfo3 = new ResolveInfo();
                                    resolveInfo3.activityInfo = resolveActivityInfo;
                                    if (((UserManager) ResolverActivity.this.getSystemService(ImsConferenceState.USER)).isManagedProfile()) {
                                        resolveInfo3.noResourceId = true;
                                    }
                                    if (intent instanceof LabeledIntent) {
                                        LabeledIntent labeledIntent = (LabeledIntent) intent;
                                        resolveInfo3.resolvePackageName = labeledIntent.getSourcePackage();
                                        resolveInfo3.labelRes = labeledIntent.getLabelResource();
                                        resolveInfo3.nonLocalizedLabel = labeledIntent.getNonLocalizedLabel();
                                        resolveInfo3.icon = labeledIntent.getIconResource();
                                    }
                                    addResolveInfo(new DisplayResolveInfo(resolveInfo3, resolveInfo3.loadLabel(ResolverActivity.this.getPackageManager()), null, intent));
                                }
                            }
                            i5 = i6 + 1;
                        }
                    }
                    ResolveInfo resolveInfo4 = list.get(0);
                    int i7 = 0;
                    CharSequence loadLabel = resolveInfo4.loadLabel(ResolverActivity.this.mPm);
                    ResolverActivity.this.mShowExtended = false;
                    int i8 = 1;
                    while (i8 < size2) {
                        String str = loadLabel;
                        if (loadLabel == null) {
                            str = resolveInfo4.activityInfo.packageName;
                        }
                        ResolveInfo resolveInfo5 = list.get(i8);
                        CharSequence loadLabel2 = resolveInfo5.loadLabel(ResolverActivity.this.mPm);
                        String str2 = loadLabel2;
                        if (loadLabel2 == null) {
                            str2 = resolveInfo5.activityInfo.packageName;
                        }
                        if (!str2.equals(str)) {
                            processGroup(list, i7, i8 - 1, resolveInfo4, str);
                            resolveInfo4 = resolveInfo5;
                            str = str2;
                            i7 = i8;
                        }
                        i8++;
                        loadLabel = str;
                    }
                    processGroup(list, i7, size2 - 1, resolveInfo4, loadLabel);
                }
            }
            if (this.mOtherProfile == null || this.mLastChosenPosition < 0) {
                return;
            }
            this.mLastChosenPosition = -1;
            this.mFilterLastUsed = false;
        }

        private void updateLastChosenPosition(ResolveInfo resolveInfo) {
            if (this.mLastChosen != null && this.mLastChosen.activityInfo.packageName.equals(resolveInfo.activityInfo.packageName) && this.mLastChosen.activityInfo.name.equals(resolveInfo.activityInfo.name)) {
                this.mLastChosenPosition = this.mList.size() - 1;
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = this.mList.size();
            int i = size;
            if (this.mFilterLastUsed) {
                i = size;
                if (this.mLastChosenPosition >= 0) {
                    i = size - 1;
                }
            }
            return i;
        }

        public DisplayResolveInfo getFilteredItem() {
            if (!this.mFilterLastUsed || this.mLastChosenPosition < 0) {
                return null;
            }
            return this.mList.get(this.mLastChosenPosition);
        }

        public int getFilteredPosition() {
            if (!this.mFilterLastUsed || this.mLastChosenPosition < 0) {
                return -1;
            }
            return this.mLastChosenPosition;
        }

        @Override // android.widget.Adapter
        public DisplayResolveInfo getItem(int i) {
            int i2 = i;
            if (this.mFilterLastUsed) {
                i2 = i;
                if (this.mLastChosenPosition >= 0) {
                    i2 = i;
                    if (i >= this.mLastChosenPosition) {
                        i2 = i + 1;
                    }
                }
            }
            return this.mList.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public DisplayResolveInfo getOtherProfile() {
            return this.mOtherProfile;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2 = view;
            if (view == null) {
                view2 = this.mInflater.inflate(R.layout.resolve_list_item, viewGroup, false);
                view2.setTag(new ViewHolder(view2));
            }
            bindView(view2, getItem(i));
            return view2;
        }

        public void handlePackagesChanged() {
            rebuildList();
            notifyDataSetChanged();
            if (getCount() == 0) {
                ResolverActivity.this.finish();
            }
        }

        public boolean hasFilteredItem() {
            return this.mFilterLastUsed && this.mLastChosenPosition >= 0;
        }

        public Intent intentForPosition(int i, boolean z) {
            return ResolverActivity.this.intentForDisplayResolveInfo(z ? getItem(i) : this.mList.get(i));
        }

        public ResolveInfo resolveInfoForPosition(int i, boolean z) {
            return (z ? getItem(i) : this.mList.get(i)).ri;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$ResolverComparator.class */
    public class ResolverComparator implements Comparator<ResolveInfo> {
        private final Collator mCollator;
        private final boolean mHttp;

        public ResolverComparator(Context context, Intent intent) {
            this.mCollator = Collator.getInstance(context.getResources().getConfiguration().locale);
            String scheme = intent.getScheme();
            this.mHttp = "http".equals(scheme) || b.a.equals(scheme);
        }

        private long getPackageTimeSpent(String str) {
            UsageStats usageStats;
            if (ResolverActivity.this.mStats == null || (usageStats = (UsageStats) ResolverActivity.this.mStats.get(str)) == null) {
                return 0L;
            }
            return usageStats.getTotalTimeInForeground();
        }

        @Override // java.util.Comparator
        public int compare(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
            boolean isSpecificUriMatch;
            if (resolveInfo.targetUserId != -2) {
                return 1;
            }
            if (this.mHttp && (isSpecificUriMatch = ResolverActivity.isSpecificUriMatch(resolveInfo.match)) != ResolverActivity.isSpecificUriMatch(resolveInfo2.match)) {
                return isSpecificUriMatch ? -1 : 1;
            }
            if (ResolverActivity.this.mStats != null) {
                long packageTimeSpent = getPackageTimeSpent(resolveInfo2.activityInfo.packageName) - getPackageTimeSpent(resolveInfo.activityInfo.packageName);
                if (packageTimeSpent != 0) {
                    return packageTimeSpent > 0 ? 1 : -1;
                }
            }
            CharSequence loadLabel = resolveInfo.loadLabel(ResolverActivity.this.mPm);
            String str = loadLabel;
            if (loadLabel == null) {
                str = resolveInfo.activityInfo.name;
            }
            CharSequence loadLabel2 = resolveInfo2.loadLabel(ResolverActivity.this.mPm);
            String str2 = loadLabel2;
            if (loadLabel2 == null) {
                str2 = resolveInfo2.activityInfo.name;
            }
            return this.mCollator.compare(str.toString(), str2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/ResolverActivity$ViewHolder.class */
    public static class ViewHolder {
        public ImageView icon;
        public TextView text;
        public TextView text2;

        public ViewHolder(View view) {
            this.text = (TextView) view.findViewById(R.id.text1);
            this.text2 = (TextView) view.findViewById(R.id.text2);
            this.icon = (ImageView) view.findViewById(R.id.icon);
        }
    }

    private boolean hasManagedProfile() {
        UserManager userManager = (UserManager) getSystemService(ImsConferenceState.USER);
        if (userManager == null) {
            return false;
        }
        try {
            for (UserInfo userInfo : userManager.getProfiles(getUserId())) {
                if (userInfo != null && userInfo.isManagedProfile()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e) {
            return false;
        }
    }

    static final boolean isSpecificUriMatch(int i) {
        int i2 = i & 268369920;
        return i2 >= 3145728 && i2 <= 5242880;
    }

    private Intent makeMyIntent() {
        Intent intent = new Intent(getIntent());
        intent.setComponent(null);
        intent.setFlags(intent.getFlags() & (-8388609));
        return intent;
    }

    private void setAlwaysButtonEnabled(boolean z, int i, boolean z2) {
        boolean z3 = false;
        if (z) {
            z3 = false;
            if (this.mAdapter.resolveInfoForPosition(i, z2).targetUserId == -2) {
                z3 = true;
            }
        }
        this.mAlwaysButton.setEnabled(z3);
    }

    private void setProfileSwitchMessageId(int i) {
        if (i == -2 || i == UserHandle.myUserId()) {
            return;
        }
        UserManager userManager = (UserManager) getSystemService(ImsConferenceState.USER);
        UserInfo userInfo = userManager.getUserInfo(i);
        boolean isManagedProfile = userInfo != null ? userInfo.isManagedProfile() : false;
        boolean isManagedProfile2 = userManager.isManagedProfile();
        if (isManagedProfile && !isManagedProfile2) {
            this.mProfileSwitchMessageId = R.string.forward_intent_to_owner;
        } else if (isManagedProfile || !isManagedProfile2) {
        } else {
            this.mProfileSwitchMessageId = R.string.forward_intent_to_work;
        }
    }

    private boolean supportsManagedProfiles(ResolveInfo resolveInfo) {
        try {
            return versionNumberAtLeastL(getPackageManager().getApplicationInfo(resolveInfo.activityInfo.packageName, 0).targetSdkVersion);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private boolean versionNumberAtLeastL(int i) {
        return i >= 21;
    }

    void bindProfileView() {
        DisplayResolveInfo otherProfile = this.mAdapter.getOtherProfile();
        if (otherProfile == null) {
            this.mProfileView.setVisibility(8);
            return;
        }
        this.mProfileView.setVisibility(0);
        ImageView imageView = (ImageView) this.mProfileView.findViewById(R.id.icon);
        TextView textView = (TextView) this.mProfileView.findViewById(R.id.text1);
        if (otherProfile.displayIcon == null) {
            new LoadIconTask().execute(otherProfile);
        }
        imageView.setImageDrawable(otherProfile.displayIcon);
        textView.setText(otherProfile.displayLabel);
    }

    void dismiss() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    Drawable getIcon(Resources resources, int i) {
        try {
            return resources.getDrawableForDensity(i, this.mIconDpi);
        } catch (Resources.NotFoundException e) {
            return null;
        }
    }

    public Intent getReplacementIntent(ActivityInfo activityInfo, Intent intent) {
        return intent;
    }

    protected CharSequence getTitleForAction(String str, int i) {
        ActionTitle forAction = this.mResolvingHome ? ActionTitle.HOME : ActionTitle.forAction(str);
        return (forAction != ActionTitle.DEFAULT || i == 0) ? this.mAdapter.hasFilteredItem() ? getString(forAction.namedTitleRes, new Object[]{this.mAdapter.getFilteredItem().displayLabel}) : getString(forAction.titleRes) : getString(i);
    }

    Intent intentForDisplayResolveInfo(DisplayResolveInfo displayResolveInfo) {
        Intent intent = new Intent(displayResolveInfo.origIntent != null ? displayResolveInfo.origIntent : getReplacementIntent(displayResolveInfo.ri.activityInfo, this.mIntent));
        intent.addFlags(View.SCROLLBARS_OUTSIDE_INSET);
        ActivityInfo activityInfo = displayResolveInfo.ri.activityInfo;
        intent.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
        return intent;
    }

    Drawable loadIconForResolveInfo(ResolveInfo resolveInfo) {
        Drawable icon;
        try {
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Couldn't find resources for package", e);
        }
        if (resolveInfo.resolvePackageName == null || resolveInfo.icon == 0 || (icon = getIcon(this.mPm.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon)) == null) {
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                Drawable icon2 = getIcon(this.mPm.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (icon2 != null) {
                    return icon2;
                }
            }
            return resolveInfo.loadIcon(this.mPm);
        }
        return icon;
    }

    public void onActivityStarted(Intent intent) {
    }

    public void onButtonClick(View view) {
        startSelected(this.mAlwaysUseOption ? this.mListView.getCheckedItemPosition() : this.mAdapter.getFilteredPosition(), view.getId() == 16909169, this.mAlwaysUseOption);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent makeMyIntent = makeMyIntent();
        Set<String> categories = makeMyIntent.getCategories();
        if ("android.intent.action.MAIN".equals(makeMyIntent.getAction()) && categories != null && categories.size() == 1 && categories.contains("android.intent.category.HOME")) {
            this.mResolvingHome = true;
        }
        setSafeForwardingMode(true);
        onCreate(bundle, makeMyIntent, null, 0, null, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle bundle, Intent intent, CharSequence charSequence, int i, Intent[] intentArr, List<ResolveInfo> list, boolean z) {
        boolean z2;
        int i2;
        setTheme(R.style.Theme_DeviceDefault_Resolver);
        super.onCreate(bundle);
        setProfileSwitchMessageId(intent.getContentUserHint());
        try {
            this.mLaunchedFromUid = ActivityManagerNative.getDefault().getLaunchedFromUid(getActivityToken());
        } catch (RemoteException e) {
            this.mLaunchedFromUid = -1;
        }
        this.mPm = getPackageManager();
        this.mUsm = (UsageStatsManager) getSystemService("usagestats");
        this.mStats = this.mUsm.queryAndAggregateUsageStats(System.currentTimeMillis() - USAGE_STATS_PERIOD, System.currentTimeMillis());
        this.mMaxColumns = getResources().getInteger(R.integer.config_maxResolverActivityColumns);
        this.mPackageMonitor.register(this, getMainLooper(), false);
        this.mRegistered = true;
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        this.mIconDpi = activityManager.getLauncherLargeIconDensity();
        this.mIconSize = activityManager.getLauncherLargeIconSize();
        this.mIntent = new Intent(intent);
        this.mAdapter = new ResolveListAdapter(this, intentArr, list, this.mLaunchedFromUid, z);
        if (this.mAdapter.hasFilteredItem()) {
            i2 = 17367216;
            z = false;
            z2 = true;
        } else {
            z2 = false;
            i2 = 17367215;
        }
        this.mAlwaysUseOption = z;
        if (this.mLaunchedFromUid < 0 || UserHandle.isIsolated(this.mLaunchedFromUid)) {
            finish();
            return;
        }
        int size = this.mAdapter.mList.size();
        if (size > 1 || (size == 1 && this.mAdapter.getOtherProfile() != null)) {
            setContentView(i2);
            this.mListView = (ListView) findViewById(R.id.resolver_list);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            this.mListView.setOnItemClickListener(this);
            this.mListView.setOnItemLongClickListener(new ItemLongClickListener());
            if (z) {
                this.mListView.setChoiceMode(1);
            }
            if (z2) {
                this.mListView.addHeaderView(LayoutInflater.from(this).inflate(R.layout.resolver_different_item_header, (ViewGroup) this.mListView, false));
            }
        } else if (size == 1) {
            safelyStartActivity(this.mAdapter.intentForPosition(0, false));
            this.mPackageMonitor.unregister();
            this.mRegistered = false;
            finish();
            return;
        } else {
            setContentView(R.layout.resolver_list);
            ((TextView) findViewById(R.id.empty)).setVisibility(0);
            this.mListView = (ListView) findViewById(R.id.resolver_list);
            this.mListView.setVisibility(8);
        }
        getWindow().clearFlags(65792);
        ResolverDrawerLayout resolverDrawerLayout = (ResolverDrawerLayout) findViewById(R.id.contentPanel);
        if (resolverDrawerLayout != null) {
            resolverDrawerLayout.setOnDismissedListener(new ResolverDrawerLayout.OnDismissedListener() { // from class: com.android.internal.app.ResolverActivity.2
                @Override // com.android.internal.widget.ResolverDrawerLayout.OnDismissedListener
                public void onDismissed() {
                    ResolverActivity.this.finish();
                }
            });
        }
        CharSequence charSequence2 = charSequence;
        if (charSequence == null) {
            charSequence2 = getTitleForAction(intent.getAction(), i);
        }
        if (!TextUtils.isEmpty(charSequence2)) {
            TextView textView = (TextView) findViewById(R.id.title);
            if (textView != null) {
                textView.setText(charSequence2);
            }
            setTitle(charSequence2);
        }
        ImageView imageView = (ImageView) findViewById(R.id.icon);
        DisplayResolveInfo filteredItem = this.mAdapter.getFilteredItem();
        if (imageView != null && filteredItem != null) {
            new LoadIconIntoViewTask(imageView).execute(filteredItem);
        }
        if (z || this.mAdapter.hasFilteredItem()) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.button_bar);
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
                this.mAlwaysButton = (Button) viewGroup.findViewById(R.id.button_always);
                this.mOnceButton = (Button) viewGroup.findViewById(R.id.button_once);
            } else {
                this.mAlwaysUseOption = false;
            }
        }
        if (this.mAdapter.hasFilteredItem()) {
            this.mFilteredItemContainer = (ViewGroup) findViewById(R.id.filtered_item_container);
            this.mFilteredItemContainer.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.android.internal.app.ResolverActivity.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    DisplayResolveInfo filteredItem2 = ResolverActivity.this.mAdapter.getFilteredItem();
                    if (filteredItem2 == null) {
                        return false;
                    }
                    ResolverActivity.this.showAppDetails(filteredItem2.ri);
                    return true;
                }
            });
            setAlwaysButtonEnabled(true, this.mAdapter.getFilteredPosition(), false);
            this.mOnceButton.setEnabled(true);
        }
        this.mProfileView = findViewById(R.id.profile_button);
        if (this.mProfileView != null) {
            this.mProfileView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ResolverActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DisplayResolveInfo otherProfile = ResolverActivity.this.mAdapter.getOtherProfile();
                    if (otherProfile == null) {
                        return;
                    }
                    ResolverActivity.this.onIntentSelected(otherProfile.ri, ResolverActivity.this.intentForDisplayResolveInfo(otherProfile), false);
                    ResolverActivity.this.finish();
                }
            });
            bindProfileView();
        }
    }

    protected void onCreate(Bundle bundle, Intent intent, CharSequence charSequence, Intent[] intentArr, List<ResolveInfo> list, boolean z) {
        onCreate(bundle, intent, charSequence, 0, intentArr, list, z);
    }

    protected void onIntentSelected(ResolveInfo resolveInfo, Intent intent, boolean z) {
        if ((this.mAlwaysUseOption || this.mAdapter.hasFilteredItem()) && this.mAdapter.mOrigResolveList != null) {
            IntentFilter intentFilter = new IntentFilter();
            if (intent.getAction() != null) {
                intentFilter.addAction(intent.getAction());
            }
            Set<String> categories = intent.getCategories();
            if (categories != null) {
                for (String str : categories) {
                    intentFilter.addCategory(str);
                }
            }
            intentFilter.addCategory("android.intent.category.DEFAULT");
            int i = resolveInfo.match & 268369920;
            Uri data = intent.getData();
            IntentFilter intentFilter2 = intentFilter;
            if (i == 6291456) {
                String resolveType = intent.resolveType(this);
                intentFilter2 = intentFilter;
                if (resolveType != null) {
                    try {
                        intentFilter.addDataType(resolveType);
                        intentFilter2 = intentFilter;
                    } catch (IntentFilter.MalformedMimeTypeException e) {
                        Log.w(TAG, e);
                        intentFilter2 = null;
                    }
                }
            }
            if (data != null && data.getScheme() != null && (i != 6291456 || (!"file".equals(data.getScheme()) && !l.y.equals(data.getScheme())))) {
                intentFilter2.addDataScheme(data.getScheme());
                Iterator<PatternMatcher> schemeSpecificPartsIterator = resolveInfo.filter.schemeSpecificPartsIterator();
                if (schemeSpecificPartsIterator != null) {
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    while (true) {
                        if (schemeSpecificPart == null || !schemeSpecificPartsIterator.hasNext()) {
                            break;
                        }
                        PatternMatcher next = schemeSpecificPartsIterator.next();
                        if (next.match(schemeSpecificPart)) {
                            intentFilter2.addDataSchemeSpecificPart(next.getPath(), next.getType());
                            break;
                        }
                    }
                }
                Iterator<IntentFilter.AuthorityEntry> authoritiesIterator = resolveInfo.filter.authoritiesIterator();
                if (authoritiesIterator != null) {
                    while (true) {
                        if (!authoritiesIterator.hasNext()) {
                            break;
                        }
                        IntentFilter.AuthorityEntry next2 = authoritiesIterator.next();
                        if (next2.match(data) >= 0) {
                            int port = next2.getPort();
                            intentFilter2.addDataAuthority(next2.getHost(), port >= 0 ? Integer.toString(port) : null);
                        }
                    }
                }
                Iterator<PatternMatcher> pathsIterator = resolveInfo.filter.pathsIterator();
                if (pathsIterator != null) {
                    String path = data.getPath();
                    while (true) {
                        if (path == null || !pathsIterator.hasNext()) {
                            break;
                        }
                        PatternMatcher next3 = pathsIterator.next();
                        if (next3.match(path)) {
                            intentFilter2.addDataPath(next3.getPath(), next3.getType());
                            break;
                        }
                    }
                }
            }
            if (intentFilter2 != null) {
                int size = this.mAdapter.mOrigResolveList.size();
                ComponentName[] componentNameArr = new ComponentName[size];
                int i2 = 0;
                int i3 = 0;
                while (i3 < size) {
                    ResolveInfo resolveInfo2 = this.mAdapter.mOrigResolveList.get(i3);
                    componentNameArr[i3] = new ComponentName(resolveInfo2.activityInfo.packageName, resolveInfo2.activityInfo.name);
                    int i4 = i2;
                    if (resolveInfo2.match > i2) {
                        i4 = resolveInfo2.match;
                    }
                    i3++;
                    i2 = i4;
                }
                if (z) {
                    getPackageManager().addPreferredActivity(intentFilter2, i2, componentNameArr, intent.getComponent());
                } else {
                    try {
                        AppGlobals.getPackageManager().setLastChosenActivity(intent, intent.resolveTypeIfNeeded(getContentResolver()), 65536, intentFilter2, i2, intent.getComponent());
                    } catch (RemoteException e2) {
                        Log.d(TAG, "Error calling setLastChosenActivity\n" + e2);
                    }
                }
            }
        }
        if (intent != null) {
            safelyStartActivity(intent);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.mListView.getHeaderViewsCount();
        if (headerViewsCount < 0) {
            return;
        }
        ResolveInfo resolveInfoForPosition = this.mAdapter.resolveInfoForPosition(headerViewsCount, true);
        if (this.mResolvingHome && hasManagedProfile() && !supportsManagedProfiles(resolveInfoForPosition)) {
            Toast.makeText(this, String.format(getResources().getString(R.string.activity_resolver_work_profiles_support), resolveInfoForPosition.activityInfo.loadLabel(getPackageManager()).toString()), 1).show();
            return;
        }
        int checkedItemPosition = this.mListView.getCheckedItemPosition();
        boolean z = checkedItemPosition != -1;
        if (!this.mAlwaysUseOption || (z && this.mLastSelected == checkedItemPosition)) {
            startSelected(headerViewsCount, false, true);
            return;
        }
        setAlwaysButtonEnabled(z, checkedItemPosition, true);
        this.mOnceButton.setEnabled(z);
        if (z) {
            this.mListView.smoothScrollToPosition(checkedItemPosition);
        }
        this.mLastSelected = checkedItemPosition;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.mRegistered) {
            this.mPackageMonitor.register(this, getMainLooper(), false);
            this.mRegistered = true;
        }
        this.mAdapter.handlePackagesChanged();
        if (this.mProfileView != null) {
            bindProfileView();
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (this.mAlwaysUseOption) {
            int checkedItemPosition = this.mListView.getCheckedItemPosition();
            boolean z = checkedItemPosition != -1;
            this.mLastSelected = checkedItemPosition;
            setAlwaysButtonEnabled(z, checkedItemPosition, true);
            this.mOnceButton.setEnabled(z);
            if (z) {
                this.mListView.setSelection(checkedItemPosition);
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (this.mRegistered) {
            this.mPackageMonitor.unregister();
            this.mRegistered = false;
        }
        if ((getIntent().getFlags() & 268435456) == 0 || isChangingConfigurations()) {
            return;
        }
        finish();
    }

    public void safelyStartActivity(Intent intent) {
        String str;
        if (this.mProfileSwitchMessageId != -1) {
            Toast.makeText(this, getString(this.mProfileSwitchMessageId), 1).show();
        }
        if (!this.mSafeForwardingMode) {
            startActivity(intent);
            onActivityStarted(intent);
            return;
        }
        try {
            startActivityAsCaller(intent, null, -10000);
            onActivityStarted(intent);
        } catch (RuntimeException e) {
            try {
                str = ActivityManagerNative.getDefault().getLaunchedFromPackage(getActivityToken());
            } catch (RemoteException e2) {
                str = "??";
            }
            Slog.wtf(TAG, "Unable to launch as uid " + this.mLaunchedFromUid + " package " + str + ", while running in " + ActivityThread.currentProcessName(), e);
        }
    }

    public void setSafeForwardingMode(boolean z) {
        this.mSafeForwardingMode = z;
    }

    void showAppDetails(ResolveInfo resolveInfo) {
        startActivity(new Intent().setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", resolveInfo.activityInfo.packageName, null)).addFlags(524288));
    }

    void startSelected(int i, boolean z, boolean z2) {
        if (isFinishing()) {
            return;
        }
        onIntentSelected(this.mAdapter.resolveInfoForPosition(i, z2), this.mAdapter.intentForPosition(i, z2), z);
        finish();
    }
}
