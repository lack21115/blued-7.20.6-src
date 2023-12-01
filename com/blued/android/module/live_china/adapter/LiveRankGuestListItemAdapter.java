package com.blued.android.module.live_china.adapter;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveRankBehalfRecordListDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveRankListData;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveRankGuestListItemAdapter.class */
public class LiveRankGuestListItemAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f11680a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Fragment f11681c;
    private List<BluedLiveRankListData> d;
    private LoadOptions e;
    private LoadOptions f;
    private LoadOptions g;
    private String h;
    private boolean i;
    private IRequestHost j;
    private Dialog k;
    private boolean l;
    private boolean m = false;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveRankGuestListItemAdapter$ViewHolder.class */
    class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        ImageView f11688a;
        ImageView b;

        /* renamed from: c  reason: collision with root package name */
        TextView f11689c;
        TextView d;
        TextView e;
        TextView f;
        ImageView g;
        LinearLayout h;
        TextView i;
        TextView j;
        ImageView k;

        private ViewHolder() {
        }
    }

    public LiveRankGuestListItemAdapter(Fragment fragment, List<BluedLiveRankListData> list, boolean z, boolean z2, IRequestHost iRequestHost) {
        this.f11681c = fragment;
        Context context = fragment.getContext();
        this.b = context;
        this.d = list;
        this.f11680a = LayoutInflater.from(context);
        LoadOptions loadOptions = new LoadOptions();
        this.e = loadOptions;
        loadOptions.d = R.drawable.live_bg;
        this.e.b = R.drawable.live_bg;
        this.e.a(750, 750);
        LoadOptions loadOptions2 = new LoadOptions();
        this.f = loadOptions2;
        loadOptions2.d = R.drawable.live_list_item_card_img;
        this.f.b = R.drawable.live_list_item_card_img;
        LoadOptions loadOptions3 = new LoadOptions();
        this.g = loadOptions3;
        loadOptions3.d = R.drawable.user_bg_round;
        this.g.b = R.drawable.user_bg_round;
        this.i = z;
        this.j = iRequestHost;
        this.l = z2;
        this.k = DialogUtils.a(this.b);
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(List<BluedLiveRankListData> list) {
        List<BluedLiveRankListData> list2 = this.d;
        if (list2 == null) {
            this.d = new ArrayList();
        } else {
            list2.clear();
        }
        b(list);
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void b(List<BluedLiveRankListData> list) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        this.d.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d.get(i);
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
            view2 = this.f11680a.inflate(R.layout.item_live_rank_guest, viewGroup, false);
            viewHolder.f11688a = (ImageView) view2.findViewById(R.id.live_end_user_pic);
            viewHolder.b = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.f11689c = (TextView) view2.findViewById(R.id.tv_live_rank);
            viewHolder.d = (TextView) view2.findViewById(R.id.live_user_name);
            viewHolder.e = (TextView) view2.findViewById(R.id.live_user_score);
            viewHolder.f = (TextView) view2.findViewById(R.id.live_user_score_des);
            viewHolder.g = (ImageView) view2.findViewById(R.id.img_viewer);
            viewHolder.h = (LinearLayout) view2.findViewById(R.id.ll_live_rank_name);
            viewHolder.i = (TextView) view2.findViewById(R.id.tv_score_label);
            viewHolder.j = (TextView) view2.findViewById(R.id.tv_attention);
            viewHolder.k = (ImageView) view2.findViewById(R.id.iv_live_rank_behalf_arrow);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final BluedLiveRankListData bluedLiveRankListData = this.d.get(i);
        if (bluedLiveRankListData != null) {
            if (bluedLiveRankListData.active == 1) {
                viewHolder.g.setVisibility(0);
            } else {
                viewHolder.g.setVisibility(8);
            }
            if (i == 0) {
                viewHolder.f11689c.setText("");
                viewHolder.f11689c.setBackground(this.b.getResources().getDrawable(R.drawable.live_rank_one));
            } else if (i == 1) {
                viewHolder.f11689c.setText("");
                viewHolder.f11689c.setBackground(this.b.getResources().getDrawable(R.drawable.live_rank_two));
            } else if (i == 2) {
                viewHolder.f11689c.setText("");
                viewHolder.f11689c.setBackground(this.b.getResources().getDrawable(R.drawable.live_rank_three));
            } else {
                if (i < 9) {
                    TextView textView = viewHolder.f11689c;
                    textView.setText("0" + String.valueOf(i + 1));
                } else {
                    viewHolder.f11689c.setText(String.valueOf(i + 1));
                }
                viewHolder.f11689c.setBackground(null);
            }
            ImageLoader.a(this.j, bluedLiveRankListData.avatar).b(R.drawable.user_bg_round).c().a(viewHolder.f11688a);
            if ("0".equals(Integer.valueOf(bluedLiveRankListData.vbadge))) {
                viewHolder.b.setVisibility(8);
                viewHolder.b.setImageDrawable(this.b.getResources().getDrawable(R.drawable.v_gray));
            } else {
                viewHolder.b.setVisibility(0);
                LiveRoomInfo.a().a(viewHolder.b, bluedLiveRankListData.vbadge);
                LiveRoomInfo.a().a(viewHolder.b, bluedLiveRankListData.vbadge);
            }
            viewHolder.f11688a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (LiveRankGuestListItemAdapter.this.f11681c == null || LiveCloakingUtil.b(bluedLiveRankListData.privilege)) {
                        return;
                    }
                    if (LiveRankGuestListItemAdapter.this.f11681c instanceof DialogFragment) {
                        ((DialogFragment) LiveRankGuestListItemAdapter.this.f11681c).dismiss();
                    } else if (LiveRankGuestListItemAdapter.this.f11681c.getParentFragment() != null && (LiveRankGuestListItemAdapter.this.f11681c.getParentFragment() instanceof DialogFragment)) {
                        ((DialogFragment) LiveRankGuestListItemAdapter.this.f11681c.getParentFragment()).dismiss();
                    }
                    LiveSetDataObserver.a().e(bluedLiveRankListData.uid);
                }
            });
            viewHolder.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    if (LiveRankGuestListItemAdapter.this.f11681c == null || LiveCloakingUtil.b(bluedLiveRankListData.privilege)) {
                        return;
                    }
                    if (LiveRankGuestListItemAdapter.this.f11681c instanceof DialogFragment) {
                        ((DialogFragment) LiveRankGuestListItemAdapter.this.f11681c).dismiss();
                    } else if (LiveRankGuestListItemAdapter.this.f11681c.getParentFragment() != null && (LiveRankGuestListItemAdapter.this.f11681c.getParentFragment() instanceof DialogFragment)) {
                        ((DialogFragment) LiveRankGuestListItemAdapter.this.f11681c.getParentFragment()).dismiss();
                    }
                    LiveSetDataObserver.a().e(bluedLiveRankListData.uid);
                }
            });
            viewHolder.d.setText(LiveCloakingUtil.a(bluedLiveRankListData.name, bluedLiveRankListData.privilege));
            viewHolder.f.setVisibility(8);
            if (TextUtils.isEmpty(this.h)) {
                if (this.l) {
                    viewHolder.i.setText(this.b.getString(R.string.live_rank_consumption_short));
                } else {
                    viewHolder.i.setText(this.b.getString(R.string.live_rank_month_consumption_short));
                }
                int i2 = bluedLiveRankListData.beans;
                if (this.m) {
                    TextView textView2 = viewHolder.f;
                    textView2.setText("(弯豆" + CommonStringUtils.a(bluedLiveRankListData.beans - bluedLiveRankListData.like) + "，点赞" + CommonStringUtils.a(bluedLiveRankListData.like) + ")");
                    viewHolder.f.setVisibility(0);
                }
                viewHolder.e.setText(CommonStringUtils.d(String.valueOf(i2)));
            } else {
                viewHolder.i.setText(this.h);
                viewHolder.e.setText(String.valueOf(CommonStringUtils.d(String.valueOf(bluedLiveRankListData.score))));
            }
            if (this.i) {
                viewHolder.j.setVisibility(0);
                LiveRoomInfo.a().a(this.b, bluedLiveRankListData.relationship, viewHolder.j, (ImageView) null, false);
                final ViewHolder viewHolder2 = viewHolder;
                viewHolder.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        if (LiveRoomInfo.a().b(bluedLiveRankListData.relationship)) {
                            return;
                        }
                        LiveRoomInfo.a().a(LiveRankGuestListItemAdapter.this.b, new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter.3.1
                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void Q_() {
                                DialogUtils.a(LiveRankGuestListItemAdapter.this.k);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void a(String str) {
                                bluedLiveRankListData.relationship = str;
                                LiveRoomInfo.a().a(LiveRankGuestListItemAdapter.this.b, str, viewHolder2.j, (ImageView) null, false);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void b(String str) {
                                bluedLiveRankListData.relationship = str;
                                LiveRoomInfo.a().a(LiveRankGuestListItemAdapter.this.b, str, viewHolder2.j, (ImageView) null, false);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void c() {
                                DialogUtils.b(LiveRankGuestListItemAdapter.this.k);
                            }

                            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
                            public void d() {
                                DialogUtils.b(LiveRankGuestListItemAdapter.this.k);
                            }
                        }, bluedLiveRankListData.uid, bluedLiveRankListData.relationship, "", LiveRankGuestListItemAdapter.this.j, true);
                    }
                });
            } else {
                viewHolder.j.setVisibility(8);
            }
            if (bluedLiveRankListData.behalf_order_record != null && bluedLiveRankListData.behalf_order_record.size() > 0) {
                viewHolder.k.setVisibility(0);
                viewHolder.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveRankGuestListItemAdapter.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        Tracker.onClick(view3);
                        LiveRankBehalfRecordListDialogFragment liveRankBehalfRecordListDialogFragment = new LiveRankBehalfRecordListDialogFragment();
                        liveRankBehalfRecordListDialogFragment.a(bluedLiveRankListData.behalf_order_record);
                        liveRankBehalfRecordListDialogFragment.show(LiveRankGuestListItemAdapter.this.f11681c.getChildFragmentManager(), "LiveRankBehalfRecordListDialogFragment");
                    }
                });
                return view2;
            }
            viewHolder.k.setVisibility(8);
        }
        return view2;
    }
}
