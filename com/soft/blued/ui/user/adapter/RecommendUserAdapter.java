package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.bytedance.ProfileEventUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ChatBundleExtra;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.utils.UserInfoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/RecommendUserAdapter.class */
public final class RecommendUserAdapter extends BaseQuickAdapter<UserFindResult, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f20058a;
    private final LogData b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendUserAdapter(IRequestHost iRequestHost, LogData logData) {
        super((int) R.layout.item_recommend_user);
        Intrinsics.e(iRequestHost, "requestHost");
        Intrinsics.e(logData, "logData");
        this.f20058a = iRequestHost;
        this.b = logData;
    }

    private final void a(UserFindResult userFindResult) {
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_SAME_POP_USER_CHAT_CLICK, userFindResult.uid);
        String name = PersonalProfileProtos.Event.PERSONAL_SAME_POP_USER_CHAT_CLICK.name();
        String str = userFindResult.uid;
        Intrinsics.c(str, "item.uid");
        ProfileEventUtils.a(name, str);
        try {
            ChatHelperV4 a2 = ChatHelperV4.a();
            Context context = this.mContext;
            String str2 = userFindResult.uid;
            Intrinsics.c(str2, "item.uid");
            a2.a(context, Long.parseLong(str2), userFindResult.name, userFindResult.avatar, userFindResult.vbadge, userFindResult.vip_grade, userFindResult.is_vip_annual, userFindResult.vip_exp_lvl, userFindResult.distance, false, 0, userFindResult.is_hide_vip_look, this.b, (MsgSourceEntity) null, (ChatBundleExtra) null);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(UserFindResult userFindResult, ImageView imageView, RecommendUserAdapter recommendUserAdapter, View view) {
        Tracker.onClick(view);
        Intrinsics.e(userFindResult, "$item");
        Intrinsics.e(recommendUserAdapter, "this$0");
        UserInfoUtils userInfoUtils = UserInfoUtils.f20642a;
        Intrinsics.c(imageView, "iv_attention");
        UserInfoUtils.a(userInfoUtils, userFindResult, imageView, recommendUserAdapter.f20058a, recommendUserAdapter.b, null, 16, null);
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_SAME_POP_USER_FOLLOW_CLICK, userFindResult.uid);
        String name = PersonalProfileProtos.Event.PERSONAL_SAME_POP_USER_FOLLOW_CLICK.name();
        String str = userFindResult.uid;
        Intrinsics.c(str, "item.uid");
        ProfileEventUtils.a(name, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendUserAdapter recommendUserAdapter, UserFindResult userFindResult, View view) {
        Tracker.onClick(view);
        Intrinsics.e(recommendUserAdapter, "this$0");
        Intrinsics.e(userFindResult, "$item");
        recommendUserAdapter.b(userFindResult);
    }

    private final void b(UserFindResult userFindResult) {
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_SAME_POP_USER_PHOTO_CLICK, userFindResult.uid);
        String name = PersonalProfileProtos.Event.PERSONAL_SAME_POP_USER_PHOTO_CLICK.name();
        String str = userFindResult.uid;
        Intrinsics.c(str, "item.uid");
        ProfileEventUtils.a(name, str);
        UserInfoFragmentNew.a(this.mContext, (UserBasicModel) userFindResult, "recommend_same", false, (MsgSourceEntity) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RecommendUserAdapter recommendUserAdapter, UserFindResult userFindResult, View view) {
        Tracker.onClick(view);
        Intrinsics.e(recommendUserAdapter, "this$0");
        Intrinsics.e(userFindResult, "$item");
        recommendUserAdapter.a(userFindResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
}
