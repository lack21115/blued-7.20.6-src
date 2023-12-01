package com.blued.android.module.shortvideo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.base.album.TakePhotoProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.bytedance.applog.tracker.Tracker;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/fragment/PhotoPreviewFragment.class */
public class PhotoPreviewFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f15720a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f15721c;
    private View d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private String h;
    private ImageView i;
    private PhotoViewAttacher j;
    private ProgressBar k;

    public static void a(final BaseFragment baseFragment, final String str, final int i) {
        PermissionHelper.a(new PermissionCallbacks() { // from class: com.blued.android.module.shortvideo.fragment.PhotoPreviewFragment.1
            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void U_() {
                Bundle bundle = new Bundle();
                bundle.putString("frame_path", String.this);
                TerminalActivity.a(baseFragment, PhotoPreviewFragment.class, bundle, i);
            }

            @Override // com.blued.android.framework.permission.PermissionCallbacks
            public void a(String[] strArr) {
            }
        });
    }

    private void b() {
        View findViewById = this.b.findViewById(R.id.top_title);
        this.d = findViewById;
        this.f = (ImageView) findViewById.findViewById(R.id.top_ctt_left);
        this.e = (TextView) this.d.findViewById(R.id.top_ctt_center);
        this.g = (ImageView) this.d.findViewById(R.id.top_ctt_right);
        this.f15721c = (TextView) this.b.findViewById(R.id.top_done_view);
        this.g.setVisibility(8);
        this.f15721c.setVisibility(0);
        this.f15721c.setText(this.f15720a.getResources().getString(R.string.photo_end));
        this.i = (ImageView) this.b.findViewById(R.id.photo_pre_view_img);
        this.k = (ProgressBar) this.b.findViewById(R.id.photo_pre_loading_view);
        this.j = new PhotoViewAttacher(this.i);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.PhotoPreviewFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                File file = new File(PhotoPreviewFragment.this.h);
                if (file.exists()) {
                    file.delete();
                }
                PhotoPreviewFragment.this.getActivity().finish();
            }
        });
        this.f15721c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.shortvideo.fragment.PhotoPreviewFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TakePhotoProxy.a().a(PhotoPreviewFragment.this.h);
                PhotoPreviewFragment.this.getActivity().setResult(-1);
                PhotoPreviewFragment.this.getActivity().finish();
            }
        });
    }

    private void c() {
        this.k.setVisibility(0);
        ImageLoader.d(getFragmentActive(), this.h).a(new ImageLoadResult(getFragmentActive()) { // from class: com.blued.android.module.shortvideo.fragment.PhotoPreviewFragment.4
            @Override // com.blued.android.core.image.ImageLoadResult
            public void a() {
                PhotoPreviewFragment.this.j.update();
            }

            @Override // com.blued.android.core.image.ImageLoadResult
            public void b() {
                PhotoPreviewFragment.this.k.setVisibility(8);
            }
        }).a(this.i);
    }

    public void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.h = arguments.getString("frame_path");
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle != null) {
            this.h = bundle.getString("frame_path");
        }
        this.f15720a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_photo_preview, viewGroup, false);
            b();
            a();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("frame_path", this.h);
        super.onSaveInstanceState(bundle);
    }
}
