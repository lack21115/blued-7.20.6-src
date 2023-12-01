package com.blued.android.module.yy_china.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.utils.UserRelationshipUtils;
import com.blued.android.module.yy_china.view.RankingView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/EndMemberAdapter.class */
public class EndMemberAdapter extends BaseMultiItemQuickAdapter<YYUserInfo, BaseViewHolder> implements FollowStatusObserver {
    private final SmartRefreshLayout a;
    private final RankingView b;
    private IRequestHost c;
    private MvpFragment d;
    private BluedEntityA<YYUserInfo> e;

    public EndMemberAdapter(MvpFragment mvpFragment, SmartRefreshLayout smartRefreshLayout, RankingView rankingView) {
        super(new ArrayList());
        this.d = mvpFragment;
        this.c = mvpFragment.getFragmentActive();
        this.a = smartRefreshLayout;
        addItemType(0, R.layout.item_end_member_layout);
        addItemType(1, R.layout.item_end_member_more_layout);
        this.b = rankingView;
    }

    public void a() {
        if (this.e != null) {
            ArrayList arrayList = new ArrayList();
            int i = 5;
            while (true) {
                int i2 = i;
                if (i2 >= this.e.data.size()) {
                    break;
                }
                arrayList.add(this.e.data.get(i2));
                i = i2 + 1;
            }
            addData(arrayList);
            if (this.e.hasMore()) {
                this.a.b(true);
            } else {
                this.a.b(false);
            }
        }
    }

    public void a(BluedEntityA<YYUserInfo> bluedEntityA) {
        this.e = bluedEntityA;
        if (bluedEntityA.data == null || bluedEntityA.data.size() <= 5) {
            setNewData(bluedEntityA.data);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                YYUserInfo yYUserInfo = new YYUserInfo();
                yYUserInfo.itemType = 1;
                arrayList.add(yYUserInfo);
                setNewData(arrayList);
                return;
            }
            arrayList.add(bluedEntityA.data.get(i2));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final YYUserInfo yYUserInfo) {
        int itemType = yYUserInfo.getItemType();
        if (itemType != 0) {
            if (itemType != 1) {
                return;
            }
            baseViewHolder.itemView.setClickable(true);
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.EndMemberAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    baseViewHolder.itemView.setClickable(false);
                    for (int i = 0; i < EndMemberAdapter.this.getData().size(); i++) {
                        if (((YYUserInfo) EndMemberAdapter.this.getData().get(i)).getItemType() == 1) {
                            EndMemberAdapter.this.remove(i);
                            EndMemberAdapter.this.a();
                            return;
                        }
                    }
                }
            });
            return;
        }
        final ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_member_view);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_member_name);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_member_style);
        final ShapeTextView shapeTextView = (ShapeTextView) baseViewHolder.getView(R.id.tv_follow);
        ImageLoader.a(this.c, yYUserInfo.getAvatar()).b(R.drawable.user_bg_round).a(imageView);
        textView.setText(yYUserInfo.getName());
        textView2.setText(String.format(textView2.getResources().getString(R.string.yy_years_height_weight), yYUserInfo.age, yYUserInfo.height, yYUserInfo.weight, UserInfoHelper.a(textView2.getContext(), (TextView) null, yYUserInfo.role)));
        if (TextUtils.equals(yYUserInfo.getUid(), YYRoomInfoManager.e().k()) || TextUtils.equals(yYUserInfo.relationship, "8") || TextUtils.equals(yYUserInfo.relationship, "4")) {
            shapeTextView.setVisibility(8);
        } else {
            shapeTextView.setVisibility(0);
        }
        shapeTextView.setText(UserRelationshipUtils.a(shapeTextView.getContext(), yYUserInfo.relationship));
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.EndMemberAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (!YYObserverManager.a().c(EndMemberAdapter.this)) {
                    YYObserverManager.a().a(EndMemberAdapter.this);
                }
                if (TextUtils.equals(yYUserInfo.relationship, "1") || TextUtils.equals(yYUserInfo.relationship, "3")) {
                    YYRoomInfoManager.e().a(shapeTextView.getContext(), yYUserInfo.getUid(), "", EndMemberAdapter.this.c);
                } else {
                    YYRoomInfoManager.e().b(shapeTextView.getContext(), yYUserInfo.getUid(), "", EndMemberAdapter.this.c);
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.EndMemberAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomInfoManager.e().c().a(imageView.getContext(), yYUserInfo.getUid(), yYUserInfo.getName(), yYUserInfo.getAvatar(), yYUserInfo.vbadge, 2);
                YYRoomInfoManager.e().x();
            }
        });
    }

    @Override // com.blued.android.module.yy_china.observer.FollowStatusObserver
    public void a_(String str, String str2) {
        int i;
        Iterator it = getData().iterator();
        int i2 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            YYUserInfo yYUserInfo = (YYUserInfo) it.next();
            if (TextUtils.equals(str, yYUserInfo.getUid())) {
                yYUserInfo.relationship = str2;
                break;
            }
            i2 = i + 1;
        }
        notifyItemChanged(i);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        YYObserverManager.a().a(this);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        YYObserverManager.a().b(this);
    }
}
