package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogSendgiftAuctionBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.model.YYRelationDetailMode;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSndgiftAuctionView.class */
public class YYSndgiftAuctionView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private DialogSendgiftAuctionBinding f18496a;
    private BaseYYStudioFragment b;

    /* renamed from: c  reason: collision with root package name */
    private YYRelationDetailMode f18497c;
    private String d;

    public YYSndgiftAuctionView(Context context) {
        this(context, null);
    }

    public YYSndgiftAuctionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYSndgiftAuctionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18496a = DialogSendgiftAuctionBinding.a(LayoutInflater.from(context), this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(YYRelationDetailMode yYRelationDetailMode) {
        if (yYRelationDetailMode == null || yYRelationDetailMode.getRelation() == null || yYRelationDetailMode.getGoods() == null) {
            return;
        }
        this.f18497c = yYRelationDetailMode;
        ImageLoader.a(this.b.getFragmentActive(), yYRelationDetailMode.getRelation().getRelation_image()).a(this.f18496a.f16409a);
        this.f18496a.f16410c.setText(yYRelationDetailMode.getRelation().getContent());
        this.f18496a.e.setText(String.format(getContext().getString(R.string.yy_day), yYRelationDetailMode.getRelation().getDuration()));
        ImageLoader.a(this.b.getFragmentActive(), yYRelationDetailMode.getGoods().getImages_static()).a(this.f18496a.b);
        this.f18496a.d.setText(yYRelationDetailMode.getGoods().getName());
        TextView textView = this.f18496a.f;
        textView.setText(yYRelationDetailMode.getGoods().getBeans() + getResources().getString(R.string.yy_gift_beans));
        this.f18496a.g.setOnClickListener(this);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, String str, String str2) {
        this.b = baseYYStudioFragment;
        this.d = str2;
        YYRoomHttpUtils.O(str, new BluedUIHttpResponse<BluedEntityA<YYRelationDetailMode>>(baseYYStudioFragment.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYSndgiftAuctionView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYRelationDetailMode> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                YYSndgiftAuctionView.this.a(bluedEntityA.getSingleData());
            }
        }, baseYYStudioFragment.getFragmentActive());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        YYRelationDetailMode yYRelationDetailMode;
        Tracker.onClick(view);
        if (view.getId() != R.id.tv_ok || (yYRelationDetailMode = this.f18497c) == null || yYRelationDetailMode.getGoods() == null || TextUtils.isEmpty(this.d)) {
            return;
        }
        this.b.y();
        this.b.a(true, "", this.f18497c.getGoods().getGoods_id(), this.d);
    }
}
