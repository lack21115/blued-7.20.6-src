package com.tencent.tencentmap.mapsdk.maps.model;

import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/mapsdk/maps/model/TencentMapGestureListenerList.class */
public class TencentMapGestureListenerList implements TencentMapGestureListener {
    private ArrayList<TencentMapGestureListener> mListeners = new ArrayList<>();

    public void addListener(TencentMapGestureListener tencentMapGestureListener) {
        synchronized (this) {
            if (tencentMapGestureListener != null) {
                if (!this.mListeners.contains(tencentMapGestureListener)) {
                    this.mListeners.add(tencentMapGestureListener);
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onDoubleTap(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onDoubleTap(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onDown(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onDown(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onFling(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onFling(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onLongPress(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onLongPress(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public void onMapStable() {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onMapStable();
                    size = i;
                }
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onScroll(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onScroll(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onSingleTap(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onSingleTap(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener
    public boolean onUp(float f, float f2) {
        synchronized (this) {
            int size = this.mListeners.size();
            while (true) {
                int i = size - 1;
                if (i >= 0) {
                    this.mListeners.get(i).onUp(f, f2);
                    size = i;
                }
            }
        }
        return false;
    }

    public void removeListener(TencentMapGestureListener tencentMapGestureListener) {
        synchronized (this) {
            this.mListeners.remove(tencentMapGestureListener);
        }
    }
}
