package android.view;

import android.os.Build;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/view/InputEventConsistencyVerifier.class */
public final class InputEventConsistencyVerifier {
    private static final String EVENT_TYPE_GENERIC_MOTION = "GenericMotionEvent";
    private static final String EVENT_TYPE_KEY = "KeyEvent";
    private static final String EVENT_TYPE_TOUCH = "TouchEvent";
    private static final String EVENT_TYPE_TRACKBALL = "TrackballEvent";
    public static final int FLAG_RAW_DEVICE_INPUT = 1;
    private static final boolean IS_ENG_BUILD = "eng".equals(Build.TYPE);
    private static final int RECENT_EVENTS_TO_LOG = 5;
    private final Object mCaller;
    private InputEvent mCurrentEvent;
    private String mCurrentEventType;
    private final int mFlags;
    private boolean mHoverEntered;
    private KeyState mKeyStateList;
    private int mLastEventSeq;
    private String mLastEventType;
    private int mLastNestingLevel;
    private final String mLogTag;
    private int mMostRecentEventIndex;
    private InputEvent[] mRecentEvents;
    private boolean[] mRecentEventsUnhandled;
    private int mTouchEventStreamDeviceId;
    private boolean mTouchEventStreamIsTainted;
    private int mTouchEventStreamPointers;
    private int mTouchEventStreamSource;
    private boolean mTouchEventStreamUnhandled;
    private boolean mTrackballDown;
    private boolean mTrackballUnhandled;
    private StringBuilder mViolationMessage;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/InputEventConsistencyVerifier$KeyState.class */
    public static final class KeyState {
        private static KeyState mRecycledList;
        private static Object mRecycledListLock = new Object();
        public int deviceId;
        public int keyCode;
        public KeyState next;
        public int source;
        public boolean unhandled;

        private KeyState() {
        }

        public static KeyState obtain(int i, int i2, int i3) {
            KeyState keyState;
            synchronized (mRecycledListLock) {
                keyState = mRecycledList;
                if (keyState != null) {
                    mRecycledList = keyState.next;
                } else {
                    keyState = new KeyState();
                }
            }
            keyState.deviceId = i;
            keyState.source = i2;
            keyState.keyCode = i3;
            keyState.unhandled = false;
            return keyState;
        }

        public void recycle() {
            synchronized (mRecycledListLock) {
                this.next = mRecycledList;
                mRecycledList = this.next;
            }
        }
    }

    public InputEventConsistencyVerifier(Object obj, int i) {
        this(obj, i, null);
    }

    public InputEventConsistencyVerifier(Object obj, int i, String str) {
        this.mTouchEventStreamDeviceId = -1;
        this.mCaller = obj;
        this.mFlags = i;
        this.mLogTag = str == null ? "InputEventConsistencyVerifier" : str;
    }

    private void addKeyState(int i, int i2, int i3) {
        KeyState obtain = KeyState.obtain(i, i2, i3);
        obtain.next = this.mKeyStateList;
        this.mKeyStateList = obtain;
    }

    private static void appendEvent(StringBuilder sb, int i, InputEvent inputEvent, boolean z) {
        sb.append(i).append(": sent at ").append(inputEvent.getEventTimeNano());
        sb.append(", ");
        if (z) {
            sb.append("(unhandled) ");
        }
        sb.append(inputEvent);
    }

    private void ensureHistorySizeIsZeroForThisAction(MotionEvent motionEvent) {
        int historySize = motionEvent.getHistorySize();
        if (historySize != 0) {
            problem("History size is " + historySize + " but it should always be 0 for " + MotionEvent.actionToString(motionEvent.getAction()));
        }
    }

    private void ensureMetaStateIsNormalized(int i) {
        int normalizeMetaState = KeyEvent.normalizeMetaState(i);
        if (normalizeMetaState != i) {
            problem(String.format("Metastate not normalized.  Was 0x%08x but expected 0x%08x.", Integer.valueOf(i), Integer.valueOf(normalizeMetaState)));
        }
    }

