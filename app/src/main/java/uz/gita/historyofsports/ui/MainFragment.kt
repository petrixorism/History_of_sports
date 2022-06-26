package uz.gita.historyofsports.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
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

        }

    }

}