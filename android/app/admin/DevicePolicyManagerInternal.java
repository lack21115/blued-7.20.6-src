package android.app.admin;

import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/app/admin/DevicePolicyManagerInternal.class */
public abstract class DevicePolicyManagerInternal {

    /* loaded from: source-9557208-dex2jar.jar:android/app/admin/DevicePolicyManagerInternal$OnCrossProfileWidgetProvidersChangeListener.class */
    public interface OnCrossProfileWidgetProvidersChangeListener {
        void onCrossProfileWidgetProvidersChanged(int i, List<String> list);
    }

    public abstract void addOnCrossProfileWidgetProvidersChangeListener(OnCrossProfileWidgetProvidersChangeListener onCrossProfileWidgetProvidersChangeListener);

    public abstract List<String> getCrossProfileWidgetProviders(int i);
}
