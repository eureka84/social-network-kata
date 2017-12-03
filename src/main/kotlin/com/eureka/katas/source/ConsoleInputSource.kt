package com.eureka.katas.source

class ConsoleInputSource: InputSource {

    private val subscribers: MutableList<Subscriber> = mutableListOf()

    override fun receive(message: String) {
        subscribers.forEach { s -> s.notify(message) }
    }

    override fun register(subscriber: Subscriber) {
        this.subscribers.add(subscriber)
    }

}