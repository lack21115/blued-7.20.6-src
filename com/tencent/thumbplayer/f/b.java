package com.tencent.thumbplayer.f;

import android.content.Context;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeatureData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaInnerProcessorCallback;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeature;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaFeatureData;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaProcessor;
import com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaRequestExtraInfo;
import com.tencent.thumbplayer.f.a;
import com.tencent.thumbplayer.tplayer.plugins.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/b.class */
public class b implements com.tencent.thumbplayer.f.a {

    /* renamed from: a  reason: collision with root package name */
    private ITPNativeRichMediaProcessor f39305a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private C1022b f39306c;
    private c d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/b$a.class */
    class a implements ITPNativeRichMediaInnerProcessorCallback {
        private a.InterfaceC1019a b;

        a() {
        }

        public void a(a.InterfaceC1019a interfaceC1019a) {
            this.b = interfaceC1019a;
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaInnerProcessorCallback
        public long onGetCurrentPositionMs(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor) {
            a.InterfaceC1019a interfaceC1019a = this.b;
            if (interfaceC1019a != null) {
                long a2 = interfaceC1019a.a(b.this);
                b.this.a(311, (int) a2, 0, null, null);
                return a2;
            }
            return -1L;
        }
    }

    /* renamed from: com.tencent.thumbplayer.f.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/f/b$b.class */
    class C1022b implements ITPNativeRichMediaProcessorCallback {
        private ITPRichMediaSynchronizerListener b;

        C1022b() {
        }

        public void a(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener) {
            this.b = iTPRichMediaSynchronizerListener;
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onDeselectFeatureSuccess(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i) {
            b.this.a(305, i, 0, null, null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onDeselectFeatureSuccess(b.this, i);
            }
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onRichMediaError(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i) {
            b.this.a(308, i, 0, null, null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaError(b.this, i);
            }
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onRichMediaFeatureData(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData) {
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaFeatureData(b.this, i, new TPRichMediaFeatureData(tPNativeRichMediaFeatureData));
            }
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onRichMediaFeatureFailure(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i, int i2) {
            b.this.a(310, i, i2, null, null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaFeatureFailure(b.this, i, i2);
            }
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onRichMediaInfo(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i, long j, long j2, long j3, Object obj) {
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaInfo(b.this, i, j, j2, j3, obj);
            }
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onRichMediaPrepared(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor) {
            b.this.a(301, 0, 0, null, b.this.getFeatures());
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onRichMediaPrepared(b.this);
            }
        }

        @Override // com.tencent.thumbplayer.core.richmedia.ITPNativeRichMediaProcessorCallback
        public void onSelectFeatureSuccess(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i) {
            b.this.a(303, i, 0, null, null);
            ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener = this.b;
            if (iTPRichMediaSynchronizerListener != null) {
                iTPRichMediaSynchronizerListener.onSelectFeatureSuccess(b.this, i);
            }
        }
    }

    public b(Context context) {
        this.f39305a = new TPNativeRichMediaProcessor(context);
        a aVar = new a();
        this.b = aVar;
        this.f39305a.setInnerProcessorCallback(aVar);
        C1022b c1022b = new C1022b();
        this.f39306c = c1022b;
        this.f39305a.setProcessorCallback(c1022b);
        c cVar = new c();
        this.d = cVar;
        cVar.a(new com.tencent.thumbplayer.f.b.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, String str, Object obj) {
        this.d.a(i, i2, i3, str, obj);
    }

    @Override // com.tencent.thumbplayer.f.a
    public void a(float f) {
        this.f39305a.setPlaybackRate(f);
    }

    @Override // com.tencent.thumbplayer.f.a
    public void a(long j) {
        this.f39305a.seek(j);
    }

    @Override // com.tencent.thumbplayer.f.a
    public void a(a.InterfaceC1019a interfaceC1019a) {
        this.b.a(interfaceC1019a);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void deselectFeatureAsync(int i) {
        this.f39305a.deselectFeatureAsync(i);
        a(304, i, 0, null, null);
    }

    protected void finalize() {
        this.f39305a.setInnerProcessorCallback(null);
        this.f39305a.setProcessorCallback(null);
        this.f39305a.release();
        this.f39306c.a(null);
        this.b.a(null);
        super.finalize();
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public TPRichMediaFeature[] getFeatures() {
        TPNativeRichMediaFeature[] features = this.f39305a.getFeatures();
        if (features == null) {
            return new TPRichMediaFeature[0];
        }
        TPRichMediaFeature[] tPRichMediaFeatureArr = new TPRichMediaFeature[features.length];
        for (int i = 0; i < features.length && features[i] != null; i++) {
            tPRichMediaFeatureArr[i] = new TPRichMediaFeature(features[i]);
        }
        return tPRichMediaFeatureArr;
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void prepareAsync() {
        this.f39305a.prepareAsync();
        a(300, 0, 0, null, null);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void release() {
        this.f39305a.setInnerProcessorCallback(null);
        this.f39305a.setProcessorCallback(null);
        this.f39305a.release();
        this.f39306c.a(null);
        this.b.a(null);
        a(307, 0, 0, null, null);
        this.d.c();
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void reset() {
        this.f39305a.reset();
        a(306, 0, 0, null, null);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void selectFeatureAsync(int i, TPRichMediaRequestExtraInfo tPRichMediaRequestExtraInfo) {
        TPNativeRichMediaRequestExtraInfo tPNativeRichMediaRequestExtraInfo = new TPNativeRichMediaRequestExtraInfo();
        tPNativeRichMediaRequestExtraInfo.setActOnOptional(tPRichMediaRequestExtraInfo.getActOnOption());
        this.f39305a.selectFeatureAsync(i, tPNativeRichMediaRequestExtraInfo);
        a(302, i, 0, null, null);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener) {
        this.f39306c.a(iTPRichMediaSynchronizerListener);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void setRichMediaSource(String str) {
        this.f39305a.setRichMediaSource(str);
        a(309, 0, 0, str, null);
    }
}
