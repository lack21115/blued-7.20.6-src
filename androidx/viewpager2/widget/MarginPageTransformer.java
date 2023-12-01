package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/widget/MarginPageTransformer.class */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {

    /* renamed from: a  reason: collision with root package name */
    private final int f3539a;

    public MarginPageTransformer(int i) {
        Preconditions.checkArgumentNonnegative(i, "Margin must be non-negative");
        this.f3539a = i;
    }

    private ViewPager2 a(View view) {
        ViewParent parent = view.getParent();
        ViewParent parent2 = parent.getParent();
        if ((parent instanceof RecyclerView) && (parent2 instanceof ViewPager2)) {
            return (ViewPager2) parent2;
        }
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View view, float f) {
        ViewPager2 a2 = a(view);
        float f2 = this.f3539a * f;
        if (a2.getOrientation() != 0) {
            view.setTranslationY(f2);
            return;
        }
        float f3 = f2;
        if (a2.b()) {
            f3 = -f2;
        }
        view.setTranslationX(f3);
    }
}
