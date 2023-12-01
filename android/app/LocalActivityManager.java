package android.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import com.android.internal.content.ReferrerIntent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-9557208-dex2jar.jar:android/app/LocalActivityManager.class */
public class LocalActivityManager {
    static final int CREATED = 2;
    static final int DESTROYED = 5;
    static final int INITIALIZING = 1;
    static final int RESTORED = 0;
    static final int RESUMED = 4;
    static final int STARTED = 3;
    private static final String TAG = "LocalActivityManager";
    private static final boolean localLOGV = false;
    private boolean mFinishing;
    private final Activity mParent;
    private LocalActivityRecord mResumed;
    private boolean mSingleMode;
    private final Map<String, LocalActivityRecord> mActivities = new HashMap();
    private final ArrayList<LocalActivityRecord> mActivityArray = new ArrayList<>();
    private int mCurState = 1;
    private final ActivityThread mActivityThread = ActivityThread.currentActivityThread();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/app/LocalActivityManager$LocalActivityRecord.class */
    public static class LocalActivityRecord extends Binder {
        Activity activity;
        ActivityInfo activityInfo;
        int curState = 0;
        final String id;
        Bundle instanceState;
        Intent intent;
        Window window;

        LocalActivityRecord(String str, Intent intent) {
            this.id = str;
            this.intent = intent;
        }
    }

    public LocalActivityManager(Activity activity, boolean z) {
        this.mParent = activity;
        this.mSingleMode = z;
    }

    private void moveToState(LocalActivityRecord localActivityRecord, int i) {
        if (localActivityRecord.curState == 0 || localActivityRecord.curState == 5) {
            return;
        }
        if (localActivityRecord.curState == 1) {
            HashMap<String, Object> lastNonConfigurationChildInstances = this.mParent.getLastNonConfigurationChildInstances();
            Object obj = null;
            if (lastNonConfigurationChildInstances != null) {
                obj = lastNonConfigurationChildInstances.get(localActivityRecord.id);
            }
            Activity.NonConfigurationInstances nonConfigurationInstances = null;
            if (obj != null) {
                nonConfigurationInstances = new Activity.NonConfigurationInstances();
                nonConfigurationInstances.activity = obj;
            }
            if (localActivityRecord.activityInfo == null) {
                localActivityRecord.activityInfo = this.mActivityThread.resolveActivityInfo(localActivityRecord.intent);
            }
            localActivityRecord.activity = this.mActivityThread.startActivityNow(this.mParent, localActivityRecord.id, localActivityRecord.intent, localActivityRecord.activityInfo, localActivityRecord, localActivityRecord.instanceState, nonConfigurationInstances);
            if (localActivityRecord.activity != null) {
                localActivityRecord.window = localActivityRecord.activity.getWindow();
                localActivityRecord.instanceState = null;
                localActivityRecord.curState = 3;
                if (i == 4) {
                    this.mActivityThread.performResumeActivity(localActivityRecord, true);
                    localActivityRecord.curState = 4;
                    return;
                }
                return;
            }
            return;
        }
        switch (localActivityRecord.curState) {
            case 2:
                if (i == 3) {
                    this.mActivityThread.performRestartActivity(localActivityRecord);
                    localActivityRecord.curState = 3;
                }
                if (i == 4) {
                    this.mActivityThread.performRestartActivity(localActivityRecord);
                    this.mActivityThread.performResumeActivity(localActivityRecord, true);
                    localActivityRecord.curState = 4;
                    return;
                }
                return;
            case 3:
                if (i == 4) {
                    this.mActivityThread.performResumeActivity(localActivityRecord, true);
                    localActivityRecord.instanceState = null;
                    localActivityRecord.curState = 4;
                }
                if (i == 2) {
                    this.mActivityThread.performStopActivity(localActivityRecord, false);
                    localActivityRecord.curState = 2;
                    return;
                }
                return;
            case 4:
                if (i == 3) {
                    performPause(localActivityRecord, this.mFinishing);
                    localActivityRecord.curState = 3;
                }
                if (i == 2) {
                    performPause(localActivityRecord, this.mFinishing);
                    this.mActivityThread.performStopActivity(localActivityRecord, false);
                    localActivityRecord.curState = 2;
                    return;
                }
                return;
            default:
                return;
        }
    }

