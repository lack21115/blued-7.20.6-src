package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/BaseMenuWrapper.class */
abstract class BaseMenuWrapper {

    /* renamed from: a  reason: collision with root package name */
    final Context f1659a;
    private SimpleArrayMap<SupportMenuItem, MenuItem> b;

    /* renamed from: c  reason: collision with root package name */
    private SimpleArrayMap<SupportSubMenu, SubMenu> f1660c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMenuWrapper(Context context) {
        this.f1659a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem a(MenuItem menuItem) {
        MenuItemWrapperICS menuItemWrapperICS = menuItem;
        if (menuItem instanceof SupportMenuItem) {
            SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
            if (this.b == null) {
                this.b = new SimpleArrayMap<>();
            }
            MenuItem menuItem2 = this.b.get(menuItem);
            menuItemWrapperICS = menuItem2;
            if (menuItem2 == null) {
                menuItemWrapperICS = new MenuItemWrapperICS(this.f1659a, supportMenuItem);
                this.b.put(supportMenuItem, menuItemWrapperICS);
            }
        }
        return menuItemWrapperICS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof SupportSubMenu) {
            SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
            if (this.f1660c == null) {
                this.f1660c = new SimpleArrayMap<>();
            }
            SubMenu subMenu2 = this.f1660c.get(supportSubMenu);
            SubMenuWrapperICS subMenuWrapperICS = subMenu2;
            if (subMenu2 == null) {
                subMenuWrapperICS = new SubMenuWrapperICS(this.f1659a, supportSubMenu);
                this.f1660c.put(supportSubMenu, subMenuWrapperICS);
            }
            return subMenuWrapperICS;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        SimpleArrayMap<SupportMenuItem, MenuItem> simpleArrayMap = this.b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<SupportSubMenu, SubMenu> simpleArrayMap2 = this.f1660c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.size()) {
                return;
            }
            int i4 = i3;
            if (this.b.keyAt(i3).getGroupId() == i) {
                this.b.removeAt(i3);
                i4 = i3 - 1;
            }
            i2 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i) {
        if (this.b == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.b.size()) {
                return;
            }
            if (this.b.keyAt(i3).getItemId() == i) {
                this.b.removeAt(i3);
                return;
            }
            i2 = i3 + 1;
        }
    }
}
