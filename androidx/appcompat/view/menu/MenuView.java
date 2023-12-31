package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuView.class */
public interface MenuView {

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuView$ItemView.class */
    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl menuItemImpl, int i);

        boolean prefersCondensedTitle();

        void setCheckable(boolean z);

        void setChecked(boolean z);

        void setEnabled(boolean z);

        void setIcon(Drawable drawable);

        void setShortcut(boolean z, char c2);

        void setTitle(CharSequence charSequence);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
