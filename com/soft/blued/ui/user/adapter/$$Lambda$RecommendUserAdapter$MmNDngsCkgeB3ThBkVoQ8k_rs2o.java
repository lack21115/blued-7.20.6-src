package com.soft.blued.ui.user.adapter;

import android.view.View;
import com.soft.blued.ui.find.model.UserFindResult;

/* renamed from: com.soft.blued.ui.user.adapter.-$$Lambda$RecommendUserAdapter$MmNDngsCkgeB3ThBkVoQ8k_rs2o  reason: invalid class name */
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/-$$Lambda$RecommendUserAdapter$MmNDngsCkgeB3ThBkVoQ8k_rs2o.class */
public final /* synthetic */ class $$Lambda$RecommendUserAdapter$MmNDngsCkgeB3ThBkVoQ8k_rs2o implements View.OnClickListener {
    private final /* synthetic */ RecommendUserAdapter f$0;
    private final /* synthetic */ UserFindResult f$1;

    public /* synthetic */ $$Lambda$RecommendUserAdapter$MmNDngsCkgeB3ThBkVoQ8k_rs2o(RecommendUserAdapter recommendUserAdapter, UserFindResult userFindResult) {
        this.f$0 = recommendUserAdapter;
        this.f$1 = userFindResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecommendUserAdapter.b(this.f$0, this.f$1, view);
    }
}
