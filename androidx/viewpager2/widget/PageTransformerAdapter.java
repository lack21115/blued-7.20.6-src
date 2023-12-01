package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/viewpager2/widget/PageTransformerAdapter.class */
final class PageTransformerAdapter extends ViewPager2.OnPageChangeCallback {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutManager f3588a;
    private ViewPager2.PageTransformer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageTransformerAdapter(LinearLayoutManager linearLayoutManager) {
        this.f3588a = linearLayoutManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewPager2.PageTransformer a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewPager2.PageTransformer pageTransformer) {
        this.b = pageTransformer;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int i, float f, int i2) {
        if (this.b == null) {
            return;
        }
        float f2 = -f;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f3588a.getChildCount()) {
                return;
            }
            View childAt = this.f3588a.getChildAt(i4);
            if (childAt == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i4), Integer.valueOf(this.f3588a.getChildCount())));
            }
            this.b.transformPage(childAt, (this.f3588a.getPosition(childAt) - i) + f2);
            i3 = i4 + 1;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
    }
}
