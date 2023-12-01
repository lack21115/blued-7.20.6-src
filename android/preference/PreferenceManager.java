package android.preference;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceManager.class */
public class PreferenceManager {
    public static final String KEY_HAS_SET_DEFAULT_VALUES = "_has_set_default_values";
    public static final String METADATA_KEY_PREFERENCES = "android.preference";
    private static final String TAG = "PreferenceManager";
    private Activity mActivity;
    private List<OnActivityDestroyListener> mActivityDestroyListeners;
    private List<OnActivityResultListener> mActivityResultListeners;
    private List<OnActivityStopListener> mActivityStopListeners;
    private Context mContext;
    private SharedPreferences.Editor mEditor;
    private PreferenceFragment mFragment;
    private long mNextId = 0;
    private int mNextRequestCode;
    private boolean mNoCommit;
    private OnPreferenceTreeClickListener mOnPreferenceTreeClickListener;
    private PreferenceScreen mPreferenceScreen;
    private List<DialogInterface> mPreferencesScreens;
    private SharedPreferences mSharedPreferences;
    private int mSharedPreferencesMode;
    private String mSharedPreferencesName;

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceManager$OnActivityDestroyListener.class */
    public interface OnActivityDestroyListener {
        void onActivityDestroy();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceManager$OnActivityResultListener.class */
    public interface OnActivityResultListener {
        boolean onActivityResult(int i, int i2, Intent intent);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceManager$OnActivityStopListener.class */
    public interface OnActivityStopListener {
        void onActivityStop();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceManager$OnPreferenceTreeClickListener.class */
    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference);
    }

    public PreferenceManager(Activity activity, int i) {
        this.mActivity = activity;
        this.mNextRequestCode = i;
        init(activity);
    }

    PreferenceManager(Context context) {
        init(context);
    }