    private Window performDestroy(LocalActivityRecord localActivityRecord, boolean z) {
        Window window = localActivityRecord.window;
        if (localActivityRecord.curState == 4 && !z) {
            performPause(localActivityRecord, z);
        }
        this.mActivityThread.performDestroyActivity(localActivityRecord, z);
        localActivityRecord.activity = null;
        localActivityRecord.window = null;
        if (z) {
            localActivityRecord.instanceState = null;
        }
        localActivityRecord.curState = 5;
        return window;
    }

    private void performPause(LocalActivityRecord localActivityRecord, boolean z) {
        boolean z2 = localActivityRecord.instanceState == null;
        Bundle performPauseActivity = this.mActivityThread.performPauseActivity(localActivityRecord, z, z2);
        if (z2) {
            localActivityRecord.instanceState = performPauseActivity;
        }
    }

    public Window destroyActivity(String str, boolean z) {
        LocalActivityRecord localActivityRecord = this.mActivities.get(str);
        Window window = null;
        if (localActivityRecord != null) {
            Window performDestroy = performDestroy(localActivityRecord, z);
            window = performDestroy;
            if (z) {
                this.mActivities.remove(str);
                this.mActivityArray.remove(localActivityRecord);
                window = performDestroy;
            }
        }
        return window;
    }

