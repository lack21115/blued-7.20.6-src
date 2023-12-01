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

    /* renamed from: a  reason: collision with root package name */
    private final Context f44198a;
    private SkinCompatViewInflater b;

    /* renamed from: c  reason: collision with root package name */
    private List<WeakReference<SkinCompatSupportable>> f44199c = new CopyOnWriteArrayList();

    private SkinCompatDelegate(Context context) {
        this.f44198a = context;
    }

    public static SkinCompatDelegate a(Context context) {
        return new SkinCompatDelegate(context);
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.b == null) {
            this.b = new SkinCompatViewInflater();
        }
        for (SkinWrapper skinWrapper : SkinCompatManager.a().c()) {
            Context a2 = skinWrapper.a(this.f44198a, view, attributeSet);
            if (a2 != null) {
                context = a2;
            }
        }
        return this.b.a(view, str, context, attributeSet);
    }

    public void a() {
        List<WeakReference<SkinCompatSupportable>> list = this.f44199c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (WeakReference<SkinCompatSupportable> weakReference : this.f44199c) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().applySkin();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof SkinCompatSupportable) {
            this.f44199c.add(new WeakReference<>((SkinCompatSupportable) a2));
        }
        return a2;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a(null, str, context, attributeSet);
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof SkinCompatSupportable) {
            this.f44199c.add(new WeakReference<>((SkinCompatSupportable) a2));
        }
        return a2;
    }
}
