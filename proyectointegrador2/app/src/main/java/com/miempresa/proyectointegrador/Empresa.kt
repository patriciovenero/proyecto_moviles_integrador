package com.miempresa.proyectointegrador

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
class Empresa : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empresa)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_ayuda -> {
                    val intent = Intent(this, Ayuda::class.java)
                    startActivity(intent)
                }
                R.id.nav_team -> {
                    val intent = Intent(this, teammanager::class.java)
                    startActivity(intent)
                }
                R.id.nav_empresa -> {
                    val intent = Intent(this, Empresa::class.java)
                    startActivity(intent)
                }
                R.id.nav_estacionamiento -> {
                    val intent = Intent(this, Estacionamiento::class.java)
                    startActivity(intent)
                }
                R.id.nav_estado -> {
                    val intent = Intent(this, Estado::class.java)
                    startActivity(intent)
                }
                R.id.nav_miperfil -> {
                    val intent = Intent(this, miperfil::class.java)
                    startActivity(intent)
                }
                R.id.nav_ayuda -> {
                    val intent = Intent(this, Ayuda::class.java)
                    startActivity(intent)
                }
                R.id.nav_team -> {
                    val intent = Intent(this, teammanager::class.java)
                    startActivity(intent)
                }
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}