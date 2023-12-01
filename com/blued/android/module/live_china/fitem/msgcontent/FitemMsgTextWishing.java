package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveDataListManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRoomAnchorModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveWishContestContentModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextWishing.class */
public final class FitemMsgTextWishing extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextWishing(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    private final void a(Context context, TextView textView) {
        String k = k();
        if (k == null || k.length() == 0) {
            return;
        }
        if (!(e() instanceof LiveChattingModel) || e().getObjExtra() == null || !(e().getObjExtra() instanceof LiveGiftModel)) {
            View view = this.a.itemView;
            Intrinsics.c(view, "viewHolder.itemView");
            BluedViewExKt.a(view);
            return;
        }
        Object objExtra = e().getObjExtra();
        if (objExtra == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftModel");
        }
        LiveTextSpanExKt.a(textView, new FitemMsgTextWishing$setSpanToWinning$1(this, (LiveGiftModel) objExtra, context, textView));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextWishing$pUB1Pe4xEGg30QrkYlhvwoXiP3E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FitemMsgTextWishing.a(FitemMsgTextWishing.this, view2);
            }
        });
    }

    private final void a(Context context, final LiveWishContestContentModel liveWishContestContentModel, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToChallenge$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                buildSpannableString.a("星之许愿池：恭喜 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToChallenge$1.1
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
                String str = LiveWishContestContentModel.this.anchorName;
                Intrinsics.c(str, "msgModel.anchorName");
                buildSpannableString.a(str, new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToChallenge$1.2
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.syc_dark_ffd452);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                        a(dslSpanBuilder);
                        return Unit.a;
                    }
                });
                int i = LiveWishContestContentModel.this.type;
                String str2 = i != 0 ? i != 1 ? "许愿争夺战" : "疯狂争夺战" : "许愿争夺战";
                buildSpannableString.a(" 直播间诞生了" + str2 + "最终擂主，主播获得 ", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToChallenge$1.3
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
                StringBuilder sb = new StringBuilder();
                sb.append(LiveWishContestContentModel.this.beans);
                sb.append(" 赠豆");
                buildSpannableString.a(sb.toString(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToChallenge$1.4
                    public final void a(DslSpanBuilder addText) {
                        Intrinsics.e(addText, "$this$addText");
                        Context d = AppInfo.d();
                        Intrinsics.c(d, "getAppContext()");
                        addText.a(d, R.color.syc_dark_ffd452);
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
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextWishing$0Fl6HmCWbxpbDNCwpusZ3jb5Y8E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgTextWishing.a(LiveWishContestContentModel.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextWishing this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextWishing this$0, LiveWishContestContentModel msgModel, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(msgModel, "$msgModel");
        this$0.a(msgModel.userId);
    }

    private final void a(final LiveWishContestContentModel liveWishContestContentModel, TextView textView) {
        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToStart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(DslSpannableStringBuilder buildSpannableString) {
                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                int i = LiveWishContestContentModel.this.type;
                String str = i != 0 ? i != 1 ? "许愿争夺战" : "疯狂争夺战" : "许愿争夺战";
                buildSpannableString.a("星之许愿池：已开启" + str + "，成为擂主并保持到倒计时结束，可以获得最终奖励", new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToStart$1.1
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveWishContestContentModel msgModel, FitemMsgTextWishing this$0, View view) {
        Intrinsics.e(msgModel, "$msgModel");
        Intrinsics.e(this$0, "this$0");
        boolean z = true;
        boolean z2 = LiveRoomInfo.a().g() == LiveRoomManager.a().f();
        if (msgModel.anchorId != LiveRoomManager.a().f()) {
            z = false;
        }
        if (z2 || z) {
            return;
        }
        LiveRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<AnchorLiveStateModel>>() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextWishing$wishingContestToChallenge$2$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorLiveStateModel> bluedEntityA) {
                AnchorLiveStateModel singleData;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null || singleData.is_live != 1) {
                    return;
                }
                try {
                    LiveRoomData liveRoomData = new LiveRoomData();
                    liveRoomData.lid = singleData.lid;
                    LiveRoomAnchorModel liveRoomAnchorModel = new LiveRoomAnchorModel();
                    liveRoomAnchorModel.name = singleData.name;
                    liveRoomAnchorModel.avatar = singleData.avatar;
                    liveRoomAnchorModel.uid = singleData.uid;
                    liveRoomData.profile = liveRoomAnchorModel;
                    LiveDataListManager.a().a(liveRoomData, false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, String.valueOf(msgModel.anchorId), this$0.a.b);
    }

    private final void b(Context context, TextView textView) {
        if (!(e() instanceof LiveChattingModel) || e().getObjExtra() == null || !(e().getObjExtra() instanceof LiveWishContestContentModel)) {
            View view = this.a.itemView;
            Intrinsics.c(view, "viewHolder.itemView");
            BluedViewExKt.a(view);
            return;
        }
        Object objExtra = e().getObjExtra();
        if (objExtra == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveWishContestContentModel");
        }
        LiveWishContestContentModel liveWishContestContentModel = (LiveWishContestContentModel) objExtra;
        if (liveWishContestContentModel.event != 1) {
            a(liveWishContestContentModel, textView);
        } else if (liveWishContestContentModel.msg_event_type == 1) {
            a(context, liveWishContestContentModel, textView);
        } else {
            b(context, liveWishContestContentModel, textView);
        }
    }

    private final void b(Context context, final LiveWishContestContentModel liveWishContestContentModel, TextView textView) {
        LiveTextSpanExKt.a(textView, new FitemMsgTextWishing$wishingContestToWin$1(liveWishContestContentModel, this, context, textView));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextWishing$X1Os5RZ8lGWMA6g6VWLWfLK_8rY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgTextWishing.a(FitemMsgTextWishing.this, liveWishContestContentModel, view);
            }
        });
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text_wishing;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        a(false);
        super.a(context, vh, list, i);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        short s = e().msgType;
        if (s == 245) {
            a(context, textView);
        } else if (s != 251) {
        } else {
            b(context, textView);
        }
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
