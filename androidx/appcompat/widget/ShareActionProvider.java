package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ShareActionProvider.class */
public class ShareActionProvider extends ActionProvider {
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";

    /* renamed from: a  reason: collision with root package name */
    final Context f1836a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    OnShareTargetSelectedListener f1837c;
    private int d;
    private final ShareMenuItemOnMenuItemClickListener e;
    private ActivityChooserModel.OnChooseActivityListener f;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ShareActionProvider$OnShareTargetSelectedListener.class */
    public interface OnShareTargetSelectedListener {
        boolean onShareTargetSelected(ShareActionProvider shareActionProvider, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ShareActionProvider$ShareActivityChooserModelPolicy.class */
    public class ShareActivityChooserModelPolicy implements ActivityChooserModel.OnChooseActivityListener {
        ShareActivityChooserModelPolicy() {
        }

        @Override // androidx.appcompat.widget.ActivityChooserModel.OnChooseActivityListener
        public boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent) {
            if (ShareActionProvider.this.f1837c != null) {
                ShareActionProvider.this.f1837c.onShareTargetSelected(ShareActionProvider.this, intent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/ShareActionProvider$ShareMenuItemOnMenuItemClickListener.class */
    class ShareMenuItemOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener {
        ShareMenuItemOnMenuItemClickListener() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            Tracker.onMenuItemClick(menuItem);
            Intent chooseActivity = ActivityChooserModel.get(ShareActionProvider.this.f1836a, ShareActionProvider.this.b).chooseActivity(menuItem.getItemId());
            if (chooseActivity != null) {
                String action = chooseActivity.getAction();
                if (Intent.ACTION_SEND.equals(action) || Intent.ACTION_SEND_MULTIPLE.equals(action)) {
                    ShareActionProvider.this.a(chooseActivity);
                }
                ShareActionProvider.this.f1836a.startActivity(chooseActivity);
                return true;
            }
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.d = 4;
        this.e = new ShareMenuItemOnMenuItemClickListener();
        this.b = DEFAULT_SHARE_HISTORY_FILE_NAME;
        this.f1836a = context;
    }

    private void a() {
        if (this.f1837c == null) {
            return;
        }
        if (this.f == null) {
            this.f = new ShareActivityChooserModelPolicy();
        }
        ActivityChooserModel.get(this.f1836a, this.b).setOnChooseActivityListener(this.f);
    }

    void a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }

    @Override // androidx.core.view.ActionProvider
    public boolean hasSubMenu() {
        return true;
    }

    @Override // androidx.core.view.ActionProvider
    public View onCreateActionView() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f1836a);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(ActivityChooserModel.get(this.f1836a, this.b));
        }
        TypedValue typedValue = new TypedValue();
        this.f1836a.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(AppCompatResources.getDrawable(this.f1836a, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.ActionProvider
    public void onPrepareSubMenu(SubMenu subMenu) {
        subMenu.clear();
        ActivityChooserModel activityChooserModel = ActivityChooserModel.get(this.f1836a, this.b);
        PackageManager packageManager = this.f1836a.getPackageManager();
        int activityCount = activityChooserModel.getActivityCount();
        int min = Math.min(activityCount, this.d);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= min) {
                break;
            }
            ResolveInfo activity = activityChooserModel.getActivity(i2);
            subMenu.add(0, i2, i2, activity.loadLabel(packageManager)).setIcon(activity.loadIcon(packageManager)).setOnMenuItemClickListener(this.e);
            i = i2 + 1;
        }
        if (min >= activityCount) {
            return;
        }
        SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.f1836a.getString(R.string.abc_activity_chooser_view_see_all));
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= activityCount) {
                return;
            }
            ResolveInfo activity2 = activityChooserModel.getActivity(i4);
            addSubMenu.add(0, i4, i4, activity2.loadLabel(packageManager)).setIcon(activity2.loadIcon(packageManager)).setOnMenuItemClickListener(this.e);
            i3 = i4 + 1;
        }
    }

    public void setOnShareTargetSelectedListener(OnShareTargetSelectedListener onShareTargetSelectedListener) {
        this.f1837c = onShareTargetSelectedListener;
        a();
    }

    public void setShareHistoryFileName(String str) {
        this.b = str;
        a();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (Intent.ACTION_SEND.equals(action) || Intent.ACTION_SEND_MULTIPLE.equals(action)) {
                a(intent);
            }
        }
        ActivityChooserModel.get(this.f1836a, this.b).setIntent(intent);
    }
}
