package com.eureka.katas

import com.eureka.katas.destination.Output
import com.eureka.katas.source.InputSource
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * @author asciarra
 */
class SocialNetworkTest {

    @Mock
    private lateinit var output: Output
    @Mock
    private lateinit var inputSource: InputSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test@Ignore
    fun shouldDisplayUserPostsWhenPassedOnlyTheUsername() {

        SocialNetwork(inputSource, output)

        inputSource.receive("Alice -> My first post")
        inputSource.receive("Alice")

        verify(output).send("My first post")
    }
}