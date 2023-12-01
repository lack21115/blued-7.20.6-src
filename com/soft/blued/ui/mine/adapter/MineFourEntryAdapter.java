package com.soft.blued.ui.mine.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.DistanceUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/adapter/MineFourEntryAdapter.class */
public class MineFourEntryAdapter extends BaseQuickAdapter<MineEntryInfo.ColumnsItem, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f31585a;
    private IRequestHost b;

    public MineFourEntryAdapter(Context context, IRequestHost iRequestHost) {
        super((int) R.layout.item_mine_four_entry);
        this.f31585a = context;
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final MineEntryInfo.ColumnsItem columnsItem) {
        ImageLoader.a(this.b, columnsItem.icon).a((ImageView) baseViewHolder.getView(2131364552));
        baseViewHolder.setText(2131372754, columnsItem.title);
        if (TextUtils.isEmpty(columnsItem.recommend_text)) {
            baseViewHolder.setText(2131371186, "");
        } else {
            baseViewHolder.setText(2131371186, columnsItem.recommend_text);
        }
        if (BluedPreferences.P(columnsItem.item_key)) {
            baseViewHolder.setGone(2131365270, true);
        } else {
            baseViewHolder.setGone(2131365270, false);
        }
        baseViewHolder.getView(2131366742).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.adapter.MineFourEntryAdapter.1
            /* JADX WARN: Code restructure failed: missing block: B:19:0x00b4, code lost:
                if (r0.equals("charge") != false) goto L15;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r6) {
                /*
                    Method dump skipped, instructions count: 214
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.adapter.MineFourEntryAdapter.AnonymousClass1.onClick(android.view.View):void");
            }
        });
        baseViewHolder.setGone(2131365504, false);
        baseViewHolder.setGone(2131371196, false);
        if (columnsItem.extra == null || TextUtils.isEmpty(columnsItem.extra.type)) {
            if (TextUtils.isEmpty(columnsItem.recommend_text)) {
                baseViewHolder.setGone(R.id.layout_content, false);
                return;
            }
            return;
        }
        String str = columnsItem.extra.type;
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != -1361632588) {
            if (hashCode != -378396698) {
                if (hashCode == -358591903 && str.equals(MineEntryInfo.ColumnsExtra.TYPE_RICH_LEVEL)) {
                    z = true;
                }
            } else if (str.equals(MineEntryInfo.ColumnsExtra.TYPE_CALL_ORDERS)) {
                z = true;
            }
        } else if (str.equals("charge")) {
            z = false;
        }
        if (!z) {
            baseViewHolder.setGone(2131371196, true);
            long j = columnsItem.extra.beans;
            UserInfo.getInstance().setUserPrice(j);
            baseViewHolder.setText(2131371196, DistanceUtils.a(this.f31585a, Long.valueOf(j)));
            baseViewHolder.setText(2131371186, this.f31585a.getString(2131886105));
        } else if (z) {
            baseViewHolder.setGone(2131371186, false);
            baseViewHolder.setGone(2131365504, true);
            BitmapUtils.a(this.f31585a, (ImageView) baseViewHolder.getView(2131365504), columnsItem.extra.rich_level, false);
        } else if (!z) {
            if (TextUtils.isEmpty(columnsItem.recommend_text)) {
                baseViewHolder.setGone(R.id.layout_content, false);
            }
        } else {
            baseViewHolder.setGone(2131371196, false);
            int i = columnsItem.extra.times;
            if (i > 0) {
                baseViewHolder.setText(2131371186, String.format(this.f31585a.getString(R.string.blued_call_times), Integer.valueOf(i)));
            } else {
                baseViewHolder.setText(2131371186, this.f31585a.getString(R.string.blued_call_buy));
            }
        }
    }
}
