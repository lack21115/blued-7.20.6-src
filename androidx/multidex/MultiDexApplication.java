package androidx.multidex;

import android.app.Application;
import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:androidx/multidex/MultiDexApplication.class */
public class MultiDexApplication extends Application {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
