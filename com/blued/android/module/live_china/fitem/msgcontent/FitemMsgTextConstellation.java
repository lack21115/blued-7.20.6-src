package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgTextConstellation.class */
public final class FitemMsgTextConstellation extends FitemMsgAboutUser {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgTextConstellation(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b0, code lost:
        if (r0.length() == 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(final android.content.Context r9, android.widget.TextView r10) {
        /*
            r8 = this;
            r0 = r8
            com.blued.android.module.live_china.model.LiveChattingModel r0 = r0.e()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.msgMapExtra
            r16 = r0
            r0 = r16
            if (r0 != 0) goto Lf
            return
        Lf:
            r0 = r8
            java.lang.String r0 = r0.k()
            r15 = r0
            r0 = r16
            java.lang.String r1 = "anchor_name"
            java.lang.Object r0 = r0.get(r1)
            r13 = r0
            r0 = 0
            r14 = r0
            r0 = r13
            if (r0 != 0) goto L2e
            r0 = 0
            r13 = r0
            goto L35
        L2e:
            r0 = r13
            java.lang.String r0 = r0.toString()
            r13 = r0
        L35:
            r0 = r16
            java.lang.String r1 = "constellation_name"
            java.lang.Object r0 = r0.get(r1)
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L48
            goto L4f
        L48:
            r0 = r16
            java.lang.String r0 = r0.toString()
            r14 = r0
        L4f:
            r0 = r15
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r16 = r0
            r0 = 0
            r12 = r0
            r0 = r16
            if (r0 == 0) goto L70
            r0 = r16
            int r0 = r0.length()
            if (r0 != 0) goto L6b
            goto L70
        L6b:
            r0 = 0
            r11 = r0
            goto L72
        L70:
            r0 = 1
            r11 = r0
        L72:
            r0 = r11
            if (r0 != 0) goto Lcf
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r16 = r0
            r0 = r16
            if (r0 == 0) goto L94
            r0 = r16
            int r0 = r0.length()
            if (r0 != 0) goto L8f
            goto L94
        L8f:
            r0 = 0
            r11 = r0
            goto L96
        L94:
            r0 = 1
            r11 = r0
        L96:
            r0 = r11
            if (r0 != 0) goto Lcf
            r0 = r14
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r16 = r0
            r0 = r16
            if (r0 == 0) goto Lb3
            r0 = r12
            r11 = r0
            r0 = r16
            int r0 = r0.length()
            if (r0 != 0) goto Lb5
        Lb3:
            r0 = 1
            r11 = r0
        Lb5:
            r0 = r11
            if (r0 == 0) goto Lba
            return
        Lba:
            r0 = r10
            com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation$initDataToConstellationTop$1$1 r1 = new com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation$initDataToConstellationTop$1$1
            r2 = r1
            r3 = r15
            r4 = r13
            r5 = r14
            r6 = r9
            r2.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.blued.android.module.live_china.view.LiveTextSpanExKt.a(r0, r1)
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation.a(android.content.Context, android.widget.TextView):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgTextConstellation this$0, View view) {
        String obj;
        Intrinsics.e(this$0, "this$0");
        Map<String, Object> map = this$0.e().msgMapExtra;
        if (map == null) {
            return;
        }
        Object obj2 = map.get("link_type");
        String str = null;
        Integer valueOf = (obj2 == null || (obj = obj2.toString()) == null) ? null : Integer.valueOf(Integer.parseInt(obj));
        Object obj3 = map.get("link");
        if (obj3 != null) {
            str = obj3.toString();
        }
        String str2 = str;
        if (((str2 == null || str2.length() == 0) || valueOf == null) && valueOf != null && valueOf.intValue() == 0) {
            return;
        }
        LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
        Intrinsics.a(valueOf);
        liveRoomFunctionItemModel.setLink_type(valueOf.intValue());
        Intrinsics.a((Object) str);
        liveRoomFunctionItemModel.setLink(str);
        LiveEventBus.get(LiveEventBusUtil.C).post(liveRoomFunctionItemModel);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
        if (r0.length() == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(final android.content.Context r8, android.widget.TextView r9) {
        /*
            r7 = this;
            r0 = r7
            com.blued.android.module.live_china.model.LiveChattingModel r0 = r0.e()
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.msgMapExtra
            r12 = r0
            r0 = r12
            if (r0 != 0) goto Lf
            return
        Lf:
            r0 = r7
            java.lang.String r0 = r0.k()
            r13 = r0
            r0 = r12
            java.lang.String r1 = "anchor_name"
            java.lang.Object r0 = r0.get(r1)
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L2b
            r0 = 0
            r12 = r0
            goto L32
        L2b:
            r0 = r12
            java.lang.String r0 = r0.toString()
            r12 = r0
        L32:
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14 = r0
            r0 = 0
            r11 = r0
            r0 = r14
            if (r0 == 0) goto L53
            r0 = r14
            int r0 = r0.length()
            if (r0 != 0) goto L4e
            goto L53
        L4e:
            r0 = 0
            r10 = r0
            goto L55
        L53:
            r0 = 1
            r10 = r0
        L55:
            r0 = r10
            if (r0 != 0) goto L8c
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L72
            r0 = r11
            r10 = r0
            r0 = r14
            int r0 = r0.length()
            if (r0 != 0) goto L74
        L72:
            r0 = 1
            r10 = r0
        L74:
            r0 = r10
            if (r0 == 0) goto L79
            return
        L79:
            r0 = r9
            com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation$initDataToConstellationKing$1$1 r1 = new com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation$initDataToConstellationKing$1$1
            r2 = r1
            r3 = r13
            r4 = r12
            r5 = r8
            r2.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.blued.android.module.live_china.view.LiveTextSpanExKt.a(r0, r1)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgTextConstellation.b(android.content.Context, android.widget.TextView):void");
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_text_constellation;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Object obj;
        String obj2;
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        a(false);
        super.a(context, vh, list, i);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        if (textView == null) {
            return;
        }
        Map<String, Object> map = e().msgMapExtra;
        if (map != null && (obj = map.get("type")) != null && (obj2 = obj.toString()) != null) {
            int parseInt = Integer.parseInt(obj2);
            if (parseInt == 1) {
                a(context, textView);
            } else if (parseInt == 2) {
                b(context, textView);
            }
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgTextConstellation$wKyW1eBTPaDt7weEN45MFHRLvBE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgTextConstellation.a(FitemMsgTextConstellation.this, view);
            }
        });
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgAboutUser, com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
