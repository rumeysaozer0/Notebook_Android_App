package com.rumeysaozer.notdefteri

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rumeysaozer.notdefteri.databinding.FragmentGirisBinding


class GirisFragment : Fragment(), INotClick {
    private var _binding: FragmentGirisBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NotViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     _binding = FragmentGirisBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          binding.rv.setHasFixedSize(true)
        binding.rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

            context?.let {
                val notAdapter = NotAdapter(requireContext(),this,)
                binding.rv.adapter = notAdapter
                viewModel = ViewModelProviders.of(this).get(NotViewModel::class.java)
                viewModel.notlar.observe(viewLifecycleOwner, Observer{ list ->
                    list?.let{
                        notAdapter.updateList(it)
                    }

                })
            }



        binding.add.setOnClickListener{
            val action = GirisFragmentDirections.actionGirisFragmentToNotEkleFragment2("","",1,1)
            findNavController().navigate(action)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onNotClick(not: Notlar) {

        val action = GirisFragmentDirections.actionGirisFragmentToNotEkleFragment2(not.title,not.not, not.id!!,2)
        findNavController().navigate(action)
    }


}