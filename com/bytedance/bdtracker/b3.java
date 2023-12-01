package com.bytedance.bdtracker;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuItemImpl;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b3.class */
public class b3 {
    public static View a(View view, MenuItem menuItem) {
        MenuItemImpl itemData;
        if (view.getClass() == d3.e) {
            itemData = d3.f.invoke(view, new Object[0]);
        } else {
            if (!(k2.n && (view instanceof ListMenuItemView))) {
                if (!(k2.i && (view instanceof ListMenuItemView))) {
                    itemData = null;
                }
            }
            itemData = ((ListMenuItemView) view).getItemData();
        }
        if (itemData == menuItem) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View a2 = a(viewGroup.getChildAt(i2), menuItem);
            if (a2 != null) {
                return a2;
            }
            i = i2 + 1;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static com.bytedance.bdtracker.v1 a(android.view.View r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 2654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.b3.a(android.view.View, boolean):com.bytedance.bdtracker.v1");
    }
}
