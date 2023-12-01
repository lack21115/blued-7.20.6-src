package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/TintResources.class */
public class TintResources extends ResourcesWrapper {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1849a;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.f1849a = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable a2 = a(i);
        Context context = this.f1849a.get();
        if (a2 != null && context != null) {
            ResourceManagerInternal.get().a(context, i, a2);
        }
        return a2;
    }
}
