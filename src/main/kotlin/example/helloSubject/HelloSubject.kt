package example.helloSubject

class HelloSubject {
    fun publishSubject() {
        val observable = Observable.interval(100, TimeUnit.MILLISECONDS) 
        val subject = PublishSubject.create<Long>() 
        
        observable.subscribe(subject) 
        
        runBlocking { delay(300) } 
        
        subject.subscribe { println("1st: $it") } 
        
        runBlocking { delay(300) } 
        
        subject.subscribe { println("2nd: $it") } 
        
        runBlocking { delay(300) }
    }

    fun main() {
        println("# PublishSubject")
        publishSubject()

        println("\n")
    }
}