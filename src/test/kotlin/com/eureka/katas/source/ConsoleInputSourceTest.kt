package com.eureka.katas.source

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * @author asciarra
 */
class ConsoleInputSourceTest {

    @Mock
    private lateinit var firstSubscriber: Subscriber
    @Mock
    private lateinit var secondSubscriber: Subscriber

    private lateinit var inputSource: InputSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
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

