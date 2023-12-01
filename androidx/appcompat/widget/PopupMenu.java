package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/PopupMenu.class */
public class PopupMenu {

    /* renamed from: a  reason: collision with root package name */
    final MenuPopupHelper f1843a;
    OnMenuItemClickListener b;

    /* renamed from: c  reason: collision with root package name */
    OnDismissListener f1844c;
    private final Context d;
    private final MenuBuilder e;
    private final View f;
    private View.OnTouchListener g;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/PopupMenu$OnDismissListener.class */
    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/PopupMenu$OnMenuItemClickListener.class */
    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.d = context;
        this.f = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.e = menuBuilder;
        menuBuilder.setCallback(new MenuBuilder.Callback() { // from class: androidx.appcompat.widget.PopupMenu.1
            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public boolean onMenuItemSelected(MenuBuilder menuBuilder2, MenuItem menuItem) {
                if (PopupMenu.this.b != null) {
                    return PopupMenu.this.b.onMenuItemClick(menuItem);
                }
                return false;
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public void onMenuModeChange(MenuBuilder menuBuilder2) {
            }
        });
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, this.e, view, false, i2, i3);
        this.f1843a = menuPopupHelper;
        menuPopupHelper.setGravity(i);
        this.f1843a.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.PopupMenu.2
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (PopupMenu.this.f1844c != null) {
                    PopupMenu.this.f1844c.onDismiss(PopupMenu.this);
                }
            }
        });
    }

    public void dismiss() {
        this.f1843a.dismiss();
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.g == null) {
            this.g = new ForwardingListener(this.f) { // from class: androidx.appcompat.widget.PopupMenu.3
                @Override // androidx.appcompat.widget.ForwardingListener
                public ShowableListMenu getPopup() {
                    return PopupMenu.this.f1843a.getPopup();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                protected boolean onForwardingStarted() {
                    PopupMenu.this.show();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                protected boolean onForwardingStopped() {
                    PopupMenu.this.dismiss();
                    return true;
                }
            };
        }
        return this.g;
    }

    public int getGravity() {
        return this.f1843a.getGravity();
    }

    public Menu getMenu() {
        return this.e;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.d);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.e);
    }

    public void setForceShowIcon(boolean z) {
        this.f1843a.setForceShowIcon(z);
    }

    public void setGravity(int i) {
        this.f1843a.setGravity(i);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1844c = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.b = onMenuItemClickListener;
    }

    public void show() {
        this.f1843a.show();
    }
}
