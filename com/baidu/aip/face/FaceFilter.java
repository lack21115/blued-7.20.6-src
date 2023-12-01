package com.baidu.aip.face;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.util.Pools;
import com.baidu.aip.ImageFrame;
import com.baidu.idl.facesdk.FaceInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceFilter.class */
public class FaceFilter {
    private OnTrackListener onTrackListener;
    private SparseArray<TrackedModel> trackingFaces = new SparseArray<>();
    private Pools.SynchronizedPool<TrackedModel> pool = new Pools.SynchronizedPool<>(5);
    private HashSet<TrackedModel> currentFrame = new HashSet<>();
    private ArrayList<Integer> leftFaces = new ArrayList<>();
    private int angle = 15;

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceFilter$Event.class */
    public enum Event {
        OnEnter,
        OnUpdate,
        OnLeave
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceFilter$OnTrackListener.class */
    public interface OnTrackListener {
        void onTrack(TrackedModel trackedModel);
    }

    /* loaded from: source-8756600-dex2jar.jar:com/baidu/aip/face/FaceFilter$TrackedModel.class */
    public class TrackedModel {
        private Event event;
        private ImageFrame frame;
        private FaceInfo info;
        int[] points = new int[8];
        private String trackId;

        public TrackedModel() {
        }

        public Bitmap cropFace() {
            return cropFace(getFaceRect());
        }

        public Bitmap cropFace(Rect rect) {
            return FaceCropper.getFace(getFrame().getArgb(), this.info, getImageFrame().getWidth());
        }

        public Event getEvent() {
            return this.event;
        }

        public Rect getFaceRect() {
            Rect rect = new Rect();
            getInfo().getRectPoints(this.points);
            int[] iArr = this.points;
            int i = iArr[2];
            int i2 = iArr[3];
            int i3 = iArr[6];
            int i4 = iArr[7];
            int i5 = ((i3 - i) * 8) / 3;
            int i6 = ((i4 - i2) * 10) / 3;
            int i7 = getInfo().mCenter_x - (i5 / 2);
            int i8 = getInfo().mCenter_y - ((i6 * 2) / 3);
            rect.top = i8 < 0 ? 0 : i8;
            rect.left = i7 < 0 ? 0 : i7;
            int i9 = i7 + i5;
            int i10 = i9;
            if (i9 > this.frame.getWidth()) {
                i10 = this.frame.getWidth();
            }
            rect.right = i10;
            int i11 = i8 + i6;
            int i12 = i11;
            if (i11 > this.frame.getHeight()) {
                i12 = this.frame.getHeight();
            }
            rect.bottom = i12;
            return rect;
        }

        public ImageFrame getFrame() {
            return this.frame;
        }

        public ImageFrame getImageFrame() {
            return getFrame();
        }

        public FaceInfo getInfo() {
            return this.info;
        }

        public String getTrackId() {
            return this.trackId;
        }

        public int hashCode() {
            return getInfo().face_id;
        }

        public boolean meetCriteria() {
            float abs = Math.abs(getInfo().headPose[0]);
            float abs2 = Math.abs(getInfo().headPose[1]);
            float abs3 = Math.abs(getInfo().headPose[2]);
            boolean z = false;
            if (abs < FaceFilter.this.angle) {
                z = false;
                if (abs2 < FaceFilter.this.angle) {
                    z = false;
                    if (abs3 < FaceFilter.this.angle) {
                        z = true;
                    }
                }
            }
            return z;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public void setFrame(ImageFrame imageFrame) {
            this.frame = imageFrame;
        }

        public void setInfo(FaceInfo faceInfo) {
            this.info = faceInfo;
        }

        public void setTrackId(String str) {
            this.trackId = str;
        }
    }

    private TrackedModel getTrackedModel(FaceInfo faceInfo, ImageFrame imageFrame) {
        TrackedModel trackedModel = this.trackingFaces.get(faceInfo.face_id);
        TrackedModel trackedModel2 = trackedModel;
        if (trackedModel == null) {
            TrackedModel acquire = this.pool.acquire();
            trackedModel2 = acquire;
            if (acquire == null) {
                trackedModel2 = new TrackedModel();
            }
            this.trackingFaces.append(faceInfo.face_id, trackedModel2);
            trackedModel2.setTrackId(UUID.randomUUID().toString());
            trackedModel2.setEvent(Event.OnEnter);
        }
        trackedModel2.setInfo(faceInfo);
        trackedModel2.setFrame(imageFrame);
        return trackedModel2;
    }

    public void filter(FaceInfo[] faceInfoArr, ImageFrame imageFrame) {
        this.currentFrame.clear();
        if (faceInfoArr != null) {
            int length = faceInfoArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                FaceInfo faceInfo = faceInfoArr[i2];
                TrackedModel trackedModel = getTrackedModel(faceInfo, imageFrame);
                this.currentFrame.add(trackedModel);
                trackedModel.setInfo(faceInfo);
                i = i2 + 1;
            }
        }
        this.leftFaces.clear();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.trackingFaces.size()) {
                break;
            }
            int keyAt = this.trackingFaces.keyAt(i4);
            TrackedModel trackedModel2 = this.trackingFaces.get(keyAt);
            if (!this.currentFrame.contains(trackedModel2)) {
                this.leftFaces.add(Integer.valueOf(keyAt));
            } else if (this.onTrackListener != null) {
                trackedModel2.setFrame(imageFrame);
                this.onTrackListener.onTrack(trackedModel2);
            }
            i3 = i4 + 1;
        }
        Iterator<Integer> it = this.leftFaces.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TrackedModel trackedModel3 = this.trackingFaces.get(next.intValue());
            Log.e("xx", " left:" + trackedModel3);
            trackedModel3.setEvent(Event.OnLeave);
            this.trackingFaces.remove(next.intValue());
            OnTrackListener onTrackListener = this.onTrackListener;
            if (onTrackListener != null) {
                onTrackListener.onTrack(trackedModel3);
            }
        }
    }

    public void setAngle(int i) {
        this.angle = i;
    }

    public void setOnTrackListener(OnTrackListener onTrackListener) {
        this.onTrackListener = onTrackListener;
    }
}
