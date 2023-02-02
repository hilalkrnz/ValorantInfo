package com.info.valorantinfo.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.info.valorantinfo.R
import com.info.valorantinfo.databinding.FragmentDetailBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel by viewModels<DetailViewModel>()

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWeaponById(args.weaponArgument.id!!)

        onClickBack()

        observeDetailState()

        initTextSizeViews()
    }

    private fun onClickBack() {
        binding.toolbarBack.setNavigationIcon(R.drawable.ic_baseline_back_24)
        binding.toolbarBack.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }


    private fun initTextSizeViews() {
        binding.valorantComponent.setNameTextSize(NAME_TEXT_SIZE)
        binding.valorantComponent.setCategoryTextSize(CATEGORY_TEXT_SIZE)
    }

    private fun observeDetailState() {
        viewModel.valorantDetailUiState.observe(viewLifecycleOwner) {
            when (it) {
                is DetailUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_LONG)
                        .show()
                    binding.progressBar.isVisible = false
                }
                DetailUiState.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is DetailUiState.Success -> {
                    binding.progressBar.isVisible = false
                    handleSuccessDetailState(it.data)

                }
            }
        }
    }

    private fun handleSuccessDetailState(data: WeaponUiData?) {
        if (data != null) {
            binding.valorantComponent.setWeaponData(data)
            binding.fireRate.text = data.weaponStats?.fireRate.toString()
            binding.magazine.text = data.weaponStats?.magazineSize.toString()
            binding.runSpeed.text = data.weaponStats?.runSpeedMultiplier.toString()
        }
    }

    companion object {
        private const val NAME_TEXT_SIZE = 20f
        private const val CATEGORY_TEXT_SIZE = 16f

    }

}