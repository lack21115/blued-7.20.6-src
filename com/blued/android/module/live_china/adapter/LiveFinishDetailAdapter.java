package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.model.LiveFansLevelModel;
import com.blued.android.module.common.view.LiveFansLevelView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveHostFinishDetailItemBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFinishData;
import com.blued.android.module.live_china.model.LiveRelationModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.same.LiveBitmapUtils;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view_model.LiveHostFinishDetailViewModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFinishDetailAdapter.class */
public final class LiveFinishDetailAdapter extends BaseQuickAdapter<LiveFinishData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f11626a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private LiveHostFinishDetailViewModel.ApiState f11627c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFinishDetailAdapter(Context context, IRequestHost fragmentActive, LiveHostFinishDetailViewModel.ApiState state) {
        super(R.layout.live_host_finish_detail_item);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(state, "state");
        this.f11626a = context;
        this.b = fragmentActive;
        this.f11627c = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveFinishDetailAdapter this$0, LiveFinishData liveFinishData, LiveHostFinishDetailItemBinding viewBinding, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        this$0.a(liveFinishData, viewBinding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveFinishDetailAdapter this$0, LiveFinishData liveFinishData, LiveHostFinishDetailItemBinding viewBinding, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        this$0.a(liveFinishData, viewBinding);
    }

    public final IRequestHost a() {
        return this.b;
    }

