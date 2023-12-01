package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/recyclerview/widget/ItemTouchUIUtil.class */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z);

    void onSelected(View view);
}
