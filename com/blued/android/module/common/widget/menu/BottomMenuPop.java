package com.blued.android.module.common.widget.menu;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.R;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BottomMenuPop.class */
public class BottomMenuPop extends BottomPopupView {
    public List<MenuItemInfo> b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f11212c;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/BottomMenuPop$MenuItemInfo.class */
    public static class MenuItemInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f11214a;
        public int b = R.color.syc_h;

        /* renamed from: c  reason: collision with root package name */
        public int f11215c;
        public View.OnClickListener d;
    }

    public BottomMenuPop(Context context) {
        super(context);
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        VerticalRecyclerView verticalRecyclerView = (VerticalRecyclerView) findViewById(R.id.recycler_view);
        List<MenuItemInfo> list = this.b;
        if (list != null) {
            verticalRecyclerView.setAdapter(new BottomMenuAdapter(list));
            verticalRecyclerView.a();
        }
        ShapeTextView shapeTextView = (ShapeTextView) findViewById(R.id.tv_cancel);
        ShapeHelper.b(shapeTextView, R.color.syc_b);
        ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_h);
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.menu.BottomMenuPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                BottomMenuPop.this.p();
                if (BottomMenuPop.this.f11212c != null) {
                    BottomMenuPop.this.f11212c.onClick(view);
                }
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_bottom_menu;
    }
}
