package com.info.valorantinfo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.info.valorantinfo.R
import com.info.valorantinfo.databinding.FragmentHomeBinding
import com.info.valorantinfo.domain.model.WeaponUiData
import com.info.valorantinfo.utility.observeTextChanges
import com.info.valorantinfo.utility.okWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel by viewModels<HomeViewModel>()

    private val adapter = WeaponRecyclerViewAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater).apply {
            weaponListRecyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickWeaponListAdapter()

        //observeSearchTextChanges()

        observeUiState()
    }

    private fun onClickWeaponListAdapter() {
        adapter.setOnItemClickListener {
            val weaponUiData = adapter.getItem(it)
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(weaponUiData)
            )
        }
        binding.weaponListRecyclerView.adapter = adapter
    }


    private fun observeUiState() {
        viewModel.valorantHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), getString(it.message), Toast.LENGTH_LONG)
                        .show()
                    binding.progressBar.isVisible = false
                }
                HomeUiState.Loading -> {
                    //Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
                    binding.progressBar.isVisible = true
                }
                is HomeUiState.Success -> {
                    binding.progressBar.isVisible = false
                    handleSuccessUiState(it.data)
                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<WeaponUiData>) {
        adapter.updateList(data)
    }

    private fun observeSearchTextChanges() {
        binding.searchEditText.observeTextChanges()
            .filter { it okWith MINIMUM_SEARCH_LENGTH }
            .debounce(SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS)
            .distinctUntilChanged()
            .onEach {
                viewModel.getWeapons()
            }.launchIn(lifecycleScope)
    }


    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 1
        private const val SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS = 300L
    }

}