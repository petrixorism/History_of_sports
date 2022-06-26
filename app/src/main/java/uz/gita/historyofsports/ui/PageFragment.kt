package uz.gita.historyofsports.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.historyofsports.R
import uz.gita.historyofsports.databinding.FragmentPageBinding
import uz.gita.historyofsports.model.Repository

class PageFragment : Fragment(R.layout.fragment_page) {

    private val binding by viewBinding(FragmentPageBinding::bind)
    private val args by navArgs<PageFragmentArgs>()
    private val repository = Repository()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val data = repository.getSportData(args.sportName)
        binding.apply {
            titleTv.text = args.sportName
            sportIv.setImageResource(data.image)
            infooTv.setText(data.info)
        }

        binding.backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }


    }

}