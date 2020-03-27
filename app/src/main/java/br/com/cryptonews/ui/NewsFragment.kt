package br.com.cryptonews.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import br.com.cryptonews.R
import br.com.cryptonews.databinding.FragmentNewsBinding
import br.com.cryptonews.model.ArticleObject
import br.com.cryptonews.ui.adapter.ListNewsAdapter
import br.com.cryptonews.util.DateNews
import br.com.cryptonews.util.QueryType
import br.com.cryptonews.util.onShowToast
import br.com.cryptonews.viewmodel.NewsViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private val viewModel by viewModel<NewsViewModel>()
    private var listNews: List<ArticleObject>? = null

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    private val adapterNews by lazy {
        ListNewsAdapter(ListNewsAdapter.OnClickListener {
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
            onShowData()

        drawerLayout = requireActivity().findViewById(R.id.drawer_layout)
        navigationView = requireActivity().findViewById(R.id.nav_view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView?.apply {
            adapter = adapterNews
        }
        setupNavDrawer()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_itens, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onItemSelected(item)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        onItemSelected(item)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun onItemSelected(item: MenuItem) {
        val title = when (item.itemId) {
            R.id.bitcoin -> QueryType.BITCOIN.value
            R.id.bitcoinCash -> QueryType.BITCOIN_CASH.value
            R.id.ethereum -> QueryType.ETHEREUM.value
            R.id.litecoin -> QueryType.LITECOIN.value
            R.id.ripple -> QueryType.RIPPLE.value
            else -> QueryType.SHOW_ALL.value
        }
        onShowData(title)
    }

    private fun onShowData(title: String = QueryType.SHOW_ALL.value) {
        viewModel.onShowProgressBar(true)
        viewModel.onUpdateFilter(title, dateNews.from(), dateNews.to())
    }

    private fun setupNavDrawer() {
        val toggle = ActionBarDrawerToggle(
            this.requireActivity(),
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }
}
