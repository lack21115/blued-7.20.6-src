package androidx.lifecycle;

import android.app.Application;

/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/AndroidViewModel.class */
public class AndroidViewModel extends ViewModel {
    private Application mApplication;

    public AndroidViewModel(Application application) {
        this.mApplication = application;
    }

    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
