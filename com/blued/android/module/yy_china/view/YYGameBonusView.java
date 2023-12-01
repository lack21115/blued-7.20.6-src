package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYGameBonusAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.IMemberClickListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYGameBonusModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGameBonusView.class */
public class YYGameBonusView extends LinearLayout {
    private RecyclerView a;
    private ShapeTextView b;
    private YYGameBonusAdapter c;
    private BaseYYStudioFragment d;
    private YYRoomModel e;

    public YYGameBonusView(Context context) {
        super(context);
        a();
    }

    public YYGameBonusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYGameBonusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_game_bonus_layout, (ViewGroup) this, true);
        this.a = findViewById(R.id.rv_bonus_list);
        this.b = (ShapeTextView) findViewById(R.id.no_data_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.a.setLayoutManager(linearLayoutManager);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYGameBonusView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYGameBonusView.this.getBonusGiftes();
            }
        });
    }

    private void a(ActivityFragmentActive activityFragmentActive) {
        YYGameBonusAdapter yYGameBonusAdapter = new YYGameBonusAdapter(activityFragmentActive);
        this.c = yYGameBonusAdapter;
        this.a.setAdapter(yYGameBonusAdapter);
        this.c.a(new IMemberClickListener() { // from class: com.blued.android.module.yy_china.view.YYGameBonusView.2
            @Override // com.blued.android.module.yy_china.listener.IMemberClickListener
            public void a(int i) {
                YYGiftModel yYGiftModel;
                if (YYGameBonusView.this.e == null || YYGameBonusView.this.d == null || (yYGiftModel = (YYGiftModel) YYGameBonusView.this.c.getData().get(i)) == null) {
                    return;
                }
                YYGameBonusView.this.d.a(true, "", yYGiftModel.goods_id, YYGameBonusView.this.e.uid);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBonusGiftes() {
        YYRoomModel yYRoomModel = this.e;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.I(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYGameBonusModel>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYGameBonusView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYGameBonusModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    YYGameBonusView.this.b.setVisibility(0);
                    YYGameBonusView.this.a.setVisibility(8);
                    return;
                }
                YYGameBonusView.this.a.setVisibility(0);
                YYGameBonusView.this.b.setVisibility(8);
                ArrayList arrayList = new ArrayList();
                arrayList.add(bluedEntityA.getSingleData().incr);
                arrayList.add(bluedEntityA.getSingleData().decr);
                YYGameBonusView.this.c.setNewData(arrayList);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th) {
                super.onFailure(th);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYGameBonusView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YYGameBonusView.this.a.setVisibility(8);
                        YYGameBonusView.this.b.setVisibility(0);
                    }
                });
            }
        }, this.d.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.d = baseYYStudioFragment;
        this.e = YYRoomInfoManager.e().b();
        a(baseYYStudioFragment.getFragmentActive());
        getBonusGiftes();
    }
}
