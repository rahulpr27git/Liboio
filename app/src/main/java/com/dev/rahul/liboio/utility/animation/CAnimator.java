package com.dev.rahul.liboio.utility.animation;

import android.animation.Animator;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by rahul on 21/1/18.
 */

public class CAnimator {

    public static Animator getRippleAnim(@NonNull View view) {
        // get the center for the clipping circle
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;

// get the final radius for the clipping circle
        float finalRadius = (float) Math.hypot(cx, cy);

// create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);

        return anim;

    }
}
