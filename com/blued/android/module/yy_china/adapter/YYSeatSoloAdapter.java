package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.GiftBeansObserver;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatSoloAdapter.class */
public class YYSeatSoloAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements View.OnClickListener, GiftBeansObserver, SeatChangedObserver {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f16273a;
    private YYRoomModel b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f16274c;
    private TextView d;
    private YYBaseUserHeadView e;
    private TextView f;
    private YYBaseUserHeadView g;
    private TextView h;
    private TextView i;
    private YYBaseUserHeadView j;
    private TextView k;
    private TextView l;
    private int m;
    private int n;

    public YYSeatSoloAdapter(Context context, BaseYYStudioFragment baseYYStudioFragment) {
        super(null);
        this.f16273a = baseYYStudioFragment;
        this.mContext = context;
        addItemType(5, R.layout.item_yy_connecting_solo_layout);
        this.b = YYRoomInfoManager.e().b();
        int a2 = AppInfo.l - DensityUtils.a(this.mContext, 20.0f);
        this.m = a2;
        this.n = (int) (a2 * 0.338d);
    }

    private String a(int i) {
        return this.f16273a.getResources().getString(i);
    }

    private void a(int i, View view) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty() || i > this.b.mics.size() - 1 || i < 0) {
            return;
        }
        YYSeatMemberModel yYSeatMemberModel = this.b.mics.get(i);
        if (e(yYSeatMemberModel)) {
            this.f16273a.a(view, yYSeatMemberModel, yYSeatMemberModel.mic_position);
        } else if (i == 1) {
            LiveEventBus.get("event_solo_friend").post("");
        } else if (i != 2) {
        } else {
            LiveEventBus.get("event_solo_fans").post("");
        }
    }

    private void a(int i, YYSeatMemberModel yYSeatMemberModel) {
        if (i == 0) {
            b(yYSeatMemberModel);
        } else if (i != 1) {
            c(yYSeatMemberModel);
        } else {
            d(yYSeatMemberModel);
        }
    }

    private void b() {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size() || i2 > 2) {
                return;
            }
            a(i2, this.b.mics.get(i2));
            i = i2 + 1;
        }
    }

    private void b(YYSeatMemberModel yYSeatMemberModel) {
        YYBaseUserHeadView yYBaseUserHeadView = this.e;
        if (yYBaseUserHeadView != null && yYSeatMemberModel != null) {
            yYBaseUserHeadView.a(yYSeatMemberModel, this.f16273a.getFragmentActive());
        }
        if (this.f != null && e(yYSeatMemberModel)) {
            this.f.setText(yYSeatMemberModel.getName());
        }
    }

    private void c(YYSeatMemberModel yYSeatMemberModel) {
        a();
        YYBaseUserHeadView yYBaseUserHeadView = this.j;
        if (yYBaseUserHeadView != null && yYSeatMemberModel != null) {
            yYBaseUserHeadView.setNoAudienceView(this.k);
            this.j.a(yYSeatMemberModel, this.f16273a.getFragmentActive());
        }
        if (this.l == null) {
            return;
        }
        if (e(yYSeatMemberModel)) {
            this.l.setText(yYSeatMemberModel.getName());
        } else {
            this.l.setText("");
        }
    }

    private void d(YYSeatMemberModel yYSeatMemberModel) {
        YYBaseUserHeadView yYBaseUserHeadView = this.g;
        if (yYBaseUserHeadView != null && yYSeatMemberModel != null) {
            yYBaseUserHeadView.setNoAudienceView(this.h);
            this.g.a(yYSeatMemberModel, this.f16273a.getFragmentActive());
        }
        if (this.i == null) {
            return;
        }
        if (e(yYSeatMemberModel)) {
            this.i.setText(yYSeatMemberModel.getName());
            return;
        }
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel != null) {
            a(yYRoomModel.soloLock);
        }
        this.i.setText("");
    }

    private boolean e(YYSeatMemberModel yYSeatMemberModel) {
        return yYSeatMemberModel != null && StringUtils.a(yYSeatMemberModel.getUid(), 0) > 0;
    }

    public void a() {
        YYRoomModel yYRoomModel;
        TextView textView = this.k;
        if (textView == null) {
            return;
        }
        textView.setText(a(R.string.yy_fans_seat));
        if (!YYRoomInfoManager.e().y() || (yYRoomModel = this.b) == null || yYRoomModel.setSoloGift) {
            return;
        }
        this.k.setText(a(R.string.yy_set_gift));
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void a(int i, int i2) {
        YYSeatMemberModel yYSeatMemberModel;
        YYBaseUserHeadView yYBaseUserHeadView;
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty() || i >= this.b.mics.size() || i > 2 || (yYSeatMemberModel = this.b.mics.get(i)) == null) {
            return;
        }
        if (i2 == 1) {
            yYSeatMemberModel.position_status = -1;
        } else {
            yYSeatMemberModel.position_status = i2;
        }
        if (i == 0) {
            YYBaseUserHeadView yYBaseUserHeadView2 = this.e;
            if (yYBaseUserHeadView2 == null) {
                return;
            }
            yYBaseUserHeadView2.a(yYSeatMemberModel, this.f16273a.getFragmentActive());
        } else if (i != 1) {
            if (i == 2 && (yYBaseUserHeadView = this.j) != null) {
                yYBaseUserHeadView.a(yYSeatMemberModel, this.f16273a.getFragmentActive());
            }
        } else {
            YYBaseUserHeadView yYBaseUserHeadView3 = this.g;
            if (yYBaseUserHeadView3 == null) {
                return;
            }
            yYBaseUserHeadView3.a(yYSeatMemberModel, this.f16273a.getFragmentActive());
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(int i, String str, String str2, YYImModel yYImModel) {
        YYBaseUserHeadView yYBaseUserHeadView;
        if (i > 2) {
            return;
        }
        if (i == 0) {
            YYBaseUserHeadView yYBaseUserHeadView2 = this.e;
            if (yYBaseUserHeadView2 == null) {
                return;
            }
            yYBaseUserHeadView2.a(this.f16273a.getFragmentActive(), str, str2, yYImModel);
        } else if (i != 1) {
            if (i == 2 && (yYBaseUserHeadView = this.j) != null) {
                yYBaseUserHeadView.a(this.f16273a.getFragmentActive(), str, str2, yYImModel);
            }
        } else {
            YYBaseUserHeadView yYBaseUserHeadView3 = this.g;
            if (yYBaseUserHeadView3 == null) {
                return;
            }
            yYBaseUserHeadView3.a(this.f16273a.getFragmentActive(), str, str2, yYImModel);
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size() || i2 > 2) {
                return;
            }
            if (StringUtils.a(str, this.b.mics.get(i2).getUid())) {
                if (i2 == 0) {
                    YYBaseUserHeadView yYBaseUserHeadView = this.e;
                    if (yYBaseUserHeadView == null) {
                        return;
                    }
                    yYBaseUserHeadView.a(getViewX_Y_W_H);
                } else if (i2 == 1) {
                    YYBaseUserHeadView yYBaseUserHeadView2 = this.g;
                    if (yYBaseUserHeadView2 == null) {
                        return;
                    }
                    yYBaseUserHeadView2.a(getViewX_Y_W_H);
                } else if (i2 == 2) {
                    YYBaseUserHeadView yYBaseUserHeadView3 = this.j;
                    if (yYBaseUserHeadView3 == null) {
                        return;
                    }
                    yYBaseUserHeadView3.a(getViewX_Y_W_H);
                } else {
                    continue;
                }
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYSeatMemberModel yYSeatMemberModel) {
        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSoloAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.getView(R.id.ll_topic);
        this.f16274c = relativeLayout;
        ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
        layoutParams.width = this.m;
        layoutParams.height = this.n;
        this.d = (TextView) baseViewHolder.getView(R.id.tv_topic);
        this.f16274c.setOnClickListener(this);
        YYBaseUserHeadView yYBaseUserHeadView = (YYBaseUserHeadView) baseViewHolder.getView(R.id.base_host_head);
        this.e = yYBaseUserHeadView;
        yYBaseUserHeadView.setOnClickListener(this);
        this.e.a(0, 0, DensityUtils.a(this.f16273a.b, 5.0f), DensityUtils.a(this.f16273a.b, 5.0f));
        this.f = (TextView) baseViewHolder.getView(R.id.tv_host_name);
        YYBaseUserHeadView yYBaseUserHeadView2 = (YYBaseUserHeadView) baseViewHolder.getView(R.id.base_friend_head);
        this.g = yYBaseUserHeadView2;
        yYBaseUserHeadView2.setOnClickListener(this);
        this.h = (TextView) baseViewHolder.getView(R.id.tv_no_friend);
        this.i = (TextView) baseViewHolder.getView(R.id.tv_friend_name);
        YYBaseUserHeadView yYBaseUserHeadView3 = (YYBaseUserHeadView) baseViewHolder.getView(R.id.base_fans_head);
        this.j = yYBaseUserHeadView3;
        yYBaseUserHeadView3.setOnClickListener(this);
        this.k = (TextView) baseViewHolder.getView(R.id.tv_no_fans);
        this.l = (TextView) baseViewHolder.getView(R.id.tv_fans_name);
        b();
        a("");
        if (YYRoomInfoManager.e().b().voice_skin_info != null) {
            ImageLoader.a((IRequestHost) null, YYRoomInfoManager.e().b().voice_skin_info.getIcon()).a(new SimpleTarget<Drawable>() { // from class: com.blued.android.module.yy_china.adapter.YYSeatSoloAdapter.2
                @Override // com.bumptech.glide.request.target.Target
                /* renamed from: a */
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    YYSeatSoloAdapter.this.k.setBackgroundDrawable(drawable);
                    YYSeatSoloAdapter.this.h.setBackgroundDrawable(drawable);
                }
            });
        }
    }

    public void a(String str) {
        this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        if (!TextUtils.isEmpty(str)) {
            this.d.setText(str);
            return;
        }
        if (YYRoomInfoManager.e().y()) {
            Drawable drawable = this.f16273a.getResources().getDrawable(R.drawable.icon_yy_topic_editor);
            this.d.setText("");
            this.d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
        } else {
            this.d.setText("欢迎来到单麦房间");
        }
        if (YYRoomInfoManager.e().b() == null || YYRoomInfoManager.e().b().topic_set_info == null) {
            return;
        }
        this.d.setText(YYRoomInfoManager.e().b().topic_set_info.getTopic());
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(String str, String str2) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size() || i2 > 2) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.b.mics.get(i2);
            if (TextUtils.equals(yYSeatMemberModel.getUid(), str)) {
                yYSeatMemberModel.chat_anchor = str2;
                a(i2, yYSeatMemberModel);
                return;
            }
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.module.yy_china.adapter.BaseConnectingAdapter
    public void a(Set<String> set) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null || yYRoomModel.mics == null || this.b.mics.isEmpty()) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.mics.size() || i2 > 2) {
                return;
            }
            YYSeatMemberModel yYSeatMemberModel = this.b.mics.get(i2);
            if (yYSeatMemberModel.is_open_mic != 0) {
                if (set == null || set.isEmpty() || !set.contains(yYSeatMemberModel.getUid())) {
                    yYSeatMemberModel.is_open_mic = 1;
                } else {
                    yYSeatMemberModel.is_open_mic = 2;
                }
                if (i2 == 0) {
                    YYBaseUserHeadView yYBaseUserHeadView = this.e;
                    if (yYBaseUserHeadView == null) {
                        return;
                    }
                    yYBaseUserHeadView.a(set, yYSeatMemberModel);
                } else if (i2 == 1) {
                    YYBaseUserHeadView yYBaseUserHeadView2 = this.g;
                    if (yYBaseUserHeadView2 == null) {
                        return;
                    }
                    yYBaseUserHeadView2.a(set, yYSeatMemberModel);
                } else if (i2 == 2) {
                    YYBaseUserHeadView yYBaseUserHeadView3 = this.j;
                    if (yYBaseUserHeadView3 == null) {
                        return;
                    }
                    yYBaseUserHeadView3.a(set, yYSeatMemberModel);
                } else {
                    continue;
                }
            }
            i = i2 + 1;
        }
    }

    public void a(boolean z) {
        TextView textView = this.h;
        if (textView == null) {
            return;
        }
        textView.setText(z ? R.string.yy_friend_lock : R.string.yy_friend_unlock);
    }

    @Override // com.blued.android.module.yy_china.observer.GiftBeansObserver
    public void b(String str) {
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        a(yYRoomModel.soloLock);
    }

    @Override // com.blued.android.module.yy_china.observer.SeatChangedObserver
    public void b(List<YYSeatMemberModel> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || i2 > 2) {
                return;
            }
            a(i2, list.get(i2));
            i = i2 + 1;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        YYObserverManager.a().a((SeatChangedObserver) this);
        YYObserverManager.a().a((GiftBeansObserver) this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.base_host_head) {
            a(0, this.e);
        } else if (view.getId() == R.id.base_friend_head) {
            a(1, this.g);
        } else if (view.getId() == R.id.base_fans_head) {
            a(2, this.j);
        } else if (view.getId() == R.id.ll_topic) {
            String trim = this.d.getText().toString().trim();
            if (YYRoomInfoManager.e().y()) {
                LiveEventBus.get("event_solo_edit_topic").post(trim);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        YYObserverManager.a().b((SeatChangedObserver) this);
        YYObserverManager.a().b((GiftBeansObserver) this);
        YYRoomModel yYRoomModel = this.b;
        if (yYRoomModel == null) {
            return;
        }
        yYRoomModel.clearEmojiAndSendMessage();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<YYSeatMemberModel> list) {
        ArrayList arrayList = new ArrayList();
        YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
        yYSeatMemberModel.itemType = 5;
        arrayList.add(yYSeatMemberModel);
        super.setNewData(arrayList);
    }
}
