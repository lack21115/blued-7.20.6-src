package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.fragment.DependentVIPSelectedFragment;
import com.soft.blued.ui.find.fragment.FilterDialogFragment;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.group.UserGroupListsFragment;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.setting.fragment.BlacklistFragment;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.SpecialCareDialogFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.VIPCustomizedFragment;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.ui.user.observer.FollowAndFansSelectedTabObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPRightOptionNewAdapter.class */
public final class VIPRightOptionNewAdapter extends BaseQuickAdapter<VIPRightOption, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f33810a;
    private final ActivityFragmentActive b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33811c;
    private final FragmentManager d;
    private final VIPCenterTabPageViewModel e;
    private boolean f;
    private String g;
    private int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPRightOptionNewAdapter(Context context, ActivityFragmentActive fragmentActive, int i, FragmentManager fragmentManager, VIPCenterTabPageViewModel viewModel) {
        super((int) R.layout.item_vip_right_option);
        Intrinsics.e(context, "context");
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(viewModel, "viewModel");
        this.f33810a = context;
        this.b = fragmentActive;
        this.f33811c = i;
        this.d = fragmentManager;
        this.e = viewModel;
        this.g = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedBlackList.privacySettingEntity settingModel, VIPRightOption item, VIPRightOptionNewAdapter this$0, int i, DialogInterface dialogInterface, int i2) {
        Tracker.onClick(dialogInterface, i2);
        Intrinsics.e(settingModel, "$settingModel");
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        settingModel.avatar_location_status = 0;
        settingModel.is_hide_distance = 1;
        item.is_on = 1;
        this$0.notifyItemChanged(i);
        int i3 = this$0.f33811c;
        if (i3 == 1) {
            this$0.g = "vip_center_hide_distance_vip";
            this$0.h = 1;
        } else if (i3 != 2) {
        } else {
            this$0.g = "vip_center_hide_distance_svip";
            this$0.h = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPRightOptionNewAdapter this$0, VIPRightOption item, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final VIPRightOptionNewAdapter this$0, final VIPRightOption item, BaseViewHolder helper, View view) {
        String str;
        String str2;
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        Intrinsics.e(helper, "$helper");
        if (this$0.a(item, helper, helper.getAdapterPosition())) {
            if (item.is_on != 1) {
                if (item.pid == 3) {
                    str2 = this$0.mContext.getResources().getString(R.string.open_half_invisible);
                    Intrinsics.c(str2, "mContext.resources.getSt…ring.open_half_invisible)");
                    String string = this$0.mContext.getResources().getString(R.string.open_half_invisible_alert);
                    Intrinsics.c(string, "mContext.resources.getSt…pen_half_invisible_alert)");
                    str = string;
                } else {
                    str = "";
                    str2 = "";
                }
                if (StringUtils.d(str2) || StringUtils.d(str)) {
                    this$0.a(item);
                } else {
                    CommonAlertDialog.a(this$0.mContext, str2, str, (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$_mMhseEW90Gwy8T0N4VRabmmjOI
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            VIPRightOptionNewAdapter.b(VIPRightOptionNewAdapter.this, item, dialogInterface, i);
                        }
                    }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                }
            } else if (item.pid == 25) {
                CommonAlertDialog.a(this$0.mContext, this$0.mContext.getResources().getString(R.string.hide_vip_icon_title), this$0.mContext.getResources().getString(R.string.hide_vip_icon_desc), (String) null, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$JPvMqERSurD1VuNFmjufuhtYQ-0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        VIPRightOptionNewAdapter.a(VIPRightOptionNewAdapter.this, item, dialogInterface, i);
                    }
                }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            } else {
                this$0.a(item);
            }
            this$0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPRightOption item, BaseViewHolder holder, VIPRightOptionNewAdapter this$0, int i, DialogInterface dialogInterface, int i2) {
        Tracker.onClick(dialogInterface, i2);
        Intrinsics.e(item, "$item");
        Intrinsics.e(holder, "$holder");
        Intrinsics.e(this$0, "this$0");
        item.is_on = 0;
        ((ToggleButton) holder.getView(R.id.tglbtn)).setChecked(false);
        this$0.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
        FollowAndFansSelectedTabObserver.a().b(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VIPRightOptionNewAdapter this$0, VIPRightOption item, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.a(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VIPRightOptionNewAdapter this$0, VIPRightOption item, BaseViewHolder helper, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        Intrinsics.e(helper, "$helper");
        this$0.b(item, helper, helper.getAdapterPosition());
    }

    private final void b(VIPRightOption vIPRightOption, BaseViewHolder baseViewHolder, int i) {
        if (a(vIPRightOption, baseViewHolder, i)) {
            EventTrackVIP.a(UserInfo.getInstance().getLoginUserInfo().vip_grade, this.f33811c, false, vIPRightOption.pid);
            int i2 = vIPRightOption.pid;
            if (i2 == 4) {
                VipInvisibleDialogFragment vipInvisibleDialogFragment = new VipInvisibleDialogFragment();
                if (vipInvisibleDialogFragment.isAdded()) {
                    vipInvisibleDialogFragment.dismiss();
                    return;
                }
                FragmentManager fragmentManager = this.d;
                if (fragmentManager == null) {
                    return;
                }
                vipInvisibleDialogFragment.show(fragmentManager, VIPRightOptionNewAdapter.class.getName());
            } else if (i2 == 5) {
                ModifyUserInfoFragment.a(this.mContext, false);
            } else if (i2 == 12) {
                TerminalActivity.d(this.mContext, VisitHistoryFragment.class, null);
            } else if (i2 == 14) {
                ChangeBluedIconFragment.a(this.mContext, this.f33811c);
            } else if (i2 == 26) {
                DependentVIPSelectedFragment.a(this.mContext);
            } else if (i2 == 28) {
                BluedURIRouterAdapter.goChatAndOpenMsgBox(this.d, this.f33811c);
            } else if (i2 == 34) {
                MyGroupFragmentNew.f32768a.a(this.mContext, null);
            } else if (i2 == 36) {
                SpecialCareDialogFragment specialCareDialogFragment = new SpecialCareDialogFragment();
                if (specialCareDialogFragment.isAdded()) {
                    specialCareDialogFragment.dismiss();
                    return;
                }
                FragmentManager fragmentManager2 = this.d;
                if (fragmentManager2 == null) {
                    return;
                }
                specialCareDialogFragment.show(fragmentManager2, SpecialCareDialogFragment.class.getName());
            } else if (i2 == 31) {
                VIPCustomizedFragment.a(this.mContext, this.f33811c);
            } else if (i2 == 32) {
                EventTrackVIP.a(VipProtos.Event.VIP_CENTER_PHOTO_PENDANT_CLICK, this.f33811c);
                WidgetListFragment.a(this.mContext, this.f33811c, "photo_pendant_vip_center", VipProtos.FromType.PHOTO_PENDANT_OTHER);
            } else {
                switch (i2) {
                    case 7:
                        TerminalActivity.d(this.mContext, BlacklistFragment.class, null);
                        return;
                    case 8:
                        UserGroupListsFragment.a(this.mContext);
                        return;
                    case 9:
                        UserInfoFragmentNew.c(this.mContext, UserInfo.getInstance().getLoginUserInfo().uid, "");
                        return;
                    case 10:
                        ModifyUserInfoFragment.a(this.mContext, false);
                        return;
                    default:
                        switch (i2) {
                            case 21:
                                BluedURIRouterAdapter.openMapFind(this.mContext);
                                return;
                            case 22:
                                FollowedAndFansFragment.a(this.mContext, UserInfo.getInstance().getLoginUserInfo().uid);
                                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$11-zvsqlceQ_pdZZ3N-HF1-qlwc
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        VIPRightOptionNewAdapter.b();
                                    }
                                }, 500L);
                                return;
                            case 23:
                                ChatBgSettingFragment.a(this.mContext, 2);
                                return;
                            case 24:
                                FilterDialogFragment filterDialogFragment = new FilterDialogFragment();
                                Context context = this.mContext;
                                if (context == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                                }
                                filterDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "");
                                return;
                            default:
                                return;
                        }
                }
            }
        }
    }

    public final int a() {
        return this.f33811c;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void a(int i, final int i2) {
        Map<String, String> ajaxParms = BluedHttpTools.a();
        if (i == 5) {
            Intrinsics.c(ajaxParms, "ajaxParms");
            ajaxParms.put("is_show_vip_page", i2 + "");
            UserHttpUtils.a(this.mContext, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.user.adapter.VIPRightOptionNewAdapter$setChecked$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(null);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    UserInfo.getInstance().getLoginUserInfo().is_show_vip_page = i2;
                }
            }, UserInfo.getInstance().getLoginUserInfo().uid, ajaxParms, (IRequestHost) null);
            return;
        }
        if (i == 0) {
            Intrinsics.c(ajaxParms, "ajaxParms");
            ajaxParms.put("is_hide_last_operate", i2 + "");
        } else if (i == 1) {
            Intrinsics.c(ajaxParms, "ajaxParms");
            ajaxParms.put("is_hide_distance", i2 + "");
        } else if (i != 2) {
            if (i == 3) {
                Intrinsics.c(ajaxParms, "ajaxParms");
                ajaxParms.put("is_invisible_half", i2 + "");
                if (i2 == 1) {
                    ajaxParms.put("stealth_distance", BluedPreferences.ab());
                    ajaxParms.put("is_invisible_all", "0");
                }
            } else if (i == 4) {
                Intrinsics.c(ajaxParms, "ajaxParms");
                ajaxParms.put("is_invisible_all", i2 + "");
                if (i2 == 1) {
                    ajaxParms.put("is_invisible_half", "0");
                }
            } else if (i == 11) {
                Intrinsics.c(ajaxParms, "ajaxParms");
                ajaxParms.put("is_traceless_access", i2 + "");
            } else if (i == 13) {
                Intrinsics.c(ajaxParms, "ajaxParms");
                ajaxParms.put("is_global_view_secretly", i2 + "");
                BluedPreferences.B(i2 == 1);
                BluedPreferences.Y(i2 != 1);
            } else if (i == 25) {
                Intrinsics.c(ajaxParms, "ajaxParms");
                ajaxParms.put(ReqAckPackage.REQ_RESPONSE_KEY.IS_HIDE_VIP_LOOK, i2 != 1 ? "1" : "0");
            } else if (i == 27) {
                Intrinsics.c(ajaxParms, "ajaxParms");
                ajaxParms.put("is_filter_ads", i2 + "");
            }
        } else {
            Intrinsics.c(ajaxParms, "ajaxParms");
            ajaxParms.put("is_hide_city_settled", i2 + "");
        }
        final ActivityFragmentActive activityFragmentActive = this.b;
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(activityFragmentActive) { // from class: com.soft.blued.ui.user.adapter.VIPRightOptionNewAdapter$setChecked$2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                BluedConfig.a().c();
            }
        }, UserInfo.getInstance().getLoginUserInfo().uid, ajaxParms);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, final VIPRightOption item) {
        String str;
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageView imageView = (ImageView) helper.getView(2131365763);
        if (this.f33811c == 2) {
            str = item.icon_svip;
            Intrinsics.c(str, "item.icon_svip");
        } else {
            str = item.icon_vip;
            Intrinsics.c(str, "item.icon_vip");
        }
        ImageLoader.a(this.b, str).a(imageView);
        helper.setText(2131372299, item.title);
        helper.setText(2131372298, item.description);
        boolean z = true;
        if (item.getRightType() != 0) {
            helper.getView(R.id.tglbtn).setVisibility(4);
            helper.setGone(2131365072, true);
            ((LinearLayout) helper.getView(R.id.ll_item)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$_T0EWblP_9Gc2sU6f2oRKaygZxU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VIPRightOptionNewAdapter.b(VIPRightOptionNewAdapter.this, item, helper, view);
                }
            });
            return;
        }
        helper.setGone(R.id.tglbtn, true);
        helper.setGone(2131365072, false);
        ToggleButton toggleButton = (ToggleButton) helper.getView(R.id.tglbtn);
        if (item.is_on != 1) {
            z = false;
        }
        toggleButton.setChecked(z);
        ((LinearLayout) helper.getView(R.id.ll_item)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$8v4czm5R1WXmxP_wwnTETKDb228
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPRightOptionNewAdapter.a(view);
            }
        });
        toggleButton.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$szTQc_zRxbmR8bfqECF7qf_VgTg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPRightOptionNewAdapter.a(VIPRightOptionNewAdapter.this, item, helper, view);
            }
        });
    }

    public final void a(VIPRightOption rightOption) {
        Intrinsics.e(rightOption, "rightOption");
        rightOption.is_on = rightOption.is_on == 1 ? 0 : 1;
        a(rightOption.pid, rightOption.is_on);
        notifyDataSetChanged();
        boolean z = false;
        if (rightOption.is_on == 1) {
            z = false;
            if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                z = true;
            }
        }
        EventTrackVIP.a(UserInfo.getInstance().getLoginUserInfo().vip_grade, this.f33811c, z, rightOption.pid);
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.g = str;
    }

    public final void a(List<? extends VIPRightOption> datas) {
        Intrinsics.e(datas, "datas");
        if (datas.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (VIPRightOption vIPRightOption : datas) {
                vIPRightOption.is_on = VIPRightOption.getOnOffStatus(vIPRightOption.pid);
                if (this.f33811c == 2) {
                    arrayList.add(vIPRightOption);
                } else if (vIPRightOption.is_svip == 0) {
                    arrayList.add(vIPRightOption);
                }
            }
            setNewData(arrayList);
        }
        notifyDataSetChanged();
    }

    public final boolean a(final VIPRightOption item, final BaseViewHolder holder, final int i) {
        final BluedBlackList.privacySettingEntity b;
        Intrinsics.e(item, "item");
        Intrinsics.e(holder, "holder");
        int i2 = item.pid;
        if (i2 == 0) {
            if (BluedConfig.a().g().is_hide_last_operate == 1) {
                this.f = true;
            }
            int i3 = this.f33811c;
            if (i3 == 1) {
                this.g = "vip_center_hide_time_vip";
                this.h = 1;
            } else if (i3 == 2) {
                this.g = "vip_center_hide_time_svip";
                this.h = 2;
            }
        } else if (i2 == 1) {
            if (BluedConfig.a().g().is_hide_distance == 1) {
                this.f = true;
            }
            VIPCenterTabPageViewModel vIPCenterTabPageViewModel = this.e;
            if (vIPCenterTabPageViewModel != null && (b = vIPCenterTabPageViewModel.b()) != null) {
                if (b.avatar_location_status == 1 && b.is_hide_distance == 0 && UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                    CommonAlertDialog.a(this.mContext, this.mContext.getResources().getString(R.string.call_open_pop_title), this.mContext.getResources().getString(R.string.close_the_location_and_open_hide_distance), this.mContext.getResources().getString(R.string.close_now), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$_C-NvS_qQCTwucgqVNOacphiMdc
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            VIPRightOptionNewAdapter.a(BluedBlackList.privacySettingEntity.this, item, this, i, dialogInterface, i4);
                        }
                    }, this.mContext.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPRightOptionNewAdapter$NgYS-4NaVV7NmqxSx2DlFGr8ay8
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            VIPRightOptionNewAdapter.a(VIPRightOption.this, holder, this, i, dialogInterface, i4);
                        }
                    }, (DialogInterface.OnDismissListener) null);
                } else if (a() == 2) {
                    a("vip_center_hide_distance_svip");
                    a(2);
                } else {
                    a("vip_center_hide_distance_vip");
                    a(1);
                }
            }
        } else if (i2 == 3) {
            if (BluedConfig.a().g().is_invisible_half == 1) {
                this.f = true;
            }
            int i4 = this.f33811c;
            if (i4 == 1) {
                this.g = "vip_center_half_hide_vip";
                this.h = 1;
            } else if (i4 == 2) {
                this.g = "vip_center_half_hide_svip";
                this.h = 2;
            }
        } else if (i2 == 4) {
            this.f = true;
        } else if (i2 == 5) {
            if (BluedConfig.a().g().is_show_vip_page == 1) {
                this.f = true;
            }
            int i5 = this.f33811c;
            if (i5 == 1) {
                this.g = "vip_center_personal_hom_vip";
                this.h = 1;
            } else if (i5 == 2) {
                this.g = "vip_center_personal_hom_svip";
                this.h = 2;
            }
        } else if (i2 == 7) {
            if (BluedConfig.a().g().is_improve_backlist == 1) {
                this.f = true;
            }
            int i6 = this.f33811c;
            if (i6 == 1) {
                this.g = "blacklist_expand";
                this.h = 1;
            } else if (i6 == 2) {
                this.g = "blacklist_expand";
                this.h = 2;
            }
        } else if (i2 == 9) {
            if (BluedConfig.a().g().is_top_feed_views == 1) {
                this.f = true;
            }
            int i7 = this.f33811c;
            if (i7 == 1) {
                this.g = "vip_center_feed_top_vip";
                this.h = 1;
            } else if (i7 == 2) {
                this.g = "vip_center_feed_top_svip";
                this.h = 2;
            }
        } else if (i2 == 31) {
            this.f = true;
        } else if (i2 == 36) {
            this.f = true;
        } else if (i2 == 33) {
            this.f = true;
        } else if (i2 != 34) {
            switch (i2) {
                case 11:
                    if (BluedConfig.a().g().is_traceless_access == 1) {
                        this.f = true;
                    }
                    if (this.f33811c == 2) {
                        this.g = "vip_center_no_trace_visit_svip";
                        this.h = 2;
                        break;
                    }
                    break;
                case 12:
                    if (BluedConfig.a().g().is_advanced_recently_view == 1) {
                        this.f = true;
                    }
                    int i8 = this.f33811c;
                    if (i8 == 1) {
                        this.g = "vip_center_super_visit_vip";
                        this.h = 1;
                        break;
                    } else if (i8 == 2) {
                        this.g = "vip_center_super_visit_svip";
                        this.h = 2;
                        break;
                    }
                    break;
                case 13:
                    if (BluedConfig.a().g().is_global_view_secretly == 1) {
                        this.f = true;
                    }
                    if (this.f33811c == 2) {
                        this.g = "vip_center_quiety_see_svip";
                        this.h = 2;
                        break;
                    }
                    break;
                case 14:
                    if (BluedConfig.a().g().is_change_blued_icon == 1) {
                        this.f = true;
                    }
                    int i9 = this.f33811c;
                    if (i9 == 1) {
                        this.g = "vip_center_change_logo_vip";
                        this.h = 1;
                        break;
                    } else if (i9 == 2) {
                        this.g = "vip_center_change_logo_svip";
                        this.h = 2;
                        break;
                    }
                    break;
                default:
                    switch (i2) {
                        case 21:
                            if (BluedConfig.a().g().is_find_on_map == 1) {
                                this.f = true;
                            }
                            int i10 = this.f33811c;
                            if (i10 == 1) {
                                this.g = "vip_center_map_find_vip";
                                this.h = 1;
                                break;
                            } else if (i10 == 2) {
                                this.g = "vip_center_map_find_svip";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 22:
                            if (BluedConfig.a().g().is_secretly_followed == 1) {
                                this.f = true;
                            }
                            if (this.f33811c == 2) {
                                this.g = "vip_center_quietly_follow_svip";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 23:
                            if (BluedConfig.a().g().is_chat_backgrounds == 1) {
                                this.f = true;
                            }
                            int i11 = this.f33811c;
                            if (i11 == 1) {
                                this.g = "chat_customize_bg";
                                this.h = 1;
                                break;
                            } else if (i11 == 2) {
                                this.g = "chat_customize_bg";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 24:
                            if (BluedConfig.a().g().is_filter_vip == 1) {
                                this.f = true;
                            }
                            int i12 = this.f33811c;
                            if (i12 == 1) {
                                this.g = "vip_center_super_filter_vip";
                                this.h = 1;
                                break;
                            } else if (i12 == 2) {
                                this.g = "vip_center_super_filter_svip";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 25:
                            if (BluedConfig.a().g().is_hide_vip_look == 1) {
                                this.f = true;
                            }
                            int i13 = this.f33811c;
                            if (i13 == 1) {
                                this.g = "vip_center_logo_vip";
                                this.h = 1;
                                break;
                            } else if (i13 == 2) {
                                this.g = "vip_center_logo_svip";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 26:
                            if (BluedConfig.a().g().is_vip_select == 1) {
                                this.f = true;
                            }
                            if (this.f33811c == 2) {
                                this.g = "vip_center_featured_svip";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 27:
                            if (BluedConfig.a().g().is_filter_ads == 1) {
                                this.f = true;
                            }
                            if (this.f33811c == 2) {
                                this.g = "vip_center_no_ad_svip";
                                this.h = 2;
                                break;
                            }
                            break;
                        case 28:
                            this.f = true;
                            break;
                    }
            }
        } else {
            this.f = true;
        }
        if (!this.f) {
            EventTrackVIP.a(UserInfo.getInstance().getLoginUserInfo().vip_grade, this.f33811c, false, item.pid);
            PayUtils.a(this.mContext, this.h, this.g, item.pid, VipProtos.FromType.UNKNOWN_FROM);
        }
        return this.f;
    }

    public final Context getContext() {
        return this.f33810a;
    }
}
