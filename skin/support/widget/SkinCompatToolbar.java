package skin.support.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import skin.support.appcompat.R;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatVectorResources;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatToolbar.class */
public class SkinCompatToolbar extends Toolbar implements SkinCompatSupportable {

    /* renamed from: a  reason: collision with root package name */
    private int f44290a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f44291c;
    private SkinCompatBackgroundHelper d;

    public SkinCompatToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public SkinCompatToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44290a = 0;
        this.b = 0;
        this.f44291c = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.d = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Toolbar, i, 0);
        this.f44291c = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_navigationIcon, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, R.styleable.SkinTextAppearance);
            this.f44290a = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes2.recycle();
        }
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId2, R.styleable.SkinTextAppearance);
            this.b = obtainStyledAttributes3.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes3.recycle();
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, R.styleable.Toolbar, i, 0);
        if (obtainStyledAttributes4.hasValue(R.styleable.Toolbar_titleTextColor)) {
            this.f44290a = obtainStyledAttributes4.getResourceId(R.styleable.Toolbar_titleTextColor, 0);
        }
        if (obtainStyledAttributes4.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            this.b = obtainStyledAttributes4.getResourceId(R.styleable.Toolbar_subtitleTextColor, 0);
        }
        obtainStyledAttributes4.recycle();
        a();
        b();
        c();
    }

    private void a() {
        int b = SkinCompatHelper.b(this.f44290a);
        this.f44290a = b;
        if (b != 0) {
            setTitleTextColor(SkinCompatResources.c(getContext(), this.f44290a));
        }
    }

    private void b() {
        int b = SkinCompatHelper.b(this.b);
        this.b = b;
        if (b != 0) {
            setSubtitleTextColor(SkinCompatResources.c(getContext(), this.b));
        }
    }

    private void c() {
        int b = SkinCompatHelper.b(this.f44291c);
        this.f44291c = b;
        if (b != 0) {
            setNavigationIcon(SkinCompatVectorResources.a(getContext(), this.f44291c));
        }
    }

    @Override // skin.support.widget.SkinCompatSupportable
    public void applySkin() {
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a();
        }
        a();
        b();
        c();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(int i) {
        super.setNavigationIcon(i);
        this.f44291c = i;
        c();
    }
}
