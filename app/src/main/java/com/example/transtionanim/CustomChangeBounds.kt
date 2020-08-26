package com.example.transtionanim

import android.R
import android.animation.Animator
import android.transition.ChangeBounds
import android.transition.TransitionValues
import android.view.ViewGroup
import android.view.animation.AnimationUtils

class CustomChangeBounds : ChangeBounds() {
    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        val changeBounds: Animator = super.createAnimator(sceneRoot, startValues, endValues)
        if (startValues == null || endValues == null || changeBounds == null) return null

//        if (endValues.view instanceof ViewGroup) {
//            ViewGroup vg = (ViewGroup) endValues.view;
//            float offset = vg.getHeight() / 3;
//            for (int i = 0; i < vg.getChildCount(); i++) {
//                View v = vg.getChildAt(i);
//                v.setTranslationY(offset);
//                v.setAlpha(0f);
//                v.animate()
//                        .alpha(1f)
//                        .translationY(0f)
//                        .setDuration(150)
//                        .setStartDelay(150)
//                        .setInterpolator(AnimationUtils.loadInterpolator(vg.getContext(),
//                                android.R.interpolator.fast_out_slow_in));
//                offset *= 1.8f;
//            }
//        }
        changeBounds.setDuration(300)
        changeBounds.setInterpolator(
            AnimationUtils.loadInterpolator(
                sceneRoot.getContext(),
                R.interpolator.fast_out_slow_in
            )
        )
        return changeBounds
    }
}