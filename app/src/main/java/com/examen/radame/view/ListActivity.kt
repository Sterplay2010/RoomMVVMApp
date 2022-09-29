package com.examen.radame.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.examen.radame.StartApplication.Companion.room
import com.examen.radame.databinding.ActivityListBinding
import com.examen.radame.room.CarEntity
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity(), AdapterCar.Eventos {
    private lateinit var binding:ActivityListBinding
    var list = listOf(CarEntity(null,"Tsuru","Tsuru","2000"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            setData(room.getCarDAO().getAllData())
        }
    }
    var adapter:AdapterCar?=null

    fun setData(list: List<CarEntity>){
        binding.recyclerData.layoutManager = LinearLayoutManager(this)
        adapter = AdapterCar(this,this)
        binding.recyclerData.adapter = adapter
        adapter!!.submitList(list)
    }

    override fun onIntemClick(element: CarEntity, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onStatusChange(element: CarEntity, position: Int, status: Boolean) {
        TODO("Not yet implemented")
    }


}