package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/MenuKt.class */
public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem item) {
        Intrinsics.e(menu, "<this>");
        Intrinsics.e(item, "item");
        int size = menu.size();
        if (size <= 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            if (Intrinsics.a(menu.getItem(i2), item)) {
                return true;
            }
            if (i3 >= size) {
                return false;
            }
            i = i3;
        }
    }

    public static final void forEach(Menu menu, Function1<? super MenuItem, Unit> action) {
        Intrinsics.e(menu, "<this>");
        Intrinsics.e(action, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            MenuItem item = menu.getItem(i2);
            Intrinsics.c(item, "getItem(index)");
            action.invoke(item);
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final void forEachIndexed(Menu menu, Function2<? super Integer, ? super MenuItem, Unit> action) {
        Intrinsics.e(menu, "<this>");
        Intrinsics.e(action, "action");
        int size = menu.size();
        if (size <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = i2 + 1;
            MenuItem item = menu.getItem(i2);
            Intrinsics.c(item, "getItem(index)");
            action.invoke(Integer.valueOf(i2), item);
            if (i3 >= size) {
                return;
            }
            i = i3;
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        Intrinsics.e(menu, "<this>");
        MenuItem item = menu.getItem(i);
        Intrinsics.c(item, "getItem(index)");
        return item;
    }

    public static final Sequence<MenuItem> getChildren(final Menu menu) {
        Intrinsics.e(menu, "<this>");
        return new Sequence<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.Sequence
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(Menu.this);
            }
        };
    }

    public static final int getSize(Menu menu) {
        Intrinsics.e(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        Intrinsics.e(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        Intrinsics.e(menu, "<this>");
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        Intrinsics.e(menu, "<this>");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem item) {
        Intrinsics.e(menu, "<this>");
        Intrinsics.e(item, "item");
        menu.removeItem(item.getItemId());
    }
}
