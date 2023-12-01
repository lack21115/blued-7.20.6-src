package com.soft.blued.ui.find.adapter;

import android.content.Context;
import android.view.View;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.find.model.RecommendPopModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendPopAdapter.class */
public final class RecommendPopAdapter extends BaseQuickAdapter<RecommendPopModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30129a;
    private OnSayHelloClickedListener b;

    @Metadata
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendPopAdapter$OnSayHelloClickedListener.class */
    public interface OnSayHelloClickedListener {
        void a(int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendPopAdapter(Context mContext) {
        super((int) R.layout.item_nearby_people_recommend);
        Intrinsics.e(mContext, "mContext");
        this.f30129a = mContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RecommendPopModel item, RecommendPopAdapter this$0, BaseViewHolder helper, View view) {
        OnSayHelloClickedListener onSayHelloClickedListener;
        Tracker.onClick(view);
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        if (!item.getSayHelloEnable() || (onSayHelloClickedListener = this$0.b) == null) {
            return;
        }
        onSayHelloClickedListener.a(helper.getLayoutPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x027f  */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void convert(final com.chad.library.adapter.base.BaseViewHolder r8, final com.soft.blued.ui.find.model.RecommendPopModel r9) {
        /*
            Method dump skipped, instructions count: 1069
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.adapter.RecommendPopAdapter.convert(com.chad.library.adapter.base.BaseViewHolder, com.soft.blued.ui.find.model.RecommendPopModel):void");
    }

    public final void a(OnSayHelloClickedListener onSayHelloClickedListener) {
        this.b = onSayHelloClickedListener;
    }
}
