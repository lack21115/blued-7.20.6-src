package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYSendVoteModel;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSendVoteView.class */
public class YYSendVoteView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f18472a;
    private RecyclerView b;

    /* renamed from: c  reason: collision with root package name */
    private ShapeFrameLayout f18473c;
    private ShapeFrameLayout d;
    private ShapeTextView e;
    private ShapeTextView f;
    private ShapeTextView g;
    private int h;
    private String i;
    private YYVoteTimeModel j;
    private VoteUserAdapter k;
    private BaseYYStudioFragment l;
    private List<String> m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSendVoteView$VoteTimeAdapter.class */
    public class VoteTimeAdapter extends BaseQuickAdapter<YYVoteTimeModel, BaseViewHolder> {
        public VoteTimeAdapter() {
            super(R.layout.item_vote_time_layout, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYVoteTimeModel yYVoteTimeModel) {
            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_vote_time);
            ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_vote_time);
            shapeTextView.setText(yYVoteTimeModel.timeStr);
            if (yYVoteTimeModel.isCheck) {
                ShapeHelper.a(shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.white);
                return;
            }
            ShapeHelper.a(shapeFrameLayout, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
            ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_8d8d8e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYSendVoteView$VoteUserAdapter.class */
    public class VoteUserAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {
        public VoteUserAdapter() {
            super(R.layout.item_vote_user_layout, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_vote_header);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_vote);
            ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout) baseViewHolder.getView(R.id.fl_vote_header);
            ImageLoader.a((IRequestHost) null, yYSeatMemberModel.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
            if (yYSeatMemberModel.isVoted) {
                imageView2.setVisibility(0);
                ShapeHelper.a(shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
                return;
            }
            imageView2.setVisibility(8);
            ShapeHelper.a(shapeFrameLayout, R.color.white, R.color.white);
        }
    }

    public YYSendVoteView(Context context) {
        super(context);
        this.h = 1;
        this.i = null;
        this.m = new ArrayList();
        a();
    }

    public YYSendVoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = 1;
        this.i = null;
        this.m = new ArrayList();
        a();
    }

    public YYSendVoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 1;
        this.i = null;
        this.m = new ArrayList();
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_send_vote, (ViewGroup) this, true);
        this.f18472a = (RecyclerView) findViewById(R.id.rv_vote_list);
        this.b = (RecyclerView) findViewById(R.id.rv_times_lsit);
        this.f18473c = (ShapeFrameLayout) findViewById(R.id.fl_all);
        this.d = (ShapeFrameLayout) findViewById(R.id.fl_only_mic);
        this.e = (ShapeTextView) findViewById(R.id.tv_all_vote);
        this.f = (ShapeTextView) findViewById(R.id.tv_mic_vote);
        this.g = (ShapeTextView) findViewById(R.id.tv_create_vote);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        onClick(this.e);
        this.k = new VoteUserAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        this.f18472a.setLayoutManager(linearLayoutManager);
        this.f18472a.setAdapter(this.k);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (YYSeatMemberModel yYSeatMemberModel : b.getHasPeopleMics()) {
            arrayList.add(yYSeatMemberModel.copy());
        }
        this.k.setNewData(arrayList);
        this.k.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYSendVoteView.1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YYSeatMemberModel item = YYSendVoteView.this.k.getItem(i);
                item.isVoted = !item.isVoted;
                if (item.isVoted) {
                    YYSendVoteView.this.m.add(item.getUid());
                } else {
                    YYSendVoteView.this.m.remove(item.getUid());
                }
                YYSendVoteView.this.k.notifyItemChanged(i);
                YYSendVoteView.this.b();
            }
        });
        final VoteTimeAdapter voteTimeAdapter = new VoteTimeAdapter();
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
        linearLayoutManager2.setOrientation(0);
        this.b.setLayoutManager(linearLayoutManager2);
        this.b.setAdapter(voteTimeAdapter);
        voteTimeAdapter.setNewData(getTimeList());
        voteTimeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.view.YYSendVoteView.2
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= voteTimeAdapter.getItemCount()) {
                        voteTimeAdapter.notifyDataSetChanged();
                        return;
                    }
                    YYVoteTimeModel item = voteTimeAdapter.getItem(i3);
                    if (i3 == i) {
                        item.isCheck = true;
                        YYSendVoteView.this.j = item;
                    } else {
                        item.isCheck = false;
                    }
                    i2 = i3 + 1;
                }
            }
        });
    }

    private void a(boolean z) {
        this.h = z ? 1 : 2;
        this.i = getResources().getString(z ? R.string.yy_vote_all : R.string.yy_vote_mic);
        ShapeHelper.a(z ? this.f18473c : this.d, R.color.syc_00E0AB, R.color.syc_3883FD);
        ShapeHelper.a((ShapeHelper.ShapeView) (z ? this.e : this.f), R.color.white);
        ShapeHelper.a(z ? this.d : this.f18473c, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
        ShapeHelper.a((ShapeHelper.ShapeView) (z ? this.f : this.e), R.color.syc_8d8d8e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.m.size() >= 2) {
            this.g.setEnabled(true);
            this.g.setAlpha(1.0f);
            return;
        }
        this.g.setEnabled(false);
        this.g.setAlpha(0.3f);
    }

    private void c() {
        final YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || this.j == null) {
            return;
        }
        EventTrackYY.f(ChatRoomProtos.Event.CHAT_ROOM_VOTE_LAUNCH_CLICK, b.room_id, this.i);
        YYRoomHttpUtils.a(b.room_id, this.h, this.j.timeMill, this.m, new BluedUIHttpResponse<BluedEntityA<YYSendVoteModel>>(this.l.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYSendVoteView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYSendVoteModel> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                    return;
                }
                b.vote_id = bluedEntityA.getSingleData().vote_id;
                YYSendVoteView.this.l.y();
            }
        }, this.l.getFragmentActive());
    }

    private List<YYVoteTimeModel> getTimeList() {
        String[] stringArray = getResources().getStringArray(R.array.yy_vote_times);
        String[] stringArray2 = getResources().getStringArray(R.array.yy_vote_time_mill);
        if (stringArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stringArray.length) {
                return arrayList;
            }
            YYVoteTimeModel yYVoteTimeModel = new YYVoteTimeModel();
            yYVoteTimeModel.timeStr = stringArray[i2];
            if (i2 < stringArray2.length) {
                yYVoteTimeModel.timeMill = StringUtils.a(stringArray2[i2], 0);
            }
            if (i2 == 0) {
                this.j = yYVoteTimeModel;
                yYVoteTimeModel.isCheck = true;
            }
            arrayList.add(yYVoteTimeModel);
            i = i2 + 1;
        }
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.l = baseYYStudioFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.tv_all_vote) {
            a(true);
        } else if (view.getId() == R.id.tv_mic_vote) {
            a(false);
        } else if (view.getId() == R.id.tv_create_vote) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        List<String> list = this.m;
        if (list != null) {
            list.clear();
            this.m = null;
        }
        this.j = null;
        this.h = 1;
    }
}
