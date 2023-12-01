package com.soft.blued.ui.photo.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.tv.TvContract;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.live_china.view.ViewDragHelperLayout;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.blued.community.model.AlbumFlow;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.das.live.LiveProtos;
import com.soft.blued.ui.feed.fragment.ShowAlbumActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.utils.TypefaceUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/BasePhotoFragment.class */
public class BasePhotoFragment extends BaseFragment implements EventCallBackListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19362a = true;
    public boolean b;

    /* renamed from: com.soft.blued.ui.photo.fragment.BasePhotoFragment$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/fragment/BasePhotoFragment$4.class */
    class AnonymousClass4 implements ViewDragHelperLayout.OnLayoutStateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewDragHelperLayout f19367a;

        public void a() {
            this.f19367a.setVisibility(8);
        }

        public void a(int i) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    private static AlbumFlow a(BluedIngSelfFeed bluedIngSelfFeed) {
        return new AlbumFlow(bluedIngSelfFeed);
    }

    public static void a(Context context, int i, int i2, LoadOptions loadOptions) {
        if (context == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putInt("show_photo", i2);
        bundle.putSerializable("photo_options", loadOptions);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowPhotoRemoveFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3) {
        if (bluedIngSelfFeed == null || KeyBoardFragment.V_()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (i2 != 7) {
            String[] strArr = bluedIngSelfFeed.feed_pics;
            int length = strArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length) {
                    break;
                }
                String str2 = strArr[i5];
                AlbumFlow a2 = a(bluedIngSelfFeed);
                a2.album_pic = str2;
                arrayList.add(a2);
                i4 = i5 + 1;
            }
        } else {
            arrayList.add(a(bluedIngSelfFeed));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putSerializable("photo_options", loadOptions);
        bundle.putSerializable("photo_datas", arrayList);
        bundle.putInt("show_photo", i2);
        bundle.putInt("from_feed_list_page", i3);
        bundle.putString("WATER_MASK_NAME", str);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowAlbumFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, AlbumForDataTrans albumForDataTrans, int i, int i2, String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        ShowAlbumFragment.f19375c = albumForDataTrans;
        bundle.putInt("show_photo", i2);
        bundle.putString("WATER_MASK_NAME", str);
        bundle.putString("TARGET_UID", str2);
        bundle.putInt("from_feed_list_page", i3);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowAlbumFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, int i3, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("video_preview_url", str);
        bundle.putString("video_url", str2);
        bundle.putInt(TvContract.Programs.COLUMN_VIDEO_WIDTH, i2);
        bundle.putInt(TvContract.Programs.COLUMN_VIDEO_HEIGHT, i3);
        bundle.putLong("video_size", j);
        bundle.putInt("show_photo", i);
        bundle.putString("key_feed_id", str3);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowVideoFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, int i3, long j, boolean z, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("video_preview_url", str);
        bundle.putString("video_url", str2);
        bundle.putInt(TvContract.Programs.COLUMN_VIDEO_WIDTH, i2);
        bundle.putInt(TvContract.Programs.COLUMN_VIDEO_HEIGHT, i3);
        bundle.putLong("video_size", j);
        bundle.putInt("show_photo", i);
        bundle.putString("key_feed_id", str3);
        bundle.putBoolean("support_save", z);
        bundle.putString("target_uid", str4);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowVideoFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, String str, String str2, String str3, int i, long j) {
        a(context, str, str2, str3, i, 0, 0, j);
    }

    public static void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putStringArray("photo_datas", strArr);
        bundle.putInt("show_photo", i2);
        bundle.putSerializable("photo_options", loadOptions);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowPhotoFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, String[] strArr, int i, int i2, LoadOptions loadOptions, String str, View view, String str2) {
        if (strArr == null || strArr.length <= 0 || KeyBoardFragment.V_()) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putStringArray("photo_datas", strArr);
        bundle.putInt("show_photo", i2);
        bundle.putSerializable("photo_options", loadOptions);
        bundle.putString("WATER_MASK_NAME", str);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowPhotoFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, String[] strArr, int i, int i2, String str, String str2, int i3) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putStringArray("photo_datas", strArr);
        bundle.putInt("show_photo", i2);
        bundle.putString("UID", str);
        bundle.putString("WATER_MASK_NAME", str2);
        bundle.putInt("avatar_widget", i3);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowPhotoFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(Context context, String[] strArr, String[] strArr2, int i, int i2, String str, LoadOptions loadOptions) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putStringArray("photo_datas", strArr);
        bundle.putStringArray("photo_pids", strArr2);
        bundle.putInt("show_photo", i2);
        bundle.putString("WATER_MASK_NAME", str);
        bundle.putSerializable("photo_options", loadOptions);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.b(context, ShowPhotoFragment.class, bundle);
        ActivityChangeAnimationUtils.i((Activity) context);
    }

    public static void a(BaseFragment baseFragment, BluedIngSelfFeed bluedIngSelfFeed, int i, int i2, LoadOptions loadOptions, String str, int i3, int i4) {
        if (bluedIngSelfFeed == null || KeyBoardFragment.V_()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (i2 != 7) {
            String[] strArr = bluedIngSelfFeed.feed_pics;
            int length = strArr.length;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= length) {
                    break;
                }
                String str2 = strArr[i6];
                AlbumFlow a2 = a(bluedIngSelfFeed);
                a2.album_pic = str2;
                arrayList.add(a2);
                i5 = i6 + 1;
            }
        } else {
            arrayList.add(a(bluedIngSelfFeed));
        }
        Bundle bundle = new Bundle();
        bundle.putInt("photo_index", i);
        bundle.putSerializable("photo_options", loadOptions);
        bundle.putSerializable("photo_datas", arrayList);
        bundle.putInt("show_photo", i2);
        bundle.putInt("from_feed_list_page", i4);
        bundle.putString("WATER_MASK_NAME", str);
        bundle.putInt("REQUEST_CODE_KEY", i3);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        ShowAlbumActivity.a(baseFragment, ShowAlbumFragment.class, bundle, i3);
        ActivityChangeAnimationUtils.i(baseFragment.getActivity());
    }

    public void a(float f, float f2, float f3) {
    }

    public void a(int i) {
    }

    public void a(View view) {
    }

    public void a(View view, View view2, boolean z) {
        if (this.b) {
            return;
        }
        view.setVisibility(8);
        view2.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), 2130772121);
        loadAnimation.setDuration(200L);
        view.startAnimation(loadAnimation);
        if (z) {
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getActivity(), 2130772121);
            loadAnimation2.setDuration(200L);
            view2.startAnimation(loadAnimation2);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.photo.fragment.BasePhotoFragment.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BasePhotoFragment.this.b = false;
                BasePhotoFragment.this.f19362a = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                BasePhotoFragment.this.b = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final File file, String str) {
        Bitmap bitmap;
        int min;
        if (ChatHelperV4.a(file)) {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
                ThreadManager.a().a(new ThreadExecutor("saveGif") { // from class: com.soft.blued.ui.photo.fragment.BasePhotoFragment.1
                    public void execute() {
                        final String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "blued/" + System.currentTimeMillis() + ".gif";
                        FileUtils.a(file.getAbsolutePath(), str2);
                        BasePhotoFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.photo.fragment.BasePhotoFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppUtils.a(AppInfo.d(), str2, true);
                            }
                        });
                    }
                });
                return;
            }
            return;
        }
        try {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
            bitmap = null;
        }
        if (bitmap == null) {
            return;
        }
        double d = Math.min(bitmap.getWidth(), bitmap.getHeight()) > 540 ? min / LiveProtos.Event.LIVE_BAG_CHAT_MARK_SHOW_VALUE : 1.0d;
        if (getActivity() == null || getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        Bitmap a2 = BitmapUtils.a(getActivity(), TypefaceUtils.a(getActivity(), str, d));
        if (a2 != null) {
            bitmap = BitmapUtils.a(getActivity(), bitmap, a2, (int) (Math.max(d, 1.0d) * 10.0d), (int) (Math.max(d, 1.0d) * 10.0d));
        }
        if (bitmap == null) {
            return;
        }
        ImageUtils.a(bitmap);
    }

    public void a(Object... objArr) {
    }

    public void ak_() {
    }

    public void al_() {
    }

    public void am_() {
        f();
    }

    public void b(View view) {
    }

    public void b(View view, View view2, boolean z) {
        if (this.b) {
            return;
        }
        view.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), 2130772120);
        loadAnimation.setDuration(200L);
        view.startAnimation(loadAnimation);
        if (z) {
            view2.setVisibility(0);
            view2.startAnimation(loadAnimation);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.photo.fragment.BasePhotoFragment.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                BasePhotoFragment.this.b = false;
                BasePhotoFragment.this.f19362a = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                BasePhotoFragment.this.b = true;
            }
        });
    }

    public void b(Object... objArr) {
    }

    public void d() {
    }

    public void e() {
        f();
    }

    public void f() {
        getActivity().finish();
        ActivityChangeAnimationUtils.j(getActivity());
    }

    public void g() {
        getActivity().finish();
        ActivityChangeAnimationUtils.f(getActivity());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventCallbackObserver.a().a(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventCallbackObserver.a().b(this);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        BaseFragmentActivity activity = getActivity();
        activity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        activity.getWindow().getDecorView().setBackgroundColor(0);
    }
}
