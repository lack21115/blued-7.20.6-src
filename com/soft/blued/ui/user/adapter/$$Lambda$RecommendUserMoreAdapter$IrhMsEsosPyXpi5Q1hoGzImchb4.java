package com.soft.blued.ui.user.adapter;

import android.view.View;
import com.soft.blued.ui.find.model.UserFindResult;

/* renamed from: com.soft.blued.ui.user.adapter.-$$Lambda$RecommendUserMoreAdapter$IrhMsEsosPyXpi5Q1hoGzImchb4  reason: invalid class name */
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/-$$Lambda$RecommendUserMoreAdapter$IrhMsEsosPyXpi5Q1hoGzImchb4.class */
public final /* synthetic */ class $$Lambda$RecommendUserMoreAdapter$IrhMsEsosPyXpi5Q1hoGzImchb4 implements View.OnClickListener {
    private final /* synthetic */ RecommendUserMoreAdapter f$0;
    private final /* synthetic */ UserFindResult f$1;

    public /* synthetic */ $$Lambda$RecommendUserMoreAdapter$IrhMsEsosPyXpi5Q1hoGzImchb4(RecommendUserMoreAdapter recommendUserMoreAdapter, UserFindResult userFindResult) {
        this.f$0 = recommendUserMoreAdapter;
        this.f$1 = userFindResult;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecommendUserMoreAdapter.a(this.f$0, this.f$1, view);
    }
}
