package com.blued.community.ui.circle.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.menu.BottomMenuPop;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.circle.presenter.CircleInfoSettingPresenter;
import com.blued.community.view.EditInputNumView;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleInfoSettingFragment.class */
public class CircleInfoSettingFragment extends MvpKeyBoardFragment<CircleInfoSettingPresenter> {
    private Dialog k;
    private KeyboardListenLinearLayout l;
    private CommonTopTitleNoTrans m;
    private LinearLayout n;
    private ImageView o;
    private FrameLayout p;
    private TextView q;
    private EditText r;
    private EditInputNumView s;
    private boolean t = false;
    private TextWatcher u = new TextWatcher() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.7
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.equals(editable.toString(), ((CircleInfoSettingPresenter) CircleInfoSettingFragment.this.j()).p())) {
                CircleInfoSettingFragment.this.t = true;
            }
            CircleInfoSettingFragment.this.x();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };

    public static void a(Context context, MyCircleModel myCircleModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("circle_data", myCircleModel);
        TerminalActivity.d(context, CircleInfoSettingFragment.class, bundle);
    }

    private void v() {
        this.l = (KeyboardListenLinearLayout) this.i.findViewById(R.id.keyboard_layout);
        this.m = (CommonTopTitleNoTrans) this.i.findViewById(R.id.title);
        this.n = (LinearLayout) this.i.findViewById(R.id.ll_header);
        this.o = (ImageView) this.i.findViewById(R.id.iv_header);
        this.p = (FrameLayout) this.i.findViewById(R.id.fl_header_bottom);
        this.q = (TextView) this.i.findViewById(R.id.tv_edit);
        this.r = (EditText) this.i.findViewById(R.id.edt_info);
        this.s = this.i.findViewById(R.id.inv_word_count);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        ArrayList arrayList = new ArrayList();
        final BasePopupView a = CommonShowBottomWindow.a(getContext(), arrayList);
        BottomMenuPop.MenuItemInfo menuItemInfo = new BottomMenuPop.MenuItemInfo();
        menuItemInfo.a = getContext().getString(R.string.head_pic_update);
        menuItemInfo.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommunityServiceManager.b().a(CircleInfoSettingFragment.this, 15, 177);
                BasePopupView basePopupView = a;
                if (basePopupView != null) {
                    basePopupView.p();
                }
            }
        };
        BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
        menuItemInfo2.a = getContext().getString(R.string.head_pic_view);
        menuItemInfo2.d = new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CommunityServiceManager.b().a(CircleInfoSettingFragment.this.getContext(), new String[]{((CircleInfoSettingPresenter) CircleInfoSettingFragment.this.j()).o()}, 0, 3, (LoadOptions) null);
                BasePopupView basePopupView = a;
                if (basePopupView != null) {
                    basePopupView.p();
                }
            }
        };
        arrayList.add(menuItemInfo);
        arrayList.add(menuItemInfo2);
        a.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (y()) {
            this.m.getRightTextView().setAlpha(1.0f);
            this.m.getRightTextView().setEnabled(true);
            return;
        }
        this.m.getRightTextView().setAlpha(0.3f);
        this.m.getRightTextView().setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y() {
        return this.t || ((CircleInfoSettingPresenter) j()).q();
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment
    public void a(int i) {
        if (i != -3) {
            if (i != -2) {
                return;
            }
            this.s.setVisibility(8);
            return;
        }
        this.s.setVisibility(0);
        this.r.setFocusable(true);
        this.r.setFocusableInTouchMode(true);
        this.r.requestFocus();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        v();
        a(this.l);
        this.k = DialogUtils.a(getContext());
        this.m.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CircleInfoSettingFragment.this.t();
            }
        });
        this.m.setRightTextColor(R.color.syc_a);
        this.m.getRightTextView().setAlpha(0.3f);
        this.m.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackFeed.h(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK, ((CircleInfoSettingPresenter) CircleInfoSettingFragment.this.j()).n());
                if (CircleInfoSettingFragment.this.y()) {
                    String obj = CircleInfoSettingFragment.this.r.getText().toString();
                    if (obj.length() >= 15) {
                        ((CircleInfoSettingPresenter) CircleInfoSettingFragment.this.j()).d(obj);
                    } else {
                        AppMethods.d(R.string.circle_description_number_less_toast);
                    }
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                KeyboardUtils.a((Activity) CircleInfoSettingFragment.this.getActivity());
                CircleInfoSettingFragment.this.w();
            }
        });
        this.r.setFilters(new InputFilter[]{new InputFilter.LengthFilter(512)});
        this.r.addTextChangedListener(this.u);
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.circle.fragment.CircleInfoSettingFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.s.init(this.r, 512);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(MyCircleModel myCircleModel) {
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, myCircleModel.cover)).b(R.drawable.circle_header_default).a(6.0f).a(this.o);
        this.r.setText(myCircleModel.description);
        EditText editText = this.r;
        editText.setSelection(editText.length());
        if (myCircleModel.cover_is_auditing == 1) {
            this.q.setText(R.string.circle_avatar_auditing);
        } else {
            this.q.setText(R.string.modify);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void a(String str, boolean z) {
        super.a(str, z);
        if ("upload_photo".equals(str)) {
            DialogUtils.b(this.k);
        }
    }

    @Override // com.blued.android.framework.ui.custom.MvpKeyBoardFragment, com.blued.android.framework.ui.mvp.MvpFragment
    public void af_() {
        this.r.removeTextChangedListener(this.u);
        super.af_();
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void f() {
        super.f();
        getActivity().getWindow().setSoftInputMode(19);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_circle_info_setting;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.framework.ui.mvp.MvpView
    public void g_(String str) {
        super.g_(str);
        if ("upload_photo".equals(str)) {
            DialogUtils.a(this.k);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 177 && intent != null) {
            String stringExtra = intent.getStringExtra("photo_path");
            if (!TextUtils.isEmpty(stringExtra)) {
                ImageLoader.d(getFragmentActive(), stringExtra).a(this.o);
                ((CircleInfoSettingPresenter) j()).f(stringExtra);
                ((CircleInfoSettingPresenter) j()).a(true);
                x();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        KeyboardUtils.a((Activity) getActivity());
        return super.onBackPressed();
    }
}
