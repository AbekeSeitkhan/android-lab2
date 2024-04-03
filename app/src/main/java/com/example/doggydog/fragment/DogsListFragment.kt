package com.example.doggydog.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doggydog.adapter.DogsListAdapter
import com.example.doggydog.databinding.FragmentDogsListBinding
import com.example.doggydog.model.entity.DogItem
import com.example.doggydog.model.network.ApiClient
import retrofit2.Call
import retrofit2.Response


class DogsListFragment : Fragment() {

    var dogs:List<DogItem> = emptyList()

    companion object{
        fun newInstance() = DogsListFragment()
    }

    private var _binding:FragmentDogsListBinding? = null

    private val binding
        get() = _binding!!

    private val adapter: DogsListAdapter by lazy{
        DogsListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogsListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dogsList.adapter = adapter
        binding.searchButton.setOnClickListener{
            searchByName(binding.editText.text.toString())
        }

    }

    private fun searchByName(name: String){
        ApiClient.apiService.getDogsByName(name).enqueue(object : retrofit2.Callback<List<DogItem>> {
            override fun onResponse(call: Call<List<DogItem>>, response: Response<List<DogItem>>) {
                if (response.isSuccessful) {
                    dogs = response.body() ?: emptyList()
                    adapter.submitList(dogs)

                } else {
                }
            }

            override fun onFailure(call: Call<List<DogItem>>, t: Throwable) {
            }
        })
    }

}