package example.helloObservable

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import java.util.concurrent.TimeUnit

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

    private fun singleFromObservable() {
        val source = Observable.just("Hello Single")
        Single.fromObservable(source).subscribe { it ->
            println(it)
        }
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

    private fun completableObservable() {
        val completable = Completable.create { it.onComplete() }

        completable.subscribe(object : CompletableObserver {
            override fun onSubscribe(d: Disposable?) {
                println("CompletableObservable Subscribe!")
            }

            override fun onComplete() {
                println("CompletableObservable Complete!")
            }

            override fun onError(e: Throwable?) {
                println("CompletableObservable Error!")
            }
        })
    }

    private fun create() {
        val source = Observable.create<Int> {
            for (i in 1..5) {
                it.onNext(i)
            }
            it.onComplete()
        }

        source.subscribeBy(onNext = {
            println(it)
        }, onComplete = {
            println("Completed!")
        })
    }

    private fun defer() {
        val source = Observable.defer {
            println("Create an Observable")
            Observable.just("Hello defer")
        }

        source.subscribeBy(onNext = {
            println("Next: $it")
        }, onComplete = {
            println("Completed")
        })
    }

    fun main() {
        println("# SingleObservable")
        singleObservable()

        println("\n")

        println("# MaybeObservable")
        maybeObservable()

        println("\n")

        println("# CompletableObservable")
        completableObservable()

        println("\n")

        println("# Observable.create()")
        create()

        println("\n")

        println("# Observable.defer")
        defer()

        println("\n")

        println("# Single from Observable")
        singleFromObservable()
    }
}