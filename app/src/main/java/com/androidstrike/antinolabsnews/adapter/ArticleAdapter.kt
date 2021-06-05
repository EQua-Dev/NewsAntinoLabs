package com.androidstrike.antinolabsnews.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.androidstrike.antinolabsnews.R
import com.androidstrike.antinolabsnews.`interface`.INewsClickListener
import com.androidstrike.antinolabsnews.model.Article
import com.androidstrike.antinolabsnews.ui.NewsDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter(
    public val context: Context,
    private var articleList: ArrayList<Article>
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val placeHolderImage = "https://image.shutterstock.com/image-vector/newspaper-icon-vector-news-paper-260nw-1890929389.jpg"
    private lateinit var viewGroupContext: Context
    lateinit var iNewsClickListener: INewsClickListener

    fun setClick(iNewsClickListener: INewsClickListener){
        this.iNewsClickListener = iNewsClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ArticleViewHolder {
        viewGroupContext = viewGroup.context
        val itemView: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_article, viewGroup, false)
        return ArticleViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(articleViewHolder: ArticleViewHolder, itemIndex: Int) {
        val article: Article = articleList.get(itemIndex)
        setPropertiesForArticleViewHolder(articleViewHolder, article)
        articleViewHolder.cardView.setOnClickListener {
            //do something
            val i = Intent(context, NewsDetail::class.java)
            i.putExtra("newsUrl", article.url)
            context.startActivity(i)
//            var articleUrl = article.url
//            onClick(it)

        }


    }

    private fun setPropertiesForArticleViewHolder(articleViewHolder: ArticleViewHolder, article: Article) {
        checkForUrlToImage(article, articleViewHolder)
        articleViewHolder.title.text = article?.title
        articleViewHolder.description.text = article?.description
    }

    private fun checkForUrlToImage(article: Article, articleViewHolder: ArticleViewHolder) {
        if (article.urlToImage == null || article.urlToImage.isEmpty()) {
            Picasso.get()
                .load(placeHolderImage)
                .centerCrop()
                .fit()
                .into(articleViewHolder.urlToImage)
        } else {
            Picasso.get()
                .load(article.urlToImage)
                .centerCrop()
                .fit()
                .into(articleViewHolder.urlToImage)
        }
    }

    fun setArticles(articles: ArrayList<Article>) {
        articleList = articles
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val cardView: CardView by lazy { view.card_view }
        val urlToImage: ImageView by lazy { view.article_urlToImage }
        val title: TextView by lazy { view.article_title }
        val description: TextView by lazy { view.article_description }
    }

//    override fun onClick(v: View?) {
//        iNewsClickListener.onItemClickListener(v!!, articleList[])
//    }
}