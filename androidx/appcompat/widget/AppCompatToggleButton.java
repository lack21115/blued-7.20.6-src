package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.ToggleButton;
import androidx.appcompat.R;
import androidx.core.view.TintableBackgroundView;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatToggleButton.class */
public class AppCompatToggleButton extends ToggleButton implements EmojiCompatConfigurationView, TintableBackgroundView {

    /* renamed from: a  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1806a;
    private final AppCompatTextHelper b;

    /* renamed from: c  reason: collision with root package name */
    private AppCompatEmojiTextHelper f1807c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatToggleButton$InspectionCompanion.class */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<AppCompatToggleButton> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1808a = false;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f1809c;

        @Override // android.view.inspector.InspectionCompanion
        public void mapProperties(PropertyMapper propertyMapper) {
            this.b = propertyMapper.mapObject("backgroundTint", R.attr.backgroundTint);
            this.f1809c = propertyMapper.mapObject("backgroundTintMode", R.attr.backgroundTintMode);
            this.f1808a = true;
        }

        @Override // android.view.inspector.InspectionCompanion
        public void readProperties(AppCompatToggleButton appCompatToggleButton, PropertyReader propertyReader) {
            if (!this.f1808a) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readObject(this.b, appCompatToggleButton.getBackgroundTintList());
            propertyReader.readObject(this.f1809c, appCompatToggleButton.getBackgroundTintMode());
        }
    }

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1806a = appCompatBackgroundHelper;
        appCompatBackgroundHelper.a(attributeSet, i);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.b = appCompatTextHelper;
        appCompatTextHelper.a(attributeSet, i);
        getEmojiTextViewHelper().a(attributeSet, i);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1807c == null) {
            this.f1807c = new AppCompatEmojiTextHelper(this);
        }
        return this.f1807c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.c();
        }
        AppCompatTextHelper appCompatTextHelper = this.b;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.a();
        }
        return null;
    }

    @Override // androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().isEnabled();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b(z);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(i);
        }
    }

    @Override // androidx.appcompat.widget.EmojiCompatConfigurationView
    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().a(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(colorStateList);
        }
    }

    @Override // androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1806a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a(mode);
        }
    }
}
