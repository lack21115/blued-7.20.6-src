package com.soft.blued.ui.find.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.view.FollowStatusView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.SecretlyFollowedExtra;
import com.soft.blued.ui.user.observer.SecretlyFollowedObserver;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendListAdapter.class */
public class RecommendListAdapter<T extends UserBasicModel> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected List<T> f16426a = new ArrayList();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f16427c;
    private int d;
    private Dialog e;
    private LoadOptions f;
    private int g;
    private boolean h;
    private SecretlyFollowedExtra i;
    private IRequestHost j;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendListAdapter$PAGE_NAME.class */
    public interface PAGE_NAME {
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/RecommendListAdapter$ViewHolder.class */
    public class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16434a;
        public TextView b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16435c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public FollowStatusView h;
        public ImageView i;
        public ImageView j;
        public View k;
        public LinearLayout l;
        public LinearLayout m;
        public ShapeTextView n;
        public ImageView o;
        public View p;

        protected ViewHolder() {
        }
    }

    public RecommendListAdapter(Context context, int i, IRequestHost iRequestHost) {
        this.g = -1;
        this.j = iRequestHost;
        this.b = context;
        this.g = i;
        this.f16427c = LayoutInflater.from(context);
        this.d = context.getResources().getDisplayMetrics().widthPixels;
        this.e = DialogUtils.a(context);
    }

    public RecommendListAdapter(Context context, int i, boolean z, IRequestHost iRequestHost) {
        this.g = -1;
        this.j = iRequestHost;
        this.b = context;
        this.g = i;
        this.h = z;
        this.f16427c = LayoutInflater.from(context);
        this.d = context.getResources().getDisplayMetrics().widthPixels;
        this.e = DialogUtils.a(context);
        LoadOptions loadOptions = new LoadOptions();
        this.f = loadOptions;
        loadOptions.d = 2131237310;
        this.f.b = 2131237310;
        LoadOptions loadOptions2 = this.f;
        int i2 = this.d;
        loadOptions2.a(i2 >> 1, i2 >> 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final T t) {
        UserHttpUtils.b(this.b, new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.find.adapter.RecommendListAdapter.3
            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a() {
                DialogUtils.a(RecommendListAdapter.this.e);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String str) {
                UserInfo.getInstance().getLoginUserInfo().setAttentionCount(1);
                t.relationship = str;
                LiveEventBus.get("feed_relation_ship").post(t);
                RecommendListAdapter.this.notifyDataSetChanged();
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b() {
                DialogUtils.b(RecommendListAdapter.this.e);
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String str) {
            }

            @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
                DialogUtils.b(RecommendListAdapter.this.e);
            }
        }, ((UserBasicModel) t).uid, "", this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final T t) {
        Context context = this.b;
        CommonAlertDialog.a(context, (String) null, context.getResources().getString(2131886888), this.b.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.RecommendListAdapter.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                UserHttpUtils.a(RecommendListAdapter.this.b, new UserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.soft.blued.ui.find.adapter.RecommendListAdapter.4.1
                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void a() {
                        DialogUtils.a(RecommendListAdapter.this.e);
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void a(String str) {
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void b() {
                        DialogUtils.b(RecommendListAdapter.this.e);
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void b(String str) {
                        UserInfo.getInstance().getLoginUserInfo().setAttentionCount(-1);
                        t.relationship = str;
                        LiveEventBus.get("feed_relation_ship").post(t);
                        if (RecommendListAdapter.this.g != 1 && RecommendListAdapter.this.g != 4) {
                            RecommendListAdapter.this.f16426a.remove(t);
                        }
                        if (RecommendListAdapter.this.i != null) {
                            SecretlyFollowedObserver a2 = SecretlyFollowedObserver.a();
                            SecretlyFollowedExtra secretlyFollowedExtra = RecommendListAdapter.this.i;
                            int i2 = secretlyFollowedExtra.secretly_count - 1;
                            secretlyFollowedExtra.secretly_count = i2;
                            a2.a(i2, RecommendListAdapter.this.i.secretly_followed_limit);
                        }
                        RecommendListAdapter.this.notifyDataSetChanged();
                    }

                    @Override // com.soft.blued.utils.UserRelationshipUtils.IAddOrRemoveAttentionDone
                    public void c() {
                        DialogUtils.b(RecommendListAdapter.this.e);
                    }
                }, t.uid, "", RecommendListAdapter.this.j);
            }
        }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void a(SecretlyFollowedExtra secretlyFollowedExtra) {
        this.i = secretlyFollowedExtra;
    }

    public void a(List<T> list) {
        this.f16426a.clear();
        if (list != null && list.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (BlueAppLocal.d()) {
                    ((UserBasicModel) list.get(i2)).height = StringUtils.a(((UserBasicModel) list.get(i2)).height, BlueAppLocal.c(), false);
                    ((UserBasicModel) list.get(i2)).weight = StringUtils.b(((UserBasicModel) list.get(i2)).weight, BlueAppLocal.c(), false);
                } else {
                    ((UserBasicModel) list.get(i2)).height = StringUtils.a(((UserBasicModel) list.get(i2)).height, BlueAppLocal.c(), true);
                    ((UserBasicModel) list.get(i2)).weight = StringUtils.b(((UserBasicModel) list.get(i2)).weight, BlueAppLocal.c(), true);
                }
                i = i2 + 1;
            }
            this.f16426a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void b(List<T> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                this.f16426a.addAll(list);
                notifyDataSetChanged();
                return;
            }
            if (BlueAppLocal.d()) {
                ((UserBasicModel) list.get(i2)).height = StringUtils.a(((UserBasicModel) list.get(i2)).height, BlueAppLocal.c(), false);
                ((UserBasicModel) list.get(i2)).weight = StringUtils.b(((UserBasicModel) list.get(i2)).weight, BlueAppLocal.c(), false);
            } else {
                ((UserBasicModel) list.get(i2)).height = StringUtils.a(((UserBasicModel) list.get(i2)).height, BlueAppLocal.c(), true);
                ((UserBasicModel) list.get(i2)).weight = StringUtils.b(((UserBasicModel) list.get(i2)).weight, BlueAppLocal.c(), true);
            }
            i = i2 + 1;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f16426a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
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
            view2 = this.f16427c.inflate(R.layout.fragment_recommend_list_item, viewGroup, false);
            viewHolder.f16434a = (ImageView) view2.findViewById(2131364232);
            viewHolder.g = (TextView) view2.findViewById(R.id.role_view);
            viewHolder.f16435c = (TextView) view2.findViewById(R.id.name_view);
            viewHolder.b = (TextView) view2.findViewById(R.id.location_view);
            viewHolder.d = (TextView) view2.findViewById(R.id.age_view);
            viewHolder.e = (TextView) view2.findViewById(R.id.height_view);
            viewHolder.f = (TextView) view2.findViewById(R.id.weight_view);
            viewHolder.h = view2.findViewById(R.id.follow_status_view);
            viewHolder.i = (ImageView) view2.findViewById(R.id.img_verify);
            viewHolder.j = (ImageView) view2.findViewById(R.id.img_blued_medal);
            viewHolder.k = view2.findViewById(R.id.tv_online);
            viewHolder.l = (LinearLayout) view2.findViewById(R.id.ll_personal_info);
            viewHolder.m = (LinearLayout) view2.findViewById(R.id.ll_distance);
            viewHolder.n = view2.findViewById(R.id.tv_identity);
            viewHolder.o = (ImageView) view2.findViewById(R.id.cb_member_remove);
            viewHolder.p = view2.findViewById(R.id.item_line);
            view2.setTag(viewHolder);
        } else {
            view2 = view;
            viewHolder = (ViewHolder) view.getTag();
        }
        final T t = this.f16426a.get(i);
        if (this.g == 3) {
            ((UserBasicModel) t).relationship = "1";
        }
        UserInfoHelper.a(viewHolder.i, ((UserBasicModel) t).vbadge, 3);
        ImageLoader.a(this.j, AvatarUtils.a(0, ((UserBasicModel) t).avatar)).c().b(2131237310).a(viewHolder.f16434a);
        UserRelationshipUtils.a(viewHolder.j, t);
        if (((UserBasicModel) t).is_official != 1) {
            UserInfoHelper.a(this.b, viewHolder.g, ((UserBasicModel) t).role);
        }
        if (!TextUtils.isEmpty(((UserBasicModel) t).note)) {
            viewHolder.f16435c.setText(((UserBasicModel) t).note);
        } else if (TextUtils.isEmpty(((UserBasicModel) t).name)) {
            viewHolder.f16435c.setText("");
        } else {
            viewHolder.f16435c.setText(((UserBasicModel) t).name);
        }
        UserRelationshipUtils.a(this.b, viewHolder.f16435c, t);
        if (((UserBasicModel) t).online_state == 1) {
            viewHolder.k.setVisibility(0);
        } else {
            viewHolder.k.setVisibility(8);
        }
        if (UserInfoHelper.c(((UserBasicModel) t).vbadge)) {
            viewHolder.l.setVisibility(8);
        } else {
            viewHolder.l.setVisibility(0);
            if (TextUtils.isEmpty(((UserBasicModel) t).age)) {
                viewHolder.d.setText("");
            } else {
                TextView textView = viewHolder.d;
                textView.setText(((UserBasicModel) t).age + this.b.getResources().getString(2131886374));
            }
            if (TextUtils.isEmpty(((UserBasicModel) t).height)) {
                viewHolder.e.setText("");
            } else {
                viewHolder.e.setText(((UserBasicModel) t).height);
            }
            if (TextUtils.isEmpty(((UserBasicModel) t).weight)) {
                viewHolder.f.setText("");
            } else {
                viewHolder.f.setText(((UserBasicModel) t).weight);
            }
        }
        if (((UserBasicModel) t).vbadge == 3) {
            viewHolder.m.setVisibility(8);
        } else {
            viewHolder.m.setVisibility(0);
        }
        if (TextUtils.isEmpty(((UserBasicModel) t).location) || ((UserBasicModel) t).vbadge == 3) {
            viewHolder.b.setText("");
        } else {
            viewHolder.b.setText(((UserBasicModel) t).location);
        }
        if (((UserBasicModel) t).uid == null || !((UserBasicModel) t).uid.equals(UserInfo.getInstance().getLoginUserInfo().getUid())) {
            viewHolder.h.setVisibility(0);
        } else {
            viewHolder.h.setVisibility(8);
        }
        viewHolder.h.setRelationShip(((UserBasicModel) t).relationship);
        viewHolder.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.RecommendListAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                boolean z;
                FeedProtos.FollowLocation followLocation;
                Tracker.onClick(view3);
                if (TextUtils.isEmpty(t.relationship) || !(t.relationship.equals("1") || t.relationship.equals("3"))) {
                    RecommendListAdapter.this.a((RecommendListAdapter) t);
                    z = true;
                } else {
                    RecommendListAdapter.this.b((RecommendListAdapter) t);
                    z = false;
                }
                if (RecommendListAdapter.this.g == 1) {
                    followLocation = RecommendListAdapter.this.h ? FeedProtos.FollowLocation.FOLLOW_MINE : FeedProtos.FollowLocation.FOLLOW_PROFILE_FANS_LIST;
                } else {
                    followLocation = null;
                    if (RecommendListAdapter.this.g == 2) {
                        followLocation = null;
                        if (!RecommendListAdapter.this.h) {
                            followLocation = FeedProtos.FollowLocation.FOLLOW_PROFILE_FOLLOW_LIST;
                        }
                    }
                }
                EventTrackFeed.a(FeedProtos.Event.OTHER_FOLLOW_CLICK, t.uid, "", "", followLocation, z, false);
            }
        });
        final ImageView imageView = viewHolder.f16434a;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.RecommendListAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                MessageProtos.StrangerSource strangerSource;
                String str;
                Tracker.onClick(view3);
                int i2 = RecommendListAdapter.this.g;
                if (i2 == 1) {
                    strangerSource = MessageProtos.StrangerSource.MINE_FAN;
                    str = "my_fans";
                } else if (i2 == 2) {
                    strangerSource = MessageProtos.StrangerSource.MINE_FOLLOW;
                    str = "my_followed";
                } else if (i2 != 3) {
                    strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                    str = "";
                } else {
                    strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
                    str = "my_secret_follow";
                }
                UserInfoFragmentNew.a(RecommendListAdapter.this.b, t, str, imageView, (LogData) null, new MsgSourceEntity(strangerSource, ""));
            }
        });
        return view2;
    }
}
