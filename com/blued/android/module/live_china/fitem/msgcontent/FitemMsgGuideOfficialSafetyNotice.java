package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgGuideOfficialSafetyNotice.class */
public final class FitemMsgGuideOfficialSafetyNotice extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgGuideOfficialSafetyNotice(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_live_msg_official_safety_notice;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        vh.a(R.id.live_msg_content_text, (CharSequence) e().msgContent);
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
