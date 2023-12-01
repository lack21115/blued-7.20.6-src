package com.blued.community.ui.topic.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.fragment.FeedAddPostFragment;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.regex.Pattern;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/fragment/CreateSuperTopicFragment.class */
public class CreateSuperTopicFragment extends BaseFragment implements View.OnClickListener {
    InputFilter a = new InputFilter() { // from class: com.blued.community.ui.topic.fragment.CreateSuperTopicFragment.2
        Pattern a = Pattern.compile("[^a-zA-Z0-9\\u4E00-\\u9FA5_]");

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.a.matcher(charSequence).find()) {
                return "";
            }
            return null;
        }
    };
    private Context b;
    private View c;
    private CommonTopTitleNoTrans d;
    private RelativeLayout e;
    private ImageView f;
    private ImageView g;
    private EditText h;
    private Dialog i;
    private String j;

    private void a() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.c.findViewById(R.id.title);
        this.d = commonTopTitleNoTrans;
        commonTopTitleNoTrans.setCenterText(R.string.create_super_topic);
        this.d.setRightText(R.string.community_next_step);
        this.d.setRightTextColor(R.color.syc_k);
        this.d.setRightClickListener(this);
        this.d.setLeftClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.blued.community.ui.topic.fragment.CreateSuperTopicFragment.5
            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2) {
                CreateSuperTopicFragment.this.i.dismiss();
                AppMethods.d(R.string.avatar_upload_error);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, double d) {
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public void a(String str2, String str3) {
                CreateSuperTopicFragment.this.i.dismiss();
                CreateSuperTopicFragment createSuperTopicFragment = CreateSuperTopicFragment.this;
                FeedAddPostFragment.a(createSuperTopicFragment, str2, createSuperTopicFragment.h.getText().toString(), 178);
            }

            @Override // com.blued.android.framework.utils.upload.QiniuUploadTools.QiNiuListener
            public boolean a() {
                return false;
            }
        });
    }

    private void b() {
        this.e = (RelativeLayout) this.c.findViewById(R.id.layout_avatar_tip);
        this.f = (ImageView) this.c.findViewById(R.id.img_avatar);
        this.g = (ImageView) this.c.findViewById(R.id.iv_delete);
        this.h = (EditText) this.c.findViewById(R.id.edt_name);
        ShapeHelper.b((ShapeFrameLayout) this.c.findViewById(R.id.fl_add_name), R.color.syc_x);
        this.c.findViewById(R.id.cl_parent).setOnClickListener(new SingleClickProxy(this));
        this.f.setOnClickListener(new SingleClickProxy(this));
        this.g.setOnClickListener(new SingleClickProxy(this));
        this.h.setFilters(new InputFilter[]{this.a, new InputFilter.LengthFilter(15)});
        this.h.addTextChangedListener(new TextWatcher() { // from class: com.blued.community.ui.topic.fragment.CreateSuperTopicFragment.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                CreateSuperTopicFragment.this.c();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (d()) {
            this.d.setRightTextColor(R.color.syc_h);
        } else {
            this.d.setRightTextColor(R.color.syc_k);
        }
    }

    private boolean d() {
        return (TextUtils.isEmpty(this.j) || TextUtils.isEmpty(this.h.getText().toString())) ? false : true;
    }

    private void e() {
        if (d()) {
            f();
        }
    }

    private void f() {
        FeedHttpUtils.c(new BluedUIHttpResponse<BluedEntity>(getFragmentActive()) { // from class: com.blued.community.ui.topic.fragment.CreateSuperTopicFragment.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                CreateSuperTopicFragment.this.g();
            }
        }, this.h.getText().toString(), getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        CommunityHttpUtils.a((Context) null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(getFragmentActive()) { // from class: com.blued.community.ui.topic.fragment.CreateSuperTopicFragment.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedAlbum> parseData(String str) {
                BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA) super.parseData(str);
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                            CreateSuperTopicFragment.this.a(CreateSuperTopicFragment.this.j, bluedEntityA.data.get(0));
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
                AppMethods.d(R.string.avatar_upload_error);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                CreateSuperTopicFragment.this.i.dismiss();
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                CreateSuperTopicFragment.this.i.show();
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 177) {
                if (i == 178 && intent != null && intent.getBooleanExtra("close_page", false)) {
                    getActivity().finish();
                }
            } else if (intent != null) {
                this.j = intent.getStringExtra("photo_path");
                this.e.setVisibility(8);
                ImageLoader.d(getFragmentActive(), this.j).a(this.f);
                this.g.setVisibility(0);
                c();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ctt_left) {
            EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_CREATE_NEXT_BTN_CLICK);
            getActivity().finish();
        } else if (id == R.id.ctt_right) {
            EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_CREATE_RETURN_BTN_CLICK);
            e();
        } else if (id == R.id.cl_parent) {
            KeyboardUtils.a((Activity) getActivity());
        } else if (id == R.id.img_avatar) {
            CommunityServiceManager.b().a(this, 13, 177);
        } else if (id == R.id.iv_delete) {
            this.j = "";
            this.e.setVisibility(0);
            this.f.setImageDrawable(null);
            this.g.setVisibility(8);
            c();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.b = getActivity();
        View view = this.c;
        if (view == null) {
            this.c = layoutInflater.inflate(R.layout.fragment_create_super_topic, viewGroup, false);
            this.i = DialogUtils.a(this.b);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.c.getParent()).removeView(this.c);
        }
        return this.c;
    }
}
