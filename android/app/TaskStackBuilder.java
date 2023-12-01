package android.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.Log;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/app/TaskStackBuilder.class */
public class TaskStackBuilder {
    private static final String TAG = "TaskStackBuilder";
    private final ArrayList<Intent> mIntents = new ArrayList<>();
    private final Context mSourceContext;

    private TaskStackBuilder(Context context) {
        this.mSourceContext = context;
    }

    public static TaskStackBuilder create(Context context) {
        return new TaskStackBuilder(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent) {
        this.mIntents.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent) {
        ComponentName component = intent.getComponent();
        ComponentName componentName = component;
        if (component == null) {
            componentName = intent.resolveActivity(this.mSourceContext.getPackageManager());
        }
        if (componentName != null) {
            addParentStack(componentName);
        }
        addNextIntent(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            ComponentName component = parentActivityIntent.getComponent();
            ComponentName componentName = component;
            if (component == null) {
                componentName = parentActivityIntent.resolveActivity(this.mSourceContext.getPackageManager());
            }
            addParentStack(componentName);
            addNextIntent(parentActivityIntent);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName componentName) {
        int size = this.mIntents.size();
        PackageManager packageManager = this.mSourceContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 0);
            String str = activityInfo.parentActivityName;
            while (str != null) {
                ComponentName componentName2 = new ComponentName(activityInfo.packageName, str);
                ActivityInfo activityInfo2 = packageManager.getActivityInfo(componentName2, 0);
                str = activityInfo2.parentActivityName;
                this.mIntents.add(size, (str == null && size == 0) ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2));
                activityInfo = activityInfo2;
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public TaskStackBuilder addParentStack(Class<?> cls) {
        return addParentStack(new ComponentName(this.mSourceContext, cls));
    }

    public Intent editIntentAt(int i) {
        return this.mIntents.get(i);
    }

    public int getIntentCount() {
        return this.mIntents.size();
    }

    public Intent[] getIntents() {
        Intent[] intentArr = new Intent[this.mIntents.size()];
        if (intentArr.length != 0) {
            intentArr[0] = new Intent(this.mIntents.get(0)).addFlags(268484608);
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 >= intentArr.length) {
                    break;
                }
                intentArr[i2] = new Intent(this.mIntents.get(i2));
                i = i2 + 1;
            }
        }
        return intentArr;
    }

    public PendingIntent getPendingIntent(int i, int i2) {
        return getPendingIntent(i, i2, null);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        return PendingIntent.getActivities(this.mSourceContext, i, getIntents(), i2, bundle);
    }

    public PendingIntent getPendingIntent(int i, int i2, Bundle bundle, UserHandle userHandle) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        return PendingIntent.getActivitiesAsUser(this.mSourceContext, i, getIntents(), i2, bundle, userHandle);
    }

    public void startActivities() {
        startActivities(null);
    }

    public void startActivities(Bundle bundle) {
        startActivities(bundle, new UserHandle(UserHandle.myUserId()));
    }

    public void startActivities(Bundle bundle, UserHandle userHandle) {
        if (this.mIntents.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        this.mSourceContext.startActivitiesAsUser(getIntents(), bundle, userHandle);
    }
}
