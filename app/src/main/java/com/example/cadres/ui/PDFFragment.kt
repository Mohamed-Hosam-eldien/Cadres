package com.example.cadres.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cadres.R
import com.example.cadres.databinding.FragmentPDFBinding

class PDFFragment : Fragment() {

    lateinit var binding : FragmentPDFBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_p_d_f, container, false)
        binding = FragmentPDFBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pdfView.fromAsset(requireArguments().getString("pdfName")).load()
    }

}