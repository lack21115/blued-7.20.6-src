package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.Pair;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/w3.class */
public class w3 extends v3 {
    public LruCache<String, Pair<Double, Double>> d;

    public w3(String str) {
        super(str, "check cell");
        this.d = new LruCache<>(100);
    }

    @Override // c.t.m.g.v3
    public void a() {
        super.a();
        this.d.evictAll();
    }

    @Override // c.t.m.g.v3
    public boolean b(Bundle bundle) {
        String string = bundle.getString("cellkey");
        Location location = (Location) bundle.getParcelable("location");
        if (location == null) {
            return true;
        }
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        Pair<Double, Double> pair = this.d.get(string);
        if (pair != null) {
            return f6.a(location.getLatitude(), location.getLongitude(), pair.first.doubleValue(), pair.second.doubleValue()) < 6000.0d;
        }
        this.d.put(string, Pair.create(Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
        return true;
    }
}
