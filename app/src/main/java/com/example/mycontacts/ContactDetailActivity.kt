package com.example.mycontacts

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.mycontacts.databinding.ActivityContactDetailBinding
import kotlinx.android.synthetic.main.activity_contact_detail.*

class ContactDetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityContactDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil.setContentView(this,R.layout.activity_contact_detail)

        DetailName.text = getIntent().getStringExtra("CONTACTNAME")
        DetailPhone.text = getIntent().getStringExtra("CONTACTPHONE")
        getIntent().getStringExtra("CONTACTIMAGE")?.toInt()?.let { DetailImage.setImageResource(it) }
    }
}