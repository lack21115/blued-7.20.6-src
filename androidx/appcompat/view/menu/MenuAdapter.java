package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/menu/MenuAdapter.class */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    MenuBuilder f1627a;
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1628c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.f1627a = menuBuilder;
        this.f = i;
        a();
    }

    void a() {
        MenuItemImpl expandedItem = this.f1627a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = this.f1627a.getNonActionItems();
            int size = nonActionItems.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                } else if (nonActionItems.get(i2) == expandedItem) {
                    this.b = i2;
                    return;
                } else {
                    i = i2 + 1;
                }
            }
        }
        this.b = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.f1627a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<MenuItemImpl> nonActionItems = this.d ? this.f1627a.getNonActionItems() : this.f1627a.getVisibleItems();
        return this.b < 0 ? nonActionItems.size() : nonActionItems.size() - 1;
    }

    public boolean getForceShowIcon() {
        return this.f1628c;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> nonActionItems = this.d ? this.f1627a.getNonActionItems() : this.f1627a.getVisibleItems();
        int i2 = this.b;
        int i3 = i;
        if (i2 >= 0) {
            i3 = i;
            if (i >= i2) {
                i3 = i + 1;
            }
        }
        return nonActionItems.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = view;
        if (view == null) {
            view2 = this.e.inflate(this.f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        int groupId2 = i2 >= 0 ? getItem(i2).getGroupId() : groupId;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view2;
        listMenuItemView.setGroupDividerEnabled(this.f1627a.isGroupDividerEnabled() && groupId != groupId2);
        MenuView.ItemView itemView = (MenuView.ItemView) view2;
        if (this.f1628c) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.initialize(getItem(i), 0);
        return view2;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean z) {
        this.f1628c = z;
    }
}
