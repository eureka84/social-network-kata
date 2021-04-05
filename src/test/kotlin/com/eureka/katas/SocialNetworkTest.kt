package com.eureka.katas

import com.eureka.katas.destination.Output
import com.eureka.katas.source.InputSource
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class SocialNetworkTest {

    @Mock
    private lateinit var output: Output
    @Mock
    private lateinit var inputSource: InputSource

    @Test
    @Disabled
    fun shouldDisplayUserPostsWhenPassedOnlyTheUsername() {

        SocialNetwork(inputSource, output)

        inputSource.receive("Alice -> My first post")
        inputSource.receive("Alice")

        verify(output).send("My first post")
    }
}