package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCSavePreFrameFilter.class */
public class TXCSavePreFrameFilter {
    private e mGLTexturePool;
    private int mSavePreFrameNumber = 1;
    private b mDrawFilter = null;
    private int mVideoWidth = -1;
    private int mVideoHeight = -1;
    private ArrayList<d> mRecyclerTextureBuffers = new ArrayList<>();
    private ArrayList<d> mPreTextureBuffers = new ArrayList<>();

    public void destroy() {
        b bVar = this.mDrawFilter;
        if (bVar != null) {
            bVar.uninitialize();
            this.mDrawFilter = null;
        }
        ArrayList<d> arrayList = this.mRecyclerTextureBuffers;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().release();
            }
            this.mRecyclerTextureBuffers.clear();
            this.mRecyclerTextureBuffers = null;
        }
        ArrayList<d> arrayList2 = this.mPreTextureBuffers;
        if (arrayList2 != null) {
            Iterator<d> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().release();
            }
            this.mPreTextureBuffers.clear();
            this.mPreTextureBuffers = null;
        }
    }

    public void initFilter(e eVar) {
        this.mGLTexturePool = eVar;
        if (this.mDrawFilter == null) {
            b bVar = new b();
            this.mDrawFilter = bVar;
            bVar.initialize(eVar);
        }
    }

    public void onDrawToTexture(int i, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mPreTextureBuffers.size() >= this.mSavePreFrameNumber && this.mPreTextureBuffers.size() > 0) {
            d dVar2 = this.mPreTextureBuffers.get(0);
            b bVar = this.mDrawFilter;
            if (bVar != null) {
                bVar.onDraw(dVar2.a(), dVar, floatBuffer, floatBuffer2);
            }
            this.mRecyclerTextureBuffers.add(dVar2);
            this.mPreTextureBuffers.remove(0);
        }
        d remove = this.mRecyclerTextureBuffers.size() > 0 ? this.mRecyclerTextureBuffers.remove(0) : this.mGLTexturePool.a(this.mVideoWidth, this.mVideoHeight);
        if (remove != null) {
            this.mDrawFilter.onDraw(i, remove, floatBuffer, floatBuffer2);
            this.mPreTextureBuffers.add(remove);
        }
    }

    public void onOutputSizeChanged(int i, int i2) {
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        b bVar = this.mDrawFilter;
        if (bVar != null) {
            bVar.onOutputSizeChanged(i, i2);
        }
    }

    public void setSavePreFrameNumber(int i) {
        if (i <= 0) {
            return;
        }
        this.mSavePreFrameNumber = i;
    }
}
