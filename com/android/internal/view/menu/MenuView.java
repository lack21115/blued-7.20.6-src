package com.android.internal.view.menu;

import android.graphics.drawable.Drawable;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/MenuView.class */
public interface MenuView {

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/MenuView$ItemView.class */
    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z);

        void setChecked(boolean z);

        void setEnabled(boolean z);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z, char c);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
