package c.t.m.g;

import android.content.SharedPreferences;
import java.util.Observable;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/o0.class */
public class o0 extends Observable implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f3855a = "cc_c_t_m_l_";
    public static volatile o0 b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile SharedPreferences f3856c;

    public o0() {
        f3856c = p3.a(f3855a);
    }

    public static o0 a() {
        o0 o0Var;
        synchronized (o0.class) {
            try {
                if (b == null) {
                    synchronized (o0.class) {
                        b = new o0();
                    }
                }
                o0Var = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return o0Var;
    }

    public static void a(String str) {
        f3855a = "cc_c_t_m_l_" + str;
    }

    public SharedPreferences b() {
        SharedPreferences sharedPreferences;
        synchronized (this) {
            if (f3856c == null) {
                f3856c = p3.a(f3855a);
            }
            sharedPreferences = f3856c;
        }
        return sharedPreferences;
    }

    public void c() {
        synchronized (this) {
            if (f3856c != null) {
                addObserver(n0.b());
                f3856c.registerOnSharedPreferenceChangeListener(this);
            }
        }
    }

    public void d() {
        synchronized (this) {
            if (f3856c != null) {
                f3856c.unregisterOnSharedPreferenceChangeListener(this);
                deleteObserver(n0.b());
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        setChanged();
        notifyObservers(str);
    }
}
