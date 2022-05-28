package com.example.cadres.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cadres.R
import com.example.cadres.adapter.SizeDetailsAdapter
import com.example.cadres.data.*
import com.example.cadres.databinding.FragmentSizeDetailsBinding
import com.example.cadres.interfaces.ISpecification
import com.example.cadres.utils.Utils

class SizeDetailsFragment : Fragment(), ISpecification {

    private lateinit var binding: FragmentSizeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSizeDetailsBinding.bind(
            inflater.inflate(
                R.layout.fragment_size_details,
                container,
                false
            )
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtToolsName.text = Utils.currentMachine.machineName
        binding.img.setImageResource(Utils.currentMachine.machineImage)
        binding.recycler.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            //val lambda = { description: String -> getDescription(description) }

            val adapter = SizeDetailsAdapter(this@SizeDetailsFragment, Utils.currentMachine.sizes)

            binding.recycler.adapter = adapter
        }

    }

    override fun navToSpecScreen(machineName: String, sizeNum: Int, sizeName: String) {
        var series = ""

        when (Utils.currentMachine.nickName) {
            "HMJ" -> {
                when (sizeNum) {
                    0 -> {
                        Utils.specificationList = HMJ.listItemsOne
                        series = "380"
                    }
                    1 -> {
                        Utils.specificationList = HMJ.listItemsTwo
                        series = "474"
                    }
                    else -> {
                        Utils.specificationList = HMJ.listItemsThree
                        series = "336-20"
                    }

                }
                Utils.specificationHeaders = HMJ.listHeader
            }

            "DAHMJ" -> {
                when (sizeNum) {
                    0 -> {
                        Utils.specificationList = DAHMJ.listItemsOne
                        series = "431"
                    }
                    1 -> {
                        Utils.specificationList = DAHMJ.listItemsTwo
                        series = "428"
                    }
                    else -> {
                        Utils.specificationList = DAHMJ.listItemsThree
                        series = "411"
                    }
                }
                Utils.specificationHeaders = DAHMJ.listHeader
            }

            "HYDRA JAR" -> {
                when (sizeNum) {
                    0 -> {
                        Utils.specificationList = HydraJar.listItemsOne
                        series = "H16790"
                    }
                    1 -> {
                        Utils.specificationList = HydraJar.listItemsTwo
                        series = "H16293"
                    }
                    else -> {
                        Utils.specificationList = HydraJar.listItemsThree
                        series = "H16293"
                    }
                }
                Utils.specificationHeaders = HydraJar.listHeader
            }

            "SHOOK TOOL" -> {
                when (sizeNum) {
                    0 -> {
                        Utils.specificationList = Shook.listItemsOne
                        series = "160"
                    }
                    1 -> {
                        Utils.specificationList = Shook.listItemsTwo
                        series = "151"
                    }
                    2 -> {
                        Utils.specificationList = Shook.listItemsThree
                        series = "157"
                    }
                    else -> {
                        Utils.specificationList = Shook.listItemsFour
                        series = "143"
                    }
                }
                Utils.specificationHeaders = Shook.listHeader
            }

            "PBL" -> {
                when (sizeNum) {
                    0 -> {
                        Utils.specificationList = PBL.listItemsOne
                        series = "-"
                    }
                    1 -> {
                        Utils.specificationList = PBL.listItemsTwo
                        series = "-"
                    }
                    else -> {
                        Utils.specificationList = PBL.listItemsThree
                        series = "-"
                    }
                }
                Utils.specificationHeaders = PBL.listHeader

                   // Shook.listHeader
            }

            else -> {

            }

        }

        if (Utils.currentMachine.nickName != "TUBULARS") {
            findNavController().navigate(
                R.id.action_sizeDetailsFragment_to_specificationFragment,
                Bundle().apply {
                    putString("size", sizeName)
                    putString("series", series)
                })
        }

    }

    override fun navToPdfScreen(machineName: String, sizeNum: Int) {
        var pdf = ""

        when (Utils.currentMachine.nickName) {

            "HMJ" -> {
                pdf = when (sizeNum) {
                    0 -> {
                        "HMJ Operation Manual"
                    }
                    1 -> {
                        "HMJ Operation Manual"
                    }
                    else -> {
                        "HMJ Operation Manual"
                    }

                }

            }

            "DAHMJ" -> {
                pdf = when (sizeNum) {
                    0 -> {
                        "DAHMJ Operation Manual"
                    }
                    1 -> {
                        "DAHMJ Operation Manual"
                    }
                    else -> {
                        "DAHMJ Operation Manual"
                    }
                }
            }

            "HYDRA JAR" -> {
                pdf = when (sizeNum) {
                    0 -> {
                        "HYDRA JAR OPERATING MANUAL"
                    }
                    1 -> {
                        "HYDRA JAR OPERATING MANUAL"
                    }
                    else -> {
                        "HYDRA JAR OPERATING MANUAL"
                    }
                }
            }

            "SHOOK TOOL" -> {
                pdf = when (sizeNum) {
                    0 -> {
                        "Shock Tool Operation"
                    }
                    1 -> {
                        "Shock Tool Operation"
                    }
                    2 -> {
                        "Shock Tool Operation"
                    }
                    else -> {
                        "Shock Tool Operation"
                    }
                }
            }

            "PBL" -> {

                pdf = when (sizeNum) {
                    0 -> {
                        "4.75 PBL Operation"
                    }
                    1 -> {
                        "6.75 PBL Operation"
                    }
                    else -> {
                        "8.25 PBL Operation"
                    }
                }
            }

        }

        findNavController().navigate(
            R.id.action_sizeDetailsFragment_to_PDFFragment,
            Bundle().apply {
                putString("pdfName", "$pdf.pdf")
            })
    }

    override fun navToDrill(text: String) {
        findNavController().navigate(
            R.id.action_sizeDetailsFragment_to_tubularsFragment,
            Bundle().apply {
                putString("isDrill", text)
            })
    }

    override fun navToCalc(sizeName: String, position: Int) {

        when (Utils.currentMachine.nickName) {

            "HMJ" -> {
                when (position) {
                    0 -> {
                        Utils.calcList = HMJ.listCalcOne
                    }
                    1 -> {
                        Utils.calcList = HMJ.listCalcTwo
                    }
                    else -> {
                        Utils.calcList = HMJ.listCalcThree
                    }

                }

            }

            "DAHMJ" -> {
                when (position) {
                    0 -> {
                        Utils.calcList = DAHMJ.listCalcOne
                    }
                    1 -> {
                        Utils.calcList = DAHMJ.listCalcTwo
                    }
                    else -> {
                        Utils.calcList = DAHMJ.listCalcThree
                    }

                }
            }

            "HYDRA JAR" -> {
                when (position) {
                    0 -> {
                        Utils.calcList = HydraJar.listCalcOne
                    }
                    1 -> {
                        Utils.calcList = HydraJar.listCalcTwo
                    }
                    else -> {
                        Utils.calcList = HydraJar.listCalcThree
                    }

                }
            }

        }

        findNavController().navigate(
            R.id.action_sizeDetailsFragment_to_calcFragment,
            Bundle().apply {
                putString("size", sizeName)
            })

    }

    override fun navToPBLInstructionPdf(position: Int) {
        var pdf = ""
        when (position) {
            0 -> {
                pdf = "4.75 PBL Troubleshooting"
            }
            1 -> {
                pdf = "6.75 PBL troubleshooting"
            }
            2 -> {
                pdf = "8 PBL Troubleshooting"
            }
        }

        findNavController().navigate(
            R.id.action_sizeDetailsFragment_to_PDFFragment,
            Bundle().apply {
                putString("pdfName", "$pdf.pdf")
            })
    }


}