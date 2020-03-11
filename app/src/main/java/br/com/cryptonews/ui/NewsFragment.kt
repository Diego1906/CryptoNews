package br.com.cryptonews.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.cryptonews.R
import br.com.cryptonews.databinding.FragmentNewsBinding
import br.com.cryptonews.di.AppGlobal
import br.com.cryptonews.remote.RetrofitConfig
import br.com.cryptonews.repository.Repository
import br.com.cryptonews.ui.adapter.ListNewsAdapter
import br.com.cryptonews.util.QueryType
import br.com.cryptonews.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class NewsFragment : Fragment() {

    private val viewModel by viewModel<NewsViewModel> {
        parametersOf(Repository(RetrofitConfig()), AppGlobal())
    }
    private val adapterNews by lazy { ListNewsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentNewsBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(viewLifecycleOwner)

        setHasOptionsMenu(true)

        viewModel.news.observe(viewLifecycleOwner, Observer {
            it?.articles?.let {
                adapterNews.submitList(it)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView?.apply {
            adapter = adapterNews
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_items, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val title = when (item.itemId) {
            R.id.bitcoin -> QueryType.BITCOIN.value
            R.id.bitcoinCash -> QueryType.BITCOIN_CASH.value
            R.id.ethereum -> QueryType.ETHEREUM.value
            R.id.litecoin -> QueryType.LITECOIN.value
            R.id.ripple -> QueryType.RIPPLE.value
            else -> QueryType.SHOW_ALL.value
        }

        viewModel.updateFilter(title, "2020-03-01", "2020-03-10")

        return true
    }
}
