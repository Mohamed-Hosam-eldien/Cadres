package com.example.cadres.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadres.model.Machine
import com.example.cadres.adapter.MachineAdapter
import com.example.cadres.R
import com.example.cadres.databinding.FragmentFirstBinding
import com.example.cadres.utils.Utils
import com.example.cadres.interfaces.OnClickListener

class FirstFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var machineAdapter: MachineAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        binding.info.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_PDFFragment, Bundle().apply {
                putString("pdfName", "ABOUT_CADRES.pdf")
            })
        }
    }


    private fun initView() {
        machineAdapter = MachineAdapter(requireContext(), listOfMachine(), this)
        binding.machineRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = machineAdapter

        }
    }

    private fun listOfMachine(): ArrayList<Machine> {
        val machineList = ArrayList<Machine>()

        machineList.add(
            Machine(
                "HYDRAULIC MECHANICAL JAR",
                "HMJ",
                R.drawable.hydraulic_mechanical_drilling_jar,
                listOf("4.75\"","6.5\"","8\"")
            )
        )


        machineList.add(
            Machine(
                "DOUBLE ACTING HYDRAULIC MECHANICAL DRILLING JAR",
                "DAHMJ",
                R.drawable.double_action_hydrolic_mechanical_drilling,
                listOf("4.75\"","6.5\"","8\"")

            )
        )

        machineList.add(
            Machine(
                "DOUBLE ACTING HYDRAULIC JAR",
                "HYDRA JAR",
                R.drawable.double_action_hydraulic_jar,
                listOf("4.75\"","6.5\"","8\"")

            )
        )

        machineList.add(
            Machine("SHOCK TOOL",
            "SHOOK TOOL",
            R.drawable.shock_tool,
            listOf("8\"","9.5\"", "11\"", "12\"")
        )
        )

        machineList.add(
            Machine("PBL SUB",
            "PBL",
            R.drawable.pnl_sub,listOf("4.75\"","6.75\"","8.25\""))
        )

        machineList.add(
            Machine("TUBULARS",
            "TUBULARS",
            R.drawable.tublars,listOf("Drill Pipes","Heavy Weight Drill Pipes"))
        )

        return machineList
    }

    override fun onClick(machine: Machine) {
        Utils.currentMachine = machine
        findNavController().navigate(R.id.action_firstFragment_to_sizeDetailsFragment)
    }

}