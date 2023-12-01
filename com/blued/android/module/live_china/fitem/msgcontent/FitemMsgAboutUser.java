package com.blued.android.module.live_china.fitem.msgcontent;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveBubbleBgModel;
import com.blued.android.module.live_china.model.LiveChatBadgeModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveNobleModel;
import com.blued.android.module.live_china.model.LiveWishContestContentModel;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.view.LiveMsgBgFrameLayout;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgAboutUser.class */
public abstract class FitemMsgAboutUser extends FitemMsgBase {
    private final LiveChattingModel b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgAboutUser(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
        this.c = true;
        this.d = true;
        this.e = true;
        this.g = DisplayUtil.a(AppInfo.d(), 3.0f);
        this.h = DisplayUtil.a(AppInfo.d(), 2.0f);
        this.i = DisplayUtil.a(AppInfo.d(), 12.0f);
        this.j = DisplayUtil.a(AppInfo.d(), 15.0f);
        this.k = DisplayUtil.a(AppInfo.d(), 17.0f);
        this.l = DisplayUtil.a(AppInfo.d(), 20.0f);
        this.m = DisplayUtil.a(AppInfo.d(), 29.0f);
        this.n = DisplayUtil.a(AppInfo.d(), 30.0f);
        this.o = DisplayUtil.a(AppInfo.d(), 60.0f);
        this.p = DisplayUtil.a(AppInfo.d(), 59.5f);
    }

    private final void a(Context context, TextView textView) {
        if (TextUtils.isEmpty(p())) {
            return;
        }
        LiveTextSpanExKt.a(textView, new FitemMsgAboutUser$addIconToVIP$1(this, this.o, this.j, context, textView));
    }

