package com.c16.flywithme_admin.presentation.adapter.flights

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c16.flywithme_admin.R
import com.c16.flywithme_admin.data.model.flights.DataFlights

class FlightsAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<FlightsAdapter.ViewHolderFlights>() {

    var flightList = mutableListOf<DataFlights>()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFlights {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_row_list_flight, parent, false)
            return ViewHolderFlights(inflater)

    }

    override fun getItemCount(): Int = flightList.size

    override fun onBindViewHolder(holder: ViewHolderFlights, position: Int) {
        holder.bind(flightList[position])
        holder.itemView.setOnClickListener {
            clickListener.onItemDetailCLick(flightList[position])
        }
    }

    class ViewHolderFlights( view: View) : RecyclerView.ViewHolder(view){
        val tvDepatureDate = view.findViewById<TextView>(R.id.tv_depature_date)
        val tvDepatureTime = view.findViewById<TextView>(R.id.tv_depature_time)
        val tvPrice = view.findViewById<TextView>(R.id.tv_price)
        val tvFlightNumber = view.findViewById<TextView>(R.id.tv_flightNumber)
        val tvTypeFlight = view.findViewById<TextView>(R.id.tv_typeFlight)
        val tvFrom = view.findViewById<TextView>(R.id.tv_from)
        val tvTo = view.findViewById<TextView>(R.id.tv_to)

        fun bind(flight: DataFlights){
            tvDepatureDate.text = flight.depatureDate
            tvDepatureTime.text = flight.depatureTime
            tvPrice.text = flight.classPrice.toString()
            tvFlightNumber.text = flight.flightNumber
            tvTypeFlight.text = flight.typeOfFlight
            tvFrom.text = flight.from
            tvTo.text = flight.to
        }
    }

    interface OnItemClickListener {
        fun onItemDetailCLick(flight : DataFlights)
    }
}