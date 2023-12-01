package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.soft.blued.ui.find.model.UserFindResult;

/* renamed from: com.soft.blued.ui.user.adapter.-$$Lambda$RecommendUserMoreAdapter$-IdocKsQi9rrqfO1fIHuB5d3Toc  reason: invalid class name */
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/-$$Lambda$RecommendUserMoreAdapter$-IdocKsQi9rrqfO1fIHuB5d3Toc.class */
public final /* synthetic */ class $$Lambda$RecommendUserMoreAdapter$IdocKsQi9rrqfO1fIHuB5d3Toc implements View.OnClickListener {
    private final /* synthetic */ UserFindResult f$0;
    private final /* synthetic */ ImageView f$1;
    private final /* synthetic */ RecommendUserMoreAdapter f$2;
    private final /* synthetic */ ShapeRelativeLayout f$3;

    public /* synthetic */ $$Lambda$RecommendUserMoreAdapter$IdocKsQi9rrqfO1fIHuB5d3Toc(UserFindResult userFindResult, ImageView imageView, RecommendUserMoreAdapter recommendUserMoreAdapter, ShapeRelativeLayout shapeRelativeLayout) {
        this.f$0 = userFindResult;
        this.f$1 = imageView;
        this.f$2 = recommendUserMoreAdapter;
        this.f$3 = shapeRelativeLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecommendUserMoreAdapter.a(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
