package com.blued.android.module.live_china.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveCloseItemAdapter.class */
public class LiveCloseItemAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f11602a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private List<BluedLiveRankListData> f11603c;
    private boolean d;
    private IRequestHost e;
    private Dialog f;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveCloseItemAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f11609a;
        ImageView b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f11610c;
        TextView d;
        TextView e;
        TextView f;
        ImageView g;
        LinearLayout h;
        ImageView i;
        ImageView j;
        TextView k;

        private ViewHolder() {
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11603c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11603c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view2 = this.f11602a.inflate(R.layout.item_live_close_guest, viewGroup, false);
            viewHolder.b = (ImageView) view2.findViewById(R.id.live_end_user_pic);
            viewHolder.f11609a = (ImageView) view2.findViewById(R.id.live_end_header_bg);
            viewHolder.e = (TextView) view2.findViewById(R.id.live_user_name);
            viewHolder.f = (TextView) view2.findViewById(R.id.live_user_score);
            viewHolder.h = (LinearLayout) view2.findViewById(R.id.ll_live_rank_name);
            viewHolder.i = (ImageView) view2.findViewById(R.id.img_score_icon);
            viewHolder.k = (TextView) view2.findViewById(R.id.tv_attention);
            viewHolder.j = (ImageView) view2.findViewById(R.id.img_attention);
            viewHolder.g = (ImageView) view2.findViewById(R.id.img_viewer);
            viewHolder.f11610c = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.d = (TextView) view2.findViewById(R.id.tv_live_rank);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final BluedLiveRankListData bluedLiveRankListData = this.f11603c.get(i);
        if (bluedLiveRankListData != null) {
            if (bluedLiveRankListData.active == 1) {
                viewHolder.g.setVisibility(0);
            } else {
                viewHolder.g.setVisibility(8);
            }
            viewHolder.f11609a.setVisibility(0);
            viewHolder.d.setVisibility(8);
            if (i == 0) {
                viewHolder.f11609a.setBackgroundResource(R.drawable.live_close_host_rank_header1);
            } else if (i == 1) {
                viewHolder.f11609a.setBackgroundResource(R.drawable.live_close_host_rank_header2);
            } else if (i == 2) {
                viewHolder.f11609a.setBackgroundResource(R.drawable.live_close_host_rank_header3);
            } else {
                viewHolder.f11609a.setVisibility(4);
                viewHolder.d.setVisibility(0);
                if (i < 9) {
                    TextView textView = viewHolder.d;
                    textView.setText("0" + String.valueOf(i + 1));
                } else {
                    viewHolder.d.setText(String.valueOf(i + 1));
                }
            }
            ImageLoader.a(this.e, bluedLiveRankListData.avatar).b(R.drawable.user_bg_round).c().a(viewHolder.b);
            if ("0".equals(Integer.valueOf(bluedLiveRankListData.vbadge))) {
                viewHolder.f11610c.setVisibility(8);
                viewHolder.f11610c.setImageDrawable(this.b.getResources().getDrawable(R.drawable.v_gray));
            } else {
                viewHolder.f11610c.setVisibility(0);
                LiveRoomInfo.a().a(viewHolder.f11610c, bluedLiveRankListData.vbadge);
            }
            viewHolder.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveCloseItemAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (LiveCloakingUtil.b(bluedLiveRankListData.privilege)) {
                        return;
                    }
                    List<Fragment> fragments = ((FragmentActivity) LiveCloseItemAdapter.this.b).getSupportFragmentManager().getFragments();
                    if (fragments != null && fragments.size() >= 2 && (fragments.get(1) instanceof DialogFragment) && fragments.get(1) != null) {
                        ((DialogFragment) fragments.get(1)).dismiss();
                    }
                    LiveSetDataObserver.a().e(bluedLiveRankListData.uid);
                }
            });
            viewHolder.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveCloseItemAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (LiveCloakingUtil.b(bluedLiveRankListData.privilege)) {
                        return;
                    }
                    List<Fragment> fragments = ((FragmentActivity) LiveCloseItemAdapter.this.b).getSupportFragmentManager().getFragments();
                    if (fragments != null && fragments.size() >= 2 && (fragments.get(1) instanceof DialogFragment) && fragments.get(1) != null) {
                        ((DialogFragment) fragments.get(1)).dismiss();
                    }
                    LiveSetDataObserver.a().e(bluedLiveRankListData.uid);
                }
            });
            viewHolder.e.setText(LiveCloakingUtil.a(bluedLiveRankListData.name, bluedLiveRankListData.privilege));
            viewHolder.i.setVisibility(0);
            viewHolder.f.setText(String.valueOf(CommonStringUtils.d(String.valueOf(bluedLiveRankListData.beans))));
            if (this.d) {
                viewHolder.k.setVisibility(0);
                LiveUserRelationshipUtils.b(this.b, bluedLiveRankListData.relationship, viewHolder.k, viewHolder.j);
                final ViewHolder viewHolder2 = viewHolder;
                viewHolder.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveCloseItemAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        if (LiveRoomInfo.a().b(bluedLiveRankListData.relationship)) {
                            return;
                        }
                        LiveRoomInfo.a().a(LiveCloseItemAdapter.this.b, new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.adapter.LiveCloseItemAdapter.3.1
                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void Q_() {
                                DialogUtils.a(LiveCloseItemAdapter.this.f);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void a(String str) {
                                bluedLiveRankListData.relationship = str;
                                LiveRoomInfo.a().a(LiveCloseItemAdapter.this.b, str, viewHolder2.k, (ImageView) null, false);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void b(String str) {
                                bluedLiveRankListData.relationship = str;
                                LiveRoomInfo.a().a(LiveCloseItemAdapter.this.b, str, viewHolder2.k, (ImageView) null, false);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void c() {
                                DialogUtils.b(LiveCloseItemAdapter.this.f);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void d() {
                                DialogUtils.b(LiveCloseItemAdapter.this.f);
                            }
                        }, bluedLiveRankListData.uid, bluedLiveRankListData.relationship, "", LiveCloseItemAdapter.this.e, true);
                    }
                });
                return view2;
            }
            viewHolder.k.setVisibility(8);
        }
        return view2;
    }
}
