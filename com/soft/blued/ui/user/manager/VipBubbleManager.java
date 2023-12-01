package com.soft.blued.ui.user.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.BitmapUtils;
import com.blued.android.module.common.utils.NinePatchBitmapFactory;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.utils.Logger;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import skin.support.observe.SkinObservable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/manager/VipBubbleManager.class */
public class VipBubbleManager {
    private static volatile VipBubbleManager k;
    private VipBubbleModel b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f34230c;
    private Bitmap d;
    private Bitmap e;
    private Bitmap f;
    private Bitmap g;
    private Bitmap h;

    /* renamed from: a  reason: collision with root package name */
    private List<VipBubbleModel> f34229a = new ArrayList();
    private VipBubbleModel i = new VipBubbleModel();
    private VipBubbleModel j = new VipBubbleModel();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/manager/VipBubbleManager$RefreshListener.class */
    public interface RefreshListener {
        void a();
    }

    private VipBubbleManager() {
        b();
        BluedSkinUtils.a(new BluedSkinObserver() { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.1
            @Override // skin.support.observe.SkinObserver
            public void a(SkinObservable skinObservable, Object obj) {
                Logger.c("VipBubbleManager", "VipBubbleManager=====updateSkin");
                VipBubbleManager.this.b();
            }
        });
    }

    private Drawable a(Bitmap bitmap) {
        return NinePatchBitmapFactory.a(AppInfo.d().getResources(), bitmap, c(bitmap.getWidth() / 2), c(bitmap.getHeight() / 2), null);
    }

