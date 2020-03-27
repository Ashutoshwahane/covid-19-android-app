package com.cypherx.coronavirus.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cypherx.coronavirus.R
import com.cypherx.coronavirus.model.IndiaState
import com.cypherx.coronavirus.model.IndiaStateResult
import com.cypherx.coronavirus.retrofit.APIServices
import com.cypherx.coronavirus.retrofit.ApiUtils
import kotlinx.android.synthetic.main.fragment_dashboard.*
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    var apiServices : APIServices? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // api services Instance
        var apiServices = ApiUtils.getApiService()

        apiServices.getStateStat().enqueue(object : Callback<IndiaState>{
            override fun onFailure(call: Call<IndiaState>, t: Throwable) {
                Log.d("state","FAILED!@#!@#!@#!@#")
            }

            override fun onResponse(call: Call<IndiaState>, response: Response<IndiaState>) {
                Log.d("state","response : "+response.body().toString())
                var india = response.body()!!.countries_stat
                list_recycler_view.apply {
                    // set a LinearLayoutManager to handle Android
                    // RecyclerView behavior
                    layoutManager = LinearLayoutManager(activity)
                    // set the custom adapter to the RecyclerView
                    adapter = ListAdapter(india)
                }

            }

        })



        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        fun newInstance(): DashboardFragment = DashboardFragment()
    }
}
