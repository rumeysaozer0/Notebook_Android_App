package com.rumeysaozer.notdefteri

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.rumeysaozer.notdefteri.databinding.FragmentNotEkleBinding
import java.text.SimpleDateFormat
import java.util.*


class NotEkleFragment : Fragment() {
    private var _binding: FragmentNotEkleBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: NotViewModel
    private var notId = -1
    private var title = ""
    private var not1 = ""
    private var type = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotEkleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let{

            title = NotEkleFragmentArgs.fromBundle(it).title
            not1 = NotEkleFragmentArgs.fromBundle(it).not

            type = NotEkleFragmentArgs.fromBundle(it).type
        }

        viewModel = ViewModelProviders.of(this).get(NotViewModel::class.java)
        binding.title.setText(title)
        binding.description.setText(not1)
        binding.tick.setOnClickListener {
            val title = binding.title.text.toString()
            val not = binding.description.text.toString()
            if (type == 2) {
                if (title.isNotEmpty() && not.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val date: String = sdf.format(Date())
                    val updateNot = Notlar(title, not, date)
                    updateNot.id = notId
                    viewModel.updateNot(updateNot)
                    Toast.makeText(requireContext(), "Notunuz başarıyla güncellendi",Toast.LENGTH_LONG ).show()

                }
            }else{
                if (title.isNotEmpty() && not.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val date: String = sdf.format(Date())
                    viewModel.insertNot(Notlar(title, not, date))
                    Toast.makeText(requireContext(), "Notunuz başarıyla eklendi",Toast.LENGTH_LONG ).show()
                }
            }
            val action = NotEkleFragmentDirections.actionNotEkleFragment2ToGirisFragment()
            findNavController().navigate(action)
        }
        binding.back.setOnClickListener {
            val action = NotEkleFragmentDirections.actionNotEkleFragment2ToGirisFragment()
            findNavController().navigate(action)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}