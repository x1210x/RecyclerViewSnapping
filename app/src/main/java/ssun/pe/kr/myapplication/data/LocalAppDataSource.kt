package ssun.pe.kr.myapplication.data

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import ssun.pe.kr.myapplication.R
import ssun.pe.kr.myapplication.data.model.Item
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalAppDataSource @Inject constructor(
        private val context: Context,
        private val pm: PackageManager
) : AppDataSource {

    override fun getItems(): Deferred<List<Item>> = async {
        listOf(
                R.color.red,
                R.color.pink,
                R.color.purple,
                R.color.deep_purple,
                R.color.indigo,
                R.color.blue,
                R.color.light_blue,
                R.color.cyan,
                R.color.teal,
                R.color.green,
                R.color.light_green,
                R.color.lime,
                R.color.yellow,
                R.color.amber,
                R.color.orange,
                R.color.deep_orange,
                R.color.brown,
                R.color.red,
                R.color.pink,
                R.color.purple,
                R.color.deep_purple,
                R.color.indigo,
                R.color.blue,
                R.color.light_blue,
                R.color.cyan,
                R.color.teal,
                R.color.green,
                R.color.light_green,
                R.color.lime,
                R.color.yellow,
                R.color.amber,
                R.color.orange,
                R.color.deep_orange,
                R.color.brown,
                R.color.red,
                R.color.pink,
                R.color.purple,
                R.color.deep_purple,
                R.color.indigo,
                R.color.blue,
                R.color.light_blue,
                R.color.cyan,
                R.color.teal,
                R.color.green,
                R.color.light_green,
                R.color.lime,
                R.color.yellow,
                R.color.amber,
                R.color.orange,
                R.color.deep_orange,
                R.color.brown,
                R.color.red,
                R.color.pink,
                R.color.purple,
                R.color.deep_purple,
                R.color.indigo,
                R.color.blue,
                R.color.light_blue,
                R.color.cyan,
                R.color.teal,
                R.color.green,
                R.color.light_green,
                R.color.lime,
                R.color.yellow,
                R.color.amber,
                R.color.orange,
                R.color.deep_orange,
                R.color.brown
        ).map { Item(ContextCompat.getColor(context, it)) }
    }

    override fun getInstalledApps(): Deferred<List<ApplicationInfo>> = async {
        pm.getInstalledApplications(PackageManager.GET_META_DATA)
    }
}