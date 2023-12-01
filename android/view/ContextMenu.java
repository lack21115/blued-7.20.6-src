package android.view;

import android.graphics.drawable.Drawable;

/* loaded from: source-9557208-dex2jar.jar:android/view/ContextMenu.class */
public interface ContextMenu extends Menu {

    /* loaded from: source-9557208-dex2jar.jar:android/view/ContextMenu$ContextMenuInfo.class */
    public interface ContextMenuInfo {
    }

    void clearHeader();

    ContextMenu setHeaderIcon(int i);

    ContextMenu setHeaderIcon(Drawable drawable);

    ContextMenu setHeaderTitle(int i);

    ContextMenu setHeaderTitle(CharSequence charSequence);

    ContextMenu setHeaderView(View view);
}
