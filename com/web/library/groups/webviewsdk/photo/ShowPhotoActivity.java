package com.web.library.groups.webviewsdk.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.BrowserContract;
import android.view.MotionEvent;
import androidx.core.app.ActivityCompat;
import com.bytedance.applog.tracker.Tracker;
import com.web.library.groups.webviewsdk.R;
import com.web.library.groups.webviewsdk.c.c;
import com.web.library.groups.webviewsdk.photo.adapter.PhotoPagerAdapter;
import com.web.library.groups.webviewsdk.photoview.HackyViewPager;
import com.weimob.library.groups.imageloader.core.ImageLoader;
import com.weimob.library.groups.imageloader.core.ImageLoaderConfiguration;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/photo/ShowPhotoActivity.class */
public class ShowPhotoActivity extends Activity implements PhotoPagerAdapter.a {

    /* renamed from: a  reason: collision with root package name */
    HackyViewPager f27469a;
    List<String> b;

    /* renamed from: c  reason: collision with root package name */
    int f27470c;
    private final String[] d = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};

    public static void a(Context context, List<String> list, int i, int i2) {
        context.startActivity(new Intent(context, ShowPhotoActivity.class).putExtra("requestedOrientation", i2).putExtra("imgUrlList", (Serializable) list).putExtra(BrowserContract.Bookmarks.POSITION, i));
    }

    private void b() {
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this).bitmapConfig(Bitmap.Config.RGB_565).build());
        c();
    }

    private void c() {
        if (Build.VERSION.SDK_INT < 23 || c.a(this, this.d)) {
            return;
        }
        ActivityCompat.requestPermissions(this, this.d, 1001);
    }

    private void d() {
        setRequestedOrientation(getIntent().getIntExtra("requestedOrientation", 1));
        e();
        PhotoPagerAdapter photoPagerAdapter = new PhotoPagerAdapter(this);
        photoPagerAdapter.getDataList().addAll(this.b);
        this.f27469a.setAdapter(photoPagerAdapter);
        this.f27469a.setCurrentItem(this.f27470c);
    }

    private void e() {
        this.f27469a = (HackyViewPager) findViewById(R.id.hackyViewPager);
        this.b = (List) getIntent().getSerializableExtra("imgUrlList");
        this.f27470c = getIntent().getIntExtra(BrowserContract.Bookmarks.POSITION, 0);
    }

    @Override // com.web.library.groups.webviewsdk.photo.adapter.PhotoPagerAdapter.a
    public void a() {
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.webviewsdk_activity_show_photo);
        b();
        if (getActionBar() != null) {
            getActionBar().hide();
        }
        d();
    }
}
