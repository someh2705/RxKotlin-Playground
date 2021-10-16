package example.HelloRxKotlin

import io.reactivex.rxjava3.core.Observable

class HelloRxKotlin {
    fun main() {
        Observable.just(1)
            .subscribe {
                println("Hello RxKotlin!")
            }
    }
}