package com.blued.android.module.live_china.fitem.msgcontent;

import android.content.Context;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.freedom.BaseViewHolder;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveChattingModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fitem/msgcontent/FitemMsgDefault.class */
public final class FitemMsgDefault extends FitemMsgBase {
    private final LiveChattingModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitemMsgDefault(LiveChattingModel msg) {
        super(msg);
        Intrinsics.e(msg, "msg");
        this.b = msg;
    }

    @Override // com.blued.android.module.common.utils.freedom.FreedomItem
    public int a() {
        return R.layout.fitem_msg_default;
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase, com.blued.android.module.common.utils.freedom.FreedomItem
    public void a(Context context, BaseViewHolder vh, List<FreedomItem> list, int i) {
        Intrinsics.e(context, "context");
        Intrinsics.e(vh, "vh");
        Intrinsics.e(list, "list");
        super.a(context, vh, list, i);
        if (!AppInfo.m()) {
            vh.c(R.id.live_msg_content_text);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        if (e().msgType != -9999) {
            stringBuffer.append("未知类型：");
            stringBuffer.append(String.valueOf((int) e().msgType));
            stringBuffer.append("\n");
            stringBuffer.append("内容：");
        }
        stringBuffer.append(e().msgContent);
        vh.a(R.id.live_msg_content_text, (CharSequence) stringBuffer.toString()).d(R.id.live_msg_content_text);
    }

    @Override // com.blued.android.module.live_china.fitem.msgcontent.FitemMsgBase
    public LiveChattingModel e() {
        return this.b;
    }
}
