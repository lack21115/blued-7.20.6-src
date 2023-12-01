package skin.support.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import skin.support.SkinCompatManager;
import skin.support.widget.SkinCompatSupportable;

/* loaded from: source-3503164-dex2jar.jar:skin/support/app/SkinCompatDelegate.class */
public class SkinCompatDelegate implements LayoutInflater.Factory2 {
    private final Context a;
    private SkinCompatViewInflater b;
    private List<WeakReference<SkinCompatSupportable>> c = new CopyOnWriteArrayList();

    private SkinCompatDelegate(Context context) {
        this.a = context;
    }

    public static SkinCompatDelegate a(Context context) {
        return new SkinCompatDelegate(context);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.b == null) {
            this.b = new SkinCompatViewInflater();
        }
        for (SkinWrapper skinWrapper : SkinCompatManager.a().c()) {
            Context a = skinWrapper.a(this.a, view, attributeSet);
            if (a != null) {
                context = a;
            }
        }
        return this.b.a(view, str, context, attributeSet);
    }

    public void a() {
        List<WeakReference<SkinCompatSupportable>> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (WeakReference<SkinCompatSupportable> weakReference : this.c) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().applySkin();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a = a(view, str, context, attributeSet);
        if (a == null) {
            return null;
        }
        if (a instanceof SkinCompatSupportable) {
            this.c.add(new WeakReference<>((SkinCompatSupportable) a));
        }
        return a;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a = a(null, str, context, attributeSet);
        if (a == null) {
            return null;
        }
        if (a instanceof SkinCompatSupportable) {
            this.c.add(new WeakReference<>((SkinCompatSupportable) a));
        }
        return a;
    }
}