    private void dismissAllScreens() {
        synchronized (this) {
            if (this.mPreferencesScreens == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mPreferencesScreens);
            this.mPreferencesScreens.clear();
            int size = arrayList.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    return;
                }
                ((DialogInterface) arrayList.get(i)).dismiss();
                size = i;
            }
        }
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode());
    }

    private static int getDefaultSharedPreferencesMode() {
        return 0;
    }

    private static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void init(Context context) {
        this.mContext = context;
        setSharedPreferencesName(getDefaultSharedPreferencesName(context));
    }

    private List<ResolveInfo> queryIntentActivities(Intent intent) {
        return this.mContext.getPackageManager().queryIntentActivities(intent, 128);
    }

    public static void setDefaultValues(Context context, int i, boolean z) {
        setDefaultValues(context, getDefaultSharedPreferencesName(context), getDefaultSharedPreferencesMode(), i, z);
    }

    public static void setDefaultValues(Context context, String str, int i, int i2, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEY_HAS_SET_DEFAULT_VALUES, 0);
        if (z || !sharedPreferences.getBoolean(KEY_HAS_SET_DEFAULT_VALUES, false)) {
            PreferenceManager preferenceManager = new PreferenceManager(context);
            preferenceManager.setSharedPreferencesName(str);
            preferenceManager.setSharedPreferencesMode(i);
            preferenceManager.inflateFromResource(context, i2, null);
            SharedPreferences.Editor putBoolean = sharedPreferences.edit().putBoolean(KEY_HAS_SET_DEFAULT_VALUES, true);
            try {
                putBoolean.apply();
            } catch (AbstractMethodError e) {
                putBoolean.commit();
            }
        }
    }

    private void setNoCommit(boolean z) {
        if (!z && this.mEditor != null) {
            try {
                this.mEditor.apply();
            } catch (AbstractMethodError e) {
                this.mEditor.commit();
            }
        }
        this.mNoCommit = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPreferencesScreen(DialogInterface dialogInterface) {
        synchronized (this) {
            if (this.mPreferencesScreens == null) {
                this.mPreferencesScreens = new ArrayList();
            }
            this.mPreferencesScreens.add(dialogInterface);
        }
    }

    public PreferenceScreen createPreferenceScreen(Context context) {
        PreferenceScreen preferenceScreen = new PreferenceScreen(context, null);
        preferenceScreen.onAttachedToHierarchy(this);
        return preferenceScreen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityDestroy() {
        ArrayList arrayList = null;
        synchronized (this) {
            if (this.mActivityDestroyListeners != null) {
                arrayList = new ArrayList(this.mActivityDestroyListeners);
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ((OnActivityDestroyListener) arrayList.get(i2)).onActivityDestroy();
                i = i2 + 1;
            }
        }
        dismissAllScreens();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityResult(int i, int i2, Intent intent) {
        synchronized (this) {
            if (this.mActivityResultListeners == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mActivityResultListeners);
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size || ((OnActivityResultListener) arrayList.get(i4)).onActivityResult(i, i2, intent)) {
                    return;
                }
                i3 = i4 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchActivityStop() {
        synchronized (this) {
            if (this.mActivityStopListeners == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.mActivityStopListeners);
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return;
                }
                ((OnActivityStopListener) arrayList.get(i2)).onActivityStop();
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchNewIntent(Intent intent) {
        dismissAllScreens();
    }

    public Preference findPreference(CharSequence charSequence) {
        if (this.mPreferenceScreen == null) {
            return null;
        }
        return this.mPreferenceScreen.findPreference(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity getActivity() {
        return this.mActivity;
    }

    Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPreferences.Editor getEditor() {
        if (this.mNoCommit) {
            if (this.mEditor == null) {
                this.mEditor = getSharedPreferences().edit();
            }
            return this.mEditor;
        }
        return getSharedPreferences().edit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreferenceFragment getFragment() {
        return this.mFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNextId() {
        long j;
        synchronized (this) {
            j = this.mNextId;
            this.mNextId = 1 + j;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextRequestCode() {
        int i;
        synchronized (this) {
            i = this.mNextRequestCode;
            this.mNextRequestCode = i + 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnPreferenceTreeClickListener getOnPreferenceTreeClickListener() {
        return this.mOnPreferenceTreeClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreferenceScreen getPreferenceScreen() {
        return this.mPreferenceScreen;
    }

    public SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences(this.mSharedPreferencesName, this.mSharedPreferencesMode);
        }
        return this.mSharedPreferences;
    }

    public int getSharedPreferencesMode() {
        return this.mSharedPreferencesMode;
    }

    public String getSharedPreferencesName() {
        return this.mSharedPreferencesName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PreferenceScreen inflateFromIntent(Intent intent, PreferenceScreen preferenceScreen) {
        List<ResolveInfo> queryIntentActivities = queryIntentActivities(intent);
        HashSet hashSet = new HashSet();
        int size = queryIntentActivities.size() - 1;
        while (size >= 0) {
            ActivityInfo activityInfo = queryIntentActivities.get(size).activityInfo;
            Bundle bundle = activityInfo.metaData;
            PreferenceScreen preferenceScreen2 = preferenceScreen;
            if (bundle != null) {
                if (bundle.containsKey(METADATA_KEY_PREFERENCES)) {
                    String str = activityInfo.packageName + ":" + activityInfo.metaData.getInt(METADATA_KEY_PREFERENCES);
                    preferenceScreen2 = preferenceScreen;
                    if (!hashSet.contains(str)) {
                        hashSet.add(str);
                        try {
                            Context createPackageContext = this.mContext.createPackageContext(activityInfo.packageName, 0);
                            PreferenceInflater preferenceInflater = new PreferenceInflater(createPackageContext, this);
                            XmlResourceParser loadXmlMetaData = activityInfo.loadXmlMetaData(createPackageContext.getPackageManager(), METADATA_KEY_PREFERENCES);
                            preferenceScreen2 = (PreferenceScreen) preferenceInflater.inflate((XmlPullParser) loadXmlMetaData, (XmlResourceParser) preferenceScreen, true);
                            loadXmlMetaData.close();
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.w(TAG, "Could not create context for " + activityInfo.packageName + ": " + Log.getStackTraceString(e));
                            preferenceScreen2 = preferenceScreen;
                        }
                    }
                } else {
                    preferenceScreen2 = preferenceScreen;
                }
            }
            size--;
            preferenceScreen = preferenceScreen2;
        }
        preferenceScreen.onAttachedToHierarchy(this);
        return preferenceScreen;
    }

    public PreferenceScreen inflateFromResource(Context context, int i, PreferenceScreen preferenceScreen) {
        setNoCommit(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).inflate(i, (int) preferenceScreen, true);
        preferenceScreen2.onAttachedToHierarchy(this);
        setNoCommit(false);
        return preferenceScreen2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerOnActivityDestroyListener(OnActivityDestroyListener onActivityDestroyListener) {
        synchronized (this) {
            if (this.mActivityDestroyListeners == null) {
                this.mActivityDestroyListeners = new ArrayList();
            }
            if (!this.mActivityDestroyListeners.contains(onActivityDestroyListener)) {
                this.mActivityDestroyListeners.add(onActivityDestroyListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerOnActivityResultListener(OnActivityResultListener onActivityResultListener) {
        synchronized (this) {
            if (this.mActivityResultListeners == null) {
                this.mActivityResultListeners = new ArrayList();
            }
            if (!this.mActivityResultListeners.contains(onActivityResultListener)) {
                this.mActivityResultListeners.add(onActivityResultListener);
            }
        }
    }

    public void registerOnActivityStopListener(OnActivityStopListener onActivityStopListener) {
        synchronized (this) {
            if (this.mActivityStopListeners == null) {
                this.mActivityStopListeners = new ArrayList();
            }
            if (!this.mActivityStopListeners.contains(onActivityStopListener)) {
                this.mActivityStopListeners.add(onActivityStopListener);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removePreferencesScreen(DialogInterface dialogInterface) {
        synchronized (this) {
            if (this.mPreferencesScreens == null) {
                return;
            }
            this.mPreferencesScreens.remove(dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFragment(PreferenceFragment preferenceFragment) {
        this.mFragment = preferenceFragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPreferenceTreeClickListener(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.mOnPreferenceTreeClickListener = onPreferenceTreeClickListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setPreferences(PreferenceScreen preferenceScreen) {
        if (preferenceScreen != this.mPreferenceScreen) {
            this.mPreferenceScreen = preferenceScreen;
            return true;
        }
        return false;
    }

    public void setSharedPreferencesMode(int i) {
        this.mSharedPreferencesMode = i;
        this.mSharedPreferences = null;
    }

    public void setSharedPreferencesName(String str) {
        this.mSharedPreferencesName = str;
        this.mSharedPreferences = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldCommit() {
        return !this.mNoCommit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void unregisterOnActivityDestroyListener(OnActivityDestroyListener onActivityDestroyListener) {
        synchronized (this) {
            if (this.mActivityDestroyListeners != null) {
                this.mActivityDestroyListeners.remove(onActivityDestroyListener);
            }
        }
    }

    void unregisterOnActivityResultListener(OnActivityResultListener onActivityResultListener) {
        synchronized (this) {
            if (this.mActivityResultListeners != null) {
                this.mActivityResultListeners.remove(onActivityResultListener);
            }
        }
    }

    public void unregisterOnActivityStopListener(OnActivityStopListener onActivityStopListener) {
        synchronized (this) {
            if (this.mActivityStopListeners != null) {
                this.mActivityStopListeners.remove(onActivityStopListener);
            }
        }
    }
}
