package com.blued.android.module.common.widget.menu;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.blued.android.module.common.widget.menu.BluedActionSheet;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/menu/ActionSheetItem.class */
public abstract class ActionSheetItem<VB extends ViewBinding> implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    protected VB f11204a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected BluedActionSheet.Builder f11205c;
    public BluedActionSheet.OnClickActionSheetListener d;
    public BluedActionSheet.ActionSheetListener e;

    public abstract void a(VB vb);

    public void a(ActionSheetViewHolder actionSheetViewHolder) {
        VB vb = (VB) actionSheetViewHolder.a();
        this.f11204a = vb;
        vb.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.widget.menu.ActionSheetItem.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ActionSheetItem.this.d != null) {
                    ActionSheetItem.this.d.onClickActionSheet(ActionSheetItem.this.f11205c.b());
                    if (ActionSheetItem.this.f11205c.c()) {
                        ActionSheetItem.this.f11205c.e();
                    }
                }
                if (ActionSheetItem.this.e != null) {
                    ActionSheetItem.this.e.a(ActionSheetItem.this.f11205c.b(), ActionSheetItem.this.b);
                    if (ActionSheetItem.this.f11205c.c()) {
                        ActionSheetItem.this.f11205c.e();
                    }
                }
            }
        });
        a((ActionSheetItem<VB>) this.f11204a);
    }

    public ActionSheetItem b(BluedActionSheet.OnClickActionSheetListener onClickActionSheetListener) {
        this.d = onClickActionSheetListener;
        return this;
    }
}