    public final void a(final LiveFinishData liveFinishData, final LiveHostFinishDetailItemBinding viewBinding) {
        Intrinsics.e(viewBinding, "viewBinding");
        String relationship = liveFinishData == null ? null : liveFinishData.getRelationship();
        final IRequestHost iRequestHost = this.b;
        LiveRoomManager.a(relationship, new BluedUIHttpResponse<BluedEntityA<LiveRelationModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.adapter.LiveFinishDetailAdapter$addOrRemoveAtten$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRelationModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null) {
                    return;
                }
                List<LiveRelationModel> list = bluedEntityA.data;
                Intrinsics.a(list);
                if (list.size() > 0) {
                    LiveFinishData liveFinishData2 = LiveFinishData.this;
                    if (liveFinishData2 != null) {
                        List<LiveRelationModel> list2 = bluedEntityA.data;
                        Intrinsics.a(list2);
                        liveFinishData2.setRelationship(list2.get(0).getRelationship());
                    }
                    LiveFinishDetailAdapter liveFinishDetailAdapter = this;
                    LiveFinishData liveFinishData3 = LiveFinishData.this;
                    liveFinishDetailAdapter.b(liveFinishData3 == null ? null : liveFinishData3.getRelationship(), LiveFinishData.this, viewBinding);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
            }
        }, liveFinishData == null ? null : liveFinishData.getUid(), "live_", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, LiveFinishData liveFinishData) {
        Intrinsics.e(helper, "helper");
        if (liveFinishData == null) {
            return;
        }
        LiveHostFinishDetailItemBinding a2 = LiveHostFinishDetailItemBinding.a(helper.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        a2.o.setText(String.valueOf(helper.getLayoutPosition() + 1));
        if (Intrinsics.a(b(), LiveHostFinishDetailViewModel.ApiState.ApiNewFollowers.f15470a) || Intrinsics.a(b(), LiveHostFinishDetailViewModel.ApiState.ApiNewFans.f15469a)) {
            String relationship = liveFinishData.getRelationship();
            if (relationship == null || relationship.length() == 0) {
                a(liveFinishData.getUid(), liveFinishData, a2);
            } else {
                b(liveFinishData.getRelationship(), liveFinishData, a2);
            }
            LinearLayout linearLayout = a2.j;
            Intrinsics.c(linearLayout, "itemBinding.llDes");
            BluedViewExKt.a(linearLayout);
        } else {
            ShapeTextView shapeTextView = a2.m;
            Intrinsics.c(shapeTextView, "itemBinding.tvAttend");
            BluedViewExKt.a(shapeTextView);
            ShapeTextView shapeTextView2 = a2.l;
            Intrinsics.c(shapeTextView2, "itemBinding.tvAtten");
            BluedViewExKt.a(shapeTextView2);
            String text = liveFinishData.getText();
            if (text == null || text.length() == 0) {
                LinearLayout linearLayout2 = a2.j;
                Intrinsics.c(linearLayout2, "itemBinding.llDes");
                BluedViewExKt.a(linearLayout2);
            } else {
                LinearLayout linearLayout3 = a2.j;
                Intrinsics.c(linearLayout3, "itemBinding.llDes");
                BluedViewExKt.b(linearLayout3);
                a2.n.setText(liveFinishData.getText());
            }
            if (Intrinsics.a(b(), LiveHostFinishDetailViewModel.ApiState.ApiContributors.f15466a)) {
                ImageView imageView = a2.f12244c;
                Intrinsics.c(imageView, "itemBinding.ivBeans");
                BluedViewExKt.b(imageView);
            } else {
                ImageView imageView2 = a2.f12244c;
                Intrinsics.c(imageView2, "itemBinding.ivBeans");
                BluedViewExKt.a(imageView2);
            }
        }
        a2.p.setText(liveFinishData.getName());
        ImageLoader.a((IRequestHost) null, liveFinishData.getAvatar()).c().b(R.drawable.user_bg_round).a(a2.b);
        String vip_frame = liveFinishData.getVip_frame();
        if (vip_frame == null || vip_frame.length() == 0) {
            ImageView imageView3 = a2.i;
            Intrinsics.c(imageView3, "itemBinding.ivVip");
            BluedViewExKt.a(imageView3);
        } else {
            ImageView imageView4 = a2.i;
            Intrinsics.c(imageView4, "itemBinding.ivVip");
            BluedViewExKt.b(imageView4);
            String vip_frame2 = liveFinishData.getVip_frame();
            Intrinsics.a((Object) vip_frame2);
            ImageLoader.a((IRequestHost) null, vip_frame2).g().g(-1).a(a2.i);
        }
        if (liveFinishData.getRich_level() != 0) {
            ImageView imageView5 = a2.h;
            Intrinsics.c(imageView5, "itemBinding.ivRichLevel");
            BluedViewExKt.b(imageView5);
            a2.h.setImageDrawable(LiveBitmapUtils.a(AppInfo.d(), liveFinishData.getRich_level()));
        } else {
            ImageView imageView6 = a2.h;
            Intrinsics.c(imageView6, "itemBinding.ivRichLevel");
            BluedViewExKt.a(imageView6);
        }
        int a3 = AppMethods.a(15);
        ViewGroup.LayoutParams layoutParams = a2.f.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        String nameplate_img = liveFinishData.getNameplate_img();
        if (nameplate_img == null || nameplate_img.length() == 0) {
            ImageView imageView7 = a2.f;
            Intrinsics.c(imageView7, "itemBinding.ivNoble");
            BluedViewExKt.a(imageView7);
            layoutParams2.width = 0;
            layoutParams2.height = 0;
        } else {
            ImageView imageView8 = a2.f;
            Intrinsics.c(imageView8, "itemBinding.ivNoble");
            BluedViewExKt.b(imageView8);
            int nameplate_img_width = (liveFinishData.getNameplate_img_width() * a3) / liveFinishData.getNameplate_img_height();
            ImageLoader.a((IRequestHost) null, liveFinishData.getNameplate_img()).a(nameplate_img_width, a3).g().g(-1).a(a2.f);
            layoutParams2.width = nameplate_img_width;
            layoutParams2.height = a3;
        }
        a2.f.setLayoutParams(layoutParams2);
        if (liveFinishData.getFans_status() == 0) {
            LiveFansLevelView liveFansLevelView = a2.d;
            Intrinsics.c(liveFansLevelView, "itemBinding.ivFansLevel");
            BluedViewExKt.a(liveFansLevelView);
            LiveFansLevelView liveFansLevelView2 = a2.e;
            Intrinsics.c(liveFansLevelView2, "itemBinding.ivFansLevel1");
            BluedViewExKt.a(liveFansLevelView2);
            return;
        }
        LiveFansLevelModel liveFansLevelModel = new LiveFansLevelModel();
        liveFansLevelModel.fan_club_level = liveFinishData.getFan_club_level();
        liveFansLevelModel.fans_status = liveFinishData.getFans_status();
        liveFansLevelModel.fan_club_name = liveFinishData.getFan_club_name();
        liveFansLevelModel.in_fan_club = 1;
        if (a2.i.getVisibility() == 0 && a2.h.getVisibility() == 0 && a2.f.getVisibility() == 0) {
            a2.e.setFansLevel(liveFansLevelModel);
            LiveFansLevelView liveFansLevelView3 = a2.e;
            Intrinsics.c(liveFansLevelView3, "itemBinding.ivFansLevel1");
            BluedViewExKt.b(liveFansLevelView3);
            LiveFansLevelView liveFansLevelView4 = a2.d;
            Intrinsics.c(liveFansLevelView4, "itemBinding.ivFansLevel");
            BluedViewExKt.a(liveFansLevelView4);
            return;
        }
        a2.d.setFansLevel(liveFansLevelModel);
        LiveFansLevelView liveFansLevelView5 = a2.d;
        Intrinsics.c(liveFansLevelView5, "itemBinding.ivFansLevel");
        BluedViewExKt.b(liveFansLevelView5);
        LiveFansLevelView liveFansLevelView6 = a2.e;
        Intrinsics.c(liveFansLevelView6, "itemBinding.ivFansLevel1");
        BluedViewExKt.a(liveFansLevelView6);
    }

    public final void a(String str, final LiveFinishData liveFinishData, final LiveHostFinishDetailItemBinding viewBinding) {
        Intrinsics.e(viewBinding, "viewBinding");
        Context d = AppInfo.d();
        final IRequestHost iRequestHost = this.b;
        LiveRoomHttpUtils.a(d, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.adapter.LiveFinishDetailAdapter$getUserInfo$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                LiveRoomUserModel liveRoomUserModel;
                Intrinsics.e(bluedEntityA, "bluedEntityA");
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (liveRoomUserModel = bluedEntityA.data.get(0)) == null) {
                    return;
                }
                LiveFinishDetailAdapter.this.b(liveRoomUserModel.relationship, liveFinishData, viewBinding);
            }
        }, str, "", Long.valueOf(LiveRoomManager.a().d()), (Short) 4, this.b);
    }

    public final LiveHostFinishDetailViewModel.ApiState b() {
        return this.f11627c;
    }

    public final void b(String str, final LiveFinishData liveFinishData, final LiveHostFinishDetailItemBinding viewBinding) {
        Intrinsics.e(viewBinding, "viewBinding");
        if (liveFinishData != null) {
            liveFinishData.setRelationship(str);
        }
        String str2 = str;
        if (TextUtils.equals("1", str2) || TextUtils.equals("3", str2)) {
            ShapeTextView shapeTextView = viewBinding.l;
            Intrinsics.c(shapeTextView, "viewBinding.tvAtten");
            BluedViewExKt.a(shapeTextView);
            ShapeTextView shapeTextView2 = viewBinding.m;
            Intrinsics.c(shapeTextView2, "viewBinding.tvAttend");
            BluedViewExKt.b(shapeTextView2);
        } else {
            ShapeTextView shapeTextView3 = viewBinding.l;
            Intrinsics.c(shapeTextView3, "viewBinding.tvAtten");
            BluedViewExKt.b(shapeTextView3);
            ShapeTextView shapeTextView4 = viewBinding.m;
            Intrinsics.c(shapeTextView4, "viewBinding.tvAttend");
            BluedViewExKt.a(shapeTextView4);
        }
        viewBinding.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveFinishDetailAdapter$hWLRDkbz7eHVd4WoeNG53dl1eNQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFinishDetailAdapter.a(LiveFinishDetailAdapter.this, liveFinishData, viewBinding, view);
            }
        });
        viewBinding.m.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.-$$Lambda$LiveFinishDetailAdapter$jH8pxEa9ov--W2Kl5Kw-IOl9tI8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveFinishDetailAdapter.b(LiveFinishDetailAdapter.this, liveFinishData, viewBinding, view);
            }
        });
    }

    public final void c() {
        List<LiveFinishData> data = getData();
        if (data == null) {
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        for (final LiveFinishData liveFinishData : data) {
            if (!TextUtils.equals("1", liveFinishData.getRelationship()) && !TextUtils.equals("3", liveFinishData.getRelationship())) {
                intRef.f42543a++;
                final IRequestHost a2 = a();
                LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<LiveRelationModel>>(a2) { // from class: com.blued.android.module.live_china.adapter.LiveFinishDetailAdapter$allAttention$1$1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    /* renamed from: a */
                    public void onUIUpdate(BluedEntityA<LiveRelationModel> bluedEntityA) {
                        if (bluedEntityA == null || bluedEntityA.data == null) {
                            return;
                        }
                        List<LiveRelationModel> list = bluedEntityA.data;
                        Intrinsics.a(list);
                        if (list.size() > 0) {
                            LiveFinishData liveFinishData2 = LiveFinishData.this;
                            List<LiveRelationModel> list2 = bluedEntityA.data;
                            Intrinsics.a(list2);
                            liveFinishData2.setRelationship(list2.get(0).getRelationship());
                        }
                    }

                    @Override // com.blued.android.framework.http.BluedUIHttpResponse
                    public void onUIFinish() {
                        intRef2.f42543a++;
                        if (intRef.f42543a == intRef2.f42543a) {
                            this.notifyDataSetChanged();
                        }
                    }
                }, liveFinishData.getUid(), "live_", a());
            }
        }
    }

    public final Context getContext() {
        return this.f11626a;
    }
}
