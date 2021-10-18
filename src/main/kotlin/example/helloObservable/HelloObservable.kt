package example.helloObservable

import io.reactivex.rxjava3.core.Maybe
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

    private fun maybeObservable() {
        val maybe = Maybe.just("Hello Maybe")

        maybe.subscribe { it ->
            println(it)
        }

        maybe.subscribeBy(onSuccess = {
            println(it)
        })

        Maybe.create<String> { it.onComplete() }.subscribeBy(onSuccess = {
            println("Maybe Success!")
        }, onComplete = {
            println("Maybe Complete!")
        })
    }

    fun main() {
        println("SingleObservable")
        singleObservable()

        println("\n")

        println("MaybeObservable")
        maybeObservable()
    }
}