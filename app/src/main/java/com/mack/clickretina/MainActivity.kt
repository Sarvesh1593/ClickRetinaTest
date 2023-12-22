package com.mack.clickretina


import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.mack.clickretina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedNavItem: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateIndicatorPosition(binding.navHome)
        binding.homeTxt.setTextColor(ContextCompat.getColor(this, R.color.black))
        binding.homeImage.setColorFilter(
            ContextCompat.getColor(this, R.color.black),
            PorterDuff.Mode.SRC_IN
        )
        binding.navHome.setOnClickListener {
            updateIndicatorPosition(binding.navHome)
            binding.homeTxt.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.homeImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black),
                PorterDuff.Mode.SRC_IN
            )

            binding.profileTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.pointsTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.ordersTxt.setTextColor(ContextCompat.getColor(this, R.color.white))


            binding.profileImage.colorFilter = null
            binding.pointsImage.colorFilter = null
            binding.ordersImage.colorFilter = null
        }

        binding.navPoints.setOnClickListener {
            updateIndicatorPosition(binding.navPoints)
            binding.pointsTxt.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.pointsImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black),
                PorterDuff.Mode.SRC_IN
            )

            binding.homeTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.profileTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.ordersTxt.setTextColor(ContextCompat.getColor(this, R.color.white))


            binding.homeImage.colorFilter = null
            binding.profileImage.colorFilter = null
            binding.ordersImage.colorFilter = null
        }

        binding.navOrders.setOnClickListener {
            updateIndicatorPosition(binding.navOrders)
            binding.ordersTxt.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.ordersImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black),
                PorterDuff.Mode.SRC_IN
            )

            binding.homeTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.pointsTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.profileTxt.setTextColor(ContextCompat.getColor(this, R.color.white))

            binding.homeImage.colorFilter = null
            binding.pointsImage.colorFilter = null
            binding.profileImage.colorFilter = null

        }

        binding.navProfile.setOnClickListener {
            updateIndicatorPosition(binding.navProfile)
            binding.profileTxt.setTextColor(ContextCompat.getColor(this, R.color.black))
            binding.profileImage.setColorFilter(
                ContextCompat.getColor(this, R.color.black),
                PorterDuff.Mode.SRC_IN
            )

            binding.homeTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.pointsTxt.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.ordersTxt.setTextColor(ContextCompat.getColor(this, R.color.white))

            binding.homeImage.colorFilter = null
            binding.pointsImage.colorFilter = null
            binding.ordersImage.colorFilter = null
        }
    }

    private fun updateIndicatorPosition(selectedItem: View) {

        // Set the background of the clicked item to the indicator
        selectedItem.setBackgroundResource(R.drawable.indicator)

        // Update the selectedNavItem
        selectedNavItem = selectedItem

        // Move the indicator to the selected item without animation
        val newX = selectedItem.left.toFloat()
        binding.indicatorView.translationX = newX

        val navigationItems = listOf(
            binding.navHome,
            binding.navPoints,
            binding.navOrders,
            binding.navProfile
        )
        for (item in navigationItems) {
            if (item != selectedItem) {
                item.background = null
            }
        }
    }
}