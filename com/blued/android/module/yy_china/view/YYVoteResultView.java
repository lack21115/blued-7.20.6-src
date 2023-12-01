package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYVoteDataModel;
import com.blued.android.module.yy_china.model.YYVoteListModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYVoteResultView.class */
public class YYVoteResultView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18555a;
    private VoteResultAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f18556c;
    private ImageView d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYVoteResultView$VoteResultAdapter.class */
    public class VoteResultAdapter extends BaseQuickAdapter<YYVoteDataModel, BaseViewHolder> {
        public VoteResultAdapter() {
            super(R.layout.item_yy_vote_resul_listt, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYVoteDataModel yYVoteDataModel) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_result_header);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_result_count);
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_result_name);
            TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_result_index);
            ImageLoader.a(YYVoteResultView.this.f18555a.getFragmentActive(), yYVoteDataModel.avatar).b(R.drawable.user_bg_round).a(imageView);
            textView.setText(yYVoteDataModel.num + "票");
            textView2.setText(yYVoteDataModel.name);
            textView3.setText(StringUtils.a(baseViewHolder.getAdapterPosition() + 1, ""));
            if (baseViewHolder.getAdapterPosition() == 0) {
                textView3.setTextColor(BluedSkinUtils.a(YYVoteResultView.this.getContext(), R.color.syc_00E0AB));
            } else {
                textView3.setTextColor(BluedSkinUtils.a(YYVoteResultView.this.getContext(), R.color.syc_dark_8F8F91));
            }
        }
    }

    public YYVoteResultView(Context context) {
        super(context);
        a();
    }

    public YYVoteResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYVoteResultView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_vote_result, (ViewGroup) this, true);
        this.b = new VoteResultAdapter();
        this.f18556c = (RecyclerView) findViewById(R.id.rv_vote_result);
        this.d = (ImageView) findViewById(R.id.iv_close_result);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.f18556c.setLayoutManager(linearLayoutManager);
        this.f18556c.setAdapter(this.b);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYVoteResultView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYVoteResultView.this.f18555a != null) {
                    YYVoteResultView.this.f18555a.y();
                }
            }
        });
    }

    private void getVoteList() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            YYRoomHttpUtils.i(b.room_id, b.vote_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYVoteListModel>>(this.f18555a.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYVoteResultView.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYVoteListModel> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                        return;
                    }
                    YYVoteResultView.this.b.setNewData(bluedEntityA.getSingleData().vote_data);
                }
            }, (IRequestHost) this.f18555a.getFragmentActive());
        }
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.f18555a = baseYYStudioFragment;
        getVoteList();
    }
}
