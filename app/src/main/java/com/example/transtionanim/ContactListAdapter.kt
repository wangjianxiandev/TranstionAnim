package com.example.transtionanim

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*


/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @CreateDate: 2020/8/26 22:29
 */
class ContactListAdaper(
    context: Activity,
    collectList: List<String>?
) :
    RecyclerView.Adapter<ContactListAdaper.ContactListHolder?>() {
    private val mContext: Activity
    private val mCollectList: MutableList<String>? =
        ArrayList<String>()
    fun setCollectList(collectList: MutableList<String>?) {
        mCollectList!!.clear()
        mCollectList.addAll(collectList!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactListHolder {
        val view: View =
            LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false)
        return ContactListHolder(view)
    }

    override fun onBindViewHolder(
        contactListHolder: ContactListHolder,
        i: Int
    ) {
        val bitmap: Bitmap = BitmapFactory.decodeResource(
            mContext.resources,
            R.drawable.niuniu
        )
        contactListHolder.circleImageView.setImageBitmap(bitmap)
        contactListHolder.circleImageView.transitionName = "image"
        contactListHolder.itemView.setOnClickListener {
            val i = Intent(mContext, ContactDetailActivity::class.java)
            val optionsCompat: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(mContext, contactListHolder.circleImageView, "image")
            startActivity(mContext, i, optionsCompat.toBundle())
        }
    }

    override fun getItemCount(): Int {
        return mCollectList?.size ?: 0
    }

    inner class ContactListHolder(itemView: View) :
        ViewHolder(itemView) {
        val circleImageView : CircleImageView = itemView.findViewById<View>(R.id.circle_image) as CircleImageView
    }

    init {
        mContext = context
        mCollectList!!.addAll(collectList!!)
    }
}