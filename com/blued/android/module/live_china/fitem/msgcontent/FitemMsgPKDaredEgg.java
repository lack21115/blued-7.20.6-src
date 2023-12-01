package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.LinkMovementClickMethod;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgPKDaredEgg.class */
public final class FitemMsgPKDaredEgg extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgPKDaredEgg(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FitemMsgPKDaredEgg this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_pk_dared_egg;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = AppInfo.d().getResources().getString(R.string.live_pk_dared_egg_msg);
        Intrinsics.c(string, "getAppContext().resource…ng.live_pk_dared_egg_msg)");
        String format = String.format(string, Arrays.copyOf(new Object[]{k(), e().msgMapExtra.get("propName")}, 2));
        Intrinsics.c(format, "format(format, *args)");
        e().msgContent = format;
        e().msgTimestamp = System.currentTimeMillis();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new CharacterStyle() { // from class: com.blued.android.module.live_china.fitem.msgcontent.FitemMsgPKDaredEgg$initBindView$1
            @Override // android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(AppInfo.d().getResources().getColor(R.color.syc_dark_FFD228));
                ds.setUnderlineText(false);
                ds.clearShadowLayer();
            }
        }, 3, k().length() + 3, 33);
        TextView textView = (TextView) vh.a(R.id.live_msg_content_text);
        textView.setMovementMethod(LinkMovementClickMethod.a());
        textView.setText(spannableStringBuilder);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fitem.msgcontent.-$$Lambda$FitemMsgPKDaredEgg$gJACPtIJ6mC7SE9kl-iNM_qJkb4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FitemMsgPKDaredEgg.a(FitemMsgPKDaredEgg.this, view);
            }
        });
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
