package a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.xiaomi.mipush.sdk.MiPushClient;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/g/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public AudioManager f1379a;
    public BroadcastReceiver b = new a();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/g/c$a.class */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (c.this.f1379a != null && 1 == intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE, -1)) {
                e.g.c("BluetoothScoManager", "setBluetoothScoOn to true");
                c.this.f1379a.setBluetoothScoOn(true);
            }
        }
    }

    public void a(Context context) {
        if (this.f1379a == null) {
            this.f1379a = (AudioManager) context.getSystemService("audio");
        }
        AudioManager audioManager = this.f1379a;
        if (audioManager == null || !audioManager.isBluetoothScoAvailableOffCall()) {
            return;
        }
        e.g.c("BluetoothScoManager", "register");
        this.f1379a.stopBluetoothSco();
        try {
            this.f1379a.startBluetoothSco();
            context.registerReceiver(this.b, new IntentFilter(AudioManager.ACTION_SCO_AUDIO_STATE_CHANGED));
        } catch (Exception e) {
            e eVar = e.g;
            eVar.e("BluetoothScoManager", "Exception when startBluetoothSco & registerReceiver:" + e.getMessage());
        }
    }

    public void b(Context context) {
        AudioManager audioManager = this.f1379a;
        if (audioManager == null || !audioManager.isBluetoothScoAvailableOffCall()) {
            return;
        }
        e.g.c("BluetoothScoManager", MiPushClient.COMMAND_UNREGISTER);
        try {
            context.unregisterReceiver(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f1379a.isBluetoothScoOn()) {
            this.f1379a.setBluetoothScoOn(false);
            this.f1379a.stopBluetoothSco();
        }
    }
}
