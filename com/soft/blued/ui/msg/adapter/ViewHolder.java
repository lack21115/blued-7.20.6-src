package com.soft.blued.ui.msg.adapter;

import android.util.SparseArray;
import android.view.View;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ViewHolder.class */
public class ViewHolder {
    public static <T extends View> T a(View view, int i) {
        SparseArray sparseArray = (SparseArray) view.getTag();
        SparseArray sparseArray2 = sparseArray;
        if (sparseArray == null) {
            sparseArray2 = new SparseArray();
            view.setTag(sparseArray2);
        }
        View view2 = (View) sparseArray2.get(i);
        View view3 = view2;
        if (view2 == null) {
            view3 = view.findViewById(i);
            sparseArray2.put(i, view3);
        }
        return (T) view3;
    }
}
