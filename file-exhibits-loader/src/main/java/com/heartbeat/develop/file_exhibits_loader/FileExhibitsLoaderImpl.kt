package com.heartbeat.develop.file_exhibits_loader

import android.content.Context
import com.google.gson.Gson
import com.heartbeat.develop.model.Exhibit
import com.heartbeat.develop.model.ExhibitResponse
import com.heartbeat.develop.model.loader.ExhibitsLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class FileExhibitsLoaderImpl @Inject constructor(var context: Context) : ExhibitsLoader {

    override suspend fun getExhibitList(): List<Exhibit> = withContext(Dispatchers.IO) {
        var exhibits = listOf<Exhibit>()
        try {
            val jsonString = context.assets.open("exhibits.json")
                .bufferedReader()
                .use { it.readText() }
            val exhibitsResponse = Gson().fromJson(jsonString, ExhibitResponse::class.java)
            exhibits = exhibitsResponse.list
        } catch (ioException: IOException) {
            ioException.printStackTrace()
        }
        exhibits
    }
}