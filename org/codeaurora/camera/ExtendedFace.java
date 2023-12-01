package org.codeaurora.camera;

import android.hardware.Camera;
import android.os.Bundle;

/* loaded from: source-4181928-dex2jar.jar:org/codeaurora/camera/ExtendedFace.class */
public class ExtendedFace extends Camera.Face {
    private static final String BUNDLE_KEY_BLINK_DETECTED = "blinkDetected";
    private static final String BUNDLE_KEY_FACE_PITCH_DEGREE = "facePitchDegree";
    private static final String BUNDLE_KEY_FACE_RECOGNIZED = "faceRecognized";
    private static final String BUNDLE_KEY_FACE_ROLL_DEGREE = "faceRollDegree";
    private static final String BUNDLE_KEY_FACE_YAW_DEGREE = "faceYawDegree";
    private static final String BUNDLE_KEY_GAZE_LEFT_RIGHT_DEGREE = "gazeLeftRightDegree";
    private static final String BUNDLE_KEY_GAZE_UP_DOWN_DEGREE = "gazeUpDownDegree";
    private static final String BUNDLE_KEY_LEFT_EYE_CLOSED_VALUE = "leftEyeClosedValue";
    private static final String BUNDLE_KEY_RIGHT_EYE_CLOSED_VALUE = "rightEyeClosedValue";
    private static final String BUNDLE_KEY_SMILE_SCORE = "smileScore";
    private static final String BUNDLE_KEY_SMILE_VALUE = "smileValue";
    private static final String STR_FALSE = "false";
    private static final String STR_TRUE = "true";
    private int smileDegree = 0;
    private int smileScore = 0;
    private int blinkDetected = 0;
    private int faceRecognized = 0;
    private int gazeAngle = 0;
    private int updownDir = 0;
    private int leftrightDir = 0;
    private int rollDir = 0;
    private int leyeBlink = 0;
    private int reyeBlink = 0;
    private int leftrightGaze = 0;
    private int topbottomGaze = 0;

    public int getBlinkDetected() {
        return this.blinkDetected;
    }

    public Bundle getExtendedFaceInfo() {
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY_SMILE_VALUE, this.smileDegree);
        bundle.putInt(BUNDLE_KEY_LEFT_EYE_CLOSED_VALUE, this.leyeBlink);
        bundle.putInt(BUNDLE_KEY_RIGHT_EYE_CLOSED_VALUE, this.reyeBlink);
        bundle.putInt(BUNDLE_KEY_FACE_PITCH_DEGREE, this.updownDir);
        bundle.putInt(BUNDLE_KEY_FACE_YAW_DEGREE, this.leftrightDir);
        bundle.putInt(BUNDLE_KEY_FACE_ROLL_DEGREE, this.rollDir);
        bundle.putInt(BUNDLE_KEY_GAZE_UP_DOWN_DEGREE, this.topbottomGaze);
        bundle.putInt(BUNDLE_KEY_GAZE_LEFT_RIGHT_DEGREE, this.leftrightGaze);
        bundle.putInt(BUNDLE_KEY_BLINK_DETECTED, this.blinkDetected);
        bundle.putInt(BUNDLE_KEY_SMILE_SCORE, this.smileScore);
        bundle.putInt(BUNDLE_KEY_FACE_RECOGNIZED, this.faceRecognized);
        return bundle;
    }

    public int getFaceRecognized() {
        return this.faceRecognized;
    }

    public int getGazeAngle() {
        return this.gazeAngle;
    }

    public int getLeftEyeBlinkDegree() {
        return this.leyeBlink;
    }

    public int getLeftRightDirection() {
        return this.leftrightDir;
    }

    public int getLeftRightGazeDegree() {
        return this.leftrightGaze;
    }

    public int getRightEyeBlinkDegree() {
        return this.reyeBlink;
    }

    public int getRollDirection() {
        return this.rollDir;
    }

    public int getSmileDegree() {
        return this.smileDegree;
    }

    public int getSmileScore() {
        return this.smileScore;
    }

    public int getTopBottomGazeDegree() {
        return this.topbottomGaze;
    }

    public int getUpDownDirection() {
        return this.updownDir;
    }
}
