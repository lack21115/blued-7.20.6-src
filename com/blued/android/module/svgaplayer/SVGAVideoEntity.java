package com.blued.android.module.svgaplayer;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGASoundManager;
import com.blued.android.module.svgaplayer.entities.SVGAAudioEntity;
import com.blued.android.module.svgaplayer.entities.SVGAVideoData;
import com.blued.android.module.svgaplayer.proto.AudioEntity;
import com.blued.android.module.svgaplayer.proto.MovieEntity;
import com.blued.android.module.svgaplayer.utils.log.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okio.ByteString;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/SVGAVideoEntity.class */
public final class SVGAVideoEntity {

    /* renamed from: a  reason: collision with root package name */
    private SVGAVideoData f15978a;
    private final String b = "SVGAVideoEntity";

    /* renamed from: c  reason: collision with root package name */
    private SVGASoundManager.SVGASoundCallBack f15979c;
    private SVGAParser.PlayCallback d;
    private Function0<Unit> e;
    private SoundPool f;

    public SVGAVideoEntity(SVGAVideoData sVGAVideoData) {
        this.f15978a = sVGAVideoData;
    }

    private final SVGAAudioEntity a(AudioEntity audioEntity, HashMap<String, File> hashMap) {
        SVGAAudioEntity sVGAAudioEntity = new SVGAAudioEntity(audioEntity);
        Integer num = audioEntity.startTime;
        double intValue = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.totalTime;
        double intValue2 = num2 != null ? num2.intValue() : 0;
        if (((int) intValue2) == 0) {
            return sVGAAudioEntity;
        }
        SVGAParser.PlayCallback playCallback = this.d;
        if (playCallback != null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, File> entry : hashMap.entrySet()) {
                arrayList.add(entry.getValue());
            }
            playCallback.a(arrayList);
            Function0<Unit> function0 = this.e;
            if (function0 != null) {
                function0.invoke();
            }
            return sVGAAudioEntity;
        }
        File file = hashMap.get(audioEntity.audioKey);
        if (file == null) {
            return sVGAAudioEntity;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            double available = fileInputStream2.available();
            long j = (long) ((intValue / intValue2) * available);
            if (SVGASoundManager.f15975a.a()) {
                sVGAAudioEntity.a(Integer.valueOf(SVGASoundManager.f15975a.a(this.f15979c, fileInputStream2.getFD(), j, (long) available, 1)));
            } else {
                SoundPool soundPool = this.f;
                sVGAAudioEntity.a(soundPool != null ? Integer.valueOf(soundPool.load(fileInputStream2.getFD(), j, (long) available, 1)) : null);
            }
            Unit unit = Unit.f42314a;
            CloseableKt.a(fileInputStream, null);
            return sVGAAudioEntity;
        } finally {
        }
    }

    private final File a(File file, byte[] bArr) {
        file.createNewFile();
        new FileOutputStream(file).write(bArr);
        return file;
    }

    private final HashMap<String, File> a(MovieEntity movieEntity) {
        HashMap<String, byte[]> b = b(movieEntity);
        HashMap<String, File> hashMap = new HashMap<>();
        HashMap<String, byte[]> hashMap2 = b;
        if (hashMap2.size() > 0) {
            for (Map.Entry<String, byte[]> entry : hashMap2.entrySet()) {
                File f = SVGACache.f15940a.f(entry.getKey());
                HashMap<String, File> hashMap3 = hashMap;
                String key = entry.getKey();
                File file = f.exists() ? f : null;
                File file2 = file;
                if (file == null) {
                    file2 = a(f, entry.getValue());
                }
                hashMap3.put(key, file2);
            }
        }
        return hashMap;
    }

    private final void a(MovieEntity movieEntity, Function0<Unit> function0) {
        if ((movieEntity != null ? movieEntity.audios : null) != null) {
            List<AudioEntity> list = movieEntity.audios;
            boolean z = true;
            if (!((list == null || !list.isEmpty()) ? false : false)) {
                b(movieEntity, function0);
                HashMap<String, File> a2 = a(movieEntity);
                if (a2.size() == 0) {
                    function0.invoke();
                    return;
                }
                SVGAVideoData sVGAVideoData = this.f15978a;
                if (sVGAVideoData == null) {
                    return;
                }
                List<AudioEntity> list2 = movieEntity.audios;
                Intrinsics.c(list2, "entity.audios");
                List<AudioEntity> list3 = list2;
                ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) list3, 10));
                for (AudioEntity audio : list3) {
                    Intrinsics.c(audio, "audio");
                    arrayList.add(a(audio, a2));
                }
                sVGAVideoData.b(arrayList);
                return;
            }
        }
        function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.IntRef soundLoaded, MovieEntity entity, Function0 completionBlock, SoundPool soundPool, int i, int i2) {
        Intrinsics.e(soundLoaded, "$soundLoaded");
        Intrinsics.e(entity, "$entity");
        Intrinsics.e(completionBlock, "$completionBlock");
        LogUtils.f16034a.a("SVGAParser", "pool_complete");
        soundLoaded.f42543a++;
        int i3 = soundLoaded.f42543a;
        List<AudioEntity> list = entity.audios;
        Intrinsics.c(list, "entity.audios");
        if (i3 >= list.size()) {
            completionBlock.invoke();
        }
    }

    private final HashMap<String, byte[]> b(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        HashMap<String, byte[]> hashMap = new HashMap<>();
        Map<String, ByteString> map = movieEntity.images;
        if (map != null && (entrySet = map.entrySet()) != null) {
            for (Map.Entry<String, ByteString> entry : entrySet) {
                String imageKey = entry.getKey();
                byte[] byteArray = entry.getValue().toByteArray();
                if (byteArray.length >= 4) {
                    List<Byte> a2 = ArraysKt.a(byteArray, new IntRange(0, 3));
                    if (a2.get(0).byteValue() == 73 && a2.get(1).byteValue() == 68 && a2.get(2).byteValue() == 51) {
                        Intrinsics.c(imageKey, "imageKey");
                        hashMap.put(imageKey, byteArray);
                    } else if (a2.get(0).byteValue() == -1 && a2.get(1).byteValue() == -5 && a2.get(2).byteValue() == -108) {
                        Intrinsics.c(imageKey, "imageKey");
                        hashMap.put(imageKey, byteArray);
                    }
                }
            }
        }
        return hashMap;
    }

    private final void b(final MovieEntity movieEntity, final Function0<Unit> function0) {
        final Ref.IntRef intRef = new Ref.IntRef();
        if (SVGASoundManager.f15975a.a()) {
            this.f15979c = new SVGASoundManager.SVGASoundCallBack() { // from class: com.blued.android.module.svgaplayer.SVGAVideoEntity$setupSoundPool$1
            };
            return;
        }
        this.f = c(movieEntity);
        LogUtils.f16034a.a("SVGAParser", "pool_start");
        SoundPool soundPool = this.f;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.blued.android.module.svgaplayer.-$$Lambda$SVGAVideoEntity$TkeeMuzfqBwXxTObX_jlMWRr8gM
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public final void onLoadComplete(SoundPool soundPool2, int i, int i2) {
                    SVGAVideoEntity.a(Ref.IntRef.this, movieEntity, function0, soundPool2, i, i2);
                }
            });
        }
    }

    private final SoundPool c(MovieEntity movieEntity) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                List<AudioEntity> list = movieEntity.audios;
                Intrinsics.c(list, "entity.audios");
                return new SoundPool(RangesKt.d(12, list.size()), 3, 0);
            }
            SoundPool.Builder audioAttributes = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build());
            List<AudioEntity> list2 = movieEntity.audios;
            Intrinsics.c(list2, "entity.audios");
            return audioAttributes.setMaxStreams(RangesKt.d(12, list2.size())).build();
        } catch (Exception e) {
            LogUtils.f16034a.a(this.b, e);
            return null;
        }
    }

    public final SVGAVideoData a() {
        return this.f15978a;
    }

    public final void a(Function0<Unit> callback, SVGAParser.PlayCallback playCallback) {
        Intrinsics.e(callback, "callback");
        this.e = callback;
        this.d = playCallback;
        SVGAVideoData sVGAVideoData = this.f15978a;
        if ((sVGAVideoData != null ? sVGAVideoData.b() : null) == null) {
            Function0<Unit> function0 = this.e;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        SVGAVideoData sVGAVideoData2 = this.f15978a;
        MovieEntity movieEntity = null;
        if (sVGAVideoData2 != null) {
            movieEntity = sVGAVideoData2.b();
        }
        a(movieEntity, new Function0<Unit>() { // from class: com.blued.android.module.svgaplayer.SVGAVideoEntity$prepare$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final void a() {
                Function0 function02;
                function02 = SVGAVideoEntity.this.e;
                if (function02 != null) {
                    function02.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* synthetic */ Unit invoke() {
                a();
                return Unit.f42314a;
            }
        });
    }

    public final SoundPool b() {
        return this.f;
    }

    public final void c() {
        List<SVGAAudioEntity> g;
        if (SVGASoundManager.f15975a.a()) {
            SVGAVideoData sVGAVideoData = this.f15978a;
            if (sVGAVideoData != null && (g = sVGAVideoData.g()) != null) {
                for (SVGAAudioEntity sVGAAudioEntity : g) {
                    Integer d = sVGAAudioEntity.d();
                    if (d != null) {
                        SVGASoundManager.f15975a.a(d.intValue());
                    }
                }
            }
            this.f15979c = null;
        }
        this.e = null;
        SoundPool soundPool = this.f;
        if (soundPool != null) {
            soundPool.release();
        }
        this.f = null;
        this.f15978a = null;
    }
}
