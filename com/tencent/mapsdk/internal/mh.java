package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.glmodel.GLModelOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.internal.g4;
import com.tencent.mapsdk.internal.h4;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.File;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mh.class */
public class mh implements lh {
    @Override // com.tencent.mapsdk.internal.lh
    public BaseOverlayProvider a(g4 g4Var) {
        if ((g4Var instanceof h4) && g4Var.a()) {
            h4 h4Var = (h4) g4Var;
            g4.a.C0787a.c cVar = (g4.a.C0787a.c) h4Var.b.b.b.get(0);
            if (TextUtils.isEmpty(cVar.b)) {
                return null;
            }
            LatLng latLng = h4Var.b.f23821c.f23822c.f23823a.f23826a.f23824a;
            GLModelOverlayProvider gLModelOverlayProvider = new GLModelOverlayProvider(cVar.b, new LatLng(latLng.latitude, latLng.longitude, latLng.altitude));
            List<Double> list = h4Var.b.f23821c.f23822c.f23823a.f23826a.b;
            if (list != null && list.size() == 3) {
                gLModelOverlayProvider.rotationX(list.get(0).floatValue() + 90.0f).rotationY(list.get(1).floatValue()).rotationZ(list.get(2).floatValue());
            }
            gLModelOverlayProvider.latLngBounds(h4Var.b.f23821c.f23822c.f23823a.f23826a.f);
            if (h4Var.b.f23821c.f23822c.f23823a.f23826a.d) {
                gLModelOverlayProvider.coordType(GLModelOverlayProvider.CoordType.GeoGraphicType);
                gLModelOverlayProvider.scale(h4Var.b.f23821c.f23822c.f23823a.f23826a.f23825c);
            } else {
                gLModelOverlayProvider.coordType(GLModelOverlayProvider.CoordType.PixelType);
                List<Integer> list2 = h4Var.b.f23821c.f23822c.f23823a.f23826a.e;
                if (list2 != null && list2.size() == 2) {
                    gLModelOverlayProvider.pixelBounds(list2.get(0).intValue(), list2.get(1).intValue());
                }
            }
            int i = h4Var.b.f23821c.f23822c.f23823a.f23826a.g.f23781a;
            if (i == 0) {
                gLModelOverlayProvider.animateType(GLModelOverlayProvider.AnimationType.None);
            } else if (i == 1) {
                gLModelOverlayProvider.animateType(GLModelOverlayProvider.AnimationType.FlattenRise);
            }
            gLModelOverlayProvider.setExposure((float) h4Var.b.f23821c.f23822c.f23823a.f23826a.h);
            h4.a.C0791a.C0792a c0792a = h4Var.b.f23821c.d;
            gLModelOverlayProvider.zoomRange(c0792a.f, c0792a.e);
            gLModelOverlayProvider.zIndex(h4Var.b.f23821c.d.b);
            gLModelOverlayProvider.displayLevel(h4Var.b.f23821c.d.f23775a);
            gLModelOverlayProvider.opacity((float) h4Var.b.f23821c.d.d);
            gLModelOverlayProvider.visibility(!h4Var.b.f23821c.d.f23776c);
            return gLModelOverlayProvider;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(g4 g4Var, String str) {
        h4 h4Var = g4Var;
        if (g4Var instanceof h4) {
            h4 h4Var2 = (h4) g4Var;
            g4.a.C0787a.c cVar = (g4.a.C0787a.c) h4Var2.b.b.b.get(0);
            String str2 = str + "/model/";
            na.a(ma.x, "# 2次处理数据缓存根目录: [" + str2 + "]");
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(cVar.h);
            String sb2 = sb.toString();
            File file = new File(sb2, cVar.g);
            na.a(ma.x, "# 2次处理数据缓存目标文件: [" + file.getAbsolutePath() + "]");
            if (!file.exists()) {
                if (!TextUtils.isEmpty(cVar.d) && !cVar.d.equals(com.igexin.push.core.b.l)) {
                    cVar.f23770c = cVar.d;
                }
                na.a(ma.x, "2次处理数据请求url: [" + cVar.f23770c + "]");
                NetResponse doGet = NetManager.getInstance().builder().url(cVar.f23770c).doGet();
                if (!doGet.available()) {
                    na.a(ma.x, "2次处理数据请求失败");
                    ((g4.a.C0787a.c) h4Var2.b.b.b.get(0)).b = "";
                    return h4Var2;
                }
                ga.e(new File(str2));
                byte[] bArr = doGet.data;
                File file2 = new File(str2, cVar.f + ".tmp");
                ga.b(file2, bArr);
                ja.b(file2, sb2);
                ga.d(file2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append("# 2次下载处理数据大小: {");
                sb3.append(cVar.f);
                sb3.append("} [");
                byte[] bArr2 = doGet.data;
                sb3.append(bArr2 != null ? bArr2.length : 0);
                sb3.append("]");
                na.a(ma.x, sb3.toString());
                ((g4.a.C0787a.c) h4Var2.b.b.b.get(0)).b = file.getAbsolutePath();
                return h4Var2;
            }
            na.a(ma.x, "2次处理数据已存在缓存中");
            ((g4.a.C0787a.c) h4Var2.b.b.b.get(0)).b = file.getAbsolutePath();
            h4Var = h4Var2;
        }
        return h4Var;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(byte[] bArr) {
        return (g4) JsonUtils.parseToModel(new String(bArr), h4.class, new Object[0]);
    }
}
