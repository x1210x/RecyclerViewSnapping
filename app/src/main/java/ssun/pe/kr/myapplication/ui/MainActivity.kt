package ssun.pe.kr.myapplication.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import android.view.Gravity
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import dagger.android.support.DaggerAppCompatActivity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import ssun.pe.kr.myapplication.R
import ssun.pe.kr.myapplication.databinding.ActivityMainBinding
import timber.log.Timber
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter1: MainAdapter
    private lateinit var adapter2: MainAdapter2
    private lateinit var adapter3: MainAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("[x1210x] onCreate()")

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        initViews()

        viewModel.items.observe(this, Observer {
            adapter1.submitList(it)
        })

        viewModel.installedApps.observe(this, Observer {
            adapter2.submitList(it)
            adapter3.submitList(it)
        })

        viewModel.getItems()
        viewModel.getInstalledApps()
    }

    override fun onDestroy() {
        super.onDestroy()

        Timber.d("[x1210x] onDestroy()")
    }

    private fun initViews() {
        setSupportActionBar(toolbar)

        // PagerSnapHelper
        adapter1 = MainAdapter()
        rv1.adapter = adapter1
        rv1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        PagerSnapHelper().attachToRecyclerView(rv1)
        indicator1.attachToRecyclerView(rv1)

        // LinearSnapHelper
        adapter2 = MainAdapter2()
        rv2.adapter = adapter2
        rv2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        LinearSnapHelper().attachToRecyclerView(rv2)

        // RecyclerViewSnap
        adapter3 = MainAdapter2()
        rv3.adapter = adapter3
        rv3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        GravitySnapHelper(Gravity.START).attachToRecyclerView(rv3)
    }
}
