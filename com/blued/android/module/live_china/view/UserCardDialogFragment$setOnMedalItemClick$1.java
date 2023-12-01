package com.blued.android.module.live_china.view;

import com.blued.android.module.live_china.view.PopAnchorBadge;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$setOnMedalItemClick$1.class */
public final class UserCardDialogFragment$setOnMedalItemClick$1 implements PopAnchorBadge.DismissLisnter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UserCardDialogFragment f15289a;

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge.DismissLisnter
    public void a() {
        UserCardDialogFragment.UserCardOnclickListner userCardOnclickListner;
        userCardOnclickListner = this.f15289a.j;
        if (userCardOnclickListner == null) {
            return;
        }
        userCardOnclickListner.a();
    }

    @Override // com.blued.android.module.live_china.view.PopAnchorBadge.DismissLisnter
    public void b() {
        UserCardDialogFragment.UserCardOnclickListner userCardOnclickListner;
        userCardOnclickListner = this.f15289a.j;
        if (userCardOnclickListner == null) {
            return;
        }
        userCardOnclickListner.c();
    }
}
