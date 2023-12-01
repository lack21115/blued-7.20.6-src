package com.soft.blued.ui.find.adapter;

import android.app.Activity;
import android.app.backup.FullBackup;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.view.LiveAutoPlayView;
import com.blued.android.module.live_china.view.LiveListAutoPlay;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.adapter.PeopleListQuickAdapter;
import com.soft.blued.ui.find.manager.MapFindManager;
import com.soft.blued.ui.find.manager.SpannedGridLayoutManager;
import com.soft.blued.ui.find.model.UserFindExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.live.utils.LiveUtils;
import com.soft.blued.ui.mine.model.MineEntryInfo;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleGridQuickAdapter.class */
public class PeopleGridQuickAdapter extends BaseMultiItemQuickAdapter<UserFindResult, BaseViewHolder> implements LiveListAutoPlay {
    private int A;

    /* renamed from: a  reason: collision with root package name */
    public Context f30084a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public int f30085c;
    public int d;
    public String e;
    public String f;
    public LoadOptions g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public int m;
    public List<Map<String, String>> n;
    protected IRequestHost o;
    public RecyclerView p;
    public MessageProtos.SortType q;
    public boolean r;
    protected int s;
    protected OnDrawPeopleListener t;
    public PeopleListQuickAdapter.OnShowRegisterUserGuideDialogListener u;
    private int v;
    private HashSet<String> w;
    private String x;
    private LiveAutoPlayView y;
    private boolean z;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleGridQuickAdapter$OnDrawPeopleListener.class */
    public interface OnDrawPeopleListener {
        void a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/adapter/PeopleGridQuickAdapter$OnShowRegisterUserGuideDialogListener.class */
    public interface OnShowRegisterUserGuideDialogListener {
    }

