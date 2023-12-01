package com.sobot.chat.widget.timePicker.adapter;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/adapter/SobotNumericWheelAdapter.class */
public class SobotNumericWheelAdapter implements SobotWheelAdapter {
    public static final int DEFAULT_MAX_VALUE = 9;
    private static final int DEFAULT_MIN_VALUE = 0;
    private int maxValue;
    private int minValue;

    public SobotNumericWheelAdapter() {
        this(0, 9);
    }

    public SobotNumericWheelAdapter(int i, int i2) {
        this.minValue = i;
        this.maxValue = i2;
    }

    @Override // com.sobot.chat.widget.timePicker.adapter.SobotWheelAdapter
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.minValue + i);
    }

    @Override // com.sobot.chat.widget.timePicker.adapter.SobotWheelAdapter
    public int getItemsCount() {
        return (this.maxValue - this.minValue) + 1;
    }

    @Override // com.sobot.chat.widget.timePicker.adapter.SobotWheelAdapter
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.minValue;
        } catch (Exception e) {
            return -1;
        }
    }
}
