package com.c16.flywithme_admin.presentation.adapter.customer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c16.flywithme_admin.R
import com.c16.flywithme_admin.data.model.list_user.User
import com.c16.flywithme_admin.data.response.CustomerResponse

class ListCustomerAdapter(val results : ArrayList<CustomerResponse.User>)
    : RecyclerView.Adapter<ListCustomerAdapter.ViewHolderCustomer>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCustomer {
        LayoutInflater.from(parent.context).inflate(R.layout.item_row_list_customer, parent, false).apply {
            return ViewHolderCustomer(this)
        }
    }

    override fun onBindViewHolder(holder: ViewHolderCustomer, position: Int) {
        val result = results[position]
        holder.view.findViewById<TextView>(R.id.tv_idUser).text = result.id
        holder.view.findViewById<TextView>(R.id.tv_firstName).text = result.firstName
        holder.view.findViewById<TextView>(R.id.tv_lastName).text = result.lastName
    }

    override fun getItemCount(): Int = results.size

    class ViewHolderCustomer(val view: View): RecyclerView.ViewHolder(view)

    fun setData(data: List<CustomerResponse.User>) {
        results.clear()
        results.addAll(data)
        notifyDataSetChanged()
    }


}