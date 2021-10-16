package example.HelloObserver

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class HelloObserver {
    fun main() {
        Observable.just("Hello World", "Hello RxKotlin", "Hello Observable!")
            .subscribe(object: Observer<String>{
                override fun onSubscribe(d: Disposable?) {
                    println("구독 시작!")
                }
                override fun onNext(it: String?) {
                    println(it)
                }
                override fun onComplete() {
                    println("데이터 발행 완료!")
                }
                override fun onError(e: Throwable?) {
                    println(e)
                }
            })
    }
}