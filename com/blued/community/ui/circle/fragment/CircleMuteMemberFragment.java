package com.blued.community.ui.circle.fragment;

import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.ui.circle.model.CircleBaseMember;
import com.blued.community.ui.circle.presenter.CircleMuteMemberPresenter;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMuteMemberFragment.class */
public class CircleMuteMemberFragment extends CircleJoinMemberFragment<CircleMuteMemberPresenter> {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CircleBaseMember.Member member, int i, BasePopupView basePopupView, View view) {
        j().a(member, i);
        if (basePopupView != null) {
            basePopupView.p();
        }
    }

    @Override // com.blued.community.ui.circle.fragment.CircleJoinMemberFragment
    protected void a(final CircleBaseMember.Member member, final int i) {
        ArrayList arrayList = new ArrayList();
        final BasePopupView a = CommonShowBottomWindow.a(getContext(), arrayList);
        BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
        menuItemInfo.a = getResources().getString(R.string.circle_member_mute_cancel);
        menuItemInfo.b = R.color.syc_g;
        menuItemInfo.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.-$$Lambda$CircleMuteMemberFragment$B6Er2Wy5jw9BNqGnamlunZ7EAP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CircleMuteMemberFragment.this.a(member, i, a, view);
            }
        };
        arrayList.add(menuItemInfo);
        a.h();
    }
}
