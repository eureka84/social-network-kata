package com.eureka.katas.source

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ConsoleInputSourceTest {

    @Mock
    private lateinit var firstSubscriber: Subscriber
    @Mock
    private lateinit var secondSubscriber: Subscriber

    private lateinit var inputSource: InputSource

    @BeforeEach
    fun setUp() {
        inputSource = ConsoleInputSource()
    }

    @Test
    fun shouldNotifyASubscriberWhenReceivingAMessage() {
        inputSource.register(firstSubscriber)

        inputSource.receive("A MSG")

        verify(firstSubscriber).notify("A MSG")
    }

    @Test
    fun shouldNotifyAllSubscribersWhenReceivingAMessage() {
        inputSource.register(firstSubscriber)
        inputSource.register(secondSubscriber)

        inputSource.receive("A MSG")

        verify(firstSubscriber).notify("A MSG")
        verify(secondSubscriber).notify("A MSG")
    }

}

