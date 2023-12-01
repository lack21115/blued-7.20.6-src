package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.map.tools.json.JsonEncoder;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.q1;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayer;
import com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/tf.class */
public class tf {
    private static final int f = 256;
    private static final String g = "custom-layer";
    private static final String h = "layer-infos";

    /* renamed from: a  reason: collision with root package name */
    private Context f24333a;
    private pg b;
    private SharedPreferences d;

    /* renamed from: c  reason: collision with root package name */
    private List<uf> f24334c = new ArrayList();
    private Set<b> e = new HashSet();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/tf$a.class */
    public class a extends UrlTileProvider {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ uf f24335a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, uf ufVar) {
            super(i, i2);
            this.f24335a = ufVar;
        }

        @Override // com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
        public URL getTileUrl(int i, int i2, int i3) {
            uf ufVar = this.f24335a;
            if (i3 > ufVar.f24359c || i3 < ufVar.d) {
                return null;
            }
            try {
                return new URL(this.f24335a.a(i, i2, i3));
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/tf$b.class */
    public class b implements JsonEncoder, JsonParser {
        private static final String d = "id";
        private static final String e = "version";

        /* renamed from: a  reason: collision with root package name */
        private String f24336a;
        private String b;

        private b() {
        }

        public /* synthetic */ b(tf tfVar, a aVar) {
            this();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                String str = this.f24336a;
                if (str != null) {
                    if (!str.equals(bVar.f24336a)) {
                        return false;
                    }
                } else if (bVar.f24336a != null) {
                    return false;
                }
                String str2 = this.b;
                String str3 = bVar.b;
                return str2 != null ? str2.equals(str3) : str3 == null;
            }
            return false;
        }

        public int hashCode() {
            String str = this.f24336a;
            int i = 0;
            int hashCode = str != null ? str.hashCode() : 0;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return (hashCode * 31) + i;
        }

        @Override // com.tencent.map.tools.json.JsonParser
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f24336a = jSONObject.optString("id");
                this.b = jSONObject.optString("version");
            }
        }

        @Override // com.tencent.map.tools.json.JsonEncoder
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f24336a);
                jSONObject.put("version", this.b);
                return jSONObject;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return jSONObject;
            }
        }
    }

    public tf(Context context, pg pgVar, q1.b bVar) {
        this.f24333a = context;
        this.b = pgVar;
        this.d = ia.a(context, "custom-layer." + bVar.c());
        a();
    }

    private uf a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (uf ufVar : this.f24334c) {
            if (ufVar != null && str.equals(ufVar.f24358a)) {
                return ufVar;
            }
        }
        return null;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.d;
        if (sharedPreferences == null) {
            return;
        }
        String string = sharedPreferences.getString(h, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return;
                }
                try {
                    this.e.add((b) JsonUtils.parseToModel(jSONArray.getJSONObject(i2), b.class, this));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i = i2 + 1;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private TileOverlayOptions b(CustomLayerOptions customLayerOptions) {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        String str = "custom_layer_" + xa.a(customLayerOptions.getLayerId());
        tileOverlayOptions.diskCacheDir(str);
        uf a2 = a(customLayerOptions.getLayerId());
        ra.b(ma.f23951a, "cache_dir", (Object) str);
        if (a2 != null) {
            ra.b(ma.f23951a, "version", (Object) a2.b);
            ra.b(ma.f23951a, "minZoom", Integer.valueOf(a2.d));
            ra.b(ma.f23951a, "maxZoom", Integer.valueOf(a2.f24359c));
            ra.b(ma.f23951a, "layerId", (Object) a2.f24358a);
            tileOverlayOptions.tileProvider(new a(256, 256, a2));
            tileOverlayOptions.versionInfo(a2.b);
        }
        return tileOverlayOptions;
    }

    private void b() {
        boolean z;
        boolean z2 = false;
        if (!this.e.isEmpty() || this.f24334c.isEmpty()) {
            z2 = false;
            for (uf ufVar : this.f24334c) {
                Iterator<b> it = this.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    b next = it.next();
                    if (next.f24336a.equals(ufVar.f24358a)) {
                        if (!next.b.equalsIgnoreCase(ufVar.b)) {
                            ufVar.h = true;
                            next.b = ufVar.b;
                        }
                        z = true;
                    }
                }
                if (!z) {
                    b bVar = new b(this, null);
                    bVar.f24336a = ufVar.f24358a;
                    bVar.b = ufVar.b;
                    this.e.add(bVar);
                    z2 = true;
                }
            }
        } else {
            for (uf ufVar2 : this.f24334c) {
                b bVar2 = new b(this, null);
                bVar2.f24336a = ufVar2.f24358a;
                bVar2.b = ufVar2.b;
                this.e.add(bVar2);
                z2 = true;
            }
        }
        if (z2) {
            ia.a(this.d).a(h, JsonUtils.collectionToJson(this.e));
        }
    }

    public CustomLayer a(CustomLayerOptions customLayerOptions) {
        if (this.b != null) {
            ra.d(ma.f23951a, "添加个性化图层[" + customLayerOptions.getLayerId() + "]");
            kg b2 = this.b.b(b(customLayerOptions));
            uf a2 = a(customLayerOptions.getLayerId());
            if (b2 != null && a2 != null) {
                if (a2.h) {
                    b2.reload();
                    a2.h = false;
                }
                b2.b(a2.d, a2.f24359c);
            }
            this.b.b().w().q().b();
            ra.j(ma.f23951a);
            return new u0(b2);
        }
        return null;
    }

    public void a(sf sfVar) {
        if (sfVar == null || !sfVar.b()) {
            return;
        }
        this.f24334c.clear();
        this.f24334c.addAll(sfVar.a());
        b();
    }
}
