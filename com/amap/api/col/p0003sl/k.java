package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.amap.api.col.p0003sl.cr;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.k  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/k.class */
public final class k implements cr.a {
    private boolean A;
    private a D;
    private IAMapDelegate b;
    private CustomMapStyleOptions c;
    private int i;
    private Context j;
    private boolean p;
    private boolean q;
    private cr u;
    private cr v;
    private final String a = "__MACOSX";
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private byte[] k = null;
    private byte[] l = null;
    private byte[] m = null;
    private byte[] n = null;
    private byte[] o = null;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private byte[] w = null;
    private byte[] x = null;
    private byte[] y = null;
    private boolean z = false;
    private HashMap<String, byte[]> B = new HashMap<>();
    private MyTrafficStyle C = new MyTrafficStyle();

    /* renamed from: com.amap.api.col.3sl.k$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/k$a.class */
    public interface a {
        void a();
    }

    public k(IAMapDelegate iAMapDelegate, Context context, boolean z) {
        this.i = -1;
        this.p = false;
        this.q = false;
        this.A = false;
        this.b = iAMapDelegate;
        this.j = context;
        this.p = false;
        this.q = false;
        this.A = z;
        this.i = iAMapDelegate.getGLMapEngine().getEngineIDWithType(1);
    }

    private void a(MapConfig mapConfig) {
        byte[] bArr;
        if (!mapConfig.isProFunctionAuthEnable()) {
            this.B.clear();
            return;
        }
        String styleResDataPath = this.c.getStyleResDataPath();
        if (this.c.getStyleResData() == null && !TextUtils.isEmpty(styleResDataPath)) {
            this.c.setStyleResData(FileUtil.readFileContents(styleResDataPath));
        }
        if (this.c.getStyleResData() == null && this.y == null) {
            return;
        }
        byte[] bArr2 = this.y;
        if (bArr2 == null) {
            bArr2 = this.c.getStyleResData();
        }
        if (bArr2 != null) {
            mapConfig.setUseProFunction(true);
            this.B.clear();
            Map uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr2, (String[]) null);
            if (uncompressToByteWithKeys != null) {
                for (String str : uncompressToByteWithKeys.keySet()) {
                    if (str != null && !str.contains("__MACOSX") && (bArr = (byte[]) uncompressToByteWithKeys.get(str)) != null) {
                        if (FileUtil.isGzip(bArr)) {
                            this.B.put(str, bArr);
                        } else {
                            this.B.put(str, FileUtil.compress(bArr));
                        }
                    }
                }
            }
        }
    }

    private void a(String str, boolean z) {
        int i;
        boolean z2;
        int a2 = !TextUtils.isEmpty(str) ? cy.a(str) : Integer.MIN_VALUE;
        IAMapDelegate iAMapDelegate = this.b;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        if (this.m == null) {
            this.m = FileUtil.readFileContentsFromAssets(this.j, "map_assets" + File.separator + "bktile.data");
        }
        if (this.m != null) {
            if (z) {
                i = a2;
                if (a2 == Integer.MIN_VALUE) {
                    z2 = true;
                    this.b.getGLMapEngine().setBackgroundTexture(this.i, dw.a((byte[]) this.m.clone(), 0, a2, z2));
                }
            } else {
                i = 0;
            }
            z2 = false;
            a2 = i;
            this.b.getGLMapEngine().setBackgroundTexture(this.i, dw.a((byte[]) this.m.clone(), 0, a2, z2));
        }
    }

    private void a(JSONObject jSONObject) {
        this.b.getGLMapEngine().setCustomThirdLayerStyle(this.i, jSONObject.toString());
    }

    private void a(byte[] bArr) {
        cv a2;
        JSONObject optJSONObject;
        if (bArr == null || (a2 = cy.a(bArr)) == null || a2.a() == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2.a());
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mapStyle");
            String str = null;
            boolean z = true;
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("bg");
                str = null;
                z = true;
                if (optJSONObject3 != null) {
                    z = optJSONObject3.optBoolean("visible", true);
                    str = optJSONObject3.optString("lineColor", null);
                }
            }
            a(str, z);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("traffic");
            if (optJSONObject4 != null && (optJSONObject = optJSONObject4.optJSONObject("multiFillColors")) != null) {
                int a3 = cy.a(optJSONObject.optString("smooth"));
                int a4 = cy.a(optJSONObject.optString("slow"));
                int a5 = cy.a(optJSONObject.optString("congested"));
                int a6 = cy.a(optJSONObject.optString("seriousCongested"));
                this.C.setSmoothColor(a3);
                this.C.setSlowColor(a4);
                this.C.setCongestedColor(a5);
                this.C.setSeriousCongestedColor(a6);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("third_layer");
            if (optJSONObject5 != null) {
                a(optJSONObject5);
            }
        } catch (Throwable th) {
            iw.c(th, "AMapCustomStyleManager", "setExtraStyle");
            dw.a(th);
        }
    }

    private static String b(String str) {
        int indexOf;
        if (str != null && (indexOf = str.indexOf("99999_")) != -1) {
            return str.substring(0, indexOf).replace("99999_", "");
        }
        return str;
    }

    private static boolean b(byte[] bArr) {
        if (bArr == null) {
            return true;
        }
        try {
            if (bArr.length < 8) {
                return false;
            }
            return ((bArr[4] & 255) | ((((bArr[7] << 24) & View.MEASURED_STATE_MASK) | ((bArr[6] << 16) & 16711680)) | ((bArr[5] << 8) & 65280))) == 2001;
        } catch (Throwable th) {
            iw.c(th, "AMapCustomStyleManager", "checkData");
            dw.a(th);
            return true;
        }
    }

    private static byte[] c(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        } catch (Throwable th) {
            th = th;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read < 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    GLFileUtil.closeQuietly(byteArrayOutputStream);
                    GLFileUtil.closeQuietly(byteArrayInputStream);
                    GLFileUtil.closeQuietly(gZIPInputStream);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                dw.a(th);
                th.printStackTrace();
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
                return null;
            } catch (Throwable th3) {
                GLFileUtil.closeQuietly(byteArrayOutputStream);
                GLFileUtil.closeQuietly(byteArrayInputStream);
                GLFileUtil.closeQuietly(gZIPInputStream);
                throw th3;
            }
        }
    }

    private void f() {
        IAMapDelegate iAMapDelegate = this.b;
        if (iAMapDelegate != null && iAMapDelegate.getGLMapEngine() != null && this.m != null) {
            this.b.getGLMapEngine().setBackgroundTexture(this.i, this.m);
        }
        this.t = false;
    }

    private void g() {
        if (this.A) {
            if (this.l == null) {
                Context context = this.j;
                this.l = c(FileUtil.readFileContentsFromAssets(context, "map_assets" + File.separator + "style_1_16_3569740208.data"));
            }
        } else if (this.l == null) {
            Context context2 = this.j;
            this.l = c(FileUtil.readFileContentsFromAssets(context2, "map_assets" + File.separator + "style_1_18_1627443174.data"));
        }
        this.b.getGLMapEngine().setCustomStyleData(this.i, this.l, this.k);
        this.s = false;
        this.B.clear();
    }

    private void h() {
        if (this.r) {
            if (this.n == null) {
                Context context = this.j;
                this.n = FileUtil.readFileContentsFromAssets(context, "map_assets" + File.separator + "icons-for-custom_5_18_1616413149.data");
            }
            this.r = false;
            this.b.getGLMapEngine().setCustomStyleTexture(this.i, this.n);
        }
    }

    private void i() {
        CustomMapStyleOptions customMapStyleOptions = this.c;
        if (customMapStyleOptions != null) {
            customMapStyleOptions.setStyleId(null);
            this.c.setStyleDataPath(null);
            this.c.setStyleData(null);
            this.c.setStyleTexturePath(null);
            this.c.setStyleTextureData(null);
            this.c.setStyleExtraData(null);
            this.c.setStyleExtraPath(null);
        }
    }

    public final void a() {
        if (this.c == null || this.q) {
            return;
        }
        try {
            MapConfig mapConfig = this.b.getMapConfig();
            if (mapConfig == null) {
                return;
            }
            synchronized (this) {
                if (mapConfig.isHideLogoEnable() && this.b != null && this.b.getUiSettings() != null) {
                    if (this.b.getUiSettings().isLogoEnable()) {
                        if (!this.c.isEnable()) {
                            this.b.getUiSettings().setLogoEnable(true);
                        } else if (this.s) {
                            this.b.getUiSettings().setLogoEnable(false);
                        }
                    } else if (!this.s) {
                        this.b.getUiSettings().setLogoEnable(true);
                    }
                }
                if (this.d) {
                    if (!this.c.isEnable()) {
                        this.b.getGLMapEngine().setNativeMapModeAndStyle(this.i, mapConfig.getMapStyleMode(), mapConfig.getMapStyleTime(), mapConfig.getMapStyleState(), false, false, (StyleItem[]) null);
                        this.s = false;
                        if (mapConfig.isCustomStyleEnable()) {
                            if (mapConfig.getMapStyleMode() == 0 && mapConfig.getMapStyleTime() == 0 && mapConfig.getMapStyleState() == 0) {
                                g();
                            }
                            h();
                            if (this.t) {
                                f();
                            }
                            mapConfig.setCustomStyleEnable(false);
                        }
                        this.d = false;
                        return;
                    }
                    this.b.getGLMapEngine().setNativeMapModeAndStyle(this.i, 0, 0, 0, false, false, (StyleItem[]) null);
                    mapConfig.setCustomStyleEnable(true);
                    this.d = false;
                }
                if (this.f) {
                    String styleTexturePath = this.c.getStyleTexturePath();
                    if (this.c.getStyleTextureData() == null && !TextUtils.isEmpty(styleTexturePath)) {
                        this.c.setStyleTextureData(FileUtil.readFileContents(styleTexturePath));
                    }
                    if (this.c.getStyleTextureData() != null) {
                        this.z = true;
                        if (mapConfig.isProFunctionAuthEnable()) {
                            this.r = true;
                            this.b.getGLMapEngine().setCustomStyleTexture(this.i, this.c.getStyleTextureData());
                            mapConfig.setUseProFunction(true);
                        } else {
                            h();
                        }
                    } else {
                        h();
                        this.z = false;
                    }
                    this.f = false;
                }
                if (this.e) {
                    String styleDataPath = this.c.getStyleDataPath();
                    if (this.c.getStyleData() == null && !TextUtils.isEmpty(styleDataPath)) {
                        this.c.setStyleData(FileUtil.readFileContents(styleDataPath));
                    }
                    if (this.c.getStyleData() == null && this.w == null) {
                        if (this.s) {
                            this.d = true;
                            this.c.setEnable(false);
                        }
                        this.e = false;
                    }
                    if (this.o == null) {
                        Context context = this.j;
                        this.o = c(FileUtil.readFileContentsFromAssets(context, "map_assets" + File.separator + "style-for-custom_0_18_1641525834.data"));
                    }
                    byte[] styleData = this.w != null ? this.w : this.c.getStyleData();
                    if (b(styleData)) {
                        this.b.getGLMapEngine().setCustomStyleData(this.i, styleData, this.o);
                        this.s = true;
                        if (this.b != null) {
                            this.b.resetRenderTime();
                        }
                    } else {
                        dc.a();
                    }
                    this.e = false;
                }
                if (this.g) {
                    String styleExtraPath = this.c.getStyleExtraPath();
                    if (this.c.getStyleExtraData() == null && !TextUtils.isEmpty(styleExtraPath)) {
                        this.c.setStyleExtraData(FileUtil.readFileContents(styleExtraPath));
                    }
                    if (this.c.getStyleExtraData() != null || this.x != null) {
                        byte[] styleExtraData = this.x != null ? this.x : this.c.getStyleExtraData();
                        if (styleExtraData != null) {
                            a(styleExtraData);
                            this.t = true;
                        }
                    }
                    this.g = false;
                }
                if (this.h) {
                    a(mapConfig);
                    this.h = false;
                }
            }
        } catch (Throwable th) {
            iw.c(th, "AMapCustomStyleManager", "updateStyle");
            dw.a(th);
        }
    }

    public final void a(a aVar) {
        this.D = aVar;
    }

    public final void a(CustomMapStyleOptions customMapStyleOptions) {
        if (this.c == null || customMapStyleOptions == null) {
            return;
        }
        synchronized (this) {
            if (!this.p) {
                this.p = true;
                if (this.c.isEnable()) {
                    this.d = true;
                }
            }
            if (this.c.isEnable() != customMapStyleOptions.isEnable()) {
                this.c.setEnable(customMapStyleOptions.isEnable());
                this.d = true;
                dt.b(this.j, customMapStyleOptions.isEnable());
            }
            if (this.c.isEnable()) {
                if (!TextUtils.equals(this.c.getStyleId(), customMapStyleOptions.getStyleId())) {
                    this.c.setStyleId(customMapStyleOptions.getStyleId());
                    String styleId = this.c.getStyleId();
                    if (!TextUtils.isEmpty(styleId) && this.b != null && this.b.getMapConfig() != null && this.b.getMapConfig().isProFunctionAuthEnable()) {
                        if (this.u == null) {
                            if (this.A) {
                                this.u = new cr(this.j, this, 2, "abroad_sdk_json_sdk_780_zip");
                            } else {
                                this.u = new cr(this.j, this, 1, "sdk_780");
                            }
                        }
                        this.u.a(styleId);
                        this.u.b();
                        if (this.v == null) {
                            this.v = new cr(this.j, this, 0, null);
                        }
                        this.v.a(styleId);
                        this.v.b();
                    }
                }
                if (!TextUtils.equals(this.c.getStyleDataPath(), customMapStyleOptions.getStyleDataPath())) {
                    this.c.setStyleDataPath(customMapStyleOptions.getStyleDataPath());
                    this.e = true;
                }
                if (this.c.getStyleData() != customMapStyleOptions.getStyleData()) {
                    this.c.setStyleData(customMapStyleOptions.getStyleData());
                    this.e = true;
                }
                if (!TextUtils.equals(this.c.getStyleTexturePath(), customMapStyleOptions.getStyleTexturePath())) {
                    this.c.setStyleTexturePath(customMapStyleOptions.getStyleTexturePath());
                    this.f = true;
                }
                if (this.c.getStyleTextureData() != customMapStyleOptions.getStyleTextureData()) {
                    this.c.setStyleTextureData(customMapStyleOptions.getStyleTextureData());
                    this.f = true;
                }
                if (!TextUtils.equals(this.c.getStyleExtraPath(), customMapStyleOptions.getStyleExtraPath())) {
                    this.c.setStyleExtraPath(customMapStyleOptions.getStyleExtraPath());
                    this.g = true;
                }
                if (this.c.getStyleExtraData() != customMapStyleOptions.getStyleExtraData()) {
                    this.c.setStyleExtraData(customMapStyleOptions.getStyleExtraData());
                    this.g = true;
                }
                if (!TextUtils.equals(this.c.getStyleResDataPath(), customMapStyleOptions.getStyleResDataPath())) {
                    this.c.setStyleResDataPath(customMapStyleOptions.getStyleResDataPath());
                    this.h = true;
                }
                if (this.c.getStyleResData() != customMapStyleOptions.getStyleResData()) {
                    this.c.setStyleResData(customMapStyleOptions.getStyleResData());
                    this.h = true;
                }
                dt.a(this.j, true);
            } else {
                i();
                dt.a(this.j, false);
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.cr.a
    public final void a(byte[] bArr, int i) {
        MapConfig mapConfig;
        if (this.c != null) {
            synchronized (this) {
                if (this.b != null && (mapConfig = this.b.getMapConfig()) != null && mapConfig.isProFunctionAuthEnable()) {
                    mapConfig.setUseProFunction(true);
                    if (i == 1) {
                        this.w = bArr;
                        this.e = true;
                    } else if (i == 0) {
                        this.x = bArr;
                        this.g = true;
                    } else if (i == 2) {
                        String str = this.c.getStyleId() + "_sdk_780.data";
                        String str2 = this.c.getStyleId() + "_abroad_sdk.json";
                        Map uncompressToByteWithKeys = FileUtil.uncompressToByteWithKeys(bArr, new String[]{str, str2});
                        if (uncompressToByteWithKeys != null) {
                            byte[] bArr2 = (byte[]) uncompressToByteWithKeys.get(str);
                            if (bArr2 != null) {
                                this.w = bArr2;
                                this.e = true;
                            }
                            if (((byte[]) uncompressToByteWithKeys.get(str2)) != null && this.D != null) {
                                this.D.a();
                            }
                        }
                    }
                }
            }
        }
    }

    public final byte[] a(String str) {
        MapConfig mapConfig;
        if (str == null || (mapConfig = this.b.getMapConfig()) == null) {
            return null;
        }
        if (mapConfig.isProFunctionAuthEnable()) {
            for (String str2 : this.B.keySet()) {
                if (str.contains(str2)) {
                    return this.B.get(str2);
                }
            }
            return null;
        }
        return FileUtil.readFileContentsFromAssetsByPreName(this.j, "map_assets", b(str));
    }

    public final void b() {
        if (this.c == null) {
            return;
        }
        synchronized (this) {
            if (this.b != null && this.b.getMapConfig() != null && !this.b.getMapConfig().isProFunctionAuthEnable()) {
                this.c.setStyleId(null);
                this.w = null;
                this.x = null;
                this.y = null;
            }
            this.f = true;
            this.e = true;
            if (this.t) {
                this.g = true;
            }
            this.d = true;
            this.h = true;
        }
    }

    @Override // com.amap.api.col.p0003sl.cr.a
    public final void b(byte[] bArr, int i) {
        a(bArr, i);
    }

    public final void c() {
        if (this.c == null) {
            this.c = new CustomMapStyleOptions();
        }
    }

    public final boolean d() {
        return this.c != null;
    }

    public final void e() {
        synchronized (this) {
            if (this.c != null) {
                this.c.setEnable(false);
                i();
                this.d = true;
            }
        }
    }
}
