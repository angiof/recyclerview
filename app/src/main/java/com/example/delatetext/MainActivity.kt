package com.example.delatetext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    val adapter: AdapterClass = AdapterClass()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPersonas()
        settingRecycler()
        registerForContextMenu(mRecyclerView)
    }

    fun settingRecycler() {
        mRecyclerView = findViewById(R.id.recyclerview) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter.constructor(getPersonas(), this)
        mRecyclerView.adapter = adapter
    }

    fun getPersonas(): MutableList<Modello> { //crea array
        var indixepersonas: MutableList<Modello> = ArrayList()
        indixepersonas.add(Modello("angelo", "ferretti"))
        indixepersonas.add(Modello("angio", "ferretti"))
        indixepersonas.add(Modello("ademaro", "ferretti"))
        return indixepersonas
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        var m = menuInflater.inflate(R.menu.menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when ( item.itemId) {
            R.id.remover -> {
            adapter.remove(position = item.itemId)
            }
        }
        return super.onContextItemSelected(item)
    }

}

