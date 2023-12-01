package com.tencent.liteav.videobase.a;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.n;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/h.class */
public class h extends b {
    private static final String TAG = "TXCGPUImageFilterChain";
    private final List<b> mFilters = new ArrayList();
    private final Map<b, List<a>> mInterceptorsBeforeFilter = new HashMap();
    private final List<a> mLastInterceptors = new ArrayList();
    private long mTimestamp = 0;
    private final FloatBuffer mNormalCubeVerticesBuffer = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer mNormalTextureCoordsBuffer = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    private com.tencent.liteav.videobase.frame.d doIntercept(List<a> list, com.tencent.liteav.videobase.frame.d dVar) {
        if (list != null && !list.isEmpty()) {
            com.tencent.liteav.videobase.frame.d dVar2 = null;
            Iterator<a> it = list.iterator();
            while (true) {
                com.tencent.liteav.videobase.frame.d dVar3 = dVar2;
                if (!it.hasNext()) {
                    return dVar3;
                }
                dVar2 = it.next().a(this.mTimestamp, dVar3 == null ? dVar : dVar3);
                if (dVar2 == null) {
                    LiteavLog.e(TAG, "doIntercept return null value");
                    return dVar3;
                } else if (dVar3 != null && dVar2 != dVar3) {
                    dVar3.release();
                }
            }
        }
        return dVar;
    }

    private com.tencent.liteav.videobase.frame.d doLastIntercept(com.tencent.liteav.videobase.frame.d dVar) {
        if (this.mLastInterceptors.isEmpty()) {
            return dVar;
        }
        if (dVar == null) {
            LiteavLog.e(TAG, "last interceptors intecept on surface.");
            return null;
        }
        return doIntercept(this.mLastInterceptors, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFiltersAndInterceptors() {
        for (b bVar : this.mFilters) {
            if (!bVar.isInitialized()) {
                bVar.initialize(this.mTexturePool);
            }
        }
        for (List<a> list : this.mInterceptorsBeforeFilter.values()) {
            if (list != null && !list.isEmpty()) {
                for (a aVar : list) {
                    if (!aVar.f36576a) {
                        aVar.a(this.mTexturePool);
                    }
                }
            }
        }
        for (a aVar2 : this.mLastInterceptors) {
            if (!aVar2.f36576a) {
                aVar2.a(this.mTexturePool);
            }
        }
    }

    private void initFiltersAndInterceptorsOnDraw() {
        runOnDraw(i.a(this));
    }

    public void addFilter(b bVar) {
        synchronized (this) {
            if (bVar == null) {
                return;
            }
            if (!this.mLastInterceptors.isEmpty()) {
                if (this.mFilters.size() == 0) {
                    this.mFilters.add(new b());
                    LiteavLog.w(TAG, "add COPY filter to filter chain.");
                }
                this.mInterceptorsBeforeFilter.put(bVar, new ArrayList(this.mLastInterceptors));
                this.mLastInterceptors.clear();
            }
            this.mFilters.add(bVar);
            initFiltersAndInterceptorsOnDraw();
        }
    }

    public void addInterceptor(a aVar) {
        synchronized (this) {
            if (aVar != null) {
                this.mLastInterceptors.add(aVar);
                initFiltersAndInterceptorsOnDraw();
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (i == -1) {
                return;
            }
            List<b> list = this.mFilters;
            int size = list.size();
            com.tencent.liteav.videobase.frame.d dVar2 = null;
            int i2 = 0;
            while (i2 < size) {
                b bVar = list.get(i2);
                n outputSize = bVar.getOutputSize();
                com.tencent.liteav.videobase.frame.d dVar3 = dVar2;
                if (dVar2 != null) {
                    dVar3 = doIntercept(this.mInterceptorsBeforeFilter.get(bVar), dVar2);
                    if (dVar3 != null && dVar3 != dVar2) {
                        dVar2.release();
                    }
                }
                boolean z = i2 < size - 1;
                if (z && outputSize.equals(this.mOutputSize) && bVar.canBeSkipped()) {
                    bVar.onFilterBeenSkipped();
                } else {
                    com.tencent.liteav.videobase.frame.d a2 = z ? this.mTexturePool.a(outputSize.f36340a, outputSize.b) : dVar;
                    OpenGlUtils.glViewport(0, 0, outputSize.f36340a, outputSize.b);
                    int a3 = dVar3 == null ? i : dVar3.a();
                    if (i2 == 0) {
                        bVar.onDraw(a3, a2, floatBuffer, floatBuffer2);
                    } else {
                        bVar.onDraw(a3, a2, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
                    }
                    if (dVar3 != null) {
                        dVar3.release();
                    }
                    dVar3 = a2;
                }
                i2++;
                dVar2 = dVar3;
            }
            if (dVar2 != null && dVar2 != dVar) {
                dVar2.release();
            }
            com.tencent.liteav.videobase.frame.d doLastIntercept = doLastIntercept(dVar);
            if (doLastIntercept == null || doLastIntercept == dVar) {
                return;
            }
            OpenGlUtils.glViewport(0, 0, doLastIntercept.b(), doLastIntercept.c());
            super.onDraw(doLastIntercept.a(), dVar, this.mNormalCubeVerticesBuffer, this.mNormalTextureCoordsBuffer);
            doLastIntercept.release();
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        initFiltersAndInterceptors();
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        for (b bVar : this.mFilters) {
            bVar.onOutputSizeChanged(i, i2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        for (b bVar : this.mFilters) {
            bVar.uninitialize();
        }
        for (List<a> list : this.mInterceptorsBeforeFilter.values()) {
            if (list != null && !list.isEmpty()) {
                for (a aVar : list) {
                    aVar.a();
                }
            }
        }
        for (a aVar2 : this.mLastInterceptors) {
            aVar2.a();
        }
    }

    public void removeAllFilterAndInterceptor() {
        synchronized (this) {
            this.mFilters.clear();
            this.mInterceptorsBeforeFilter.clear();
            this.mLastInterceptors.clear();
        }
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }
}
