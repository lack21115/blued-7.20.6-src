package c.t.m.g;

import android.bluetooth.BluetoothDevice;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/z4.class */
public class z4 implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public int f4026a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f4027c;
    public int d;
    public long e;

    public static z4 a(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        int i2;
        boolean z;
        if (bluetoothDevice == null) {
            return null;
        }
        int i3 = 2;
        while (true) {
            i2 = i3;
            z = false;
            if (i2 <= 5) {
                if ((bArr[i2 + 2] & 255) == 2 && (bArr[i2 + 3] & 255) == 21) {
                    z = true;
                    break;
                }
                i3 = i2 + 1;
            } else {
                break;
            }
        }
        if (z) {
            z4 z4Var = new z4();
            z4Var.a(((bArr[i2 + 20] & 255) * 256) + (bArr[i2 + 21] & 255));
            z4Var.b(((bArr[i2 + 22] & 255) * 256) + (bArr[i2 + 23] & 255));
            z4Var.c(i);
            z4Var.a(bluetoothDevice.getAddress().toUpperCase());
            z4Var.b(bluetoothDevice.getName());
            z4Var.a(System.currentTimeMillis());
            return z4Var;
        }
        return null;
    }

    public static String a(List<z4> list) {
        if (list == null || list.size() == 0) {
            return "[]";
        }
        JSONArray jSONArray = new JSONArray();
        for (z4 z4Var : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("mac", z4Var.a());
                jSONObject.put("major", z4Var.b());
                jSONObject.put("minor", z4Var.c());
                jSONObject.put("rssi", z4Var.d());
                jSONObject.put("time", z4Var.e() / 1000);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public String a() {
        return this.f4027c;
    }

    public void a(int i) {
        this.f4026a = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.f4027c = str;
    }

    public int b() {
        return this.f4026a;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(String str) {
    }

    public int c() {
        return this.b;
    }

    public void c(int i) {
        this.d = i;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public int d() {
        return this.d;
    }

    public long e() {
        return this.e;
    }

    public String toString() {
        return "Beacon [major=" + this.f4026a + ", minor=" + this.b + ", bluetoothAddress=" + this.f4027c + ", rssi=" + this.d + ", time=" + this.e + "]";
    }
}