    private Drawable a(Bitmap bitmap, Bitmap bitmap2) {
        NinePatchDrawable a2 = NinePatchBitmapFactory.a(AppInfo.d().getResources(), bitmap, c(bitmap.getWidth() / 2), c(bitmap.getHeight() / 2), null);
        NinePatchDrawable a3 = NinePatchBitmapFactory.a(AppInfo.d().getResources(), bitmap2, c(bitmap2.getWidth() / 2), c(bitmap2.getHeight() / 2), null);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, a3);
        stateListDrawable.addState(new int[]{16842910}, a2);
        return stateListDrawable;
    }

    public static VipBubbleManager a() {
        if (k == null) {
            synchronized (VipBubbleManager.class) {
                try {
                    if (k == null) {
                        k = new VipBubbleManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return k;
    }

    private List<NinePatchBitmapFactory.Range> c(int i) {
        ArrayList arrayList = new ArrayList();
        NinePatchBitmapFactory.Range range = new NinePatchBitmapFactory.Range();
        range.f10890a = i - 1;
        range.b = i + 1;
        arrayList.add(range);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(VipBubbleModel vipBubbleModel, int i, View... viewArr) {
        View view;
        View view2;
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        int a2 = (int) (DensityUtils.a(AppInfo.d(), 11.0f) * (AppInfo.d().getResources().getDisplayMetrics().density / 2.0f));
        if (i == 0 && vipBubbleModel != null && vipBubbleModel.mPressBitmap != null && vipBubbleModel.mNormalBitmap != null && vipBubbleModel.mPressBitmap.get() != null && vipBubbleModel.mNormalBitmap.get() != null) {
            int length = viewArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length || (view2 = viewArr[i3]) == null) {
                    return;
                }
                view2.setPadding(DensityUtils.a(view2.getContext(), 23.0f), a2, DensityUtils.a(view2.getContext(), 23.0f), a2);
                view2.setBackground(a(vipBubbleModel.mNormalBitmap.get(), vipBubbleModel.mPressBitmap.get()));
                i2 = i3 + 1;
            }
        } else if (i != 1 || vipBubbleModel.mVoiceBitmap == null || vipBubbleModel.mVoiceBitmap.get() == null) {
        } else {
            int length2 = viewArr.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2 || (view = viewArr[i5]) == null) {
                    return;
                }
                view.setPadding(DensityUtils.a(view.getContext(), 18.0f), a2, DensityUtils.a(view.getContext(), 18.0f), a2);
                view.setBackground(a(vipBubbleModel.mVoiceBitmap.get()));
                i4 = i5 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        VipBubbleModel vipBubbleModel = this.b;
        if (vipBubbleModel == null) {
            return;
        }
        b(vipBubbleModel, 1, new View[0]);
        a(this.b, 1, new View[0]);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.4
            @Override // java.lang.Runnable
            public void run() {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_IM_BUBBLE).post(null);
            }
        }, 300L);
    }

    public void a(int i) {
        if (i == 0) {
            this.b = null;
            LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_IM_BUBBLE).post(null);
            return;
        }
        for (VipBubbleModel vipBubbleModel : this.f34229a) {
            if (vipBubbleModel.id == i) {
                this.b = vipBubbleModel.copy();
                f();
                return;
            }
        }
    }

    public void a(int i, int i2, View... viewArr) {
        if (i != 0) {
            if (i == 1) {
                if (i2 == 0) {
                    if (this.g == null) {
                        return;
                    }
                    if (this.i.mVoiceBitmap == null || this.i.mVoiceBitmap.get() == null) {
                        this.i.mVoiceBitmap = new SoftReference<>(this.g);
                    }
                    c(this.i, 1, viewArr);
                } else if (this.h == null) {
                } else {
                    if (this.j.mVoiceBitmap == null || this.j.mVoiceBitmap.get() == null) {
                        this.j.mVoiceBitmap = new SoftReference<>(this.h);
                    }
                    c(this.j, 1, viewArr);
                }
            }
        } else if (i2 == 0) {
            if (this.f34230c == null || this.d == null) {
                return;
            }
            if (this.i.mNormalBitmap == null || this.i.mNormalBitmap.get() == null) {
                this.i.mNormalBitmap = new SoftReference<>(this.f34230c);
            }
            if (this.i.mPressBitmap == null || this.i.mPressBitmap.get() == null) {
                this.i.mPressBitmap = new SoftReference<>(this.d);
            }
            c(this.i, i, viewArr);
        } else if (this.e == null || this.f == null) {
        } else {
            if (this.j.mNormalBitmap == null || this.j.mNormalBitmap.get() == null) {
                this.j.mNormalBitmap = new SoftReference<>(this.e);
            }
            if (this.j.mPressBitmap == null || this.j.mPressBitmap.get() == null) {
                this.j.mPressBitmap = new SoftReference<>(this.f);
            }
            c(this.j, i, viewArr);
        }
    }

    public void a(final RefreshListener refreshListener, IRequestHost iRequestHost) {
        UserHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipBubbleModel>>(iRequestHost) { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VipBubbleModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    VipBubbleManager.this.f34229a.clear();
                    VipBubbleManager.this.f34229a.addAll(bluedEntityA.data);
                    for (VipBubbleModel vipBubbleModel : VipBubbleManager.this.f34229a) {
                        if (vipBubbleModel.selected == 1) {
                            VipBubbleManager.this.b = vipBubbleModel.copy();
                            VipBubbleManager.this.f();
                        }
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                RefreshListener refreshListener2;
                super.onUIFinish(z);
                if (!z || (refreshListener2 = refreshListener) == null) {
                    return;
                }
                refreshListener2.a();
            }
        }, "message", iRequestHost);
    }

    public void a(final VipBubbleModel vipBubbleModel, int i, final View... viewArr) {
        if (vipBubbleModel == null) {
            return;
        }
        if (vipBubbleModel.mVoiceBitmap == null || vipBubbleModel.mVoiceBitmap.get() == null) {
            ImageFileLoader.a((IRequestHost) null).a(i == 0 ? vipBubbleModel.voice_left : vipBubbleModel.voice_right).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.5
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    if (file == null) {
                        return;
                    }
                    vipBubbleModel.mVoiceBitmap = new SoftReference<>(BitmapFactory.decodeFile(file.getAbsolutePath()));
                    if (vipBubbleModel.mVoiceBitmap == null || vipBubbleModel.mVoiceBitmap.get() == null) {
                        return;
                    }
                    VipBubbleManager.this.c(vipBubbleModel, 1, viewArr);
                }
            }).a();
        } else {
            c(vipBubbleModel, 1, viewArr);
        }
    }

    public VipBubbleModel b(int i) {
        if (this.f34229a.size() == 0) {
            a((RefreshListener) null, (IRequestHost) null);
            return null;
        }
        for (VipBubbleModel vipBubbleModel : this.f34229a) {
            if (vipBubbleModel.id == i) {
                return vipBubbleModel;
            }
        }
        return null;
    }

    public void b() {
        this.i.mNormalBitmap = null;
        this.i.mPressBitmap = null;
        this.i.mVoiceBitmap = null;
        ThreadManager.a().a(new ThreadExecutor("loadDefaultBubble") { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.2
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                if (VipBubbleManager.this.h == null) {
                    VipBubbleManager.this.h = BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.voice_right);
                }
                if (VipBubbleManager.this.e == null) {
                    VipBubbleManager.this.e = BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.bubble_right);
                }
                if (VipBubbleManager.this.f == null) {
                    VipBubbleManager.this.f = BitmapFactory.decodeResource(AppInfo.d().getResources(), R.drawable.bubble_right_pressed);
                }
                try {
                    VipBubbleManager.this.f34230c = BitmapUtils.a(BluedSkinUtils.b(AppInfo.d(), R.drawable.bubble_left));
                    VipBubbleManager.this.d = BitmapUtils.a(BluedSkinUtils.b(AppInfo.d(), R.drawable.bubble_left_pressed));
                    VipBubbleManager.this.g = BitmapUtils.a(BluedSkinUtils.b(AppInfo.d(), R.drawable.bubble_left));
                } catch (Exception e) {
                }
            }
        });
    }

    public void b(final VipBubbleModel vipBubbleModel, final int i, final View... viewArr) {
        if (vipBubbleModel == null) {
            return;
        }
        if (vipBubbleModel.mNormalBitmap == null || vipBubbleModel.mNormalBitmap.get() == null || vipBubbleModel.mPressBitmap == null || vipBubbleModel.mPressBitmap.get() == null) {
            ThreadManager.a().a(new ThreadExecutor("loadBubble") { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.6
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    try {
                        vipBubbleModel.mNormalBitmap = new SoftReference<>(GlideApp.b(AppInfo.d()).f().b(i == 0 ? vipBubbleModel.bubble_left : vipBubbleModel.bubble_right).g().get());
                        vipBubbleModel.mPressBitmap = new SoftReference<>(GlideApp.b(AppInfo.d()).f().b(i == 0 ? vipBubbleModel.bubble_left_click : vipBubbleModel.bubble_right_click).g().get());
                        if (vipBubbleModel.mNormalBitmap == null || vipBubbleModel.mPressBitmap == null || vipBubbleModel.mNormalBitmap.get() == null || vipBubbleModel.mPressBitmap.get() == null) {
                            return;
                        }
                        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.manager.VipBubbleManager.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                VipBubbleManager.this.c(vipBubbleModel, 0, viewArr);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        } else {
            c(vipBubbleModel, 0, viewArr);
        }
    }

    public VipBubbleModel c() {
        VipBubbleModel vipBubbleModel = this.b;
        if (vipBubbleModel == null || vipBubbleModel.vip_status <= UserInfo.getInstance().getLoginUserInfo().vip_grade) {
            return this.b;
        }
        return null;
    }

    public List<VipBubbleModel> d() {
        return this.f34229a;
    }

    public void e() {
        this.b = null;
        this.f34229a.clear();
    }
}