    private final void a(View view) {
        int i = e().fromRichLevel;
        if (i >= 0 && i < 16) {
            view.setBackgroundResource(R.drawable.shape_round_live_msg_item_bg);
            return;
        }
        int i2 = e().fromRichLevel;
        if (16 <= i2 && i2 < 21) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_yellow);
            return;
        }
        int i3 = e().fromRichLevel;
        if (21 <= i3 && i3 < 26) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_orange);
            return;
        }
        int i4 = e().fromRichLevel;
        if (26 <= i4 && i4 < 30) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_red);
        } else if (e().fromRichLevel == 30) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_30);
        } else if (e().fromRichLevel == 31) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_31);
        } else if (e().fromRichLevel == 32) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_32);
        } else if (e().fromRichLevel == 33) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_33);
        } else if (e().fromRichLevel == 34) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_34);
        } else if (e().fromRichLevel == 35) {
            view.setBackgroundResource(R.drawable.shape_gradient_name_level_35);
        } else {
            view.setBackgroundResource(R.drawable.transparent);
        }
    }

    private final void a(TextView textView) {
        if (e().fromLiveManager <= 0) {
            return;
        }
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser$addIconToManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                int i;
                int i2;
                int i3;
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                int i4 = R.drawable.icon_live_manager_new;
                i = FitemMsgAboutUser.this.g;
                i2 = FitemMsgAboutUser.this.m;
                i3 = FitemMsgAboutUser.this.j;
                buildSpannableString.a(i4, 0, i, i2, i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.a;
            }
        });
    }

    private final void a(LiveBubbleBgModel liveBubbleBgModel, ImageView imageView) {
        TextView textView = (TextView) this.a.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        if (liveBubbleBgModel != null && liveBubbleBgModel.chat_frame_icon_src > 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(liveBubbleBgModel.chat_frame_icon_src);
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), this.l, textView.getPaddingBottom());
        } else if (liveBubbleBgModel != null && !TextUtils.isEmpty(liveBubbleBgModel.chat_frame_icon)) {
            imageView.setVisibility(0);
            ImageLoader.a((IRequestHost) null, liveBubbleBgModel.chat_frame_icon).a(imageView);
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), this.l, textView.getPaddingBottom());
        } else if (e().fromRichLevel < 30) {
            imageView.setVisibility(8);
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), this.i, textView.getPaddingBottom());
        } else {
            imageView.setVisibility(0);
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), this.l, textView.getPaddingBottom());
            if (e().fromRichLevel == 35 || e().fromRichLevel == 34) {
                imageView.setImageResource(R.drawable.live_msg_list_star_emperor);
            } else {
                imageView.setImageResource(R.drawable.live_msg_list_star);
            }
        }
    }

    private final void a(LiveMsgBgFrameLayout liveMsgBgFrameLayout) {
        LiveBubbleBgModel u = u();
        if (u == null) {
            liveMsgBgFrameLayout.setValidColors(false);
            this.a.c(R.id.live_msg_content_star);
            a((View) liveMsgBgFrameLayout);
            return;
        }
        liveMsgBgFrameLayout.a(u, e().fromRichLevel);
        ImageView imageView = (ImageView) this.a.a(R.id.live_msg_content_star);
        if (imageView == null) {
            return;
        }
        a(u, imageView);
    }

    private final void b(Context context, TextView textView) {
        Integer nameplate_img_height;
        LiveNobleModel o = o();
        if (o == null) {
            return;
        }
        float f = this.j;
        Integer nameplate_img_width = o.getNameplate_img_width();
        Intrinsics.a(nameplate_img_width);
        float intValue = nameplate_img_width.intValue();
        Intrinsics.a(o.getNameplate_img_height());
        LiveTextSpanExKt.a(textView, new FitemMsgAboutUser$addIconToNoble$1(this, (int) ((f * intValue) / nameplate_img_height.intValue()), this.j, context, textView, o));
    }

    private final void c(Context context, TextView textView) {
        Bitmap createBitmap;
        LiveFansLevelModel m = m();
        if (m == null || m.in_fan_club == 0) {
            return;
        }
        LiveFansLevelView liveFansLevelView = new LiveFansLevelView(context);
        liveFansLevelView.setFansLevel(m);
        try {
            liveFansLevelView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            liveFansLevelView.layout(0, 0, liveFansLevelView.getMeasuredWidth(), liveFansLevelView.getMeasuredHeight());
            createBitmap = Bitmap.createBitmap(liveFansLevelView.getMeasuredWidth(), liveFansLevelView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            liveFansLevelView.draw(new Canvas(createBitmap));
        } catch (Exception e) {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), createBitmap);
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser$addIconToFans$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                int i;
                int i2;
                int i3;
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                i = this.g;
                i2 = this.j;
                i3 = this.j;
                buildSpannableString.a(bitmapDrawable, 0, i, (int) ((i2 * bitmapDrawable.getIntrinsicWidth()) / bitmapDrawable.getIntrinsicHeight()), i3);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                a(dslSpannableStringBuilder);
                return Unit.a;
            }
        });
    }

    private final void d(Context context, TextView textView) {
        final Drawable a;
        if (e().fromRichLevel > 0 && (a = LiveBitmapUtils.a(context, e().fromRichLevel)) != null) {
            LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser$addIconToRichLevel$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(DslSpannableStringBuilder buildSpannableString) {
                    int i;
                    int i2;
                    int i3;
                    int i4;
                    int i5;
                    Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                    Drawable drawable = a;
                    i = this.g;
                    if (this.e().fromRichLevel >= 30) {
                        i5 = this.p;
                        i3 = i5;
                    } else {
                        i2 = this.n;
                        i3 = i2;
                    }
                    i4 = this.j;
                    buildSpannableString.a(drawable, 0, i, i3, i4);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                    a(dslSpannableStringBuilder);
                    return Unit.a;
                }
            });
        }
    }

    private final void e(Context context, TextView textView) {
        LiveChatBadgeModel n;
        Integer chat_badge_height;
        if (this.e && (n = n()) != null) {
            float f = this.j;
            Integer chat_badge_length = n.getChat_badge_length();
            Intrinsics.a(chat_badge_length);
            float intValue = chat_badge_length.intValue();
            Intrinsics.a(n.getChat_badge_height());
            LiveTextSpanExKt.a(textView, new FitemMsgAboutUser$addIconToChatBadge$1(this, (int) ((f * intValue) / chat_badge_height.intValue()), this.j, context, textView, n));
        }
    }

    private final void q() {
        View a = this.a.a(R.id.live_msg_content_root);
        if (a == null) {
            return;
        }
        a.setBackgroundResource(R.color.transparent);
        if (!(a instanceof LiveMsgBgFrameLayout)) {
            this.a.c(R.id.live_msg_content_star);
            a(a);
            return;
        }
        LiveMsgBgFrameLayout liveMsgBgFrameLayout = (LiveMsgBgFrameLayout) a;
        liveMsgBgFrameLayout.setValidColors(true);
        a(liveMsgBgFrameLayout);
    }

    private final void r() {
        View a = this.a.a(R.id.live_msg_content_root);
        if (a != null) {
            if (a instanceof LiveMsgBgFrameLayout) {
                ((LiveMsgBgFrameLayout) a).setValidColors(false);
            }
            a.setBackgroundResource(R.drawable.transparent);
        }
        View a2 = this.a.a(R.id.live_msg_content_star);
        if (a2 == null) {
            return;
        }
        a2.setVisibility(8);
    }

    private final void s() {
        View lightView = this.a.a(R.id.live_msg_light);
        if (lightView != null) {
            lightView.setVisibility(8);
        }
        if (lightView == null) {
            return;
        }
        if (this.f || e().fromRichLevel < 34) {
            Intrinsics.c(lightView, "lightView");
            lightView.setVisibility(8);
            return;
        }
        lightView.setTranslationX(0 - lightView.getWidth());
        Intrinsics.c(lightView, "lightView");
        lightView.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(lightView, "translationX", 0 - lightView.getWidth(), AppInfo.l - DensityUtils.a(lightView.getContext(), 115.0f));
        ofFloat.setDuration(2500L);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(1);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.8f));
        ofFloat.start();
        this.f = true;
    }

    private final void t() {
        View a = this.a.a(R.id.live_msg_light);
        if (a == null) {
            return;
        }
        a.setVisibility(8);
    }

    private final LiveBubbleBgModel u() {
        try {
            short s = e().msgType;
            if (s == 33) {
                Map<String, Object> map = e().msgMapExtra;
                Object obj = map == null ? null : map.get("gift_model");
                if (obj != null) {
                    Object obj2 = ((LiveGiftModel) obj).extraModel;
                    if (obj2 != null) {
                        return (LiveBubbleBgModel) obj2;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveBubbleBgModel");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftModel");
            } else if (s == 221) {
                Object objExtra = e().getObjExtra();
                if (objExtra != null) {
                    Object obj3 = ((LiveGiftScrawlTransModel) objExtra).extraModel;
                    if (obj3 != null) {
                        return (LiveBubbleBgModel) obj3;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveBubbleBgModel");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftScrawlTransModel");
            } else if (s == 245) {
                Object objExtra2 = e().getObjExtra();
                if (objExtra2 != null) {
                    Object obj4 = ((LiveGiftModel) objExtra2).extraModel;
                    if (obj4 != null) {
                        return (LiveBubbleBgModel) obj4;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveBubbleBgModel");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftModel");
            } else if (s == 251) {
                Object objExtra3 = e().getObjExtra();
                if (objExtra3 != null) {
                    return ((LiveWishContestContentModel) objExtra3).bubbleBgModel;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveWishContestContentModel");
            } else {
                Map<String, Object> map2 = e().msgMapExtra;
                boolean z = true;
                if (map2 == null || !map2.containsKey("live_chat_frame_model")) {
                    z = false;
                }
                if (z) {
                    Map<String, Object> map3 = e().msgMapExtra;
                    if ((map3 == null ? null : map3.get("live_chat_frame_model")) instanceof LiveBubbleBgModel) {
                        Map<String, Object> map4 = e().msgMapExtra;
                        Object obj5 = map4 == null ? null : map4.get("live_chat_frame_model");
                        if (obj5 != null) {
                            return (LiveBubbleBgModel) obj5;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveBubbleBgModel");
                    }
                }
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(boolean z) {
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(boolean z) {
        this.e = z;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }

    protected final boolean f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int g() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h() {
        TextView textView = (TextView) this.a.a(R.id.live_msg_content_text);
        if (textView != null && f()) {
            a(textView);
            Context context = this.a.a.b;
            Intrinsics.c(context, "viewHolder.adapter.mContext");
            a(context, textView);
            Context context2 = this.a.a.b;
            Intrinsics.c(context2, "viewHolder.adapter.mContext");
            b(context2, textView);
            Context context3 = this.a.a.b;
            Intrinsics.c(context3, "viewHolder.adapter.mContext");
            d(context3, textView);
            Context context4 = this.a.a.b;
            Intrinsics.c(context4, "viewHolder.adapter.mContext");
            c(context4, textView);
            Context context5 = this.a.a.b;
            Intrinsics.c(context5, "viewHolder.adapter.mContext");
            e(context5, textView);
        }
        if (this.d) {
            q();
            s();
            return;
        }
        r();
        t();
    }
}
