import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.Observables

fun main() {
    Observable.range(1, 5)
        .subscribe {
            println("Hello RxKotlin!")
        }
}