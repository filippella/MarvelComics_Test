package com.test.tabmarvelcomicscodingtest.home

import android.app.ProgressDialog
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder
import com.test.tabmarvelcomicscodingtest.R
import com.test.tabmarvelcomicscodingtest.dagger2.components.DaggerMainComponent
import com.test.tabmarvelcomicscodingtest.dagger2.modules.MainModule
import com.test.tabmarvelcomicscodingtest.mvp.model.pojo.vo.ComicVO
import com.test.tabmarvelcomicscodingtest.mvp.presenter.MarvelPresenter
import com.test.tabmarvelcomicscodingtest.mvp.view.MarvelView
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MarvelView {

    @BindView(R.id.recyclerView) lateinit var mComicList : RecyclerView

    private var mItemsGap: Int = 0
    private var mAdapter: ComicsRecyclerAdapter? = null
    private var mUnbinder: Unbinder? = null
    private var mProgressDialog: ProgressDialog? = null

    @Inject lateinit var mPresenter : MarvelPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .build()
                .inject(this)

        mUnbinder = ButterKnife.bind(this)

        mItemsGap = resources.getDimensionPixelSize(R.dimen.dimen_item_gap)

        //mPresenter = MarvelPresenter(this, RestApiManager(), DatabaseManager())
        mPresenter.construct()

        mComicList.setHasFixedSize(true)
        mComicList.layoutManager = LinearLayoutManager(this)

        mAdapter = ComicsRecyclerAdapter(layoutInflater, object : ComicsRecyclerAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, comic: ComicVO) {
                Toast.makeText(applicationContext, comic.title, Toast.LENGTH_SHORT).show()
            }
        })
        mComicList.adapter = mAdapter
        mComicList.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
                super.getItemOffsets(outRect, view, parent, state)

                parent?.let {
                    val position = parent.getChildAdapterPosition(view)
                    if (position < 1) {
                        outRect?.top = mItemsGap
                    } else {
                        outRect?.top = 0
                    }
                    outRect?.left = mItemsGap
                    outRect?.right = mItemsGap
                    outRect?.bottom = mItemsGap
                }
            }
        })

        mProgressDialog = ProgressDialog.show(this, "Getting Marvel Comics", "Loading api...")

        mPresenter.getComics(0, 100)
    }

    override fun onLoadComics(comicList: List<ComicVO>) {
        mAdapter?.setComics(comicList)
        mProgressDialog?.dismiss()
    }

    override fun onError(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.destruct()
        mUnbinder?.unbind()
    }
}
