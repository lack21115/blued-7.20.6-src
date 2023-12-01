package com.blued.community.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.dialog.FeedBubblePostGuideDlgFragment;
import com.blued.community.ui.feed.dialog.FeedBubbleRewardDlgFragment;
import com.blued.community.ui.feed.dialog.FeedBubbleSayHiDlgFragment;
import com.blued.community.ui.feed.dialog.FeedInteractPopWindow;
import com.blued.community.ui.feed.dialog.FeedMineVisitTipsDlgFragment;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.feed.model.FeedBubbleListGuideExtra;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.community.ui.subject.fragment.FeedSubjectDetailFragment;
import com.blued.community.ui.subject.fragment.FeedSubjectListFragment;
import com.blued.community.ui.subject.fragment.FeedSubjectSearchFragment;
import com.blued.community.ui.subject.fragment.MySubjectFragment;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/utils/CommRouteUtil.class */
public class CommRouteUtil {
    public static void a(Context context) {
        if (context == null) {
            return;
        }
        FeedAddPostFragment.a(context);
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, (String) null);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("topic_id", str);
        bundle.putString("topic_name", str2);
        bundle.putString("insert_tt_dids", str3);
        TerminalActivity.a(bundle);
        TerminalActivity.d(context, FeedSubjectDetailFragment.class, bundle);
    }

    public static void a(BaseFragment baseFragment, View view, BluedIngSelfFeed bluedIngSelfFeed, LogData logData) {
        int c2;
        boolean z;
        if (baseFragment.getContext() == null || view == null) {
            return;
        }
        LogData logData2 = logData;
        if (logData == null) {
            logData2 = new LogData();
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        PopupPosition popupPosition = PopupPosition.Top;
        if (iArr[1] < FeedMethods.c(152)) {
            popupPosition = PopupPosition.Bottom;
            c2 = FeedMethods.c(-32);
            z = false;
        } else {
            c2 = FeedMethods.c(22);
            z = true;
        }
        new XPopup.Builder(baseFragment.getContext()).a(PopupAnimation.NoAnimation).c((Boolean) false).d((Boolean) false).a(popupPosition).b((Boolean) true).a((Boolean) true).a(false).c(c2).b(FeedMethods.c(-10)).a(view).a((BasePopupView) new FeedInteractPopWindow(baseFragment.getContext(), bluedIngSelfFeed, logData2, z, baseFragment.getFragmentActive())).h();
    }

    public static void a(BaseFragment baseFragment, BluedIngSelfFeed bluedIngSelfFeed, int[] iArr) {
        FeedBubbleSayHiDlgFragment feedBubbleSayHiDlgFragment = new FeedBubbleSayHiDlgFragment(baseFragment.getContext(), bluedIngSelfFeed, iArr[1], baseFragment.getFragmentActive());
        feedBubbleSayHiDlgFragment.setCancelable(false);
        feedBubbleSayHiDlgFragment.show(baseFragment.getFragmentManager(), feedBubbleSayHiDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, FeedBubbleListGuideExtra feedBubbleListGuideExtra) {
        if (baseFragment == null || baseFragment.getActivity() == null || feedBubbleListGuideExtra == null) {
            return;
        }
        FeedBubblePostGuideDlgFragment feedBubblePostGuideDlgFragment = new FeedBubblePostGuideDlgFragment(baseFragment.getActivity(), feedBubbleListGuideExtra);
        feedBubblePostGuideDlgFragment.setCancelable(false);
        feedBubblePostGuideDlgFragment.show(baseFragment.getFragmentManager(), feedBubblePostGuideDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, String str, String str2, String str3, String str4) {
        FeedBubbleRewardDlgFragment feedBubbleRewardDlgFragment = new FeedBubbleRewardDlgFragment(baseFragment.getActivity(), str, str2, str3, str4);
        feedBubbleRewardDlgFragment.setCancelable(false);
        feedBubbleRewardDlgFragment.show(baseFragment.getFragmentManager(), feedBubbleRewardDlgFragment.b());
    }

    public static void a(BaseFragment baseFragment, int[] iArr) {
        FeedMineVisitTipsDlgFragment feedMineVisitTipsDlgFragment = new FeedMineVisitTipsDlgFragment(baseFragment.getContext(), iArr[0], iArr[1], baseFragment.getFragmentActive());
        feedMineVisitTipsDlgFragment.setCancelable(true);
        feedMineVisitTipsDlgFragment.show(baseFragment.getFragmentManager(), feedMineVisitTipsDlgFragment.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.blued.android.core.ui.BaseFragment r7, com.blued.community.model.OperatePromotionPopup r8, java.lang.String r9, int r10, int r11, int r12, android.os.Bundle r13, int r14, long r15, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.utils.CommRouteUtil.a(com.blued.android.core.ui.BaseFragment, com.blued.community.model.OperatePromotionPopup, java.lang.String, int, int, int, android.os.Bundle, int, long, int, int):boolean");
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        TerminalActivity.d(context, FeedSubjectListFragment.class, null);
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        TerminalActivity.d(context, FeedSubjectSearchFragment.class, null);
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        TerminalActivity.d(context, MySubjectFragment.class, null);
    }
}
