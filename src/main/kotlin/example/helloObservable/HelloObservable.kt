package example.helloObservable

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable

class HelloObservable {
    private fun singleObservable() {
        val single = Single.just("Hello Single!")

        single.subscribe { it ->
            println(it)
        }

        single.subscribeBy(onSuccess = {
            println(it)
        })
    }

    fun main() {
        singleObservable()
    }
}