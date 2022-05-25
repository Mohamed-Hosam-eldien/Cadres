package com.example.cadres.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.cadres.R
import com.example.cadres.databinding.FragmentCalcBinding
import com.example.cadres.utils.Utils

class CalcFragment : Fragment() {

    private lateinit var binding: FragmentCalcBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calc, container, false)
        binding = FragmentCalcBinding.bind(view)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtSize.text = requireArguments().getString("size")
        binding.txtName.text = Utils.currentMachine.nickName

        binding.btnCalc.setOnClickListener {
            calcValues()
        }

        setValues()

    }

    @SuppressLint("SetTextI18n")
    private fun calcValues() {

        val weightAboveJar = binding.edtWeightAboveJar.text.toString().toInt()
        val dragForce = binding.edtDragForce.text.toString().toInt()
        val bitPressureDrop = binding.edtBitPressureDrop.text.toString().toInt()
        val pumpOpenForce = binding.edtPumpOpenForce.text.toString().toInt()

        binding.txtJarringUp.text = (weightAboveJar +
                binding.txtUpJarLatchSetting.text.toString().toInt() +
                dragForce -
                pumpOpenForce).toString()

        binding.txtJarringDown.text = (weightAboveJar -
                binding.txtDownJarLatchSetting.text.toString().toInt() -
                dragForce -
                pumpOpenForce).toString()

        binding.txtMinimumOverpull.text = (binding.txtUpJarLatchSetting.text.toString().toInt() - pumpOpenForce).toString()

        binding.txtMaximumOverpull.text = (binding.txtMaxLoadDuring.text.toString().toInt() - pumpOpenForce).toString()

        Toast.makeText(requireContext(), "Done", Toast.LENGTH_SHORT).show()

    }

    private fun setValues() {
        val list = Utils.calcList

        binding.txtMaxLoadDuring.text = list[0]
        binding.txtUpJarLatchSetting.text = list[1]
        binding.txtDownJarLatchSetting.text = list[2]
        binding.txtPumpOpenArea.text = list[3]
        binding.txtJarringUp.text = list[4]
        binding.txtJarringDown.text = list[5]
        binding.txtMinimumOverpull.text = list[6]
        binding.txtMaximumOverpull.text = list[7]
    }


}