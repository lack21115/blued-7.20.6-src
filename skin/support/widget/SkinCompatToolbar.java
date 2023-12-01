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
    private int a;
    private int b;
    private int c;
    private SkinCompatBackgroundHelper d;

    public SkinCompatToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SkinCompatToolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0;
        this.b = 0;
        this.c = 0;
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = new SkinCompatBackgroundHelper(this);
        this.d = skinCompatBackgroundHelper;
        skinCompatBackgroundHelper.a(attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Toolbar, i, 0);
        this.c = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_navigationIcon, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        obtainStyledAttributes.recycle();
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, R.styleable.SkinTextAppearance);
            this.a = obtainStyledAttributes2.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes2.recycle();
        }
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(resourceId2, R.styleable.SkinTextAppearance);
            this.b = obtainStyledAttributes3.getResourceId(R.styleable.SkinTextAppearance_android_textColor, 0);
            obtainStyledAttributes3.recycle();
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, R.styleable.Toolbar, i, 0);
        if (obtainStyledAttributes4.hasValue(R.styleable.Toolbar_titleTextColor)) {
            this.a = obtainStyledAttributes4.getResourceId(R.styleable.Toolbar_titleTextColor, 0);
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
        int b = SkinCompatHelper.b(this.a);
        this.a = b;
        if (b != 0) {
            setTitleTextColor(SkinCompatResources.c(getContext(), this.a));
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
        int b = SkinCompatHelper.b(this.c);
        this.c = b;
        if (b != 0) {
            setNavigationIcon(SkinCompatVectorResources.a(getContext(), this.c));
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

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.d;
        if (skinCompatBackgroundHelper != null) {
            skinCompatBackgroundHelper.a(i);
        }
    }

    public void setNavigationIcon(int i) {
        super.setNavigationIcon(i);
        this.c = i;
        c();
    }
}
