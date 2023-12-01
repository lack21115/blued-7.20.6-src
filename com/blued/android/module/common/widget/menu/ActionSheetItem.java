package com.blued.android.module.common.widget.menu;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheetItem.class */
public abstract class ActionSheetItem<VB extends ViewBinding> implements MultiItemEntity {
    protected VB a;
    protected int b;
    protected BluedActionSheet.Builder c;
    public BluedActionSheet.OnClickActionSheetListener d;
    public BluedActionSheet.ActionSheetListener e;

    public abstract void a(VB vb);

    public void a(ActionSheetViewHolder actionSheetViewHolder) {
        VB vb = (VB) actionSheetViewHolder.a();
        this.a = vb;
        vb.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.menu.ActionSheetItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ActionSheetItem.this.d != null) {
                    ActionSheetItem.this.d.onClickActionSheet(ActionSheetItem.this.c.b());
                    if (ActionSheetItem.this.c.c()) {
                        ActionSheetItem.this.c.e();
                    }
                }
                if (ActionSheetItem.this.e != null) {
                    ActionSheetItem.this.e.a(ActionSheetItem.this.c.b(), ActionSheetItem.this.b);
                    if (ActionSheetItem.this.c.c()) {
                        ActionSheetItem.this.c.e();
                    }
                }
            }
        });
        a((ActionSheetItem<VB>) this.a);
    }

    public ActionSheetItem b(BluedActionSheet.OnClickActionSheetListener onClickActionSheetListener) {
        this.d = onClickActionSheetListener;
        return this;
    }
}
