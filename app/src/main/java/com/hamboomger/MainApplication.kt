package com.hamboomger

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

/**
 * @author ddorochov
 */
@SpringBootApplication
class MainApplication

fun main(args: Array<String>) {
    SpringApplication.run(MainApplication::class.java)
}