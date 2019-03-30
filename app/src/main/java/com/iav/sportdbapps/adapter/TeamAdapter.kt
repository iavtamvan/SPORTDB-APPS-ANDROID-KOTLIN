package com.iav.sportdbapps.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.iav.sportdbapps.DetailActivity
import com.iav.sportdbapps.R
import com.iav.sportdbapps.model.ItemsSport
import com.iav.sportdbapps.model.TeamsItem
import kotlinx.android.synthetic.main.item_sport.view.*

class TeamAdapter : RecyclerView.Adapter<TeamAdapter.ViewHolder> {
    private lateinit var context: Context
    private var items: ArrayList<TeamsItem>? = null

    constructor(context: Context?, items: ArrayList<TeamsItem>) : this() {
        this.context = context!!
        this.items = items
    }
    constructor()

    class ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val imgTeam = view.img_team
        val tvNamaTeam = view.tv_name_team
        val tvNamaTeamLegaue = view.tv_name_leagaue
        val divContainer = view.divContainer
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TeamAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context)
            .inflate(R.layout.item_sport, p0, false))
    }

    override fun getItemCount(): Int {
        return items?.size as Int
    }

    override fun onBindViewHolder(p0: TeamAdapter.ViewHolder, p1: Int) {
        Glide.with(context)
            .load(items?.get(p1)?.strTeamBadge)
            .override(512,512)
            .error(android.R.drawable.ic_dialog_alert)
            .into(p0.imgTeam)
        p0.tvNamaTeam.text = items?.get(p1)?.strTeam
        p0.tvNamaTeamLegaue.text = items?.get(p1)?.strLeague
        p0.divContainer.setOnClickListener {
            Toast.makeText(context, "Ini Toast", Toast.LENGTH_LONG).show()

            val intent:Intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("IMAGE", items?.get(p1)?.strTeamBadge)
            intent.putExtra("NAMA_TEAM", items?.get(p1)?.strTeam)
            intent.putExtra("DESKRIPTION_STADIUM", items?.get(p1)?.strStadiumDescription)
            intent.putExtra("NAMA_STADIUM", items?.get(p1)?.strStadium)
            context.startActivity(intent)


        }

    }


}