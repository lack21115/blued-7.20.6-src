package android.app.usage;

import android.content.ComponentName;
import android.content.res.Configuration;

/* loaded from: source-9557208-dex2jar.jar:android/app/usage/UsageStatsManagerInternal.class */
public abstract class UsageStatsManagerInternal {
    public abstract void prepareShutdown();

    public abstract void reportConfigurationChange(Configuration configuration, int i);

    public abstract void reportEvent(ComponentName componentName, int i, int i2);
}
