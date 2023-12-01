package com.blued.android.kbswitch.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.kbswitch.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/kbswitch/utils/UtilsKt.class */
public final class UtilsKt {
    public static final float a(Context context, float f) {
        Intrinsics.e(context, "<this>");
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static final Rect a(View view, int i, int i2, int i3, int i4) {
        Intrinsics.e(view, "<this>");
        return new Rect(i, i2, i3, i4);
    }

    public static /* synthetic */ Rect a(View view, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i5 & 2) != 0) {
            i2 = view.getPaddingTop();
        }
        if ((i5 & 4) != 0) {
            i3 = view.getPaddingEnd();
        }
        if ((i5 & 8) != 0) {
            i4 = view.getPaddingBottom();
        }
        return a(view, i, i2, i3, i4);
    }

    public static final Rect a(View view, boolean z) {
        Intrinsics.e(view, "<this>");
        Object tag = view.getTag(R.id.padding_view);
        Rect rect = tag instanceof Rect ? (Rect) tag : null;
        if (z) {
            view.setTag(R.id.padding_view, null);
        }
        return rect;
    }

    public static /* synthetic */ Rect a(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return a(view, z);
    }

    public static final List<View> a(ViewGroup viewGroup, MotionEvent event, boolean z, Integer num, int[] location) {
        Intrinsics.e(viewGroup, "<this>");
        Intrinsics.e(event, "event");
        Intrinsics.e(location, "location");
        ArrayList arrayList = new ArrayList();
        a(viewGroup, num, event, z, arrayList, location);
        if (arrayList.isEmpty()) {
            arrayList.add(viewGroup);
        }
        return arrayList;
    }

    public static /* synthetic */ List a(ViewGroup viewGroup, MotionEvent motionEvent, boolean z, Integer num, int[] iArr, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            iArr = new int[2];
        }
        return a(viewGroup, motionEvent, z, num, iArr);
    }

    public static final void a(View view) {
        Intrinsics.e(view, "<this>");
        view.setTag(R.id.view_panel_show, null);
    }

    public static final void a(View view, int i) {
        Intrinsics.e(view, "<this>");
        view.setTag(R.id.view_panel_show, Integer.valueOf(i));
    }

    public static final void a(View view, Activity mContext) {
        Intrinsics.e(mContext, "mContext");
        Object systemService = mContext.getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View view2 = view;
        if (view == null) {
            view2 = mContext.getCurrentFocus();
        }
        View view3 = view2;
        if (view2 == null) {
            view3 = new View(mContext);
        }
        inputMethodManager.hideSoftInputFromWindow(view3.getWindowToken(), 0);
    }

    private static final void a(ViewGroup viewGroup, Integer num, MotionEvent motionEvent, boolean z, List<View> list, int[] iArr) {
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (i < childCount) {
            int i2 = i + 1;
            View child = viewGroup.getChildAt(viewGroup.getChildCount() - i2);
            if (num != null && child.getVisibility() != num.intValue()) {
                i = i2;
            } else if (child instanceof ViewStub) {
                i = i2;
            } else {
                Intrinsics.c(child, "child");
                i = i2;
                if (a(iArr, child, motionEvent.getRawX(), motionEvent.getRawY())) {
                    if (!z || child.isClickable()) {
                        list.add(child);
                    }
                    i = i2;
                    if (child instanceof ViewGroup) {
                        a((ViewGroup) child, num, motionEvent, z, list, iArr);
                        i = i2;
                    }
                }
            }
        }
    }

    public static final void a(RecyclerView recyclerView, boolean z, boolean z2) {
        Intrinsics.e(recyclerView, "<this>");
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        recyclerView.scrollToPosition(Integer.valueOf(linearLayoutManager.getReverseLayout() ? 0 : linearLayoutManager.getItemCount() - 1).intValue());
    }

    public static /* synthetic */ void a(RecyclerView recyclerView, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        a(recyclerView, z, z2);
    }

    public static final boolean a(View view, View view2) {
        Intrinsics.e(view, "<this>");
        Object tag = view.getTag(R.id.view_panel_show);
        Integer valueOf = view2 == null ? null : Integer.valueOf(view2.getId());
        return Intrinsics.a(tag, Integer.valueOf(valueOf == null ? view.getId() : valueOf.intValue()));
    }

    private static final boolean a(int[] iArr, View view, float f, float f2) {
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z = false;
        if (f2 >= i2) {
            z = false;
            if (f2 <= measuredHeight + i2) {
                z = false;
                if (f >= i) {
                    z = false;
                    if (f <= measuredWidth + i) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static final boolean a(Object... items) {
        boolean z;
        Intrinsics.e(items, "items");
        if (items.length > 1) {
            Object obj = items[0];
            int length = items.length;
            int i = 0;
            while (true) {
                z = true;
                if (i >= length) {
                    break;
                }
                i++;
                if (!Intrinsics.a(items[i], obj)) {
                    z = false;
                    break;
                }
            }
            return z;
        }
        throw new IllegalArgumentException("array items size must > 1");
    }

    public static final void b(View view) {
        Intrinsics.e(view, "<this>");
        view.setTag(R.id.view_not_hide, true);
    }

    public static final boolean c(View view) {
        Intrinsics.e(view, "<this>");
        boolean a = Intrinsics.a(view.getTag(R.id.view_not_hide), (Object) true);
        if (a || !(view.getParent() instanceof ViewGroup)) {
            return a;
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            return c((ViewGroup) parent);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
