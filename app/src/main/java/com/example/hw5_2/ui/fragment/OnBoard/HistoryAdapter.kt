package com.example.hw5_2.ui.fragment.OnBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw5_2.data.local.entity.HistoryEntity
import com.example.hw5_2.databinding.ItemHistoryBinding

class HistoryAdapter : ListAdapter<HistoryEntity, HistoryAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(historyEntity: HistoryEntity) = with(binding) {
            historyEntity.apply {
                tvFname.text = firstName
                tvSname.text = secondName
                tvPercent.text = percentage
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<HistoryEntity>() {
        override fun areItemsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity): Boolean {
            return oldItem.firstName == newItem.firstName
                    && oldItem.secondName == newItem.secondName
                    && oldItem.percentage == newItem.percentage
        }
    }
}