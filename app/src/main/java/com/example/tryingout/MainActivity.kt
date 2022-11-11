package com.example.tryingout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.TextureView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.commit
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.example.tryingout.databinding.ActivityMainBinding
import com.example.tryingout.fragments.HomeFragment
import com.example.tryingout.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawerLayout = binding.drawerLayout


        setSupportActionBar(binding.appBar)
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.cartFragment),drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navController)
        NavigationUI.setupWithNavController(binding.appBar,navController,appBarConfiguration)



//       Drawer Header listener
        val text = binding.navView.getHeaderView(0).findViewById<TextView>(R.id.notLoggedText)
        text.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.navHostFragment, LoginFragment())
                binding.drawerLayout.close()
            }


        }
        val seasonButton =
            binding.navView.getHeaderView(0).findViewById<LinearLayout>(R.id.seasonButton)
        seasonButton.setOnClickListener {
            Toast.makeText(it.context, "It's fall!", Toast.LENGTH_SHORT).show()
            binding.drawerLayout.close()
        }

    }


    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }


//     Apparently this is only necessary for the default navbar , oops
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.navHostFragment)
//        return NavigationUI.navigateUp(navController, drawerLayout,)
//    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        return if (toggle.onOptionsItemSelected(item)) {
            item.onNavDestinationSelected(navController)

        } else
            super.onOptionsItemSelected(item)
    }


    //      Menu item navigation listeners
//        binding.navView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeItem -> {
//                    supportFragmentManager.commit {
//                        replace(R.id.navHostFragment, HomeFragment())
//                    }
//                }
//                R.id.featuredItem -> {
//                    Toast.makeText(this, "featuredItem", Toast.LENGTH_SHORT).show()
//                }
//                R.id.outletItem -> {
//                    Toast.makeText(this, "outletItem", Toast.LENGTH_SHORT).show()
//                }
//                R.id.cartItem -> {
//                    Toast.makeText(this,"cartItem!", Toast.LENGTH_SHORT).show()
//                }
//                R.id.giftCardItem -> {
//                    Toast.makeText(this,"giftCardItem", Toast.LENGTH_SHORT).show()
//                }
//                R.id.memberItem -> {
//                    Toast.makeText(this,"memberItem", Toast.LENGTH_SHORT).show()
//                }
//                R.id.newsletterItem -> {
//                    Toast.makeText(this,"newsletterItem", Toast.LENGTH_SHORT).show()
//                }
//                R.id.helpItem -> {
//                    Toast.makeText(this,"helpItem", Toast.LENGTH_SHORT).show()
//                }
//                R.id.contactItem -> {
//                    Toast.makeText(this,"contactItem", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//            binding.drawerLayout.close()
//            true
//        }




//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        return if (toggle.onOptionsItemSelected(item)) {
//            item.onNavDestinationSelected(navController)
//
//        } else
//            super.onOptionsItemSelected(item)
//    }


//        setSupportActionBar(binding.appBar)
//        supportFragmentManager.commit {
//            replace(R.id.navHostFragment, HomeFragment())
//        }

}


