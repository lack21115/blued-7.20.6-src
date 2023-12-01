package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.util.cm.SpamFilter;
import com.blued.android.chat.utils.MsgPackHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGift.class */
public final class FitemMsgGift extends FitemMsgAboutUser {
    public static final Companion b = new Companion(null);
    private static final int e = DisplayUtil.a(AppInfo.d(), 2.0f);
    private static final int f = DisplayUtil.a(AppInfo.d(), 3.0f);
    private static final int g = DisplayUtil.a(AppInfo.d(), 15.0f);
    private static final int h = DisplayUtil.a(AppInfo.d(), 20.0f);
    private final LiveChattingModel c;
    private int d;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGift$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return FitemMsgGift.f;
        }

        public final void a(Context context, IRequestHost requestHost, TextView tv, FrameLayout parent, int i, int i2, String url) {
            Intrinsics.e(context, "context");
            Intrinsics.e(requestHost, "requestHost");
            Intrinsics.e(tv, "tv");
            Intrinsics.e(parent, "parent");
            Intrinsics.e(url, "url");
            ImageView imageView = new ImageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c(), c());
            layoutParams.leftMargin = tv.getPaddingLeft() + i;
            layoutParams.topMargin = (int) ((tv.getPaddingTop() + i2) - ((c() - b()) / 2.0f));
            imageView.setLayoutParams(layoutParams);
            parent.addView(imageView);
            if (url.length() == 0) {
                return;
            }
            ImageLoader.a(requestHost, url).b(R.drawable.live_msg_gift_default_bg).a(imageView);
        }

        public final int b() {
            return FitemMsgGift.g;
        }

        public final int c() {
            return FitemMsgGift.h;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGift(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.c = msg;
    }

    private final void a(final Context context, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToScrawlGift$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                buildSpannableString.a(FitemMsgGift.this.k() + ' ' + context.getResources().getString(R.string.Live_SendPresent_send) + " 涂鸦礼物 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgGift$setSpanToScrawlGift$1.1
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.biao_live_msg_name_0);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.a;
                    }
                });
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.a;
            }
        });
    }

    private final void a(Context context, LiveGiftModel liveGiftModel, TextView textView) {
        LiveTextSpanExKt.a(textView, new FitemMsgGift$setSpanToGift$1(this, context, liveGiftModel, textView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgGift this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    private final void b(Context context, TextView textView) {
        int intValue = MsgPackHelper.getIntValue(e().msgMapExtra, SpamFilter.SpamContract.NotificationTable.COUNT);
        String stringValue = MsgPackHelper.getStringValue(e().msgMapExtra, "image");
        e().fromNickName = MsgPackHelper.getStringValue(e().msgMapExtra, "name");
        e().fromId = MsgPackHelper.getIntValue(e().msgMapExtra, "uid");
        LiveTextSpanExKt.a(textView, new FitemMsgGift$setSpanToGetGift$1(this, context, intValue, textView, stringValue));
    }

    private final void b(Context context, LiveGiftModel liveGiftModel, TextView textView) {
        LiveTextSpanExKt.a(textView, new FitemMsgGift$setSpanToRandom$1(this, context, liveGiftModel, textView));
    }

    private final void c(Context context, LiveGiftModel liveGiftModel, TextView textView) {
        LiveTextSpanExKt.a(textView, new FitemMsgGift$setSpanToLuckBagGift$1(this, liveGiftModel, context, textView));
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_gift;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        boolean z = false;
        this.d = 0;
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        short s = e().msgType;
        if (s == 33) {
            LiveGiftModel a = LiveUtils.a(e());
            if (a != null) {
                if (a.is_luck_bag) {
                    c(context, a, textView);
                } else {
                    String str = a.random_name;
                    if (str == null || str.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        a(context, a, textView);
                    } else {
                        b(context, a, textView);
                    }
                }
            }
        } else if (s == 61) {
            b(context, textView);
        } else if (s == 221) {
            a(context, textView);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgGift$SHcHP9Wi0UDPgKHmi2U5iY2giJc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgGift.a(FitemMsgGift.this, view);
            }
        });
    }

    public final boolean a(LiveChattingModel newMsg) {
        LiveGiftModel a;
        LiveGiftModel a2;
        Intrinsics.e(newMsg, "newMsg");
        if (e().msgType == 33 && (a = LiveUtils.a(e())) != null && (a2 = LiveUtils.a(newMsg)) != null && a.giftId == a2.giftId && Intrinsics.a((Object) a.name, (Object) a2.name) && a.userId == a2.userId && a.bonus <= 0.0d && !a.is_luck_bag && !a.isReward && !a.is_help_wish_list) {
            String str = a.random_name;
            if (str == null || str.length() == 0) {
                this.d += a2.getDisplayCount();
                i();
                h();
                TextView textView = (TextView) this.a.a(R.id.live_msg_content_text);
                if (textView == null) {
                    return true;
                }
                Context context = this.a.a.b;
                Intrinsics.c(context, "viewHolder.adapter.mContext");
                a(context, a, textView);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.c;
    }
}
