package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuPopupHelper.class */
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1689a;
    private final MenuBuilder b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1690c;
    private final int d;
    private final int e;
    private View f;
    private int g;
    private boolean h;
    private MenuPresenter.Callback i;
    private MenuPopup j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder) {
        this(context, menuBuilder, null, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view) {
        this(context, menuBuilder, view, false, R.attr.popupMenuStyle, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.MenuPopupHelper.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                MenuPopupHelper.this.a();
            }
        };
        this.f1689a = context;
        this.b = menuBuilder;
        this.f = view;
        this.f1690c = z;
        this.d = i;
        this.e = i2;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            int i3 = i;
            if ((GravityCompat.getAbsoluteGravity(this.g, ViewCompat.getLayoutDirection(this.f)) & 7) == 5) {
                i3 = i - this.f.getWidth();
            }
            popup.setHorizontalOffset(i3);
            popup.setVerticalOffset(i2);
            int i4 = (int) ((this.f1689a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.setEpicenterBounds(new Rect(i3 - i4, i2 - i4, i3 + i4, i2 + i4));
        }
        popup.show();
    }

    private MenuPopup b() {
        Display defaultDisplay = ((WindowManager) this.f1689a.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        MenuPopup cascadingMenuPopup = Math.min(point.x, point.y) >= this.f1689a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.f1689a, this.f, this.d, this.e, this.f1690c) : new StandardMenuPopup(this.f1689a, this.b, this.f, this.d, this.e, this.f1690c);
        cascadingMenuPopup.addMenu(this.b);
        cascadingMenuPopup.setOnDismissListener(this.l);
        cascadingMenuPopup.setAnchorView(this.f);
        cascadingMenuPopup.setCallback(this.i);
        cascadingMenuPopup.setForceShowIcon(this.h);
        cascadingMenuPopup.setGravity(this.g);
        return cascadingMenuPopup;
    }

    public void a() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void dismiss() {
        if (isShowing()) {
            this.j.dismiss();
        }
    }

    public int getGravity() {
        return this.g;
    }

    public ListView getListView() {
        return getPopup().getListView();
    }

    public MenuPopup getPopup() {
        if (this.j == null) {
            this.j = b();
        }
        return this.j;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.j;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void setAnchorView(View view) {
        this.f = view;
    }

    public void setForceShowIcon(boolean z) {
        this.h = z;
        MenuPopup menuPopup = this.j;
        if (menuPopup != null) {
            menuPopup.setForceShowIcon(z);
        }
    }

    public void setGravity(int i) {
        this.g = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.i = callback;
        MenuPopup menuPopup = this.j;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void show(int i, int i2) {
        if (!tryShow(i, i2)) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    public boolean tryShow(int i, int i2) {
        if (isShowing()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }
}
