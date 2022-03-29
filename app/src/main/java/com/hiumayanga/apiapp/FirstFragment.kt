package com.hiumayanga.apiapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hiumayanga.apiapp.api.RetrofitAPI
import com.hiumayanga.apiapp.api.User
import com.hiumayanga.apiapp.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val retrofitAPI=RetrofitAPI.create();

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
       val user1Call= retrofitAPI.getUser1()

            user1Call.enqueue(object : Callback<User> {

                override fun onResponse(call: Call<User>?, response: Response<User>?) {
                    if(response?.body() !=null){
                        val body =response.body();
                        body?.let{ it1 -> Log.i("FirstFragment: Email",it1?.email)
                    }

                }

                override fun onFailure(call: Call<User>?, t: Throwable?) {
                }
            })
            }

//       val body=user1Call.execute().body()
 //           if (body != null) {
 //               Log.i("FirstFragment: Email",body.email)
 //           }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
    }