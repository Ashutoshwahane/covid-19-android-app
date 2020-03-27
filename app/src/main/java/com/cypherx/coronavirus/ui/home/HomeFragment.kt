package com.cypherx.coronavirus.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cypherx.coronavirus.R
import com.cypherx.coronavirus.model.WorldStat
import com.cypherx.coronavirus.retrofit.APIServices
import com.cypherx.coronavirus.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    var apiServices : APIServices? = null

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val confirmtextView : TextView = root.findViewById(R.id.confirmedTextView)
        val confirmnumbertextView : TextView = root.findViewById(R.id.confirmedNumberTextView)
        val deathstextView : TextView = root.findViewById(R.id.deathsTextView)
        val deathsnumbertextView : TextView = root.findViewById(R.id.deathsnumberTextView)
        val recoveredtextView : TextView = root.findViewById(R.id.recoverednumberTextView)

        apiServices = ApiUtils.getApiService()

        apiServices!!.getWorldStat().enqueue(object :Callback<WorldStat>{
            override fun onFailure(call: Call<WorldStat>, t: Throwable) {
                Log.d("rapid","getWorldStat FAILED")
            }

            override fun onResponse(call: Call<WorldStat>, response: Response<WorldStat>) {
                Log.d("rapid","GetWorldStat Response : "+response.body()!!.total_cases)
                if (response.body() != null) {
                    val confirmed = response.body()!!.total_cases.toString()
                    val deaths = response.body()!!.total_deaths.toString()
                    val recovered = response.body()!!.total_recovered.toString()
                    Log.d("debug", "confirmed : $confirmed")
                    confirmnumbertextView.setText(confirmed)
                    deathsnumbertextView.setText(deaths)
                    recoveredtextView.setText(recovered)
                }
            }

        })
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }




}
