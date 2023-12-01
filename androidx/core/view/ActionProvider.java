package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ActionProvider.class */
public abstract class ActionProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Context f2616a;
    private SubUiVisibilityListener b;

    /* renamed from: c  reason: collision with root package name */
    private VisibilityListener f2617c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ActionProvider$SubUiVisibilityListener.class */
    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ActionProvider$VisibilityListener.class */
    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    public ActionProvider(Context context) {
        this.f2616a = context;
    }

    public Context getContext() {
        return this.f2616a;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.f2617c == null || !overridesItemVisibility()) {
            return;
        }
        this.f2617c.onActionProviderVisibilityChanged(isVisible());
    }

    public void reset() {
        this.f2617c = null;
        this.b = null;
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.b = subUiVisibilityListener;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (this.f2617c != null && visibilityListener != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2617c = visibilityListener;
    }

    public void subUiVisibilityChanged(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.b;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }
}
