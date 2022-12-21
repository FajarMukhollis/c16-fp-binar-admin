package com.c16.flywithme_admin.presentation.adapter.customer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c16.flywithme_admin.R
import com.c16.flywithme_admin.data.model.list_user.User

class ListCustomerAdapter : RecyclerView.Adapter<ListCustomerAdapter.ViewHolderCustomer>(){

    var listCustomer = mutableListOf<User>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ViewHolderCustomer {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_list_customer, parent, false)
        return ViewHolderCustomer(inflater)
    }


    override fun getItemCount(): Int {
        return listCustomer.size
    }


    override fun onBindViewHolder(holder: ViewHolderCustomer, position: Int) {
        holder.bind(listCustomer[position])
    }

    class ViewHolderCustomer(view: View) : RecyclerView.ViewHolder(view) {
        val textViewIdUser = view.findViewById<TextView>(R.id.tv_idUser)!!
        val textViewFirtName = view.findViewById<TextView>(R.id.tv_firstName)
        val textViewLastName = view.findViewById<TextView>(R.id.tv_lastName)

        fun bind(data: User) {
            textViewIdUser.text = data.id
            textViewFirtName.text = data.firstName
            textViewLastName.text = data.lastName
        }
    }


}