package com.android.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewDebug;
import android.widget.TextView;
import com.android.internal.R;
import com.android.internal.view.menu.IconMenuView;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuView;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/IconMenuItemView.class */
public final class IconMenuItemView extends TextView implements MenuView.ItemView {
    private static final int NO_ALPHA = 255;
    private static String sPrependShortcutLabel;
    private float mDisabledAlpha;
    private Drawable mIcon;
    private IconMenuView mIconMenuView;
    private MenuItemImpl mItemData;
    private MenuBuilder.ItemInvoker mItemInvoker;
    private Rect mPositionIconAvailable;
    private Rect mPositionIconOutput;
    private String mShortcutCaption;
    private boolean mShortcutCaptionMode;
    private int mTextAppearance;
    private Context mTextAppearanceContext;

    public IconMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMenuItemView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public IconMenuItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPositionIconAvailable = new Rect();
        this.mPositionIconOutput = new Rect();
        if (sPrependShortcutLabel == null) {
            sPrependShortcutLabel = getResources().getString(R.string.prepend_shortcut_label);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MenuView, i, i2);
        this.mDisabledAlpha = obtainStyledAttributes.getFloat(6, 0.8f);
        this.mTextAppearance = obtainStyledAttributes.getResourceId(1, -1);
        this.mTextAppearanceContext = context;
        obtainStyledAttributes.recycle();
    }

    private void positionIcon() {
        if (this.mIcon == null) {
            return;
        }
        Rect rect = this.mPositionIconOutput;
        getLineBounds(0, rect);
        this.mPositionIconAvailable.set(0, 0, getWidth(), rect.top);
        Gravity.apply(19, this.mIcon.getIntrinsicWidth(), this.mIcon.getIntrinsicHeight(), this.mPositionIconAvailable, this.mPositionIconOutput, getLayoutDirection());
        this.mIcon.setBounds(this.mPositionIconOutput);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mItemData == null || this.mIcon == null) {
            return;
        }
        this.mIcon.setAlpha(!this.mItemData.isEnabled() && (isPressed() || !isFocused()) ? (int) (this.mDisabledAlpha * 255.0f) : 255);
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    @ViewDebug.CapturedViewProperty(retrieveReturn = true)
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IconMenuView.LayoutParams getTextAppropriateLayoutParams() {
        IconMenuView.LayoutParams layoutParams = (IconMenuView.LayoutParams) getLayoutParams();
        IconMenuView.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new IconMenuView.LayoutParams(-1, -1);
        }
        layoutParams2.desiredWidth = (int) Layout.getDesiredWidth(getText(), getPaint());
        return layoutParams2;
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.mItemData = menuItemImpl;
        initialize(menuItemImpl.getTitleForItemView(this), menuItemImpl.getIcon());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initialize(CharSequence charSequence, Drawable drawable) {
        setClickable(true);
        setFocusable(true);
        if (this.mTextAppearance != -1) {
            setTextAppearance(this.mTextAppearanceContext, this.mTextAppearance);
        }
        setTitle(charSequence);
        setIcon(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        positionIcon();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        setLayoutParams(getTextAppropriateLayoutParams());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        if (this.mItemInvoker == null || !this.mItemInvoker.invokeItem(this.mItemData)) {
            return false;
        }
        playSoundEffect(0);
        return true;
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCaptionMode(boolean z) {
        if (this.mItemData == null) {
            return;
        }
        this.mShortcutCaptionMode = z && this.mItemData.shouldShowShortcut();
        String titleForItemView = this.mItemData.getTitleForItemView(this);
        if (this.mShortcutCaptionMode) {
            if (this.mShortcutCaption == null) {
                this.mShortcutCaption = this.mItemData.getShortcutLabel();
            }
            titleForItemView = this.mShortcutCaption;
        }
        setText(titleForItemView);
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        if (drawable == null) {
            setCompoundDrawables(null, null, null, null);
            setGravity(17);
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        setCompoundDrawables(null, drawable, null, null);
        setGravity(81);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIconMenuView(IconMenuView iconMenuView) {
        this.mIconMenuView = iconMenuView;
    }

    public void setItemData(MenuItemImpl menuItemImpl) {
        this.mItemData = menuItemImpl;
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.mItemInvoker = itemInvoker;
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
        if (this.mShortcutCaptionMode) {
            this.mShortcutCaption = null;
            setCaptionMode(true);
        }
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        if (this.mShortcutCaptionMode) {
            setCaptionMode(true);
        } else if (charSequence != null) {
            setText(charSequence);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mIconMenuView != null) {
            this.mIconMenuView.markStaleChildren();
        }
    }

    @Override // com.android.internal.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }
}
