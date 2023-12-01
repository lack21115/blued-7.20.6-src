package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RadialTimePickerView;
import android.widget.TimePicker;
import com.android.internal.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-4181928-dex2jar.jar:android/widget/TimePickerClockDelegate.class */
public class TimePickerClockDelegate extends TimePicker.AbstractTimePickerDelegate implements RadialTimePickerView.OnValueSelectedListener {
    static final int AM = 0;
    private static final int AMPM_INDEX = 2;
    private static final boolean DEFAULT_ENABLED_STATE = true;
    private static final int ENABLE_PICKER_INDEX = 3;
    private static final int HOURS_IN_HALF_DAY = 12;
    private static final int HOUR_INDEX = 0;
    private static final int MINUTE_INDEX = 1;
    static final int PM = 1;
    private static final String TAG = "TimePickerClockDelegate";
    private boolean mAllowAutoAdvance;
    private int mAmKeyCode;
    private final CheckedTextView mAmLabel;
    private final View mAmPmLayout;
    private final String mAmText;
    private final View.OnClickListener mClickListener;
    private String mDeletedKeyFormat;
    private final float mDisabledAlpha;
    private String mDoublePlaceholderText;
    private final View.OnFocusChangeListener mFocusListener;
    private final View mHeaderView;
    private final TextView mHourView;
    private boolean mInKbMode;
    private int mInitialHourOfDay;
    private int mInitialMinute;
    private boolean mIs24HourView;
    private boolean mIsEnabled;
    private final View.OnKeyListener mKeyListener;
    private boolean mLastAnnouncedIsHour;
    private CharSequence mLastAnnouncedText;
    private Node mLegalTimesTree;
    private final TextView mMinuteView;
    private char mPlaceholderText;
    private int mPmKeyCode;
    private final CheckedTextView mPmLabel;
    private final String mPmText;
    private final RadialTimePickerView mRadialTimePickerView;
    private String mSelectHours;
    private String mSelectMinutes;
    private final TextView mSeparatorView;
    private Calendar mTempCalendar;
    private ArrayList<Integer> mTypedTimes;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TimePickerClockDelegate$ClickActionDelegate.class */
    private static class ClickActionDelegate extends View.AccessibilityDelegate {
        private final AccessibilityNodeInfo.AccessibilityAction mClickAction;

        public ClickActionDelegate(Context context, int i) {
            this.mClickAction = new AccessibilityNodeInfo.AccessibilityAction(16, context.getString(i));
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.addAction(this.mClickAction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TimePickerClockDelegate$Node.class */
    public class Node {
        private ArrayList<Node> mChildren = new ArrayList<>();
        private int[] mLegalKeys;

        public Node(int... iArr) {
            this.mLegalKeys = iArr;
        }

        public void addChild(Node node) {
            this.mChildren.add(node);
        }

        public Node canReach(int i) {
            if (this.mChildren == null) {
                return null;
            }
            Iterator<Node> it = this.mChildren.iterator();
            while (it.hasNext()) {
                Node next = it.next();
                if (next.containsKey(i)) {
                    return next;
                }
            }
            return null;
        }

        public boolean containsKey(int i) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.mLegalKeys.length) {
                    return false;
                }
                if (this.mLegalKeys[i3] == i) {
                    return true;
                }
                i2 = i3 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TimePickerClockDelegate$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.TimePickerClockDelegate.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        private final int mCurrentItemShowing;
        private final int mHour;
        private final boolean mInKbMode;
        private final boolean mIs24HourMode;
        private final int mMinute;
        private final ArrayList<Integer> mTypedTimes;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mHour = parcel.readInt();
            this.mMinute = parcel.readInt();
            this.mIs24HourMode = parcel.readInt() == 1;
            this.mInKbMode = parcel.readInt() == 1;
            this.mTypedTimes = parcel.readArrayList(getClass().getClassLoader());
            this.mCurrentItemShowing = parcel.readInt();
        }

        private SavedState(Parcelable parcelable, int i, int i2, boolean z, boolean z2, ArrayList<Integer> arrayList, int i3) {
            super(parcelable);
            this.mHour = i;
            this.mMinute = i2;
            this.mIs24HourMode = z;
            this.mInKbMode = z2;
            this.mTypedTimes = arrayList;
            this.mCurrentItemShowing = i3;
        }

        public int getCurrentItemShowing() {
            return this.mCurrentItemShowing;
        }

        public int getHour() {
            return this.mHour;
        }

        public int getMinute() {
            return this.mMinute;
        }

        public ArrayList<Integer> getTypesTimes() {
            return this.mTypedTimes;
        }

        public boolean inKbMode() {
            return this.mInKbMode;
        }

        public boolean is24HourMode() {
            return this.mIs24HourMode;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mHour);
            parcel.writeInt(this.mMinute);
            parcel.writeInt(this.mIs24HourMode ? 1 : 0);
            parcel.writeInt(this.mInKbMode ? 1 : 0);
            parcel.writeList(this.mTypedTimes);
            parcel.writeInt(this.mCurrentItemShowing);
        }
    }

