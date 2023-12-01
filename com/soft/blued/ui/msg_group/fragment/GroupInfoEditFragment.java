package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.OnClick;
import com.amap.api.services.district.DistrictSearchQuery;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.group.GroupCategoryModel;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.msg_group.viewmodel.GroupCreateViewModel;
import com.soft.blued.utils.BluedPreferences;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupInfoEditFragment.class */
public class GroupInfoEditFragment extends MvpFragment<MvpPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private GroupCreateViewModel f32677a;
    private GroupInfoModel b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32678c;
    @BindView
    View category_dot;
    private Map<String, String> d = new HashMap();
    private String e = "";
    private GroupCategoryModel f;
    @BindView
    FrameLayout fm_auditing;
    @BindView
    ImageView iv_attention;
    @BindView
    ImageView iv_icon;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    TextView tv_classify;
    @BindView
    TextView tv_description;
    @BindView
    TextView tv_group_location;
    @BindView
    TextView tv_group_name;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.9
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
                GroupInfoEditFragment.this.n();
                AppMethods.d(2131886544);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                GroupInfoEditFragment.this.d.put("group_cover", str2);
                GroupInfoEditFragment.this.v();
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    private void b() {
        GroupInfoModel groupInfoModel = this.b;
        boolean z = true;
        if (groupInfoModel == null) {
            if (this.iv_icon.getTag() == null || TextUtils.isEmpty(this.tv_description.getText().toString()) || TextUtils.isEmpty(this.tv_group_name.getText().toString()) || this.f == null) {
                z = false;
            }
            this.f32678c = z;
        } else {
            this.f32678c = this.iv_icon.getTag() != null || ((!TextUtils.isEmpty(groupInfoModel.group_desc) ? this.b.group_desc.equals(this.tv_description.getText().toString()) : TextUtils.isEmpty(this.tv_description.getText().toString())) ^ true) || ((!TextUtils.isEmpty(this.b.group_title) ? this.b.group_title.equals(this.tv_group_name.getText().toString()) : TextUtils.isEmpty(this.tv_group_name.getText().toString())) ^ true);
            if (this.f == null && TextUtils.isEmpty(this.b.category_zh)) {
                this.f32678c = false;
            } else {
                boolean z2 = true;
                if (!this.f32678c) {
                    z2 = c();
                }
                this.f32678c = z2;
            }
        }
        if (this.f32678c) {
            this.title.getRightTextView().setVisibility(0);
        } else {
            this.title.getRightTextView().setVisibility(4);
        }
    }

    private boolean c() {
        boolean z = false;
        if (this.f != null || TextUtils.isEmpty(this.b.category_zh)) {
            if ((this.f != null && TextUtils.isEmpty(this.b.category_zh)) || this.f.getId() != this.b.category) {
                z = true;
            }
            return z;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.d.clear();
        GroupInfoModel groupInfoModel = this.b;
        if (groupInfoModel == null) {
            if (this.iv_icon.getTag() == null || TextUtils.isEmpty(this.tv_description.getText().toString()) || TextUtils.isEmpty(this.tv_group_name.getText().toString()) || this.f == null) {
                ToastUtils.a(getString(R.string.group_create_dialog_error_toast));
                return;
            }
            this.d.put("group_desc", this.tv_description.getText().toString());
            this.d.put("group_title", this.tv_group_name.getText().toString());
            this.d.put(DistrictSearchQuery.KEYWORDS_CITY, this.e);
            Map<String, String> map = this.d;
            map.put("category", this.f.getId() + "");
        } else if (this.f == null && TextUtils.isEmpty(groupInfoModel.category_zh)) {
            ToastUtils.a(getString(R.string.group_create_dialog_error_toast));
            return;
        } else {
            if (!this.tv_description.getText().toString().equals(this.b.group_desc) || !this.tv_group_name.getText().toString().equals(this.b.group_title)) {
                this.d.put("group_desc", this.tv_description.getText().toString());
                this.d.put("group_title", this.tv_group_name.getText().toString());
            }
            if (c()) {
                Map<String, String> map2 = this.d;
                map2.put("category", this.f.getId() + "");
            }
        }
        if (this.iv_icon.getTag() != null) {
            e();
        } else {
            v();
        }
    }

    private void e() {
        CommunityHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedAlbum> parseData(String str) {
                BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                            GroupInfoEditFragment.this.a((String) GroupInfoEditFragment.this.iv_icon.getTag(), bluedEntityA.data.get(0));
                            return bluedEntityA;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return bluedEntityA;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                AppMethods.d(2131886544);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                GroupInfoEditFragment.this.n();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                GroupInfoEditFragment.this.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                GroupInfoEditFragment.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.b == null) {
            this.d.put("longitude", CommonPreferences.u());
            this.d.put("latitude", CommonPreferences.v());
            this.f32677a.a(this.d);
            return;
        }
        ActivityFragmentActive fragmentActive = getFragmentActive();
        MsgGroupHttpUtils.a(fragmentActive, this.b.group_id + "", this.d, new BluedUIHttpResponse<BluedEntityA>(getFragmentActive()) { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA bluedEntityA) {
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    AppMethods.a((CharSequence) GroupInfoEditFragment.this.getString(R.string.group_submitted));
                    LiveEventBus.get("modify_group_info").post(null);
                    GroupInfoEditFragment.this.t();
                }
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        if (getArguments() != null) {
            this.b = (GroupInfoModel) getArguments().getSerializable(d.K);
            this.f = (GroupCategoryModel) getArguments().getSerializable("key_data");
        }
        GroupCreateViewModel groupCreateViewModel = (GroupCreateViewModel) new ViewModelProvider(this).get(GroupCreateViewModel.class);
        this.f32677a = groupCreateViewModel;
        groupCreateViewModel.d().observe(this, new Observer<GroupInfoModel>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(GroupInfoModel groupInfoModel) {
                Context context = GroupInfoEditFragment.this.getContext();
                GroupInfoFragment.a(context, groupInfoModel.group_id + "", (GroupInfoModel) null, SocialNetWorkProtos.SourceType.UNKNOWN_SOURCE_TYPE);
                GroupInfoEditFragment.this.t();
            }
        });
        this.f32677a.e().observe(this, new Observer<String>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                GroupInfoEditFragment.this.e = str;
                GroupInfoEditFragment.this.tv_group_location.setText(AreaUtils.getAreaTxt(GroupInfoEditFragment.this.e, BlueAppLocal.c()));
            }
        });
        if (this.b == null) {
            this.title.setCenterText(getString(R.string.group_fill_info));
        } else {
            this.title.setCenterText(getString(R.string.group_edit_info_title));
        }
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupInfoEditFragment.this.t();
            }
        });
        this.title.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (GroupInfoEditFragment.this.b == null) {
                    CommonAlertDialog.a(GroupInfoEditFragment.this.getContext(), GroupInfoEditFragment.this.getString(R.string.group_confirm_create), GroupInfoEditFragment.this.getString(R.string.group_create_dialog_hint), GroupInfoEditFragment.this.getString(R.string.group_create_dialog_confirm), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.4.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            GroupInfoEditFragment.this.d();
                        }
                    }, GroupInfoEditFragment.this.getString(R.string.group_create_dialog_back), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.4.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            dialogInterface.dismiss();
                        }
                    }, (DialogInterface.OnDismissListener) null);
                } else {
                    GroupInfoEditFragment.this.d();
                }
            }
        });
        if (this.b != null) {
            this.title.setRightText(getString(R.string.live_apply_improve_submit));
            this.tv_description.setText(this.b.group_desc);
            this.tv_group_name.setText(this.b.group_title);
            ImageLoader.a(getFragmentActive(), this.b.group_cover).c().a(this.iv_icon);
            if (this.b.group_role == 1 && this.b.auditing == 1) {
                this.fm_auditing.setVisibility(0);
                this.fm_auditing.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        GroupUtil.a(GroupInfoEditFragment.this.getContext());
                    }
                });
            }
            this.tv_group_location.setText(this.b.city);
            if (!TextUtils.isEmpty(this.b.category_zh)) {
                this.tv_classify.setText(this.b.category_zh);
            } else if (!BluedPreferences.fl()) {
                this.category_dot.setVisibility(0);
            }
        } else {
            this.title.setRightText(getString(R.string.group_submit_create));
            GroupCategoryModel groupCategoryModel = this.f;
            if (groupCategoryModel != null) {
                this.tv_classify.setText(groupCategoryModel.getName());
            }
        }
        this.iv_attention.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                GroupUtil.a(GroupInfoEditFragment.this.getContext(), GroupInfoEditFragment.this.getString(R.string.group_about_location), GroupInfoEditFragment.this.getString(R.string.group_about_location_hint));
            }
        });
        this.title.getRightTextView().setVisibility(4);
        this.f32677a.f();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fm_msg_group_edit_info;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && i2 == -1) {
            if (i == 1) {
                String stringExtra = intent.getStringExtra("string_edit");
                if (!TextUtils.isEmpty(stringExtra)) {
                    this.tv_description.setText(stringExtra);
                }
            } else if (i == 0) {
                String stringExtra2 = intent.getStringExtra("string_edit");
                if (!TextUtils.isEmpty(stringExtra2)) {
                    this.tv_group_name.setText(stringExtra2);
                }
            } else if (i == 2) {
                String stringExtra3 = intent.getStringExtra("photo_path");
                ImageLoader.d(getFragmentActive(), stringExtra3).c().a(this.iv_icon);
                this.iv_icon.setTag(stringExtra3);
            }
            if (intent.hasExtra("key_data")) {
                GroupCategoryModel groupCategoryModel = (GroupCategoryModel) intent.getSerializableExtra("key_data");
                this.f = groupCategoryModel;
                if (groupCategoryModel != null) {
                    this.tv_classify.setText(groupCategoryModel.getName());
                }
            }
            b();
        }
    }

    @OnClick
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cl_classify /* 2131362885 */:
                GroupCategoryFragment.b.a(this, 1, this.f);
                if (this.category_dot.getVisibility() == 0) {
                    this.category_dot.setVisibility(8);
                    BluedPreferences.fk();
                    return;
                }
                return;
            case R.id.cl_describe /* 2131362890 */:
                CommonWriteTextFragment.a(this, "256", this.tv_description.getText().toString(), null, getString(R.string.group_intro_modification), 1);
                return;
            case R.id.cl_group_name /* 2131362898 */:
                CommonWriteTextFragment.a(this, BaseWrapper.ENTER_ID_SYSTEM_HELPER, this.tv_group_name.getText().toString(), null, getString(R.string.group_edit_name), 0);
                return;
            case R.id.cl_icon /* 2131362907 */:
                PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg_group.fragment.GroupInfoEditFragment.7
                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void U_() {
                        PhotoSelectFragment.a(GroupInfoEditFragment.this, 3, 2);
                    }

                    @Override // com.blued.android.framework.permission.PermissionCallbacks
                    public void a(String[] strArr) {
                    }
                });
                return;
            default:
                return;
        }
    }
}
