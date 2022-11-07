package com.lidorttol.pruebamercadona.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lidorttol.pruebamercadona.R
import com.lidorttol.pruebamercadona.data.bo.FilmBo
import com.lidorttol.pruebamercadona.data.lifecycle.EventAsyncResultObserver
import com.lidorttol.pruebamercadona.databinding.FragmentListBinding
import com.lidorttol.pruebamercadona.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var binding: FragmentListBinding? = null
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.bind(inflater.inflate(R.layout.fragment_list, container, false))
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        mainViewModel.requestGetFilmsData()
    }

    private fun setupObservers() {
        mainViewModel.getFilmsData().observe(
            viewLifecycleOwner,
            object : EventAsyncResultObserver<List<FilmBo>>() {
                override fun onSuccess(response: List<FilmBo>?) {
                    binding?.listContainerLoading?.visibility = View.GONE
                    setupList(response)
                }
            })
    }

    private fun setupList(response: List<FilmBo>?) {

    }

}