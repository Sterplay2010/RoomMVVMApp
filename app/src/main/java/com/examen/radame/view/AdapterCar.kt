package com.examen.radame.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.examen.radame.databinding.ActivityListBinding
import com.examen.radame.databinding.ContentCardBinding
import com.examen.radame.room.CarEntity

class AdapterCar(private val eventos: AdapterCar.Eventos,context: Context): ListAdapter<CarEntity, AdapterCar.ViewHolder>(DiffutilCallback) {

    val ctx = context

    interface Eventos{
        fun onIntemClick(element: CarEntity,position: Int)
        fun onStatusChange(element: CarEntity,position: Int,status:Boolean)
    }

    inner class ViewHolder(private val binding: ContentCardBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(element:CarEntity,position:Int) = with(binding){
            binding.model.text = element.model
            binding.submodel.text = element.subModel
            binding.year.text = element.year
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var item = ContentCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position),position)
    }

    private object DiffutilCallback:DiffUtil.ItemCallback<CarEntity>() {
        override fun areItemsTheSame(oldItem: CarEntity, newItem: CarEntity): Boolean {
            return  oldItem.model == newItem.model
        }

        override fun areContentsTheSame(oldItem: CarEntity, newItem: CarEntity): Boolean {
            return newItem == oldItem
        }

    }

}
