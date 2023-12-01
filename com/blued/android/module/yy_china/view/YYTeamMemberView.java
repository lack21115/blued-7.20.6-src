package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYTeamMemberAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.listener.IMemberClickListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYTeamMemberView.class */
public class YYTeamMemberView extends LinearLayout {
    private TextView a;
    private RecyclerView b;
    private TextView c;
    private YYTeamMemberAdapter d;
    private BaseYYStudioFragment e;
    private YYRoomModel f;
    private int g;

    public YYTeamMemberView(Context context) {
        super(context);
        this.g = 0;
        a();
    }

    public YYTeamMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        a();
    }

    public YYTeamMemberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = 0;
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_team_member_layout, (ViewGroup) this, true);
        this.a = (TextView) findViewById(R.id.tv_window_title);
        this.b = findViewById(R.id.rv_member_list);
        TextView textView = (TextView) findViewById(R.id.no_data_view);
        this.c = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYTeamMemberView.this.getMemberInfo();
            }
        });
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        YYRoomModel yYRoomModel = this.f;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.l(yYRoomModel.room_id, str, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYTeamMemberView.this.e.y();
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th) {
                super.onFailure(th);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YYTeamMemberView.this.e.y();
                    }
                });
            }
        }, (IRequestHost) this.e.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<YYSeatMemberModel> list) {
        this.c.setVisibility(8);
        this.b.setVisibility(0);
        if (list.size() < 4) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(0);
            this.b.setLayoutManager(linearLayoutManager);
        } else {
            this.b.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }
        this.d.setNewData(list);
    }

    private void b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager);
        YYTeamMemberAdapter yYTeamMemberAdapter = new YYTeamMemberAdapter();
        this.d = yYTeamMemberAdapter;
        this.b.setAdapter(yYTeamMemberAdapter);
        this.d.a(new IMemberClickListener() { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.3
            @Override // com.blued.android.module.yy_china.listener.IMemberClickListener
            public void a(int i) {
                YYSeatMemberModel yYSeatMemberModel;
                if (YYTeamMemberView.this.e == null || (yYSeatMemberModel = (YYSeatMemberModel) YYTeamMemberView.this.d.getData().get(i)) == null) {
                    return;
                }
                int i2 = YYTeamMemberView.this.g;
                if (i2 == 1) {
                    YYTeamMemberView.this.a(yYSeatMemberModel.getUid());
                } else if (i2 != 2) {
                } else {
                    YYTeamMemberView.this.b(yYSeatMemberModel.getUid());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        YYRoomModel yYRoomModel = this.f;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.n(yYRoomModel.room_id, str, new BluedUIHttpResponse<BluedEntityA<Object>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYTeamMemberView.this.e.y();
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th) {
                super.onFailure(th);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YYTeamMemberView.this.e.y();
                    }
                });
            }
        }, this.e.getFragmentActive());
    }

    private void getBattleList() {
        YYRoomModel yYRoomModel = this.f;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.J(yYRoomModel.room_id, getHttpResponse(), this.e.getFragmentActive());
    }

    private BluedUIHttpResponse getHttpResponse() {
        return new BluedUIHttpResponse<BluedEntityA<YYSeatMemberModel>>(this.e.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYSeatMemberModel> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    YYTeamMemberView.this.a(bluedEntityA.data);
                    return;
                }
                YYTeamMemberView.this.c.setVisibility(0);
                YYTeamMemberView.this.b.setVisibility(8);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th) {
                super.onFailure(th);
                AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.view.YYTeamMemberView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        YYTeamMemberView.this.b.setVisibility(8);
                        YYTeamMemberView.this.c.setVisibility(0);
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMemberInfo() {
        int i = this.g;
        if (i == 1) {
            getMemberList();
        } else if (i != 2) {
        } else {
            getBattleList();
        }
    }

    private void getMemberList() {
        YYRoomModel yYRoomModel = this.f;
        if (yYRoomModel == null) {
            return;
        }
        YYRoomHttpUtils.G(yYRoomModel.room_id, getHttpResponse(), this.e.getFragmentActive());
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, String str, int i) {
        this.e = baseYYStudioFragment;
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(str);
        }
        this.g = i;
        YYRoomModel b = YYRoomInfoManager.e().b();
        this.f = b;
        if (b == null) {
            return;
        }
        getMemberInfo();
    }
}
