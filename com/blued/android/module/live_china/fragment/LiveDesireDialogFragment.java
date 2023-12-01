package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveDesireListAdapter;
import com.blued.android.module.live_china.fragment.LiveDesireAddDialogFragment;
import com.blued.android.module.live_china.fragment.LiveDesireDialogFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveDesireCreateDesireModel;
import com.blued.android.module.live_china.model.LiveDesireGiftInfo;
import com.blued.android.module.live_china.model.LiveDesireLiseExtra;
import com.blued.android.module.live_china.model.LiveDesireLiseModel;
import com.blued.android.module.live_china.model.LiveDesireVerifyStatusModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveWishItemModel;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.pop.LiveDesireResetPop;
import com.blued.android.module.live_china.pop.LiveOnekeyRankPop;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.BuyGiftUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireDialogFragment.class */
public class LiveDesireDialogFragment extends BaseDialogFragment {
    public Context a;
    public Observer<Boolean> b;
    public Observer<Boolean> c;
    public Observer<Boolean> d;
    public BuyGiftUtil e;
    private FormType f;
    private View g;
    private ImageView h;
    private ImageView i;
    private View j;
    private View k;
    private View l;
    private ImageView m;
    private View n;
    private RecyclerView o;
    private SmartRefreshLayout p;
    private LiveDesireListAdapter q;
    private List<LiveDesireLiseModel> r;
    private RelativeLayout t;
    private TextView u;
    private int s = 3;
    private boolean v = false;
    private long w = 0;
    private boolean x = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireDialogFragment$1.class */
    public class AnonymousClass1 implements LiveDesireListAdapter.LiveDesireListEventCallBack {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(DialogInterface dialogInterface) {
            LiveDesireDialogFragment.this.w = System.currentTimeMillis();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(LiveDesireLiseModel liveDesireLiseModel) {
            int i;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                i = 0;
                if (i3 >= LiveDesireDialogFragment.this.r.size()) {
                    break;
                } else if (((LiveDesireLiseModel) LiveDesireDialogFragment.this.r.get(i3)).type != 0) {
                    liveDesireLiseModel.id = System.currentTimeMillis();
                    i = i3;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            LiveDesireDialogFragment.this.r.add(i, liveDesireLiseModel);
            LiveDesireDialogFragment.this.q.notifyItemInserted(i);
            LiveDesireDialogFragment.this.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(boolean z, long j, DialogInterface dialogInterface, int i) {
            EventTrackLive.a(LiveProtos.Event.LIVE_WISH_SOMEONE_DELETE_NO_CLICK, LiveRoomManager.a().e(), z, z ? String.valueOf(j) : "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z, long j, DialogInterface dialogInterface, int i) {
            EventTrackLive.a(LiveProtos.Event.LIVE_WISH_SOMEONE_DELETE_YES_CLICK, LiveRoomManager.a().e(), z, z ? String.valueOf(j) : "");
            if (z) {
                LiveDesireDialogFragment.this.a(j);
            } else {
                LiveDesireDialogFragment.this.b(j);
            }
        }

        @Override // com.blued.android.module.live_china.adapter.LiveDesireListAdapter.LiveDesireListEventCallBack
        public void a() {
            int i;
            EventTrackLive.b(LiveProtos.Event.LIVE_WISH_ADD_CLICK, LiveRoomManager.a().e());
            int i2 = 0;
            int i3 = 0;
            while (true) {
                i = i3;
                if (i2 >= LiveDesireDialogFragment.this.r.size()) {
                    break;
                }
                int i4 = i;
                if (((LiveDesireLiseModel) LiveDesireDialogFragment.this.r.get(i2)).type == 0) {
                    i4 = i + 1;
                }
                i2++;
                i3 = i4;
            }
            if (i >= LiveDesireDialogFragment.this.s) {
                ToastUtils.b(R.string.live_desire_exceed_the_count_limit);
                return;
            }
            LiveDesireAddDialogFragment liveDesireAddDialogFragment = new LiveDesireAddDialogFragment(LiveDesireDialogFragment.this.a, new LiveDesireAddDialogFragment.AddDesireCallBack() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$1$BILd4yGWYDlfByOzBAm-76au5Uk
                @Override // com.blued.android.module.live_china.fragment.LiveDesireAddDialogFragment.AddDesireCallBack
                public final void addDesireSuccess(LiveDesireLiseModel liveDesireLiseModel) {
                    LiveDesireDialogFragment.AnonymousClass1.this.a(liveDesireLiseModel);
                }
            });
            liveDesireAddDialogFragment.a(new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$1$JD4RjJFLWPoR-t_VF7rUe-Uv6Xs
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LiveDesireDialogFragment.AnonymousClass1.this.a(dialogInterface);
                }
            });
            liveDesireAddDialogFragment.show(LiveDesireDialogFragment.this.getFragmentManager(), "addDesireDialog");
            LiveDesireDialogFragment.this.w = 0L;
        }

