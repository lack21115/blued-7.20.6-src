package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.FansClubAdapter;
import com.blued.android.module.yy_china.databinding.DialogFansClubAudienceViewBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClubAudienceModel;
import com.blued.android.module.yy_china.model.YYClubGroupInfoModel;
import com.blued.android.module.yy_china.model.YYClubLevelInfoModel;
import com.blued.android.module.yy_china.model.YYClubRankMemberModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYFansLevelView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYFansClubAudienceViewDialog.class */
public final class YYFansClubAudienceViewDialog extends YYBaseFansDialog {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f17225a;
    private final YYUserInfo b;

    /* renamed from: c  reason: collision with root package name */
    private DialogFansClubAudienceViewBinding f17226c;
    private FansClubAdapter d;
    private int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYFansClubAudienceViewDialog(BaseFragment fragment, YYUserInfo us) {
        super(fragment, us);
        Intrinsics.e(fragment, "fragment");
        Intrinsics.e(us, "us");
        this.f17225a = fragment;
        this.b = us;
        this.e = 1;
    }

    private final void l() {
        SmartRefreshLayout smartRefreshLayout;
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding = this.f17226c;
        if (dialogFansClubAudienceViewBinding != null && (smartRefreshLayout = dialogFansClubAudienceViewBinding.j) != null) {
            smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYFansClubAudienceViewDialog$initView$1
                @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYFansClubAudienceViewDialog.this.p();
                }

                @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    YYFansClubAudienceViewDialog.this.e = 0;
                    YYFansClubAudienceViewDialog.this.p();
                }
            });
        }
        m();
        n();
    }

    private final void m() {
        YYUserInfo g = g();
        if (g != null) {
            DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding = this.f17226c;
            TextView textView = dialogFansClubAudienceViewBinding == null ? null : dialogFansClubAudienceViewBinding.o;
            if (textView != null) {
                textView.setText(Intrinsics.a(g.getName(), (Object) "的粉丝团"));
            }
            ImageWrapper b = ImageLoader.a(a(), g.getAvatar()).b(R.drawable.user_bg_round);
            DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding2 = this.f17226c;
            b.a(dialogFansClubAudienceViewBinding2 == null ? null : dialogFansClubAudienceViewBinding2.f16331c);
        }
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
        if (yYUserInfo == null) {
            return;
        }
        ImageWrapper b2 = ImageLoader.a(a(), yYUserInfo.getAvatar()).b(R.drawable.user_bg_round);
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding3 = this.f17226c;
        b2.a(dialogFansClubAudienceViewBinding3 == null ? null : dialogFansClubAudienceViewBinding3.d);
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding4 = this.f17226c;
        TextView textView2 = dialogFansClubAudienceViewBinding4 == null ? null : dialogFansClubAudienceViewBinding4.x;
        if (textView2 == null) {
            return;
        }
        textView2.setText(yYUserInfo.getName());
    }

    private final void n() {
        List<YYClubRankMemberModel> data;
        ActivityFragmentActive fragmentActive = a();
        Intrinsics.c(fragmentActive, "fragmentActive");
        this.d = new FansClubAdapter(fragmentActive);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding = this.f17226c;
        Integer num = null;
        RecyclerView recyclerView = dialogFansClubAudienceViewBinding == null ? null : dialogFansClubAudienceViewBinding.n;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding2 = this.f17226c;
        RecyclerView recyclerView2 = dialogFansClubAudienceViewBinding2 == null ? null : dialogFansClubAudienceViewBinding2.n;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.d);
        }
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding3 = this.f17226c;
        TextView textView = dialogFansClubAudienceViewBinding3 == null ? null : dialogFansClubAudienceViewBinding3.t;
        if (textView != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = getString(R.string.yy_fans_member_list);
            Intrinsics.c(string, "getString(R.string.yy_fans_member_list)");
            FansClubAdapter fansClubAdapter = this.d;
            if (fansClubAdapter != null && (data = fansClubAdapter.getData()) != null) {
                num = Integer.valueOf(data.size());
            }
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(num)}, 1));
            Intrinsics.c(format, "format(format, *args)");
            textView.setText(format);
        }
        FansClubAdapter fansClubAdapter2 = this.d;
        if (fansClubAdapter2 == null) {
            return;
        }
        fansClubAdapter2.setEmptyView(i());
    }

    private final void o() {
        YYUserInfo g = g();
        String uid = g == null ? null : g.getUid();
        final ActivityFragmentActive a2 = a();
        YYRoomHttpUtils.o(uid, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYClubAudienceModel>>(a2) { // from class: com.blued.android.module.yy_china.fragment.YYFansClubAudienceViewDialog$getClubInfoByAudience$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYClubAudienceModel> bluedEntityA) {
                YYClubAudienceModel singleData;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding2;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding3;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding4;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding5;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding6;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding7;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding8;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding9;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding10;
                DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding11;
                YYFansLevelView yYFansLevelView;
                YYFansLevelView yYFansLevelView2;
                if (bluedEntityA == null || !bluedEntityA.hasData() || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYFansClubAudienceViewDialog yYFansClubAudienceViewDialog = YYFansClubAudienceViewDialog.this;
                dialogFansClubAudienceViewBinding = yYFansClubAudienceViewDialog.f17226c;
                String str = null;
                TextView textView = dialogFansClubAudienceViewBinding == null ? null : dialogFansClubAudienceViewBinding.t;
                if (textView != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string = yYFansClubAudienceViewDialog.getString(R.string.yy_fans_member_list);
                    Intrinsics.c(string, "getString(R.string.yy_fans_member_list)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{singleData.fans_count}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    textView.setText(format);
                }
                YYClubLevelInfoModel yYClubLevelInfoModel = singleData.level_info;
                if (yYClubLevelInfoModel != null) {
                    dialogFansClubAudienceViewBinding2 = yYFansClubAudienceViewDialog.f17226c;
                    TextView textView2 = dialogFansClubAudienceViewBinding2 == null ? null : dialogFansClubAudienceViewBinding2.u;
                    if (textView2 != null) {
                        textView2.setText(yYClubLevelInfoModel.rank);
                    }
                    int a3 = StringUtils.a(yYClubLevelInfoModel.gap_score, 0);
                    int a4 = StringUtils.a(yYClubLevelInfoModel.score, 0);
                    dialogFansClubAudienceViewBinding3 = yYFansClubAudienceViewDialog.f17226c;
                    TextView textView3 = dialogFansClubAudienceViewBinding3 == null ? null : dialogFansClubAudienceViewBinding3.q;
                    if (textView3 != null) {
                        textView3.setText(yYClubLevelInfoModel.score);
                    }
                    dialogFansClubAudienceViewBinding4 = yYFansClubAudienceViewDialog.f17226c;
                    TextView textView4 = dialogFansClubAudienceViewBinding4 == null ? null : dialogFansClubAudienceViewBinding4.w;
                    if (textView4 != null) {
                        textView4.setText(Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) Integer.valueOf(a4 + a3)));
                    }
                    dialogFansClubAudienceViewBinding5 = yYFansClubAudienceViewDialog.f17226c;
                    if (dialogFansClubAudienceViewBinding5 != null && (yYFansLevelView2 = dialogFansClubAudienceViewBinding5.g) != null) {
                        String str2 = yYClubLevelInfoModel.level;
                        YYClubGroupInfoModel yYClubGroupInfoModel = singleData.group_info;
                        yYFansLevelView2.a(str2, yYClubGroupInfoModel == null ? null : yYClubGroupInfoModel.name, yYClubLevelInfoModel.status == 1);
                    }
                    dialogFansClubAudienceViewBinding6 = yYFansClubAudienceViewDialog.f17226c;
                    if (dialogFansClubAudienceViewBinding6 != null && (yYFansLevelView = dialogFansClubAudienceViewBinding6.h) != null) {
                        String str3 = yYClubLevelInfoModel.level;
                        YYClubGroupInfoModel yYClubGroupInfoModel2 = singleData.group_info;
                        yYFansLevelView.a(str3, yYClubGroupInfoModel2 == null ? null : yYClubGroupInfoModel2.name, yYClubLevelInfoModel.status == 1);
                    }
                    dialogFansClubAudienceViewBinding7 = yYFansClubAudienceViewDialog.f17226c;
                    ProgressBar progressBar = dialogFansClubAudienceViewBinding7 == null ? null : dialogFansClubAudienceViewBinding7.f16330a;
                    if (progressBar != null) {
                        progressBar.setMax(100);
                    }
                    dialogFansClubAudienceViewBinding8 = yYFansClubAudienceViewDialog.f17226c;
                    ProgressBar progressBar2 = dialogFansClubAudienceViewBinding8 == null ? null : dialogFansClubAudienceViewBinding8.f16330a;
                    if (progressBar2 != null) {
                        progressBar2.setProgress(StringUtils.a(yYClubLevelInfoModel.level_percent, 0));
                    }
                    if (a3 <= 0) {
                        dialogFansClubAudienceViewBinding11 = yYFansClubAudienceViewDialog.f17226c;
                        TextView textView5 = dialogFansClubAudienceViewBinding11 == null ? null : dialogFansClubAudienceViewBinding11.r;
                        if (textView5 != null) {
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                            String string2 = yYFansClubAudienceViewDialog.getString(R.string.yy_fans_intimacy_complete);
                            Intrinsics.c(string2, "getString(R.string.yy_fans_intimacy_complete)");
                            String format2 = String.format(string2, Arrays.copyOf(new Object[]{yYClubLevelInfoModel.score}, 1));
                            Intrinsics.c(format2, "format(format, *args)");
                            textView5.setText(format2);
                        }
                    } else {
                        dialogFansClubAudienceViewBinding9 = yYFansClubAudienceViewDialog.f17226c;
                        TextView textView6 = dialogFansClubAudienceViewBinding9 == null ? null : dialogFansClubAudienceViewBinding9.r;
                        if (textView6 != null) {
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
                            String string3 = yYFansClubAudienceViewDialog.getString(R.string.yy_fans_intimacy);
                            Intrinsics.c(string3, "getString(R.string.yy_fans_intimacy)");
                            String format3 = String.format(string3, Arrays.copyOf(new Object[]{yYClubLevelInfoModel.score, yYClubLevelInfoModel.gap_score}, 2));
                            Intrinsics.c(format3, "format(format, *args)");
                            textView6.setText(format3);
                        }
                    }
                    dialogFansClubAudienceViewBinding10 = yYFansClubAudienceViewDialog.f17226c;
                    TextView textView7 = dialogFansClubAudienceViewBinding10 == null ? null : dialogFansClubAudienceViewBinding10.p;
                    if (textView7 != null) {
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.f42549a;
                        String string4 = yYFansClubAudienceViewDialog.getString(R.string.yy_fans_consumption);
                        Intrinsics.c(string4, "getString(R.string.yy_fans_consumption)");
                        String format4 = String.format(string4, Arrays.copyOf(new Object[]{yYClubLevelInfoModel.score}, 1));
                        Intrinsics.c(format4, "format(format, *args)");
                        textView7.setText(format4);
                    }
                }
                ChatRoomProtos.Event event = ChatRoomProtos.Event.CHAT_ROOM_FANS_PANEL_SHOW;
                YYRoomModel h = yYFansClubAudienceViewDialog.h();
                String str4 = h == null ? null : h.room_id;
                YYRoomModel h2 = yYFansClubAudienceViewDialog.h();
                String str5 = h2 == null ? null : h2.uid;
                YYUserInfo g2 = yYFansClubAudienceViewDialog.g();
                if (g2 != null) {
                    str = g2.getUid();
                }
                EventTrackYY.a(event, str4, str5, str, ChatRoomProtos.UserType.FANS_USER);
            }
        }, a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        YYUserInfo g = g();
        YYRoomHttpUtils.j(g == null ? null : g.getUid(), String.valueOf(this.e), (BluedUIHttpResponse) new YYFansClubAudienceViewDialog$getMemberList$1(this, a()), a());
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public BaseFragment f() {
        return this.f17225a;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public YYUserInfo g() {
        return this.b;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public View j() {
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding = this.f17226c;
        return dialogFansClubAudienceViewBinding == null ? null : dialogFansClubAudienceViewBinding.e;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog
    public View k() {
        DialogFansClubAudienceViewBinding dialogFansClubAudienceViewBinding = this.f17226c;
        if (dialogFansClubAudienceViewBinding == null) {
            return null;
        }
        return dialogFansClubAudienceViewBinding.b;
    }

    @Override // com.blued.android.module.yy_china.fragment.YYBaseFansDialog, com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        o();
        p();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.dialog_fans_club_audience_view, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…ce_view, container, true)");
        this.f17226c = DialogFansClubAudienceViewBinding.a(inflate);
        l();
        return inflate;
    }
}
