package com.example.cadres.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadres.interfaces.PdfInterface
import com.example.cadres.R
import com.example.cadres.adapter.TubularsAdapter
import com.example.cadres.databinding.FragmentTubularsBinding

class TubularsFragment : Fragment(), PdfInterface {

    lateinit var binding: FragmentTubularsBinding
    var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (requireArguments().getString("isDrill") == "yes") {
            list.add("1.9 Iin Spec")
            list.add("2 7-8 HT PAC  DP spec")
            list.add("3.5 in DP spec")
            list.add("4 inch DP Specification Sheet S-135")
            list.add("4 inch DP Specification Sheet TSS-105")
            list.add("5 DP 19.5 G105")
            list.add("5IN DP TSS 105 19.5 spec")
            list.add("5 DP 25.6 G105")
        } else {
            list.add("3.5 in HWDP Spec")
            list.add("4 in HWDP Spec")
            list.add("SS HWDP Data Sheet - 5inch")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tubulars, container, false)
        binding = FragmentTubularsBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        binding.specificRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = TubularsAdapter(this@TubularsFragment, list)

        }
    }

    override fun gotoPdfViewer(pdfName: String) {
        findNavController().navigate(
            R.id.action_tubularsFragment_to_PDFFragment,
            Bundle().apply {
                putString("pdfName", "$pdfName.pdf")
            })
    }


}