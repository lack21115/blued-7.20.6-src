package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.BluedLinearLayoutManager;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.AudienceAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.observer.AudienceCountObserver;
import com.blued.android.module.yy_china.observer.AudiencesChangedObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYAudienceListView.class */
public class YYAudienceListView extends RelativeLayout implements AudienceCountObserver, AudiencesChangedObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18036a;
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private AudienceAdapter f18037c;
    private TextView d;

    public YYAudienceListView(Context context) {
        super(context);
        a();
    }

    public YYAudienceListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYAudienceListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        Logger.e("YYAudienceListView", "YYAudienceListView initView ... ");
        YYObserverManager.a().a((AudienceCountObserver) this);
        YYObserverManager.a().a((AudiencesChangedObserver) this);
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_audience_list, (ViewGroup) this, true);
        this.b = (RecyclerView) findViewById(R.id.rv_fans_list_view);
        this.d = (TextView) findViewById(R.id.tv_audience_view);
        BluedLinearLayoutManager bluedLinearLayoutManager = new BluedLinearLayoutManager(getContext());
        bluedLinearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(bluedLinearLayoutManager);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYAudienceListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYAudienceListView.this.f18036a.c(0);
            }
        });
    }

    private void getMembers() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.k(b.room_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYAudienceModel>>(this.f18036a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYAudienceListView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYAudienceModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    YYAudienceListView.this.a(0);
                    return;
                }
                YYAudienceListView.this.f18037c.setNewData(null);
                YYRoomModel b2 = YYRoomInfoManager.e().b();
                StringBuilder sb = new StringBuilder();
                sb.append("response model is empty : ");
                sb.append(b2 == null);
                Logger.e("YYAudienceListView", sb.toString());
                if (b2 != null) {
                    Logger.e("YYAudienceListView", "response list size : " + bluedEntityA.data.size());
                    b2.setAudiences(bluedEntityA.data);
                }
                YYAudienceListView.this.a(bluedEntityA.data);
                YYAudienceListView.this.a(bluedEntityA.extra.total);
            }
        }, (IRequestHost) this.f18036a.getFragmentActive());
    }

    @Override // com.blued.android.module.yy_china.observer.AudienceCountObserver
    public void a(int i) {
        this.d.setText(CommonStringUtils.d(i));
    }

    public void a(final BaseYYStudioFragment baseYYStudioFragment) {
        Logger.e("YYAudienceListView", "YYAudienceListView init ... ");
        this.f18036a = baseYYStudioFragment;
        YYObserverManager.a().a((AudienceCountObserver) this);
        YYObserverManager.a().a((AudiencesChangedObserver) this);
        AudienceAdapter audienceAdapter = new AudienceAdapter(getContext(), baseYYStudioFragment);
        this.f18037c = audienceAdapter;
        this.b.setAdapter(audienceAdapter);
        this.f18037c.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYAudienceListView.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYAudienceModel yYAudienceModel;
                if (YYAudienceListView.this.f18037c.getData().isEmpty() || i >= YYAudienceListView.this.f18037c.getData().size() || (yYAudienceModel = YYAudienceListView.this.f18037c.getData().get(i)) == null) {
                    return;
                }
                BaseYYStudioFragment baseYYStudioFragment2 = baseYYStudioFragment;
                String uid = yYAudienceModel.getUid();
                String name = yYAudienceModel.getName();
                String avatar = yYAudienceModel.getAvatar();
                baseYYStudioFragment2.a(uid, name, avatar, baseYYStudioFragment.F() + "", false);
            }
        });
        getMembers();
    }

    @Override // com.blued.android.module.yy_china.observer.AudiencesChangedObserver
    public void a(List<YYAudienceModel> list) {
        if (this.f18036a == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            this.f18037c.setNewData(null);
            return;
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<YYAudienceModel> it = list.iterator();
        for (int i = 0; it.hasNext() && i <= 2; i++) {
            arrayList.add(it.next().copy());
        }
        this.f18037c.setNewData(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger.e("YYAudienceListView", "YYAudienceListView onAttachedToWindow ... ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Logger.e("YYAudienceListView", "YYAudienceListView onDetachedFromWindow ... ");
        YYObserverManager.a().b((AudienceCountObserver) this);
        YYObserverManager.a().b((AudiencesChangedObserver) this);
    }
}