    private void ensurePointerCountIsOneForThisAction(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount != 1) {
            problem("Pointer count is " + pointerCount + " but it should always be 1 for " + MotionEvent.actionToString(motionEvent.getAction()));
        }
    }

    private KeyState findKeyState(int i, int i2, int i3, boolean z) {
        KeyState keyState = null;
        KeyState keyState2 = this.mKeyStateList;
        while (true) {
            KeyState keyState3 = keyState2;
            if (keyState3 == null) {
                return null;
            }
            if (keyState3.deviceId == i && keyState3.source == i2 && keyState3.keyCode == i3) {
                if (z) {
                    if (keyState != null) {
                        keyState.next = keyState3.next;
                    } else {
                        this.mKeyStateList = keyState3.next;
                    }
                    keyState3.next = null;
                }
                return keyState3;
            }
            keyState = keyState3;
            keyState2 = keyState3.next;
        }
    }

    private void finishEvent() {
        int i;
        InputEvent inputEvent;
        if (this.mViolationMessage != null && this.mViolationMessage.length() != 0) {
            if (!this.mCurrentEvent.isTainted()) {
                this.mViolationMessage.append("\n  in ").append(this.mCaller);
                this.mViolationMessage.append("\n  ");
                appendEvent(this.mViolationMessage, 0, this.mCurrentEvent, false);
                if (this.mRecentEvents != null) {
                    this.mViolationMessage.append("\n  -- recent events --");
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= 5 || (inputEvent = this.mRecentEvents[(i = ((this.mMostRecentEventIndex + 5) - i3) % 5)]) == null) {
                            break;
                        }
                        this.mViolationMessage.append("\n  ");
                        appendEvent(this.mViolationMessage, i3 + 1, inputEvent, this.mRecentEventsUnhandled[i]);
                        i2 = i3 + 1;
                    }
                }
                Log.d(this.mLogTag, this.mViolationMessage.toString());
                this.mCurrentEvent.setTainted(true);
            }
            this.mViolationMessage.setLength(0);
        }
        if (this.mRecentEvents == null) {
            this.mRecentEvents = new InputEvent[5];
            this.mRecentEventsUnhandled = new boolean[5];
        }
        int i4 = (this.mMostRecentEventIndex + 1) % 5;
        this.mMostRecentEventIndex = i4;
        if (this.mRecentEvents[i4] != null) {
            this.mRecentEvents[i4].recycle();
        }
        this.mRecentEvents[i4] = this.mCurrentEvent.copy();
        this.mRecentEventsUnhandled[i4] = false;
        this.mCurrentEvent = null;
        this.mCurrentEventType = null;
    }

    public static boolean isInstrumentationEnabled() {
        return IS_ENG_BUILD;
    }

    private void problem(String str) {
        if (this.mViolationMessage == null) {
            this.mViolationMessage = new StringBuilder();
        }
        if (this.mViolationMessage.length() == 0) {
            this.mViolationMessage.append(this.mCurrentEventType).append(": ");
        } else {
            this.mViolationMessage.append("\n  ");
        }
        this.mViolationMessage.append(str);
    }

    private boolean startEvent(InputEvent inputEvent, int i, String str) {
        int sequenceNumber = inputEvent.getSequenceNumber();
        if (sequenceNumber == this.mLastEventSeq && i < this.mLastNestingLevel && str == this.mLastEventType) {
            return false;
        }
        if (i > 0) {
            this.mLastEventSeq = sequenceNumber;
            this.mLastEventType = str;
            this.mLastNestingLevel = i;
        } else {
            this.mLastEventSeq = -1;
            this.mLastEventType = null;
            this.mLastNestingLevel = 0;
        }
        this.mCurrentEvent = inputEvent;
        this.mCurrentEventType = str;
        return true;
    }

    public void onGenericMotionEvent(MotionEvent motionEvent, int i) {
        if (startEvent(motionEvent, i, EVENT_TYPE_GENERIC_MOTION)) {
            try {
                ensureMetaStateIsNormalized(motionEvent.getMetaState());
                int action = motionEvent.getAction();
                int source = motionEvent.getSource();
                if ((source & 2) == 0) {
                    if ((source & 16) != 0) {
                        switch (action) {
                            case 2:
                                ensurePointerCountIsOneForThisAction(motionEvent);
                                break;
                            default:
                                problem("Invalid action for generic joystick event.");
                                break;
                        }
                    }
                } else {
                    switch (action) {
                        case 7:
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            break;
                        case 8:
                            ensureHistorySizeIsZeroForThisAction(motionEvent);
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            break;
                        case 9:
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            this.mHoverEntered = true;
                            break;
                        case 10:
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            if (!this.mHoverEntered) {
                                problem("ACTION_HOVER_EXIT without prior ACTION_HOVER_ENTER");
                            }
                            this.mHoverEntered = false;
                            break;
                        default:
                            problem("Invalid action for generic pointer event.");
                            break;
                    }
                }
            } finally {
                finishEvent();
            }
        }
    }

    public void onInputEvent(InputEvent inputEvent, int i) {
        if (inputEvent instanceof KeyEvent) {
            onKeyEvent((KeyEvent) inputEvent, i);
            return;
        }
        MotionEvent motionEvent = (MotionEvent) inputEvent;
        if (motionEvent.isTouchEvent()) {
            onTouchEvent(motionEvent, i);
        } else if ((motionEvent.getSource() & 4) != 0) {
            onTrackballEvent(motionEvent, i);
        } else {
            onGenericMotionEvent(motionEvent, i);
        }
    }

    public void onKeyEvent(KeyEvent keyEvent, int i) {
        if (startEvent(keyEvent, i, EVENT_TYPE_KEY)) {
            try {
                ensureMetaStateIsNormalized(keyEvent.getMetaState());
                int action = keyEvent.getAction();
                int deviceId = keyEvent.getDeviceId();
                int source = keyEvent.getSource();
                int keyCode = keyEvent.getKeyCode();
                switch (action) {
                    case 0:
                        KeyState findKeyState = findKeyState(deviceId, source, keyCode, false);
                        if (findKeyState == null) {
                            addKeyState(deviceId, source, keyCode);
                            break;
                        } else if (!findKeyState.unhandled) {
                            if ((this.mFlags & 1) == 0 && keyEvent.getRepeatCount() == 0) {
                                problem("ACTION_DOWN but key is already down and this event is not a key repeat.");
                                break;
                            }
                        } else {
                            findKeyState.unhandled = false;
                            break;
                        }
                        break;
                    case 1:
                        KeyState findKeyState2 = findKeyState(deviceId, source, keyCode, true);
                        if (findKeyState2 != null) {
                            findKeyState2.recycle();
                            break;
                        } else {
                            problem("ACTION_UP but key was not down.");
                            break;
                        }
                    case 2:
                        break;
                    default:
                        problem("Invalid action " + KeyEvent.actionToString(action) + " for key event.");
                        break;
                }
            } finally {
                finishEvent();
            }
        }
    }

    public void onTouchEvent(MotionEvent motionEvent, int i) {
        if (startEvent(motionEvent, i, EVENT_TYPE_TOUCH)) {
            int action = motionEvent.getAction();
            boolean z = action == 0 || action == 3 || action == 4;
            if (z && (this.mTouchEventStreamIsTainted || this.mTouchEventStreamUnhandled)) {
                this.mTouchEventStreamIsTainted = false;
                this.mTouchEventStreamUnhandled = false;
                this.mTouchEventStreamPointers = 0;
            }
            if (this.mTouchEventStreamIsTainted) {
                motionEvent.setTainted(true);
            }
            try {
                ensureMetaStateIsNormalized(motionEvent.getMetaState());
                int deviceId = motionEvent.getDeviceId();
                int source = motionEvent.getSource();
                if (!z && this.mTouchEventStreamDeviceId != -1 && (this.mTouchEventStreamDeviceId != deviceId || this.mTouchEventStreamSource != source)) {
                    problem("Touch event stream contains events from multiple sources: previous device id " + this.mTouchEventStreamDeviceId + ", previous source " + Integer.toHexString(this.mTouchEventStreamSource) + ", new device id " + deviceId + ", new source " + Integer.toHexString(source));
                }
                this.mTouchEventStreamDeviceId = deviceId;
                this.mTouchEventStreamSource = source;
                int pointerCount = motionEvent.getPointerCount();
                if ((source & 2) != 0) {
                    switch (action) {
                        case 0:
                            if (this.mTouchEventStreamPointers != 0) {
                                problem("ACTION_DOWN but pointers are already down.  Probably missing ACTION_UP from previous gesture.");
                            }
                            ensureHistorySizeIsZeroForThisAction(motionEvent);
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            this.mTouchEventStreamPointers = 1 << motionEvent.getPointerId(0);
                            break;
                        case 1:
                            ensureHistorySizeIsZeroForThisAction(motionEvent);
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            this.mTouchEventStreamPointers = 0;
                            this.mTouchEventStreamIsTainted = false;
                            break;
                        case 2:
                            int bitCount = Integer.bitCount(this.mTouchEventStreamPointers);
                            if (pointerCount != bitCount) {
                                problem("ACTION_MOVE contained " + pointerCount + " pointers but there are currently " + bitCount + " pointers down.");
                                this.mTouchEventStreamIsTainted = true;
                                break;
                            }
                            break;
                        case 3:
                            this.mTouchEventStreamPointers = 0;
                            this.mTouchEventStreamIsTainted = false;
                            break;
                        case 4:
                            if (this.mTouchEventStreamPointers != 0) {
                                problem("ACTION_OUTSIDE but pointers are still down.");
                            }
                            ensureHistorySizeIsZeroForThisAction(motionEvent);
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            this.mTouchEventStreamIsTainted = false;
                            break;
                        default:
                            int actionMasked = motionEvent.getActionMasked();
                            int actionIndex = motionEvent.getActionIndex();
                            if (actionMasked != 5) {
                                if (actionMasked != 6) {
                                    problem("Invalid action " + MotionEvent.actionToString(action) + " for touch event.");
                                    break;
                                } else {
                                    if (actionIndex < 0 || actionIndex >= pointerCount) {
                                        problem("ACTION_POINTER_UP index is " + actionIndex + " but the pointer count is " + pointerCount + ".");
                                        this.mTouchEventStreamIsTainted = true;
                                    } else {
                                        int pointerId = motionEvent.getPointerId(actionIndex);
                                        int i2 = 1 << pointerId;
                                        if ((this.mTouchEventStreamPointers & i2) == 0) {
                                            problem("ACTION_POINTER_UP specified pointer id " + pointerId + " which is not currently down.");
                                            this.mTouchEventStreamIsTainted = true;
                                        } else {
                                            this.mTouchEventStreamPointers &= i2 ^ (-1);
                                        }
                                    }
                                    ensureHistorySizeIsZeroForThisAction(motionEvent);
                                    break;
                                }
                            } else {
                                if (this.mTouchEventStreamPointers == 0) {
                                    problem("ACTION_POINTER_DOWN but no other pointers were down.");
                                    this.mTouchEventStreamIsTainted = true;
                                }
                                if (actionIndex < 0 || actionIndex >= pointerCount) {
                                    problem("ACTION_POINTER_DOWN index is " + actionIndex + " but the pointer count is " + pointerCount + ".");
                                    this.mTouchEventStreamIsTainted = true;
                                } else {
                                    int pointerId2 = motionEvent.getPointerId(actionIndex);
                                    int i3 = 1 << pointerId2;
                                    if ((this.mTouchEventStreamPointers & i3) != 0) {
                                        problem("ACTION_POINTER_DOWN specified pointer id " + pointerId2 + " which is already down.");
                                        this.mTouchEventStreamIsTainted = true;
                                    } else {
                                        this.mTouchEventStreamPointers |= i3;
                                    }
                                }
                                ensureHistorySizeIsZeroForThisAction(motionEvent);
                                break;
                            }
                            break;
                    }
                } else {
                    problem("Source was not SOURCE_CLASS_POINTER.");
                }
            } finally {
                finishEvent();
            }
        }
    }

    public void onTrackballEvent(MotionEvent motionEvent, int i) {
        if (startEvent(motionEvent, i, EVENT_TYPE_TRACKBALL)) {
            try {
                ensureMetaStateIsNormalized(motionEvent.getMetaState());
                int action = motionEvent.getAction();
                if ((motionEvent.getSource() & 4) != 0) {
                    switch (action) {
                        case 0:
                            if (!this.mTrackballDown || this.mTrackballUnhandled) {
                                this.mTrackballDown = true;
                                this.mTrackballUnhandled = false;
                            } else {
                                problem("ACTION_DOWN but trackball is already down.");
                            }
                            ensureHistorySizeIsZeroForThisAction(motionEvent);
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            break;
                        case 1:
                            if (this.mTrackballDown) {
                                this.mTrackballDown = false;
                                this.mTrackballUnhandled = false;
                            } else {
                                problem("ACTION_UP but trackball is not down.");
                            }
                            ensureHistorySizeIsZeroForThisAction(motionEvent);
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            break;
                        case 2:
                            ensurePointerCountIsOneForThisAction(motionEvent);
                            break;
                        default:
                            problem("Invalid action " + MotionEvent.actionToString(action) + " for trackball event.");
                            break;
                    }
                    if (this.mTrackballDown && motionEvent.getPressure() <= 0.0f) {
                        problem("Trackball is down but pressure is not greater than 0.");
                    } else if (!this.mTrackballDown && motionEvent.getPressure() != 0.0f) {
                        problem("Trackball is up but pressure is not equal to 0.");
                    }
                } else {
                    problem("Source was not SOURCE_CLASS_TRACKBALL.");
                }
            } finally {
                finishEvent();
            }
        }
    }

    public void onUnhandledEvent(InputEvent inputEvent, int i) {
        if (i != this.mLastNestingLevel) {
            return;
        }
        if (this.mRecentEventsUnhandled != null) {
            this.mRecentEventsUnhandled[this.mMostRecentEventIndex] = true;
        }
        if (inputEvent instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) inputEvent;
            KeyState findKeyState = findKeyState(keyEvent.getDeviceId(), keyEvent.getSource(), keyEvent.getKeyCode(), false);
            if (findKeyState != null) {
                findKeyState.unhandled = true;
                return;
            }
            return;
        }
        MotionEvent motionEvent = (MotionEvent) inputEvent;
        if (motionEvent.isTouchEvent()) {
            this.mTouchEventStreamUnhandled = true;
        } else if ((motionEvent.getSource() & 4) == 0 || !this.mTrackballDown) {
        } else {
            this.mTrackballUnhandled = true;
        }
    }

    public void reset() {
        this.mLastEventSeq = -1;
        this.mLastNestingLevel = 0;
        this.mTrackballDown = false;
        this.mTrackballUnhandled = false;
        this.mTouchEventStreamPointers = 0;
        this.mTouchEventStreamIsTainted = false;
        this.mTouchEventStreamUnhandled = false;
        this.mHoverEntered = false;
        while (this.mKeyStateList != null) {
            KeyState keyState = this.mKeyStateList;
            this.mKeyStateList = keyState.next;
            keyState.recycle();
        }
    }
}
