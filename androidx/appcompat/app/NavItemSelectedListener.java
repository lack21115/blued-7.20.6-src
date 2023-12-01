package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/app/NavItemSelectedListener.class */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    private final ActionBar.OnNavigationListener f1594a;

    public NavItemSelectedListener(ActionBar.OnNavigationListener onNavigationListener) {
        this.f1594a = onNavigationListener;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        Tracker.onItemSelected(adapterView, view, i, j);
        ActionBar.OnNavigationListener onNavigationListener = this.f1594a;
        if (onNavigationListener != null) {
            onNavigationListener.onNavigationItemSelected(i, j);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
