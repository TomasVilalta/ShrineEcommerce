package com.example.tryingout

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.tryingout.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //----Click listeners-------
        // Restore password button
        binding.forgotText.setOnClickListener {
            Toast.makeText(
                view.context,
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
                view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }

        // Sign Up button

        binding.registerText.setOnClickListener {
            Toast.makeText(
                view.context,
                "Sign up click",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 5
    }


}



