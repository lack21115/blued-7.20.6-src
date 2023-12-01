package android.app;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/app/TabActivity.class */
public class TabActivity extends ActivityGroup {
    private String mDefaultTab = null;
    private int mDefaultTabIndex = -1;
    private TabHost mTabHost;

    private void ensureTabHost() {
        if (this.mTabHost == null) {
            setContentView(17367251);
        }
    }

    public TabHost getTabHost() {
        ensureTabHost();
        return this.mTabHost;
    }

    public TabWidget getTabWidget() {
        return this.mTabHost.getTabWidget();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
        View currentTabView;
        if (getLocalActivityManager().getCurrentActivity() == activity && (currentTabView = this.mTabHost.getCurrentTabView()) != null && (currentTabView instanceof TextView)) {
            ((TextView) currentTabView).setText(charSequence);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.mTabHost = (TabHost) findViewById(R.id.tabhost);
        if (this.mTabHost == null) {
            throw new RuntimeException("Your content must have a TabHost whose id attribute is 'android.R.id.tabhost'");
        }
        this.mTabHost.setup(getLocalActivityManager());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ensureTabHost();
        if (this.mTabHost.getCurrentTab() == -1) {
            this.mTabHost.setCurrentTab(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        ensureTabHost();
        String string = bundle.getString("currentTab");
        if (string != null) {
            this.mTabHost.setCurrentTabByTag(string);
        }
        if (this.mTabHost.getCurrentTab() < 0) {
            if (this.mDefaultTab != null) {
                this.mTabHost.setCurrentTabByTag(this.mDefaultTab);
            } else if (this.mDefaultTabIndex >= 0) {
                this.mTabHost.setCurrentTab(this.mDefaultTabIndex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.ActivityGroup, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        String currentTabTag = this.mTabHost.getCurrentTabTag();
        if (currentTabTag != null) {
            bundle.putString("currentTab", currentTabTag);
        }
    }

    public void setDefaultTab(int i) {
        this.mDefaultTab = null;
        this.mDefaultTabIndex = i;
    }

    public void setDefaultTab(String str) {
        this.mDefaultTab = str;
        this.mDefaultTabIndex = -1;
    }
}
