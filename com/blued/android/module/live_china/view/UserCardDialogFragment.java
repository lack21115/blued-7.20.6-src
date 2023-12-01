package com.blued.android.module.live_china.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.UserMedalsAdapter;
import com.blued.android.module.live_china.databinding.LayoutUsercardDialogBinding;
import com.blued.android.module.live_china.fragment.LiveGoodsWallDialogFragment;
import com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BehalfExtra;
import com.blued.android.module.live_china.model.LiveFansGroupModel;
import com.blued.android.module.live_china.model.LiveMsgReportModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.LiveUserCardBadgeModel;
import com.blued.android.module.live_china.model.LiveUserCardGalleryItemModel;
import com.blued.android.module.live_china.model.LiveUserCardGoodsModel;
import com.blued.android.module.live_china.model.LiveUserCardGreatModel;
import com.blued.android.module.live_china.model.LiveUserCardModel;
import com.blued.android.module.live_china.model.LiveUserCardModelExtra;
import com.blued.android.module.live_china.model.LiveUserCardMouleModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveGiftAndMedalCardView;
import com.blued.android.module.live_china.view.PopActionSheet;
import com.blued.android.module.live_china.view.UserCardDialogFragment;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment.class */
public final class UserCardDialogFragment extends BottomSheetDialogFragment implements LiveUserRelationshipUtils.IAddOrRemoveAttentionDone {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f15275a = new Companion(null);
    private final Lazy b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15276c;
    private Context d;
    private BaseFragment e;
    private IRequestHost f;
    private long g;
    private short h;
    private ArrayList<String> i;
    private UserCardOnclickListner j;
    private final int k;
    private LiveUserCardModel l;
    private LiveRoomUserModel m;
    private boolean n;
    private final String o;
    private int p;
    private int q;
    private int r;
    private LiveMsgReportModel s;
    private LiveRoomData t;
    private BehalfExtra u;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$FROM_SOURCE.class */
    public interface FROM_SOURCE {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f15277a = Companion.f15278a;

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$FROM_SOURCE$Companion.class */
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ Companion f15278a = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$USER_PRIVILLAGE.class */
    public interface USER_PRIVILLAGE {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f15279a = Companion.f15280a;

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$USER_PRIVILLAGE$Companion.class */
        public static final class Companion {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ Companion f15280a = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$UserCardOnclickListner.class */
    public interface UserCardOnclickListner {
        void a();

        void a(LiveRoomUserModel liveRoomUserModel);

        void a(String str);

        void a(String str, LiveMsgReportModel liveMsgReportModel);

        void a(String str, String str2);

        void b();

        void b(String str, String str2);

        void c();

        void c(String str, String str2);

        void d();

        void d(String str, String str2);
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/UserCardDialogFragment$UserMedalAdapterForCard.class */
    public static final class UserMedalAdapterForCard extends UserMedalsAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f15281a;

        @Override // com.blued.android.module.live_china.adapter.UserMedalsAdapter
        public View a() {
            View inflate = LayoutInflater.from(this.f15281a).inflate(R.layout.item_user_anchor_medal4card, (ViewGroup) null);
            Intrinsics.c(inflate, "from(mContext).inflate(R…_anchor_medal4card, null)");
            return inflate;
        }
    }

    public UserCardDialogFragment() {
        this.b = LazyKt.a(new Function0<LayoutUsercardDialogBinding>() { // from class: com.blued.android.module.live_china.view.UserCardDialogFragment$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutUsercardDialogBinding invoke() {
                Context context;
                context = UserCardDialogFragment.this.d;
                Context context2 = context;
                if (context == null) {
                    Intrinsics.c("mContext");
                    context2 = null;
                }
                return LayoutUsercardDialogBinding.a(LayoutInflater.from(context2));
            }
        });
        this.i = new ArrayList<>();
        this.k = 1;
        this.l = new LiveUserCardModel();
        this.m = new LiveRoomUserModel();
        this.o = " ・ ";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0116, code lost:
        if (kotlin.jvm.internal.Intrinsics.a((java.lang.Object) r6, (java.lang.Object) "0") != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UserCardDialogFragment(com.blued.android.core.ui.BaseFragment r5) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.UserCardDialogFragment.<init>(com.blued.android.core.ui.BaseFragment):void");
    }

    private final void A() {
        int i = 1;
        if (!TextUtils.equals(LiveRoomInfo.a().f(), p())) {
            Logger.a("rrb", "isCurrentUserAManager = ", Integer.valueOf(this.q));
            i = LiveFloatManager.a().w() ? 2 : B() ? 3 : C() ? 4 : 0;
        }
        this.q = i;
    }

    private final boolean B() {
        if (LiveRoomManager.a().N() != null) {
            return LiveRoomManager.a().N().getCan_kick() == 1 || LiveRoomManager.a().N().getCan_mute() == 1;
        }
        return false;
    }

    private final boolean C() {
        return LiveRoomManager.a().p().can_kick == 1 || LiveRoomManager.a().p().can_mute == 1;
    }

    private final void D() {
        IRequestHost iRequestHost = this.f;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost2 = null;
        }
        UserCardDialogFragment$judgeIsJionFansGroup$1 userCardDialogFragment$judgeIsJionFansGroup$1 = new UserCardDialogFragment$judgeIsJionFansGroup$1(this, iRequestHost2);
        IRequestHost iRequestHost3 = this.f;
        if (iRequestHost3 == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost3 = null;
        }
        LiveRoomHttpUtils.l(userCardDialogFragment$judgeIsJionFansGroup$1, iRequestHost3);
    }

