package com.c16.flywithme_admin.presentation.adapter.flights

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c16.flywithme_admin.R
import com.c16.flywithme_admin.data.model.flights.DataFlights
import com.c16.flywithme_admin.data.response.flights.FlightsResponse

class FlightsAdapter() : RecyclerView.Adapter<FlightsAdapter.ViewHolderFlights>() {

    var flightList = mutableListOf<DataFlights>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFlights {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_row_list_flight, parent, false)
            return ViewHolderFlights(inflater)

    }

    override fun onBindViewHolder(holder: ViewHolderFlights, position: Int) {
        holder.bind(flightList[position])
    }

    override fun getItemCount(): Int = flightList.size


    class ViewHolderFlights(val view: View) : RecyclerView.ViewHolder(view){
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
}