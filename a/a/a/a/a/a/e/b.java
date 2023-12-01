package a.a.a.a.a.a.e;

import android.media.MediaFormat;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/e/b.class */
public class b extends a.a.a.a.a.a.a {
    public b(a.a.a.a.a.a.i.c cVar) {
        super(cVar);
        cVar.b(this);
        a j = cVar.d().j();
        MediaFormat createAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", j.b(), j.d());
        createAudioFormat.setInteger(MediaFormat.KEY_AAC_PROFILE, 2);
        createAudioFormat.setInteger(MediaFormat.KEY_SAMPLE_RATE, j.b());
        createAudioFormat.setInteger(MediaFormat.KEY_CHANNEL_COUNT, j.a());
        createAudioFormat.setInteger(MediaFormat.KEY_BIT_RATE, j.c());
        createAudioFormat.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, 16384);
        this.b = new a.a.a.a.a.a.g.c(createAudioFormat, "audio/mp4a-latm", false);
        c().start();
        this.f1213c = 0;
    }
}
