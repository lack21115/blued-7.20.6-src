package com.android.internal.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/menu/ActionMenu.class */
public class ActionMenu implements Menu {
    private Context mContext;
    private boolean mIsQwerty;
    private ArrayList<ActionMenuItem> mItems = new ArrayList<>();

    public ActionMenu(Context context) {
        this.mContext = context;
    }

    private int findItemIndex(int i) {
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return -1;
            }
            if (arrayList.get(i3).getItemId() == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    private ActionMenuItem findItemWithShortcut(int i, KeyEvent keyEvent) {
        boolean z = this.mIsQwerty;
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return null;
            }
            ActionMenuItem actionMenuItem = arrayList.get(i3);
            if (i == (z ? actionMenuItem.getAlphabeticShortcut() : actionMenuItem.getNumericShortcut())) {
                return actionMenuItem;
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return add(0, 0, 0, i);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return add(i, i2, i3, this.mContext.getResources().getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        ActionMenuItem actionMenuItem = new ActionMenuItem(getContext(), i, i2, 0, i3, charSequence);
        this.mItems.add(i3, actionMenuItem);
        return actionMenuItem;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return add(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= size) {
                return size;
            }
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
            i5 = i6 + 1;
        }
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return null;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    @Override // android.view.Menu
    public void clear() {
        this.mItems.clear();
    }

    @Override // android.view.Menu
    public void close() {
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return this.mItems.get(findItemIndex(i));
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.mItems.get(i);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return false;
            }
            if (arrayList.get(i2).isVisible()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return findItemWithShortcut(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        int findItemIndex = findItemIndex(i);
        if (findItemIndex < 0) {
            return false;
        }
        return this.mItems.get(findItemIndex).invoke();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        ActionMenuItem findItemWithShortcut = findItemWithShortcut(i, keyEvent);
        if (findItemWithShortcut == null) {
            return false;
        }
        return findItemWithShortcut.invoke();
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            if (arrayList.get(i2).getGroupId() == i) {
                arrayList.remove(i2);
                size--;
            } else {
                i2++;
            }
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        this.mItems.remove(findItemIndex(i));
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            ActionMenuItem actionMenuItem = arrayList.get(i3);
            if (actionMenuItem.getGroupId() == i) {
                actionMenuItem.setCheckable(z);
                actionMenuItem.setExclusiveCheckable(z2);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            ActionMenuItem actionMenuItem = arrayList.get(i3);
            if (actionMenuItem.getGroupId() == i) {
                actionMenuItem.setEnabled(z);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ArrayList<ActionMenuItem> arrayList = this.mItems;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            ActionMenuItem actionMenuItem = arrayList.get(i3);
            if (actionMenuItem.getGroupId() == i) {
                actionMenuItem.setVisible(z);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mIsQwerty = z;
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }
}
