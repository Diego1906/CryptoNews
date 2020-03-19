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
import br.com.cryptonews.model.ArticleObject
import br.com.cryptonews.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {

    private var article: ArticleObject? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewModel = DetailViewModel(
            DetailFragmentArgs.fromBundle(arguments!!).article,
            requireNotNull(activity).application
        )

        val binding = FragmentDetailBinding.inflate(inflater)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.article.observe(viewLifecycleOwner, Observer {
            article = it
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLearnMore.setOnClickListener {
            article?.let { obj ->
                Intent(Intent.ACTION_VIEW, obj.url?.toUri()).run {
                    activity?.packageManager?.let { pm ->
                        this.resolveActivity(pm)?.let {
                            startActivity(this)
                        }
                    }
                }
            }
        }
    }
}
