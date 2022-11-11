package com.example.tryingout.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tryingout.ItemProductDecoration
import com.example.tryingout.ProductProvider
import com.example.tryingout.R
import com.example.tryingout.adapter.ProductAdapter
import com.example.tryingout.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Toolbar Setup
//        (activity as AppCompatActivity).setSupportActionBar(binding.appBar)
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_search -> {
                        Toast.makeText(activity, "hola", Toast.LENGTH_SHORT).show()
                        view?.findNavController()?.navigate(R.id.action_loginFragment_to_homeFragment)

                    }
                }
                return true
            }
        }, viewLifecycleOwner)

        //RecyclerView setup
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = GridLayoutManager(this.context, 2)
        recyclerView.adapter = ProductAdapter(ProductProvider.ProductList)
        recyclerView.addItemDecoration(ItemProductDecoration(16, 4))

    }

}