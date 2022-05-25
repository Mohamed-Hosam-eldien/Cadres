package com.example.cadres.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadres.R
import com.example.cadres.adapter.SpecificationAdapter
import com.example.cadres.databinding.FragmentSpecificationfragmentBinding
import com.example.cadres.utils.Utils

class SpecificationFragment : Fragment() {

    lateinit var binding: FragmentSpecificationfragmentBinding
    lateinit var specificationAdapter: SpecificationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_specificationfragment, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSize.text = requireArguments().get("size").toString()
        binding.txtSeries.text = requireArguments().get("series").toString()

        intiView()
    }

    private fun intiView() {

        binding.txtToolName.text = Utils.currentMachine.nickName
        binding.specificName.text = Utils.currentMachine.machineName

        specificationAdapter = SpecificationAdapter(Utils.specificationHeaders, Utils.specificationList)
        binding.specificRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = specificationAdapter
        }
    }

}