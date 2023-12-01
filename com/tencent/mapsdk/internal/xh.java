package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xh.class */
public class xh extends OverSeaTileProvider {

    /* renamed from: a  reason: collision with root package name */
    private ei f24424a;
    private w6 b;

    /* renamed from: c  reason: collision with root package name */
    private Language f24425c;
    private OverSeaSource d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xh$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24426a;

        static {
            OverSeaSource.values();
            int[] iArr = new int[2];
            f24426a = iArr;
            try {
                OverSeaSource overSeaSource = OverSeaSource.DEFAULT;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f24426a;
                OverSeaSource overSeaSource2 = OverSeaSource.SPARE;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public xh(ei eiVar, OverSeaSource overSeaSource, w6 w6Var) {
        super(eiVar.a(), eiVar.f());
        this.f24425c = Language.zh;
        this.b = w6Var;
        this.d = overSeaSource;
        this.f24424a = eiVar;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider
    public Bitmap getLogo(boolean z) {
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
    public URL getTileUrl(int i, int i2, int i3) {
        String a2 = this.f24424a.a(i, i2, i3, this.f24425c.name());
        if (a2 != null) {
            na.c(ma.h, "请求海外图瓦片：" + a2);
            try {
                return new URL(a2);
            } catch (MalformedURLException e) {
                na.b(Log.getStackTraceString(e));
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider
    public boolean onLanguageChange(Language language) {
        this.f24425c = language;
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
    public NetResponse requestTileData(String str) {
        NetResponse doGet = NetManager.getInstance().builder().url(str).doGet();
        byte[] bArr = doGet != null ? doGet.data : null;
        if (bArr != null && bArr.length != 0 && this.b != null) {
            int ordinal = this.d.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    return doGet;
                }
                this.b.n().a(1);
                return doGet;
            }
            this.b.n().b(1);
        }
        return doGet;
    }
}
