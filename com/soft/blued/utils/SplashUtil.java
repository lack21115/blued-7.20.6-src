package com.soft.blued.utils;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.soft.blued.ui.welcome.model.SplashEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/SplashUtil.class */
public final class SplashUtil {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f21085a;
    private ArrayList<SplashEntity.ShowEntity> b;

    /* renamed from: c  reason: collision with root package name */
    private LifecycleCoroutineScope f21086c;
    private int d;
    private final long e;

    public SplashUtil(Fragment fragment) {
        Intrinsics.e(fragment, "fragment");
        this.f21085a = fragment;
        this.b = new ArrayList<>();
        this.f21086c = LifecycleOwnerKt.getLifecycleScope(this.f21085a);
        this.d = -1;
        this.e = 5000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SplashEntity.ShowEntity b() {
        int i = this.d + 1;
        this.d = i;
        if (i > this.b.size() - 1) {
            this.d = 0;
        }
        SplashEntity.ShowEntity showEntity = this.b.get(this.d);
        Intrinsics.c(showEntity, "adList[index]");
        return showEntity;
    }

    public final ArrayList<SplashEntity.ShowEntity> a() {
        ArrayList<SplashEntity.ShowEntity> arrayList = new ArrayList<>();
        SplashEntity.ShowEntity showEntity = new SplashEntity.ShowEntity();
        showEntity.splashResultList = new ArrayList();
        showEntity.timeout = 8;
        SplashEntity splashEntity = new SplashEntity();
        splashEntity.today = new SplashEntity.ShowEntity();
        splashEntity.today.adms_type = "6";
        splashEntity.today.third_id = "b60890081aea2d";
        SplashEntity.ShowEntity showEntity2 = new SplashEntity.ShowEntity();
        showEntity2.timeout = 8;
        showEntity2.splashResultList = new ArrayList();
        SplashEntity splashEntity2 = new SplashEntity();
        splashEntity2.today = new SplashEntity.ShowEntity();
        splashEntity2.today.adms_type = "6";
        splashEntity2.today.third_id = "b6100f87051655";
        showEntity.splashResultList.add(splashEntity);
        showEntity2.splashResultList.add(splashEntity2);
        arrayList.add(showEntity);
        arrayList.add(showEntity2);
        return arrayList;
    }

    public final void a(int i, int i2, Intent intent) {
        BuildersKt.a(this.f21086c, Dispatchers.b(), (CoroutineStart) null, new SplashUtil$onActivityResult$1(this, null), 2, (Object) null);
    }

    public final void a(ArrayList<SplashEntity.ShowEntity> arrayList) {
        Intrinsics.e(arrayList, "list");
        this.b = arrayList;
        BuildersKt.a(this.f21086c, Dispatchers.b(), (CoroutineStart) null, new SplashUtil$start$1(this, null), 2, (Object) null);
    }
}
