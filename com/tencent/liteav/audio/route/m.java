package com.tencent.liteav.audio.route;

import android.media.AudioManager;
import android.os.Handler;
import com.tencent.liteav.audio.route.b;
import com.tencent.liteav.base.Log;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m.class */
public final class m {

    /* renamed from: com.tencent.liteav.audio.route.m$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$1.class */
    static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22575a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0067 -> B:42:0x0013). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006b -> B:38:0x001d). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006f -> B:50:0x0027). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0073 -> B:10:0x0031). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0077 -> B:40:0x0045). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007b -> B:36:0x0050). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x007f -> B:48:0x005b). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.a.a().length];
            b = iArr;
            try {
                iArr[b.a.f22579a - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[b.a.b - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[b.a.d - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[b.a.f22580c - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            int[] iArr2 = new int[b.a.values().length];
            f22575a = iArr2;
            try {
                iArr2[b.a.EARPHONE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f22575a[b.a.SPEAKERPHONE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f22575a[b.a.WIRED_HEADSET.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f22575a[b.a.BLUETOOTH_HEADSET.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$a.class */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        protected final AudioManager f22576a;
        final Handler b;
        protected com.tencent.liteav.audio.route.a d;

        /* renamed from: c  reason: collision with root package name */
        protected b.a f22577c = b.a.NONE;
        protected InterfaceC0754a e = null;
        protected int f = 0;
        boolean g = false;
        protected final Runnable h = new Runnable() { // from class: com.tencent.liteav.audio.route.m.a.1
            @Override // java.lang.Runnable
            public final void run() {
                long e = a.this.e();
                a.this.f++;
                a.this.b.removeCallbacks(a.this.h);
                if (!a.this.g || e < 0) {
                    return;
                }
                a.this.b.postDelayed(a.this.h, e);
            }
        };

        /* renamed from: com.tencent.liteav.audio.route.m$a$a  reason: collision with other inner class name */
        /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$a$a.class */
        public interface InterfaceC0754a {
            void a(b.a aVar);

            void b(b.a aVar);
        }

        public a(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            this.d = com.tencent.liteav.audio.route.a.STOPPED;
            this.f22576a = audioManager;
            this.b = handler;
            this.d = aVar;
        }

        public final void a() {
            this.g = true;
            InterfaceC0754a interfaceC0754a = this.e;
            if (interfaceC0754a != null) {
                interfaceC0754a.a(this.f22577c);
            }
            this.b.post(this.h);
        }

        public void a(com.tencent.liteav.audio.route.a aVar) {
            this.d = aVar;
            this.b.removeCallbacks(this.h);
            this.f = 0;
            this.b.post(this.h);
        }

        public final void a(InterfaceC0754a interfaceC0754a) {
            this.e = interfaceC0754a;
        }

        public void a(boolean z) {
        }

        public final void b() {
            c();
            this.b.removeCallbacks(this.h);
            this.g = false;
        }

        protected void c() {
        }

        protected final int d() {
            AudioManager audioManager = this.f22576a;
            if (audioManager != null) {
                try {
                    return audioManager.getMode();
                } catch (Exception e) {
                    Log.i("AudioRouteSwitcher", "Exception occurs in getAudioMode " + e.getMessage(), new Object[0]);
                    return 0;
                }
            }
            return 0;
        }

        protected abstract long e();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$b.class */
    public static final class b extends a {
        private int i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: $VALUES field not found */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$b$a.class */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            public static final int f22579a = 1;
            public static final int b = 2;

            /* renamed from: c  reason: collision with root package name */
            public static final int f22580c = 3;
            public static final int d = 4;
            private static final /* synthetic */ int[] e = {1, 2, 3, 4};

            public static int[] a() {
                return (int[]) e.clone();
            }
        }

        public b(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.i = a.b;
            this.f22577c = b.a.BLUETOOTH_HEADSET;
        }

        private void f() {
            Log.i("AudioRouteSwitcher", "stopBluetoothSco", new Object[0]);
            try {
                this.f22576a.stopBluetoothSco();
                this.f22576a.setBluetoothScoOn(false);
            } catch (Throwable th) {
                Log.w("AudioRouteSwitcher", "stop bluetooth sco exception " + th.getMessage(), new Object[0]);
            }
        }

        @Override // com.tencent.liteav.audio.route.m.a
        public final void a(com.tencent.liteav.audio.route.a aVar) {
            if (this.d.a() != aVar.a()) {
                a(false);
            }
            super.a(aVar);
        }

        @Override // com.tencent.liteav.audio.route.m.a
        public final void a(boolean z) {
            this.i = z ? a.f22579a : a.b;
        }

        @Override // com.tencent.liteav.audio.route.m.a
        protected final void c() {
            Log.i("AudioRouteSwitcher", "beforeStop: stop bluetooth SCO", new Object[0]);
            f();
        }

        @Override // com.tencent.liteav.audio.route.m.a
        protected final long e() {
            if (!this.d.a()) {
                Log.i("AudioRouteSwitcher", "BluetoothHeadsetSwitcher stop sco, mCurrentIOScene: " + this.d + ", AudioMode: " + d(), new Object[0]);
                f();
                return -1L;
            }
            int i = AnonymousClass1.b[this.i - 1];
            if (i == 1) {
                Log.i("AudioRouteSwitcher", "Bluetooth Headset is connected, isBluetoothScoOn:" + this.f22576a.isBluetoothScoOn(), new Object[0]);
                return -1L;
            } else if (i != 2 && i != 3) {
                if (i != 4) {
                    return -1L;
                }
                f();
                this.i = a.d;
                return 4000L;
            } else if (this.f > 5) {
                Log.w("AudioRouteSwitcher", "Bluetooth headset connection failed for 3 times, give it up", new Object[0]);
                this.e.b(this.f22577c);
                return -1L;
            } else {
                Log.i("AudioRouteSwitcher", "BluetoothHeadsetSwitcher start bluetooth SCO mode", new Object[0]);
                try {
                    this.f22576a.setBluetoothScoOn(true);
                    this.f22576a.startBluetoothSco();
                } catch (Throwable th) {
                    Log.w("AudioRouteSwitcher", "start bluetooth sco exception " + th.getMessage(), new Object[0]);
                }
                this.i = a.f22580c;
                return 4000L;
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$c.class */
    public static final class c extends a {
        public c(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f22577c = b.a.EARPHONE;
        }

        @Override // com.tencent.liteav.audio.route.m.a
        protected final long e() {
            long j = this.f < 5 ? 1000L : 4000L;
            if (this.d.a() && this.f22576a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "EarphoneSwitcher switch to earphone", new Object[0]);
                this.f22576a.setSpeakerphoneOn(false);
                return j;
            }
            if (this.f == 0) {
                Log.i("AudioRouteSwitcher", "EarphoneSwitcher do nothing, mCurrentIOScene: " + this.d + ", isSpeakerOn: " + this.f22576a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$d.class */
    public static final class d extends a {
        public d(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f22577c = b.a.SPEAKERPHONE;
        }

        @Override // com.tencent.liteav.audio.route.m.a
        protected final long e() {
            long j = this.f < 5 ? 1000L : 4000L;
            if (this.d.a() && !this.f22576a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "SpeakerSwitcher switch to speakerphone", new Object[0]);
                this.f22576a.setSpeakerphoneOn(true);
                return j;
            }
            if (this.f == 0) {
                Log.i("AudioRouteSwitcher", "SpeakerSwitcher do nothing, mCurrentIOScene: " + this.d + ", isSpeakerOn: " + this.f22576a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/m$e.class */
    public static final class e extends a {
        public e(AudioManager audioManager, Handler handler, com.tencent.liteav.audio.route.a aVar) {
            super(audioManager, handler, aVar);
            this.f22577c = b.a.WIRED_HEADSET;
        }

        @Override // com.tencent.liteav.audio.route.m.a
        protected final long e() {
            long j = this.f < 5 ? 1000L : 4000L;
            if (this.d.a() && this.f22576a.isSpeakerphoneOn()) {
                Log.i("AudioRouteSwitcher", "WiredHeadsetSwitcher switch to wired headset", new Object[0]);
                this.f22576a.setWiredHeadsetOn(true);
                this.f22576a.setSpeakerphoneOn(false);
                return j;
            }
            if (this.f == 0) {
                Log.i("AudioRouteSwitcher", "WiredHeadsetSwitcher do nothing, mCurrentIOScene: " + this.d + ", isWiredHeadsetOn: " + this.f22576a.isWiredHeadsetOn() + ", isSpeakerphoneOn: " + this.f22576a.isSpeakerphoneOn() + ", AudioMode: " + d(), new Object[0]);
            }
            return j;
        }
    }
}
