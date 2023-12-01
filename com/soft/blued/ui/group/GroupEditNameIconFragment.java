package com.soft.blued.ui.group;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.third.QiniuUploadUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/group/GroupEditNameIconFragment.class */
public class GroupEditNameIconFragment extends BaseFragment implements View.OnClickListener {
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f17084c;
    private LinearLayout d;
    private LinearLayout e;
    private ImageView f;
    private LoadOptions g;
    private Dialog h;
    private TextView i;
    private String j;
    private String k;
    private String l;
    private String n;
    private boolean o;
    private boolean p;

    /* renamed from: a  reason: collision with root package name */
    private String f17083a = GroupEditNameIconFragment.class.getSimpleName();
    private String[] m = new String[2];

    private void a(final String str) {
        GroupHttpUtils.a(this.f17084c, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.soft.blued.ui.group.GroupEditNameIconFragment.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                GroupEditNameIconFragment.this.a(str, (BluedAlbum) bluedEntityA.getSingleData());
            }
        }, this.l, (IRequestHost) getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, BluedAlbum bluedAlbum) {
        QiniuUploadUtils.a(str, bluedAlbum, new QiniuUploadTools.QiNiuListener() { // from class: com.soft.blued.ui.group.GroupEditNameIconFragment.2
            public void a(String str2) {
            }

            public void a(String str2, double d) {
            }

            public void a(String str2, String str3) {
                GroupEditNameIconFragment.this.b(str2);
            }

            public boolean a() {
                return false;
            }
        });
    }

    private void b() {
        CommonTopTitleNoTrans findViewById = this.b.findViewById(R.id.top_title);
        findViewById.a();
        findViewById.setCenterText(getString(R.string.group_info));
        findViewById.setLeftClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        GroupHttpUtils.j(this.f17084c, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>() { // from class: com.soft.blued.ui.group.GroupEditNameIconFragment.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedAlbum> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    return;
                }
                ImageLoader.d(GroupEditNameIconFragment.this.getFragmentActive(), GroupEditNameIconFragment.this.n).c().a(GroupEditNameIconFragment.this.f);
                GroupEditNameIconFragment.this.p = true;
            }

            public void onUIFinish() {
                super.onUIFinish();
                DialogUtils.b(GroupEditNameIconFragment.this.h);
            }

            public void onUIStart() {
                super.onUIStart();
                DialogUtils.a(GroupEditNameIconFragment.this.h);
            }
        }, str, this.l, getFragmentActive());
    }

    private void c() {
        this.h = DialogUtils.a(this.f17084c);
        this.m[0] = this.f17084c.getResources().getString(R.string.head_pic_update);
        this.m[1] = this.f17084c.getResources().getString(R.string.head_pic_view);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_groupinfo_edit_icon);
        this.d = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.ll_groupinfo_edit_name);
        this.e = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_group_edit_name);
        this.i = textView;
        textView.setText(this.j);
        this.f = (ImageView) this.b.findViewById(R.id.iv_group_profile_pic);
        if (StringUtils.d(this.k)) {
            this.f.setImageResource(R.drawable.group_default_head);
        } else {
            ImageLoader.a(getFragmentActive(), this.k).c().b(2131237310).a(this.f);
        }
    }

    private void d() {
        if (this.o || this.p) {
            Intent intent = new Intent();
            if (this.o) {
                intent.putExtra("name", this.j);
            }
            if (this.p) {
                intent.putExtra("icon", this.n);
            }
            getActivity().setResult(-1, intent);
        } else {
            getActivity().setResult(-1);
        }
        getActivity().finish();
    }

    public void a() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.l = arguments.getString("gid");
        this.j = arguments.getString("name");
        this.k = arguments.getString("icon");
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 22) {
                if (i != 100) {
                    if (i == 1000) {
                        if (intent != null && !StringUtils.d(intent.getStringExtra("name"))) {
                            this.i.setText(intent.getStringExtra("name"));
                            this.j = intent.getStringExtra("name");
                        }
                        if (i2 == -1) {
                            this.o = true;
                        }
                    }
                } else if (intent != null) {
                    StringUtils.d(intent.getStringExtra("uid"));
                }
            } else if (intent != null) {
                String stringExtra = intent.getStringExtra("photo_path");
                this.n = stringExtra;
                a(stringExtra);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackPressed() {
        d();
        return super.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                d();
                return;
            case R.id.ll_groupinfo_edit_icon /* 2131367879 */:
                if (TextUtils.isEmpty(this.k)) {
                    this.m = r0;
                    String[] strArr = {this.f17084c.getResources().getString(R.string.head_pic_update)};
                } else {
                    String[] strArr2 = new String[2];
                    this.m = strArr2;
                    strArr2[0] = this.f17084c.getResources().getString(R.string.head_pic_update);
                    this.m[1] = this.f17084c.getResources().getString(R.string.head_pic_view);
                }
                CommonShowBottomWindow.a(getActivity(), this.m, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.group.GroupEditNameIconFragment.4
                    public void a(ActionSheet actionSheet, int i) {
                        if (i == 0) {
                            PhotoSelectFragment.a(GroupEditNameIconFragment.this, 3, 22);
                        } else if (GroupEditNameIconFragment.this.p) {
                            BasePhotoFragment.a(GroupEditNameIconFragment.this.f17084c, new String[]{RecyclingUtils.Scheme.c.b(GroupEditNameIconFragment.this.n)}, 0, 2, GroupEditNameIconFragment.this.g);
                        } else if (StringUtils.d(GroupEditNameIconFragment.this.k)) {
                            BasePhotoFragment.a(GroupEditNameIconFragment.this.f17084c, new String[]{null}, 0, 2, GroupEditNameIconFragment.this.g);
                        } else {
                            BasePhotoFragment.a(GroupEditNameIconFragment.this.f17084c, new String[]{GroupEditNameIconFragment.this.k}, 0, 2, GroupEditNameIconFragment.this.g);
                        }
                    }

                    public void a(ActionSheet actionSheet, boolean z) {
                    }
                });
                return;
            case R.id.ll_groupinfo_edit_name /* 2131367880 */:
                Bundle bundle = new Bundle();
                bundle.putString("name", this.j);
                TerminalActivity.a(this, ModifyGroupNameFragment.class, bundle, 1000);
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f17084c = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_group_edit_icon_name, viewGroup, false);
            a();
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
