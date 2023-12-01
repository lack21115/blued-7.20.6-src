package com.tencent.tencentmap.lbssdk.service;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/lbssdk/service/GnssRaw.class */
public class GnssRaw {
    public double elapsedRealtime;
    public double mAccumulatedDeltaRangeMeters;
    public int mAccumulatedDeltaRangeState;
    public double mAccumulatedDeltaRangeUncertaintyMeters;
    public double mAutomaticGainControlLevelInDb;
    public double mBiasNanos;
    public double mBiasUncertaintyNanos;
    public long mCarrierCycles;
    public float mCarrierFrequencyHz;
    public double mCarrierPhase;
    public double mCarrierPhaseUncertainty;
    public double mCn0DbHz;
    public int mConstellationType;
    public double mDriftNanosPerSecond;
    public double mDriftUncertaintyNanosPerSecond;
    public int mEndFlag;
    public int mFlags;
    public long mFullBiasNanos;
    public int mHardwareClockDiscontinuityCount;
    public int mLeapSecond;
    public int mMultipathIndicator;
    public double mPseudorangeRateMetersPerSecond;
    public double mPseudorangeRateUncertaintyMetersPerSecond;
    public long mReceivedSvTimeNanos;
    public long mReceivedSvTimeUncertaintyNanos;
    public double mSnrInDb;
    public int mState;
    public int mSvid;
    public long mTimeNanos;
    public double mTimeOffsetNanos;
    public double mTimeUncertaintyNanos;
    public int mProvider = -1;
    public long mTime = 0;
    public long mElapsedRealtimeNanos = 0;
    public double mLatitude = 0.0d;
    public double mLongitude = 0.0d;
    public double mAltitude = 0.0d;
    public float mSpeed = 0.0f;
    public float mBearing = 0.0f;
    public float mHorizontalAccuracyMeters = 0.0f;
    public float mVerticalAccuracyMeters = 0.0f;
    public float mSpeedAccuracyMetersPerSecond = 0.0f;
    public float mBearingAccuracyDegrees = 0.0f;
}
