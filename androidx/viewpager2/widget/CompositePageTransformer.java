package androidx.viewpager2.widget;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/widget/CompositePageTransformer.class */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.PageTransformer> f3536a = new ArrayList();

    public void addTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.f3536a.add(pageTransformer);
    }

    public void removeTransformer(ViewPager2.PageTransformer pageTransformer) {
        this.f3536a.remove(pageTransformer);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        for (ViewPager2.PageTransformer pageTransformer : this.f3536a) {
            pageTransformer.transformPage(view, f);
        }
    }
}
