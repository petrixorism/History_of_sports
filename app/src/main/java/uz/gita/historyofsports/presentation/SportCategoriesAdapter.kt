package uz.gita.historyofsports.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.historyofsports.R
import uz.gita.historyofsports.databinding.ItemCategoryBinding
import uz.gita.historyofsports.model.Sport

class SportCategoriesAdapter : ListAdapter<Sport, SportCategoriesAdapter.ViewHolder>(DiffItem) {

    private var moreListener: ((Sport) -> Unit)? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding by viewBinding(ItemCategoryBinding::bind)

        @SuppressLint("SetTextI18n")
        fun bind() {
            getItem(absoluteAdapterPosition).apply {
                binding.titleTv.text = this.title
                binding.categoryIv.setImageResource(this.image)
                val counter = this.info.toString().split(" ").size / 120
                binding.timeToReadTv.text = counter.toString()
            }
        }

        init {
            binding.root.setOnClickListener {
                moreListener?.invoke(
                    getItem(absoluteAdapterPosition)
                )
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


    object DiffItem : DiffUtil.ItemCallback<Sport>() {
        override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: Sport,
            newItem: Sport
        ): Boolean {
            return oldItem == newItem
        }

    }

    fun setMoreButtonListener(block: (Sport) -> Unit) {
        moreListener = block
    }
}

