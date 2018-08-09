package com.marlonmoorer.timeline.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marlonmoorer.timeline.App
import com.marlonmoorer.timeline.R
import com.marlonmoorer.timeline.api.WmataService
import com.marlonmoorer.timeline.commit
import com.marlonmoorer.timeline.observe
import com.marlonmoorer.timeline.ui.fragments.RailLinesFragment
import io.reactivex.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers


import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var  service:WmataService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.component.inject(this)
        supportFragmentManager.commit {
            add(R.id.container,RailLinesFragment())
        }
        service.getRailLines()
                .subscribeOn(Schedulers.newThread())
                .subscribe{ results->
                    print("")
                }
    }
}
