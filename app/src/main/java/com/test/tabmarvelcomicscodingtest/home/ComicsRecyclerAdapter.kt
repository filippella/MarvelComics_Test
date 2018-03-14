package com.test.tabmarvelcomicscodingtest.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.test.tabmarvelcomicscodingtest.R
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo.ComicVO

/**
 * @author Filippo Engidashet [filippo.eng@gmail.com]
 * @version 1.0.0
 * @since Sunday, 11/03/2018 at 14:38.
 */

class ComicsRecyclerAdapter constructor(private val layoutInflater: LayoutInflater, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<ComicsRecyclerAdapter.ComicItemViewHolder> () {

    private val mComics : MutableList<ComicVO> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicItemViewHolder {
        return ComicItemViewHolder(layoutInflater.inflate(R.layout.item_comic_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return mComics.size
    }

    override fun onBindViewHolder(holder: ComicItemViewHolder, position: Int) {
        holder.bindViewItem(mComics.get(position))
    }

    fun setComics(comics : List<ComicVO>) {
        mComics.clear()
        mComics.addAll(comics)
        notifyDataSetChanged()
    }

    inner class ComicItemViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val mComicAvatarImageView : ImageView = itemView.findViewById(R.id.imageViewThumbnail)
        private val mTitleTextView : TextView = itemView.findViewById(R.id.textViewTitle)
        private val mIdTextView : TextView = itemView.findViewById(R.id.textViewId)
        private val mModifiedDateTextView : TextView = itemView.findViewById(R.id.textViewModifiedDate)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindViewItem(comic: ComicVO) {
            mTitleTextView.text = comic.title
            mIdTextView.text = comic.id
            mModifiedDateTextView.text = comic.modifiedDate
            Glide.with(itemView.context).load(comic.avatarURL).apply(RequestOptions.circleCropTransform()).into(mComicAvatarImageView)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClickListener.onItemClick(position, mComics.get(position))
        }
    }

    interface OnItemClickListener {

        fun onItemClick(position: Int, comic: ComicVO)
    }
}