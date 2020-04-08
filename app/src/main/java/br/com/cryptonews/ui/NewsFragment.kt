package br.com.cryptonews.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.cryptonews.R
import br.com.cryptonews.databinding.FragmentNewsBinding
import br.com.cryptonews.model.ArticleObject
import br.com.cryptonews.ui.adapter.ListNewsAdapter
import br.com.cryptonews.util.DateNews
import br.com.cryptonews.util.QueryType
import br.com.cryptonews.util.onIsNetworkConnected
import br.com.cryptonews.util.onShowToast
import br.com.cryptonews.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment() {

    private val viewModel by viewModel<NewsViewModel>()
    private var listNews: List<ArticleObject>? = null
    private var filterTitle: String = QueryType.SHOW_ALL.value

    private val adapterNews by lazy {
        ListNewsAdapter(ListNewsAdapter.OnClickListener {
            viewModel.onShowToast(null)
            this.findNavController().navigate(
                NewsFragmentDirections.actionNewsFragmentToDetailFragment(it)
            )
        })
    }

    private val dateNews by lazy {
        DateNews(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNewsBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setHasOptionsMenu(true)

        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            news?.articles?.let {
                listNews = it
                adapterNews.submitList(it)
            }
        })

        viewModel.toast.observe(viewLifecycleOwner, Observer {
            it?.onShowToast(requireContext())
        })

        if (listNews.isNullOrEmpty())
            onShowData(filterTitle)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView?.apply {
            adapter = adapterNews
        }
        swipeRefresh.setOnRefreshListener {
            onShowData(filterTitle)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_itens, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        filterTitle = when (item.itemId) {
            R.id.bitcoin -> QueryType.BITCOIN.value
            R.id.bitcoinCash -> QueryType.BITCOIN_CASH.value
            R.id.ethereum -> QueryType.ETHEREUM.value
            R.id.litecoin -> QueryType.LITECOIN.value
            R.id.ripple -> QueryType.RIPPLE.value
            else -> QueryType.SHOW_ALL.value
        }
        onShowData(filterTitle)
        return true
    }

    private fun onShowData(filterTitle: String) {
        if (!onIsNetworkConnected()) {
            viewModel.onShowToast(getString(R.string.no_connection_internet))
            onHideRefresh()
            return
        }
        viewModel.onShowProgressBar(true)
        viewModel.onShowData(filterTitle, dateNews.from(), dateNews.to())
        onHideRefresh()
    }

    private fun onHideRefresh() {
        swipeRefresh?.let {
            swipeRefresh.isRefreshing = false
        }
    }
}
