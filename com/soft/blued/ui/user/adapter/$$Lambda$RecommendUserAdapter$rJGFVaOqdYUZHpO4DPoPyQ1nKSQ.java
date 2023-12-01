package com.soft.blued.ui.user.adapter;

import android.view.View;
import com.soft.blued.ui.find.model.UserFindResult;

/* renamed from: com.soft.blued.ui.user.adapter.-$$Lambda$RecommendUserAdapter$rJGFVaOqdYUZHpO4DPoPyQ1nKSQ  reason: invalid class name */
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/-$$Lambda$RecommendUserAdapter$rJGFVaOqdYUZHpO4DPoPyQ1nKSQ.class */
public final /* synthetic */ class $$Lambda$RecommendUserAdapter$rJGFVaOqdYUZHpO4DPoPyQ1nKSQ implements View.OnClickListener {
    private final /* synthetic */ RecommendUserAdapter f$0;
    private final /* synthetic */ UserFindResult f$1;

    public /* synthetic */ $$Lambda$RecommendUserAdapter$rJGFVaOqdYUZHpO4DPoPyQ1nKSQ(RecommendUserAdapter recommendUserAdapter, UserFindResult userFindResult) {
        this.f$0 = recommendUserAdapter;
        this.f$1 = userFindResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecommendUserAdapter.a(this.f$0, this.f$1, view);
    }
}
