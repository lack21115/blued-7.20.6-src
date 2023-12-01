package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.module.common.utils.ComplianceUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.ui.send.dialog.PayVIPPopupWindow;
import com.bytedance.applog.tracker.Tracker;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.soft.blued.R;
import com.soft.blued.ui.msg.manager.FlashPhotoManager;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/SendPhotoFragment.class */
public class SendPhotoFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f30014a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f30015c;
    private TextView d;
    private CommonTopTitleNoTrans e;
    private ImageView f;
    private LinearLayout g;
    private String h;
    private ImageView i;
    private PhotoViewAttacher j;
    private ProgressBar k;
    private String l;
    private int m;
    private int n;
    private int o;
    private boolean p = false;

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.h = arguments.getString("photo_path");
            this.l = arguments.getString("msg_path");
            this.p = arguments.getBoolean("KEY_IS_GROUP");
        }
    }

    public static void a(BaseFragment baseFragment, String str, int i, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("photo_path", str);
        bundle.putString("msg_path", str2);
        bundle.putBoolean("KEY_IS_GROUP", z);
        TerminalActivity.a(baseFragment, SendPhotoFragment.class, bundle, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (new File(str).exists()) {
            int[] b = ImageUtils.b(str);
            this.n = b[0];
            this.o = b[1];
        }
    }

    private void b() {
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.b.findViewById(2131370749);
        this.e = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.e.setCenterText(getString(2131891622));
        this.e.setLeftText(2131886885);
        this.e.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.SendPhotoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                SendPhotoFragment.this.getActivity().finish();
            }
        });
        TextView textView = (TextView) this.b.findViewById(2131369700);
        this.f30015c = textView;
        textView.setVisibility(0);
        this.f30015c.setText(this.f30014a.getResources().getString(R.string.send));
        this.i = (ImageView) this.b.findViewById(2131368859);
        this.k = (ProgressBar) this.b.findViewById(2131368385);
        this.f = (ImageView) this.b.findViewById(R.id.destroy_btn);
        this.g = (LinearLayout) this.b.findViewById(R.id.destroy_layout);
        TextView textView2 = (TextView) this.b.findViewById(R.id.tv_photo_burn);
        this.d = textView2;
        textView2.setText(this.f30014a.getString(2131887473) + FlashPhotoManager.a().b().flash_prompt);
        if (this.p) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
        this.j = new PhotoViewAttacher(this.i);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.SendPhotoFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ComplianceUtils.f10878a.a(SendPhotoFragment.this.getContext())) {
                    return;
                }
                if (SendPhotoFragment.this.m == 1) {
                    SendPhotoFragment.this.f.setImageResource(R.drawable.destroy_btn_default);
                    SendPhotoFragment.this.m = 0;
                } else if (FlashPhotoManager.a().b().flash_left_times <= 0) {
                    PayVIPPopupWindow.f19924c.a(SendPhotoFragment.this.f30014a, 1, new DialogInterface.OnDismissListener() { // from class: com.soft.blued.ui.feed.fragment.SendPhotoFragment.2.1
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            TextView textView3 = SendPhotoFragment.this.d;
                            textView3.setText(SendPhotoFragment.this.f30014a.getString(2131887473) + FlashPhotoManager.a().b().flash_prompt);
                        }
                    });
                } else {
                    SendPhotoFragment.this.f.setImageResource(R.drawable.destroy_btn_selected);
                    SendPhotoFragment.this.m = 1;
                }
            }
        });
        this.f30015c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.SendPhotoFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                try {
                    String e = !TextUtils.isEmpty(SendPhotoFragment.this.l) ? SendPhotoFragment.this.l : RecyclingUtils.e("photo");
                    Houyi.a().a(SendPhotoFragment.this.h, e).b();
                    ImageFileLoader.a(SendPhotoFragment.this.getFragmentActive()).c(e).a();
                    SendPhotoFragment.this.a(e);
                    Intent intent = new Intent();
                    intent.putExtra("photo_path", e);
                    intent.putExtra("photo_width", SendPhotoFragment.this.n);
                    intent.putExtra("photo_height", SendPhotoFragment.this.o);
                    intent.putExtra("destroy_switch", SendPhotoFragment.this.m);
                    SendPhotoFragment.this.getActivity().setResult(-1, intent);
                    SendPhotoFragment.this.getActivity().finish();
                } catch (OutOfMemoryError e2) {
                    MemoryRequest.a().b();
                }
            }
        });
        ImageLoader.d(getFragmentActive(), this.h).a(new ImageLoadResult(getFragmentActive()) { // from class: com.soft.blued.ui.feed.fragment.SendPhotoFragment.4
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
                SendPhotoFragment.this.j.update();
            }
        }).a(this.i);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f30014a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_send_photo, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
