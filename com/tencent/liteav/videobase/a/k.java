package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import java.lang.reflect.Array;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/k.class */
public abstract class k extends b {

    /* renamed from: a  reason: collision with root package name */
    public final a f36583a;
    private a f;
    private int[] g;
    private int h;
    private com.tencent.liteav.videobase.frame.d i;
    private FloatBuffer j;
    private FloatBuffer k;
    private final List<a> d = new ArrayList();
    private final Map<a, Integer> e = new HashMap();
    private final FloatBuffer b = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: c  reason: collision with root package name */
    private final FloatBuffer f36584c = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final b f36585a;
        final Map<String, a> b;

        /* renamed from: c  reason: collision with root package name */
        com.tencent.liteav.videobase.frame.d f36586c;
        int d;

        private a(b bVar) {
            this.b = new HashMap();
            this.f36586c = null;
            this.d = 0;
            this.f36585a = bVar;
        }

        /* synthetic */ a(b bVar, byte b) {
            this(bVar);
        }

        public final void a(a aVar) {
            aVar.d++;
            this.b.put("input-texture-name-for-on-draw", aVar);
        }

        public final void a(String str, a aVar) {
            aVar.d++;
            this.b.put(str, aVar);
        }
    }

    public k() {
        a aVar = new a(null, (byte) 0);
        this.f36583a = aVar;
        this.d.add(aVar);
    }

    private void a(a aVar) {
        for (a aVar2 : aVar.b.values()) {
            if (aVar2 != this.f36583a && aVar2.f36586c == null) {
                a(aVar2);
            }
        }
        if (aVar.f36585a instanceof j) {
            j jVar = (j) aVar.f36585a;
            for (Map.Entry<String, a> entry : aVar.b.entrySet()) {
                if (!"input-texture-name-for-on-draw".equals(entry.getKey())) {
                    if (entry.getValue() == this.f36583a) {
                        jVar.setInputTexture(entry.getKey(), this.h);
                    } else {
                        jVar.setInputTexture(entry.getKey(), entry.getValue().f36586c.a());
                    }
                }
            }
        }
        com.tencent.liteav.videobase.frame.d dVar = this.i;
        int i = this.mOutputSize.f36340a;
        int i2 = this.mOutputSize.b;
        if (aVar != this.f) {
            i = aVar.f36585a.getOutputSize().f36340a;
            i2 = aVar.f36585a.getOutputSize().b;
            aVar.f36586c = this.mTexturePool.a(i, i2);
            dVar = aVar.f36586c;
        }
        a aVar3 = aVar.b.get("input-texture-name-for-on-draw");
        GLES20.glViewport(0, 0, i, i2);
        if (aVar3 == this.f36583a) {
            aVar.f36585a.onDraw(this.h, dVar, this.j, this.k);
        } else {
            aVar.f36585a.onDraw(aVar3.f36586c.a(), dVar, this.b, this.f36584c);
        }
        for (a aVar4 : aVar.b.values()) {
            int intValue = this.e.get(aVar4).intValue();
            int[] iArr = this.g;
            iArr[intValue] = iArr[intValue] + 1;
            if (aVar4.f36586c != null && this.g[intValue] == aVar4.d) {
                aVar4.f36586c.release();
                aVar4.f36586c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a a(b bVar) {
        a aVar = new a(bVar, (byte) 0);
        this.d.add(aVar);
        return aVar;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            this.h = i;
            this.i = dVar;
            this.j = floatBuffer;
            this.k = floatBuffer2;
            Arrays.fill(this.g, 0);
            a(this.f);
            Iterator<a> it = this.d.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        for (a aVar : this.d) {
            if (aVar.f36585a != null) {
                aVar.f36585a.initialize(eVar);
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                break;
            }
            this.e.put(this.d.get(i2), Integer.valueOf(i2));
            i = i2 + 1;
        }
        int size = this.d.size();
        ArrayList<Integer> arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            arrayList.add(Integer.valueOf(i4));
            i3 = i4 + 1;
        }
        boolean[][] zArr = (boolean[][]) Array.newInstance(Boolean.TYPE, size, size);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= this.d.size()) {
                break;
            }
            Arrays.fill(zArr[i6], false);
            i5 = i6 + 1;
        }
        for (a aVar2 : this.d) {
            int intValue = this.e.get(aVar2).intValue();
            for (a aVar3 : aVar2.b.values()) {
                zArr[this.e.get(aVar3).intValue()][intValue] = true;
            }
        }
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        ArrayList<Integer> arrayList2 = new ArrayList();
        while (arrayList.size() > 1) {
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            arrayList2.clear();
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size) {
                    break;
                }
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < size) {
                        if (zArr[i8][i10]) {
                            iArr2[i8] = iArr2[i8] + 1;
                            iArr[i10] = iArr[i10] + 1;
                        }
                        i9 = i10 + 1;
                    }
                }
                i7 = i8 + 1;
            }
            for (Integer num : arrayList) {
                int intValue2 = num.intValue();
                if (iArr[intValue2] == 0 && iArr2[intValue2] != 0) {
                    arrayList2.add(Integer.valueOf(intValue2));
                }
            }
            if (arrayList2.isEmpty()) {
                break;
            }
            arrayList.removeAll(arrayList2);
            for (Integer num2 : arrayList2) {
                Arrays.fill(zArr[num2.intValue()], false);
            }
        }
        a aVar4 = arrayList.size() == 1 ? this.d.get(((Integer) arrayList.get(0)).intValue()) : null;
        this.f = aVar4;
        if (aVar4 == null) {
            throw new RuntimeException("Directed acyclic graph can't find a final node.");
        }
        this.g = new int[this.d.size()];
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        for (a aVar : this.d) {
            if (aVar.f36585a != null) {
                aVar.f36585a.onOutputSizeChanged(i, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        for (a aVar : this.d) {
            if (aVar.f36585a != null) {
                aVar.f36585a.uninitialize();
            }
        }
    }
}
