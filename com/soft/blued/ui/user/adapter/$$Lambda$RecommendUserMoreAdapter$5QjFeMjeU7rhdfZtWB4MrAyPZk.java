package com.soft.blued.ui.user.adapter;

import android.view.View;
import com.soft.blued.ui.find.model.UserFindResult;

/* renamed from: com.soft.blued.ui.user.adapter.-$$Lambda$RecommendUserMoreAdapter$5QjFeMjeU7rhd-fZtWB4MrAyPZk  reason: invalid class name */
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/-$$Lambda$RecommendUserMoreAdapter$5QjFeMjeU7rhd-fZtWB4MrAyPZk.class */
public final /* synthetic */ class $$Lambda$RecommendUserMoreAdapter$5QjFeMjeU7rhdfZtWB4MrAyPZk implements View.OnClickListener {
    private final /* synthetic */ RecommendUserMoreAdapter f$0;
    private final /* synthetic */ UserFindResult f$1;

    public /* synthetic */ $$Lambda$RecommendUserMoreAdapter$5QjFeMjeU7rhdfZtWB4MrAyPZk(RecommendUserMoreAdapter recommendUserMoreAdapter, UserFindResult userFindResult) {
        this.f$0 = recommendUserMoreAdapter;
        this.f$1 = userFindResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecommendUserMoreAdapter.b(this.f$0, this.f$1, view);
    }
}
