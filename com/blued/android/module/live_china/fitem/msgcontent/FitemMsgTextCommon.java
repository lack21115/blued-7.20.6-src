package com.blued.android.module.live_china.fitem.msgcontent;

import android.view.View;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextCommon.class */
public final class FitemMsgTextCommon extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextCommon(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextCommon this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        Object obj = this$0.e().msgMapExtra.get("link");
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        liveRoomFunctionItemModel.setLink((String) obj);
        Object obj2 = this$0.e().msgMapExtra.get("link_type");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        liveRoomFunctionItemModel.setLink_type((int) ((Long) obj2).longValue());
        LiveEventBusUtil.a(liveRoomFunctionItemModel);
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text_common;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0082, code lost:
        if (r0.length() == 0) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r7, com.blued.android.module.common.utils.freedom.BaseViewHolder r8, java.util.List<com.blued.android.module.common.utils.freedom.FreedomItem> r9, int r10) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r8
            java.lang.String r1 = "vh"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r9
            java.lang.String r1 = "list"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = 0
            r11 = r0
            r0 = r6
            r1 = 0
            r0.a(r1)
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            super.a(r1, r2, r3, r4)
            r0 = r8
            int r1 = com.blued.android.module.live_china.R.id.live_msg_content_text
            android.view.View r0 = r0.a(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L33
            return
        L33:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r6
            com.blued.android.module.live_china.model.LiveChattingModel r0 = r0.e()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.msgMapExtra
            r12 = r0
            r0 = 0
            r7 = r0
            r0 = r12
            if (r0 != 0) goto L4e
            goto L67
        L4e:
            r0 = r12
            java.lang.String r1 = "color"
            java.lang.Object r0 = r0.get(r1)
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L61
            goto L67
        L61:
            r0 = r12
            java.lang.String r0 = r0.toString()
            r7 = r0
        L67:
            r0 = r9
            r1 = r7
            r0.a = r1
            r0 = r9
            T r0 = r0.a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L85
            r0 = r11
            r10 = r0
            r0 = r7
            int r0 = r0.length()
            if (r0 != 0) goto L88
        L85:
            r0 = 1
            r10 = r0
        L88:
            r0 = r10
            if (r0 == 0) goto L93
            r0 = r9
            java.lang.String r1 = "#FFFFFF"
            r0.a = r1
        L93:
            r0 = r8
            com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextCommon$initBindView$1$1 r1 = new com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextCommon$initBindView$1$1
            r2 = r1
            r3 = r6
            r4 = r9
            r2.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.blued.android.module.live_china.view.LiveTextSpanExKt.a(r0, r1)
            r0 = r8
            com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextCommon$cV9RMVaBRLT7D1rr1oIF3_l-ZiI r1 = new com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextCommon$cV9RMVaBRLT7D1rr1oIF3_l-ZiI
            r2 = r1
            r3 = r6
            r2.<init>()
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextCommon.a(android.content.Context, com.blued.android.module.common.utils.freedom.BaseViewHolder, java.util.List, int):void");
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
