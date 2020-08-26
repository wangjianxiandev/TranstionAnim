package com.example.transtionanim

import android.os.Bundle
import android.transition.ArcMotion
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_contact_detail.*
import kotlinx.android.synthetic.main.contact_info_fragment.*

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @CreateDate: 2020/8/26 22:28
 */
class ContactInfoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contact_info_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //定义ArcMotion
        var arcMotion = ArcMotion()
        arcMotion.setMinimumHorizontalAngle(50f)
        arcMotion.setMinimumVerticalAngle(50f)
        //插值器，控制速度
        var interpolator =
            AnimationUtils.loadInterpolator(activity, android.R.interpolator.fast_out_slow_in)
        //实例化自定义的ChangeBounds
        var changeBounds: CustomChangeBounds = CustomChangeBounds()

        changeBounds.setPathMotion(arcMotion)
        changeBounds.setInterpolator(interpolator)
        changeBounds.addTarget(big_photo)

        //将切换动画应用到当前的Activity的进入和返回
        activity!!.getWindow().setSharedElementEnterTransition(changeBounds)
        activity!!.getWindow().setSharedElementReturnTransition(changeBounds)
    }
}