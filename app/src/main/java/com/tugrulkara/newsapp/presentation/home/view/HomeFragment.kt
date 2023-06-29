package com.tugrulkara.newsapp.presentation.home.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tugrulkara.newsapp.R
import com.tugrulkara.newsapp.data.remote.dto.Article
import com.tugrulkara.newsapp.databinding.FragmentHomeBinding
import com.tugrulkara.newsapp.presentation.home.HomeViewModel
import com.tugrulkara.newsapp.util.Resource
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment:Fragment(R.layout.fragment_home), HomeRecyclerAdapter.Listener {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val viewModel by viewModel<HomeViewModel>()

    private var adapter = HomeRecyclerAdapter(listOf(),this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewBinding=FragmentHomeBinding.bind(view)
        _binding=viewBinding

        getDataFromApi()

    }

    private fun getDataFromApi(){

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewModel.state.collect{

                    viewModel.state.collect { requestState ->
                        requestState?.let { it ->
                            when (it) {
                                is Resource.Loading -> {
                                    binding.progressBar.isVisible = true
                                }
                                is Resource.Success -> {
                                    binding.progressBar.isVisible = false
                                    it.data?.let { initRecycler(it) }
                                }
                                is Resource.Error -> {
                                    binding.progressBar.isVisible = false
                                }
                            }
                        }


                    }
                }
            }
        }

    }

    private fun initRecycler(list : List<Article>){
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        adapter = HomeRecyclerAdapter(list,this@HomeFragment)
        binding.recyclerView.adapter = adapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(article: Article) {
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(article.url)
        startActivity(openURL)
    }

}