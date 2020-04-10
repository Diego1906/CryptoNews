package br.com.cryptonews.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.com.cryptonews.databinding.FragmentDetailBinding
import br.com.cryptonews.domain.ArticleModel
import br.com.cryptonews.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private lateinit var article: ArticleModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = DetailViewModel(
            DetailFragmentArgs.fromBundle(requireArguments()).article
        )

        val binding = FragmentDetailBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.article.observe(viewLifecycleOwner, Observer {
            it?.let {
                article = it
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLearnMore.setOnClickListener {
            Intent(Intent.ACTION_VIEW, article.url?.toUri()).run {
                activity?.packageManager?.let { pm ->
                    resolveActivity(pm)?.let {
                        startActivity(this)
                    }
                }
            }
        }
    }
}
