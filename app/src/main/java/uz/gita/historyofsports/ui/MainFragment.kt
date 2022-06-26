package uz.gita.historyofsports.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.historyofsports.R
import uz.gita.historyofsports.databinding.FragmentMainBinding
import uz.gita.historyofsports.model.Repository
import uz.gita.historyofsports.presentation.SportCategoriesAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val categoryAdapter by lazy { SportCategoriesAdapter() }
    private val repository = Repository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sportsRv.adapter = categoryAdapter
        categoryAdapter.submitList(repository.getSportList())

        categoryAdapter.setMoreButtonListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToPageFragment(it.title))
        }

        binding.moreBtn.setOnClickListener {
            showPopUp(it as Button)
        }

        if (repository.getIsDayMode()) {
            AppCompatDelegate
                .setDefaultNightMode(
                    AppCompatDelegate
                        .MODE_NIGHT_NO
                )
        } else {
            AppCompatDelegate
                .setDefaultNightMode(
                    AppCompatDelegate
                        .MODE_NIGHT_YES
                )
        }

    }

    private fun showPopUp(button: Button) {
        val popup = PopupMenu(requireContext(), button)
        popup.inflate(R.menu.pop_up_menu)
        popup.show()
        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.exit -> {
                    requireActivity().finish()
                    return@setOnMenuItemClickListener true
                }
                R.id.mode -> {
                    if (repository.getIsDayMode()){
                        AppCompatDelegate
                            .setDefaultNightMode(
                                AppCompatDelegate
                                    .MODE_NIGHT_YES
                            )
                        repository.setMode(false)
                    } else {
                        AppCompatDelegate
                            .setDefaultNightMode(
                                AppCompatDelegate
                                    .MODE_NIGHT_NO
                            )
                        repository.setMode(true)
                    }

                    return@setOnMenuItemClickListener true
                }
            }

            return@setOnMenuItemClickListener false
        }
    }

}