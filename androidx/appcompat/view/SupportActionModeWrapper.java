package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/SupportActionModeWrapper.class */
public class SupportActionModeWrapper extends android.view.ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f1591a;
    final ActionMode b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/view/SupportActionModeWrapper$CallbackWrapper.class */
    public static class CallbackWrapper implements ActionMode.Callback {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f1592a;
        final Context b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<SupportActionModeWrapper> f1593c = new ArrayList<>();
        final SimpleArrayMap<Menu, Menu> d = new SimpleArrayMap<>();

        public CallbackWrapper(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.f1592a = callback;
        }

        private Menu a(Menu menu) {
            Menu menu2 = this.d.get(menu);
            MenuWrapperICS menuWrapperICS = menu2;
            if (menu2 == null) {
                menuWrapperICS = new MenuWrapperICS(this.b, (SupportMenu) menu);
                this.d.put(menu, menuWrapperICS);
            }
            return menuWrapperICS;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
            int size = this.f1593c.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    SupportActionModeWrapper supportActionModeWrapper = new SupportActionModeWrapper(this.b, actionMode);
                    this.f1593c.add(supportActionModeWrapper);
                    return supportActionModeWrapper;
                }
                SupportActionModeWrapper supportActionModeWrapper2 = this.f1593c.get(i2);
                if (supportActionModeWrapper2 != null && supportActionModeWrapper2.b == actionMode) {
                    return supportActionModeWrapper2;
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f1592a.onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS(this.b, (SupportMenuItem) menuItem));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f1592a.onCreateActionMode(getActionModeWrapper(actionMode), a(menu));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f1592a.onDestroyActionMode(getActionModeWrapper(actionMode));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return this.f1592a.onPrepareActionMode(getActionModeWrapper(actionMode), a(menu));
        }
    }

    public SupportActionModeWrapper(Context context, ActionMode actionMode) {
        this.f1591a = context;
        this.b = actionMode;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.f1591a, (SupportMenu) this.b.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.setCustomView(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.setSubtitle(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.setSubtitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.setTag(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.setTitle(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.setTitle(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.setTitleOptionalHint(z);
    }
}
