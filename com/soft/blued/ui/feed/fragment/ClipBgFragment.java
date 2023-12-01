package com.soft.blued.ui.feed.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.ImageUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.ClipZoomImageView;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.feed.activity.ClipBgActivity;
import com.soft.blued.ui.feed.manager.IDispatchTouchEvent;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ClipBgFragment.class */
public class ClipBgFragment extends BaseFragment implements View.OnTouchListener, IDispatchTouchEvent {

    /* renamed from: a  reason: collision with root package name */
    private Context f29877a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f29878c;
    private TextView d;
    private View e;
    private View f;
    private View g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private ClipZoomImageView k;
    private ShapeLinearLayout l;
    private ImageView m;
    private String n;
    private int o;
    private int p;
    private int q;
    private ReviewModel r = new ReviewModel();
    private int s;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ClipBgFragment$ReviewModel.class */
    public class ReviewModel implements Runnable {
        public ReviewModel() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ClipBgFragment.this.s == 0) {
                ClipBgFragment.this.c();
            }
        }
    }

    private void a() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getString("photo_path");
            this.o = arguments.getInt("select_photo");
            if (TextUtils.isEmpty(this.n)) {
                getActivity().finish();
            }
        }
        ((ClipBgActivity) getActivity()).a((IDispatchTouchEvent) this);
    }

    public static void a(BaseFragment baseFragment, int i, String str, int i2) {
        MemoryRequest.a().b();
        Bundle bundle = new Bundle();
        bundle.putString("photo_path", str);
        bundle.putInt("select_photo", i);
        ClipBgActivity.b(baseFragment, ClipBgFragment.class, bundle, i2);
    }

    private void b() {
        this.f29878c = (TextView) this.b.findViewById(R.id.ok_view);
        this.d = (TextView) this.b.findViewById(R.id.cancel_view);
        this.k = (ClipZoomImageView) this.b.findViewById(R.id.clip_zoom_view);
        this.l = (ShapeLinearLayout) this.b.findViewById(R.id.clip_zoom_bg);
        this.m = (ImageView) this.b.findViewById(R.id.clip_zoom_inside);
        this.e = this.b.findViewById(R.id.clip_zoom_top);
        this.f = this.b.findViewById(R.id.clip_zoom_bottom);
        this.h = (ImageView) this.b.findViewById(R.id.clip_zoom_review);
        this.i = (TextView) this.b.findViewById(R.id.clip_zoom_title);
        this.j = (TextView) this.b.findViewById(R.id.clip_zoom_des);
        View findViewById = this.b.findViewById(R.id.clip_zoom_touch);
        this.g = findViewById;
        findViewById.setOnTouchListener(this);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
        layoutParams.height = AppInfo.l;
        this.l.setLayoutParams(layoutParams);
        int c2 = ImageUtils.c(this.n);
        String[] a2 = ImageUtils.a(this.n);
        int[] a3 = this.o == 8 ? ImageUtils.a(Integer.valueOf(a2[0]).intValue(), Integer.valueOf(a2[1]).intValue(), DensityUtils.a(this.f29877a, 198.0f) - DensityUtils.a(getActivity())) : ImageUtils.a(Integer.valueOf(a2[0]).intValue(), Integer.valueOf(a2[1]).intValue());
        if (a3[0] > a3[1]) {
            int i = a3[0];
        } else {
            int i2 = a3[1];
        }
        Bitmap a4 = BitmapUtils.a(this.n, 1080);
        if (a4 != null) {
            Bitmap bitmap = a4;
            try {
                this.p = a4.getWidth();
                this.q = a4.getHeight();
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
            this.k.setImageBitmap(BitmapUtils.a(bitmap));
        } else {
            AppMethods.d(2131889002);
            MemoryRequest.a().b();
        }
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipBgFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ClipBgFragment.this.getActivity().finish();
            }
        });
        this.f29878c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipBgFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK);
                try {
                    float f = ClipBgFragment.this.p;
                    float f2 = ClipBgFragment.this.q;
                    if (f < 300.0f || f2 < 300.0f) {
                        CommonAlertDialog.a(ClipBgFragment.this.f29877a, (String) null, ClipBgFragment.this.f29877a.getResources().getString(R.string.cropped_image_too_small), ClipBgFragment.this.f29877a.getResources().getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipBgFragment.2.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                                Intent intent = new Intent();
                                intent.putExtra("finish", false);
                                ClipBgFragment.this.getActivity().setResult(0, intent);
                                ClipBgFragment.this.getActivity().finish();
                            }
                        }, ClipBgFragment.this.f29877a.getResources().getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.feed.fragment.ClipBgFragment.2.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i3) {
                                Tracker.onClick(dialogInterface, i3);
                                Intent intent = new Intent();
                                intent.putExtra("finish", true);
                                ClipBgFragment.this.getActivity().setResult(0, intent);
                                ClipBgFragment.this.getActivity().finish();
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    }
                    Bitmap a6 = ClipBgFragment.this.k.a();
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
                    Intent intent = new Intent();
                    intent.putExtra("photo_path", e2);
                    ClipBgFragment.this.getActivity().setResult(-1, intent);
                    ClipBgFragment.this.getActivity().finish();
                } catch (Exception e3) {
                }
            }
        });
        AppInfo.n().postDelayed(this.r, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.s = 1;
        this.e.setBackgroundResource(2131099824);
        this.f.setBackgroundResource(2131099824);
        this.h.setVisibility(0);
        this.i.setText(R.string.profile_background_review);
        this.j.setVisibility(8);
        ShapeHelper.d(this.l, 2131102388);
        this.m.setVisibility(4);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.6f, 1.0f);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setDuration(500L);
        this.e.setAnimation(alphaAnimation);
        this.f.setAnimation(alphaAnimation);
        this.h.setAnimation(alphaAnimation);
    }

    private void d() {
        this.s = 0;
        this.e.setBackgroundResource(2131102389);
        this.f.setBackgroundResource(2131102389);
        this.h.setVisibility(8);
        this.i.setText(R.string.profile_background_text1);
        this.j.setText(R.string.profile_background_text1);
        this.j.setVisibility(0);
        ShapeHelper.d(this.l, 2131102479);
        this.m.setVisibility(0);
    }

    @Override // com.soft.blued.ui.feed.manager.IDispatchTouchEvent
    public void a(MotionEvent motionEvent) {
        AppInfo.n().removeCallbacks(this.r);
        AppInfo.n().postDelayed(this.r, 1000L);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f29877a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.fragment_clip_bg, viewGroup, false);
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((ClipBgActivity) getActivity()).b(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.s == 1) {
            d();
            return false;
        }
        return false;
    }
}
