package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.ClipImageLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ClipPhotoFragment.class */
public class ClipPhotoFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f29884a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f29885c;
    private View d;
    private TextView e;
    private ImageView f;
    private ImageView g;
    private ClipImageLayout h;
    private String i;
    private String j;
    private int k;
    private int l;
    private int m;

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.j = arguments.getString("select_http_url");
            this.i = arguments.getString("photo_path");
            this.k = arguments.getInt("select_photo");
            if (TextUtils.isEmpty(this.i)) {
                getActivity().finish();
            }
        }
    }

    public static void a(BaseFragment baseFragment, int i, String str, int i2) {
        MemoryRequest.a().b();
        Bundle bundle = new Bundle();
        bundle.putString("photo_path", str);
        bundle.putInt("select_photo", i);
        TerminalActivity.a(baseFragment, ClipPhotoFragment.class, bundle, i2);
    }

    private void b() {
        View findViewById = this.b.findViewById(2131370694);
        this.d = findViewById;
        this.f = (ImageView) findViewById.findViewById(2131363120);
        this.e = (TextView) this.d.findViewById(2131363108);
        this.g = (ImageView) this.d.findViewById(2131363126);
        this.f29885c = (TextView) this.b.findViewById(R.id.done_view);
        this.g.setVisibility(8);
        this.f29885c.setVisibility(0);
        this.h = (ClipImageLayout) this.b.findViewById(R.id.id_clipImageLayout);
        if (this.k == 8) {
            this.h.setVerticalPadding((AppInfo.m - DensityUtils.a(this.f29884a, 198.0f)) / 2);
        }
        if (this.k == 9) {
            this.h.setVerticalPadding((AppInfo.m - AppInfo.l) / 2);
        }
        int c2 = ImageUtils.c(this.i);
        String[] a2 = ImageUtils.a(this.i);
        int[] a3 = this.k == 8 ? ImageUtils.a(Integer.valueOf(a2[0]).intValue(), Integer.valueOf(a2[1]).intValue(), DensityUtils.a(this.f29884a, 198.0f) - DensityUtils.a(getActivity())) : ImageUtils.a(Integer.valueOf(a2[0]).intValue(), Integer.valueOf(a2[1]).intValue());
        if (a3[0] > a3[1]) {
            int i = a3[0];
        } else {
            int i2 = a3[1];
        }
        Bitmap a4 = BitmapUtils.a(this.i, 1080);
        if (a4 != null) {
            Bitmap bitmap = a4;
            try {
                this.l = a4.getWidth();
                this.m = a4.getHeight();
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a4, a3[0], a3[1], true);
                Bitmap bitmap2 = a4;
                if (createScaledBitmap != a4) {
                    bitmap2 = a4;
                    if (createScaledBitmap != null) {
                        a4.recycle();
                        bitmap2 = createScaledBitmap;
                    }
                }
                Bitmap a5 = c2 != 0 ? BitmapUtils.a(c2, bitmap2) : bitmap2;
                bitmap = bitmap2;
                if (a5 != bitmap2) {
                    bitmap = bitmap2;
                    if (a5 != null) {
                        bitmap = bitmap2;
                        bitmap2.recycle();
                        bitmap = a5;
                    }
                }
            } catch (OutOfMemoryError e) {
                MemoryRequest.a().b();
            }
            this.h.setImageBitmap(bitmap);
        } else {
            AppMethods.d(2131889002);
            MemoryRequest.a().b();
        }
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipPhotoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ClipPhotoFragment.this.getParentFragment() == null || !(ClipPhotoFragment.this.getParentFragment() instanceof LiveBaseDialogFragment)) {
                    ClipPhotoFragment.this.getActivity().finish();
                } else {
                    ((LiveBaseDialogFragment) ClipPhotoFragment.this.getParentFragment()).a((LiveBaseDialogFragment) null);
                }
            }
        });
        this.f29885c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipPhotoFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                try {
                    float f = ClipPhotoFragment.this.l;
                    float f2 = ClipPhotoFragment.this.m;
                    if (f < 300.0f || f2 < 300.0f) {
                        CommonAlertDialog.a(ClipPhotoFragment.this.f29884a, (String) null, ClipPhotoFragment.this.f29884a.getResources().getString(R.string.cropped_image_too_small), ClipPhotoFragment.this.f29884a.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipPhotoFragment.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                                if (ClipPhotoFragment.this.getParentFragment() != null && (ClipPhotoFragment.this.getParentFragment() instanceof LiveBaseDialogFragment)) {
                                    ((LiveBaseDialogFragment) ClipPhotoFragment.this.getParentFragment()).a((LiveBaseDialogFragment) null);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("finish", false);
                                ClipPhotoFragment.this.getActivity().setResult(0, intent);
                                ClipPhotoFragment.this.getActivity().finish();
                            }
                        }, ClipPhotoFragment.this.f29884a.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipPhotoFragment.2.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                                if (ClipPhotoFragment.this.getParentFragment() != null && (ClipPhotoFragment.this.getParentFragment() instanceof LiveBaseDialogFragment)) {
                                    ((LiveBaseDialogFragment) ClipPhotoFragment.this.getParentFragment()).a((LiveBaseDialogFragment) null);
                                    return;
                                }
                                Intent intent = new Intent();
                                intent.putExtra("finish", true);
                                ClipPhotoFragment.this.getActivity().setResult(0, intent);
                                ClipPhotoFragment.this.getActivity().finish();
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    }
                    Bitmap a6 = ClipPhotoFragment.this.h.a();
                    if (a6 == null) {
                        AppMethods.d(2131889002);
                        MemoryRequest.a().b();
                        return;
                    }
                    String e2 = RecyclingUtils.e("photo");
                    BitmapUtils.a(a6, e2, 100);
                    if (a6 != null && !a6.isRecycled()) {
                        a6.recycle();
                    }
                    if (ClipPhotoFragment.this.getParentFragment() == null || !(ClipPhotoFragment.this.getParentFragment() instanceof LiveBaseDialogFragment)) {
                        Intent intent = new Intent();
                        intent.putExtra("photo_path", e2);
                        ClipPhotoFragment.this.getActivity().setResult(-1, intent);
                        ClipPhotoFragment.this.getActivity().finish();
                        return;
                    }
                    LiveMakeLoverFansModel liveMakeLoverFansModel = new LiveMakeLoverFansModel();
                    liveMakeLoverFansModel.avatar = ClipPhotoFragment.this.j;
                    liveMakeLoverFansModel.pic = e2;
                    ((LiveBaseDialogFragment) ClipPhotoFragment.this.getParentFragment()).a((LiveBaseDialogFragment) liveMakeLoverFansModel);
                } catch (Exception e3) {
                }
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f29884a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_clip_photo, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }
}
