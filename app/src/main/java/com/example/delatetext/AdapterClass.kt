package com.example.delatetext

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterClass:RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    var indixepersonas:MutableList<Modello> = ArrayList()
    lateinit var context:Context

  fun   constructor(person: MutableList<Modello>, context: Context)  {
        this.indixepersonas = person
        this.context = context
    }
   fun remove(position: Int){
       indixepersonas.removeAt(position.toInt())
       notifyDataSetChanged()
   }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { //gonfia
        val layoutInflater=LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.items, parent, false))
    }

    override fun getItemCount(): Int {
        return indixepersonas.size
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=indixepersonas.get(position)
        holder.bind(item,context)


    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){

        val nonbre=view.findViewById(R.id.nonbre)as TextView
        val apellido=view.findViewById(R.id.apellido) as TextView
        var clikc=view.apply {

            setOnLongClickListener {
                showContextMenu()

            }

        }
        fun bind(modelar:Modello ,context:Context){
            nonbre.text=modelar.nome
            apellido.text=modelar.cogonome
        }
    }
}

