package android.media;

import android.Manifest;
import android.app.ActivityThread;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.hardware.display.WifiDisplay;
import android.hardware.display.WifiDisplayStatus;
import android.media.AudioAttributes;
import android.media.IAudioRoutesObserver;
import android.media.IAudioService;
import android.media.IMediaRouterClient;
import android.media.IMediaRouterService;
import android.media.IRemoteVolumeObserver;
import android.media.MediaRouterClientState;
import android.media.session.MediaSession;
import android.os.Handler;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter.class */
public class MediaRouter {
    public static final int AVAILABILITY_FLAG_IGNORE_DEFAULT_ROUTE = 1;
    public static final int CALLBACK_FLAG_PASSIVE_DISCOVERY = 8;
    public static final int CALLBACK_FLAG_PERFORM_ACTIVE_SCAN = 1;
    public static final int CALLBACK_FLAG_REQUEST_DISCOVERY = 4;
    public static final int CALLBACK_FLAG_UNFILTERED_EVENTS = 2;
    static final int ROUTE_TYPE_ANY = 8388615;
    public static final int ROUTE_TYPE_LIVE_AUDIO = 1;
    public static final int ROUTE_TYPE_LIVE_VIDEO = 2;
    public static final int ROUTE_TYPE_REMOTE_DISPLAY = 4;
    public static final int ROUTE_TYPE_USER = 8388608;
    static Static sStatic;
    private static final String TAG = "MediaRouter";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    static final HashMap<Context, MediaRouter> sRouters = new HashMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$Callback.class */
    public static abstract class Callback {
        public abstract void onRouteAdded(MediaRouter mediaRouter, RouteInfo routeInfo);

        public abstract void onRouteChanged(MediaRouter mediaRouter, RouteInfo routeInfo);

        public abstract void onRouteGrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup, int i);

        public void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public abstract void onRouteRemoved(MediaRouter mediaRouter, RouteInfo routeInfo);

        public abstract void onRouteSelected(MediaRouter mediaRouter, int i, RouteInfo routeInfo);