    public void dispatchCreate(Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                try {
                    Bundle bundle2 = bundle.getBundle(str);
                    LocalActivityRecord localActivityRecord = this.mActivities.get(str);
                    if (localActivityRecord != null) {
                        localActivityRecord.instanceState = bundle2;
                    } else {
                        LocalActivityRecord localActivityRecord2 = new LocalActivityRecord(str, null);
                        localActivityRecord2.instanceState = bundle2;
                        this.mActivities.put(str, localActivityRecord2);
                        this.mActivityArray.add(localActivityRecord2);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Exception thrown when restoring LocalActivityManager state", e);
                }
            }
        }
        this.mCurState = 2;
    }

    public void dispatchDestroy(boolean z) {
        int size = this.mActivityArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.mActivities.clear();
                this.mActivityArray.clear();
                return;
            }
            this.mActivityThread.performDestroyActivity(this.mActivityArray.get(i2), z);
            i = i2 + 1;
        }
    }

    public void dispatchPause(boolean z) {
        if (z) {
            this.mFinishing = true;
        }
        this.mCurState = 3;
        if (this.mSingleMode) {
            if (this.mResumed != null) {
                moveToState(this.mResumed, 3);
                return;
            }
            return;
        }
        int size = this.mActivityArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            LocalActivityRecord localActivityRecord = this.mActivityArray.get(i2);
            if (localActivityRecord.curState == 4) {
                moveToState(localActivityRecord, 3);
            }
            i = i2 + 1;
        }
    }

    public void dispatchResume() {
        this.mCurState = 4;
        if (this.mSingleMode) {
            if (this.mResumed != null) {
                moveToState(this.mResumed, 4);
                return;
            }
            return;
        }
        int size = this.mActivityArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            moveToState(this.mActivityArray.get(i2), 4);
            i = i2 + 1;
        }
    }

    public HashMap<String, Object> dispatchRetainNonConfigurationInstance() {
        HashMap<String, Object> hashMap = null;
        int size = this.mActivityArray.size();
        int i = 0;
        while (i < size) {
            LocalActivityRecord localActivityRecord = this.mActivityArray.get(i);
            HashMap<String, Object> hashMap2 = hashMap;
            if (localActivityRecord != null) {
                hashMap2 = hashMap;
                if (localActivityRecord.activity != null) {
                    Object onRetainNonConfigurationInstance = localActivityRecord.activity.onRetainNonConfigurationInstance();
                    hashMap2 = hashMap;
                    if (onRetainNonConfigurationInstance != null) {
                        hashMap2 = hashMap;
                        if (hashMap == null) {
                            hashMap2 = new HashMap<>();
                        }
                        hashMap2.put(localActivityRecord.id, onRetainNonConfigurationInstance);
                    }
                }
            }
            i++;
            hashMap = hashMap2;
        }
        return hashMap;
    }

    public void dispatchStop() {
        this.mCurState = 2;
        int size = this.mActivityArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            moveToState(this.mActivityArray.get(i2), 2);
            i = i2 + 1;
        }
    }

    public Activity getActivity(String str) {
        LocalActivityRecord localActivityRecord = this.mActivities.get(str);
        if (localActivityRecord != null) {
            return localActivityRecord.activity;
        }
        return null;
    }

    public Activity getCurrentActivity() {
        if (this.mResumed != null) {
            return this.mResumed.activity;
        }
        return null;
    }

    public String getCurrentId() {
        if (this.mResumed != null) {
            return this.mResumed.id;
        }
        return null;
    }

    public void removeAllActivities() {
        dispatchDestroy(true);
    }

    public Bundle saveInstanceState() {
        Bundle bundle = null;
        int size = this.mActivityArray.size();
        int i = 0;
        while (i < size) {
            LocalActivityRecord localActivityRecord = this.mActivityArray.get(i);
            Bundle bundle2 = bundle;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            if ((localActivityRecord.instanceState != null || localActivityRecord.curState == 4) && localActivityRecord.activity != null) {
                Bundle bundle3 = new Bundle();
                localActivityRecord.activity.performSaveInstanceState(bundle3);
                localActivityRecord.instanceState = bundle3;
            }
            if (localActivityRecord.instanceState != null) {
                bundle2.putBundle(localActivityRecord.id, localActivityRecord.instanceState);
            }
            i++;
            bundle = bundle2;
        }
        return bundle;
    }

    public Window startActivity(String str, Intent intent) {
        ActivityInfo activityInfo;
        boolean z;
        LocalActivityRecord localActivityRecord;
        LocalActivityRecord localActivityRecord2;
        if (this.mCurState == 1) {
            throw new IllegalStateException("Activities can't be added until the containing group has been created.");
        }
        boolean z2 = false;
        LocalActivityRecord localActivityRecord3 = this.mActivities.get(str);
        if (localActivityRecord3 == null) {
            localActivityRecord = new LocalActivityRecord(str, intent);
            z = true;
            activityInfo = null;
        } else {
            activityInfo = null;
            z = false;
            localActivityRecord = localActivityRecord3;
            if (localActivityRecord3.intent != null) {
                boolean filterEquals = localActivityRecord3.intent.filterEquals(intent);
                activityInfo = null;
                z = false;
                localActivityRecord = localActivityRecord3;
                z2 = filterEquals;
                if (filterEquals) {
                    activityInfo = localActivityRecord3.activityInfo;
                    z = false;
                    localActivityRecord = localActivityRecord3;
                    z2 = filterEquals;
                }
            }
        }
        ActivityInfo activityInfo2 = activityInfo;
        if (activityInfo == null) {
            activityInfo2 = this.mActivityThread.resolveActivityInfo(intent);
        }
        if (this.mSingleMode && (localActivityRecord2 = this.mResumed) != null && localActivityRecord2 != localActivityRecord && this.mCurState == 4) {
            moveToState(localActivityRecord2, 3);
        }
        if (z) {
            this.mActivities.put(str, localActivityRecord);
            this.mActivityArray.add(localActivityRecord);
        } else if (localActivityRecord.activityInfo != null) {
            if (activityInfo2 == localActivityRecord.activityInfo || (activityInfo2.name.equals(localActivityRecord.activityInfo.name) && activityInfo2.packageName.equals(localActivityRecord.activityInfo.packageName))) {
                if (activityInfo2.launchMode != 0 || (intent.getFlags() & 536870912) != 0) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(new ReferrerIntent(intent, this.mParent.getPackageName()));
                    this.mActivityThread.performNewIntents(localActivityRecord, arrayList);
                    localActivityRecord.intent = intent;
                    moveToState(localActivityRecord, this.mCurState);
                    if (this.mSingleMode) {
                        this.mResumed = localActivityRecord;
                    }
                    return localActivityRecord.window;
                } else if (z2 && (intent.getFlags() & 67108864) == 0) {
                    localActivityRecord.intent = intent;
                    moveToState(localActivityRecord, this.mCurState);
                    if (this.mSingleMode) {
                        this.mResumed = localActivityRecord;
                    }
                    return localActivityRecord.window;
                }
            }
            performDestroy(localActivityRecord, true);
        }
        localActivityRecord.intent = intent;
        localActivityRecord.curState = 1;
        localActivityRecord.activityInfo = activityInfo2;
        moveToState(localActivityRecord, this.mCurState);
        if (this.mSingleMode) {
            this.mResumed = localActivityRecord;
        }
        return localActivityRecord.window;
    }
}
