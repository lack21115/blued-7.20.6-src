package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.area.AreaUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.menu.ActionSheet;
import com.blued.android.module.common.widget.menu.CommonShowBottomWindow;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.io.File;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/UserQrFragment.class */
public class UserQrFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f34065a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f34066c;
    private ImageView d;
    private Dialog e;
    private RelativeLayout f;

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    private void a() {
        this.e = DialogUtils.a(this.f34065a);
        this.f = (RelativeLayout) this.b.findViewById(R.id.sava_view);
        this.f34066c = (ImageView) this.b.findViewById(R.id.my_qr_img);
        this.d = (ImageView) this.b.findViewById(2131364726);
        this.f34066c.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.user.fragment.UserQrFragment.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                UserQrFragment.this.b();
                return false;
            }
        });
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        commonTopTitleNoTrans.a();
        commonTopTitleNoTrans.setCenterText(getString(R.string.qr_card));
        commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.UserQrFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                UserQrFragment.this.getActivity().finish();
            }
        });
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).c().a((ImageView) this.b.findViewById(2131364232));
        String str = getActivity().getFilesDir() + BridgeUtil.SPLIT_MARK + UserInfo.getInstance().getLoginUserInfo().getUid() + ".bmp";
        if (new File(str).exists()) {
            this.f34066c.setImageBitmap(BitmapUtils.a(str));
        }
        TextView textView = (TextView) this.b.findViewById(R.id.qr_tv_my_name);
        textView.setText(UserInfo.getInstance().getLoginUserInfo().getName());
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = UserInfo.getInstance().getLoginUserInfo().vip_grade;
        userBasicModel.is_vip_annual = UserInfo.getInstance().getLoginUserInfo().is_vip_annual;
        userBasicModel.is_hide_vip_look = BluedConfig.a().h().is_hide_vip_look;
        UserRelationshipUtils.a(this.f34065a, textView, userBasicModel);
        UserRelationshipUtils.a(this.d, userBasicModel);
        TextView textView2 = (TextView) this.b.findViewById(R.id.qr_tv_my_description);
        textView2.setText(AreaUtils.getAreaTxt(UserInfo.getInstance().getLoginUserInfo().getCity_settled(), BlueAppLocal.c()));
        userBasicModel.is_hide_city_settled = UserInfo.getInstance().getLoginUserInfo().is_hide_city_settled;
        TypefaceUtils.b(this.f34065a, textView2, userBasicModel.is_hide_city_settled, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        CommonShowBottomWindow.a(getActivity(), new String[]{getActivity().getString(R.string.qr_save)}, new ActionSheet.ActionSheetListener() { // from class: com.soft.blued.ui.user.fragment.UserQrFragment.3
            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, int i) {
                if (i != 0) {
                    return;
                }
                UserQrFragment userQrFragment = UserQrFragment.this;
                ImageUtils.a(userQrFragment.a(userQrFragment.f));
            }

            @Override // com.blued.android.module.common.widget.menu.ActionSheet.ActionSheetListener
            public void a(ActionSheet actionSheet, boolean z) {
            }
        });
    }

    private void c() {
        UserHttpUtils.a(this.f34065a, new BinaryHttpResponseHandler(true) { // from class: com.soft.blued.ui.user.fragment.UserQrFragment.4
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onFailure(Throwable th, int i, byte[] bArr) {
                super.onFailure(th, i, bArr);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(byte[] bArr) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                UserQrFragment.this.f34066c.setImageBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                BitmapUtils.a(UserQrFragment.this.getActivity().getFilesDir() + BridgeUtil.SPLIT_MARK + UserInfo.getInstance().getLoginUserInfo().getUid() + ".bmp", decodeByteArray, 100, true);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                super.onFinish();
                DialogUtils.b(UserQrFragment.this.e);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onStart() {
                super.onStart();
                DialogUtils.a(UserQrFragment.this.e);
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f34065a = getActivity();
        View view = this.b;
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.fragment_my_qr, viewGroup, false);
            this.b = inflate;
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(2131364048);
            a();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
