package com.soft.blued.ui.feed.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MemoryBitmapCache;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/fragment/ShowPhotoDestroyFragment.class */
public class ShowPhotoDestroyFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private View f16331a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f16332c;
    private ProgressBar d;
    private LinearLayout e;
    private TextView f;
    private TextView g;
    private FrameLayout h;
    private TextView i;
    private ImageView j;
    private boolean k;
    private CountDownTimer l;
    private short m;
    private long n;
    private long o;

    private void a() {
        this.j = (ImageView) this.f16331a.findViewById(R.id.photo_view);
        this.d = (ProgressBar) this.f16331a.findViewById(R.id.loading_view);
        this.e = (LinearLayout) this.f16331a.findViewById(2131369468);
        this.f = (TextView) this.f16331a.findViewById(R.id.first_text);
        this.g = (TextView) this.f16331a.findViewById(R.id.second_text);
        this.h = (FrameLayout) this.f16331a.findViewById(R.id.photo_layout);
        TextView textView = (TextView) this.f16331a.findViewById(R.id.photo_num);
        this.i = textView;
        textView.setText(String.valueOf(5L));
    }

    public static void a(BaseFragment baseFragment, short s, long j, long j2, String str, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putShort("passby_session_type", s);
        bundle.putLong("passby_session_id", j);
        bundle.putLong("PASSBY_MSG_ID", j2);
        bundle.putString("photo_path", str);
        bundle.putInt("msg_burn_after_reading_position", i);
        TerminalActivity.a(baseFragment, ShowPhotoDestroyFragment.class, bundle, i2);
        ActivityChangeAnimationUtils.i(baseFragment.getActivity());
    }

    private void b() {
        Logger.c("ShowPhotoDestroyFragment", "mImagePath===" + this.b);
        MemoryBitmapCache.BitmapWrapper b = MemoryBitmapCache.a().b(this.b);
        if (b == null || b.f21071a == null || b.f21071a.isRecycled()) {
            this.d.setVisibility(0);
            ImageLoader.a(getFragmentActive(), this.b).a(new ImageLoadResult(getFragmentActive()) { // from class: com.soft.blued.ui.feed.fragment.ShowPhotoDestroyFragment.1
                public void a() {
                    ShowPhotoDestroyFragment.this.c();
                }

                public void a(int i, Exception exc) {
                    Logger.e("loadImage", "Exception===" + exc.getMessage());
                    ShowPhotoDestroyFragment.this.d.setVisibility(8);
                    AppMethods.a(AppInfo.d().getResources().getString(2131891037) + "(" + i + ")");
                    ShowPhotoDestroyFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.feed.fragment.ShowPhotoDestroyFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ShowPhotoDestroyFragment.this.a(false);
                        }
                    }, 1000L);
                }
            }).e().b().a(this.j);
            return;
        }
        Logger.c("ShowPhotoDestroyFragment", "缓存存在===" + this.b);
        this.j.setImageBitmap(b.f21071a);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.d.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.feed.fragment.ShowPhotoDestroyFragment.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    ShowPhotoDestroyFragment.this.h.setVisibility(0);
                    ShowPhotoDestroyFragment.this.d();
                    ShowPhotoDestroyFragment.this.k = true;
                    return true;
                } else if (action == 1) {
                    ShowPhotoDestroyFragment.this.a(true);
                    return true;
                } else if (action != 3) {
                    return true;
                } else {
                    ShowPhotoDestroyFragment.this.a(true);
                    return true;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.l == null) {
            CountDownTimer countDownTimer = new CountDownTimer(5500L, 1000L) { // from class: com.soft.blued.ui.feed.fragment.ShowPhotoDestroyFragment.3
                @Override // android.os.CountDownTimer
                public void onFinish() {
                }

                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    long j2 = j / 1000;
                    if (j2 == 0) {
                        ShowPhotoDestroyFragment.this.a(true);
                    } else {
                        ShowPhotoDestroyFragment.this.i.setText(String.valueOf(j2));
                    }
                }
            };
            this.l = countDownTimer;
            countDownTimer.start();
        }
    }

    private void e() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.m = arguments.getShort("passby_session_type");
            this.n = arguments.getLong("passby_session_id");
            this.o = arguments.getLong("PASSBY_MSG_ID");
            this.b = arguments.getString("photo_path");
            this.f16332c = arguments.getInt("msg_burn_after_reading_position", -1);
        }
        this.k = false;
    }

    public void a(boolean z) {
        if (getActivity() != null) {
            if (z) {
                ChatManager.getInstance().sendReadReceipt(this.m, this.n, this.o);
                Intent intent = new Intent();
                intent.putExtra("msg_burn_after_reading_position", this.f16332c);
                getActivity().setResult(-1, intent);
            }
            getActivity().finish();
            ActivityChangeAnimationUtils.j(getActivity());
        }
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public boolean onBackPressed() {
        a(this.k);
        return super.onBackPressed();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().addFlags(8192);
        View view = this.f16331a;
        if (view == null) {
            this.f16331a = layoutInflater.inflate(R.layout.fragment_show_photo_destroy, viewGroup, false);
            e();
            a();
            b();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f16331a.getParent()).removeView(this.f16331a);
        }
        return this.f16331a;
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.l = null;
        }
    }
}
