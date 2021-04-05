package com.eureka.katas

import com.eureka.katas.destination.Output
import com.eureka.katas.source.InputSource
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class SocialNetworkTest {

    @Mock
    private lateinit var output: Output
    @Mock
    private lateinit var inputSource: InputSource

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    @Disabled
    fun shouldDisplayUserPostsWhenPassedOnlyTheUsername() {

        SocialNetwork(inputSource, output)

        inputSource.receive("Alice -> My first post")
        inputSource.receive("Alice")

        verify(output).send("My first post")
    }
}