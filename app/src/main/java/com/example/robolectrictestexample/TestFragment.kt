package com.example.robolectrictestexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.robolectrictestexample.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private val viewModel = TestViewModel(TestRepository())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_test, container, false)

        binding.btnGetProducts.setOnClickListener {
            viewModel.getProducts()
        }
        observe()
        return binding.root
    }

    private fun observe() {
        viewModel.productLiveData.observe(viewLifecycleOwner){
            binding.rvProducts.visibility = View.VISIBLE
        }
    }

}