package butterknife.internal;

import android.view.View;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-8756600-dex2jar.jar:butterknife/internal/DebouncingOnClickListener.class */
public abstract class DebouncingOnClickListener implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static boolean f3728a = true;
    private static final Runnable b = new Runnable() { // from class: butterknife.internal.-$$Lambda$DebouncingOnClickListener$fKu_GIo_pW_YXcz3KkfF3UXipRU
        @Override // java.lang.Runnable
        public final void run() {
            DebouncingOnClickListener.f3728a = true;
        }
    };

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (f3728a) {
            f3728a = false;
            view.post(b);
            a(view);
        }
    }
}
