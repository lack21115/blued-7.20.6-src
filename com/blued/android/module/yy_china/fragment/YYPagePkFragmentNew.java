package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.fragment.YYPagePkFragment;
import com.blued.android.module.yy_china.model.YYEventMatching;
import com.blued.android.module.yy_china.model.YYInvitationPkModel;
import com.blued.android.module.yy_china.model.YYRecommendPkModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYPagePkFragmentNew.class */
public final class YYPagePkFragmentNew extends YYPagePkFragment {
    private YYSearchDialogFragmentNew b;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYPagePkFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYSearchDialogFragmentNew yYSearchDialogFragmentNew = new YYSearchDialogFragmentNew();
        this$0.b = yYSearchDialogFragmentNew;
        if (yYSearchDialogFragmentNew == null) {
            return;
        }
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        yYSearchDialogFragmentNew.show(childFragmentManager, "search_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYPagePkFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYRoomModel g = this$0.g();
        String str = null;
        String str2 = g == null ? null : g.room_id;
        YYRecommendPkModel i = this$0.i();
        String str3 = i == null ? null : i.room_id;
        YYRecommendPkModel i2 = this$0.i();
        if (i2 != null) {
            str = i2.uid;
        }
        this$0.b(str2, str3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYPagePkFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYVoteTimeModel h = this$0.h();
        if (h != null) {
            int i = h.timeMill;
            ToggleButton d = this$0.d();
            if (d != null) {
                boolean isChecked = d.isChecked();
                YYRoomModel g = this$0.g();
                EventTrackYY.a(g == null ? null : g.room_id, isChecked, i);
            }
        }
        this$0.m();
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void a(int i, int i2) {
        YYRoomModel g = g();
        String str = g == null ? null : g.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.b(str, i, i2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragmentNew$setConfigure$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                TextView e = YYPagePkFragmentNew.this.e();
                if (e == null) {
                    return;
                }
                e.setText("");
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void a(View view) {
        Intrinsics.e(view, "view");
        super.a(view);
        ShapeTextView a2 = a();
        if (a2 == null) {
            return;
        }
        a2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragmentNew$DuyHWAxp1riIdS0UEJ_fUrtvVy8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPagePkFragmentNew.c(YYPagePkFragmentNew.this, view2);
            }
        });
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void a(YYConstants.MatchingFromSource type) {
        Intrinsics.e(type, "type");
        try {
            YYEventMatching yYEventMatching = new YYEventMatching();
            yYEventMatching.matchType = type;
            LiveEventBus.get("show_matching_pk_new").post(yYEventMatching);
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseDialogFragment");
            }
            ((BaseDialogFragment) parentFragment).dismiss();
        } catch (Exception e) {
        }
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void a(String str, String str2, String str3) {
        YYRoomModel g = g();
        String str4 = g == null ? null : g.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.b(str4, str2, str3, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragmentNew$sendInvitationPK$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYPagePkFragmentNew.this.a(YYConstants.MatchingFromSource.invitation);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void b(String str, String str2, String str3) {
        YYVoteTimeModel h = h();
        if (h != null) {
            EventTrackYY.a(str, str2, str3, h.timeMill);
        }
        a(str, str2, str3);
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void j() {
        YYRoomModel g = g();
        YYRoomHttpUtils.f(g == null ? null : g.room_id, (BluedUIHttpResponse) k(), getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void l() {
        YYRoomModel g = g();
        String str = g == null ? null : g.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.c(str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYRecommendPkModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragmentNew$getRecommendList$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRecommendPkModel> bluedEntityA) {
                YYPagePkFragment.RoomAdapter f = YYPagePkFragmentNew.this.f();
                if (f == null) {
                    return;
                }
                List<YYRecommendPkModel> list = bluedEntityA == null ? null : bluedEntityA.data;
                Intrinsics.a(list);
                f.addData((Collection) list);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment
    public void m() {
        YYVoteTimeModel h = h();
        if (h == null) {
            return;
        }
        int i = h.timeMill;
        YYRoomModel g = g();
        String str = g == null ? null : g.room_id;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        YYRoomHttpUtils.l(str, i, new BluedUIHttpResponse<BluedEntityA<YYInvitationPkModel>>(fragmentActive) { // from class: com.blued.android.module.yy_china.fragment.YYPagePkFragmentNew$autoMatching$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYInvitationPkModel> bluedEntityA) {
                YYPagePkFragmentNew.this.a(YYConstants.MatchingFromSource.random);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYPagePkFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        LinearLayout b = b();
        if (b != null) {
            b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragmentNew$TADorNOZB4Lyu2FquhNcYCa3G-M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYPagePkFragmentNew.a(YYPagePkFragmentNew.this, view2);
                }
            });
        }
        ShapeTextView c2 = c();
        if (c2 == null) {
            return;
        }
        c2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYPagePkFragmentNew$FIZ36PEuwDvdN48c_KQKHqoe20M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                YYPagePkFragmentNew.b(YYPagePkFragmentNew.this, view2);
            }
        });
    }
}
