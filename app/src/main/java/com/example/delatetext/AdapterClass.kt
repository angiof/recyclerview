package com.example.delatetext

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class AdapterClass:RecyclerView.Adapter<AdapterClass.ViewHolder>() {


    var indixepersonas:MutableList<Modello> = ArrayList()
    lateinit var context:Context

  fun   constructor(person: MutableList<Modello>, context: Context)  {
        this.indixepersonas = person
        this.context = context
    }
    fun remove(position: Int){
        val newList = ArrayList(indixepersonas).also { it.removeAt(position) }
        indixepersonas = newList
        notifyItemRemoved(position)
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



    inner class ViewHolder(view: View,removebtn:View=view.findViewById(R.id.button),addbtn:View=view.findViewById(R.id.button2),preview:View=view.findViewById(R.id.btnv0)):RecyclerView.ViewHolder(view){


        init {
            preview.setOnClickListener(previ())
            addbtn.setOnClickListener(add())
            removebtn.setOnClickListener(removebtn())
        }
        fun removebtn():(View)->Unit={
            layoutPosition.also {currentPosition->
                indixepersonas.removeAt(currentPosition)
                notifyDataSetChanged()

            }
        }
        fun previ():(View)->Unit={
            layoutPosition.also { currentPosition->
                 var pp=indixepersonas[currentPosition]
                var move = Intent(context, Selected::class.java).apply {
                    this.putExtra("id", pp)

                }
                startActivity(move)
            }

        }



        fun add(): (View) -> Unit = {
            layoutPosition.also { currentPosition ->
                indixepersonas.add(currentPosition, Modello("angelo","hhh"))
                notifyItemInserted(currentPosition)
            }
        }
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

