package com.eureka.katas.source

interface InputSource {
    fun receive(message: String)
    fun register(subscriber: Subscriber)
}