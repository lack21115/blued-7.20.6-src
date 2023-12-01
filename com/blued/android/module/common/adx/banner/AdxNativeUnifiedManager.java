package com.blued.android.module.common.adx.banner;

import android.content.Context;
import com.blued.android.module.common.adx.base.ADListener;
import com.blued.android.module.common.adx.base.IBaseAd;
import com.blued.android.module.common.adx.bd.unified.BDNativeAdAdapter;
import com.blued.android.module.common.adx.gdt.unified.TXNativeAdAdapter;
import com.blued.android.module.common.adx.ks.unified.KSNativeAdAdapter;
import com.blued.android.module.common.adx.tt.unified.TTNativeAdAdapter;
import com.blued.android.module.common.login.model.BluedADExtra;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/banner/AdxNativeUnifiedManager.class */
public final class AdxNativeUnifiedManager extends AdxNativeManager {
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f10446c;
    private int d;
    private long e;
    private final ADListener f;
    private final Context g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdxNativeUnifiedManager(Context context, int i, int i2, int i3, long j, ADListener listener) {
        super(context, i, i2, i3, j, listener);
        Intrinsics.e(context, "context");
        Intrinsics.e(listener, "listener");
        this.b = i;
        this.f10446c = i2;
        this.d = i3;
        this.e = j;
        this.f = listener;
        this.g = context;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public int a() {
        return this.b;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager, com.blued.android.module.common.adx.base.AdxBaseManager
    public Object a(List<? extends BluedADExtra> list, Continuation<? super Flow<? extends IBaseAd>> continuation) {
        ArrayList arrayList = new ArrayList();
        for (BluedADExtra bluedADExtra : list) {
            String str = bluedADExtra.adm_type_source;
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != 51) {
                    if (hashCode != 52) {
                        if (hashCode != 1570) {
                            if (hashCode == 1572 && str.equals("15")) {
                                arrayList.add(new BDNativeAdAdapter(this.g, bluedADExtra, d()));
                            }
                        } else if (str.equals("13")) {
                            arrayList.add(new KSNativeAdAdapter(this.g, bluedADExtra, d()));
                        }
                    } else if (str.equals("4")) {
                        arrayList.add(new TTNativeAdAdapter(this.g, bluedADExtra, d()));
                    }
                } else if (str.equals("3")) {
                    arrayList.add(new TXNativeAdAdapter(this.g, bluedADExtra, d()));
                }
            }
            arrayList.add(new TXNativeAdAdapter(this.g, bluedADExtra, d()));
        }
        return FlowKt.a((Iterable) arrayList);
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public void a(int i) {
        this.f10446c = i;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public void a(long j) {
        this.e = j;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public int b() {
        return this.d;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public void b(int i) {
        this.d = i;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public long c() {
        return this.e;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public ADListener d() {
        return this.f;
    }

    @Override // com.blued.android.module.common.adx.banner.AdxNativeManager
    public int getType() {
        return this.f10446c;
    }
}
