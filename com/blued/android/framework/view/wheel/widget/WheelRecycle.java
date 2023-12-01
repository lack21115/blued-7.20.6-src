package com.blued.android.framework.view.wheel.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/wheel/widget/WheelRecycle.class */
public class WheelRecycle {

    /* renamed from: a  reason: collision with root package name */
    private List<View> f10351a;
    private List<View> b;

    /* renamed from: c  reason: collision with root package name */
    private WheelView f10352c;

    public WheelRecycle(WheelView wheelView) {
        this.f10352c = wheelView;
    }

    private View a(List<View> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        View view = list.get(0);
        list.remove(0);
        return view;
    }

    private List<View> a(View view, List<View> list) {
        LinkedList linkedList = list;
        if (list == null) {
            linkedList = new LinkedList();
        }
        linkedList.add(view);
        return linkedList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r7 >= r0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r6, int r7) {
        /*
            r5 = this;
            r0 = r5
            com.blued.android.framework.view.wheel.widget.WheelView r0 = r0.f10352c
            com.blued.android.framework.view.wheel.widget.adapters.WheelViewAdapter r0 = r0.getViewAdapter()
            int r0 = r0.a()
            r9 = r0
            r0 = r7
            if (r0 < 0) goto L1a
            r0 = r7
            r8 = r0
            r0 = r7
            r1 = r9
            if (r0 < r1) goto L34
        L1a:
            r0 = r7
            r8 = r0
            r0 = r5
            com.blued.android.framework.view.wheel.widget.WheelView r0 = r0.f10352c
            boolean r0 = r0.c()
            if (r0 != 0) goto L34
            r0 = r5
            r1 = r5
            r2 = r6
            r3 = r5
            java.util.List<android.view.View> r3 = r3.b
            java.util.List r1 = r1.a(r2, r3)
            r0.b = r1
            return
        L34:
            r0 = r8
            if (r0 >= 0) goto L40
            r0 = r8
            r1 = r9
            int r0 = r0 + r1
            r8 = r0
            goto L34
        L40:
            r0 = r5
            r1 = r5
            r2 = r6
            r3 = r5
            java.util.List<android.view.View> r3 = r3.f10351a
            java.util.List r1 = r1.a(r2, r3)
            r0.f10351a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.wheel.widget.WheelRecycle.a(android.view.View, int):void");
    }

    public int a(LinearLayout linearLayout, int i, ItemsRange itemsRange) {
        int i2;
        int i3;
        int i4 = i;
        int i5 = 0;
        while (i5 < linearLayout.getChildCount()) {
            if (itemsRange.a(i4)) {
                i2 = i5 + 1;
                i3 = i;
            } else {
                a(linearLayout.getChildAt(i5), i4);
                linearLayout.removeViewAt(i5);
                i2 = i5;
                i3 = i;
                if (i5 == 0) {
                    i3 = i + 1;
                    i2 = i5;
                }
            }
            i4++;
            i5 = i2;
            i = i3;
        }
        return i;
    }

    public View a() {
        return a(this.f10351a);
    }

    public View b() {
        return a(this.b);
    }

    public void c() {
        List<View> list = this.f10351a;
        if (list != null) {
            list.clear();
        }
        List<View> list2 = this.b;
        if (list2 != null) {
            list2.clear();
        }
    }
}