    public PeopleGridQuickAdapter(List<UserFindResult> list, Activity activity, final IRequestHost iRequestHost, String str, RecyclerView recyclerView) {
        super(list);
        this.e = "";
        this.f = "";
        this.h = true;
        this.l = false;
        this.m = 0;
        this.w = new HashSet<>();
        this.x = "";
        this.n = new ArrayList();
        this.q = MessageProtos.SortType.UNKNOWN_SORT_TYPE;
        this.z = false;
        this.r = true;
        this.s = 0;
        this.f30084a = activity;
        this.b = str;
        this.p = recyclerView;
        recyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.1
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
                ImageLoader.a(iRequestHost, (ImageView) baseViewHolder.getView(2131364588));
                ImageLoader.a(iRequestHost, (ImageView) baseViewHolder.getView(R.id.img_chat));
            }
        });
        this.i = DensityUtils.a(this.f30084a, 6.0f);
        this.j = DensityUtils.a(this.f30084a, 9.0f);
        this.k = this.f30084a.getResources().getDisplayMetrics().widthPixels;
        this.d = a(this.f30084a);
        a();
        this.v = (this.f30085c - DensityUtils.a(this.f30084a, 15.0f)) - DensityUtils.a(this.f30084a, 18.0f);
        this.o = iRequestHost;
        LoadOptions loadOptions = new LoadOptions();
        this.g = loadOptions;
        loadOptions.l = false;
        this.g.d = 2131237314;
        this.g.b = 2131237314;
        LoadOptions loadOptions2 = this.g;
        int i = this.k;
        loadOptions2.a(i >> 1, i >> 1);
        d();
    }

    public PeopleGridQuickAdapter(List<UserFindResult> list, Activity activity, IRequestHost iRequestHost, String str, RecyclerView recyclerView, int i) {
        this(list, activity, iRequestHost, str, recyclerView);
        this.A = i;
    }

    public static int a(Context context) {
        return 3;
    }

    private void a(List<UserFindResult> list) {
        if (list != null) {
            Iterator<UserFindResult> it = list.iterator();
            while (it.hasNext()) {
                UserFindResult next = it.next();
                if (c(next)) {
                    it.remove();
                } else {
                    this.w.add(next.uid);
                }
            }
        }
    }

    public static boolean a(UserFindResult userFindResult) {
        return (userFindResult.itemType == 19 || userFindResult.itemType == 20) && userFindResult.size == 1;
    }

    public static boolean b(UserFindResult userFindResult) {
        return (userFindResult.itemType == 19 || userFindResult.itemType == 20 || userFindResult.itemType == 26) && userFindResult.size == 1;
    }

    private boolean c(UserFindResult userFindResult) {
        if (userFindResult == null) {
            return true;
        }
        if (userFindResult.itemType == 22) {
            HashSet<String> hashSet = this.w;
            return hashSet.contains(userFindResult.operate_promotion.ads_id + "");
        }
        return this.w.contains(userFindResult.uid);
    }

    private boolean d(UserFindResult userFindResult) {
        return (!this.z || userFindResult.live_info == null || TextUtils.isEmpty(userFindResult.live_info.live_stream_url)) ? false : true;
    }

    private void f(final BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(2131363859);
        SpannedGridLayoutManager.LayoutParams layoutParams = (SpannedGridLayoutManager.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.width = (this.f30085c * 2) + (this.i * 2);
        layoutParams.height = (this.f30085c * 2) + this.i + this.j;
        layoutParams.rightMargin = this.i;
        layoutParams.bottomMargin = this.j;
        frameLayout.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_operate_title);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_operate_tag);
        TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_operate_content);
        if (!userFindResult.isShowOperateVisited) {
            FindHttpUtils.b(userFindResult.show_url);
            userFindResult.isShowOperateVisited = true;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                FindHttpUtils.b(userFindResult.click_url);
                WebViewShowInfoFragment.show(PeopleGridQuickAdapter.this.f30084a, userFindResult.operate_promotion.deep_link_url, -1);
                if (UserFindResult.USER_SORT_BY.ONLINE.equals(PeopleGridQuickAdapter.this.b)) {
                    PeopleGridQuickAdapter.this.a(GuyProtos.Event.NEARBY_OPERATION_CLICK, userFindResult, GuyProtos.ShowType.PALACE_SHOW, (baseViewHolder.getLayoutPosition() / 3) + 1, false);
                } else {
                    PeopleGridQuickAdapter.this.a(GuyProtos.Event.NEARBY_DISTANCE_OPERATION_CLICK, userFindResult, GuyProtos.ShowType.PALACE_SHOW, (baseViewHolder.getLayoutPosition() / 3) + 1, false);
                }
            }
        });
        if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
            a(GuyProtos.Event.NEARBY_OPERATION_SHOW, userFindResult, GuyProtos.ShowType.PALACE_SHOW, (baseViewHolder.getLayoutPosition() / 3) + 1, false);
        } else {
            a(GuyProtos.Event.NEARBY_DISTANCE_OPERATION_SHOW, userFindResult, GuyProtos.ShowType.PALACE_SHOW, (baseViewHolder.getLayoutPosition() / 3) + 1, false);
        }
        ImageLoader.a(this.o, userFindResult.operate_promotion.master_image).b(2131237314).a(imageView);
        textView.setText(userFindResult.operate_promotion.show_title);
        if (TextUtils.isEmpty(userFindResult.operate_promotion.content)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(userFindResult.operate_promotion.content);
        }
        if (TextUtils.isEmpty(userFindResult.operate_promotion.tag)) {
            textView2.setVisibility(8);
            return;
        }
        textView2.setVisibility(0);
        textView2.setText(userFindResult.operate_promotion.tag);
    }

    private void i() {
        Collection<UserFindResult> data = getData();
        if (data != null) {
            int i = 0;
            for (UserFindResult userFindResult : data) {
                if (userFindResult != null && userFindResult.getItemType() == 10) {
                    userFindResult.userPositionReal = i;
                    i++;
                }
            }
        }
    }

    private void j() {
        LiveAutoPlayView liveAutoPlayView = this.y;
        if (liveAutoPlayView == null || !this.r) {
            return;
        }
        liveAutoPlayView.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        this.f30085c = ((this.k - (this.i * this.d)) - DensityUtils.a(this.f30084a, 18.0f)) / this.d;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void addData(int i, UserFindResult userFindResult) {
        if (c(userFindResult) || i < 0) {
            return;
        }
        super.addData(i, (int) userFindResult);
        i();
        if (userFindResult.itemType != 22) {
            this.w.add(userFindResult.uid);
            return;
        }
        HashSet<String> hashSet = this.w;
        hashSet.add(userFindResult.operate_promotion.ads_id + "");
    }

    protected void a(View view, UserFindResult userFindResult) {
        String str = UserFindResult.USER_SORT_BY.NEARBY.equals(this.b) ? "home_distance" : UserFindResult.USER_SORT_BY.ONLINE.equals(this.b) ? "home_online" : "";
        boolean z = true;
        if (userFindResult.live_info != null) {
            UserRelationshipUtils.b(this.f30084a, userFindResult, userFindResult.live_info.lid, this.b, str, userFindResult.recommend_type, userFindResult.userPositionReal + 1, getData());
        } else if (userFindResult.is_have_chatroom > 0 && userFindResult.chatroom != null && !TextUtils.isEmpty(userFindResult.chatroom.room_id)) {
            if (!UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(this.b)) {
                YYRoomInfoManager.e().a((BaseFragmentActivity) this.f30084a, userFindResult.chatroom.room_id, "home_distance_yy_icon");
            } else if (userFindResult.is_insert_chatroom == 1) {
                YYRoomInfoManager.e().a((BaseFragmentActivity) this.f30084a, userFindResult.chatroom.room_id, "home_online_yy_room");
            } else {
                YYRoomInfoManager.e().a((BaseFragmentActivity) this.f30084a, userFindResult.chatroom.room_id, "home_online_yy_icon");
            }
        } else if (!TextUtils.isEmpty(userFindResult.redirect_url)) {
            LiveUtils.a(str, userFindResult.recommend_type, userFindResult.userPositionReal + 1);
            WebViewShowInfoFragment.a(this.f30084a, userFindResult.redirect_url, "", false, 9);
        } else if (userFindResult.is_invisible_half == 1 && ((UserInfo.getInstance().getLoginUserInfo().vip_grade != 2 && UserInfo.getInstance().getLoginUserInfo().vip_grade != 1) || BluedConfig.a().g().is_invisible_half == 0)) {
            PayUtils.a(this.f30084a, 3, "user_half_invisible");
        } else {
            if (userFindResult.live_info == null) {
                z = false;
            }
            a(userFindResult, view, z, 0);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.p = recyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(GuyProtos.Event event, UserFindResult userFindResult, GuyProtos.ShowType showType, int i, boolean z) {
        String str;
        String str2 = z ? userFindResult.live_info != null ? "live" : userFindResult.chatroom != null ? "yy" : "recommend" : "operation";
        if (z) {
            str = userFindResult.uid;
        } else {
            str = userFindResult.operate_promotion.ads_id + "";
        }
        EventTrackGuy.a(event, str2, str, showType, i);
    }

    public void a(MessageProtos.SortType sortType) {
        this.q = sortType;
    }

    public void a(BaseViewHolder baseViewHolder) {
        AppUtils.a(baseViewHolder.getView(2131363859), baseViewHolder.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        if (baseViewHolder != null) {
            a(baseViewHolder);
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 11) {
                d(baseViewHolder, userFindResult);
            } else if (itemViewType == 17) {
                e(baseViewHolder, userFindResult);
            } else if (itemViewType != 22) {
                b(baseViewHolder, userFindResult);
            } else {
                f(baseViewHolder, userFindResult);
            }
        }
    }

    public void a(OnDrawPeopleListener onDrawPeopleListener) {
        this.t = onDrawPeopleListener;
    }

    public void a(PeopleListQuickAdapter.OnShowRegisterUserGuideDialogListener onShowRegisterUserGuideDialogListener) {
        this.u = onShowRegisterUserGuideDialogListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(UserFindResult userFindResult, View view, boolean z, int i) {
        MessageProtos.StrangerSource strangerSource;
        if (this.h) {
            this.h = false;
            LogData logData = new LogData();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            String str = "";
            sb.append("");
            logData.type = sb.toString();
            logData.is_hello = userFindResult.is_call + "";
            logData.nearby_sortby = this.b;
            logData.distance = StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr;
            logData.online_time = StringUtils.d(userFindResult.last_operate_str) ? userFindResult.last_operate : userFindResult.last_operate_str;
            logData.vip_selected_reason = userFindResult.additional_tag_type;
            logData.vip_selected_tag = userFindResult.selected_tag;
            logData.isShadow = userFindResult.is_shadow == 1;
            boolean z2 = false;
            if (userFindResult.is_quietly == 1) {
                z2 = true;
            }
            logData.isQuietHello = z2;
            logData.is_call = userFindResult.is_call + "";
            logData.is_special = a(userFindResult) ? "1" : "0";
            logData.show_type = "PALACE_SHOW";
            if (UserFindResult.USER_SORT_BY.NEARBY.equals(this.b)) {
                strangerSource = MessageProtos.StrangerSource.DISTANCE_SORT;
            } else if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
                strangerSource = MessageProtos.StrangerSource.ONLINE_TIME_SORT;
            } else if (UserFindResult.USER_SORT_BY.NEWBEE.equals(this.b)) {
                strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_NEW_FACE;
            } else if ("tag_user".equals(this.b)) {
                strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_PERSONAL_NEARBY;
                str = this.x;
            } else {
                strangerSource = MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE;
            }
            if (MapFindManager.a().b()) {
                strangerSource = MessageProtos.StrangerSource.MAP_FIND;
            }
            MessageProtos.StrangerSource strangerSource2 = strangerSource;
            if (userFindResult.is_shadow == 1) {
                strangerSource2 = MessageProtos.StrangerSource.SHADOW_SOURCE;
            }
            MessageProtos.StrangerSource strangerSource3 = strangerSource2;
            if (userFindResult.is_call == 1) {
                if (UserFindResult.USER_SORT_BY.INTEGRATE.equalsIgnoreCase(this.b)) {
                    strangerSource3 = MessageProtos.StrangerSource.APPRECIATE_CALL_COMPLEX;
                } else {
                    strangerSource3 = strangerSource2;
                    if (UserFindResult.USER_SORT_BY.ONLINE.equalsIgnoreCase(this.b)) {
                        strangerSource3 = MessageProtos.StrangerSource.APPRECIATE_CALL_ONLINE;
                    }
                }
            }
            if (userFindResult.is_eco_user == 1) {
                UserInfoFragmentNew.a(this.f30084a, userFindResult.uid);
            } else {
                UserInfoFragmentNew.a(this.f30084a, userFindResult, a(userFindResult) ? "nearby_operation" : this.b, z, view, logData, new MsgSourceEntity(strangerSource3, str));
            }
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.6
                @Override // java.lang.Runnable
                public void run() {
                    PeopleGridQuickAdapter.this.h = true;
                }
            }, 300L);
        }
    }

    public void a(String str) {
        this.x = str;
    }

    public void a(boolean z) {
        this.z = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i > BluedPreferences.eY() && BluedPreferences.eZ();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends UserFindResult> collection) {
        ArrayList arrayList = new ArrayList(collection);
        a(arrayList);
        super.addData((Collection) arrayList);
        i();
        setEnableLoadMore(true);
        notifyDataSetChanged();
    }

    public String b() {
        return this.x;
    }

    public void b(int i) {
        this.s = i;
    }

    public void b(int i, UserFindResult userFindResult) {
        String str;
        String str2;
        if (userFindResult.isShowUrlVisited) {
            return;
        }
        userFindResult.isShowUrlVisited = true;
        int headerLayoutCount = i - getHeaderLayoutCount();
        if (userFindResult.live_info != null || !TextUtils.isEmpty(userFindResult.redirect_url)) {
            boolean b = b(userFindResult);
            if (TextUtils.equals(this.b, UserFindResult.USER_SORT_BY.ONLINE)) {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_SHOW, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, headerLayoutCount + 1, GuyProtos.SortType.ONLINE_TIME_SORT, b);
            } else {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_SHOW, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, headerLayoutCount + 1, GuyProtos.SortType.DISTANCE_SORT, b);
            }
        }
        if (userFindResult.is_have_chatroom > 0 && userFindResult.chatroom != null) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_SHOW, userFindResult.uid, userFindResult.chatroom.room_id, userFindResult.chatroom.uid);
        }
        if (!StringUtils.d(userFindResult.uid)) {
            this.e += "-" + userFindResult.uid;
            if (userFindResult.is_call == 1) {
                this.f += "-" + userFindResult.uid;
            }
            if (e()) {
                if (InstantLog.b(this.e)) {
                    this.e = "";
                }
            } else if (InstantLog.a(this.b, this.e, this.f, 0)) {
                this.e = "";
                this.f = "";
            }
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("u", userFindResult.uid);
        a2.put("d", userFindResult.is_hide_distance == 1 ? "-1" : StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr);
        a2.put("t", userFindResult.is_hide_last_operate == 1 ? "-1" : userFindResult.last_operate_time_stamp);
        a2.put(MineEntryInfo.ColumnsExtra.TYPE_SHADOW, userFindResult.is_shadow == 1 ? "1" : "0");
        a2.put("call", userFindResult.is_call == 1 ? "1" : "0");
        a2.put("live", userFindResult.live_info != null ? "1" : "0");
        a2.put("lt", userFindResult.lt);
        a2.put("cq", userFindResult.is_quietly == 1 ? "1" : "0");
        a2.put("auto", d(userFindResult) ? "1" : "0");
        a2.put("rt", userFindResult.recommend_type);
        a2.put("n", headerLayoutCount + "");
        a2.put(FullBackup.SHAREDPREFS_TREE_TOKEN, a(userFindResult) ? "1" : "0");
        a2.put("like", userFindResult.is_recommend + "");
        a2.put("virtual", userFindResult.users_face == 1 ? "1" : "0");
        a2.put("yy", userFindResult.is_have_chatroom == 1 ? "1" : "0");
        if (userFindResult.is_have_chatroom == 1) {
            a2.put("yy_type", userFindResult.is_insert_chatroom == 1 ? "2" : "1");
        }
        a2.put("super", userFindResult.is_super_privilege_user == 1 ? "1" : "0");
        a2.put("bubble", userFindResult.bubble != null ? "1" : "0");
        if (userFindResult.live_info != null) {
            str = userFindResult.live_info.lid + "";
        } else {
            str = userFindResult.chatroom != null ? userFindResult.chatroom.room_id : "";
        }
        if (!TextUtils.isEmpty(str)) {
            a2.put("id", str);
        }
        this.n.add(a2);
        if (headerLayoutCount >= 50 && headerLayoutCount < 55 && BluedConfig.a().b().is_register_expierment_open == 1 && UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && this.u != null && BluedPreferences.eJ()) {
            this.u.a();
            BluedPreferences.eK();
        }
        if (headerLayoutCount == 50) {
            ChatHttpUtils.a();
        }
        if (this.n.size() == 15) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_PHOTO_DRAW, AppInfo.f().toJson(this.n), EventTrackGuy.c(this.b), GuyProtos.ShowType.PALACE_SHOW, MapFindManager.a().b());
            this.n.clear();
        }
        if (UserFindResult.USER_SORT_BY.NEARBY.equals(this.b)) {
            str2 = "DISTANCE_SORT";
        } else {
            str2 = "";
            if (UserFindResult.USER_SORT_BY.ONLINE.equals(this.b)) {
                str2 = "ONLINE_TIME_SORT";
            }
        }
        GuyEventUtils.a(str2, userFindResult.uid, "PALACE_SHOW", userFindResult.is_call == 1, a(userFindResult), userFindResult.is_have_chatroom == 1, userFindResult.live_info != null);
        OnDrawPeopleListener onDrawPeopleListener = this.t;
        if (onDrawPeopleListener != null) {
            onDrawPeopleListener.a();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0777, code lost:
        if (r0.equals(com.soft.blued.ui.find.model.UserFindResult.USER_SORT_BY.NEARBY) != false) goto L93;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(final com.chad.library.adapter.base.BaseViewHolder r11, final com.soft.blued.ui.find.model.UserFindResult r12) {
        /*
            Method dump skipped, instructions count: 2179
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.b(com.chad.library.adapter.base.BaseViewHolder, com.soft.blued.ui.find.model.UserFindResult):void");
    }

    public void b(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    protected void c(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        String str;
        int adapterPosition = baseViewHolder.getAdapterPosition();
        int headerLayoutCount = getHeaderLayoutCount();
        LogData logData = new LogData();
        logData.logService = "click_position";
        logData.position = (baseViewHolder.getAdapterPosition() / this.d) + "";
        logData.from = this.b;
        logData.uid = userFindResult.uid;
        logData.is_hello = userFindResult.is_call + "";
        logData.type = "0";
        InstantLog.a(logData);
        if (!BluedPreferences.aa().equals("0-max")) {
            InstantLog.g("personal_page", "1");
        } else {
            InstantLog.g("personal_page", "0");
        }
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("u", userFindResult.uid);
        a2.put("d", userFindResult.is_hide_distance == 1 ? "-1" : StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr);
        a2.put("t", userFindResult.is_hide_last_operate == 1 ? "-1" : userFindResult.last_operate_time_stamp);
        a2.put("virtual", userFindResult.users_face == 1 ? "1" : "0");
        if (userFindResult.live_info != null) {
            str = userFindResult.live_info.lid + "";
        } else {
            str = userFindResult.chatroom != null ? userFindResult.chatroom.room_id : "";
        }
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_PHOTO_CLICK, AppInfo.f().toJson(a2), EventTrackGuy.c(this.b), GuyProtos.ShowType.PALACE_SHOW, MapFindManager.a().b(), userFindResult.is_shadow == 1, userFindResult.is_call == 1, userFindResult.live_info != null, userFindResult.lt, userFindResult.is_quietly == 1, d(userFindResult), userFindResult.is_reactive_recommend == 1, adapterPosition - headerLayoutCount, userFindResult.recommend_type, a(userFindResult), userFindResult.is_recommend, userFindResult.is_have_chatroom == 1, userFindResult.is_super_privilege_user == 1, str, userFindResult.bubble != null);
        GuyEventUtils.b(UserFindResult.USER_SORT_BY.NEARBY.equals(this.b) ? "DISTANCE_SORT" : UserFindResult.USER_SORT_BY.ONLINE.equals(this.b) ? "ONLINE_TIME_SORT" : "", userFindResult.uid, "PALACE_SHOW", userFindResult.is_call == 1, a(userFindResult), userFindResult.is_have_chatroom == 1, userFindResult.live_info != null);
        if (userFindResult.live_info != null) {
            int i = userFindResult instanceof UserFindExtra ? ((UserFindExtra) userFindResult).position + 1 : 0;
            boolean b = b(userFindResult);
            if (TextUtils.equals(this.b, UserFindResult.USER_SORT_BY.ONLINE)) {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_CLICK, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, i, GuyProtos.SortType.ONLINE_TIME_SORT, b);
            } else {
                EventTrackGuy.a(GuyProtos.Event.ONLINE_LIVE_USER_CLICK, String.valueOf(userFindResult.live_info.lid), userFindResult.uid + "", userFindResult.recommend_type, i, GuyProtos.SortType.DISTANCE_SORT, b);
            }
        }
        if (userFindResult.is_have_chatroom <= 0 || userFindResult.chatroom == null) {
            return;
        }
        EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_USER_CHATROOM_CLICK, userFindResult.uid, userFindResult.chatroom.room_id, userFindResult.chatroom.uid);
    }

    public void c(String str) {
        if (this.n.size() > 0) {
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_PHOTO_DRAW, AppInfo.f().toJson(this.n), EventTrackGuy.c(str), GuyProtos.ShowType.PALACE_SHOW, MapFindManager.a().b());
            this.n.clear();
        }
    }

    public void c(boolean z) {
        LiveAutoPlayView liveAutoPlayView = this.y;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.a(z);
        }
    }

    @Override // com.blued.android.module.live_china.view.LiveListAutoPlay
    public boolean c() {
        View findViewByPosition;
        this.y = null;
        RecyclerView.LayoutManager layoutManager = getRecyclerView().getLayoutManager();
        if (layoutManager instanceof SpannedGridLayoutManager) {
            SpannedGridLayoutManager spannedGridLayoutManager = (SpannedGridLayoutManager) layoutManager;
            int b = spannedGridLayoutManager.b() - getHeaderLayoutCount();
            int c2 = spannedGridLayoutManager.c() - getHeaderLayoutCount();
            if (this.mData != null && b >= 0 && b <= c2 && c2 < this.mData.size()) {
                while (true) {
                    if (b >= c2) {
                        break;
                    }
                    UserFindResult userFindResult = (UserFindResult) this.mData.get(b);
                    if (this.z && userFindResult != null && userFindResult.live_info != null && !TextUtils.isEmpty(userFindResult.live_info.live_stream_url) && (findViewByPosition = spannedGridLayoutManager.findViewByPosition(getHeaderLayoutCount() + b)) != null) {
                        LiveAutoPlayView liveAutoPlayView = (LiveAutoPlayView) findViewByPosition.findViewById(R.id.header_video_view);
                        this.y = liveAutoPlayView;
                        if (liveAutoPlayView != null) {
                            BluedLiveListData bluedLiveListData = new BluedLiveListData();
                            bluedLiveListData.lid = String.valueOf(userFindResult.live_info.lid);
                            bluedLiveListData.live_play = userFindResult.live_info.live_stream_url;
                            int i = userFindResult.play_view_width;
                            int i2 = userFindResult.play_view_height;
                            int i3 = i;
                            if (i == 0) {
                                i3 = this.f30085c;
                            }
                            if (i2 == 0) {
                                i2 = this.f30085c;
                            }
                            this.y.a(this, bluedLiveListData, "", i3, i2);
                            this.y.setVisibility(0);
                        }
                    }
                    b++;
                }
            } else {
                return false;
            }
        }
        LiveAutoPlayView liveAutoPlayView2 = this.y;
        if (liveAutoPlayView2 == null || !liveAutoPlayView2.e() || this.y.getHeight() == 0) {
            return false;
        }
        j();
        return true;
    }

    public void d() {
        addItemType(10, R.layout.friends_grid_single_item);
        addItemType(24, R.layout.friends_grid_single_item);
        addItemType(25, R.layout.friends_grid_single_item);
        addItemType(26, R.layout.friends_grid_single_item);
        addItemType(19, R.layout.friends_grid_single_item);
        addItemType(20, R.layout.friends_grid_single_item);
        addItemType(11, R.layout.item_people_ad_layout);
        addItemType(17, R.layout.item_people_visible_to_vip_layout);
        addItemType(22, R.layout.item_people_grid_operate_promotion);
    }

    public void d(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        Log.v("drb", "身边宫格加载banner广告");
        ((BannerADView) baseViewHolder.getView(R.id.banner_ad)).a(this.o, userFindResult, ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER, new BannerADView.ADListener() { // from class: com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.4
            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void a() {
                PeopleGridQuickAdapter.this.mData.remove(userFindResult);
                PeopleGridQuickAdapter.this.f();
            }

            @Override // com.soft.blued.customview.BannerADView.ADListener
            public void b() {
                PeopleGridQuickAdapter.this.mData.remove(userFindResult);
                PeopleGridQuickAdapter.this.f();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        ((ImageView) baseViewHolder.getView(R.id.iv_to_vip_unlock_more_user)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PayUtils.a(PeopleGridQuickAdapter.this.f30084a, UserInfo.getInstance().getLoginUserInfo().vip_grade, "nearb_unlock_user", 10001, VipProtos.FromType.UNKNOWN_FROM);
            }
        });
        if (baseViewHolder.getLayoutPosition() != BluedPreferences.eY()) {
            BluedPreferences.w(baseViewHolder.getLayoutPosition());
            f();
        }
    }

    protected boolean e() {
        return "msg_hello_detail".equals(this.b);
    }

    public void f() {
        RecyclerView recyclerView = this.p;
        if (recyclerView == null || !recyclerView.isComputingLayout()) {
            notifyDataSetChanged();
        } else {
            this.p.post(new Runnable() { // from class: com.soft.blued.ui.find.adapter.-$$Lambda$NJ4rwsxqkinPn894O2O8tO_p1yg
                @Override // java.lang.Runnable
                public final void run() {
                    PeopleGridQuickAdapter.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void g() {
        LiveAutoPlayView liveAutoPlayView = this.y;
        if (liveAutoPlayView != null) {
            liveAutoPlayView.c();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public RecyclerView getRecyclerView() {
        return this.p;
    }

    public void h() {
        if (c()) {
            return;
        }
        g();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<UserFindResult> list) {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        this.w.clear();
        a(arrayList);
        if (this.mData == null || this.mData.size() <= 0) {
            this.mData = new ArrayList();
            this.mData.addAll(arrayList);
        } else {
            this.mData.clear();
            this.mData.addAll(arrayList);
        }
        int i = 0;
        this.m = 0;
        for (UserFindResult userFindResult : arrayList) {
            if (userFindResult.getItemType() == 10 && userFindResult.live_info != null) {
                userFindResult.positionReal = i;
                i++;
            }
        }
        i();
        setEnableLoadMore(true);
        notifyDataSetChanged();
    }
}
