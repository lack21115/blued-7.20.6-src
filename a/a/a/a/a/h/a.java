package a.a.a.a.a.h;

import android.media.AudioTrack;
import android.util.Log;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/h/a.class */
public class a {
    public AudioTrack b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1333a = false;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1334c = new byte[0];

    public void a() {
        AudioTrack audioTrack = this.b;
        if (audioTrack != null) {
            this.f1333a = false;
            if (audioTrack.getPlayState() == 3) {
                this.b.stop();
            }
            this.b.release();
            synchronized (this.f1334c) {
                this.b = null;
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        synchronized (this.f1334c) {
            if (this.f1333a && this.b != null) {
                this.b.write(bArr, i, i2);
            }
        }
    }

    public boolean a(int i, int i2, int i3) {
        if (this.b != null) {
            a();
        }
        this.f1333a = false;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        if (minBufferSize == -2) {
            Log.e("PcmPlayer", "Invalid parameter !");
            return false;
        }
        AudioTrack audioTrack = new AudioTrack(3, i, i2, i3, minBufferSize, 1);
        this.b = audioTrack;
        if (audioTrack.getState() == 0) {
            Log.e("PcmPlayer", "AudioTrack initialize fail !");
            return false;
        }
        return true;
    }

    public void b() {
        synchronized (this.f1334c) {
            if (this.b != null) {
                this.b.play();
                this.f1333a = true;
            }
        }
    }
}