        @Override // com.blued.android.module.live_china.adapter.LiveDesireListAdapter.LiveDesireListEventCallBack
        public void a(String str, LiveDesireGiftInfo liveDesireGiftInfo, LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack) {
            LiveDesireDialogFragment.this.a(str, liveDesireGiftInfo, rankSccessCallBack);
        }

        @Override // com.blued.android.module.live_china.adapter.LiveDesireListAdapter.LiveDesireListEventCallBack
        public void b(String str, LiveDesireGiftInfo liveDesireGiftInfo, LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack) {
            LiveDesireDialogFragment.this.b(str, liveDesireGiftInfo, rankSccessCallBack);
        }

        @Override // com.blued.android.module.live_china.adapter.LiveDesireListAdapter.LiveDesireListEventCallBack
        public void delete(final long j) {
            boolean z;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= LiveDesireDialogFragment.this.r.size()) {
                    break;
                } else if (((LiveDesireLiseModel) LiveDesireDialogFragment.this.r.get(i2)).id == j) {
                    z = ((LiveDesireLiseModel) LiveDesireDialogFragment.this.r.get(i2)).isCreate;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            EventTrackLive.a(LiveProtos.Event.LIVE_WISH_SOMEONE_DELETE_CLICK, LiveRoomManager.a().e(), z, z ? String.valueOf(j) : "");
            final boolean z2 = z;
            final boolean z3 = z;
            CommonAlertDialog.a(LiveDesireDialogFragment.this.a, "", "删除心愿单", "确认", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$1$BOXdgdIwcbM84gXaQTYiQVPPLMg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LiveDesireDialogFragment.AnonymousClass1.this.b(z2, j, dialogInterface, i3);
                }
            }, "取消", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$1$q7lHUwcuHnyV2wB4Z7co69AA31Y
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LiveDesireDialogFragment.AnonymousClass1.a(z3, j, dialogInterface, i3);
                }
            }, (DialogInterface.OnDismissListener) null);
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveDesireDialogFragment$FormType.class */
    public enum FormType {
        TYPE_PLAYING,
        TYPE_RECORDING_CONFIG,
        TYPE_RECORDING_LOOK_UP
    }

    public LiveDesireDialogFragment() {
    }

    public LiveDesireDialogFragment(Context context, FormType formType) {
        this.a = context;
        this.f = formType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final long j) {
        LiveRoomHttpUtils.j(String.valueOf(j), new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (bluedEntityA.code == 200) {
                    LiveDesireDialogFragment.this.b(j);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveDesireDialogFragment.this.t.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LiveDesireDialogFragment.this.t.setVisibility(0);
                super.onUIStart();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (!i()) {
            dismiss();
            return;
        }
        CommonAlertDialog.a(this.a, this.a.getString(R.string.live_desire_has_not_create_title), this.a.getString(R.string.live_desire_has_not_create_msg), this.a.getString(R.string.live_desire_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$cczXn6d2JJAk5PPkWaKIzzI_U18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveDesireDialogFragment.this.a(dialogInterface, i);
            }
        }, this.a.getString(R.string.live_desire_cancel), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$k_xxt2cjgTWOoYN8r5vDdTndcRQ
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                LiveDesireDialogFragment.this.a(dialogInterface);
            }
        });
        this.v = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, DialogInterface dialogInterface, int i) {
        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_HELP_POP_CANCEL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, LiveDesireGiftInfo liveDesireGiftInfo, LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack) {
        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_LIST_HELP_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
        liveDesireGiftInfo.count = 1;
        a(str, liveDesireGiftInfo, false, rankSccessCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, LiveDesireGiftInfo liveDesireGiftInfo, LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack, DialogInterface dialogInterface, int i) {
        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_HELP_POP_TRUE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
        c(str, liveDesireGiftInfo, rankSccessCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final LiveDesireGiftInfo liveDesireGiftInfo, final boolean z, final LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack) {
        this.e = new BuyGiftUtil(String.valueOf(liveDesireGiftInfo.id), liveDesireGiftInfo.count, z, this.t, this, new BuyGiftUtil.CallBack() { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.6
            @Override // com.blued.android.module.live_china.utils.BuyGiftUtil.CallBack
            public void a(int i, String str2) {
                LiveDesireDialogFragment.this.g();
            }

            @Override // com.blued.android.module.live_china.utils.BuyGiftUtil.CallBack
            public void a(long j) {
                EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_WISH_LIST_HELP_SEND_GIFT, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str, String.valueOf(liveDesireGiftInfo.id), j);
                try {
                    LiveGiftModel liveGiftModel = new LiveGiftModel();
                    liveGiftModel.giftId = liveDesireGiftInfo.id;
                    liveGiftModel.name = liveDesireGiftInfo.name;
                    if (j > 1) {
                        liveGiftModel.hit_batch = 1;
                        liveGiftModel.hit_count = liveDesireGiftInfo.count;
                    }
                    liveGiftModel.count = liveDesireGiftInfo.count;
                    liveGiftModel.pic = liveDesireGiftInfo.pic;
                    liveGiftModel.images_static = liveDesireGiftInfo.images_static;
                    liveGiftModel.images_apng2 = liveDesireGiftInfo.images_apng;
                    liveGiftModel.images_gif = liveDesireGiftInfo.images_gif;
                    liveGiftModel.images_mp4 = liveDesireGiftInfo.images_mp4;
                    liveGiftModel.anim_code = liveDesireGiftInfo.anim_code;
                    liveGiftModel.animation = liveDesireGiftInfo.animation;
                    liveGiftModel.resource_url = liveDesireGiftInfo.resource_url;
                    liveGiftModel.is_help_wish_list = z;
                    LiveMsgSendManager.a().a(liveGiftModel);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                rankSccessCallBack.rankSccess();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.k == null) {
            View view = this.j;
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!z) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
        } else {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    LiveDesireResetPop.a(LiveDesireDialogFragment.this.a, LiveDesireDialogFragment.this.a());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            i = 0;
            if (i3 >= this.r.size()) {
                break;
            } else if (this.r.get(i3).id == j) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        this.r.remove(i);
        this.q.notifyDataSetChanged();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface) {
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        int i;
        List<LiveDesireLiseModel> list = this.r;
        if (list == null || list.size() == 0) {
            ToastUtils.b(String.format(this.a.getString(R.string.live_desire_create_null_error, String.valueOf(this.s)), new Object[0]));
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= this.r.size()) {
                break;
            }
            int i4 = i;
            if (this.r.get(i2).type == 0) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        if (i == 0 || i > this.s) {
            ToastUtils.b(String.format(this.a.getString(R.string.live_desire_create_null_error, String.valueOf(this.s)), new Object[0]));
            return;
        }
        EventTrackLive.b(LiveProtos.Event.LIVE_WISH_CREATE_CLICK, LiveRoomManager.a().e());
        ArrayList arrayList = new ArrayList();
        for (LiveDesireLiseModel liveDesireLiseModel : this.r) {
            if (liveDesireLiseModel.type == 0 && !liveDesireLiseModel.isCreate) {
                LiveDesireCreateDesireModel liveDesireCreateDesireModel = new LiveDesireCreateDesireModel();
                liveDesireCreateDesireModel.count = liveDesireLiseModel.count;
                liveDesireCreateDesireModel.goods_id = liveDesireLiseModel.gift_info.id;
                liveDesireCreateDesireModel.return_way = liveDesireLiseModel.return_way;
                arrayList.add(liveDesireCreateDesireModel);
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        LiveRoomHttpUtils.a(arrayList, new BluedUIHttpResponse<BluedEntityA<Integer>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Integer> bluedEntityA) {
                if (bluedEntityA.code == 200) {
                    for (Integer num : bluedEntityA.data) {
                        EventTrackLive.b(LiveProtos.Event.LIVE_WISH_CREATE_SUCCESS, LiveRoomManager.a().e(), String.valueOf(num));
                    }
                    LiveDesireDialogFragment.this.dismiss();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveDesireDialogFragment.this.t.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LiveDesireDialogFragment.this.t.setVisibility(0);
                super.onUIStart();
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Boolean bool) {
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final String str, final LiveDesireGiftInfo liveDesireGiftInfo, final LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack) {
        EventTrackLive.b(LiveProtos.Event.LIVE_ANCHOR_WISH_HELP_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), str);
        CommonAlertDialog.a(this.a, String.format(this.a.getString(R.string.live_desire_onekey_rank_title, liveDesireGiftInfo.name), new Object[0]), (String) null, "确认", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$h3NqmXGoy4r3W9KjXAo41DJ3wYg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveDesireDialogFragment.this.a(str, liveDesireGiftInfo, rankSccessCallBack, dialogInterface, i);
            }
        }, "取消", new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$uwapP7aYqaDuYZORPR4CkMUrhGI
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveDesireDialogFragment.a(String.this, dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view) {
        EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_WISH_LIST_REFRESH_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Boolean bool) {
        this.n.animate().translationY(bool.booleanValue() ? 0.0f : this.n.getHeight()).setStartDelay(bool.booleanValue() ? 0L : 600L).setDuration(1L);
    }

    private void c(final String str, final LiveDesireGiftInfo liveDesireGiftInfo, final LiveDesireListAdapter.RankSccessCallBack rankSccessCallBack) {
        LiveRoomHttpUtils.g(String.valueOf(liveDesireGiftInfo.id), new BluedUIHttpResponse<BluedEntityA<LiveDesireVerifyStatusModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveDesireVerifyStatusModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                if (!"PENDING".equals(bluedEntityA.getSingleData().status)) {
                    ToastUtils.b(R.string.live_desire_onekey_rank_failure);
                    LiveDesireDialogFragment.this.g();
                    return;
                }
                liveDesireGiftInfo.count = bluedEntityA.getSingleData().diff;
                LiveDesireDialogFragment.this.a(str, liveDesireGiftInfo, true, rankSccessCallBack);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                LiveDesireDialogFragment.this.g();
                return super.onUIFailure(i, str2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveDesireDialogFragment.this.t.setVisibility(8);
            }
        });
    }

    private void e() {
        if (this.f == FormType.TYPE_RECORDING_CONFIG) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$AhxplmV7YjPdjYSJ8dykpWXDyIM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveDesireDialogFragment.this.a(view);
                }
            });
            this.u.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$NgRYXF9XUI1zpkTVG4b_2JfR_FU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveDesireDialogFragment.this.b(view);
                }
            });
        } else {
            this.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$67PnxloXuVeosUkT-HFRftTNNLM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveDesireDialogFragment.this.c(view);
                }
            });
        }
        this.p.c(false);
        this.p.b(false);
        this.p.f(true);
        this.p.e(true);
        this.p.g(true);
    }

    private void f() {
        LiveDesireListAdapter liveDesireListAdapter = new LiveDesireListAdapter(this.a, this.f);
        this.q = liveDesireListAdapter;
        liveDesireListAdapter.a(new AnonymousClass1());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.o.setLayoutManager(linearLayoutManager);
        this.q.setHasStableIds(true);
        this.o.setAdapter(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LiveRoomHttpUtils.z(new BluedUIHttpResponse<BluedEntity<LiveDesireLiseModel, LiveDesireLiseExtra>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveDesireDialogFragment.this.t.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LiveDesireDialogFragment.this.t.setVisibility(0);
                super.onUIStart();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveDesireLiseModel, LiveDesireLiseExtra> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                if (LiveDesireDialogFragment.this.r == null) {
                    LiveDesireDialogFragment.this.r = new ArrayList();
                } else {
                    LiveDesireDialogFragment.this.r.clear();
                }
                LiveDesireDialogFragment.this.s = bluedEntity.extra.getWish_list_limit();
                if (bluedEntity.data != null && bluedEntity.data.size() != 0) {
                    for (LiveDesireLiseModel liveDesireLiseModel : bluedEntity.data) {
                        liveDesireLiseModel.isCreate = true;
                    }
                    LiveDesireDialogFragment.this.r.addAll(bluedEntity.data);
                }
                if (LiveDesireDialogFragment.this.f == FormType.TYPE_RECORDING_CONFIG) {
                    LiveDesireLiseModel liveDesireLiseModel2 = new LiveDesireLiseModel();
                    liveDesireLiseModel2.type = 1;
                    LiveDesireDialogFragment.this.r.add(liveDesireLiseModel2);
                    LiveDesireDialogFragment.this.a(bluedEntity.extra.wish_list_all_done);
                }
                LiveDesireLiseModel liveDesireLiseModel3 = new LiveDesireLiseModel();
                liveDesireLiseModel3.type = 2;
                liveDesireLiseModel3.tips = LiveDesireDialogFragment.this.f == FormType.TYPE_RECORDING_CONFIG ? LiveDesireDialogFragment.this.a.getString(R.string.live_desire_describe_recording) : LiveDesireDialogFragment.this.a.getString(R.string.live_desire_describe_playing);
                LiveDesireDialogFragment.this.r.add(liveDesireLiseModel3);
                LiveDesireDialogFragment.this.q.a(LiveDesireDialogFragment.this.r);
                LiveDesireDialogFragment.this.q.notifyDataSetChanged();
                LiveDesireDialogFragment.this.j();
                LiveDesireDialogFragment.this.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.x && this.f == FormType.TYPE_PLAYING) {
            a(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$3E3v8Un3UXwY1TJU6QaGy4aeI00
                @Override // java.lang.Runnable
                public final void run() {
                    LiveDesireDialogFragment.this.k();
                }
            }, 200L);
        }
    }

    private boolean i() {
        List<LiveDesireLiseModel> list = this.r;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (LiveDesireLiseModel liveDesireLiseModel : this.r) {
            if (liveDesireLiseModel.type == 0 && !liveDesireLiseModel.isCreate) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f != FormType.TYPE_RECORDING_CONFIG || this.u == null) {
            return;
        }
        if (i()) {
            if (this.u.getAlpha() <= 0.32d) {
                this.u.animate().alpha(1.0f).setDuration(200L);
            }
        } else if (this.u.getAlpha() >= 0.98d) {
            this.u.animate().alpha(0.3f).setDuration(200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        int h;
        if (this.q.a() != null && (h = LiveRoomPreferences.h()) < 3) {
            new LiveOnekeyRankPop(this.a).b(this.q.a());
            this.x = false;
            LiveRoomPreferences.a(h + 1);
        }
    }

    public void d() {
        LiveRoomHttpUtils.C(new BluedUIHttpResponse<BluedEntityA<LiveWishItemModel>>(a()) { // from class: com.blued.android.module.live_china.fragment.LiveDesireDialogFragment.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveWishItemModel> bluedEntityA) {
                if ((bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) ? false : true) {
                    AppMethods.d(R.string.live_desire_reset_success);
                    LiveDesireDialogFragment.this.dismiss();
                    return;
                }
                AppMethods.d(R.string.live_desire_reset_clear);
                LiveDesireDialogFragment.this.g();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 4221005 || i == 4221004) && intent != null) {
                String stringExtra = intent.getStringExtra("password");
                boolean booleanExtra = intent.getBooleanExtra("remember_me", false);
                if (this.e == null || TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                this.e.a(stringExtra, booleanExtra);
            } else if (i != 4221002 || intent == null || this.e == null) {
            } else {
                this.e.a(intent.getStringExtra("password"), intent.getBooleanExtra("remember_me", false));
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        if (this.v || this.w == 0 || System.currentTimeMillis() - this.w < 200) {
            return true;
        }
        if (this.f == FormType.TYPE_RECORDING_CONFIG && i()) {
            CommonAlertDialog.a(this.a, this.a.getString(R.string.live_desire_has_not_create_title), this.a.getString(R.string.live_desire_has_not_create_msg), this.a.getString(R.string.live_desire_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$-MKvuogWF_Qkzq_8qrdrrH-hqH0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LiveDesireDialogFragment.this.b(dialogInterface, i);
                }
            }, this.a.getString(R.string.live_desire_cancel), (DialogInterface.OnClickListener) null, new DialogInterface.OnDismissListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$zq_LNF9RWtVoDUe4VV6VpfNabQ8
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LiveDesireDialogFragment.this.b(dialogInterface);
                }
            });
            this.v = true;
            return true;
        }
        return super.onBackPressed();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.a = getActivity();
        View inflate = getActivity().getLayoutInflater().inflate(this.f == FormType.TYPE_RECORDING_CONFIG ? R.layout.dialog_live_desire_recording : R.layout.dialog_live_desire_playing, (ViewGroup) null);
        int height = this.f == FormType.TYPE_RECORDING_CONFIG ? getActivity().getWindowManager().getDefaultDisplay().getHeight() - DensityUtils.a(getActivity()) : DensityUtils.a(this.a, 364.0f);
        Dialog dialog = new Dialog(getActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(inflate, new ViewGroup.LayoutParams(-1, height));
        Window window = dialog.getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = height;
        attributes.x = 0;
        attributes.y = getActivity().getWindowManager().getDefaultDisplay().getHeight() - height;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(this.f == FormType.TYPE_RECORDING_CONFIG ? R.layout.dialog_live_desire_recording : R.layout.dialog_live_desire_playing, viewGroup);
        this.j = inflate.findViewById(R.id.tv_tips);
        this.k = inflate.findViewById(R.id.ll_reset);
        this.l = inflate.findViewById(R.id.tv_reset_desire);
        this.n = inflate.findViewById(R.id.rl_content);
        this.o = inflate.findViewById(R.id.recycler_view);
        this.p = inflate.findViewById(R.id.smart_refresh);
        this.t = (RelativeLayout) inflate.findViewById(R.id.loading);
        if (this.f == FormType.TYPE_RECORDING_CONFIG) {
            this.g = inflate.findViewById(R.id.view_bg);
            this.u = (TextView) inflate.findViewById(R.id.tv_create_desire);
            this.o.setPadding(0, DensityUtils.a(this.a, 4.0f), 0, 0);
        } else {
            this.h = (ImageView) inflate.findViewById(R.id.header_view);
            this.i = (ImageView) inflate.findViewById(R.id.header_level_bg);
            this.m = (ImageView) inflate.findViewById(R.id.iv_refresh);
            this.o.setPadding(0, DensityUtils.a(this.a, 4.0f), 0, DensityUtils.a(this.a, 17.0f));
        }
        e();
        f();
        g();
        if (this.f != FormType.TYPE_RECORDING_CONFIG) {
            ImageLoader.a((IRequestHost) null, AvatarUtils.a(1, LiveRoomManager.a().p().profile.avatar)).b(R.drawable.user_bg_round).c().a(this.h);
            int i = LiveRoomManager.a().p().level;
            if (i >= 90) {
                this.i.setImageResource(R.drawable.live_anchor_head_bg_90);
                this.i.setVisibility(0);
            } else if (i >= 60) {
                this.i.setImageResource(R.drawable.live_anchor_head_bg_60);
                this.i.setVisibility(0);
            } else if (i >= 30) {
                this.i.setImageResource(R.drawable.live_anchor_head_bg_30);
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
        this.b = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$oV-cAZnUNirS204BX7GJ9Y18Nxk
            public final void onChanged(Object obj) {
                LiveDesireDialogFragment.this.c((Boolean) obj);
            }
        };
        this.c = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$e6A5PC4Ak4qkV_snCnvhEDbleog
            public final void onChanged(Object obj) {
                LiveDesireDialogFragment.this.b((Boolean) obj);
            }
        };
        this.d = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveDesireDialogFragment$KCBZwAQeBh6G3EmBcKOYErxu7wY
            public final void onChanged(Object obj) {
                LiveDesireDialogFragment.this.a((Boolean) obj);
            }
        };
        LiveEventBus.get("desire_dialog_show", Boolean.class).observe(this, this.b);
        LiveEventBus.get("desire_refresh", Boolean.class).observe(this, this.d);
        LiveEventBus.get("desire_reset", Boolean.class).observe(this, this.c);
        return inflate;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroy() {
        LiveEventBus.get("desire_dialog_show", Boolean.class).removeObserver(this.b);
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            if (this.f == FormType.TYPE_PLAYING) {
                EventTrackLive.a(LiveProtos.Event.LIVE_ANCHOR_WISH_LIST_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            }
            ReflectionUtils.a(this, "mDismissed", false);
            ReflectionUtils.a(this, "mShownByMe", true);
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
            this.w = System.currentTimeMillis();
        } catch (Exception e) {
            super.show(fragmentManager, str);
        }
    }
}
