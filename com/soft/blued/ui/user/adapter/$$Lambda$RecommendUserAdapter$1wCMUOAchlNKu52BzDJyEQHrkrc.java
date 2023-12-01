package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import com.soft.blued.ui.find.model.UserFindResult;

/* renamed from: com.soft.blued.ui.user.adapter.-$$Lambda$RecommendUserAdapter$1wCMUOAchlNKu52BzDJyEQHrkrc  reason: invalid class name */
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/-$$Lambda$RecommendUserAdapter$1wCMUOAchlNKu52BzDJyEQHrkrc.class */
public final /* synthetic */ class $$Lambda$RecommendUserAdapter$1wCMUOAchlNKu52BzDJyEQHrkrc implements View.OnClickListener {
    private final /* synthetic */ UserFindResult f$0;
    private final /* synthetic */ ImageView f$1;
    private final /* synthetic */ RecommendUserAdapter f$2;

    public /* synthetic */ $$Lambda$RecommendUserAdapter$1wCMUOAchlNKu52BzDJyEQHrkrc(UserFindResult userFindResult, ImageView imageView, RecommendUserAdapter recommendUserAdapter) {
        this.f$0 = userFindResult;
        this.f$1 = imageView;
        this.f$2 = recommendUserAdapter;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecommendUserAdapter.a(this.f$0, this.f$1, this.f$2, view);
    }
}
