package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.anythink.core.common.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveMsgBgFrameLayout;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import com.blued.das.live.LiveProtos;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgNobleUpgrade.class */
public final class FitemMsgNobleUpgrade extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgNobleUpgrade(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, View view, FrameLayout icon_root, final FitemMsgNobleUpgrade this$0) {
        Intrinsics.e(context, "$context");
        Intrinsics.e(icon_root, "$icon_root");
        Intrinsics.e(this$0, "this$0");
        LinearLayout linearLayout = new LinearLayout(context);
        int height = view.getHeight();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, ((height - view.getPaddingTop()) - view.getPaddingBottom()) + DisplayUtil.a(AppInfo.d(), 1.0f), DisplayUtil.a(AppInfo.d(), 10.0f), DisplayUtil.a(AppInfo.d(), 2.0f));
        layoutParams.gravity = 5;
        linearLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(DisplayUtil.a(AppInfo.d(), 29.0f), DisplayUtil.a(AppInfo.d(), 24.0f)));
        imageView.setImageResource(R.drawable.live_noble_upgrade_msg_img);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        textView.setLayoutParams(layoutParams2);
        textView.setText("成为贵族");
        textView.getPaint().setFakeBoldText(true);
        textView.setTextSize(2, 10.0f);
        textView.setTextColor(BluedSkinUtils.a(context, R.color.syc_dark_F5DEC0));
        linearLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(DisplayUtil.a(AppInfo.d(), 16.0f), DisplayUtil.a(AppInfo.d(), 16.0f));
        layoutParams3.gravity = 16;
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setImageResource(R.drawable.live_noble_upgrade_msg_arrows);
        linearLayout.addView(imageView2);
        icon_root.addView(linearLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgNobleUpgrade$3By3tyjFrqevwRhzL65Yf-rx10Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FitemMsgNobleUpgrade.c(FitemMsgNobleUpgrade.this, view2);
            }
        });
    }

    private final void a(final Context context, final FrameLayout frameLayout) {
        final View a = this.a.a(R.id.live_msg_content_text);
        if (a == null) {
            return;
        }
        a.post(new Runnable() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgNobleUpgrade$nIde-wO_3LX7w94hhKmx-R4Bdok
            @Override // java.lang.Runnable
            public final void run() {
                FitemMsgNobleUpgrade.a(context, a, frameLayout, this);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(Context context, TextView textView) {
        Object obj;
        Object obj2;
        String obj3;
        Object obj4;
        String obj5;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Map<String, Object> map = e().msgMapExtra;
        Long l = null;
        objectRef.a = (map == null || (obj = map.get("nameplate_img")) == null) ? null : obj.toString();
        Map<String, Object> map2 = e().msgMapExtra;
        Long valueOf = (map2 == null || (obj2 = map2.get("nameplate_img_width")) == null || (obj3 = obj2.toString()) == null) ? null : Long.valueOf(Long.parseLong(obj3));
        Map<String, Object> map3 = e().msgMapExtra;
        if (map3 != null && (obj4 = map3.get("nameplate_img_height")) != null && (obj5 = obj4.toString()) != null) {
            l = Long.valueOf(Long.parseLong(obj5));
        }
        CharSequence charSequence = (CharSequence) objectRef.a;
        if ((charSequence == null || charSequence.length() == 0) || valueOf == null || valueOf.longValue() <= 0 || l == null || l.longValue() <= 0) {
            return;
        }
        LiveTextSpanExKt.a(textView, new FitemMsgNobleUpgrade$addIconToNoble$1((int) ((FitemMsgGift.b.b() * ((float) valueOf.longValue())) / ((float) l.longValue())), FitemMsgGift.b.b(), this, context, textView, objectRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgNobleUpgrade this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FitemMsgNobleUpgrade this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(FitemMsgNobleUpgrade this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void f() {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgNobleUpgrade.f():void");
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_noble_upgrade;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.util.ArrayList] */
    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Object obj;
        String obj2;
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Map<String, Object> map = e().msgMapExtra;
        List list2 = null;
        if (map != null && (obj = map.get(l.y)) != null && (obj2 = obj.toString()) != null) {
            list2 = StringsKt.b((CharSequence) obj2, new String[]{"#username#"}, false, 0, 6, (Object) null);
        }
        objectRef.a = list2;
        Collection collection = (Collection) objectRef.a;
        if ((collection == null || collection.isEmpty()) || ((List) objectRef.a).size() < 2) {
            objectRef.a = CollectionsKt.d("恭喜 ", " 成为贵族！");
        }
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView != null) {
            a(context, textView);
            LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgNobleUpgrade$initBindView$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void a(DslSpannableStringBuilder buildSpannableString) {
                    Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                    buildSpannableString.a(objectRef.a.get(0), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgNobleUpgrade$initBindView$1$1.1
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                    buildSpannableString.a(this.k(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgNobleUpgrade$initBindView$1$1.2
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
                            Context d = AppInfo.d();
                            Intrinsics.c(d, "getAppContext()");
                            addText.a(d, R.color.biao_live_msg_name_3);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                            a(dslSpanBuilder);
                            return Unit.a;
                        }
                    });
                    buildSpannableString.a(objectRef.a.get(objectRef.a.size() - 1), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgNobleUpgrade$initBindView$1$1.3
                        public final void a(DslSpanBuilder addText) {
                            Intrinsics.e(addText, "$this$addText");
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgNobleUpgrade$N4YJiS_VZaGN7U1pylLuS602FO8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemMsgNobleUpgrade.a(FitemMsgNobleUpgrade.this, view);
                }
            });
        }
        View a = vh.a(R.id.live_msg_content_root);
        if (a != null) {
            a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgNobleUpgrade$xiNavMVkERZ-UOSaPCFGeHja1f8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FitemMsgNobleUpgrade.b(FitemMsgNobleUpgrade.this, view);
                }
            });
            a.setBackgroundResource(R.drawable.live_msg_noble_join_item_bg);
            if (a instanceof LiveMsgBgFrameLayout) {
                ((LiveMsgBgFrameLayout) a).setValidColors(false);
            }
        }
        FrameLayout frameLayout = (FrameLayout) this.a.a(R.id.fl_icon_root);
        if (frameLayout != null) {
            a(context, frameLayout);
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_NOBLE_MSG_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