    /* JADX WARN: Removed duplicated region for block: B:189:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0646  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void E() {
        /*
            Method dump skipped, instructions count: 1680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.UserCardDialogFragment.E():void");
    }

    private final boolean F() {
        LiveRoomUserModel liveRoomUserModel = this.m;
        String str = liveRoomUserModel == null ? null : liveRoomUserModel.relationship;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 52) {
                if (hashCode != 56) {
                    if (hashCode == 1569 && str.equals("12")) {
                        G();
                        return false;
                    }
                } else if (str.equals("8")) {
                    G();
                    return false;
                }
            } else if (str.equals("4")) {
                TextView textView = v().D;
                Context context = this.d;
                if (context == null) {
                    Intrinsics.c("mContext");
                    context = null;
                }
                textView.setText(context.getString(R.string.liveVideo_livingView_label_inBlackList));
                v().D.setVisibility(0);
                v().r.setVisibility(8);
                return false;
            }
        }
        v().D.setVisibility(8);
        v().r.setVisibility(0);
        return true;
    }

    private final void G() {
        v().G.setVisibility(0);
        v().r.setVisibility(8);
        v().D.setVisibility(0);
        TextView textView = v().D;
        Context context = this.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        textView.setText(context2.getString(R.string.liveVideo_livingView_label_userBlockYou));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        if (r0.contains(r0 == null ? null : r0.uid) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01fa, code lost:
        if (r0.contains(r0 == null ? null : r0.uid) != false) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void H() {
        /*
            Method dump skipped, instructions count: 1379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.UserCardDialogFragment.H():void");
    }

    private final void I() {
        v().P.setVisibility(4);
        v().D.setVisibility(8);
        v().J.setVisibility(8);
        v().v.setVisibility(8);
        v().t.setVisibility(8);
        v().I.setVisibility(8);
        v().s.setVisibility(8);
    }

    private final void J() {
        v().G.setVisibility(8);
        v().P.setVisibility(4);
        v().r.setVisibility(8);
        v().D.setVisibility(8);
        v().v.setVisibility(8);
    }

    private final void K() {
        LiveRoomUserModel liveRoomUserModel;
        if (this.d == null) {
            return;
        }
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        IRequestHost iRequestHost = null;
        if (Intrinsics.a((Object) "fromname", (Object) (liveRoomUserModel2 == null ? null : liveRoomUserModel2.uid)) && (liveRoomUserModel = this.m) != null) {
            String str = liveRoomUserModel.name;
        }
        BluedUIHttpResponse<BluedEntity<LiveUserCardModel, LiveUserCardModelExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveUserCardModel, LiveUserCardModelExtra>>() { // from class: com.blued.android.module.live_china.view.UserCardDialogFragment$getUserinfo$2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                UserCardDialogFragment.this.a(false);
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LayoutUsercardDialogBinding v;
                UserCardDialogFragment.UserCardOnclickListner userCardOnclickListner;
                super.onUIFinish();
                v = UserCardDialogFragment.this.v();
                v.A.setVisibility(0);
                if (UserCardDialogFragment.this.h()) {
                    return;
                }
                if (UserCardDialogFragment.this.getFragmentManager() != null) {
                    UserCardDialogFragment.this.dismiss();
                    return;
                }
                userCardOnclickListner = UserCardDialogFragment.this.j;
                if (userCardOnclickListner == null) {
                    return;
                }
                userCardOnclickListner.a();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveUserCardModel, LiveUserCardModelExtra> bluedEntity) {
                LiveUserCardModelExtra liveUserCardModelExtra;
                List<LiveUserCardModel> list;
                UserCardDialogFragment.this.a(true);
                if (bluedEntity != null && (list = bluedEntity.data) != null) {
                    UserCardDialogFragment userCardDialogFragment = UserCardDialogFragment.this;
                    if (list.isEmpty() || list.size() <= 0) {
                        return;
                    }
                    LiveUserCardModel liveUserCardModel = list.get(0);
                    if (liveUserCardModel != null) {
                        userCardDialogFragment.l = liveUserCardModel;
                        if (liveUserCardModel.getUser() != null) {
                            LiveRoomUserModel user = liveUserCardModel.getUser();
                            Intrinsics.a(user);
                            userCardDialogFragment.m = user;
                        }
                        userCardDialogFragment.q();
                        userCardDialogFragment.s();
                        userCardDialogFragment.t();
                    }
                }
                if (bluedEntity == null || (liveUserCardModelExtra = bluedEntity.extra) == null) {
                    return;
                }
                UserCardDialogFragment.this.a(liveUserCardModelExtra.getBehalf());
            }
        };
        LiveRoomUserModel liveRoomUserModel3 = this.m;
        String str2 = liveRoomUserModel3 == null ? null : liveRoomUserModel3.uid;
        IRequestHost iRequestHost2 = this.f;
        if (iRequestHost2 == null) {
            Intrinsics.c("fragmentActive");
        } else {
            iRequestHost = iRequestHost2;
        }
        LiveRoomHttpUtils.f(bluedUIHttpResponse, str2, iRequestHost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRoomData it, UserCardDialogFragment this$0, View view) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        LiveProtos.Event event = LiveProtos.Event.LIVE_PK_GO_TA_CLICK;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        long j = it.lid;
        LiveRoomAnchorModel liveRoomAnchorModel = it.profile;
        EventTrackLive.d(event, e, g, String.valueOf(j), liveRoomAnchorModel == null ? null : liveRoomAnchorModel.uid);
        this$0.dismissAllowingStateLoss();
        LiveDataListManager.a().b(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, int i, String str) {
        UserCardOnclickListner userCardOnclickListner;
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        if (StringsKt.a(str, context2.getString(R.string.live_set_manager), true)) {
            this$0.n();
            return;
        }
        Context context3 = this$0.d;
        Context context4 = context3;
        if (context3 == null) {
            Intrinsics.c("mContext");
            context4 = null;
        }
        if (StringsKt.a(str, context4.getString(R.string.live_cancel_manage), true)) {
            this$0.o();
            return;
        }
        Context context5 = this$0.d;
        Context context6 = context5;
        if (context5 == null) {
            Intrinsics.c("mContext");
            context6 = null;
        }
        if (StringsKt.a(str, context6.getString(R.string.live_manager_list), true)) {
            UserCardOnclickListner userCardOnclickListner2 = this$0.j;
            if (userCardOnclickListner2 == null) {
                return;
            }
            userCardOnclickListner2.d();
            return;
        }
        Context context7 = this$0.d;
        Context context8 = context7;
        if (context7 == null) {
            Intrinsics.c("mContext");
            context8 = null;
        }
        if (StringsKt.a(str, context8.getString(R.string.live_temp_banned), true)) {
            UserCardOnclickListner userCardOnclickListner3 = this$0.j;
            if (userCardOnclickListner3 != null) {
                userCardOnclickListner3.b(this$0.k(), this$0.l());
            }
            InstantLog.b("live_banned_option_click", 0);
            return;
        }
        Context context9 = this$0.d;
        Context context10 = context9;
        if (context9 == null) {
            Intrinsics.c("mContext");
            context10 = null;
        }
        if (StringsKt.a(str, context10.getString(R.string.live_perm_banned), true)) {
            UserCardOnclickListner userCardOnclickListner4 = this$0.j;
            if (userCardOnclickListner4 != null) {
                userCardOnclickListner4.a(this$0.k());
            }
            InstantLog.b("live_banned_option_click", 1);
            return;
        }
        Context context11 = this$0.d;
        Context context12 = context11;
        if (context11 == null) {
            Intrinsics.c("mContext");
            context12 = null;
        }
        if (StringsKt.a(str, context12.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak), true)) {
            UserCardOnclickListner userCardOnclickListner5 = this$0.j;
            if (userCardOnclickListner5 != null) {
                userCardOnclickListner5.d(this$0.k(), this$0.l());
            }
            InstantLog.b("live_banned_option_click", 2);
            return;
        }
        Context context13 = this$0.d;
        if (context13 == null) {
            Intrinsics.c("mContext");
            context13 = null;
        }
        if (!StringsKt.a(str, context13.getString(R.string.liveVideo_livingView_label_kick), true) || (userCardOnclickListner = this$0.j) == null) {
            return;
        }
        userCardOnclickListner.a(this$0.k(), this$0.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, LiveRoomUserModel liveRoomUserModel, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(liveRoomUserModel, i, (LiveMsgReportModel) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, LiveUserCardGreatModel topOne, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(topOne, "$topOne");
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_PROFILE_FIRST_USER_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this$0.dismiss();
        UserCardOnclickListner userCardOnclickListner = this$0.j;
        if (userCardOnclickListner != null) {
            userCardOnclickListner.a();
        }
        this$0.v().T.setVisibility(4);
        try {
            ArrayList arrayList = new ArrayList();
            String g = LiveRoomManager.a().g();
            Intrinsics.c(g, "getInstance().anchorIdStr");
            arrayList.add(g);
            if (!TextUtils.isEmpty(topOne.getUid())) {
                String uid = topOne.getUid();
                Intrinsics.a((Object) uid);
                arrayList.add(uid);
            }
            LiveRoomManager.a().a(arrayList);
            BaseFragment baseFragment = this$0.e;
            BaseFragment baseFragment2 = baseFragment;
            if (baseFragment == null) {
                Intrinsics.c("mFragment");
                baseFragment2 = null;
            }
            UserCardDialogFragment userCardDialogFragment = new UserCardDialogFragment(baseFragment2);
            userCardDialogFragment.e(topOne.getUid());
            BaseFragment baseFragment3 = this$0.e;
            if (baseFragment3 == null) {
                Intrinsics.c("mFragment");
                baseFragment3 = null;
            }
            FragmentManager childFragmentManager = baseFragment3.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "mFragment.childFragmentManager");
            userCardDialogFragment.show(childFragmentManager, UserCardDialogFragment.class.getSimpleName());
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserCardDialogFragment this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        this$0.b(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UserCardDialogFragment this$0, View view) {
        LiveRoomData p;
        Intrinsics.e(this$0, "this$0");
        LiveProtos.Event event = LiveProtos.Event.LIVE_PROFILE_CARD_TO_PROFILE_CLICK;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        LiveRoomUserModel liveRoomUserModel = this$0.m;
        Integer num = null;
        EventTrackLive.e(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
        LiveRoomManager a2 = LiveRoomManager.a();
        boolean z = false;
        if (a2 != null && (p = a2.p()) != null && p.link_type == 4) {
            z = true;
        }
        if (z) {
            LiveProtos.Event event2 = LiveProtos.Event.USER_MIKE_USER_PHOTO_CARD_CLICK;
            String e2 = LiveRoomManager.a().e();
            String g2 = LiveRoomManager.a().g();
            LiveRoomUserModel liveRoomUserModel2 = this$0.m;
            EventTrackLive.d(event2, e2, g2, liveRoomUserModel2 == null ? null : liveRoomUserModel2.uid);
        }
        if (LiveRefreshUIObserver.a().f()) {
            this$0.dismiss();
            ArrayList<String> arrayList = this$0.i;
            LiveRoomUserModel liveRoomUserModel3 = this$0.m;
            if (arrayList.contains(liveRoomUserModel3 == null ? null : liveRoomUserModel3.uid)) {
                LiveRoomInfo a3 = LiveRoomInfo.a();
                Context context = this$0.d;
                if (context == null) {
                    Intrinsics.c("mContext");
                    context = null;
                }
                LiveRoomUserModel liveRoomUserModel4 = this$0.m;
                String str = liveRoomUserModel4 == null ? null : liveRoomUserModel4.uid;
                LiveRoomUserModel liveRoomUserModel5 = this$0.m;
                String str2 = liveRoomUserModel5 == null ? null : liveRoomUserModel5.name;
                LiveRoomUserModel liveRoomUserModel6 = this$0.m;
                String str3 = liveRoomUserModel6 == null ? null : liveRoomUserModel6.avatar;
                LiveRoomUserModel liveRoomUserModel7 = this$0.m;
                if (liveRoomUserModel7 != null) {
                    num = Integer.valueOf(liveRoomUserModel7.is_show_vip_page);
                }
                a3.a(context, str, str2, str3, num.intValue(), 1);
            } else {
                LiveRoomInfo a4 = LiveRoomInfo.a();
                Context context2 = this$0.d;
                if (context2 == null) {
                    Intrinsics.c("mContext");
                    context2 = null;
                }
                LiveRoomUserModel liveRoomUserModel8 = this$0.m;
                String str4 = liveRoomUserModel8 == null ? null : liveRoomUserModel8.uid;
                LiveRoomUserModel liveRoomUserModel9 = this$0.m;
                String str5 = liveRoomUserModel9 == null ? null : liveRoomUserModel9.name;
                LiveRoomUserModel liveRoomUserModel10 = this$0.m;
                String str6 = liveRoomUserModel10 == null ? null : liveRoomUserModel10.avatar;
                LiveRoomUserModel liveRoomUserModel11 = this$0.m;
                a4.a(context2, str4, str5, str6, (liveRoomUserModel11 == null ? null : Integer.valueOf(liveRoomUserModel11.is_show_vip_page)).intValue(), 2);
            }
            UserCardOnclickListner userCardOnclickListner = this$0.j;
            if (userCardOnclickListner == null) {
                return;
            }
            userCardOnclickListner.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(UserCardDialogFragment this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        this$0.c(z);
    }

    private final void b(boolean z) {
        if (z && j()) {
            LiveRoomUserModel liveRoomUserModel = this.m;
            if (liveRoomUserModel != null) {
                liveRoomUserModel.allow_active = 0;
            }
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
        UserCardOnclickListner userCardOnclickListner = this$0.j;
        if (userCardOnclickListner == null) {
            return;
        }
        LiveRoomUserModel liveRoomUserModel = this$0.m;
        userCardOnclickListner.a(liveRoomUserModel == null ? null : liveRoomUserModel.uid, this$0.s);
    }

    private final void c(boolean z) {
        if (z && j()) {
            LiveRoomUserModel liveRoomUserModel = this.m;
            if (liveRoomUserModel != null) {
                liveRoomUserModel.allow_active = 1;
            }
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomInfo a2 = LiveRoomInfo.a();
        Context context = this$0.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        if (a2.a(context2, new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$NAizD6hcNSTbOzcG07V8NDBhRBs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UserCardDialogFragment.a(view2);
            }
        })) {
            return;
        }
        this$0.dismiss();
        UserCardOnclickListner userCardOnclickListner = this$0.j;
        if (userCardOnclickListner == null) {
            return;
        }
        LiveRoomUserModel liveRoomUserModel = this$0.m;
        String str = liveRoomUserModel == null ? null : liveRoomUserModel.uid;
        LiveRoomUserModel liveRoomUserModel2 = this$0.m;
        userCardOnclickListner.c(str, liveRoomUserModel2 == null ? null : liveRoomUserModel2.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(UserCardDialogFragment this$0, View view) {
        ArrayList<String> arrayList;
        Intrinsics.e(this$0, "this$0");
        if (this$0.r == 3) {
            LiveProtos.Event event = LiveProtos.Event.PK_LIVE_PROFILE_FOLLOW_BTN_CLICK;
            long d = LiveRoomManager.a().d();
            LiveRoomUserModel liveRoomUserModel = this$0.m;
            String str = liveRoomUserModel == null ? null : liveRoomUserModel.uid;
            LiveRoomUserModel liveRoomUserModel2 = this$0.m;
            EventTrackLive.a(event, d, str, EventTrackLive.b(liveRoomUserModel2 == null ? null : liveRoomUserModel2.relationship));
        }
        if (this$0.q == 0 && (arrayList = this$0.i) != null && arrayList.size() > 0) {
            String str2 = this$0.i.get(0);
            LiveRoomUserModel liveRoomUserModel3 = this$0.m;
            if (TextUtils.equals(str2, liveRoomUserModel3 == null ? null : liveRoomUserModel3.uid)) {
                this$0.D();
                return;
            }
        }
        this$0.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
        UserCardOnclickListner userCardOnclickListner = this$0.j;
        if (userCardOnclickListner == null) {
            return;
        }
        userCardOnclickListner.a(this$0.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveProtos.Event event = LiveProtos.Event.LIVE_MANAGE_BTN_CLICK;
        String e = LiveRoomManager.a().e();
        LiveRoomUserModel liveRoomUserModel = this$0.m;
        EventTrackLive.a(event, e, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
        this$0.m();
        InstantLog.a("live_manage_btn_click");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomUserModel liveRoomUserModel = this$0.m;
        if (liveRoomUserModel != null && liveRoomUserModel.allow_active == this$0.k) {
            InstantLog.b("live_banned_option_click", 0);
            UserCardOnclickListner userCardOnclickListner = this$0.j;
            if (userCardOnclickListner == null) {
                return;
            }
            userCardOnclickListner.b(this$0.k(), this$0.l());
            return;
        }
        UserCardOnclickListner userCardOnclickListner2 = this$0.j;
        if (userCardOnclickListner2 != null) {
            LiveRoomUserModel liveRoomUserModel2 = this$0.m;
            String str = liveRoomUserModel2 == null ? null : liveRoomUserModel2.uid;
            LiveRoomUserModel liveRoomUserModel3 = this$0.m;
            userCardOnclickListner2.d(str, liveRoomUserModel3 == null ? null : liveRoomUserModel3.name);
        }
        InstantLog.b("live_banned_option_click", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        UserCardOnclickListner userCardOnclickListner = this$0.j;
        if (userCardOnclickListner == null) {
            return;
        }
        userCardOnclickListner.a(this$0.k(), this$0.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final UserCardDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        final BehalfExtra behalfExtra = this$0.u;
        if (behalfExtra == null) {
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f42543a = behalfExtra.getStatus() == 0 ? 1 : 0;
        EventTrackLive.h(LiveProtos.Event.LIVE_PROFILE_CARD_SUBSTITUTE_ME_SHOW, String.valueOf(intRef.f42543a));
        int i = intRef.f42543a;
        IRequestHost iRequestHost = this$0.f;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost2 = null;
        }
        final IRequestHost iRequestHost3 = iRequestHost2;
        BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveFansGroupModel>>(iRequestHost3) { // from class: com.blued.android.module.live_china.view.UserCardDialogFragment$initClick$12$1$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveFansGroupModel> bluedEntityA) {
                BehalfExtra.this.setStatus(intRef.f42543a);
                this$0.a(BehalfExtra.this);
                ToastUtils.a(bluedEntityA == null ? null : bluedEntityA.message);
            }
        };
        IRequestHost iRequestHost4 = this$0.f;
        if (iRequestHost4 == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost4 = null;
        }
        LiveRoomHttpUtils.g(i, bluedUIHttpResponse, iRequestHost4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutUsercardDialogBinding v() {
        return (LayoutUsercardDialogBinding) this.b.getValue();
    }

    private final void w() {
        y();
    }

    private final int x() {
        DisplayMetrics displayMetrics;
        Context context = this.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        Resources resources = context2.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    private final void y() {
        if (this.d == null) {
            return;
        }
        LiveProtos.Event event = LiveProtos.Event.LIVE_PROFILE_CARD_SHOW;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        LiveRoomUserModel liveRoomUserModel = this.m;
        EventTrackLive.e(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
        v().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$f3l4jRyujs61E4r7fHPBpBYQhWI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.a(UserCardDialogFragment.this, view);
            }
        });
        v().x.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$TnL82s4VjiPOcHOIAqD8z14US1M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.b(UserCardDialogFragment.this, view);
            }
        });
        v().P.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$TLzSnWPqO-FmekFUfUwVgBopBEQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.c(UserCardDialogFragment.this, view);
            }
        });
        v().u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$vlGu57ue5XgU0Q_oneSy42fSF-A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.d(UserCardDialogFragment.this, view);
            }
        });
        v().q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$oa7RLi6zJom5HtA9UH8OPZoiNOs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.e(UserCardDialogFragment.this, view);
            }
        });
        v().s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$xItMfsAgAi2glnXLfN7-yuDrGrg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.f(UserCardDialogFragment.this, view);
            }
        });
        v().t.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$7U8w6PVqEXG4TvADjzz8UR065R0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.g(UserCardDialogFragment.this, view);
            }
        });
        v().Q.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$WQluh3r4Fbzh8NYxi3_x8RbVA8o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.h(UserCardDialogFragment.this, view);
            }
        });
        v().L.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$9jLzl56kd1mHV4OEKvtDfMIY7zM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.i(UserCardDialogFragment.this, view);
            }
        });
        final LiveRoomData liveRoomData = this.t;
        if (liveRoomData != null) {
            v().m.setVisibility(0);
            v().P.setVisibility(8);
            v().m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$xuPS7Cw_atRynyNFY01ttGifsBc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserCardDialogFragment.a(LiveRoomData.this, this, view);
                }
            });
        }
        v().R.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$Xlygtz9lO7d_sIEQOOV359thQ2I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCardDialogFragment.j(UserCardDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void z() {
        /*
            Method dump skipped, instructions count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.UserCardDialogFragment.z():void");
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void Q_() {
    }

    public final void a(BehalfExtra behalfExtra) {
        if (TextUtils.equals(this.m.uid, LiveRoomInfo.a().f())) {
            this.u = behalfExtra;
            if (behalfExtra == null) {
                return;
            }
            ShapeModel shapeModel = v().R.getShapeModel();
            EventTrackLive.h(LiveProtos.Event.LIVE_PROFILE_CARD_SUBSTITUTE_ME_SHOW, String.valueOf(behalfExtra.getStatus()));
            int status = behalfExtra.getStatus();
            if (status == 0) {
                ShapeTextView shapeTextView = v().R;
                Intrinsics.c(shapeTextView, "vb.tvUserCardBehalfStatus");
                BluedViewExKt.b(shapeTextView);
                v().R.setText(behalfExtra.getSwitch_enable_name());
                shapeModel.t = getResources().getColor(R.color.syc_dark_f8f8f8);
                shapeModel.v = getResources().getColor(R.color.syc_dark_f8f8f8);
                shapeModel.H = UiUtils.a(getContext(), 20.0f);
                v().R.setTextColor(getResources().getColor(R.color.syc_999999));
                shapeModel.b = getResources().getColor(R.color.syc_999999);
                Drawable drawable = getResources().getDrawable(R.drawable.img_behalf_gift_disnabel);
                Intrinsics.c(drawable, "resources.getDrawable(R.…img_behalf_gift_disnabel)");
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                v().R.setCompoundDrawablesRelative(drawable, null, null, null);
            } else if (status != 1) {
                ShapeTextView shapeTextView2 = v().R;
                Intrinsics.c(shapeTextView2, "vb.tvUserCardBehalfStatus");
                BluedViewExKt.a(shapeTextView2);
            } else {
                ShapeTextView shapeTextView3 = v().R;
                Intrinsics.c(shapeTextView3, "vb.tvUserCardBehalfStatus");
                BluedViewExKt.b(shapeTextView3);
                v().R.setText(behalfExtra.getSwitch_disable_name());
                shapeModel.t = getResources().getColor(R.color.syc_dark_922CEE);
                shapeModel.v = getResources().getColor(R.color.syc_dark_FF3AAA);
                shapeModel.H = UiUtils.a(getContext(), 20.0f);
                Drawable drawable2 = getResources().getDrawable(R.drawable.img_behalf_gift_enabel);
                Intrinsics.c(drawable2, "resources.getDrawable(R.…e.img_behalf_gift_enabel)");
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                shapeModel.b = getResources().getColor(R.color.white);
                v().R.setCompoundDrawablesRelative(drawable2, null, null, null);
                v().R.setTextColor(getResources().getColor(R.color.white));
            }
            v().R.setShapeModel(shapeModel);
        }
    }

    public final void a(LiveRoomData liveRoomData) {
        if (liveRoomData == null) {
            return;
        }
        this.t = liveRoomData;
        LiveRoomAnchorModel liveRoomAnchorModel = liveRoomData.profile;
        e(liveRoomAnchorModel == null ? null : liveRoomAnchorModel.uid);
    }

    public final void a(LiveRoomUserModel liveRoomUserModel) {
        a(liveRoomUserModel, 0, (LiveMsgReportModel) null);
    }

    public final void a(final LiveRoomUserModel liveRoomUserModel, final int i) {
        Context context = null;
        if (!PlayingOnliveFragment.aa) {
            a(liveRoomUserModel, i, (LiveMsgReportModel) null);
            return;
        }
        Context context2 = this.d;
        if (context2 == null) {
            Intrinsics.c("mContext");
        } else {
            context = context2;
        }
        KeyboardUtils.a((Activity) context);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$3BeuuO3Oeh85-91pWkAE7Ubgsxk
            @Override // java.lang.Runnable
            public final void run() {
                UserCardDialogFragment.a(UserCardDialogFragment.this, liveRoomUserModel, i);
            }
        }, 500L);
    }

    public final void a(LiveRoomUserModel liveRoomUserModel, int i, LiveMsgReportModel liveMsgReportModel) {
        if (this.d == null) {
            return;
        }
        if (liveRoomUserModel == null || (TextUtils.isEmpty(liveRoomUserModel.uid) && TextUtils.isEmpty(liveRoomUserModel.name))) {
            AppMethods.d(R.string.live_usercard_fail_tip);
            return;
        }
        this.s = liveMsgReportModel;
        this.r = i;
        if (this.j == null) {
            this.j = new UserCardOnclickListner() { // from class: com.blued.android.module.live_china.view.UserCardDialogFragment$showMenu$4
                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a() {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(LiveRoomUserModel liveRoomUserModel2) {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(String str) {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(String str, LiveMsgReportModel liveMsgReportModel2) {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void a(String str, String str2) {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void b() {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void b(String str, String str2) {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void c() {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void c(String str, String str2) {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void d() {
                }

                @Override // com.blued.android.module.live_china.view.UserCardDialogFragment.UserCardOnclickListner
                public void d(String str, String str2) {
                }
            };
        }
        UserCardOnclickListner userCardOnclickListner = this.j;
        if (userCardOnclickListner != null) {
            userCardOnclickListner.b();
        }
        v().T.setVisibility(4);
        this.m = liveRoomUserModel;
        Dialog dialog = getDialog();
        boolean z = false;
        if (dialog != null && true == dialog.isShowing()) {
            z = true;
        }
        if (z) {
            dismiss();
        }
        q();
        K();
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void a(String relation) {
        Intrinsics.e(relation, "relation");
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            liveRoomUserModel.relationship = relation;
        }
        RelationInfo relationInfo = new RelationInfo();
        relationInfo.setRelation(relation);
        relationInfo.setUid(k());
        LiveEventBus.get("live_attention_relation_changed").post(relationInfo);
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        if (Intrinsics.a((Object) (liveRoomUserModel2 == null ? null : liveRoomUserModel2.uid), (Object) p())) {
            LiveMsgSendManager.a().k();
        }
        LiveRoomData p = LiveRoomManager.a().p();
        if (p != null) {
            LiveProtos.Event event = LiveProtos.Event.USER_PROFILE_FOLLOW_BTN_CLICK;
            long j = p.lid;
            String g = LiveRoomManager.a().g();
            LiveRoomUserModel liveRoomUserModel3 = this.m;
            EventTrackLive.a(event, String.valueOf(j), g, liveRoomUserModel3 == null ? null : liveRoomUserModel3.uid, p.liveFrom, p.recommendType, p.livePosition);
        }
        Context context = this.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        LiveUserRelationshipUtils.a(context2, relation, v().B, null);
        d(relation);
        LiveRelationshipObserver a2 = LiveRelationshipObserver.a();
        LiveRoomUserModel liveRoomUserModel4 = this.m;
        a2.a(relation, liveRoomUserModel4 == null ? null : liveRoomUserModel4.uid);
    }

    public final void a(String str, int i) {
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            liveRoomUserModel.uid = str;
        }
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        if (liveRoomUserModel2 != null) {
            liveRoomUserModel2.name = "";
        }
        LiveRoomUserModel liveRoomUserModel3 = this.m;
        if (liveRoomUserModel3 != null) {
            liveRoomUserModel3.avatar = "";
        }
        a(this.m, i);
    }

    public final void a(String str, LiveMsgReportModel liveMsgReportModel) {
        Intrinsics.e(liveMsgReportModel, "liveMsgReportModel");
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            liveRoomUserModel.uid = str;
        }
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        if (liveRoomUserModel2 != null) {
            liveRoomUserModel2.name = "";
        }
        LiveRoomUserModel liveRoomUserModel3 = this.m;
        if (liveRoomUserModel3 != null) {
            liveRoomUserModel3.avatar = "";
        }
        a(this.m, 0, liveMsgReportModel);
    }

    public final void a(List<String> hostUIDS) {
        Intrinsics.e(hostUIDS, "hostUIDS");
        this.i.clear();
        this.i.addAll(hostUIDS);
    }

    public final void a(boolean z) {
        this.n = z;
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void b(String relation) {
        Intrinsics.e(relation, "relation");
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            liveRoomUserModel.relationship = relation;
        }
        RelationInfo relationInfo = new RelationInfo();
        relationInfo.setRelation(relation);
        relationInfo.setUid(k());
        LiveEventBus.get("live_attention_relation_changed").post(relationInfo);
        Context context = this.d;
        Context context2 = context;
        if (context == null) {
            Intrinsics.c("mContext");
            context2 = null;
        }
        LiveUserRelationshipUtils.a(context2, relation, v().B, null);
        d(relation);
        LiveRelationshipObserver a2 = LiveRelationshipObserver.a();
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        a2.a(relation, liveRoomUserModel2 == null ? null : liveRoomUserModel2.uid);
    }

    public final void b(String str, LiveMsgReportModel liveMsgReportModel) {
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            liveRoomUserModel.name = str;
        }
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        if (liveRoomUserModel2 != null) {
            liveRoomUserModel2.uid = "fromname";
        }
        LiveRoomUserModel liveRoomUserModel3 = this.m;
        if (liveRoomUserModel3 != null) {
            liveRoomUserModel3.avatar = "";
        }
        a(this.m, 0, liveMsgReportModel);
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void c() {
    }

    public final void c(String str) {
        if (str == null) {
            return;
        }
        this.i.clear();
        this.i.add(str);
    }

    @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
    public void d() {
    }

    public final void d(String relationship) {
        Intrinsics.e(relationship, "relationship");
        if (Intrinsics.a((Object) "0", (Object) relationship)) {
            v().B.setTextColor(Color.parseColor("#2B72FF"));
        } else if (Intrinsics.a((Object) "2", (Object) relationship)) {
            v().B.setTextColor(Color.parseColor("#2B72FF"));
        } else {
            v().B.setTextColor(Color.parseColor("#777777"));
        }
    }

    public final void e(String str) {
        a(str, 0);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment
    public boolean e() {
        return true;
    }

    public final void f(String str) {
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            liveRoomUserModel.name = str;
        }
        LiveRoomUserModel liveRoomUserModel2 = this.m;
        if (liveRoomUserModel2 != null) {
            liveRoomUserModel2.uid = "fromname";
        }
        LiveRoomUserModel liveRoomUserModel3 = this.m;
        if (liveRoomUserModel3 != null) {
            liveRoomUserModel3.avatar = "";
        }
        a(this.m, 0);
    }

    public final boolean h() {
        return this.n;
    }

    public final void i() {
        UserCardDialogFragment userCardDialogFragment = this;
        LiveEventBus.get("live_user_card_dismiss", String.class).observe(userCardDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$-52CEQFj7E-tCYZ20gqeBkYsAkA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserCardDialogFragment.a(UserCardDialogFragment.this, (String) obj);
            }
        });
        LiveEventBus.get("multi_dialog_banner", Boolean.TYPE).observe(userCardDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$SLHnz9nzcnPPuTVqqfgKdowtWaM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserCardDialogFragment.a(UserCardDialogFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        LiveEventBus.get("multi_dialog_banner_cancel", Boolean.TYPE).observe(userCardDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$YrOzj6YdmEUNiAWKrphrXJdr3-M
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UserCardDialogFragment.b(UserCardDialogFragment.this, ((Boolean) obj).booleanValue());
            }
        });
    }

    public final boolean j() {
        Dialog dialog = getDialog();
        if (dialog == null) {
            return false;
        }
        return dialog.isShowing();
    }

    public final String k() {
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel == null) {
            return null;
        }
        return liveRoomUserModel.uid;
    }

    public final String l() {
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel == null) {
            return null;
        }
        return liveRoomUserModel.name;
    }

    public final void m() {
        ArrayList arrayList = new ArrayList();
        LiveRoomUserModel liveRoomUserModel = this.m;
        Context context = null;
        if (liveRoomUserModel != null && liveRoomUserModel.allow_active == this.k) {
            LiveRoomUserModel liveRoomUserModel2 = this.m;
            if (liveRoomUserModel2 != null && liveRoomUserModel2.is_manager == 1) {
                Context context2 = this.d;
                Context context3 = context2;
                if (context2 == null) {
                    Intrinsics.c("mContext");
                    context3 = null;
                }
                String string = context3.getString(R.string.live_cancel_manage);
                Intrinsics.c(string, "mContext.getString(R.string.live_cancel_manage)");
                arrayList.add(string);
            } else {
                Context context4 = this.d;
                Context context5 = context4;
                if (context4 == null) {
                    Intrinsics.c("mContext");
                    context5 = null;
                }
                String string2 = context5.getString(R.string.live_set_manager);
                Intrinsics.c(string2, "mContext.getString(R.string.live_set_manager)");
                arrayList.add(string2);
            }
            Context context6 = this.d;
            Context context7 = context6;
            if (context6 == null) {
                Intrinsics.c("mContext");
                context7 = null;
            }
            String string3 = context7.getString(R.string.live_manager_list);
            Intrinsics.c(string3, "mContext.getString(R.string.live_manager_list)");
            arrayList.add(string3);
            Context context8 = this.d;
            Context context9 = context8;
            if (context8 == null) {
                Intrinsics.c("mContext");
                context9 = null;
            }
            String string4 = context9.getString(R.string.live_temp_banned);
            Intrinsics.c(string4, "mContext.getString(R.string.live_temp_banned)");
            arrayList.add(string4);
            Context context10 = this.d;
            Context context11 = context10;
            if (context10 == null) {
                Intrinsics.c("mContext");
                context11 = null;
            }
            String string5 = context11.getString(R.string.live_perm_banned);
            Intrinsics.c(string5, "mContext.getString(R.string.live_perm_banned)");
            arrayList.add(string5);
        } else {
            LiveRoomUserModel liveRoomUserModel3 = this.m;
            if (liveRoomUserModel3 != null && liveRoomUserModel3.is_manager == 1) {
                Context context12 = this.d;
                Context context13 = context12;
                if (context12 == null) {
                    Intrinsics.c("mContext");
                    context13 = null;
                }
                String string6 = context13.getString(R.string.live_cancel_manage);
                Intrinsics.c(string6, "mContext.getString(R.string.live_cancel_manage)");
                arrayList.add(string6);
            } else {
                Context context14 = this.d;
                Context context15 = context14;
                if (context14 == null) {
                    Intrinsics.c("mContext");
                    context15 = null;
                }
                String string7 = context15.getString(R.string.live_set_manager);
                Intrinsics.c(string7, "mContext.getString(R.string.live_set_manager)");
                arrayList.add(string7);
            }
            Context context16 = this.d;
            Context context17 = context16;
            if (context16 == null) {
                Intrinsics.c("mContext");
                context17 = null;
            }
            String string8 = context17.getString(R.string.live_manager_list);
            Intrinsics.c(string8, "mContext.getString(R.string.live_manager_list)");
            arrayList.add(string8);
            Context context18 = this.d;
            Context context19 = context18;
            if (context18 == null) {
                Intrinsics.c("mContext");
                context19 = null;
            }
            String string9 = context19.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak);
            Intrinsics.c(string9, "mContext.getString(R.str…abel_cancelForbidToSpeak)");
            arrayList.add(string9);
        }
        Context context20 = this.d;
        Context context21 = context20;
        if (context20 == null) {
            Intrinsics.c("mContext");
            context21 = null;
        }
        String string10 = context21.getString(R.string.liveVideo_livingView_label_kick);
        Intrinsics.c(string10, "mContext.getString(R.str…eo_livingView_label_kick)");
        arrayList.add(string10);
        int size = arrayList.size();
        int[] iArr = new int[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            iArr[i2] = R.color.syc_a;
            i = i2 + 1;
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        String[] strArr = (String[]) array;
        Context context22 = this.d;
        if (context22 == null) {
            Intrinsics.c("mContext");
            context22 = null;
        }
        LinearLayout linearLayout = v().t;
        Context context23 = this.d;
        if (context23 == null) {
            Intrinsics.c("mContext");
        } else {
            context = context23;
        }
        PopActionSheet.a(context22, linearLayout, strArr, iArr, DensityUtils.a(context, 200.0f), true, new PopActionSheet.PopSheetClickListner() { // from class: com.blued.android.module.live_china.view.-$$Lambda$UserCardDialogFragment$hOKD31THyGfQWRiG70MSentCbL4
            @Override // com.blued.android.module.live_china.view.PopActionSheet.PopSheetClickListner
            public final void onClick(int i3, String str) {
                UserCardDialogFragment.a(UserCardDialogFragment.this, i3, str);
            }
        });
        dismiss();
    }

    public final void n() {
        IRequestHost iRequestHost = this.f;
        String str = null;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost2 = null;
        }
        UserCardDialogFragment$setManager$1 userCardDialogFragment$setManager$1 = new UserCardDialogFragment$setManager$1(this, iRequestHost2);
        IRequestHost iRequestHost3 = this.f;
        IRequestHost iRequestHost4 = iRequestHost3;
        if (iRequestHost3 == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost4 = null;
        }
        long j = this.g;
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            str = liveRoomUserModel.uid;
        }
        LiveRoomHttpUtils.b(userCardDialogFragment$setManager$1, iRequestHost4, String.valueOf(j), str);
    }

    public final void o() {
        IRequestHost iRequestHost = this.f;
        String str = null;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost2 = null;
        }
        final IRequestHost iRequestHost3 = iRequestHost2;
        BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(iRequestHost3) { // from class: com.blued.android.module.live_china.view.UserCardDialogFragment$removeManager$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                Context context;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                context = UserCardDialogFragment.this.d;
                Context context2 = context;
                if (context == null) {
                    Intrinsics.c("mContext");
                    context2 = null;
                }
                AppMethods.a((CharSequence) context2.getResources().getString(R.string.live_manager_removed));
            }
        };
        IRequestHost iRequestHost4 = this.f;
        IRequestHost iRequestHost5 = iRequestHost4;
        if (iRequestHost4 == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost5 = null;
        }
        long j = this.g;
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            str = liveRoomUserModel.uid;
        }
        LiveRoomHttpUtils.c(bluedUIHttpResponse, iRequestHost5, String.valueOf(j), str);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        i();
        return super.onCreateView(inflater, viewGroup, bundle);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.e(dialog, "dialog");
        try {
            UserCardOnclickListner userCardOnclickListner = this.j;
            if (userCardOnclickListner != null) {
                userCardOnclickListner.a();
            }
        } catch (Exception e) {
        }
        super.onDismiss(dialog);
    }

    public final String p() {
        ArrayList<String> arrayList = this.i;
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        String str = this.i.get(0);
        Intrinsics.c(str, "{\n            hostUID[0]\n        }");
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0364  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q() {
        /*
            Method dump skipped, instructions count: 1648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.UserCardDialogFragment.q():void");
    }

    public final void r() {
        LiveRoomUserModel liveRoomUserModel = this.m;
        boolean z = false;
        if (liveRoomUserModel != null && liveRoomUserModel.allow_active == 0) {
            z = true;
        }
        Context context = null;
        if (z) {
            TextView textView = v().Q;
            Context context2 = this.d;
            if (context2 == null) {
                Intrinsics.c("mContext");
            } else {
                context = context2;
            }
            textView.setText(context.getString(R.string.liveVideo_livingView_label_cancelForbidToSpeak));
            return;
        }
        TextView textView2 = v().Q;
        Context context3 = this.d;
        if (context3 == null) {
            Intrinsics.c("mContext");
            context3 = null;
        }
        textView2.setText(context3.getString(R.string.liveVideo_livingView_label_forbidToSpeakButton));
    }

    public final void s() {
        LayoutUsercardDialogBinding v = v();
        String str = null;
        LiveUserCardModuleView liveUserCardModuleView = v == null ? null : v.y;
        LiveUserCardModel liveUserCardModel = this.l;
        List<LiveUserCardMouleModel> module = liveUserCardModel == null ? null : liveUserCardModel.getModule();
        LiveRoomUserModel liveRoomUserModel = this.m;
        if (liveRoomUserModel != null) {
            str = liveRoomUserModel.uid;
        }
        liveUserCardModuleView.a(module, str);
    }

    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        ViewParent parent;
        Intrinsics.e(dialog, "dialog");
        if (this.d == null) {
            return;
        }
        FrameLayout root = v().getRoot();
        if (root != null && (parent = root.getParent()) != null) {
            ((ViewGroup) parent).removeView(v().getRoot());
        }
        super.setupDialog(dialog, i);
        dialog.setContentView(v().getRoot());
        if (this.f15276c) {
            BottomSheetDialog R_ = R_();
            if (R_ != null) {
                R_.a(x());
            }
            ViewGroup.LayoutParams layoutParams = v().z.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            Context context = this.d;
            Context context2 = context;
            if (context == null) {
                Intrinsics.c("mContext");
                context2 = null;
            }
            layoutParams2.width = DensityUtils.a(context2, 400.0f);
            layoutParams2.height = -2;
            layoutParams2.gravity = 17;
            v().A.setBackgroundResource(R.drawable.shape_usercard_bg_all_radius);
            RelativeLayout relativeLayout = v().z;
            Context context3 = this.d;
            if (context3 == null) {
                Intrinsics.c("mContext");
                context3 = null;
            }
            relativeLayout.setPivotX(DensityUtils.a(context3, 200.0f));
            v().z.setPivotY(0.0f);
            v().z.setScaleX(0.85f);
            v().z.setScaleY(0.85f);
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        w();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        if (this.d == null) {
            return;
        }
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }

    public final void t() {
        LiveUserCardGoodsModel goods;
        LiveUserCardGoodsModel goods2;
        LiveUserCardBadgeModel badge;
        LiveUserCardGoodsModel goods3;
        LiveUserCardBadgeModel badge2;
        LiveUserCardGoodsModel goods4;
        ArrayList<LiveUserCardGalleryItemModel> data;
        LiveUserCardBadgeModel badge3;
        ArrayList<LiveUserCardGalleryItemModel> data2;
        ArrayList<LiveUserCardGalleryItemModel> arrayList = new ArrayList<>();
        ArrayList<LiveUserCardGalleryItemModel> arrayList2 = new ArrayList<>();
        LiveUserCardModel liveUserCardModel = this.l;
        if (liveUserCardModel != null && (badge3 = liveUserCardModel.getBadge()) != null && (data2 = badge3.getData()) != null) {
            Iterator<LiveUserCardGalleryItemModel> it = data2.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next());
            }
        }
        LiveUserCardModel liveUserCardModel2 = this.l;
        if (liveUserCardModel2 != null && (goods4 = liveUserCardModel2.getGoods()) != null && (data = goods4.getData()) != null) {
            Iterator<LiveUserCardGalleryItemModel> it2 = data.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
        LiveUserCardModel liveUserCardModel3 = this.l;
        String str = null;
        boolean isEmpty = TextUtils.isEmpty((liveUserCardModel3 == null || (goods = liveUserCardModel3.getGoods()) == null) ? null : goods.getTitle());
        boolean z = arrayList2.size() != 0;
        LiveGiftAndMedalCardView liveGiftAndMedalCardView = v().n;
        IRequestHost iRequestHost = this.f;
        IRequestHost iRequestHost2 = iRequestHost;
        if (iRequestHost == null) {
            Intrinsics.c("fragmentActive");
            iRequestHost2 = null;
        }
        LiveUserCardModel liveUserCardModel4 = this.l;
        String title = (liveUserCardModel4 == null || (goods2 = liveUserCardModel4.getGoods()) == null) ? null : goods2.getTitle();
        LiveUserCardModel liveUserCardModel5 = this.l;
        String title2 = (liveUserCardModel5 == null || (badge = liveUserCardModel5.getBadge()) == null) ? null : badge.getTitle();
        LiveUserCardModel liveUserCardModel6 = this.l;
        String desc = (liveUserCardModel6 == null || (goods3 = liveUserCardModel6.getGoods()) == null) ? null : goods3.getDesc();
        LiveUserCardModel liveUserCardModel7 = this.l;
        if (liveUserCardModel7 != null && (badge2 = liveUserCardModel7.getBadge()) != null) {
            str = badge2.getDesc();
        }
        liveGiftAndMedalCardView.a(iRequestHost2, title, title2, desc, str, arrayList, arrayList2, !isEmpty, z, new LiveGiftAndMedalCardView.CardArrowClickListener() { // from class: com.blued.android.module.live_china.view.UserCardDialogFragment$setUserGiftOrMedalCard$3
            @Override // com.blued.android.module.live_china.view.LiveGiftAndMedalCardView.CardArrowClickListener
            public void a() {
                LiveRoomUserModel liveRoomUserModel;
                LiveProtos.Event event = LiveProtos.Event.LIVE_PROFILE_CARD_GIFT_WALL_CLICK;
                String e = LiveRoomManager.a().e();
                String g = LiveRoomManager.a().g();
                liveRoomUserModel = UserCardDialogFragment.this.m;
                EventTrackLive.e(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
                TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
                LiveGoodsWallDialogFragment.Companion companion = LiveGoodsWallDialogFragment.f12934a;
                FragmentManager childFragmentManager = UserCardDialogFragment.this.getChildFragmentManager();
                Intrinsics.c(childFragmentManager, "childFragmentManager");
                companion.a(childFragmentManager);
            }

            @Override // com.blued.android.module.live_china.view.LiveGiftAndMedalCardView.CardArrowClickListener
            public void b() {
                LiveRoomUserModel liveRoomUserModel;
                LiveRoomUserModel liveRoomUserModel2;
                BaseFragment baseFragment;
                LiveProtos.Event event = LiveProtos.Event.LIVE_PROFILE_CARD_MEDAL_WALL_CLICK;
                String e = LiveRoomManager.a().e();
                String g = LiveRoomManager.a().g();
                liveRoomUserModel = UserCardDialogFragment.this.m;
                EventTrackLive.e(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
                LiveMedalWallDialogFragment.Companion companion = LiveMedalWallDialogFragment.f13060a;
                liveRoomUserModel2 = UserCardDialogFragment.this.m;
                FragmentManager childFragmentManager = UserCardDialogFragment.this.getChildFragmentManager();
                Intrinsics.c(childFragmentManager, "childFragmentManager");
                baseFragment = UserCardDialogFragment.this.e;
                BaseFragment baseFragment2 = baseFragment;
                if (baseFragment2 == null) {
                    Intrinsics.c("mFragment");
                    baseFragment2 = null;
                }
                companion.a(liveRoomUserModel2, childFragmentManager, baseFragment2);
            }
        });
    }

    public final void u() {
        if (j()) {
            dismissAllowingStateLoss();
        }
    }
}
