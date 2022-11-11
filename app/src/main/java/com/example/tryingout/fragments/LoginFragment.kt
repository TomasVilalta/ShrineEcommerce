package com.example.tryingout.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.tryingout.R
import com.example.tryingout.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        //----Click listeners-------
        // Restore password button
        binding.forgotText.setOnClickListener {
            Toast.makeText(
                this.context,
                "Oh that's not good",
                Toast.LENGTH_SHORT
            ).show()
        }
        // Login button
        binding.loginButton.setOnClickListener {
            if (!isPasswordValid(binding.passwordEditText.text!!)) {
                binding.passwordEditText.error = getString(R.string.password_err)
            } else {
                // Clear the error.
                binding.passwordEditText.error = null


            }
        }

        // Sign Up button

        binding.registerText.setOnClickListener {
            Toast.makeText(
                this.context,
                "Sign up click",
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 5
    }


}



