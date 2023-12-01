package com.android.internal.app;

import android.app.Activity;
import android.app.ActivityManagerNative;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/app/HeavyWeightSwitcherActivity.class */
public class HeavyWeightSwitcherActivity extends Activity {
    public static final String KEY_CUR_APP = "cur_app";
    public static final String KEY_CUR_TASK = "cur_task";
    public static final String KEY_HAS_RESULT = "has_result";
    public static final String KEY_INTENT = "intent";
    public static final String KEY_NEW_APP = "new_app";
    String mCurApp;
    int mCurTask;
    boolean mHasResult;
    String mNewApp;
    IntentSender mStartIntent;
    private View.OnClickListener mSwitchOldListener = new View.OnClickListener() { // from class: com.android.internal.app.HeavyWeightSwitcherActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ActivityManagerNative.getDefault().moveTaskToFront(HeavyWeightSwitcherActivity.this.mCurTask, 0, (Bundle) null);
            } catch (RemoteException e) {
            }
            HeavyWeightSwitcherActivity.this.finish();
        }
    };
    private View.OnClickListener mSwitchNewListener = new View.OnClickListener() { // from class: com.android.internal.app.HeavyWeightSwitcherActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                ActivityManagerNative.getDefault().finishHeavyWeightApp();
            } catch (RemoteException e) {
            }
            try {
                if (HeavyWeightSwitcherActivity.this.mHasResult) {
                    HeavyWeightSwitcherActivity.this.startIntentSenderForResult(HeavyWeightSwitcherActivity.this.mStartIntent, -1, null, 33554432, 33554432, 0);
                } else {
                    HeavyWeightSwitcherActivity.this.startIntentSenderForResult(HeavyWeightSwitcherActivity.this.mStartIntent, -1, null, 0, 0, 0);
                }
            } catch (IntentSender.SendIntentException e2) {
                Log.w("HeavyWeightSwitcherActivity", "Failure starting", e2);
            }
            HeavyWeightSwitcherActivity.this.finish();
        }
    };
    private View.OnClickListener mCancelListener = new View.OnClickListener() { // from class: com.android.internal.app.HeavyWeightSwitcherActivity.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HeavyWeightSwitcherActivity.this.finish();
        }
    };

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(3);
        this.mStartIntent = (IntentSender) getIntent().getParcelableExtra(KEY_INTENT);
        this.mHasResult = getIntent().getBooleanExtra(KEY_HAS_RESULT, false);
        this.mCurApp = getIntent().getStringExtra(KEY_CUR_APP);
        this.mCurTask = getIntent().getIntExtra(KEY_CUR_TASK, 0);
        this.mNewApp = getIntent().getStringExtra(KEY_NEW_APP);
        setContentView(R.layout.heavy_weight_switcher);
        setIconAndText(R.id.old_app_icon, R.id.old_app_action, R.id.old_app_description, this.mCurApp, R.string.old_app_action, R.string.old_app_description);
        setIconAndText(R.id.new_app_icon, R.id.new_app_action, R.id.new_app_description, this.mNewApp, R.string.new_app_action, R.string.new_app_description);
        findViewById(R.id.switch_old).setOnClickListener(this.mSwitchOldListener);
        findViewById(R.id.switch_new).setOnClickListener(this.mSwitchNewListener);
        findViewById(R.id.cancel).setOnClickListener(this.mCancelListener);
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.alertDialogIcon, typedValue, true);
        getWindow().setFeatureDrawableResource(3, typedValue.resourceId);
    }

    void setDrawable(int i, Drawable drawable) {
        if (drawable != null) {
            ((ImageView) findViewById(i)).setImageDrawable(drawable);
        }
    }

    void setIconAndText(int i, int i2, int i3, String str, int i4, int i5) {
        Drawable drawable = null;
        CharSequence charSequence = "";
        if (this.mCurApp != null) {
            charSequence = "";
            try {
                ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(str, 0);
                CharSequence loadLabel = applicationInfo.loadLabel(getPackageManager());
                charSequence = loadLabel;
                drawable = applicationInfo.loadIcon(getPackageManager());
                charSequence = loadLabel;
            } catch (PackageManager.NameNotFoundException e) {
                drawable = null;
            }
        }
        setDrawable(i, drawable);
        setText(i2, getString(i4, new Object[]{charSequence}));
        setText(i3, getText(i5));
    }

    void setText(int i, CharSequence charSequence) {
        ((TextView) findViewById(i)).setText(charSequence);
    }
}