    public TimePickerClockDelegate(TimePicker timePicker, Context context, AttributeSet attributeSet, int i, int i2) {
        super(timePicker, context);
        this.mIsEnabled = true;
        this.mTypedTimes = new ArrayList<>();
        this.mClickListener = new View.OnClickListener() { // from class: android.widget.TimePickerClockDelegate.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.hours /* 16909242 */:
                        TimePickerClockDelegate.this.setCurrentItemShowing(0, true, true);
                        break;
                    case R.id.separator /* 16909243 */:
                    case R.id.ampm_layout /* 16909245 */:
                    default:
                        return;
                    case R.id.minutes /* 16909244 */:
                        TimePickerClockDelegate.this.setCurrentItemShowing(1, true, true);
                        break;
                    case R.id.am_label /* 16909246 */:
                        TimePickerClockDelegate.this.setAmOrPm(0);
                        break;
                    case R.id.pm_label /* 16909247 */:
                        TimePickerClockDelegate.this.setAmOrPm(1);
                        break;
                }
                TimePickerClockDelegate.this.tryVibrate();
            }
        };
        this.mKeyListener = new View.OnKeyListener() { // from class: android.widget.TimePickerClockDelegate.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (keyEvent.getAction() == 1) {
                    return TimePickerClockDelegate.this.processKeyUp(i3);
                }
                return false;
            }
        };
        this.mFocusListener = new View.OnFocusChangeListener() { // from class: android.widget.TimePickerClockDelegate.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z && TimePickerClockDelegate.this.mInKbMode && TimePickerClockDelegate.this.isTypedTimeFullyLegal()) {
                    TimePickerClockDelegate.this.finishKbMode();
                    if (TimePickerClockDelegate.this.mOnTimeChangedListener != null) {
                        TimePickerClockDelegate.this.mOnTimeChangedListener.onTimeChanged(TimePickerClockDelegate.this.mDelegator, TimePickerClockDelegate.this.mRadialTimePickerView.getCurrentHour(), TimePickerClockDelegate.this.mRadialTimePickerView.getCurrentMinute());
                    }
                }
            }
        };
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TimePicker, i, i2);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        Resources resources = this.mContext.getResources();
        this.mSelectHours = resources.getString(R.string.select_hours);
        this.mSelectMinutes = resources.getString(R.string.select_minutes);
        String[] amPmStrings = TimePickerSpinnerDelegate.getAmPmStrings(context);
        this.mAmText = amPmStrings[0];
        this.mPmText = amPmStrings[1];
        View inflate = layoutInflater.inflate(obtainStyledAttributes.getResourceId(9, R.layout.time_picker_holo), timePicker);
        this.mHeaderView = inflate.findViewById(R.id.time_header);
        this.mHeaderView.setBackground(obtainStyledAttributes.getDrawable(0));
        this.mHourView = (TextView) this.mHeaderView.findViewById(R.id.hours);
        this.mHourView.setOnClickListener(this.mClickListener);
        this.mHourView.setAccessibilityDelegate(new ClickActionDelegate(context, R.string.select_hours));
        this.mSeparatorView = (TextView) this.mHeaderView.findViewById(R.id.separator);
        this.mMinuteView = (TextView) this.mHeaderView.findViewById(R.id.minutes);
        this.mMinuteView.setOnClickListener(this.mClickListener);
        this.mMinuteView.setAccessibilityDelegate(new ClickActionDelegate(context, R.string.select_minutes));
        int resourceId = obtainStyledAttributes.getResourceId(1, 0);
        if (resourceId != 0) {
            this.mHourView.setTextAppearance(context, resourceId);
            this.mSeparatorView.setTextAppearance(context, resourceId);
            this.mMinuteView.setTextAppearance(context, resourceId);
        }
        this.mHourView.setMinWidth(computeStableWidth(this.mHourView, 24));
        this.mMinuteView.setMinWidth(computeStableWidth(this.mMinuteView, 60));
        int color = obtainStyledAttributes.getColor(11, resources.getColor(R.color.timepicker_default_selector_color_material));
        this.mHourView.setTextColor(ColorStateList.addFirstIfMissing(this.mHourView.getTextColors(), R.attr.state_selected, color));
        this.mMinuteView.setTextColor(ColorStateList.addFirstIfMissing(this.mMinuteView.getTextColors(), R.attr.state_selected, color));
        this.mAmPmLayout = this.mHeaderView.findViewById(R.id.ampm_layout);
        this.mAmLabel = (CheckedTextView) this.mAmPmLayout.findViewById(R.id.am_label);
        this.mAmLabel.setText(amPmStrings[0]);
        this.mAmLabel.setOnClickListener(this.mClickListener);
        this.mPmLabel = (CheckedTextView) this.mAmPmLayout.findViewById(R.id.pm_label);
        this.mPmLabel.setText(amPmStrings[1]);
        this.mPmLabel.setOnClickListener(this.mClickListener);
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId2 != 0) {
            this.mAmLabel.setTextAppearance(context, resourceId2);
            this.mPmLabel.setTextAppearance(context, resourceId2);
        }
        obtainStyledAttributes.recycle();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        this.mDisabledAlpha = typedValue.getFloat();
        this.mRadialTimePickerView = (RadialTimePickerView) inflate.findViewById(R.id.radial_picker);
        setupListeners();
        this.mAllowAutoAdvance = true;
        this.mDoublePlaceholderText = resources.getString(R.string.time_placeholder);
        this.mDeletedKeyFormat = resources.getString(R.string.deleted_key);
        this.mPlaceholderText = this.mDoublePlaceholderText.charAt(0);
        this.mPmKeyCode = -1;
        this.mAmKeyCode = -1;
        generateLegalTimesTree();
        Calendar calendar = Calendar.getInstance(this.mCurrentLocale);
        initialize(calendar.get(11), calendar.get(12), false, 0);
    }

    private boolean addKeyIfLegal(int i) {
        if (this.mIs24HourView && this.mTypedTimes.size() == 4) {
            return false;
        }
        if (this.mIs24HourView || !isTypedTimeFullyLegal()) {
            this.mTypedTimes.add(Integer.valueOf(i));
            if (!isTypedTimeLegalSoFar()) {
                deleteLastTypedKey();
                return false;
            }
            this.mDelegator.announceForAccessibility(String.format("%d", Integer.valueOf(getValFromKeyCode(i))));
            if (isTypedTimeFullyLegal()) {
                if (!this.mIs24HourView && this.mTypedTimes.size() <= 3) {
                    this.mTypedTimes.add(this.mTypedTimes.size() - 1, 7);
                    this.mTypedTimes.add(this.mTypedTimes.size() - 1, 7);
                }
                onValidationChanged(true);
                return true;
            }
            return true;
        }
        return false;
    }

    private int computeStableWidth(TextView textView, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            textView.setText(String.format("%02d", Integer.valueOf(i3)));
            textView.measure(0, 0);
            int measuredWidth = textView.getMeasuredWidth();
            int i4 = i2;
            if (measuredWidth > i2) {
                i4 = measuredWidth;
            }
            i3++;
            i2 = i4;
        }
        return i2;
    }

    private int deleteLastTypedKey() {
        int intValue = this.mTypedTimes.remove(this.mTypedTimes.size() - 1).intValue();
        if (!isTypedTimeFullyLegal()) {
            onValidationChanged(false);
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishKbMode() {
        this.mInKbMode = false;
        if (!this.mTypedTimes.isEmpty()) {
            int[] enteredTime = getEnteredTime(null);
            this.mRadialTimePickerView.setCurrentHour(enteredTime[0]);
            this.mRadialTimePickerView.setCurrentMinute(enteredTime[1]);
            if (!this.mIs24HourView) {
                this.mRadialTimePickerView.setAmOrPm(enteredTime[2]);
            }
            this.mTypedTimes.clear();
        }
        updateDisplay(false);
        this.mRadialTimePickerView.setInputEnabled(true);
    }

    private void generateLegalTimesTree() {
        this.mLegalTimesTree = new Node(new int[0]);
        if (this.mIs24HourView) {
            Node node = new Node(7, 8, 9, 10, 11, 12);
            Node node2 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            node.addChild(node2);
            Node node3 = new Node(7, 8);
            this.mLegalTimesTree.addChild(node3);
            Node node4 = new Node(7, 8, 9, 10, 11, 12);
            node3.addChild(node4);
            node4.addChild(node);
            node4.addChild(new Node(13, 14, 15, 16));
            Node node5 = new Node(13, 14, 15, 16);
            node3.addChild(node5);
            node5.addChild(node);
            Node node6 = new Node(9);
            this.mLegalTimesTree.addChild(node6);
            Node node7 = new Node(7, 8, 9, 10);
            node6.addChild(node7);
            node7.addChild(node);
            Node node8 = new Node(11, 12);
            node6.addChild(node8);
            node8.addChild(node2);
            Node node9 = new Node(10, 11, 12, 13, 14, 15, 16);
            this.mLegalTimesTree.addChild(node9);
            node9.addChild(node);
            return;
        }
        Node node10 = new Node(getAmOrPmKeyCode(0), getAmOrPmKeyCode(1));
        Node node11 = new Node(8);
        this.mLegalTimesTree.addChild(node11);
        node11.addChild(node10);
        Node node12 = new Node(7, 8, 9);
        node11.addChild(node12);
        node12.addChild(node10);
        Node node13 = new Node(7, 8, 9, 10, 11, 12);
        node12.addChild(node13);
        node13.addChild(node10);
        Node node14 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node13.addChild(node14);
        node14.addChild(node10);
        Node node15 = new Node(13, 14, 15, 16);
        node12.addChild(node15);
        node15.addChild(node10);
        Node node16 = new Node(10, 11, 12);
        node11.addChild(node16);
        Node node17 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node16.addChild(node17);
        node17.addChild(node10);
        Node node18 = new Node(9, 10, 11, 12, 13, 14, 15, 16);
        this.mLegalTimesTree.addChild(node18);
        node18.addChild(node10);
        Node node19 = new Node(7, 8, 9, 10, 11, 12);
        node18.addChild(node19);
        Node node20 = new Node(7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        node19.addChild(node20);
        node20.addChild(node10);
    }

    private int getAmOrPmKeyCode(int i) {
        int i2;
        if (this.mAmKeyCode == -1 || this.mPmKeyCode == -1) {
            KeyCharacterMap load = KeyCharacterMap.load(-1);
            String lowerCase = this.mAmText.toLowerCase(this.mCurrentLocale);
            String lowerCase2 = this.mPmText.toLowerCase(this.mCurrentLocale);
            int min = Math.min(lowerCase.length(), lowerCase2.length());
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= min) {
                    break;
                }
                char charAt = lowerCase.charAt(i4);
                char charAt2 = lowerCase2.charAt(i4);
                if (charAt != charAt2) {
                    KeyEvent[] events = load.getEvents(new char[]{charAt, charAt2});
                    if (events == null || events.length != 4) {
                        Log.e(TAG, "Unable to find keycodes for AM and PM.");
                    } else {
                        this.mAmKeyCode = events[0].getKeyCode();
                        this.mPmKeyCode = events[2].getKeyCode();
                    }
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        if (i == 0) {
            i2 = this.mAmKeyCode;
        } else {
            i2 = -1;
            if (i == 1) {
                return this.mPmKeyCode;
            }
        }
        return i2;
    }

    private int getCurrentItemShowing() {
        return this.mRadialTimePickerView.getCurrentItemShowing();
    }

    private int[] getEnteredTime(boolean[] zArr) {
        int i;
        int i2;
        int i3 = -1;
        int i4 = -1;
        int i5 = 1;
        if (!this.mIs24HourView) {
            i4 = -1;
            i5 = 1;
            if (isTypedTimeFullyLegal()) {
                int intValue = this.mTypedTimes.get(this.mTypedTimes.size() - 1).intValue();
                if (intValue == getAmOrPmKeyCode(0)) {
                    i3 = 0;
                } else if (intValue == getAmOrPmKeyCode(1)) {
                    i3 = 1;
                }
                i5 = 2;
                i4 = i3;
            }
        }
        int i6 = -1;
        int i7 = -1;
        int i8 = i5;
        while (i8 <= this.mTypedTimes.size()) {
            int valFromKeyCode = getValFromKeyCode(this.mTypedTimes.get(this.mTypedTimes.size() - i8).intValue());
            if (i8 == i5) {
                i2 = valFromKeyCode;
                i = i7;
            } else if (i8 == i5 + 1) {
                int i9 = i6 + (valFromKeyCode * 10);
                i = i7;
                i2 = i9;
                if (zArr != null) {
                    i = i7;
                    i2 = i9;
                    if (valFromKeyCode == 0) {
                        zArr[1] = true;
                        i = i7;
                        i2 = i9;
                    }
                }
            } else if (i8 == i5 + 2) {
                i = valFromKeyCode;
                i2 = i6;
            } else {
                i = i7;
                i2 = i6;
                if (i8 == i5 + 3) {
                    int i10 = i7 + (valFromKeyCode * 10);
                    i = i10;
                    i2 = i6;
                    if (zArr != null) {
                        i = i10;
                        i2 = i6;
                        if (valFromKeyCode == 0) {
                            zArr[0] = true;
                            i = i10;
                            i2 = i6;
                        }
                    }
                }
            }
            i8++;
            i7 = i;
            i6 = i2;
        }
        return new int[]{i7, i6, i4};
    }

    private ArrayList<Integer> getTypedTimes() {
        return this.mTypedTimes;
    }

    private int getValFromKeyCode(int i) {
        switch (i) {
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 2;
            case 10:
                return 3;
            case 11:
                return 4;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 7;
            case 15:
                return 8;
            case 16:
                return 9;
            default:
                return -1;
        }
    }

    private boolean inKbMode() {
        return this.mInKbMode;
    }

    private void initialize(int i, int i2, boolean z, int i3) {
        this.mInitialHourOfDay = i;
        this.mInitialMinute = i2;
        this.mIs24HourView = z;
        this.mInKbMode = false;
        updateUI(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTypedTimeFullyLegal() {
        boolean z = false;
        if (this.mIs24HourView) {
            int[] enteredTime = getEnteredTime(null);
            return enteredTime[0] >= 0 && enteredTime[1] >= 0 && enteredTime[1] < 60;
        }
        if (this.mTypedTimes.contains(Integer.valueOf(getAmOrPmKeyCode(0))) || this.mTypedTimes.contains(Integer.valueOf(getAmOrPmKeyCode(1)))) {
            z = true;
        }
        return z;
    }

    private boolean isTypedTimeLegalSoFar() {
        Node node = this.mLegalTimesTree;
        Iterator<Integer> it = this.mTypedTimes.iterator();
        while (it.hasNext()) {
            Node canReach = node.canReach(it.next().intValue());
            node = canReach;
            if (canReach == null) {
                return false;
            }
        }
        return true;
    }

    private static int lastIndexOfAny(String str, char[] cArr) {
        int length = cArr.length;
        if (length <= 0) {
            return -1;
        }
        int length2 = str.length();
        while (true) {
            int i = length2 - 1;
            if (i < 0) {
                return -1;
            }
            char charAt = str.charAt(i);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < length) {
                    if (charAt == cArr[i3]) {
                        return i;
                    }
                    i2 = i3 + 1;
                }
            }
            length2 = i;
        }
    }

    private static int modulo12(int i, boolean z) {
        int i2 = i % 12;
        int i3 = i2;
        if (i2 == 0) {
            i3 = i2;
            if (!z) {
                i3 = 12;
            }
        }
        return i3;
    }

    private void onTimeChanged() {
        this.mDelegator.sendAccessibilityEvent(4);
        if (this.mOnTimeChangedListener != null) {
            this.mOnTimeChangedListener.onTimeChanged(this.mDelegator, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean processKeyUp(int i) {
        boolean z = true;
        if (i == 67) {
            if (this.mInKbMode && !this.mTypedTimes.isEmpty()) {
                int deleteLastTypedKey = deleteLastTypedKey();
                this.mDelegator.announceForAccessibility(String.format(this.mDeletedKeyFormat, deleteLastTypedKey == getAmOrPmKeyCode(0) ? this.mAmText : deleteLastTypedKey == getAmOrPmKeyCode(1) ? this.mPmText : String.format("%d", Integer.valueOf(getValFromKeyCode(deleteLastTypedKey)))));
                updateDisplay(true);
            }
        } else if (i == 7 || i == 8 || i == 9 || i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || (!this.mIs24HourView && (i == getAmOrPmKeyCode(0) || i == getAmOrPmKeyCode(1)))) {
            if (this.mInKbMode) {
                if (addKeyIfLegal(i)) {
                    updateDisplay(false);
                    return true;
                }
                return z;
            } else if (this.mRadialTimePickerView == null) {
                Log.e(TAG, "Unable to initiate keyboard mode, TimePicker was null.");
                return true;
            } else {
                this.mTypedTimes.clear();
                tryStartingKbMode(i);
                return true;
            }
        }
        z = false;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAmOrPm(int i) {
        updateAmPmLabelStates(i);
        this.mRadialTimePickerView.setAmOrPm(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentItemShowing(int i, boolean z, boolean z2) {
        this.mRadialTimePickerView.setCurrentItemShowing(i, z);
        if (i == 0) {
            if (z2) {
                this.mDelegator.announceForAccessibility(this.mSelectHours);
            }
        } else if (z2) {
            this.mDelegator.announceForAccessibility(this.mSelectMinutes);
        }
        this.mHourView.setSelected(i == 0);
        this.mMinuteView.setSelected(i == 1);
    }

    private void setInKbMode(boolean z) {
        this.mInKbMode = z;
    }

    private void setTypedTimes(ArrayList<Integer> arrayList) {
        this.mTypedTimes = arrayList;
    }

    private void setupListeners() {
        this.mHeaderView.setOnKeyListener(this.mKeyListener);
        this.mHeaderView.setOnFocusChangeListener(this.mFocusListener);
        this.mHeaderView.setFocusable(true);
        this.mRadialTimePickerView.setOnValueSelectedListener(this);
    }

    private void tryAnnounceForAccessibility(CharSequence charSequence, boolean z) {
        if (this.mLastAnnouncedIsHour == z && charSequence.equals(this.mLastAnnouncedText)) {
            return;
        }
        this.mDelegator.announceForAccessibility(charSequence);
        this.mLastAnnouncedText = charSequence;
        this.mLastAnnouncedIsHour = z;
    }

    private void tryStartingKbMode(int i) {
        if (i == -1 || addKeyIfLegal(i)) {
            this.mInKbMode = true;
            onValidationChanged(false);
            updateDisplay(false);
            this.mRadialTimePickerView.setInputEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryVibrate() {
        this.mDelegator.performHapticFeedback(4);
    }

    private void updateAmPmLabelStates(int i) {
        boolean z = i == 0;
        this.mAmLabel.setChecked(z);
        this.mAmLabel.setAlpha(z ? 1.0f : this.mDisabledAlpha);
        boolean z2 = i == 1;
        this.mPmLabel.setChecked(z2);
        this.mPmLabel.setAlpha(z2 ? 1.0f : this.mDisabledAlpha);
    }

    private void updateDisplay(boolean z) {
        if (!z && this.mTypedTimes.isEmpty()) {
            int currentHour = this.mRadialTimePickerView.getCurrentHour();
            int currentMinute = this.mRadialTimePickerView.getCurrentMinute();
            updateHeaderHour(currentHour, false);
            updateHeaderMinute(currentMinute, false);
            if (!this.mIs24HourView) {
                updateAmPmLabelStates(currentHour < 12 ? 0 : 1);
            }
            setCurrentItemShowing(this.mRadialTimePickerView.getCurrentItemShowing(), true, true);
            onValidationChanged(true);
            return;
        }
        boolean[] zArr = {false, false};
        int[] enteredTime = getEnteredTime(zArr);
        String str = zArr[0] ? "%02d" : "%2d";
        String str2 = zArr[1] ? "%02d" : "%2d";
        String replace = enteredTime[0] == -1 ? this.mDoublePlaceholderText : String.format(str, Integer.valueOf(enteredTime[0])).replace(' ', this.mPlaceholderText);
        String replace2 = enteredTime[1] == -1 ? this.mDoublePlaceholderText : String.format(str2, Integer.valueOf(enteredTime[1])).replace(' ', this.mPlaceholderText);
        this.mHourView.setText(replace);
        this.mHourView.setSelected(false);
        this.mMinuteView.setText(replace2);
        this.mMinuteView.setSelected(false);
        if (this.mIs24HourView) {
            return;
        }
        updateAmPmLabelStates(enteredTime[2]);
    }

    private void updateHeaderAmPm() {
        if (this.mIs24HourView) {
            this.mAmPmLayout.setVisibility(8);
            return;
        }
        boolean startsWith = DateFormat.getBestDateTimePattern(this.mCurrentLocale, "hm").startsWith("a");
        ViewGroup viewGroup = (ViewGroup) this.mAmPmLayout.getParent();
        int childCount = startsWith ? 0 : viewGroup.getChildCount() - 1;
        if (childCount != viewGroup.indexOfChild(this.mAmPmLayout)) {
            viewGroup.removeView(this.mAmPmLayout);
            viewGroup.addView(this.mAmPmLayout, childCount);
        }
        updateAmPmLabelStates(this.mInitialHourOfDay < 12 ? 0 : 1);
    }

    private void updateHeaderHour(int i, boolean z) {
        int i2;
        char c;
        boolean z2;
        int modulo12;
        char charAt;
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(this.mCurrentLocale, this.mIs24HourView ? "Hm" : "hm");
        int length = bestDateTimePattern.length();
        int i3 = 0;
        while (true) {
            i2 = i3;
            c = 0;
            z2 = false;
            if (i2 >= length) {
                break;
            }
            charAt = bestDateTimePattern.charAt(i2);
            if (charAt == 'H' || charAt == 'h' || charAt == 'K' || charAt == 'k') {
                break;
            }
            i3 = i2 + 1;
        }
        c = charAt;
        z2 = false;
        if (i2 + 1 < length) {
            c = charAt;
            z2 = false;
            if (charAt == bestDateTimePattern.charAt(i2 + 1)) {
                z2 = true;
                c = charAt;
            }
        }
        String str = z2 ? "%02d" : "%d";
        if (this.mIs24HourView) {
            modulo12 = i;
            if (c == 'k') {
                modulo12 = i;
                if (i == 0) {
                    modulo12 = 24;
                }
            }
        } else {
            modulo12 = modulo12(i, c == 'K');
        }
        String format = String.format(str, Integer.valueOf(modulo12));
        this.mHourView.setText(format);
        if (z) {
            tryAnnounceForAccessibility(format, true);
        }
    }

    private void updateHeaderMinute(int i, boolean z) {
        int i2 = i;
        if (i == 60) {
            i2 = 0;
        }
        String format = String.format(this.mCurrentLocale, "%02d", Integer.valueOf(i2));
        this.mMinuteView.setText(format);
        if (z) {
            tryAnnounceForAccessibility(format, false);
        }
    }

    private void updateHeaderSeparator() {
        String bestDateTimePattern = DateFormat.getBestDateTimePattern(this.mCurrentLocale, this.mIs24HourView ? "Hm" : "hm");
        int lastIndexOfAny = lastIndexOfAny(bestDateTimePattern, new char[]{'H', 'h', 'K', 'k'});
        this.mSeparatorView.setText(lastIndexOfAny == -1 ? ":" : Character.toString(bestDateTimePattern.charAt(lastIndexOfAny + 1)));
    }

    private void updateRadialPicker(int i) {
        this.mRadialTimePickerView.initialize(this.mInitialHourOfDay, this.mInitialMinute, this.mIs24HourView);
        setCurrentItemShowing(i, false, true);
    }

    private void updateUI(int i) {
        updateRadialPicker(i);
        updateHeaderAmPm();
        updateHeaderHour(this.mInitialHourOfDay, false);
        updateHeaderSeparator();
        updateHeaderMinute(this.mInitialMinute, false);
        this.mDelegator.invalidate();
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public int getBaseline() {
        return -1;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public Integer getCurrentHour() {
        int currentHour = this.mRadialTimePickerView.getCurrentHour();
        if (this.mIs24HourView) {
            return Integer.valueOf(currentHour);
        }
        switch (this.mRadialTimePickerView.getAmOrPm()) {
            case 1:
                return Integer.valueOf((currentHour % 12) + 12);
            default:
                return Integer.valueOf(currentHour % 12);
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public Integer getCurrentMinute() {
        return Integer.valueOf(this.mRadialTimePickerView.getCurrentMinute());
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean is24HourView() {
        return this.mIs24HourView;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onConfigurationChanged(Configuration configuration) {
        updateUI(this.mRadialTimePickerView.getCurrentItemShowing());
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        accessibilityNodeInfo.setClassName(TimePicker.class.getName());
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i = this.mIs24HourView ? 1 | 128 : 1 | 64;
        this.mTempCalendar.set(11, getCurrentHour().intValue());
        this.mTempCalendar.set(12, getCurrentMinute().intValue());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(this.mContext, this.mTempCalendar.getTimeInMillis(), i));
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        setInKbMode(savedState.inKbMode());
        setTypedTimes(savedState.getTypesTimes());
        initialize(savedState.getHour(), savedState.getMinute(), savedState.is24HourMode(), savedState.getCurrentItemShowing());
        this.mRadialTimePickerView.invalidate();
        if (this.mInKbMode) {
            tryStartingKbMode(-1);
            this.mHourView.invalidate();
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public Parcelable onSaveInstanceState(Parcelable parcelable) {
        return new SavedState(parcelable, getCurrentHour().intValue(), getCurrentMinute().intValue(), is24HourView(), inKbMode(), getTypedTimes(), getCurrentItemShowing());
    }

    @Override // android.widget.RadialTimePickerView.OnValueSelectedListener
    public void onValueSelected(int i, int i2, boolean z) {
        switch (i) {
            case 0:
                if (!this.mAllowAutoAdvance || !z) {
                    updateHeaderHour(i2, true);
                    break;
                } else {
                    updateHeaderHour(i2, false);
                    setCurrentItemShowing(1, true, false);
                    this.mDelegator.announceForAccessibility(i2 + ". " + this.mSelectMinutes);
                    break;
                }
                break;
            case 1:
                updateHeaderMinute(i2, true);
                break;
            case 2:
                updateAmPmLabelStates(i2);
                break;
            case 3:
                if (!isTypedTimeFullyLegal()) {
                    this.mTypedTimes.clear();
                }
                finishKbMode();
                break;
        }
        if (this.mOnTimeChangedListener != null) {
            this.mOnTimeChangedListener.onTimeChanged(this.mDelegator, getCurrentHour().intValue(), getCurrentMinute().intValue());
        }
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setCurrentHour(Integer num) {
        int i = 1;
        if (this.mInitialHourOfDay == num.intValue()) {
            return;
        }
        this.mInitialHourOfDay = num.intValue();
        updateHeaderHour(num.intValue(), true);
        updateHeaderAmPm();
        this.mRadialTimePickerView.setCurrentHour(num.intValue());
        RadialTimePickerView radialTimePickerView = this.mRadialTimePickerView;
        if (this.mInitialHourOfDay < 12) {
            i = 0;
        }
        radialTimePickerView.setAmOrPm(i);
        this.mDelegator.invalidate();
        onTimeChanged();
    }

    @Override // android.widget.TimePicker.AbstractTimePickerDelegate
    public void setCurrentLocale(Locale locale) {
        super.setCurrentLocale(locale);
        this.mTempCalendar = Calendar.getInstance(locale);
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setCurrentMinute(Integer num) {
        if (this.mInitialMinute == num.intValue()) {
            return;
        }
        this.mInitialMinute = num.intValue();
        updateHeaderMinute(num.intValue(), true);
        this.mRadialTimePickerView.setCurrentMinute(num.intValue());
        this.mDelegator.invalidate();
        onTimeChanged();
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setEnabled(boolean z) {
        this.mHourView.setEnabled(z);
        this.mMinuteView.setEnabled(z);
        this.mAmLabel.setEnabled(z);
        this.mPmLabel.setEnabled(z);
        this.mRadialTimePickerView.setEnabled(z);
        this.mIsEnabled = z;
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setIs24HourView(Boolean bool) {
        if (bool.booleanValue() == this.mIs24HourView) {
            return;
        }
        this.mIs24HourView = bool.booleanValue();
        generateLegalTimesTree();
        int currentHour = this.mRadialTimePickerView.getCurrentHour();
        this.mInitialHourOfDay = currentHour;
        updateHeaderHour(currentHour, false);
        updateHeaderAmPm();
        updateRadialPicker(this.mRadialTimePickerView.getCurrentItemShowing());
        this.mDelegator.invalidate();
    }

    @Override // android.widget.TimePicker.TimePickerDelegate
    public void setOnTimeChangedListener(TimePicker.OnTimeChangedListener onTimeChangedListener) {
        this.mOnTimeChangedListener = onTimeChangedListener;
    }
}
