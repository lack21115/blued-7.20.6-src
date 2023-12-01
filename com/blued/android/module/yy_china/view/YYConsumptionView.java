package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyConsumptionBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYConsumptionModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYConsumptionView.class */
public class YYConsumptionView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18110a;
    private ViewYyConsumptionBinding b;

    public YYConsumptionView(Context context) {
        super(context);
        a();
    }

    public YYConsumptionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYConsumptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        ViewYyConsumptionBinding a2 = ViewYyConsumptionBinding.a(LayoutInflater.from(getContext()), this, true);
        this.b = a2;
        a2.f16896c.setText(String.format(getResources().getString(R.string.yy_solo_min_consumption), "10000"));
        this.b.b.setText(String.format(getResources().getString(R.string.yy_consumption_total), "0"));
        this.b.f16895a.setText(String.format(getResources().getString(R.string.yy_consumption_gap), "10000"));
    }

    private void b() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.R(b.room_id, new BluedUIHttpResponse<BluedEntityA<YYConsumptionModel>>(this.f18110a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYConsumptionView.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYConsumptionModel> bluedEntityA) {
                String str;
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                int a2 = StringUtils.a(bluedEntityA.getSingleData().total, 0);
                int a3 = StringUtils.a(bluedEntityA.getSingleData().beans, 0);
                int i = a2 - a3;
                YYConsumptionView.this.b.f16896c.setText(String.format(YYConsumptionView.this.getResources().getString(R.string.yy_solo_min_consumption), a2 + ""));
                YYConsumptionView.this.b.b.setText(String.format(YYConsumptionView.this.getResources().getString(R.string.yy_consumption_total), a3 + ""));
                TextView textView = YYConsumptionView.this.b.f16895a;
                String string = YYConsumptionView.this.getResources().getString(R.string.yy_consumption_gap);
                if (i >= 0) {
                    str = i + "";
                } else {
                    str = "0";
                }
                textView.setText(String.format(string, str));
            }
        }, this.f18110a.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        if (baseYYStudioFragment == null) {
            return;
        }
        this.f18110a = baseYYStudioFragment;
        b();
    }
}
