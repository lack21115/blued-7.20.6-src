package com.tencent.turingcam.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/view/spXPg.class */
public class spXPg extends SurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private SurfaceHolderC1060spXPg f39836a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.turingcam.view.spXPg$spXPg  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/view/spXPg$spXPg.class */
    public class SurfaceHolderC1060spXPg implements SurfaceHolder {

        /* renamed from: a  reason: collision with root package name */
        private SurfaceHolder f39837a;
        private List<SurfaceHolder.Callback> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private SurfaceHolder.Callback f39838c;

        /* renamed from: com.tencent.turingcam.view.spXPg$spXPg$spXPg  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/view/spXPg$spXPg$spXPg.class */
        class SurfaceHolder$CallbackC1061spXPg implements SurfaceHolder.Callback {
            SurfaceHolder$CallbackC1061spXPg() {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                Log.i("MFASurfaceView", "[method: surfaceChanged ] ");
                if (SurfaceHolderC1060spXPg.this.b != null) {
                    for (SurfaceHolder.Callback callback : SurfaceHolderC1060spXPg.this.b) {
                        callback.surfaceChanged(surfaceHolder, i, i2, i3);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Log.i("MFASurfaceView", "[method: surfaceCreated ] ");
                if (SurfaceHolderC1060spXPg.this.b != null) {
                    for (SurfaceHolder.Callback callback : SurfaceHolderC1060spXPg.this.b) {
                        callback.surfaceCreated(surfaceHolder);
                    }
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.i("MFASurfaceView", "[method: surfaceDestroyed ] ");
                if (SurfaceHolderC1060spXPg.this.b != null) {
                    for (SurfaceHolder.Callback callback : SurfaceHolderC1060spXPg.this.b) {
                        callback.surfaceDestroyed(surfaceHolder);
                    }
                    SurfaceHolderC1060spXPg.this.b.clear();
                }
            }
        }

        SurfaceHolderC1060spXPg(spXPg spxpg, SurfaceHolder surfaceHolder) {
            this.f39837a = null;
            SurfaceHolder$CallbackC1061spXPg surfaceHolder$CallbackC1061spXPg = new SurfaceHolder$CallbackC1061spXPg();
            this.f39838c = surfaceHolder$CallbackC1061spXPg;
            this.f39837a = surfaceHolder;
            surfaceHolder.addCallback(surfaceHolder$CallbackC1061spXPg);
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
            List<SurfaceHolder.Callback> list = this.b;
            if (list == null || list.contains(callback)) {
                return;
            }
            Log.i("MFASurfaceView", "[method: addCallback ] " + callback);
            this.b.add(callback);
        }

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                return surfaceHolder.getSurface();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                return surfaceHolder.getSurfaceFrame();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                return surfaceHolder.isCreating();
            }
            return false;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                return surfaceHolder.lockCanvas();
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect rect) {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                return surfaceHolder.lockCanvas(rect);
            }
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
            List<SurfaceHolder.Callback> list = this.b;
            if (list != null) {
                list.remove(callback);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i, int i2) {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                surfaceHolder.setFixedSize(i, i2);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int i) {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                surfaceHolder.setFormat(i);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z) {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(z);
            }
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                surfaceHolder.setSizeFromLayout();
            }
        }

        @Override // android.view.SurfaceHolder
        public void setType(int i) {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                surfaceHolder.setType(i);
            }
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
            SurfaceHolder surfaceHolder = this.f39837a;
            if (surfaceHolder != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public spXPg(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public spXPg(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        getHolder();
        Log.i("MFASurfaceView", "[method: init ] ");
    }

    @Override // android.view.SurfaceView
    public SurfaceHolder getHolder() {
        if (this.f39836a == null) {
            this.f39836a = new SurfaceHolderC1060spXPg(this, super.getHolder());
        }
        return this.f39836a;
    }
}
