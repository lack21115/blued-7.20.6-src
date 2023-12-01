package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgAboutUser$addIconToChatBadge$1.class */
public final class FitemMsgAboutUser$addIconToChatBadge$1 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FitemMsgAboutUser f12546a;
    final /* synthetic */ int b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ int f12547c;
    final /* synthetic */ Context d;
    final /* synthetic */ TextView e;
    final /* synthetic */ LiveChatBadgeModel f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgAboutUser$addIconToChatBadge$1(FitemMsgAboutUser fitemMsgAboutUser, int i, int i2, Context context, TextView textView, LiveChatBadgeModel liveChatBadgeModel) {
        super(1);
        this.f12546a = fitemMsgAboutUser;
        this.b = i;
        this.f12547c = i2;
        this.d = context;
        this.e = textView;
        this.f = liveChatBadgeModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgAboutUser this$0, Context context, int i, int i2, TextView tv, LiveChatBadgeModel badgeModel, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        Intrinsics.e(tv, "$tv");
        Intrinsics.e(badgeModel, "$badgeModel");
        FrameLayout frameLayout = (FrameLayout) this$0.f10935a.a(R.id.fl_icon_root);
        if (frameLayout == null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = tv.getPaddingLeft() + i3;
        layoutParams.topMargin = tv.getPaddingTop() + i4;
        imageView.setLayoutParams(layoutParams);
        frameLayout.addView(imageView);
        String chat_badge_url = badgeModel.getChat_badge_url();
        if (chat_badge_url == null || chat_badge_url.length() == 0) {
            return;
        }
        IRequestHost iRequestHost = this$0.f10935a.b;
        String chat_badge_url2 = badgeModel.getChat_badge_url();
        Intrinsics.a((Object) chat_badge_url2);
        ImageLoader.a(iRequestHost, chat_badge_url2).g().g(-1).a(imageView);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        int i;
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        ColorDrawable colorDrawable = new ColorDrawable();
        i = this.f12546a.g;
        final int i2 = this.b;
        final int i3 = this.f12547c;
        final FitemMsgAboutUser fitemMsgAboutUser = this.f12546a;
        final Context context = this.d;
        final TextView textView = this.e;
        final LiveChatBadgeModel liveChatBadgeModel = this.f;
        buildSpannableString.a(colorDrawable, 0, i, i2, i3, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgAboutUser$addIconToChatBadge$1$KSbWWG_IeUHaC8F_DG3lcm0fmn4
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i4, int i5) {
                FitemMsgAboutUser$addIconToChatBadge$1.a(FitemMsgAboutUser.this, context, i2, i3, textView, liveChatBadgeModel, i4, i5);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.f42314a;
    }
}