        public abstract void onRouteUngrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup);

        public abstract void onRouteUnselected(MediaRouter mediaRouter, int i, RouteInfo routeInfo);

        public abstract void onRouteVolumeChanged(MediaRouter mediaRouter, RouteInfo routeInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$CallbackInfo.class */
    public static class CallbackInfo {
        public final Callback cb;
        public int flags;
        public final MediaRouter router;
        public int type;

        public CallbackInfo(Callback callback, int i, int i2, MediaRouter mediaRouter) {
            this.cb = callback;
            this.type = i;
            this.flags = i2;
            this.router = mediaRouter;
        }

        public boolean filterRouteEvent(int i) {
            return ((this.flags & 2) == 0 && (this.type & i) == 0) ? false : true;
        }

        public boolean filterRouteEvent(RouteInfo routeInfo) {
            return filterRouteEvent(routeInfo.mSupportedTypes);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$RouteCategory.class */
    public static class RouteCategory {
        final boolean mGroupable;
        boolean mIsSystem;
        CharSequence mName;
        int mNameResId;
        int mTypes;

        RouteCategory(int i, int i2, boolean z) {
            this.mNameResId = i;
            this.mTypes = i2;
            this.mGroupable = z;
        }

        RouteCategory(CharSequence charSequence, int i, boolean z) {
            this.mName = charSequence;
            this.mTypes = i;
            this.mGroupable = z;
        }

        public CharSequence getName() {
            return getName(MediaRouter.sStatic.mResources);
        }

        public CharSequence getName(Context context) {
            return getName(context.getResources());
        }

        CharSequence getName(Resources resources) {
            return this.mNameResId != 0 ? resources.getText(this.mNameResId) : this.mName;
        }

        public List<RouteInfo> getRoutes(List<RouteInfo> list) {
            if (list == null) {
                list = new ArrayList();
            } else {
                list.clear();
            }
            int routeCountStatic = MediaRouter.getRouteCountStatic();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= routeCountStatic) {
                    return list;
                }
                RouteInfo routeAtStatic = MediaRouter.getRouteAtStatic(i2);
                if (routeAtStatic.mCategory == this) {
                    list.add(routeAtStatic);
                }
                i = i2 + 1;
            }
        }

        public int getSupportedTypes() {
            return this.mTypes;
        }

        public boolean isGroupable() {
            return this.mGroupable;
        }

        public boolean isSystem() {
            return this.mIsSystem;
        }

        public String toString() {
            return "RouteCategory{ name=" + ((Object) this.mName) + " types=" + MediaRouter.typesToString(this.mTypes) + " groupable=" + this.mGroupable + " }";
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$RouteGroup.class */
    public static class RouteGroup extends RouteInfo {
        final ArrayList<RouteInfo> mRoutes;
        private boolean mUpdateName;

        RouteGroup(RouteCategory routeCategory) {
            super(routeCategory);
            this.mRoutes = new ArrayList<>();
            this.mGroup = this;
            this.mVolumeHandling = 0;
        }

        public void addRoute(RouteInfo routeInfo) {
            if (routeInfo.getGroup() != null) {
                throw new IllegalStateException("Route " + routeInfo + " is already part of a group.");
            }
            if (routeInfo.getCategory() != this.mCategory) {
                throw new IllegalArgumentException("Route cannot be added to a group with a different category. (Route category=" + routeInfo.getCategory() + " group category=" + this.mCategory + ")");
            }
            int size = this.mRoutes.size();
            this.mRoutes.add(routeInfo);
            routeInfo.mGroup = this;
            this.mUpdateName = true;
            updateVolume();
            routeUpdated();
            MediaRouter.dispatchRouteGrouped(routeInfo, this, size);
        }

        public void addRoute(RouteInfo routeInfo, int i) {
            if (routeInfo.getGroup() != null) {
                throw new IllegalStateException("Route " + routeInfo + " is already part of a group.");
            }
            if (routeInfo.getCategory() != this.mCategory) {
                throw new IllegalArgumentException("Route cannot be added to a group with a different category. (Route category=" + routeInfo.getCategory() + " group category=" + this.mCategory + ")");
            }
            this.mRoutes.add(i, routeInfo);
            routeInfo.mGroup = this;
            this.mUpdateName = true;
            updateVolume();
            routeUpdated();
            MediaRouter.dispatchRouteGrouped(routeInfo, this, i);
        }

        @Override // android.media.MediaRouter.RouteInfo
        CharSequence getName(Resources resources) {
            if (this.mUpdateName) {
                updateName();
            }
            return super.getName(resources);
        }

        public RouteInfo getRouteAt(int i) {
            return this.mRoutes.get(i);
        }

        public int getRouteCount() {
            return this.mRoutes.size();
        }

        void memberNameChanged(RouteInfo routeInfo, CharSequence charSequence) {
            this.mUpdateName = true;
            routeUpdated();
        }

        void memberStatusChanged(RouteInfo routeInfo, CharSequence charSequence) {
            setStatusInt(charSequence);
        }

        void memberVolumeChanged(RouteInfo routeInfo) {
            updateVolume();
        }

        public void removeRoute(int i) {
            RouteInfo remove = this.mRoutes.remove(i);
            remove.mGroup = null;
            this.mUpdateName = true;
            updateVolume();
            MediaRouter.dispatchRouteUngrouped(remove, this);
            routeUpdated();
        }

        public void removeRoute(RouteInfo routeInfo) {
            if (routeInfo.getGroup() != this) {
                throw new IllegalArgumentException("Route " + routeInfo + " is not a member of this group.");
            }
            this.mRoutes.remove(routeInfo);
            routeInfo.mGroup = null;
            this.mUpdateName = true;
            updateVolume();
            MediaRouter.dispatchRouteUngrouped(routeInfo, this);
            routeUpdated();
        }

        @Override // android.media.MediaRouter.RouteInfo
        public void requestSetVolume(int i) {
            int volumeMax = getVolumeMax();
            if (volumeMax == 0) {
                return;
            }
            float f = i / volumeMax;
            int routeCount = getRouteCount();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= routeCount) {
                    break;
                }
                RouteInfo routeAt = getRouteAt(i3);
                routeAt.requestSetVolume((int) (routeAt.getVolumeMax() * f));
                i2 = i3 + 1;
            }
            if (i != this.mVolume) {
                this.mVolume = i;
                MediaRouter.dispatchRouteVolumeChanged(this);
            }
        }

        @Override // android.media.MediaRouter.RouteInfo
        public void requestUpdateVolume(int i) {
            if (getVolumeMax() == 0) {
                return;
            }
            int routeCount = getRouteCount();
            int i2 = 0;
            int i3 = 0;
            while (i3 < routeCount) {
                RouteInfo routeAt = getRouteAt(i3);
                routeAt.requestUpdateVolume(i);
                int volume = routeAt.getVolume();
                int i4 = i2;
                if (volume > i2) {
                    i4 = volume;
                }
                i3++;
                i2 = i4;
            }
            if (i2 != this.mVolume) {
                this.mVolume = i2;
                MediaRouter.dispatchRouteVolumeChanged(this);
            }
        }

        @Override // android.media.MediaRouter.RouteInfo
        void routeUpdated() {
            int i = 0;
            int size = this.mRoutes.size();
            if (size == 0) {
                MediaRouter.removeRouteStatic(this);
                return;
            }
            int i2 = 0;
            boolean z = true;
            boolean z2 = true;
            int i3 = 0;
            while (i3 < size) {
                RouteInfo routeInfo = this.mRoutes.get(i3);
                int i4 = i | routeInfo.mSupportedTypes;
                int volumeMax = routeInfo.getVolumeMax();
                int i5 = i2;
                if (volumeMax > i2) {
                    i5 = volumeMax;
                }
                z &= routeInfo.getPlaybackType() == 0;
                z2 &= routeInfo.getVolumeHandling() == 0;
                i3++;
                i2 = i5;
                i = i4;
            }
            this.mPlaybackType = z ? 0 : 1;
            this.mVolumeHandling = z2 ? 0 : 1;
            this.mSupportedTypes = i;
            this.mVolumeMax = i2;
            this.mIcon = size == 1 ? this.mRoutes.get(0).getIconDrawable() : null;
            super.routeUpdated();
        }

        public void setIconDrawable(Drawable drawable) {
            this.mIcon = drawable;
        }

        public void setIconResource(int i) {
            setIconDrawable(MediaRouter.sStatic.mResources.getDrawable(i));
        }

        @Override // android.media.MediaRouter.RouteInfo
        public String toString() {
            StringBuilder sb = new StringBuilder(super.toString());
            sb.append('[');
            int size = this.mRoutes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    sb.append(']');
                    return sb.toString();
                }
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(this.mRoutes.get(i2));
                i = i2 + 1;
            }
        }

        void updateName() {
            StringBuilder sb = new StringBuilder();
            int size = this.mRoutes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    this.mName = sb.toString();
                    this.mUpdateName = false;
                    return;
                }
                RouteInfo routeInfo = this.mRoutes.get(i2);
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(routeInfo.mName);
                i = i2 + 1;
            }
        }

        void updateVolume() {
            int routeCount = getRouteCount();
            int i = 0;
            int i2 = 0;
            while (i2 < routeCount) {
                int volume = getRouteAt(i2).getVolume();
                int i3 = i;
                if (volume > i) {
                    i3 = volume;
                }
                i2++;
                i = i3;
            }
            if (i != this.mVolume) {
                this.mVolume = i;
                MediaRouter.dispatchRouteVolumeChanged(this);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$RouteInfo.class */
    public static class RouteInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 0;
        public static final int PLAYBACK_TYPE_REMOTE = 1;
        public static final int PLAYBACK_VOLUME_FIXED = 0;
        public static final int PLAYBACK_VOLUME_VARIABLE = 1;
        public static final int STATUS_AVAILABLE = 3;
        public static final int STATUS_CONNECTED = 6;
        public static final int STATUS_CONNECTING = 2;
        public static final int STATUS_IN_USE = 5;
        public static final int STATUS_NONE = 0;
        public static final int STATUS_NOT_AVAILABLE = 4;
        public static final int STATUS_SCANNING = 1;
        final RouteCategory mCategory;
        CharSequence mDescription;
        String mDeviceAddress;
        String mGlobalRouteId;
        RouteGroup mGroup;
        Drawable mIcon;
        CharSequence mName;
        int mNameResId;
        Display mPresentationDisplay;
        private int mRealStatusCode;
        private int mResolvedStatusCode;
        private CharSequence mStatus;
        int mSupportedTypes;
        private Object mTag;
        VolumeCallbackInfo mVcb;
        int mPlaybackType = 0;
        int mVolumeMax = 15;
        int mVolume = 15;
        int mVolumeHandling = 1;
        int mPlaybackStream = 3;
        int mPresentationDisplayId = -1;
        boolean mEnabled = true;
        final IRemoteVolumeObserver.Stub mRemoteVolObserver = new IRemoteVolumeObserver.Stub() { // from class: android.media.MediaRouter.RouteInfo.1
            @Override // android.media.IRemoteVolumeObserver
            public void dispatchRemoteVolumeUpdate(final int i, final int i2) {
                MediaRouter.sStatic.mHandler.post(new Runnable() { // from class: android.media.MediaRouter.RouteInfo.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RouteInfo.this.mVcb != null) {
                            if (i != 0) {
                                RouteInfo.this.mVcb.vcb.onVolumeUpdateRequest(RouteInfo.this.mVcb.route, i);
                            } else {
                                RouteInfo.this.mVcb.vcb.onVolumeSetRequest(RouteInfo.this.mVcb.route, i2);
                            }
                        }
                    }
                });
            }
        };

        RouteInfo(RouteCategory routeCategory) {
            this.mCategory = routeCategory;
        }

        private Display choosePresentationDisplay() {
            Display display;
            if ((this.mSupportedTypes & 2) != 0) {
                Display[] allPresentationDisplays = MediaRouter.sStatic.getAllPresentationDisplays();
                if (this.mPresentationDisplayId >= 0) {
                    int length = allPresentationDisplays.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            return null;
                        }
                        display = allPresentationDisplays[i2];
                        if (display.getDisplayId() == this.mPresentationDisplayId) {
                            break;
                        }
                        i = i2 + 1;
                    }
                } else if (this.mDeviceAddress == null) {
                    if (this != MediaRouter.sStatic.mDefaultAudioVideo || allPresentationDisplays.length <= 0) {
                        return null;
                    }
                    return allPresentationDisplays[0];
                } else {
                    int length2 = allPresentationDisplays.length;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= length2) {
                            return null;
                        }
                        Display display2 = allPresentationDisplays[i4];
                        if (display2.getType() == 3) {
                            display = display2;
                            if (this.mDeviceAddress.equals(display2.getAddress())) {
                                break;
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
                return display;
            }
            return null;
        }

        public RouteCategory getCategory() {
            return this.mCategory;
        }

        public CharSequence getDescription() {
            return this.mDescription;
        }

        public String getDeviceAddress() {
            return this.mDeviceAddress;
        }

        public RouteGroup getGroup() {
            return this.mGroup;
        }

        public Drawable getIconDrawable() {
            return this.mIcon;
        }

        public CharSequence getName() {
            return getName(MediaRouter.sStatic.mResources);
        }

        public CharSequence getName(Context context) {
            return getName(context.getResources());
        }

        CharSequence getName(Resources resources) {
            if (this.mNameResId != 0) {
                CharSequence text = resources.getText(this.mNameResId);
                this.mName = text;
                return text;
            }
            return this.mName;
        }

        public int getPlaybackStream() {
            return this.mPlaybackStream;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public Display getPresentationDisplay() {
            return this.mPresentationDisplay;
        }

        public CharSequence getStatus() {
            return this.mStatus;
        }

        public int getStatusCode() {
            return this.mResolvedStatusCode;
        }

        public int getSupportedTypes() {
            return this.mSupportedTypes;
        }

        public Object getTag() {
            return this.mTag;
        }

        public int getVolume() {
            if (this.mPlaybackType == 0) {
                try {
                    return MediaRouter.sStatic.mAudioService.getStreamVolume(this.mPlaybackStream);
                } catch (RemoteException e) {
                    Log.e(MediaRouter.TAG, "Error getting local stream volume", e);
                    return 0;
                }
            }
            return this.mVolume;
        }

        public int getVolumeHandling() {
            return this.mVolumeHandling;
        }

        public int getVolumeMax() {
            if (this.mPlaybackType == 0) {
                try {
                    return MediaRouter.sStatic.mAudioService.getStreamMaxVolume(this.mPlaybackStream);
                } catch (RemoteException e) {
                    Log.e(MediaRouter.TAG, "Error getting local stream volume", e);
                    return 0;
                }
            }
            return this.mVolumeMax;
        }

        public boolean isConnecting() {
            return this.mResolvedStatusCode == 2;
        }

        public boolean isDefault() {
            return this == MediaRouter.sStatic.mDefaultAudioVideo;
        }

        public boolean isEnabled() {
            return this.mEnabled;
        }

        public boolean isSelected() {
            return this == MediaRouter.sStatic.mSelectedRoute;
        }

        public boolean matchesTypes(int i) {
            return (this.mSupportedTypes & i) != 0;
        }

        public void requestSetVolume(int i) {
            if (this.mPlaybackType != 0) {
                MediaRouter.sStatic.requestSetVolume(this, i);
                return;
            }
            try {
                MediaRouter.sStatic.mAudioService.setStreamVolume(this.mPlaybackStream, i, 0, ActivityThread.currentPackageName());
            } catch (RemoteException e) {
                Log.e(MediaRouter.TAG, "Error setting local stream volume", e);
            }
        }

        public void requestUpdateVolume(int i) {
            if (this.mPlaybackType != 0) {
                MediaRouter.sStatic.requestUpdateVolume(this, i);
                return;
            }
            try {
                MediaRouter.sStatic.mAudioService.setStreamVolume(this.mPlaybackStream, Math.max(0, Math.min(getVolume() + i, getVolumeMax())), 0, ActivityThread.currentPackageName());
            } catch (RemoteException e) {
                Log.e(MediaRouter.TAG, "Error setting local stream volume", e);
            }
        }

        boolean resolveStatusCode() {
            int i;
            int i2 = this.mRealStatusCode;
            int i3 = i2;
            if (isSelected()) {
                i3 = i2;
                switch (i2) {
                    case 1:
                    case 3:
                        i3 = 2;
                        break;
                    case 2:
                        break;
                    default:
                        i3 = i2;
                        break;
                }
            }
            if (this.mResolvedStatusCode == i3) {
                return false;
            }
            this.mResolvedStatusCode = i3;
            switch (i3) {
                case 1:
                    i = 17041073;
                    break;
                case 2:
                    i = 17041074;
                    break;
                case 3:
                    i = 17041075;
                    break;
                case 4:
                    i = 17041076;
                    break;
                case 5:
                    i = 17041077;
                    break;
                default:
                    i = 0;
                    break;
            }
            this.mStatus = i != 0 ? MediaRouter.sStatic.mResources.getText(i) : null;
            return true;
        }

        void routeUpdated() {
            MediaRouter.updateRoute(this);
        }

        public void select() {
            MediaRouter.selectRouteStatic(this.mSupportedTypes, this, true);
        }

        boolean setRealStatusCode(int i) {
            if (this.mRealStatusCode != i) {
                this.mRealStatusCode = i;
                return resolveStatusCode();
            }
            return false;
        }

        void setStatusInt(CharSequence charSequence) {
            if (charSequence.equals(this.mStatus)) {
                return;
            }
            this.mStatus = charSequence;
            if (this.mGroup != null) {
                this.mGroup.memberStatusChanged(this, charSequence);
            }
            routeUpdated();
        }

        public void setTag(Object obj) {
            this.mTag = obj;
            routeUpdated();
        }

        public String toString() {
            return getClass().getSimpleName() + "{ name=" + ((Object) getName()) + ", description=" + ((Object) getDescription()) + ", status=" + ((Object) getStatus()) + ", category=" + getCategory() + ", supportedTypes=" + MediaRouter.typesToString(getSupportedTypes()) + ", presentationDisplay=" + this.mPresentationDisplay + " }";
        }

        boolean updatePresentationDisplay() {
            Display choosePresentationDisplay = choosePresentationDisplay();
            if (this.mPresentationDisplay != choosePresentationDisplay) {
                this.mPresentationDisplay = choosePresentationDisplay;
                return true;
            }
            return false;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$SimpleCallback.class */
    public static class SimpleCallback extends Callback {
        @Override // android.media.MediaRouter.Callback
        public void onRouteAdded(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteGrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup, int i) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteRemoved(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteSelected(MediaRouter mediaRouter, int i, RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUngrouped(MediaRouter mediaRouter, RouteInfo routeInfo, RouteGroup routeGroup) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteUnselected(MediaRouter mediaRouter, int i, RouteInfo routeInfo) {
        }

        @Override // android.media.MediaRouter.Callback
        public void onRouteVolumeChanged(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$Static.class */
    public static class Static implements DisplayManager.DisplayListener {
        boolean mActivelyScanningWifiDisplays;
        final Context mAppContext;
        RouteInfo mBluetoothA2dpRoute;
        final boolean mCanConfigureWifiDisplays;
        IMediaRouterClient mClient;
        MediaRouterClientState mClientState;
        RouteInfo mDefaultAudioVideo;
        boolean mDiscoverRequestActiveScan;
        int mDiscoveryRequestRouteTypes;
        final DisplayManager mDisplayService;
        final Handler mHandler;
        String mPreviousActiveWifiDisplayAddress;
        RouteInfo mSelectedRoute;
        final CopyOnWriteArrayList<CallbackInfo> mCallbacks = new CopyOnWriteArrayList<>();
        final ArrayList<RouteInfo> mRoutes = new ArrayList<>();
        final ArrayList<RouteCategory> mCategories = new ArrayList<>();
        final AudioRoutesInfo mCurAudioRoutesInfo = new AudioRoutesInfo();
        int mCurrentUserId = -1;
        final IAudioRoutesObserver.Stub mAudioRoutesObserver = new IAudioRoutesObserver.Stub() { // from class: android.media.MediaRouter.Static.1
            @Override // android.media.IAudioRoutesObserver
            public void dispatchAudioRoutesChanged(final AudioRoutesInfo audioRoutesInfo) {
                Static.this.mHandler.post(new Runnable() { // from class: android.media.MediaRouter.Static.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Static.this.updateAudioRoutes(audioRoutesInfo);
                    }
                });
            }
        };
        final Resources mResources = Resources.getSystem();
        final IAudioService mAudioService = IAudioService.Stub.asInterface(ServiceManager.getService("audio"));
        final IMediaRouterService mMediaRouterService = IMediaRouterService.Stub.asInterface(ServiceManager.getService(Context.MEDIA_ROUTER_SERVICE));
        final RouteCategory mSystemCategory = new RouteCategory(17041064, 3, false);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$Static$Client.class */
        public final class Client extends IMediaRouterClient.Stub {
            Client() {
            }

            @Override // android.media.IMediaRouterClient
            public void onStateChanged() {
                Static.this.mHandler.post(new Runnable() { // from class: android.media.MediaRouter.Static.Client.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Client.this == Static.this.mClient) {
                            Static.this.updateClientState();
                        }
                    }
                });
            }
        }

        Static(Context context) {
            this.mAppContext = context;
            this.mHandler = new Handler(context.getMainLooper());
            this.mDisplayService = (DisplayManager) context.getSystemService("display");
            this.mSystemCategory.mIsSystem = true;
            this.mCanConfigureWifiDisplays = context.checkPermission(Manifest.permission.CONFIGURE_WIFI_DISPLAY, Process.myPid(), Process.myUid()) == 0;
        }

        private void updatePresentationDisplays(int i) {
            int size = this.mRoutes.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    return;
                }
                RouteInfo routeInfo = this.mRoutes.get(i3);
                if (routeInfo.updatePresentationDisplay() || (routeInfo.mPresentationDisplay != null && routeInfo.mPresentationDisplay.getDisplayId() == i)) {
                    MediaRouter.dispatchRoutePresentationDisplayChanged(routeInfo);
                }
                i2 = i3 + 1;
            }
        }

        RouteInfo findGlobalRoute(String str) {
            int size = this.mRoutes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return null;
                }
                RouteInfo routeInfo = this.mRoutes.get(i2);
                if (str.equals(routeInfo.mGlobalRouteId)) {
                    return routeInfo;
                }
                i = i2 + 1;
            }
        }

        public Display[] getAllPresentationDisplays() {
            return this.mDisplayService.getDisplays("android.hardware.display.category.PRESENTATION");
        }

        boolean isBluetoothA2dpOn() {
            try {
                return this.mAudioService.isBluetoothA2dpOn();
            } catch (RemoteException e) {
                Log.e(MediaRouter.TAG, "Error querying Bluetooth A2DP state", e);
                return false;
            }
        }

        RouteInfo makeGlobalRoute(MediaRouterClientState.RouteInfo routeInfo) {
            RouteInfo routeInfo2 = new RouteInfo(MediaRouter.sStatic.mSystemCategory);
            routeInfo2.mGlobalRouteId = routeInfo.id;
            routeInfo2.mName = routeInfo.name;
            routeInfo2.mDescription = routeInfo.description;
            routeInfo2.mSupportedTypes = routeInfo.supportedTypes;
            routeInfo2.mEnabled = routeInfo.enabled;
            routeInfo2.setRealStatusCode(routeInfo.statusCode);
            routeInfo2.mPlaybackType = routeInfo.playbackType;
            routeInfo2.mPlaybackStream = routeInfo.playbackStream;
            routeInfo2.mVolume = routeInfo.volume;
            routeInfo2.mVolumeMax = routeInfo.volumeMax;
            routeInfo2.mVolumeHandling = routeInfo.volumeHandling;
            routeInfo2.mPresentationDisplayId = routeInfo.presentationDisplayId;
            routeInfo2.updatePresentationDisplay();
            return routeInfo2;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            updatePresentationDisplays(i);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            updatePresentationDisplays(i);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            updatePresentationDisplays(i);
        }

        void publishClientDiscoveryRequest() {
            if (this.mClient != null) {
                try {
                    this.mMediaRouterService.setDiscoveryRequest(this.mClient, this.mDiscoveryRequestRouteTypes, this.mDiscoverRequestActiveScan);
                } catch (RemoteException e) {
                    Log.e(MediaRouter.TAG, "Unable to publish media router client discovery request.", e);
                }
            }
        }

        void publishClientSelectedRoute(boolean z) {
            if (this.mClient != null) {
                try {
                    this.mMediaRouterService.setSelectedRoute(this.mClient, this.mSelectedRoute != null ? this.mSelectedRoute.mGlobalRouteId : null, z);
                } catch (RemoteException e) {
                    Log.e(MediaRouter.TAG, "Unable to publish media router client selected route.", e);
                }
            }
        }

        void rebindAsUser(int i) {
            if (this.mCurrentUserId != i || i < 0 || this.mClient == null) {
                if (this.mClient != null) {
                    try {
                        this.mMediaRouterService.unregisterClient(this.mClient);
                    } catch (RemoteException e) {
                        Log.e(MediaRouter.TAG, "Unable to unregister media router client.", e);
                    }
                    this.mClient = null;
                }
                this.mCurrentUserId = i;
                try {
                    Client client = new Client();
                    this.mMediaRouterService.registerClientAsUser(client, this.mAppContext.getPackageName(), i);
                    this.mClient = client;
                } catch (RemoteException e2) {
                    Log.e(MediaRouter.TAG, "Unable to register media router client.", e2);
                }
                publishClientDiscoveryRequest();
                publishClientSelectedRoute(false);
                updateClientState();
            }
        }

        void requestSetVolume(RouteInfo routeInfo, int i) {
            if (routeInfo.mGlobalRouteId == null || this.mClient == null) {
                return;
            }
            try {
                this.mMediaRouterService.requestSetVolume(this.mClient, routeInfo.mGlobalRouteId, i);
            } catch (RemoteException e) {
                Log.w(MediaRouter.TAG, "Unable to request volume change.", e);
            }
        }

        void requestUpdateVolume(RouteInfo routeInfo, int i) {
            if (routeInfo.mGlobalRouteId == null || this.mClient == null) {
                return;
            }
            try {
                this.mMediaRouterService.requestUpdateVolume(this.mClient, routeInfo.mGlobalRouteId, i);
            } catch (RemoteException e) {
                Log.w(MediaRouter.TAG, "Unable to request volume change.", e);
            }
        }

        void setSelectedRoute(RouteInfo routeInfo, boolean z) {
            this.mSelectedRoute = routeInfo;
            publishClientSelectedRoute(z);
        }

        void startMonitoringRoutes(Context context) {
            this.mDefaultAudioVideo = new RouteInfo(this.mSystemCategory);
            this.mDefaultAudioVideo.mNameResId = 17041060;
            this.mDefaultAudioVideo.mSupportedTypes = 3;
            this.mDefaultAudioVideo.updatePresentationDisplay();
            MediaRouter.addRouteStatic(this.mDefaultAudioVideo);
            MediaRouter.updateWifiDisplayStatus(this.mDisplayService.getWifiDisplayStatus());
            context.registerReceiver(new WifiDisplayStatusChangedReceiver(), new IntentFilter(DisplayManager.ACTION_WIFI_DISPLAY_STATUS_CHANGED));
            context.registerReceiver(new VolumeChangeReceiver(), new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.mDisplayService.registerDisplayListener(this, this.mHandler);
            AudioRoutesInfo audioRoutesInfo = null;
            try {
                audioRoutesInfo = this.mAudioService.startWatchingRoutes(this.mAudioRoutesObserver);
            } catch (RemoteException e) {
            }
            if (audioRoutesInfo != null) {
                updateAudioRoutes(audioRoutesInfo);
            }
            rebindAsUser(UserHandle.myUserId());
            if (this.mSelectedRoute == null) {
                MediaRouter.selectDefaultRouteStatic();
            }
        }

        void updateAudioRoutes(AudioRoutesInfo audioRoutesInfo) {
            if (audioRoutesInfo.mMainType != this.mCurAudioRoutesInfo.mMainType) {
                this.mCurAudioRoutesInfo.mMainType = audioRoutesInfo.mMainType;
                MediaRouter.sStatic.mDefaultAudioVideo.mNameResId = ((audioRoutesInfo.mMainType & 2) == 0 && (audioRoutesInfo.mMainType & 1) == 0) ? (audioRoutesInfo.mMainType & 4) != 0 ? 17041062 : (audioRoutesInfo.mMainType & 8) != 0 ? 17041063 : 17041060 : 17041061;
                MediaRouter.dispatchRouteChanged(MediaRouter.sStatic.mDefaultAudioVideo);
            }
            int i = this.mCurAudioRoutesInfo.mMainType;
            if (!TextUtils.equals(audioRoutesInfo.mBluetoothName, this.mCurAudioRoutesInfo.mBluetoothName)) {
                this.mCurAudioRoutesInfo.mBluetoothName = audioRoutesInfo.mBluetoothName;
                if (this.mCurAudioRoutesInfo.mBluetoothName != null) {
                    if (MediaRouter.sStatic.mBluetoothA2dpRoute == null) {
                        RouteInfo routeInfo = new RouteInfo(MediaRouter.sStatic.mSystemCategory);
                        routeInfo.mName = this.mCurAudioRoutesInfo.mBluetoothName;
                        routeInfo.mDescription = MediaRouter.sStatic.mResources.getText(17041065);
                        routeInfo.mSupportedTypes = 1;
                        MediaRouter.sStatic.mBluetoothA2dpRoute = routeInfo;
                        MediaRouter.addRouteStatic(MediaRouter.sStatic.mBluetoothA2dpRoute);
                    } else {
                        MediaRouter.sStatic.mBluetoothA2dpRoute.mName = this.mCurAudioRoutesInfo.mBluetoothName;
                        MediaRouter.dispatchRouteChanged(MediaRouter.sStatic.mBluetoothA2dpRoute);
                    }
                } else if (MediaRouter.sStatic.mBluetoothA2dpRoute != null) {
                    MediaRouter.removeRouteStatic(MediaRouter.sStatic.mBluetoothA2dpRoute);
                    MediaRouter.sStatic.mBluetoothA2dpRoute = null;
                }
            }
            if (this.mBluetoothA2dpRoute != null) {
                boolean isBluetoothA2dpOn = isBluetoothA2dpOn();
                if (i != 0 && this.mSelectedRoute == this.mBluetoothA2dpRoute && !isBluetoothA2dpOn) {
                    MediaRouter.selectRouteStatic(1, this.mDefaultAudioVideo, false);
                } else if ((this.mSelectedRoute == this.mDefaultAudioVideo || this.mSelectedRoute == null) && isBluetoothA2dpOn) {
                    MediaRouter.selectRouteStatic(1, this.mBluetoothA2dpRoute, false);
                }
            }
        }

        void updateClientState() {
            this.mClientState = null;
            if (this.mClient != null) {
                try {
                    this.mClientState = this.mMediaRouterService.getState(this.mClient);
                } catch (RemoteException e) {
                    Log.e(MediaRouter.TAG, "Unable to retrieve media router client state.", e);
                }
            }
            ArrayList<MediaRouterClientState.RouteInfo> arrayList = this.mClientState != null ? this.mClientState.routes : null;
            String str = this.mClientState != null ? this.mClientState.globallySelectedRouteId : null;
            int size = arrayList != null ? arrayList.size() : 0;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                MediaRouterClientState.RouteInfo routeInfo = arrayList.get(i2);
                RouteInfo findGlobalRoute = findGlobalRoute(routeInfo.id);
                if (findGlobalRoute == null) {
                    MediaRouter.addRouteStatic(makeGlobalRoute(routeInfo));
                } else {
                    updateGlobalRoute(findGlobalRoute, routeInfo);
                }
                i = i2 + 1;
            }
            if (str != null) {
                RouteInfo findGlobalRoute2 = findGlobalRoute(str);
                if (findGlobalRoute2 == null) {
                    Log.w(MediaRouter.TAG, "Could not find new globally selected route: " + str);
                } else if (findGlobalRoute2 != this.mSelectedRoute) {
                    if (MediaRouter.DEBUG) {
                        Log.d(MediaRouter.TAG, "Selecting new globally selected route: " + findGlobalRoute2);
                    }
                    MediaRouter.selectRouteStatic(findGlobalRoute2.mSupportedTypes, findGlobalRoute2, false);
                }
            } else if (this.mSelectedRoute != null && this.mSelectedRoute.mGlobalRouteId != null) {
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "Unselecting previous globally selected route: " + this.mSelectedRoute);
                }
                MediaRouter.selectDefaultRouteStatic();
            }
            int size2 = this.mRoutes.size();
            while (true) {
                int i3 = size2;
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    return;
                }
                RouteInfo routeInfo2 = this.mRoutes.get(i4);
                String str2 = routeInfo2.mGlobalRouteId;
                if (str2 != null) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= size) {
                            MediaRouter.removeRouteStatic(routeInfo2);
                            break;
                        } else if (str2.equals(arrayList.get(i6).id)) {
                            size2 = i4;
                            break;
                        } else {
                            i5 = i6 + 1;
                        }
                    }
                }
                size2 = i4;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0097, code lost:
            if (r10 != false) goto L48;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void updateDiscoveryRequest() {
            /*
                Method dump skipped, instructions count: 268
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.MediaRouter.Static.updateDiscoveryRequest():void");
        }

        void updateGlobalRoute(RouteInfo routeInfo, MediaRouterClientState.RouteInfo routeInfo2) {
            boolean z = false;
            boolean z2 = false;
            if (!Objects.equals(routeInfo.mName, routeInfo2.name)) {
                routeInfo.mName = routeInfo2.name;
                z = true;
            }
            if (!Objects.equals(routeInfo.mDescription, routeInfo2.description)) {
                routeInfo.mDescription = routeInfo2.description;
                z = true;
            }
            int i = routeInfo.mSupportedTypes;
            if (i != routeInfo2.supportedTypes) {
                routeInfo.mSupportedTypes = routeInfo2.supportedTypes;
                z = true;
            }
            if (routeInfo.mEnabled != routeInfo2.enabled) {
                routeInfo.mEnabled = routeInfo2.enabled;
                z = true;
            }
            if (routeInfo.mRealStatusCode != routeInfo2.statusCode) {
                routeInfo.setRealStatusCode(routeInfo2.statusCode);
                z = true;
            }
            if (routeInfo.mPlaybackType != routeInfo2.playbackType) {
                routeInfo.mPlaybackType = routeInfo2.playbackType;
                z = true;
            }
            if (routeInfo.mPlaybackStream != routeInfo2.playbackStream) {
                routeInfo.mPlaybackStream = routeInfo2.playbackStream;
                z = true;
            }
            boolean z3 = z;
            boolean z4 = false;
            if (routeInfo.mVolume != routeInfo2.volume) {
                routeInfo.mVolume = routeInfo2.volume;
                z3 = true;
                z4 = true;
            }
            if (routeInfo.mVolumeMax != routeInfo2.volumeMax) {
                routeInfo.mVolumeMax = routeInfo2.volumeMax;
                z3 = true;
                z4 = true;
            }
            if (routeInfo.mVolumeHandling != routeInfo2.volumeHandling) {
                routeInfo.mVolumeHandling = routeInfo2.volumeHandling;
                z3 = true;
                z4 = true;
            }
            if (routeInfo.mPresentationDisplayId != routeInfo2.presentationDisplayId) {
                routeInfo.mPresentationDisplayId = routeInfo2.presentationDisplayId;
                routeInfo.updatePresentationDisplay();
                z3 = true;
                z2 = true;
            }
            if (z3) {
                MediaRouter.dispatchRouteChanged(routeInfo, i);
            }
            if (z4) {
                MediaRouter.dispatchRouteVolumeChanged(routeInfo);
            }
            if (z2) {
                MediaRouter.dispatchRoutePresentationDisplayChanged(routeInfo);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$UserRouteInfo.class */
    public static class UserRouteInfo extends RouteInfo {
        RemoteControlClient mRcc;
        SessionVolumeProvider mSvp;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$UserRouteInfo$SessionVolumeProvider.class */
        public class SessionVolumeProvider extends VolumeProvider {
            public SessionVolumeProvider(int i, int i2, int i3) {
                super(i, i2, i3);
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(final int i) {
                MediaRouter.sStatic.mHandler.post(new Runnable() { // from class: android.media.MediaRouter.UserRouteInfo.SessionVolumeProvider.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UserRouteInfo.this.mVcb != null) {
                            UserRouteInfo.this.mVcb.vcb.onVolumeUpdateRequest(UserRouteInfo.this.mVcb.route, i);
                        }
                    }
                });
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(final int i) {
                MediaRouter.sStatic.mHandler.post(new Runnable() { // from class: android.media.MediaRouter.UserRouteInfo.SessionVolumeProvider.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (UserRouteInfo.this.mVcb != null) {
                            UserRouteInfo.this.mVcb.vcb.onVolumeSetRequest(UserRouteInfo.this.mVcb.route, i);
                        }
                    }
                });
            }
        }

        UserRouteInfo(RouteCategory routeCategory) {
            super(routeCategory);
            this.mSupportedTypes = 8388608;
            this.mPlaybackType = 1;
            this.mVolumeHandling = 0;
        }

        private void configureSessionVolume() {
            if (this.mRcc == null) {
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "No Rcc to configure volume for route " + ((Object) this.mName));
                    return;
                }
                return;
            }
            MediaSession mediaSession = this.mRcc.getMediaSession();
            if (mediaSession == null) {
                if (MediaRouter.DEBUG) {
                    Log.d(MediaRouter.TAG, "Rcc has no session to configure volume");
                }
            } else if (this.mPlaybackType != 1) {
                AudioAttributes.Builder builder = new AudioAttributes.Builder();
                builder.setLegacyStreamType(this.mPlaybackStream);
                mediaSession.setPlaybackToLocal(builder.build());
                this.mSvp = null;
            } else {
                int i = 0;
                switch (this.mVolumeHandling) {
                    case 1:
                        i = 2;
                        break;
                }
                if (this.mSvp != null && this.mSvp.getVolumeControl() == i && this.mSvp.getMaxVolume() == this.mVolumeMax) {
                    return;
                }
                this.mSvp = new SessionVolumeProvider(i, this.mVolumeMax, this.mVolume);
                mediaSession.setPlaybackToRemote(this.mSvp);
            }
        }

        private void updatePlaybackInfoOnRcc() {
            configureSessionVolume();
        }

        public RemoteControlClient getRemoteControlClient() {
            return this.mRcc;
        }

        @Override // android.media.MediaRouter.RouteInfo
        public void requestSetVolume(int i) {
            if (this.mVolumeHandling == 1) {
                if (this.mVcb == null) {
                    Log.e(MediaRouter.TAG, "Cannot requestSetVolume on user route - no volume callback set");
                } else {
                    this.mVcb.vcb.onVolumeSetRequest(this, i);
                }
            }
        }

        @Override // android.media.MediaRouter.RouteInfo
        public void requestUpdateVolume(int i) {
            if (this.mVolumeHandling == 1) {
                if (this.mVcb == null) {
                    Log.e(MediaRouter.TAG, "Cannot requestChangeVolume on user route - no volumec callback set");
                } else {
                    this.mVcb.vcb.onVolumeUpdateRequest(this, i);
                }
            }
        }

        public void setDescription(CharSequence charSequence) {
            this.mDescription = charSequence;
            routeUpdated();
        }

        public void setIconDrawable(Drawable drawable) {
            this.mIcon = drawable;
        }

        public void setIconResource(int i) {
            setIconDrawable(MediaRouter.sStatic.mResources.getDrawable(i));
        }

        public void setName(int i) {
            this.mNameResId = i;
            this.mName = null;
            routeUpdated();
        }

        public void setName(CharSequence charSequence) {
            this.mName = charSequence;
            routeUpdated();
        }

        public void setPlaybackStream(int i) {
            if (this.mPlaybackStream != i) {
                this.mPlaybackStream = i;
                configureSessionVolume();
            }
        }

        public void setPlaybackType(int i) {
            if (this.mPlaybackType != i) {
                this.mPlaybackType = i;
                configureSessionVolume();
            }
        }

        public void setRemoteControlClient(RemoteControlClient remoteControlClient) {
            this.mRcc = remoteControlClient;
            updatePlaybackInfoOnRcc();
        }

        public void setStatus(CharSequence charSequence) {
            setStatusInt(charSequence);
        }

        public void setVolume(int i) {
            int max = Math.max(0, Math.min(i, getVolumeMax()));
            if (this.mVolume != max) {
                this.mVolume = max;
                if (this.mSvp != null) {
                    this.mSvp.setCurrentVolume(this.mVolume);
                }
                MediaRouter.dispatchRouteVolumeChanged(this);
                if (this.mGroup != null) {
                    this.mGroup.memberVolumeChanged(this);
                }
            }
        }

        public void setVolumeCallback(VolumeCallback volumeCallback) {
            this.mVcb = new VolumeCallbackInfo(volumeCallback, this);
        }

        public void setVolumeHandling(int i) {
            if (this.mVolumeHandling != i) {
                this.mVolumeHandling = i;
                configureSessionVolume();
            }
        }

        public void setVolumeMax(int i) {
            if (this.mVolumeMax != i) {
                this.mVolumeMax = i;
                configureSessionVolume();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$VolumeCallback.class */
    public static abstract class VolumeCallback {
        public abstract void onVolumeSetRequest(RouteInfo routeInfo, int i);

        public abstract void onVolumeUpdateRequest(RouteInfo routeInfo, int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$VolumeCallbackInfo.class */
    static class VolumeCallbackInfo {
        public final RouteInfo route;
        public final VolumeCallback vcb;

        public VolumeCallbackInfo(VolumeCallback volumeCallback, RouteInfo routeInfo) {
            this.vcb = volumeCallback;
            this.route = routeInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$VolumeChangeReceiver.class */
    public static class VolumeChangeReceiver extends BroadcastReceiver {
        VolumeChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_TYPE, -1) == 3 && (intExtra = intent.getIntExtra(AudioManager.EXTRA_VOLUME_STREAM_VALUE, 0)) != intent.getIntExtra(AudioManager.EXTRA_PREV_VOLUME_STREAM_VALUE, 0)) {
                MediaRouter.systemVolumeChanged(intExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouter$WifiDisplayStatusChangedReceiver.class */
    public static class WifiDisplayStatusChangedReceiver extends BroadcastReceiver {
        WifiDisplayStatusChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(DisplayManager.ACTION_WIFI_DISPLAY_STATUS_CHANGED)) {
                MediaRouter.updateWifiDisplayStatus((WifiDisplayStatus) intent.getParcelableExtra(DisplayManager.EXTRA_WIFI_DISPLAY_STATUS));
            }
        }
    }

    public MediaRouter(Context context) {
        synchronized (Static.class) {
            try {
                if (sStatic == null) {
                    Context applicationContext = context.getApplicationContext();
                    sStatic = new Static(applicationContext);
                    sStatic.startMonitoringRoutes(applicationContext);
                }
            } finally {
            }
        }
    }

    static void addRouteStatic(RouteInfo routeInfo) {
        RouteCategory category = routeInfo.getCategory();
        if (!sStatic.mCategories.contains(category)) {
            sStatic.mCategories.add(category);
        }
        if (!category.isGroupable() || (routeInfo instanceof RouteGroup)) {
            sStatic.mRoutes.add(routeInfo);
            dispatchRouteAdded(routeInfo);
            return;
        }
        RouteGroup routeGroup = new RouteGroup(routeInfo.getCategory());
        routeGroup.mSupportedTypes = routeInfo.mSupportedTypes;
        sStatic.mRoutes.add(routeGroup);
        dispatchRouteAdded(routeGroup);
        routeGroup.addRoute(routeInfo);
    }

    static void dispatchRouteAdded(RouteInfo routeInfo) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeInfo)) {
                next.cb.onRouteAdded(next.router, routeInfo);
            }
        }
    }

    static void dispatchRouteChanged(RouteInfo routeInfo) {
        dispatchRouteChanged(routeInfo, routeInfo.mSupportedTypes);
    }

    static void dispatchRouteChanged(RouteInfo routeInfo, int i) {
        int i2 = routeInfo.mSupportedTypes;
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            boolean filterRouteEvent = next.filterRouteEvent(i);
            boolean filterRouteEvent2 = next.filterRouteEvent(i2);
            if (!filterRouteEvent && filterRouteEvent2) {
                next.cb.onRouteAdded(next.router, routeInfo);
                if (routeInfo.isSelected()) {
                    next.cb.onRouteSelected(next.router, i2, routeInfo);
                }
            }
            if (filterRouteEvent || filterRouteEvent2) {
                next.cb.onRouteChanged(next.router, routeInfo);
            }
            if (filterRouteEvent && !filterRouteEvent2) {
                if (routeInfo.isSelected()) {
                    next.cb.onRouteUnselected(next.router, i, routeInfo);
                }
                next.cb.onRouteRemoved(next.router, routeInfo);
            }
        }
    }

    static void dispatchRouteGrouped(RouteInfo routeInfo, RouteGroup routeGroup, int i) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeGroup)) {
                next.cb.onRouteGrouped(next.router, routeInfo, routeGroup, i);
            }
        }
    }

    static void dispatchRoutePresentationDisplayChanged(RouteInfo routeInfo) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeInfo)) {
                next.cb.onRoutePresentationDisplayChanged(next.router, routeInfo);
            }
        }
    }

    static void dispatchRouteRemoved(RouteInfo routeInfo) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeInfo)) {
                next.cb.onRouteRemoved(next.router, routeInfo);
            }
        }
    }

    static void dispatchRouteSelected(int i, RouteInfo routeInfo) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeInfo)) {
                next.cb.onRouteSelected(next.router, i, routeInfo);
            }
        }
    }

    static void dispatchRouteUngrouped(RouteInfo routeInfo, RouteGroup routeGroup) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeGroup)) {
                next.cb.onRouteUngrouped(next.router, routeInfo, routeGroup);
            }
        }
    }

    static void dispatchRouteUnselected(int i, RouteInfo routeInfo) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeInfo)) {
                next.cb.onRouteUnselected(next.router, i, routeInfo);
            }
        }
    }

    static void dispatchRouteVolumeChanged(RouteInfo routeInfo) {
        Iterator<CallbackInfo> it = sStatic.mCallbacks.iterator();
        while (it.hasNext()) {
            CallbackInfo next = it.next();
            if (next.filterRouteEvent(routeInfo)) {
                next.cb.onRouteVolumeChanged(next.router, routeInfo);
            }
        }
    }

    private int findCallbackInfo(Callback callback) {
        int size = sStatic.mCallbacks.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return -1;
            }
            if (sStatic.mCallbacks.get(i2).cb == callback) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private static WifiDisplay findWifiDisplay(WifiDisplay[] wifiDisplayArr, String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= wifiDisplayArr.length) {
                return null;
            }
            WifiDisplay wifiDisplay = wifiDisplayArr[i2];
            if (wifiDisplay.getDeviceAddress().equals(str)) {
                return wifiDisplay;
            }
            i = i2 + 1;
        }
    }

    private static RouteInfo findWifiDisplayRoute(WifiDisplay wifiDisplay) {
        int size = sStatic.mRoutes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            RouteInfo routeInfo = sStatic.mRoutes.get(i2);
            if (wifiDisplay.getDeviceAddress().equals(routeInfo.mDeviceAddress)) {
                return routeInfo;
            }
            i = i2 + 1;
        }
    }

    static RouteInfo getRouteAtStatic(int i) {
        return sStatic.mRoutes.get(i);
    }

    static int getRouteCountStatic() {
        return sStatic.mRoutes.size();
    }

    static int getWifiDisplayStatusCode(WifiDisplay wifiDisplay, WifiDisplayStatus wifiDisplayStatus) {
        int i = wifiDisplayStatus.getScanState() == 1 ? 1 : wifiDisplay.isAvailable() ? wifiDisplay.canConnect() ? 3 : 5 : 4;
        if (wifiDisplay.equals(wifiDisplayStatus.getActiveDisplay())) {
            switch (wifiDisplayStatus.getActiveDisplayState()) {
                case 0:
                    Log.e(TAG, "Active display is not connected!");
                    return i;
                case 1:
                    return 2;
                case 2:
                    return 6;
            }
        }
        return i;
    }

    static boolean isWifiDisplayEnabled(WifiDisplay wifiDisplay, WifiDisplayStatus wifiDisplayStatus) {
        if (wifiDisplay.isAvailable()) {
            return wifiDisplay.canConnect() || wifiDisplay.equals(wifiDisplayStatus.getActiveDisplay());
        }
        return false;
    }

    static RouteInfo makeWifiDisplayRoute(WifiDisplay wifiDisplay, WifiDisplayStatus wifiDisplayStatus) {
        RouteInfo routeInfo = new RouteInfo(sStatic.mSystemCategory);
        routeInfo.mDeviceAddress = wifiDisplay.getDeviceAddress();
        routeInfo.mSupportedTypes = 7;
        routeInfo.mVolumeHandling = 0;
        routeInfo.mPlaybackType = 1;
        routeInfo.setRealStatusCode(getWifiDisplayStatusCode(wifiDisplay, wifiDisplayStatus));
        routeInfo.mEnabled = isWifiDisplayEnabled(wifiDisplay, wifiDisplayStatus);
        routeInfo.mName = wifiDisplay.getFriendlyDisplayName();
        routeInfo.mDescription = sStatic.mResources.getText(17041066);
        routeInfo.updatePresentationDisplay();
        return routeInfo;
    }

    static boolean matchesDeviceAddress(WifiDisplay wifiDisplay, RouteInfo routeInfo) {
        boolean z = (routeInfo == null || routeInfo.mDeviceAddress == null) ? false : true;
        if (wifiDisplay != null || z) {
            if (wifiDisplay == null || !z) {
                return false;
            }
            return wifiDisplay.getDeviceAddress().equals(routeInfo.mDeviceAddress);
        }
        return true;
    }

    static void removeRouteStatic(RouteInfo routeInfo) {
        boolean z;
        if (sStatic.mRoutes.remove(routeInfo)) {
            RouteCategory category = routeInfo.getCategory();
            int size = sStatic.mRoutes.size();
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= size) {
                    break;
                } else if (category == sStatic.mRoutes.get(i2).getCategory()) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (routeInfo.isSelected()) {
                selectDefaultRouteStatic();
            }
            if (!z) {
                sStatic.mCategories.remove(category);
            }
            dispatchRouteRemoved(routeInfo);
        }
    }

    static void selectDefaultRouteStatic() {
        if (sStatic.mSelectedRoute == sStatic.mBluetoothA2dpRoute || sStatic.mBluetoothA2dpRoute == null || !sStatic.isBluetoothA2dpOn()) {
            selectRouteStatic(8388615, sStatic.mDefaultAudioVideo, false);
        } else {
            selectRouteStatic(8388615, sStatic.mBluetoothA2dpRoute, false);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x012d -> B:22:0x0085). Please submit an issue!!! */
    static void selectRouteStatic(int i, RouteInfo routeInfo, boolean z) {
        boolean z2 = true;
        RouteInfo routeInfo2 = sStatic.mSelectedRoute;
        if (routeInfo2 == routeInfo) {
            return;
        }
        if (!routeInfo.matchesTypes(i)) {
            Log.w(TAG, "selectRoute ignored; cannot select route with supported types " + typesToString(routeInfo.getSupportedTypes()) + " into route types " + typesToString(i));
            return;
        }
        RouteInfo routeInfo3 = sStatic.mBluetoothA2dpRoute;
        if (routeInfo3 != null && (i & 1) != 0 && (routeInfo == routeInfo3 || routeInfo == sStatic.mDefaultAudioVideo)) {
            try {
                sStatic.mAudioService.setBluetoothA2dpOn(routeInfo == routeInfo3);
            } catch (RemoteException e) {
                Log.e(TAG, "Error changing Bluetooth A2DP state", e);
            }
        }
        WifiDisplay activeDisplay = sStatic.mDisplayService.getWifiDisplayStatus().getActiveDisplay();
        boolean z3 = (routeInfo2 == null || routeInfo2.mDeviceAddress == null) ? false : true;
        if (routeInfo == null || routeInfo.mDeviceAddress == null) {
            z2 = false;
        }
        if (activeDisplay != null || z3 || z2) {
            if (!z2 || matchesDeviceAddress(activeDisplay, routeInfo)) {
                if (activeDisplay != null && !z2) {
                    sStatic.mDisplayService.disconnectWifiDisplay();
                }
            } else if (sStatic.mCanConfigureWifiDisplays) {
                sStatic.mDisplayService.connectWifiDisplay(routeInfo.mDeviceAddress);
            } else {
                Log.e(TAG, "Cannot connect to wifi displays because this process is not allowed to do so.");
            }
        }
        sStatic.setSelectedRoute(routeInfo, z);
        if (routeInfo2 != null) {
            dispatchRouteUnselected(routeInfo2.getSupportedTypes() & i, routeInfo2);
            if (routeInfo2.resolveStatusCode()) {
                dispatchRouteChanged(routeInfo2);
            }
        }
        if (routeInfo != null) {
            if (routeInfo.resolveStatusCode()) {
                dispatchRouteChanged(routeInfo);
            }
            dispatchRouteSelected(routeInfo.getSupportedTypes() & i, routeInfo);
        }
        sStatic.updateDiscoveryRequest();
    }

    private static boolean shouldShowWifiDisplay(WifiDisplay wifiDisplay, WifiDisplay wifiDisplay2) {
        return wifiDisplay.isRemembered() || wifiDisplay.equals(wifiDisplay2);
    }

    static void systemVolumeChanged(int i) {
        RouteInfo routeInfo = sStatic.mSelectedRoute;
        if (routeInfo == null) {
            return;
        }
        if (routeInfo == sStatic.mBluetoothA2dpRoute || routeInfo == sStatic.mDefaultAudioVideo) {
            dispatchRouteVolumeChanged(routeInfo);
        } else if (sStatic.mBluetoothA2dpRoute == null) {
            dispatchRouteVolumeChanged(sStatic.mDefaultAudioVideo);
        } else {
            try {
                dispatchRouteVolumeChanged(sStatic.mAudioService.isBluetoothA2dpOn() ? sStatic.mBluetoothA2dpRoute : sStatic.mDefaultAudioVideo);
            } catch (RemoteException e) {
                Log.e(TAG, "Error checking Bluetooth A2DP state to report volume change", e);
            }
        }
    }

    static String typesToString(int i) {
        StringBuilder sb = new StringBuilder();
        if ((i & 1) != 0) {
            sb.append("ROUTE_TYPE_LIVE_AUDIO ");
        }
        if ((i & 2) != 0) {
            sb.append("ROUTE_TYPE_LIVE_VIDEO ");
        }
        if ((i & 4) != 0) {
            sb.append("ROUTE_TYPE_REMOTE_DISPLAY ");
        }
        if ((8388608 & i) != 0) {
            sb.append("ROUTE_TYPE_USER ");
        }
        return sb.toString();
    }

    static void updateRoute(RouteInfo routeInfo) {
        dispatchRouteChanged(routeInfo);
    }

    private static void updateWifiDisplayRoute(RouteInfo routeInfo, WifiDisplay wifiDisplay, WifiDisplayStatus wifiDisplayStatus, boolean z) {
        boolean z2 = false;
        String friendlyDisplayName = wifiDisplay.getFriendlyDisplayName();
        if (!routeInfo.getName().equals(friendlyDisplayName)) {
            routeInfo.mName = friendlyDisplayName;
            z2 = true;
        }
        boolean isWifiDisplayEnabled = isWifiDisplayEnabled(wifiDisplay, wifiDisplayStatus);
        boolean z3 = routeInfo.mEnabled != isWifiDisplayEnabled;
        routeInfo.mEnabled = isWifiDisplayEnabled;
        if (z2 | z3 | routeInfo.setRealStatusCode(getWifiDisplayStatusCode(wifiDisplay, wifiDisplayStatus))) {
            dispatchRouteChanged(routeInfo);
        }
        if ((!isWifiDisplayEnabled || z) && routeInfo.isSelected()) {
            selectDefaultRouteStatic();
        }
    }

    static void updateWifiDisplayStatus(WifiDisplayStatus wifiDisplayStatus) {
        WifiDisplay[] wifiDisplayArr;
        WifiDisplay wifiDisplay;
        WifiDisplay findWifiDisplay;
        if (wifiDisplayStatus.getFeatureState() == 3) {
            wifiDisplayArr = wifiDisplayStatus.getDisplays();
            WifiDisplay activeDisplay = wifiDisplayStatus.getActiveDisplay();
            wifiDisplay = activeDisplay;
            if (!sStatic.mCanConfigureWifiDisplays) {
                if (activeDisplay != null) {
                    wifiDisplayArr = new WifiDisplay[]{activeDisplay};
                    wifiDisplay = activeDisplay;
                } else {
                    wifiDisplayArr = WifiDisplay.EMPTY_ARRAY;
                    wifiDisplay = activeDisplay;
                }
            }
        } else {
            wifiDisplayArr = WifiDisplay.EMPTY_ARRAY;
            wifiDisplay = null;
        }
        String deviceAddress = wifiDisplay != null ? wifiDisplay.getDeviceAddress() : null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= wifiDisplayArr.length) {
                break;
            }
            WifiDisplay wifiDisplay2 = wifiDisplayArr[i2];
            if (shouldShowWifiDisplay(wifiDisplay2, wifiDisplay)) {
                RouteInfo findWifiDisplayRoute = findWifiDisplayRoute(wifiDisplay2);
                if (findWifiDisplayRoute == null) {
                    findWifiDisplayRoute = makeWifiDisplayRoute(wifiDisplay2, wifiDisplayStatus);
                    addRouteStatic(findWifiDisplayRoute);
                } else {
                    String deviceAddress2 = wifiDisplay2.getDeviceAddress();
                    updateWifiDisplayRoute(findWifiDisplayRoute, wifiDisplay2, wifiDisplayStatus, !deviceAddress2.equals(deviceAddress) && deviceAddress2.equals(sStatic.mPreviousActiveWifiDisplayAddress));
                }
                if (wifiDisplay2.equals(wifiDisplay)) {
                    selectRouteStatic(findWifiDisplayRoute.getSupportedTypes(), findWifiDisplayRoute, false);
                }
            }
            i = i2 + 1;
        }
        int size = sStatic.mRoutes.size();
        while (true) {
            int i3 = size;
            int i4 = i3 - 1;
            if (i3 <= 0) {
                sStatic.mPreviousActiveWifiDisplayAddress = deviceAddress;
                return;
            }
            RouteInfo routeInfo = sStatic.mRoutes.get(i4);
            if (routeInfo.mDeviceAddress != null && ((findWifiDisplay = findWifiDisplay(wifiDisplayArr, routeInfo.mDeviceAddress)) == null || !shouldShowWifiDisplay(findWifiDisplay, wifiDisplay))) {
                removeRouteStatic(routeInfo);
            }
            size = i4;
        }
    }

    public void addCallback(int i, Callback callback) {
        addCallback(i, callback, 0);
    }

    public void addCallback(int i, Callback callback, int i2) {
        int findCallbackInfo = findCallbackInfo(callback);
        if (findCallbackInfo >= 0) {
            CallbackInfo callbackInfo = sStatic.mCallbacks.get(findCallbackInfo);
            callbackInfo.type |= i;
            callbackInfo.flags |= i2;
        } else {
            sStatic.mCallbacks.add(new CallbackInfo(callback, i, i2, this));
        }
        sStatic.updateDiscoveryRequest();
    }

    public void addRouteInt(RouteInfo routeInfo) {
        addRouteStatic(routeInfo);
    }

    public void addUserRoute(UserRouteInfo userRouteInfo) {
        addRouteStatic(userRouteInfo);
    }

    public void clearUserRoutes() {
        int i;
        int i2;
        while (true) {
            int i3 = i;
            if (i3 >= sStatic.mRoutes.size()) {
                return;
            }
            RouteInfo routeInfo = sStatic.mRoutes.get(i3);
            if (!(routeInfo instanceof UserRouteInfo)) {
                i2 = i3;
                i = routeInfo instanceof RouteGroup ? 0 : i2 + 1;
            }
            removeRouteStatic(routeInfo);
            i2 = i3 - 1;
        }
    }

    public RouteCategory createRouteCategory(int i, boolean z) {
        return new RouteCategory(i, 8388608, z);
    }

    public RouteCategory createRouteCategory(CharSequence charSequence, boolean z) {
        return new RouteCategory(charSequence, 8388608, z);
    }

    public UserRouteInfo createUserRoute(RouteCategory routeCategory) {
        return new UserRouteInfo(routeCategory);
    }

    public RouteCategory getCategoryAt(int i) {
        return sStatic.mCategories.get(i);
    }

    public int getCategoryCount() {
        return sStatic.mCategories.size();
    }

    public RouteInfo getDefaultRoute() {
        return sStatic.mDefaultAudioVideo;
    }

    public RouteInfo getRouteAt(int i) {
        return sStatic.mRoutes.get(i);
    }

    public int getRouteCount() {
        return sStatic.mRoutes.size();
    }

    public RouteInfo getSelectedRoute() {
        return getSelectedRoute(8388615);
    }

    public RouteInfo getSelectedRoute(int i) {
        if (sStatic.mSelectedRoute == null || (sStatic.mSelectedRoute.mSupportedTypes & i) == 0) {
            if (i == 8388608) {
                return null;
            }
            return sStatic.mDefaultAudioVideo;
        }
        return sStatic.mSelectedRoute;
    }

    public RouteCategory getSystemCategory() {
        return sStatic.mSystemCategory;
    }

    public boolean isRouteAvailable(int i, int i2) {
        int size = sStatic.mRoutes.size();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                return false;
            }
            RouteInfo routeInfo = sStatic.mRoutes.get(i4);
            if (routeInfo.matchesTypes(i) && ((i2 & 1) == 0 || routeInfo != sStatic.mDefaultAudioVideo)) {
                return true;
            }
            i3 = i4 + 1;
        }
    }

    public void rebindAsUser(int i) {
        sStatic.rebindAsUser(i);
    }

    public void removeCallback(Callback callback) {
        int findCallbackInfo = findCallbackInfo(callback);
        if (findCallbackInfo < 0) {
            Log.w(TAG, "removeCallback(" + callback + "): callback not registered");
            return;
        }
        sStatic.mCallbacks.remove(findCallbackInfo);
        sStatic.updateDiscoveryRequest();
    }

    public void removeRouteInt(RouteInfo routeInfo) {
        removeRouteStatic(routeInfo);
    }

    public void removeUserRoute(UserRouteInfo userRouteInfo) {
        removeRouteStatic(userRouteInfo);
    }

    public void selectRoute(int i, RouteInfo routeInfo) {
        selectRouteStatic(i, routeInfo, true);
    }

    public void selectRouteInt(int i, RouteInfo routeInfo, boolean z) {
        selectRouteStatic(i, routeInfo, z);
    }
}
