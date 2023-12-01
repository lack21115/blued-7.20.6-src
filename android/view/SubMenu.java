package android.view;

import android.graphics.drawable.Drawable;

/* loaded from: source-9557208-dex2jar.jar:android/view/SubMenu.class */
public interface SubMenu extends Menu {
    void clearHeader();

    MenuItem getItem();

    SubMenu setHeaderIcon(int i);

    SubMenu setHeaderIcon(Drawable drawable);

    SubMenu setHeaderTitle(int i);

    SubMenu setHeaderTitle(CharSequence charSequence);

    SubMenu setHeaderView(View view);

    SubMenu setIcon(int i);

    SubMenu setIcon(Drawable drawable);
}
