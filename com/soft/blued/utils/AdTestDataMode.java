package com.soft.blued.utils;

import com.blued.android.module.common.login.model.BluedADExtra;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.ui.ab_test.models.BannerAdExtra;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AdTestDataMode.class */
public final class AdTestDataMode implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private int f34711a;
    private BannerAdExtra b;

    /* renamed from: c  reason: collision with root package name */
    private BluedADExtra f34712c;
    private ArrayList<BluedADExtra> d = new ArrayList<>();

    public AdTestDataMode(int i) {
        this.f34711a = i;
    }

    public final BannerAdExtra a() {
        return this.b;
    }

    public final void a(BluedADExtra bluedADExtra) {
        this.f34712c = bluedADExtra;
    }

    public final void a(BannerAdExtra bannerAdExtra) {
        this.b = bannerAdExtra;
    }

    public final BluedADExtra b() {
        return this.f34712c;
    }

    public final ArrayList<BluedADExtra> c() {
        return this.d;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 0;
    }

    public final int getType() {
        return this.f34711a;
    }
}
