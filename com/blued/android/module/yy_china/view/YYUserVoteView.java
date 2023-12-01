package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYVoteDataModel;
import com.blued.android.module.yy_china.model.YYVoteListModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYUserVoteView.class */
public class YYUserVoteView extends LinearLayout {
    private RecyclerView a;
    private ShapeTextView b;
    private VoteUserAdapter c;
    private BaseYYStudioFragment d;
    private String e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYUserVoteView$VoteUserAdapter.class */
    public class VoteUserAdapter extends BaseQuickAdapter<YYVoteDataModel, BaseViewHolder> {
        public VoteUserAdapter() {
            super(R.layout.item_yy_vote_user, new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(final BaseViewHolder baseViewHolder, final YYVoteDataModel yYVoteDataModel) {
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_vote_header);
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_vote_count);
            ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_check);
            ImageLoader.a(YYUserVoteView.this.d.getFragmentActive(), yYVoteDataModel.avatar).b(R.drawable.user_bg_round).a(imageView);
            textView.setText(yYVoteDataModel.num + "票");
            if (yYVoteDataModel.is_choise == 1) {
                shapeTextView.setVisibility(0);
                shapeTextView.setText(YYUserVoteView.this.getResources().getString(R.string.yy_mic_voted));
                shapeTextView.setEnabled(false);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.syc_8d8d8e);
                ShapeHelper.a(shapeTextView, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
            } else if (YYUserVoteView.this.f) {
                shapeTextView.setVisibility(4);
            } else {
                shapeTextView.setVisibility(0);
                shapeTextView.setText(YYUserVoteView.this.getResources().getString(R.string.yy_mic_vote));
                shapeTextView.setEnabled(true);
                ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView, R.color.white);
                ShapeHelper.a(shapeTextView, R.color.syc_00E0AB, R.color.syc_3883FD);
            }
            shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYUserVoteView.VoteUserAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    YYRoomModel b = YYRoomInfoManager.e().b();
                    if (b != null) {
                        EventTrackYY.l(ChatRoomProtos.Event.CHAT_ROOM_VOTE_USER_CLICK, b.room_id, b.uid, yYVoteDataModel.uid);
                    }
                    YYUserVoteView.this.a(yYVoteDataModel, baseViewHolder.getAdapterPosition());
                }
            });
        }
    }

    public YYUserVoteView(Context context) {
        super(context);
        a();
    }

    public YYUserVoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYUserVoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_user_vote, (ViewGroup) this, true);
        this.a = findViewById(R.id.rv_vote_user_list);
        ShapeTextView shapeTextView = (ShapeTextView) findViewById(R.id.tv_close_vote);
        this.b = shapeTextView;
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYUserVoteView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYUserVoteView.this.b();
            }
        });
        this.c = new VoteUserAdapter();
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            if (TextUtils.equals(b.uid, YYRoomInfoManager.e().k())) {
                this.b.setVisibility(0);
            } else {
                this.b.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final YYVoteDataModel yYVoteDataModel, int i) {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null || yYVoteDataModel == null) {
            return;
        }
        YYRoomHttpUtils.d(b.room_id, yYVoteDataModel.vote_id, yYVoteDataModel.uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYUserVoteView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                yYVoteDataModel.num++;
                yYVoteDataModel.is_choise = 1;
                YYUserVoteView.this.f = true;
                YYUserVoteView.this.c.notifyDataSetChanged();
            }
        }, (IRequestHost) this.d.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        LiveAlterDialog.a(getContext(), R.layout.dialog_vote_close_layout, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYUserVoteView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYUserVoteView.this.c();
            }
        }, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        YYRoomHttpUtils.j(b.room_id, b.vote_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYUserVoteView.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (YYUserVoteView.this.d != null) {
                    YYUserVoteView.this.d.y();
                }
            }
        }, (IRequestHost) this.d.getFragmentActive());
    }

    private void getVoteList() {
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            YYRoomHttpUtils.i(b.room_id, b.vote_id, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYVoteListModel>>(this.d.getFragmentActive()) { // from class: com.blued.android.module.yy_china.view.YYUserVoteView.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<YYVoteListModel> bluedEntityA) {
                    if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.getSingleData() == null) {
                        return;
                    }
                    if (bluedEntityA.getSingleData().vote_data.size() < 4) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(YYUserVoteView.this.getContext());
                        linearLayoutManager.setOrientation(0);
                        YYUserVoteView.this.a.setLayoutManager(linearLayoutManager);
                    } else {
                        YYUserVoteView.this.a.setLayoutManager(new GridLayoutManager(YYUserVoteView.this.getContext(), 4));
                    }
                    Iterator<YYVoteDataModel> it = bluedEntityA.getSingleData().vote_data.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().is_choise == 1) {
                            YYUserVoteView.this.f = true;
                            break;
                        }
                    }
                    YYUserVoteView.this.a.setAdapter(YYUserVoteView.this.c);
                    YYUserVoteView.this.c.setNewData(bluedEntityA.getSingleData().vote_data);
                }
            }, (IRequestHost) this.d.getFragmentActive());
        }
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment, String str) {
        this.d = baseYYStudioFragment;
        this.e = str;
        getVoteList();
    }
}
